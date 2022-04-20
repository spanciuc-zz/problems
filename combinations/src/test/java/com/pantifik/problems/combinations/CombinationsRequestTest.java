package com.pantifik.problems.combinations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class CombinationsRequestTest {

  @ParameterizedTest
  @NullAndEmptySource
  void constructor1Params_whenInvalidList_shouldThrowException(List<?> of) {
    assertThrows(IllegalArgumentException.class,
        () -> new CombinationsRequest<>(of));
  }

  @ParameterizedTest
  @NullAndEmptySource
  void constructor2Params_whenInvalidList_shouldThrowException(List<?> of) {
    assertThrows(IllegalArgumentException.class,
        () -> new CombinationsRequest<>(null, 1));
  }

  @ParameterizedTest
  @ValueSource(ints = {-1, 0, 4})
  void constructor_whenInvalidByNumber_shouldThrowException(int by) {
    List<?> of = List.of(1, 2, 3);
    assertThrows(IllegalArgumentException.class,
        () -> new CombinationsRequest<>(of, by));
  }

  @Test
  void of1Param_whenValidParams_shouldCreateRequest() {
    List<Integer> expectedOf = List.of(1, 2, 3);
    int expectedBy = expectedOf.size();
    CombinationsRequest<Integer> request = CombinationsRequest.of(expectedOf);
    assertEquals(expectedOf, request.getOf());
    assertEquals(expectedBy, request.getBy());
  }

  @Test
  void of2Param_whenValidParams_shouldCreateRequest() {
    List<Integer> expectedOf = List.of(1, 2, 3);
    int expectedBy = 2;
    CombinationsRequest<Integer> request = CombinationsRequest.of(expectedOf,
        expectedBy);
    assertEquals(expectedOf, request.getOf());
    assertEquals(expectedBy, request.getBy());
  }

  @Test
  void getOf_shouldReturnUnmodifiableList() {
    CombinationsRequest<Integer> request = CombinationsRequest.of(
        Arrays.asList(1, 2, 3));
    List<Integer> of = request.getOf();
    assertThrows(UnsupportedOperationException.class, () -> of.add(1));
  }


}