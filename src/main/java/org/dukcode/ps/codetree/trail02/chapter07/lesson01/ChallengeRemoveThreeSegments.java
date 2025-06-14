package org.dukcode.ps.codetree.trail02.chapter07.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-remove-three-segments/description">LINK</a>
 */
public class ChallengeRemoveThreeSegments {

  private static final int NUM_DELETE = 3;

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static Line[] lines;
  private static boolean[] deleted;

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

    deleted = new boolean[n];
    bw.write(String.valueOf(solve(-1, 0)));

    br.close();
    bw.close();

  }

  private static int solve(int lastIdx, int cnt) {
    if (cnt == NUM_DELETE) {
      return overlapped() ? 0 : 1;
    }

    int ret = 0;
    for (int nowIdx = lastIdx + 1; nowIdx < n; ++nowIdx) {
      deleted[nowIdx] = true;
      ret += solve(nowIdx, cnt + 1);
      deleted[nowIdx] = false;
    }

    return ret;
  }

  private static boolean overlapped() {
    for (int i = 0; i < n; i++) {
      if (deleted[i]) {
        continue;
      }
      for (int j = i + 1; j < n; j++) {
        if (deleted[j] || i == j) {
          continue;
        }

        if (lines[i].overlap(lines[j])) {
          return true;
        }
      }
    }

    return false;
  }

  private static class Line {

    int frIn;
    int toIn;

    public Line(int frIn, int toIn) {

      this.frIn = frIn;
      this.toIn = toIn;
    }

    public boolean overlap(Line other) {
      return this.toIn >= other.frIn && other.toIn >= this.frIn;
    }
  }
}
