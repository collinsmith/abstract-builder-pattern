package com.gmail.collinsmith70.builder;

public class Person implements Buildable<Person, Person.Builder> {

  public static Builder builder() {
    return Buildable.builder(Person.Builder::new);
  }

  private String name;
  private int age;

  public Person() {
    // Default constructor...
  }

  private Person(Builder builder) {
    this.name = builder.name;
    this.age = builder.age;
  }

  @Override
  public Builder get() {
    return new Builder();
  }

  public static class Builder implements SimpleBuilder<Person> {

    private String name;
    private int age;

    public Builder setName(String name) {
      this.name = name;
      return this;
    }

    public Builder setAge(int age) {
      this.age = age;
      return this;
    }

    @Override
    public Person build() {
      return new Person(this);
    }

  }

}
