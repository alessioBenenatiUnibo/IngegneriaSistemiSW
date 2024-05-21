%====================================================================================
% bw24 description   
%====================================================================================
dispatch( stepdone, stepdone(X) ).
dispatch( stepfailed, stepfailed(X) ).
event( sonardata, sonar(DISTANCE) ).
event( vrinfo, vrinfo(A,B) ).
dispatch( vrinfo, vrinfo(A,B) ).
event( obstacle, obstacle(D) ). %emesso da WEnv
event( wolf, wolf(D) ). %emesso da sonarmock
%====================================================================================
context(ctxbw24, "localhost",  "TCP", "8120").
context(ctxsonarbw24, "192.168.1.3",  "TCP", "8128").
 qactor( datacleaner, ctxsonarbw24, "external").
  qactor( bw24core, ctxbw24, "it.unibo.bw24core.Bw24core").
 static(bw24core).
  qactor( bwobserver, ctxbw24, "it.unibo.bwobserver.Bwobserver").
 static(bwobserver).
