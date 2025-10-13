package org.dukcode.ps.codetree.trail05.chapter03.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-drop-the-bomb/description">LINK</a>
 */
public class ChallengeDropTheBomb {

  private static final int MX = 1_000_000_000;

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int k;
  private static int[] points;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    points = new int[n];
    for (int i = 0; i < n; i++) {
      points[i] = Integer.parseInt(br.readLine());
    }

    Arrays.sort(points);

    bw.write(String.valueOf(solve()));

    br.close();
    bw.close();
  }

  private static int solve() {
    int frIn = 0;
    int toEx = (points[n - 1] - points[0] + 1) / 2 + 1;

    while (frIn < toEx) {
      int mid = (frIn + toEx) / 2;

      if (cntBombs(mid) > k) {
        frIn = mid + 1;
      } else {
        toEx = mid;
      }
    }
    return frIn;
  }

  private static int cntBombs(int r) {
    int last = -1;
    int ret = 0;
    for (int i = 0; i < n; ++i) {
      if (last < points[i]) {
        ret++;
        last = points[i] + 2 * r;
      }
    }

    return ret;
  }
}
