%====================================================================================
% flip_flop description   
%====================================================================================
dispatch( nor_1_in_1, nor_1_in_1(V) ).
dispatch( nor_1_out, nor_1_out(V) ).
dispatch( nor_2_in_2, nor_2_in_2(V) ).
dispatch( nor_2_out, nor_2_out(V) ).
%====================================================================================
context(ctx_flip_flop, "localhost",  "TCP", "8015").
 qactor( nor_1, ctx_flip_flop, "it.unibo.nor_1.Nor_1").
 static(nor_1).
  qactor( nor_2, ctx_flip_flop, "it.unibo.nor_2.Nor_2").
 static(nor_2).
  qactor( user, ctx_flip_flop, "it.unibo.user.User").
 static(user).
