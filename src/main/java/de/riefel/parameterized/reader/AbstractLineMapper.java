package de.riefel.parameterized.reader;

import de.riefel.parameterized.common.types.AbstractAbsoluteSpreadComparableTO;
import de.riefel.parameterized.common.validation.ArgumentChecker;

import java.util.Map;

/**
 * Abstract base class for line mappers with utility methods to extract values from key-value maps based on {@link String}s.
 *
 * @author Felix Riess <felix@felix-riess.de>
 * @since 26.03.21
 */
public abstract class AbstractLineMapper<T extends AbstractAbsoluteSpreadComparableTO> implements ILineMapper<T> {

    protected int getIntPropertyOrFail(final Map<String, String> line, final String key) {
        final String value = getStringPropertyOrFail(line, key);
        return Integer.parseInt(value);
    }

    protected double getDoublePropertyOrFail(final Map<String, String> line, final String key) {
        final String value = getStringPropertyOrFail(line, key);
        return Double.parseDouble(value);
    }

    protected String getStringPropertyOrFail(final Map<String, String> line, final String key) {
        final String value = line.get(key);
        ArgumentChecker.checkNotNull(value, "Value for key " + key);
        return value;
    }
}
