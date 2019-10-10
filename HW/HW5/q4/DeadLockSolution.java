package com.java.HW3.q4;

public class DeadLockSolution {
	public static void main(String[] ars) {
		Job2 j1 = new Job2();
		Job2 j2 = new Job2();
		Printer2 p1=new Printer2(j1, j2);
		p1.start();
		Printer2 p2=new Printer2(j2, j1);
		p2.start();
	}
}

class Printer2 extends Thread {
	private Job2 j1;
	private Job2 j2;

	public Printer2(Job2 class1, Job2 class2) {
		this.j1 = class1;
		this.j2 = class2;
	}

	@Override
	public void run() {
		j1.method(j2);
	}
}
class Job2 {

    public void method(Job2 clazz) {
        System.out.println("Printer method in");
        synchronized(this){
        }
        clazz.method2();
        System.out.println("Printer method out");
    }

    public synchronized void method2() {
        System.out.println("Printer method2");
    }
}
