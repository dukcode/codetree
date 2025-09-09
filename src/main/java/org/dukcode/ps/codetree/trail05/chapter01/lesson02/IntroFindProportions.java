package org.dukcode.ps.codetree.trail05.chapter01.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-find-proportions/description">LINK</a>
 */
public class IntroFindProportions {

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());

    Map<String, Integer> wordToCnt = new TreeMap<>();
    for (int i = 0; i < n; i++) {
      String word = br.readLine();
      wordToCnt.put(word, wordToCnt.getOrDefault(word, 0) + 1);
    }

    for (Entry<String, Integer> entry : wordToCnt.entrySet()) {
      String word = entry.getKey();
      int cnt = entry.getValue();

      bw.write(word);
      bw.write(' ');
      bw.write(String.format("%.4f", (double) 100 * cnt / n));
      bw.newLine();
    }

    br.close();
    bw.close();
  }
}
