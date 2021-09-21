package org.example;

import java.util.Arrays;

public class App {
  public static void main(String[] args) {
    int[] array = {12, -13, 24, 7, -47, -19, 26, -8, 14, -22};
    System.out.println("Original Array is: " + Arrays.toString(array));
    System.out.println("Maximum Subarray (Brute Force) is: " + Arrays.toString(MaximumSubarray.bruteForce(array)));
    System.out.println("Maximum Subarray (Recursive) is: " + Arrays.toString(MaximumSubarray.recursive(array)));
  }
}
