# Recursive

## Recursive method

a method is recursive if it repeated calls itself; 재귀

### Essential attributes

1. base case, terminating condition
    - base case can be multiple
2.  recursive case
    - method class to itself
3. progress to base case
    - have some parameter that advances towards termination
    - each recursive call must move towards the base case in some way

## Lab

### Patterned Rectangular Tilings

![img](patterned.png)

#### Code

```
    private final static String[][] TILE_WHITE = {{"white"}, {"white", "white"}};
    private final static String[][] TILE_RED = {{"red"}, {"red", "red"}};
    private final static String[][] TILE_BLACK = {{"black"}};
    private final static String[][] TILE_BLUE = {{"blue"}};

    public static List<List<String>> tiling(List<List<String>> tiles, int length){
        if (length < 1){
            return tiles;
        }
        if (length == 1){
            tiles.get(0).add(TILE_BLACK[0][0]);
            tiles.get(1).add(TILE_BLUE[0][0]);
            return tiles;
        }
        tiles.get(0).add(TILE_WHITE[0][0]);
        for (String tile : TILE_WHITE[1]){
            tiles.get(1).add(tile);
        }
        tiles.get(0).add(TILE_BLUE[0][0]);
        return tiling(tiles, length - 2);
```

#### Result

when length is even number

```
System.out.println(PatternedRectangularTilings.
    tiling(List.of(new ArrayList<>(), new ArrayList<>()), 10));

/* output:
[[white, blue, white, blue, white, blue, white, blue, white, blue],
[white, white, white, white, white, white, white, white, white, white]]
*/
```

when length is odd number
```
System.out.println(PatternedRectangularTilings.
    tiling(List.of(new ArrayList<>(), new ArrayList<>()), 7));

/* output:
[[white, blue, white, blue, white, blue, black],
[white, white, white, white, white, white, blue]]
*/
```

#### Solution

![img](patterned-solution.png)

### Increasing Subsequences in Arrays

![img.png](subsequence.png)

increasing subsequence란 주어진 배열에서 추출할 수 있는
1. index가 오름차순으로 배열됐고
2. value도 오름차순으로 배열된 subArray

예를 들어 [1,5,3,6] 이런 배열이 있으면
- [1], [5], [3], [6]
- [1,5] [1,3] [1,6] [3,6] [5,6]
- [1,5,6] [1,3,6]
이렇게 해당

#### 방법

- base case: 길이가 1일 때 이미 count한 목록에 없다면 return 1

1. 해당 배열이 오름차순으로 정렬되었는지 확인한다(인덱스 순서는 항상 유지되므로 무시)
    - 만약 그렇다면 순회한 배열 목록에 넣고 count++
2. 해당 배열의 subsequence 중 count한 목록에 없고 길이가 (해당배열 - 1)인 배열을 모두 재귀 호출해 값을 더한 후 return

#### Solution

![img](subsequence-solution.png)

### Tower Of Hanoi