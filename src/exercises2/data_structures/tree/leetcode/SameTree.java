package exercises2.data_structures.tree.leetcode;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class SameTree {


    static void main(){

        Integer x = null;




        TreeNode p = new TreeNode(1);

        p.right = new TreeNode(2);

        //p.left = new TreeNode(3);

        TreeNode q = new TreeNode(1);

        //q.right = new TreeNode(4);

        q.right = new TreeNode(3);


        System.out.println(multiTraverseDFS(p, q));







    }




    private static boolean pairBfs(TreeNode p, TreeNode q){

        if (p == null && q == null){
            return true;
        }

        if (p == null) return false;

        if (q == null) return false;

        if (p.val!=q.val) return false;

        Queue<TreeNode> pQ = new LinkedList<>();

        Queue<TreeNode> qQ = new LinkedList<>();

        pQ.offer(p);

        qQ.offer(q);


        while (!pQ.isEmpty() && !qQ.isEmpty()){


            var pCurrent = pQ.poll();
            var qCurrent = qQ.poll();

            if (pCurrent == null && qCurrent == null) continue;

            if (pCurrent == null) return false;

            if (qCurrent == null) return false;


            if (pCurrent.val!=qCurrent.val){
                return false;
            }

            pQ.offer(pCurrent.left); pQ.offer(pCurrent.right);

            qQ.offer(qCurrent.left); qQ.offer(qCurrent.right);
        }





        return true;


    }

    private static boolean multiTraverseDFS(TreeNode p, TreeNode q){


        if (p == null && q == null){
            return true;
        }

        if (p == null) return false;

        if (q == null) return false;

        if (p.val!=q.val) return false;

        boolean left = multiTraverseDFS(p.left, q.left);

        boolean right = multiTraverseDFS(p.right, q.right);

        return left && right;

    }







    private static void multiTraverseDFS(TreeNode p, TreeNode q, AtomicBoolean result){






        if (p == null && q == null) return;


        if (p == null){
            result.set(false);
            return;
        }

        if (q == null) {
            result.set(false);
            return;
        }

        if (p.val!=q.val) {
            result.set(false);
            return;
        }

        multiTraverseDFS(p.right, q.right, result);
        multiTraverseDFS(q.left, q.left, result);


    }



}
