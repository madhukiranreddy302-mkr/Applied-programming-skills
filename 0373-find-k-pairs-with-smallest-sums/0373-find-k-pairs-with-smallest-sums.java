class Solution {
    public class tuple {
        int sum;
        int r;
        int c;

        public tuple(int sum, int r, int c) {
            this.sum = sum;
            this.r = r;
            this.c = c;
        }
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        List<List<Integer>> ans = new ArrayList<>();
        PriorityQueue<tuple> pq = new PriorityQueue<>(new Comparator<tuple>() {
            @Override
            public int compare(tuple o1, tuple o2) {
                return Integer.compare(o1.sum, o2.sum);
            }
        });


        HashSet<String> vis = new HashSet<>();
        vis.add(0+"-"+0);
        pq.add(new tuple(nums1[0] + nums2[0], 0, 0));
    
        while (k > 0 && (!pq.isEmpty())) {
            tuple rv = pq.poll();
            ans.add(Arrays.asList(nums1[rv.r], nums2[rv.c]));
            k--;
            if (rv.r < n1 - 1 && (!vis.contains(rv.r+1+"-"+rv.c))) {
                pq.add(new tuple(nums1[rv.r + 1] + nums2[rv.c], rv.r + 1, rv.c));
                vis.add(rv.r+1+"-"+rv.c);
            }
            if (rv.c < n2 - 1 && (!vis.contains(rv.r+"-"+(rv.c+1)))) {
                pq.add(new tuple(nums1[rv.r] + nums2[rv.c + 1], rv.r, rv.c + 1));
                vis.add(rv.r+"-"+(rv.c+1));
            }
        }
        return ans;
    }
}