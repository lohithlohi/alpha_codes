/*
You are given a 2D integer array descriptions where descriptions[i] = [parenti, childi, isLefti] indicates that parenti is the parent of childi in a binary tree of unique values. Furthermore,

If isLefti == 1, then childi is the left child of parenti.
If isLefti == 0, then childi is the right child of parenti.
Construct the binary tree described by descriptions and return its root.

The test cases will be generated such that the binary tree is valid.

Input: descriptions = [[1,2,1],[2,3,0],[3,4,1]]
Output: [1,2,null,null,3,4]
Explanation: The root node is the node with value 1 since it has no parent.
The resulting binary tree is shown in the diagram.

Input: descriptions = [[20,15,1],[20,17,0],[50,20,1],[50,80,0],[80,19,1]]
Output: [50,20,80,15,17,19]
Explanation: The root node is the node with value 50 since it has no parent.
The resulting binary tree is shown in the diagram.

 */


package BinaryTree;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) { this.val = val; }
}

class LeetBuildTree {
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> nodeMap = new HashMap<>();
        Set<Integer> children = new HashSet<>();
        
        for (int[] description : descriptions) {
            int parentVal = description[0];
            int childVal = description[1];
            boolean isLeft = description[2] == 1;
            
            // Get the parent node, create if it doesn't exist
            TreeNode parent = nodeMap.getOrDefault(parentVal, new TreeNode(parentVal));
            nodeMap.put(parentVal, parent);
            
            // Get the child node, create if it doesn't exist
            TreeNode child = nodeMap.getOrDefault(childVal, new TreeNode(childVal));
            nodeMap.put(childVal, child);
            
            // Establish the relationship
            if (isLeft) {
                parent.left = child;
            } else {
                parent.right = child;
            }
            
            // Mark this node as a child
            children.add(childVal);
        }
        
        // Find the root (the node that is not a child)
        TreeNode root = null;
        for (int nodeVal : nodeMap.keySet()) {
            if (!children.contains(nodeVal)) {
                root = nodeMap.get(nodeVal);
                break;
            }
        }
        
        return root;
    }

    public static void main(String[] args) {
        
    }
}



/*
class Solution {

    public TreeNode makeTree(TreeNode root, int idx, int[][] desc){
        // base case
        if(idx == desc.length){
            return root;
        }

        if(root.val == desc[idx][0]){   // old parent
            if(desc[idx][2] == 1){  // add left
                TreeNode lc = new TreeNode(desc[idx][1]);
                root.left = lc;
            }else{  // right child
                TreeNode rc = new TreeNode(desc[idx][1]);
                root.right = rc;
            }
            return makeTree(root, idx+1, desc);
        }
        else{   // new parent
            TreeNode npar;
            if(desc[idx][1] == root.val){   // existing child
                if(desc[idx][2] == 1){  // add left
                    npar = new TreeNode(desc[idx][0], root, null);
                }else{   // add right
                    npar = new TreeNode(desc[idx][0], null, root);
                }
            }else{   // new child
                if(desc[idx][2] == 1){  // add left
                    npar = new TreeNode(desc[idx][0], new TreeNode(desc[idx][1]), null);
                }else{   // add right
                    npar = new TreeNode(desc[idx][0], null,new TreeNode(desc[idx][1]));
                }
            }
            return makeTree(npar, idx+1, desc);
        }
    }

    public TreeNode createBinaryTree(int[][] desc) {
        TreeNode root = new TreeNode();
        return makeTree(root, 0, desc);
    }
}
 */