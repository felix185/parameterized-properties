package de.riefel.parameterized.reader;

import de.riefel.parameterized.common.types.AbstractAbsoluteSpreadComparableTO;
import de.riefel.parameterized.common.types.ArraySet;

import java.util.List;

/**
 * Interface for all types of data readers.
 *
 * @author Felix Riess <felix@felix-riess.de>
 * @since 26.03.21
 */
public interface IDataReader {

    /**
     * Read the data from the specified path and return the data as {@link List} of {@link T}.
     *
     * @param pathToFile the path to the file which should be read (not {@code null}).
     * @param lineMapper the lineMapper which should be used to map a line to a object of type {@link T} (not {@code null}).
     * @param <T> the type to be returned (must extend {@link AbstractAbsoluteSpreadComparableTO}.
     * @return a {@link List} of the valid data.
     */
    <T extends AbstractAbsoluteSpreadComparableTO> ArraySet<T> readData(final String pathToFile, final ILineMapper<T> lineMapper);
}
