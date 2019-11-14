import java.util.*;

public class LeeCode {
    /**
     *  求i一个数组的子集，其中包含了重复元素 需要进行去重，将每个不重复的数字先加进去list中 后记录重复的次数，在之前list中的每个元素加入重复的元素，从1加到n
     * @param num 数组
     * @return 数组的子集
     */
    public List<List<Integer>> subsetsWithDup(int[] num) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> empty = new ArrayList<>();
        list.add(empty);
        Arrays.sort(num);
        for(int i = 0 ; i <num.length ;i++){
            int d = 0;
            //判断当前是否是重复数字 ，并记录重复的次数
            while((i+1<num.length)&&num[i+1] == num[i]){
                d++;
                i++;
            }
            int prenum = list.size();
            for(int j = 0 ; j < prenum ;j ++){
                //遍历之前的几个解
                List<Integer> element = new ArrayList<>(list.get(j));
             //   每次在上次的结果中多加一个重复的数字
                for(int t = 0 ; t <= d ; t++){
                    //加入重复的数字
                    element.add(num[i]);
                    list.add(new ArrayList<>(element));
                }
            }
        }
        return list;
    }
    /**
     * 含有重复元素的数组经过1次旋转 查找目标值
     * 二分查找
     * @param nums 数组
     * @param target 目标值
     * @return 是否可以找到
     */
    public boolean search(int[] nums, int target) {
        int start=0;
        int end=nums.length-1;
        while(start<=end){
            int mid=(start+end)/2;
            if(nums[mid]==target)
                return true;
            //若前半部分有序
            if(nums[start]<nums[mid]){
                if(nums[mid]>=target&&target>=nums[start]){
                    end=mid-1;
                }else{
                    start=mid+1;
                }
                //后半部分有序
            }else if(nums[end]>nums[mid]){
                if(nums[mid]<=target&&target<=nums[end]){
                    start=mid+1;
                }else{
                    end=mid-1;
                }
            }else{
                if(nums[mid]==nums[start])
                    start++;
                else
                    end--;
            }
        }
        return false;
    }
    /**
     * 求一个数组的所有子集
     * @param nums  数组
     * @return  子集
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        //初始化空链表 ---- 1 2 3
        list.add(new ArrayList<>());
        for(int i = 0 ; i <nums.length ; i++){
            //遍历之前的所有结果
            int sz = list.size();
        //    System.out.println(sz);
            for(int j = 0 ; j < sz ; j ++){
                //get方法
                List<Integer> tep = new ArrayList<>(list.get(j));
        //        System.out.println(tep);
                //加入新的数字
                tep.add(nums[i]);
                //每次在这里list会增加一个元素
                list.add(tep);
            }
        }
        return list;
    }
    /**
     *  在二维矩阵中搜索给定个target值
     *  矩阵从左到右是递增，从上到下是递增
     *  所以从右上角开始寻找，若比目标值大则向左寻找，小则向下寻找
     * @param matrix 矩阵
     * @param target 目标值
     * @return 是否找到
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length  == 0 ){
            return false;
        }
        int col = matrix[0].length-1;
        int row = 0;
        while(row<matrix.length && col>=0){
            if(matrix[row][col]<target){
                row++;
            }else if(matrix[row][col] == target){
                return true;
            }else{
                col--;
            }
        }
        return false;
    }
    /**
     * 矩阵置零，将矩阵中含有0的数的行和列全部置为零
     * 使用两个set存放值为0的行号和列号，将矩阵中含有这个行和列的元素值为零
     * @param matrix 矩阵
     */
    public void setZeroes(int[][] matrix) {
        int R = matrix.length;
        int C = matrix[0].length;
        Set<Integer> cl = new HashSet<>();
        Set<Integer> ro = new HashSet<>();
        for(int i = 0 ; i < R ;i++){
            for(int j = 0 ; j < C ; j++){
                if(matrix[i][j]==0){
                    cl.add(j);
                    ro.add(i);
                }
            }
        }
        for(int i = 0 ; i < R ; i++){
            for(int j  = 0; j <C ; j++){
                if(cl.contains(j)||ro.contains(i)){
                    matrix[i][j] = 0;
                }
            }
        }
    }
    /**
     * 若网格中有障碍物，那么从左上到右下一共有多少个不同的路径
     * 将障碍物设置为0 ，按照求路径的方法进行计算
     * @param obstacleGrid 二维数组中 1 代表障碍物  0 代表没有障碍物
     * @return 不同路径的数目
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int R = obstacleGrid.length;
        int C = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        obstacleGrid[0][0] = 1;
        for (int i = 1; i < R; i++) {
            obstacleGrid[i][0] = (obstacleGrid[i][0] == 0 && obstacleGrid[i - 1][0] == 1) ? 1 : 0;
        }
        for (int i = 1; i < C; i++) {
            obstacleGrid[0][i] = (obstacleGrid[0][i] == 0 && obstacleGrid[0][i - 1] == 1) ? 1 : 0;
        }
        for (int i = 1; i < R; i++) {
            for (int j = 1; j < C; j++) {
                if (obstacleGrid[i][j] == 0) {
                    obstacleGrid[i][j] = obstacleGrid[i][j - 1] + obstacleGrid[i - 1][j];
                } else {
                    obstacleGrid[i][j] = 0;
                }
            }
        }
        return obstacleGrid[R - 1][C - 1];
    }

    public static void main(String[] args) {
    //    int[][] res = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        LeeCode l = new LeeCode();
  //      System.out.println(l.uniquePathsWithObstacles(res));
   //     int[][] res1 = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
     //   l.setZeroes(res1);
    //    System.out.println(Arrays.deepToString(res1));
  //      System.out.println(l.searchMatrix(res1,1));
        int []num = {1,2,3};
        System.out.println(1<<3);  //1 左移--2的三次方
        System.out.println(3<<1);  //3 左移--2的一次方
        System.out.println(2<<3);  //2 左移--2的三次方
        System.out.println(3>>1);  //3 右移--2的一次方
        System.out.println(l.subsets(num));
        int[] nums = {2,5,6,0,0,1,2};
        System.out.println(l.search(nums,0));
    }
}
