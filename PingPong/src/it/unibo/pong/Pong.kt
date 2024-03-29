/* Generated by AN DISI Unibo */ 
package it.unibo.pong

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
import kotlin.random.Random

class Pong ( name: String, scope: CoroutineScope, isconfined: Boolean=false  ) : ActorBasicFsm( name, scope, confined=isconfined ){

	override fun getInitialState() : String{
		return "s0"
	}
	override fun getBody() : (ActorBasicFsm.() -> Unit){
		//val interruptedStateTransitions = mutableListOf<Transition>()
		 val counter = it.unibo.res.Counter(-1)
		return { //this:ActionBasciFsm
				state("s0") { //this:State
					action { //it:State
						CommUtils.outyellow("$name STARTS")
						//genTimer( actor, state )
					}
					//After Lenzi Aug2002
					sysaction { //it:State
					}	 	 
					 transition(edgeName="t09",targetState="controlloMessaggio",cond=whenDispatch("pallina"))
				}	 
				state("battuta") { //this:State
					action { //it:State
						delay(1000) 
						
									val precision:Double=if(counter.seq==0) 1.0 else Random.nextDouble()
									counter.lastHit=(precision>0.2)
									
									val SEQ=counter.seq
									val HIT= counter.lastHit
						CommUtils.outyellow("$name: SEQ=$SEQ HIT=$HIT")
						if( HIT 
						 ){forward("pallina", "pallina($SEQ)" ,"ping" ) 
						}
						else
						 {forward("sconfitta", "sconfitta(1)" ,"ping" ) 
						 }
						//genTimer( actor, state )
					}
					//After Lenzi Aug2002
					sysaction { //it:State
					}	 	 
					 transition(edgeName="t010",targetState="controlloMessaggio",cond=whenDispatch("pallina"))
					transition(edgeName="t011",targetState="vittoria",cond=whenDispatch("sconfitta"))
					transition(edgeName="t012",targetState="sconfitta",cond=whenDispatchGuarded("vittoria",{!counter.lastHit 
					}))
					transition(edgeName="t013",targetState="errore",cond=whenDispatchGuarded("vittoria",{counter.lastHit 
					}))
				}	 
				state("controlloMessaggio") { //this:State
					action { //it:State
						if( checkMsgContent( Term.createTerm("pallina(SEQ)"), Term.createTerm("pallina(SEQ)"), 
						                        currentMsg.msgContent()) ) { //set msgArgList
								counter.update() 
								CommUtils.outyellow("$name: ricevuto $currentMsg")
								if( payloadArg(0)!=counter.seq.toString() 
								 ){forward("errore", "errore(1)" ,name ) 
								}
								else
								 {forward("okPong", "okPong(1)" ,name ) 
								 }
						}
						//genTimer( actor, state )
					}
					//After Lenzi Aug2002
					sysaction { //it:State
					}	 	 
					 transition(edgeName="t014",targetState="errore",cond=whenDispatch("pallina"))
					transition(edgeName="t015",targetState="errore",cond=whenDispatch("vittoria"))
					transition(edgeName="t016",targetState="errore",cond=whenDispatch("sconfitta"))
					transition(edgeName="t017",targetState="errore",cond=whenDispatch("errore"))
					transition(edgeName="t018",targetState="battuta",cond=whenDispatch("okPong"))
				}	 
				state("vittoria") { //this:State
					action { //it:State
						delay(1000) 
						CommUtils.outyellow("$name: vittoria")
						forward("vittoria", "vittoria(1)" ,"ping" ) 
						//genTimer( actor, state )
					}
					//After Lenzi Aug2002
					sysaction { //it:State
					}	 	 
				}	 
				state("sconfitta") { //this:State
					action { //it:State
						CommUtils.outyellow("$name: sconfitta")
						//genTimer( actor, state )
					}
					//After Lenzi Aug2002
					sysaction { //it:State
					}	 	 
				}	 
				state("errore") { //this:State
					action { //it:State
						CommUtils.outyellow("$name: errore di sequenza")
						//genTimer( actor, state )
					}
					//After Lenzi Aug2002
					sysaction { //it:State
					}	 	 
				}	 
			}
		}
} 
