package Java.leetcode.medium;

public class SortLinkedList {

    class ListNode{
        int val;
        ListNode next;

        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode sortList(ListNode head){
        if(head == null || head.next == null) return head;

        ListNode mid = getMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        return merge(left, right);
    }

    ListNode merge(ListNode list1, ListNode list2){
        ListNode temp = new ListNode();
        ListNode currentNode = temp;
        
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                currentNode.next = list1;
                list1 = list1.next;
                currentNode = currentNode.next;
            }
            else{
                currentNode.next = list2;
                list2 = list2.next;
                currentNode = currentNode.next;
            }
        }

        currentNode.next = (list1 != null) ? list1 : list2;

        return temp.next;
    }

    ListNode getMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
