/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HungVu
 */
public class TaskThreadDemo {

	public static void main(String[] args) throws InterruptedException {
		PrintChar task1 = new PrintChar('a', 10);
		PrintChar task2 = new PrintChar('p', 10);
		Thread thread1 = new Thread(task1);
		Thread thread2 = new Thread(task2);
		thread1.setPriority(1);
		thread2.setPriority(10);
		thread1.start();
		thread2.start();

		System.out.println("Main thread end!!");
	}
}

class PrintChar implements Runnable {

	private char c;
	private int t;

	public PrintChar(char x, int n) {
		this.c = x;
		this.t = n;
	}

	@Override
	public void run() {
		for (int i = 0; i < this.t; i++) {
			System.out.println(this.c);
		}
		System.out.println("printed done!!!");
	}
}
