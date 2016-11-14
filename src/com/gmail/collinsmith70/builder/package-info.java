/**
 * This package contains constructs created to try and abstract and generalize the
 * <a href = "https://en.wikipedia.org/wiki/Builder_pattern">builder pattern</a>.
 * <p>
 * A {@link com.gmail.collinsmith70.builder.Builder} is a utility class designed to help construct
 * instances of an object using one with a mutable state, and once that state is to be finalized,
 * the object can be {@linkplain com.gmail.collinsmith70.builder.Builder#build() built}. Typically,
 * {@code Builder} implementations also support
 * <a href="https://en.wikipedia.org/wiki/Method_chaining">method chaining</a>, or the ability to
 * seamlessly chain the non-terminal methods which set the state, one after another, which then
 * concludes with the terminal "build" method to construct the final object.
 * <p>
 * For example: {@code Person p = new Person.Builder().setName("John Smith").setAge(35).build()}
 * <p>
 * An object is said to be {@link com.gmail.collinsmith70.builder.Buildable} if it supports an
 * implementation of the {@code Builder} interface. {@code Buildable} classes must
 * {@linkplain java.util.function.Supplier supply} a {@code Builder} implementation.
 * <p>
 * The intended implementation of the builder pattern in the context of this package is to implement
 * the {@code Buildable} interface, and then specify a {@code Builder} implementation to use to
 * construct object instances. In the case where there are already pre-existing data structures
 * which can be used to implement the {@code Builder} interface,
 * {@link com.gmail.collinsmith70.builder.AbstractBuilder} should be used (Note: A translational
 * function must be specified to convert the constructing data structure to the intended object).
 * However, in the case where there is not, or a more simple approach is more appropriate, then
 * implementing the {@link com.gmail.collinsmith70.builder.SimpleBuilder} should be enough. In most
 * cases, it is not recommended to directly implemented the Builder interface, as most
 * {@code Builder} subclasses are themselves, named "Builder".
 * <p>
 * Note: This implementation and abstraction is not perfect, partly due to language limitations,
 * so if implementations become overly verbose, I would recommend implementing the raw builder
 * pattern into your class design instead of using this abstraction.
 *
 * @author Collin Smith
 */
package com.gmail.collinsmith70.builder;