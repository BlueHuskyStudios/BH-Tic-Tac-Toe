/**
 * StaticShock, made for BH Tic Tac Toe, is copyright Blue Husky Programming ©2014 GPLv3<HR/>
 * 
 * @author Kyli of Blue Husky Programming
 * @version 1.0.0
 * @since 2014-09-22
 */
public class StaticShock
{
	public static final String test = "access approved";
	
	private static StaticShock ss = null;
	
	public static void main(String[] args)
	{
		try
		{
			System.out.println(ss.test);
		}
		catch (Throwable t)
		{
			System.out.println("access denied");
		}
	}
}
