%====================================================================================
% prodcons description   
%====================================================================================
dispatch( infoDis, infoDis(N) ). %informazione di tipo dispatch inviata dal prod al cons
request( infoReq, infoReq(N) ). %informazione di tipo richiesta inviata dal prod al cons
%====================================================================================
context(ctxprodcons, "localhost",  "TCP", "8000").
 qactor( cons, ctxprodcons, "it.unibo.cons.Cons").
 static(cons).
  qactor( prod0, ctxprodcons, "it.unibo.prod0.Prod0").
 static(prod0).
  qactor( prod1, ctxprodcons, "it.unibo.prod1.Prod1").
 static(prod1).
