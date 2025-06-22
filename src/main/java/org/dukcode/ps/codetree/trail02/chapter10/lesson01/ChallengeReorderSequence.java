package org.dukcode.ps.codetree.trail02.chapter10.lesson01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-reorder-sequence/description">LINK</a>
 */
public class ChallengeReorderSequence {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    int cntLastSorted = 1;
    for (int i = n - 2; i >= 0; --i) {
      if (arr[i] > arr[i + 1]) {
        break;
      }
      cntLastSorted++;
    }

    // 맨 앞의 원소를 맨 뒤의 정렬된 부분에 끼워넣으면 되므로...
    int ans = n - cntLastSorted;
    bw.write(String.valueOf(ans));

    br.close();
    bw.close();

  }
}
