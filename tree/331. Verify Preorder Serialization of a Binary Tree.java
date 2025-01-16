class Solution {

    /**
     * Similar to Problem 297:
     * Serialize and Deserialize Binary Tree, but here we do not really need to
     * reconstruct our tree,
     * and using stack is enough. The trick is to add elements one by one and when
     * we see num, #, #,
     * we replace it with #. If we get just one # in the end, return True, else:
     * False. Let us look
     * at the example 9,3,4,#,#,1,#,#,2,#,6,#,#.
     * Let us go through steps:
     * 
     * 1. We add elements until we have 9, 3, 4, #, #. It means now that 4 is leaf,
     * so let us
     * remove it: we have 9, 3, #.
     * 2. Add elements, so we have 9, 3, #, 1, #, #. We have leaf 1, remove it: 9,
     * 3, #, #.
     * Now, we have 3 as leaf as well: remove it: 9, #.
     * 3. Add elements 9, #, 2, #, 6, #, # -> 9, #, 2, #, # -> 9, #, # -> #.
     */
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < nodes.length; i++) {
            String curr = nodes[i];

            while (curr.equals("#") && !stack.empty() && stack.peek().equals(curr)) {
                stack.pop();

                if (stack.empty()) {
                    return false;
                }

                stack.pop();
            }
            stack.push(curr);
        }

        return stack.size() == 1 && stack.peek().equals("#");
    }
}