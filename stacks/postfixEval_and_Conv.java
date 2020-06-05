import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();
    
    postfixEval(exp);
    // code
 }
 
 public static void postfixEval(String exp){
     
     Stack<Integer> operands = new Stack<>();
     
     Stack<String> infix = new Stack<>();
     Stack<String> prefix = new Stack<>();

     
     for(int i=0; i< exp.length(); i++){
         char ch = exp.charAt(i);
         
     if( (ch >= '0' && ch <= '9') || (ch >= 'a' && ch  <= 'z') || (ch >= 'A' && ch <= 'Z')){
             operands.push(ch - '0');
             infix.push(ch+"");
             prefix.push(ch+"");
        
         
             
         }else if(ch == '-' || ch == '+' || ch == '*' || ch == '/'){
                 
             
                 char optr = ch;
                 int op2 = operands.pop();
                 int op1 = operands.pop();
                 int ans = solve(optr, op1, op2);
                 operands.push(ans); 
             
                 
                 String in2= infix.pop();
                 String in1 = infix.pop();
                 String inf = '(' + in1 + optr + in2 + ')';
                 infix.push(inf);
                 
                 String pre2= prefix.pop();
                 String pre1 = prefix.pop();
                 String pref = optr + pre1 + pre2;
                 prefix.push(pref);
                 
             
         }
        }
     
     
     System.out.println(operands.peek());
     System.out.println(infix.peek());
     System.out.println(prefix.peek());

     
}
 
 public static int precedence(char op){
     if(op == '+' || op == '-'){
         return 1;
     }else {
         return 2;
     }
 }
 
 public static int solve(char op, int op1, int op2){
     if(op == '-'){
         return op1 - op2;
     
     }else if(op == '+'){
         return op1 + op2;
     
     }else if(op == '*'){
         return op1 * op2;
    
     }else {
         return op1 / op2;
     }
 }
}