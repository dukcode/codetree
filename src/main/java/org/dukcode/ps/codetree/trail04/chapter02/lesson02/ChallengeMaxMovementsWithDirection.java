package org.dukcode.ps.codetree.trail04.chapter02.lesson02;

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
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-max-movements-with-direction/description">LINK</a>
 */
public class ChallengeMaxMovementsWithDirection {

  private static final int[] DY = {-1, -1, 0, 1, 1, 1, 0, -1};
  private static final int[] DX = {0, 1, 1, 1, 0, -1, -1, -1};

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int[][] board;
  private static int[][] dirs;

  private static int r;
  private static int c;

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

    dirs = new int[n][n];
    for (int y = 0; y < n; y++) {
      st = new StringTokenizer(br.readLine());
      for (int x = 0; x < n; x++) {
        dirs[y][x] = Integer.parseInt(st.nextToken()) - 1;
      }
    }

    st = new StringTokenizer(br.readLine());
    r = Integer.parseInt(st.nextToken()) - 1;
    c = Integer.parseInt(st.nextToken()) - 1;

    bw.write(String.valueOf(solve(r, c)));

    br.close();
    bw.close();

  }

  private static int solve(int r, int c) {
    List<Pos> nextPos = findNext(r, c);
    if (nextPos.isEmpty()) {
      return 0;
    }

    int ret = 0;
    for (Pos next : nextPos) {
      ret = Math.max(ret, solve(next.y, next.x) + 1);
    }

    return ret;
  }

  private static List<Pos> findNext(int y, int x) {
    int pivot = board[y][x];
    int dir = dirs[y][x];

    List<Pos> ret = new ArrayList<>();
    while (inRange(y, x)) {
      if (board[y][x] > pivot) {
        ret.add(new Pos(y, x));
      }

      y += DY[dir];
      x += DX[dir];
    }

    return ret;
  }

  private static boolean inRange(int y, int x) {
    return 0 <= y && y < n && 0 <= x && x < n;
  }

  private static class Pos {

    int y;
    int x;

    public Pos(int y, int x) {
      this.y = y;
      this.x = x;
    }
  }
}
