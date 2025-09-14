package org.dukcode.ps.codetree.trail05.chapter01.lesson03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-invitation-and-number-tag/description">LINK</a>
 */
public class ChallengeInvitationAndNumberTag {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int g;
  private static List<Integer>[] personToGroups;
  private static List<Integer>[] groupToPeople;
  private static boolean[] invited;
  private static int[] uninvitedCount;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    g = Integer.parseInt(st.nextToken());

    personToGroups = new ArrayList[n];
    for (int i = 0; i < n; i++) {
      personToGroups[i] = new ArrayList<>();
    }
    groupToPeople = new ArrayList[g];
    for (int i = 0; i < g; ++i) {
      groupToPeople[i] = new ArrayList<>();
    }

    invited = new boolean[n];
    uninvitedCount = new int[g];
    for (int i = 0; i < g; i++) {
      st = new StringTokenizer(br.readLine());
      uninvitedCount[i] = Integer.parseInt(st.nextToken());
      for (int idx = 0; idx < uninvitedCount[i]; idx++) {
        int number = Integer.parseInt(st.nextToken()) - 1;
        groupToPeople[i].add(number);
        personToGroups[number].add(i);
      }
    }

    bw.write(String.valueOf(solve()));

    br.close();
    bw.close();
  }

  private static int solve() {
    Queue<Integer> q = new LinkedList<>();
    q.offer(0);
    invited[0] = true;

    int cnt = 0;
    while (!q.isEmpty()) {
      int cur = q.poll();
      cnt++;
      for (int groupIdx : personToGroups[cur]) {

        uninvitedCount[groupIdx]--;

        if (uninvitedCount[groupIdx] != 1) {
          continue;
        }

        for (int peopleIdx : groupToPeople[groupIdx]) {
          if (invited[peopleIdx]) {
            continue;
          }

          q.offer(peopleIdx);
          invited[peopleIdx] = true;
        }
      }
    }

    return cnt;
  }

}
