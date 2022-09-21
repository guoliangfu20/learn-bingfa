package stopThread;

/**
 * 线程中断，如sleep,wait等让线程阻塞的方法使线程休眠了，
 * 而处于休眠中的线程被中断，线程依然可以感受到中断信号，并抛出 InterruptedException的异常。
 * 同时清除中断信号，将中断标记位设置成 false
 */
public class StopDuringSleep {
	public static void main(String[] args) throws InterruptedException {

		Runnable runnable = () -> {

			int count = 0;
			try {
				while (!Thread.currentThread().isInterrupted() && count < 1000) {
					System.out.println("count = " + count);
					count++;
					Thread.sleep(1000000);
				}
			} catch (InterruptedException exception) {
				exception.printStackTrace();
			}
		};

		Thread th = new Thread(runnable);
		th.start();
		Thread.sleep(5);
		th.interrupt();
	}
}
