package xu.barry.interview.huawei;

import org.junit.Test;

import java.util.Arrays;

public class Arithmetic {

    @Test
    public void test(){
        int[] b =new int[]{1,2,3,4,5};
        System.out.println(numberOfArithmeticSlices(b));
    }
        public int numberOfArithmeticSlices(int[] a){
            int result = 0;
            for(int begin = 0 ; begin < a.length ; begin++){
               for(int limit = begin;  limit < a.length; limit ++ ){
                   int[] splitArray = Arrays.copyOfRange(a, begin, limit+1 );
                   if(isAS(splitArray)){
                       result++;
                   }
               }
            }
            return result;
        }


        public boolean isAS(int[] b){
            //int[] b =new int[]{1,-2,3,4,5};// test example
            boolean result = true;
            if(b.length < 3) return false;
            int delt = b[1] - b[0];
            for(int i = 0; i < b.length; i++){
                if(b[i] != b[0] + delt * i){
                    result = false;
                    break;
                }
            }
            System.out.println(result);
            return result;
        }
}
