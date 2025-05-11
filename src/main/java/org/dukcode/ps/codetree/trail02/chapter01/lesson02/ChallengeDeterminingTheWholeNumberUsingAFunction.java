package org.dukcode.ps.codetree.trail02.chapter01.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-determining-the-whole-number-using-a-function/description">LINK</a>
 */
public class ChallengeDeterminingTheWholeNumberUsingAFunction {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    int frIn = Integer.parseInt(st.nextToken());
    int toIn = Integer.parseInt(st.nextToken());

    bw.write(String.valueOf(cntWholeNums(frIn, toIn)));

    br.close();
    bw.close();

  }

  private static int cntWholeNums(int frIn, int toIn) {
    int ret = 0;
    for (int num = frIn; num <= toIn; num++) {
      if (isWholeNum(num)) {
        ret++;
      }
    }
    return ret;
  }

  private static boolean isWholeNum(int num) {
    return num % 2 != 0 && num % 10 != 5 && (num % 3 != 0 || num % 9 == 0);
  }
}
