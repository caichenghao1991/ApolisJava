package com.java.HW3.q3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducersCustomers {
	public static void main(String[] args) throws InterruptedException {
		Inventory inventory = new Inventory();		
		Thread[] producers=new Thread[5];
		for(int i=0;i<producers.length;i++) {
			producers[i]=new Thread(new Runnable() {
				@Override
				public void run() {
					for (int i = 0; i < 100; i++) {
						inventory.add();
					}
				}
			});
		}
		Thread[] consumers=new Thread[5];
		for(int i=0;i<consumers.length;i++) {
			consumers[i]=new Thread(new Runnable() {
				@Override
				public void run() {
					for (int i = 0; i < 100; i++) {
						inventory.remove();
					}
				}
			});
		}
		for(int i=0;i<producers.length;i++) {
			producers[i].start();
		}
		for(int i=0;i<consumers.length;i++) {
			consumers[i].start();
		}
		
		for(int i=0;i<producers.length;i++) {
			producers[i].join();
		}
		for(int i=0;i<consumers.length;i++) {
			consumers[i].join();
		}
		System.out.println(inventory.list.size());// 0
	}
}

class Inventory {
	List<Integer> list = new ArrayList<>();
	Lock lock = new ReentrantLock();
	Condition add = lock.newCondition();
	Condition remove= lock.newCondition();
	public void add() {
		while (true) {
			try {				
				if (lock.tryLock(1, TimeUnit.SECONDS)) {// lock was acquired on obj
					if (list.size() < 10) { 
						list.add((int) (Math.random() * 1000));
						remove.signalAll();
						lock.unlock();
						break;
					}else {
						add.await();
						lock.unlock();
					}			
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}		
	}

	public void remove() {
		while (true) {
			try {
				if (lock.tryLock(1, TimeUnit.SECONDS)) {
					if (list.size() > 0) {
						list.remove(0);
						add.signalAll();
						lock.unlock();
						break;
					} else {
						remove.await();
						lock.unlock();
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}