package com.gmail.collinsmith70.builder;

import java.util.LinkedList;

public class BuildableLinkedList<E> extends LinkedList<E> implements Buildable<BuildableLinkedList<E>, BuildableLinkedList.Builder<E>> {

  public static <E> Builder<E> builder() {
    return Buildable.builder(BuildableLinkedList.Builder<E>::new);
  }

  public BuildableLinkedList() {
  }

  private BuildableLinkedList(Builder<E> builder) {
    super(builder.getConstructor());
  }

  @Override
  public Builder<E> get() {
    return new Builder<>();
  }

  public static class Builder<E> extends AbstractBuilder<BuildableLinkedList<E>, LinkedList<E>> {

    public Builder() {
      super(LinkedList::new);
    }

    @Override
    public BuildableLinkedList<E> apply(LinkedList<E> es) {
      return new BuildableLinkedList<>(this);
    }

    public Builder<E> add(E e) {
      getConstructor().add(e);
      return this;
    }

  }

}
