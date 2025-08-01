package org.dukcode.ps.codetree.trail04.chapter02.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-select-segments-without-overlap/description">LINK</a>
 */
public class ChallengeSelectSegmentsWithoutOverlap {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static Line[] lines;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());
    lines = new Line[n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int frIn = Integer.parseInt(st.nextToken());
      int enIn = Integer.parseInt(st.nextToken());
      lines[i] = new Line(frIn, enIn);
    }

    Arrays.sort(lines, (l1, l2) -> l1.frIn == l2.frIn ? Integer.compare(l1.enIn, l2.enIn)
        : Integer.compare(l1.frIn, l2.frIn));

    bw.write(String.valueOf(solve(-1)));

    br.close();
    bw.close();

  }

  private static int solve(int lastIdx) {
    if (lastIdx == n) {
      return 0;
    }

    int lastEn = lastIdx == -1 ? -1 : lines[lastIdx].enIn;

    int ret = 0;
    for (int idx = lastIdx + 1; idx < n; ++idx) {
      if (lastEn >= lines[idx].frIn) {
        continue;
      }

      ret = Math.max(ret, solve(idx) + 1);
    }

    return ret;
  }

  private static class Line {

    int frIn;
    int enIn;

    public Line(int frIn, int enIn) {
      this.frIn = frIn;
      this.enIn = enIn;
    }
  }
}
