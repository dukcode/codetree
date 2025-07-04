package org.dukcode.ps.codetree.trail04.chapter01.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-number-of-happy-sequence/description">LINK</a>
 */
public class ChallengeNumberOfHappySequence {

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

    bw.write(String.valueOf(cntHappySeq()));

    br.close();
    bw.close();

  }

  private static int cntHappySeq() {
    int ret = 0;
    for (int i = 0; i < n; i++) {
      if (isHappySeq(i, true)) {
        ret++;
      }

      if (isHappySeq(i, false)) {
        ret++;
      }
    }

    return ret;
  }

  private static boolean isHappySeq(int idx, boolean isRow) {
    int cnt = 0;
    int num = -1;
    for (int i = 0; i < n; ++i) {
      int val = isRow ? board[idx][i] : board[i][idx];

      if (val == num) {
        cnt++;
      } else {
        num = val;
        cnt = 1;
      }

      if (cnt >= m) {
        return true;
      }
    }

    return false;
  }

}