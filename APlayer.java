import java.util.*;
import java.io.*;

/**
 * An abstract class used to create a generic player object
 *
 * @author Pablo Crisostomo Suarez
 * @version 2022
 */
public abstract class APlayer
{
    // instance variables - replace the example below with your own
    private ArrayList<Pokemon> team;

    /**
     * Constructor for objects of class APlayer
     */
    public APlayer(ArrayList<Pokemon> team){
        this.team = team;
    }

    /**
     * Returns the team instance variable
     */
    public ArrayList<Pokemon> getTeam(){
        return team;
    }

    /**
     * Prints out every element in team with their hp
     */
    public void printTeam(){
        int i = 1;
        PrintStream os = System.out;
        for(Pokemon p : team){
            os.println(i +") "+ p.currentStats());
            i++;
        }

        os.println();
        os.println("-----------");
        os.println();
    }

    /**
     * Returns whether team still has active Pokemon
     */
    public boolean teamIsActive(){
        
        for(Pokemon p : team){
            if (p.getStatus()){
                return true;
            }
        }
        
        return false;
    }

    /**
     * An abstract method meant for selecting a valid move from a Pokemon's array of Move objects
     * @return a Move object representing the selected move for a turn
     */
    public abstract Move pickMove();

    /**
     * An abstract method meant for switching out a Pokemon to the front of the ArrayList team (index 0)
     * @param start a boolean representing whether it is the start of the game or not
     */
    public abstract void switchPokemon(boolean start);
}
