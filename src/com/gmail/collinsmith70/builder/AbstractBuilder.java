package com.gmail.collinsmith70.builder;

import java.util.function.Supplier;

public abstract class AbstractBuilder<T extends Buildable<T, ? extends Builder<T>>>
    implements Builder<T> {

  private T INSTANCE;

  public AbstractBuilder() {
    this.INSTANCE = get();
  }

  public AbstractBuilder(Supplier<T> supplier) {
    this.INSTANCE = supplier.get();
  }

  @Override
  public T build() {
    return INSTANCE;
  }

  protected T constructing() {
    return INSTANCE;
  }

}
