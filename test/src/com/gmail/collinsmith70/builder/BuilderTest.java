package com.gmail.collinsmith70.builder;

import org.junit.Assert;
import org.junit.Test;

public class BuilderTest {

  public BuilderTest() {
  }

  @Test
  public void testConstructors() {
    BuildableImpl b1 = Buildable.builder(BuildableImpl.Builder::new).build();
    BuildableLinkedList<Integer> b2
        = Buildable.builder(BuildableLinkedList.Builder<Integer>::new).build();
  }

  @Test
  public void testGeneric() {
    BuildableLinkedList<Integer> b2 = Buildable.builder(BuildableLinkedList.Builder<Integer>::new)
        .add(1)
        .add(3)
        .add(5)
        .add(7)
        .add(11)
        .build();
    Assert.assertTrue(b2.get(0) == 1);
    Assert.assertTrue(b2.get(1) == 3);
    Assert.assertTrue(b2.get(2) == 5);
    Assert.assertTrue(b2.get(3) == 7);
    Assert.assertTrue(b2.get(4) == 11);
  }

}
