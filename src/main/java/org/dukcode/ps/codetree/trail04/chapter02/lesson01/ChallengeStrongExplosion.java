package org.dukcode.ps.codetree.trail04.chapter02.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-strong-explosion/description">LINK</a>
 */
public class ChallengeStrongExplosion {

  private static final int[][][] BOMBS = {
      {{-2, 0}, {-1, 0}, {0, 0}, {1, 0}, {2, 0}},
      {{-1, 0}, {1, 0}, {0, 0}, {0, 1}, {0, -1}},
      {{-1, 1}, {1, -1}, {0, 0}, {1, 1}, {-1, -1}}
  };

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static List<Pos> positions;
  private static int[] types;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());

    positions = new ArrayList<>();
    for (int y = 0; y < n; y++) {
      st = new StringTokenizer(br.readLine());
      for (int x = 0; x < n; x++) {
        int num = Integer.parseInt(st.nextToken());

        if (num == 1) {
          positions.add(new Pos(y, x));
        }
      }
    }

    types = new int[positions.size()];
    bw.write(String.valueOf(solve(0)));

    br.close();
    bw.close();

  }

  private static int solve(int idx) {
    if (idx == positions.size()) {
      return cntDestroyed();
    }

    int ret = 0;
    for (int t = 0; t < 3; ++t) {
      types[idx] = t;
      ret = Math.max(ret, solve(idx + 1));
    }

    return ret;
  }

  private static int cntDestroyed() {
    Set<Pos> set = new HashSet<>();

    for (int idx = 0; idx < positions.size(); idx++) {
      Pos pivot = positions.get(idx);
      for (int i = 0; i < BOMBS[types[idx]].length; ++i) {
        int ny = pivot.y + BOMBS[types[idx]][i][0];
        int nx = pivot.x + BOMBS[types[idx]][i][1];

        if (ny < 0 || ny >= n || nx < 0 || nx >= n) {
          continue;
        }

        set.add(new Pos(ny, nx));
      }
    }

    return set.size();
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
