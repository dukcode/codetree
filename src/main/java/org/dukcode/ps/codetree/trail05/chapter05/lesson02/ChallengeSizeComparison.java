package org.dukcode.ps.codetree.trail05.chapter05.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-size-comparison/description">LINK</a>
 */
public class ChallengeSizeComparison {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;
  private static int[][] compare;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    compare = new int[n][n];
    for (int i = 0; i < n; i++) {
      Arrays.fill(compare[i], Integer.MAX_VALUE);
      compare[i][i] = 0;
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int biggerIdx = Integer.parseInt(st.nextToken()) - 1;
      int smallerIdx = Integer.parseInt(st.nextToken()) - 1;
      compare[smallerIdx][biggerIdx] = 1;
    }

    for (int mid = 0; mid < n; mid++) {
      for (int fr = 0; fr < n; fr++) {
        for (int to = 0; to < n; to++) {
          if (compare[fr][mid] == Integer.MAX_VALUE || compare[mid][to] == Integer.MAX_VALUE) {
            continue;
          }

          compare[fr][to] = Math.min(compare[fr][to], compare[fr][mid] + compare[mid][to]);
        }
      }
    }

    for (int pivotIdx = 0; pivotIdx < n; pivotIdx++) {
      int cnt = 0;
      for (int idx = 0; idx < n; idx++) {
        if (pivotIdx == idx) {
          continue;
        }

        if (compare[pivotIdx][idx] != Integer.MAX_VALUE
            || compare[idx][pivotIdx] != Integer.MAX_VALUE) {
          continue;
        }

        cnt++;
      }

      bw.write(String.valueOf(cnt));
      bw.newLine();
    }

    br.close();
    bw.close();
  }
}
