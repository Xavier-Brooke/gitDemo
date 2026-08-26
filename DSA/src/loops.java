public class loops {

    // max area in histogram
    public static int max_rectangular_area_in_histogram(int[] heights) {
        int n = heights.length ;
        int maxArea = 0 ;

        for(int i = 0; i < n; i++) {
            int tempArea = 0 ;
            int influencing_bar = heights[i] ;

            for(int j = i; j < n; j++) {
                if(heights[j] >= influencing_bar) {
                    tempArea = (j-i+1) * influencing_bar ;
                } else if(heights[j] < influencing_bar) {
                    influencing_bar = heights[j] ;
                    tempArea = (j-i+1) * influencing_bar ;
                }
                maxArea = Math.max(maxArea, tempArea) ;
            }
        }

        return maxArea ;
    }

    public static void main(String[] args) {
        int[] heights =  {2, 1, 5, 6, 2, 3} ;
        System.out.println(max_rectangular_area_in_histogram(heights));
    }
}
