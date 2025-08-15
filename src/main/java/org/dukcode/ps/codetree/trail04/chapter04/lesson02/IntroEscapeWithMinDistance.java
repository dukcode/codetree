package org.dukcode.ps.codetree.trail04.chapter04.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-escape-with-min-distance/description">LINK</a>
 */
public class IntroEscapeWithMinDistance {

  private static final int[] DY = {-1, 1, 0, 0};
  private static final int[] DX = {0, 0, -1, 1};
  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int h;
  private static int w;
  private static int[][] board;

  private static int[][] dist;

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

    dist = new int[h][w];
    for (int y = 0; y < h; y++) {
      Arrays.fill(dist[y], -1);
    }

    Queue<Pos> q = new ArrayDeque<>();
    dist[0][0] = 0;
    q.offer(new Pos(0, 0));

    while (!q.isEmpty()) {
      Pos cur = q.poll();

      for (int dir = 0; dir < 4; ++dir) {
        int ny = cur.y + DY[dir];
        int nx = cur.x + DX[dir];

        if (ny < 0 || ny >= h || nx < 0 || nx >= w) {
          continue;
        }

        if (board[ny][nx] == 0) {
          continue;
        }

        if (dist[ny][nx] != -1) {
          continue;
        }

        dist[ny][nx] = dist[cur.y][cur.x] + 1;
        q.offer(new Pos(ny, nx));
      }
    }

    bw.write(String.valueOf(dist[h - 1][w - 1]));

    br.close();
    bw.close();

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

