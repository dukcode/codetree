package org.dukcode.ps.codetree.trail05.chapter02.lesson05;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-strange-bomb/description">LINK</a>
 */
public class ChallengeStrangeBomb {

  private static final int MX = 1_000_000;

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int k;
  private static int[] bombs;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    bombs = new int[n];
    for (int i = 0; i < n; i++) {
      bombs[i] = Integer.parseInt(br.readLine());
    }

    int ans = -1;
    int[] before = new int[MX + 1];
    Arrays.fill(before, -1);
    for (int idx = 0; idx < n; idx++) {
      int beforeIdx = before[bombs[idx]];
      int dist = idx - beforeIdx;
      if (beforeIdx != -1 && dist <= k) {
        ans = Math.max(ans, bombs[idx]);
      }

      before[bombs[idx]] = idx;
    }

    bw.write(String.valueOf(ans));

    br.close();
    bw.close();
  }
}
