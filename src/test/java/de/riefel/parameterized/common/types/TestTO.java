package de.riefel.parameterized.common.types;

import de.riefel.parameterized.common.property.PropertyAttribute;
import de.riefel.parameterized.common.property.StringProperty;
import org.junit.jupiter.api.Test;

/**
 * A transport object for unit tests.
 *
 * @author Felix Riess <felix@felix-riess.de>
 * @since 27.03.21
 */
public class TestTO extends AbstractTO {
    /**
     * generated serialVersionUID.
     */
    private static final long serialVersionUID = 1670728636069734461L;

    private static final StringProperty TEAM = new StringProperty(TestTO.class, "Team", true,null, 1, Integer.MAX_VALUE, PropertyAttribute.IMMUTABLE, PropertyAttribute.NOT_NULLABLE);
    private static final StringProperty RIVAL = new StringProperty(TestTO.class, "Rival", null, 1, Integer.MAX_VALUE);

    // would usually not exist as team is a not-nullable field and must be instantiated.
    TestTO() {

    }

    TestTO(final String team) {
        setValue(TEAM, team);
    }

    public String getTeam() {
        return getValue(TEAM);
    }

    public void setTeam(final String team) {
        setValue(TEAM, team);
    }

    public String getRival() {
        return getValue(RIVAL);
    }

    public void setRival(final String rival) {
        setValue(RIVAL, rival);
    }

    @Override
    public String toString() {
        return "TestTO{" +
                "team='" + this.getTeam() + '\'' +
                ", rival=" + this.getRival() +
                '}';
    }
}
