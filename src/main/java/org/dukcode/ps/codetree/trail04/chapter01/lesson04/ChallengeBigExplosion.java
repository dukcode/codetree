package org.dukcode.ps.codetree.trail04.chapter01.lesson04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-big-explosion/description">LINK</a>
 */
public class ChallengeBigExplosion {

  private static final int[] DY = {-1, 1, 0, 0};
  private static final int[] DX = {0, 0, -1, 1};

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;
  private static int r;
  private static int c;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    r = Integer.parseInt(st.nextToken()) - 1;
    c = Integer.parseInt(st.nextToken()) - 1;

    Set<Pos> bombs = new HashSet<>();

    bombs.add(new Pos(r, c));

    for (int i = 0; i < m; i++) {
      Set<Pos> cur = new HashSet<>();

      for (Pos bomb : bombs) {
        cur.add(bomb);
        int y = bomb.y;
        int x = bomb.x;
        for (int dir = 0; dir < 4; ++dir) {
          int ny = y + (DY[dir] << i);
          int nx = x + (DX[dir] << i);

          if (ny < 0 || ny >= n || nx < 0 || nx >= n) {
            continue;
          }

          cur.add(new Pos(ny, nx));
        }
      }

      bombs = cur;
    }

    bw.write(String.valueOf(bombs.size()));

    br.close();
    bw.close();

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
