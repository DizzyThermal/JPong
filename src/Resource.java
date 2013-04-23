public class Resource
{
	public static final String VERSION_NUMBER		= "v0.0.1";
	public static final String VERSION_CODENAME		= "Anchovies";
	
	public static String IP							= "192.168.1.100";
	public static String PORT						= "8010";

	public static String USERNAME					= getUsername();
	
	public static String getUsername()
	{
		return System.getProperty("user.name");
	}
}