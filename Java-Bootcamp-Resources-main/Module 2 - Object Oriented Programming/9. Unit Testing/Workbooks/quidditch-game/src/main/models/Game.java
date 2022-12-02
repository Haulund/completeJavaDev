package src.main.models;

import java.util.HashMap;
import java.util.Random;

public class Game {
    private HashMap<Team, Integer> scoreboard;
    private static int gameCount = 0;
    private static final int QUAFFLE_POINTS = 10;
    private static final int SNITCH_POINTS = 150;

    public static int getQuafflePoints() {
        return QUAFFLE_POINTS;
    }

    public static int getSnitchPoints() {
        return SNITCH_POINTS;
    }

    public Game(Team home, Team away){
        this.scoreboard = new HashMap<Team, Integer>();
        scoreboard.put(new Team(home), 0);
        scoreboard.put(new Team(away), 0);
        gameCount++;
    }

    public int getScore(Team team) {
        return scoreboard.get(team);
    }

    public void setScore(Team team, Integer score) {
        scoreboard.put(team, score);
    }

    public Team getTeam(String name) {
        return this.scoreboard.keySet().stream()
        .filter(key -> key.getHouse().equals(name))
        .findFirst()
        .orElse(null);
    }

    public static int getGameCount() {
        return gameCount;
    }

    public String getPlaceholder(String play) {
        return play.substring(play.indexOf("<") + 1, play.indexOf(">"));
    }

    public String replacePlaceholder(String play, String placeholder, String Value) {
        return play.replace("<"+placeholder+">", Value);
    }

    public void quaffleScore(Team team) {
        int currentScore = this.getScore(team); 
        this.setScore(new Team(team), currentScore + QUAFFLE_POINTS);
    }

    public void catchSnitch(Team team) {
        int currentScore = this.getScore(team); 
        this.setScore(new Team(team), currentScore + SNITCH_POINTS);
    }

    ///// ************** DU ER IGANG MED TASK 7 + 8

    public Team getRandoTeam() {
        Object[] array = scoreboard.keySet().toArray();
        return game.getTeam()
    }

    public int random(int range) {
        int number = (int)Math.random()*range;
        return number;
    }

    public void simulate(String play) {
        getPlaceholder(play);
    }
}
