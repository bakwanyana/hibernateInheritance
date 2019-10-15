# Spring Data JPA (Hibernate) Inheritance Persistence 
While learning Spring Data JPA, I ran into a problem trying to persist classes with multile inheritance.
I found a reference (https://thoughts-on-java.org/complete-guide-inheritance-strategies-jpa-hibernate/) that had four strategies to achieve this and have coded up some example for you to use and compare.
This is basically a summary of what that article had to offer, but coded up

All examples are based on the following domain object inheritance: Employee and SelfEmployed classes both inherit from the Person class.

## Strategy Description
### Mapped Superclass
The method here is to persist each concrete class to its own table while using the @MappedSuperclass for the parent class.

Branch: https://github.com/bakwanyana/hibernateInheritance/tree/mappedSuperclass

Pros:
* Shared attributes amongst all child classes

Cons:
* You cannot have an entity with a bi-directional relationship with any superclass (only unidirectional from superclass to another entity)
* You cannot persist superclasses

### Table per class
Each concrete class still gets persisted to its own table - using the @Inheritance  annotation with the InheritanceType.TABLE_PER_CLASS parameter achieves this.

Branch: https://github.com/bakwanyana/hibernateInheritance/tree/tablePerClass

Pros:
* Unlike the previous example, bi-directional relationships can be established with the parent class

Cons:
* Could lead to performance issues due to more complex queries that result from polymorphic queries

### Single Table
In this case, the entire inheritance tree is persisted to a single table. Note that the site mentions that this approach is best suited for
polymorphic queries (performance-wise), whereas the "table per class" approach is sited as the worst.

For Hibernate to know the object type it requires a "discriminator column". It gets defaulted to DTYPE should you not define one yourself in the superclass

Branch: https://github.com/bakwanyana/hibernateInheritance/tree/singleTable

Pros:
* Suited for inheritance: performance advantage over the single table strategy

Cons:
* Null values can be written to attributes that aren't common to all classes in your inheritance tree so you cannot introduce
null constraints on the DB

### Joined
A kind of combination between "single table" and "table per class" in that each entity gets persisted in its own class AND the
superclass entity gets persisted as well

All common attributes get persisted with the superclass entity and the child class specific attributes to the individual tables -  a join is required to
consolidate all data associated with the child entities

Branch: https://github.com/bakwanyana/hibernateInheritance/tree/joined

Pros:
* Greater data integrity than the single table strategy as you can introduce null constraints on attributes

Cons:
* Performance knock when retrieving child entities due to required join
