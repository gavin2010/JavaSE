package com.gavin.arithmetic.base;

public class MaxLengthString {
    public int lengthOfLongestSubstring(String str){
        if(null == str || 0 == str.length()){
            return 0;
        }
        if(isCf(str)){
            int lenA = lengthOfLongestSubstring(str.substring(0,str.length()-1));
            int lenB = lengthOfLongestSubstring(str.substring(1));
            if(lenA>lenB){
                return lenA;
            }
            return  lenB;
        }else{
            return str.length();
        }

    }
    private boolean isCf(String Str){
        char[] arr = Str.toCharArray();
        for(int i = 0; i < arr.length-1; i++){
            for(int j = i+1; j < arr.length; j++){
                if(arr[i] == arr[j]){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args){
        int n = new MaxLengthString().lengthOfLongestSubstring("pwwkew");
        System.out.println(n);
    }
}
