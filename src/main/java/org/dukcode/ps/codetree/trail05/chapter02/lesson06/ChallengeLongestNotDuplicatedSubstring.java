package org.dukcode.ps.codetree.trail05.chapter02.lesson06;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-longest-not-duplicated-substring/description">LINK</a>
 */
public class ChallengeLongestNotDuplicatedSubstring {

  private static BufferedReader br;
  private static BufferedWriter bw;

  private static char[] line;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    line = br.readLine().toCharArray();
    final int n = line.length;

    int ans = 0;
    int[] cnt = new int[26];
    int right = 0;
    for (int left = 0; left < n; left++) {

      while (right < n && cnt[line[right] - 'a'] != 1) {
        cnt[line[right] - 'a']++;
        right++;
      }

      ans = Math.max(ans, right - left);

      cnt[line[left] - 'a']--;
    }

    bw.write(String.valueOf(ans));

    br.close();
    bw.close();
  }
}
