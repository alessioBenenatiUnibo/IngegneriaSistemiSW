%====================================================================================
% cold_storage_service description   
%====================================================================================
request( store_request, store(N) ).
request( charge_request, store(N) ).
request( new_ticket_request, new_ticket_request(N) ).
request( validate_ticket_request, validate_ticket_request(T) ).
request( avilable_space_request, available_cpace_request(N) ).
%====================================================================================
context(ctx_cold_storage_service, "localhost",  "TCP", "8020").
 qactor( cold_storage_service, ctx_cold_storage_service, "it.unibo.cold_storage_service.Cold_storage_service").
 static(cold_storage_service).
  qactor( ticket_manager, ctx_cold_storage_service, "it.unibo.ticket_manager.Ticket_manager").
 static(ticket_manager).
  qactor( indoor, ctx_cold_storage_service, "it.unibo.indoor.Indoor").
 static(indoor).
  qactor( driver_mock, ctx_cold_storage_service, "it.unibo.driver_mock.Driver_mock").
 static(driver_mock).
