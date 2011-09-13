/*
 *@Author rudebox 
 *
 */

import org.jibble.pircbot.*;

public class WasteBot extends PircBot 
{
	private int alternate;
	private String mess;
	private String channel;
	private String me;
	private String rea;
	private String red;
	private String fail;
	private int rp;

	public WasteBot(String n, String chan)
	{
		this.setName(n);
		this.setLogin(n);
		channel = chan;
		alternate = 0;
		me = "rudebox";
		rp = 1;
	}

	protected void onInvite(String targetNick, String sourceNick, String sourceLogin, String sourceHostname, String channel)
	{
		if (targetNick.equalsIgnoreCase(getName())) 
		{
			joinChannel(this.channel);
		}
	}
	
	protected void onPrivateMessage(String sender, String login, String hostname, String message)
	{
		if (sender.equalsIgnoreCase(me) && message.equalsIgnoreCase("cactus"))
		{
			leave();
		}
		else if (sender.equalsIgnoreCase(me) && message.equalsIgnoreCase("oi"))
		{
			sendInvite(me, channel);
		}
	}	

	public void onJoin(String channel, String sender, String login, String hostname)
	{
		String [] friends = {"rudebox","Redache","reality","Willow","fail","lavard","Paulie","Snow","enemy"};
		boolean notfriend = true;

		for (String f : friends)
		{
			if (sender.equalsIgnoreCase(f))
			{
				op(channel, sender);
				notfriend = false;
			}
		}
		if(notfriend) setMode(channel, "+h " + sender);
 	}

	protected void onKick(String channel, String kickerNick, String kickerLogin, String kickerHostname, String recipientNick, String reason)
	{
		if (recipientNick.equalsIgnoreCase(getName())) 
		{
		    joinChannel(channel);
	            sendMessage(channel, kickerNick + ": Pls2NotKickBots.");
		    
		}
	}

	protected void onDeop(String channel, String sourceNick, String sourceLogin, String sourceHostname, String recipient)
	{
		
	}

	protected void onMessage(String channel, String sender, String login, String hostname, String message) 
	{
        
		String [] splits;
		String delimiter = " ";
		splits = message.split(delimiter, 2);
		
		if (message.equalsIgnoreCase("false flag"))
		{
			sendMessage(channel, sender + ": ✈ ▌▌ |  ¦҉▌▌ | ▄ ▌ | ▄✈▌ | ▄ ¦҉▌ | ▄ ▄ ");
  		}
		else if(message.equalsIgnoreCase("ron paul"))
		{
			ronpaul(sender);
		}
		else if (splits.length == 2)
		{
			if (splits[0].equalsIgnoreCase(".g"))
			{
				google(splits[1], sender);				
			}			
		}
	}

    	public void leave()
    	{
		this.disconnect();
		System.exit(0);
    	}

	public void ronpaul(String send)
	{
		String ron = "";
	        switch (rp) 
	    	{
            		case 1:  
				ron = ": SAVE OUR CONSTITUTIONAL RIGHTS!";
				rp++; 
				break;
            		case 2: ron = ": WE'RE NOT GONNA GIVE UP THE FIGHT!";
				rp++;
			        break;
            		case 3:  ron = ": START A REVOLUTION! AND BREAK DOWN THAT ILLEGAL INSTITUTION!";
			         rp = 1;
				break;
		}
		sendMessage(channel, send + ron); 
	}

	public void google(String words, String send)
	{
		String search = words.replace(" ", "+");
		sendMessage(channel, send + ": http://www.google.com/search?q="+search);		
	}
}
