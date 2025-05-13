package org.dukcode.ps.codetree.trail02.chapter03.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-determine-same-word/description">LINK</a>
 */
public class ChallengeDetermineSameWord {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    char[] word1 = br.readLine().toCharArray();
    char[] word2 = br.readLine().toCharArray();

    bw.write(isSame(word1, word2) ? "Yes" : "No");

    br.close();
    bw.close();

  }

  private static boolean isSame(char[] word1, char[] word2) {
    Arrays.sort(word1);
    Arrays.sort(word2);

    String word1Str = String.valueOf(word1);
    String word2Str = String.valueOf(word2);

    return word1Str.equals(word2Str);
  }
}
