# CodeTree 문제 풀이

## Trail 2 : Novice Mid

---

### Chapter 1. 함수

- **Lesson 01. 값을 반환하는 함수**
  - 최대공약수 : [LINK](src/main/java/org/dukcode/ps/codetree/trail02/chapter01/lesson01/ChallengeFindTheGreatestCommonDivisor.java)

---

### Chapter 2. 재귀함수

- **Lesson 01. 값을 반환하지 않는 재귀함수**
  - 앞 뒤 재귀 : [LINK](src/main/java/org/dukcode/ps/codetree/trail02/chapter02/lesson01/TestStarOutputWithRecursiveFunction2.java)

---

### Chapter 3. 정렬

- **Lesson 01. 일반 정렬**
  - 그리디 증명 해보기 : [LINK](src/main/java/org/dukcode/ps/codetree/trail02/chapter03/lesson01/ChallengeGroupOfPairs.java)
    - 주어진 배열의 최댓값(=M)을 어떤 값과 그룹으로 묶어주는 것이 가장 좋을까요? 아마도 최솟값(=m)이라고 추측할 수 있을 것 입니다.
    - 만약 M과 m이 다른 그룹에 배치되면 [M, a], [m, b]로 묶이는데, [M, m], [a, b]로 바꾸면 더 작은 최대값을 만들 수 있음.

---

### Chapter 4. 시뮬레이션 I

- **Lesson 03. 구간 칠하기**
  - 겹치는 이동 구간은 [a, b)로 해야함 : [LINK](src/main/java/org/dukcode/ps/codetree/trail02/chapter04/lesson03/ChallengeAreaBeenToAndFrom2.java)
    - 겹치는 구간을 찾는 문제이므로 배열 x1[ ]과 x2[ ]에 대해 x1부터 x2 - 1까지로 표기해야 함.
  - n칸 색칠 주의, 초기값으로 최대/최소 잡아야함 : [LINK](src/main/java/org/dukcode/ps/codetree/trail02/chapter04/lesson03/ChallengePaintingWhiteBlack.java)

- **Lesson 04. 사각형 칠하기**
  - 좌표 주어지고 넓이 구할 때 끝점 빼야함 : [LINK](src/main/java/org/dukcode/ps/codetree/trail02/chapter04/lesson04/IntroTotalWidthOfARectangle2.java)

---

### Chapter 5. 시뮬레이션 II

- **Lesson 03. dx dy technique**
  - 복잡한 시뮬레이션 : [LINK](src/main/java/org/dukcode/ps/codetree/trail02/chapter05/lesson03/ChallengeShootALaserInTheMirror2.java)

---

### Chapter 6. 완전탐색 I

- **Lesson 02. 자리 마다 숫자를 정하는 완전탐색**
  - `Set`으로 처리하면 같은 숫자들 가지고 있는지 판단 못함 : [LINK](src/main/java/org/dukcode/ps/codetree/trail02/chapter06/lesson02/ChallengeBeautifulSequence2.java)
- **Lesson 03. 자리 마다 숫자를 정하는 완전탐색**
  - 자리마다 숫자를 정하는 완전탐색 - 어렵게 풀려고 하는 경향 : [LINK](src/main/java/org/dukcode/ps/codetree/trail02/chapter06/lesson03)

---

### Chapter 7. 완전탐색 II

- **Lesson 01. 물체 단위로 완전탐색**
  - x축, y축에 평행한 삼각형 판단 로직 : [LINK](src/main/java/org/dukcode/ps/codetree/trail02/chapter07/lesson01/IntroCreateTriangle.java)
  - 어느 기준으로 순회할건지 판단해야함 : [LINK](src/main/java/org/dukcode/ps/codetree/trail02/chapter07/lesson01/ChallengeRottenCheese.java)
  - 내용이 rank인지 order인지 잘 파악해서 풀기 (반례 검증해보기) : [LINK](src/main/java/org/dukcode/ps/codetree/trail02/chapter07/lesson01/ChallengeDevelopersRank.java)

