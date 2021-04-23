package de.riefel.parameterized.common.property;

import de.riefel.parameterized.common.validation.ArgumentChecker;

import java.util.Iterator;
import java.util.List;

/**
 * Abstract base class for parameterized properties which implements {@link #hashCode()} and {@link #equals(Object)}.
 *
 * @author Felix Riess <felix@felix-riess.de>
 * @since 26.03.21
 */
public abstract class AbstractProperty {

    private final Class<?> clazz;
    private final String name;
    private final List<PropertyAttribute> attributes;
    private final boolean isCompared;

    /**
     * Constructor.
     *
     * @param clazz      the associated class with this property (not {@code null}).
     * @param name       the name of the property (not {@code null} or empty).
     * @param isCompared {@code true} if property should be used for {@link Comparable#compareTo(Object)}, {@code false} otherwise.
     * @param attributes additional {@link PropertyAttribute}s.
     */
    protected AbstractProperty(final Class<?> clazz, final String name, final boolean isCompared, final PropertyAttribute... attributes) {
        ArgumentChecker.checkNotNull(clazz, "Class");
        ArgumentChecker.checkNotEmpty(name, "Name");
        this.clazz = clazz;
        this.name = name;
        this.isCompared = isCompared;
        this.attributes = List.of(attributes);
    }

    /**
     * Get name
     *
     * @return value of name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Get an iterator over an unmodifiable list of the {@link PropertyAttribute}s
     *
     * @return an {@link Iterator} over an unmodifiable list of the {@link PropertyAttribute}s.
     */
    public Iterator<PropertyAttribute> getAttributes() {
        return this.attributes.iterator();
    }

    /**
     * Get isCompared
     *
     * @return value of isCompared
     */
    public boolean isCompared() {
        return this.isCompared;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (getClass() != o.getClass()) {
            return false;
        }
        AbstractProperty that = (AbstractProperty) o;
        if (!this.clazz.equals(that.clazz)) {
            return false;
        }
        return this.name.equals(that.name);
    }

    @Override
    public int hashCode() {
        int result = this.clazz.hashCode();
        result = 31 * result + this.name.hashCode();
        return result;
    }
}
