# HashMap

Type of a map

## Map

dictionaries

- collections of key-value pairs
- searchable
- undordered
	- when used with hashing
- key is unique
	- cannot be duplicated
	- value can be duplicated
- immutable
	- cannot change key value through entry

### ADT 

methods

- V put(K, V)
- V get(K)
- V remove(K)
- int size(): number of entries

capacity
- length of the backing array: N

## HashMap componenet

### Hash function

1. represents key object as an integer: hashcode
2. maps that hashcode to an integer in the backing array
	- if two hashcode is equal with `equal()`, they are the same hashcode

#### Compression function

- having same hashcode does not always mean that they are same key
	- hashcode is just some part of the key
- backing array의 size capacity를 맞추기 위해 hashcode를 사용
	- index = hashcode % array length
- **collision**: mutiple key and value pairs can be stored at the index of their hashcode

#### Avoid collision

- resize to a larger table
- resize when maximum load factor is hit
	- load factor = size / capacity
	- typical maximum load factor: 60~70%
- use prime numbers for the array

## Exeternal chaining

chaining all the entries are put at the exact index calculated

- mutiple entries can be stored at each index
- **closed addressing strategy**
	- keys that collide into the same location are stored at that location by some means

### LinkedList as an element

- each element in the array is LinkedList
- the first value of the index became head
- after the first value, add to the front of the chain

## Interval chaining

- **open addressing** strategy
  - entries may not end up at the original index calcualated

### Linear probing 

- used to store only one entry in each index of the array 

`index = (h + original index) % length of the array` 

- if collision occurs at a given index, increment the index by one and check again
- `h` = number of times probed
  - max = N 

#### Removing 

1. look at index `hashcode % length`
2. if the key is different, probe; move to index of `index + 1`
  - repeat until finding the target key
3. insert marker at the index of the removed key
  - markers are perfomed as boolean 

#### Putting 

at the proper index of key(driven by `hashcode % length`), there can be 4 possible shenarios 

1. valid and unequal key 
	- probe 
2. valid and equal key 
	- update the value 

3. deleted(marker) 
	- if it is the first marker encountered,  save index
	- probe 

4. null
	- if there is a saved marker, put at that location
	- else, put in this location 

#### Resize 

1. create a new backing array of lager capacity
2. loop old backing array
3. rehash all cells to backing array
4. skip all markers 

#### Problem 

= primary clustering = turtling 

- developing contiguous blocks of data with markers
- search for data in these indices will necessarily continue until hitting the end of the block 

### Quadratic probing 

if a collision occurs at given index, add `h^2` to the original index and check again 

- `index = (h^2 % original index) % length of the array`
- mitigate effect of primary clustering 

#### Example 

- `original hash = h`
- `length = l` 

1. index = h % l
2. index = (h + 1^2) % l
3. index = (h + 2^2) % l
... 

#### Problem 

Secondary clustering 

- keys of completely differend hash indices can still collide 

#### Solution to infinite probing 

1. continually resize until a spot is eventually found
2. impose a set of conditions on the table to ensure that this scenario never occurs

### Double hashing

if a collision occurs at a given index, add multiple of `c` to the original index and check again

- break up clusters created by linear probing
- `index = (c * h + original index) % length of backing array`

#### Hash index

- `H(k)`: first hash, used to calculate original index
- `D(k)`: second hash, used to calculate probing constant(`c`)
	- = `q - H(k) % q`
	- `q`: prime number, `q < N`