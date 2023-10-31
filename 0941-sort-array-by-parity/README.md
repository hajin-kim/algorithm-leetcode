<h2><a href="https://leetcode.com/problems/sort-array-by-parity">941. Sort Array By Parity</a></h2><h3>Easy</h3><hr>

### 후기

특별한 알고리즘 없이 구현하면 되는 쉬운 문제입니다.

방법은 많지만 선형 시간은 보장하는 것이 좋습니다.
공간 복잡도는 상수 공간(in-place)이든 선형 공간이든 각자의 선택인 것 같네요.

### 풀이

저는 직관적이고 내장 라이브러리에 존재하는 deque로 풀었습니다.
코드가 간결하고 가독성이 높습니다.

그 외에 고려해볼 방법이 몇 가지 있습니다.

- 배열 또는 리스트를 홀/짝 각각 만들고 나중에 합치기
- 배열을 하나 만들어 양끝부터 채우기
- in-place, selection 알고리즘
  앞에서부터 보다가 홀수를 찾으면 저장
  뒤에서부터 보다가 짝수를 찾으면 그 위치에 저장된 홀수로 덮어씌우고 찾은 짝수를 저장
  앞에서부터 보다가 홀수를 찾으면 그 위치에 저장된 짝수로 덮어씌우고 찾은 홀수를 저장
  다 될 때까지 무한반복

---

<p>Given an integer array <code>nums</code>, move all the even integers at the beginning of the array followed by all the odd integers.</p>

<p>Return <em><strong>any array</strong> that satisfies this condition</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [3,1,2,4]
<strong>Output:</strong> [2,4,3,1]
<strong>Explanation:</strong> The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [0]
<strong>Output:</strong> [0]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 5000</code></li>
	<li><code>0 &lt;= nums[i] &lt;= 5000</code></li>
</ul>
