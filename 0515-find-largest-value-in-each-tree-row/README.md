<h2><a href="https://leetcode.com/problems/find-largest-value-in-each-tree-row">515. Find Largest Value in Each Tree
Row</a></h2><h3>Medium</h3>

---

### 풀이

BFS 원리를 살짝 응용합니다.

우선 루트를 큐에 넣습니다.

현재 queue의 사이즈(즉 row의 사이즈)만큼 원소를 꺼내서 최댓값을 체크하고, 자식 노드가 있다면 다시 큐에 넣습니다.
이만큼이 row 하나를 체크한 것입니다.

이를 더 이상 자식이 없어 queue가 빌 때까지 반복합니다.

<hr><p>Given the <code>root</code> of a binary tree, return <em>an array of the largest value in each row</em> of the tree <strong>(0-indexed)</strong>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/08/21/largest_e1.jpg" style="width: 300px; height: 172px;" />
<pre>
<strong>Input:</strong> root = [1,3,2,5,3,null,9]
<strong>Output:</strong> [1,3,9]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> root = [1,2,3]
<strong>Output:</strong> [1,3]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the tree will be in the range <code>[0, 10<sup>4</sup>]</code>.</li>
	<li><code>-2<sup>31</sup> &lt;= Node.val &lt;= 2<sup>31</sup> - 1</code></li>
</ul>
