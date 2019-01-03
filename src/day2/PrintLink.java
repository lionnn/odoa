package day2;

import java.util.Stack;

/**
 * 方向打印单向链表
 * <p>面试题5：输入一个链表的头节点，从尾到头反过来打印出每个节点的值</p>
 * @author leoss
 * @version 2019/1/3 23:22
 */
public class PrintLink {


    public static void main(String[] args) {
        int size = 5;
        Node head = genLink(size);
        printLinkByLoop(head);
//        printLinkByRecursion(head);
//        printLinkByArray(head);

        size = 0;
        head = genLink(size);
        printLinkByLoop(head);
//        printLinkByRecursion(head);
//        printLinkByArray(head);

        printLinkByLoop(null);
//        printLinkByRecursion(null);
//        printLinkByArray(null);
    }

    static class Node {
        int val;
        Node next;
    }

    /**
     * 生成指定长度的链表
     *
     * @param size 链表长度
     * @return 链表
     */
    private static Node genLink(int size) {
        Node head = null;
        Node now = null;
        for (int i = 0; i < size; i++) {
            Node node = new Node();
            node.val = i;
            if (i == 0) {
                head = node;
                now = head;
            } else {
                now.next = node;
                now = node;
            }
        }
        return head;
    }

    /**
     * 递归实现反向打印链表
     *
     * @param node 链表头节点
     */
    private static void printLinkByRecursion(Node node) {
        if (node != null) {
            if (node.next != null) {
                printLinkByRecursion(node.next);
            }
            System.out.println("rec : " + node.val);
        } else {
            System.err.println("link is null");
        }
    }

    /**
     * 循环实现反向打印链表
     *
     * @param node 链表头节点
     */
    private static void printLinkByLoop(Node node) {
        if (node == null) {
            System.err.println("link is null");
            return;
        }

        Stack<Integer> stack = new Stack<>();
        while (node != null) {
            stack.push(node.val);
            node = node.next;
        }
        while (!stack.isEmpty()) {
            //注意这里是用pop,不是用peek
            System.out.println("loop : " + stack.pop());
        }
    }

    /**
     * 数组实现反向打印链表
     *
     * @param node 链表头节点
     */
    private static void printLinkByArray(Node node) {
        int size = 0;
        Node tmp = node;
        while (tmp != null) {
            size++;
            tmp = tmp.next;
        }

        Node[] nodes = new Node[size];

        for (int i = 0; i < size; i++) {
            nodes[i] = node;
            node = node.next;
        }

        for (int i = size - 1; i >= 0; i--) {
            System.out.println("arr : " + nodes[i].val);
        }

    }

}
