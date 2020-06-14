/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head== null || head.next == null){
            return head;
        }
        ListNode prev = new ListNode(0);
        prev.next = head;
        
        ListNode node = prev;
        while(head!= null){
            if(head.next == null || head.val != head.next.val){
                prev.next = head;
                head = head.next;
                prev = prev.next;
            }else{
                while(head.next != null && head.val == head.next.val){
                    head = head.next;
                 }
                head = head.next;
            }
        }
        prev.next = null;
        return node.next;
    }
}

