package org.dukcode.ps.codetree.trail05.chapter02.lesson03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-c-o-w/description">LINK</a>
 */
public class ChallengeCOW {

  private static BufferedReader br;
  private static BufferedWriter bw;

  private static String sequence;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    sequence = br.readLine();

    bw.write(String.valueOf(cntCow(sequence)));

    br.close();
    bw.close();
  }

  private static long cntCow(String sequence) {
    long c = 0;
    long co = 0;
    long cow = 0;
    for (char ch : sequence.toCharArray()) {
      if (ch == 'C') {
        c++;
        continue;
      }

      if (ch == 'O') {
        co += c;
        continue;
      }

      cow += co;
    }

    return cow;
  }
}
