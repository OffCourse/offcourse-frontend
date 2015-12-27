// Compiled by ClojureScript 1.7.170 {}
goog.provide('offcourse.api.implementations.bootstrappable');
goog.require('cljs.core');
goog.require('cljs.core.async');
goog.require('offcourse.protocols.bootstrappable');
offcourse.api.implementations.bootstrappable.listen = (function offcourse$api$implementations$bootstrappable$listen(p__37111){
var map__37135 = p__37111;
var map__37135__$1 = ((((!((map__37135 == null)))?((((map__37135.cljs$lang$protocol_mask$partition0$ & (64))) || (map__37135.cljs$core$ISeq$))?true:false):false))?cljs.core.apply.call(null,cljs.core.hash_map,map__37135):map__37135);
var output_channel = cljs.core.get.call(null,map__37135__$1,new cljs.core.Keyword(null,"output-channel","output-channel",338004025));
var input_channel = cljs.core.get.call(null,map__37135__$1,new cljs.core.Keyword(null,"input-channel","input-channel",1891525728));
var c__27442__auto__ = cljs.core.async.chan.call(null,(1));
cljs.core.async.impl.dispatch.run.call(null,((function (c__27442__auto__,map__37135,map__37135__$1,output_channel,input_channel){
return (function (){
var f__27443__auto__ = (function (){var switch__27421__auto__ = ((function (c__27442__auto__,map__37135,map__37135__$1,output_channel,input_channel){
return (function (state_37146){
var state_val_37147 = (state_37146[(1)]);
if((state_val_37147 === (1))){
var state_37146__$1 = state_37146;
var statearr_37148_37158 = state_37146__$1;
(statearr_37148_37158[(2)] = null);

(statearr_37148_37158[(1)] = (2));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_37147 === (2))){
var state_37146__$1 = state_37146;
return cljs.core.async.impl.ioc_helpers.take_BANG_.call(null,state_37146__$1,(4),input_channel);
} else {
if((state_val_37147 === (3))){
var inst_37144 = (state_37146[(2)]);
var state_37146__$1 = state_37146;
return cljs.core.async.impl.ioc_helpers.return_chan.call(null,state_37146__$1,inst_37144);
} else {
if((state_val_37147 === (4))){
var inst_37139 = (state_37146[(2)]);
var state_37146__$1 = state_37146;
return cljs.core.async.impl.ioc_helpers.put_BANG_.call(null,state_37146__$1,(5),output_channel,inst_37139);
} else {
if((state_val_37147 === (5))){
var inst_37141 = (state_37146[(2)]);
var state_37146__$1 = (function (){var statearr_37149 = state_37146;
(statearr_37149[(7)] = inst_37141);

return statearr_37149;
})();
var statearr_37150_37159 = state_37146__$1;
(statearr_37150_37159[(2)] = null);

(statearr_37150_37159[(1)] = (2));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
return null;
}
}
}
}
}
});})(c__27442__auto__,map__37135,map__37135__$1,output_channel,input_channel))
;
return ((function (switch__27421__auto__,c__27442__auto__,map__37135,map__37135__$1,output_channel,input_channel){
return (function() {
var offcourse$api$implementations$bootstrappable$listen_$_state_machine__27422__auto__ = null;
var offcourse$api$implementations$bootstrappable$listen_$_state_machine__27422__auto____0 = (function (){
var statearr_37154 = [null,null,null,null,null,null,null,null];
(statearr_37154[(0)] = offcourse$api$implementations$bootstrappable$listen_$_state_machine__27422__auto__);

(statearr_37154[(1)] = (1));

return statearr_37154;
});
var offcourse$api$implementations$bootstrappable$listen_$_state_machine__27422__auto____1 = (function (state_37146){
while(true){
var ret_value__27423__auto__ = (function (){try{while(true){
var result__27424__auto__ = switch__27421__auto__.call(null,state_37146);
if(cljs.core.keyword_identical_QMARK_.call(null,result__27424__auto__,new cljs.core.Keyword(null,"recur","recur",-437573268))){
continue;
} else {
return result__27424__auto__;
}
break;
}
}catch (e37155){if((e37155 instanceof Object)){
var ex__27425__auto__ = e37155;
var statearr_37156_37160 = state_37146;
(statearr_37156_37160[(5)] = ex__27425__auto__);


cljs.core.async.impl.ioc_helpers.process_exception.call(null,state_37146);

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
throw e37155;

}
}})();
if(cljs.core.keyword_identical_QMARK_.call(null,ret_value__27423__auto__,new cljs.core.Keyword(null,"recur","recur",-437573268))){
var G__37161 = state_37146;
state_37146 = G__37161;
continue;
} else {
return ret_value__27423__auto__;
}
break;
}
});
offcourse$api$implementations$bootstrappable$listen_$_state_machine__27422__auto__ = function(state_37146){
switch(arguments.length){
case 0:
return offcourse$api$implementations$bootstrappable$listen_$_state_machine__27422__auto____0.call(this);
case 1:
return offcourse$api$implementations$bootstrappable$listen_$_state_machine__27422__auto____1.call(this,state_37146);
}
throw(new Error('Invalid arity: ' + arguments.length));
};
offcourse$api$implementations$bootstrappable$listen_$_state_machine__27422__auto__.cljs$core$IFn$_invoke$arity$0 = offcourse$api$implementations$bootstrappable$listen_$_state_machine__27422__auto____0;
offcourse$api$implementations$bootstrappable$listen_$_state_machine__27422__auto__.cljs$core$IFn$_invoke$arity$1 = offcourse$api$implementations$bootstrappable$listen_$_state_machine__27422__auto____1;
return offcourse$api$implementations$bootstrappable$listen_$_state_machine__27422__auto__;
})()
;})(switch__27421__auto__,c__27442__auto__,map__37135,map__37135__$1,output_channel,input_channel))
})();
var state__27444__auto__ = (function (){var statearr_37157 = f__27443__auto__.call(null);
(statearr_37157[cljs.core.async.impl.ioc_helpers.USER_START_IDX] = c__27442__auto__);

return statearr_37157;
})();
return cljs.core.async.impl.ioc_helpers.run_state_machine_wrapped.call(null,state__27444__auto__);
});})(c__27442__auto__,map__37135,map__37135__$1,output_channel,input_channel))
);

