package com.liulangf.refactor;

/**
 * http://refactoring.com/
 * Refactoring is a disciplined technique for restructuring an existing body of code, altering its internal structure 
 * without changing its external behavior. Its heart is a series of small behavior preserving transformations. 
 * Each transformation (called a 'refactoring') does little, but a sequence of transformations can produce a 
 * significant restructuring. Since each refactoring is small, it's less likely to go wrong. The system is also kept 
 * fully working after each small refactoring, reducing the chances that a system can get seriously broken during the 
 * restructuring.
 * 
 * @author YuQing Liu
 *
 */
public class Refactoring {
	
	/**
	 * From <<addison.wesley.refactoring.workbook>>.
	 * 
	 * There's a basic pattern for refactoring.
	 * 
	 * While smells remain:
	 * <ul>
	 *   <li>Choose the worst smell.</li>
	 *   <li>Select a refactoring that will address the smell.</li>
	 *   <li>Apply the refactoring.</li>
	 * </ul>
	 * 
	 * We try to select refactorings that improve the code in each trip through the cycle. Because none of the steps 
	 * change the program's observable behavior, the program remains in a working state. Thus, the cycle improves code 
	 * but retains behavior. 
	 */
	void theRefactoringCycle() {
	}
	
	/**
	 * Refactoring is like crossing a stream. One way to cross a stream is to take a running leap and hope for the best. 
	 * The refactoring way is to find stepping stones and to cross the stream by stepping on one stone at a time.
	 * 
	 * When you start refactoring, it's best to start with the easy stuff (for example, breaking up large routines or 
	 * renaming things for clarity). You'll find that this lets you see and fix the remaining problems more easily.
	 */
	void practice() {
	}
	
	/**
	 * Refactoring works in tiny steps.


	 * Refactoring is a step-by-step process. The steps are smaller than people typically expect. 
	 * Most refactorings tend to take from a minute to an hour to apply
	 */
	void stepByStep() {
	}

}
