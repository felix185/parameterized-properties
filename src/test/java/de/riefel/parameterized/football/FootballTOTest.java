package de.riefel.parameterized.football;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

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

    @Test
    void hashSet_twoEqualTeams_setShouldContainOnlyOne() {
        final FootballTO bayern1 = new FootballTO("Bayern München", 34, 34, 0, 0, 100, 2, 102);
        final FootballTO bayern2 = new FootballTO("Bayern München", 34, 34, 0, 0, 100, 2, 102);
        final Set<FootballTO> bayernSet = new HashSet<>();
        bayernSet.add(bayern1);
        bayernSet.add(bayern2);
        assertEquals(1, bayernSet.size());
    }
}
