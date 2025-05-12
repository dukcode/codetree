package org.dukcode.ps.codetree.trail02.chapter01.lesson03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-to-exchange-two-integer-values/introduction">LINK</a>
 */
public class IntroToExchangeTwoIntegerValues {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    IntWrapper n = IntWrapper.of(Integer.parseInt(st.nextToken()));
    IntWrapper m = IntWrapper.of(Integer.parseInt(st.nextToken()));

    swap(n, m);

    bw.write(n.toString());
    bw.write(" ");
    bw.write(m.toString());

    br.close();
    bw.close();

  }

  private static void swap(IntWrapper a, IntWrapper b) {
    IntWrapper temp = IntWrapper.of(a.value);
    a.value = b.value;
    b.value = temp.value;
  }

  private static class IntWrapper {

    public int value;

    private IntWrapper(int value) {
      this.value = value;
    }

    public static IntWrapper of(int value) {
      return new IntWrapper(value);
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
  }
}
