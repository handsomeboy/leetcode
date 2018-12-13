/**
 * 实现并查集(改进)
 */
public class UnionSet2 {

    private  int[]  parent; //记录上一级节点
    private int count;
    private int[] rank;

    /**
     * 为节点i找到根节点
     * @param i
     * @return
     */
    public  int find(int i){

        int root=i;//初始化为当前节点

        while( parent[root] !=root)
        { //不断查询上一级节点
            root=parent[parent[root]]; //路径压缩
            root=parent[root];
        }
        return  root;

    }

    /**
     * 合并两个节点所处的树
     * @param p
     * @param q
     */
    public void merge(int p,int q){
        int  rootP=find(p);
        int  rootQ=find(q);//找到各自的根节点

        if(rootP==rootQ)
            return;

        if(rank[rootP] > rank[rootQ])
            parent[rootQ]=rootP;
        else {
            parent[rootP] = rootQ; //注意，这里是rootP，也就是P所处的树的根节点
            if (rank[rootP] == rank[rootQ])
                 rank[rootQ]++;
             }

        count--; //合并之后要减去1

    }


    /**
     * 计算朋友换
     * @param M
     * @return
     */
    public int findCircleNum(int[][] M) {

       init(M);

        for(int i=0;i < M.length;i++)
            for(int j=i+1;j<M.length;j++){
                if(M[i][j]==1)  //只有为1的时候才进行判断是否合并
                    merge(i,j);
            }

        return count;
    }







    public  void  init(int[][] M){
        count= M.length; //初始时，每个节点就是一个集合

        parent=new int[count];//
        rank =new int[count];
        for(int i=0;i<count;i++){
            parent[i]=i;
            rank[i]=1;

            //初始时，每个节点都是一个独立的集合，
            // 其集合代表就是自身
        }
    }


    public static  void main(String[] args){



        int[][]  M={{1,0,0},{0,1,0},{0,0,1}};

        UnionSet2 ust =new UnionSet2(); //初始化
        int num= ust.findCircleNum(M);

        System.out.println(num);


    }

}
