%====================================================================================
% ping_pong description   
%====================================================================================
dispatch( pallina, pallina(SEQ) ). %messaggio scambiato da Ping e Pong quando colpiscono la pallina
dispatch( errore, errore(1) ). %messaggio indicante un qualche errore
dispatch( vittoria, vittoria(1) ). %messaggio inviato da un'attore per confermare la sua vittoria
dispatch( sconfitta, sconfitta(1) ). %messaggio inviato da un'attore per segnalare la sua sconfitta
dispatch( okPing, okPing(1) ). %messaggio autoinviato da Ping se il controllo di un messaggio da parte di pong è andato a buon fine
dispatch( okPong, okPong(1) ). %messaggio autoinviato da Pong se il controllo di un messaggio da parte di ping è andato a buon fine
dispatch( short, short(V) ).
%====================================================================================
context(ctxpingpong, "localhost",  "TCP", "8015").
 qactor( ping, ctxpingpong, "it.unibo.ping.Ping").
 static(ping).
  qactor( pong, ctxpingpong, "it.unibo.pong.Pong").
 static(pong).
