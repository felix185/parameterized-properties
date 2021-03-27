package de.riefel.parameterized.common.errorhandling.exception;

import de.riefel.parameterized.common.errorhandling.IErrorCode;

/**
 * Exception for all business errors.
 *
 * @author Felix Riess <felix@felix-riess.de>
 * @since 27.03.21
 */
public class BusinessException extends BaseException {
    /**
     * generated serialVersionUID.
     */
    private static final long serialVersionUID = 2835714592683077283L;

    /**
     * Generates a new {@link BusinessException}.
     *
     * @param errorCode the {@link IErrorCode} of this exception.
     * @param message the error message of this exception as {@link String}.
     */
    public BusinessException(final IErrorCode errorCode, final String message) {
        super(errorCode, message);
    }

    /**
     * Generates a new {@link BusinessException}.
     *
     * @param errorCode the {@link IErrorCode} of this exception.
     * @param cause the {@link Throwable} of this exception.
     */
    public BusinessException(final IErrorCode errorCode, final Throwable cause) {
        super(errorCode, cause);
    }

    /**
     * Generates a new {@link BusinessException}.
     *
     * @param errorCode the {@link IErrorCode} of this exception.
     * @param message the error message of this exception as {@link String}
     * @param cause the {@link Throwable} of this exception.
     */
    public BusinessException(final IErrorCode errorCode, final String message, final Throwable cause) {
        super(errorCode, message, cause);
    }
}
