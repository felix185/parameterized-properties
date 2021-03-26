package de.riefel.parameterized.common.exception;

/**
 * Exception to represent business errors.
 *
 * @author Felix Riess <felix@felix-riess.de>
 * @since 26.03.21
 */
public class BusinessException extends RuntimeException {
    /**
     * generated serialVersionUID.
     */
    private static final long serialVersionUID = 2452607317328560174L;

    /**
     * Constructor.
     *
     * @param message the message to be used for the exception.
     */
    public BusinessException(final String message) {
        super(message);
    }
}
