package de.riefel.parameterized.common.errorhandling.exception;

import de.riefel.parameterized.common.errorhandling.ExceptionUtils;
import de.riefel.parameterized.common.errorhandling.IErrorCode;
import de.riefel.parameterized.common.errorhandling.ReferenceCodeGenerator;
import de.riefel.parameterized.common.logging.ILogger;

/**
 * Base exception to be extended by each exception.
 *
 * @author Felix Riess <felix@felix-riess.de>
 * @since 27.03.21
 */
abstract class BaseException extends RuntimeException {
    /**
     * generated serialVersionUID.
     */
    private static final long serialVersionUID = 3476934297255914619L;
    /**
     * The {@link ILogger} to be used.
     */
    private static final ILogger LOG = ILogger.getLogger(BaseException.class);
    /**
     * The {@link IErrorCode} of this exception.
     */
    private final IErrorCode errorCode;
    /**
     * The reference code of this exception.
     */
    private final String referenceCode;

    /**
     * Constructor.
     *
     * @param errorCode the {@link IErrorCode} of this exception.
     * @param message the error message of this exception as {@link String}.
     */
    BaseException(final IErrorCode errorCode, final String message) {
        super(getFormattedErrorCode(errorCode) + ": " + message);
        this.errorCode = errorCode;
        this.referenceCode = ReferenceCodeGenerator.generateReferenceCode();
        LOG.error("{}: {}", getFormattedErrorCode(errorCode), message);
        LOG.info("Generated reference code for exception with error code '{}' is: '{}'", getFormattedErrorCode(errorCode), this.referenceCode);
    }

    /**
     * Constructor.
     *
     * @param errorCode the {@link IErrorCode} of this exception.
     * @param cause the {@link Throwable} of this exception.
     */
    BaseException(final IErrorCode errorCode, final Throwable cause) {
        this(errorCode, ExceptionUtils.convertStacktraceToString(cause));
    }

    /**
     * Constructor.
     *
     * @param errorCode the {@link IErrorCode} of this exception.
     * @param message the error message of this exception as {@link String}.
     * @param cause the {@link Throwable} of this exception.
     */
    BaseException(final IErrorCode errorCode, final String message, final Throwable cause) {
        this(errorCode, message + System.lineSeparator() + ExceptionUtils.convertStacktraceToString(cause));
    }

    /**
     * Get the {@link IErrorCode} of this exception.
     *
     * @return the {@link IErrorCode} of this exception.
     */
    public IErrorCode getErrorCode() {
        return this.errorCode;
    }

    /**
     * Get the reference code of this exception.
     *
     * @return the reference code.
     */
    public String getReferenceCode() {
        return this.referenceCode;
    }

    /**
     * Formats the given {@link IErrorCode} to a human readable {@link String}.
     *
     * @param errorCode the {@link IErrorCode} to format.
     * @return the formatted {@link String}.
     */
    private static String getFormattedErrorCode(final IErrorCode errorCode) {
        return "[" + errorCode.getErrorCategory() + "] " + errorCode.getDescription();
    }
}
