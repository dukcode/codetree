package org.dukcode.ps.codetree.trail05.chapter01.lesson05;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-process-numeric-commands-6/description">LINK</a>
 */
public class IntroProcessNumericCommands6 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
    while (n-- > 0) {
      st = new StringTokenizer(br.readLine());
      String command = st.nextToken();

      switch (command) {
        case "push":
          int value = Integer.parseInt(st.nextToken());
          pq.offer(value);
          break;
        case "pop":
          bw.write(String.valueOf(pq.poll()));
          bw.newLine();
          break;
        case "size":
          bw.write(String.valueOf(pq.size()));
          bw.newLine();
          break;
        case "empty":
          bw.write(String.valueOf(pq.isEmpty() ? 1 : 0));
          bw.newLine();
          break;
        case "top":
          bw.write(String.valueOf(pq.peek()));
          bw.newLine();
          break;
      }
    }

    br.close();
    bw.close();
  }
}
