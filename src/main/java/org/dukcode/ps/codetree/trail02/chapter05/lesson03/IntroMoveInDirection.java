package org.dukcode.ps.codetree.trail02.chapter05.lesson03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-move-in-direction/description">LINK</a>
 */
public class IntroMoveInDirection {

  // 동 서 남 북
  private static final int[] DX = {1, -1, 0, 0};
  private static final int[] DY = {0, 0, -1, 1};

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    int x = 0;
    int y = 0;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int dir = findDir(st.nextToken());
      int dist = Integer.parseInt(st.nextToken());

      x += DX[dir] * dist;
      y += DY[dir] * dist;
    }

    bw.write(String.valueOf(x));
    bw.write(' ');
    bw.write(String.valueOf(y));

    br.close();
    bw.close();

  }

  private static int findDir(String dir) {
    switch (dir) {
      case "E":
        return 0;
      case "W":
        return 1;
      case "S":
        return 2;
      case "N":
        return 3;
      default:
        return -1;
    }
  }
}
