package com.liulangf.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * source :
 * [
 *   [A, B, C],
 *   [1, 2],
 *   [a]
 * ]
 * 
 * 3 * 2 * 1 = 6;
 * 
 * target :
 * [
 *   [A, 1, a],
 *   [A, 2, a],
 *   [B, 1, a],
 *   [B, 2, a],
 *   [C, 1, a],
 *   [C, 2, a]
 * ]
 */
public class ListComprehension {
	
	
	public List<List<String>> forEach(List<List<String>> source) {
		List<List<String>> result = new ArrayList<>();
		Iterator<List<String>> it = source.iterator();
		it.forEachRemaining(e -> {
			
		});
		
		return result;
	}
	
	public List<List<String>> trans_recursive(List<List<String>> source) {
		return convert(new ArrayList<>(), source);
	}
	
	private List<List<String>> convert(List<List<String>> collector, List<List<String>> source) {
		Iterator<List<String>> it = source.iterator();
		return convert(collector, it);
	}
	
	private List<List<String>> convert(List<List<String>> collector, Iterator<List<String>> it) {
		if (!it.hasNext()) {
			return collector;
		}
		List<List<String>> newCollector;
		List<String> ls = it.next();
		if (collector.isEmpty()) {
			newCollector = ls.stream().map(Arrays::asList).collect(Collectors.toList());
		} else {
			newCollector = 
					collector.stream().flatMap((List<String> e) -> {
						return ls.stream().map((String t) -> {
							List<String> as = new ArrayList<>();
							as.addAll(e);
							as.add(t);
							return as;
						});
					}).collect(Collectors.toList());	
		}
		
		return convert(newCollector, it);
	}
	
	
	public List<List<String>> trans_no_recursive(List<List<String>> source) {
		return convert(source);
	}
	
	private List<List<String>> convert(List<List<String>> source) {
		Iterator<List<String>> it = source.iterator();
		List<List<String>> result = new ArrayList<List<String>>();
		while (it.hasNext()) {
			List<String> ls = it.next();
			result = addTo(result, ls);
		}
		
		return result;
	}
	
	private List<List<String>> addTo(List<List<String>> collector, List<String> ls) {
		if (collector.isEmpty()) {
			return ls.stream().map(e -> Arrays.asList(e)).collect(Collectors.toList());
		} else {
			List<List<String>> result = new ArrayList<>();
			collector.stream().forEach(e -> ls.stream().forEach(s -> {
				List<String> as = new ArrayList<>();
				as.addAll(e);
				as.add(s);
				result.add(as);
			}));
			return result;
		}
	}
}
