public class List<T> {
  private Node head = null;
  private Node tail = null;

  public List() { this(null); }
  public List(T start) {
    if(start == null) this.head = null;
    else this.head = new Node<T>(start, null, null);
    this.tail = this.head;
  }

  public void append(T o) {
    Node<T> n = new Node<T>(o, tail, null);
    if(this.head == null) {
      this.head = n;
    } else {
      this.tail.setNext(n);
    }
    this.tail = n;
  }
  public void append(T[] os) {
    for(int i=0; i < os.length; i++) {
      this.append(os[i]);
    }
  }

  public void print() {
    Node itr = this.head;
    System.out.print(" |;| ");
    while(itr != null) {
      System.out.print(itr.toString());
      System.out.print(" |;| ");
      itr = itr.getNext();
    }
    System.out.print("\n");
  }

  public T remove() {
    System.out.println(this.tail);
    if (this.tail == null) return null;
    Node n = this.tail;
    this.tail = this.tail.getPrevious();
    return n.getValue();
  }

  public static void main(String[] args) {
    List<String> l = new List<String>();
    l.remove();
    l.print();
    l = new List("This is a test.");
    l.print();
    l.append("1");
    String[] strs = { "A", "B", "C" };
    l.append(strs);
    l.print();
  }
}

class Node<T> {
  private T val = null;
  private Node next = null;
  private Node prev = null;

  public Node(T val) {
    this.val = val;
  }
  public Node(T val, Node prev, Node next) {
    this.val = val;
    this.prev = prev;
    this.next = next;
  }

  public Node getNext() { return this.next; }
  public Node getPrevious() { return this.prev; }
  public Object getValue() { return this.val; }

  public void setNext(Node next) {
    this.next = next;
  }
  public void setPrevious(Node prev) {
    this.prev = prev;
  }

  public String toString() {
    return this.val.toString();
  }
}
