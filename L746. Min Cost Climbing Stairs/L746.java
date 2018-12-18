public class L746 {

    public int minCostClimbingStairs(int[] cost) {

          int len= cost.length + 1 ; //注意，这里是了楼顶，因此多出一个
          int[]  dp =new int[len];

          dp[0]=0;
          dp[1]=0;

          for(int i=2;i < len;i++ ){
              dp[i]=Math.min(dp[i-2]+cost[i-2],dp[i-1] + cost[i-1]);
          }

          return  dp[len-1];
    }


    public int minCostClimbingStairs2(int[] cost) {

        int len= cost.length + 1 ; //注意，这里是了楼顶，因此多出一个

       int  layer0=0;
       int  layer1=0;


        for(int i=2;i < len;i++ ){

            int layer2 =Math.min(layer0+cost[i-2],layer1+ cost[i-1]);

            layer0=layer1;
            layer1=layer2;
        }

        return  layer1;
    }

    public  static void  main(String[] args){
        int[]  cost={1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        L746 sol=new L746();

        int value=  sol.minCostClimbingStairs2(cost);


        System.out.println(value);
    }


}
