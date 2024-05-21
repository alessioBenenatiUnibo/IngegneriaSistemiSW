/* Generated by AN DISI Unibo */ 
package it.unibo.nor_1

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

class Nor_1 ( name: String, scope: CoroutineScope, isconfined: Boolean=false  ) : ActorBasicFsm( name, scope, confined=isconfined ){

	override fun getInitialState() : String{
		return "s0"
	}
	override fun getBody() : (ActorBasicFsm.() -> Unit){
		//val interruptedStateTransitions = mutableListOf<Transition>()
		
				var in1=false;
				var in2=false;
				var out=!(in1 || in2)
		return { //this:ActionBasciFsm
				state("s0") { //this:State
					action { //it:State
						CoapObserverSupport(myself, "localhost","8015","ctx_flip_flop","nor_2","nor_2_out")
						//genTimer( actor, state )
					}
					//After Lenzi Aug2002
					sysaction { //it:State
					}	 	 
					 transition( edgeName="goto",targetState="out", cond=doswitch() )
				}	 
				state("in") { //this:State
					action { //it:State
						//genTimer( actor, state )
					}
					//After Lenzi Aug2002
					sysaction { //it:State
				 	 		stateTimer = TimerActor("timer_in", 
				 	 					  scope, context!!, "local_tout_"+name+"_in", 1000.toLong() )  //OCT2023
					}	 	 
					 transition(edgeName="t00",targetState="out",cond=whenTimeout("local_tout_"+name+"_in"))   
					transition(edgeName="t01",targetState="handle_in_1",cond=whenDispatch("nor_1_in_1"))
					transition(edgeName="t02",targetState="handle_in_2",cond=whenDispatch("nor_2_out"))
				}	 
				state("out") { //this:State
					action { //it:State
						
									out=!(in1 || in2)
									val OUT=if(out) 1 else 0	
						CommUtils.outgreen("$name out $out")
						forward("nor_1_out", "nor_1_out($OUT)" ,"nor_2" ) 
						//genTimer( actor, state )
					}
					//After Lenzi Aug2002
					sysaction { //it:State
					}	 	 
					 transition( edgeName="goto",targetState="in", cond=doswitch() )
				}	 
				state("handle_in_1") { //this:State
					action { //it:State
						if( checkMsgContent( Term.createTerm("nor_1_in_1(V)"), Term.createTerm("nor_1_in_1(V)"), 
						                        currentMsg.msgContent()) ) { //set msgArgList
								
											in1=(payloadArg(0)=="1")
						}
						//genTimer( actor, state )
					}
					//After Lenzi Aug2002
					sysaction { //it:State
					}	 	 
					 transition( edgeName="goto",targetState="in", cond=doswitch() )
				}	 
				state("handle_in_2") { //this:State
					action { //it:State
						if( checkMsgContent( Term.createTerm("nor_2_out(V)"), Term.createTerm("nor_2_out(V)"), 
						                        currentMsg.msgContent()) ) { //set msgArgList
								
											in2=(payloadArg(0)=="1")
						}
						//genTimer( actor, state )
					}
					//After Lenzi Aug2002
					sysaction { //it:State
					}	 	 
					 transition( edgeName="goto",targetState="in", cond=doswitch() )
				}	 
			}
		}
} 
