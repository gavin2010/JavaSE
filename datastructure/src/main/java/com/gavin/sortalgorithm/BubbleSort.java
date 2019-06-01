package com.gavin.sortalgorithm;

import org.junit.Test;

import java.util.Arrays;

/**
 * 稳定排序
 */
public class BubbleSort {
    private int[] arr = {4,2,67,32,14,89,31,45,34,14};

    //普通冒泡排序,大泡往后冒泡
    //效率低,实现简单
    @Test
    public void bubbleSort1(){
        int temp;
        for(int i = 0, len = arr.length; i < len-1; i++){
            for(int j = 0; j < arr.length-i-1; j++){
                if(arr[j]>arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    //冒泡排序，小泡向前冒泡
    @Test
    public void bubbleSort2(){
        int temp;
        for(int i = 1; i < arr.length ; i++){
            for(int j = arr.length-1; j >= i; j-- ){
                if(arr[j] < arr[j-1]){
                    temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
