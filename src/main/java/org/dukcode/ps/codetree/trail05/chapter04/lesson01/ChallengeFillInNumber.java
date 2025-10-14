package org.dukcode.ps.codetree.trail05.chapter04.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-fill-in-number/description">LINK</a>
 */
public class ChallengeFillInNumber {

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());

    bw.write(String.valueOf(solve(n)));

    br.close();
    bw.close();
  }

  private static int solve(int target) {
    for (int cnt5 = target / 5; cnt5 >= 0; --cnt5) {
      if ((target - cnt5 * 5) % 2 == 0) {
        return cnt5 + (target - cnt5 * 5) / 2;
      }
    }

    return -1;
  }
}
