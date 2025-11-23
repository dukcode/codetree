package org.dukcode.ps.codetree.trail06.chapter02.lesson03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-connecting-cities/description">LINK</a>
 */
public class ChallengeConnectingCities {

  private static final int MX = 987_654_321;

  private static final int[] DY = {-1, 1, 0, 0};
  private static final int[] DX = {0, 0, -1, 1};

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;
  private static int[][] board;
  private static int[][] posToIdx;

  private static int size;
  private static int[][] adj;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    board = new int[n][m];
    for (int y = 0; y < n; y++) {
      st = new StringTokenizer(br.readLine());
      for (int x = 0; x < m; x++) {
        board[y][x] = Integer.parseInt(st.nextToken());
      }
    }

    buildAdj();

    bw.write(String.valueOf(solve()));

    br.close();
    bw.close();
  }

  private static int solve() {
    int[] dists = new int[size];
    Arrays.fill(dists, MX);
    boolean[] visited = new boolean[size];

    dists[0] = 0;

    int ret = 0;
    for (int i = 0; i < size; ++i) {

      int from = -1;
      for (int idx = 0; idx < size; ++idx) {
        if (visited[idx]) {
          continue;
        }

        if (from == -1 || dists[idx] < dists[from]) {
          from = idx;
        }
      }

      visited[from] = true;
      ret += dists[from];

      for (int to = 0; to < size; ++to) {
        dists[to] = Math.min(dists[to], adj[from][to]);
      }

    }

    return ret >= MX ? -1 : ret;
  }

  private static void buildAdj() {
    posToIdx = new int[n][m];
    for (int y = 0; y < n; y++) {
      Arrays.fill(posToIdx[y], -1);
    }

    size = 0;
    for (int y = 0; y < n; y++) {
      for (int x = 0; x < m; x++) {
        if (board[y][x] == 0) {
          continue;
        }

        posToIdx[y][x] = size++;
      }
    }

    adj = new int[size][size];
    for (int i = 0; i < size; i++) {
      Arrays.fill(adj[i], MX);
    }

    for (int y = 0; y < n; y++) {
      for (int x = 0; x < m; x++) {
        if (board[y][x] == 0) {
          continue;
        }

        for (int dir = 0; dir < 4; dir++) {
          int dist = 1;
          while (true) {
            int ny = y + DY[dir] * dist;
            int nx = x + DX[dir] * dist;

            if (ny < 0 || ny >= n || nx < 0 || nx >= m) {
              break;
            }

            if (board[ny][nx] == 1) {
              int fromIdx = posToIdx[y][x];
              int toIdx = posToIdx[ny][nx];
              adj[fromIdx][toIdx] = dist - 1;
            }

            dist++;
          }
        }
      }
    }

  }

}
