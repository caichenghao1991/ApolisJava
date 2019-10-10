package com.java.HW3.q5;

import java.util.*;

class Q4 {
    public static void main(String[] args) {       
        HashMap<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String expression = scan.next();
            if(isBalanced(expression, map)){
                System.out.println("true");
            }else{
                System.out.println("false");
            }
        }
        scan.close();       
    }
    
     public static boolean isBalanced(String exp, HashMap<Character, Character> map) {           
        Stack<Character> stack = new Stack<>(); 
        for (int i = 0; i < exp.length(); i++) {  
            Character c = exp.charAt(i);
            if (map.containsKey(c)) {
                stack.push(c);
            } else if (stack.isEmpty() || c != map.get(stack.pop())) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}



