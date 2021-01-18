//package pramp;
//
//import java.util.Arrays;
//
//public class SmallestSubstringOfAllCharacters {
//
//
//    /*
//        str = xyyzyzyx
//        arr = ['x', 'y', 'z']
//        result: zyx
//     */
//    static String getShortestUniqueSubstring(char[] arr, String str) {
//        int arrSize = arr.length;
//        int seqPos[] = {};
//        int currPos = 0;
//        for(int i = 0; i <= str.length(); i++) {
//            int pos = Arrays.asList(arr).indexOf(str.charAt(i));
//            if(pos >= 0) {
//                seqPos[currPos] = pos;
//            }
//
//        }
//        str.contains();
//
//        return "";
//    }
//
//
//
//    public static void main(String[] args) {
//        char[] arr = {'x', 'y', 'z'};
//        String str = "xyyzyzyx";
//        String result = getShortestUniqueSubstring(arr, str);
//        System.out.println(result);
//    }
//}
