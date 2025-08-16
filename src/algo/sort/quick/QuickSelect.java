package algo.sort.quick;

public class QuickSelect {
    public int selectKBiggest(int[] nums, int k) {
        if (k > nums.length) {
            throw new IllegalArgumentException("k=" + k + " is greater than n=" + nums.length);
        }

        int index = select(nums, 0, nums.length - 1, k);
        return nums[index];
    }

    private int select(int[] nums, int start, int end, int k) {
        if (start == end) {
            return start;
        }

        int p = partition(nums, start, end, k);
        if (end - p + 1 == k) {
            return p;
        } else if (end - p + 1 > k) {
            return select(nums, p + 1, end, k);
        } else {
            return select(nums, start, p - 1, k - (end - p + 1));
        }
    }

    private int partition(int[] nums, int start, int end, int k) {
        int piviot = nums[start];
        int j = start + 1;
        for (int i = start + 1; i <= end; i++) {
            if (nums[i] < piviot) {
                swap(nums, i, j ++);
            }
        }
        swap(nums, start, j - 1);
        return j - 1;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        test(new int[] {3, 2, 4, 5, 1}, 1);
        test(new int[] {3, 2, 4, 5, 1}, 2);
        test(new int[] {3, 2, 4, 5, 1}, 4);
    }

    private static void test(int[] nums, int k) {
        QuickSelect q = new QuickSelect();
        System.out.println(q.selectKBiggest(nums, k));
    }
}
