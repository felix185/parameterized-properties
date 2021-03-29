package de.riefel.parameterized.football;

import de.riefel.parameterized.common.property.IntegerProperty;
import de.riefel.parameterized.common.property.PropertyAttribute;
import de.riefel.parameterized.common.property.StringProperty;
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

    private static final StringProperty TEAM_PROPERTY = new StringProperty(FootballTO.class, "Team", null, 1, Integer.MAX_VALUE, PropertyAttribute.NOT_NULLABLE, PropertyAttribute.IMMUTABLE);
    private static final IntegerProperty GAMES_PROPERTY = new IntegerProperty(FootballTO.class, "Games", 0, Integer.MAX_VALUE, PropertyAttribute.NOT_NULLABLE, PropertyAttribute.IMMUTABLE);
    private static final IntegerProperty WINS_PROPERTY = new IntegerProperty(FootballTO.class, "Wins", 0, Integer.MAX_VALUE, PropertyAttribute.NOT_NULLABLE, PropertyAttribute.IMMUTABLE);
    private static final IntegerProperty LOSSES_PROPERTY = new IntegerProperty(FootballTO.class, "Losses", 0, Integer.MAX_VALUE, PropertyAttribute.NOT_NULLABLE, PropertyAttribute.IMMUTABLE);
    private static final IntegerProperty DRAWS_PROPERTY = new IntegerProperty(FootballTO.class, "Draws", 0, Integer.MAX_VALUE, PropertyAttribute.NOT_NULLABLE, PropertyAttribute.IMMUTABLE);
    private static final IntegerProperty GOALS_PROPERTY = new IntegerProperty(FootballTO.class, "Goals", 0, Integer.MAX_VALUE, PropertyAttribute.NOT_NULLABLE, PropertyAttribute.IMMUTABLE);
    private static final IntegerProperty GOALS_ALLOWED_PROPERTY = new IntegerProperty(FootballTO.class, "Goals allowed", 0, Integer.MAX_VALUE, PropertyAttribute.NOT_NULLABLE, PropertyAttribute.IMMUTABLE);
    private static final IntegerProperty POINTS_PROPERTY = new IntegerProperty(FootballTO.class, "Points", 0, Integer.MAX_VALUE, PropertyAttribute.NOT_NULLABLE, PropertyAttribute.IMMUTABLE);

    public FootballTO(final String team, final int games, final int wins, final int losses, final int draws,
                      final int goals, final int goalsAllowed, final int points) {
        super(goals, goalsAllowed);
        setValue(TEAM_PROPERTY, team);
        setValue(GAMES_PROPERTY, games);
        setValue(WINS_PROPERTY, wins);
        setValue(LOSSES_PROPERTY, losses);
        setValue(DRAWS_PROPERTY, draws);
        setValue(GOALS_PROPERTY, goals);
        setValue(GOALS_ALLOWED_PROPERTY, goalsAllowed);
        setValue(POINTS_PROPERTY, points);
    }

    /**
     * Get team
     *
     * @return value of team
     */
    public String getTeam() {
        return getValue(TEAM_PROPERTY);
    }

    /**
     * Get games
     *
     * @return value of games
     */
    public int getGames() {
        return getValue(GAMES_PROPERTY);
    }

    /**
     * Get wins
     *
     * @return value of wins
     */
    public int getWins() {
        return getValue(WINS_PROPERTY);
    }

    /**
     * Get losses
     *
     * @return value of losses
     */
    public int getLosses() {
        return getValue(LOSSES_PROPERTY);
    }

    /**
     * Get draws
     *
     * @return value of draws
     */
    public int getDraws() {
        return getValue(DRAWS_PROPERTY);
    }

    /**
     * Get goals
     *
     * @return value of goals
     */
    public int getGoals() {
        return getValue(GOALS_PROPERTY);
    }

    /**
     * Get goalsAllowed
     *
     * @return value of goalsAllowed
     */
    public int getGoalsAllowed() {
        return getValue(GOALS_ALLOWED_PROPERTY);
    }

    /**
     * Get points
     *
     * @return value of points
     */
    public int getPoints() {
        return getValue(POINTS_PROPERTY);
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
        if (this.getGames() != that.getGames()) {
            return false;
        }
        if (this.getWins() != that.getWins()) {
            return false;
        }
        if (this.getLosses() != that.getLosses()) {
            return false;
        }
        if (this.getDraws() != that.getDraws()) {
            return false;
        }
        if (this.getGoals() != that.getGoals()) {
            return false;
        }
        if (this.getGoalsAllowed() != that.getGoalsAllowed()) {
            return false;
        }
        if (this.getPoints() != that.getPoints()) {
            return false;
        }
        return this.getTeam() != null ? this.getTeam().equals(that.getTeam()) : that.getTeam() == null;
    }

    @Override
    public String toString() {
        return "FootballTO{" +
                "team='" + this.getTeam() + '\'' +
                ", games=" + this.getGames() +
                ", wins=" + this.getWins() +
                ", losses=" + this.getLosses() +
                ", draws=" + this.getDraws() +
                ", goals=" + this.getGoals() +
                ", goalsAllowed=" + this.getGoalsAllowed() +
                ", points=" + this.getPoints() +
                '}';
    }
}
