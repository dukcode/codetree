package org.dukcode.ps.codetree.trail04.chapter01.lesson04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-escape-maze-with-wall-following/description">LINK</a>
 */
public class ChallengeEscapeMazeWithWallFollowing {

  // 우 상 좌 하
  private static final int[] DY = {0, -1, 0, 1};
  private static final int[] DX = {1, 0, -1, 0};

  private static final int NONE = 0;
  private static final int WALL = 1;

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int r;
  private static int c;
  private static int[][] board;
  private static boolean[][][] visited;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());

    st = new StringTokenizer(br.readLine());
    r = Integer.parseInt(st.nextToken()) - 1;
    c = Integer.parseInt(st.nextToken()) - 1;

    board = new int[n][n];
    for (int y = 0; y < n; y++) {
      String line = br.readLine();
      for (int x = 0; x < n; x++) {
        int block = line.charAt(x) == '#' ? WALL : NONE;
        board[y][x] = block;
      }
    }

    visited = new boolean[n][n][4];

    int cnt = getCnt();

    bw.write(String.valueOf(cnt));

    br.close();
    bw.close();

  }

  private static int getCnt() {
    int cnt = 0;

    int y = r;
    int x = c;
    int dir = 0;
    while (true) {

      if (visited[y][x][dir]) {
        return -1;
      }

      visited[y][x][dir] = true;

      int ny = y + DY[dir];
      int nx = x + DX[dir];

      if (outOfRange(ny, nx)) {
        cnt++;
        break;
      }

      if (board[ny][nx] == WALL) {
        dir = (dir + 1) % 4;
        continue;
      }

      int onRightDir = (dir + 3) % 4;
      int nyRight = ny + DY[onRightDir];
      int nxRight = nx + DX[onRightDir];
      if (board[nyRight][nxRight] == WALL) {
        cnt++;
        y = ny;
        x = nx;
      } else {
        cnt += 2;
        y = nyRight;
        x = nxRight;
        dir = onRightDir;
      }

    }

    return cnt;
  }

  private static boolean outOfRange(int y, int x) {
    return y < 0 || y >= n || x < 0 || x >= n;
  }
}
