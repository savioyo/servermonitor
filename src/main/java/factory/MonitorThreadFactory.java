package factory;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class MonitorThreadFactory implements ThreadFactory
{

	private String threadName;
	private AtomicInteger count = new AtomicInteger(0);

	public MonitorThreadFactory(String name)
	{
		this.threadName = name;
	}

	public Thread newThread(Runnable r)
	{
		Thread thread = new Thread(r, threadName + "_Thread_" + count.getAndIncrement());
		return thread;
	}

}
