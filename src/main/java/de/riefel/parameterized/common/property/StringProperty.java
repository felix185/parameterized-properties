package de.riefel.parameterized.common.property;

import de.riefel.parameterized.common.validation.ArgumentChecker;

import java.util.regex.Pattern;

/**
 * Parameterized property type for {@link String} values.
 *
 * @author Felix Riess <felix@felix-riess.de>
 * @since 26.03.21
 */
public class StringProperty extends AbstractProperty {
    private final Pattern pattern;
    private final int minLength;
    private final int maxLength;

    /**
     * Constructor.
     *
     * @param clazz      the associated class of this property (not {@code null}).
     * @param name       the name of the property (not {@code null} or empty).
     * @param isCompared {@code true} if property should be used for {@link Comparable#compareTo(Object)}, {@code false} otherwise.
     * @param pattern    a specific RegEx pattern (may be {@code null}).
     * @param minLength  the min length of the attribute ({@code minLength <= maxLength}).
     * @param maxLength  the max length of the attribute ({@code minLength <= maxLength}).
     * @param attributes additional {@link PropertyAttribute}s.
     */
    public StringProperty(final Class<?> clazz, final String name, final boolean isCompared, final Pattern pattern, final int minLength,
                          final int maxLength, PropertyAttribute... attributes) {
        super(clazz, name, isCompared, attributes);
        ArgumentChecker.checkIsTrue(minLength <= maxLength, "MinLength {} is greater than MaxLength {}", minLength, maxLength);
        this.pattern = pattern;
        this.minLength = minLength;
        this.maxLength = maxLength;
    }

    /**
     * Constructor.
     * Property will not be used for {@link Comparable#compareTo(Object)}.
     *
     * @param clazz      the associated class of this property (not {@code null}).
     * @param name       the name of the property (not {@code null} or empty).
     * @param pattern    a specific RegEx pattern (may be {@code null}).
     * @param minLength  the min length of the attribute ({@code minLength <= maxLength}).
     * @param maxLength  the max length of the attribute ({@code minLength <= maxLength}).
     * @param attributes additional {@link PropertyAttribute}s.
     */
    public StringProperty(final Class<?> clazz, final String name, final Pattern pattern, final int minLength,
                          final int maxLength, PropertyAttribute... attributes) {
        this(clazz, name, false, pattern, minLength, maxLength, attributes);
    }

    /**
     * Get pattern
     *
     * @return value of pattern (may be {@code null}).
     */
    public Pattern getPattern() {
        return this.pattern;
    }

    /**
     * Get minLength
     *
     * @return value of minLength
     */
    public int getMinLength() {
        return this.minLength;
    }

    /**
     * Get maxLength
     *
     * @return value of maxLength
     */
    public int getMaxLength() {
        return this.maxLength;
    }
}
