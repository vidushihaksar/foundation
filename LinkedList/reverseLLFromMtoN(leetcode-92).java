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
    public ListNode krevhelp(ListNode root, int k, ListNode node,ListNode prev, ListNode curr) {
            // ListNode prev = null;
            // ListNode curr = node;
            ListNode next = null;
        
            for(int i = 1; i <= k; i++) {
               
                 next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
           
            node.next = curr;
        
            return prev;
        }
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m== n)  return head;
        int i = 1;
        ListNode tmp = null;
        
        ListNode prev = null;
        ListNode curr = head;
        
        while(i <= m){
            tmp = prev;
             prev = curr;
             curr = curr.next; 
            i++;
        }
        
        ListNode ans = krevhelp(head, n-m , prev, prev, curr);
        
        // while(ans != null){
        //     System.out.print(ans.val+" ");
        //     ans = ans.next;
        // }
        if(tmp != null){
              tmp.next= ans;
              return head;
        }else{
              return ans;
        }
        
        
    }
}