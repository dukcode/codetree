package org.dukcode.ps.codetree.trail02.chapter01.lesson03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-more-than-one-alphabet/description">LINK</a>
 */
public class ChallengeMoreThanOneAlphabet {

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String word = br.readLine();

    bw.write(hasMoreThanOneAlphabet(word) ? "Yes" : "No");

    br.close();
    bw.close();

  }

  private static boolean hasMoreThanOneAlphabet(String word) {
    int[] freq = new int[26];
    boolean hasOne = false;
    for (char c : word.toCharArray()) {
      freq[c - 'a']++;
      if (freq[c - 'a'] == 1) {
        if (hasOne) {
          return true;
        }
        hasOne = true;
      }

    }

    return false;
  }
}
