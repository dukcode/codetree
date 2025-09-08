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
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-special-character/description">LINK</a>
 */
public class ChallengeSpecialCharacter {

  private static BufferedReader br;
  private static BufferedWriter bw;

  private static Map<Character, Integer> charToCnt;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int[] idx = new int[26];
    Arrays.fill(idx, -1);
    char[] characters = br.readLine().toCharArray();
    charToCnt = new HashMap<>();
    for (int i = 0; i < characters.length; i++) {
      char c = characters[i];
      charToCnt.put(c, charToCnt.getOrDefault(c, 0) + 1);
      if (idx[c - 'a'] == -1) {
        idx[c - 'a'] = i;
      }
    }

    int firstIdx = Integer.MAX_VALUE;
    boolean exist = false;
    char ans = ' ';
    for (char c = 'a'; c <= 'z'; ++c) {
      int cnt = charToCnt.getOrDefault(c, 0);
      if (cnt == 1 && idx[c - 'a'] < firstIdx) {
        firstIdx = idx[c - 'a'];
        exist = true;
        ans = c;
      }
    }

    bw.write(exist ? String.valueOf(ans) : "None");

    br.close();
    bw.close();
  }
}
