package de.riefel.parameterized.common.types;

import java.io.Serializable;

/**
 * Abstract base class which implements {@link Comparable} to compare two absolute spreads.
 *
 * @author Felix Riess <felix@felix-riess.de>
 * @since 26.03.21
 */
public abstract class AbstractAbsoluteSpreadComparableTO extends AbstractTO implements Comparable<AbstractAbsoluteSpreadComparableTO>, Serializable {
    /**
     * generated serialVersionUID.
     */
    private static final long serialVersionUID = 7234615714945883566L;

    private final int min;
    private final int max;

    /**
     * Constructor to initialize min and max for spread comparison.
     *
     * @param min the min value.
     * @param max the max value.
     */
    protected AbstractAbsoluteSpreadComparableTO(final int min, final int max) {
        this.min = min;
        this.max = max;
    }

    private int getAbsoluteSpread() {
        return Math.abs(this.max - this.min);
    }

    @Override
    public int compareTo(AbstractAbsoluteSpreadComparableTO other) {
        return Integer.compare(getAbsoluteSpread(), other.getAbsoluteSpread());
    }

    @Override
    public abstract int hashCode();

    @Override
    public abstract boolean equals(Object o);

    @Override
    public abstract String toString();
}
