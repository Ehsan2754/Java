package Spring2020.DSA2;

public class Stack <E>{
}
class ArrayList <E>{
  Object [] values = new Object[1];
  int size;
  public ArrayList(){ }
  void add(E value){
      if (size == values.length) {
          Object [] newArray = new Object[2*values.length];
          System.arraycopy(values,0,newArray,0,values.length);
          values = newArray;
      }
      values[size] =value;
      size++;
  }
  void remove (int index){
      if (index >= size)
          throw new IndexOutOfBoundsException();
      System.arraycopy(values, index+1, values, index, size-index-1);
      size--;

  }
  public int getSize() {
        return size;
  }
}
