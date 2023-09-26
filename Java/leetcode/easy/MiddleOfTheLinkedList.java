package Java.leetcode.easy;

import org.w3c.dom.Node;

public class MiddleOfTheLinkedList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode middleNode(ListNode head){
        int length = 0;
        ListNode temp = head;

        while(temp != null){
            temp = temp.next;
            length++;
        }

        int mid = length / 2;
        ListNode current = head;
        for(int i = 1 ; i <= mid ; i++){
            current = current.next;
        }

        return current;
    }
}
