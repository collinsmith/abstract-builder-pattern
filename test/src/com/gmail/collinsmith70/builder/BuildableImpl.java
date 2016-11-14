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

  public static class Builder implements SimpleBuilder<BuildableImpl> {

    @Override
    public BuildableImpl build() {
      return new BuildableImpl();
    }

    public Builder test() {
      return this;
    }

  }

}
