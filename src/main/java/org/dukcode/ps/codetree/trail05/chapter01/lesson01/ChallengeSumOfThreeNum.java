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
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-sum-of-three-num/description">LINK</a>
 */
public class ChallengeSumOfThreeNum {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int k;
  private static Map<Integer, Integer> numToCnt;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    numToCnt = new HashMap<>();
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      int num = Integer.parseInt(st.nextToken());
      numToCnt.put(num, numToCnt.getOrDefault(num, 0) + 1);
    }

    bw.write(String.valueOf(solve()));

    br.close();
    bw.close();
  }

  private static int solve() {
    int ret = 0;
    for (int first : numToCnt.keySet()) {
      for (int i = 0; i < numToCnt.get(first); i++) {
        numToCnt.computeIfPresent(first, (k, v) -> v - 1);

        for (int second : numToCnt.keySet()) {
          int third = k - first - second;
          ret += second == third ?
              numToCnt.get(second) * (numToCnt.get(third) - 1) :
              numToCnt.get(second) * numToCnt.getOrDefault(third, 0);
        }
      }
    }

    ret /= 2;

    return ret;
  }
}
