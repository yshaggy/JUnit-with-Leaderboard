package main;

import java.util.HashMap;
import java.util.Map;

public class Scoreboard implements Leaderboard {

    private HashMap<String, Integer> board;
    private String topPlayer;
    private int topScore;

    public Scoreboard() {
        reset();
    }

    @Override
    public void addScore(String name, int score) {
        if (score < 0 || score > 999 || name == null || name.equals("")) {
            throw new IllegalArgumentException("Invalid score entry!");
        }
        if (getSize() < 5 && score >= board.getOrDefault(name, 0)) {
            board.put(name, score);
        }
        updateTopPlayer();
    }

    @Override
    public void deleteScore(String name) {
        if (!board.containsKey(name)) {
            throw new IllegalArgumentException("Cannot delete score for invalid player");
        }
        board.remove(name);
        updateTopPlayer();
    }

    // Simple way to update program state, since hashmap since never goes above 5 entries
    private void updateTopPlayer() {
        if (getSize() == 0) {
            topPlayer = "No current entries!";
            topScore = 0;
            return;
        }

        // Reset to default values, in case the previous top player + score were deleted
        topPlayer = "";
        topScore = 0;

        for (Map.Entry<String, Integer> e : board.entrySet()) {
            if (e.getValue() > topScore) {
                topPlayer = e.getKey();
                topScore = e.getValue();
            }
            // Uncomment below for a fully functional class
            /**
            else if (e.getValue() == topScore) {
                topPlayer = "TIE";
            }
             */
        }
    }

    @Override
    public int getScore(String name) {
        if (!board.containsKey(name)) {
            throw new IllegalArgumentException("Cannot get score for invalid player");
        }
        return board.get(name);
    }

    @Override
    public String getTopPlayer() {
        return topPlayer;
    }

    @Override
    public int getTopScore() {
        return topScore;
    }

    @Override
    public void reset() {
        board = new HashMap<>();
        topPlayer = "No current entries!";
        topScore = 0;
    }

    @Override
    public int getSize() {
        return board.size();
    }
}
