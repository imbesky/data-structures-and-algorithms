package org.example.section2;

import java.util.List;

public class PatternedRectangularTilings {
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
    }

}
