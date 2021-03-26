package de.riefel.parameterized.football;

import de.riefel.parameterized.common.types.AbstractAbsoluteSpreadComparableTO;

/**
 * Transport object representing the football data.
 * Extends {@link AbstractAbsoluteSpreadComparableTO} for {@link AbstractAbsoluteSpreadComparableTO#compareTo(AbstractAbsoluteSpreadComparableTO)}.
 *
 * @author Felix Riess <felix@felix-riess.de>
 * @since 26.03.21
 */
public class FootballTO extends AbstractAbsoluteSpreadComparableTO{
    /**
     * generated serialVersionUID.
     */
    private static final long serialVersionUID = 875069962018384368L;

    private final String team;
    private final int games;
    private final int wins;
    private final int losses;
    private final int draws;
    private final int goals;
    private final int goalsAllowed;
    private final int points;

    public FootballTO(final String team, final int games, final int wins, final int losses, final int draws,
                      final int goals, final int goalsAllowed, final int points) {
        super(goals, goalsAllowed);
        this.team = team;
        this.games = games;
        this.wins = wins;
        this.losses = losses;
        this.draws = draws;
        this.goals = goals;
        this.goalsAllowed = goalsAllowed;
        this.points = points;
    }

    /**
     * Get team
     *
     * @return value of team
     */
    public String getTeam() {
        return this.team;
    }

    /**
     * Get games
     *
     * @return value of games
     */
    public int getGames() {
        return this.games;
    }

    /**
     * Get wins
     *
     * @return value of wins
     */
    public int getWins() {
        return this.wins;
    }

    /**
     * Get losses
     *
     * @return value of losses
     */
    public int getLosses() {
        return this.losses;
    }

    /**
     * Get draws
     *
     * @return value of draws
     */
    public int getDraws() {
        return this.draws;
    }

    /**
     * Get goals
     *
     * @return value of goals
     */
    public int getGoals() {
        return this.goals;
    }

    /**
     * Get goalsAllowed
     *
     * @return value of goalsAllowed
     */
    public int getGoalsAllowed() {
        return this.goalsAllowed;
    }

    /**
     * Get points
     *
     * @return value of points
     */
    public int getPoints() {
        return this.points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof FootballTO)) {
            return false;
        }
        FootballTO that = (FootballTO) o;
        if (this.games != that.games) {
            return false;
        }
        if (this.wins != that.wins) {
            return false;
        }
        if (this.losses != that.losses) {
            return false;
        }
        if (this.draws != that.draws) {
            return false;
        }
        if (this.goals != that.goals) {
            return false;
        }
        if (this.goalsAllowed != that.goalsAllowed) {
            return false;
        }
        if (this.points != that.points) {
            return false;
        }
        return this.team != null ? this.team.equals(that.team) : that.team == null;
    }

    @Override
    public int hashCode() {
        int result = this.team != null ? this.team.hashCode() : 0;
        result = 31 * result + this.games;
        result = 31 * result + this.wins;
        result = 31 * result + this.losses;
        result = 31 * result + this.draws;
        result = 31 * result + this.goals;
        result = 31 * result + this.goalsAllowed;
        result = 31 * result + this.points;
        return result;
    }

    @Override
    public String toString() {
        return "FootballTO{" +
                "team='" + this.team + '\'' +
                ", games=" + this.games +
                ", wins=" + this.wins +
                ", losses=" + this.losses +
                ", draws=" + this.draws +
                ", goals=" + this.goals +
                ", goalsAllowed=" + this.goalsAllowed +
                ", points=" + this.points +
                '}';
    }
}
