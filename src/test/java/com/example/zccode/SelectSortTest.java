package com.example.zccode;

import org.junit.Test;

public class SelectSortTest {

    @Test
    public void name() throws Exception {
        String str="1,2,3,4,";
        str=str.substring(0,str.lastIndexOf(","));
        System.out.println(str);
    }

    @Test
    public void testSelectSort() throws Exception {
        int[] arr = {20, 10, 5, 30, 1, 2, 3, 8, 9, 88};
        PrintUtil.print(arr);
        arr = selectSort(arr);
        PrintUtil.print(arr);
    }

    private int[] selectSort(int[] arr) {
        int out, in, min;
        for (out = 0; out < arr.length; out++) {
            min = out;
            for (in = out + 1; in < arr.length; in++) {
                if (arr[in] < arr[min]) {
                    min = in;
                }
            }

            if (arr[min] < arr[out]) {
                swap(min, out, arr);
            }
        }

        return arr;
    }
    private void swap(int a, int b, int[] arr) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
