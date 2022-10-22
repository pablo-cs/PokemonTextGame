import java.util.*;
import java.io.*;

/**
 * A class containing all the methods needed to simulate a Pokemon battle
 *
 * @author Pablo Crisostomo Suarez
 * @version 2022
 */
public class Battle
{
    // instance variables - replace the example below with your own
    Pokedex pokedex = new Pokedex();
    
    /** 
     * Provides the user interface to play the text-based Pokemon game.
     * Allows the user to play as many rounds as they want against a CPU
     * until they decide to quit.
     */
    public static void main (String[] args){
        PrintStream os = System.out;
        Battle battle = new Battle();
        Scanner scan = new Scanner(System.in);
        os.println("Welcome to the Pokemon Battle Simulator! - Pablo Crisostomo Suarez");
        int cont = 0;
        while(cont!=2){
            battle.selectMenu();
            boolean validCont = false;
            while(!validCont){
                try{
                    os.println("Would you like to play again?");
                    os.println("1) Yes");
                    os.println("2) No");
                    cont = scan.nextInt();
                    if(cont < 1 || cont > 2) throw new IllegalArgumentException();
                    validCont = true;
                } catch (InputMismatchException e){
                    os.println("Invalid input");
                    scan.nextLine();
                } catch (IllegalArgumentException e){
                    os.println("Invalid option");
                    scan.nextLine();
                }
            }

            if(cont!=2) battle.pokedex = new Pokedex();
            else os.println("Good bye!");

        }

    }

    /**
     * Prompts the user to either choose from the Pokedex class' HashMap
     * of Pokemon manually and add 6 Pokemon for their team, or to choose to
     * randomly generate 6 Pokemon from the Pokedex class. In either case,
     * a random team is generated from the Pokedex class for the CPU.
     * After teams are chosen, starting Pokemon are selected and
     * the battleRound method initiates.
     */
    public void selectMenu (){
        int randomOrChoose = 0;
        PrintStream os = System.out;
        Scanner scan = new Scanner(System.in);
        ArrayList<Pokemon> userTeam = new ArrayList<>();
        ArrayList<Pokemon> compTeam;
        while(randomOrChoose != 1 && randomOrChoose != 2){
            try{
                os.println("How would you like to select your team?");
                os.println("1) Choose from Pokedex");
                os.println("2) Generate randomly");
                randomOrChoose = scan.nextInt();
                if(randomOrChoose != 1 && randomOrChoose != 2) throw new IllegalArgumentException();
            } catch(InputMismatchException e){
                os.println("Non-integer input");
                scan.nextLine();
            } catch(IllegalArgumentException e){
                os.println("Invalid input");
                scan.nextLine();
            }
        }

        int dexView = -1;
        
        if(randomOrChoose == 1){
            os.println(pokedex);
            while(dexView != 0 ){
                try{
                    os.println("Enter a Pokedex number to view more info or 0 to select your team:");

                    dexView = scan.nextInt();
                    if(pokedex.getDex().get(dexView) == null) throw new IllegalArgumentException();
                    os.println(pokedex.getDex().get(dexView));
                    os.println("----------------------------");
                    os.println();
                }catch(InputMismatchException e){
                    os.println("Invalid input");
                    scan.nextLine();
                }catch (IllegalArgumentException e){
                    if(dexView != 0){
                        os.println("Pokemon at Pokedex number is unavailable, try again");
                    }
                    scan.nextLine();
                }
            }

            os.println(pokedex);
            
            while(userTeam.size() != 6){
                
                int pickTeam = -1;
                
                try{
                    os.println("Pick a Pokemon with their Pokedex number");
                    pickTeam = scan.nextInt();
                    Integer choiceKey = pickTeam;
                    if(pokedex.getDex().get(choiceKey) == null) throw new InputMismatchException();
                    userTeam.add(pokedex.getEntry(choiceKey));
                    printTeam(userTeam);
                }catch (InputMismatchException e){
                    os.println("Enter a valid Pokedex number.");
                    scan.nextLine();
                }
                
                Integer c = pickTeam;
                pokedex.removeFromDex(c);
            }
        }else{
            userTeam = randomTeam();
        }
        compTeam = randomTeam();
        HumanPlayer user = new HumanPlayer(userTeam);
        CPUPlayer comp = new CPUPlayer(compTeam);

        os.println("CPU's Team:");
        printTeam(compTeam);
        os.println("Your team:");
        printTeam(userTeam);
        
        user.switchPokemon(true);
        comp.switchPokemon(true);
        
        battleRound(user,comp);
    }

