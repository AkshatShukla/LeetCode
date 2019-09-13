import java.util.ArrayList;
import java.util.List;

public class BinarySearchTreeIterator {
    private List<Integer> inorder;
    private int index;

    public BinarySearchTreeIterator(TreeNode root) {
        this.inorder = new ArrayList<>();
        this.index = -1;
        this._inorder(root);
    }

    private void _inorder(TreeNode root) {
        if (root == null)
            return;
        this._inorder(root.left);
        this.inorder.add(root.val);
        this._inorder(root.right);
    }

    /** @return the next smallest number */
    public int next() {
        return this.inorder.get(++this.index);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return this.index + 1 < this.inorder.size();
    }
}
