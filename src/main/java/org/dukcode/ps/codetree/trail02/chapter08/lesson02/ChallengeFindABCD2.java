package org.dukcode.ps.codetree.trail02.chapter08.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-find-a-b-c-d-2/description">LINK</a>
 */
public class ChallengeFindABCD2 {

  private static final int N = 15;

  private static final int MN = 1;
  private static final int MX = 40;

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static List<Integer> nums;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    nums = new ArrayList<>();
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      int num = Integer.parseInt(st.nextToken());
      nums.add(num);
    }

    Collections.sort(nums);

    int[] ans = solve();

    for (int num : ans) {
      bw.write(String.valueOf(num));
      bw.write(' ');
    }

    br.close();
    bw.close();

  }

  private static int[] solve() {
    for (int a = MN; a <= MX; ++a) {
      for (int b = a; b <= MX; ++b) {
        for (int c = b; c <= MX; ++c) {
          for (int d = c; d <= MX; ++d) {
            List<Integer> list = new ArrayList<>();
            list.add(a);
            list.add(b);
            list.add(c);
            list.add(d);
            list.add(a + b);
            list.add(b + c);
            list.add(c + d);
            list.add(d + a);
            list.add(a + c);
            list.add(b + d);
            list.add(a + b + c);
            list.add(a + b + d);
            list.add(a + c + d);
            list.add(b + c + d);
            list.add(a + b + c + d);

            Collections.sort(list);
            if (list.equals(nums)) {
              return new int[]{a, b, c, d};
            }
          }
        }
      }
    }

    return new int[]{-1, -1, -1, -1};
  }
}
