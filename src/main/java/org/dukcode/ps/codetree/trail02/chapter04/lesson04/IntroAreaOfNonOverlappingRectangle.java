package org.dukcode.ps.codetree.trail02.chapter04.lesson04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-area-of-non-overlapping-rectangle/description">LINK</a>
 */
public class IntroAreaOfNonOverlappingRectangle {

  private static final int OFFSET = 1000;

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int[][] arr;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    arr = new int[2 * OFFSET + 1][2 * OFFSET + 1];

    for (int i = 0; i < 3; i++) {
      st = new StringTokenizer(br.readLine());
      int x1 = Integer.parseInt(st.nextToken());
      int y1 = Integer.parseInt(st.nextToken());
      int x2 = Integer.parseInt(st.nextToken());
      int y2 = Integer.parseInt(st.nextToken());

      int toDraw = i == 2 ? 0 : 1;

      for (int y = y1; y < y2; y++) {
        for (int x = x1; x < x2; x++) {
          arr[y + OFFSET][x + OFFSET] = toDraw;
        }
      }
    }

    int area = 0;
    for (int[] line : arr) {
      for (int i : line) {
        area += i;
      }
    }

    bw.write(String.valueOf(area));

    br.close();
    bw.close();
  }
}
