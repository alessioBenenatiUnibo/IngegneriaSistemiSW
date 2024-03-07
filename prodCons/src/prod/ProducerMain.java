package prod;

import unibo.basicomm23.msg.ProtocolType;

public class ProducerMain {


	public static void main(String[] args) {
		Producer prod=new Producer(ProtocolType.tcp,"localhost","60000");
		prod.sendInfo("info");

	}

}
