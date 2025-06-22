package org.dukcode.ps.codetree.trail02.chapter09.lesson03;

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
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-study-cafe-keeping-distance-3/description">LINK</a>
 */
public class IntroStudyCafeKeepingDistance3 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static char[] line;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());
    line = br.readLine().toCharArray();

    PriorityQueue<Integer> dist = new PriorityQueue<>(Comparator.reverseOrder());
    int beforeIdx = -1;
    for (int idx = 0; idx < n; idx++) {
      if (line[idx] == '0') {
        continue;
      }

      if (beforeIdx == -1) {
        beforeIdx = idx;
        continue;
      }

      dist.add(idx - beforeIdx);
      beforeIdx = idx;
    }

    int maxDist = dist.poll();
    dist.offer(maxDist / 2);
    dist.offer(maxDist / 2 + maxDist % 2);

    int minDist = dist.stream().min(Integer::compareTo).get();
    bw.write(String.valueOf(minDist));

    br.close();
    bw.close();

  }
}
