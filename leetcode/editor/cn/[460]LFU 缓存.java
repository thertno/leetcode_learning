//请你为 最不经常使用（LFU）缓存算法设计并实现数据结构。 
//
// 实现 LFUCache 类： 
//
// 
// LFUCache(int capacity) - 用数据结构的容量 capacity 初始化对象 
// int get(int key) - 如果键存在于缓存中，则获取键的值，否则返回 -1。 
// void put(int key, int value) - 如果键已存在，则变更其值；如果键不存在，请插入键值对。当缓存达到其容量时，则应该在插入新项之
//前，使最不经常使用的项无效。在此问题中，当存在平局（即两个或更多个键具有相同使用频率）时，应该去除 最久未使用 的键。 
// 
//
// 注意「项的使用次数」就是自插入该项以来对其调用 get 和 put 函数的次数之和。使用次数会在对应项被移除后置为 0 。 
//
// 为了确定最不常使用的键，可以为缓存中的每个键维护一个 使用计数器 。使用计数最小的键是最久未使用的键。 
//
// 当一个键首次插入到缓存中时，它的使用计数器被设置为 1 (由于 put 操作)。对缓存中的键执行 get 或 put 操作，使用计数器的值将会递增。 
//
// 
//
// 示例： 
//
// 
//输入：
//["LFUCache", "put", "put", "get", "put", "get", "get", "put", "get", "get", "g
//et"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [3], [4, 4], [1], [3], [4]]
//输出：
//[null, null, null, 1, null, -1, 3, null, -1, 3, 4]
//
//解释：
//// cnt(x) = 键 x 的使用计数
//// cache=[] 将显示最后一次使用的顺序（最左边的元素是最近的）
//LFUCache lFUCache = new LFUCache(2);
//lFUCache.put(1, 1);   // cache=[1,_], cnt(1)=1
//lFUCache.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
//lFUCache.get(1);      // 返回 1
//                      // cache=[1,2], cnt(2)=1, cnt(1)=2
//lFUCache.put(3, 3);   // 去除键 2 ，因为 cnt(2)=1 ，使用计数最小
//                      // cache=[3,1], cnt(3)=1, cnt(1)=2
//lFUCache.get(2);      // 返回 -1（未找到）
//lFUCache.get(3);      // 返回 3
//                      // cache=[3,1], cnt(3)=2, cnt(1)=2
//lFUCache.put(4, 4);   // 去除键 1 ，1 和 3 的 cnt 相同，但 1 最久未使用
//                      // cache=[4,3], cnt(4)=1, cnt(3)=2
//lFUCache.get(1);      // 返回 -1（未找到）
//lFUCache.get(3);      // 返回 3
//                      // cache=[3,4], cnt(4)=1, cnt(3)=3
//lFUCache.get(4);      // 返回 4
//                      // cache=[3,4], cnt(4)=2, cnt(3)=3 
//
// 
//
// 提示： 
//
// 
// 0 <= capacity, key, value <= 104 
// 最多调用 105 次 get 和 put 方法 
// 
//
// 
//
// 进阶：你可以为这两种操作设计时间复杂度为 O(1) 的实现吗？ 
// Related Topics 设计 
// 👍 337 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
//淘汰使用次数最少（频率低）的元素
class LFUCache {
    //freq 使用频率
    //key ->val映射
    private HashMap<Integer, Integer> keyVal;
    //key ->freq映射
    private HashMap<Integer, Integer> keyToFreq;
    //freq ->keys映射
    private HashMap<Integer, LinkedHashSet<Integer>> freqToKeys;

    private int minFreq;
    private int cap;

    public LFUCache(int capacity) {
        this.keyVal = new HashMap();
        this.keyToFreq = new HashMap();
        this.freqToKeys = new HashMap();
        this.minFreq = 0;
        this.cap = capacity;
    }

    public int get(int key) {
        //不存在返回-1
        if (!keyVal.containsKey(key)) {
            return -1;
        }
        increaseFreq(key);
        //存在使用次数+1
//        Integer freq = keyToFreq.get(key);
//        keyToFreq.put(key, freq + 1);
//        LinkedHashSet<Integer> old = freqToKeys.get(freq);
//        old.remove(key);

        return keyVal.get(key);
    }

    public void put(int key, int value) {
        if (this.cap <= 0) {
            return;
        }
        if (keyVal.containsKey(key)) {
            increaseFreq(key);
            keyVal.put(key, value);
            return;
        }
        if (this.cap == keyVal.size()) {
            removeMinFreqKey(key);
        }
        keyVal.put(key, value);
        keyToFreq.put(key, 1);
        freqToKeys.putIfAbsent(1, new LinkedHashSet<Integer>());
        freqToKeys.get(1).add(key);
        this.minFreq = 1;
    }

    private void removeMinFreqKey(Integer key) {
        LinkedHashSet<Integer> linkedHashSet = freqToKeys.get(minFreq);
        Integer deleteKey = linkedHashSet.iterator().next();
        linkedHashSet.remove(deleteKey);
        if (linkedHashSet.isEmpty()) {
            freqToKeys.remove(minFreq);
        }
        keyVal.remove(deleteKey);
        keyToFreq.remove(deleteKey);
    }

    private void increaseFreq(Integer key) {
        Integer freq = keyToFreq.get(key);
        keyToFreq.put(key, freq + 1);
        LinkedHashSet<Integer> old = freqToKeys.get(freq);
        old.remove(key);
        freqToKeys.putIfAbsent(freq + 1, new LinkedHashSet<Integer>());
        freqToKeys.get(freq + 1).add(key);
        if (old.isEmpty()) {
            freqToKeys.remove(freq);
            if (minFreq == freq) {
                minFreq++;
            }
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)
