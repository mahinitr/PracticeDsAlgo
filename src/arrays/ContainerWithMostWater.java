package arrays;

/*
Given n non-negative integers a1, a2, ..., an ,
where each represents a point at coordinate (i, ai). n vertical lines are drawn
such that the two endpoints of line i is at (i, ai) and (i, 0).
Find two lines, which together with x-axis forms a container,
such that the container contains the most water.

Note: You may not slant the container and n is at least 2.

Examle:

Input: [1,8,6,2,5,4,8,3,7]
Output: 49

The vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
In this case, the max area of water (blue section) the container can contain is 49.

 */


// We can use two-pointer approach
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int m = height.length;
        if(m < 2){
            return 0;
        }
        int maxArea = 0;
        int i=0, j=m-1;
        while(i<j){
            maxArea = Math.max(maxArea, (j-i)*Math.min(height[i], height[j]));
            if(height[j]<height[i]){
                j--;
            }else{
                i++;
            }
        }
        return maxArea;
    }

    public static void main(String args[]){
        int[] arr = new int[]{1,8,6,2,5,4,8,3,7};


    }

}
