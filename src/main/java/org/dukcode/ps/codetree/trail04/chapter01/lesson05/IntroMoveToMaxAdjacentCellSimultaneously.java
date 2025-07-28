package org.dukcode.ps.codetree.trail04.chapter01.lesson05;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-move-to-max-adjacent-cell-simultaneously/description">LINK</a>
 */
public class IntroMoveToMaxAdjacentCellSimultaneously {

  // 상 하 좌 우
  private static final int[] DY = new int[]{-1, 1, 0, 0};
  private static final int[] DX = new int[]{0, 0, -1, 1};

  private static int n;
  private static int m;
  private static int t;

  private static int[][] board;
  private static int[][] count;
  private static int[][] nextCount;

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {

    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    t = Integer.parseInt(st.nextToken());

    board = new int[n][n];
    for (int y = 0; y < n; y++) {
      st = new StringTokenizer(br.readLine());
      for (int x = 0; x < n; x++) {
        board[y][x] = Integer.parseInt(st.nextToken());
      }
    }

    count = new int[n][n];
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int r = Integer.parseInt(st.nextToken()) - 1;
      int c = Integer.parseInt(st.nextToken()) - 1;
      count[r][c] = 1;
    }

    while (t-- > 0) {
      moveAll();
    }

    int ans = 0;
    for (int y = 0; y < n; y++) {
      for (int x = 0; x < n; x++) {
        ans += count[y][x];
      }
    }

    bw.write(String.valueOf(ans));

    br.close();
    bw.close();

  }

  private static boolean inRange(int y, int x) {
    return 0 <= y && y < n && 0 <= x && x < n;
  }

  private static Pos getNextPos(int y, int x) {
    int maxNum = 0;
    Pos maxPos = new Pos(-1, -1);
    for (int i = 0; i < 4; i++) {
      int ny = y + DY[i];
      int nx = x + DX[i];

      if (!inRange(ny, nx)) {
        continue;
      }

      if (board[ny][nx] > maxNum) {
        maxNum = board[ny][nx];
        maxPos = new Pos(ny, nx);
      }
    }

    return maxPos;
  }

  private static void move(int y, int x) {
    Pos nextPos = getNextPos(y, x);
    nextCount[nextPos.y][nextPos.x] += 1;
  }

  public static void moveAll() {
    nextCount = new int[n][n];

    for (int y = 0; y < n; y++) {
      for (int x = 0; x < n; x++) {
        if (count[y][x] == 1) {
          move(y, x);
        }
      }
    }

    for (int x = 0; x < n; x++) {
      for (int y = 0; y < n; y++) {
        if (nextCount[y][x] == 1) {
          count[y][x] = 1;
          continue;
        }

        count[y][x] = 0;
      }
    }
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
