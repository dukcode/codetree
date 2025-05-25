package org.dukcode.ps.codetree.trail02.chapter06.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-escaping-carry-2/description">LINK</a>
 */
public class ChallengeEscapingCarry2 {

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    int maxSum = -1;
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        for (int k = j + 1; k < n; k++) {
          if (hasCarry(arr[i], arr[j], arr[k])) {
            continue;
          }

          maxSum = Math.max(maxSum, arr[i] + arr[j] + arr[k]);
        }
      }
    }

    bw.write(String.valueOf(maxSum));

    br.close();
    bw.close();
  }

  private static boolean hasCarry(int a, int b, int c) {
    while (a > 0 || b > 0 || c > 0) {
      if (a % 10 + b % 10 + c % 10 >= 10) {
        return true;
      }

      a /= 10;
      b /= 10;
      c /= 10;
    }

    return false;
  }
}
