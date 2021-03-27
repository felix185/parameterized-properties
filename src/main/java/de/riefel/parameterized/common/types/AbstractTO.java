package de.riefel.parameterized.common.types;

import de.riefel.parameterized.common.property.StringProperty;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Abstract base transport object for all other transport objects.
 *
 * @author Felix Riess <felix@felix-riess.de>
 * @since 27.03.21
 */
public abstract class AbstractTO implements Serializable {
    /**
     * generated serialVersionUID.
     */
    private static final long serialVersionUID = 6957221635679729861L;

    private Map<StringProperty, String> stringProperties = new HashMap<>();

    protected String getValue(final StringProperty property) {
        return stringProperties.get(property);
    }

    protected void setValue(final StringProperty property, final String value) {
        final int minLength = property.getMinLength();
        if (value.length() < minLength) {
        }
        final String currentValue = stringProperties.get(property);

    }
}
