package org.dukcode.ps.codetree.trail05.chapter04.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-m2-pairs-of-natural-numbers/description">LINK</a>
 */
public class ChallengeM2PairsOfNaturalNumbers {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static TreeMap<Integer, Integer> map;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());

    map = new TreeMap<>();
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int cnt = Integer.parseInt(st.nextToken());
      int num = Integer.parseInt(st.nextToken());

      map.put(num, cnt);
    }

    int c = 0;
    while (map.size() >= 2) {
      Entry<Integer, Integer> left = map.pollFirstEntry();
      Entry<Integer, Integer> right = map.pollLastEntry();

      int minCnt = Math.min(left.getValue(), right.getValue());

      if (left.getValue() != minCnt) {
        map.put(left.getKey(), left.getValue() - minCnt);
      }

      if (right.getValue() != minCnt) {
        map.put(right.getKey(), right.getValue() - minCnt);
      }

      c = Math.max(c, left.getKey() + right.getKey());
    }

    if (map.size() == 1) {
      int num = map.firstKey();
      c = Math.max(c, num * 2);
    }

    bw.write(String.valueOf(c));

    br.close();
    bw.close();
  }
}
