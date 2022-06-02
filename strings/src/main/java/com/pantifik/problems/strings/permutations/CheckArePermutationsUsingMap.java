package com.pantifik.problems.strings.permutations;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CheckArePermutationsUsingMap implements CheckArePermutations {
  @Override
  public boolean check(String first, String second) {
    Objects.requireNonNull(first);
    Objects.requireNonNull(second);
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < first.length(); i++) {
      map.merge(first.charAt(i), 1, Integer::sum);
    }
    for (int i = 0; i < second.length(); i++) {
      char current = second.charAt(i);
      int count = map.getOrDefault(current, 0);

      if (count == 0) {
        return false;
      } else if (count == 1) {
        map.remove(current);
      } else {
        map.put(current, --count);
      }
    }
    return map.isEmpty();
  }
}
