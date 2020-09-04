package data3.structre.a排序_数组;


/**
 * https://leetcode-cn.com/problems/sort-colors/
 * 
 * @author MJ
 *
 */
public class _0075_颜色分类 {
	/*
	 * 一个只包含0、1、2的整型数组，要求对它进行【原地】排序
	 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
	 * 
	 * 空间复杂度O(1)，时间复杂度O(n)
	 */
    public void sortColors(int[] nums) {
    	int h = 0;//红色指针就来遍历所有元素
    	int l = 0;//左边的绿色指针
    	int r = nums.length - 1;//紫色指针
    	while (h <= r) {
    		if (nums[h] == 0) {
    			//和绿色指针交换值
    			swap(nums, h++, l++);
    		} else if (nums[h] == 1) {
    			//扫描指针遇到1 跳过
    			h++;
    		} else {
    			//和紫色指针交换值
    			swap(nums, h, r--);
    		}
    	}
    }
    
    private void swap(int[] nums, int i, int j) {
    	int tmp = nums[i];
    	nums[i] = nums[j];
    	nums[j] = tmp;
    }
}
