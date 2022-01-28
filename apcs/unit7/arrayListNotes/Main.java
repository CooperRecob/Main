package apcs.unit7.arrayListNotes;
import java.util.ArrayList;

class Main {
  public static void main(String[] args) {
    //=========================================
    // Unit 7 - ARRAYLISTS
    //=========================================
    // Learning Targets:
    //   - I can create an ArrayList
    //   - I can use ArrayList methods
    //=========================================
    // About ArrayLists 
    //  - functions like a class (constructor and methods)
    //  - starts an an empty list 
    //  - can change the size by adding and removing
    //  - has a built in printing feature
    //=========================================
    // CREATE AN ARRAYLIST
    //=========================================
    ArrayList<Integer> nums = new ArrayList<Integer>();
    //   Note: cannot make an ArrayList of ints
    //         need to use the wrapper class Integer.
    //         Same for Double and Boolean

    ArrayList<String> texts = new ArrayList<String>();

    ArrayList<Integer> nums2 = new ArrayList<Integer>(10);
    //===========================================
    // ARRAYLIST METHODS 
    //  - Note: the syntax uses an ArrayLists of objects from class E 
    //    ArrayList<E> list = new ArrayList<E>();
    //===========================================
    // 1) add method - note: is overloaded
    //  - boolean add( E element )
    //      - adds element to the end of the list
    //      - returns true 
    nums.add( 5 ); // 5 is added to the end
    nums.add( 7 ); // 7 is added to the end
    nums.add( 2 ); // 2 is added to the end
    texts.add("World");
    //  - void add( int index, E element)
    //       - adds element at index location
    //       - remaining elements in list are shifted
    nums.add( 1, 9 ); // 9 is added to index 1, then 7 and 2 are shifted
    texts.add(0,"Hello");
    //nums.add( 7, 3 ); // throws IndexOutOfBoundsException
    //===========================================
    // Let's try the built in printing feature
    System.out.println( nums );
    System.out.println( nums2 );
    System.out.println(texts);
    //===========================================
    // 2) get method
    //   - E get( int index )
    //        - returns the element at index 
    int n0 = nums.get(0);
    System.out.println( n0 );
    System.out.println( nums.get(3) );

    //int n9 = nums.get(9); Throws IndexOutOfBoundsException

    String t1 = texts.get(1);
    System.out.println( t1 );
    //==============================================
    // 3) size method
    //    - int size() 
    //       - returns the number elements in the list
    int sizeNums = nums.size();
    System.out.println( sizeNums );
    System.out.println( texts.size() );
    //===============================================
    // 4) set method
    //  - E set( int index, E element )
    //       - replaces item at index with element
    //       - returns the elements that had been replaced 

    //===============================================
    // 5) remove method
    //  - E remove( int index )
    //       - removes element at index 
    //       - elements after are shifted back
    //       - returns element that was removed


    //===============================================
  }
}