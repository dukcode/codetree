package org.dukcode.ps.codetree.trail02.chapter09.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-coding-talk/description">LINK</a>
 */
public class ChallengeCodingTalk {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int m;
  private static int targetMessage;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    targetMessage = Integer.parseInt(st.nextToken()) - 1;

    int[] sender = new int[m];
    int[] unread = new int[m];
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int person = st.nextToken().charAt(0) - 'A';
      sender[i] = person;
      unread[i] = Integer.parseInt(st.nextToken());

    }

    boolean[] read = calcRead(sender, unread, targetMessage);

    for (int person = 0; person < n; person++) {
      if (!read[person]) {
        bw.write(person + 'A');
        bw.write(' ');
      }
    }

    br.close();
    bw.close();

  }

  private static boolean[] calcRead(int[] sender, int[] unread, int targetMessage) {
    boolean[] read = new boolean[n];
    if (unread[targetMessage] == 0) {
      Arrays.fill(read, true);
      return read;
    }

    for (int message = 0; message < m; ++message) {
      if (unread[message] < unread[targetMessage]) {
        continue;
      }

      read[sender[message]] = true;
    }

    return read;
  }
}
