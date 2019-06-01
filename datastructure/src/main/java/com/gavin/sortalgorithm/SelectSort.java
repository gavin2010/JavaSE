package com.gavin.sortalgorithm;

import org.junit.Test;

import java.util.Arrays;

/**
 * 不稳定排序
 */
public class SelectSort {
    private int[] arr = {4,2,67,32,14,89,31,45,34,14};

    //内层每次循环选择最小的，和第i个元素交换
    @Test
    public void selectSort(){
        int index;
        int temp ;
        for(int i = 0; i < arr.length-1; i++){
            index = i;
            for(int j = i+1; j < arr.length; j++){
                if(arr[index] > arr[j]){
                    index = j;
                }
            }
            if(i != index){
                temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
