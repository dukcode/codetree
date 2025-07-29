package org.dukcode.ps.codetree.trail04.chapter01.lesson05;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-collision-experiment-with-wall/description">LINK</a>
 */
public class ChallengeCollisionExperimentWithWall {

  // U D L R
  private static final int[] DY = {0, -1, 1, 0, 0};
  private static final int[] DX = {0, 0, 0, -1, 1};

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int t;
  private static int n;
  private static int m;
  private static int[][] board;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    t = Integer.parseInt(br.readLine());

    while (t-- > 0) {
      st = new StringTokenizer(br.readLine());
      n = Integer.parseInt(st.nextToken());
      m = Integer.parseInt(st.nextToken());

      board = new int[n][n];
      for (int i = 0; i < m; i++) {
        st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken()) - 1;
        int x = Integer.parseInt(st.nextToken()) - 1;
        int dir = parseDir(st.nextToken());

        board[y][x] = dir;
      }

      for (int i = 0; i < 2 * n; ++i) {
        move();
      }

      int ans = 0;
      for (int y = 0; y < n; y++) {
        for (int x = 0; x < n; x++) {
          if (board[y][x] != 0) {
            ans++;
          }
        }
      }

      bw.write(String.valueOf(ans));
      bw.newLine();
    }

    br.close();
    bw.close();

  }

  private static void move() {
    int[][] tmp = new int[n][n];

    for (int y = 0; y < n; y++) {
      for (int x = 0; x < n; x++) {
        if (board[y][x] == 0) {
          continue;
        }

        int dir = board[y][x];
        int ny = y + DY[dir];
        int nx = x + DX[dir];

        if (ny < 0 || ny >= n || nx < 0 || nx >= n) {
          int oppositeDir = opposite(dir);

          if (tmp[y][x] != 0) {
            tmp[y][x] = -1;
          } else {
            tmp[y][x] = oppositeDir;
          }

          continue;
        }

        if (tmp[ny][nx] != 0) {
          tmp[ny][nx] = -1;
        } else {
          tmp[ny][nx] = dir;
        }

      }
    }

    for (int y = 0; y < n; y++) {
      for (int x = 0; x < n; x++) {
        if (tmp[y][x] == -1) {
          board[y][x] = 0;
          continue;
        }

        board[y][x] = tmp[y][x];
      }
    }
  }

  private static int opposite(int dir) {
    if (dir == 1) {
      return 2;
    }

    if (dir == 2) {
      return 1;
    }

    if (dir == 3) {
      return 4;
    }

    if (dir == 4) {
      return 3;
    }

    return -1;
  }


  private static int parseDir(String dir) {
    switch (dir) {
      // U D L R
      case "U":
        return 1;
      case "D":
        return 2;
      case "L":
        return 3;
      case "R":
        return 4;
      default:
        return -1;
    }
  }

}
