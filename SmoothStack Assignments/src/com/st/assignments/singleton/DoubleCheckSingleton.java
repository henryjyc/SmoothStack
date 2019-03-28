package com.st.assignments.singleton;

public class DoubleCheckSingleton {
	private static volatile DoubleCheckSingleton instance;
	public static DoubleCheckSingleton getInstance() {
		if(instance == null) {
			synchronized (DoubleCheckSingleton .class) {
				if(instance == null)
					instance = new DoubleCheckSingleton();
			}
		}
		return instance;
	}
}
