package de.riefel.parameterized.common.types;

import de.riefel.parameterized.common.property.PropertyAttribute;
import de.riefel.parameterized.common.property.StringProperty;
import de.riefel.parameterized.common.validation.ArgumentChecker;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
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

    private final Map<StringProperty, String> stringProperties = new HashMap<>();

    protected String getValue(final StringProperty property) {
        ArgumentChecker.checkNotNull(property, "Property");
        return this.stringProperties.get(property);
    }

    protected void setValue(final StringProperty property, final String value) {
        ArgumentChecker.checkNotNull(property, "Property");
        final String currentValue = this.stringProperties.get(property);
        validateProperties(property.getAttributes(), property.getName(), currentValue, value);
        if(value != null) {
            ArgumentChecker.checkIntervalUpperBoundIncluded(property.getMinLength(), value.length(), property.getMaxLength(), property.getName() + " length");
        }
        if (property.getPattern() != null) {
            final String pattern = property.getPattern().pattern();
            ArgumentChecker.checkIsTrue(value.matches(pattern), "Value {} does not match pattern {}", value, pattern);
        }
        this.stringProperties.compute(property, (k, v) -> value);
    }

    private void validateProperties(final Iterator<PropertyAttribute> attributes, final String propertyName, final Object currentValue, final Object newValue) {
        while (attributes.hasNext()) {
            final PropertyAttribute attribute = attributes.next();
            switch (attribute) {
                case NOT_NULLABLE:
                    ArgumentChecker.checkNotNull(newValue, propertyName);
                    break;
                case IMMUTABLE:
                    ArgumentChecker.checkIsTrue(currentValue == null, "Property {} has already a value ({}) and is immutable", propertyName, currentValue);
                    break;
            }
        }
    }
}
