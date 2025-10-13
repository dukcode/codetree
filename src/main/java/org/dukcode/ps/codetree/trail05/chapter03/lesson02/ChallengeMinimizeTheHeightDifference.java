package org.dukcode.ps.codetree.trail05.chapter03.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-minimize-the-height-difference/description">LINK</a>
 */
public class ChallengeMinimizeTheHeightDifference {

  private static final int[] DY = {-1, 1, 0, 0};
  private static final int[] DX = {0, 0, -1, 1};

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int h;
  private static int w;

  private static int[][] board;
  private static int min;
  private static int max;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    h = Integer.parseInt(st.nextToken());
    w = Integer.parseInt(st.nextToken());

    board = new int[h][w];
    min = Integer.MAX_VALUE;
    max = Integer.MIN_VALUE;
    for (int y = 0; y < h; y++) {
      st = new StringTokenizer(br.readLine());
      for (int x = 0; x < w; x++) {
        board[y][x] = Integer.parseInt(st.nextToken());
        min = Math.min(min, board[y][x]);
        max = Math.max(max, board[y][x]);
      }
    }

    bw.write(String.valueOf(solve()));

    br.close();
    bw.close();
  }

  private static int solve() {
    int frIn = 0;
    int toEx = max - min + 1;

    while (frIn < toEx) {
      int mid = (frIn + toEx) / 2;

      if (isPossible(mid)) {
        toEx = mid;
      } else {
        frIn = mid + 1;
      }
    }

    return frIn;
  }

  private static boolean isPossible(int maxDiff) {
    for (int minVal = min; minVal <= max - maxDiff; minVal++) {
      int maxVal = minVal + maxDiff;
      if (board[0][0] < minVal || maxVal < board[0][0]) {
        continue;
      }

      if (bfs(0, 0, minVal, maxVal)) {
        return true;
      }
    }

    return false;
  }

  private static boolean bfs(int y, int x, int minVal, int maxVal) {
    boolean[][] discovered = new boolean[h][w];
    Queue<Point> q = new ArrayDeque<>();

    discovered[0][0] = true;
    q.offer(new Point(y, x));

    while (!q.isEmpty()) {
      Point cur = q.poll();
      for (int dir = 0; dir < 4; ++dir) {
        int ny = cur.y + DY[dir];
        int nx = cur.x + DX[dir];

        if (ny < 0 || ny >= h || nx < 0 || nx >= w) {
          continue;
        }

        if (discovered[ny][nx]) {
          continue;
        }

        if (board[ny][nx] < minVal || maxVal < board[ny][nx]) {
          continue;
        }

        discovered[ny][nx] = true;
        q.offer(new Point(ny, nx));
      }
    }

    return discovered[h - 1][w - 1];
  }


  private static class Point {

    int y;
    int x;

    public Point(int y, int x) {
      this.y = y;
      this.x = x;
    }
  }
}
