<h2><a href="https://leetcode.com/problems/power-of-four">342. Power of Four</a></h2><h3>Easy</h3>

---

### 풀이

반복을 쓰지 말래서 비트 카운트로 풀었습니다.
1 비트가 오직 1개이고, 그 1 비트 오른쪽에 0 비트 개수가 2의 배수이면 됩니다.

코틀린 내장 함수에 integer bit counting하는 메소드들이 있습니다.
코틀린 최고

<hr><p>Given an integer <code>n</code>, return <em><code>true</code> if it is a power of four. Otherwise, return <code>false</code></em>.</p>

<p>An integer <code>n</code> is a power of four, if there exists an integer <code>x</code> such that <code>n == 4<sup>x</sup></code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> n = 16
<strong>Output:</strong> true
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> n = 5
<strong>Output:</strong> false
</pre><p><strong class="example">Example 3:</strong></p>
<pre><strong>Input:</strong> n = 1
<strong>Output:</strong> true
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>-2<sup>31</sup> &lt;= n &lt;= 2<sup>31</sup> - 1</code></li>
</ul>

<p>&nbsp;</p>
<strong>Follow up:</strong> Could you solve it without loops/recursion?