package de.riefel.parameterized.reader.csv;

import de.riefel.parameterized.common.exception.TechnicalException;
import de.riefel.parameterized.reader.AbstractDataReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Abstract class to read data from CSV files.
 *
 * @author Felix Riess <felix@felix-riess.de>
 * @since 26.03.21
 */
public abstract class AbstractCsvReader extends AbstractDataReader {

    /**
     * @return the CSV separator like ',' or ';'.
     */
    protected abstract String getCsvSeparator();

    @Override
    protected List<Map<String, String>> readLinesFromFile(final String pathToFile) {
        final List<String> header = new ArrayList<>();
        final List<Map<String, String>> lines = new ArrayList<>();
        int count = 0;
        try(final BufferedReader reader = new BufferedReader(new FileReader(pathToFile, StandardCharsets.UTF_8))) {
            String line;
            while((line = reader.readLine()) != null) {
                final List<String> currentLineSplit = Arrays.asList(line.split(getCsvSeparator()));
                if(count == 0) {
                    // headline
                    header.addAll(currentLineSplit);
                } else {
                    if(currentLineSplit.size() != header.size()) {
                        System.out.println("Line has other size than header. Line is ignored");
                    } else {
                        final Map<String, String> lineAsMap = new HashMap<>();
                        for(int i = 0; i < currentLineSplit.size(); i++) {
                            lineAsMap.put(header.get(i), currentLineSplit.get(i));
                        }
                        lines.add(lineAsMap);
                    }
                }
                count++;
            }
        } catch(final IOException ex) {
            ex.printStackTrace();
            throw new TechnicalException("Error reading CSV", ex);
        }
        return lines;
    }
}
