// Compiled by ClojureScript 1.7.170 {}
goog.provide('adapters.pouchdb.wrapper');
goog.require('cljs.core');
goog.require('cljs.core.async');
goog.require('cljsjs.pouchdb');
goog.require('cljs.core.match');
goog.require('clojure.set');
goog.require('offcourse.helpers.interop');
adapters.pouchdb.wrapper.get_db_doc_id = (function adapters$pouchdb$wrapper$get_db_doc_id(doc){
return new cljs.core.Keyword(null,"_id","_id",-789960287).cljs$core$IFn$_invoke$arity$1(offcourse.helpers.interop.jsx__GT_clj.call(null,doc));
});
adapters.pouchdb.wrapper.init = (function adapters$pouchdb$wrapper$init(name){
return (new PouchDB(name));
});
adapters.pouchdb.wrapper.info = (function adapters$pouchdb$wrapper$info(pouch){
return offcourse.helpers.interop.handle_js_response.call(null,pouch.info());
});
adapters.pouchdb.wrapper.fetch_doc = (function adapters$pouchdb$wrapper$fetch_doc(pouch,key){
return offcourse.helpers.interop.handle_js_response.call(null,pouch.get(key));
});
adapters.pouchdb.wrapper.fetch_docs = (function adapters$pouchdb$wrapper$fetch_docs(var_args){
var args37963 = [];
var len__26139__auto___37966 = arguments.length;
var i__26140__auto___37967 = (0);
while(true){
if((i__26140__auto___37967 < len__26139__auto___37966)){
args37963.push((arguments[i__26140__auto___37967]));

var G__37968 = (i__26140__auto___37967 + (1));
i__26140__auto___37967 = G__37968;
continue;
} else {
}
break;
}

var G__37965 = args37963.length;
switch (G__37965) {
case 2:
return adapters.pouchdb.wrapper.fetch_docs.cljs$core$IFn$_invoke$arity$2((arguments[(0)]),(arguments[(1)]));

break;
case 3:
return adapters.pouchdb.wrapper.fetch_docs.cljs$core$IFn$_invoke$arity$3((arguments[(0)]),(arguments[(1)]),(arguments[(2)]));

break;
default:
throw (new Error([cljs.core.str("Invalid arity: "),cljs.core.str(args37963.length)].join('')));

}
});

adapters.pouchdb.wrapper.fetch_docs.cljs$core$IFn$_invoke$arity$2 = (function (pouch,include_docs){
var options = new cljs.core.PersistentArrayMap(null, 1, ["include_docs",include_docs], null);
return offcourse.helpers.interop.handle_js_response.call(null,pouch.allDocs(cljs.core.clj__GT_js.call(null,options)),new cljs.core.Keyword(null,"rows","rows",850049680));
});

adapters.pouchdb.wrapper.fetch_docs.cljs$core$IFn$_invoke$arity$3 = (function (pouch,keys,include_docs){
var options = new cljs.core.PersistentArrayMap(null, 2, [new cljs.core.Keyword(null,"keys","keys",1068423698),keys,"include_docs",include_docs], null);
return offcourse.helpers.interop.handle_js_response.call(null,pouch.allDocs(cljs.core.clj__GT_js.call(null,options)),new cljs.core.Keyword(null,"rows","rows",850049680));
});

