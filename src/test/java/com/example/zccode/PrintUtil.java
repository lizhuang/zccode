package com.example.zccode;

public class PrintUtil {

    public static void print(int[] arr) {
        System.out.println("======");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);

            if(i != arr.length -1){
                System.out.print(",");
            }
        }
        System.out.println("");
        System.out.println("======");
    }
}
