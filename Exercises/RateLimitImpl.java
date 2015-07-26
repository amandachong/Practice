public class RateLimitImpl implements RateLimit {

	int qps = 0;
	long time = -1;

	@Override
	public void setQPS(int qps) {
		if (qps < 0 || qps > 1000000) {
			throw new RuntimeException("QPS cannot be smaller than 0.");
		}
		this.qps = qps;
		this.time = System.currentTimeMillis();
	}

	@Override
	public boolean allowThisRequest() {
		if (time == -1) {
			time = System.currentTimeMillis();
			return true;
		}
		if (System.currentTimeMillis() - time < qps) {
			return false;
		} else {
			time = System.currentTimeMillis();
			return true;
		}
	}

}
