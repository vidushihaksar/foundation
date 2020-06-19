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
    
    public ListNode Mid(ListNode head){
      ListNode fast = head;
      ListNode slow = head;
      
      while(fast.next != null && fast.next.next!=null){
          fast = fast.next;
          fast = fast.next;
          slow = slow.next;
      }
      return slow;
    }
    
     public ListNode reverseList(ListNode head) {        
        ListNode prev = null, curr = head, nxt = head;
      
        while(curr != null){
          nxt = curr.next;
          curr.next = prev;
          prev = curr;
          curr = nxt;
        }
          head = prev;
          return head;
    }
    
    public void reorderList(ListNode head) {
        if(head == null || head.next == null){
            return;
            
        }
        
        //find mid node
        ListNode mid = Mid(head);
        
        
        //reverse list from mid.next to end
        ListNode sec =  mid.next;
        sec = reverseList(sec);
       
        //detach first half
        mid.next = null;
        
        
        //now reorder both lists
        ListNode first = head;
        
        while(first != null && sec != null){
            ListNode n1 = first.next;
            ListNode n2 = sec.next;
            
            first.next = sec;
            sec.next = n1;
            
            first=  n1;;
            sec = n2;
        }
        
       
        
    }
}


