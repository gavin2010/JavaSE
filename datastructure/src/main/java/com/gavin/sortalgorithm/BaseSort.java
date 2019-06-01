package com.gavin.sortalgorithm;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 基数排序
 * 稳定排序
 * 基本思想：将所有待比较数值（正整数）统一为同样的数位长度，数位较短的数前面补零。
 * 然后，从最低位开始，依次进行一次排序。
 * 这样从最低位排序一直到最高位排序完成以后,数列就变成一个有序序列。
 */
public class BaseSort {
    private static int[] arr = {4,2,67,32,14,89,31,45,34,14};

    public static void main(String[] args){
       new BaseSort().baseSort(arr);
       System.out.println(Arrays.toString(arr));
    }

    private void baseSort(int[] arr) {
        //1.中出最大的数据
        int max = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }

        //2.找出总共的位数
        int times = 0;
        while(max > 0){
            max = max/10;
            times++;
        }

        //3.创建一个List，包含10个list
        List<ArrayList>  arrList = new ArrayList<ArrayList>();
        for(int i=0; i<10; i++){
            arrList.add(new ArrayList());
        }

        //总共遍历的位数
        for(int i=0; i<times; i++){
            //装入集合
            for(int j=0; j<arr.length; j++){
                int index = arr[j] % (int)Math.pow(10,i+1) / (int)Math.pow(10,i);
                arrList.get(index).add(arr[j]);
            }

            //按照位数排序
            int flag = 0;
            for(int m = 0; m <arrList.size(); m++){
                ArrayList<Integer> alist = arrList.get(m);
                for(int k=0; k<alist.size(); k++){
                    arr[flag++]  = alist.get(k);
                }
                alist.clear();
            }
        }
    }

}
