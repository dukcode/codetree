package org.dukcode.ps.codetree.trail04.chapter01.lesson05;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-sequential-movement-of-stacked-numbers/description">LINK</a>
 */
public class ChallengeSequentialMovementOfStackedNumbers {

  private static final int[] DY = {-1, -1, -1, 0, 1, 1, 1, 0};
  private static final int[] DX = {-1, 0, 1, 1, 1, 0, -1, -1};

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;
  private static Deque<Integer>[][] board;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    board = new Deque[n][n];
    for (int y = 0; y < n; y++) {
      st = new StringTokenizer(br.readLine());
      for (int x = 0; x < n; x++) {
        board[y][x] = new ArrayDeque<>();
        board[y][x].offerLast(Integer.parseInt(st.nextToken()));
      }
    }

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < m; ++i) {
      int num = Integer.parseInt(st.nextToken());

      int[] result = findNum(num);
      int r = result[0];
      int c = result[1];
      int size = result[2];

      int maxR = -1;
      int maxC = -1;
      int maxVal = -1;
      for (int dir = 0; dir < 8; ++dir) {
        int nr = r + DY[dir];
        int nc = c + DX[dir];

        if (nr < 0 || nr >= n || nc < 0 || nc >= n) {
          continue;
        }

        Deque<Integer> dq = board[nr][nc];

        for (int j = 0; j < dq.size(); ++j) {
          int val = dq.peekFirst();
          if (maxVal < val) {
            maxVal = val;
            maxR = nr;
            maxC = nc;
          }

          dq.offerLast(dq.pollFirst());
        }

      }

      if (maxVal == -1) {
        for (int j = 0; j < size; ++j) {
          board[r][c].offerLast(board[r][c].pollFirst());
        }
      } else {
        for (int j = 0; j < size; ++j) {
          board[maxR][maxC].offerLast(board[r][c].pollFirst());
        }
      }


    }

    for (int y = 0; y < n; y++) {
      for (int x = 0; x < n; x++) {
        Deque<Integer> dq = board[y][x];

        if (dq.isEmpty()) {
          bw.write("None");
        } else {
          while (!dq.isEmpty()) {
            bw.write(String.valueOf(dq.pollLast()));
            bw.write(' ');
          }
        }
        bw.newLine();

      }
    }

    br.close();
    bw.close();

  }

  private static int[] findNum(int num) {
    for (int y = 0; y < n; y++) {
      for (int x = 0; x < n; x++) {
        Deque<Integer> dq = board[y][x];
        int size = dq.size();

        for (int i = 0; i < size; ++i) {
          int cand = dq.peekFirst();

          if (num == cand) {
            return new int[]{y, x, size - i};
          }

          dq.offerLast(dq.pollFirst());
        }
      }
    }

    return null;
  }

}
