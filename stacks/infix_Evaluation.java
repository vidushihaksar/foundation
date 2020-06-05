import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();
    //System.out.println(exp);
    System.out.println(infixEval(exp));
    // code
 }
 
 public static int infixEval(String exp){
     
     Stack<Integer> operands = new Stack<>();
     Stack<Character> operators = new Stack<>();
     
     for(int i=0; i< exp.length(); i++){
         char ch = exp.charAt(i);
         
         if((ch >= '0' && ch <= '9')){
             operands.push(ch - '0');
             
         }else if(ch == '('){
             operators.push(ch);
         
             
         }else if(ch == ')'){
             while(operators.peek() != '('){
                 char optr = operators.pop();
                 int num2 = operands.pop();
                 int num1 = operands.pop();
                 int ans = solve(optr, num1, num2);
                 operands.push(ans);
             }
             operators.pop();
         
             
         }else if(ch== '+' || ch== '*' || ch=='/' || ch=='-'){
             
             while(operators.size()!=0 && operators.peek()!='(' && precedence(ch) <= precedence(operators.peek())){
                 char optr = operators.pop();
                 int num2 = operands.pop();
                 int num1 = operands.pop();
                 int ans = solve(optr, num1, num2);
                 operands.push(ans);
             }
             
             operators.push(ch);
         }
         
     }
     while(operators.size() != 0){
        char optr = operators.pop();
        int num2 = operands.pop();
        int num1 = operands.pop();
        int ans = solve(optr, num1, num2);
        operands.push(ans);
     }
     
    return operands.peek();
 }
 
 public static int precedence(char ch){
     if(ch == '*' || ch == '/'){
         return 2;
     }else{
         return 1;
     }
 }
 
 public static int solve(char op, int num1, int num2){
     if(op == '*'){
         return num1 * num2;
     }else if(op == '+'){
         return num1 + num2;
     }else if(op == '/'){
         return num1 / num2;
     }else{
         return num1 - num2;
     }
     
 }
}