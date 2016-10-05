package com.liulangf.io;

import java.io.Console;

public class ConsoleIsAvailable {
	
	public static void main(String... args) {
		Console console = System.console();
		String a = console.readLine();
	}

}
