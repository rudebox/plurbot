import org.jibble.pircbot.*;

public class Main
{
	public static void main(String[] args) throws Exception 
	{
		if(args.length == 2)
		{
			String channel = args[1];
			//startup
			WasteBot wb = new WasteBot(args[0], channel);
			//enable debug
			wb.setVerbose(true);
			//connect
			wb.connect("irc.aberwiki.org");
			//join	
			wb.joinChannel(channel);
		}
		else
		{
			System.out.println("Invalid Syntax: Please add arguments for name and channel.");
			System.out.println("For example: java -classpath pircbot.jar:. Main \"Paul\" \"#mychannel\"");
		}
	}
}
