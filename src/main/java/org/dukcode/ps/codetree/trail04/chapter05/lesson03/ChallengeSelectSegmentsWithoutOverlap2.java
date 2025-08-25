package org.dukcode.ps.codetree.trail04.chapter05.lesson03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-select-segments-without-overlap-2/description">LINK</a>
 */
public class ChallengeSelectSegmentsWithoutOverlap2 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static Line[] lines;

  private static int[] cache;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());
    lines = new Line[n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int frIn = Integer.parseInt(st.nextToken());
      int toIn = Integer.parseInt(st.nextToken());
      lines[i] = new Line(frIn, toIn);
    }

    Arrays.sort(lines);

    bw.write(String.valueOf(solve()));

    br.close();
    bw.close();

  }

  private static int solve() {
    cache = new int[n + 1];
    return solve(-1) - 1;
  }

  private static int solve(int idx) {
    if (cache[idx + 1] != 0) {
      return cache[idx + 1];
    }

    int ret = 1;
    int nowToIn = idx == -1 ? -1 : lines[idx].toIn;
    for (int nextIdx = idx + 1; nextIdx < n; nextIdx++) {
      int nextFrIn = lines[nextIdx].frIn;

      if (nowToIn >= nextFrIn) {
        continue;
      }

      ret = Math.max(ret, solve(nextIdx) + 1);
    }

    return cache[idx + 1] = ret;
  }

  private static class Line implements Comparable<Line> {

    int frIn;
    int toIn;

    public Line(int frIn, int toIn) {
      this.frIn = frIn;
      this.toIn = toIn;
    }

    @Override
    public int compareTo(Line o) {
      return this.toIn == o.toIn ?
          Integer.compare(this.frIn, o.frIn) :
          Integer.compare(this.toIn, o.toIn);
    }
  }
}
