package org.dukcode.ps.codetree.trail05.chapter02.lesson03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-rock-paper-scissors-to-see-the-future/description">LINK</a>
 */
public class ChallengeRockPaperScissorsToSeeTheFuture {

  private static final int ROCK = 0;
  private static final int SCISSORS = 1;
  private static final int PAPER = 2;

  private static int L = 0;
  private static int R = 1;

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n; // ~ 100_000

  private static int[] arr;
  private static int[][][] pSumWin; // [r, c, p][l r][idx]

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    input();

    init();

    bw.write(String.valueOf(solve()));

    br.close();
    bw.close();
  }

  private static void input() throws IOException {
    n = Integer.parseInt(br.readLine());

    arr = new int[n];
    for (int i = 0; i < n; i++) {
      String rcp = br.readLine();
      arr[i] = convertToInt(rcp);
    }
  }

  private static void init() {
    pSumWin = new int[3][2][n];
    for (int rcp = 0; rcp < 3; rcp++) {
      for (int i = 0; i < n; ++i) {
        int a = rcp;
        int b = arr[i];
        pSumWin[rcp][L][i] = (i == 0 ? 0 : pSumWin[rcp][L][i - 1]) + canWin(a, b);
      }

      for (int i = n - 1; i > 0; --i) {
        int a = rcp;
        int b = arr[i];
        pSumWin[rcp][R][i] = (i == n - 1 ? 0 : pSumWin[rcp][R][i + 1]) + canWin(a, b);
      }
    }
  }

  private static int solve() {
    int ans = 0;
    for (int rcp = 0; rcp < 3; rcp++) {
      ans = Math.max(ans, pSumWin[rcp][L][n - 1]);
    }

    for (int i = 1; i < n; ++i) {

      for (int before = 0; before < 3; ++before) {
        for (int after = 0; after < 3; ++after) {

          if (before == after) {
            continue;
          }

          ans = Math.max(ans, pSumWin[before][L][i - 1] + pSumWin[after][R][i]);
        }
      }

    }
    return ans;
  }

  private static int canWin(int a, int b) {
    if (a == ROCK && b == SCISSORS ||
        a == SCISSORS && b == PAPER ||
        a == PAPER && b == ROCK) {
      return 1;
    }
    return 0;
  }

  private static int convertToInt(String rcp) {
    if (rcp.equals("H")) {
      return ROCK;
    }

    if (rcp.equals("S")) {
      return SCISSORS;
    }

    return PAPER;
  }
}
