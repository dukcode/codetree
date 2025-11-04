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
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-change-tree-traversal-3/description">LINK</a>
 */
public class ChallengeChangeTreeTraversal3 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int[] inorder;
  private static int[] postorder;

  private static int[] inorderMap;

  private static List<Integer> preorder;


  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());

    inorder = new int[n];
    inorderMap = new int[n + 1];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      inorder[i] = Integer.parseInt(st.nextToken());
      inorderMap[inorder[i]] = i;
    }

    postorder = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      postorder[i] = Integer.parseInt(st.nextToken());
    }

    preorder = new ArrayList<>();
    preorder(0, n, 0, n);

    for (int num : preorder) {
      bw.write(String.valueOf(num));
      bw.write(' ');
    }

    br.close();
    bw.close();
  }

  private static void preorder(int inFrIn, int inToEx, int postFrIn, int postToEx) {
    int size = inToEx - inFrIn;

    if (size == 0) {
      return;
    }

    int parent = postorder[postToEx - 1];
    int inorderParentIdx = inorderMap[parent];
    int leftSize = inorderParentIdx - inFrIn;
    int rightSize = inToEx - (inorderParentIdx + 1);

    preorder.add(parent);
    preorder(inFrIn, inFrIn + leftSize, postFrIn, postFrIn + leftSize);
    preorder(inToEx - rightSize, inToEx, postToEx - 1 - rightSize, postToEx - 1);

  }
}
