package org.dukcode.ps.codetree.trail04.chapter04.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-glacier/description">LINK</a>
 */
public class ChallengeGlacier {

  private static final int[] DY = {-1, 1, 0, 0};
  private static final int[] DX = {0, 0, -1, 1};

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int h;
  private static int w;

  private static int[][] board;

  private static int lastMeltCnt;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    h = Integer.parseInt(st.nextToken());
    w = Integer.parseInt(st.nextToken());

    board = new int[h][w];
    for (int y = 0; y < h; y++) {
      st = new StringTokenizer(br.readLine());
      for (int x = 0; x < w; x++) {
        board[y][x] = Integer.parseInt(st.nextToken());
      }
    }

    bw.write(String.valueOf(solve()));
    bw.write(' ');
    bw.write(String.valueOf(lastMeltCnt));

    br.close();
    bw.close();

  }

  private static int solve() {
    int time = 0;
    while (melt()) {
      time++;
    }

    return time;
  }

  private static boolean melt() {
    boolean[][] discovered = new boolean[h][w];
    Queue<Pos> q = new ArrayDeque<>();
    q.offer(new Pos(0, 0));
    discovered[0][0] = true;

    Set<Pos> toMelts = new HashSet<>();
    while (!q.isEmpty()) {
      Pos cur = q.poll();
      for (int dir = 0; dir < 4; dir++) {
        int ny = cur.y + DY[dir];
        int nx = cur.x + DX[dir];

        if (ny < 0 || ny >= h || nx < 0 || nx >= w) {
          continue;
        }

        if (discovered[ny][nx]) {
          continue;
        }

        if (board[ny][nx] == 1) {
          toMelts.add(new Pos(ny, nx));
          continue;
        }

        discovered[ny][nx] = true;
        q.offer(new Pos(ny, nx));
      }
    }

    if (toMelts.isEmpty()) {
      return false;
    }

    lastMeltCnt = toMelts.size();
    for (Pos toMelt : toMelts) {
      board[toMelt.y][toMelt.x] = 0;
    }

    return true;
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
