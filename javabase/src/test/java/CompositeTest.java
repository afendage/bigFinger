import com.finger.desgin.composite.TreeNode;
import org.junit.Test;

public class CompositeTest {

    @Test
    public void treeTest(){
        TreeNode root = new TreeNode("");
        TreeNode tree = new TreeNode("A");
        TreeNode node1 = new TreeNode("A1");
        TreeNode node2 = new TreeNode("A2");
        TreeNode node3 = new TreeNode("A3");

        TreeNode node11 = new TreeNode("A11");
        TreeNode node12 = new TreeNode("A12");
        TreeNode node121 = new TreeNode("A121");
        TreeNode node122 = new TreeNode("A122");
        node12.add(node121);
        node12.add(node122);
        node1.add(node11);
        node1.add(node12);
        tree.add(node2);
        tree.add(node3);
        tree.add(node1);

        root.add(tree);
        this.eachNode("",root);
    }

    public void eachNode(String tabLine,TreeNode node){
        StringBuilder line = new StringBuilder(tabLine);
        if(node.getChild().size()>0){
            line.append("-");
            for(TreeNode n:node.getChild()){
                System.out.println(line.toString()+n.getName());
                this.eachNode(line.toString(),n);
            }
        }
    }

}
