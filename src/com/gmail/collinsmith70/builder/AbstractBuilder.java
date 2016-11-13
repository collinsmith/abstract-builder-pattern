package com.gmail.collinsmith70.builder;

import java.util.function.Supplier;

/**
 * Abstract implementation of a {@link Builder} to make subclassing generic {@code Builder}
 * implementations easier.
 * <br>
 * This implementation uses an instance of {@link T object} to be
 * constructed to store the state, and then returns that object in the
 * {@linkplain #build() terminal} method.
 * <br>
 * The constructed object can be retrieved using {@link #constructing()}.
 *
 * @param <T> Type of object to construct
 */
public abstract class AbstractBuilder<T extends Buildable<T, ? extends Builder<T>>>
    implements Builder<T> {

  /**
   * Instance of the {@linkplain T object} to save the mutable state to while constructing.
   */
  private T INSTANCE;

  /**
   * Constructs an {@link AbstractBuilder} using the instance
   * {@linkplain #get() provided by the built-in supplier}.
   */
  public AbstractBuilder() {
    this.INSTANCE = get();
  }

  /**
   * Constructs an {@link AbstractBuilder} using the instance provided by the passed
   * {@link Supplier}.
   *
   * @param supplier {@code Supplier} to generate the mutable state of this {@link Builder}
   */
  public AbstractBuilder(Supplier<T> supplier) {
    this.INSTANCE = supplier.get();
  }

  /**
   * {@inheritDoc}
   * <br>
   * Note: This implementation simply returns the same object used to construct the instance.
   * Modifications to the state of this {@link Builder} after calling this method will be applied
   * to any and all built instances.
   */
  @Override
  public T build() {
    return INSTANCE;
  }

  /**
   * Returns a reference to the object whose mutable state is used to construct the desired
   * {@linkplain T object}.
   *
   * @return Instance of {@link T} used to set the state of the constructed object.
   */
  protected T constructing() {
    return INSTANCE;
  }

}
