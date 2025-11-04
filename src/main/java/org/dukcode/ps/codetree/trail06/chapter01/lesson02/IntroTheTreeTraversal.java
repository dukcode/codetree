package org.dukcode.ps.codetree.trail06.chapter01.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/intro-the-tree-traversal/description">LINK</a>
 */
public class IntroTheTreeTraversal {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  private static int n;
  private static int[] left;
  private static int[] right;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    left = new int[26];
    Arrays.fill(left, -1);
    right = new int[26];
    Arrays.fill(right, -1);

    n = Integer.parseInt(br.readLine());
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int parent = st.nextToken().charAt(0) - 'A';

      char leftChar = st.nextToken().charAt(0);
      int leftIdx = leftChar == '.' ? -1 : leftChar - 'A';

      char rightChar = st.nextToken().charAt(0);
      int rightIdx = rightChar == '.' ? -1 : rightChar - 'A';

      left[parent] = leftIdx;
      right[parent] = rightIdx;
    }

    preorder(0);
    bw.newLine();

    inorder(0);
    bw.newLine();

    postorder(0);
    bw.newLine();

    br.close();
    bw.close();
  }

  private static void preorder(int idx) throws IOException {
    bw.write((char) (idx + 'A'));

    if (left[idx] != -1) {
      preorder(left[idx]);
    }

    if (right[idx] != -1) {
      preorder(right[idx]);
    }

  }

  private static void inorder(int idx) throws IOException {

    if (left[idx] != -1) {
      inorder(left[idx]);
    }

    bw.write((char) (idx + 'A'));

    if (right[idx] != -1) {
      inorder(right[idx]);
    }

  }

  private static void postorder(int idx) throws IOException {
    if (left[idx] != -1) {
      postorder(left[idx]);
    }

    if (right[idx] != -1) {
      postorder(right[idx]);
    }

    bw.write((char) (idx + 'A'));

  }

  private static class A {

    int left = -1;
    int right = -1;

    public A(int left, int right) {
      this.left = left;
      this.right = right;
    }
  }
}
