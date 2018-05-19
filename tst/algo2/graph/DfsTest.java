package algo2.graph;

import org.junit.Assert;
import org.junit.Test;
import util.PrintUtil;

public class DfsTest {
    @Test
    public void test() {
        final Graph g = GraphExamples.getExample1();

        Dfs dfs = new Dfs(g, 0);
        Assert.assertTrue(dfs.hasPathTo(6));
        Assert.assertTrue(dfs.hasPathTo(4));
        Assert.assertFalse(dfs.hasPathTo(10));

        System.out.print("Path from 0 to 6: ");
        PrintUtil.print(dfs.pathTo(6));

        System.out.print("Path from 0 to 7: ");
        PrintUtil.print(dfs.pathTo(7));

        dfs = new Dfs(g, 9);
        Assert.assertFalse(dfs.hasPathTo(7));
        Assert.assertTrue(dfs.hasPathTo(11));

        System.out.print("Path from 9 to 7: ");
        PrintUtil.print(dfs.pathTo(7));

        System.out.print("Path from 9 to 11: ");
        PrintUtil.print(dfs.pathTo(11));
    }
}
