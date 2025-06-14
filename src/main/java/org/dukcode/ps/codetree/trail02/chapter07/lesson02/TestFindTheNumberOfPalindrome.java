package org.dukcode.ps.codetree.trail02.chapter07.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/test-find-the-number-of-palindrome/description">LINK</a>
 */
public class TestFindTheNumberOfPalindrome {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    int x = Integer.parseInt(st.nextToken());
    int y = Integer.parseInt(st.nextToken());

    int cnt = 0;
    for (int num = x; num <= y; num++) {
      if (isPalindrome(num)) {
        cnt++;
      }
    }

    bw.write(String.valueOf(cnt));

    br.close();
    bw.close();

  }

  private static boolean isPalindrome(int num) {
    String numStr = String.valueOf(num);
    int n = numStr.length();

    for (int i = 0; i < n / 2; i++) {
      char st = numStr.charAt(i);
      char en = numStr.charAt(n - 1 - i);

      if (st != en) {
        return false;
      }
    }

    return true;
  }
}
