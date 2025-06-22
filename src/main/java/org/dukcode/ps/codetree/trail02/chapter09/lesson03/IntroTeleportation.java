package org.dukcode.ps.codetree.trail02.chapter09.lesson03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-teleportation/description">LINK</a>
 */
public class IntroTeleportation {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int a;
  private static int b;
  private static int x;
  private static int y;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    a = Integer.parseInt(st.nextToken());
    b = Integer.parseInt(st.nextToken());
    x = Integer.parseInt(st.nextToken());
    y = Integer.parseInt(st.nextToken());

    int minDist = Math.abs(b - a);
    minDist = Math.min(minDist, Math.abs(x - a) + Math.abs(b - y));
    minDist = Math.min(minDist, Math.abs(y - a) + Math.abs(b - x));

    bw.write(String.valueOf(minDist));

    br.close();
    bw.close();

  }
}
