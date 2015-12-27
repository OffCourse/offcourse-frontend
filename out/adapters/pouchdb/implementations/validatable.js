// Compiled by ClojureScript 1.7.170 {}
goog.provide('adapters.pouchdb.implementations.validatable');
goog.require('cljs.core');
goog.require('cljs.core.async');
goog.require('adapters.pouchdb.wrapper');
adapters.pouchdb.implementations.validatable.errors_async = (function adapters$pouchdb$implementations$validatable$errors_async(p__32428){
var map__32463 = p__32428;
var map__32463__$1 = ((((!((map__32463 == null)))?((((map__32463.cljs$lang$protocol_mask$partition0$ & (64))) || (map__32463.cljs$core$ISeq$))?true:false):false))?cljs.core.apply.call(null,cljs.core.hash_map,map__32463):map__32463);
var connection = cljs.core.get.call(null,map__32463__$1,new cljs.core.Keyword(null,"connection","connection",-123599300));
var design_doc = cljs.core.get.call(null,map__32463__$1,new cljs.core.Keyword(null,"design-doc","design-doc",-98897062));
var bootstrap_doc = cljs.core.get.call(null,map__32463__$1,new cljs.core.Keyword(null,"bootstrap-doc","bootstrap-doc",-908945544));
var c__27442__auto__ = cljs.core.async.chan.call(null,(1));
cljs.core.async.impl.dispatch.run.call(null,((function (c__27442__auto__,map__32463,map__32463__$1,connection,design_doc,bootstrap_doc){
return (function (){
var f__27443__auto__ = (function (){var switch__27421__auto__ = ((function (c__27442__auto__,map__32463,map__32463__$1,connection,design_doc,bootstrap_doc){
return (function (state_32483){
var state_val_32484 = (state_32483[(1)]);
if((state_val_32484 === (1))){
var inst_32465 = cljs.core.PersistentVector.EMPTY_NODE;
var inst_32466 = [design_doc,bootstrap_doc];
var inst_32467 = (new cljs.core.PersistentVector(null,2,(5),inst_32465,inst_32466,null));
var inst_32468 = adapters.pouchdb.wrapper.missing_docs.call(null,connection,inst_32467);
var state_32483__$1 = state_32483;
return cljs.core.async.impl.ioc_helpers.take_BANG_.call(null,state_32483__$1,(2),inst_32468);
} else {
if((state_val_32484 === (2))){
var inst_32470 = (state_32483[(7)]);
var inst_32470__$1 = (state_32483[(2)]);
var inst_32471 = cljs.core.empty_QMARK_.call(null,inst_32470__$1);
var state_32483__$1 = (function (){var statearr_32485 = state_32483;
(statearr_32485[(7)] = inst_32470__$1);

return statearr_32485;
})();
if(inst_32471){
var statearr_32486_32497 = state_32483__$1;
(statearr_32486_32497[(1)] = (3));

} else {
var statearr_32487_32498 = state_32483__$1;
(statearr_32487_32498[(1)] = (4));

}

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_32484 === (3))){
var inst_32473 = [new cljs.core.Keyword(null,"status","status",-1997798413)];
var inst_32474 = [new cljs.core.Keyword(null,"db-ready","db-ready",25959867)];
var inst_32475 = cljs.core.PersistentHashMap.fromArrays(inst_32473,inst_32474);
var state_32483__$1 = state_32483;
var statearr_32488_32499 = state_32483__$1;
(statearr_32488_32499[(2)] = inst_32475);

(statearr_32488_32499[(1)] = (5));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_32484 === (4))){
var inst_32470 = (state_32483[(7)]);
var inst_32477 = [new cljs.core.Keyword(null,"status","status",-1997798413),new cljs.core.Keyword(null,"error","error",-978969032),new cljs.core.Keyword(null,"missing-data","missing-data",1386207722)];
var inst_32478 = [new cljs.core.Keyword(null,"error","error",-978969032),new cljs.core.Keyword(null,"missing-data","missing-data",1386207722),inst_32470];
var inst_32479 = cljs.core.PersistentHashMap.fromArrays(inst_32477,inst_32478);
var state_32483__$1 = state_32483;
var statearr_32489_32500 = state_32483__$1;
(statearr_32489_32500[(2)] = inst_32479);

(statearr_32489_32500[(1)] = (5));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_32484 === (5))){
var inst_32481 = (state_32483[(2)]);
var state_32483__$1 = state_32483;
return cljs.core.async.impl.ioc_helpers.return_chan.call(null,state_32483__$1,inst_32481);
} else {
return null;
}
}
}
}
}
});})(c__27442__auto__,map__32463,map__32463__$1,connection,design_doc,bootstrap_doc))
;
return ((function (switch__27421__auto__,c__27442__auto__,map__32463,map__32463__$1,connection,design_doc,bootstrap_doc){
return (function() {
var adapters$pouchdb$implementations$validatable$errors_async_$_state_machine__27422__auto__ = null;
var adapters$pouchdb$implementations$validatable$errors_async_$_state_machine__27422__auto____0 = (function (){
var statearr_32493 = [null,null,null,null,null,null,null,null];
(statearr_32493[(0)] = adapters$pouchdb$implementations$validatable$errors_async_$_state_machine__27422__auto__);

(statearr_32493[(1)] = (1));

return statearr_32493;
});
var adapters$pouchdb$implementations$validatable$errors_async_$_state_machine__27422__auto____1 = (function (state_32483){
while(true){
var ret_value__27423__auto__ = (function (){try{while(true){
var result__27424__auto__ = switch__27421__auto__.call(null,state_32483);
if(cljs.core.keyword_identical_QMARK_.call(null,result__27424__auto__,new cljs.core.Keyword(null,"recur","recur",-437573268))){
continue;
} else {
return result__27424__auto__;
}
break;
}
}catch (e32494){if((e32494 instanceof Object)){
var ex__27425__auto__ = e32494;
var statearr_32495_32501 = state_32483;
(statearr_32495_32501[(5)] = ex__27425__auto__);


cljs.core.async.impl.ioc_helpers.process_exception.call(null,state_32483);

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
throw e32494;

}
}})();
if(cljs.core.keyword_identical_QMARK_.call(null,ret_value__27423__auto__,new cljs.core.Keyword(null,"recur","recur",-437573268))){
var G__32502 = state_32483;
state_32483 = G__32502;
continue;
} else {
return ret_value__27423__auto__;
}
break;
}
});
adapters$pouchdb$implementations$validatable$errors_async_$_state_machine__27422__auto__ = function(state_32483){
switch(arguments.length){
case 0:
return adapters$pouchdb$implementations$validatable$errors_async_$_state_machine__27422__auto____0.call(this);
case 1:
return adapters$pouchdb$implementations$validatable$errors_async_$_state_machine__27422__auto____1.call(this,state_32483);
}
throw(new Error('Invalid arity: ' + arguments.length));
};
adapters$pouchdb$implementations$validatable$errors_async_$_state_machine__27422__auto__.cljs$core$IFn$_invoke$arity$0 = adapters$pouchdb$implementations$validatable$errors_async_$_state_machine__27422__auto____0;
adapters$pouchdb$implementations$validatable$errors_async_$_state_machine__27422__auto__.cljs$core$IFn$_invoke$arity$1 = adapters$pouchdb$implementations$validatable$errors_async_$_state_machine__27422__auto____1;
return adapters$pouchdb$implementations$validatable$errors_async_$_state_machine__27422__auto__;
})()
;})(switch__27421__auto__,c__27442__auto__,map__32463,map__32463__$1,connection,design_doc,bootstrap_doc))
})();
var state__27444__auto__ = (function (){var statearr_32496 = f__27443__auto__.call(null);
(statearr_32496[cljs.core.async.impl.ioc_helpers.USER_START_IDX] = c__27442__auto__);

return statearr_32496;
})();
return cljs.core.async.impl.ioc_helpers.run_state_machine_wrapped.call(null,state__27444__auto__);
});})(c__27442__auto__,map__32463,map__32463__$1,connection,design_doc,bootstrap_doc))
);

