# Java Abstraction of the Builder Pattern

This repository contains my attempt at abstracting the [builder design pattern]
(https://en.wikipedia.org/wiki/Builder_pattern). As a fairly common implementor of the builder
design pattern, I wanted to try and abstract it to remove at least some of the repetitive and
often verbose code it entails. In many regards, I would consider this a success, in that I was able
to abstract at least some of the builder pattern implementation process, however it is still fairly
verbose. That being said, abstracting the builder pattern may have its uses, as implementations
could actually be polymorphic in nature (e.g., similar to how some libraries allow StringBuilder
instances where String instances are also accepted), however this was not apart of the design
process.

One major drawback is that there does not currently seem to be support at the language level for
dynamically inherited static methods, such as a method to automatically create a builder generator
specific to a class. This use-case could be accomplished in other languages, such as C/C++ using
parameterized macro definitions, however for the time being a static method within the Buildable
interface is provided to retrieve Builder instances for a class, and a static utility method to
call that static method with arguments specific to the implementing class is a fair workaround.

For example implementations, see:
- [Person](../master/test/src/com/gmail/collinsmith70/builder/Person.java)
- [BuildableLinkedList](../master/test/src/com/gmail/collinsmith70/builder/BuildableLinkedList.java)