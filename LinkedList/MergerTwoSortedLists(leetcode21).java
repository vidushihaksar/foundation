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
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if(l1 == null && l2 == null) return null;
    if(l1 == null) return l2;
    if(l2 == null) return l1;
        
     ListNode root = new ListNode();
     ListNode l11 =l1, l22 = l2;
        
        if(l1.val <= l2.val){
            root = l1;
            l11 = l1.next;
        }else{
            root =l2;
            l22 = l2.next;
                
        } 
        ListNode sorted = root;
    //System.out.println(l11.val+" "+l22.val+" "+sorted.val+" "+root.val);
         
         
         while(l11 != null && l22 != null){
             
             if(l11.val < l22.val){
                 sorted.next = l11;
                 l11 = l11.next;
             }else {
                 sorted.next = l22;
                 l22 = l22.next;
             }
             sorted= sorted.next;
         }
         
         while(l11 != null ){
             sorted.next = l11;
             l11 = l11.next;
             sorted= sorted.next;


         }
         while(l22 != null ){
             sorted.next = l22;
             l22 = l22.next;
             sorted= sorted.next;


         }
         
         return root;   
    }
}
// public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//     if(l1 == null && l2 == null) return null;
//     if(l1 == null) return l2;
//     if(l2 == null) return l1;

//     ListNode head = l1.val<l2.val?l1:l2;
//     ListNode current = new ListNode();
    
//     while(l1!= null && l2 != null){
//         if (l1.val < l2.val){
//             current.next = l1;
//             l1 = l1.next;
//         }else{
//             current.next = l2;
//             l2 = l2.next;
//         }
//         current = current.next;
//     }
    
//     if(l1 == null & l2 != null) current.next = l2;   
//     else if(l1 != null & l2 == null) current.next = l1;
    
//     return head;
// }
// }