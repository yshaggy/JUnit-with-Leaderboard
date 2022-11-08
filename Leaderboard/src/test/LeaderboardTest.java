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
        Assert.assertEquals(523, newBoard.getScore("Paul Stotts"));
        newBoard.addScore("Kris Jordan", 101);
        Assert.assertEquals(101, newBoard.getScore("Kris Jordan"));
        newBoard.addScore("Paul Stotts", 401);
        Assert.assertEquals(523, newBoard.getScore("Paul Stotts"));
    }
    @Test
    public void testDeleteScore() {
        Leaderboard newBoard = new LeaderboardImpl();
        newBoard.addScore("Paul Stotts", 523);
        Assert.assertEquals(523, newBoard.getScore("Paul Stotts"));
        newBoard.addScore("Kris Jordan", 101);
        //Testing to make sure getScore does not remove entry.
        Assert.assertEquals(523, newBoard.getScore("Paul Stotts"));
        Assert.assertEquals(101, newBoard.getScore("Kris Jordan"));
    }
    @Test
    public void testGetScore() {
        Leaderboard newBoard = new LeaderboardImpl();
        newBoard.addScore("Paul Stotts", 523);
        Assert.assertEquals(523, newBoard.getScore("Paul Stotts"));
        newBoard.addScore("Kris Jordan", 101);
        //Testing to make sure getScore does not remove entry.
        Assert.assertEquals(523, newBoard.getScore("Paul Stotts"));
        Assert.assertEquals(101, newBoard.getScore("Kris Jordan"));
    }
    @Test
    public void testGetTopPlayer() {}
    @Test
    public void testGetTopScore() {}
    @Test
    public void testReset() {}
}


