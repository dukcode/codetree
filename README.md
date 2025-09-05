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
  - **역대 가장 더러운 구현** : [LINK](src/main/java/org/dukcode/ps/codetree/trail04/chapter01/lesson05/ChallengeCollisionExperimentWithoutWall.java)

### Chapter 2. Backtracking

- **Lesson 01. K개 중 하나를 N번 선택하기(Simple)
  - Backtracking, DP, Greedy 3가지 풀이 존재 : [LINK](src/main/java/org/dukcode/ps/codetree/trail04/chapter02/lesson01/ChallengeSelectSegmentsWithoutOverlap.java)
  - Backtacking으로 풀면 $O((N + M) * 2^M)$ : [LINK](src/main/java/org/dukcode/ps/codetree/trail04/chapter02/lesson01/ChallengeLadderGame.java)
    - Inversion이란, 배열에서 순서가 뒤바뀐 원소의 쌍을 의미합니다. 즉, 배열 A에서 인덱스 `i < j` 이지만, 값은 `A[i] > A[j]` 인 경우 `(A[i], A[j])`를 하나의 Inversion이라고 합니다.
    - 즉 Inversion의 갯수를 세서 구할 수 있음.
      - Brute Force : $O(N^2)$
      - Divide & Conquer : $O(NlogN)$
- **Lesson 02. K개 중 하나를 N번 선택하기(Conditional)**
  - 함수가 `void`인지 `boolean`인지 판단할 줄 알아야함 : [LINK](src/main/java/org/dukcode/ps/codetree/trail04/chapter02/lesson02/ChallengeFindMinOfPossibleSeries.java)

### Chapter 3. DFS

`discovered`의 의미 :  `discovered`는 "방문했거나 방문할 예정인 길"이라는 본래의 의미임. 벽까지 `discovered`에 포함되면 잃고 "**한 번이라도 고려해 본 모든 좌표**"라는 애매한 의미가 됨.([LINK](src/main/java/org/dukcode/ps/codetree/trail04/chapter04/lesson01/IntroDetermineEscapablenessWith4Ways.java)같이 짜면 안됨)

- **Lesson 01. DFS**
  - 탬플릿 외우기(`visited[here]`체크 위치!) : [LINK](src/main/java/org/dukcode/ps/codetree/trail04/chapter03/lesson01/IntroGraphTraversal.java)
  - 재귀/Stack 두가지로 풀 줄 알기, visited/discovered 차이 알기 : [LINK](src/main/java/org/dukcode/ps/codetree/trail04/chapter03/lesson01/IntroDetermineEscapablenessWith2Ways.java)
  - 문제 조건 잘보기.. TC로 엣지케이스 추가해보기 습관 들이기 : [LINK](src/main/java/org/dukcode/ps/codetree/trail04/chapter03/lesson01/ChallengeComfortZone.java) 

### Chapter 4. BFS

- BFS 여러 시작점 동시 시작 : `Queue`에 시작점 넣어놓기

### Chapter 5. DP

- **Lesson 01. subproblem을 그대로 합치면 되는 DP**
  - 특이한 점화식 유도, 모듈러연산 음수일 때 하나 더해주기 : [LINK](src/main/java/org/dukcode/ps/codetree/trail04/chapter05/lesson01/ChallengeRectangleFill3.java)
  - 특이한 점화식 유도 (카탈란 수) : [LINK](src/main/java/org/dukcode/ps/codetree/trail04/chapter05/lesson01/ChallengeNumberOfUniqueBst.java)
- **Lesson 02. 격자 안에서 한 칸씩 전진하는 DP**
  - Tabluation으로 풀 수 있음? 순서를 강제하는것이 핵심 : [LINK](src/main/java/org/dukcode/ps/codetree/trail04/chapter05/lesson02/ChallengeLisOnTheIntegerGrid.java)
  - `cache`를 어떻게 잡을지 생각하기. `cache`가 계산완료 판단 애매할 때 `calculated` 사용하기 : [LINK](src/main/java/org/dukcode/ps/codetree/trail04/chapter05/lesson02/ChallengeMinimumDifferenceOnTheIntegerGrid2.java)

