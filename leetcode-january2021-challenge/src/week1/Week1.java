package week1;

public class Week1 {

    public static void main(String[] args) {
        int[] arr = new int[] {85};
        int[][] pieces = new int[][] {{85}};
        System.out.println(Week1.canFormArray(arr, pieces));
    }

    public static boolean canFormArray(int[] arr, int[][] pieces) {
        int arrLen = arr.length;
        int seq = 0;
        int curr = 0;
        for(int x = 0 ; x<=arrLen ; x++) {
            for (int i = 0; i <= pieces.length; i++) {

                for (int k = 0; k <= pieces[i].length; k++) {
                    curr+=1;
                    if (pieces[i].length > 1) {
                        if(arr[x] == pieces[i][k])
                            seq++;
                        if(curr != seq)
                            return false;
                    } else {
                        if(arr[x] == pieces[i][k])
                            arrLen--;
                    }

                }
            }
            if(arrLen == 0)
                return true;
        }


        return false;

    }
}
