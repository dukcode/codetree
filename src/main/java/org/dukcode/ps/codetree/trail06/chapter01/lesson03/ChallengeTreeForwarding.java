package org.dukcode.ps.codetree.trail06.chapter01.lesson03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-tree-forwarding/description">LINK</a>
 */
public class ChallengeTreeForwarding {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;

  private static List<Integer>[] children;
  private static int[] scores;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    children = new List[n];
    for (int i = 0; i < n; i++) {
      children[i] = new ArrayList<>();
    }

    st = new StringTokenizer(br.readLine());
    for (int idx = 0; idx < n; idx++) {
      int parent = Integer.parseInt(st.nextToken()) - 1;

      if (parent < 0) {
        continue;
      }

      children[parent].add(idx);
    }

    scores = new int[n];

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int idx = Integer.parseInt(st.nextToken()) - 1;
      int w = Integer.parseInt(st.nextToken());

      scores[idx] += w;
    }

    operate(0, 0);

    for (int score : scores) {
      bw.write(String.valueOf(score));
      bw.write(' ');
    }

    br.close();
    bw.close();
  }

  private static void operate(int idx, int w) {
    for (int child : children[idx]) {
      operate(child, scores[idx] + w);
    }

    scores[idx] += w;
  }
}