adapters.pouchdb.wrapper.fetch_docs.cljs$lang$maxFixedArity = 3;
adapters.pouchdb.wrapper.refresh_doc = (function adapters$pouchdb$wrapper$refresh_doc(pouch,doc){
return offcourse.helpers.interop.handle_js_response.call(null,pouch.put(doc));
});
adapters.pouchdb.wrapper.fetch = (function adapters$pouchdb$wrapper$fetch(pouch,opts){
cljs.core.println.call(null,opts);

try{if(((!((opts == null)))?((((opts.cljs$lang$protocol_mask$partition0$ & (256))) || (opts.cljs$core$ILookup$))?true:(((!opts.cljs$lang$protocol_mask$partition0$))?cljs.core.native_satisfies_QMARK_.call(null,cljs.core.ILookup,opts):false)):cljs.core.native_satisfies_QMARK_.call(null,cljs.core.ILookup,opts))){
try{var opts_key__37990 = cljs.core.get.call(null,opts,new cljs.core.Keyword(null,"key","key",-1516042587),new cljs.core.Keyword("clojure.core.match","not-found","clojure.core.match/not-found",1553053780));
if(cljs.core.not_EQ_.call(null,opts_key__37990,new cljs.core.Keyword("clojure.core.match","not-found","clojure.core.match/not-found",1553053780))){
var key = cljs.core.get.call(null,opts,new cljs.core.Keyword(null,"key","key",-1516042587));
return adapters.pouchdb.wrapper.fetch_doc.call(null,pouch,key);
} else {
throw cljs.core.match.backtrack;

}
}catch (e37994){if((e37994 instanceof Error)){
var e__31146__auto__ = e37994;
if((e__31146__auto__ === cljs.core.match.backtrack)){
try{var opts_include_docs__37989 = cljs.core.get.call(null,opts,new cljs.core.Keyword(null,"include-docs","include-docs",637176099),new cljs.core.Keyword("clojure.core.match","not-found","clojure.core.match/not-found",1553053780));
if(cljs.core.not_EQ_.call(null,opts_include_docs__37989,new cljs.core.Keyword("clojure.core.match","not-found","clojure.core.match/not-found",1553053780))){
try{var opts_keys__37991 = cljs.core.get.call(null,opts,new cljs.core.Keyword(null,"keys","keys",1068423698),new cljs.core.Keyword("clojure.core.match","not-found","clojure.core.match/not-found",1553053780));
if(cljs.core.not_EQ_.call(null,opts_keys__37991,new cljs.core.Keyword("clojure.core.match","not-found","clojure.core.match/not-found",1553053780))){
var keys = cljs.core.get.call(null,opts,new cljs.core.Keyword(null,"keys","keys",1068423698));
var incd = cljs.core.get.call(null,opts,new cljs.core.Keyword(null,"include-docs","include-docs",637176099));
return adapters.pouchdb.wrapper.fetch_docs.call(null,pouch,keys,incd);
} else {
throw cljs.core.match.backtrack;

}
}catch (e37997){if((e37997 instanceof Error)){
var e__31146__auto____$1 = e37997;
if((e__31146__auto____$1 === cljs.core.match.backtrack)){
throw cljs.core.match.backtrack;
} else {
throw e__31146__auto____$1;
}
} else {
throw e37997;

}
}} else {
throw cljs.core.match.backtrack;

}
}catch (e37995){if((e37995 instanceof Error)){
var e__31146__auto____$1 = e37995;
if((e__31146__auto____$1 === cljs.core.match.backtrack)){
try{var opts_keys__37991 = cljs.core.get.call(null,opts,new cljs.core.Keyword(null,"keys","keys",1068423698),new cljs.core.Keyword("clojure.core.match","not-found","clojure.core.match/not-found",1553053780));
if(cljs.core.not_EQ_.call(null,opts_keys__37991,new cljs.core.Keyword("clojure.core.match","not-found","clojure.core.match/not-found",1553053780))){
var keys = cljs.core.get.call(null,opts,new cljs.core.Keyword(null,"keys","keys",1068423698));
return adapters.pouchdb.wrapper.fetch_docs.call(null,pouch,keys,true);
} else {
throw cljs.core.match.backtrack;

}
}catch (e37996){if((e37996 instanceof Error)){
var e__31146__auto____$2 = e37996;
if((e__31146__auto____$2 === cljs.core.match.backtrack)){
throw cljs.core.match.backtrack;
} else {
throw e__31146__auto____$2;
}
} else {
throw e37996;

}
}} else {
throw e__31146__auto____$1;
}
} else {
throw e37995;

}
}} else {
throw e__31146__auto__;
}
} else {
throw e37994;

}
}} else {
throw cljs.core.match.backtrack;

}
}catch (e37992){if((e37992 instanceof Error)){
var e__31146__auto__ = e37992;
if((e__31146__auto__ === cljs.core.match.backtrack)){
throw (new Error([cljs.core.str("No matching clause: "),cljs.core.str(opts)].join('')));
} else {
throw e__31146__auto__;
}
} else {
throw e37992;

}
}});
adapters.pouchdb.wrapper.has_doc_QMARK_ = (function adapters$pouchdb$wrapper$has_doc_QMARK_(pouch,doc){
var c__27442__auto__ = cljs.core.async.chan.call(null,(1));
cljs.core.async.impl.dispatch.run.call(null,((function (c__27442__auto__){
return (function (){
var f__27443__auto__ = (function (){var switch__27421__auto__ = ((function (c__27442__auto__){
return (function (state_38031){
var state_val_38032 = (state_38031[(1)]);
if((state_val_38032 === (1))){
var inst_38021 = adapters.pouchdb.wrapper.get_db_doc_id.call(null,doc);
var inst_38022 = adapters.pouchdb.wrapper.fetch_doc.call(null,pouch,inst_38021);
var state_38031__$1 = state_38031;
return cljs.core.async.impl.ioc_helpers.take_BANG_.call(null,state_38031__$1,(2),inst_38022);
} else {
if((state_val_38032 === (2))){
var inst_38024 = (state_38031[(2)]);
var inst_38025 = new cljs.core.Keyword(null,"error","error",-978969032).cljs$core$IFn$_invoke$arity$1(inst_38024);
var state_38031__$1 = state_38031;
if(cljs.core.truth_(inst_38025)){
var statearr_38033_38044 = state_38031__$1;
(statearr_38033_38044[(1)] = (3));

} else {
var statearr_38034_38045 = state_38031__$1;
(statearr_38034_38045[(1)] = (4));

}

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_38032 === (3))){
var state_38031__$1 = state_38031;
var statearr_38035_38046 = state_38031__$1;
(statearr_38035_38046[(2)] = false);

(statearr_38035_38046[(1)] = (5));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_38032 === (4))){
var state_38031__$1 = state_38031;
var statearr_38036_38047 = state_38031__$1;
(statearr_38036_38047[(2)] = true);

(statearr_38036_38047[(1)] = (5));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_38032 === (5))){
var inst_38029 = (state_38031[(2)]);
var state_38031__$1 = state_38031;
return cljs.core.async.impl.ioc_helpers.return_chan.call(null,state_38031__$1,inst_38029);
} else {
return null;
}
}
}
}
}
});})(c__27442__auto__))
;
return ((function (switch__27421__auto__,c__27442__auto__){
return (function() {
var adapters$pouchdb$wrapper$has_doc_QMARK__$_state_machine__27422__auto__ = null;
var adapters$pouchdb$wrapper$has_doc_QMARK__$_state_machine__27422__auto____0 = (function (){
var statearr_38040 = [null,null,null,null,null,null,null];
(statearr_38040[(0)] = adapters$pouchdb$wrapper$has_doc_QMARK__$_state_machine__27422__auto__);

(statearr_38040[(1)] = (1));

return statearr_38040;
});
var adapters$pouchdb$wrapper$has_doc_QMARK__$_state_machine__27422__auto____1 = (function (state_38031){
while(true){
var ret_value__27423__auto__ = (function (){try{while(true){
var result__27424__auto__ = switch__27421__auto__.call(null,state_38031);
if(cljs.core.keyword_identical_QMARK_.call(null,result__27424__auto__,new cljs.core.Keyword(null,"recur","recur",-437573268))){
continue;
} else {
return result__27424__auto__;
}
break;
}
}catch (e38041){if((e38041 instanceof Object)){
var ex__27425__auto__ = e38041;
var statearr_38042_38048 = state_38031;
(statearr_38042_38048[(5)] = ex__27425__auto__);


cljs.core.async.impl.ioc_helpers.process_exception.call(null,state_38031);

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
throw e38041;

}
}})();
if(cljs.core.keyword_identical_QMARK_.call(null,ret_value__27423__auto__,new cljs.core.Keyword(null,"recur","recur",-437573268))){
var G__38049 = state_38031;
state_38031 = G__38049;
continue;
} else {
return ret_value__27423__auto__;
}
break;
}
});
adapters$pouchdb$wrapper$has_doc_QMARK__$_state_machine__27422__auto__ = function(state_38031){
switch(arguments.length){
case 0:
return adapters$pouchdb$wrapper$has_doc_QMARK__$_state_machine__27422__auto____0.call(this);
case 1:
return adapters$pouchdb$wrapper$has_doc_QMARK__$_state_machine__27422__auto____1.call(this,state_38031);
}
throw(new Error('Invalid arity: ' + arguments.length));
};
adapters$pouchdb$wrapper$has_doc_QMARK__$_state_machine__27422__auto__.cljs$core$IFn$_invoke$arity$0 = adapters$pouchdb$wrapper$has_doc_QMARK__$_state_machine__27422__auto____0;
adapters$pouchdb$wrapper$has_doc_QMARK__$_state_machine__27422__auto__.cljs$core$IFn$_invoke$arity$1 = adapters$pouchdb$wrapper$has_doc_QMARK__$_state_machine__27422__auto____1;
return adapters$pouchdb$wrapper$has_doc_QMARK__$_state_machine__27422__auto__;
})()
;})(switch__27421__auto__,c__27442__auto__))
})();
var state__27444__auto__ = (function (){var statearr_38043 = f__27443__auto__.call(null);
(statearr_38043[cljs.core.async.impl.ioc_helpers.USER_START_IDX] = c__27442__auto__);

return statearr_38043;
})();
return cljs.core.async.impl.ioc_helpers.run_state_machine_wrapped.call(null,state__27444__auto__);
});})(c__27442__auto__))
);

