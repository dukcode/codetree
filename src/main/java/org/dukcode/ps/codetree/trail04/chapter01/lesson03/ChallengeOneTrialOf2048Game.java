package org.dukcode.ps.codetree.trail04.chapter01.lesson03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-one-trial-of-2048-game/description">LINK</a>
 */
public class ChallengeOneTrialOf2048Game {

  private static final int N = 4;

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int[][] board;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    board = new int[N][N];
    for (int y = 0; y < N; y++) {
      st = new StringTokenizer(br.readLine());
      for (int x = 0; x < N; x++) {
        board[y][x] = Integer.parseInt(st.nextToken());
      }
    }

    String command = br.readLine();
    move(command);

    for (int y = 0; y < N; y++) {
      for (int x = 0; x < N; x++) {
        bw.write(String.valueOf(board[y][x]));
        bw.write(' ');
      }
      bw.newLine();
    }

    br.close();
    bw.close();

  }

  private static void move(String command) {
    int dir = convertToDir(command);
    rotateCW(dir);
    moveLeft();
    rotateCW(4 - dir);

  }

  private static int convertToDir(String command) {
    switch (command) {
      case "L":
        return 0;
      case "D":
        return 1;
      case "R":
        return 2;
      case "U":
        return 3;
      default:
        return -1;
    }
  }

  private static void moveLeft() {
    for (int y = 0; y < N; y++) {
      int keep = -1;
      int pos = 0;
      for (int x = 0; x < N; x++) {
        if (board[y][x] == 0) {
          continue;
        }

        if (keep == -1) {
          keep = board[y][x];
          continue;
        }

        if (board[y][x] == keep) {
          board[y][pos++] = keep * 2;
          board[y][x] = 0;
          keep = -1;
          continue;
        }

        board[y][pos++] = keep;
        keep = board[y][x];
        board[y][x] = 0;
      }

      if (keep != -1) {
        board[y][pos++] = keep;
      }

      while (pos < N) {
        board[y][pos++] = 0;
      }
    }
  }

  private static void rotateCW(int cnt) {
    for (int i = 0; i < cnt; ++i) {
      for (int y = 0; y < N; y++) {
        for (int x = y + 1; x < N; x++) {
          int tmp = board[y][x];
          board[y][x] = board[x][y];
          board[x][y] = tmp;
        }
      }

      for (int y = 0; y < N; y++) {
        for (int x = 0; x < N / 2; x++) {
          int tmp = board[y][x];
          board[y][x] = board[y][N - 1 - x];
          board[y][N - 1 - x] = tmp;
        }
      }
    }
  }
}
