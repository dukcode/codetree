package org.dukcode.ps.codetree.trail04.chapter02.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/test-calculations-with-alphabet/description">LINK</a>
 */
public class TestCalculationsWithAlphabet {

  private static BufferedReader br;
  private static BufferedWriter bw;

  private static char[] expression;

  private static int cntAlphabet;
  private static int[] picked;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    expression = br.readLine().toCharArray();

    cntAlphabet = 0;
    for (char c : expression) {
      if (!Character.isAlphabetic(c)) {
        continue;
      }

      cntAlphabet = Math.max(cntAlphabet, c - 'a' + 1);
    }

    picked = new int[cntAlphabet];
    bw.write(String.valueOf(solve(0)));

    br.close();
    bw.close();

  }

  private static int solve(int idx) {
    if (idx == cntAlphabet) {
      return calculate();
    }

    int ret = Integer.MIN_VALUE;
    for (int num = 1; num <= 4; ++num) {
      picked[idx] = num;
      ret = Math.max(ret, solve(idx + 1));
    }

    return ret;
  }

  private static int calculate() {
    int ret = 0;
    char op = '+';
    for (char c : expression) {
      if (!Character.isAlphabetic(c)) {
        op = c;
        continue;
      }

      switch (op) {
        case '+':
          ret += picked[c - 'a'];
          break;
        case '-':
          ret -= picked[c - 'a'];
          break;
        case '*':
          ret *= picked[c - 'a'];
          break;
        default:
          assert false;
      }
    }

    return ret;
  }
}
