package org.dukcode.ps.codetree.trail02.chapter04.lesson03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-block-stacking-commands2/description">LINK</a>
 */
public class IntroBlockStackingCommands2 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    int[] blocks = new int[n];
    for (int i = 0; i < k; ++i) {
      st = new StringTokenizer(br.readLine());
      int frIn = Integer.parseInt(st.nextToken()) - 1;
      int toIn = Integer.parseInt(st.nextToken()) - 1;
      for (int idx = frIn; idx <= toIn; ++idx) {
        blocks[idx]++;
      }
    }

    bw.write(String.valueOf(Arrays.stream(blocks).max().getAsInt()));

    br.close();
    bw.close();

  }
}
