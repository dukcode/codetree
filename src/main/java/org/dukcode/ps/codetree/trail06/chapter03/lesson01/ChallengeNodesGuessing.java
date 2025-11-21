package org.dukcode.ps.codetree.trail06.chapter03.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-nodes-guessing/description">LINK</a>
 */
public class ChallengeNodesGuessing {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static String[] idxToName;
  private static Map<String, Integer> nameToIdx;
  private static int m;
  private static List<Integer>[] adj;
  private static int[] inbounds;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());

    idxToName = new String[n];
    st = new StringTokenizer(br.readLine());
    for (int idx = 0; idx < n; idx++) {
      String name = st.nextToken();

      idxToName[idx] = name;
    }

    Arrays.sort(idxToName);

    nameToIdx = new HashMap<>();
    for (int idx = 0; idx < n; idx++) {
      nameToIdx.put(idxToName[idx], idx);
    }

    m = Integer.parseInt(br.readLine());

    adj = new List[n];
    for (int i = 0; i < n; i++) {
      adj[i] = new ArrayList<>();
    }

    inbounds = new int[n];

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int child = nameToIdx.get(st.nextToken());
      int ancestor = nameToIdx.get(st.nextToken());

      adj[ancestor].add(child);
      inbounds[child]++;
    }

    PriorityQueue<String> pq = new PriorityQueue<>();
    List<String> roots = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      if (inbounds[i] == 0) {
        pq.offer(idxToName[i]);
        roots.add(idxToName[i]);
      }
    }

    int cntTree = pq.size();

    List<Integer>[] children = new List[n];
    for (int i = 0; i < n; i++) {
      children[i] = new ArrayList<>();
    }

    while (!pq.isEmpty()) {
      String curName = pq.poll();
      int curIdx = nameToIdx.get(curName);

      for (int nextIdx : adj[curIdx]) {
        inbounds[nextIdx]--;
        if (inbounds[nextIdx] == 0) {
          pq.offer(idxToName[nextIdx]);
          children[curIdx].add(nextIdx);
        }
      }
    }

    bw.write(String.valueOf(cntTree));
    bw.newLine();

    roots.sort(Comparator.naturalOrder());
    for (String rootName : roots) {
      bw.write(rootName);
      bw.write(' ');
    }
    bw.newLine();

    for (int idx = 0; idx < n; idx++) {
      String name = idxToName[idx];

      bw.write(name);
      bw.write(' ');

      bw.write(String.valueOf(children[idx].size()));
      bw.write(' ');

      Collections.sort(children[idx]);

      for (int child : children[idx]) {
        bw.write(idxToName[child]);
        bw.write(' ');
      }

      bw.newLine();
    }

    bw.close();
  }
}
