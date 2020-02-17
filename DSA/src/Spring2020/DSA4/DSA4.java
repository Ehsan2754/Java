package Spring2020.DSA4;

import javax.sound.sampled.Line;
import java.util.LinkedList;
import java.util.Scanner;

public class DSA4 {
    public static void main(String[] arg) throws Throwable {
        Scanner user = new Scanner(System.in);
        Stack<Character>
                opening = new Stack<>();

        Stack<Integer>
                openingLine = new Stack<>(),
                openingColumn = new Stack<>();
        int line, column;
        int MAX_LINE = user.nextInt();
        user.nextLine();
        for (line = 0; line < MAX_LINE; line++) {
            String thisLine = user.nextLine();
            for (column = 0; column < thisLine.length(); column++) {
                switch (thisLine.charAt(column)) {
                    case '{':
//                        if ((!closing.isEmpty()) &&
//                                (closing.peek() == '}')) {
//                            closing.pop();
//                            closingLine.pop();
//                            closingColumn.pop();
//                        } else {
//                            opening.push(thisLine.charAt(column));
//                            openingLine.push(line+1);
//                            openingColumn.push(column+1);
//                        }
//
//                        break;
                    case '[':
//                        if ((!closing.isEmpty()) &&
//                                (closing.peek() == ']')) {
//                            closing.pop();
//                            closingLine.pop();
//                            closingColumn.pop();
//                        } else {
//                            opening.push(thisLine.charAt(column));
//                            openingLine.push(line+1);
//                            openingColumn.push(column+1);
//                        }
//
//                        break;
                    case '(':
//                        if ((!closing.isEmpty()) &&
//                                (closing.peek() == ')')) {
//                            closing.pop();
//                            closingLine.pop();
//                            closingColumn.pop();
//                        } else {
                        opening.push(thisLine.charAt(column));
                        openingLine.push(line + 1);
                        openingColumn.push(thisLine.length());
//                        }
                        break;

                    case '}':
                        if (opening.isEmpty()) {
                            System.out.println("Error in line " + (line + 1)
                                    + ", column " + (column + 1)
                                    + ": unexpected closing '}'.");
                        } else if (!opening.isEmpty()) {
                            if (opening.peek() == '{') {
                                opening.pop();
                                openingLine.pop();
                                openingColumn.pop();
                            } else {
                                System.out.println("Error in line " + (line + 1) +
                                        ", column " + (column + 1)
                                        + ": expected '" + opening.peek()
                                        + "', but got '}'.");
                            }

                        }
//                        if ((!opening.isEmpty()) &&
//                                (opening.peek() == '{')) {
//                            opening.pop();
//                            openingLine.pop();
//                            openingColumn.pop();
//                        } else {
//                            closing.push(thisLine.charAt(column));
//                            closingLine.push(line+1);
//                            closingColumn.push(column+1);
//                        }
                        break;
                    case ']':
                        if (opening.isEmpty()) {
                            System.out.println("Error in line " + (line + 1)
                                    + ", column " + (column + 1)
                                    + ": unexpected closing ']'.");
                        } else if (!opening.isEmpty()) {
                            if (opening.peek() == '[') {
                                opening.pop();
                                openingLine.pop();
                                openingColumn.pop();
                            } else {
                                System.out.println("Error in line " + (line + 1) +
                                        ", column " + (column + 1)
                                        + ": expected '" + opening.peek()
                                        + "', but got ']'.");
                            }

                        }
                        break;
                    case ')':
                        if (opening.isEmpty()) {
                            System.out.println("Error in line " + (line + 1)
                                    + ", column " + (column + 1)
                                    + ": unexpected closing ')'.");
                        } else if (!opening.isEmpty()) {
                            if (opening.peek() == '(') {
                                opening.pop();
                                openingLine.pop();
                                openingColumn.pop();
                            } else {
                                System.out.println("Error in line " + (line + 1) +
                                        ", column " + (column + 1)
                                        + ": expected '" + opening.peek()
                                        + "', but got ')'.");
                            }

                        }
//                        if ((!opening.isEmpty()) &&
//                                (opening.peek() == '(')) {
//                            opening.pop();
//                            openingLine.pop();
//                            openingColumn.pop();
//                        } else {
//                            closing.push(thisLine.charAt(column));
//                            closingLine.push(line+1);
//                            closingColumn.push(column+1);
//                        }
                        break;
                }
            }
        }
        while (!opening.isEmpty())
            System.out.println("Error in line " + openingLine.pop()
                    + ", column " + openingColumn.pop()
                    + ": expected '" + mirrorIt(opening.pop())
                    + "', but got end of input.");

//        while (
//                (! (opening.isEmpty()||closing.isEmpty() )) &&
//                (
//                        (opening.peek() == '(' && closing.peek() == ')') ||
//                        (opening.peek() == '{' && closing.peek() == '}') ||
//                        (opening.peek() == '[' && closing.peek() == ']'
//                        )
//                )
//        ) {
//			opening.pop();
//			openingLine.pop();
//			openingColumn.pop();
//			closing.pop();
//			closingLine.pop();
//			closingColumn.pop();
//        }


    }

