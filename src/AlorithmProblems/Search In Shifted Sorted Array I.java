public class Solution {
    public int search(int[] array, int target) {
        if (array == null || array.length == 0)
            return -1;
        return search(array, 0, array.length - 1, target);
    }

    public int search(int[] array, int left, int right, int target) {
        if (left > right)
            return -1;

        int mid = left + (right - left) / 2;
        if (target == array[mid])
            return mid;
        if (array[mid] < array[left]) {
            // pivot in left part [left, mid]
            if (array[mid] < target && array[right] >= target)
                return search(array, mid + 1, right, target);
            return search(array, left, mid - 1, target);
        } else {
            // pivot in right part [mid + 1, right]
            if (array[left] <= target && array[mid] > target)
                return search(array, left, mid - 1, target);
            return search(array, mid + 1, right, target);
        }
    }
}
