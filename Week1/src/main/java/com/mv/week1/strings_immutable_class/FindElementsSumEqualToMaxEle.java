package com.mv.week1.strings_immutable_class;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindElementsSumEqualToMaxEle {

    public static void helper(int i, int sum, List<Integer> temp, List<List<Integer>> result, int[] nums, int n) {
        if (sum == 0 && temp.size() != 1) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int j = i; j < n; j++) {
            if (j > i && nums[j] == nums[j - 1]) continue;
            if (nums[j] <= sum) {
                temp.add(nums[j]);
                helper(j + 1, sum - nums[j], temp, result, nums, n);
                temp.remove(temp.size() - 1);
            } else
                return;
        }
    }

    public static List<List<Integer>> findElements(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int x : nums) max = Math.max(max, x);
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        helper(0, max, new ArrayList<>(), result, nums, nums.length);
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 4};
        System.out.println(findElements(nums));
    }

}
