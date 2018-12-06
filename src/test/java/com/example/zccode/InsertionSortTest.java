package com.example.zccode;

import org.junit.Test;

public class InsertionSortTest {

    @Test
    public void testSelectSort() throws Exception {
        int[] arr = {20, 10, 5, 30, 1, 2, 3, 8, 9, 88};
        PrintUtil.print(arr);
        arr = insertSort(arr);
        PrintUtil.print(arr);
    }


    private int[] insertSort(int[] arr) {
        int in, out;
        for (out = 1; out < arr.length; out++) {
            int temp = arr[out];
            in = out;
            while (in > 0 && arr[in - 1] > temp) {
                arr[in] = arr[in - 1];
                --in;
            }
            arr[in] = temp;
        }

        return arr;
    }

}
