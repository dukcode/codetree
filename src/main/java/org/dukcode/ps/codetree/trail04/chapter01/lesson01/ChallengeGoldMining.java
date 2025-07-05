package org.dukcode.ps.codetree.trail04.chapter01.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-gold-mining/description">LINK</a>
 */
public class ChallengeGoldMining {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;
  private static int[][] board;

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

    int ans = 0;
    for (int y = 0; y < n; y++) {
      for (int x = 0; x < n; x++) {
        for (int k = 0; k <= 2 * (n - 1); ++k) {
          ans = Math.max(ans, cntGold(y, x, k));
        }
      }
    }

    bw.write(String.valueOf(ans));

    br.close();
    bw.close();

  }

  private static int cntGold(int r, int c, int k) {
    int cost = k * k + (k + 1) * (k + 1);

    int cnt = 0;
    for (int y = r - k; y <= r + k; y++) {
      for (int x = c - k; x <= c + k; x++) {
        if (y < 0 || y >= n || x < 0 || x >= n) {
          continue;
        }

        int dist = Math.abs(y - r) + Math.abs(x - c);
        if (dist > k) {
          continue;
        }

        if (board[y][x] == 1) {
          cnt++;
        }
      }
    }

    if (cnt * m < cost) {
      return 0;
    }

    return cnt;
  }
}
