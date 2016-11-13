package com.gmail.collinsmith70.builder;

import java.util.function.Supplier;

public interface Builder<T> extends Supplier<T> {

  T build();

}