    private static Character mirrorIt(Character c) {
        switch (c) {
            case '(':
                return ')';
            case ')':
                return '(';
            case '[':
                return ']';
            case ']':
                return '[';
            case '{':
                return '}';
            case '}':
                return '{';
            default:
                return null;

        }
    }

}

/**************
 * Abstract Data Type (ADT)
 * "List" of type @param <E>
 * @param <E>
 */
abstract class List<E> {
    /**********************
     * @return a boolean is the list is empty or not!
     */
    abstract boolean isEmpty();

    /**********************
     * Adds element of type <E> e in index i of the list
     * and also throws the OutOfMemoryError in case of Error or IndexOutOfBound Exception
     * @param i -> Index
     * @param e -> Element
     * @throws OutOfMemoryError,IndexOutOfBoundsException
     */
    abstract void add(final int i, final E e) throws Throwable;

    /**********************
     * Adds element of type<E> e to the first of the list
     * and also throws the OutOfMemoryError in case of Error
     * @param e
     * @throws OutOfMemoryError
     */
    abstract void addFirst(final E e) throws Throwable;

    /**********************
     * Adds element of type<E> e to the end of the list
     * and also throws the OutOfMemoryError in case of Error
     * @param e
     * @throws OutOfMemoryError
     */
    abstract void addLast(final E e) throws Throwable;

    /**********************
     * Deletes element of type <E> with value e in the List
     * @param e
     * @return true if item existed in list otherwise will return false
     */
    abstract boolean delete(final E e) throws Throwable;

    /**********************
     * Deletes element of index i from the list and throws IndexOutOfBound in case of Exception
     * @param i
     * @throws IndexOutOfBoundsException
     */
    abstract void delete(final int i) throws IndexOutOfBoundsException;

    /**********************
     * Deletes first element of the List<E> and returns true if list in not empty;
     * if List<E> is empty it returns false
     * @return
     */
    abstract boolean deleteFirst();

    /**********************
     * Deletes first element of the List<E> and returns true if list in not empty;
     * if List<E> is empty it returns false
     * @return
     */
    abstract boolean deleteLast();

    /**********************
     * replaces element at index i with new element e;
     * throws IndexOutOfBound in case of Exception
     * @param i
     * @param e
     * @throws IndexOutOfBoundsException
     */
    abstract void set(final int i, final E e) throws IndexOutOfBoundsException;

    /***********************
     * returns element of <E> type at index i and
     * throws IndexOutOfBound in case of Exception
     * @param i
     * @throws IndexOutOfBoundsException
     */
    abstract E get(final int i) throws IndexOutOfBoundsException;

}

class Stack<E> extends DynamicArray<E> {

    /***************
     * All complexities are due to my DynamicArray Implemention
     **/
    public int getSize() {
        return super.getSize();
    }

    public boolean isEmpty() {
        return super.isEmpty();
    }

    public void push(E e) throws Throwable {
        super.addFirst(e);
    }

    public E pop() {
        E out = super.get(0);
        super.deleteFirst();
        return out;
    }

    public E peek() {
        return super.get(0);
    }

    public List<Integer> search(E e) throws Throwable {
        return super.getIndexsByValue(e);
    }

}

