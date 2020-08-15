import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=786 lang=java
 *
 * [786] K-th Smallest Prime Fraction
 *
 * https://leetcode.com/problems/k-th-smallest-prime-fraction/description/
 *
 * algorithms
 * Hard (41.07%)
 * Likes:    379
 * Dislikes: 23
 * Total Accepted:    13.8K
 * Total Submissions: 33.7K
 * Testcase Example:  '[1,2,3,5]\n3'
 *
 * A sorted list A contains 1, plus some number of primes.  Then, for every p <
 * q in the list, we consider the fraction p/q.
 * 
 * What is the K-th smallest fraction considered?  Return your answer as an
 * array of ints, where answer[0] = p and answer[1] = q.
 * 
 * 
 * Examples:
 * Input: A = [1, 2, 3, 5], K = 3
 * Output: [2, 5]
 * Explanation:
 * The fractions to be considered in sorted order are:
 * 1/5, 1/3, 2/5, 1/2, 3/5, 2/3.
 * The third fraction is 2/5.
 * 
 * Input: A = [1, 7], K = 1
 * Output: [1, 7]
 * 
 * 
 * Note:
 * 
 * 
 * A will have length between 2 and 2000.
 * Each A[i] will be between 1 and 30000.
 * K will be between 1 and A.length * (A.length - 1) / 2.
 * 
 */

// @lc code=start
// T=O(KlogN)
// S=O(N)
class Solution {
    public int[] kthSmallestPrimeFraction(int[] A, int K) {
        PriorityQueue<MyNode> minHeap = new PriorityQueue<MyNode>((a, b) -> A[a.p] * A[b.q] - A[b.p] * A[a.q]);
        int n = A.length;
        for (int i = 0; i < n; i++)
            minHeap.add(new MyNode(i, n - 1));
        MyNode curr = minHeap.peek();
        while (K-- > 0) {
            curr = minHeap.poll();
            int p = curr.p;
            int q = curr.q;
            if (p < q) {
                minHeap.offer(new MyNode(p, q - 1));
            }
        }
        return new int[] { A[curr.p], A[curr.q] };
    }
}

class MyNode {
    int p, q;

    public MyNode(int p, int q) {
        this.p = p;
        this.q = q;
    }
}

// @lc code=end
