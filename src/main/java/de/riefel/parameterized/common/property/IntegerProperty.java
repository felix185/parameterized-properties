package de.riefel.parameterized.common.property;

import de.riefel.parameterized.common.validation.ArgumentChecker;

/**
 * Parameterized property for {@link Integer} types.
 *
 * @author Felix Riess <felix@felix-riess.de>
 * @since 29.03.21
 */
public class IntegerProperty extends AbstractProperty {

    private final int minValue;
    private final int maxValue;

    /**
     * Constructor.
     *
     * @param clazz the associated class of this property (not {@code null}).
     * @param name the name of the property (not {@code null} or empty).
     * @param minValue the min value of the attribute ({@code minValue <= maxValue}).
     * @param maxValue the max value of the attribute ({@code minValue <= minValue}).
     * @param attributes additional {@link PropertyAttribute}s.
     */
    public IntegerProperty(final Class<?> clazz, final String name, final int minValue, final int maxValue, final PropertyAttribute...attributes) {
        super(clazz, name, attributes);
        ArgumentChecker.checkIsTrue(minValue<=maxValue, "Min value {} is greater than max value {}", minValue, maxValue);
        this.maxValue = maxValue;
        this.minValue = minValue;
    }

    /**
     * Constructor. Sets minValue to {@link Integer#MIN_VALUE} and maxValue to {@link Integer#MAX_VALUE}.
     *
     * @param clazz the associated class of this property (not {@code null}).
     * @param name the name of the property (not {@code null} or empty).
     * @param attributes additional {@link PropertyAttribute}s.
     */
    public IntegerProperty(final Class<?> clazz, final String name, final PropertyAttribute...attributes) {
        this(clazz, name, Integer.MIN_VALUE, Integer.MAX_VALUE, attributes);
    }

    /**
     * Get minValue
     *
     * @return value of minValue
     */
    public int getMinValue() {
        return this.minValue;
    }

    /**
     * Get maxValue
     *
     * @return value of maxValue
     */
    public int getMaxValue() {
        return this.maxValue;
    }
}
