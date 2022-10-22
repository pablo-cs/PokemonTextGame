
/**
 * A class to represent a Pokemon
 *
 * @author Pablo Crisostomo Suarez
 * @version 2022
 */
public class Pokemon
{
    private String name;
    private Move[] moves;
    private String[] type;
    private int hp;
    private double attack, specialAttack, defense, specialDefense, speed;
    private boolean status;

    /**
     * Constructor for objects of class Pokemon
     */
    public Pokemon(String name, Move[] moves, String[] type, int hp, double attack, 
    double defense, double specialAttack, double specialDefense, double speed)
    {
        this.name = name;
        this.moves = moves;
        this.type = type;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.specialAttack = specialAttack;
        this.specialDefense = specialDefense;
        this.speed = speed;
        this.status = true;
    }

    /**
     * Returns name of Pokemon
     */
    public String getName(){
        return name;
    }

    /**
     * Returns type array of Pokemon
     */
    public String[] getType(){
        return type;
    }

    /**
     * Returns hp of Pokemon
     */
    public int getHP(){
        return hp;
    }

    /**
     * Updates hp of Pokemon and sets status to false if hp falls below or equal to 0
     */
    public void updateHP(int d){
        hp -= d;
        if(hp <= 0){
            hp = 0;
            status = false;
        }

    }

    /**
     * Returns attack of Pokemon
     */
    public double getAttack(){
        return attack;
    }

    /**
     * Returns specialAttack of Pokemon
     */
    public double getSpecialAttack(){
        return specialAttack;
    }

    /**
     * Returns defense of Pokemon
     */
    public double getDefense(){
        return defense;
    }

    /**
     * Returns specialDefense of Pokemon
     */
    public double getSpecialDefense(){
        return specialDefense;
    }

    /**
     * Returns speed of Pokemon
     */
    public double getSpeed(){
        return speed;
    }
    
    /**
     * Returns status of Pokemon
     */
    public boolean getStatus(){
        return status;
    }
    
    /**
     * Returns moves of Pokemon
     */
    public Move[] getMoves(){
        return moves;
    }

    /**
     * Returns String representation of type(s) of Pokemon
     */
    public String typeToString(){
        String t = "";
        int i = 0;
        for (String s : type) {
            t += s;
            if (i == 0 && type.length == 2) t += " ";
            i++;
        }
        return t;
    }

    /**
     * Returns String representation of moves of Pokemon
     */
    public String printMoves(){
        String moveString = "";
        for(int i = 0; i < moves.length;i++){
            moveString += "\n" + (i+1) + ") " + moves[i] + "\n";
        }
        return moveString;
    }

    /**
     * Returns String representation of Pokemon
     */
    public String toString(){
        String info = name + "\nType: " + typeToString();

        info+="\nHP: " + hp + "\nAttack: " + (int)attack + "\nDefense: " + (int)defense
        + "\nSpecial Attack: " + (int)specialAttack + "\nSpecial Defense: "
        + (int)specialDefense + "\nSpeed: " + (int)speed;
        info+="\nMoves:";
        for(int i = 0; i < moves.length;i++){
            info += "\n" + (i+1) + ") " + moves[i].getName();
        }
        return info;
    }

    /**
     * Returns String representation of current health status of Pokemon
     */
    public String currentStats(){
        String info = "";
        if(!status){
            info+= "X " + name + " X";
        }else{
            info += name + "\nType: " + typeToString() + "\nHP: " + (int)hp;
        }
        return info;
    }
}
