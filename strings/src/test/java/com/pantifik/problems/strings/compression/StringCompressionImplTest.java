package com.pantifik.problems.strings.compression;

import static org.junit.jupiter.api.Assertions.*;

class StringCompressionImplTest extends StringCompressionTest {

  @Override
  protected StringCompression createInstance() {
    return new StringCompressionImpl();
  }

}