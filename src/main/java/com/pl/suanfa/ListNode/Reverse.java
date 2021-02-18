package com.pl.suanfa.ListNode;

import org.junit.Test;
import org.springframework.util.CollectionUtils;

import java.util.*;

public class Reverse {
    public ListNode Reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode last = Reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    @Test
    public void test() {
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        System.out.println(123);
        ListNode temp = Reverse(listNode);
        List<Integer> list = new ArrayList<Integer>();
//        Queue<Integer> temp1 = new ArrayList<>();
//        "".equals()
//        temp1.offer()
//        temp1.poll()
//        list.size()
//        StringBuilder
//        CollectionUtils
//        list.add()
//        list.remove()
//        Queue<TreeNode> q=new LinkedList();
//        "".isEmpty()
//        ListNode pre, cur, nex;
//        cur = nex = null;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
//        map.remove()
//        map.size();
    }

    public void demo() {
        String str = "";
//        Integer.valueOf()
        char[] chars = str.toCharArray();
//        Character.isLetterOrDigit(str.charAt()[l])
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
        map.put(1, 1);
        map.containsKey("");
//        map.putIfAbsent();
        LinkedHashSet linkedHashSet=new LinkedHashSet();
//        linkedHashSet
    }
}

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}
