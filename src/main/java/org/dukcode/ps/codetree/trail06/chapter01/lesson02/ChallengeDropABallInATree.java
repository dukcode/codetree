package org.dukcode.ps.codetree.trail06.chapter01.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-drop-a-ball-in-a-tree/description">LINK</a>
 */
public class ChallengeDropABallInATree {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int[] left;
  private static int[] right;
  private static long k;

  private static List<Integer> leaves;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());

    left = new int[n + 1];
    right = new int[n + 1];

    Arrays.fill(left, -1);
    for (int i = 1; i <= n; i++) {
      st = new StringTokenizer(br.readLine());
      left[i] = Integer.parseInt(st.nextToken());
      right[i] = Integer.parseInt(st.nextToken());
    }

    k = Long.parseLong(br.readLine());

    bw.write(String.valueOf(solve(k)));

    br.close();
    bw.close();
  }

  private static int solve(long k) {
    int now = 1;

    while (!isLeaf(now)) {
      if (left[now] != -1 && right[now] == -1) {
        now = left[now];
        continue;
      } else if (left[now] == -1 && right[now] != -1) {
        now = right[now];
        continue;
      }

      if (k % 2 == 0) {
        now = right[now];
        k = k / 2;
      } else {
        now = left[now];
        k = (k + 1) / 2;
      }

    }

    return now;
  }

  private static boolean isLeaf(int num) {

    return left[num] == -1 && right[num] == -1;
  }
}
