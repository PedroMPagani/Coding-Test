package me.paganidev.psolving.p1;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class AlgorithmP1 {


    // switches values, first methdd
    // i is value1, j value2
    public void switchValues(int i,int j){
        if (i != j){
          i ^= j; // Bitwise exclusive OR
          //System.out.println("I is " + i + " j is " + j);
          j ^= i; // Bitwise exclusive OR
          //System.out.println("I is " + i + " j is " + j);
          i ^= j; // Bitwise exclusive OR
          // System.out.println("I is " + i + " j is " + j);
        }
        System.out.println("Value1: " + i + " Value2: " + j);
    }

    // second method
    public int[][] rotateArray(int arr[][]){
        int xy = arr.length;
        // 1 2 3    7 4 1
        // 4 5 6 -> 8 5 2
        // 7 8 9    9 6 3

        /**
         * The first first number on the first column will become the first one on the last comumn
         */
        int temp;
        for (int i = 0; i < xy/2; i ++){
            for (int j = 0; j < xy - i - 1; j++){
                temp = arr[i][j];
                arr[i][j] = arr[xy - 1 - j][i];
                arr[xy - 1 - j][i] = arr[xy - 1 - i][xy - 1 - j];
                arr[xy - 1 - i][xy - 1 - j] = arr[j][xy - 1 - i];
                arr[j][xy - 1 - i] = temp;
            }

        }
        return arr;
    }

    // third method, recursion.
    public int size(List<String> list,String parameter){
        int a = list.size();
        AtomicInteger c = new AtomicInteger();
        rec(parameter,list,0,c,a);
        return c.get();
    }

    private void rec(String p, List<String> list, int index, AtomicInteger c, int size){
        if (index < size){
            String j = list.get(index);
            if (j.contains(p)) c.incrementAndGet(); // c could be from a object, but lets just use this for simple purppose
            index++;
            rec(p,list,index,c,size);
        }
    }

}
