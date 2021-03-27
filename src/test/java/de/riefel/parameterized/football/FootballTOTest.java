package de.riefel.parameterized.football;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Felix Riess <felix@felix-riess.de>
 * @since 27.03.21
 */
public class FootballTOTest {

    @Test
    void compareTo_twoTeams_shouldReturnTeamWithSmallerGoalSpread() {
        final FootballTO bayern = new FootballTO("Bayern München", 34, 34, 0, 0, 100, 2, 102);
        final FootballTO dortmund = new FootballTO("Borussia Dortmund", 34, 32, 2, 0, 99, 3, 96);
        assertEquals(1, bayern.compareTo(dortmund));
    }
}
