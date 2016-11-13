package com.gmail.collinsmith70.builder;

import java.util.LinkedList;

public class BuildableLinkedList<E> extends LinkedList<E> implements Buildable<BuildableLinkedList<E>, BuildableLinkedList.Builder<E>> {

  public static <E> Builder<E> builder() {
    return Buildable.builder(BuildableLinkedList.Builder<E>::new);
  }

  public BuildableLinkedList() {
  }

  @Override
  public Builder<E> get() {
    return new Builder<>();
  }

  public static class Builder<E> extends AbstractBuilder<BuildableLinkedList<E>> {

    @Override
    public BuildableLinkedList<E> get() {
      return new BuildableLinkedList<>();
    }

    public Builder<E> add(E e) {
      constructing().add(e);
      return this;
    }

  }

}
