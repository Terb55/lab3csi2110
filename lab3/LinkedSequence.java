

//import net.datastructures.*; //copied LinkedPositionalList from net.datastructures.*

/**
 * 
 * An implementation of Sequence based on LinkedPositionalList
 * Only List methods and bridge methods in Sequence interface need to be provided
 * 
 * Created for csi2110 Lab3, Fall 2021
 * 
 * @author Lucia Moura
 *
 */

public class LinkedSequence<E> extends LinkedPositionalList<E> implements Sequence<E> {
		
	/**
	 * returns position corresponding to index
	 * since need to traverse this LinkedPositionalList to get to index i time is O(n)
	 * @param i the index or rank of the element in the list (first has index 0, second has index 1,etc
	 * @return position of the element or null if index does not exist
	 * @throws IndexOutOfBoundsException if the index is negative or greater than size()-1
	 */
         public Position<E> positionAtIndex(int i) throws IndexOutOfBoundsException { 
                 checkIndex(i,size()); // checks whether the given index is in the range [0, size()-1].

                 /******* add your code here **********/
				 Position<E> current = first();
				 for(int k = 0; k <= i; k++){
					if(k == i){
						return current;
					}else{
						current = after(current);
					}
				 }

                 return null; 
          } 
	
      /**
        * returns index corresponding to position
        * since need to hop through elements of this LinkedPositionalList to get to position pos time is O(n)
        * @param pos - the position or cell you must located in this LinkedPositionalList
        * @return index (also called rank) in the list or -1 if position not found
        * 
        */
	public int indexAtPosition(Position<E> pos) {
		
        /******* add your code here **********/
		Position<E> current = first();
		int index = 0;
		for(int k = 0; k < size(); k++){
		   if(current == pos){
			   index = k;
		   }else{
			   current = after(current);
		   }
		}

		return index; 
	} 

       /**
	 * Returns (but does not remove) the element at index i.
	 * @param  i   the index of the element to return
	 * @return the element at the specified index
         * @throws IndexOutOfBoundsException if the index is negative or greater than size()-1
	 */
	public E get(int i) throws IndexOutOfBoundsException { // gets element at index i
		
        /******* add your code here **********/
		 Position<E> current = first();
		 for(int k = 0; k <= i; k++){
			if(k == i){
				return current.getElement();
			}else{
				current = after(current);
			}
		 }

		 return null;
	}
	
	/**
	  * Replaces the element at the specified index, and returns the element previously stored.
	  * @param  i   the index of the element to replace
	  * @param  e   the new element to be stored
	  * @return the previously stored element
	  * @throws IndexOutOfBoundsException if the index is negative or greater than size()-1
	  */
	public E set(int i, E e) throws IndexOutOfBoundsException { // replaces the element at index i with e

               /******* add your code here **********/
			   Position<E> current = first();
			   for(int k = 0; k <= i; k++){
				  if(k == i){
					  set(positionAtIndex(i), e);
				  }else{
					  current = after(current);

				  }
			   }

               return null;
	}
	
	/**
	  * Inserts the given element at the specified index of the list, shifting all
	  * subsequent elements in the list one position further to make room
	  * Note: when i=size() it correspond to an addLast when i<size it correspond to addBefore the i-th position
	  * @param  i   the index at which the new element should be stored
	  * @param  e   the new element to be stored
	  * @throws IndexOutOfBoundsException if the index is negative or greater than size()
	  */
	public void add(int i, E e){ // insert a new element which will have index i 
		 /******* add your code here **********/
		 Position<E> current = first();
		 if(i == size()){
			addLast(e);
		 }else if(i == 0){
			addFirst(e);
		 }else{
			for(int k = 0; k <= i; k++){
				if(k == i){
					addBefore(current, e);
				}else{
					current = after(current);
	
				}
			 }
		 }

	}
	
	/**
	  * Removes and returns the element at the given index, shifting all subsequent
	  * elements in the list one position closer to the front.
	  * @param  i   the index of the element to be removed
	  * @return the element that had be stored at the given index
	  * @throws IndexOutOfBoundsException if the index is negative or greater than size()
	  */
	public E remove(int i) throws IndexOutOfBoundsException { // remove element with index i

		/******* add your code here **********/
		Position<E> current = first();
		for(int k = 0; k <= i; k++){
		   if(k == i){
			   remove(positionAtIndex(i));
		   }else{
			   current = after(current);

		   }
		}

		return null;
	}
	
	  // utility methods
	  /** Checks whether the given index is in the range [0, n-1]. */
	  protected void checkIndex(int i, int n) throws IndexOutOfBoundsException {
	    if (i < 0 || i >= n)
	      throw new IndexOutOfBoundsException("Illegal index: " + i);
	  }
}
