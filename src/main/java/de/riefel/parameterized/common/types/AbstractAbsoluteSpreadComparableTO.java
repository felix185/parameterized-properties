package de.riefel.parameterized.common.types;

import de.riefel.parameterized.common.property.IntegerProperty;
import de.riefel.parameterized.common.property.PropertyAttribute;

import java.io.Serializable;

/**
 * Abstract base class which implements {@link Comparable} to compare two absolute spreads.
 *
 * @author Felix Riess <felix@felix-riess.de>
 * @since 26.03.21
 */
public abstract class AbstractAbsoluteSpreadComparableTO extends AbstractTO {
    /**
     * generated serialVersionUID.
     */
    private static final long serialVersionUID = 7234615714945883566L;

    private static final IntegerProperty MIN_PROPERTY = new IntegerProperty(AbstractAbsoluteSpreadComparableTO.class, "Min", PropertyAttribute.NOT_NULLABLE, PropertyAttribute.IMMUTABLE);
    private static final IntegerProperty MAX_PROPERTY = new IntegerProperty(AbstractAbsoluteSpreadComparableTO.class, "Max", PropertyAttribute.NOT_NULLABLE, PropertyAttribute.IMMUTABLE);

    /**
     * Constructor to initialize min and max for spread comparison.
     *
     * @param min the min value.
     * @param max the max value.
     */
    protected AbstractAbsoluteSpreadComparableTO(final int min, final int max) {
        setValue(MIN_PROPERTY, min);
        setValue(MAX_PROPERTY, max);
    }

    private int getAbsoluteSpread() {
        return Math.abs(getValue(MAX_PROPERTY) - getValue(MIN_PROPERTY));
    }


}
