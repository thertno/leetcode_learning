//运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制 。 
//
// 
// 
// 实现 LRUCache 类： 
//
// 
// LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存 
// int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。 
// void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上
//限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。 
// 
//
// 
// 
// 
//
// 进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？ 
//
// 
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
// 0 <= key <= 3000 
// 0 <= value <= 104 
// 最多调用 3 * 104 次 get 和 put 
// 
// Related Topics 设计 
// 👍 1164 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
//最近最少使用
//淘汰最长时间未使用的元素
class LRUCache {
    private HashMap<Integer, Node> map;
    private DoubleList doubleList;
    private int cap;

    //最近最少使用
    //双向链表，指定在表尾新增元素
    //满容删除表头数据
    //get必须o(1),map
    //插入元素要有顺序，链表
    public LRUCache(int capacity) {
        this.map = new HashMap();
        this.doubleList = new DoubleList();
        this.cap = capacity;
    }

    public int get(int key) {
        if (map.get(key) == null) {
            return -1;
        }
        return makeRecently(key).val;
    }

    public void put(int key, int value) {
        if (map.get(key) != null) {
            dexKey(key);
            addRecently(key, value);
            return;
        }
        if (doubleList.getSize() == cap) {
            //容量已满
            delNotRecently();
        }
        addRecently(key, value);
    }

    /* 将某个 key 提升为最近使用的 */
    public Node makelecently(int key) {
        Node node = map.get(key);
        doubleList.delX(node);
        doubleList.addLast(node);
        return node;
    }

    /* 添加最近使用的元素 */
    //添加一个节点
    public void addRecently(int key, int val) {
        Node x = new Node(key, val);
        doubleList.addLast(x);
        map.put(key, x);
    }

    /* 删除某一个 key */
    public void dexKey(int key) {
        Node x = map.get(key);
        doubleList.delX(x);
        map.remove(key);
    }

    /* 删除最久未使用的元素 */
    public void delNotRecently() {
        Node x = doubleList.delFirst();
        map.remove(x.key);
    }

}

class Node {
    public int key, val;
    public Node pre, nex;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class DoubleList {
    private Node head, tail;
    private int size;

    public DoubleList() {
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        head.nex = tail;
        tail.pre = head;
        this.size = 0;
    }

    //在链表尾部添加节点 x，时间 O(1)
    public void addLast(Node x) {
        x.pre = tail.pre;
        x.nex = tail;
        tail.pre.nex = x;
        tail.pre = x;
        size++;
    }

    // 删除链表中的 x 节点（x 一定存在）
    // 由于是双链表且给的是目标 Node 节点，时间 O(1)
    public void delX(Node x) {
        x.pre.nex = x.nex;
        x.nex.pre = x.pre;
        size--;
    }

    // 删除链表中第一个节点，并返回该节点，时间 O(1)
    public Node delFirst() {
        if (head.nex == tail) {
            return null;
        }
        Node first = head.nex;
        delX(first);
        return first;
    }

    public int getSize() {
        return this.size;
    }


}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)
