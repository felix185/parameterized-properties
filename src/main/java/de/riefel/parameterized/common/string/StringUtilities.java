package de.riefel.parameterized.common.string;

/**
 * A simple utility class for string operations.
 *
 * @author Felix Riess <felix@felix-riess.de>
 * @since 27.03.21
 */
public final class StringUtilities {

    /**
     * private constructor to hide implicit public one.
     */
    private StringUtilities() {

    }

    /**
     * Check if provided string is {@code null} or empty.
     *
     * @param str the {@link String} to be checked.
     * @return {@code true} if provided string is {@code null} or empty, {@code false} otherwise.
     */
    public static boolean isNullOrEmpty(final String str) {
        return (str == null) || (str.isEmpty());
    }
}
