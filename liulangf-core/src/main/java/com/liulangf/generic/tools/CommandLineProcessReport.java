package com.liulangf.tools;

public class CommandLineProcessReport {

	public void printProcessBar(int percent) {
		StringBuilder bar = new StringBuilder("[");
		for (int i = 0; i < 50; i++) {
			if (i < (percent / 2)) {
				bar.append("=");
			} else if (i == (percent / 2)) {
				bar.append(">");
			} else {
				bar.append(" ");
			}
		}
		bar.append("]    " + percent + "%    ");
		System.out.print("\r" + bar.toString());
	}

}
