package org.dukcode.ps.codetree.trail05.chapter02.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-count-number-of-points-3/description">LINK</a>
 */
public class IntroCountNumberOfPoints3 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int q;

  private static int[] points;
  private static TreeMap<Integer, Integer> map;

  /*
  ## 값 범위
  - n, q : ~ 100_000
  - points[i], a_i , b_i : -1_000_000_000 ~ 1_000_000_000 (r)


  ## 시간 복잡도 분석
  - 이분탐색 : O(q * nlgn) -> O(100_000 * 100_000 * 20) -> O(200_000_000_000) -> 불가능
    - 입력 : O(n)
    - 정렬 : O(nlgn)
    - 이분탐색 : O(q * nlgn)

  - TreeSet : O(q * n^2(lgn)^2) -> 불가능
    - 입력 : O(nlgn)
    - 탐색 : O(q * subset * size) -> O(q * nlgn * nlgn) ->  O(q * n^2(lgn)^2)

  - TreeMap : O((n + q) * lgn) -> O(200_000 * 20) -> O(4_000_000)
    - 정렬 : O(nlgn)
    - 앞부터 순서대로 prefixSum (1 ~ n) TreeMap에 삽입 : O(nlgn)
    - floor ~ floor 조회 후 prefixSum 차이  : O(qlgn)
  */


  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    q = Integer.parseInt(st.nextToken());

    points = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      points[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(points);

    map = new TreeMap<>();
    for (int i = 0; i < n; i++) {
      int cnt = i + 1;
      map.put(points[i], cnt);
    }

    for (int i = 0; i < q; i++) {
      st = new StringTokenizer(br.readLine());
      int frIn = Integer.parseInt(st.nextToken());
      int toIn = Integer.parseInt(st.nextToken());

      bw.write(String.valueOf(cnt(frIn, toIn)));
      bw.newLine();
    }

    br.close();
    bw.close();
  }

  private static int cnt(int frIn, int toIn) {

    return (map.floorKey(toIn) == null ? 0 : map.floorEntry(toIn).getValue())
        - (map.lowerKey(frIn) == null ? 0 : map.lowerEntry(frIn).getValue());
  }
}
