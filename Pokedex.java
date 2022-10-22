import java.util.HashMap;

/**
 * A class to represent a Pokedex
 *
 * @author Pablo Crisostomo Suarez
 * @version 2022
 */
public class Pokedex
{
    // instance variables - replace the example below with your own
    protected  HashMap<Integer, Pokemon> dex = new HashMap<>();

    /**
     * Constructor for objects of class Pokedex.
     * Fills up the dex HashMap with 32 unique Pokemon object, each with a 4 element Move array.
     */
    public Pokedex()
    {
        //Move(String name, String type, double power,int pp, boolean physicalOrSpecial, double accuracy
        Move[] arcanineMoves = {new Move("Dragon Pulse","dragon", 85, 10, false, 1), new Move("Burn Up","fire", 130, 5, false, 1), 
            new Move("Hyper Voice", "normal",90, 10, false, 1), new Move("Scorching Sands","ground", 70, 10, false, 1)};
        Pokemon arcanine = new Pokemon ("Arcanine", arcanineMoves, new String[] {"fire"}, 165, 130, 100,120, 100, 115);
        dex.put(59,arcanine);

        Move[] charizardMoves = {new Move("Overheat","fire", 130, 5, false, .9), new Move("Air Cutter","flying", 60, 25, false, .95), 
            new Move("Earthquake","ground", 100, 10, true, 1), new Move("Fire Punch","fire", 75, 15, true, 1)};
        Pokemon charizard = new Pokemon ("Charizard",charizardMoves, new String[] {"fire","flying"}, 153, 104, 98, 129, 105, 120);
        dex.put(6,charizard);
        
        Move[] porygonZMoves = {new Move("Tri Attack","normal", 80, 10, false, 1), new Move("Psychic","psychic", 90, 10, false, 1), 
            new Move("Ice Beam","ice", 90, 10, false, 1), new Move("Thunderbolt","electric", 90, 15, false, 1)};
        Pokemon porygonZ = new Pokemon ("Porygon-Z", porygonZMoves, new String[] {"normal"}, 160, 100, 90, 155, 95, 110);
        dex.put(474,porygonZ);
        
        Move[] bewearMoves = {new Move("Double Edge","normal", 120, 15, true, 1), new Move("Close Combat","fighting", 120, 5, true, 1), 
            new Move("Darkest Lariat","dark", 85, 10, true, 1), new Move("Shadow Claw","ghost", 70, 15, true, 1)};
        Pokemon bewear = new Pokemon ("Bewear", bewearMoves, new String[] {"normal","fighting"}, 195, 145, 100, 75, 80, 80);
        dex.put(760,bewear);
        
        Move[] hitmonleeMoves = {new Move("High Jump Kick","fighting", 130, 10, true, .9), new Move("Bounce","flying", 85, 5, true, .85), 
            new Move("Stone Edge","rock", 100, 5, true, .8), new Move("Poison Jab","poison", 80, 20, true, 1)};
        Pokemon hitmonlee = new Pokemon ("Hitmonlee", hitmonleeMoves, new String[] {"fighting"}, 125, 140, 73, 55, 130, 107);
        dex.put(106,hitmonlee);
        
        Move[] lucarioMoves = {new Move("Close Combat","fighting", 120, 5, true, 1),new Move("Blaze Kick","fire", 85, 10, true, .9), 
            new Move("Meteor Mash","steel", 90, 10, true, .9), new Move("Earthquake","ground", 100, 10, true, 1)};
        Pokemon lucario = new Pokemon ("Lucario", lucarioMoves, new String[] {"fighting","steel"}, 145, 130, 90, 135, 90, 110);
        dex.put(448,lucario);
        
        Move[] samurottMoves = {new Move("Surf","water", 90, 15, false, 1), new Move("Ice Beam","ice", 90, 10, false, 1), 
            new Move("Air Slash","flying", 75, 15, false, .95), new Move("Hyper Beam","normal", 150, 5, false, .9)};
        Pokemon samurott = new Pokemon ("Samurott",samurottMoves, new String[] {"water"}, 170, 120, 105, 128, 90, 90);
        dex.put(503,samurott);
        
        Move[] sharpedoMoves = {new Move("Ice Fang","ice", 65, 15, true, .95), new Move("Crunch","dark", 80, 15, true, 1), 
            new Move("Waterfall","water", 80, 15, true, 1), new Move("Night Slash","dark", 70, 15, true, 1)};
        Pokemon sharpedo = new Pokemon ("Sharpedo", sharpedoMoves, new String[] {"water","dark"}, 145, 140, 60, 115, 60, 115);
        dex.put(319,sharpedo);
        
        Move[] lilligantMoves = {new Move("Petal Dance","grass", 120, 10, false, 1), new Move("Petal Blizzard","grass", 90, 15, true, 1), 
            new Move("Round","normal", 60, 15, true, 1), new Move("Cut","normal", 50, 30, true, .95)};
        Pokemon lilligant = new Pokemon ("Lilligant", lilligantMoves, new String[] {"grass"}, 145, 80, 95, 130, 95, 110);
        dex.put(549,lilligant);
        
        Move[] torterraMoves = {new Move("Seed Bomb","grass", 80, 15, true, 1), new Move("Stomping Tantrum","ground", 75, 10, true, 1), 
            new Move("Rock Slide","rock", 75, 10, true, .9), new Move("Earthquake","ground", 100, 10, true, 1)};
        Pokemon torterra = new Pokemon ("Torterra", torterraMoves, new String[] {"grass","ground"}, 170, 129, 125, 95, 105, 76);
        dex.put(389,torterra);
        
        Move[] noivernMoves = {new Move("Dragon Pulse","dragon", 85, 10, false, 1), new Move("Flamethrower","fire", 90, 15, false, 1), 
            new Move("Hurricane","flying",110, 10, false, .7), new Move("Boomburst","normal", 140, 10, false, 1)};
        Pokemon noivern = new Pokemon ("Noivern", noivernMoves, new String[] {"flying","dragon"}, 160, 90, 100, 117, 100, 143);
        dex.put(715,noivern);
        
        Move[] weezingMoves = {new Move("Sludge Wave","poison", 95, 10, false, 1), new Move("Thunderbolt","electric", 90, 15, false, 1), 
            new Move("Shadow Ball","ghost", 80, 15, false, 1), new Move("Sludge Bomb","poison", 90, 10, false, 1)};
        Pokemon weezing = new Pokemon ("Weezing", weezingMoves, new String[] {"poison"}, 140, 110, 140, 105, 90, 80);
        dex.put(110,weezing);
        
        Move[] drapionMoves = {new Move("Night Slash","dark", 70, 15, true, 1), new Move("Poison Jab","poison", 80, 20, true, 1), 
            new Move("Brick Break","fighting", 75, 15, true, 1), new Move("Strength","normal", 80, 15, true, 1)};
        Pokemon drapion = new Pokemon ("Drapion", drapionMoves, new String[] {"poison", "bug"}, 145, 110, 130, 80, 95, 115);
        dex.put(452,drapion);
        
        Move[] ampharosMoves = {new Move("Discharge","electric", 80, 15, false, 1), new Move("Dragon Pulse","dragon", 85, 10, false, 1),
            new Move("Power Gem","rock", 80, 20, false, 1), new Move("Signal Beam","bug", 75, 15, false, 1)};
        Pokemon ampharos = new Pokemon ("Ampharos", ampharosMoves, new String[] {"electric"}, 165, 95, 105, 135, 110, 75);
        dex.put(181,ampharos);
        
        Move[] magnezoneMoves = {new Move("Thunderbolt","electric", 90, 15, false, 1), new Move("Flash Cannon","steel", 80, 10, false, 1), 
            new Move("Hyper Beam","normal", 150, 5, false, .9), new Move("Tri Attack","normal", 80, 10, false, 1)};
        Pokemon magnezone = new Pokemon ("Magnezone", magnezoneMoves, new String[] {"electric", "steel"}, 145, 90, 135, 150, 110, 80);
        dex.put(462,magnezone);
        
        Move[] donphanMoves = {new Move("Head Smash","rock", 150, 5, true, .8), new Move("High Horsepower","ground", 95, 10, true, .95), 
            new Move("Superpower","fighting", 120, 5, true, 1), new Move("Ice Shard","ice", 40, 30, true, 1)};
        Pokemon donphan = new Pokemon ("Donphan", donphanMoves, new String[] {"ground"}, 165, 140, 140, 80, 80, 70);
        dex.put(231,donphan);
        
        Move[] golurkMoves = {new Move("Poltergeist","ghost", 110, 5, true, .9), new Move("Dynamic Punch","fighting", 100, 5, true, .5), 
            new Move("Stone Edge","rock", 100, 5, true, .8), new Move("Ice Punch","ice", 75, 15, true, 1)};
        Pokemon golurk = new Pokemon ("Golurk", golurkMoves, new String[] {"ground", "ghost"}, 164, 144, 100, 75, 10, 75);
        dex.put(623,golurk);
        
        Move[] gothitelleMoves = {new Move("Psychic","psychic", 90, 10, false, 1), new Move("Dark Pulse","dark", 80, 15, false, 1), 
            new Move("Energy Ball","grass", 90, 10, false, 1), new Move("Expanding Force","psychic", 80, 10, false, 1)};
        Pokemon gothitelle = new Pokemon ("Gothitelle", gothitelleMoves, new String[] {"psychic"}, 145, 75, 115, 115, 130, 85);
        dex.put(576,gothitelle);
        
        Move[] galladeMoves = {new Move("Psycho Cut","psychic", 90, 20, true, 1), new Move("Zen Headbutt","psychic", 80, 15, true, .9), 
            new Move("Double Edge","normal", 120, 15, true, 1), new Move("Leaf Blade","grass", 90, 15, true, 1)};
        Pokemon gallade = new Pokemon ("Gallade", galladeMoves, new String[] {"psychic", "fighting"}, 143, 145, 85, 85, 135, 100);
        dex.put(475,gallade);
        
        Move[] ramparadosMoves = {new Move("Rock Slide","rock", 75, 10, true, .9), new Move("Zen Headbutt","psychic", 80, 15, true, .9), 
            new Move("Avalanche","ice", 60, 10, true, 1), new Move("Rock Tomb","rock", 60, 15, true, .95)};
        Pokemon ramparados = new Pokemon ("Ramparados", ramparadosMoves, new String[] {"rock"}, 172, 185, 80, 85, 70, 78);
        dex.put(409,ramparados);
        
        Move[] golemMoves = {new Move("Iron Head","steel", 90, 20, true, 1), new Move("Fire Punch","fire", 75, 15, true, 1), 
            new Move("Earthquake","ground", 100, 10, true, 1),  new Move("Stone Edge","rock", 100, 5, true, .8)};
        Pokemon golem = new Pokemon ("Golem", golemMoves, new String[] {"rock", "ground"}, 155, 140, 150, 75, 85, 65);
        dex.put(76,golem);
        
        Move[] glaceonMoves = {new Move("Shadow Ball","ghost", 80, 15, false, 1), new Move("Freeze Dry","ice", 70, 20, false, 1), 
            new Move("Blizzard","ice", 110, 5, false, .7), new Move("Hyper Voice","normal", 90, 10, false, 1)};
        Pokemon glaceon = new Pokemon ("Glaceon", glaceonMoves, new String[] {"ice"}, 140, 80, 130, 150, 115, 85);
        dex.put(471,glaceon);
        
        Move[] froslassMoves = {new Move("Poltergeist","ghost", 110, 5, true, .9), new Move("Icy Wind","ice", 55, 15, false, .95), 
            new Move("Hex","ghost", 65, 10, false, 1),  new Move("Crunch","rock", 80, 15, true, 1)};
        Pokemon froslass = new Pokemon ("Froslass", froslassMoves, new String[] {"ice", "ghost"}, 145, 100, 90, 100, 90, 130);
        dex.put(478,froslass);
        
        Move[] accelgorMoves = {new Move("Bug Buzz","bug", 90, 10, false, 1), new Move("Struggle Bug","bug", 50, 20, false, 1), 
            new Move("Acid Spray","poison", 40, 20, false, 1), new Move("Venoshock","poison", 65, 10, false, 1)};
        Pokemon accelgor = new Pokemon ("Accelgor", accelgorMoves, new String[] {"bug"}, 155, 90, 60, 120, 80, 165);
        dex.put(617,accelgor);
        
        Move[] volcaronaMoves = {new Move("Heat Wave","fire", 95, 10, false, .9), new Move("Solar Beam","grass", 120, 10, false, 1), 
            new Move("Psychic","psychic", 90, 10, false, 1),  new Move("Overheat","fire", 130, 5, false, .9)};
        Pokemon volcarona = new Pokemon ("Volcarona", volcaronaMoves, new String[] {"bug", "fire"}, 160, 80, 85, 155, 125, 120);
        dex.put(637,volcarona);
        
        Move[] haxorusMoves = {new Move("Dragon Claw","dragon", 80, 15, true, 1), new Move("Close Combat","fighting", 120, 5, true, 1), 
            new Move("Breaking Swipe","dragon", 60, 15, true, 1), new Move("Stomping Tantrum","ground", 75, 10, true, 1)};
        Pokemon haxorus = new Pokemon ("Haxorus", haxorusMoves, new String[] {"dragon"}, 151, 167, 110, 80, 90, 117);
        dex.put(612,haxorus);
        
        Move[] garchompMoves = {new Move("Outrage","dragon", 120, 10, true, 1), new Move("Poison Jab","poison", 80, 20, true, 1), 
            new Move("Shadow Claw","ghost", 70, 15, true, 1),  new Move("Stone Edge","rock", 100, 5, true, .8)};
        Pokemon garchomp = new Pokemon ("Garchomp", garchompMoves, new String[] {"dragon", "ground"}, 183, 150, 115, 100, 105, 122);
        dex.put(445,garchomp);
        
        Move[] dusknoirMoves = {new Move("Poltergeist","ghost", 110, 5, true, .9), new Move("Earthquake","ground", 100, 10, true, 1), 
            new Move("Double Edge","normal", 120, 15, true, 1), new Move("Ice Punch","ice", 75, 15, true, 1)};
        Pokemon dusknoir = new Pokemon ("Dusknoir", dusknoirMoves, new String[] {"ghost"}, 120, 120, 155, 85, 155, 65);
        dex.put(477,dusknoir);
        
        Move[] gengarMoves = {new Move("Sludge Wave","poison", 95, 10, false, 1), new Move("Shadow Ball","ghost", 80, 15, false, 1), 
            new Move("Thunderbolt","electric", 90, 15, false, 1),  new Move("Psychic","psychic", 90, 10, false, 1)};
        Pokemon gengar = new Pokemon ("Gengar", gengarMoves, new String[] {"ghost", "poison"}, 135, 85, 80, 150, 95, 130);
        dex.put(94,gengar);
        
        Move[] zoroarkMoves = {new Move("Burning Jealousy","fire", 70, 5, false, 1), new Move("Night Daze","dark", 85, 10, false, 1), 
            new Move("Shadow Claw","ghost", 70, 15, true, 1), new Move("Skitter Smack","bug", 70, 10, true, .9)};
        Pokemon zoroark = new Pokemon ("Zoroark", zoroarkMoves, new String[] {"dark"}, 135, 125, 80, 140, 80, 125);
        dex.put(571,zoroark);
        
        Move[] hydreigonMoves = {new Move("Draco Meteor","dragon", 130, 5, false, .9), new Move("Earth Power","ground", 90, 10, false, 1), 
             new Move("Dark Pulse","dark", 80, 15, false, 1), new Move("Throat Chop","dark", 80, 15, true, 1)};
        Pokemon hydreigon = new Pokemon ("Hydreigon", hydreigonMoves, new String[] {"dark", "dragon"}, 167, 125, 110, 145, 110, 118);
        dex.put(635,hydreigon);
        
        Move[] steelixMoves = {new Move("Head Smash","rock", 150, 5, true, .8), new Move("Rock Slide","rock", 75, 10, true, .9), 
            new Move("High Horsepower","ground", 95, 10, true, .95), new Move("Iron Head","steel", 90, 20, true, 1)};
        Pokemon steelix = new Pokemon ("Steelix", steelixMoves, new String[] {"steel", "ground"}, 150, 105, 220, 75, 85, 50);
        dex.put(208,steelix);
        
        Move[] metagrossMoves = {new Move("Meteor Mash","steel", 90, 10, true, .9), new Move("Psycho Cut","psychic", 90, 20, true, 1), 
             new Move("Ice Punch","ice", 75, 15, true, 1), new Move("Double Edge","normal", 120, 15, true, 1)};
        Pokemon metagross = new Pokemon ("Metagross", metagrossMoves, new String[] {"steel", "psychic"}, 155, 155, 150, 115, 110, 90);
        dex.put(376,metagross);
        
        Move[] sylveonMoves = {new Move("Mystical Fire","fire", 75, 10, false, 1), new Move("Psyshock","psychic", 80, 10, false, 1), 
            new Move("Misty Explosion","fairy", 100, 5, false, 1), new Move("Moonblast","fairy", 95, 15, false, 1)};
        Pokemon sylveon = new Pokemon ("Sylveon", sylveonMoves, new String[] {"fairy"}, 170, 85, 85, 130, 150, 80);
        dex.put(700,sylveon);
        
        Move[] togekissMoves = {new Move("Dazzling Gleam","fairy", 80, 10, false, 1), new Move("Air Slash","flying", 75, 15, false, .95), 
             new Move("Psychic","psychic", 90, 10, false, 1), new Move("Extrasensory","psychic", 80, 20, false, 1)};
        Pokemon togekiss = new Pokemon ("Togekiss", togekissMoves, new String[] {"fairy", "flying"}, 160, 70, 115, 140, 135, 100);
        dex.put(468,togekiss);

    }

    /**
     * Returns dex of Pokedex
     */
    public HashMap<Integer, Pokemon> getDex()
    {
        return dex;
    }

    /**
     * Returns a Pokemon value at the given key
     */
    public Pokemon getEntry(Integer e){
        return dex.get(e);
    }
    
    /**
     * Returns a String representation of Pokedex
     */
    public String toString(){
        String s = "";
        for (Integer i : dex.keySet()) {
            s += "No." + i + ": " + dex.get(i).getName() + "\n";
        }
        return s;
    }

    public void removeFromDex(Integer key){
        dex.remove(key);
    }

}
