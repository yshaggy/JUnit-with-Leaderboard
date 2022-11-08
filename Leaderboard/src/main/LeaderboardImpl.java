package main;

import java.util.HashMap;
import java.util.Map;

public class LeaderboardImpl implements Leaderboard {

    private HashMap<String, Integer> currentBoard;
    private Map.Entry<String, Integer> topPlayer = null;

    public LeaderboardImpl() {
        currentBoard = new HashMap<>();

    }
    @Override
    public void addScore(String name, int score) {
        if (currentBoard.containsKey(name)) {
            if (currentBoard.get(name) > score) {
                return;
            }
        }
        currentBoard.put(name, score);
        updateTopPlayer();
    }

    @Override
    public void deleteScore(String name) {
        currentBoard.remove(name);
    }

    @Override
    public int getScore(String name) {
        return currentBoard.get(name);
    }
    private void updateTopPlayer(){
        for (Map.Entry<String, Integer> a : currentBoard.entrySet()) {
            if (topPlayer == null) {
                topPlayer = a;
            } else if (a.getValue() > topPlayer.getValue()) {
                topPlayer = a;
            }
        }
    }
    @Override
    public String getTopPlayer() {
        if (currentBoard.size() == 0) {
            return "No current entries!";
        }
        //updateTopPlayer();
        return topPlayer.getKey();
    }

    @Override
    public int getTopScore() {
        if (currentBoard.size() == 0) {
            return -999;
        }

        return topPlayer.getValue();
    }

    @Override
    public void reset() {
        currentBoard = new HashMap<>();
        topPlayer = null;
    }
}
