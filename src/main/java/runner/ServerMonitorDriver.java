package runner;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import factory.MonitorThreadFactory;
import monitor.MonitorSchduleTask;

public class ServerMonitorDriver
{
	private static final Logger LOGGER = LoggerFactory.getLogger(ServerMonitorDriver.class);

	public static void main(String[] args)
	{
		LOGGER.info("ServerMonitor start.");
		ScheduledExecutorService executor = Executors
		        .newSingleThreadScheduledExecutor(new MonitorThreadFactory("ServerMonitor"));
		executor.scheduleWithFixedDelay(new MonitorSchduleTask(), 0, 1, TimeUnit.SECONDS);
	}

}
