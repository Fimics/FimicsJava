package data3.structre.jDFS;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/permutations/
 */
public class _46_全排列 {
    private List<List<Integer>> list;
    private int[] nums;//[1,2,3]
    /** 用来保存每一层选择的数字 */
    private int[] result;
    /** 用来标记nums中的数字是否被使用过了 */
    private boolean[] used;

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null) return null;
        list = new ArrayList<>();
        if (nums.length == 0) return list;
        this.nums = nums;
        result = new int[nums.length];
        used = new boolean[nums.length];
        dfs(0);
        return list;
    }

    private void dfs(int idx) {
        // 不能再往下搜索
        if (idx == nums.length) {
            List<Integer> resultList = new ArrayList<>();
            for (int value : result) {
                resultList.add(value);
            }
            list.add(resultList);
            return;
        }

        // 枚举这一层所有可以做出的选择
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            result[idx] = nums[i];
            used[i] = true;

            dfs(idx + 1);

            // 还原现场
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> l= new _46_全排列().permute(new int[]{1,2,3,4,5,8});

        l.forEach(it->{
                StringBuffer sb = new StringBuffer();
                sb.append(it).append(" ,");
                System.out.println(sb.toString());

        });

        System.out.println(l.size());
    }
}
