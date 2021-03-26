package de.riefel.parameterized.reader;

import de.riefel.parameterized.common.exception.BusinessException;
import de.riefel.parameterized.common.types.AbstractAbsoluteSpreadComparableTO;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Abstract base implementation to read data from a file and map it to suitable objects.
 *
 * @author Felix Riess <felix@felix-riess.de>
 * @since 26.03.21
 */
public abstract class AbstractDataReader implements IDataReader {

    @Override
    public <T extends AbstractAbsoluteSpreadComparableTO> List<T> readData(String pathToFile, ILineMapper<T> lineMapper) {
        if(pathToFile == null || pathToFile.isEmpty()) {
            System.out.println("Path to file is null or empty");
            throw new BusinessException("Path to file is null or empty");
        }
        if(lineMapper == null) {
            System.out.println("Line mapper is null");
            throw new BusinessException("Line mapper is null");
        }
        return readLinesFromFile(pathToFile).stream().map(lineMapper::mapToTO).collect(Collectors.toList());
    }

    /**
     * Read the content of the specified file.
     *
     * @param pathToFile the path to the file to be read.
     * @return a {@link List} of all lines. Each line as {@link Map} with attribute name as key and attribute value as value.
     */
    protected abstract List<Map<String, String>> readLinesFromFile(final String pathToFile);
}
