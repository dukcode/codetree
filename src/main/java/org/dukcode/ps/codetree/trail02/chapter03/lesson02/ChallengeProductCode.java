package org.dukcode.ps.codetree.trail02.chapter03.lesson02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @see <a
 * href="https://www.codetree.ai/ko/trails/complete/curated-cards/challenge-product-code/description">LINK</a>
 */
public class ChallengeProductCode {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine());
    String name = st.nextToken();
    int code = Integer.parseInt(st.nextToken());

    Product product1 = new Product();
    Product product2 = new Product(name, code);

    bw.write(product1.toString());
    bw.newLine();
    bw.write(product2.toString());

    br.close();
    bw.close();
  }

  private static class Product {

    private String name = "codetree";
    private int code = 50;

    public Product() {
    }

    public Product(String name, int code) {
      this.name = name;
      this.code = code;
    }

    @Override
    public String toString() {
      return "product " + code + " is " + name;
    }
  }
}
