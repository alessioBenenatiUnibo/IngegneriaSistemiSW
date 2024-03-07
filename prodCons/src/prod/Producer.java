package prod;
import unibo.basicomm23.interfaces.IApplMessage;
import unibo.basicomm23.interfaces.Interaction;
import unibo.basicomm23.mqtt.MqttConnection;
import unibo.basicomm23.msg.ProtocolType;
import unibo.basicomm23.utils.BasicMsgUtil;
import unibo.basicomm23.utils.CommUtils;
import unibo.basicomm23.utils.ConnectionFactory;

public class Producer { 	
	private ProtocolType protocol;
	private String consAddr;
	private String consEntry;
 	
 	public Producer(ProtocolType protocol,String consAddr,String consEntry)
 	{
 		this.protocol=protocol;
 		this.consAddr=consAddr;
 		this.consEntry=consEntry;
 	}
 	
 	public void sendInfo(String info)
 	{
 		IApplMessage req=BasicMsgUtil.buildRequest("prodJava", "sendInfo", info, "consJava");
 		Interaction connection=ConnectionFactory.createClientSupport(protocol, consAddr, consEntry);
 		System.out.println("sending: "+req);
 		try{
 			IApplMessage res=connection.request(req);
 			System.out.println("received: "+res);
 		}catch(Exception e)
 		{
 			System.out.println("something went wrong:");
 			e.printStackTrace();
 		} 		
 	}
}
