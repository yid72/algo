package algo2.graph;

import org.junit.Assert;
import org.junit.Test;

public class CCTest {
    @Test
    public void test() {
        final Graph g = GraphExamples.getExample1();

        CC cc = new CC(g);
        Assert.assertEquals(3, cc.count());
        Assert.assertTrue(cc.connected(0, 6));
        Assert.assertTrue(cc.connected(7, 8));
        Assert.assertTrue(cc.connected(9, 12));
        Assert.assertFalse(cc.connected(0, 7));
        Assert.assertFalse(cc.connected(0, 9));
    }
}
