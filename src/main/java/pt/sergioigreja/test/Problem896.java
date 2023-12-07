package pt.sergioigreja.test;

public class Problem896 {
    public static void main(String[] args) {
        
    }

    public boolean isMonotonic(int[] nums) {
        if (nums.length < 2) return true;
        Boolean increasing = null;

        for (int i=0; i<nums.length -1; i++) {
            if (nums[i] > nums[i+1]) {
                if (increasing == null) {
                    increasing = true;
                }
                if (increasing == false) return false;
            }else if(nums[i] < nums[i+1]) {
                if (increasing == null) {
                    increasing = false;
                }
                if (increasing == true) return false;
            }
        }

        return true;
    }

    public boolean isMonotonicNice(int[] nums) {
        boolean forwards = true;
        for (int i = 0; i < nums.length-1;i++) {
            if (nums[i] > nums[i+1]) {forwards = false; break;}
        }

        boolean backwards = true;
        for (int i = 0; i < nums.length-1;i++) {
            if (nums[i] < nums[i+1]) {backwards = false; break;}
        }
        System.gc();
        return backwards || forwards;
    }
}
