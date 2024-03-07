package cons;

import unibo.basicomm23.interfaces.IApplMessage;
import unibo.basicomm23.interfaces.Interaction;
import unibo.basicomm23.msg.ApplMsgHandler;
import unibo.basicomm23.utils.BasicMsgUtil;

public class MyApplMsgHandler extends ApplMsgHandler {

	public MyApplMsgHandler(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void elaborate(IApplMessage message, Interaction conn) {
		System.out.println("elaboration of "+ message +" from "+conn+"...");
		
		try {
			IApplMessage res=BasicMsgUtil.buildReply("consJava", "ack", "ack", "prodJava");
			System.out.println("sending: "+res);
			conn.reply(res);
		} catch (Exception e) {
			System.out.println("something went wrong:");
			e.printStackTrace();
		}

	}

}
