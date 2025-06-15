# CodeTree 문제 풀이

## Trail 2 : Novice Mid

- 최대공약수 : [LINK](src/main/java/org/dukcode/ps/codetree/trail02/chapter01/lesson01/ChallengeFindTheGreatestCommonDivisor.java)
- 앞 뒤 재귀 : [LINK](src/main/java/org/dukcode/ps/codetree/trail02/chapter02/lesson01/TestStarOutputWithRecursiveFunction2.java)
- 그리디 증명 해보기 : [LINK](src/main/java/org/dukcode/ps/codetree/trail02/chapter03/lesson01/ChallengeGroupOfPairs.java)
  - 주어진 배열의 최댓값(=M)을 어떤 값과 그룹으로 묶어주는 것이 가장 좋을까요? 아마도 최솟값(=m)이라고 추측할 수 있을 것 입니다. 왜냐하면 만약 최댓값과 최솟값이 각각 다른 그룹에 배치된다고 생각해보면 [M, a], [m, b] 이렇게 그룹으로 만들어집니다. 이 때, M+a >= m+b 입니다 (M >= b, a >= m 이므로) 이 그룹들의 a와 m을 서로 바꿔서 [M, m], [a, b]로 만들면 M+m과 a+b라는 값이 최댓값이 될 수 있습니다. 하지만 두 값 모두 M+a보다는 같거나 작습니다.
- 겹치는 이동 구간은 [a, b)로 해야함 : [LINK](src/main/java/org/dukcode/ps/codetree/trail02/chapter04/lesson03/ChallengeAreaBeenToAndFrom2.java)
  - 겹치는 구간을 찾는 문제이므로 배열 x1[ ]과 x2[ ]에 대해 x1[ ]부터 x2[ ] - 1까지 표기해줘야 함에 유의합니다.
- n칸 색칠 주의, 초기값으로 최대/최소 잡아야함 : [LINK](src/main/java/org/dukcode/ps/codetree/trail02/chapter04/lesson03/ChallengePaintingWhiteBlack.java)
- 좌표 주어지고 넓이 구할 때 끝점 빼야함 : [LINK](src/main/java/org/dukcode/ps/codetree/trail02/chapter04/lesson04/IntroTotalWidthOfARectangle2.java)
- 복잡한 시뮬레이션 : [LINK](src/main/java/org/dukcode/ps/codetree/trail02/chapter05/lesson03/ChallengeShootALaserInTheMirror2.java)
- `Set`으로 처리하면 같은 숫자들 가지고 있는지 판단 못함 : [LINK](src/main/java/org/dukcode/ps/codetree/trail02/chapter06/lesson02/ChallengeBeautifulSequence2.java)
- 자리마다 숫자를 정하는 완전탐색 - 어렵게 풀려고 하는 경향 : [LINK](src/main/java/org/dukcode/ps/codetree/trail02/chapter06/lesson03)
- x축, y축에 평행한 삼각형 판단 로직 : [LINK](src/main/java/org/dukcode/ps/codetree/trail02/chapter07/lesson01/IntroCreateTriangle.java)
- 어느 기준으로 순회할건지 판단해야함 : [LINK](src/main/java/org/dukcode/ps/codetree/trail02/chapter07/lesson01/ChallengeRottenCheese.java)
- 내용이 rank인지 order인지 잘 파악해서 풀기 (반례 검증해보기) : [LINK](src/main/java/org/dukcode/ps/codetree/trail02/chapter07/lesson01/ChallengeDevelopersRank.java)
- 최소 범위 미만 최대 범위 초과 고려해야함!! : [LINK](src/main/java/org/dukcode/ps/codetree/trail02/chapter07/lesson02/IntroAdjustingTheTemperatureOfTheDataCenter2.java)
- 원소 하나가 지워진 상황에서 sumDiff 깔끔하게 구하기 : [LINK](src/main/java/org/dukcode/ps/codetree/trail02/chapter08/lesson01/IntroMultiplyTwoAndRemoveOneNumber.java)