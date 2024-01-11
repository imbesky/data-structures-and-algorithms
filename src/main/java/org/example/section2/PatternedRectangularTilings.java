package org.example.section2;

public class PatternedRectangularTilings {
    public static void main(String[] args) {
        System.out.println(tiling(2));
    }

    public static int tiling(int length){
        if (length < 1){
            return 1;
        }
        if (length == 1){
            return 3; // black + blue / blue + black / blue + blue
        }
        return 3 * tiling(length - 1) + 4 * tiling(length - 2);
        // 4: red + black / red + blue / white + black / white + blue
    }

}
