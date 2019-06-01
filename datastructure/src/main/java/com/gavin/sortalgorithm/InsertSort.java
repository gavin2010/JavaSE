package com.gavin.sortalgorithm;

import org.junit.Test;

import java.util.Arrays;

/**
 * 稳定排序
 */
public class InsertSort {
    private int[] arr = {4,2,67,32,14,89,31,45,34,14};

    //直接插入排序，从后面往前面排序，比他小的就交换
    @Test
    public void insertSort(){
        int temp;
        int number;
        for(int i = 1; i < arr.length; i++){
            number = arr[i];
            for(int j = i-1; j >=0 && number <arr[j]; j-- ){
                arr[j+1] = arr[j];
                arr[j] = number;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    //二分插入排序，稳定排序
    @Test
    public void binaryInsertSort(){
        for(int i=1; i<arr.length; i++){
            int left = 0;
            int right = i-1;
            int temp = arr[i];
            while(left <= right){
                int mid = (left+right)/2;
                if(temp < arr[mid]){
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }

            for(int j=i-1; j>=left; j--){
                arr[j+1] = arr[j];
            }

            if(left != i){
                arr[left] = temp;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
