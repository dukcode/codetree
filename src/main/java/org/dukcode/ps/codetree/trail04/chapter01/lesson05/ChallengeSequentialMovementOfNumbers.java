package org.dukcode.ps.codetree.trail04.chapter01.lesson05;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-sequential-movement-of-numbers/description">LINK</a>
 */
public class ChallengeSequentialMovementOfNumbers {

  private static final int[] DY = {-1, -1, -1, 0, 1, 1, 1, 0};
  private static final int[] DX = {-1, 0, 1, 1, 1, 0, -1, -1};

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;
  private static int[][] board;
  private static Pos[] positions;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    board = new int[n][n];
    positions = new Pos[n * n];
    for (int y = 0; y < n; y++) {
      st = new StringTokenizer(br.readLine());
      for (int x = 0; x < n; x++) {
        int num = Integer.parseInt(st.nextToken()) - 1;
        positions[num] = new Pos(y, x);
        board[y][x] = num;
      }
    }

    while (m-- > 0) {
      moveAll();
    }

    for (int y = 0; y < n; y++) {
      for (int x = 0; x < n; x++) {
        bw.write(String.valueOf(board[y][x] + 1));
        bw.write(' ');
      }
      bw.newLine();
    }

    br.close();
    bw.close();

  }


  private static void moveAll() {
    for (int num = 0; num < n * n; ++num) {
      moveNum(num);
    }
  }

  private static void moveNum(int num) {
    int maxNum = 0;
    for (int dir = 0; dir < 8; ++dir) {
      int ny = positions[num].y + DY[dir];
      int nx = positions[num].x + DX[dir];

      if (ny < 0 || ny >= n || nx < 0 || nx >= n) {
        continue;
      }

      if (board[ny][nx] > maxNum) {
        maxNum = board[ny][nx];
      }
    }

    swap(num, maxNum);
  }

  private static void swap(int a, int b) {
    Pos posA = positions[a];
    Pos posB = positions[b];

    int tmpNum = board[posA.y][posA.x];
    board[posA.y][posA.x] = board[posB.y][posB.x];
    board[posB.y][posB.x] = tmpNum;

    Pos tmpPos = positions[a];
    positions[a] = positions[b];
    positions[b] = tmpPos;

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
