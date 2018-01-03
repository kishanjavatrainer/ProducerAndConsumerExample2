package org.infotech.com;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

	private BlockingQueue<Integer> sharedQueue;
	
	public Consumer(BlockingQueue<Integer> sharedQueue) {
		super();
		this.sharedQueue = sharedQueue;
	}

	@Override
	public void run() {
		
		while (true) {
			try {
				Integer data = sharedQueue.take();
				System.out.println("Consumed::"+data);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}
