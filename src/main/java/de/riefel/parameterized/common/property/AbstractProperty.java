package de.riefel.parameterized.common.property;

import de.riefel.parameterized.common.validation.ArgumentChecker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
    private final List<PropertyAttribute> attributes = new ArrayList<>();

    /**
     * Constructor.
     *
     * @param clazz the associated class with this property (not {@code null}).
     * @param name the name of the property (not {@code null} or empty).
     * @param attributes additional {@link PropertyAttribute}s.
     */
    protected AbstractProperty(final Class<?> clazz, final String name, final PropertyAttribute... attributes) {
        ArgumentChecker.checkNotNull(clazz, "Class");
        ArgumentChecker.checkNotEmpty(name, "Name");
        this.clazz = clazz;
        this.name = name;
        if(attributes.length > 0) {
            this.attributes.addAll(Arrays.asList(attributes));
        }
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
     * @return an {@link java.util.Iterator} over an unmodifiable list of the {@link PropertyAttribute}s.
     */
    public Iterator<PropertyAttribute> getAttributes() {
        return Collections.unmodifiableList(this.attributes).iterator();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AbstractProperty)) {
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
