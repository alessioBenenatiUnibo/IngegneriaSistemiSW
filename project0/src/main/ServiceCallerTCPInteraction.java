package main;
import unibo.basicomm23.interfaces.IApplMessage;
import unibo.basicomm23.interfaces.Interaction;
import unibo.basicomm23.mqtt.MqttConnection;
import unibo.basicomm23.msg.ProtocolType;
import unibo.basicomm23.utils.BasicMsgUtil;
import unibo.basicomm23.utils.CommUtils;
import unibo.basicomm23.utils.ConnectionFactory;

public class ServiceCallerTCPInteraction { 	
 	
    public static void main( String[] args) {
    	ProtocolType protocol=ProtocolType.tcp;
    	String hostAddr="130.136.113.239";
    	String entry="8011";
     	Interaction conn ;
     	String  nfibo = "5";
     	String payload="dofibo(N)".replace("N", nfibo);
     	IApplMessage reqSync = BasicMsgUtil.buildRequest("clientJava", "dofibo", payload, "servicemath");
     	IApplMessage reqAsync = BasicMsgUtil.buildRequest("clientJava", "dofibo", payload, "servicemath");
     	IApplMessage res=null;
     	String mqttAnswerTopic = "answ_dofibo_clientJava";
     	
        
		try {
			conn = ConnectionFactory.createClientSupport(protocol, hostAddr, entry);
			System.out.println("req sync: "+reqSync);
			res=conn.request(reqSync);
			System.out.println("res sync: "+res.toString());
			
			System.out.println("req async: "+reqSync);
			conn.forward(reqAsync);
			System.out.println("res async: "+conn.receive());
			
			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}
