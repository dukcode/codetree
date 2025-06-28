package org.dukcode.ps.codetree.trail03.chapter02.lesson05;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-golden-toast/description">LINK</a>
 */
public class IntroGoldenToast {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    LinkedList<Character> ll = new LinkedList<>();
    String line = br.readLine();
    for (int i = 0; i < n; i++) {
      ll.offerLast(line.charAt(i));
    }

    ListIterator<Character> it = ll.listIterator(ll.size());
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      String command = st.nextToken();
      switch (command) {
        case "L":
          if (it.hasPrevious()) {
            it.previous();
          }
          break;
        case "R":
          if (it.hasNext()) {
            it.next();
          }
          break;
        case "D":
          if (it.hasNext()) {
            it.next();
            it.remove();
          }
          break;
        case "P":
          char toAdd = st.nextToken().charAt(0);
          it.add(toAdd);
          break;
        default:
          break;
      }
    }

    for (Character c : ll) {
      bw.write(c);
    }

    br.close();
    bw.close();

  }
}
