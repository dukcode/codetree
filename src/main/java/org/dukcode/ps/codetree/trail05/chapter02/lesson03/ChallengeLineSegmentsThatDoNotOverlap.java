package org.dukcode.ps.codetree.trail05.chapter02.lesson03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-line-segments-that-do-not-overlap/description">LINK</a>
 */
public class ChallengeLineSegmentsThatDoNotOverlap {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static Segment[] segments;

  private static int[] leftMaxX2;
  private static int[] rightMinX2;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());

    segments = new Segment[n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int x1 = Integer.parseInt(st.nextToken());
      int x2 = Integer.parseInt(st.nextToken());

      segments[i] = new Segment(x1, x2);
    }

    Arrays.sort(segments);

    leftMaxX2 = new int[n];
    for (int i = 0; i < n; i++) {
      leftMaxX2[i] = Math.max((i == 0 ? Integer.MIN_VALUE : leftMaxX2[i - 1]), segments[i].x2);
    }

    rightMinX2 = new int[n];
    for (int i = n - 1; i >= 0; i--) {
      rightMinX2[i] = Math.min((i == n - 1 ? Integer.MAX_VALUE : rightMinX2[i + 1]),
          segments[i].x2);
    }

    int ans = 0;
    for (int i = 0; i < n; i++) {
      if (i > 0 && leftMaxX2[i - 1] >= segments[i].x2) {
        continue;
      }

      if (i < n - 1 && rightMinX2[i + 1] <= segments[i].x2) {
        continue;
      }

      ans++;
    }

    bw.write(String.valueOf(ans));

    br.close();
    bw.close();
  }


  private static class Segment implements Comparable<Segment> {

    int x1;
    int x2;

    public Segment(int x1, int x2) {
      this.x1 = x1;
      this.x2 = x2;
    }

    @Override
    public int compareTo(Segment o) {
      return Integer.compare(x1, o.x1);
    }
  }
}
