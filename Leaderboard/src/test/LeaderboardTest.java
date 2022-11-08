package test;


import main.Leaderboard;
import main.LeaderboardImpl;
import org.junit.Assert;
import org.junit.Test;

public class LeaderboardTest {
    @Test
    public void testConstructor() {
        Leaderboard newBoard = new LeaderboardImpl();
        Assert.assertNotNull(newBoard);
        Assert.assertEquals(-999, newBoard.getTopScore());
        Assert.assertEquals("No current entries!", newBoard.getTopPlayer());
    }
    @Test
    public void testAddScore() {
        Leaderboard newBoard = new LeaderboardImpl();
        newBoard.addScore("Paul Stotts", 210);
        Assert.assertEquals(210, newBoard.getScore("Paul Stotts"));
        newBoard.addScore("Paul Stotts", 523);
        //Check to make sure better scores update
        Assert.assertEquals(523, newBoard.getScore("Paul Stotts"));
        LeaderboardImpl checkSize = (LeaderboardImpl) newBoard;
        Assert.assertEquals(1,checkSize.size());

        //Check to make sure lower scores don't update
        newBoard.addScore("Paul Stotts", 410);
        Assert.assertEquals(523, newBoard.getScore("Paul Stotts"));


        //Check to make sure size is updating with multiple added scores.
        newBoard.addScore("Kris Jordan", 101);
        newBoard.addScore("Henry Fuchs", 311);
        LeaderboardImpl checkSize_2 = (LeaderboardImpl) newBoard;
        Assert.assertEquals(3, checkSize_2.size());
    }
    @Test
    public void testDeleteScore() {
        Leaderboard newBoard = new LeaderboardImpl();
        newBoard.addScore("Paul Stotts", 523);
        newBoard.addScore("Kris Jordan", 101);

        //test deleteScore
        newBoard.deleteScore("Kris Jordan");
        Assert.assertEquals(523, newBoard.getScore("Paul Stotts"));
        LeaderboardImpl sizeCheck = (LeaderboardImpl) newBoard;
        Assert.assertEquals(1, sizeCheck.size());

        //test deleteScore multiple times
        newBoard.deleteScore("Paul Stotts");
        Assert.assertEquals(0, sizeCheck.size());

        //test deleteScore invalid parameter

        try {
            newBoard.deleteScore("Lightning McQueen");
        } catch (IllegalArgumentException e) {
            Assert.assertTrue(true);
        }
    }
    @Test
    public void testGetScore() {
        Leaderboard newBoard = new LeaderboardImpl();
        newBoard.addScore("Paul Stotts", 523);
        //Testing getScore method.
        Assert.assertEquals(523, newBoard.getScore("Paul Stotts"));
        newBoard.addScore("Kris Jordan", 101);
        //Testing to make sure getScore does not remove entry.
        Assert.assertEquals(523, newBoard.getScore("Paul Stotts"));
        Assert.assertEquals(101, newBoard.getScore("Kris Jordan"));

    }
    @Test
    public void testGetTopPlayer() {
        Leaderboard newBoard = new LeaderboardImpl();
        //checking for no entries
        Assert.assertEquals("No current entries!", newBoard.getTopPlayer());
        //checking for one entry
        newBoard.addScore("Brent Munsell", 211);
        Assert.assertEquals("Brent Munsell", newBoard.getTopPlayer());
        newBoard.addScore("Ketan Mayer-Patel", 401);
        newBoard.addScore("Jack Snoeyink", 283);
        //checking for multiple entries
        Assert.assertEquals("Ketan Mayer-Patel", newBoard.getTopPlayer());
        newBoard.reset();
        //checking with  reset
        Assert.assertEquals("No current entries!", newBoard.getTopPlayer());
    }
    @Test
    public void testGetTopScore() {
        Leaderboard newBoard = new LeaderboardImpl();
        //checking for no entries
        Assert.assertEquals(-999, newBoard.getTopScore());
        //checking for one entry
        newBoard.addScore("Brent Munsell", 211);
        Assert.assertEquals(211, newBoard.getTopScore());
        newBoard.addScore("Ketan Mayer-Patel", 401);
        newBoard.addScore("Jack Snoeyink", 283);
        //checking for multiple entries
        Assert.assertEquals(401, newBoard.getTopScore());
        newBoard.reset();
        //checking with  reset
        Assert.assertEquals(-999, newBoard.getTopScore());
    }
    @Test
    public void testReset() {
        Leaderboard newBoard = new LeaderboardImpl();
        newBoard.addScore("Ketan Mayer-Patel", 401);
        newBoard.addScore("Jack Snoeyink", 283);
        LeaderboardImpl checkSize = (LeaderboardImpl) newBoard;
        //checking that leaderboard is not initially empty
        Assert.assertEquals(2, checkSize.size());
        newBoard.reset();
        //checking that TopPlayer updates
        Assert.assertEquals("No current entries!", newBoard.getTopPlayer());
        Assert.assertEquals(-999, newBoard.getTopScore());
        //checking that Leaderboard is empty
        LeaderboardImpl checkSize_2 = (LeaderboardImpl) newBoard;
        Assert.assertEquals(0, checkSize_2.size());
    }
}


