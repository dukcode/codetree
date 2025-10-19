package org.dukcode.ps.codetree.trail05.chapter04.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-flip-up-down-left-right/description">LINK</a>
 */
public class ChallengeFlipUpDownLeftRight {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int[][] board;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());

    board = new int[n][n];
    for (int y = 0; y < n; y++) {
      st = new StringTokenizer(br.readLine());
      for (int x = 0; x < n; x++) {
        board[y][x] = Integer.parseInt(st.nextToken());
      }
    }

    bw.write(String.valueOf(solve()));

    br.close();
    bw.close();
  }

  private static int solve() {
    int ret = 0;

    final int[] dy = {-1, 1, 0, 0};
    final int[] dx = {0, 0, -1, 1};
    for (int y = 1; y < n; y++) {
      for (int x = 0; x < n; x++) {
        if (board[y - 1][x] == 1) {
          continue;
        }

        board[y][x] = board[y][x] == 0 ? 1 : 0;
        for (int dir = 0; dir < 4; ++dir) {
          int ny = y + dy[dir];
          int nx = x + dx[dir];

          if (ny < 0 || ny >= n || nx < 0 || nx >= n) {
            continue;
          }

          board[ny][nx] = board[ny][nx] == 0 ? 1 : 0;
        }

        ret++;
      }
    }

    for (int x = 0; x < n; x++) {
      if (board[n - 1][x] == 0) {
        return -1;
      }
    }

    return ret;
  }

}
