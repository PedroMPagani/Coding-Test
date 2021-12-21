package me.paganidev.psolving;

import me.paganidev.psolving.p1.AlgorithmP1;
import me.paganidev.psolving.p2.AlgorithmP2;
import me.paganidev.psolving.p3.Cafeteria;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        AlgorithmP1 algorithmP1 = new AlgorithmP1();
        AlgorithmP2 algorithmP2 = new AlgorithmP2();


        algorithmP1.switchValues(10,12);
        int[][] arr = {{1, 2, 3}, {4, 5, 6},{7, 8, 9}};
        int[][] reversed = algorithmP1.rotateArray(arr);

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < reversed.length; i++){
            for (int j = 0; j <reversed.length; j++) {
                stringBuilder.append(reversed[i][j]).append(" ");
            }
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder);
        /*List<String> list = Arrays.asList("jobhunting","foodhunting","dignathunter","m,fowpafm");

        int c = algorithmP1.size(list,"hunting");
        System.out.println("c is  " + c);*/
        List<String> list = Arrays.asList("jobhuntin!g","foodhu&nting","dign!athunter","mfowpafmZA");
        List<List<Character>> a = algorithmP2.array(list);
        for (List<Character> characters : a) {
            System.out.println(characters);
        }

        Cafeteria cafeteria = new Cafeteria();
    }

}
