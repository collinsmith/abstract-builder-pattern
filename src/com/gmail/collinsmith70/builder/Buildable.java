package com.gmail.collinsmith70.builder;

import java.util.function.Supplier;

/**
 * Interface used to specify that an object is buildable. An object is said to be {@code Buildable}
 * if there exists a {@linkplain B Builder} implementation which has a mutable state, that can have
 * an instance of that {@linkplain T object} created, mirroring the state set by within
 * {@link Builder}.
 *
 * @param <T> Type of object to construct
 * @param <B> {@link Builder} used to construct the object
 */
@FunctionalInterface
public interface Buildable<T extends Buildable<T, B>, B extends Builder<? super T>>
    extends Supplier<B> {

  /**
   * Retrieves an instance of a {@linkplain B builder} for the specified {@linkplain T type} using
   * the passed {@link Supplier} to generate the {@code Builder} instance.
   *
   * @param supplier {@code Supplier} used to generate the {@linkplain B Builder}
   * @param <T>      Type of object to construct
   * @param <B>      {@link Builder} used to construct the object
   *
   * @return {@linkplain B Builder} instance to construct the {@linkplain T object} instance using
   */
  static <T extends Buildable<T, B>, B extends Builder<? super T>> B builder(Supplier<B> supplier) {
    return supplier.get();
  }

}
