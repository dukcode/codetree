package org.dukcode.ps.codetree.trail05.chapter02.lesson04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-computer-hours/description">LINK</a>
 */
public class ChallengeComputerHours {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static Usage[] usages;

  private static int[] idToComputer;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());
    usages = new Usage[2 * n];
    for (int i = 0; i < n; ++i) {
      st = new StringTokenizer(br.readLine());
      int onTime = Integer.parseInt(st.nextToken());
      int offTime = Integer.parseInt(st.nextToken());

      usages[2 * i] = new Usage(i, onTime, true);
      usages[2 * i + 1] = new Usage(i, offTime, false);
    }

    idToComputer = new int[n];
    Arrays.fill(idToComputer, -1);

    Arrays.sort(usages, Comparator.comparingInt(u -> u.t));

    PriorityQueue<Integer> freeComputers = IntStream.range(0, n)
        .boxed()
        .collect(Collectors.toCollection(PriorityQueue::new));

    for (Usage usage : usages) {
      if (usage.on) {
        int firstFree = freeComputers.poll();
        idToComputer[usage.id] = firstFree;
      } else {
        freeComputers.offer(idToComputer[usage.id]);
      }
    }

    for (int computer : idToComputer) {
      bw.write(String.valueOf(computer + 1));
      bw.write(' ');
    }

    br.close();
    bw.close();
  }

  private static class Usage {

    int id;
    int t;
    boolean on;

    public Usage(int id, int t, boolean on) {
      this.id = id;
      this.t = t;
      this.on = on;
    }

  }
}
