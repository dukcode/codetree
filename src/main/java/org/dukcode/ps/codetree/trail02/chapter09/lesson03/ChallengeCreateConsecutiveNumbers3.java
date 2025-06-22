package org.dukcode.ps.codetree.trail02.chapter09.lesson03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-create-consecutive-numbers-3/description">LINK</a>
 */
public class ChallengeCreateConsecutiveNumbers3 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int[] pos;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    pos = new int[3];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < 3; i++) {
      pos[i] = Integer.parseInt(st.nextToken());
    }

    int a = pos[1] - pos[0];
    int b = pos[2] - pos[1];

    int maxCnt = Math.max(a, b) - 1;
    bw.write(String.valueOf(maxCnt));

    br.close();
    bw.close();

  }
}
