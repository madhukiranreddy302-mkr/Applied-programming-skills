/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    static class Pair {
        TreeNode data;
        int level;
        int hd;

        public Pair(TreeNode data, int level, int hd) {
            this.data = data;
            this.level = level;
            this.hd = hd;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        if (root == null) {
            return Collections.emptyList();
        }

        // Map<hd, Map<level, PriorityQueue<values>>>
        Map<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

        // BFS queue
        Deque<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0, 0));

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            TreeNode node = pair.data;
            int level = pair.level;
            int hd = pair.hd;

            map.computeIfAbsent(hd, k -> new TreeMap<>())
               .computeIfAbsent(level, k -> new PriorityQueue<>())
               .add(node.val);

            if (node.left != null) {
                queue.offer(new Pair(node.left, level + 1, hd - 1));
            }

            if (node.right != null) {
                queue.offer(new Pair(node.right, level + 1, hd + 1));
            }
        }

        // Build result
        List<List<Integer>> result = new ArrayList<>();

        for (TreeMap<Integer, PriorityQueue<Integer>> colMap : map.values()) {
            List<Integer> column = new ArrayList<>();
            for (PriorityQueue<Integer> pq : colMap.values()) {
                while (!pq.isEmpty()) {
                    column.add(pq.poll());
                }
            }
            result.add(column);
        }

        return result;
    }
}