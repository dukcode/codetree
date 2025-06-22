package org.dukcode.ps.codetree.trail02.chapter10.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/test-group-of-pairs-2/description">LINK</a>
 */
public class TestGroupOfPairs2 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n * 2];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n * 2; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    // a b c d -> (a, b), (c, d)가 맞다고 치자
    // (a, a + x), (a + x + y, a + x + y + z) -> min(x, z)
    // 다르게 나누면?
    // (a, a + x + y), (a + x, a + x + y + z) -> min(x + y, y + z)
    // 뒤의 방법으로 차이를 더 크게 만들 수 있음
    // 따라서 모순 발생 -> n개일 때도 부분으로 보면 적용됨
    Arrays.sort(arr);
    int ans = Integer.MAX_VALUE;
    for (int i = 0; i < n; ++i) {
      int a = arr[i];
      int b = arr[i + n];
      ans = Math.min(ans, b - a);
    }

    bw.write(String.valueOf(ans));

    br.close();
    bw.close();

  }
}
