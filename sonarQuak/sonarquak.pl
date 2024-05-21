%====================================================================================
% sonarquak description   
%====================================================================================
dispatch( startSonar, start(M) ). %
dispatch( stopSonar, stop(M) ). %
%====================================================================================
context(ctxsonar, "localhost",  "TCP", "8014").
 qactor( sonardevice, ctxsonar, "it.unibo.sonardevice.Sonardevice").
 static(sonardevice).
  qactor( god, ctxsonar, "it.unibo.god.God").
 static(god).
