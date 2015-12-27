// Compiled by ClojureScript 1.7.170 {}
goog.provide('adapters.pouchdb.implementations.bootstrappable');
goog.require('cljs.core');
goog.require('cljs.core.async');
goog.require('adapters.pouchdb.implementations.validatable');
goog.require('adapters.pouchdb.wrapper');
adapters.pouchdb.implementations.bootstrappable.bootstrap_data = (function adapters$pouchdb$implementations$bootstrappable$bootstrap_data(p__32639){
var map__32684 = p__32639;
var map__32684__$1 = ((((!((map__32684 == null)))?((((map__32684.cljs$lang$protocol_mask$partition0$ & (64))) || (map__32684.cljs$core$ISeq$))?true:false):false))?cljs.core.apply.call(null,cljs.core.hash_map,map__32684):map__32684);
var bootstrap_doc = cljs.core.get.call(null,map__32684__$1,new cljs.core.Keyword(null,"bootstrap-doc","bootstrap-doc",-908945544));
var design_doc = cljs.core.get.call(null,map__32684__$1,new cljs.core.Keyword(null,"design-doc","design-doc",-98897062));
var connection = cljs.core.get.call(null,map__32684__$1,new cljs.core.Keyword(null,"connection","connection",-123599300));
var c__27442__auto__ = cljs.core.async.chan.call(null,(1));
cljs.core.async.impl.dispatch.run.call(null,((function (c__27442__auto__,map__32684,map__32684__$1,bootstrap_doc,design_doc,connection){
return (function (){
var f__27443__auto__ = (function (){var switch__27421__auto__ = ((function (c__27442__auto__,map__32684,map__32684__$1,bootstrap_doc,design_doc,connection){
return (function (state_32711){
var state_val_32712 = (state_32711[(1)]);
if((state_val_32712 === (1))){
var inst_32686 = [new cljs.core.Keyword(null,"bootstrap-doc","bootstrap-doc",-908945544),new cljs.core.Keyword(null,"design-doc","design-doc",-98897062)];
var inst_32687 = adapters.pouchdb.wrapper.refresh_doc.call(null,connection,bootstrap_doc);
var state_32711__$1 = (function (){var statearr_32713 = state_32711;
(statearr_32713[(7)] = inst_32686);

return statearr_32713;
})();
return cljs.core.async.impl.ioc_helpers.take_BANG_.call(null,state_32711__$1,(2),inst_32687);
} else {
if((state_val_32712 === (2))){
var inst_32689 = (state_32711[(2)]);
var inst_32690 = adapters.pouchdb.wrapper.refresh_doc.call(null,connection,design_doc);
var state_32711__$1 = (function (){var statearr_32714 = state_32711;
(statearr_32714[(8)] = inst_32689);

return statearr_32714;
})();
return cljs.core.async.impl.ioc_helpers.take_BANG_.call(null,state_32711__$1,(3),inst_32690);
} else {
if((state_val_32712 === (3))){
var inst_32686 = (state_32711[(7)]);
var inst_32689 = (state_32711[(8)]);
var inst_32698 = (state_32711[(9)]);
var inst_32692 = (state_32711[(2)]);
var inst_32693 = [inst_32689,inst_32692];
var inst_32694 = cljs.core.PersistentHashMap.fromArrays(inst_32686,inst_32693);
var inst_32696 = (function (){var bootstrap_data__$1 = inst_32694;
return ((function (bootstrap_data__$1,inst_32686,inst_32689,inst_32698,inst_32692,inst_32693,inst_32694,state_val_32712,c__27442__auto__,map__32684,map__32684__$1,bootstrap_doc,design_doc,connection){
return (function (acc,p__32695){
var vec__32715 = p__32695;
var k = cljs.core.nth.call(null,vec__32715,(0),null);
var v = cljs.core.nth.call(null,vec__32715,(1),null);
if(cljs.core.truth_(v)){
return null;
} else {
return cljs.core.conj.call(null,acc,k);
}
});
;})(bootstrap_data__$1,inst_32686,inst_32689,inst_32698,inst_32692,inst_32693,inst_32694,state_val_32712,c__27442__auto__,map__32684,map__32684__$1,bootstrap_doc,design_doc,connection))
})();
var inst_32697 = cljs.core.PersistentVector.EMPTY;
var inst_32698__$1 = cljs.core.reduce.call(null,inst_32696,inst_32697,inst_32694);
var inst_32699 = cljs.core.empty_QMARK_.call(null,inst_32698__$1);
var state_32711__$1 = (function (){var statearr_32716 = state_32711;
(statearr_32716[(9)] = inst_32698__$1);

return statearr_32716;
})();
if(inst_32699){
var statearr_32717_32728 = state_32711__$1;
(statearr_32717_32728[(1)] = (4));

} else {
var statearr_32718_32729 = state_32711__$1;
(statearr_32718_32729[(1)] = (5));

}

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_32712 === (4))){
var inst_32701 = [new cljs.core.Keyword(null,"status","status",-1997798413)];
var inst_32702 = [new cljs.core.Keyword(null,"db-bootstrapped","db-bootstrapped",-1309822246)];
var inst_32703 = cljs.core.PersistentHashMap.fromArrays(inst_32701,inst_32702);
var state_32711__$1 = state_32711;
var statearr_32719_32730 = state_32711__$1;
(statearr_32719_32730[(2)] = inst_32703);

(statearr_32719_32730[(1)] = (6));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_32712 === (5))){
var inst_32698 = (state_32711[(9)]);
var inst_32705 = [new cljs.core.Keyword(null,"status","status",-1997798413),new cljs.core.Keyword(null,"error","error",-978969032),new cljs.core.Keyword(null,"missing-data","missing-data",1386207722)];
var inst_32706 = [new cljs.core.Keyword(null,"error","error",-978969032),new cljs.core.Keyword(null,"missing-data","missing-data",1386207722),inst_32698];
var inst_32707 = cljs.core.PersistentHashMap.fromArrays(inst_32705,inst_32706);
var state_32711__$1 = state_32711;
var statearr_32720_32731 = state_32711__$1;
(statearr_32720_32731[(2)] = inst_32707);

(statearr_32720_32731[(1)] = (6));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_32712 === (6))){
var inst_32709 = (state_32711[(2)]);
var state_32711__$1 = state_32711;
return cljs.core.async.impl.ioc_helpers.return_chan.call(null,state_32711__$1,inst_32709);
} else {
return null;
}
}
}
}
}
}
});})(c__27442__auto__,map__32684,map__32684__$1,bootstrap_doc,design_doc,connection))
;
return ((function (switch__27421__auto__,c__27442__auto__,map__32684,map__32684__$1,bootstrap_doc,design_doc,connection){
return (function() {
var adapters$pouchdb$implementations$bootstrappable$bootstrap_data_$_state_machine__27422__auto__ = null;
var adapters$pouchdb$implementations$bootstrappable$bootstrap_data_$_state_machine__27422__auto____0 = (function (){
var statearr_32724 = [null,null,null,null,null,null,null,null,null,null];
(statearr_32724[(0)] = adapters$pouchdb$implementations$bootstrappable$bootstrap_data_$_state_machine__27422__auto__);

(statearr_32724[(1)] = (1));

return statearr_32724;
});
var adapters$pouchdb$implementations$bootstrappable$bootstrap_data_$_state_machine__27422__auto____1 = (function (state_32711){
while(true){
var ret_value__27423__auto__ = (function (){try{while(true){
var result__27424__auto__ = switch__27421__auto__.call(null,state_32711);
if(cljs.core.keyword_identical_QMARK_.call(null,result__27424__auto__,new cljs.core.Keyword(null,"recur","recur",-437573268))){
continue;
} else {
return result__27424__auto__;
}
break;
}
}catch (e32725){if((e32725 instanceof Object)){
var ex__27425__auto__ = e32725;
var statearr_32726_32732 = state_32711;
(statearr_32726_32732[(5)] = ex__27425__auto__);


cljs.core.async.impl.ioc_helpers.process_exception.call(null,state_32711);

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
throw e32725;

}
}})();
if(cljs.core.keyword_identical_QMARK_.call(null,ret_value__27423__auto__,new cljs.core.Keyword(null,"recur","recur",-437573268))){
var G__32733 = state_32711;
state_32711 = G__32733;
continue;
} else {
return ret_value__27423__auto__;
}
break;
}
});
adapters$pouchdb$implementations$bootstrappable$bootstrap_data_$_state_machine__27422__auto__ = function(state_32711){
switch(arguments.length){
case 0:
return adapters$pouchdb$implementations$bootstrappable$bootstrap_data_$_state_machine__27422__auto____0.call(this);
case 1:
return adapters$pouchdb$implementations$bootstrappable$bootstrap_data_$_state_machine__27422__auto____1.call(this,state_32711);
}
throw(new Error('Invalid arity: ' + arguments.length));
};
adapters$pouchdb$implementations$bootstrappable$bootstrap_data_$_state_machine__27422__auto__.cljs$core$IFn$_invoke$arity$0 = adapters$pouchdb$implementations$bootstrappable$bootstrap_data_$_state_machine__27422__auto____0;
adapters$pouchdb$implementations$bootstrappable$bootstrap_data_$_state_machine__27422__auto__.cljs$core$IFn$_invoke$arity$1 = adapters$pouchdb$implementations$bootstrappable$bootstrap_data_$_state_machine__27422__auto____1;
return adapters$pouchdb$implementations$bootstrappable$bootstrap_data_$_state_machine__27422__auto__;
})()
;})(switch__27421__auto__,c__27442__auto__,map__32684,map__32684__$1,bootstrap_doc,design_doc,connection))
})();
var state__27444__auto__ = (function (){var statearr_32727 = f__27443__auto__.call(null);
(statearr_32727[cljs.core.async.impl.ioc_helpers.USER_START_IDX] = c__27442__auto__);

return statearr_32727;
})();
return cljs.core.async.impl.ioc_helpers.run_state_machine_wrapped.call(null,state__27444__auto__);
});})(c__27442__auto__,map__32684,map__32684__$1,bootstrap_doc,design_doc,connection))
);

