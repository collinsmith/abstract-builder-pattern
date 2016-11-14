package com.gmail.collinsmith70.builder;

/**
 * Abstract implementation of a {@link Builder} to make subclassing generic {@code Builder}
 * implementations easier.
 * <p>
 * This implementation should be used whenever no external class is needed to store the mutable
 * state of the builder, and as a replacement for implementing the {@link Builder} interface itself,
 * as commonly the {@link Builder} subclass itself is named {@code Builder}.
 *
 * @param <T> {@inheritDoc}
 */
public interface SimpleBuilder<T extends Buildable<T, ? extends Builder<T>>> extends Builder<T> {
}
