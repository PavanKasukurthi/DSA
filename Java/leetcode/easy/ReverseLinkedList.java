package Java.leetcode.easy;

public class ReverseLinkedList {
   
        private Node head;
        private Node tail;
        private int size;

        public ReverseLinkedList() {
            this.size = 0;
        }
    

     private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    //USING RECURSION
    private void reverseRecursive(Node node){
       if(node == tail){
            head = tail;
            return;
       }

       reverseRecursive(node.next);

       tail.next = node;
       tail = node;
       tail.next = null;
    }

    //IN PLACE REVERSAL
    public void reverse(){
        if(size < 2){
            return;
        }

        Node prev = null;
        Node present = head;
        Node next = present.next;

        while(present != null){
            present.next = prev;
            prev = present;
            present = next;
            if(next != null){
                next = next.next;
            }
        }

        head = prev;
    }
}
