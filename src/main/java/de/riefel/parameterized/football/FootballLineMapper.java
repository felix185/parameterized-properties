package de.riefel.parameterized.football;

import de.riefel.parameterized.common.logging.ILogger;
import de.riefel.parameterized.common.validation.ArgumentChecker;
import de.riefel.parameterized.reader.AbstractLineMapper;

import java.util.Map;

/**
 * Maps a line of football data to actual {@link FootballTO}. Extends {@link AbstractLineMapper} for utility methods.
 *
 * @author Felix Riess <felix@felix-riess.de>
 * @since 26.03.21
 */
public class FootballLineMapper extends AbstractLineMapper<FootballTO> {

    private static final ILogger LOG = ILogger.getLogger(FootballLineMapper.class);

    static final String TEAM_KEY = "Team";
    static final String GAMES_KEY = "Games";
    static final String WINS_KEY = "Wins";
    static final String LOSSES_KEY = "Losses";
    static final String DRAWS_KEY = "Draws";
    static final String GOALS_KEY = "Goals";
    static final String GOALS_ALLOWED_KEY = "Goals Allowed";
    static final String POINTS_KEY = "Points";

    @Override
    public FootballTO mapToTO(final Map<String, String> toBeMapped) {
        ArgumentChecker.checkInterval(8, toBeMapped.size(), 9, "Line length");
        final String team = getStringPropertyOrFail(toBeMapped, TEAM_KEY);
        final int games = getIntPropertyOrFail(toBeMapped, GAMES_KEY);
        final int wins = getIntPropertyOrFail(toBeMapped, WINS_KEY);
        final int losses = getIntPropertyOrFail(toBeMapped, LOSSES_KEY);
        final int draws = getIntPropertyOrFail(toBeMapped, DRAWS_KEY);
        final int goals = getIntPropertyOrFail(toBeMapped, GOALS_KEY);
        final int goalsAllowed = getIntPropertyOrFail(toBeMapped, GOALS_ALLOWED_KEY);
        final int points = getIntPropertyOrFail(toBeMapped, POINTS_KEY);
        return new FootballTO(team, games, wins, losses, draws, goals, goalsAllowed, points);
    }
}
