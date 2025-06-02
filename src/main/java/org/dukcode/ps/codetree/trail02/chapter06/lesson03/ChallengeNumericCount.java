package org.dukcode.ps.codetree.trail02.chapter06.lesson03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 숫자 야구 게임 - 가능한 답의 개수를 구하는 문제
 *
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-numeric-count/description">LINK</a>
 */
public class ChallengeNumericCount {

  private static int n;
  private static String[] nums;
  private static int[] strike;
  private static int[] ball;

  public static void main(String[] args) throws IOException {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

      n = Integer.parseInt(br.readLine());

      nums = new String[n];
      strike = new int[n];
      ball = new int[n];
      for (int i = 0; i < n; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        nums[i] = st.nextToken();
        strike[i] = Integer.parseInt(st.nextToken());
        ball[i] = Integer.parseInt(st.nextToken());
      }

      int cnt = 0;
      for (int i = 1; i <= 9; ++i) {
        for (int j = 1; j <= 9; j++) {
          for (int k = 1; k <= 9; k++) {
            if (i == j || j == k || i == k) {
              continue;
            }

            if (isValid(n, i, j, k)) {
              cnt++;
            }

          }
        }
      }

      bw.write(String.valueOf(cnt));
    }
  }

  private static boolean isValid(int n, int i, int j, int k) {
    for (int l = 0; l < n; l++) {
      int x = nums[l].charAt(0) - '0';
      int y = nums[l].charAt(1) - '0';
      int z = nums[l].charAt(2) - '0';

      int cnt1 = 0;
      int cnt2 = 0;
      if (i == x) {
        cnt1++;
      }

      if (j == y) {
        cnt1++;
      }

      if (k == z) {
        cnt1++;
      }

      if (i == y || i == z) {
        cnt2++;
      }

      if (j == x || j == z) {
        cnt2++;
      }

      if (k == x || k == y) {
        cnt2++;
      }

      if (cnt1 != strike[l] || cnt2 != ball[l]) {
        return false;
      }
    }
    return true;
  }

}
