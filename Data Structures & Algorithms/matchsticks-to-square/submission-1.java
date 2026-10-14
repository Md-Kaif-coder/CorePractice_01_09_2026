class Solution {
    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        for (int el : matchsticks) sum += el;

        if (sum % 4 != 0) return false;

        int side = sum / 4;
        Arrays.sort(matchsticks);

        if (matchsticks[matchsticks.length - 1] > side)
            return false;

        int sides[] = new int[4];

        return find(matchsticks, matchsticks.length - 1, sides, side);
    }

    static boolean find(int arr[], int i, int sides[], int target) {
        if (i < 0) {
            return sides[0] == target &&
                   sides[1] == target &&
                   sides[2] == target &&
                   sides[3] == target;
        }

        for (int j = 0; j < 4; j++) {
            if (sides[j] + arr[i] <= target) {
                sides[j] += arr[i];

                if (find(arr, i - 1, sides, target))
                    return true;

                sides[j] -= arr[i];
            }

            
            if (sides[j] == 0) break;
        }

        return false;
    }
}