return c__27442__auto__;
});
adapters.pouchdb.wrapper.missing_docs = (function adapters$pouchdb$wrapper$missing_docs(pouch,docs){
var c__27442__auto__ = cljs.core.async.chan.call(null,(1));
cljs.core.async.impl.dispatch.run.call(null,((function (c__27442__auto__){
return (function (){
var f__27443__auto__ = (function (){var switch__27421__auto__ = ((function (c__27442__auto__){
return (function (state_38088){
var state_val_38089 = (state_38088[(1)]);
if((state_val_38089 === (1))){
var inst_38076 = (state_38088[(7)]);
var inst_38074 = cljs.core.PersistentHashSet.EMPTY;
var inst_38075 = cljs.core.map.call(null,adapters.pouchdb.wrapper.get_db_doc_id,docs);
var inst_38076__$1 = cljs.core.into.call(null,inst_38074,inst_38075);
var inst_38077 = [new cljs.core.Keyword(null,"keys","keys",1068423698),new cljs.core.Keyword(null,"include-docs","include-docs",637176099)];
var inst_38078 = [inst_38076__$1,false];
var inst_38079 = cljs.core.PersistentHashMap.fromArrays(inst_38077,inst_38078);
var inst_38080 = adapters.pouchdb.wrapper.fetch.call(null,pouch,inst_38079);
var state_38088__$1 = (function (){var statearr_38090 = state_38088;
(statearr_38090[(7)] = inst_38076__$1);

return statearr_38090;
})();
return cljs.core.async.impl.ioc_helpers.take_BANG_.call(null,state_38088__$1,(2),inst_38080);
} else {
if((state_val_38089 === (2))){
var inst_38076 = (state_38088[(7)]);
var inst_38082 = (state_38088[(2)]);
var inst_38083 = (function (){var expected_doc_ids = inst_38076;
var docs__$1 = inst_38082;
return ((function (expected_doc_ids,docs__$1,inst_38076,inst_38082,state_val_38089,c__27442__auto__){
return (function (doc){
return cljs.core.get_in.call(null,doc,new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Keyword(null,"value","value",305978217),new cljs.core.Keyword(null,"deleted","deleted",-510100639)], null));
});
;})(expected_doc_ids,docs__$1,inst_38076,inst_38082,state_val_38089,c__27442__auto__))
})();
var inst_38084 = cljs.core.remove.call(null,inst_38083,inst_38082);
var inst_38085 = cljs.core.map.call(null,new cljs.core.Keyword(null,"id","id",-1388402092),inst_38084);
var inst_38086 = clojure.set.difference.call(null,inst_38076,inst_38085);
var state_38088__$1 = state_38088;
return cljs.core.async.impl.ioc_helpers.return_chan.call(null,state_38088__$1,inst_38086);
} else {
return null;
}
}
});})(c__27442__auto__))
;
return ((function (switch__27421__auto__,c__27442__auto__){
return (function() {
var adapters$pouchdb$wrapper$missing_docs_$_state_machine__27422__auto__ = null;
var adapters$pouchdb$wrapper$missing_docs_$_state_machine__27422__auto____0 = (function (){
var statearr_38094 = [null,null,null,null,null,null,null,null];
(statearr_38094[(0)] = adapters$pouchdb$wrapper$missing_docs_$_state_machine__27422__auto__);

(statearr_38094[(1)] = (1));

return statearr_38094;
});
var adapters$pouchdb$wrapper$missing_docs_$_state_machine__27422__auto____1 = (function (state_38088){
while(true){
var ret_value__27423__auto__ = (function (){try{while(true){
var result__27424__auto__ = switch__27421__auto__.call(null,state_38088);
if(cljs.core.keyword_identical_QMARK_.call(null,result__27424__auto__,new cljs.core.Keyword(null,"recur","recur",-437573268))){
continue;
} else {
return result__27424__auto__;
}
break;
}
}catch (e38095){if((e38095 instanceof Object)){
var ex__27425__auto__ = e38095;
var statearr_38096_38098 = state_38088;
(statearr_38096_38098[(5)] = ex__27425__auto__);


cljs.core.async.impl.ioc_helpers.process_exception.call(null,state_38088);

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
throw e38095;

}
}})();
if(cljs.core.keyword_identical_QMARK_.call(null,ret_value__27423__auto__,new cljs.core.Keyword(null,"recur","recur",-437573268))){
var G__38099 = state_38088;
state_38088 = G__38099;
continue;
} else {
return ret_value__27423__auto__;
}
break;
}
});
adapters$pouchdb$wrapper$missing_docs_$_state_machine__27422__auto__ = function(state_38088){
switch(arguments.length){
case 0:
return adapters$pouchdb$wrapper$missing_docs_$_state_machine__27422__auto____0.call(this);
case 1:
return adapters$pouchdb$wrapper$missing_docs_$_state_machine__27422__auto____1.call(this,state_38088);
}
throw(new Error('Invalid arity: ' + arguments.length));
};
adapters$pouchdb$wrapper$missing_docs_$_state_machine__27422__auto__.cljs$core$IFn$_invoke$arity$0 = adapters$pouchdb$wrapper$missing_docs_$_state_machine__27422__auto____0;
adapters$pouchdb$wrapper$missing_docs_$_state_machine__27422__auto__.cljs$core$IFn$_invoke$arity$1 = adapters$pouchdb$wrapper$missing_docs_$_state_machine__27422__auto____1;
return adapters$pouchdb$wrapper$missing_docs_$_state_machine__27422__auto__;
})()
;})(switch__27421__auto__,c__27442__auto__))
})();
var state__27444__auto__ = (function (){var statearr_38097 = f__27443__auto__.call(null);
(statearr_38097[cljs.core.async.impl.ioc_helpers.USER_START_IDX] = c__27442__auto__);

return statearr_38097;
})();
return cljs.core.async.impl.ioc_helpers.run_state_machine_wrapped.call(null,state__27444__auto__);
});})(c__27442__auto__))
);

return c__27442__auto__;
});

//# sourceMappingURL=wrapper.js.map