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
    
    public int size(ListNode h){
       
        int count =0;
        while(h != null){
            count++;
            h = h.next;
        }
        return count;
    }
    
    public boolean isPalindrome(ListNode head) {
        
         ListNode n1 = head;
        
//*********   size of list *******************
         int size = size(n1);
        
//********** reverse first half **************
        ListNode left = head;
        ListNode next = null;
        n1 = null;
        
        for(int i = 1; i <= size/2; i++){
            next = left.next;
            left.next = n1;
            n1 = left;
            left = next;
            
        }
        
//******** if list  is oddd, move one step ahead ******
        if(size % 2 != 0 ){
            left = left.next;
        }
        
//******** compare n1 and n2 ******************
        ListNode n2 = left;
        
        while(n1 != null && n2 != null){
            if(n1.val != n2.val){
                return false;
            }
            n1 = n1.next;
            n2 = n2.next;
        }
        
    return true;
        
    }
}