import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
/**
 * Created by 1109806 on 2019-09-06.
 */
public class UnionFindTest {
    @Test
    public void testQuickFindUF() {
        QuickFindUF quickFindUF = new QuickFindUF(10);

        quickFindUF.union(0,5);
        quickFindUF.union(5,6);
        quickFindUF.union(6,1);
        quickFindUF.union(1,2);
        quickFindUF.union(2,7);
        quickFindUF.union(3,8);
        quickFindUF.union(3,4);
        quickFindUF.union(4,9);

        assertThat(quickFindUF.connected(0, 7), is(true));
        assertThat(quickFindUF.connected(0, 9), is(false));
    }
    @Test
    public void testQuickUnionUF() {
        QuickUnionUF quickUnionUF = new QuickUnionUF(10);

        quickUnionUF.union(0,5);
        quickUnionUF.union(5,6);
        quickUnionUF.union(6,1);
        quickUnionUF.union(1,2);
        quickUnionUF.union(2,7);
        quickUnionUF.union(3,8);
        quickUnionUF.union(3,4);
        quickUnionUF.union(4,9);

        assertThat(quickUnionUF.connected(0, 7), is(true));
        assertThat(quickUnionUF.connected(0, 9), is(false));
    }
}
