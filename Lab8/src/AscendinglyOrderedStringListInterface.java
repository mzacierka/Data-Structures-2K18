/*
 * Purpose: Data Structure and Algorithms Lab 8 Problem 3
 * Status: Complete and thoroughly tested
 * Last update: 03/28/18
 * Submitted:  03/29/18
 * Comment: test suite and sample run attached
 * @author: Michael Zacierka
 * @version: 2018.03.28
 */
public interface AscendinglyOrderedStringListInterface {
	  boolean isEmpty();
	  int size();
	  void add(String item) throws ListIndexOutOfBoundsException;
	  String get(int index) throws ListIndexOutOfBoundsException;
	  void remove(int index) throws ListIndexOutOfBoundsException;
	  int search(String item);
	  void clear();
	}
