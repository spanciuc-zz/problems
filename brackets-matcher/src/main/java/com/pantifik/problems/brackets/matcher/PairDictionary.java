package com.pantifik.problems.brackets.matcher;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class PairDictionary {

  public static final String LEFT_KEY = "left";
  public static final String RIGHT_KEY = "right";
  private static final String DUPLICATE_ELEMENT_MESSAGE
      = "The %s element of the pair already present in the dictionary";
  List<Character> left;
  List<Character> right;

  public PairDictionary() {
    left = new ArrayList<>();
    right = new ArrayList<>();
  }

  public PairDictionary(Collection<Pair> pairs) {
    this();
    this.addPairs(pairs);
  }

  public void addPair(Pair pair) {
    validatePair(pair);
    left.add(pair.left());
    right.add(pair.right());
  }

  public void addPairs(Collection<Pair> pairs) {
    Objects.requireNonNull(pairs);
    pairs.forEach(this::addPair);
  }

  public boolean isLeft(char character) {
    return left.contains(character);
  }

  public boolean isRight(char character) {
    return right.contains(character);
  }

  public Optional<Character> getLeft(char right) {
    int index = this.right.indexOf(right);
    if (index == -1) {
      return Optional.empty();
    }
    return Optional.of(left.get(index));
  }

  public Optional<Character> getRight(char left) {
    int index = this.left.indexOf(left);
    if (index == -1) {
      return Optional.empty();
    }
    return Optional.of(this.right.get(index));
  }

  public void clear() {
    left.clear();
    right.clear();
  }

  public boolean isEmpty() {
    return left.isEmpty();
  }

  public int size() {
    return left.size();
  }

  public List<Pair> getPairs() {
    List<Pair> pairs = new ArrayList<>();
    for (int i = 0; i < left.size(); i++) {
      pairs.add(new Pair(left.get(i), right.get(i)));
    }
    return pairs;
  }

  @Override
  public String toString() {
    return "PairDictionary{" + "pairs=[" + getPairs() + "]}";
  }

  private void validatePair(Pair pair) {
    Objects.requireNonNull(pair);
    checkPairExists(pair);
  }

  private void checkPairExists(Pair pair) {
    if (left.contains(pair.left()) || right.contains(pair.left())) {
      throw new IllegalArgumentException(String.format(DUPLICATE_ELEMENT_MESSAGE, LEFT_KEY));
    }
    if (right.contains(pair.right()) || left.contains(pair.right())) {
      throw new IllegalArgumentException(String.format(DUPLICATE_ELEMENT_MESSAGE, RIGHT_KEY));
    }
  }
}