class DynamicArray<E> extends List<E> {
    private final int initialCapacity = 1;
    /***********
     * --size field holds the Dynamic Array List Size.
     * Capacity holds number of elements array
     * --capacity holds the capacity of DynamicArray
     * --initial Capacity is starting size of the array
     * --elements is the array to save elements
     */
    private int size = 0;
    private int capacity = 1;
    private Object[] elements;


    /**********
     * constructor
     * default
     * the complexity to create n variables (initial capacity = n)
     * is linear -> O(n)
     */
    DynamicArray() {
        this.elements = new Object[this.initialCapacity];
    }

    DynamicArray(int capacity) {
        if (capacity > 0) {
            this.elements = new Object[capacity];
        } else {
            if (capacity != 0) {
                throw new IllegalArgumentException("Invalid argument : Capacity " + capacity);
            }

            this.elements = new Object[initialCapacity];
        }
    }

    /***********
     * Private method that checks if index is in range of out array range
     * @param index
     * @throws IndexOutOfBoundsException
     */
    private void checkOutOfBoundERR(int index) throws IndexOutOfBoundsException {
        /************
         * Simple Condition checking a variable's value
         * Complexity is constant O(1)
         */

        if (index > this.size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + this.size);
        }
    }

    public int getSize() {
        /***************
         * returns List size ; Complexity -> O(1)
         */
        return this.size;
    }

    /***********
     * checks if the elements size is equal to capacity;
     * doubles the array capacity
     * due to explaination overall complexity of this method is sum of several linear procedure; Hence it is Linear -> O(n)
     * @throws Throwable
     */
    private void ensureCapacity() throws Throwable {
        if (size == capacity) { // Condition checking complexity is constant
            try {
                Object[] temp = this.elements; // allocation takes linear time O(n)since we allocate and initialize memory cells with null or respective values;
                this.capacity *= 2; // Complexity -> O(1);
                elements = new Object[this.capacity];// allocation takes linear time O(n)since we allocate and initialize memory cells with null or respective values;
                System.arraycopy(temp, 0, this.elements, 0, size);// copying takes linear time O(n) since we assign every corresponding element of destination
                // with the source desirable elments;
            } catch (Throwable x) {
                throw x;
            }
        }
    }

    /***********************
     * returns an List<Integer> of Indexes which hold the value e of type <E> and if it does not hold that value,it returns null
     * @param e
     * @return List<Integer> of Indexes which value is equal to object E
     * overall complexity -> O(n^2)
     */
    public List<Integer> getIndexsByValue(final E e) throws Throwable {
        List<Integer> indexes = new DynamicArray<>();//initial size is zero so constant complexity -> O(1);
        for (int i = 0; i < size; i++) {//n iteration loop
            if (this.elements[i].equals(e)) indexes.addLast(i);// O(n) complexity
        }
        if (indexes.isEmpty()) return null;
        else return indexes;
    }

    @Override
    public boolean isEmpty() {
        /************
         * Simple Condition checking a variable's value
         * Complexity is constant O(1)
         */
        return size == 0;

    }


    @Override
    public void add(int i, E e) throws Throwable {
        /***************
         * Complexity -> O(n) since its sum of linear and constant complex procedures
         * @param i -> Index
         * @param e -> Element
         * @throws Throwable
         */
        checkOutOfBoundERR(i);  //check if index is in range of array indexes or its equal to the size and throws Index out of bound; Complexity -> O(1);
        ensureCapacity();       //ensures if array is full it will double the array capacity; Complexity -> O(n) as mentioned in method comments;
        System.arraycopy(this.elements, i, this.elements, i + 1, this.size++ - i);//Shifts elements from index i one cell to right and increases the size by one;
        // as mentioned before complexity is O(n);
        this.elements[i] = e; //assigning element to the desired index of list; Complexity -> O(1)
    }

    @Override
    public void addFirst(E e) throws Throwable {

        add(0, e); //same method for public void add(int i, E e) just a constant index of 0;Complexity -> O(n);
    }

    @Override
    public void addLast(E e) throws Throwable {
        /*************
         * Complexity -> O(n) since its sum of linear and constant complex procedures
         * @param e
         * @throws Throwable
         */
        ensureCapacity();//ensures if array is full it will double the array capacity; Complexity -> O(n) as mentioned in method comments;
        this.elements[size++] = e; //assigning the element after the last element in elements to desired value e and increases the size by 1; Complexity -> O(1)
    }

    @Override
    public boolean delete(E e) throws Throwable {
        /************
         *Complexity -> O(n^2) since its sum of square and constant complex procedures
         * @param e
         * @return
         * @throws Throwable
         */
        DynamicArray<Integer> indexes = (DynamicArray<Integer>) getIndexsByValue(e);//Complexity -> O(n^2) ref: comments on getIndexesByValue
        if (indexes == null) return false;//constant complexity
        else {
            for (int i = 0; i < indexes.getSize(); i++) {//n iteration loop
                this.delete(indexes.get(i));// complexity -> O(n) mentioned below
            }
            return true;
        }
    }

    @Override
    public void delete(int i) throws IndexOutOfBoundsException {
        /***************
         * Complexity -> O(n) since its sum of linear and constant complex procedures
         * @param i -> Index
         * @throws Throwable
         */
        checkOutOfBoundERR(i);//check if index is in range of array indexes or its equal to the size and throws Index out of bound; Complexity -> O(1);
        if (i == size - 1)
            this.elements[--size] = null;//avoids out of bound for deleting last element; Complexity -> O(1)
        else {
            System.arraycopy(this.elements, i + 1, this.elements, i, size - i - 1);//Shifts elements from index i+1 one to the left cell ;
            // as mentioned before complexity is O(n);
            this.elements[--size] = null;//deletes the last element in array and decreases the size by 1; Complexity -> O(1)
        }
    }

    @Override
    public boolean deleteFirst() {
        /***************
         * Complexity -> O(n) since its sum of linear and constant complex procedures
         * @return boolean which indicates if array is empty
         */
        if (size == 0) return false;
        else {
            delete(0);
            return true;
        }
    }

    @Override
    public boolean deleteLast() {
        /***************
         * Complexity -> O(n) since its sum of linear and constant complex procedures
         * @return boolean which indicates if array is empty
         */
        if (size == 0) return false;
        else {
            delete(size - 1);
            return true;
        }
    }

    @Override
    public void set(int i, E e) throws IndexOutOfBoundsException {
        /*************
         * Time complexity is constant -> O(1)
         * @param i
         * @param e
         * @throws IndexOutOfBoundsException
         */
        if (i == size) throw new IndexOutOfBoundsException("Out of bound Index");//O(1)
        checkOutOfBoundERR(i);//check if index is in range of array indexes or its equal to the size and throws Index out of bound; Complexity -> O(1);
        elements[i] = e;//assigning element to the desired index of list; Complexity -> O(1)
    }

    @Override
    public E get(int i) throws IndexOutOfBoundsException {
        /*************
         * Time complexity is constant -> O(1)
         * @param i
         * @throws IndexOutOfBoundsException
         */
        if (i == size) throw new IndexOutOfBoundsException("Out of bound Index");//O(1)
        checkOutOfBoundERR(i);//check if index is in range of array indexes or its equal to the size and throws Index out of bound; Complexity -> O(1);
        return (E) elements[i];
    }
}

