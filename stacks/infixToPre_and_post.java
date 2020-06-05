import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    // code
    
    Stack<String> prefix = new Stack<>();
    Stack<String> postfix = new Stack<>();
    Stack<Character> operators = new Stack<>();
    
    for(int i=0; i<exp.length(); i++){
        
        char ch = exp.charAt(i);
        if(isOprnd(ch)){
            prefix.push(""+ch);
            postfix.push(""+ch);
        
            
        }else if( ch == '('){
             operators.push(ch);
        
            
        }else if(ch == ')'){
             while(operators.peek() != '('){
                 char optr = operators.pop();
                 String op2 = prefix.pop();
                 String op1 = prefix.pop();
                 prefix.push(optr + op1 + op2); 
                 
                 String oprnd2 = postfix.pop();
                 String oprnd1 = postfix.pop();
                 postfix.push(oprnd1 + oprnd2 + optr); 
                 
             }
             
             operators.pop();
         
             
        }else if(ch == '-' || ch == '+' || ch == '*' || ch == '/'){
             
             while(operators.size() > 0 && operators.peek() != '(' && precedence( operators.peek() ) >= precedence(ch)){
                 char optr = operators.pop();
                 String op2 = prefix.pop();
                 String op1 = prefix.pop();
                 prefix.push(optr + op1 + op2); 
                 
                 String oprnd2 = postfix.pop();
                 String oprnd1 = postfix.pop();
                 postfix.push(oprnd1 + oprnd2 + optr); 
             }
             
             operators.push(ch);
        }
        
    }
     
     while(operators.size() > 0){
                 char optr = operators.pop();
                 String op2 = prefix.pop();
                 String op1 = prefix.pop();
                 prefix.push(optr + op1 + op2); 
                 
                 String oprnd2 = postfix.pop();
                 String oprnd1 = postfix.pop();
                 postfix.push(oprnd1 + oprnd2 + optr); 
        }
     
     System.out.println(postfix.peek());
     System.out.println(prefix.peek());
 }
 public static int precedence(char op){
     if(op == '+' || op == '-'){
         return 1;
     }else {
         return 2;
     }
 }
 
 public static boolean isOprnd(char ch){
     if( (ch >= '0' && ch <= '9') || (ch >= 'a' && ch  <= 'z') || (ch >= 'A' && ch <= 'Z')){
         return true;
     }
         return false;
     
 }
}
 
 