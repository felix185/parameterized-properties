package de.riefel.parameterized.common.exception;

/**
 * Exception for all technical errors.
 *
 * @author Felix Riess <felix@felix-riess.de>
 * @since 26.03.21
 */
public class TechnicalException extends RuntimeException {
    /**
     * generated serialVersionUID.
     */
    private static final long serialVersionUID = -8542498123445664180L;

    /**
     * Constructor.
     *
     * @param message the message to be used for this exception.
     */
    public TechnicalException(final String message) {
        super(message);
    }

    /**
     * Constructor.
     *
     * @param message the message to be used for this exception.
     * @param throwable the cause as {@link Throwable}.
     */
    public TechnicalException(final String message, final Throwable throwable) {
        super(message, throwable);
    }
}
