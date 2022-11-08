package main;

public interface Leaderboard {

    /**
     * Method should add a player's name and score to Leaderboard
     * @param name - Player Name
     * @param score - Player Score
     */
    void addScore(String name, int score);

    /**
     * Method should delete a player's score from the Leaderboard. If Player is not in Leaderboard, should throw an Illegal Argument Exception.
     * @param name - Player Name
     */
    void deleteScore(String name);

    /**
     * Method should retrieve a player's score based on their name.
     * @param name - Player Name X
     * @return player X's score
     */
    int getScore(String name);

    /**
     * Method should retrieve the player with the high score. Default is "No current entries!"
     * @return the player with the high score
     */
    String getTopPlayer();

    /**
     * Method should retrieve the high score of the Leaderboard.
     * @return the high score
     */
    int getTopScore();

    /**
     * Method should reset the Leaderboard.
     */

    void reset();
}
