package de.riefel.parameterized.common.types;

import de.riefel.parameterized.common.property.DoubleProperty;
import de.riefel.parameterized.common.property.IntegerProperty;
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
    private final Map<IntegerProperty, Integer> integerProperties = new HashMap<>();
    private final Map<DoubleProperty, Double> doubleProperties = new HashMap<>();

    protected Double getValue(final DoubleProperty property) {
        ArgumentChecker.checkNotNull(property, "Property");
        return this.doubleProperties.get(property);
    }

    protected void setValue(final DoubleProperty property, final Double value) {
        ArgumentChecker.checkNotNull(property, "Property");
        final Double currentValue = this.doubleProperties.get(property);
        validateProperties(property.getAttributes(), property.getName(), currentValue, value);
        if (value != null) {
            ArgumentChecker.checkIntervalUpperBoundIncluded(property.getMinValue(), value, property.getMaxValue(), property.getName());
        }
        this.doubleProperties.compute(property, (k, v) -> value);
    }

    protected Integer getValue(final IntegerProperty property) {
        ArgumentChecker.checkNotNull(property, "Property");
        return this.integerProperties.get(property);
    }

    protected void setValue(final IntegerProperty property, final Integer value) {
        ArgumentChecker.checkNotNull(property, "Property");
        final Integer currentValue = this.integerProperties.get(property);
        validateProperties(property.getAttributes(), property.getName(), currentValue, value);
        if (value != null) {
            ArgumentChecker.checkIntervalUpperBoundIncluded(property.getMinValue(), value, property.getMaxValue(), property.getName());
        }
        this.integerProperties.compute(property, (k, v) -> value);
    }

    protected String getValue(final StringProperty property) {
        ArgumentChecker.checkNotNull(property, "Property");
        return this.stringProperties.get(property);
    }

    protected void setValue(final StringProperty property, final String value) {
        ArgumentChecker.checkNotNull(property, "Property");
        final String currentValue = this.stringProperties.get(property);
        validateProperties(property.getAttributes(), property.getName(), currentValue, value);
        if (value != null) {
            ArgumentChecker.checkIntervalUpperBoundIncluded(property.getMinLength(), value.length(), property.getMaxLength(), property.getName() + " length");
            if (property.getPattern() != null) {
                final String pattern = property.getPattern().pattern();
                ArgumentChecker.checkIsTrue(value.matches(pattern), "Value {} does not match pattern {}", value, pattern);
            }
        }
        this.stringProperties.compute(property, (k, v) -> value);
    }

    private <T> void validateProperties(final Iterator<PropertyAttribute> attributes, final String propertyName, final T currentValue, final T newValue) {
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

    @Override
    public int hashCode() {
        int result = 0;
        for (final String stringProperty : this.stringProperties.values()) {
            result = 31 * result + (stringProperty != null ? stringProperty.hashCode() : 0);
        }
        for (final Integer integerProperty : this.integerProperties.values()) {
            result = 31 * result + (integerProperty != null ? integerProperty : 0);
        }
        for (final Double doubleProperty : this.doubleProperties.values()) {
            if (doubleProperty == null) {
                result = 31 * result;
            } else {
                long temp = Double.doubleToLongBits(doubleProperty);
                result = 31 * result + (int) (temp ^ (temp >>> 32));
            }
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AbstractTO)) {
            return false;
        }
        final AbstractTO that = (AbstractTO) o;
        if (this.stringProperties.size() != that.stringProperties.size()) {
            return false;
        }
        if (this.integerProperties.size() != that.integerProperties.size()) {
            return false;
        }
        if (this.doubleProperties.size() != that.doubleProperties.size()) {
            return false;
        }
        for (Map.Entry<StringProperty, String> stringPropertyEntry : this.stringProperties.entrySet()) {
            final String thatString = that.stringProperties.get(stringPropertyEntry.getKey());
            final String thisString = stringPropertyEntry.getValue();
            if (thisString != null) {
                if (thatString == null) {
                    return false;
                } else if (!thisString.equals(thatString)) {
                    return false;
                }
            } else {
                if (thatString != null) {
                    return false;
                }
            }
        }
        for (Map.Entry<IntegerProperty, Integer> integerPropertyEntry : this.integerProperties.entrySet()) {
            final Integer thatInt = that.integerProperties.get(integerPropertyEntry.getKey());
            final Integer thisInt = integerPropertyEntry.getValue();
            if (thisInt != null) {
                if (thatInt == null) {
                    return false;
                } else if (!thisInt.equals(thatInt)) {
                    return false;
                }
            } else {
                if (thatInt != null) {
                    return false;
                }
            }
        }

        for (Map.Entry<DoubleProperty, Double> doublePropertyEntry : this.doubleProperties.entrySet()) {
            final Double thatDouble = that.doubleProperties.get(doublePropertyEntry.getKey());
            final Double thisDouble = doublePropertyEntry.getValue();
            if (thisDouble != null) {
                if (thatDouble == null) {
                    return false;
                } else if (!thisDouble.equals(thatDouble)) {
                    return false;
                }
            } else {
                if (thatDouble != null) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public abstract String toString();
}
