package org.dukcode.ps.codetree.trail05.chapter01.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-sum-of-two-num/description">LINK</a>
 */
public class ChallengeSumOfTwoNum {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static long k;
  private static Map<Long, Integer> numToCnt;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    k = Long.parseLong(st.nextToken());

    numToCnt = new HashMap<>();
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      long num = Long.parseLong(st.nextToken());
      numToCnt.put(num, numToCnt.getOrDefault(num, 0) + 1);
    }

    bw.write(String.valueOf(solve()));

    br.close();
    bw.close();

  }

  private static int solve() {
    int ret = 0;
    for (long a : numToCnt.keySet()) {
      long b = k - a;
      int cnt1 = numToCnt.get(a);
      int cnt2 = numToCnt.getOrDefault(b, 0);

      ret += a == b ? cnt1 * (cnt1 - 1) : cnt1 * cnt2;
    }

    return ret / 2;
  }
}
