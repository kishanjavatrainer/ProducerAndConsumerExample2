package org.infotech.com;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

	private BlockingQueue<Integer> sharedQueue;
	
	public Producer(BlockingQueue<Integer> sharedQueue) {
		super();
		this.sharedQueue = sharedQueue;
	}

	@Override
	public void run() {
		
		while (true) {
			Random random = new Random();
			int data = random.nextInt(10);
			try {
				sharedQueue.put(data);
				System.out.println("Produced::"+data);
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}