return c__27442__auto__;
});
adapters.pouchdb.implementations.bootstrappable.bootstrap = (function adapters$pouchdb$implementations$bootstrappable$bootstrap(db){
var c__27442__auto__ = cljs.core.async.chan.call(null,(1));
cljs.core.async.impl.dispatch.run.call(null,((function (c__27442__auto__){
return (function (){
var f__27443__auto__ = (function (){var switch__27421__auto__ = ((function (c__27442__auto__){
return (function (state_32771){
var state_val_32772 = (state_32771[(1)]);
if((state_val_32772 === (1))){
var inst_32759 = adapters.pouchdb.implementations.validatable.valid_QMARK__async.call(null,db);
var state_32771__$1 = state_32771;
return cljs.core.async.impl.ioc_helpers.take_BANG_.call(null,state_32771__$1,(2),inst_32759);
} else {
if((state_val_32772 === (2))){
var inst_32761 = (state_32771[(2)]);
var inst_32762 = cljs.core.not.call(null,inst_32761);
var state_32771__$1 = state_32771;
if(inst_32762){
var statearr_32773_32784 = state_32771__$1;
(statearr_32773_32784[(1)] = (3));

} else {
var statearr_32774_32785 = state_32771__$1;
(statearr_32774_32785[(1)] = (4));

}

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_32772 === (3))){
var inst_32764 = adapters.pouchdb.implementations.bootstrappable.bootstrap_data.call(null,db);
var state_32771__$1 = state_32771;
return cljs.core.async.impl.ioc_helpers.take_BANG_.call(null,state_32771__$1,(6),inst_32764);
} else {
if((state_val_32772 === (4))){
var state_32771__$1 = state_32771;
var statearr_32775_32786 = state_32771__$1;
(statearr_32775_32786[(2)] = true);

(statearr_32775_32786[(1)] = (5));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_32772 === (5))){
var inst_32769 = (state_32771[(2)]);
var state_32771__$1 = state_32771;
return cljs.core.async.impl.ioc_helpers.return_chan.call(null,state_32771__$1,inst_32769);
} else {
if((state_val_32772 === (6))){
var inst_32766 = (state_32771[(2)]);
var state_32771__$1 = state_32771;
var statearr_32776_32787 = state_32771__$1;
(statearr_32776_32787[(2)] = inst_32766);

(statearr_32776_32787[(1)] = (5));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
return null;
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
var adapters$pouchdb$implementations$bootstrappable$bootstrap_$_state_machine__27422__auto__ = null;
var adapters$pouchdb$implementations$bootstrappable$bootstrap_$_state_machine__27422__auto____0 = (function (){
var statearr_32780 = [null,null,null,null,null,null,null];
(statearr_32780[(0)] = adapters$pouchdb$implementations$bootstrappable$bootstrap_$_state_machine__27422__auto__);

(statearr_32780[(1)] = (1));

return statearr_32780;
});
var adapters$pouchdb$implementations$bootstrappable$bootstrap_$_state_machine__27422__auto____1 = (function (state_32771){
while(true){
var ret_value__27423__auto__ = (function (){try{while(true){
var result__27424__auto__ = switch__27421__auto__.call(null,state_32771);
if(cljs.core.keyword_identical_QMARK_.call(null,result__27424__auto__,new cljs.core.Keyword(null,"recur","recur",-437573268))){
continue;
} else {
return result__27424__auto__;
}
break;
}
}catch (e32781){if((e32781 instanceof Object)){
var ex__27425__auto__ = e32781;
var statearr_32782_32788 = state_32771;
(statearr_32782_32788[(5)] = ex__27425__auto__);


cljs.core.async.impl.ioc_helpers.process_exception.call(null,state_32771);

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
throw e32781;

}
}})();
if(cljs.core.keyword_identical_QMARK_.call(null,ret_value__27423__auto__,new cljs.core.Keyword(null,"recur","recur",-437573268))){
var G__32789 = state_32771;
state_32771 = G__32789;
continue;
} else {
return ret_value__27423__auto__;
}
break;
}
});
adapters$pouchdb$implementations$bootstrappable$bootstrap_$_state_machine__27422__auto__ = function(state_32771){
switch(arguments.length){
case 0:
return adapters$pouchdb$implementations$bootstrappable$bootstrap_$_state_machine__27422__auto____0.call(this);
case 1:
return adapters$pouchdb$implementations$bootstrappable$bootstrap_$_state_machine__27422__auto____1.call(this,state_32771);
}
throw(new Error('Invalid arity: ' + arguments.length));
};
adapters$pouchdb$implementations$bootstrappable$bootstrap_$_state_machine__27422__auto__.cljs$core$IFn$_invoke$arity$0 = adapters$pouchdb$implementations$bootstrappable$bootstrap_$_state_machine__27422__auto____0;
adapters$pouchdb$implementations$bootstrappable$bootstrap_$_state_machine__27422__auto__.cljs$core$IFn$_invoke$arity$1 = adapters$pouchdb$implementations$bootstrappable$bootstrap_$_state_machine__27422__auto____1;
return adapters$pouchdb$implementations$bootstrappable$bootstrap_$_state_machine__27422__auto__;
})()
;})(switch__27421__auto__,c__27442__auto__))
})();
var state__27444__auto__ = (function (){var statearr_32783 = f__27443__auto__.call(null);
(statearr_32783[cljs.core.async.impl.ioc_helpers.USER_START_IDX] = c__27442__auto__);

return statearr_32783;
})();
return cljs.core.async.impl.ioc_helpers.run_state_machine_wrapped.call(null,state__27444__auto__);
});})(c__27442__auto__))
);

return c__27442__auto__;
});

//# sourceMappingURL=bootstrappable.js.map