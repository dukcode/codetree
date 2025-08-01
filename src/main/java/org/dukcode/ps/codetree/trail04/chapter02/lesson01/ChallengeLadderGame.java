package org.dukcode.ps.codetree.trail04.chapter02.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-ladder-game/description">LINK</a>
 */
public class ChallengeLadderGame {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;
  private static Line[] lines;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    lines = new Line[m];
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken()) - 1;
      int h = Integer.parseInt(st.nextToken()) - 1;
      lines[i] = new Line(x, h);
    }

    Arrays.sort(lines, (l1, l2) -> l1.h == l2.h ?
        Integer.compare(l1.x, l2.x) :
        Integer.compare(l1.h, l2.h));

    int[] result = IntStream.range(0, n).toArray();
    for (Line line : lines) {
      swap(result, line.x, line.x + 1);
    }

    int ans = 0;
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        if (result[i] > result[j]) {
          ans++;
        }
      }
    }

    bw.write(String.valueOf(ans));

    br.close();
    bw.close();

  }

  private static void swap(int[] result, int a, int b) {
    int tmp = result[a];
    result[a] = result[b];
    result[b] = tmp;
  }

  private static class Line {

    int x;
    int h;

    public Line(int x, int h) {
      this.x = x;
      this.h = h;
    }
  }
}
