package com.gmail.collinsmith70.builder;

import java.util.function.Supplier;

/**
 * Interface used to represent a {@code Builder} class for constructing object instances.
 * {@code Builder} implementations should provide methods to set state, and every method should
 * return the {@code Builder} instance to allow method chaining which terminates with the terminal
 * {@link #build()} method.
 *
 * @param <T> Type of object which the {@code Builder} creates
 */
public interface Builder<T> extends Supplier<T> {

  /**
   * Builds an instance of {@link T} using the state set by this {@link Builder}.
   *
   * @return Instance of type {@link T} created using the values set by this {@link Builder}
   */
  T build();

}
