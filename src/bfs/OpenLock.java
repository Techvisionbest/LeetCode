package bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 链接：https://leetcode-cn.com/problems/open-the-lock/
 */
public class OpenLock {

    public int solution(String[] deadends, String target){
        // 死亡密码
        Set<String> deads = new HashSet<>();
        for (String s : deadends){
            deads.add(s);
        }
        // 记录已经穷举过的密码
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        // 广度优先
        int step = 0;
        q.offer("0000");
        visited.add("0000");
        while(!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String current = q.poll();
                if (deads.contains(current)) {
                    continue;
                }
                if (current.equals(target)){
                    return step;
                }
                for (int j = 0; j < 4; j++) {
                    String up = plusNums(current, j);
                    if(!visited.contains(up)){
                        q.offer(up);
                        visited.add(up);
                    }

                    String down = minNums(current, j);
                    if(!visited.contains(down)){
                        q.offer(down);
                        visited.add(down);
                    }
                }
            }

            step ++;
        }
        return -1;
    }
    

    /**
     * 将第 i 个拨轮向上拨动一位
     * @param s
     * @param index
     * @return
     */
    private String plusNums(String s, int index){
        char[] strings = s.toCharArray();
        if(strings[index] == '9'){
            strings[index] = '0';
        }else{
            strings[index] += 1;
        }
        return new String(strings);
    }

    /**
     * 将第 i 个拨轮向下拨动一位
     * @param s
     * @param index
     * @return
     */
    private String minNums(String s, int index){
        char[] strings = s.toCharArray();
        if(strings[index] == '0'){
            strings[index] = '9';
        }else{
            strings[index] -= 1;
        }
        return new String(strings);
    }
}
