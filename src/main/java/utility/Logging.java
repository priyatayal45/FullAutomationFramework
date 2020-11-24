package utility;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Logging 

{
	static Logger logs = Logger.getLogger(Logging.class);
	public static void loadfile()
	{
		PropertyConfigurator.configure("C:\\Users\\LENOVO\\eclipse-workspace\\Framework\\Utilities\\Log4j.properties");
		
		
	}
	
	public static void loginfo(String message)
	{
		loadfile();
		logs.info(message);
	}

	
}
