package org.example;

import java.util.Arrays;

public class MaximumSubarray {

  public static int[] bruteForce(int[] inArray) {
    int startIndex = 0;
    int endIndex = inArray.length - 1;
    int sum = 0;
    for (int i = 0; i < inArray.length; i++) {
      int tempSum = inArray[i];
      for (int j = i + 1; j < inArray.length; j++) {
        tempSum += inArray[j];
        if (tempSum > sum) {
          sum = tempSum;
          startIndex = i;
          endIndex = j;
        }
      }
    }
    return Arrays.copyOfRange(inArray, startIndex, endIndex + 1);
  }

  public static int[] recursive(int[] inArray) {
    return recursive(inArray, 0, inArray.length);
  }

  public static int[] recursive(int[] inArray, int start, int end) {
    if (end - start <= 2) {
      return Arrays.copyOfRange(inArray, start, end);
    }
    if (end - start <= 4) {
      return bruteForce(Arrays.copyOfRange(inArray, start, end));
    }
    int midPoint = start + (end - start) / 2;
    int[] leftArray = recursive(inArray, start, midPoint);
    int[] rightArray = recursive(inArray, midPoint, end);
    int sum = inArray[midPoint];
    for (int i = midPoint - 1; i >= start; i--) {
      int tempSum = sum + inArray[i];
      if (tempSum > sum) {
        sum = tempSum;
        start = i;
      }
    }
    int leftSum = sum;
    sum = inArray[midPoint];
    for (int i = midPoint + 1; i < end; i++) {
      int tempSum = sum + inArray[i];
      if (tempSum > sum) {
        sum = tempSum;
        end = i;
      }
    }
    int rightSum = sum;
    sum = leftSum + rightSum;
    leftSum = Arrays.stream(leftArray).sum();
    rightSum = Arrays.stream(rightArray).sum();
    if ((sum > leftSum) && (sum > rightSum)) {
      return Arrays.copyOfRange(inArray, start, end + 1);
    }
    else if (leftSum > rightSum) {
      return leftArray;
    }
    else {
      return rightArray;
    }
  }
}