- **Lesson 02. 값을 기준으로 완전탐색**
  - 최소 범위 미만 최대 범위 초과 고려해야함!! : [LINK](src/main/java/org/dukcode/ps/codetree/trail02/chapter07/lesson02/IntroAdjustingTheTemperatureOfTheDataCenter2.java)

---

### Chapter 8. 완전탐색 III

- **Lesson 01. 상황을 일일이 가정해보고 진행하는 완전탐색**
  - 원소 하나가 지워진 상황에서 sumDiff 깔끔하게 구하기 : [LINK](src/main/java/org/dukcode/ps/codetree/trail02/chapter08/lesson01/IntroMultiplyTwoAndRemoveOneNumber.java)

- **Lesson 02. 상황을 일일이 가정해보고 진행 / 기준을 새로 설정**
  - 정렬 후 arr범위 잡아서 k넘는지 확인하기 vs `[frIn, frIn + k]`범위 잡아서 전체 배열 검사하기 : [LINK](src/main/java/org/dukcode/ps/codetree/trail02/chapter08/lesson02/IntroMaximumDifferenceInNumbers.java)
  - val을 for문돌린건지, 배열을 for문에 돌린건지에 따라 시간 복잡도 판단해야함 (2가지 방법 있음 인지하기!) : [LINK](src/main/java/org/dukcode/ps/codetree/trail02/chapter08/lesson02/IntroGreatJump.java)
  - 반복문 개선 가능한지 고민해보기 : [LINK](src/main/java/org/dukcode/ps/codetree/trail02/chapter08/lesson02/ChallengeRestoreInitialSequence.java)
  - 정확히 폭탄이 터지는 갯수, 그리고 언제 카운트 업데이트할건지 조건 잘 생각해야함 : [LINK](src/main/java/org/dukcode/ps/codetree/trail02/chapter08/lesson02/ChallengeStrangeBomb3.java)
  - 정렬을 가장 먼저 생각했음. 높이를 범위로 잡아서 루프돌리는 방법이 생각이 잘 안났음 : [LINK](src/main/java/org/dukcode/ps/codetree/trail02/chapter08/lesson02/ChallengeHillCutting.java)
  - ⭐️루프 돌리는 주체를 잘생각하기 (시간복잡도 고려하면 99C50은 불가능함을 알 수 있음) : [LINK](src/main/java/org/dukcode/ps/codetree/trail02/chapter08/lesson02/ChallengeDivideSectionsWell.java)
  - 조건 놓치기 쉬움 : [LINK](src/main/java/org/dukcode/ps/codetree/trail02/chapter08/lesson02/ChallengeMaximumHScore2.java)

  - 범위를 먼저 잡고 루프도는게 빠름(생각하기 어려움...) : [LINK](src/main/java/org/dukcode/ps/codetree/trail02/chapter08/lesson02/TestDifferenceBetweenMaximumAndMinimum.java)

---

### Chapter 9. 케이스별로 나누기

- **Lesson 01. 겹치는 경우**
  - n개의 선분이 모두 겹치는 지점이 있는지 판단하기. 뭔가 파란눈 마을 문제 같음 : [LINK](src/main/java/org/dukcode/ps/codetree/trail02/chapter09/lesson01/ChallengeOverlappingLineSegments.java)
- **Lesson 02. 일어난 상황에 대한 추론**
  - ⭐️카톡 단톡방 안읽은 사람 추론 문제(나올 가능성 높을 듯) : [LINK](src/main/java/org/dukcode/ps/codetree/trail02/chapter09/lesson02/ChallengeCodingTalk.java)
  - 이분탐색 말고도 구현으로 푸는 방법 익히기 : [LINK](src/main/java/org/dukcode/ps/codetree/trail02/chapter09/lesson02/TestXRun.java)
- **Lesson 03. 좋은 전략을 추려내기**
  - 최대거리만 고려해서 효율적으로 다시 짜보기 : [LINK](src/main/java/org/dukcode/ps/codetree/trail02/chapter09/lesson03/ChallengeStudyCafeKeepingDistance2.java)

---

