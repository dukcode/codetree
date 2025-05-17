# CodeTree 문제 풀이

## Trail 2 : Novice Mid

- 최대공약수 : [LINK](src/main/java/org/dukcode/ps/codetree/trail02/chapter01/lesson01/ChallengeFindTheGreatestCommonDivisor.java)
- 앞 뒤 재귀 : [LINK](src/main/java/org/dukcode/ps/codetree/trail02/chapter02/lesson01/TestStarOutputWithRecursiveFunction2.java)
- 그리디 증명 해보기 : [LINK](src/main/java/org/dukcode/ps/codetree/trail02/chapter03/lesson01/ChallengeGroupOfPairs.java)
  - 주어진 배열의 최댓값(=M)을 어떤 값과 그룹으로 묶어주는 것이 가장 좋을까요? 아마도 최솟값(=m)이라고 추측할 수 있을 것 입니다. 왜냐하면 만약 최댓값과 최솟값이 각각 다른 그룹에 배치된다고 생각해보면 [M, a], [m, b] 이렇게 그룹으로 만들어집니다. 이 때, M+a >= m+b 입니다 (M >= b, a >= m 이므로) 이 그룹들의 a와 m을 서로 바꿔서 [M, m], [a, b]로 만들면 M+m과 a+b라는 값이 최댓값이 될 수 있습니다. 하지만 두 값 모두 M+a보다는 같거나 작습니다.
- 겹치는 이동 구간은 [a, b)로 해야함 : [LINK](src/main/java/org/dukcode/ps/codetree/trail02/chapter04/lesson03/ChallengeAreaBeenToAndFrom2.java)
  - 겹치는 구간을 찾는 문제이므로 배열 x1[ ]과 x2[ ]에 대해 x1[ ]부터 x2[ ] - 1까지 표기해줘야 함에 유의합니다.