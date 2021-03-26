package de.riefel.parameterized.reader.factory;

import de.riefel.parameterized.common.exception.TechnicalException;
import de.riefel.parameterized.reader.IDataReader;
import de.riefel.parameterized.reader.csv.CommaSeparatedCsvReader;
import de.riefel.parameterized.reader.csv.SemicolonSeparatedCsvReader;

/**
 * A factory to get implementations of {@link IDataReader} for the requested {@link DataReaderType}.
 *
 * @author Felix Riess <felix@felix-riess.de>
 * @since 26.03.21
 */
public final class DataReaderFactory {

    // private constructor to hide implicit public one.
    private DataReaderFactory() {
        throw new TechnicalException("DataReaderFactory cannot be initialized");
    }

    /**
     * Get the specific implementation of {@link IDataReader} for the requested {@link DataReaderType}.
     *
     * @param type the {@link DataReaderType} for which an {@link IDataReader} implementation should be returned.
     * @return a specific implementation of {@link IDataReader} for the requested {@link DataReaderType}.
     */
    public static IDataReader getDataReader(final DataReaderType type) {
        switch (type) {
            case CSV_COMMA_SEPARATED:
                return new CommaSeparatedCsvReader();
            case CSV_SEMICOLON_SEPARATED:
                return new SemicolonSeparatedCsvReader();
            case XML:
            case JSON:
            default:
                throw new TechnicalException("XML and JSON readers are not yet implemented");
        }
    }
}
