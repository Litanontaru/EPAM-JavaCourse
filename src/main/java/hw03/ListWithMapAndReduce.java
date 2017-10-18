package hw03;

import hw02.ListWithIgnoredElements;
import hw03.function.BinaryOperator;
import hw03.function.Function;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ListWithMapAndReduce<E> extends ListWithIgnoredElements<E> {
    public ListWithMapAndReduce(Collection<? extends E> collection, Collection<? extends E> ignoredElements) {
        super(collection, ignoredElements);
    }

    public <R> List<R> map(Function<E,R> mapper) {
        List<R> mappedList = new ListWithMapAndReduce<>(Collections.emptyList(), Collections.emptyList());
        for (E element : this) {
            mappedList.add(mapper.apply(element));
        }
        return mappedList;
    }

    public E reduce(BinaryOperator<E> accumulator) {
        E result = null;
        Iterator<E> itr = this.iterator();
        if (!itr.hasNext()) {
            return result;
        }
        result = itr.next();
        while (itr.hasNext()) {
            result = accumulator.apply(result, itr.next());
        }
        return result;
    }
}
