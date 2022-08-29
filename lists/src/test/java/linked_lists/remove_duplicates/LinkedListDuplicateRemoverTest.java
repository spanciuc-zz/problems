package linked_lists.remove_duplicates;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

abstract class LinkedListDuplicateRemoverTest {

    protected LinkedListDuplicateRemover listDuplicateRemover;

    public static Stream<Arguments> removeParamsProvider() {
        var arguments = new ArrayList<Arguments>();
        arguments.add(Arguments.of(new LinkedList<>(Collections.emptyList()), new LinkedList<>(Collections.emptyList())));
        arguments.add(Arguments.of(new LinkedList<>(List.of(1)), new LinkedList<>(List.of(1))));
        arguments.add(Arguments.of(new LinkedList<>(List.of(3, 2, 1)), new LinkedList<>(List.of(3, 2, 1))));
        arguments.add(Arguments.of(new LinkedList<>(List.of(3, 3, 3, 2, 2, 1)), new LinkedList<>(List.of(3, 2, 1))));
        arguments.add(Arguments.of(new LinkedList<>(List.of(3, 3, 3, 2, 2, 1, 3, 2, 1, 1, 3, 2, 2, 3, 3)), new LinkedList<>(List.of(3, 2, 1))));
        return arguments.stream();
    }

    @Test
    void removeDuplicates_whenNull_shouldThrowException() {
        assertThrows(NullPointerException.class, () -> listDuplicateRemover.remove(null));
    }

    @ParameterizedTest
    @MethodSource("removeParamsProvider")
    void remove_shouldRemoveAllDuplicates(LinkedList<Object> list, LinkedList<Object> expected) {
        var result = listDuplicateRemover.remove(list);
        assertTrue(result.containsAll(expected));
        assertEquals(result.size(), expected.size());
    }
}