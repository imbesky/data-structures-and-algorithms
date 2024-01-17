# Linked List

collection of nodes

- implement list ADT
- store data in node; can be put anywhere in memory, thus not contiguous
- there are connections between nodes

## Singly-Linked Lists

the linked list that nodes have only a single pointer that points to the next node in the list

### Adding

#### To the back

- O(n)
- use interation to find the current last node of the list: `while(current.next != null) current = current.next`
- set the new node as the next node: `current.next = new`

#### To the front

- O(1)
- `new.next = head`

#### Edge case

1. If the List is empty
    - head 노드부터 먼저 생성해줘야 함

### Remove

#### From front

- O(1)
- `head = head.next`

#### From back

- O(n)
- use interation to find the current last node of the list: `while(current.next.next != null) current = current.next`
- change `current.next = null`

#### Edge case

1. If the List is empty, removing from the front or back
    - `head == null then return null`
2. If the List size is 1, removing from the back
    - `current.next.next` throws exception
    - head.next == null then head == null`

### Optimization

- maintain size variable in the implementation
- need to increment or decrement size when adding or removing

#### Tail pointer

similar to head pointer, tail pointer points to the last node in the list

- 맨 뒤에 삽입: O(1)
- 맨 뒤에 삭제: O(n)
  - 마지막 노드를 삭제하기 위해서는 마지막에서 두 번째 노드까지 순회해야 함

### Recursion

- given internal access to a Singly-Linked List with Comparable data and list is sorted
- remove duplication
- done in O(n) time and O(1) space
  - for space, we are referring to external memory such as creating new nodes, data, etc.

#### Solution

```
Node removeDuplicate(Node nurr){
	if (curr == null){
		return null
	}
	curr.next = removeDuplicate(curr.next)
	if (curr.next != null && curr.data == curr.next.data){
		return curr.next
	}
	return curr
}
```

#### Iteration

```
current = head
while(current.next != null){
   if (current.data == current.next.data){
      current.next == current.next.next
   }
   current = current.next
}
```

## Other Linked lists

### Doubly-Linked Lists

linear list of nodes that have pointers pointing to next node and previous node

- almost always has a tail pointer
- compare to SLL: use extra memory, more efficient

#### Edge case

shen removing from a size 1 list

- head and tail will both need to point to null

### Circularly-Linked Lists

last node points back to the head

- usually doesn't include a tail pointer
- termination condition for code logic changes due to no 'end' to the list
- can be singly or doubly linked

#### Adding to the front, back in singly linked

앞에 넣나 뒤에 넣나 동일함

1. 새 노드 생성
2. 헤드 바로 다음(인덱스 1)에 새 노드 삽입
3. 헤드에 있는 데이터 복사
4. 헤드에 원하는 데이터 집어넣기

#### Removing from the front in singly linked

1. 헤드 다음 노드의 값을 헤드로 복사
2. 헤드가 다음다음 노드를 가리키도록 변경
