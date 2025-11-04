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
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-change-tree-traversal-2/description">LINK</a>
 */
public class ChallengeChangeTreeTraversal2 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int[] preorder;
  private static int[] inorder;
  private static int[] inorderMap;
  private static List<Integer> postorder;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());

    preorder = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      preorder[i] = Integer.parseInt(st.nextToken());
    }

    inorder = new int[n];
    inorderMap = new int[n + 1];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      inorder[i] = Integer.parseInt(st.nextToken());
      inorderMap[inorder[i]] = i;
    }

    postorder = new ArrayList<>();
    postOrder(0, n, 0, n);

    for (Integer num : postorder) {
      bw.write(String.valueOf(num));
      bw.write(' ');
    }

    br.close();
    bw.close();
  }

  private static void postOrder(int preFrIn, int preToEx, int inFrIn, int inToEx) {
    int size = preToEx - preFrIn;

    if (size == 0) {
      return;
    }

    int parent = preorder[preFrIn];

    int inorderParentIdx = findIdx(parent, inFrIn, inToEx, inorder);

    int leftSize = inorderParentIdx - inFrIn;
    int rightSize = inToEx - (inorderParentIdx + 1);

    postOrder(preFrIn + 1, preFrIn + leftSize + 1, inFrIn, inFrIn + leftSize);
    postOrder(preToEx - rightSize, preToEx, inToEx - rightSize, inToEx);

    postorder.add(parent);
  }

  private static int findIdx(int target, int frIn, int toEx, int[] arr) {
    return inorderMap[target];
  }
}
