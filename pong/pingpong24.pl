%====================================================================================
% pingpong24 description   
%====================================================================================
dispatch( ball, ball(N) ). %info exchanged by the players
dispatch( ballview, ball(N) ). %observed info | payload not mandatory
request( info, info(X) ). %sent by the testUnit to the observer
reply( obsinfo, obsinfo(X) ).  %%for info
dispatch( endgame, endgame(X) ). %sent as an automsg by the observer
%====================================================================================
context(ctxping, "127.0.0.1",  "TCP", "8014").
context(ctxpong, "localhost",  "TCP", "8015").
 qactor( ping, ctxping, "external").
  qactor( pong, ctxpong, "it.unibo.pong.Pong").
 static(pong).
