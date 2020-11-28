package DataStructures.MyBST;

import org.junit.Assert;

import java.util.*;

/**
 * @Author : jingtao
 * @Data : 2020/11/01/16:58
 * @Description :
 * @PageOrWebSite：
 * @Expected result ：
 */
public class AVLMap<K, V> implements Iterable<AVLEntry<K, V>> {
    private int size;
    AVLEntry<K, V> root;
    private Comparator<K> comp;
    private LinkedList<AVLEntry<K, V>> stack = new LinkedList<>();

    private int compare(K a, K b) {
        if (comp != null) {
            return comp.compare(a, b);
        } else {
            Comparable<K> comparable = (Comparable<K>) a;
            return comparable.compareTo(b);
        }
    }

    public AVLMap() {
    }

    public AVLMap(Comparator<K> comp) {
        this.comp = comp;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public V put(K key, V value) {
        AVLEntry<K, V> kvavlEntry1 = new AVLEntry<>(key, value);
        stack.push(root);
        if (root == null) {
            root = kvavlEntry1;
            size++;
        } else {
            AVLEntry<K, V> p = root;
            while (p != null) {
                stack.push(p);
                int compareResult = compare(key, p.key);
                if (compareResult == 0) {
                    p.setValue(value);
                    break;
                } else if (compareResult < 0) {
                    if (p.left == null) {
                        p.left = kvavlEntry1;
                        size++;
                        stack.push(p.left);
                        break;
                    } else {
                        p = p.left;
                    }
                } else {
                    if (p.right == null) {
                        p.right = kvavlEntry1;
                        size++;
                        stack.push(p.right);
                        break;
                    } else {
                        p = p.right;
                    }
                }
            }
        }
        fixAfterInsterion(key);
        return value;
    }

    private AVLEntry<K, V> getEntry(K key) {
        AVLEntry<K, V> p = this.root;
        while (p != null) {
            int compare = compare(key, p.key);
            if (compare == 0) {
                return p;
            } else if (compare > 0) {
                p = p.right;
            } else {
                p = p.left;
            }
        }
        return null;
    }

    public boolean containsKey(K key) {
        AVLEntry<K, V> entry = getEntry(key);
        return entry != null;
    }

    public V get(K key) {
        AVLEntry<K, V> entry = getEntry(key);
        return entry == null ? entry.value : null;
    }

    //需要遍历整个树
    public boolean containsValue(V value) {
        Iterator<AVLEntry<K, V>> iterator = this.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getValue().equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<AVLEntry<K, V>> iterator() {
        return new AVLIterator<>(root);
    }

    public AVLEntry<K, V> getFirstEntry(AVLEntry<K, V> p) {
        if (p == null) {
            return null;
        }
        while (p.left != null) {
            p = p.left;
        }
        return p;
    }

    public AVLEntry<K, V> getLastEntry(AVLEntry<K, V> p) {
        if (p == null) {
            return null;
        }
        while (p.right != null) {
            p = p.right;
        }
        return p;
    }

    private AVLEntry<K, V> deleteEntry(AVLEntry<K, V> p, K key) {
        if (p == null) {
            return null;
        } else {
            int compare = compare(key, p.key);
            //找到了这个节点
            if (compare == 0) {
                //只有这一个节点，将节点置空即可
                if (p.left == null && p.right == null)
                    p = null;
                    //左节点或右节点有仅有一方不为空，只将其左右子节点放到原节点即可
                else if (p.left != null && p.right == null)
                    p = p.left;
                else if (p.right != null && p.left == null)
                    p = p.right;
                    //既有左子节点又有右子节点，将左子节点的最大节点或右子节点的最小节点赋予原值即可
                else {
                    if ((size & 1) == 0) {
                        AVLEntry<K, V> rightMin = getFirstEntry(p.right);
                        p.key = rightMin.key;
                        p.value = rightMin.value;
                        //将被替换的节点的原节点删除
                        AVLEntry newRight = deleteEntry(p.right, p.key);
                        p.right = newRight;
                    } else {
                        AVLEntry<K, V> leftMin = getLastEntry(p.left);
                        p.key = leftMin.key;
                        p.value = leftMin.value;
                        //将被替换的节点的原节点删除
                        AVLEntry newLeft = deleteEntry(p.right, p.key);
                        p.left = newLeft;
                    }
                }
                //向左向右进行递归查找删除
            } else if (compare < 0) {
                AVLEntry avlEntry = deleteEntry(p.left, key);
                p.left = avlEntry;
            } else {
                AVLEntry avlEntry = deleteEntry(p.right, key);
                p.right = avlEntry;
            }
            return p;
        }
    }

    public V remove(K key) {
        AVLEntry<K, V> entry = getEntry(key);
        if (entry == null) {
            return null;
        }
        V value = entry.getValue();
        root = deleteEntry(root, key);
        size--;
        return value;
    }

    public void levelOrder() {
        Queue<AVLEntry<K, V>> list = new LinkedList<>();
        list.offer(root);
        //preCount保存的是一层出栈的节点的数量，当清零后表示一层节点输出完毕，需要换行
        int preCount = 1;
        int pCount = 0;
        while (!list.isEmpty()) {
            preCount--;
            AVLEntry<K, V> poll = list.poll();
            System.out.print(poll + " ");
            //pCount表示poll这个节点下面有几个子节点
            if (poll.left != null) {
                list.offer(poll.left);
                pCount++;
            }
            if (poll.right != null) {
                list.offer(poll.right);
                pCount++;
            }
            if (preCount == 0) {
                preCount = pCount;
                pCount = 0;
                System.out.println();
            }
        }
    }

    public int getHeight(AVLEntry<K, V> entry) {
        return entry == null ? 0 : entry.height;
    }

    public AVLEntry<K, V> rotateRight(AVLEntry<K, V> p) {
        AVLEntry<K, V> left = p.left;//获取节点的左节点
        p.left = left.right;//将左节点的右节点设置为根节点的右节点
        left.right = p;//将左节点的右节点设置为根节点
        p.height = Math.max(getHeight(p.left), getHeight(p.right)) + 1;
        left.height = Math.max(getHeight(left.left), p.height) + 1;
        return left;
    }

    public AVLEntry<K, V> rotateLeft(AVLEntry<K, V> p) {
        AVLEntry<K, V> right = p.right;
        p.right = right.left;
        right.left = p;
        p.height = Math.max(getHeight(p.left), getHeight(p.right)) + 1;
        right.height = Math.max(getHeight(right.right), p.height) + 1;
        return right;
    }

    //先让左子结点左旋，再让整个树右旋，返回根节点
    public AVLEntry<K, V> firstLeftThenRight(AVLEntry<K, V> p) {
        p.left = rotateLeft(p.left);
        p = rotateRight(p);
        return p;
    }

    //先让右子结点右旋，在让整个树左旋，返回根节点
    public AVLEntry<K, V> firstLeftThenLeft(AVLEntry<K, V> p) {
        p.right = rotateRight(p.right);
        p = rotateLeft(p);
        return p;
    }

    public void fixAfterInsterion(K key) {
        AVLEntry<K, V> p = this.root;
        while (!stack.isEmpty()) {
            p = stack.pop();
            int newHeight = Math.max(getHeight(p.left), getHeight(p.right)) + 1;
            if (p.height > 1 && newHeight == p.height) {
                stack.clear();
                return;
            }
            p.height = newHeight;
            int d = getHeight(p.left) - getHeight(p.right);
            if (Math.abs(d) <= 1) {
                continue;
            } else {
                if (d == 2) {
                    if (compare(key, p.left.key) < 0) {
                        p = rotateRight(p);
                    } else
                        p = firstLeftThenRight(p);
                } else {
                    if (compare(key, p.right.key) < 0) {
                        p = rotateLeft(p);
                    } else
                        p = firstLeftThenLeft(p);
                }
            }
            if (!stack.isEmpty()) {
                if (compare(key, stack.peek().key) < 0) {
                    stack.peek().left = p;
                } else stack.peek().right = p;
            }
        }
        root = p;
    }

    public void checkBalance() {
        postOrderChackBalance(root);
    }

    private void postOrderChackBalance(AVLEntry<K, V> p) {
        if (p != null) {
            postOrderChackBalance(p.left);
            postOrderChackBalance(p.right);
            Assert.assertTrue(Math.abs(getHeight(p.left)) - getHeight(p.right) <= 1);
        }
    }
}