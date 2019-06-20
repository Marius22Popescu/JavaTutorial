package Challenges;

import java.util.Stack;

public class EvaluateStringExpressions {

	public static int evaluate(String expression) { 
        char[] tokens = expression.toCharArray(); 
        Stack<Integer> values = new Stack<Integer>(); // Stack for numbers
        Stack<Character> operators = new Stack<Character>(); // Stack for Operators  
        for (int i = 0; i < tokens.length; i++) {              
            if (tokens[i] == ' ') // if white space go over
                continue; 
            if (tokens[i] >= '0' && tokens[i] <= '9') { // if is number
                StringBuffer sbuf = new StringBuffer();  
                while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9') //if is more like one token in a number
                    sbuf.append(tokens[i++]); 
                values.push(Integer.parseInt(sbuf.toString())); 
            }  
            else if (tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*' || tokens[i] == '/') { //if operator
                if (!operators.empty() && hasPrecedence(tokens[i], operators.peek())) //if the top of operators has greater or the same precedence like the current operation 
                  values.push(performOperation(operators.pop(), values.pop(), values.pop())); //perform the operation 
                operators.push(tokens[i]);  //push current operation
            } 
        } 
        while (!operators.empty())  //while operations stack is not empty 
            values.push(performOperation(operators.pop(), values.pop(), values.pop())); //run the operations on the operations stack
        return values.pop(); //return the result
    }   
    // This method check if 'op2' has higher or same precedence as 'op1'
    public static boolean hasPrecedence(char op1, char op2) { 
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) 
            return false; 
        else
            return true; 
    } 
    //This method will perform the operation
    public static int performOperation(char c, int x, int y) {
		if (c == '+') return x + y;
		else if (c == '*') return x * y;
		else if (c == '-') return y - x;
    	return 0;    	
    }
 
    
    // Driver method to test above methods 
    public static void main(String[] args) 
    { 
        System.out.println(EvaluateStringExpressions.evaluate("10 + 2 * 6")); 
        System.out.println(EvaluateStringExpressions.evaluate("100 * 2 + 12")); 
        System.out.println(EvaluateStringExpressions.evaluate("1 + 2 * 3 + 4 * 5")); 
        System.out.println(EvaluateStringExpressions.evaluate("1 * 2 * 3 * 4 * 5")); 
    }
}
