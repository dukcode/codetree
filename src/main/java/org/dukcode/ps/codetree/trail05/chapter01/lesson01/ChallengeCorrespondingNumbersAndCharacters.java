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
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-corresponding-numbers-and-characters/description">LINK</a>
 */
public class ChallengeCorrespondingNumbersAndCharacters {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;
  private static Map<Integer, String> idxToWord;
  private static Map<String, Integer> wordToIdx;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    idxToWord = new HashMap<>();
    wordToIdx = new HashMap<>();
    for (int idx = 1; idx <= n; idx++) {
      String word = br.readLine();
      idxToWord.put(idx, word);
      wordToIdx.put(word, idx);
    }

    for (int i = 0; i < m; ++i) {
      String token = br.readLine();
      if (isNumber(token)) {
        bw.write(String.valueOf(idxToWord.get(Integer.parseInt(token))));
      } else {
        bw.write(String.valueOf(wordToIdx.get(token)));
      }
      bw.newLine();
    }

    idxToWord = new HashMap<>();
    wordToIdx = new HashMap<>();

    br.close();
    bw.close();

  }

  private static boolean isNumber(String s) {
    try {
      Integer.parseInt(s);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }
}
