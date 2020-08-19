
/*
 * @lc app=leetcode id=917 lang=java
 *
 * [917] Reverse Only Letters
 *
 * https://leetcode.com/problems/reverse-only-letters/description/
 *
 * algorithms
 * Easy (57.90%)
 * Likes:    597
 * Dislikes: 34
 * Total Accepted:    59.6K
 * Total Submissions: 102.8K
 * Testcase Example:  '"ab-cd"'
 *
 * Given a string S, return the "reversed" string where all characters that are
 * not a letter stay in the same place, and all letters reverse their
 * positions.
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: "ab-cd"
 * Output: "dc-ba"
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "a-bC-dEf-ghIj"
 * Output: "j-Ih-gfE-dCba"
 * 
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: "Test1ng-Leet=code-Q!"
 * Output: "Qedo1ct-eeLg=ntse-T!"
 * 
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * S.length <= 100
 * 33 <= S[i].ASCIIcode <= 122 
 * S doesn't contain \ or "
 * 
 * 
 * 
 * 
 * 
 */

// @lc code=start
// T=O(n)
// S=O(n)
class Solution {
    public String reverseOnlyLetters(String S) {
        // return solution1(S);
        return solution2(S);
    }

    // two pointers, T=O(n), S=O(1)
    private String solution2(String S) {
        int n = S.length();
        int left = 0, right = n - 1;
        char[] s = S.toCharArray();
        while (left < right) {
            if (Character.isLetter(s[left]) && Character.isLetter(s[right])) {
                swap(s, left++, right--);
            }else{
                if (!Character.isLetter(s[left])) {++left;}
                if (!Character.isLetter(s[right])) {--right;}
            }
        }
        return new String(s);
    }

    private void swap(char[] s, int left, int right) {
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;
    }
}
// @lc code=end
