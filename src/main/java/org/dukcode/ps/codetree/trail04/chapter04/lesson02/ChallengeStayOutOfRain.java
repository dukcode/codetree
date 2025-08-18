package org.dukcode.ps.codetree.trail04.chapter04.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-stay-out-of-rain/description">LINK</a>
 */
public class ChallengeStayOutOfRain {

  private static final int[] DY = {-1, 1, 0, 0};
  private static final int[] DX = {0, 0, -1, 1};

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int h; // 사람 수
  private static int m; // 비 피할 수 있는 공간 수

  // 0 : 이동 가능
  // 1 : 벽 (이동 불가)
  // 2 : 사람
  // 3 : 비 피할 수 있는 공간
  private static int[][] board;
  private static int[][] dist;

  private static List<Pos> ends;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    h = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    board = new int[n][n];
    ends = new ArrayList<>();
    for (int y = 0; y < n; y++) {
      st = new StringTokenizer(br.readLine());
      for (int x = 0; x < n; x++) {
        board[y][x] = Integer.parseInt(st.nextToken());

        if (board[y][x] == 3) {
          ends.add(new Pos(y, x));
        }
      }
    }

    dist = new int[n][n];
    for (int y = 0; y < n; y++) {
      Arrays.fill(dist[y], -1);
    }

    Queue<Pos> q = new ArrayDeque<>();
    for (Pos end : ends) {
      q.offer(end);
      dist[end.y][end.x] = 0;
    }

    while (!q.isEmpty()) {
      Pos cur = q.poll();
      for (int dir = 0; dir < 4; dir++) {
        int ny = cur.y + DY[dir];
        int nx = cur.x + DX[dir];

        if (ny < 0 || ny >= n || nx < 0 || nx >= n) {
          continue;
        }

        if (dist[ny][nx] != -1) {
          continue;
        }

        if (board[ny][nx] == 1) {
          continue;
        }

        dist[ny][nx] = dist[cur.y][cur.x] + 1;
        q.offer(new Pos(ny, nx));
      }
    }

    for (int y = 0; y < n; y++) {
      for (int x = 0; x < n; x++) {
        bw.write(String.valueOf(board[y][x] == 2 ? dist[y][x] : 0));
        bw.write(' ');
      }
      bw.newLine();
    }

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
