class Solution {
    public boolean checkValidString(String s) {
        int minOpen = 0; // Minimum possible number of open parentheses
        int maxOpen = 0; // Maximum possible number of open parentheses

        for (char c : s.toCharArray()) {
            if (c == '(') {
                minOpen++; // '(' increases both min and max
                maxOpen++;
            } else if (c == ')') {
                minOpen = Math.max(minOpen - 1, 0); // ')' decreases min, but it cannot go below 0
                maxOpen--;
            } else { // c == '*'
                minOpen = Math.max(minOpen - 1, 0); // '*' can decrease minOpen as if it were ')'
                maxOpen++; // '*' can also increase maxOpen as if it were '('
            }

            if (maxOpen < 0) {
                // If maxOpen falls below 0, there's no way to balance the parentheses
                return false;
            }
        }

        // After processing all characters, minOpen should be 0 for the string to be
        // valid
        return minOpen == 0;

    }

}