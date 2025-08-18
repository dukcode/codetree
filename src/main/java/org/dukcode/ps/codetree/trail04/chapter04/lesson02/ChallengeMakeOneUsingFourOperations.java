package org.dukcode.ps.codetree.trail04.chapter04.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-make-one-using-four-operations/description">LINK</a>
 */
public class ChallengeMakeOneUsingFourOperations {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static int n;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());

    int ans = solve();
    bw.write(String.valueOf(ans));

    br.close();
    bw.close();
  }

  private static int solve() {
    Map<Integer, Integer> counts = new HashMap<>();

    Queue<Integer> q = new ArrayDeque<>();

    counts.put(n, 0);
    q.offer(n);

    while (!q.isEmpty()) {
      int cur = q.poll();

      if (cur == 1) {
        return counts.get(cur);
      }

      for (Operation op : Operation.values()) {
        if (!op.isApplicable(cur)) {
          continue;
        }

        int next = op.apply(cur);

        if (counts.containsKey(next)) {
          continue;
        }

        counts.put(next, counts.get(cur) + 1);
        q.offer(next);
      }
    }

    return -1;
  }

  private enum Operation {
    SUBTRACT_ONE(n -> true, n -> n - 1),
    ADD_ONE(n -> true, n -> n + 1),
    DIVIDE_BY_TWO(n -> n % 2 == 0, n -> n / 2),
    DIVIDE_BY_THREE(n -> n % 3 == 0, n -> n / 3);

    private final Predicate<Integer> precondition;
    private final UnaryOperator<Integer> function;

    Operation(Predicate<Integer> precondition, UnaryOperator<Integer> function) {
      this.precondition = precondition;
      this.function = function;
    }

    public boolean isApplicable(int n) {
      return precondition.test(n);
    }

    public int apply(int n) {
      return function.apply(n);
    }
  }
}
