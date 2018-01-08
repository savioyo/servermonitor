package monitor;

import java.util.HashMap;
import java.util.Map;

import org.hyperic.sigar.NetInterfaceConfig;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;

import util.Constants;

public class SigarService
{
	private final static SigarService INSTANCE = new SigarService();

	private static Sigar sigar;

	private SigarService()
	{
		sigar = initSigar();
	}

	public static SigarService getInstance()
	{
		return INSTANCE;
	}

	private Sigar initSigar()
	{
		String libPath = System.getProperty(Constants.Processor.LIB_PATH);
		ClassLoader cl = SigarService.class.getClassLoader();
		String filePath = cl.getResource("sigar").getPath();
		libPath += ":" + filePath;
		System.setProperty(Constants.Processor.LIB_PATH, libPath);

		return new Sigar();
	}

	public Map<String, String> getServerInfo()
	{
		Map<String, String> result = new HashMap<String, String>();
		try
		{
			NetInterfaceConfig nc = sigar.getNetInterfaceConfig();
			result.put("mac", nc.getHwaddr());
		}
		catch (SigarException e)
		{
			e.printStackTrace();
		}
		return result;
	}

}