    /**
     * Simulates a Pokemon battle between two 6 Pokemon teams from two
     * APlayer objects.
     * Runs while both teams still have at least one active Pokemon.
     * Pokemon at index 0 of their respective teams are considered the
     * active Pokemon.
     * Moves are chosen and execute in order depending on which Pokemon is 
     * has a higher speed value or if one of the players switches out their active Pokemon.
     * If either side switches, the switch occurs first and the move the
     * opposing Pokemon chose now executes on the newly active Pokemon.
     * If the Pokemon faints following the opposing player's turn,
     * that Pokemon must switch out and is no longer available for the game.
     * @param user APlayer representation of the user, containing their team
     * and implementations of APlayer methods
     * @param comp APlayer representation of the CPU, containing their team
     * and implementations of APlayer methods
     */
    public void battleRound(HumanPlayer user, CPUPlayer comp){
        SplittableRandom random = new SplittableRandom();
        PrintStream os = System.out;
        ArrayList<Pokemon> compTeam = comp.getTeam();
        ArrayList<Pokemon> userTeam = user.getTeam();
        while(user.teamIsActive() && comp.teamIsActive()){
            Pokemon a = userTeam.get(0);
            Move m = user.pickMove(compTeam);
            Pokemon b = compTeam.get(0);
            Move n = comp.pickMove();
            double randomTurn = -1;
            if(m.getName().equals("Switch")){
                a = user.getTeam().get(0);
                turn(b,a,user,n);
            } else if(n.getName().equals("Switch")){
                b = comp.getTeam().get(0);
                turn(a,b,comp,m);
            } else{
                if(a.getSpeed() == b.getSpeed()){
                    randomTurn = random.nextDouble();
                }
                if(a.getSpeed() > b.getSpeed() || randomTurn >= .5){
                    turn(a,b,comp,m);
                    if(b.getName().equals(comp.getTeam().get(0).getName()) &&
                    comp.teamIsActive()){
                        turn(b,a,user,n);
                    }

                }else if (a.getSpeed() < b.getSpeed() || randomTurn < .5 && randomTurn != -1){
                    turn(b,a,user,n);
                    if(a.getName().equals(user.getTeam().get(0).getName()) && 
                    user.teamIsActive()){
                        turn(a,b,comp,m);
                    }
                }
            }
            os.println("-----------");
            os.println();
        }

        if(user.teamIsActive()){
            os.println("You won!");
        }else{
            os.println("CPU wins!");
        }
    }

    /**
     * Performs a single Pokemon's turn and updates opposing Pokemon accordingly
     * Calculates the accuracy of a move by generating a double from 0 to 1.
     * If the random double is greater than the accuracy of the move, the move
     * doesn't execute and an appropriate statement is printed.
     * Given a move is on target, calculates the damage of a move on the 
     * opposing Pokemon and then updates their HP.
     * If the Pokemon's active variable returns false, prints out text
     * indicating that the Pokemon has fainted.
     * If there is at least one other active Pokemon on the opposing team, 
     * forces them to switch out into one of those active members.
     * @param a the active Pokemon which is executing a move
     * @param b the active Pokemon which is getting dealt a move
     * @param p2 APlayer representation of the CPU, containing their team
     * and implementations of APlayer methods
     * @param m the Move which a is executing
     */
    public void turn(Pokemon a, Pokemon b, APlayer p2, Move m){
        SplittableRandom random = new SplittableRandom();
        PrintStream os = System.out;
        //ArrayList<Pokemon> team2 = p2.getTeam();
        if(random.nextDouble() < m.getAccuracy()){ 
            int moveDam1 = damageCalc(a, b, m);
            b.updateHP(moveDam1);
        }else if (!m.getName().equals("Switch")){
            os.println(a.getName() + " used " + m.getName());
            os.println("It missed!");
        }

        if(!b.getStatus()){
            os.println(b.getName() + " fainted!\n");
            if(p2.teamIsActive()) p2.switchPokemon(false);
        }

    }

