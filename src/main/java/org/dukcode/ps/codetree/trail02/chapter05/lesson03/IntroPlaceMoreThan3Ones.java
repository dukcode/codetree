package org.dukcode.ps.codetree.trail02.chapter05.lesson03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-place-more-than-3-ones/description">LINK</a>
 */
public class IntroPlaceMoreThan3Ones {

  private static final int[] DY = {0, 0, -1, 1};
  private static final int[] DX = {-1, 1, 0, 0};

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int[][] board;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());
    board = new int[n][n];
    for (int y = 0; y < n; y++) {
      st = new StringTokenizer(br.readLine());
      for (int x = 0; x < n; x++) {
        board[y][x] = Integer.parseInt(st.nextToken());
      }
    }

    bw.write(String.valueOf(solve()));

    br.close();
    bw.close();

  }

  private static int solve() {
    int ret = 0;
    for (int y = 0; y < n; y++) {
      for (int x = 0; x < n; x++) {
        if (cntOneNear(y, x) >= 3) {
          ret++;
        }
      }
    }

    return ret;
  }

  private static int cntOneNear(int y, int x) {
    int cnt = 0;
    for (int dir = 0; dir < 4; dir++) {
      int ny = y + DY[dir];
      int nx = x + DX[dir];

      if (ny < 0 || ny >= n || nx < 0 || nx >= n) {
        continue;
      }

      if (board[ny][nx] == 1) {
        cnt++;
      }
    }

    return cnt;
  }
}