### Chap 10. Ad-Hoc

- **Lesson 01. 지극히 최선인 전략이 확실히 정해지는 경우**
  - 배열 한바퀴 돌면서 배열 자르기 while문이 더 나음 : [LINK](src/main/java/org/dukcode/ps/codetree/trail02/chapter10/lesson01/IntroMinimumNumberOfWifi.java)  
  - 수식으로 풀려고 하니까 규칙찾기가 어려웠음 : [LINK](src/main/java/org/dukcode/ps/codetree/trail02/chapter10/lesson01/ChallengeOddEvenBundle.java)
  - 처음엔 생각도 안남(그리디) : [LINK](src/main/java/org/dukcode/ps/codetree/trail02/chapter10/lesson01/ChallengeReorderSequence.java)
  - 그리디 증명 : [LINK](src/main/java/org/dukcode/ps/codetree/trail02/chapter10/lesson01/TestGroupOfPairs2.java)

---

## Trail 3 : Novice High

---

### Chapter 3. 정렬

- **Lesson 03. 삽입 정렬**
  - 삽입정렬 구현.. idx 주의 : [LINK](src/main/java/org/dukcode/ps/codetree/trail03/chapter03/lesson03/ChallengeImplementInsertionSort.java)
- **Lesson 04. 기수 정렬**
  - 기수정렬 구현.. : [LINK](src/main/java/org/dukcode/ps/codetree/trail03/chapter03/lesson04/ChallengeImplementRadixSort.java)
- **Lesson 07. 퀵 정렬**
  - 퀵 정렬 구현.. (partition 방법, base case, 3개중 중앙값 찾기) : [LINK](src/main/java/org/dukcode/ps/codetree/trail03/chapter03/lesson07/ChallengeImplementQuickSort.java)
- **Lesson 08. 힙 정렬**
  - 힙 정렬 구현.. : [LINK](src/main/java/org/dukcode/ps/codetree/trail03/chapter03/lesson08/ChallengeImplementHeapSort.java)

---

## Trail 2 : Novice Mid

---

### Chapter 1. Simulation

- **Lesson 02. 격자 안에서 밀고 당기기**
  - rotate 구현 -> for문 순서 중요 or O(n) 공간복잡도로 옮기기 : [LINK](src/main/java/org/dukcode/ps/codetree/trail04/chapter01/lesson02/ChallengeThe2dWindBlows.java)

- **Lesson 03. 격자 안에서 터지고 떨어지는 경우**
  - 2048 로직(keep)을 이용한, 2차원 배열 회전 : [LINK](src/main/java/org/dukcode/ps/codetree/trail04/chapter01/lesson03/ChallengeOneTrialOf2048Game.java)
  - 문제 잘읽기.. : [LINK](src/main/java/org/dukcode/ps/codetree/trail04/chapter01/lesson03/ChallengeThe2dBombGame.java)

- **Lesson 04. 격자 안에서 단일 객체를 이동**
  - 오른쪽 벽 짚고 탈출 구현 : [LINK](src/main/java/org/dukcode/ps/codetree/trail04/chapter01/lesson04/ChallengeEscapeMazeWithWallFollowing.java)
  - 주사위 앞 위 오 3개로만 구현해보기 : [LINK](src/main/java/org/dukcode/ps/codetree/trail04/chapter01/lesson04/ChallengeRollADice.java)
  - snake 구현 : [LINK](src/main/java/org/dukcode/ps/codetree/trail04/chapter01/lesson04/ChallengeSnakeLovesApples.java)

- **Lesson 05. 격자 안에서 여러 객체를 이동**
  - 여러개가 만나 터지는 경우를 고려할 수 있는 힘, 시간복잡도 계산하고 개선해보기 : [LINK](src/main/java/org/dukcode/ps/codetree/trail04/chapter01/lesson05/ChallengeCollisionExperimentWithWall.java)
  - 구현하는데 오래걸림 : [LINK](src/main/java/org/dukcode/ps/codetree/trail04/chapter01/lesson05/ChallengeSequentialMovementOfStackedNumbers.java)