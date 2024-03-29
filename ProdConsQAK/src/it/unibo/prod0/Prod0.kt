/* Generated by AN DISI Unibo */ 
package it.unibo.prod0

import it.unibo.kactor.*
import alice.tuprolog.*
import unibo.basicomm23.*
import unibo.basicomm23.interfaces.*
import unibo.basicomm23.utils.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import it.unibo.kactor.sysUtil.createActor   //Sept2023

//User imports JAN2024

class Prod0 ( name: String, scope: CoroutineScope, isconfined: Boolean=false  ) : ActorBasicFsm( name, scope, confined=isconfined ){

	override fun getInitialState() : String{
		return "s0"
	}
	override fun getBody() : (ActorBasicFsm.() -> Unit){
		//val interruptedStateTransitions = mutableListOf<Transition>()
		return { //this:ActionBasciFsm
				state("s0") { //this:State
					action { //it:State
						CommUtils.outmagenta("$name: starting")
						//genTimer( actor, state )
					}
					//After Lenzi Aug2002
					sysaction { //it:State
					}	 	 
					 transition( edgeName="goto",targetState="sendInfo", cond=doswitch() )
				}	 
				state("sendInfo") { //this:State
					action { //it:State
						CommUtils.outmagenta("$name: sending info")
						forward("infoDis", "infoDis(10)" ,"cons" ) 
						request("infoReq", "infoReq(11)" ,"cons" )  
						//genTimer( actor, state )
					}
					//After Lenzi Aug2002
					sysaction { //it:State
					}	 	 
					 transition(edgeName="replReceived2",targetState="replReceived",cond=whenReply("infoRepl"))
				}	 
				state("replReceived") { //this:State
					action { //it:State
						if( checkMsgContent( Term.createTerm("infoRepl(N)"), Term.createTerm("infoRepl(N)"), 
						                        currentMsg.msgContent()) ) { //set msgArgList
								 val N=payloadArg(0)  
								CommUtils.outmagenta("$name in ${currentState.stateName} | $currentMsg | ${Thread.currentThread().getName()} n=${Thread.activeCount()}")
								 	   
								CommUtils.outmagenta("$name: received reply $N")
						}
						//genTimer( actor, state )
					}
					//After Lenzi Aug2002
					sysaction { //it:State
					}	 	 
					 transition( edgeName="goto",targetState="wait", cond=doswitch() )
				}	 
				state("wait") { //this:State
					action { //it:State
						CommUtils.outmagenta("$name: waiting 5sec")
						delay(5000) 
						//genTimer( actor, state )
					}
					//After Lenzi Aug2002
					sysaction { //it:State
					}	 	 
					 transition( edgeName="goto",targetState="sendInfo", cond=doswitch() )
				}	 
			}
		}
} 
