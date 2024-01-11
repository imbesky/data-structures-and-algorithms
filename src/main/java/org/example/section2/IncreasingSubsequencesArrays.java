package org.example.section2;

import java.util.ArrayList;
import java.util.List;

public class IncreasingSubsequencesArrays {
    public static void main(String[] args) {
        System.out.println(findThem(List.of(1,5,3,6), new ArrayList<>()));
    }
    public static int findThem(List<Integer> array, List<List<Integer>> alreadyAdded){
        int count = 0;
        if (array.size() == 1){
            alreadyAdded.add(array);
            System.out.println("array = " + array);
            return 1;
        }
        for (int i = 0; i < array.size() - 1; i++){
            if(array.get(i) >= array.get(i+1)){
                break;
            } else if (i == array.size() - 2) {
                alreadyAdded.add(array);
                System.out.println("array = " + array);
                count++;
            }
        }
        for (int i = 0; i < array.size(); i++) {
            List<Integer> subArray = new ArrayList<>(array);
            subArray.remove(i);
            if (!alreadyAdded.contains(subArray)){
                count += findThem(subArray, alreadyAdded);
            }
        }
        return count;
    }
}
