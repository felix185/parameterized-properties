package de.riefel.parameterized.common.types;

import de.riefel.parameterized.common.errorhandling.exception.TechnicalException;
import de.riefel.parameterized.common.validation.ArgumentChecker;
import de.riefel.parameterized.common.errorhandling.exception.BusinessException;
import de.riefel.parameterized.common.errorhandling.ErrorCode;

import java.io.Serializable;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Set-like structure based on an array for efficient storage of arbitrary data. Extends {@link AbstractSet} for {@link AbstractSet#equals(Object)} and {@link AbstractSet#hashCode()}.
 *
 * @param <E> type of data this structure can contain. The elements <b>have to</b> properly implement {@link Comparable#compareTo(Object)},
 *            otherwise the methods {@link ArraySet#contains(Object)} and {@link ArraySet#containsAll(Collection)} will behave unreliable!
 * @author Felix Riess <felix@felix-riess.de>
 * @since 26.04.21
 */
public class ArraySet<E extends Comparable<? super E>> extends AbstractSet<E> implements Set<E>, SortedSet<E>, RandomAccess, Serializable {

    /**
     * generated serialVersionUID.
     */
    private static final long serialVersionUID = -4228833578616445570L;

    /**
     * The {@link Comparator} to use or {@code null} for natural ordering.
     */
    private final Comparator<E> comparator;

    /**
     * The element {@link ArrayList}.
     */
    private final List<E> elements = new ArrayList<>();

    /**
     * Default empty constructor.
     */
    public ArraySet() {
        this((Comparator<E>) null);
    }

    /**
     * Constructor.
     *
     * @param comparator the {@link Comparator} to use for ordering elements or {@code null} for natural ordering
     *                   (make sure the element properly implements {@link Comparable#compareTo(Object)} in this case!)
     */
    public ArraySet(final Comparator<E> comparator) {
        this.comparator = comparator;
    }

    /**
     * Constructor.
     *
     * @param elements the content of the set. The elements have to properly implement {@link Comparable#compareTo(Object)}. Duplicates are ignored. (not {@code null}).
     */
    public ArraySet(final Iterable<E> elements) {
        this(elements, null);
    }

    /**
     * Constructor.
     *
     * @param elements   the content of the set. Duplicates are ignored (not {@code null}).
     * @param comparator the {@link Comparator} to use for ordering the elements or {@code null} for natural ordering
     *                   (make sure the element properly implements {@link Comparable#compareTo(Object)} in this case!)
     */
    public ArraySet(final Iterable<E> elements, final Comparator<E> comparator) {
        ArgumentChecker.checkNotNull(elements, "Elements");
        final Set<E> unique = new TreeSet<>(comparator);
        for (final E element : elements) {
            unique.add(element);
        }
        this.comparator = comparator;
        this.elements.addAll(unique);
    }

    /**
     * Returns the index of the search key within the internal list.
     *
     * @param element the element to search for (not {@code null}).
     * @return the index of the search key, if it is contained in the list; otherwise, <tt>(-(<i>insertion point</i>) - 1)</tt>. The <i>insertion point</i> is
     * defined as the point at which the key would be inserted into the list: the index of the first element greater than the key,
     * or <tt>list.size()</tt> if all elements in the list are less than the specified key. Note that this guarantees that the return value will be {@code >= 0} if and only if the key is found.
     */
    public int getIndexOf(final E element) {
        ArgumentChecker.checkNotNull(element, "Element");
        return Collections.binarySearch(this.elements, element, this.comparator);
    }

    /**
     * Returns the element at the specified position in this {@link ArraySet}. (according to {@link #getIndexOf(Comparable)}).
     *
     * @param index index of the element to return.
     * @return the element at the specified position
     * @throws BusinessException with {@link ErrorCode#INVALID_ARGUMENT} if the index is negative or greater or equal to {@link ArraySet#size()}).
     */
    public E get(final int index) {
        ArgumentChecker.checkInterval(0, index, size(), "index");
        return this.elements.get(index);
    }

    /**
     * Removes the element at the specified position in this {@link ArraySet}. Shifts any subsequent elements to the left (subtracts one from their indices).
     *
     * @param index index of the element to be removed.
     * @return the element that was removed from the {@link ArraySet}.
     * @throws BusinessException with {@link ErrorCode#INVALID_ARGUMENT} if the index is negative or greater or equal to {@link ArraySet#size()}.
     */
    public E remove(final int index) {
        ArgumentChecker.checkInterval(0, index, size(), "index");
        return this.elements.remove(index);
    }

    /**
     * Returns {@code true} if this {@link ArraySet} contains all of the elements of the specified other {@link ArraySet}.
     *
     * @param other {@link ArraySet} to be checked for containment in this {@link ArraySet} (not {@code null}).
     * @return {@code true} if this {@link ArraySet} contains all of the elements of the specified other {@link ArraySet}, {@code false} otherwise.
     */
    public boolean containsAll(final ArraySet<E> other) {
        ArgumentChecker.checkNotNull(other, "Other");
        if (size() < other.size()) {
            return false;
        } else {
            final Iterator<E> iterator = other.iterator();
            while (iterator.hasNext()) {
                if (getIndexOf(iterator.next()) < 0) {
                    return false;
                }
            }
            return true;
        }
    }

    @Override
    public Comparator<? super E> comparator() {
        return this.comparator;
    }

    @Override
    public SortedSet<E> subSet(final E fromElement, final E toElement) {
        throw new UnsupportedOperationException("Sub sets are not supported");
    }

    @Override
    public SortedSet<E> headSet(final E toElement) {
        throw new UnsupportedOperationException("Head sets are not supported");
    }

    @Override
    public SortedSet<E> tailSet(final E fromElement) {
        throw new UnsupportedOperationException("Tail sets are not supported");
    }

    @Override
    public E first() {
        if (this.elements.isEmpty()) {
            throw new TechnicalException(ErrorCode.ILLEGAL_ACCESS, "There are no elements present");
        }
        return this.elements.get(0);
    }

    @Override
    public E last() {
        if (this.elements.isEmpty()) {
            throw new TechnicalException(ErrorCode.ILLEGAL_ACCESS, "There are no elements present");
        }
        return this.elements.get(size() - 1);
    }

    @Override
    public Iterator<E> iterator() {
        return this.elements.iterator();
    }

    @Override
    public int size() {
        return this.elements.size();
    }

    @Override
    public boolean isEmpty() {
        return this.elements.isEmpty();
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean contains(final Object o) {
        return getIndexOf((E) o) >= 0;
    }

    @Override
    public Object[] toArray() {
        return this.elements.toArray();
    }

    @Override
    public <T> T[] toArray(final T[] array) {
        return this.elements.toArray(array);
    }

    @Override
    public boolean add(final E element) {
        final int index = getIndexOf(element);
        if (index >= 0) {
            return false;
        } else {
            final int insertIndex = -index - 1;
            this.elements.add(insertIndex, element);
            return true;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean remove(final Object obj) {
        final int index = getIndexOf((E) obj);
        if (index >= 0) {
            this.elements.remove(index);
            return true;
        } else {
            return false;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean containsAll(final Collection<?> collection) {
        ArgumentChecker.checkNotNull(collection, "Collection");
        if (collection instanceof ArraySet<?>) {
            return containsAll((ArraySet<E>) collection);
        }
        return collection.stream().map(this::contains).reduce(true, (a, b) -> a && b);
    }

    @Override
    public boolean addAll(final Collection<? extends E> collection) {
        return addAll((Iterable<? extends E>) collection);
    }

    public boolean addAll(Iterable<? extends E> elements) {
        ArgumentChecker.checkNotNull(elements, "Elements");
        final Set<E> uniqueNotAlreadyAdded = new TreeSet<>();
        if (this.elements.isEmpty()) {
            // optimization if no elements are present
            for (final E element : elements) {
                uniqueNotAlreadyAdded.add(element);
            }
        } else {
            for (final E element : elements) {
                if (!contains(element)) {
                    uniqueNotAlreadyAdded.add(element);
                }
            }
        }
        if (uniqueNotAlreadyAdded.isEmpty()) {
            return false;
        }
        // insert new elements into sorted exisitng
        final Set<E> merged = new TreeSet<>(this.comparator);
        merged.addAll(this.elements);
        merged.addAll(uniqueNotAlreadyAdded);
        this.elements.clear();
        this.elements.addAll(merged);
        return true;
    }

    @Override
    public void clear() {
        this.elements.clear();
    }

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getClass().getSimpleName());
        stringBuilder.append(("[{"));
        if(!this.elements.isEmpty()) {
            int i = -1;
            for (final E element : this.elements) {
                stringBuilder.append(element == null ? "<null>" : element.toString());
                if(i < this.elements.size()) {
                    stringBuilder.append(", ");
                }
                i++;
            }
        }
        stringBuilder.append("}]");
        return stringBuilder.toString();
    }
}
