class Solution {
    public String removeOuterParentheses(String S) {
        Stack<Character> stack = new Stack<Character>();
        String result = "";
        int op=0, cl=0;
        for(int i=0; i<S.length(); i++){
            char c = S.charAt(i);
            //System.out.println(stack+" "+stack.size()+" "+op+" "+cl);
            if(!stack.isEmpty() && (stack.peek() == '(' && stack.size() == 1 && c == ')')){
                stack.clear(); op = cl = 0;
            }
            else if(stack.isEmpty() || (stack.peek() == '(' && c == '(')){
                stack.push(c);
                op++;
            }
            else if(!stack.isEmpty() && (stack.peek() == '(' && c == ')')){
                    stack.push(c); cl++;
            }
            else if(!stack.isEmpty() && (stack.size()>1)){
                stack.push(c);
                if(c==')') cl++; else op++;
            }
            
            if(stack.size() >1 && op == cl+1){
                       String s = "";
                        while(stack.size() != 1){
                            s += stack.pop();
                        }
                    op = 1; cl =0;
                    result += (new StringBuilder(s)).reverse();
                } 
        }
        return result;
    }
}
