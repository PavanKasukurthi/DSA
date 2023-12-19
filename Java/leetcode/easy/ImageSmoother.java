package Java.leetcode.easy;

public class ImageSmoother{
    public static int[][] imageSmoother(int[][] img) {
        int[][] avg = new int[img.length][img[0].length];

        for(int i = 0 ; i < img.length ; i++){
            for(int j = 0 ; j < img[0].length ; j++){
                avg[i][j] = smooth(img, i, j);
            }
        }
        
        return avg;
    }

    public static int smooth(int[][] img, int i, int j){

        int sum = 0;
        int count = 0;

        for(int r = -1 ; i < 1; i++){
            for(int c = -1 ; c < 1; j++){
                int x = i + r;
                int y = j + c;
                if(x >= 0 && y >= 0 && x < img.length && y < img[0].length){
                    sum += img[x][y];
                    count++;
                }
            }
        }
    
        return sum/count;
    }


}