class DoubleLinkedList<E> extends List<E> {
    private Node head, tail;
    private int size = 0;

    public DoubleLinkedList() {
        /***************
         * simple initialization costing constant time -> O(1)
         */
        this.head = new Node();
        this.tail = new Node();
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    /***********
     * Private method that checks if index is in range of out array range
     * @param index
     * @throws IndexOutOfBoundsException
     */
    private void checkOutOfBoundERR(int index) throws IndexOutOfBoundsException {
        /************
         * Simple Condition checking a variable's value
         * Complexity is constant O(1)
         */
        if (index > this.size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + this.size);
        }
    }

    public int getSize() {
        /***************
         * returns List size ; Complexity -> O(1)
         */
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        /**************
         * Complexity -> O(1)
         */
        return size == 0;
    }

    @Override
    public void add(int i, E e) throws Throwable {
        /******************
         * linear complexity -> O(n)
         */
        checkOutOfBoundERR(i);//O(1)
        Node current = this.head;//O(1)
        for (int j = 0; j <= i; j++) {//n-iteration loop
            current = current.next;//O(1)
        }
        Node n = new Node(e, current.next, current);//O(1)
        current.next.prev = n;//O(1)
        current.next = n;//O(1)
        size++;//O(1)
    }

    @Override
    public void addFirst(E e) throws Throwable {
        /**************
         * constant complexity -> O(1)
         */
        Node current = new Node(e, this.head.next, this.head);//O(1)
        this.head.next.prev = current;//O(1)
        this.head.next = current;//O(1)
        size++;//O(1)
    }

