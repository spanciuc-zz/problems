package linked_lists.remove_duplicates;

import org.junit.jupiter.api.BeforeEach;

class WithoutUsingAdditionalSpaceTest extends LinkedListDuplicateRemoverTest {

    @BeforeEach
    void setUp() {
        this.listDuplicateRemover = new WithoutUsingAdditionalSpace();
    }

}