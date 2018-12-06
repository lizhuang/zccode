package com.example.zccode;

import org.junit.Test;

public class BubbleTest {

    @Test
    public void testBubbleSort() throws Exception {
        int[] a = {20, 10, 5, 30, 1, 2, 3, 8, 9, 88};
        print(a);
        a = bubbleSort(a);
        print(a);
    }

    private int[] bubbleSort(int[] arr) {
        for (int out = 0; out < arr.length; out++) {
            for (int in = out + 1; in < arr.length; in++) {
                if (arr[out] > arr[in]) {
                    swap(out, in, arr);
                }
            }
        }

        return arr;
    }

    private void swap(int a, int b ,int[] arr){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    private void print(int[] arr) {
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
