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
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/test-we-are-the-one/description">LINK</a>
 */
public class TestWeAreTheOne {

  private static final int[] DY = {-1, 1, 0, 0};
  private static final int[] DX = {0, 0, -1, 1};

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int k;
  private static int u;
  private static int d;

  private static int[][] board;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    u = Integer.parseInt(st.nextToken());
    d = Integer.parseInt(st.nextToken());

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
    boolean[] picked = new boolean[n * n];
    return solve(-1, 0, picked);
  }

  private static int solve(int lastIdx, int cnt, boolean[] picked) {
    if (cnt == k) {
      return cntCities(picked);
    }

    int ret = 0;
    for (int idx = lastIdx + 1; idx < n * n; ++idx) {
      if (picked[idx]) {
        continue;
      }

      picked[idx] = true;
      ret = Math.max(ret, solve(idx, cnt + 1, picked));
      picked[idx] = false;
    }

    return ret;
  }

  private static int cntCities(boolean[] picked) {
    boolean[][] discovered = new boolean[n][n];
    Queue<Pos> q = new ArrayDeque<>();

    for (int idx = 0; idx < n * n; ++idx) {
      if (!picked[idx]) {
        continue;
      }
      int y = idx / n;
      int x = idx % n;

      q.offer(new Pos(y, x));
      discovered[y][x] = true;
    }

    int ret = 0;
    while (!q.isEmpty()) {
      Pos cur = q.poll();
      ret++;
      for (int dir = 0; dir < 4; ++dir) {
        int ny = cur.y + DY[dir];
        int nx = cur.x + DX[dir];

        if (ny < 0 || ny >= n || nx < 0 || nx >= n) {
          continue;
        }

        if (discovered[ny][nx]) {
          continue;
        }

        int diff = Math.abs(board[ny][nx] - board[cur.y][cur.x]);
        if (diff < u || d < diff) {
          continue;
        }

        discovered[ny][nx] = true;
        q.offer(new Pos(ny, nx));
      }
    }

    return ret;
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
