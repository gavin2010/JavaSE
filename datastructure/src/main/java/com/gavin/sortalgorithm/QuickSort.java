package com.gavin.sortalgorithm;

import java.util.Arrays;
/**
 * 不稳定排序
 *
 * 1.取数据最左边的一个数作为基数
 * 2.从右往左遍历，小于这个基数的放左边
 * 3.从左往右遍历，大于这个基数的放右边
 * 4.从而分出2段，左段必然小于等于这个基数，右段必然大于等于这个基数
 * 5.递归循环调用
 */
public class QuickSort {

    private static int[] arr = {4,2,67,32,14,89,31,45,34,14};
    public static void main(String[] args){
        new QuickSort().quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    private void quickSort(int[] arr,int low,int height){
        if(low >= height){
            return ;
        }
        int index = getIndex(arr,low,height);
        quickSort(arr,0,index-1);
        quickSort(arr,index+1,height);
    }

    private int getIndex(int[] arr,int low,int height){
        int temp = arr[low];
        while(low < height){
            //从右往左遍历
            while(low < height && temp <= arr[height]){
                height--;
            }
            arr[low] = arr[height];
            //从左往右遍历
            while(low < height && arr[low] <= temp){
                low++;
            }
            arr[height] = arr[low];
        }
        arr[low] = temp;
        return low;
    }
}
