import java.util.*;

/**
 * A class to represent a CPU Player
 *
 * @author Pablo Crisostomo Suarez
 * @version 2022
 */
public class CPUPlayer extends APlayer
{
    // instance variables - replace the example below with your own

    /**
     * Constructor for objects of class CPUPlayer
     */
    public CPUPlayer(ArrayList<Pokemon>t)
    {
        super(t);
    }

    /**
     * Based on random number generator, either returns one of the active Pokemon's valid moves
     * or switches out into another Pokemon.
     *
     * @return    a Move object representing the CPU's selection
     */
    public Move pickMove(){
        boolean validMove = false;
        SplittableRandom random = new SplittableRandom();
        Pokemon a = super.getTeam().get(0);
        while(!validMove){
            double select = random.nextDouble(0,4.1);
            if(select <= 4 && a.getMoves()[(int)select].getActive() || (select > 4 && !validSwitch())){
                a.getMoves()[(int)select].useMove();
                return a.getMoves()[(int)select];
            }else{
                switchPokemon(false);
                return new Move();
            }
            
        }
        return null;
    }
    
    /**
     * Returns whether there is a valid Pokemon to switch into.
     * Method returns true if there is any Pokemon which is active and not
     * at index 0, false otherwise.
     * @return a boolean representing whether there is a valid Pokemon to switch into
     */
    public boolean validSwitch(){
        for(Pokemon p : super.getTeam()){
            if(p.getStatus() && !p.getName().equals(super.getTeam().get(0).getName()))
                return true;
            
        }
        return false;
    }
    
    /**
     * Randomly selects an index of the ArrayList team with an active Pokemon, and 
     * the selected Pokemon is moved to the 0 index of the team ArrayList.
     * If at the start of the game, all Pokemon can be selected.
     * Otherwise, the first Pokemon can't be chosen as when switching out mid-game, 
     * you can't switch out into the same Pokemon that is currently active.
     * @param start a boolean representing whether it is the start of the game or not
     */
    public void switchPokemon(boolean start){
        SplittableRandom random = new SplittableRandom();
        boolean validChoice = false;
        int select = -1;
        while(!validChoice){
            if(start) select = random.nextInt(0,6);
            else select = random.nextInt(1,6);
            
            if(super.getTeam().get(select).getStatus()) validChoice = true;
        
            
        }
        Pokemon switched = super.getTeam().get(select);
        super.getTeam().remove(switched);
        super.getTeam().add(0, switched);
        
        System.out.println("CPU switched into " + switched.getName() + "!\n");
    }
}
