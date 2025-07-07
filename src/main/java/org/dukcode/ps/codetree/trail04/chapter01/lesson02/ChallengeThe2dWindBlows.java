package org.dukcode.ps.codetree.trail04.chapter01.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-The-2D-wind-blows/description">LINK</a>
 */
public class ChallengeThe2dWindBlows {

  private static final int[] DY = {0, -1, 1, 0};
  private static final int[] DX = {1, 0, 0, -1};

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int h;
  private static int w;
  private static int q;
  private static int[][] board;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    h = Integer.parseInt(st.nextToken());
    w = Integer.parseInt(st.nextToken());
    q = Integer.parseInt(st.nextToken());

    board = new int[h][w];
    for (int y = 0; y < h; y++) {
      st = new StringTokenizer(br.readLine());
      for (int x = 0; x < w; x++) {
        board[y][x] = Integer.parseInt(st.nextToken());
      }
    }

    for (int i = 0; i < q; ++i) {
      st = new StringTokenizer(br.readLine());
      int r1 = Integer.parseInt(st.nextToken()) - 1;
      int c1 = Integer.parseInt(st.nextToken()) - 1;
      int r2 = Integer.parseInt(st.nextToken()) - 1;
      int c2 = Integer.parseInt(st.nextToken()) - 1;

      blow(r1, c1, r2, c2);
      convertToAvg(r1, c1, r2, c2);
    }

    for (int y = 0; y < h; y++) {
      for (int x = 0; x < w; x++) {
        bw.write(String.valueOf(board[y][x]));
        bw.write(' ');
      }
      bw.newLine();
    }

    br.close();
    bw.close();

  }

  private static void convertToAvg(int r1, int c1, int r2, int c2) {
    int[][] tmp = new int[h][w];
    for (int y = 0; y < h; y++) {
      System.arraycopy(board[y], 0, tmp[y], 0, w);
    }

    for (int y = r1; y <= r2; y++) {
      for (int x = c1; x <= c2; x++) {
        tmp[y][x] = avg(y, x);
      }
    }

    board = tmp;
  }

  private static int avg(int y, int x) {
    int cnt = 1;
    int sum = board[y][x];
    for (int dir = 0; dir < 4; dir++) {
      int ny = y + DY[dir];
      int nx = x + DX[dir];

      if (ny < 0 || ny >= h || nx < 0 || nx >= w) {
        continue;
      }

      cnt++;
      sum += board[ny][nx];
    }

    return sum / cnt;
  }

  private static void blow(int r1, int c1, int r2, int c2) {
    int tmp = board[r1][c2];
    for (int x = c2; x > c1; --x) { // 순서 중요
      board[r1][x] = board[r1][x - 1];
    }

    for (int y = r1; y < r2; ++y) { // 순서 : 영향 미치지 않는 순서
      board[y][c1] = board[y + 1][c1];
    }

    for (int x = c1; x < c2; ++x) {
      board[r2][x] = board[r2][x + 1];
    }

    for (int y = r2; y > r1; --y) {
      board[y][c2] = board[y - 1][c2];
    }

    board[r1 + 1][c2] = tmp; // tmp 1개로 충분
  }
}
