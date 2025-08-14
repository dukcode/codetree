package org.dukcode.ps.codetree.trail04.chapter04.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-determine-escapableness-with-4-ways/description">LINK</a>
 */
public class IntroDetermineEscapablenessWith4Ways {

  private static final int[] DY = {-1, 1, 0, 0};
  private static final int[] DX = {0, 0, -1, 1};

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int h;
  private static int w;

  private static int[][] board;

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

    bw.write(String.valueOf(solve() ? 1 : 0));

    br.close();
    bw.close();

  }

  private static boolean solve() {
    boolean[][] discovered = new boolean[h][w];
    Queue<Pos> q = new ArrayDeque<>();
    q.offer(new Pos(0, 0));
    discovered[0][0] = true;

    while (!q.isEmpty()) {
      Pos cur = q.poll();

      if (cur.y == h - 1 && cur.x == w - 1) {
        return true;
      }

      for (int dir = 0; dir < 4; ++dir) {
        int ny = cur.y + DY[dir];
        int nx = cur.x + DX[dir];

        if (ny < 0 || ny >= h || nx < 0 || nx >= w) {
          continue;
        }

        if (discovered[ny][nx]) {
          continue;
        }

        discovered[ny][nx] = true; // discovered 의미 훼손

        if (board[ny][nx] == 0) {
          continue;
        }

        q.offer(new Pos(ny, nx));
      }
    }

    return false;
  }

  private static class Pos {

    int y;
    int x;

    public Pos(int y, int x) {
      this.y = y;
      this.x = x;
    }
  }
}
