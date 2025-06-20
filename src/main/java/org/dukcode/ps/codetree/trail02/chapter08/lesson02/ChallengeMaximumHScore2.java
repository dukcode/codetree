package org.dukcode.ps.codetree.trail02.chapter08.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-maximum-h-score-2/description">LINK</a>
 */
public class ChallengeMaximumHScore2 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int l;
  private static int[] arr;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    l = Integer.parseInt(st.nextToken());

    arr = new int[n];
    st = new StringTokenizer(br.readLine());
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
      max = Math.max(max, arr[i]);
    }

    bw.write(String.valueOf(solve(max)));

    br.close();
    bw.close();

  }

  private static int solve(int max) {
    int ret = -1;
    // 0부터 시작해야함 min값부터 시작하면 안됨
    for (int score = max + 1; score >= 0; --score) {
      int cnt = 0;
      int cntMinusOne = 0;
      for (int idx = 0; idx < n; ++idx) {
        if (arr[idx] >= score) {
          cnt++;
        }

        if (arr[idx] + 1 >= score) {
          cntMinusOne++;
        }

      }

      // 조건이 중요함!
      if (Math.min(cnt + l, cntMinusOne) >= score) {
        return score;
      }

    }

    return ret;
  }
}
