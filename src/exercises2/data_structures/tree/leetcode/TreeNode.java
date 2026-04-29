package exercises2.data_structures.tree.leetcode;

/*

идеальная задача для тестирования двух алгоритмов - обхода в глубину и обхода в ширину


очередь - добавляет в конец, вытаскивает из начала

стэк - добавляет в начало, забирает из начала

 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
