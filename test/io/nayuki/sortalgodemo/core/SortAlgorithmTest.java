/* 
 * Sorting algorithms demo (Java)
 * 
 * Copyright (c) Project Nayuki
 * https://www.nayuki.io/page/sorting-algorithms-demo-java
 * 
 * (MIT License)
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 * the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 * - The above copyright notice and this permission notice shall be included in
 *   all copies or substantial portions of the Software.
 * - The Software is provided "as is", without warranty of any kind, express or
 *   implied, including but not limited to the warranties of merchantability,
 *   fitness for a particular purpose and noninfringement. In no event shall the
 *   authors or copyright holders be liable for any claim, damages or other
 *   liability, whether in an action of contract, tort or otherwise, arising from,
 *   out of or in connection with the Software or the use or other dealings in the
 *   Software.
 */

package io.nayuki.sortalgodemo.core;

import org.junit.Before;
import org.junit.Test;


// Common superclass containing test cases appropriate for all sort algorithms.
public abstract class SortAlgorithmTest {
	
	// For subclasses to implement
	public abstract SortAlgorithm getInstance();
	
	// Actual algorithm under test
	protected SortAlgorithm algo;
	
	@Before public void setUp() {
		algo = getInstance();
	}
	
	
	/* Test cases */
	
	@Test public void testRandom10() {
		testRandom(10);
	}
	
	@Test public void testRandom30() {
		testRandom(30);
	}
	
	@Test public void testRandom100() {
		testRandom(100);
	}
	
	@Test public void testRandomSizes() {
		for (int i = 0; i < 100; i++)
			testRandom(AbstractSortArray.random.nextInt(100) + 1);
	}
	
	protected void testRandom(int size) {
		TestSortArray arr = new TestSortArray(size);
		arr.shuffle();
		algo.sort(arr);
		arr.assertSorted();
	}
	
	
	@Test public void testForward100() {
		TestSortArray arr = new TestSortArray(100);
		algo.sort(arr);
		arr.assertSorted();
	}
	
	
	@Test public void testReverse100() {
		TestSortArray arr = new TestSortArray(100);
		arr.reverse();
		algo.sort(arr);
		arr.assertSorted();
	}
	
}
