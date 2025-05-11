package org.dukcode.ps.codetree.trail02.chapter01.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-quadratic-operations-function/description">LINK</a>
 */
public class ChallengeQuadraticOperationsFunction {

  private static final int MX = 987_654_321;

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    int a = Integer.parseInt(st.nextToken());
    String op = st.nextToken();
    int b = Integer.parseInt(st.nextToken());

    int ans = calc(a, op, b);

    if (ans == MX) {
      bw.write("False");
    } else {
      bw.write(String.valueOf(a));
      bw.write(' ');
      bw.write(op);
      bw.write(' ');
      bw.write(String.valueOf(b));
      bw.write(' ');
      bw.write('=');
      bw.write(' ');
      bw.write(String.valueOf(ans));
    }

    br.close();
    bw.close();

  }

  private static int calc(int a, String op, int b) {
    switch (op) {
      case "+":
        return a + b;
      case "-":
        return a - b;
      case "*":
        return a * b;
      case "/":
        return a / b;
      default:
        return MX;
    }
  }
}
