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
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-remove-k-walls/description">LINK</a>
 */
public class ChallengeRemoveKWalls {

  private static int n;
  private static int k;
  private static int[][] board;

  private static int sy;
  private static int sx;
  private static int ey;
  private static int ex;

  private static int[][][] distances;

  public static void main(String[] args) throws IOException {
    input();
    init();
    int ans = solve();
    output(ans);

  }

  private static int solve() {
    final int[] DY = {-1, 1, 0, 0};
    final int[] DX = {0, 0, -1, 1};

    Queue<Pos> q = new ArrayDeque<>();
    q.offer(new Pos(k, sy, sx));
    distances[k][sy][sx] = 0;

    while (!q.isEmpty()) {
      Pos cur = q.poll();

      if (cur.y == ey && cur.x == ex) {
        return distances[cur.k][cur.y][cur.x];
      }

      for (int dir = 0; dir < 4; dir++) {
        int ny = cur.y + DY[dir];
        int nx = cur.x + DX[dir];

        if (ny < 0 || ny >= n || nx < 0 || nx >= n) {
          continue;
        }

        if (board[ny][nx] == 1) {
          int nk = cur.k - 1;
          if (nk >= 0 && distances[nk][ny][nx] == -1) {
            distances[nk][ny][nx] = distances[cur.k][cur.y][cur.x] + 1;
            q.offer(new Pos(nk, ny, nx));
          }
        } else {
          if (distances[cur.k][ny][nx] == -1) {
            distances[cur.k][ny][nx] = distances[cur.k][cur.y][cur.x] + 1;
            q.offer(new Pos(cur.k, ny, nx));
          }
        }


      }
    }

    return -1;
  }

  private static void init() {
    distances = new int[k + 1][n][n];
    for (int z = 0; z < k + 1; z++) {
      for (int y = 0; y < n; y++) {
        Arrays.fill(distances[z][y], -1);
      }
    }
  }

  private static void output(int ans) throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(String.valueOf(ans));
    bw.close();
  }

  private static void input() throws IOException {
    StringTokenizer st;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    board = new int[n][n];
    for (int y = 0; y < n; y++) {
      st = new StringTokenizer(br.readLine());
      for (int x = 0; x < n; x++) {
        board[y][x] = Integer.parseInt(st.nextToken());
      }
    }

    st = new StringTokenizer(br.readLine());
    sy = Integer.parseInt(st.nextToken()) - 1;
    sx = Integer.parseInt(st.nextToken()) - 1;

    st = new StringTokenizer(br.readLine());
    ey = Integer.parseInt(st.nextToken()) - 1;
    ex = Integer.parseInt(st.nextToken()) - 1;

    br.close();
  }

  private static class Pos {

    int k;
    int y;
    int x;

    public Pos(int k, int y, int x) {
      this.k = k;
      this.y = y;
      this.x = x;
    }
  }
}
