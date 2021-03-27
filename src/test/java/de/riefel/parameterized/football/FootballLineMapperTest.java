package de.riefel.parameterized.football;

import de.riefel.parameterized.common.errorhandling.exception.BusinessException;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author Felix Riess <felix@felix-riess.de>
 * @since 27.03.21
 */
public class FootballLineMapperTest {

    private FootballLineMapper underTest = new FootballLineMapper();

    @Test
    void mapToTO_invalidArgs_shouldThrowBusinessException() {
        final Map<String, String> invalidLength = new HashMap<>();
        invalidLength.put("bla", "bla");
        assertThrows(BusinessException.class, () -> underTest.mapToTO(invalidLength));
        final Map<String, String> invalidKey = new HashMap<>();
        invalidKey.put("bla", "bla");
        invalidKey.put("foo", "foo");
        invalidKey.put("bar", "bar");
        invalidKey.put("lorem", "ipsum");
        invalidKey.put("dolorem", "sit");
        invalidKey.put("ipsum", "lorem");
        invalidKey.put("sit", "dolorem");
        invalidKey.put("unit", "test");
        assertThrows(BusinessException.class, () -> underTest.mapToTO(invalidKey));
    }

    @Test
    void mapToTO_valid_shouldReturnExpectedFootballData() {
        final String team = "FC Bayern";
        final int wins = 34;
        final int losses = 0;
        final int draws = 0;
        final int goals = 100;
        final int goalsAllowed = 2;
        final int points = 102;
        final int games = 34;
        final FootballTO expected = new FootballTO(team, games, wins, losses, draws, goals, goalsAllowed, points);
        final Map<String, String> line = new HashMap<>();
        line.put(FootballLineMapper.TEAM_KEY, team);
        line.put(FootballLineMapper.POINTS_KEY, String.valueOf(points));
        line.put(FootballLineMapper.GOALS_ALLOWED_KEY, String.valueOf(goalsAllowed));
        line.put(FootballLineMapper.GOALS_KEY, String.valueOf(goals));
        line.put(FootballLineMapper.DRAWS_KEY, String.valueOf(draws));
        line.put(FootballLineMapper.LOSSES_KEY, String.valueOf(losses));
        line.put(FootballLineMapper.WINS_KEY, String.valueOf(wins));
        line.put(FootballLineMapper.GAMES_KEY, String.valueOf(games));
        final FootballTO actual = underTest.mapToTO(line);
        assertEquals(expected, actual);
    }
}
