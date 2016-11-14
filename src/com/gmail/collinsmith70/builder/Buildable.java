package com.gmail.collinsmith70.builder;

import java.util.function.Supplier;

/**
 * Interface used to specify that an object is buildable. An object is said to be {@code Buildable}
 * if there exists a {@linkplain B Builder} implementation which has a mutable state, that can have
 * an instance of that {@linkplain T object} created, mirroring the state set by within
 * {@link Builder}.
 * <p>
 * To avoid needless verbosity in some cases (especially when generic types are used), it is also
 * recommended to provide a static utility method to improve usability when retrieving the
 * {@code Builder} instance, such as:
 * <pre>{@code
 *   public static <E> Builder<E> builder() {
 *     return Buildable.builder(BuildableLinkedList.Builder<E>::new);
 *   }
 * }</pre>
 * Finally, here is a simple example implementation:
 * <pre>{@code
 * public class Person implements Buildable<Person, Person.Builder> {
 *
 * public static Builder builder() {
 *     return Buildable.builder(Person.Builder::new);
 *   }
 *
 *   private String name;
 *   private int age;
 *
 *   public Person() {
 *     // Default constructor...
 *   }
 *
 *   private Person(Builder builder) {
 *     this.name = builder.name;
 *     this.age = builder.age;
 *   }
 *
 *   @Override
 *   public Builder get() {
 *     return new Builder();
 *   }
 *
 *   public static class Builder implements SimpleBuilder<Person> {
 *
 *     private String name;
 *     private int age;
 *
 *     public Builder setName(String name) {
 *       this.name = name;
 *       return this;
 *     }
 *
 *     public Builder setAge(int age) {
 *       this.age = age;
 *       return this;
 *     }
 *
 *     @Override
 *     public Person build() {
 *       return new Person(this);
 *     }
 *   }
 * }
 * }</pre>
 *
 * @param <T> Type of object to construct
 * @param <B> {@link Builder} used to construct the object
 */
@FunctionalInterface
public interface Buildable<T extends Buildable<T, B>, B extends Builder<? super T>>
    extends Supplier<B> {

  /**
   * Retrieves an instance of a {@linkplain B builder} for the specified {@linkplain T type} using
   * the passed {@link Supplier} to generate the {@code Builder} instance. In some cases, generic
   * arguments cannot be inferred by the compiler, such as in
   * <pre>{@code
   *   BuildableLinkedList<Integer> list
   *     = Buildable.builder(BuildableLinkedList.Builder::new)
   *         .build();
   * }</pre>
   * In these cases, generic arguments must be specified:
   * <pre>{@code
   *   BuildableLinkedList<Integer> list
   *     = Buildable.builder(BuildableLinkedList.Builder<Integer>::new)
   *         .build();
   * }</pre>
   * It is also recommended to provide a static utility method to improve usability for
   * some common implementations:
   * <pre>{@code
   *   public static <E> Builder<E> builder() {
   *     return Buildable.builder(BuildableLinkedList.Builder<E>::new);
   *   }
   * }</pre>
   *
   * @param supplier {@code Supplier} used to generate the {@linkplain B Builder}
   * @param <T>      Type of object to construct
   * @param <B>      {@link Builder} used to construct the object
   *
   * @return {@linkplain B Builder} instance to construct the {@linkplain T object} instance using
   */
  static <T extends Buildable<T, B>, B extends Builder<? super T>> B builder(Supplier<B> supplier) {
    return supplier.get();
  }

}
