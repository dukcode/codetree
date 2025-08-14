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
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-places-can-go/description">LINK</a>
 */
public class ChallengePlacesCanGo {

  private static final int[] DY = {-1, 1, 0, 0};
  private static final int[] DX = {0, 0, -1, 1};

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;
  private static int[][] board;

  private static Pos[] starts;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    board = new int[n][n];
    for (int y = 0; y < n; y++) {
      st = new StringTokenizer(br.readLine());
      for (int x = 0; x < n; x++) {
        board[y][x] = Integer.parseInt(st.nextToken());
      }
    }

    starts = new Pos[m];
    for (int i = 0; i < m; ++i) {
      st = new StringTokenizer(br.readLine());
      int y = Integer.parseInt(st.nextToken()) - 1;
      int x = Integer.parseInt(st.nextToken()) - 1;

      starts[i] = new Pos(y, x);
    }

    boolean[][] discovered = new boolean[n][n];
    int totalCnt = getTotalCnt(discovered, starts);

    bw.write(String.valueOf(totalCnt));

    br.close();
    bw.close();

  }

  private static int getTotalCnt(boolean[][] discovered, Pos[] starts) {
    int ret = 0;
    for (int i = 0; i < m; ++i) {
      int y = starts[i].y;
      int x = starts[i].x;

      if (discovered[y][x]) {
        continue;
      }

      ret += getCnt(discovered, y, x);
    }
    return ret;
  }

  private static int getCnt(boolean[][] discovered, int y, int x) {
    Queue<Pos> q = new ArrayDeque<>();
    q.offer(new Pos(y, x));
    discovered[y][x] = true;
    int cnt = 0;

    while (!q.isEmpty()) {
      Pos cur = q.poll();
      cnt++;
      for (int dir = 0; dir < 4; ++dir) {
        int ny = cur.y + DY[dir];
        int nx = cur.x + DX[dir];

        if (ny < 0 || ny >= n || nx < 0 || nx >= n) {
          continue;
        }

        if (discovered[ny][nx] || board[ny][nx] == 1) {
          continue;
        }

        discovered[ny][nx] = true;
        q.offer(new Pos(ny, nx));
      }
    }
    return cnt;
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
