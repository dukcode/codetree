package org.dukcode.ps.codetree.trail02.chapter05.lesson03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-small-marble-movement/description">LINK</a>
 */
public class IntroSmallMarbleMovement {

  // U L D R
  private static final int[] DY = {-1, 0, 1, 0};
  private static final int[] DX = {0, -1, 0, 1};

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int t;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    t = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    int y = Integer.parseInt(st.nextToken()) - 1;
    int x = Integer.parseInt(st.nextToken()) - 1;
    int dir = convertToInt(st.nextToken());

    for (int time = 0; time < t; time++) {
      int ny = y + DY[dir];
      int nx = x + DX[dir];

      if (ny < 0 || ny >= n || nx < 0 || nx >= n) {
        dir = (dir + 2) % 4;
        continue;
      }

      y = ny;
      x = nx;
    }

    bw.write((y + 1) + " " + (x + 1));

    br.close();
    bw.close();

  }

  private static int convertToInt(String dir) {
    switch (dir) {
      case "U":
        return 0;
      case "L":
        return 1;
      case "D":
        return 2;
      case "R":
        return 3;
      default:
        return -1;
    }
  }
}
