package com.pantifik.problems.strings.unique;

import static org.junit.jupiter.api.Assertions.*;

class TestUniqueCharsUsingBinaryInsertionTest extends TestUniqueCharsTest {

  @Override
  protected TestUniqueChars getImplementation() {
    return new TestUniqueCharsUsingBinaryInsertion();
  }


}