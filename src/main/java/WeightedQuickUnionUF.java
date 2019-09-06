/**
 * Created by 1109806 on 2019-09-05.
 */
public class WeightedQuickUnionUF {
    private int[] id;
    private int[] sz;

    public WeightedQuickUnionUF(int N) {
        id = new int[N];
        sz = new int[N];
        for(int i = 0; i < N; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    /**
     *  path compression: root 를 찾아가는 것 뿐만 아니라 어차피 찾아가는거 그 사이 중간 노드들 root 를 가르키도록 변경하자는 컨셉.
     *  다만, 간단한 수정만으로 그에 상당한 효과를 얻고자 아래와 같이 할아버지 노드를 가르키도록 함.
     */
    private int root(int i) {
        while( i != id[i] ) {
            id[i] = id[id[i]];      // Path compression. Make every other node in path point to its grandparent
            i = id[i];
        }
        return i;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        int proot = root(p);
        int qroot = root(q);
        if( proot == qroot ) return;
        if( sz[proot] > sz[qroot]) {
            id[qroot] = proot;
            sz[proot] += sz[qroot];
        } else {
            id[proot] = qroot;
            sz[qroot] += sz[proot];
        }
    }
}
