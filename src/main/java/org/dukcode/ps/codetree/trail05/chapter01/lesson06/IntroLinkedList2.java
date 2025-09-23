package org.dukcode.ps.codetree.trail05.chapter01.lesson06;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-linked-list2/description">LINK</a>
 */
public class IntroLinkedList2 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int q;
  private static int[] prev;
  private static int[] next;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());
    prev = new int[n + 1];
    next = new int[n + 1];

    q = Integer.parseInt(br.readLine());
    for (int idx = 0; idx < q; idx++) {
      st = new StringTokenizer(br.readLine());
      int command = Integer.parseInt(st.nextToken());

      switch (command) {
        case 1: { // (i) : i를 단일노드가 되게
          int i = Integer.parseInt(st.nextToken());

          if (prev[i] != 0 && next[i] != 0) {
            prev[next[i]] = prev[i];
            next[prev[i]] = next[i];
            next[i] = 0;
            prev[i] = 0;
          } else if (prev[i] != 0) {
            next[prev[i]] = 0;
            prev[i] = 0;
          } else if (next[i] != 0) {
            prev[next[i]] = 0;
            next[i] = 0;
          }

          break;
        }
        case 2: { // (i j) : 단일 노드인 j 노드를 i 앞에 삽입
          int i = Integer.parseInt(st.nextToken());
          int j = Integer.parseInt(st.nextToken());

          if (prev[i] == 0) {
            next[j] = i;
            prev[i] = j;
          } else {
            next[prev[i]] = j;
            prev[j] = prev[i];
            next[j] = i;
            prev[i] = j;
          }

          break;
        }
        case 3: {  // (i j) : 단일 노드인 j 노드를 i 뒤에 삽입
          int i = Integer.parseInt(st.nextToken());
          int j = Integer.parseInt(st.nextToken());

          if (next[i] == 0) {
            prev[j] = i;
            next[i] = j;
          } else {
            prev[next[i]] = j;
            next[j] = next[i];
            prev[j] = i;
            next[i] = j;
          }
          break;
        }
        case 4: { // 이전 이후 노드 출력
          int i = Integer.parseInt(st.nextToken());
          bw.write(String.valueOf(prev[i]));
          bw.write(' ');
          bw.write(String.valueOf(next[i]));
          bw.newLine();
          break;
        }
        default:
          break;
      }
    }

    for (int idx = 1; idx <= n; ++idx) {
      bw.write(String.valueOf(next[idx]));
      bw.write(' ');
    }

    br.close();
    bw.close();
  }
}
