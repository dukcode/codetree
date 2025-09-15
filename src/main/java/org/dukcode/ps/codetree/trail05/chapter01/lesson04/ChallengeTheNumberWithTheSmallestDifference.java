package org.dukcode.ps.codetree.trail05.chapter01.lesson04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-the-number-with-the-smallest-difference/description">LINK</a>
 */
public class ChallengeTheNumberWithTheSmallestDifference {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    TreeSet<Integer> set = new TreeSet<>();
    int ans = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++) {
      int num = Integer.parseInt(br.readLine());

      if (set.floor(num - m) != null) {
        ans = Math.min(ans, num - set.floor(num - m));
      }

      if (set.ceiling(num + m) != null) {
        ans = Math.min(ans, set.ceiling(num + m) - num);
      }

      set.add(num);
    }

    bw.write(String.valueOf(ans == Integer.MAX_VALUE ? -1 : ans));

    br.close();
    bw.close();
  }
}
