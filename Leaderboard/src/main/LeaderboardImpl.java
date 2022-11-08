package main;

import java.util.HashMap;
import java.util.Map;

public class LeaderboardImpl implements Leaderboard {

    private HashMap<String, Integer> currentBoard;
    private Map.Entry<String, Integer> topPlayer;

    public LeaderboardImpl() {
        currentBoard = new HashMap<>();
        topPlayer = null;
    }
    @Override
    public void addScore(String name, int score) {
        if (currentBoard.containsKey(name)) {
            if (score > currentBoard.get(name)) {
                currentBoard.put(name, score);
            }
        } else {
            currentBoard.put(name, score);
        }
        if (currentBoard.size() == 1) {
            topPlayer = currentBoard.entrySet().iterator().next();
        } else if (score > topPlayer.getValue()) {
            HashMap<String, Integer> tempBoard = new HashMap<>();
            tempBoard.put(name,score);
            topPlayer = tempBoard.entrySet().iterator().next();
        }
    }

    @Override
    public void deleteScore(String name) {
        if (!currentBoard.containsKey(name)) {
            throw new IllegalArgumentException("Invalid player");
        }
        currentBoard.remove(name);
    }

    @Override
    public int getScore(String name) {
        return currentBoard.get(name);
    }

    @Override
    public String getTopPlayer() {
        if (currentBoard.size() == 0) {
            return "No current entries!";
        }

        return topPlayer.getKey();
    }

    @Override
    public int getTopScore() {
        if (currentBoard.size() == 0) {
            return 0;
        }

        return topPlayer.getValue();
    }

    @Override
    public void reset() {
        currentBoard = new HashMap<>();
        topPlayer = null;
    }
    public int getSize() {
        return currentBoard.size();
    }
}
