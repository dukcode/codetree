package org.dukcode.ps.codetree.trail2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-create-a-rectangle-using-a-function/description">LINK</a>
 */
public class IntroCreateARectangleUsingAFunction {

  private static final String CONTENT = "1";

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int h;
  private static int w;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());

    h = Integer.parseInt(st.nextToken());
    w = Integer.parseInt(st.nextToken());

    printSquare(h, w);

    br.close();
    bw.close();

  }

  private static void printSquare(int h, int w) throws IOException {
    for (int y = 0; y < h; y++) {
      for (int x = 0; x < w; x++) {
        bw.write(CONTENT);
      }
      bw.newLine();
    }
    bw.newLine();
  }
}
