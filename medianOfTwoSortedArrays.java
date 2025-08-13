class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int lenA = nums1.length;
        int lenB = nums2.length;
        int[] res = new int[lenA+lenB];

        int i = 0; //Puntero para el array nums1
        int j = 0; //Puntero para el array nums2

        int n = 0; // Puntero para el resultado

        while (i < lenA && j < lenB && n < lenA+lenB){
            if(nums1[i] < nums2[j]){
                res[n] = nums1[i];
                i++;
                n++;
            } else {
                res[n] = nums2[j];
                j++;
                n++;
            }
        }

        while (i < lenA){
            res[n] = nums1[i];
            n++;
            i++;
        } 
        while (j < lenB){
            res[n] = nums2[j];
            n++;
            j++;
        } 

        if(res.length % 2 == 1){
            return res[res.length/2];
        } else {
            int mid = (lenA + lenB) / 2; 
            return (res[mid - 1] + res[mid]) / 2.0;
        }
    }
}
