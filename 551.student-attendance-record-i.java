/*
 * @lc app=leetcode id=551 lang=java
 *
 * [551] Student Attendance Record I
 *
 * https://leetcode.com/problems/student-attendance-record-i/description/
 *
 * algorithms
 * Easy (46.20%)
 * Likes:    200
 * Dislikes: 714
 * Total Accepted:    67.6K
 * Total Submissions: 146K
 * Testcase Example:  '"PPALLP"'
 *
 * You are given a string representing an attendance record for a student. The
 * record only contains the following three characters:
 * 
 * 
 * 
 * 'A' : Absent. 
 * 'L' : Late.
 * ⁠'P' : Present. 
 * 
 * 
 * 
 * 
 * A student could be rewarded if his attendance record doesn't contain more
 * than one 'A' (absent) or more than two continuous 'L' (late).    
 * 
 * You need to return whether the student could be rewarded according to his
 * attendance record.
 * 
 * Example 1:
 * 
 * Input: "PPALLP"
 * Output: True
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: "PPALLL"
 * Output: False
 * 
 * 
 * 
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean checkRecord(String s) {
        if (s == null)
            return false;
        int absent = 0, late = 0;
        for (char c : s.toCharArray()) {
            if (c == 'A') {
                absent++;
                late = 0;
            } else if (c == 'L') {
                late++;
            }else{
                late = 0;
            }

            if (absent > 1 || late > 2){
                return false;
            }
        }
        return true;
    }
}
// @lc code=end
