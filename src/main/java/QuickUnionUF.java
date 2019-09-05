/**
 * Created by 1109806 on 2019-09-05.
 */
public class QuickUnionUF {
    private int[] id;

    public QuickUnionUF(int N) {
        id = new int[N];
        for(int i = 0; i < N; i++)
            id[i] = i;
    }

    private int root(int i) {
        while( i != id[i] )
            i = id[i];
        return i;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        id[root(p)] = id[root(q)];
    }

    public static void main(String[] args) {
        QuickUnionUF quickUnionUF = new QuickUnionUF(10);

        quickUnionUF.union(0,5);
        quickUnionUF.union(5,6);
        quickUnionUF.union(6,1);
        quickUnionUF.union(1,2);
        quickUnionUF.union(2,7);
        quickUnionUF.union(3,8);
        quickUnionUF.union(3,4);
        quickUnionUF.union(4,9);

        System.out.println(quickUnionUF.connected(0, 7));
        System.out.println(quickUnionUF.connected(0, 9));
    }
}
