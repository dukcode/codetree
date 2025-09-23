package org.dukcode.ps.codetree.trail05.chapter01.lesson06;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-switch-position-in-array/description">LINK</a>
 */

public class IntroSwitchPositionInArray {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static Node[] nodes;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());

    int q = Integer.parseInt(br.readLine());

    init();

    for (int i = 0; i < q; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      int d = Integer.parseInt(st.nextToken());

      swap(nodes[a], nodes[b], nodes[c], nodes[d]);
    }

    print();

    bw.close();
    br.close();
  }

  private static void init() {
    nodes = new Node[n + 1];
    for (int i = 1; i <= n; i++) {
      nodes[i] = new Node(i);
    }

    for (int i = 1; i < n; i++) {
      connect(nodes[i], nodes[i + 1]);
    }
  }

  private static void print() throws IOException {
    Node cur = nodes[1];
    while (cur.prev != null) {
      cur = cur.prev;
    }

    while (cur != null) {
      bw.write(String.valueOf(cur.id));
      bw.write(' ');
      cur = cur.next;
    }
    bw.newLine();

  }


  private static void connect(Node s, Node e) {
    if (s != null) {
      s.next = e;
    }
    if (e != null) {
      e.prev = s;
    }
  }

  private static void swap(Node a, Node b, Node c, Node d) {
    Node beforePrevC = c.prev;
    Node beforeNextD = d.next;

    Node beforePrevA = a.prev;
    Node beforeNextB = b.next;

    if (b.next == c) {
      beforePrevC = d;
      beforeNextB = a;
    }

    if (d.next == a) {
      beforeNextD = c;
      beforePrevA = b;
    }

    connect(beforePrevC, a);
    connect(b, beforeNextD);

    connect(beforePrevA, c);
    connect(d, beforeNextB);
  }


  private static class Node {

    int id;
    Node prev, next;

    Node(int id) {
      this.id = id;
      this.prev = null;
      this.next = null;
    }
  }

}
