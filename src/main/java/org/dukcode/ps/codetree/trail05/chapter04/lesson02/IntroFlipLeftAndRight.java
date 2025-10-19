package org.dukcode.ps.codetree.trail05.chapter04.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-flip-left-and-right/description">LINK</a>
 */
public class IntroFlipLeftAndRight {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int[] arr;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());

    arr = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    bw.write(String.valueOf(solve()));

    br.close();
    bw.close();
  }

  private static int solve() {
    int ret = 0;

    for (int i = 1; i < n; ++i) {

      if (arr[i - 1] == 1) {
        continue;
      }

      ret++;
      for (int idx = i - 1; idx <= i + 1; ++idx) {
        if (idx < 0 || idx >= n) {
          continue;
        }

        arr[idx] = flip(arr[idx]);

      }
    }

    if (arr[n - 1] != 1) {
      return -1;
    }

    return ret;
  }

  private static int flip(int num) {
    return num == 0 ? 1 : 0;
  }
}
