package src.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

import src.main.models.Team;

public class TeamTest {
    @Test
    public void hasNullTest() {
        assertTrue(Team.hasNull(new String[] {null, "Ginny", "Katie"}));
    }

    @Test
    public void hasBlankTest() {
        assertTrue(Team.hasblank(new String[] {"    ", "Ginny", "Katie"}));
    }

}
