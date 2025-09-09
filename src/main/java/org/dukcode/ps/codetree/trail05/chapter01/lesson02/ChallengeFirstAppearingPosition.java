package org.dukcode.ps.codetree.trail05.chapter01.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-first-appearing-position/description">LINK</a>
 */
public class ChallengeFirstAppearingPosition {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static Map<Integer, Integer> numToFirstIdx;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());
    numToFirstIdx = new TreeMap<>();

    st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= n; i++) {
      int num = Integer.parseInt(st.nextToken());
      if (numToFirstIdx.containsKey(num)) {
        continue;
      }

      numToFirstIdx.put(num, i);
    }

    for (Entry<Integer, Integer> entry : numToFirstIdx.entrySet()) {
      int num = entry.getKey();
      int idx = entry.getValue();

      bw.write(String.valueOf(num));
      bw.write(' ');
      bw.write(String.valueOf(idx));
      bw.newLine();
    }

    br.close();
    bw.close();
  }
}