return c__27442__auto__;
});
adapters.pouchdb.implementations.validatable.valid_QMARK__async = (function adapters$pouchdb$implementations$validatable$valid_QMARK__async(db){
var c__27442__auto__ = cljs.core.async.chan.call(null,(1));
cljs.core.async.impl.dispatch.run.call(null,((function (c__27442__auto__){
return (function (){
var f__27443__auto__ = (function (){var switch__27421__auto__ = ((function (c__27442__auto__){
return (function (state_32591){
var state_val_32592 = (state_32591[(1)]);
if((state_val_32592 === (7))){
var state_32591__$1 = state_32591;
var statearr_32593_32617 = state_32591__$1;
(statearr_32593_32617[(2)] = false);

(statearr_32593_32617[(1)] = (8));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_32592 === (1))){
var inst_32561 = adapters.pouchdb.implementations.validatable.errors_async.call(null,db);
var state_32591__$1 = state_32591;
return cljs.core.async.impl.ioc_helpers.take_BANG_.call(null,state_32591__$1,(2),inst_32561);
} else {
if((state_val_32592 === (4))){
var state_32591__$1 = state_32591;
var statearr_32594_32618 = state_32591__$1;
(statearr_32594_32618[(2)] = false);

(statearr_32594_32618[(1)] = (5));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_32592 === (13))){
var state_32591__$1 = state_32591;
var statearr_32595_32619 = state_32591__$1;
(statearr_32595_32619[(2)] = true);

(statearr_32595_32619[(1)] = (14));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_32592 === (6))){
var state_32591__$1 = state_32591;
var statearr_32596_32620 = state_32591__$1;
(statearr_32596_32620[(2)] = true);

(statearr_32596_32620[(1)] = (8));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_32592 === (3))){
var inst_32563 = (state_32591[(7)]);
var inst_32568 = inst_32563.cljs$lang$protocol_mask$partition0$;
var inst_32569 = (inst_32568 & (64));
var inst_32570 = inst_32563.cljs$core$ISeq$;
var inst_32571 = (inst_32569) || (inst_32570);
var state_32591__$1 = state_32591;
if(cljs.core.truth_(inst_32571)){
var statearr_32597_32621 = state_32591__$1;
(statearr_32597_32621[(1)] = (6));

} else {
var statearr_32598_32622 = state_32591__$1;
(statearr_32598_32622[(1)] = (7));

}

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_32592 === (12))){
var state_32591__$1 = state_32591;
var statearr_32599_32623 = state_32591__$1;
(statearr_32599_32623[(2)] = false);

(statearr_32599_32623[(1)] = (14));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_32592 === (2))){
var inst_32563 = (state_32591[(7)]);
var inst_32563__$1 = (state_32591[(2)]);
var inst_32565 = (inst_32563__$1 == null);
var inst_32566 = cljs.core.not.call(null,inst_32565);
var state_32591__$1 = (function (){var statearr_32600 = state_32591;
(statearr_32600[(7)] = inst_32563__$1);

return statearr_32600;
})();
if(inst_32566){
var statearr_32601_32624 = state_32591__$1;
(statearr_32601_32624[(1)] = (3));

} else {
var statearr_32602_32625 = state_32591__$1;
(statearr_32602_32625[(1)] = (4));

}

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_32592 === (11))){
var inst_32583 = (state_32591[(2)]);
var inst_32584 = cljs.core.get.call(null,inst_32583,new cljs.core.Keyword(null,"status","status",-1997798413));
var inst_32585 = cljs.core._EQ_.call(null,inst_32584,new cljs.core.Keyword(null,"error","error",-978969032));
var state_32591__$1 = state_32591;
if(inst_32585){
var statearr_32603_32626 = state_32591__$1;
(statearr_32603_32626[(1)] = (12));

} else {
var statearr_32604_32627 = state_32591__$1;
(statearr_32604_32627[(1)] = (13));

}

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_32592 === (9))){
var inst_32563 = (state_32591[(7)]);
var inst_32580 = cljs.core.apply.call(null,cljs.core.hash_map,inst_32563);
var state_32591__$1 = state_32591;
var statearr_32605_32628 = state_32591__$1;
(statearr_32605_32628[(2)] = inst_32580);

(statearr_32605_32628[(1)] = (11));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_32592 === (5))){
var inst_32578 = (state_32591[(2)]);
var state_32591__$1 = state_32591;
if(cljs.core.truth_(inst_32578)){
var statearr_32606_32629 = state_32591__$1;
(statearr_32606_32629[(1)] = (9));

} else {
var statearr_32607_32630 = state_32591__$1;
(statearr_32607_32630[(1)] = (10));

}

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_32592 === (14))){
var inst_32589 = (state_32591[(2)]);
var state_32591__$1 = state_32591;
return cljs.core.async.impl.ioc_helpers.return_chan.call(null,state_32591__$1,inst_32589);
} else {
if((state_val_32592 === (10))){
var inst_32563 = (state_32591[(7)]);
var state_32591__$1 = state_32591;
var statearr_32608_32631 = state_32591__$1;
(statearr_32608_32631[(2)] = inst_32563);

(statearr_32608_32631[(1)] = (11));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_32592 === (8))){
var inst_32575 = (state_32591[(2)]);
var state_32591__$1 = state_32591;
var statearr_32609_32632 = state_32591__$1;
(statearr_32609_32632[(2)] = inst_32575);

(statearr_32609_32632[(1)] = (5));


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
});})(c__27442__auto__))
;
return ((function (switch__27421__auto__,c__27442__auto__){
return (function() {
var adapters$pouchdb$implementations$validatable$valid_QMARK__async_$_state_machine__27422__auto__ = null;
var adapters$pouchdb$implementations$validatable$valid_QMARK__async_$_state_machine__27422__auto____0 = (function (){
var statearr_32613 = [null,null,null,null,null,null,null,null];
(statearr_32613[(0)] = adapters$pouchdb$implementations$validatable$valid_QMARK__async_$_state_machine__27422__auto__);

(statearr_32613[(1)] = (1));

return statearr_32613;
});
var adapters$pouchdb$implementations$validatable$valid_QMARK__async_$_state_machine__27422__auto____1 = (function (state_32591){
while(true){
var ret_value__27423__auto__ = (function (){try{while(true){
var result__27424__auto__ = switch__27421__auto__.call(null,state_32591);
if(cljs.core.keyword_identical_QMARK_.call(null,result__27424__auto__,new cljs.core.Keyword(null,"recur","recur",-437573268))){
continue;
} else {
return result__27424__auto__;
}
break;
}
}catch (e32614){if((e32614 instanceof Object)){
var ex__27425__auto__ = e32614;
var statearr_32615_32633 = state_32591;
(statearr_32615_32633[(5)] = ex__27425__auto__);


cljs.core.async.impl.ioc_helpers.process_exception.call(null,state_32591);

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
throw e32614;

}
}})();
if(cljs.core.keyword_identical_QMARK_.call(null,ret_value__27423__auto__,new cljs.core.Keyword(null,"recur","recur",-437573268))){
var G__32634 = state_32591;
state_32591 = G__32634;
continue;
} else {
return ret_value__27423__auto__;
}
break;
}
});
adapters$pouchdb$implementations$validatable$valid_QMARK__async_$_state_machine__27422__auto__ = function(state_32591){
switch(arguments.length){
case 0:
return adapters$pouchdb$implementations$validatable$valid_QMARK__async_$_state_machine__27422__auto____0.call(this);
case 1:
return adapters$pouchdb$implementations$validatable$valid_QMARK__async_$_state_machine__27422__auto____1.call(this,state_32591);
}
throw(new Error('Invalid arity: ' + arguments.length));
};
adapters$pouchdb$implementations$validatable$valid_QMARK__async_$_state_machine__27422__auto__.cljs$core$IFn$_invoke$arity$0 = adapters$pouchdb$implementations$validatable$valid_QMARK__async_$_state_machine__27422__auto____0;
adapters$pouchdb$implementations$validatable$valid_QMARK__async_$_state_machine__27422__auto__.cljs$core$IFn$_invoke$arity$1 = adapters$pouchdb$implementations$validatable$valid_QMARK__async_$_state_machine__27422__auto____1;
return adapters$pouchdb$implementations$validatable$valid_QMARK__async_$_state_machine__27422__auto__;
})()
;})(switch__27421__auto__,c__27442__auto__))
})();
var state__27444__auto__ = (function (){var statearr_32616 = f__27443__auto__.call(null);
(statearr_32616[cljs.core.async.impl.ioc_helpers.USER_START_IDX] = c__27442__auto__);

return statearr_32616;
})();
return cljs.core.async.impl.ioc_helpers.run_state_machine_wrapped.call(null,state__27444__auto__);
});})(c__27442__auto__))
);

return c__27442__auto__;
});

//# sourceMappingURL=validatable.js.map