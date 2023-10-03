package Java.leetcode.easy;

public class RemoveLinkedListElements {
    public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
   
     public ListNode removeElements(ListNode head, int val) {
        if(head == null) return head;

        while(head !=null && head.val == val) head = head.next;

        ListNode currentNode = head;

        while(currentNode != null && currentNode.next != null) {
            if(currentNode.next.val == val){
                currentNode.next = currentNode.next.next;
            }
            else currentNode = currentNode.next;
        }
        return head;
    }
}
