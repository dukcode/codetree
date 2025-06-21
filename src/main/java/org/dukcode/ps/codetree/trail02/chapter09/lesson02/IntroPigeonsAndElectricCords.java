package org.dukcode.ps.codetree.trail02.chapter09.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-pigeons-and-electric-cords/description">LINK</a>
 */
public class IntroPigeonsAndElectricCords {

  private static final int MX = 10;

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());

    int[] pigeons = new int[MX];
    Arrays.fill(pigeons, -1);

    int cnt = 0;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int idx = Integer.parseInt(st.nextToken()) - 1;
      int pos = Integer.parseInt(st.nextToken());

      if (pigeons[idx] == -1) {
        pigeons[idx] = pos;
        continue;
      }

      if (pigeons[idx] != pos) {
        pigeons[idx] = pos;
        cnt++;
      }
    }

    bw.write(String.valueOf(cnt));

    br.close();
    bw.close();

  }
}
