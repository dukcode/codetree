package org.dukcode.ps.codetree.trail02.chapter06.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-O-mok/description">LINK</a>
 */
public class ChallengeOMok {

  private static final int BOARD_SIZE = 19;

  private static final int[][] DIR = {
      {0, 1}, {1, 0}, {1, 1}, {1, -1}
  };

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int[][] board;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    board = new int[BOARD_SIZE][BOARD_SIZE];
    for (int y = 0; y < BOARD_SIZE; y++) {
      st = new StringTokenizer(br.readLine());
      for (int x = 0; x < BOARD_SIZE; x++) {
        board[y][x] = Integer.parseInt(st.nextToken());
      }
    }

    Winner winner = solve();
    if (winner == null) {
      bw.write(String.valueOf(0));
    } else {
      bw.write(String.valueOf(winner.winner));
      bw.newLine();
      bw.write(String.valueOf(winner.y + 1));
      bw.write(' ');
      bw.write(String.valueOf(winner.x + 1));
    }

    br.close();
    bw.close();

  }

  private static Winner solve() {
    for (int y = 0; y < BOARD_SIZE; y++) {
      for (int x = 0; x < BOARD_SIZE; x++) {
        for (int dir = 0; dir < 4; ++dir) {
          if (hasWon(y, x, dir)) {
            return new Winner(board[y][x], y + DIR[dir][0] * 2, x + DIR[dir][1] * 2);
          }
        }
      }
    }

    return null;
  }

  private static boolean hasWon(int y, int x, int dir) {
    int base = board[y][x];

    if (base == 0) {
      return false;
    }

    for (int i = 0; i < 5; ++i) {
      if (y < 0 || y >= BOARD_SIZE || x < 0 || x >= BOARD_SIZE) {
        return false;
      }
      if (board[y][x] != base) {
        return false;
      }

      y += DIR[dir][0];
      x += DIR[dir][1];
    }

    return true;
  }

  private static class Winner {

    int winner;
    int y;
    int x;

    public Winner(int winner, int y, int x) {
      this.winner = winner;
      this.y = y;
      this.x = x;
    }
  }
}