- **Lesson 04. 아이템을 적절히 고르는 문제**
  - Top Down 어떻게 푸는지 모르겠음. `cache` 조건 설정하는 연습 해야함. : [LINK](src/main/java/org/dukcode/ps/codetree/trail04/chapter05/lesson04/IntroTheSumOfTheSubsequencesIsM.java)
  - 2차원 DP로 풀면 비효율적. 1차원 DP로 풀어보고 비효율적인 이유 분석하기 : [LINK](src/main/java/org/dukcode/ps/codetree/trail04/chapter05/lesson04/ChallengeMaxCoinChange.java)
  - 3가지 방법 으로 풀어보기 : [LINK](src/main/java/org/dukcode/ps/codetree/trail04/chapter05/lesson04/ChallengeKnapsack.java)
  - **DP는 부분문제에서 결과가 유일결정되어야함. 이걸 지키는지 마는지가 곧 DP 실력** : [LINK](src/main/java/org/dukcode/ps/codetree/trail04/chapter05/lesson04/ChallengeMaximumSumPartition.java)
  - **`cache` 사이즈 너무 클 때 상태 공간 뒤집기!!!!, bottom-up으로도 풀어보기** : [LINK](src/main/java/org/dukcode/ps/codetree/trail04/chapter05/lesson04/ChallengeGainExpQuickly.java)

### Chapter 6. DP II

- **Lesson 01. 원하는 State를 정의하여 한 칸씩 나아가는 DP**
  - **제발 경계조건 생각해!!!!!, 부분 유일 결정에 유의해서 `cache` 작성함.** : [LINK](src/main/java/org/dukcode/ps/codetree/trail04/chapter06/lesson01/ChallengeRightEquality.java)
  - 메서드 설계 어려움.. : [LINK](src/main/java/org/dukcode/ps/codetree/trail04/chapter06/lesson01/ChallengeSelectMSections.java)
  - 넘 어렵다.. 왜 이건 앞의 정보를 들고와도 될까?: [LINK](src/main/java/org/dukcode/ps/codetree/trail04/chapter06/lesson01/Challenge369GameChallenge.java)
    - 아마 앞에서부터 결정해야 `n`보다 작은 수들 처리할 수 있음 + 상태에 따른 결과가 과거의 루트와 상관 없이 유일 결정되기 때문에
    - 상태를 잘 정의하자. -> 앞의 정보 가져와도 상관 없음 그냥 상태에 따라서 유일 결정되면 됨! 그래도 햇갈리니까 웬만하면 앞의 정보 안가져오게 짤 수 있으면 짜자..

- **Lesson 02. 연속적이지만 직전 상황에 영향을 받는 DP**
  - 앞의 정보를 어쩔 수 없이 가져와야함. 판단력 키우기 : [LINK](src/main/java/org/dukcode/ps/codetree/trail04/chapter06/lesson02/IntroSelectProperClothes.java)
  - 문제 잘 읽기, 엣지케이스 생각 : [LINK](src/main/java/org/dukcode/ps/codetree/trail04/chapter06/lesson02/ChallengeCollectCrystals.java)
  - 쉽게 풀었는데 좀 재미있었음 : [LINK](src/main/java/org/dukcode/ps/codetree/trail04/chapter06/lesson02/ChallengeRotationMagicCircle.java)
  - **어려움!!!! 빨리감기 문제, 자연수 분할 활용** : [LINK](src/main/java/org/dukcode/ps/codetree/trail04/chapter06/lesson02/ChallengeNumberPuzzle.java)
    - 자연수 분할 DP : 1이 포함된 경우, 1이 포함안된경우(다 1씩 까면 됨)

- **Lesson 03. String Matching**
  - 최대 LCS 거리, 전형적인 문제, 기억하자 : [LINK](src/main/java/org/dukcode/ps/codetree/trail04/chapter06/lesson03/IntroLongestCommonSequence.java)
  - 최소 편집 거리, 전형적일지도? : [LINK](src/main/java/org/dukcode/ps/codetree/trail04/chapter06/lesson03/ChallengeEditDistance.java)
  - 복구 로직 : [LINK](src/main/java/org/dukcode/ps/codetree/trail04/chapter06/lesson03/ChallengeLongestCommonSequence2.java)
  - **필수로 다시 풀기!** `solve()`를 재귀로 짜면 메모리 터짐.. DP 두번 쓰는 아이디어. 외우기..? : [LINK](src/main/java/org/dukcode/ps/codetree/trail04/chapter06/lesson03/ChallengeLongestCommonSequence3.java)
  - 조건만 조금 달라졌는데 신기했음 : [LINK](src/main/java/org/dukcode/ps/codetree/trail04/chapter06/lesson03/TestShortestCommonSupersubsequence.java)