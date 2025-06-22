package org.dukcode.ps.codetree.trail02.chapter10.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/test-all-inclusive-segment/description">LINK</a>
 */
public class TestAllInclusiveSegment {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    Line[] lines = new Line[n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int x1 = Integer.parseInt(st.nextToken());
      int x2 = Integer.parseInt(st.nextToken());
      lines[i] = new Line(x1, x2);
    }

    Arrays.sort(lines, Comparator.comparingInt(line -> line.x1));
    int maxX2 = Integer.MIN_VALUE;
    for (int i = 1; i < n; ++i) {
      maxX2 = Math.max(maxX2, lines[i].x2);
    }

    int ans = maxX2 - lines[1].x1;

    Arrays.sort(lines, Comparator.comparingInt(line -> -line.x2));
    int minX1 = Integer.MAX_VALUE;
    for (int i = 1; i < n; ++i) {
      minX1 = Math.min(minX1, lines[i].x1);
    }

    ans = Math.min(ans, lines[1].x2 - minX1);

    bw.write(String.valueOf(ans));

    br.close();
    bw.close();

  }

  private static class Line {

    int x1;
    int x2;

    public Line(int x1, int x2) {
      this.x1 = x1;
      this.x2 = x2;
    }
  }
}
