package cons;

import unibo.basicomm23.msg.ProtocolType;

public class ConsumerMain {
	
	public static void main(String[] args)
	{
		Comsumer cons=new Comsumer(ProtocolType.tcp,"localhost",60000);
		cons.start();
	}

}
