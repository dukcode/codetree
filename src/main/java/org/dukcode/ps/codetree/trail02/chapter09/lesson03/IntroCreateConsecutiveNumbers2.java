package org.dukcode.ps.codetree.trail02.chapter09.lesson03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-create-consecutive-numbers-2/description">LINK</a>
 */
public class IntroCreateConsecutiveNumbers2 {

  private static final int N = 3;

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int[] pos;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    pos = new int[N];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      pos[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(pos);

    bw.write(String.valueOf(solve()));

    br.close();
    bw.close();

  }

  private static int solve() {
    if (pos[0] + 1 == pos[1] && pos[1] + 1 == pos[2]) {
      return 0;
    }

    if (pos[0] + 2 == pos[1] || pos[1] + 2 == pos[2]) {
      return 1;
    }

    return 2;
  }
}
