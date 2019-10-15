# Spring Data JPA (Hibernate) Inheritance Persistence 
While learning Spring Data JPA, I ran into a problem trying to persist classes with multile inheritance.
I found a reference (https://thoughts-on-java.org/complete-guide-inheritance-strategies-jpa-hibernate/) that had four strategies to achieve this and have coded up some example for you to use and compare.
This is basically a summary of what that article had to offer, but coded up

All examples are based on the following domain object inheritance: Employee and SelfEmployed classes both inherit from the Person class.

## Strategy Description

### Table per class
Each concrete class still gets persisted to its own table - using the @Inheritance  annotation with the InheritanceType.TABLE_PER_CLASS parameter achieves this.


Pros:
* Unlike the previous example, bi-directional relationships can be established with the parent class

Cons:
* Could lead to performance issues due to more complex queries that result from polymorphic queries