<h2><a href="https://leetcode.com/problems/median-of-two-sorted-arrays">4. Median of Two Sorted Arrays</a></h2><h3>
Hard</h3><hr>

## Solution

Define separators `mid1` and `mid2` such that

- `nums1` is divided into two parts at `mid1`.
    - `nums1[0:mid1]` is the left minimal part. Let's call it `mins1`.
    - `nums1[mid1:m]` is the right maximal part. Let's call it `maxs1`.
- `nums2` is divided into two parts at `mid2`.
    - `nums2[0:mid2]` is the left minimal part. Let's call it `mins2`.
    - `nums2[mid2:n]` is the right maximal part. Let's call it `maxs2`.
- `mins1 & mins2` and `maxs1 & maxs2` are the left and right parts of the merged array, respectively.
    - `mins1 & mins2` and `maxs1 & maxs2` should have the same length or differ by 1.
    - Every elements in `mins1 & mins2` are smaller than every elements in `maxs1 & maxs2`.

Now, initially assign `mid1` as the middle index of `nums1`.
`mid2` is derived by `mid2 = (m + n + 1) // 2 - mid1`, by the size constraint of `mins1 & mins2` and `maxs1 & maxs2`.

Then, we can check if `mins1 & mins2` and `maxs1 & maxs2` are valid by

- Given that the candidates of the maximum of `mins1 & mins2` is `nums1[mid1 - 1]` and `nums2[mid2 - 1]`.
- Given that the candidates of the minimum of `maxs1 & maxs2` is `nums1[mid1]` and `nums2[mid2]`.
- Both `nums1[mid1 - 1]` and `nums2[mid2 - 1]` should be smaller than or equal to `nums1[mid1]` and `nums2[mid2]`.

Note that always `nums1[mid1 - 1] <= nums1[mid1]` and `nums2[mid2 - 1] <= nums2[mid2]`.
Now, we want to find `mid1` and `mid2` that satisfies the above conditions, using **binary search**.

- If the above conditions are satisfied, that is `nums1[mid1 - 1] <= nums2[mid2]` and `nums2[mid2 - 1] <= nums1[mid1]`,
  then we found the valid `mid1` and `mid2`.
- If `nums1[mid1 - 1] > nums2[mid2]`, then shorten `mins1`.
- If `nums2[mid2 - 1] > nums1[mid1]`, then shorten `mins2`.

Finally, the median is  `min(maxs1 & maxs2)` or `(max(mins1 & mins2) + min(maxs1 & maxs2)) / 2`.
Note that `max(mins1 & mins2) = max(nums1[mid1 - 1], nums2[mid2 - 1])`
and `min(maxs1 & maxs2) = min(nums1[mid1], nums2[mid2])`.

---

<p>Given two sorted arrays <code>nums1</code> and <code>nums2</code> of size <code>m</code> and <code>n</code> respectively, return <strong>the median</strong> of the two sorted arrays.</p>

<p>The overall run time complexity should be <code>O(log (m+n))</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums1 = [1,3], nums2 = [2]
<strong>Output:</strong> 2.00000
<strong>Explanation:</strong> merged array = [1,2,3] and median is 2.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums1 = [1,2], nums2 = [3,4]
<strong>Output:</strong> 2.50000
<strong>Explanation:</strong> merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>nums1.length == m</code></li>
	<li><code>nums2.length == n</code></li>
	<li><code>0 &lt;= m &lt;= 1000</code></li>
	<li><code>0 &lt;= n &lt;= 1000</code></li>
	<li><code>1 &lt;= m + n &lt;= 2000</code></li>
	<li><code>-10<sup>6</sup> &lt;= nums1[i], nums2[i] &lt;= 10<sup>6</sup></code></li>
</ul>
