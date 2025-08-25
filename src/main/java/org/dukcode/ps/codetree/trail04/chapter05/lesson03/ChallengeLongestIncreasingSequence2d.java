package org.dukcode.ps.codetree.trail04.chapter05.lesson03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-longest-increasing-sequence-2d/description">LINK</a>
 */
public class ChallengeLongestIncreasingSequence2d {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;
  private static int[][] board;
  private static int[][] cache;

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

    bw.write(String.valueOf(solve()));

    br.close();
    bw.close();
  }

  private static int solve() {
    cache = new int[n][m];
    return solve(0, 0);
  }

  private static int solve(int y, int x) {
    if (cache[y][x] != 0) {
      return cache[y][x];
    }

    int ret = 1;
    for (int ny = y + 1; ny < n; ny++) {
      for (int nx = x + 1; nx < m; nx++) {
        if (board[ny][nx] <= board[y][x]) {
          continue;
        }

        ret = Math.max(ret, solve(ny, nx) + 1);
      }
    }

    return cache[y][x] = ret;
  }
}
