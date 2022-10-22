import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * A class with unit tests for the Pokemon class.
 *
 * @author  Pablo Crisostomo Suarez
 * @version 2022
 */
class PokemonTest {

    /**
     * Tests that a Pokemon remains active when it's hp is depleted by less than its current hp
     * and that its hp is updated accordingly
     */
    @Test
    void updateHPNoFaintTest() {
        Pokemon p  = (new Pokedex()).getEntry(474);
        p.updateHP(50);
        assertTrue(p.getStatus());
        assertEquals(110,p.getHP());
    }

    /**
     * Tests that a Pokemon is inactive when it's hp is depleted by more than its current hp
     * and that its hp is updated accordingly
     */
    @Test
    void updateHPFaintTest() {
        Pokemon p  = (new Pokedex()).getEntry(474);
        p.updateHP(170);
        assertFalse(p.getStatus());
        assertEquals(0,p.getHP());
    }

    /**
     * Tests that the typeToString method return the proper String formats for the type array  when a Pokemon has a
     * single type
     */
    @Test
    void typeToStringSingleTypeTest(){
        Pokemon p = (new Pokedex()).getEntry(474);
        String type = p.typeToString();
        assertEquals("normal", type);
    }

    /**
     * Tests that the typeToString method return the proper String formats for the type array  when a Pokemon has a
     * double type
     */
    @Test
    void typeToStringDoubleTypeTest(){
        Pokemon p = (new Pokedex()).getEntry(6);
        String type = p.typeToString();
        assertEquals("fire flying", type);
    }

    /**
     * Tests that the printMoves method returns the String representation of a Pokemon's moves in the proper format
     */
    @Test
    void printMovesTest(){
        Pokemon p = (new Pokedex()).getEntry(6);
        String mString = "\n1) Overheat\nType: fire\nPower: 130\nCategory: Special\nPP: 5/5\nAccuracy: 90%\n";
        mString += "\n2) Air Cutter\nType: flying\nPower: 60\nCategory: Special\nPP: 25/25\nAccuracy: 95%\n";
        mString += "\n3) Earthquake\nType: ground\nPower: 100\nCategory: Physical\nPP: 10/10\nAccuracy: 100%\n";
        mString += "\n4) Fire Punch\nType: fire\nPower: 75\nCategory: Physical\nPP: 15/15\nAccuracy: 100%\n";
        assertEquals(mString, p.printMoves());

    }

    /**
     * Tests that the printMoves method returns the String representation of a Pokemon in the proper format
     */
    @Test
    void toStringTest(){
        Pokemon p = (new Pokedex()).getEntry(474);
        String pString = "Porygon-Z\nType: normal\nHP: 160\nAttack: 100\nDefense: 90\nSpecial Attack: 155\nSpecial Defense: 95\nSpeed: 110";
        pString+="\nMoves:\n1) Tri Attack\n2) Psychic\n3) Ice Beam\n4) Thunderbolt";
        assertEquals(pString, p.toString());
    }

    /**
     * Tests that the currentStats method returns the proper mid-game String representation of a Pokemon
     * when active
     */
    @Test
    void currentStatsNonFaintTest(){
        Pokemon p = (new Pokedex()).getEntry(448);
        String tString = "Lucario\nType: fighting steel\nHP: 145";
        assertEquals(tString,p.currentStats());
    }

    /**
     * Tests that the currentStats method returns the proper mid-game String representation of a Pokemon
     * when inactive
     */
    @Test
    void currentStatsFaintTest(){
        Pokemon p = (new Pokedex()).getEntry(760);
        p.updateHP(200);
        String tString =  "X Bewear X";
        assertEquals(tString,p.currentStats());
    }
}