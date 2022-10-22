
/**
 * A class to represent a Move
 *
 * @author Pablo Crisostomo Suarez
 * @version 2022
 */
public class Move
{
    // instance variables - replace the example below with your own
    private String name, type;
    private double power;
    private int currPP, maxPP;
    private boolean physicalOrSpecial;
    private double accuracy;
    private boolean active;
    /**
     * Default constructor for objects of class Move.
     * Used to represent the decision to switch as opposed to a proper Move.
     */
    public Move(){
        this.name = "Switch";
        this.type = "";
        this.power = 0;
        this.currPP = 0;
        this.maxPP = 0;
        this.physicalOrSpecial = false;
        this.accuracy = 0;
        this.active = false;
    }
    
    /**
     * Constructor for objects of class Move
     */
    public Move(String name, String type, double power,int pp,
    boolean physicalOrSpecial, double accuracy){
        this.name = name;
        this.type = type;
        this.power = power;
        this.currPP = pp;
        this.maxPP = pp;
        this.physicalOrSpecial = physicalOrSpecial;
        this.accuracy = accuracy;
        this.active = true;
    }

    /**
     * Returns name of Move
     */
    public String getName(){
        return name;
    }
    
    /**
     * Returns type of Move
     */
    public String getType(){
        return type;
    }
    
    /**
     * Returns power of Move
     */
    public double getPower(){
        return power;
    }

    /**
     * Returns currPP of Move
     */
    public double getCurrPP(){
        return currPP;
    }

    /**
     * Returns maxPP of Move
     */
    public double getMaxPP(){
        return maxPP;
    }


    /**
     * Subtracts 1 from currPP, meaning Move has been used once.
     * If currPP becomes 0 as a result, active is set to false.
     */
    public void useMove(){
        currPP --;
        if (currPP <= 0){
            active = false;
            currPP = 0;
        }
    }

    /**
     * Returns physicalOrSpecial of Move
     */
    public boolean getPhysicalOrSpecial(){
        return physicalOrSpecial;
    }
    
    /**
     * Returns accuracy of Move
     */
    public double getAccuracy(){
        return accuracy;
    }
    
    /**
     * Returns active of Move
     */
    public boolean getActive(){
        return active;
    }
    
    /**
     * Returns String representation of Move
     */
    public String toString(){
        String info = name + "\nType: " + type + "\nPower: " + (int)power + "\nCategory: ";
        if(physicalOrSpecial){
            info += "Physical";
        }else{
            info += "Special";
        }
        info += "\nPP: " + currPP + "/" + maxPP + "\nAccuracy: " + (int)(accuracy * 100) + "%";
        
        return info;
    }
}
