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

    // main function
    public static void main(String[] args) {

        int[] heights = {4, 2, 0, 6, 3, 2,5} ;
        System.out.println(trappingRainWater(heights)); ;

//        int[] arr = {-10, -2, -3, 23423} ;
//        System.out.println(maxSum_prefixSum(arr));
    }
}
