package org.dukcode.ps.codetree.trail06.chapter05.lesson03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/test-number-of-non-overlapping-pairs/description">LINK</a>
 */
public class TestNumberOfNonOverlappingPairs {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int[] groups;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());

    groups = new int[n];
    for (int idx = 0; idx < n; idx++) {
      st = new StringTokenizer(br.readLine());
      int m = Integer.parseInt(st.nextToken());
      for (int i = 0; i < m; i++) {
        int person = Integer.parseInt(st.nextToken());
        groups[idx] |= (1 << person);
      }
    }

    int ans = 0;
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        if ((groups[i] & groups[j]) == 0) {
          ans++;
        }
      }
    }

    bw.write(String.valueOf(ans));

    br.close();
    bw.close();
  }
}
