package org.dukcode.ps.codetree.trail05.chapter01.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-most-frequent-data/description">LINK</a>
 */
public class IntroMostFrequentData {

  private static BufferedReader br;
  private static BufferedWriter bw;

  private static int n;
  private static Map<String, Integer> map;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());

    map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      String word = br.readLine();
      map.put(word, map.getOrDefault(word, 0) + 1);
    }

    int maxCnt = map.values().stream()
        .mapToInt(v -> v)
        .max()
        .orElseThrow(RuntimeException::new);

    bw.write(String.valueOf(maxCnt));

    br.close();
    bw.close();

  }
}
