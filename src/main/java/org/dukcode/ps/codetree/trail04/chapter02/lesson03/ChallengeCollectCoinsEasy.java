package org.dukcode.ps.codetree.trail04.chapter02.lesson03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-collect-coins-easy/description">LINK</a>
 */
public class ChallengeCollectCoinsEasy {

  private static final int MX = 987_654_321;

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static Pos[] coins;
  private static int cntCoin;
  private static Pos start;
  private static Pos end;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());
    coins = new Pos[9];
    cntCoin = 0;
    for (int y = 0; y < n; y++) {
      String line = br.readLine();
      for (int x = 0; x < n; x++) {
        char c = line.charAt(x);

        if (Character.isDigit(c)) {
          coins[c - '1'] = new Pos(y, x);
          cntCoin++;
          continue;
        }

        if (c == 'S') {
          start = new Pos(y, x);
        } else if (c == 'E') {
          end = new Pos(y, x);
        }
      }
    }

    bw.write(String.valueOf(solve()));

    br.close();
    bw.close();

  }

  private static int solve() {
    if (cntCoin < 3) {
      return -1;
    }

    return solve(-1, 0);
  }

  private static int solve(int lastIdx, int cnt) {
    if (cnt == 3) {
      return dist(coins[lastIdx], end);
    }

    int ret = MX;
    for (int idx = lastIdx + 1; idx < 9; ++idx) {
      if (coins[idx] == null) {
        continue;
      }
      int dist = lastIdx == -1 ? dist(start, coins[idx]) : dist(coins[lastIdx], coins[idx]);
      ret = Math.min(ret, solve(idx, cnt + 1) + dist);
    }

    return ret;
  }

  private static int dist(Pos a, Pos b) {
    return Math.abs(a.y - b.y) + Math.abs(a.x - b.x);
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
