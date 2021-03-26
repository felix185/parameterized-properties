package de.riefel.parameterized.reader;

import de.riefel.parameterized.common.types.AbstractAbsoluteSpreadComparableTO;

import java.util.Map;

/**
 * Interface for all line mappers.
 *
 * @author Felix Riess <felix@felix-riess.de>
 * @since 26.03.21
 * @param <T> the type to which a line should be mapped.
 */
public interface ILineMapper <T extends AbstractAbsoluteSpreadComparableTO> {

    /**
     * Maps the data of a line provided as {@link Map} with attribute name as key and attribute value as value to the type {@link T}.
     *
     * @param toBeMapped the data of a line provided as {@link Map} with attribute name as key and attribute value as value.
     * @return the mapped object as {@link T}.
     */
    T mapToTO(final Map<String, String> toBeMapped);
}
