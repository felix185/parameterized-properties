package de.riefel.parameterized.reader.csv;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Felix Riess <felix@felix-riess.de>
 * @since 27.03.21
 */
public class SemicolonSeparatedCsvReaderTest {

    private SemicolonSeparatedCsvReader underTest = new SemicolonSeparatedCsvReader();

    @Test
    void readLinesFromFile_withValidAndInvalidLines_shouldReturnValidLines() {
        final String pathToFile = "src/test/resources/de/riefel/test_semicolon.csv";
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
}
