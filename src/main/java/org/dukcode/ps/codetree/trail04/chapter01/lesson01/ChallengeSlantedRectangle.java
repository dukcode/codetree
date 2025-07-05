package org.dukcode.ps.codetree.trail04.chapter01.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-slanted-rectangle/description">LINK</a>
 */
public class ChallengeSlantedRectangle {

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

    int ans = 0;
    for (int y = 0; y < n; y++) {
      for (int x = 0; x < n; x++) {
        for (int h = 2; h <= n - 1; ++h) {
          for (int w = 2; w <= n - 1; ++w) {
            int minX = x - (h - 1);
            int maxX = x + (w - 1);
            int maxY = y + (h - 1) + (w - 1);

            if (minX < 0 || maxX >= n || maxY >= n) {
              continue;
            }
            ans = Math.max(ans, squareSum(y, x, h, w));
          }
        }
      }
    }

    bw.write(String.valueOf(ans));

    br.close();
    bw.close();

  }

  private static int squareSum(int r, int c, int h, int w) {
    int sum = 0;
    int y = r;
    int x = c;

    for (int i = 0; i < h - 1; ++i) {
      sum += board[y][x];
      y++;
      x--;
    }

    for (int i = 0; i < w - 1; ++i) {
      sum += board[y][x];
      y++;
      x++;
    }

    for (int i = 0; i < h - 1; ++i) {
      sum += board[y][x];
      y--;
      x++;
    }

    for (int i = 0; i < w - 1; ++i) {
      sum += board[y][x];
      y--;
      x--;
    }

    return sum;
  }

}