    /**
     * Generates a random ArrayList of 6 Pokemon and removes them from the Pokedex.
     * @return an ArrayList of 6 unique Pokemon objects
     */
    public ArrayList randomTeam(){
        ArrayList<Object> team = new ArrayList<>();

        Object[] keysArr = pokedex.getDex().keySet().toArray();
        Object key = null;
        boolean validPokemon = false;
        for(int i = 0; i < 6; i++){
            while(!validPokemon){
                key = keysArr[new Random().nextInt(keysArr.length)];
                if(pokedex.getDex().get(key) != null) validPokemon = true;
            }
            team.add(pokedex.getDex().get(key));
            pokedex.removeFromDex((Integer)key);
            validPokemon = false;
        }
        return team;
    }

    /**
     * Prints out all the Pokemon's names and HP in a team.
     * @param team an ArrayList of Pokemon
     */
    public static void printTeam(ArrayList<Pokemon> team){
        int i = 1;
        PrintStream os = System.out;
        for(Pokemon p : team){
            os.println(i +") "+ p.getName() + "| HP: " + p.getHP());
            i++;
        }

        os.println();
        os.println("-----------");
        os.println();
    }

    /**
     * Prints out if a move was "super effective", "not very effective", or
     * "had no effect" on a given Pokemon object.
     * If effect was neutral, nothing is printed.
     * Output depends on type of the Pokemon and type of the move.
     * @param t the target Pokemon object
     * @param m the Move which is targeting t
     */
    public void printTypeEffectiveMessage(Pokemon t, Move m){
        PrintStream os = System.out;
        double typeMod = typeEffectivenessModifier(t.getType()[0], m.getType());

        if(t.getType().length == 2){
            typeMod *= typeEffectivenessModifier(t.getType()[1], m.getType());
        }

        if(typeMod >= 2){
            os.println("It was super effective!");
        }else if(typeMod <= .5 && typeMod != 0) {
            os.println("It was not very effective!");
        }else if (typeMod == 0){
            os.println("It had no effect!");
        }

    }

    /**
     * Calculates and returns the total damage inflicted on a target Pokemon's
     * hp variable.
     * Result is calculated based on the attacking Pokemon's attack/specialAttack
     * and the opposing Pokemon's defense/specialDefense,the types of both
     * Pokemon, and whether is not the move is a critical hit.
     * @param  a  a Pokemon object representing the attacking Pokemon
     * @param  t  a Pokemon object representing the target Pokemon
     * @param  m  a Move object representing the Move executed by a onto t
     * @param crit an integer representing the chance of a critical hit
     * @param rand a double representing the random factor of move damage
     * @return    an int which is the total damage of the Move m
     */
    public static int damageCalc(Pokemon a, Pokemon t, Move m, int crit, double rand)
    {
        double finalDamage = m.getPower();
        Battle battle = new Battle();
        PrintStream os = System.out;
        os.println();
        os.println(a.getName() + " used " + m.getName());

        if(typeEffectivenessModifier(t.getType()[0], m.getType()) == 0){
            return 0;
        }else if (t.getType().length == 2){
            if(typeEffectivenessModifier(t.getType()[1], m.getType()) == 0) return 0;
        }
        //Determines physical or special attack
        if(m.getPhysicalOrSpecial()){
            finalDamage = Math.floor(finalDamage * (a.getAttack() / t.getDefense()));
        }else{
            finalDamage = Math.floor(finalDamage * (a.getSpecialAttack() / t.getSpecialDefense()));
        }

        finalDamage = Math.floor(22* finalDamage );
        finalDamage = Math.floor(finalDamage / 50) + 2;

        finalDamage = Math.floor(finalDamage * rand);

        //Checks for critical hit
        if(crit == 0 && finalDamage > 0){
            finalDamage = Math.floor(finalDamage * 1.5);
            os.println("It's a critical hit!");
        }

        //Checks for STAB
        if(a.getType()[0].equals(m.getType())){
            finalDamage = Math.floor(finalDamage * 1.5);
        }

        if(a.getType().length == 2){
            if (a.getType()[1].equals(m.getType())){
                finalDamage = Math.floor(finalDamage * 1.5);
            }
        }
        //Applies type effectiveness of move based on first type and second type if applicable
        finalDamage = Math.floor(finalDamage * typeEffectivenessModifier(t.getType()[0], m.getType()));
        if(t.getType().length == 2){
            finalDamage = Math.floor(finalDamage * typeEffectivenessModifier(t.getType()[1], m.getType()));
        }
        battle.printTypeEffectiveMessage(t,m);



        if((int)finalDamage != 0) os.println("It did " + (int)finalDamage + " damage!");
        os.println();
        return (int)finalDamage;
    }

