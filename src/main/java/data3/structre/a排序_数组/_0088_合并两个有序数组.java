package data3.structre.a排序_数组;

/**
 * https://leetcode-cn.com/problems/merge-sorted-array/
 * 
 * @author MJ
 *
 */
public class _0088_合并两个有序数组 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
    	// nums1 = [1,3,5,0,0,0], m = 3
    	// nums2 = [2,4,6],       n = 3
		//
    	int i1 = m - 1;//开始指向5
    	int i2 = n - 1;//一开始指向6
    	int cur = nums1.length - 1;//cur指向nums的末尾

		//第二个数组中的数据用完，就可以退出了
    	while (i2 >= 0) {
    		if (i1 >= 0 && nums2[i2] < nums1[i1]) {
    			nums1[cur--] = nums1[i1--];
    		} else { // i1 < 0 || nums2[i2] >= nums1[i1]
    			nums1[cur--] = nums2[i2--];
    		}
    	}
    }
}
