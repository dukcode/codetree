package org.dukcode.ps.codetree.trail03.chapter02.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/test-process-numeric-commands-5/description">LINK</a>
 */
public class TestProcessNumericCommands5 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static List<Integer> list;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());

    list = new ArrayList<>();

    for (int i = 0; i < n; ++i) {
      st = new StringTokenizer(br.readLine());
      String command = st.nextToken();

      switch (command) {
        case "push_back":
          int value = Integer.parseInt(st.nextToken());
          list.add(value);
          break;
        case "pop_back":
          list.remove(list.size() - 1);
          break;
        case "size":
          bw.write(String.valueOf(list.size()));
          bw.newLine();
          break;
        case "get":
          int k = Integer.parseInt(st.nextToken());
          bw.write(String.valueOf(list.get(k - 1)));
          bw.newLine();
          break;
        default:
          break;
      }
    }

    br.close();
    bw.close();

  }

}
