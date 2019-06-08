package LinkedList;

public class LinkedList {
    private Node head;
    public LinkedList(){
        this.head = new Node();
    }

    public Node addNode(int value){
        Node temp = head;
        while(temp.getNext()!=null){
            temp = temp.getNext();
        }
        Node n = new Node(value);
        temp.setNext(n);
        temp = n;
        return temp;
    }

    public void traverseList(){
        Node temp = head;
        while(temp.getNext()!=null){
            temp = temp.getNext();
            System.out.print(temp.getValue());
            System.out.print(" ->");
        }

    }

    public void deleteNode(int value){
        Node temp = head;
        Node prev = head;
        while(temp!=null){
            if(temp.getValue() == value){
                prev.setNext(temp.getNext());
                temp.setNext(null);
                break;
            }
            prev = temp;
            temp = temp.getNext();
        }

    }
    public static void main(String s[]){
        LinkedList l = new LinkedList();
        l.addNode(4);
        l.addNode(5);
        l.addNode(2);
        l.addNode(7);
        l.traverseList();
        l.deleteNode(5);
        System.out.println();
        l.traverseList();
    }
}
