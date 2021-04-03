package xu.barry.stu.jcth;

import org.junit.Test;

/**
 * 题目：小明妈妈给小明30块钱到商店买啤酒，啤酒两块钱一瓶，
 * 近期商店搞活动3个空瓶换一瓶新的啤酒，5个瓶盖也能换一瓶新的啤酒，
 * 用递归算法，通过Java代码实现，计算小明最多能得到多少瓶啤酒？
 *
 * Title: Xiao Ming's mother gave Xiao Ming 30 dollars to buy beer at the store,
 * beer two dollars a bottle, the store recently held an activity for 3 empty bottles for a new bottle of beer,
 * 5 bottle caps can also be changed for a new bottle of beer, using recursive algorithm,
 * through the Java code to calculate the maximum number of bottles of beer Xiao Ming can get?
 */
public class BottleAndCap {


    @Test
    public void test(){
        int initnal = 30/2;
        int n = get(initnal,0,0,0);
        System.out.println(n);
    }

    /**
     *
     * @param n 啤酒
     * @param cap 盖子
     * @param bottle 空瓶
     * @param r 累计
     * @return 结果
     */
    private int get(int n, int cap, int bottle, int r) {
        r = r + n ;
        if (n > 0 ) {
            cap = cap + n;
            bottle = bottle + n;
            int more = (cap / 5) + (bottle / 3);
            if (more == 0){
                return r;
            }
            if (more >0 ){
                return  get(more ,cap%5, bottle%3 ,r);
            }
        }
        return r;
    }
}
