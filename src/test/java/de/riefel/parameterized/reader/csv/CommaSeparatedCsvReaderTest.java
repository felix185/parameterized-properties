package de.riefel.parameterized.reader.csv;

import de.riefel.parameterized.common.errorhandling.exception.BusinessException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author Felix Riess <felix@felix-riess.de>
 * @since 27.03.21
 */
public class CommaSeparatedCsvReaderTest {

    private final CommaSeparatedCsvReader underTest = new CommaSeparatedCsvReader();

    @Test
    void readLinesFromFile_withValidAndInvalidLines_shouldReturnValidLines() {
        final String pathToFile = "src/test/resources/de/riefel/parameterized/test_comma.csv";
        final Map<String, String> firstLine = new HashMap<>();
        firstLine.put("eins", "vier");
        firstLine.put("zwei", "fünf");
        firstLine.put("drei", "sechs");
        final Map<String, String> secondLine = new HashMap<>();
        secondLine.put("eins", "sieben");
        secondLine.put("zwei", "acht");
        secondLine.put("drei", "neun");
        final List<Map<String, String>> expected = Arrays.asList(firstLine, secondLine);
        final List<Map<String, String>> actual = underTest.readLinesFromFile(pathToFile);
        assertEquals(expected, actual);
    }

    @Test
    void readFromFile_invalidArgs_shouldThrowBusinessException() {
        assertThrows(BusinessException.class, () -> underTest.readData(null, toBeMapped -> null));
        assertThrows(BusinessException.class, () -> underTest.readData("", toBeMapped -> null));
        assertThrows(BusinessException.class, () -> underTest.readData("any", null));
    }
}
