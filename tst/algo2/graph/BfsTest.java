package algo2.graph;

import org.junit.Assert;
import org.junit.Test;
import util.PrintUtil;

public class BfsTest {
    @Test
    public void test() {
        final Graph g = GraphExamples.getExample1();

        Bfs bfs = new Bfs(g, 0);
        Assert.assertTrue(bfs.hasPathTo(6));
        Assert.assertTrue(bfs.hasPathTo(4));
        Assert.assertFalse(bfs.hasPathTo(10));

        System.out.print("Path from 0 to 6: ");
        PrintUtil.print(bfs.pathTo(6));

        System.out.print("Path from 0 to 7: ");
        PrintUtil.print(bfs.pathTo(7));

        bfs = new Bfs(g, 9);
        Assert.assertFalse(bfs.hasPathTo(7));
        Assert.assertTrue(bfs.hasPathTo(11));

        System.out.print("Path from 9 to 7: ");
        PrintUtil.print(bfs.pathTo(7));

        System.out.print("Path from 9 to 11: ");
        PrintUtil.print(bfs.pathTo(11));
    }
}
