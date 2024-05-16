package _01_TestMatchingBrackets;

import java.util.Stack;

public class TestMatchingBrackets {
    /*
     * Use a Stack to complete the method for checking if every opening bracket
     * has a matching closing bracket
     */
    public static boolean doBracketsMatch(String b) {
    	Stack<Character> stack = new Stack<Character>();
    	for (int i = 0; i < b.length(); i++) {
    		stack.push(b.charAt(i));
    	}
    	int count1 = 0;
    	int count2 = 0;
    	if (stack.lastElement() != '}') {
    		return false;
    	}
    	for (int i = 0; i < b.length(); i++) {
    		if (stack.pop() == '}') {
    			count1++;
    		}
    		else {
    			count2++;
    		}
    	}
        if (count1 == count2) {
        	return true;
        }
        else {
        	return false;
        }
    }
}