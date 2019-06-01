package com.gavin.sortalgorithm;

import java.util.Arrays;

/**
 * 稳定排序
 *
 * 归并排序
 * 1.相邻的2个元素排序，然后再依次合并。
 */
public class MergeSort {
    private static int[] arr = {4,2,67,32,14,89,31,45,34,14};
    public static void main(String[] args){
        new MergeSort().mergeSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    private void mergeSort(int[] arr,int low,int height){
        if(low < height){
            int mid = (low + height)/2;
            //1.左边排序
            mergeSort(arr,low,mid);
            //2.右边排序
            mergeSort(arr,mid+1,height);
            //3.合并排序
            mergeInto(arr,low,mid,height);
        }
    }

    private void mergeInto(int[] arr, int low, int mid, int height){
        int[] arrbak = new int[arr.length];
        int first  = low;
        int copyfirst  = low;
        int mid1 = mid + 1;
        while(low <= mid && mid1 <= height){;
            if(arr[low] <= arr[mid1] ){
                arrbak[first++] = arr[low++];
            }else{
                arrbak[first++] = arr[mid1++];
            }
        }
        //复制剩余的到左边
        while(low <= mid){
            arrbak[first++] = arr[low++];
        }
        //复制剩余的到右边
        while(mid1 <= height){
            arrbak[first++] = arr[mid1++];
        }

        //将中间数组复制到arr原数组
        while(copyfirst<=height){
            arr[copyfirst] = arrbak[copyfirst++];
        }
    }
}
