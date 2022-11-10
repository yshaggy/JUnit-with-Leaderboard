# JUnit-with-Leaderboard

## Set Up
* Clone this repository into your local IDE (IntelliJ-IDEA or Eclipse).
* To run all JUnit tests in the `LeadershipBoard` test class:
  * click the green double-play button to the left of the class name
* To run an individual JUnit test:
  * click the green play button to the left of the test method signature

## Starter Code
If you would like to start from a blank template, we have a `Leaderboard` interface you can implement in regular Java code.
* Create a file in the `.main` folder to implement a `YourClass` class!
  * To rename this file (and all its references), right-click on the file and select `Refactor` > `Rename`.
  * Check the boxes for renaming tests, variables, and inheritors at minimum.
* Refer to the interface code comments for class logic!
* You can write helper methods or structure your code however you normally do. 

If you don't want the extra practice of reviewing Java code syntax and **skip straight to exploring JUnit**, we've provided a solution class that implements the `Leaderboard` interface for you (`Scoreboard`).

## Brainstorming
If you want to create JUnit tests from scratch, here are some things you should consider while brainstorming what to test for!

1. Initialization
   * What should the initial state of my program be?

2. Use Cases
   * What should happen when I add/delete/reset scores normally?
   * Does the top player score update correctly in these use cases?

3. Edge Cases
   * What about adding a score when the board is full (capacity 5)?
   * Updating a player's score?
   * Deleting a score for a player that doesn't exist? Deleting when there are no players left?

4. Fill in the gaps! (What else could you be missing?)

## Coding in JUnit
Go to the `YourTest` class in the `.test` folder, where we've set up a template test class for you!
Feel free to write test for either the `Scoreboard` class and/or `YourClass`.
The `ScoreboardTest` class contains fully written tests for you to play around with!

If you skipped the brainstorming phase, here is a guided list of features/functionality to test:
1. Initialization
   * Check that the initial program state is one where:
     * the scoreboard has 0 entries
     * retrieving the top player returns "No current entries!"
     * retrieving the top score returns 0

2. Use Cases
   * When using normally, you should be able to:
     * Successfully add distinct, valid scores for distinct players (up to 5)
     * Get the correct top player's name and score
     * Get the correct score for another random player
     * Add a new score to the same player and have it update the existing entry correctly
     * Successfully delete distinct players' scores
     * Reset the board, which will return the program to its initial state

3. Edge Cases
   * When attempting to break the program, you should _not_ be able to:
     * Add a score with an invalid parameter (score < 0, score > 999, or player name as `""` or `null`)
     * Add more than 5 distinct score entries
     * Delete more than 5 distinct score entries
     * Delete a score entry for a nonexistent player
     * Get a score entry for a nonexistent player
     * Have more than one score logged for a single player
     * Reset the board and have top player & score not reset as well

4. Fill in the gaps!
   * When two players have the same score, top player name should display as "TIE"
   * If the current top player's score gets deleted, the top player name and score need to be updated accordingly
   * If all score entries are deleted from the board, the program state should be the same as the intiial state
   * See if you can think of any more cases to cover!



