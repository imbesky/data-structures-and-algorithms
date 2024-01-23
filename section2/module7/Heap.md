# Heap

## Binary heap

binary tree type

### Property

#### Shape

completeness: must be complete tree

- top level filled entirely
- bottom level with no gaps

#### Order

1. minimum heap: smallest data set in the root
	- every parent is smaller than children
2. maximum heap: biggest data set in the root
	- every parent is bigger than children

### Implement with backing array

- place based level order
- leave index 0 empty; begin at index 1

#### Index

- left child index = 2 * index
- right child index = 2 * index + 1
- parent = round(index / 2)
- size = last given element value

### Usage

- designed for accessing the root
- not designed for arbitrary searching
	- O(N)
- used to back priority queue
	- O(1) to find the highest priority element; maximum heap

## Operations

- only consider add and remove; not designed for arbitrary searching
- maintain shape property first, then order property

### Add

1. add to the array while maintaining completeness
	- to the end(bottom) of the heap or next available spot in the array
2. heapify: operation to enforce order property, up-heap
	- compare data with parent
	- swap the data with the parent of necessary
	- continue until root or until no swap is necessary

#### Time complexity

O(logN)

- compare needed

#### Pseudo code

```
arr[arr.size()] = node
min_add(arr.size())

def min_add(index):
	if arr[(int)(index / 2)].data > arr[index].data:
		current = arr[index]
		arr[index] = arr[(int)(index / 2)]
		arr[(int)(index / 2)] = current
		min_add((int)(index / 2))
	else:
		return
```

### Remove

from the root

1. move the last element of the heap to replace the root
	- the element that has index of size in the array
2. down-heap
	- compare data with child
		- if two children, compare data with higher priority child
	- swap the data with the parent of necessary
	- continue until bottom(leaf) or until no swap is necessary

#### Time complexity

O(logN)

- compare needed

#### Pseudo code

```
new_root = arr[arr.size() - 1]
arr[1] = new root
min_remove(1)

def min_remove(index):
	if arr[index].left_child == null && arr[index].right_child == null:
		return
	if arr[index].left_child == null  || arr[index].right_child == null:
		child = arr[index].left_child == null ? arr[index].right_child : arr[index].left_child
	else:
		child = arr[index].left_child > arr[index].right_child ? arr[index].right_child : arr[index].left_child
	if arr[index].data > child.data:
		current = arr[index]
		arr[index] = child
		child = current
		min_remove(child.index)
	else:
		return		
```

## BuildHeap algorithm

- problem: when constructing from input of unsorted, unordered array, need to use add method for all data each; inefficient
	- O(N * logN) because N times of adding
- when doing down-heap, the only element that violates order property is the target node that we want to move
	- sub-heaps of the target node is valid heaps

### Method

1. make heap with unsorted array
2. from bottom, do down-heap repeatedly
	- make every possible sub-heaps valid

#### Time complexity

O(N)

- down-heap: O(1) at the bottom, O(logN) at the root
	- 합이 O(N) 정도

#### Pseudo code

in min-heap

```
def build_heap(index):
	if index == 1:
		return
	if arr[index * 2] == null && arr[index * 2 + 1] == null:
		build_heap((int)(index / 2))
	else
		down_heap(index)
		if index % 2 == 0:
			build_heap(index + 1)
		else:
			build_heap((int)(index / 2))

def down_heap(index):
	if arr[index * 2 + 1] == null  || arr[index * 2] == null:
		child = arr[index * 2 + 1] == null ? arr[index * 2] : arr[index * 2 + 1]
	else:
		child = arr[index * 2] < arr[index * 2 + 1] ? arr[index * 2] : arr[index * 2 + 1]
	if arr[index].data > child.data:
		current = arr[index]
		arr[index] = child
		child = current
		down_heap(child.index)
	else:
		return		
```