package org.dukcode.ps.codetree.trail03.chapter02.lesson04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-process-numeric-commands-8/description">LINK</a>
 */
public class IntroProcessNumericCommands8 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    LinkedList<Integer> ll = new LinkedList<>();

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      String command = st.nextToken();
      int value = st.hasMoreTokens() ? Integer.parseInt(st.nextToken()) : Integer.MIN_VALUE;

      switch (command) {
        case "push_front":
          ll.offerFirst(value);
          break;
        case "push_back":
          ll.offerLast(value);
          break;
        case "pop_front":
          bw.write(String.valueOf(ll.pollFirst()));
          bw.newLine();
          break;
        case "pop_back":
          bw.write(String.valueOf(ll.pollLast()));
          bw.newLine();
          break;
        case "size":
          bw.write(String.valueOf(ll.size()));
          bw.newLine();
          break;
        case "empty":
          bw.write(String.valueOf(ll.isEmpty() ? 1 : 0));
          bw.newLine();
          break;
        case "front":
          bw.write(String.valueOf(ll.peekFirst()));
          bw.newLine();
          break;
        case "back":
          bw.write(String.valueOf(ll.peekLast()));
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
