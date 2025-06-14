package org.dukcode.ps.codetree.trail02.chapter07.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-interesting-numbers-2/description">LINK</a>
 */
public class ChallengeInterestingNumbers2 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int x;
  private static int y;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    x = Integer.parseInt(st.nextToken());
    y = Integer.parseInt(st.nextToken());

    int ans = 0;
    for (int num = x; num <= y; num++) {
      if (isInteresting(num)) {
        ans++;
      }
    }

    bw.write(String.valueOf(ans));

    br.close();
    bw.close();

  }

  private static boolean isInteresting(int num) {
    int[] freq = new int[10];

    while (num > 0) {
      freq[num % 10]++;
      num /= 10;
    }

    int cntZero = 0;
    int cntOne = 0;
    for (int i = 0; i < 10; i++) {
      if (freq[i] == 0) {
        cntZero++;
      }

      if (freq[i] == 1) {
        cntOne++;
      }
    }

    int cntDuplicated = 10 - cntOne - cntZero;

    return cntDuplicated == 1 && cntOne == 1;
  }
}
