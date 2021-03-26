package de.riefel.parameterized.common.property;

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

    public StringProperty(final Class<?> clazz, final String name, final Pattern pattern, final int minLength,
                          final int maxLength, PropertyAttribute...attributes) {
        super(clazz, name, attributes);
        this.pattern = pattern;
        if(minLength > maxLength) {
            throw new IllegalArgumentException("MinLength must not be greater than MaxLength");
        }
        this.minLength = minLength;
        this.maxLength = maxLength;
    }

    /**
     * Get pattern
     *
     * @return value of pattern
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
