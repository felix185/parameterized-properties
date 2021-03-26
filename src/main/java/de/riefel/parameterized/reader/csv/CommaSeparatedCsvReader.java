package de.riefel.parameterized.reader.csv;

/**
 * CSV reader for comma separated CSV files.
 *
 * @author Felix Riess <felix@felix-riess.de>
 * @since 26.03.21
 */
public class CommaSeparatedCsvReader extends AbstractCsvReader {

    private static final String CSV_SEPARATOR = ",";

    @Override
    protected String getCsvSeparator() {
        return CSV_SEPARATOR;
    }
}
