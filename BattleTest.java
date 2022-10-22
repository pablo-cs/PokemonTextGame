import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;
/**
 * A class with unit tests for the Battle class.
 *
 * @author  Pablo Crisostomo Suarez
 * @version 2022
 */
class BattleTest {

    /**
     * Tests that using Battle's randomTeam method will generate an ArrayList of size 6
     */
    @Test
    void randomTeamHasSixElementsTest() {
        Battle b = new Battle();
        ArrayList team = b.randomTeam();
        assertEquals(6, team.size());
    }

    /**
     * Tests that using Battle's randomTeam method remove 6 elements of Battle's Pokedex,
     * meaning all the elements in the team are unique
     */
    @Test
    void randomTeamRemovesFromDexTest() {
        Battle b = new Battle();
        ArrayList team = b.randomTeam();
        assertEquals(29, b.pokedex.getDex().size());
    }

    /**
     * Tests that damageCalc produces the correct output if the move is not a critical hit
     * and the random factor is at the minimum value
     */
    @Test
    void damageCalcNonCritMinRangeTest() {
        Battle b = new Battle();
        Pokemon x = b.pokedex.getEntry(471);
        Pokemon y = b.pokedex.getEntry(445);
        Move m = x.getMoves()[1];

        int d = Battle.damageCalc(x,y,m,1,.85);
        assertEquals(232,d);
    }

    /**
     * Tests that damageCalc produces the correct output if the move is a critical hit
     * and the random factor is at the minimum value
     */
    @Test
    void damageCalcCritMinRangeTest() {
        Battle b = new Battle();
        Pokemon x = b.pokedex.getEntry(471);
        Pokemon y = b.pokedex.getEntry(445);
        Move m = x.getMoves()[1];

        int d = Battle.damageCalc(x,y,m,0,.85);
        assertEquals(348,d);
    }

    /**
     * Tests that damageCalc produces the correct output if the move is not a critical hit
     * and the random factor is at a middle range value
     */
    @Test
    void damageCalcNonCritMidRangeTest() {
        Battle b = new Battle();
        Pokemon x = b.pokedex.getEntry(471);
        Pokemon y = b.pokedex.getEntry(445);
        Move m = x.getMoves()[1];

        int d = Battle.damageCalc(x,y,m,1,.92);
        assertEquals(252,d);
    }

    /**
     * Tests that damageCalc produces the correct output if the move is a critical hit
     * and the random factor is at a middle range value
     */
    @Test
    void damageCalcCritMidRangeTest() {
        Battle b = new Battle();
        Pokemon x = b.pokedex.getEntry(471);
        Pokemon y = b.pokedex.getEntry(445);
        Move m = x.getMoves()[1];

        int d = Battle.damageCalc(x,y,m,0,.92);
        assertEquals(376,d);
    }

    /**
     * Tests that damageCalc produces the correct output if the move is not a critical hit
     * and the random factor is at the max value
     */
    @Test
    void damageCalcNonCritMaxRangeTest() {
        Battle b = new Battle();
        Pokemon x = b.pokedex.getEntry(471);
        Pokemon y = b.pokedex.getEntry(445);
        Move m = x.getMoves()[1];

        int d = Battle.damageCalc(x,y,m,1,1);
        assertEquals(276,d);
    }

    /**
     * Tests that damageCalc produces the correct output if the move is a critical hit
     * and the random factor is at the max value
     */
    @Test
    void damageCalcCritMaxRangeTest() {
        Battle b = new Battle();
        Pokemon x = b.pokedex.getEntry(471);
        Pokemon y = b.pokedex.getEntry(445);
        Move m = x.getMoves()[1];

        int d = Battle.damageCalc(x,y,m,0,1);
        assertEquals(412,d);
    }

    /**
     * Tests that typeEffectivenessModifier returns the correct modifier if a type is not very effective
     * against another type
     */
    @Test
    void typeEffectivenessModifierNotEffectiveTest() {

        assertEquals(.5, Battle.typeEffectivenessModifier("fairy","dark"));
    }

    /**
     * Tests that typeEffectivenessModifier returns the correct modifier if a type has no effect
     * against another type
     */
    @Test
    void typeEffectivenessModifierNoEffectTest() {

        assertEquals(0, Battle.typeEffectivenessModifier("ghost","normal"));
    }

    /**
     * Tests that typeEffectivenessModifier returns the correct modifier if a type has a neutral
     * against another type
     */
    @Test
    void typeEffectivenessModifierNeutralEffectTest() {
        assertEquals(1, Battle.typeEffectivenessModifier("psychic","rock"));
    }

    /**
     * Tests that typeEffectivenessModifier returns the correct modifier if a type is super effective
     * against another type
     */
    @Test
    void typeEffectivenessModifierSuperEffectiveTest() {

        assertEquals(2, Battle.typeEffectivenessModifier("bug","fire"));
    }
}