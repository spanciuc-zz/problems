package com.pantifik.problems.permutations;

import java.util.List;

public interface PermutationsGenerator {

  int count(final List<?> from, int count);

  <T> List<List<T>> generate(final List<T> from, int count);

}
