package org.dukcode.ps.codetree.trail02.chapter09.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-two-rectangles/description">LINK</a>
 */
public class IntroTwoRectangles {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int[] rect1 = new int[4];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < 4; i++) {
      rect1[i] = Integer.parseInt(st.nextToken());
    }

    int[] rect2 = new int[4];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < 4; i++) {
      rect2[i] = Integer.parseInt(st.nextToken());
    }

    bw.write(overlapped(rect1, rect2) ? "overlapping" : "nonoverlapping");

    br.close();
    bw.close();

  }

  private static boolean overlapped(int[] rect1, int[] rect2) {
    boolean horizontalOverlapped = rect1[2] >= rect2[0] && rect2[2] >= rect1[0];
    boolean verticalOverlapped = rect1[3] >= rect2[1] && rect2[3] >= rect1[1];

    return horizontalOverlapped && verticalOverlapped;
  }
}
