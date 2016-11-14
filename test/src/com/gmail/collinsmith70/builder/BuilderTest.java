package com.gmail.collinsmith70.builder;

import org.junit.Assert;
import org.junit.Test;

public class BuilderTest {

  public BuilderTest() {
  }

  @Test
  public void testSimpleConstructor() {
    BuildableImpl b1 = Buildable.builder(BuildableImpl.Builder::new).build();
  }

  @Test
  public void testGenericConstructor() {
    BuildableLinkedList<Integer> b2
        = Buildable.builder(BuildableLinkedList.Builder<Integer>::new).build();
  }

  @Test
  public void testGenericBuilderMethods() {
    int[] data = { 1, 3, 5, 7, 11 };
    BuildableLinkedList.Builder<Integer> builder = BuildableLinkedList.builder();
    for (int i : data) {
      builder.add(i);
    }

    BuildableLinkedList<Integer> list = builder.build();
    for (int i = 0; i < data.length; i++) {
      Assert.assertTrue(list.get(i) == data[i]);
    }
  }

}