    @Override
    public void addLast(E e) throws Throwable {
        /***********
         * Complexity -> O(1)
         */
        Node current = new Node(e, tail, this.tail.prev);//O(1)
        this.tail.prev.next = current;//O(1)
        this.tail.prev = current;//O(1)
        size++;//O(1)
    }

    @Override
    public boolean delete(E e) throws Throwable {
        /***************
         * Overall complexity is linear -> O(n)
         */
        Node current = this.head;//O(1)
        int tempSize = this.size;//O(1)
        for (int i = 0; i <= size; i++) {//n-Iteration loop
            if (current.value == e) {//O(1)
                current.prev.next = current.next;//O(1)
                current.next.prev = current.prev;//O(1)
                this.size--;//O(1)
                i--;//O(1)
            } else {//O(1)
                current = current.next;//O(1)
            }
        }
        return !(tempSize == this.size);//O(1)
    }

    @Override
    public void delete(int i) throws IndexOutOfBoundsException {
        /***************
         * Overall complexity is linear -> O(n)
         */
        checkOutOfBoundERR(i);//O(1)
        Node current = this.head;//O(1)
        for (int j = 0; j <= i; j++) {//n-Iteration loop
            current = current.next;//O(1)
        }
        size--;//O(1)
    }

    @Override
    public boolean deleteFirst() {
        /******************
         * the complexity is constant -> O(1)
         */
        if (this.isEmpty()) return false;//O(1)
        else {
            this.head.next.next.prev = this.head;//O(1)
            this.head.next = this.head.next.next;//O(1)
            size--;//O(1)
            return true;//O(1)
        }
    }

    @Override
    public boolean deleteLast() {
        /******************
         * the complexity is constant -> O(1)
         */
        if (this.isEmpty()) return false;//O(1)
        else {
            this.tail.prev.prev.next = this.tail;//O(1)
            this.tail.prev = this.tail.prev.prev;//O(1)
            size--;//O(1)
            return true;//O(1)
        }
    }

    @Override
    public void set(int i, E e) throws IndexOutOfBoundsException {
        /******************
         * the complexity is Linear -> O(n)
         */
        if (i == size) throw new IndexOutOfBoundsException("Out of bound Index");//O(1)
        checkOutOfBoundERR(i);//O(1)
        Node current = this.head;//O(1)
        for (int j = 0; j <= i; j++) {//n-Iteration loop
            current = current.next;//O(1)
        }
        current.value = e;//O(1)
    }

    @Override
    public E get(int i) throws IndexOutOfBoundsException {
        /******************
         * the complexity is Linear -> O(n)
         */
        if (i == size) throw new IndexOutOfBoundsException("Out of bound Index");//O(1)
        checkOutOfBoundERR(i);//O(1)
        Node current = this.head;//O(1)
        for (int j = 0; j <= i; j++) {//n-Iteration loop
            current = current.next;//O(1)
        }
        return (E) current.value;//O(1)
    }

    /*******************
     * Nested Class node to produce elements which can link to other objects
     * @param <E>
     */
    private class Node<E> {
        E value;
        Node<E> prev, next;

        public Node() {
            /*****
             * o(1) for calling method
             */
        }


        public Node(E element, Node next, Node prev) {
            /**************
             * simple initialization costing constant time -> O(1)
             * @param element
             * @param next
             * @param prev
             */
            this.value = element;
            this.next = next;
            this.prev = prev;
        }
    }
}

