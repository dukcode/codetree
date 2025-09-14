package org.dukcode.ps.codetree.trail05.chapter01.lesson04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-Integer-command/description">LINK</a>
 */
public class IntroIntegerCommand {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int t = Integer.parseInt(br.readLine());
    while (t-- > 0) {
      int k = Integer.parseInt(br.readLine());

      TreeSet<Integer> set = new TreeSet<>();
      while (k-- > 0) {
        st = new StringTokenizer(br.readLine());
        String command = st.nextToken();
        int value = Integer.parseInt(st.nextToken());

        switch (command) {
          case "I":
            set.add(value);
            break;
          case "D":
            if (value == 1) {
              set.pollLast();
            } else if (value == -1) {
              set.pollFirst();
            }
            break;
          default:
            break;
        }

      }

      if (set.isEmpty()) {
        bw.write("EMPTY");
      } else {
        bw.write(String.valueOf(set.last()));
        bw.write(' ');
        bw.write(String.valueOf(set.first()));
      }
      bw.newLine();

    }

    br.close();
    bw.close();
  }
}
