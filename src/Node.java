public class Node {

    char ch;
    int counter;
    Node next;

    public Node(char ch){

        this.ch = ch;
        this.counter = 1;
        this.next = null;
    }

    public Node add(Node root, char ch) {

        //System.out.println("node girdi 3 => " + ch);

        // compare other nodes
        // if new character is same before any nodes character
        Node iter = root;
        while(iter.next != null && iter.next.ch != ch)
            iter = iter.next;
        if(iter.next != null && iter.next.ch == ch){

            //System.out.println("node girdi 4 => ");
            iter.next.counter++;

            Node iter2 = null;
            // if it is bigger than first node
            if(root.counter < iter.next.counter) {

                //System.out.println("node girdi 7 => ");
                iter2 = iter.next;
                iter.next = iter2.next;
                iter2.next = root;
                return iter2;
            }

            Node iter3 = root;
            while(iter3.next != null && iter3.next.counter > iter.next.counter)
                iter3 = iter3.next;
            //System.out.println("node girdi 5 => ");

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
        //System.out.println("node girdi 6 => ");
        newNode.next = iter.next;
        iter.next = newNode;
        return root;
    }
}
