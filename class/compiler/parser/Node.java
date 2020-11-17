package compiler.parser;

import java.util.Iterator;
import java.util.List;

public class Node {
    scanner.Token key;
    List<Node> children;

    public Node(scanner.Token item)
    {
        this.key = item;
        this.children=null;
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
        for (Iterator<Node> it = children.iterator(); it.hasNext();) {
            Node next = it.next();
            if (it.hasNext()) {
                print(buffer, childrenPrefix + "├── ", childrenPrefix + "│   ");
            } else {
                print(buffer, childrenPrefix + "└── ", childrenPrefix + "    ");
            }
        }
    }

}
