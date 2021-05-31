package com.leetcode.algorithm.simulation;

import java.util.HashMap;
import java.util.Map;

/**
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制 。
 * 实现 LRUCache 类：
 *
 * LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 *  
 *
 * 进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lru-cache
 */
public class LRU {

    /**
     * 解题思路：采用链表和哈希数组结合的方式，哈希表存放对应的链表结点，查找元素通过哈希表实现O(1)时间复杂度的获取和插入，删除结点通过链表删除，同时获取到结点到哈希表中删除
     * PS：链表要设置虚拟的头和尾方便插入与删除
     * 对于链表的控制需要拆分成几个子方法，以便调理清晰的调用
     */

    /**
     * 创建双向链表结点
     */
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        DLinkedNode(){}
        DLinkedNode(int key, int value){
            this.key=key;
            this.value = value;
        }
    }

    //创建缓存哈希数组
    private Map<Integer, DLinkedNode> cache = new HashMap<Integer, DLinkedNode>();
    private int size;
    private int capacity;
    private DLinkedNode head, tail;

    //初始化LRU
    public LRU(int capacity){
        this.capacity = capacity;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        //hash表获取数据
        DLinkedNode node = cache.get(key);
        if(node == null){
            return -1;
        }else{
            moveToHead(node);
            return node.value;
        }
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        //判断是否存在哈希表中
        if(node !=null){
            node.value = value;
            moveToHead(node);
        }else{
            node = new DLinkedNode(key,value);
            size++;
            if(size>capacity){
                cache.remove(tail.prev.key);
                removeTail();
                size--;
            }
            cache.put(key,node);
            addToHead(node);

        }
    }

    private void addToHead(DLinkedNode node) {
        //设置node结点的前驱和后驱
        node.prev =head;
        node.next= head.next.prev;
        //node结点插入头部
        head.next.prev = node;
        head.next=node;

    }

    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private DLinkedNode removeTail() {
        DLinkedNode res = tail.prev;
        removeNode(tail.prev);
        return res;
    }


}
