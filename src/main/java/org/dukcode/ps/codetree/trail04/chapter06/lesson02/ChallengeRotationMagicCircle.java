package org.dukcode.ps.codetree.trail04.chapter06.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-rotation-magic-circle/description">LINK</a>
 */
public class ChallengeRotationMagicCircle {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static char[] arr;
  private static char[] targetArr;

  // 반시계 : 뒤에꺼 모두다 반시계
  // 시계 : 움직인 것만 시계
  // 순서 강제 해도 상관 없음
  private static int[][] cache;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());
    arr = br.readLine().toCharArray();
    targetArr = br.readLine().toCharArray();

    bw.write(String.valueOf(solve()));

    br.close();
    bw.close();
  }

  private static int solve() {
    cache = new int[n][10];
    for (int i = 0; i < n; i++) {
      Arrays.fill(cache[i], -1);
    }
    return solve(0, 0);
  }

  private static int solve(int idx, int base) {
    if (idx == n) {
      return 0;
    }

    if (cache[idx][base] != -1) {
      return cache[idx][base];
    }

    int top = ((arr[idx] - '0') + base) % 10;
    int target = targetArr[idx] - '0';
    int cw = (top + 10 - target) % 10; // top: 3, target:0
    int ccw = (target + 10 - top) % 10; // target: 3 , top 0

    return cache[idx][base] = Math.min(
        solve(idx + 1, (base + ccw) % 10) + ccw,
        solve(idx + 1, base) + cw
    );
  }
}
