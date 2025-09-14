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
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-treeset-basic/description">LINK</a>
 */
public class IntroTreesetBasic {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());

    TreeSet<Integer> set = new TreeSet<>();
    while (n-- > 0) {
      st = new StringTokenizer(br.readLine());
      String command = st.nextToken();

      switch (command) {
        case "add": {
          int value = Integer.parseInt(st.nextToken());
          set.add(value);
          break;
        }
        case "remove": {
          int value = Integer.parseInt(st.nextToken());
          set.remove(value);
          break;
        }
        case "find": {
          int value = Integer.parseInt(st.nextToken());
          bw.write(set.contains(value) ? "true" : "false");
          bw.newLine();
          break;
        }
        case "lower_bound": {
          int value = Integer.parseInt(st.nextToken());
          bw.write(set.ceiling(value) == null ? "None" : String.valueOf(set.ceiling(value)));
          bw.newLine();
          break;
        }
        case "upper_bound": {
          int value = Integer.parseInt(st.nextToken());
          bw.write(set.higher(value) == null ? "None" : String.valueOf(set.higher(value)));
          bw.newLine();
          break;
        }
        case "largest": {
          bw.write(set.isEmpty() ? "None" : String.valueOf(set.last()));
          bw.newLine();
          break;
        }
        case "smallest": {
          bw.write(set.isEmpty() ? "None" : String.valueOf(set.first()));
          bw.newLine();
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
