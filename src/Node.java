public class Node {

    char ch;
    int counter;
    Node next;

    // constructor
    public Node(char ch){

        this.ch = ch;
        this.counter = 1;
        this.next = null;
    }
    // add each character in all dictionary words one-by-one
    public Node add(Node root, char ch) {

        // compare other nodes
        // if new character is same before any nodes character
        Node iter = root;
        while(iter.next != null && iter.next.ch != ch)
            iter = iter.next;

        if(iter.next != null/* && iter.next.ch == ch*/){

            iter.next.counter++;
            Node iter2;
            // if it is bigger than first node
            if(root.counter < iter.next.counter) {

                iter2 = iter.next;
                iter.next = iter2.next;
                iter2.next = root;
                return iter2;
            }

            //if it is bigger than the other any node
            Node iter3 = root;
            while(iter3.next != null && iter3.next.counter > iter.next.counter)
                iter3 = iter3.next;

            iter2 = iter.next.next;
            iter.next.next = iter3.next;
            iter3.next = iter.next;
            iter.next = iter2;
            return root;
        }

        // if new character is different before nodes character, add last node
        Node newNode = new Node(ch);
        iter = root;
        while (iter.next != null && iter.next.counter > newNode.counter)
            iter = iter.next;
        newNode.next = iter.next;
        iter.next = newNode;
        return root;
    }
}
