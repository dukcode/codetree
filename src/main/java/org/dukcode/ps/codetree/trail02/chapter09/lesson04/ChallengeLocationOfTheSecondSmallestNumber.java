package org.dukcode.ps.codetree.trail02.chapter09.lesson04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-location-of-the-second-smallest-number/description">LINK</a>
 */
public class ChallengeLocationOfTheSecondSmallestNumber {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    int minVal = arr[0];
    for (int i = 0; i < n; i++) {
      minVal = Math.min(minVal, arr[i]);
    }

    int secondMinVal = Integer.MAX_VALUE;
    int pos = -1;
    for (int i = 0; i < n; i++) {
      if (arr[i] == minVal) {
        continue;
      }

      if (secondMinVal >= arr[i]) {
        secondMinVal = arr[i];
        pos = i;
      }
    }

    for (int i = 0; i < n; ++i) {
      if (pos != i && arr[i] == secondMinVal) {
        pos = -1;
        break;
      }
    }

    bw.write(String.valueOf(pos == -1 ? pos : pos + 1));

    br.close();
    bw.close();

  }
}
