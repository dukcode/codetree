package org.dukcode.ps.codetree.trail02.chapter01.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-use-functions-to-determine-sums-and-decimals/description">LINK</a>
 */
public class ChallengeUseFunctionsToDetermineSumsAndDecimals {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    int frIn = Integer.parseInt(st.nextToken());
    int toIn = Integer.parseInt(st.nextToken());

    bw.write(String.valueOf(cntValidNums(frIn, toIn)));

    br.close();
    bw.close();

  }

  private static int cntValidNums(int frIn, int toIn) {
    int ret = 0;
    for (int num = frIn; num <= toIn; num++) {
      if (isValidNum(num)) {
        ret++;
      }
    }
    return ret;
  }

  private static boolean isValidNum(int num) {
    return isDigitSumEven(num) && isPrimeNum(num);
  }

  private static boolean isDigitSumEven(int num) {
    int sumDigit = 0;

    while (num > 0) {
      sumDigit += num % 10;
      num /= 10;
    }

    return sumDigit % 2 == 0;
  }

  private static boolean isPrimeNum(int num) {
    for (int i = 2; i * i <= num; ++i) {
      if (num % i == 0) {
        return false;
      }
    }

    return true;
  }
}
