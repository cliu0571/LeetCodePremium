/*
 * @lc app=leetcode id=1154 lang=java
 *
 * [1154] Day of the Year
 *
 * https://leetcode.com/problems/day-of-the-year/description/
 *
 * algorithms
 * Easy (48.88%)
 * Likes:    45
 * Dislikes: 95
 * Total Accepted:    11.3K
 * Total Submissions: 23.1K
 * Testcase Example:  '"2019-01-09"\r'
 *
 * Given a string date representing a Gregorian calendar date formatted as
 * YYYY-MM-DD, return the day number of the year.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: date = "2019-01-09"
 * Output: 9
 * Explanation: Given date is the 9th day of the year in 2019.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: date = "2019-02-10"
 * Output: 41
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: date = "2003-03-01"
 * Output: 60
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: date = "2004-03-01"
 * Output: 61
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * date.length == 10
 * date[4] == date[7] == '-', and all other date[i]'s are digits
 * date represents a calendar date between Jan 1st, 1900 and Dec 31, 2019.
 * 
 */

// @lc code=start
class Solution {
    public int dayOfYear(String date) {
        String[] input = date.split("-");
        int days = Integer.parseInt(input[2]);
        int month = Integer.parseInt(input[1]);
        int feb = isLeapYear(Integer.parseInt(input[0])) ? 29 : 28;
        int[] months = { 31, feb, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        int result = 0;
        for (int i = 0; i < month - 1; i++) {
            result += months[i];
        }
        result += days;
        
        return result;
    }

    private boolean isLeapYear(int year) {
        if (year % 400 == 0)
            return true;
        if (year % 100 == 0)
            return false;
        if (year % 4 == 0)
            return true;
        return false;
    }
}
// @lc code=end
