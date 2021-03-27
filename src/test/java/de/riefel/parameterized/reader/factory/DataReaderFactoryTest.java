package de.riefel.parameterized.reader.factory;

import de.riefel.parameterized.common.exception.TechnicalException;
import de.riefel.parameterized.reader.IDataReader;
import de.riefel.parameterized.reader.csv.CommaSeparatedCsvReader;
import de.riefel.parameterized.reader.csv.SemicolonSeparatedCsvReader;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Felix Riess <felix@felix-riess.de>
 * @since 27.03.21
 */
public class DataReaderFactoryTest {

    @Test
    void getDataReader_allTypes_shouldReturnReaderImplementation() {
        IDataReader reader = DataReaderFactory.getDataReader(DataReaderType.CSV_COMMA_SEPARATED);
        assertTrue(reader instanceof CommaSeparatedCsvReader);
        reader = DataReaderFactory.getDataReader(DataReaderType.CSV_SEMICOLON_SEPARATED);
        assertTrue(reader instanceof SemicolonSeparatedCsvReader);
        assertThrows(TechnicalException.class, () -> DataReaderFactory.getDataReader(DataReaderType.XML));
        assertThrows(TechnicalException.class, () -> DataReaderFactory.getDataReader(DataReaderType.JSON));
    }
}
