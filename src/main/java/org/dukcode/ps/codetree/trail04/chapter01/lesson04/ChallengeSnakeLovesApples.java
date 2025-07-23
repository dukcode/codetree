package org.dukcode.ps.codetree.trail04.chapter01.lesson04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-snake-loves-apples/description">LINK</a>
 */
public class ChallengeSnakeLovesApples {

  // 우 상 좌 하
  private static final int[] DY = {0, -1, 0, 1};
  private static final int[] DX = {1, 0, -1, 0};

  private static final int APPLE = -1;

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;
  private static int k;
  private static int[][] board;
  private static int[] dirs;
  private static int[] times;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    board = new int[n][n];
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int y = Integer.parseInt(st.nextToken()) - 1;
      int x = Integer.parseInt(st.nextToken()) - 1;
      board[y][x] = APPLE;
    }

    dirs = new int[k];
    times = new int[k];
    for (int i = 0; i < k; ++i) {
      st = new StringTokenizer(br.readLine());
      dirs[i] = dirToIdx(st.nextToken());
      times[i] = Integer.parseInt(st.nextToken());
    }

    bw.write(String.valueOf(solve()));

    br.close();
    bw.close();

  }

  private static int solve() {
    int ret = 0;
    Snake snake = new Snake();
    for (int i = 0; i < k; ++i) {
      int dir = dirs[i];
      for (int t = 0; t < times[i]; t++) {
        ret++;

        if (!snake.move(dir)) {
          return ret;
        }
      }
    }

    return ret;
  }

  private static int dirToIdx(String dir) {
    switch (dir) {
      case "R":
        return 0;
      case "U":
        return 1;
      case "L":
        return 2;
      case "D":
        return 3;
      default:
        return -1;
    }
  }

  private static class Snake {

    Deque<Pos> bodies = new ArrayDeque<>();

    public Snake() {
      bodies.offerLast(new Pos(0, 0));
    }

    public boolean move(int dir) {

      Pos head = bodies.peekFirst();

      int ny = head.y + DY[dir];
      int nx = head.x + DX[dir];

      if (ny < 0 || ny >= n || nx < 0 || nx >= n) {
        return false;
      }

      if (board[ny][nx] == APPLE) {
        board[ny][nx] = 1;
        bodies.offerFirst(new Pos(ny, nx));
        return true;
      }

      Pos tail = bodies.pollLast();
      board[tail.y][tail.x] = 0;
      if (board[ny][nx] == 1) {
        return false;
      }

      bodies.offerFirst(new Pos(ny, nx));
      board[ny][nx] = 1;
      return true;
    }
  }

  private static class Pos {

    int y;
    int x;

    public Pos(int y, int x) {
      this.y = y;
      this.x = x;
    }

    public boolean equals(Pos other) {
      return y == other.y && x == other.x;
    }
  }
}
