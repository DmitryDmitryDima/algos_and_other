package exercises2.data_structures.tree.leetcode;


import java.util.*;


public class MaximumDepthOfBinaryTree {



    static class LevelCounter {
        int value;
    }


    static void main() {

        TreeNode treeNode = new TreeNode(1);

        treeNode.left = new TreeNode(2);

        treeNode.right = new TreeNode(3);




        treeNode.right.right = new TreeNode(4);

        treeNode.right.right.right = new TreeNode(100);

        treeNode.right.left = new TreeNode(5);

        treeNode.left.right = new TreeNode(6);

        treeNode.left.left = new TreeNode(7);





        System.out.println(new MaximumDepthOfBinaryTree().dfsStack(treeNode));
    }



    // обход в ширину

    public int maxDepthBFS(TreeNode node){

        Queue<TreeNode> nodes = new ArrayDeque<>();

        int level = 0;



        nodes.offer(node); // offer - добавление в конец, push - добавление в начало






        while (!nodes.isEmpty()){


            int size = nodes.size();


            for (int i =0; i<size; i++){
                TreeNode current = nodes.poll();

                if (current.left != null) {
                    nodes.offer(current.left);
                }
                if (current.right != null) {
                    nodes.offer(current.right);
                }
            }


            level++;

        }

        return level;
    }



    // TODO обход в глубину с помощью стэка


    public int dfsStack(TreeNode root){


        Deque<TreeNode> stack = new ArrayDeque<>();



        HashMap<TreeNode, Integer> levelCache = new HashMap<>();
        levelCache.put(root, 1);


        stack.push(root);

        while (!stack.isEmpty()){


            TreeNode current = stack.poll();

            int level = levelCache.get(current);


            if (current.right!=null){

                stack.push(current.right);
                levelCache.put(current.right, level+1);
            }

            if (current.left!=null){
                stack.push(current.left);
                levelCache.put(current.left, level+1);
            }
        }

        return levelCache.values().stream().mapToInt(Integer::intValue).max().orElse(0);
    }



    // обход в глубину без вспомогательного класса
    public int dfsRecursiveAlternative(TreeNode root){
        if (root == null){
            return 0;
        }

        int left = dfsRecursiveAlternative(root.left);

        int right = dfsRecursiveAlternative(root.right);

        return Math.max(left, right)+1;
    }










    // обход в глубину

    public int dfsRecursive(TreeNode root) {

        LevelCounter counter = new LevelCounter();



        traverse(root, 1, counter);

        return counter.value;

    }

    private void traverse(TreeNode node, int level, LevelCounter counter){
        if (node != null){

            if (counter.value<level){
                counter.value = level;
            }

            traverse(node.left, level+1, counter);
            traverse(node.right, level+1, counter);
        }


    }


}
