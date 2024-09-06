class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }
        for (int num : nums2) {
            set2.add(num);
        }
        if (set1.size() < set2.size())
            return _interSectgion(set1, set2);
        return _interSectgion(set2, set1);
    }

    public int[] _interSectgion(Set<Integer> set1, Set<Integer> set2) {
        int[] result = new int[set1.size()];
        int idx = 0;
        for (Integer s : set1) {
            if (set2.contains(s))
                result[idx++] = s;
        }
        return Arrays.copyOf(result, idx);
    }
}