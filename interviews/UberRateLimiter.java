import java.util.LinkedList;

class UberRateLimiterSolution {
	public static void main(String[] args) {

		RateLimiter rateLimiter = new RateLimiter(20, 500);

		for (int i = 0; i < 21; i++) {
			System.out.println(rateLimiter.doWork());
		}
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {

		}
		for (int i = 0; i < 21; i++) {
			System.out.println(rateLimiter.doWork());
		}
	}
}

class RateLimiter {

	int work;
	long time;
	LinkedList<Long> queue;

	public RateLimiter(int work, long time) {
		this.work = work;
		this.time = time;
		this.queue = new LinkedList<Long>();
	}

	// Return false if work was not able to be done, true if work was done.
	public boolean doWork() {
		long currentTime = System.currentTimeMillis();
		long lastAcceptableTime = currentTime - time;
		while (queue.size() > 0 && queue.peek() <= lastAcceptableTime) {
			queue.remove();
		}
		if (queue.size() + 1 <= work) {
			queue.add(System.currentTimeMillis());
			return true;
		} else {
			return false;
		}
	}
}