package org.dukcode.ps.codetree.trail06.chapter05.lesson03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-filp-up-down-left-right-2/description">LINK</a>
 */
public class ChallengeFilpUpDownLeftRight2 {

  private static final int MX = 987_654_321;

  private static final int[] DY = {0, 0, 0, -1, 1};
  private static final int[] DX = {0, -1, 1, 0, 0};

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;
  private static int[] board;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    board = new int[n];
    for (int i = 0; i < n; i++) {
      int line = 0;
      st = new StringTokenizer(br.readLine());
      for (int x = 0; x < m; ++x) {
        line = line << 1;
        line |= Integer.parseInt(st.nextToken());
      }

      board[i] = line;
    }

    bw.write(String.valueOf(solve()));

    br.close();
    bw.close();
  }

  private static void print() {
    for (int num : board) {
      System.out.println(
          String.format("%" + m + "s", Integer.toBinaryString(num)).replace(' ', '0'));
    }
    System.out.println();
  }

  private static int solve() {
    int ret = solve(0, 0);
    return ret == MX ? -1 : ret;
  }

  private static int solve(int idx, int cnt) {
    if (idx == m) {
      return calcCnt(cnt);
    }

    int ret = solve(idx + 1, cnt);
    push(board, 0, idx);
    ret = Math.min(ret, solve(idx + 1, cnt + 1));
    push(board, 0, idx);

    return ret;
  }

  private static int calcCnt(int cnt) {
    int[] board = copyBoard();

    int ret = cnt;
    for (int y = 1; y < n; ++y) {
      for (int x = 0; x < m; ++x) {
        if (((board[y - 1] >> x) & 1) == 1) {
          continue;
        }

        push(board, y, x);
        ret++;
      }

    }

    if ((board[n - 1] ^ ((1 << m) - 1)) != 0) {
      return MX;
    }

    return ret;
  }

  private static void push(int[] board, int y, int x) {
    for (int dir = 0; dir < 5; ++dir) {
      int ny = y + DY[dir];
      int nx = x + DX[dir];

      if (ny < 0 || ny >= n || nx < 0 || nx >= m) {
        continue;
      }

      flip(board, ny, nx);
    }
  }

  private static void flip(int[] board, int y, int x) {
    board[y] ^= (1 << x);
  }

  private static int[] copyBoard() {
    int[] ret = new int[n];
    for (int y = 0; y < n; ++y) {
      ret[y] = board[y];
    }
    return ret;
  }
}
