package com.gavin.sortalgorithm;

import org.junit.Test;

import java.util.Arrays;

/**
 * 希尔排序  https://blog.csdn.net/CJF_iceKing/article/details/7951481
 */
public class ShellSort {
    private int[] arr = {4,2,67,32,14,89,31,45,34,14};

    @Test
    public void shellSort(){
        int len = arr.length;
        int d = len/2;
        while(d>=1){
            shellInsert(arr,d,len);
            d = d/2;
        }
        System.out.println(Arrays.toString(arr));
    }

    //实际就是等距插入排序
    private void shellInsert(int[] arr, int d, int len) {
        for(int i=d; i<len; i++){
            int temp = arr[i];
            int j = i-d;
            for(; j>=0 && temp< arr[j]; j=j-d){
                arr[j+d] = arr[j];
            }
            if(j+d != i){
                arr[j+d] = temp;
            }
        }
    }
}
