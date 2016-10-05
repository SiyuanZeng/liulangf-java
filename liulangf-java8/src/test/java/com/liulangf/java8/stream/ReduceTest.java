package com.liulangf.java8.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReduceTest {
	
	private Logger log = LoggerFactory.getLogger(getClass());

	@Test
	public void test() {
		Stream<MyStation> stream = Stream.of(
				new MyStation("A", "1", 6),
				new MyStation("B", "4", 2),
				new MyStation("A", "2", 4),
				new MyStation("A", "3", 3),
				new MyStation("F", "11", 3),
				new MyStation("E", "3", 1),
				new MyStation("A", "6", 2),
				new MyStation("B", "8", 1),
				new MyStation("A", "5", 1),
				new MyStation("H", "11", 2),
				new MyStation("F", "11", 2),
				new MyStation("G", "11", 3),
				new MyStation("F", "11", 6),
				new MyStation("G", "11", 2),
				new MyStation("E", "3", 2),
				new MyStation("B", "11", 3),
				new MyStation("F", "11", 1),
				new MyStation("H", "11", 3),
				new MyStation("G", "11", 1),
				new MyStation("E", "3", 3),
				new MyStation("C", "7", 2),
				new MyStation("H", "11", 1),
				new MyStation("F", "11", 5),
				new MyStation("F", "11", 4),
				new MyStation("D", "12", 1),
				new MyStation("C", "9", 1),
				new MyStation("C", "10", 3),
				new MyStation("A", "13", 5));
		
		Comparator<MyStation> mc = Comparator.comparing((MyStation e) -> e.getStationId())
				.thenComparing(s -> s.getInstant());
		List<MyStation> list = stream.sorted(mc)
				.collect((Supplier<List<MyStation>>) ArrayList::new, 
				(co, e) -> {
					if (co.stream().anyMatch(st -> st.getStationId().equals(e.getStationId()))) {
						return;
					}
					co.add(e);
					log.info("{}", co.hashCode());
				},
				(left, right) -> {});
		
		list.stream().forEach(e -> {
			log.info("[{} - {} - {}]", e.getStationId(), e.getInterviewId(), e.getInstant());
		});
		
	}
	
	static class MyStation {
		private String stationId;
		private String interviewId;
		private int instant;
		
		public MyStation() {
		}
		public MyStation(String stationId, String interviewId, int instant) {
			this.stationId = stationId;
			this.interviewId = interviewId;
			this.instant = instant;
		}
		
		public String getStationId() {
			return stationId;
		}
		public void setStationId(String stationId) {
			this.stationId = stationId;
		}
		public String getInterviewId() {
			return interviewId;
		}
		public void setInterviewId(String interviewId) {
			this.interviewId = interviewId;
		}
		public int getInstant() {
			return instant;
		}
		public void setInstant(int instant) {
			this.instant = instant;
		}
	}

}
