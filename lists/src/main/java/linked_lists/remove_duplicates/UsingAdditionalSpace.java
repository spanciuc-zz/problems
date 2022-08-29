package linked_lists.remove_duplicates;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;

public class UsingAdditionalSpace implements LinkedListDuplicateRemover {

    public UsingAdditionalSpace() {
    }

    public LinkedList<Object> remove(LinkedList<Object> list) {
        Objects.requireNonNull(list);
        var hashSet = new HashSet<>();
        list.removeIf(o -> !hashSet.add(o));
        return list;
    }
}
