package org.dukcode.ps.codetree.trail04.chapter01.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/test-max-area-of-positive-rectangle/description">LINK</a>
 */
public class TestMaxAreaOfPositiveRectangle {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int h;
  private static int w;
  private static int[][] board;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    h = Integer.parseInt(st.nextToken());
    w = Integer.parseInt(st.nextToken());

    board = new int[h][w];
    for (int y = 0; y < h; y++) {
      st = new StringTokenizer(br.readLine());
      for (int x = 0; x < w; x++) {
        board[y][x] = Integer.parseInt(st.nextToken());
      }
    }

    bw.write(String.valueOf(solve()));

    br.close();
    bw.close();

  }

  private static int solve() {
    int ret = -1;

    for (int y1 = 0; y1 < h; y1++) {
      for (int x1 = 0; x1 < w; x1++) {
        for (int y2 = y1; y2 < h; y2++) {
          for (int x2 = x1; x2 < w; x2++) {
            if (isPositiveSquare(y1, x1, y2, x2)) {
              int area = (y2 - y1 + 1) * (x2 - x1 + 1);
              ret = Math.max(ret, area);
            }
          }
        }
      }
    }

    return ret;
  }

  private static boolean isPositiveSquare(int r1, int c1, int r2, int c2) {
    for (int y = r1; y <= r2; y++) {
      for (int x = c1; x <= c2; x++) {
        if (board[y][x] <= 0) {
          return false;
        }
      }
    }

    return true;
  }
}