return c__27442__auto__;
});
offcourse.api.implementations.bootstrappable.bootstrap = (function offcourse$api$implementations$bootstrappable$bootstrap(p__37162){
var map__37234 = p__37162;
var map__37234__$1 = ((((!((map__37234 == null)))?((((map__37234.cljs$lang$protocol_mask$partition0$ & (64))) || (map__37234.cljs$core$ISeq$))?true:false):false))?cljs.core.apply.call(null,cljs.core.hash_map,map__37234):map__37234);
var api = map__37234__$1;
var output_channel = cljs.core.get.call(null,map__37234__$1,new cljs.core.Keyword(null,"output-channel","output-channel",338004025));
var input_channel = cljs.core.get.call(null,map__37234__$1,new cljs.core.Keyword(null,"input-channel","input-channel",1891525728));
var status = cljs.core.get.call(null,map__37234__$1,new cljs.core.Keyword(null,"status","status",-1997798413));
var service = cljs.core.get.call(null,map__37234__$1,new cljs.core.Keyword(null,"service","service",-1963054559));
var c__27442__auto__ = cljs.core.async.chan.call(null,(1));
cljs.core.async.impl.dispatch.run.call(null,((function (c__27442__auto__,map__37234,map__37234__$1,api,output_channel,input_channel,status,service){
return (function (){
var f__27443__auto__ = (function (){var switch__27421__auto__ = ((function (c__27442__auto__,map__37234,map__37234__$1,api,output_channel,input_channel,status,service){
return (function (state_37277){
var state_val_37278 = (state_37277[(1)]);
if((state_val_37278 === (7))){
var state_37277__$1 = state_37277;
var statearr_37279_37305 = state_37277__$1;
(statearr_37279_37305[(2)] = false);

(statearr_37279_37305[(1)] = (8));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_37278 === (1))){
var inst_37237 = offcourse.protocols.bootstrappable.bootstrap.call(null,service);
var state_37277__$1 = state_37277;
return cljs.core.async.impl.ioc_helpers.take_BANG_.call(null,state_37277__$1,(2),inst_37237);
} else {
if((state_val_37278 === (4))){
var state_37277__$1 = state_37277;
var statearr_37280_37306 = state_37277__$1;
(statearr_37280_37306[(2)] = false);

(statearr_37280_37306[(1)] = (5));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_37278 === (15))){
var inst_37275 = (state_37277[(2)]);
var state_37277__$1 = state_37277;
return cljs.core.async.impl.ioc_helpers.return_chan.call(null,state_37277__$1,inst_37275);
} else {
if((state_val_37278 === (13))){
var inst_37259 = (state_37277[(7)]);
var inst_37267 = [new cljs.core.Keyword(null,"error","error",-978969032)];
var inst_37268 = [inst_37259];
var inst_37269 = cljs.core.PersistentHashMap.fromArrays(inst_37267,inst_37268);
var state_37277__$1 = state_37277;
return cljs.core.async.impl.ioc_helpers.put_BANG_.call(null,state_37277__$1,(16),output_channel,inst_37269);
} else {
if((state_val_37278 === (6))){
var state_37277__$1 = state_37277;
var statearr_37281_37307 = state_37277__$1;
(statearr_37281_37307[(2)] = true);

(statearr_37281_37307[(1)] = (8));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_37278 === (3))){
var inst_37239 = (state_37277[(8)]);
var inst_37244 = inst_37239.cljs$lang$protocol_mask$partition0$;
var inst_37245 = (inst_37244 & (64));
var inst_37246 = inst_37239.cljs$core$ISeq$;
var inst_37247 = (inst_37245) || (inst_37246);
var state_37277__$1 = state_37277;
if(cljs.core.truth_(inst_37247)){
var statearr_37282_37308 = state_37277__$1;
(statearr_37282_37308[(1)] = (6));

} else {
var statearr_37283_37309 = state_37277__$1;
(statearr_37283_37309[(1)] = (7));

}

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_37278 === (12))){
var inst_37260 = (state_37277[(9)]);
var inst_37265 = (state_37277[(2)]);
var state_37277__$1 = (function (){var statearr_37284 = state_37277;
(statearr_37284[(10)] = inst_37265);

return statearr_37284;
})();
if(cljs.core.truth_(inst_37260)){
var statearr_37285_37310 = state_37277__$1;
(statearr_37285_37310[(1)] = (13));

} else {
var statearr_37286_37311 = state_37277__$1;
(statearr_37286_37311[(1)] = (14));

}

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_37278 === (2))){
var inst_37239 = (state_37277[(8)]);
var inst_37239__$1 = (state_37277[(2)]);
var inst_37241 = (inst_37239__$1 == null);
var inst_37242 = cljs.core.not.call(null,inst_37241);
var state_37277__$1 = (function (){var statearr_37287 = state_37277;
(statearr_37287[(8)] = inst_37239__$1);

return statearr_37287;
})();
if(inst_37242){
var statearr_37288_37312 = state_37277__$1;
(statearr_37288_37312[(1)] = (3));

} else {
var statearr_37289_37313 = state_37277__$1;
(statearr_37289_37313[(1)] = (4));

}

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_37278 === (11))){
var inst_37259 = (state_37277[(7)]);
var inst_37259__$1 = (state_37277[(2)]);
var inst_37260 = cljs.core.get.call(null,inst_37259__$1,new cljs.core.Keyword(null,"error","error",-978969032));
var inst_37261 = [new cljs.core.Keyword(null,"status","status",-1997798413)];
var inst_37262 = [inst_37259__$1];
var inst_37263 = cljs.core.PersistentHashMap.fromArrays(inst_37261,inst_37262);
var state_37277__$1 = (function (){var statearr_37290 = state_37277;
(statearr_37290[(9)] = inst_37260);

(statearr_37290[(7)] = inst_37259__$1);

return statearr_37290;
})();
return cljs.core.async.impl.ioc_helpers.put_BANG_.call(null,state_37277__$1,(12),output_channel,inst_37263);
} else {
if((state_val_37278 === (9))){
var inst_37239 = (state_37277[(8)]);
var inst_37256 = cljs.core.apply.call(null,cljs.core.hash_map,inst_37239);
var state_37277__$1 = state_37277;
var statearr_37291_37314 = state_37277__$1;
(statearr_37291_37314[(2)] = inst_37256);

(statearr_37291_37314[(1)] = (11));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_37278 === (5))){
var inst_37254 = (state_37277[(2)]);
var state_37277__$1 = state_37277;
if(cljs.core.truth_(inst_37254)){
var statearr_37292_37315 = state_37277__$1;
(statearr_37292_37315[(1)] = (9));

} else {
var statearr_37293_37316 = state_37277__$1;
(statearr_37293_37316[(1)] = (10));

}

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_37278 === (14))){
var inst_37273 = offcourse.api.implementations.bootstrappable.listen.call(null,api);
var state_37277__$1 = state_37277;
var statearr_37294_37317 = state_37277__$1;
(statearr_37294_37317[(2)] = inst_37273);

(statearr_37294_37317[(1)] = (15));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_37278 === (16))){
var inst_37271 = (state_37277[(2)]);
var state_37277__$1 = state_37277;
var statearr_37295_37318 = state_37277__$1;
(statearr_37295_37318[(2)] = inst_37271);

(statearr_37295_37318[(1)] = (15));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_37278 === (10))){
var inst_37239 = (state_37277[(8)]);
var state_37277__$1 = state_37277;
var statearr_37296_37319 = state_37277__$1;
(statearr_37296_37319[(2)] = inst_37239);

(statearr_37296_37319[(1)] = (11));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_37278 === (8))){
var inst_37251 = (state_37277[(2)]);
var state_37277__$1 = state_37277;
var statearr_37297_37320 = state_37277__$1;
(statearr_37297_37320[(2)] = inst_37251);

(statearr_37297_37320[(1)] = (5));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
return null;
}
}
}
}
}
}
}
}
}
}
}
}
}
}
}
}
});})(c__27442__auto__,map__37234,map__37234__$1,api,output_channel,input_channel,status,service))
;
return ((function (switch__27421__auto__,c__27442__auto__,map__37234,map__37234__$1,api,output_channel,input_channel,status,service){
return (function() {
var offcourse$api$implementations$bootstrappable$bootstrap_$_state_machine__27422__auto__ = null;
var offcourse$api$implementations$bootstrappable$bootstrap_$_state_machine__27422__auto____0 = (function (){
var statearr_37301 = [null,null,null,null,null,null,null,null,null,null,null];
(statearr_37301[(0)] = offcourse$api$implementations$bootstrappable$bootstrap_$_state_machine__27422__auto__);

(statearr_37301[(1)] = (1));

return statearr_37301;
});
var offcourse$api$implementations$bootstrappable$bootstrap_$_state_machine__27422__auto____1 = (function (state_37277){
while(true){
var ret_value__27423__auto__ = (function (){try{while(true){
var result__27424__auto__ = switch__27421__auto__.call(null,state_37277);
if(cljs.core.keyword_identical_QMARK_.call(null,result__27424__auto__,new cljs.core.Keyword(null,"recur","recur",-437573268))){
continue;
} else {
return result__27424__auto__;
}
break;
}
}catch (e37302){if((e37302 instanceof Object)){
var ex__27425__auto__ = e37302;
var statearr_37303_37321 = state_37277;
(statearr_37303_37321[(5)] = ex__27425__auto__);


cljs.core.async.impl.ioc_helpers.process_exception.call(null,state_37277);

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
throw e37302;

}
}})();
if(cljs.core.keyword_identical_QMARK_.call(null,ret_value__27423__auto__,new cljs.core.Keyword(null,"recur","recur",-437573268))){
var G__37322 = state_37277;
state_37277 = G__37322;
continue;
} else {
return ret_value__27423__auto__;
}
break;
}
});
offcourse$api$implementations$bootstrappable$bootstrap_$_state_machine__27422__auto__ = function(state_37277){
switch(arguments.length){
case 0:
return offcourse$api$implementations$bootstrappable$bootstrap_$_state_machine__27422__auto____0.call(this);
case 1:
return offcourse$api$implementations$bootstrappable$bootstrap_$_state_machine__27422__auto____1.call(this,state_37277);
}
throw(new Error('Invalid arity: ' + arguments.length));
};
offcourse$api$implementations$bootstrappable$bootstrap_$_state_machine__27422__auto__.cljs$core$IFn$_invoke$arity$0 = offcourse$api$implementations$bootstrappable$bootstrap_$_state_machine__27422__auto____0;
offcourse$api$implementations$bootstrappable$bootstrap_$_state_machine__27422__auto__.cljs$core$IFn$_invoke$arity$1 = offcourse$api$implementations$bootstrappable$bootstrap_$_state_machine__27422__auto____1;
return offcourse$api$implementations$bootstrappable$bootstrap_$_state_machine__27422__auto__;
})()
;})(switch__27421__auto__,c__27442__auto__,map__37234,map__37234__$1,api,output_channel,input_channel,status,service))
})();
var state__27444__auto__ = (function (){var statearr_37304 = f__27443__auto__.call(null);
(statearr_37304[cljs.core.async.impl.ioc_helpers.USER_START_IDX] = c__27442__auto__);

return statearr_37304;
})();
return cljs.core.async.impl.ioc_helpers.run_state_machine_wrapped.call(null,state__27444__auto__);
});})(c__27442__auto__,map__37234,map__37234__$1,api,output_channel,input_channel,status,service))
);

return c__27442__auto__;
});

//# sourceMappingURL=bootstrappable.js.map