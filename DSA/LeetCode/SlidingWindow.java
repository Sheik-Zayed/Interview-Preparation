class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new LinkedList<>();
        int[] result = new int[nums.length - k + 1];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            // remove out of window
            if (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }
            // maintain decreasing order
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }
            dq.offerLast(i);
            // store result
            if (i >= k - 1) {
                result[index++] = nums[dq.peekFirst()];
            }
        }
        return result;
    }
}