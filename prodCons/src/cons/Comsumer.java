package cons;
import unibo.basicomm23.enablers.ServerFactory;
import unibo.basicomm23.interfaces.IApplMsgHandler;
import unibo.basicomm23.interfaces.IServer;
import unibo.basicomm23.msg.ProtocolType;

public class Comsumer { 	
	private ProtocolType protocol;
	private String addr;
	private int entry;
	private IApplMsgHandler msgHandler;
	private IServer server;
 	
 	public Comsumer(ProtocolType protocol,String addr,int entry)
 	{
 		this.protocol=protocol;
 		this.addr=addr;
 		this.entry=entry;
 		this.msgHandler=new MyApplMsgHandler("cons");
 		this.server=ServerFactory.create(this.addr, this.entry, this.protocol, this.msgHandler);
 	}
 	
 	public void start() {
 		this.server.start();
 	}
 	
 	public boolean isAcrive()
 	{
 		return this.server.isActive();
 	}
 	
 	public void stop() {
 		this.server.stop();
 	}
}
