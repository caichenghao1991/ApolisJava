package com.java.HW3.q4;

public class DeadLock {
	public static void main(String[] ars) {
		Job j1 = new Job();
		Job j2 = new Job();
		Printer p1=new Printer(j1, j2);
		p1.start();
		Printer p2=new Printer(j2, j1);
		p2.start();
	}
}

class Printer extends Thread {
	private Job j1;
	private Job j2;

	public Printer(Job class1, Job class2) {
		this.j1 = class1;
		this.j2 = class2;
	}

	@Override
	public void run() {
		j1.method(j2);
	}
}
class Job {

    public synchronized void method(Job clazz) {
        System.out.println("Printer method in");
        clazz.method2();
        System.out.println("Printer method out");
    }
    public synchronized void method2() {
        System.out.println("Printer method2");
    }
}
