package de.riefel.parameterized.reader;

import de.riefel.parameterized.common.errorhandling.exception.BusinessException;
import de.riefel.parameterized.common.logging.ILogger;
import de.riefel.parameterized.common.types.AbstractAbsoluteSpreadComparableTO;
import de.riefel.parameterized.common.types.ArraySet;
import de.riefel.parameterized.common.validation.ArgumentChecker;

import java.util.Collection;
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

    private static final ILogger LOG = ILogger.getLogger(AbstractDataReader.class);

    @Override
    public <T extends AbstractAbsoluteSpreadComparableTO> ArraySet<T> readData(String pathToFile, ILineMapper<T> lineMapper) {
        ArgumentChecker.checkNotEmpty(pathToFile, "Path to file");
        ArgumentChecker.checkNotNull(lineMapper, "Line mapper");
        final Collection<T> lines = readLinesFromFile(pathToFile).stream().map(line -> {
            try {
                return lineMapper.mapToTO(line);
            } catch (BusinessException ex) {
                LOG.warn("Cannot convert line to TO: {}", ex.getMessage());
                return null;
            }
        }).filter(o -> o!=null).collect(Collectors.toList());
        return new ArraySet<>(lines);
    }

    /**
     * Read the content of the specified file.
     *
     * @param pathToFile the path to the file to be read.
     * @return a {@link List} of all lines. Each line as {@link Map} with attribute name as key and attribute value as value.
     */
    protected abstract List<Map<String, String>> readLinesFromFile(final String pathToFile);
}
