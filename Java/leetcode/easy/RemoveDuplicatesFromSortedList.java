package Java.leetcode.easy;

public class RemoveDuplicatesFromSortedList {

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
    }

    public static ListNode deleteDuplicates(ListNode head){
        ListNode currentNode = head;

        if(head == null) return head;

        while(currentNode.next != null){
            if(currentNode.val == currentNode.next.val){
                currentNode.next = currentNode.next.next;
            }
            else currentNode = currentNode.next;
        }

        return head;
    }
}
