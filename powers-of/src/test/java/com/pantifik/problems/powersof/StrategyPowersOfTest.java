package com.pantifik.problems.powersof;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public abstract class StrategyPowersOfTest {

  protected BiFunction<Integer, Integer, List<Integer>> powersOfCalculator;

  @BeforeEach
  protected abstract void setUp();

  @ParameterizedTest
  @MethodSource("powersOfProvider")
  void get_shouldReturnPowersOf(int number, int power, List<Integer> expected) {
    List<Integer> actual = powersOfCalculator.apply(number, power);
    assertEquals(expected, actual);
  }


  private static Stream<Arguments> powersOfProvider() {

    Stream<Arguments> argsPower0or1 = Stream.of(Arguments.of(1, 0, List.of(1)),
        Arguments.of(1, 1, List.of(1)), Arguments.of(3, 0, List.of(1)),
        Arguments.of(3, 1, List.of(1, 2, 3)), Arguments.of(10, 0, List.of(1)),
        Arguments.of(10, 1, List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));

    Stream<Arguments> args = Stream.of(Arguments.of(1, 2, List.of(1)),
        Arguments.of(2, 2, List.of(1, 2)), Arguments.of(2, 3, List.of(1)),
        Arguments.of(4, 2, List.of(1, 2, 4)), Arguments.of(4, 3, List.of(1, 3)),
        Arguments.of(9, 5, List.of(1, 5)),
        Arguments.of(25, 5, List.of(1, 5, 25)),
        Arguments.of(100, 2, List.of(1, 2, 4, 8, 16, 32, 64)),
        Arguments.of(100, 3, List.of(1, 3, 9, 27, 81)),
        Arguments.of(100, 4, List.of(1, 4, 16, 64)),
        Arguments.of(100, 5, List.of(1, 5, 25)),
        Arguments.of(100, 105, List.of(1)));

    return Stream.of(argsPower0or1, args)
        .flatMap(Function.identity());
  }

}
