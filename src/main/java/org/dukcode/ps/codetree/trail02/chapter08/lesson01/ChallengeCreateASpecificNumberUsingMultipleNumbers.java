package org.dukcode.ps.codetree.trail02.chapter08.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-create-a-specific-number-using-multiple-numbers/description">LINK</a>
 */
public class ChallengeCreateASpecificNumberUsingMultipleNumbers {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());

    int maxNum = -1;

    for (int an = a; an <= c; an += a) {
      int remain = c - an;
      int bm = (remain / b) * b;

      maxNum = Math.max(maxNum, an + bm);
    }

    bw.write(String.valueOf(maxNum));

    br.close();
    bw.close();

  }
}
