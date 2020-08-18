/*
 * @lc app=leetcode id=925 lang=java
 *
 * [925] Long Pressed Name
 *
 * https://leetcode.com/problems/long-pressed-name/description/
 *
 * algorithms
 * Easy (40.73%)
 * Likes:    679
 * Dislikes: 106
 * Total Accepted:    46.9K
 * Total Submissions: 116.3K
 * Testcase Example:  '"alex"\n"aaleex"'
 *
 * Your friend is typing his name into a keyboard.  Sometimes, when typing a
 * character c, the key might get long pressed, and the character will be typed
 * 1 or more times.
 * 
 * You examine the typed characters of the keyboard.  Return True if it is
 * possible that it was your friends name, with some characters (possibly none)
 * being long pressed.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: name = "alex", typed = "aaleex"
 * Output: true
 * Explanation: 'a' and 'e' in 'alex' were long pressed.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: name = "saeed", typed = "ssaaedd"
 * Output: false
 * Explanation: 'e' must have been pressed twice, but it wasn't in the typed
 * output.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: name = "leelee", typed = "lleeelee"
 * Output: true
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: name = "laiden", typed = "laiden"
 * Output: true
 * Explanation: It's not necessary to long press any character.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= name.length <= 1000
 * 1 <= typed.length <= 1000
 * The characters of name and typed are lowercase letters.
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int m = name.length(), n = typed.length();
        int i = 0, j = 0;
        
        while(i < m && j < n){
            char c1 = name.charAt(i), c2 = typed.charAt(j);
            if(c1 != c2) return false; // we are handling different chars, no!
            
			// count of consecutive c1/c2
            int count1 = 0; 
            while(i < m && name.charAt(i) == c1){
                count1++;
                i++;
            }
            
			// count of consecutive c1/c2
            int count2 = 0; 
            while(j < n && typed.charAt(j) == c2){
                count2++;
                j++;
            }
            
            if(count2 < count1) return false;
        }
        
		// they both reach the end
        return i == m && j == n;
    }
}
// @lc code=end

