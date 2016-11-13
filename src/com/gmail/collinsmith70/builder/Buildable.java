package com.gmail.collinsmith70.builder;

import java.util.function.Supplier;

@FunctionalInterface
public interface Buildable<T extends Buildable<T, B>, B extends Builder<? super T>>
    extends Supplier<B> {

  static <T extends Buildable<T, B>, B extends Builder<? super T>> B builder(Supplier<B> supplier) {
    return supplier.get();
  }

}
