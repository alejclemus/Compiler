package parser;
import javax.swing.tree.TreeNode;
import java.util.Iterator;
import java.util.List;

public class AST {
    public String key;
    List<AST> children;

    public AST(String item, List<AST> children)
    {
        this.key = item;
        this.children=children;
    }

    public String toString() {
        StringBuilder buffer = new StringBuilder(50);
        print(buffer, "", "");
        return buffer.toString();
    }

    private void print(StringBuilder buffer, String prefix, String childrenPrefix) {
        buffer.append(prefix);
        buffer.append(key);
        buffer.append('\n');
        for (Iterator<AST> it = children.iterator(); it.hasNext();) {
            AST next = it.next();
            if (it.hasNext()) {
                print(buffer, childrenPrefix + "├── ", childrenPrefix + "│   ");
            } else {
                print(buffer, childrenPrefix + "└── ", childrenPrefix + "    ");
            }
        }
    }
}

