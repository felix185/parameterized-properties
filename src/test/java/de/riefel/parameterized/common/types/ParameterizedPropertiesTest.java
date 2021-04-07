package de.riefel.parameterized.common.types;

import de.riefel.parameterized.common.errorhandling.exception.BusinessException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author Felix Riess <felix@felix-riess.de>
 * @since 27.03.21
 */
public class ParameterizedPropertiesTest {

    private static final String GOOD_TEAM = "Bayern München";
    private static final String INVALID_TEAM = "1860 München";
    private static final String RIVAL = "Borussia Dortmund";

    @Test
    void init_ok_shouldReturnTeam() {
        final TestTO testTeam = new TestTO(GOOD_TEAM);
        assertEquals(GOOD_TEAM, testTeam.getTeam());
    }

    @Test
    void init_noTeam_setShouldBePossible() {
        final TestTO testTeam = new TestTO();
        testTeam.setTeam(GOOD_TEAM);
        assertEquals(GOOD_TEAM, testTeam.getTeam());
        assertThrows(BusinessException.class, () -> testTeam.setTeam(INVALID_TEAM));
    }

    @Test
    void init_withTeam_setShouldThrowException() {
        final TestTO testTeam = new TestTO(GOOD_TEAM);
        assertThrows(BusinessException.class, () -> testTeam.setTeam(INVALID_TEAM));
    }

    @Test
    void init_invalidTeam_shouldThrowBusinessException() {
        assertThrows(BusinessException.class, () -> new TestTO(null));
        assertThrows(BusinessException.class, () -> new TestTO(""));
    }

    @Test
    void setAndReplaceRival_shouldReturnCurrentRival() {
        final TestTO testTeam = new TestTO(GOOD_TEAM);
        assertNull(testTeam.getRival());
        testTeam.setRival(INVALID_TEAM);
        assertEquals(INVALID_TEAM, testTeam.getRival());
        assertEquals(GOOD_TEAM, testTeam.getTeam());
        testTeam.setRival(null);
        assertNull(testTeam.getRival());
        assertEquals(GOOD_TEAM, testTeam.getTeam());
        testTeam.setRival(RIVAL);
        assertEquals(RIVAL, testTeam.getRival());
        assertEquals(GOOD_TEAM, testTeam.getTeam());
    }

    @Test
    void compareTo_bayernVsDortmund_shouldReturnBayern() {
        final TestTO bayern = new TestTO(GOOD_TEAM);
        final TestTO dortmund = new TestTO(RIVAL);
        assertEquals(1, bayern.compareTo(dortmund));
    }

    @Test
    void equals_twoClasses_shouldReturnFalse() {
        final TestTO test = new TestTO();
        final AnotherTestTO anotherTest = new AnotherTestTO();
        assertNotEquals(test, anotherTest);
    }
}