    /**
     * An override of damage calc which uses a random number generator to determine the chance
     * of a critical hit and the random factor.
     * Calls damageCalc(Pokemon,Pokemon,Move,int,double) with the given parameters
     * and random numbers
     * @param a a Pokemon object representing the attacking Pokemon
     * @param t a Pokemon object representing the target Pokemon
     * @param m a Move object representing the Move executed by a onto t
     * @return the result of calling damageCalc with random numbers for crit and and rand
     */
    public static int damageCalc(Pokemon a, Pokemon t, Move m)
    {
        SplittableRandom random = new SplittableRandom();
        return damageCalc(a, t, m, random.nextInt(24), random.nextDouble(.85,1));
    }
    /**
     * Calculates the type effectiveness modifier of a Move's damage output
     * based on a String representing the type of the target and 
     * a String representing the type of the Move. 
     * Either returns .5, 1, 2, or 0.
     * @param targetType a String representing the type of the target
     * @param moveType a String representing the type of the move
     * @return a double representing the type effectiveness modifier
     */
    public static double typeEffectivenessModifier(String targetType, String moveType){

        switch(targetType){
            case "normal":
                if(moveType.equals("fighting")){
                    return 2;
                }

                if(moveType.equals("ghost")){
                    return 0;
                }

                break;
            case "fire":
                if((moveType.equals("bug")) || (moveType.equals("fire")) || (moveType.equals("fairy")) || (moveType.equals("ice"))
                || (moveType.equals("grass")) || (moveType.equals("steel"))){
                    return .5;
                }

                if((moveType.equals("ground")) || (moveType.equals("rock")) || (moveType.equals("water"))){
                    return 2;
                }

                if(moveType.equals("ghost")){
                    return 0;
                }

                break;
            case "water":
                if((moveType.equals("fire")) || (moveType.equals("ice")) || (moveType.equals("water")) || (moveType.equals("steel"))){
                    return .5;
                }

                if((moveType.equals("electric")) || (moveType.equals("grass"))){
                    return 2;
                }

                break;
            case "grass":
                if((moveType.equals("electric")) || (moveType.equals("grass")) || (moveType.equals("ground")) || (moveType.equals("water"))){
                    return .5;
                }

                if((moveType.equals("bug")) || (moveType.equals("fire")) || (moveType.equals("flying")) || (moveType.equals("ice"))
                || (moveType.equals("poison"))){
                    return 2;
                }

                break;
            case "electric":
                if((moveType.equals("electric")) || (moveType.equals("flying")) || (moveType.equals("steel"))){
                    return .5;
                }

                if(moveType.equals("ground")){
                    return 2;
                }

                break;
            case "ice":
                if(moveType.equals("ice")){
                    return .5;
                }

                if((moveType.equals("fighting")) || (moveType.equals("fire")) || (moveType.equals("rock")) || (moveType.equals("steel"))){
                    return 2;
                }

                break;
            case "fighting":
                if((moveType.equals("rock")) || (moveType.equals("bug")) || (moveType.equals("dark"))){
                    return .5;
                }

                if((moveType.equals("flying")) || (moveType.equals("psychic")) || (moveType.equals("fairy"))){
                    return 2;
                }

                break;
            case "poison":
                if((moveType.equals("fighting")) || (moveType.equals("bug")) || (moveType.equals("poison")) || (moveType.equals("grass")
                    || (moveType.equals("fairy")))){
                    return .5;
                }

                if((moveType.equals("ground")) || (moveType.equals("psychic"))){
                    return 2;
                }

                break;
            case "ground":
                if((moveType.equals("rock")) || (moveType.equals("poison"))){
                    return .5;
                }

                if((moveType.equals("water")) || (moveType.equals("grass")) || (moveType.equals("ice"))){
                    return 2;
                }

                if(moveType.equals("electric")){
                    return 0;
                }

                break;
            case "flying":
                if((moveType.equals("fighting")) || (moveType.equals("bug")) || (moveType.equals("grass"))){
                    return .5;
                }

                if((moveType.equals("rock")) || (moveType.equals("electric")) || (moveType.equals("ice"))){
                    return 2;
                }

                if(moveType.equals("ground")){
                    return 0;
                }

                break;
            case "psychic":
                if((moveType.equals("fighting")) || (moveType.equals("psychic"))){
                    return .5;
                }

                if((moveType.equals("bug")) || (moveType.equals("dark")) || (moveType.equals("ghost"))){
                    return 2;
                }

                break;
            case "bug":
                if((moveType.equals("fighting")) || (moveType.equals("grass")) || (moveType.equals("ground"))){
                    return .5;
                }

                if((moveType.equals("fire")) || (moveType.equals("flying")) || (moveType.equals("rock"))){
                    return 2;
                }

                break;
            case "rock":
                if((moveType.equals("fire")) || (moveType.equals("flying")) || (moveType.equals("normal")) || (moveType.equals("poison"))){
                    return .5;
                }

                if((moveType.equals("fighting")) || (moveType.equals("grass")) || (moveType.equals("ground")) || (moveType.equals("steel")) || (moveType.equals("water"))){
                    return 2;
                }

                break;
            case "ghost":
                if((moveType.equals("bug")) || (moveType.equals("poison"))){
                    return .5;
                }

                if((moveType.equals("dark")) || (moveType.equals("ghost"))){
                    return 2;
                }

                if((moveType.equals("fighting")) || (moveType.equals("normal"))){
                    return 0;
                }

                break;
            case "dark":
                if((moveType.equals("dark")) || (moveType.equals("ghost"))){
                    return .5;
                }

                if((moveType.equals("bug")) || (moveType.equals("fairy")) || (moveType.equals("fighting"))){
                    return 2;
                }

                if((moveType.equals("psychic"))){
                    return 0;
                }

                break;
            case "dragon":
                if((moveType.equals("electric")) || (moveType.equals("fire")) || (moveType.equals("grass")) || (moveType.equals("water"))){
                    return .5;
                }

                if((moveType.equals("dragon")) || (moveType.equals("fairy")) || (moveType.equals("ice"))){
                    return 2;
                }

                break;
            case "steel":
                if((moveType.equals("bug")) || (moveType.equals("dragon")) || (moveType.equals("fairy")) || (moveType.equals("ice"))
                || (moveType.equals("grass")) || (moveType.equals("steel")) || (moveType.equals("flying")) || (moveType.equals("normal"))
                || (moveType.equals("psychic")) || (moveType.equals("rock"))){
                    return .5;
                }

                if((moveType.equals("fighting")) || (moveType.equals("fire")) || (moveType.equals("ground"))){
                    return 2;
                } 

                if((moveType.equals("poison"))){
                    return 0;
                }

                break;
            case "fairy":
                if((moveType.equals("fighting")) || (moveType.equals("dark")) || (moveType.equals("bug"))){
                    return .5;
                }

                if((moveType.equals("poison")) || (moveType.equals("steel"))){
                    return 2;
                }

                if((moveType.equals("dragon"))){
                    return 0;
                }

                break;
            default:
                break;
        }
        return 1;
    }
}

