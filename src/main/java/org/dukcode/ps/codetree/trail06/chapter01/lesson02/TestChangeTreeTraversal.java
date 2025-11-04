package org.dukcode.ps.codetree.trail06.chapter01.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/test-change-tree-traversal/description">LINK</a>
 */
public class TestChangeTreeTraversal {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int[] preorder;

  private static List<Integer> postorder;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());
    preorder = new int[n];
    for (int i = 0; i < n; i++) {
      int num = Integer.parseInt(br.readLine());
      preorder[i] = num;
    }

    postorder = new ArrayList<>();
    postorder(0, n);

    for (int num : postorder) {
      bw.write(String.valueOf(num));
      bw.newLine();
    }

    br.close();
    bw.close();
  }

  private static void postorder(int frIn, int toEx) {
    int size = toEx - frIn;

    if (size == 0) {
      return;
    }

    int parent = preorder[frIn];
    int leftSize = cntLower(parent, frIn + 1, toEx);
    int rightSize = size - leftSize - 1;

    postorder(frIn + 1, frIn + leftSize + 1);
    postorder(toEx - rightSize, toEx);

    postorder.add(parent);
  }

  private static int cntLower(int value, int frIn, int toEx) {
    int ret = 0;
    for (int i = frIn; i < toEx; i++) {
      if (preorder[i] > value) {
        break;
      }

      ret++;
    }

    return ret;
  }
}
