package org.dukcode.ps.codetree.trail05.chapter02.lesson04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-overlapping-lines/description">LINK</a>
 */
public class ChallengeOverlappingLines {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int k;
  private static TreeMap<Integer, Integer> map;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    int now = 0;
    map = new TreeMap<>();
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int len = Integer.parseInt(st.nextToken());
      int dir = st.nextToken().equals("R") ? 1 : -1;

      int start = now;
      int end = start + len * dir;

      int x1 = Math.min(start, end);
      int x2 = Math.max(start, end);
      map.put(x1, map.getOrDefault(x1, 0) + 1);
      map.put(x2, map.getOrDefault(x2, 0) - 1);

      now = end;
    }

    int ans = 0;
    int before = map.firstKey();
    int overlapped = 0;
    for (Entry<Integer, Integer> entry : map.entrySet()) {
      int x = entry.getKey();
      int diff = entry.getValue();

      int dist = x - before;

      if (overlapped >= k) {
        ans += dist;
      }

      overlapped += diff;
      before = x;
    }

    bw.write(String.valueOf(ans));

    br.close();
    bw.close();
  }

}
