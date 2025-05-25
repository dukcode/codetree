package org.dukcode.ps.codetree.trail02.chapter06.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-find-hidden-words-2/description">LINK</a>
 */
public class ChallengeFindHiddenWords2 {

  private static final int[][] DIR = {
      {0, -1}, {0, 1}, {-1, 0}, {1, 0}, {1, 1}, {1, -1}, {-1, -1}, {-1, 1}
  };

  private static final char[] LEE = {'L', 'E', 'E'};

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int h;
  private static int w;
  private static char[][] board;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    h = Integer.parseInt(st.nextToken());
    w = Integer.parseInt(st.nextToken());
    board = new char[h][];
    for (int y = 0; y < h; y++) {
      board[y] = br.readLine().toCharArray();
    }

    int ans = 0;
    for (int y = 0; y < h; y++) {
      for (int x = 0; x < w; x++) {
        ans += cntLee(y, x);
      }
    }

    bw.write(String.valueOf(ans));

    br.close();
    bw.close();

  }

  private static int cntLee(int y, int x) {

    int ret = 0;
    Loop:
    for (int dir = 0; dir < 8; ++dir) {
      int ny = y;
      int nx = x;
      for (int i = 0; i < 3; ++i) {
        if (ny < 0 || ny >= h || nx < 0 || nx >= w) {
          continue Loop;
        }

        if (board[ny][nx] != LEE[i]) {
          continue Loop;
        }

        ny += DIR[dir][0];
        nx += DIR[dir][1];
      }

      ret++;
    }

    return ret;
  }
}
