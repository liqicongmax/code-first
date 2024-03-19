package codeTop.mid.lc146;//
// 请你设计并实现一个满足 
// LRU (最近最少使用) 缓存 约束的数据结构。
// 
//
// 
// 实现 
// LRUCache 类：
// LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存 
// int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。 
// void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 
//key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。 
//
// 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。 
//
// 示例： 
//
// 
//输入
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//输出
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//解释
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // 缓存是 {1=1}
//lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
//lRUCache.get(1);    // 返回 1
//lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//lRUCache.get(2);    // 返回 -1 (未找到)
//lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//lRUCache.get(1);    // 返回 -1 (未找到)
//lRUCache.get(3);    // 返回 3
//lRUCache.get(4);    // 返回 4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= capacity <= 3000 
// 0 <= key <= 10000 
// 0 <= value <= 10⁵ 
// 最多调用 2 * 10⁵ 次 get 和 put 
// 
//
// Related Topics 设计 哈希表 链表 双向链表 👍 3117 👎 0


import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class LRUCache {

    ListNode head;
    ListNode tail;
    int capacity;
    HashMap<Integer, ListNode> dataMap=new HashMap<>();
    public LRUCache(int capacity) {
        head=new ListNode();
        tail = new ListNode();
        head.next=tail;
        tail.pre=head;
        this.capacity=capacity;
    }
    
    public int get(int key) {
        ListNode node = dataMap.get(key);
        if(node==null){
            return -1;
        }
        removeNode(node);
        insertNode(node);
        return node.v;
    }
    
    public void put(int key, int value) {
        ListNode node = dataMap.get(key);
        // key找不到时
        if(node==null){
            // 准备插入一个节点
            // 1.容量满了
            if(dataMap.size()==capacity){
                // 丢弃一个最久未使用的节点
                dataMap.remove(tail.pre.k);
                removeNode(tail.pre);
                // 插入当前值
                node = new ListNode(key,value);
                insertNode(node);
                dataMap.put(key,node);
            }else {
                // 2.容量没满
                node =new ListNode(key,value);
                dataMap.put(key,node);
                insertNode(node);
            }
        }else{
            // key已存在，更新node，并放到最开头
            node.v=value;
            removeNode(node);
            insertNode(node);
        }
    }

    /**
     * 移除节点
     * @param node 待移除的节点
     */
    public void removeNode(ListNode node){
        node.pre.next=node.next;
        node.next.pre=node.pre;
    }

    /**
     * 向头节点前面插一个节点
     * @param node
     */
    public void insertNode(ListNode node){
        node.next=head.next;
        head.next.pre=node;
        node.pre=head;
        head.next=node;
    }

}

class ListNode{
    public int k;
    public int v;
    public ListNode(){

    }
    public ListNode(int k,int v){
        this.k=k;
        this.v=v;
    }
    public ListNode pre;

    public ListNode next;
}



/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)
