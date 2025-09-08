package org.dukcode.ps.codetree.trail05.chapter01.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-group-same-word/description">LINK</a>
 */
public class ChallengeGroupSameWord {

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());

    int maxCnt = 0;
    Map<String, Integer> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      char[] wordArr = br.readLine().toCharArray();
      Arrays.sort(wordArr);
      String word = String.valueOf(wordArr);
      map.put(word, map.getOrDefault(word, 0) + 1);
      maxCnt = Math.max(maxCnt, map.get(word));
    }

    bw.write(String.valueOf(maxCnt));

    br.close();
    bw.close();
  }
}
