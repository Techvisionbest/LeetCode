package daily;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/top-k-frequent-words/
 * TODO 优先队列
 */
public class TopKFrequent {

    public List<String> solution(String[] words, int k) {
        HashMap<String, Integer> res = new HashMap<>(words.length);
        for (String s : words) {
            res.put(s, res.getOrDefault(s,0) + 1);
        }
        ArrayList<String> ans = new ArrayList<>();
        for (Map.Entry<String, Integer> entry: res.entrySet()) {
            ans.add(entry.getKey());
        }
        Collections.sort(ans, new Comparator<String>() {
            @Override
            public int compare(String word1, String word2) {
                return res.get(word1) == res.get(word2) ? word1.compareTo(word2) : res.get(word2) - res.get(word1);
            }
        });
        return ans.subList(0,k);
    }
}
