package org.dukcode.ps.codetree.trail05.chapter01.lesson06;

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
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-linked-list1/description">LINK</a>
 */
public class IntroLinkedList1 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static LinkedList<String> ll;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    ll = new LinkedList<>();
    ll.add(br.readLine());
    ListIterator<String> li = ll.listIterator();

    n = Integer.parseInt(br.readLine());
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int command = Integer.parseInt(st.nextToken());

      switch (command) {
        case 1: { // 왼쪽에 추가
          String value = st.nextToken();
          li.add(value);
          break;
        }
        case 2: { // 오른쪽에 추가
          String value = st.nextToken();
          li.next();
          li.add(value);
          li.previous();
          li.previous();
          break;
        }
        case 3: // 왼쪽 존재하면 왼쪽
          if (li.hasPrevious()) {
            li.previous();
          }
          break;
        case 4: // 오른쪽 존재하면 오른쪽
          if (li.hasNext()) {
            li.next();
            if (!li.hasNext()) {
              li.previous();
            }
          }
          break;
        default:
          break;
      }

      print(li);
    }

    br.close();
    bw.close();
  }

  private static void print(ListIterator<String> li) throws IOException {
    int diff = 0;

    if (li.hasPrevious()) {
      bw.write(li.previous());
      bw.write(' ');
      li.next();
    } else {
      bw.write("(Null)");
      bw.write(' ');
    }

    if (li.hasNext()) {
      bw.write(li.next());
      bw.write(' ');
      if (li.hasNext()) {
        bw.write(li.next());
        bw.write(' ');
        li.previous();
        li.previous();
      } else {
        bw.write("(Null)");
        bw.write(' ');
        li.previous();
      }

    } else {
      bw.write("(Null)");
      bw.write(' ');
      bw.write("(Null)");
      bw.write(' ');
    }

    bw.newLine();
  }
}
