package com.gmail.collinsmith70.builder;

public class BuildableImpl implements Buildable<BuildableImpl, BuildableImpl.Builder> {

  public BuildableImpl() {
  }

  @Override
  public Builder get() {
    return new Builder();
  }

  public void test() {
  }

  public static class Builder extends AbstractBuilder<BuildableImpl> {

    @Override
    public BuildableImpl get() {
      return new BuildableImpl();
    }

    public Builder test() {
      constructing().test();
      return this;
    }

  }

}
