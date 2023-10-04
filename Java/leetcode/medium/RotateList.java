package Java.leetcode.medium;

public class RotateList{
    public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode rotateRight(ListNode head, int k) {
        
       if(head == null || head.next == null) return head;

        ListNode tail = head;
        int n=1;

        while(tail.next != null){
            tail = tail.next;
            n+=1;
        }

        tail.next = head;

        k %= n;

        ListNode newTail = head;
        for(int i = 1 ; i < n-k ; i++){
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}