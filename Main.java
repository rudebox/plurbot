import org.jibble.pircbot.*;

public class Main
{
	public static void main(String[] args) throws Exception 
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
		
}
