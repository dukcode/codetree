package org.dukcode.ps.codetree.trail05.chapter02.lesson06.review;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-sum-closest-to-zero/description">LINK</a>
 */
public class ChallengeSumClosestToZero {

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

    Arrays.sort(arr);

    bw.write(String.valueOf(solve()));

    br.close();
    bw.close();
  }

  private static int solve() {
    int ret = Integer.MAX_VALUE;
    int left = 0;
    int right = n - 1;
    while (left < right) {
      int sum = arr[left] + arr[right];
      ret = Math.min(ret, Math.abs(sum));

      if (sum == 0) {
        return 0;
      }

      if (sum < 0) {
        left++;
      } else {
        right--;
      }
    }

    return ret;
    /*
    int ret = Integer.MAX_VALUE;
    int right = n - 1;
    for (int left = 0; left < n - 1; ++left) {

      while (left < right && arr[left] + arr[right] >= 0) {
        ret = Math.min(ret, Math.abs(arr[left] + arr[right]));
        right--;
      }

      if (left == right) {
        break;
      }

      ret = Math.min(ret, Math.abs(arr[left] + arr[right])); // 0 미만 처리
    }

    return ret;
     */
  }
}
