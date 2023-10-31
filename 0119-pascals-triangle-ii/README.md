<h2><a href="https://leetcode.com/problems/pascals-triangle-ii">119. Pascal's Triangle II</a></h2><h3>Easy</h3>

---

### 풀이

와…파스칼 삼각형(이항 계수, combination)의 **같은 행의 인접 원소** 사이에 관계식이 있다는 건 처음 알았습니다.

comb(n, 0) = 1
k = 1, 2, … n → comb(n, k) = comb(n, k-1) * (n - k) / k

이때 이 문제에서 n = rowIndex + 1 입니다.

솔루션 보기 전까지 전혀 몰랐는데, 공식으로 유도해보니까 정말 나오더군요…

자바 등을 이용하신다면 long 처리 잊지 마세요~

<hr><p>Given an integer <code>rowIndex</code>, return the <code>rowIndex<sup>th</sup></code> (<strong>0-indexed</strong>) row of the <strong>Pascal&#39;s triangle</strong>.</p>

<p>In <strong>Pascal&#39;s triangle</strong>, each number is the sum of the two numbers directly above it as shown:</p>
<img alt="" src="https://upload.wikimedia.org/wikipedia/commons/0/0d/PascalTriangleAnimated2.gif" style="height:240px; width:260px" />
<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> rowIndex = 3
<strong>Output:</strong> [1,3,3,1]
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> rowIndex = 0
<strong>Output:</strong> [1]
</pre><p><strong class="example">Example 3:</strong></p>
<pre><strong>Input:</strong> rowIndex = 1
<strong>Output:</strong> [1,1]
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>0 &lt;= rowIndex &lt;= 33</code></li>
</ul>

<p>&nbsp;</p>
<p><strong>Follow up:</strong> Could you optimize your algorithm to use only <code>O(rowIndex)</code> extra space?</p>
