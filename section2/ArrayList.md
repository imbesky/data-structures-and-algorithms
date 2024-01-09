# Module 1

## Array

data type that store sequence of related objects or values

- not primitive
- allocations of contiguous blocks of memory
- all elements must be the same type
- flexible in what data types they can store; object, reference, primitive type, etc
- memory is static; allocated statically
    - if we want to save more datas than its capacity, have to create a new array(resize)

### Big-O

1. access: O(1)
    - if we access to a specific index
2. searching: O(n)
3. copy(resize): O(n)

### Terms

#### Size

number of data(non-null) being stored in it

#### Capacity

number of data that can be stored without a resize

## ADT: Abstract Data Type

model description of a data type that is defined by its behaviors and operations

### ArrayLists

consists of a sequence of cell

- allocated contiguous space
- abstraction / wrapper for an array, type of List backed by an array
    - share lots of properties and limitations
- only can store objects
- default capacity is 10
- automatically resized when it reach the capacity; dynamic

```
import java.util.ArrayList;

public class Class{

	ArrayList<ObjectType> name = new ArrayList<>();
}
```

#### Requirement

1. data must be contiguous
    - cannot have any null spaces between data elements
2. data must be zero-aligned
   - datas must be populated beginning with the cell at index 0

#### Amortized analysis

method for analyzing a given algorithm's complexity

- averages the running times of both costly and less-costly operations
- using amortized analysis, adding to the back in array is O(1)
    - there are two possible cases: resize(O(n)) and not resize(O(1))
    - the average to these cases are O(2)

#### Other operations

- adding to an arbitrary index: O(n); shifting required
- removing from back: O(1)
- removing form an arbitrary index: O(n); shifting required

#### Soft and Hard removals

- soft: leave the data in the data structure unless it is absolutely unnecessary
- hard: when you ensure that the data you removed is completely removed form the backing structure