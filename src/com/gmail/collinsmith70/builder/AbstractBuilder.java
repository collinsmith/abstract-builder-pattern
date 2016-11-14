package com.gmail.collinsmith70.builder;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Abstract implementation of a {@link Builder} to make subclassing generic {@code Builder}
 * implementations easier.
 * <p>
 * This implementation uses an instance of a {@link C} to be used as a constructor (object to hold
 * the mutable state), and then has some translational function which can create an instance of
 * {@link T} using that {@link C} as a template when the object is to be {@link #build() built}.
 * <p>
 * The constructing object can be retrieved using {@link #getConstructor()}.
 *
 * @param <T> {@inheritDoc}
 * @param <C> Mutable class used to store the state of the object while
 *            {@linkplain #getConstructor() constructing}
 */
public abstract class AbstractBuilder<T extends Buildable<T, ? extends Builder<T>>, C>
    implements SimpleBuilder<T>, Function<C, T> {

  /**
   * Instance of the {@linkplain C constructing} object to save the mutable state to.
   */
  private C INSTANCE;

  /**
   * Constructs an {@link AbstractBuilder} by {@linkplain Supplier supplying} a constructor that
   * can be used to create a {@linkplain C constructor} instance.
   *
   * @param supplier {@code Supplier} used to generate a {@linkplain C constructor} instance
   */
  public AbstractBuilder(Supplier<C> supplier) {
    this.INSTANCE = supplier.get();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public T build() {
    return apply(INSTANCE);
  }

  /**
   * Returns a reference to the {@linkplain C constructor} object whose mutable state is used to
   * construct an object of the desired type {@link T}.
   *
   * @return Instance of {@link C} whose mutable state will be used to build a {@link T}
   */
  protected C getConstructor() {
    return INSTANCE;
  }

}
