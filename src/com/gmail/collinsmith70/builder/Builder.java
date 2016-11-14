package com.gmail.collinsmith70.builder;

/**
 * Functional interface used to represent a {@code Builder} for constructing object instances.
 * {@code Builder} implementations should provide methods to set state, and every method should
 * return the {@code Builder} instance
 * <a href="https://docs.oracle.com/javase/tutorial/java/javaOO/thiskey.html">itself</a>
 * to allow method chaining which terminates with the terminal {@link #build()} method.
 *
 * @param <T> Type of object which the {@code Builder} constructs
 */
@FunctionalInterface
public interface Builder<T> {

  /**
   * Constructs an instance of {@link T} using the state set by this {@link Builder}.
   *
   * @return Instance of type {@link T} created using the values set by this {@link Builder}
   */
  T build();

}
