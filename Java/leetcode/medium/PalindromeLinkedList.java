package Java.leetcode.medium;

public class PalindromeLinkedList {
class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
        val = x;
        next = null;
        }
    }

     public boolean isPalindrome(ListNode head) {

        ListNode mid = getMiddle(head);
        ListNode sh = reverse(mid);

        while(head != null && sh != null){
            if(head.val != sh.val){
                break;
            }
            head = head.next;
            sh = sh.next;
        }

        return head == null || sh == null;
    }

    public ListNode getMiddle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public ListNode reverse(ListNode head){
        if(head == null) return head;

        ListNode prev = null;
        ListNode present = head;
        ListNode next = present.next;

        while(present != null){
            present.next = prev;
            prev = present;
            present = next;
            if(next != null){
                next = next.next;
            }
        }

        return prev;
    }
}