package linked_lists.remove_duplicates;

import java.util.LinkedList;
import java.util.Objects;

public class WithoutUsingAdditionalSpace implements LinkedListDuplicateRemover {
    @Override
    public LinkedList<Object> remove(LinkedList<Object> list) {

        Objects.requireNonNull(list);
        var iterator = list.listIterator();
        while (iterator.hasNext()) {
            var currentElement = iterator.next();
            var nextIndex = iterator.nextIndex();
            for (int i = nextIndex; i < list.size(); i++) {
                if (Objects.equals(currentElement, list.get(i))) {
                    iterator.remove();
                    break;
                }
            }
        }

        return list;

    }
}
