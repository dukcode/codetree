package org.dukcode.ps.codetree.trail02.chapter10.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-rectangle-made-of-two-points/description">LINK</a>
 */
public class IntroRectangleMadeOfTwoPoints {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int[] rect1 = new int[4];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < 4; ++i) {
      rect1[i] = Integer.parseInt(st.nextToken());
    }

    int[] rect2 = new int[4];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < 4; ++i) {
      rect2[i] = Integer.parseInt(st.nextToken());
    }

    int x1 = Math.min(rect1[0], rect2[0]);
    int y1 = Math.min(rect1[1], rect2[1]);
    int x2 = Math.max(rect1[2], rect2[2]);
    int y2 = Math.max(rect1[3], rect2[3]);

    int area = (y2 - y1) * (x2 - x1);
    bw.write(String.valueOf(area));

    br.close();
    bw.close();

  }
}
