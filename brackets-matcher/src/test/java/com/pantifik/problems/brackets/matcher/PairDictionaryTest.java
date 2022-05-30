package com.pantifik.problems.brackets.matcher;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PairDictionaryTest {

  PairDictionary dictionary;

  @Test
  void constructor_whenNoParams_shouldCreateEmptyDictionary() {
    dictionary = new PairDictionary();
    assertTrue(dictionary.isEmpty());
    assertEquals(0, dictionary.size());
  }

  @Test
  void constructor_whenNullCollection_shouldThrowException() {
    assertThrows(NullPointerException.class, () -> new PairDictionary(null));
  }

  @Test
  void constructor_whenEmptyCollection_shouldCreateEmptyDictionary() {
    List<Pair> pairs = new ArrayList<>();
    dictionary = new PairDictionary(pairs);
    assertTrue(dictionary.isEmpty());
    assertEquals(0, dictionary.size());
  }

  @Test
  void constructor_whenCollectionContainsNull_shouldThrowException() {
    List<Pair> pairs = Arrays.asList(new Pair('{', '}'), null, new Pair('[', ']'));
    assertThrows(NullPointerException.class, () -> dictionary = new PairDictionary(pairs));
  }

  @ParameterizedTest
  @ValueSource(chars = {'{', '}'})
  void constructor_whenCollectionWithRepeatedLeftPair_shouldThrowException(char left) {
    List<Pair> pairs = List.of(new Pair('{', '}'), new Pair(left, ']'));
    assertThrows(IllegalArgumentException.class, () -> dictionary = new PairDictionary(pairs));
  }

  @ParameterizedTest
  @ValueSource(chars = {'{', '}'})
  void constructor_whenCollectionWithRepeatedRightPair_shouldThrowException(char right) {
    List<Pair> pairs = List.of(new Pair('{', '}'), new Pair('[', right));
    assertThrows(IllegalArgumentException.class, () -> dictionary = new PairDictionary(pairs));
  }

  @Test
  void addPair_whenNull_shouldThrowException() {
    dictionary = new PairDictionary();
    assertThrows(NullPointerException.class, () -> dictionary.addPair(null));
  }

  @Test
  void addPair_whenNotNull_shouldAddPair() {
    dictionary = new PairDictionary();
    Pair pair = new Pair('1', '2');
    dictionary.addPair(pair);
    assertFalse(dictionary.isEmpty());
    assertEquals(1, dictionary.size());
    assertEquals(List.of(pair), dictionary.getPairs());

    Pair pair2 = new Pair('3', '4');
    dictionary.addPair(pair2);
    assertFalse(dictionary.isEmpty());
    assertEquals(2, dictionary.size());
    assertEquals(List.of(pair, pair2), dictionary.getPairs());

    Pair pair3 = new Pair('5', '6');
    dictionary.addPair(pair3);
    assertFalse(dictionary.isEmpty());
    assertEquals(3, dictionary.size());
    assertEquals(List.of(pair, pair2, pair3), dictionary.getPairs());
  }

  @ParameterizedTest
  @ValueSource(chars = {'(', ')'})
  void addPair_whenRepeatedLeftPair_shouldThrowException(char left) {

    dictionary = new PairDictionary();
    Pair pair = new Pair('(', ')');
    dictionary.addPair(pair);
    assertFalse(dictionary.isEmpty());
    assertEquals(1, dictionary.size());
    assertEquals(List.of(pair), dictionary.getPairs());

    Pair pair2 = new Pair(left, '4');
    assertThrows(IllegalArgumentException.class, () -> dictionary.addPair(pair2));
    assertFalse(dictionary.isEmpty());
    assertEquals(1, dictionary.size());
    assertEquals(List.of(pair), dictionary.getPairs());
  }

  @ParameterizedTest
  @ValueSource(chars = {'(', ')'})
  void addPair_whenRepeatedRightPair_shouldThrowException(char right) {

    dictionary = new PairDictionary();
    Pair pair = new Pair('(', ')');
    dictionary.addPair(pair);
    assertFalse(dictionary.isEmpty());
    assertEquals(1, dictionary.size());
    assertEquals(List.of(pair), dictionary.getPairs());

    Pair pair2 = new Pair('4', right);
    assertThrows(IllegalArgumentException.class, () -> dictionary.addPair(pair2));
    assertFalse(dictionary.isEmpty());
    assertEquals(1, dictionary.size());
    assertEquals(List.of(pair), dictionary.getPairs());
  }

  @Test
  void addPairs_whenNullCollection_shouldThrowException() {
    dictionary = new PairDictionary();
    assertThrows(NullPointerException.class, () -> new PairDictionary(null));
  }

  @Test
  void addPairs_whenEmptyCollection_shouldNotChangeDictionary() {
    List<Pair> pairs = new ArrayList<>();
    dictionary = new PairDictionary();
    dictionary.addPairs(pairs);
    assertTrue(dictionary.isEmpty());
    assertEquals(0, dictionary.size());

    dictionary.addPair(new Pair('1', '2'));
    dictionary.addPairs(pairs);
    assertFalse(dictionary.isEmpty());
    assertEquals(1, dictionary.size());
  }

  @Test
  void addPairs_whenCollectionContainsNull_shouldThrowException() {
    List<Pair> pairs = Arrays.asList(new Pair('{', '}'), null, new Pair('[', ']'));
    dictionary = new PairDictionary();
    assertThrows(NullPointerException.class, () -> dictionary.addPairs(pairs));
    System.out.println(dictionary);
  }

  @ParameterizedTest
  @ValueSource(chars = {'{', '}'})
  void addPairs_whenCollectionWithRepeatedLeftPair_shouldThrowException(char left) {
    List<Pair> pairs = List.of(new Pair('{', '}'), new Pair(left, ']'));
    dictionary = new PairDictionary();
    assertThrows(IllegalArgumentException.class, () -> dictionary.addPairs(pairs));
  }

  @ParameterizedTest
  @ValueSource(chars = {'{', '}'})
  void addPairs_whenCollectionWithRepeatedRightPair_shouldThrowException(char right) {
    List<Pair> pairs = List.of(new Pair('{', '}'), new Pair('[', right));
    dictionary = new PairDictionary();
    assertThrows(IllegalArgumentException.class, () -> dictionary.addPairs(pairs));
  }

  @Test
  void clear_shouldEmptyDictionary() {
    List<Pair> pairs = List.of(new Pair('{', '}'), new Pair('[', ']'));
    dictionary = new PairDictionary(pairs);
    dictionary.clear();
    assertTrue(dictionary.isEmpty());
    assertEquals(0, dictionary.size());
  }
}