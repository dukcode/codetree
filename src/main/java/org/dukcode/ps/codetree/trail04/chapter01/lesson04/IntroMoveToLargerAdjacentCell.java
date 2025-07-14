package org.dukcode.ps.codetree.trail04.chapter01.lesson04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-move-to-larger-adjacent-cell/description">LINK</a>
 */
public class IntroMoveToLargerAdjacentCell {

  private static final int[] DY = {-1, 1, 0, 0};
  private static final int[] DX = {0, 0, -1, 1};

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int r;
  private static int c;

  private static int[][] board;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    r = Integer.parseInt(st.nextToken()) - 1;
    c = Integer.parseInt(st.nextToken()) - 1;

    board = new int[n][n];
    for (int y = 0; y < n; y++) {
      st = new StringTokenizer(br.readLine());
      for (int x = 0; x < n; x++) {
        board[y][x] = Integer.parseInt(st.nextToken());
      }
    }

    List<Integer> ans = new ArrayList<>();
    while (true) {
      int dir = -1;
      int maxVal = board[r][c];
      ans.add(maxVal);
      for (int d = 0; d < 4; ++d) {
        int ny = r + DY[d];
        int nx = c + DX[d];

        if (ny < 0 || ny >= n || nx < 0 || nx >= n) {
          continue;
        }

        if (board[ny][nx] > maxVal) {
          dir = d;
          break;
        }

      }

      if (dir == -1) {
        break;
      }

      r += DY[dir];
      c += DX[dir];
    }

    for (Integer val : ans) {
      bw.write(String.valueOf(val));
      bw.write(' ');
    }

    br.close();
    bw.close();

  }
}
