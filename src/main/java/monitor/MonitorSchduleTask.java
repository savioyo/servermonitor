package monitor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MonitorSchduleTask implements Runnable
{

	private static final Logger LOGGER = LoggerFactory.getLogger(MonitorSchduleTask.class);

	public void run()
	{
		LOGGER.info(SigarService.getInstance().getServerInfo().get("mac"));
	}

}
