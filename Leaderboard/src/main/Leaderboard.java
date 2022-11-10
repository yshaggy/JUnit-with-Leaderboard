package main;

public interface Leaderboard {

    /**
     * Add a player's name and score (0-999) to leaderboard.
     * If player is already in leaderboard, update if new score is higher than the original.
     * @param name - player name
     * @param score - player score
     */
    void addScore(String name, int score);

    /**
     * Delete a player's score from the leaderboard.
     * If player is not in leaderboard, throw an IllegalArgumentException.
     * @param name - Player Name
     */
    void deleteScore(String name);

    /**
     * Retrieve a player's score from the leaderboard.
     * If player is not in leaderboard, throw an IllegalArgumentException.
     * @param name - Player Name X
     * @return player X's score
     */
    int getScore(String name);

    /**
     * Retrieve the player with the highest score.
     * If no scores in the leaderboard, returns "No current entries!"
     * If multiple players have the highest score, returns "TIE"
     * @return top player's name
     */
    String getTopPlayer();

    /**
     * Retrieve the highest score.
     * @return top player's score
     */
    int getTopScore();

    /**
     * Reset the leaderboard.
     */
    void reset();

    /**
     * Retrieve the number of entries that are in the board (max 5).
     */
    int getSize();
}
