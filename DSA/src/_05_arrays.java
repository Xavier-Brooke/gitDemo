public class _05_arrays {

    public static int maxSum_prefixSum(int[] arr) {
        int n = arr.length ;
        int[] prefixSum = new int[n] ;

        prefixSum[0] = arr[0] ;
        for(int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i-1] + arr[i] ;
        }

        int maxSum = Integer.MIN_VALUE ;
        int tempSum = 0 ;
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                if(i == 0) {
                    tempSum = prefixSum[j] ;
                } else {
                    tempSum = prefixSum[j] - prefixSum[i-1] ;
                }

                maxSum = Math.max(maxSum, tempSum) ;
            }
        }

        return  maxSum ;
    }

    public static int trappingRainWater(int[] heights) {

        int n = heights.length ;

        int[] leftMax = new int[n] ;
        leftMax[0] = heights[0] ;
        for(int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i-1], heights[i]) ;
        }

        int[] rightMax = new int[n] ;
        rightMax[n-1] = heights[n-1] ;
        for(int j = (n-2); j >= 0; j--) {
            rightMax[j] = Math.max(rightMax[j+1], heights[j]) ;
        }

        int trappedWater = 0 ;
        int barWidth = 1 ;
        for(int i = 0; i < n; i++) {
            int wtrLevel = Math.min(leftMax[i], rightMax[i]) ;
            trappedWater += (wtrLevel - heights[i]) * barWidth ;
        }

        return trappedWater ;
    }

    public static void reverse(int[] arr, int start, int end) {
        if((start < 0) || (end >= arr.length) || (start > end)) {
            throw new IllegalStateException(start + " and " + end + " is not a valid start and end") ;
        }

        while (start < end) {
            int temp = arr[start] ;
            arr[start] = arr[end] ;
            arr[end] = temp ;
            start++ ;
            end-- ;
        }
    }

    public static void rotate(int[] arr, int k) {
        int n = arr.length ;
        k %= n ;
        if(k == 0) {
            return ;
        }
        reverse(arr, 0, k-1);
        reverse(arr, k, n-1);
        reverse(arr, 0, n-1);
    }

    public static int mostWater(int[] heights) {
        int n = heights.length ;
        int mostWater = Integer.MIN_VALUE ;
        int i = 0 ;
        int j = (n-1) ;
        int wtrLvl, wtrSpan,  tmpCollecteddWtr ;
        while(i < j) {
            wtrLvl = Math.min(heights[i], heights[j]) ;
            wtrSpan = (j-i) ;
            tmpCollecteddWtr = wtrLvl * wtrSpan ;
            mostWater = Math.max(tmpCollecteddWtr, mostWater) ;
            if(heights[i] <= heights[j]) {
                i++ ;
            } else {
                j-- ;
            }
        }

        return mostWater ;
    }

    // main function
    public static void main(String[] args) {

//        int[] heights = {1, 8, 6, 2, 5, 4, 8, 3, 7} ;
//        System.out.println(mostWater(heights));
        int[] heights = {1, 1, 1, 8, 8, 1, 1, 1} ;
        System.out.println(mostWater(heights));

//        int[] arr = {1, 2, 3, 4, 5} ;
//        int k = 5 ;
//        System.out.print("Array before rotation :- ");
//        for(int ele : arr) {
//            System.out.print(ele + " ");
//        }
//        rotate(arr, k);
//        System.out.print("\nArray after rotation :- ");
//        for(int ele : arr) {
//            System.out.print(ele + " ");
//        }

//        int[] heights = {4, 2, 0, 6, 3, 2,5} ;
//        System.out.println(trappingRainWater(heights)); ;

//        int[] arr = {-10, -2, -3, 23423} ;
//        System.out.println(maxSum_prefixSum(arr));

//        int[][] matrix = {{1, 2, 3, 4, 6}} ;
//        System.out.println(matrix.length);
//        System.out.println(matrix[0].length);
    }
}
