package org.dukcode.ps.codetree.trail02.chapter05.lesson03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/test-add-all-the-numbers-on-the-path/description">LINK</a>
 */
public class TestAddAllTheNumbersOnThePath {

  // U R D L
  private static final int Y = 0;
  private static final int X = 1;
  private static final int[][] DIR = {
      {-1, 0}, {0, 1}, {1, 0}, {0, -1}
  };

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int t;
  private static char[] commands;
  private static int[][] board;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    t = Integer.parseInt(st.nextToken());
    commands = br.readLine().toCharArray();

    board = new int[n][n];
    for (int y = 0; y < n; y++) {
      st = new StringTokenizer(br.readLine());
      for (int x = 0; x < n; x++) {
        board[y][x] = Integer.parseInt(st.nextToken());
      }
    }

    int r = n / 2;
    int c = n / 2;
    int dir = 0;

    int sum = board[r][c];
    for (char command : commands) {
      switch (command) {
        case 'L':
          dir = (dir + 3) % 4;
          break;
        case 'R':
          dir = (dir + 1) % 4;
          break;
        case 'F':
          int nr = r + DIR[dir][Y];
          int nc = c + DIR[dir][X];
          if (nr < 0 || nc < 0 || nr >= n || nc >= n) {
            continue;
          }
          r = nr;
          c = nc;
          sum += board[r][c];
          break;
        default:
          break;
      }
    }

    bw.write(String.valueOf(sum));

    br.close();
    bw.close();

  }
}
