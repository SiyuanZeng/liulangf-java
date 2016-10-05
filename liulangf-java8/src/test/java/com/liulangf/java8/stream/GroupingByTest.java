package com.liulangf.java8.stream;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GroupingByTest {

	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Test
	public void downStreamTest() {
		Collector<Input, ?, Counter> collector = Collector.of(
				Counter::new, 
				(c, i) -> {
					c.date = i.date;
					if (i.forenoon) {
						c.fcount ++;
					} else {
						c.acount ++;
					}
				}, 
				
				(a, b) -> {
					return new Counter();
				});
		
		
		Map<String, Counter> cm = 
		inputs().stream().collect(Collectors.groupingBy(
				i -> i.date, 
				collector));
		
		log.info("{}", cm);
	}
	
	@Test
	public void test() {
		Map<String, Counter> cm = new HashMap<>();
		
		inputs().stream()
		    .reduce(null, (l, r) -> {
		    	String date = r.date;
		    	boolean forenoon = r.forenoon;
		    	Counter c = cm.get(date);
		    	if (c == null) {
		    		c = new Counter();
		    		c.date = date;
		    		cm.put(date, c);
		    	}
		    	
		    	if (forenoon) {
	    			c.fcount ++;
	    		} else {
	    			c.acount ++;
	    		}
		    	return null;
		    });
		
		log.info("{}", cm);
		
		
//		Map<String, Counter> result = inputs().stream()
//				.collect(Collectors.groupingBy(
//						(Input i) -> (String)i.date, 
//						Collectors.reducing(
//								new Counter(), 
//								(Input a) -> a.forenoon, 
//								(m, n) -> {
//									return new Counter();
//								})));
		
//		log.info("{}", result);
	}
	
	
	
	
//    public static <T>
//    Collector<T, ?, DoubleSummaryStatistics> summarizingDouble(ToDoubleFunction<? super T> mapper) {
//        return new CollectorImpl<T, DoubleSummaryStatistics, DoubleSummaryStatistics>(
//                DoubleSummaryStatistics::new,
//                (r, t) -> r.accept(mapper.applyAsDouble(t)),
//                (l, r) -> { l.combine(r); return l; }, CH_ID);
//    }
	
	private List<Input> inputs() {
		Input a1 = new Input("2015-02-01", true);
		Input a2 = new Input("2015-02-01", false);
		Input a3 = new Input("2015-02-01", true);
		
		Input b1 = new Input("2015-02-02", true);
		Input b2 = new Input("2015-02-02", false);
		Input b3 = new Input("2015-02-02", false);
		
		Input c1 = new Input("2015-02-03", true);
		Input c2 = new Input("2015-02-03", false);
		Input c3 = new Input("2015-02-03", true);
		Input c4 = new Input("2015-02-03", false);
		Input c5 = new Input("2015-02-03", false);

		Input d1 = new Input("2015-02-04", true);
		Input d2 = new Input("2015-02-04", false);
		Input d3 = new Input("2015-02-04", false);
		Input d4 = new Input("2015-02-04", false);
		Input d5 = new Input("2015-02-04", false);
		
		return Arrays.asList(a1, a2, a3, b1, b2, b3, c1, c2, c3, c4, c5, d1, d2, d3, d4, d5);
	}
	
	
	static class Input {
		public String date;
		public boolean forenoon;
		
		public Input(String date, boolean forenoon) {
			this.date = date;
			this.forenoon = forenoon;
		}
	}

	static class Counter {
		public String date;
		public int fcount;
		public int acount;
		@Override
		public String toString() {
			return "Counter [date=" + date + ", fcount=" + fcount + ", acount=" + acount + "]";
		}
	}
}
