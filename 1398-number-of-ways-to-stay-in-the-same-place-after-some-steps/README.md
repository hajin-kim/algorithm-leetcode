<h2><a href="https://leetcode.com/problems/number-of-ways-to-stay-in-the-same-place-after-some-steps">1398. Number of
Ways to Stay in the Same Place After Some Steps</a></h2><h3>Hard</h3>

---

### 풀이

최적화가 필요한 DP입니다.

arrLen이 steps보다 압도적으로 크지만, 실제로는 좌우로 한칸씩 움직이는 것만 고려하면 됩니다.
그래서 arrLen이 1,000,000이어도, 실제로 500 스텝동안 도달할 수 있는 건 인덱스 501이 최대입니다.
따라서 실질적으로 고려하는 배열 크기는 min(arrLen, steps + 2) 로 정해도 됩니다.

이렇게 하면 N이 100만에서 500으로 줄어드는 효과가 생깁니다.

- 공간 최적화: DP배열 크기를 위 min값으로 합니다. O(min(arrLen, steps))
- 시간 최적화: 매 반복마다 DP배열 순회를 위 min값까지만 합니다. O(steps * min(arrLen, steps))

<hr><p>You have a pointer at index <code>0</code> in an array of size <code>arrLen</code>. At each step, you can move 1 position to the left, 1 position to the right in the array, or stay in the same place (The pointer should not be placed outside the array at any time).</p>

<p>Given two integers <code>steps</code> and <code>arrLen</code>, return the number of ways such that your pointer is still at index <code>0</code> after <strong>exactly</strong> <code>steps</code> steps. Since the answer may be too large, return it <strong>modulo</strong> <code>10<sup>9</sup> + 7</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> steps = 3, arrLen = 2
<strong>Output:</strong> 4
<strong>Explanation: </strong>There are 4 differents ways to stay at index 0 after 3 steps.
Right, Left, Stay
Stay, Right, Left
Right, Stay, Left
Stay, Stay, Stay
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> steps = 2, arrLen = 4
<strong>Output:</strong> 2
<strong>Explanation:</strong> There are 2 differents ways to stay at index 0 after 2 steps
Right, Left
Stay, Stay
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> steps = 4, arrLen = 2
<strong>Output:</strong> 8
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= steps &lt;= 500</code></li>
	<li><code>1 &lt;= arrLen &lt;= 10<sup>6</sup></code></li>
</ul>
