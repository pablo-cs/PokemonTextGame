import java.util.*;
import java.io.*;

/**
 * A class to represent a Human Player
 *
 * @author Pablo Crisostomo Suarez
 * @version 2022
 */
public class HumanPlayer extends APlayer
{

    /**
     * Constructor for objects of class HumanPlayer
     */
    public HumanPlayer(ArrayList<Pokemon>t)
    {
        super(t);
    }

    public Move pickMove(){
        return null;
    }
    /**
     * Uses ArrayList of Pokemon objects representing the opposing team 
     * and prompts the user either to pick a valid move or to switch out into a different Pokemon.
     * @param  o  an ArrayList of Pokemon objects representing the opposing team
     * @return    a Move object either representing an attack by the Human player or a switch
     * into a different Pokemon
     */
    public Move pickMove(ArrayList<Pokemon> o){
        PrintStream os = System.out;
        Scanner scan = new Scanner(System.in);
        Pokemon a = super.getTeam().get(0);
        Pokemon b = o.get(0);
        os.println("CPU:");
        os.println(b.currentStats());
        os.println("---------------");
        os.println("You:");
        os.println(a.currentStats());
        os.println();
        int select = -1;
        boolean validMove = false;
        while(!validMove){
            try{
                os.println("1) Pick a move");
                os.println("2) Switch Pokemon");
                select = scan.nextInt();
                if(select != 1 && select != 2) throw new InputMismatchException();
                else validMove = true;
            } catch (InputMismatchException e){
                os.println("Invalid input, try again");
                scan.nextLine();
            }

        }

        validMove = false;

        if(select == 1){
            os.println(a.printMoves());

            while(!validMove){
                try{
                    os.println("Pick one of the above available moves");
                    select = scan.nextInt();
                    if(select < 1 || select > 4 || !a.getMoves()[select-1].getActive())
                        throw new IllegalArgumentException();
                    else validMove = true;
                } catch (InputMismatchException e){
                    os.println("Invalid input, try again");
                    scan.nextLine();
                } catch (IllegalArgumentException e){
                    os.println("Move inactive or out of range, try again");
                    scan.nextLine();
                }
            }
            a.getMoves()[select-1].useMove();
            return a.getMoves()[select-1];

        }else{
            switchPokemon(false);
            return new Move();
        }
    }

    /**
     * Prompts user to pick a Pokemon from the team to switch into
     * Once a valid input has been received, the selected Pokemon is moved
     * to the 0 index of the team ArrayList.
     * If at the start of the game, all Pokemon can be selected.
     * Otherwise, the first Pokemon can't be chosen as when switching out mid-game, 
     * you can't switch out into the same Pokemon that is currently active
     * @param start a boolean representing whether it is the start of the game or not
     */
    public void switchPokemon(boolean start){
        PrintStream os = System.out;
        Scanner scan = new Scanner(System.in);
        boolean validChoice = false;
        int select = -1;
        while(!validChoice){
            try{
                super.printTeam();
                os.println("Choose a pokemon to switch into");
                select = scan.nextInt();
                //Checks in range, if fainted, or if same pokemon
                if((start && select == 0)||(!start && select < 2) || select > 6 || !super.getTeam().get(select-1).getStatus()){
                    throw new IllegalArgumentException();
                }
                validChoice = true;
            } catch (InputMismatchException e){
                os.println("Invalid input, try again");
                scan.nextLine();
            } catch (IllegalArgumentException e){
                os.println("Pokemon inactive or out of range, try again");
                scan.nextLine();
            }
            
        }
        
        os.println("----------");
        Pokemon switched = super.getTeam().get(select-1);
        super.getTeam().remove(switched);
        super.getTeam().add(0, switched);
        os.println("You switched into " + switched.getName() + "!\n");
    }
}
