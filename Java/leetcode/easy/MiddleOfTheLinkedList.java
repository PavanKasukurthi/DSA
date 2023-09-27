package Java.leetcode.easy;

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

    //FAST AND SLOW POINTER METHOD
    public ListNode middleOfTheLinkedList(ListNode head){
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
