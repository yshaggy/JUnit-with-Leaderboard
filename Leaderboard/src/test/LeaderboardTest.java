package test;


import main.Leaderboard;
import main.Scoreboard;


import static org.junit.Assert.*;
import org.junit.Test;

public class LeaderboardTest {
    @Test
    public void TestInitialState() {
        Scoreboard b = new Scoreboard();
        assertNotNull(b);
        assertEquals(0, b.getTopScore());
        assertEquals("No current entries!", b.getTopPlayer());
    }

    @Test
    public void TestAddingScore() {
        Scoreboard b = new Scoreboard();
        b.addScore("Kris Jordan", 101);
        assertEquals(101, b.getScore("Kris Jordan"));
        assertEquals(1, b.getSize());

        b.addScore("Henry Fuchs", 311);
        assertEquals(311, b.getScore("Henry Fuchs"));
        assertEquals(2, b.getSize());
    }

    @Test
    public void TestRetrievingInvalidScore() {
        Scoreboard b = new Scoreboard();
        b.addScore("Player One",100);

        try {
            b.getScore("Player 1");
            fail();
        } catch (IllegalArgumentException iae) {
            assertTrue(true);
        }
    }

    @Test
    public void TestUpdatingScore() {
        Scoreboard b = new Scoreboard();
        b.addScore("Paul Stotts", 210);
        assertEquals(210, b.getScore("Paul Stotts"));
        assertEquals("Paul Stotts", b.getTopPlayer());
        assertEquals(210, b.getTopScore());

        // Higher scores for same player should update
        b.addScore("Paul Stotts", 523);
        assertEquals(523, b.getScore("Paul Stotts"));
        assertEquals("Paul Stotts", b.getTopPlayer());
        assertEquals(523, b.getTopScore());

        // Lower scores for same player should not update
        b.addScore("Paul Stotts", 410);
        assertEquals(523, b.getScore("Paul Stotts"));
        assertEquals("Paul Stotts", b.getTopPlayer());
        assertEquals(523, b.getTopScore());
        assertEquals(1, b.getSize());
    }

    @Test
    public void TestBoardCapacity() {
        Scoreboard b = new Scoreboard();
        b.addScore("Kris Jordan", 101);
        b.addScore("Henry Fuchs", 311);
        b.addScore("KMP", 301);
        b.addScore("Paul Stotts", 523);
        b.addScore("John Majikes", 550);
        assertEquals(5, b.getSize());
        assertEquals("John Majikes", b.getTopPlayer());
        assertEquals(550, b.getTopScore());

        // Adding a new score when board is at capacity should not update board
        b.addScore("Deadpool", 800);
        assertEquals(5, b.getSize());
        assertEquals(101, b.getScore("Kris Jordan"));
        assertEquals(311, b.getScore("Henry Fuchs"));
        assertEquals(301, b.getScore("KMP"));
        assertEquals(523, b.getScore("Paul Stotts"));
        assertEquals(550, b.getScore("John Majikes"));
        assertEquals("John Majikes", b.getTopPlayer());
        assertEquals(550, b.getTopScore());
    }

    @Test
    public void TestDeletingScore() {
        Scoreboard b = new Scoreboard();
        b.addScore("Paul Stotts", 523);
        b.addScore("Kris Jordan", 101);

        //
        b.deleteScore("Kris Jordan");
        assertEquals(523, b.getScore("Paul Stotts"));
        assertEquals(1, b.getSize());

        //test deleteScore multiple times
        b.deleteScore("Paul Stotts");
        assertEquals(0, b.getSize());

        // Test deleteScore invalid parameter
        try {
            b.deleteScore("Lightning McQueen");
            fail();
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    @Test
    public void topPlayerTest() {
        Leaderboard newBoard = new Scoreboard();
        //checking for no entries
        assertEquals("No current entries!", newBoard.getTopPlayer());
        //checking for one entry
        newBoard.addScore("Brent Munsell", 211);
        assertEquals("Brent Munsell", newBoard.getTopPlayer());
        newBoard.addScore("Ketan Mayer-Patel", 401);
        newBoard.addScore("Jack Snoeyink", 283);
        //checking for multiple entries
        assertEquals("Ketan Mayer-Patel", newBoard.getTopPlayer());
        newBoard.reset();
        //checking with  reset
        assertEquals("No current entries!", newBoard.getTopPlayer());
    }
    @Test
    public void topScoreTest() {
        Leaderboard newBoard = new Scoreboard();
        //checking for no entries
        assertEquals(0, newBoard.getTopScore());
        //checking for one entry
        newBoard.addScore("Brent Munsell", 211);
        assertEquals(211, newBoard.getTopScore());
        newBoard.addScore("Ketan Mayer-Patel", 401);
        newBoard.addScore("Jack Snoeyink", 283);
        //checking for multiple entries
        assertEquals(401, newBoard.getTopScore());
        newBoard.reset();
        //checking with  reset
        assertEquals(0, newBoard.getTopScore());
    }
    @Test
    public void resetTest() {
        Scoreboard newBoard = new Scoreboard();
        newBoard.addScore("Ketan Mayer-Patel", 401);
        newBoard.addScore("Jack Snoeyink", 283);
        //checking that leaderboard is not initially empty
        assertEquals(2, newBoard.getSize());
        newBoard.reset();
        //checking that TopPlayer updates
        assertEquals("No current entries!", newBoard.getTopPlayer());
        assertEquals(0, newBoard.getTopScore());
        //checking that Leaderboard is empty
        assertEquals(0, newBoard.getSize());
    }
}





