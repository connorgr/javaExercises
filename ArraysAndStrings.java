import java.util.Arrays;

public class ArraysAndStrings {
  public static void main(String[] args) {
    System.out.println("Arrays and Strings!\n\n");

    String[] strs = { "START", "MIDDLE", "END" };
    UdfArrayList<String> l = new UdfArrayList(strs);
    l.remove(1);
    l.add("EXTRÄ");

    for(int i = 0; i <= l.size(); i++) {
      System.out.print(l.get(i));
      System.out.print(" |;| ");
    }
    System.out.print("\n");
  }
}

class UdfArrayList<T> {
  private int size;
  private int last;
  private T[] arr;

  UdfArrayList(T[] elems) {
    this(elems, elems.length);
  }
  UdfArrayList(T[] elems, int hint) {
    this.size = elems.length * (elems.length <= hint ? 2 : 1);
    // Generics can't be used in typical array creation (e.g., new T[10]).
    // For more details, see: http://stackoverflow.com/questions/18581002
    this.arr = Arrays.copyOf(elems, this.size);
    this.last = elems.length - 1;
  }

  public void add(T elem) {
    if (this.last == this.arr.length-1) {
      this.expand();
    }
    last++;
    arr[last] = elem;
  }

  public T get(int idx) {
    if (idx > this.last) {
      throw new ArrayIndexOutOfBoundsException("array index out of bounds: "+idx);
    }
    return this.arr[idx];
  }

  public boolean isEmpty() {
    return this.last == 0;
  }

  public T remove(int idx) {
    if (idx > this.last) {
      throw new ArrayIndexOutOfBoundsException("array index out of bounds: "+idx);
    }
    T tmp = this.arr[idx];
    for(int i = idx; i < this.last; i++) {
      this.arr[i] = this.arr[i+1];
    }
    this.last--;
    return tmp;
  }

  public int size() {
    return this.last;
  }

  private void expand() {
    this.size *= 2;
    T[] tmp = arr;
    this.arr = Arrays.copyOf(arr, this.size);
  }
}
