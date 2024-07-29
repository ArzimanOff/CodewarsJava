package com.other_tasks.tinkoff_tasks;

import java.util.*;
import java.lang.Integer;

public class Solution4 {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int n = scanner.nextInt(); // кол-во процессов
        NaryTree<Integer> tree = new NaryTree<>(1);
        for (int i = 1; i <= n; i++) {
            int cnt = scanner.nextInt(); // кол-во процессов необходимых для продолжения
            if (cnt!=0){
                // считываем какие процессы нужно выполнить для выполнения текущего процесса
                int[] processes = fillProcessesArray(cnt);
                TreeNode<Integer> node = tree.findNode(tree.getRoot(), i);
                if (node != null){
                    for (int j = 0; j < cnt; j++) {
                        node.addChild(new TreeNode<>(processes[j]));
                    }
                }
            }
        }
        // System.out.println(tree.findDepth(tree.getRoot()));
        tree.printLevels(tree.root);
    }

    public static int[] fillProcessesArray(int cnt){
        int[] processes = new int[cnt];
        for (int i = 0; i < cnt; i++) {
            processes[i] = scanner.nextInt();
        }
        return processes;
    }
}


class TreeNode<Integer>{
    Integer value;
    List<TreeNode<Integer>> children;

    public TreeNode(Integer value){
        this.value = value;
        this.children = new ArrayList<>();
    }

    public void addChild(TreeNode<Integer> child){
        this.children.add(child);
    }

    public List<TreeNode<Integer>> getChildren() {
        return children;
    }
}

class NaryTree<Integer> {
    TreeNode<Integer> root;

    public NaryTree(Integer rootValue) {
        root = new TreeNode<>(rootValue);
    }

    public TreeNode<Integer> getRoot() {
        return root;
    }

    // глубиа дерева
    public int findDepth(TreeNode<Integer> node) {
        if (node == null) return 0;

        int maxDepth = 0;
        for (TreeNode<Integer> child : node.getChildren()) {
            int childDepth = findDepth(child);
            if (childDepth > maxDepth) {
                maxDepth = childDepth;
            }
        }

        return maxDepth + 1;
    }

    // поиска узла со значением n
    public TreeNode<Integer> findNode(TreeNode<Integer> node, Integer value) {
        if (node == null) return null;

        if (node.value.equals(value)) return node;

        for (TreeNode<Integer> child : node.getChildren()) {
            TreeNode<Integer> result = findNode(child, value);
            if (result != null) return result;
        }

        return null;
    }


    // Метод для нахождения и вывода уровней дерева
    public void printLevels(TreeNode<Integer> root) {
        List<Integer> allNodes = new ArrayList<>();
        if (root == null) return;

        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);

        List<List<Integer>> levelNodes = new ArrayList<>();

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode<Integer> currentNode = queue.poll();
                currentLevel.add(currentNode.value);

                for (TreeNode<Integer> child : currentNode.getChildren()) {
                    queue.add(child);
                }
            }

            levelNodes.add(currentLevel);
        }

        // Удаляем узлы, которые уже были на нижних уровнях, с верхних уровней
        List<Integer> seen = new ArrayList<>();
        for (int i = levelNodes.size() - 1; i >= 0; i--) {
            List<Integer> currentLevel = levelNodes.get(i);
            currentLevel.removeIf(seen::contains);
            seen.addAll(currentLevel);
        }

        int depth = levelNodes.size();
        System.out.println(depth);

        for (int i = depth - 1; i >= 0; i--) {
            Collections.sort(levelNodes.get(i), (a, b) -> ((Comparable<Integer>)a).compareTo(b));
            System.out.print((levelNodes.get(i).size()) + " ");
            for (Integer nodeData : levelNodes.get(i)) {
                System.out.print(nodeData + " ");
            }
            System.out.println();
        }
    }
}
