# Introduction2

## Iterable and Iterator

### Iterable

- abstraction that allows the implementing class to be iterated through whith a for-each loop
- has abstract method called `iterator()` that returns an `Iterator` object
- allows for direct control of object iteration for more custom behavior
- depends on both data structure and iterator

### Iterator

- abstracts control away from user to allow convenience for more generic needs
- has no dependencies besides data structure to iterate through

#### Interface

- to implement `Iterator` Interface, a class must override the `next()` and `hasNext()`
- in Iterator object, there is cursor variable: keeps track of the current data

#### Methods

- abstract
    - `next()`: returns the current data, moves the cursor to the next element
    - `hasNext()`: returns true when the cursor is not null

- non-abstract
    - `remove()`

## Comparable and Comparator

- Comparable and Comparator are independent of each other

### Comparable

#### Interface

- allow the implementing class to define a natural ordering
- an object can compare itself to another object using `compareTo()`

### Comparator

#### Interface

- allows the implementing class to define a custom ordering
- can used to compare two objects of the same type using `compare()`