package org.dukcode.ps.codetree.trail05.chapter02.lesson06;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-k-distinct-characters/description">LINK</a>
 */
public class ChallengeKDistinctCharacters {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static char[] line;
  private static int k;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    line = st.nextToken().toCharArray();
    k = Integer.parseInt(st.nextToken());

    bw.write(String.valueOf(solve()));

    br.close();
    bw.close();
  }

  private static int solve() {
    final int n = line.length;
    int[] alphaCnt = new int[26];
    int distinctCnt = 0;

    int ret = 0;
    int right = 0;
    for (int left = 0; left < n; left++) {
      while (right < n && (distinctCnt < k || alphaCnt[line[right] - 'a'] != 0)) {
        alphaCnt[line[right] - 'a']++;
        if (alphaCnt[line[right] - 'a'] == 1) {
          distinctCnt++;
        }
        right++;
      }

      ret = Math.max(ret, right - left);

      alphaCnt[line[left] - 'a']--;
      if (alphaCnt[line[left] - 'a'] == 0) {
        distinctCnt--;
      }
    }

    return ret;
  }
}
