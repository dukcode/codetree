package org.dukcode.ps.codetree.trail04.chapter01.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-rotate-slanted-rectangle/description">LINK</a>
 */
public class ChallengeRotateSlantedRectangle {

  private static final int[] DY = {-1, -1, 1, 1};
  private static final int[] DX = {1, -1, -1, 1};

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

    st = new StringTokenizer(br.readLine());
    int r = Integer.parseInt(st.nextToken()) - 1;
    int c = Integer.parseInt(st.nextToken()) - 1;
    int m1 = Integer.parseInt(st.nextToken());
    int m2 = Integer.parseInt(st.nextToken());
    int m3 = Integer.parseInt(st.nextToken());
    int m4 = Integer.parseInt(st.nextToken());
    boolean cw = Integer.parseInt(st.nextToken()) == 1;

    rotate(r, c, new int[]{m1, m2, m3, m4}, cw);

    for (int y = 0; y < n; y++) {
      for (int x = 0; x < n; x++) {
        bw.write(String.valueOf(board[y][x]));
        bw.write(' ');
      }
      bw.newLine();
    }

    br.close();
    bw.close();

  }

  private static void rotate(int r, int c, int[] dists, boolean cw) {
    Deque<Integer> values = new LinkedList<>();
    Queue<Pos> positions = new LinkedList<>();

    int y = r;
    int x = c;

    for (int dir = 0; dir < 4; dir++) {
      for (int i = 0; i < dists[dir]; ++i) {
        values.offerLast(board[y][x]);
        positions.offer(new Pos(y, x));
        y += DY[dir];
        x += DX[dir];
      }
    }

    if (cw) {
      values.offerLast(values.pollFirst());
    } else {
      values.offerFirst(values.pollLast());
    }

    while (!positions.isEmpty()) {
      Pos pos = positions.poll();
      int value = values.pollFirst();

      board[pos.y][pos.x] = value;
    }

  }


  private static class Pos {

    int y;
    int x;

    public Pos(int y, int x) {
      this.y = y;
      this.x = x;
    }

    @Override
    public String toString() {
      return "(" + y + ", " + x + ")";
    }
  }
}
