import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/**
 * A class with unit tests for the Move class.
 *
 * @author  Pablo Crisostomo Suarez
 * @version 2022
 */
class MoveTest {

    /**
     * Tests that a move's max PP is equal to it's current PP when first created
     */
    @Test
    void useMoveNoneTest() {
        Move m = new Pokedex().getEntry(462).getMoves()[2];
        assertEquals(m.getMaxPP(), m.getCurrPP());
        assertEquals(5, m.getCurrPP());
    }

    /**
     * Tests that using the useMove() method once on a move decreases the currPP by 1
     */
    @Test
    void useMoveOnceTest() {
        Move m = new Pokedex().getEntry(462).getMoves()[2];
        m.useMove();
        assertEquals(4, m.getCurrPP());
    }

    /**
     * Tests that a move will remain active if the useMove() method is used on it and
     * the currPP is not equal to 0
     */
    @Test
    void useMoveOnceStatusTest() {
        Move m = new Pokedex().getEntry(462).getMoves()[2];
        m.useMove();
        assertTrue(m.getActive());
    }

    /**
     * Tests that using the useMove() method enough times on a move will set the currPP to 0
     */
    @Test
    void useMoveToZeroTest() {
        Move m = new Pokedex().getEntry(462).getMoves()[2];
        m.useMove();
        m.useMove();
        m.useMove();
        m.useMove();
        m.useMove();
        assertEquals(0, m.getCurrPP());
    }

    /**
     * Tests that a move will become inactive if the useMove() method is used on it and
     * the currPP is then equal to 0
     */
    @Test
    void useMoveToZeroStatusTest() {
        Move m = new Pokedex().getEntry(462).getMoves()[2];
        m.useMove();
        m.useMove();
        m.useMove();
        m.useMove();
        m.useMove();
        assertFalse(m.getActive());
    }

    /**
     * Tests that using the useMove() method on a Move more times than the maxPP will keep
     * the currPP at 0 and not go into negatives
     */
    @Test
    void useMovePastZeroTest() {
        Move m = new Pokedex().getEntry(462).getMoves()[2];
        m.useMove();
        m.useMove();
        m.useMove();
        m.useMove();
        m.useMove();
        m.useMove();
        assertEquals(0, m.getCurrPP());
    }

    /**
     * Tests that the toString method returns in the correct format when a Move is supposed to be Special
     */
    @Test
    void toStringTestSpecialTest(){
        Move m = new Move("Discharge","electric", 80, 15, false, 1);
        String mString = "Discharge\nType: electric\nPower: 80\nCategory: Special\nPP: 15/15\nAccuracy: 100%";
        assertEquals(mString,m.toString());
    }

    /**
     * Tests that the toString method returns in the correct format when a Move is supposed to be Physical
     */
    @Test
    void toStringTestPhysicalTest(){
        Move m = new Move("High Jump Kick","fighting", 130, 10, true, .9);
        String mString = "High Jump Kick\nType: fighting\nPower: 130\nCategory: Physical\nPP: 10/10\nAccuracy: 90%";
        assertEquals(mString,m.toString());
    }
}