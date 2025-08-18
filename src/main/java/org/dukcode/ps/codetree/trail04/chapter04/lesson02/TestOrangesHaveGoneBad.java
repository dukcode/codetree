package org.dukcode.ps.codetree.trail04.chapter04.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/test-oranges-have-gone-bad/description">LINK</a>
 */
public class TestOrangesHaveGoneBad {

  private static final int[] DY = {-1, 1, 0, 0};
  private static final int[] DX = {0, 0, -1, 1};

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int k;
  private static int[][] board;
  private static int[][] times;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    times = new int[n][n];
    for (int y = 0; y < n; y++) {
      Arrays.fill(times[y], -1);
    }

    board = new int[n][n];
    Queue<Pos> q = new ArrayDeque<>();
    for (int y = 0; y < n; y++) {
      st = new StringTokenizer(br.readLine());
      for (int x = 0; x < n; x++) {
        board[y][x] = Integer.parseInt(st.nextToken());

        if (board[y][x] == 2) {
          q.offer(new Pos(y, x));
          times[y][x] = 0;
        } else if (board[y][x] == 1) {
          times[y][x] = -2;
        }
      }
    }

    while (!q.isEmpty()) {
      Pos cur = q.poll();

      for (int dir = 0; dir < 4; dir++) {
        int ny = cur.y + DY[dir];
        int nx = cur.x + DX[dir];

        if (ny < 0 || ny >= n || nx < 0 || nx >= n) {
          continue;
        }

        if (board[ny][nx] == 0) {
          continue;
        }

        if (times[ny][nx] != -1 && times[ny][nx] != -2) {
          continue;
        }

        times[ny][nx] = times[cur.y][cur.x] + 1;
        q.offer(new Pos(ny, nx));
      }
    }

    for (int y = 0; y < n; y++) {
      for (int x = 0; x < n; x++) {
        bw.write(String.valueOf(times[y][x]));
        bw.write(' ');
      }
      bw.newLine();
    }

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
  }
}
