package de.riefel.parameterized.common.property;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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

    protected AbstractProperty(final Class<?> clazz, final String name, final PropertyAttribute... attributes) {
        if(clazz == null) {
            throw new IllegalArgumentException("Class must not be null");
        }
        if(name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name must not be null or empty");
        }
        this.clazz = clazz;
        this.name = name;
        if(attributes.length > 0) {
            this.attributes.addAll(Arrays.asList(attributes));
        }
    }

    /**
     * Get attributes
     *
     * @return value of attributes
     */
    public List<PropertyAttribute> getAttributes() {
        return Collections.unmodifiableList(this.attributes);
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
