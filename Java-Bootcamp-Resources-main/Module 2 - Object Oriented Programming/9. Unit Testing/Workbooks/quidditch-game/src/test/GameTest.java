package src.test;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Before;
import org.junit.Test;

import src.main.models.Game;
import src.main.models.Team;


public class GameTest {

    Game game;

    @Before
    public void setup() {
        Team home = new Team("GRYFFINDOR", "Oliver", "Harry", 
        new String[] {"Angelina", "Ginny", "Katie"});
        
        Team away = new Team("SLYTHERIN", "Vincent",  "Draco", 
        new String[] {"Bridget", "Harper", "Malcolm"});
        
        game = new Game(home, away);
    }

    @Test
    public void getPlaceholderTest() {
        assertTrue(game.getPlaceholder("<chaser> gets the next pass").equals("chaser"));
    }

    @Test
    public void replacePlaceholderTest() {
        assertTrue(game.replacePlaceholder("<chaser> gets the next pass", "chaser", "Katie").equals("Katie gets the next pass"));
    }

    @Test
    public void quaffleScoreTest() {
        Team gryf = game.getTeam("GRYFFINDOR");
        game.quaffleScore(gryf);
        game.quaffleScore(gryf);
        assertEquals(Game.getQuafflePoints()*2, game.getScore(gryf));
    }

    @Test
    public void catchSnitchTest() {
        Team slyth = game.getTeam("SLYTHERIN");
        game.catchSnitch(slyth);
        assertTrue(game.getScore(slyth) == Game.getSnitchPoints());
    }








}
