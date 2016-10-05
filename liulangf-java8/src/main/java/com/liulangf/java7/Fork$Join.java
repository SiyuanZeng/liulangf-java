/*************************************************************************
* Copyright (c) 2006-2011 CNPC Beijing Richfit Information Technology Co.,LTD.
* All Rights Reserved.
*
*************************************************************************/

package com.liulangf.java7;

/**
 * <<A Java Fork/Join Framework>> -Doug Lea
 * Fork/Join Framework: A style of parallel programming in which problems are solved
 * by(recursively) splitting them into subtasks that are solved in parallel, waiting
 * for them to complete, and then composing results.
 * 
 * The main implementation techniques surround efficient construction and management of 
 * tasks queues and worker threads.
 * 
 * The fork operation starts a new parallel fork/join subtask. The join operation causes the current task 
 * not to proceed until the forked subtask has completed. Fork/join algorithms, like other divide−and−conquer 
 * algorithms, are nearly always recursive, repeatedly splitting subtasks until they are small enough to solve 
 * using simple, short sequential methods.
 *
 * @author Quqing Liu
 */
public class Fork$Join {
	
	/**
	 * Fork/Join parallelism is among the simplest and most effective design techniques for obtaining good parallel performance.
	 * Fork/join algorithms are parallel versions of familiar divide−and−conquer algorithms, 
	 * taking the typical form:
	 * 
	 * @param problem
	 * @return
	 */
	Result solve(Problem problem) {
		if (problem_is_small()) {
			return directly_solve_problem();
		} else {
			return start()
			    .split_problem_into_independent_parts()
			    .fork_new_subtasks_to_solve_each_part()
			    .join_all_subtasks()
			    .compose_result_from_subresults();
		}
	}
	
	boolean problem_is_small() { return false; }
	
	Result directly_solve_problem() { return null; }
	
	BigProblem start() {
		return null;
	}

}

interface Result {}
interface Problem {}
class BigProblem {
	public BigProblem split_problem_into_independent_parts() {
		return null;
	}
	public BigProblem fork_new_subtasks_to_solve_each_part() {
		return this;
	}
	public BigProblem join_all_subtasks() {
		return this;
	}
	public Result compose_result_from_subresults() {
		return null;
	}
}
