package org.dukcode.ps.codetree.trail2.lesson2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-369-games-using-functions/description">LINK</a>
 */
public class Intro369GamesUsingFunctions {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());

    bw.write(String.valueOf(solve(a, b)));

    br.close();
    bw.close();

  }

  private static int solve(int a, int b) {
    if (a > b) {
      return solve(b, a);
    }

    int cnt = 0;
    for (int num = a; num <= b; num++) {
      if (check(num)) {
        cnt++;
      }
    }

    return cnt;
  }

  private static boolean check(int num) {
    if (num % 3 == 0) {
      return true;
    }

    while (num > 0) {
      int digit = num % 10;

      if (digit == 3 || digit == 6 || digit == 9) {
        return true;
      }

      num /= 10;
    }

    return false;
  }
}
