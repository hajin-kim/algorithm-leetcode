<h2><a href="https://leetcode.com/problems/backspace-string-compare">874. Backspace String Compare</a></h2><h3>Easy</h3>

---

### 풀이

Optional task인 O(N) 시간 + O(1) 공간을 준수하는 풀이입니다.

두 문자를 뒤에서부터 체크합니다.
공간 유지를 위해 문자를 카피하거나 하면 안 되고, 각각의 현재 인덱스를 저장할 변수만 운영해야 합니다.

대충 다음을 반복하면 됩니다.

1. 백스페이싱이 필요한 만큼 각각의 인덱스 이동
2. 각각의 인덱스의 두 문자가 같은지 비교 → 다르면 `return false`
3. 인덱스 1 앞으로

두 인덱스중 하나가 0보다 작아질 때까지(-1이 될 때까지) 반복하면 됩니다.
최종적으로 두 인덱스가 모두 0보다 작다면 true, 그렇지 않다면(반복 탈출 조건에서 이미 하나는 -1일테니, 둘의 값이 서로 다르다면) false 입니다.

<hr><p>Given two strings <code>s</code> and <code>t</code>, return <code>true</code> <em>if they are equal when both are typed into empty text editors</em>. <code>&#39;#&#39;</code> means a backspace character.</p>

<p>Note that after backspacing an empty text, the text will continue empty.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;ab#c&quot;, t = &quot;ad#c&quot;
<strong>Output:</strong> true
<strong>Explanation:</strong> Both s and t become &quot;ac&quot;.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;ab##&quot;, t = &quot;c#d#&quot;
<strong>Output:</strong> true
<strong>Explanation:</strong> Both s and t become &quot;&quot;.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;a#c&quot;, t = &quot;b&quot;
<strong>Output:</strong> false
<strong>Explanation:</strong> s becomes &quot;c&quot; while t becomes &quot;b&quot;.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code><span>1 &lt;= s.length, t.length &lt;= 200</span></code></li>
	<li><span><code>s</code> and <code>t</code> only contain lowercase letters and <code>&#39;#&#39;</code> characters.</span></li>
</ul>

<p>&nbsp;</p>
<p><strong>Follow up:</strong> Can you solve it in <code>O(n)</code> time and <code>O(1)</code> space?</p>
