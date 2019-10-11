# Spring Data JPA (Hibernate) Inheritance Persistence 
While learning Spring Data JPA, I ran into a problem trying to persist classes with multile inheritance.
I found a reference (https://thoughts-on-java.org/complete-guide-inheritance-strategies-jpa-hibernate/) that had four strategies to achieve this and have coded up some example for you to use and compare.
This is basically a summary of what that article had to offer, but coded up

All examples are based on the following domain object inheritance: Employee and SelfEmployed classes both inherit from the Person class.

## Strategy Description
### Mapped Superclass
The method here is to persist each concrete class to its own table while using the @MappedSuperclass for the parent class.

Pros:
* Shared attributes amongst all child classes

Cons:
* You cannot have an entity with a bi-directional relationship with any superclass (only unidirectional from superclass to another entity)
* You cannot persist superclasses