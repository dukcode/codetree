package org.dukcode.ps.codetree.trail02.chapter09.lesson04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Objects;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-l-r-and-b/description">LINK</a>
 */
public class ChallengeLRAndB {

  private static final int N = 10;

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static Pos l;
  private static Pos r;
  private static Pos b;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    for (int y = 0; y < N; y++) {
      String line = br.readLine();
      for (int x = 0; x < N; x++) {
        int block = line.charAt(x);

        if (block == 'L') {
          l = new Pos(y, x);
        }

        if (block == 'R') {
          r = new Pos(y, x);
        }

        if (block == 'B') {
          b = new Pos(y, x);
        }
      }

    }

    bw.write(String.valueOf(solve()));

    br.close();
    bw.close();

  }

  private static int solve() {
    if (l.y == b.y && l.y == r.y && Math.min(l.x, b.x) <= r.x && r.x <= Math.max(l.x, b.x)) {
      return Math.abs(l.x - b.x) + 2 - 1;
    }

    if (l.x == b.x && l.x == r.x && Math.min(l.y, b.y) <= r.y && r.y <= Math.max(l.y, b.y)) {
      return Math.abs(l.y - b.y) + 2 - 1;
    }

    return Math.abs(l.y - b.y) + Math.abs(l.x - b.x) - 1;
  }

  private static class Pos {

    int y;
    int x;

    public Pos(int y, int x) {
      this.y = y;
      this.x = x;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      Pos pos = (Pos) o;
      return y == pos.y && x == pos.x;
    }

    @Override
    public int hashCode() {
      return Objects.hash(y, x);
    }
  }
}
