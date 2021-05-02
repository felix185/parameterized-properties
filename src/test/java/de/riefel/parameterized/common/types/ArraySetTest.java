package de.riefel.parameterized.common.types;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Felix Riess <felix@felix-riess.de>
 * @since 30.04.21
 */
public class ArraySetTest {

    @Test
    void createSetAndFindElements_ok_shouldCreateAndFindElements() {
        final String bayernMunich = "Bayern München";
        final String dortmund = "Borussia Dortmund";
        final TestTO bayern = new TestTO(bayernMunich);
        final TestTO bvb = new TestTO(dortmund);
        final TestTO anotherBayern = new TestTO(bayernMunich);
        final List<TestTO> input = Arrays.asList(bayern, bvb, anotherBayern);
        final ArraySet<TestTO> arraySet = new ArraySet<>(input);
        assertEquals(2, arraySet.size());
        assertEquals(bayern, arraySet.first());
        assertEquals(bvb, arraySet.last());
        assertTrue(arraySet.containsAll(Arrays.asList(bayern, bvb)));
    }

    @Test
    void addElements_ok_shouldAddOrNotAddElements() {
        final String bayernMunich = "Bayern München";
        final String dortmund = "Borussia Dortmund";
        final TestTO bayern = new TestTO(bayernMunich);
        final TestTO bvb = new TestTO(dortmund);
        final List<TestTO> input = Arrays.asList(bayern, bvb);
        final ArraySet<TestTO> arraySet = new ArraySet<>(input);
        assertFalse(arraySet.add(bayern));
        final TestTO berlin = new TestTO("Berlin");
        assertTrue(arraySet.add(berlin));
        assertEquals(1, arraySet.getIndexOf(berlin));
        final TestTO freiburg = new TestTO("Freiburg");
        final TestTO anotherBayern = new TestTO(bayernMunich);
        final TestTO gladbach = new TestTO("Gladbach");
        final List<TestTO> toBeAdded = Arrays.asList(gladbach, freiburg, anotherBayern);
        assertTrue(arraySet.addAll(toBeAdded));
        assertEquals(5, arraySet.size());
        // bayern, berlin, dortmund, freiburg, gladbach
        assertEquals(0, arraySet.getIndexOf(bayern));
        assertEquals(1, arraySet.getIndexOf(berlin));
        assertEquals(2, arraySet.getIndexOf(bvb));
        assertEquals(3, arraySet.getIndexOf(freiburg));
        assertEquals(4, arraySet.getIndexOf(gladbach));
    }

    @Test
    void clearEleemnts_ok_shouldClearElements() {
        final String bayernMunich = "Bayern München";
        final String dortmund = "Borussia Dortmund";
        final TestTO bayern = new TestTO(bayernMunich);
        final TestTO bvb = new TestTO(dortmund);
        final List<TestTO> input = Arrays.asList(bayern, bvb);
        final ArraySet<TestTO> arraySet = new ArraySet<>(input);
        assertFalse(arraySet.isEmpty());
        arraySet.clear();
        assertTrue(arraySet.isEmpty());
    }
}
