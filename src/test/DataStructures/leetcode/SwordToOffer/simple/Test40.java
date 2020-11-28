package DataStructures.leetcode.SwordToOffer.simple;

/**
 * @Author : jingtao
 * @Data : 2020/07/05/21:45
 * @Description :
 * ������������ arr ���ҳ�������С�� k ���������磬����4��5��1��6��2��7��3��8��8�����֣�����С��4��������1��2��3��4��
 * @Page or WebSite��
 * @Expected result ��
 */

import org.junit.Test;

import java.util.*;


/**
 * 1�������ȡԪ��
 * 2��
 */
public class Test40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];
            int insertIndex = i - 1;
            while (insertIndex >= 0 && temp < arr[insertIndex]) { //��������ֵС��ǰ��ģ��򽻻�
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            arr[insertIndex + 1] = temp;
        }
        int[] ints = new int[k];
        for (int i = 0; i < k; i++) {
            ints[i] = arr[i];
        }
        return ints;
    }

    //�����
    public int[] getLeastNumbers1(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        // Ĭ����С���ѣ�ʵ�ִ������Ҫ��дһ�±Ƚ�����
        Queue<Integer> pq = new PriorityQueue<>((v1, v2) -> v2 - v1);
        for (int num : arr) {
            if (pq.size() < k) {
                pq.offer(num);
            } else if (num < pq.peek()) {
                pq.poll();
                pq.offer(num);
            }
        }
        // ���ض��е�Ԫ��
        int[] res = new int[pq.size()];
        int idx = 0;
        for (int num : pq) {
            res[idx++] = num;
        }
        return res;
    }

    //����
    public int[] getLeastNumbers2(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        // ���һ��������ʾ����Ҫ�ҵ����±�Ϊk-1����
        return quickSearch(arr, 0, arr.length - 1, k - 1);
    }

    private int[] quickSearch(int[] nums, int lo, int hi, int k) {
        // ÿ�����з�1�Σ��ҵ�������±�Ϊj��Ԫ�أ����jǡ�õ���k�ͷ���j�Լ�j������е�����
        int j = partition(nums, lo, hi);
        if (j == k) {
            return Arrays.copyOf(nums, j + 1);
        }
        // ��������±�j��k�Ĵ�С��ϵ�����������з���λ����ҶΡ�
        return j > k ? quickSearch(nums, lo, j - 1, k) : quickSearch(nums, j + 1, hi, k);
    }

    // �����з֣������±�j��ʹ�ñ�nums[j]С��������j����ߣ���nums[j]���������j���ұߡ�
    private int partition(int[] nums, int lo, int hi) {
        int v = nums[lo];
        int i = lo, j = hi + 1;
        while (true) {
            while (++i <= hi && nums[i] < v) ;
            while (--j >= lo && nums[j] > v) ;
            if (i >= j) {
                break;
            }
            int t = nums[j];
            nums[j] = nums[i];
            nums[i] = t;
        }
        nums[lo] = nums[j];
        nums[j] = v;
        return j;
    }

    public int[] getLeastNumbers3(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        // ͳ��ÿ�����ֳ��ֵĴ���
        int[] counter = new int[10001];
        for (int num : arr) {
            counter[num]++;
        }
        // ����counter�����ͷ�ҳ�k������Ϊ���ؽ��
        int[] res = new int[k];
        int idx = 0;
        for (int num = 0; num < counter.length; num++) {
            //�������1001��λ�õ��������¼����λ�õ������ֵĴ�����
            //����ǰ�����С����Ϊ������Ҫ�ҳ����ֵ���С��k������������ֻҪǰ������������㹻�Ĵ������Ͳ���ͳ�ƺ��������
            while (counter[num]-- > 0 && idx < k) {
                res[idx++] = num;
            }
            if (idx == k) {
                break;
            }
        }
        return res;
    }

    //����������
    public int[] getLeastNumbers4(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        // TreeMap��key������, value�Ǹ����ֵĸ�����
        // cnt��ʾ��ǰmap�ܹ����˶��ٸ����֡�
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int cnt = 0;
        for (int num : arr) {
            // 1. �������飬����ǰmap�е����ָ���С��k����map�е�ǰ���ֶ�Ӧ����+1
            if (cnt < k) {
                map.put(num, map.getOrDefault(num, 0) + 1);
                cnt++;
                continue;
            }
            // 2. ����ȡ��map������Key������������), �жϵ�ǰ������map��������ֵĴ�С��ϵ��
            //    ����ǰ���ֱ�map���������ֻ��󣬾�ֱ�Ӻ��ԣ�
            //    ����ǰ���ֱ�map����������С���򽫵�ǰ���ּ���map�У�����map�е�������ֵĸ���-1��
            Map.Entry<Integer, Integer> entry = map.lastEntry();
            if (entry.getKey() > num) {
                map.put(num, map.getOrDefault(num, 0) + 1);
                //ǰ�����һ����Ԫ�ػ��СԪ�صĳ��ָ������ӣ������Ҫ������Ԫ��ֱ��ȥ���������1
                if (entry.getValue() == 1) {
                    map.pollLastEntry();
                } else {
                    map.put(entry.getKey(), entry.getValue() - 1);
                }
            }

        }
        // ��󷵻�map�е�Ԫ��
        int[] res = new int[k];
        int idx = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int freq = entry.getValue();
            while (freq-- > 0) {
                res[idx++] = entry.getKey();
            }
        }
        return res;
    }
    @Test
    public void test() {
        int[] leastNumbers = getLeastNumbers(new int[]{3, 2, 1}, 2);
        for (Integer i : leastNumbers) {
            System.out.println(i);
        }
    }
}
