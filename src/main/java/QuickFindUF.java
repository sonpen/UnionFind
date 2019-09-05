/**
 * Created by 1109806 on 2019-09-05.
 */
public class QuickFindUF {
    private int[] id;

    public QuickFindUF(int N) {
        id = new int[N];
        for(int i = 0; i < N; i++)
            id[i] = i;
    }

    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    public void union(int p, int q) {
        int pid = id[p];
        int qid = id[q];
        if( pid == qid) return;
        for(int i = 0; i < id.length; i++) {
            if(id[i] == pid) id[i] = qid;
        }
        return;
    }

    public static void main(String[] args) {
        QuickFindUF quickFindUF = new QuickFindUF(10);

        quickFindUF.union(0,5);
        quickFindUF.union(5,6);
        quickFindUF.union(6,1);
        quickFindUF.union(1,2);
        quickFindUF.union(2,7);
        quickFindUF.union(3,8);
        quickFindUF.union(3,4);
        quickFindUF.union(4,9);

        System.out.println(quickFindUF.connected(0, 7));
        System.out.println(quickFindUF.connected(0, 9));
    }
}
