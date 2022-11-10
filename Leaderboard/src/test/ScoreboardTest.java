package test;

import main.Scoreboard;
import static org.junit.Assert.*;
import org.junit.Test;

public class ScoreboardTest {

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
        b.addScore("Player One", 101);
        assertEquals(101, b.getScore("Player One"));
        assertEquals(1, b.getSize());

        b.addScore("Player Two", 300);
        assertEquals(300, b.getScore("Player Two"));
        assertEquals(2, b.getSize());
    }

    @Test
    public void TestAddingInvalidScore() {
        Scoreboard b = new Scoreboard();
        boolean threwCorrectly = false;

        // Null name
        try {
            b.addScore(null, 85);
        } catch (IllegalArgumentException iae) {
            threwCorrectly = true;
        }
        if (!threwCorrectly) {
            fail("Name cannot be null");
        }

        // "" name
        threwCorrectly = false;
        try {
            b.addScore("", 567);
        } catch (IllegalArgumentException iae) {
            threwCorrectly = true;
        }
        if (!threwCorrectly) {
            fail("Name cannot be an empty string");
        }

        // Score < 0
        threwCorrectly = false;
        try {
            b.addScore("Goku", -7);
        } catch (IllegalArgumentException iae) {
            threwCorrectly = true;
        }
        if (!threwCorrectly) {
            fail("Score cannot be negative");
        }

        // Score > 999
        threwCorrectly = false;
        try {
            b.addScore("Goku", 9001);
        } catch (IllegalArgumentException iae) {
            threwCorrectly = true;
        }
        if (!threwCorrectly) {
            fail("It's over 9000!!! (But also, socre cannot be > 999)");
        }
    }

    @Test
    public void TestRetrievingScoreInvalidPlayer() {
        Scoreboard b = new Scoreboard();
        b.addScore("Paul Stotts",523);

        try {
            b.getScore("Paul Stoots");
            fail();
        } catch (IllegalArgumentException iae) {
            assertTrue(true);
        }
    }

    @Test
    public void TestAddingScoreSamePlayer() {
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
    public void TestAddingSameScore() {
        Scoreboard b = new Scoreboard();
        b.addScore("Sibling 1", 98);
        b.addScore("Sibling 2", 98);

        assertEquals("TIE", b.getTopPlayer());
        assertEquals(98, b.getTopScore());
    }

    @Test
    public void TestDeletingScore() {
        Scoreboard b = new Scoreboard();

        b.addScore("Cybermen", 10);
        b.addScore("The Doctor", 11);
        b.deleteScore("Cybermen");
        assertEquals(1, b.getSize());
        assertEquals(11, b.getScore("The Doctor"));
    }

    @Test
    public void TestDeletingScoreInvalidPlayer() {
        Scoreboard b = new Scoreboard();
        boolean threwCorrectly = false;

        // Deleting from empty scoreboard
        try {
            b.deleteScore("Lightning McQueen");
        } catch (IllegalArgumentException iae) {
            threwCorrectly = true;
        }
        if (!threwCorrectly) {
            fail("Cannot delete scores from an empty board");
        }

        threwCorrectly = true;
        b.addScore("Lightning McQueen", 95);

        // Deleting with invalid player
        try {
            b.deleteScore("Lighting Queen");
        } catch (IllegalArgumentException iae) {
            threwCorrectly = true;
        } finally {
            assertTrue(threwCorrectly);
        }
    }

    @Test
    public void TestDeletingTopScore() {
        Scoreboard b = new Scoreboard();
        b.addScore("Half the Universe's Population", 999);
        b.addScore("Avengers", 997);
        b.addScore("Thanos", 998);

        b.deleteScore("Half the Universe's Population");
        assertEquals("Thanos", b.getTopPlayer());
        assertEquals(998, b.getTopScore());

        b.deleteScore("Thanos");
        assertEquals("Avengers", b.getTopPlayer());
        assertEquals(997, b.getTopScore());
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

        b.deleteScore("Paul Stotts");
        b.deleteScore("John Majikes");
        b.deleteScore("KMP");
        b.deleteScore("Kris Jordan");
        b.deleteScore("Henry Fuchs");

        assertEquals("No current entries!", b.getTopPlayer());
        assertEquals(0, b.getTopScore());
        assertEquals(0, b.getSize());
    }

    @Test
    public void TestResetBoard() {
        Scoreboard b = new Scoreboard();
        b.addScore("KMP", 301);
        b.addScore("Jack Snoeyink", 283);
        assertEquals(2, b.getSize());

        b.reset();
        assertEquals("No current entries!", b.getTopPlayer());
        assertEquals(0, b.getTopScore());
        assertEquals(0, b.getSize());

        // Try to reset again, expect the same results
        b.reset();
        assertEquals("No current entries!", b.getTopPlayer());
        assertEquals(0, b.getTopScore());
        assertEquals(0, b.getSize());
    }

}





