%====================================================================================
% sonarbw24 description   
%====================================================================================
mqttBroker("broker.hivemq.com", "1883", "sonarbw24data").
event( sonardata, distance(D) ).
event( wolf, wolf(D) ).
%====================================================================================
context(ctxsonarbw24, "localhost",  "TCP", "8128").
context(ctxbw24, "192.168.1.2",  "TCP", "8120").
 qactor( sonardevice, ctxsonarbw24, "it.unibo.sonardevice.Sonardevice").
 static(sonardevice).
  qactor( datacleaner, ctxsonarbw24, "it.unibo.datacleaner.Datacleaner").
 static(datacleaner).
