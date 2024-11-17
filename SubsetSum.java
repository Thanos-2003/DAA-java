import java.util.ArrayList;
import java.util.List;

public class SubsetSum {
    // Backtracking function to find subsets with the target sum
    private static void findSubsetsWithSum(int[] nums, int targetSum, int currentIndex, List<Integer> currentSubset, List<List<Integer>> result) {
        if (targetSum == 0) {
            result.add(new ArrayList<>(currentSubset)); // Found a valid subset
            return;
        }

        if (currentIndex >= nums.length || targetSum < 0) {
            return; // No more elements or targetSum is negative, backtrack
        }

        // Include the current element in the subset
        currentSubset.add(nums[currentIndex]);
        findSubsetsWithSum(nums, targetSum - nums[currentIndex], currentIndex + 1, currentSubset, result);

        // Exclude the current element from the subset
        currentSubset.remove(currentSubset.size() - 1);
        findSubsetsWithSum(nums, targetSum, currentIndex + 1, currentSubset, result);
    }

    // Wrapper function to find subsets with the target sum
    public static List<List<Integer>> findSubsetsWithSum(int[] nums, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentSubset = new ArrayList<>();
        findSubsetsWithSum(nums, targetSum, 0, currentSubset, result);
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int targetSum = 7;
        List<List<Integer>> subsets = findSubsetsWithSum(nums, targetSum);

        if (subsets.isEmpty()) {
            System.out.println("No subsets found with the target sum.");
        } else {
            System.out.println("Subsets with the target sum:");
            for (List<Integer> subset : subsets) {
                System.out.println(subset);
            }
        }
    }
}
