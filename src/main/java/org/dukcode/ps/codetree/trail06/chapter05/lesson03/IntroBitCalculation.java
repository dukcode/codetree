package org.dukcode.ps.codetree.trail06.chapter05.lesson03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-bit-calculation/description">LINK</a>
 */
public class IntroBitCalculation {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int q = Integer.parseInt(br.readLine());
    int s = 0;
    while (q-- > 0) {
      st = new StringTokenizer(br.readLine());
      String command = st.nextToken();
      switch (command) {
        case "add": {
          int x = Integer.parseInt(st.nextToken());
          s |= (1 << x);
          break;
        }
        case "delete": {
          int x = Integer.parseInt(st.nextToken());
          s &= ~(1 << x);
          break;
        }
        case "print": {
          int x = Integer.parseInt(st.nextToken());
          bw.write(String.valueOf(((s >> x) & 1) == 1 ? 1 : 0));
          bw.newLine();
          break;
        }
        case "toggle": {
          int x = Integer.parseInt(st.nextToken());
          s ^= (1 << x);
          break;
        }
        case "clear": {
          s = 0;
          break;
        }
        default:
          break;
      }
    }

    br.close();
    bw.close();
  }
}
