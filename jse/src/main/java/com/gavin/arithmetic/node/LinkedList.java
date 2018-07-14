package com.gavin.arithmetic.node;

public class LinkedList {
    private ListNode first;
    private int lenth = 0;
    public void put(int n){
        if(null == first){
            first = new ListNode(n);
            lenth++;
            return;
        }

        ListNode point = first;
        ListNode next = point.next;
        while(null != next){
            point = next;
            next = point.next;
        }
        point.next = new ListNode(n);
        lenth++;
    }
}
