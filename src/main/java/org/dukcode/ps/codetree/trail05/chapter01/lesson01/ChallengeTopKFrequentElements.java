package org.dukcode.ps.codetree.trail05.chapter01.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-top-k-frequent-elements/description">LINK</a>
 */
public class ChallengeTopKFrequentElements {

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

    List<Integer> list = numToCnt.entrySet().stream().sorted(
            (e1, e2) -> e1.getValue().equals(e2.getValue()) ?
                e2.getKey() - e1.getKey() :
                e2.getValue() - e1.getValue()
        )
        .map(Map.Entry::getKey)
        .limit(k)
        .collect(Collectors.toList());

    for (Integer num : list) {
      bw.write(String.valueOf(num));
      bw.write(' ');
    }

    br.close();
    bw.close();

  }
}
