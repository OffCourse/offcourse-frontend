// Compiled by ClojureScript 1.7.170 {}
goog.provide('offcourse.adapters.pouchdb.wrapper');
goog.require('cljs.core');
goog.require('cljs.core.async');
goog.require('cljsjs.pouchdb');
goog.require('cljs.core.match');
goog.require('clojure.set');
goog.require('offcourse.helpers.interop');
offcourse.adapters.pouchdb.wrapper.get_db_doc_id = (function offcourse$adapters$pouchdb$wrapper$get_db_doc_id(doc){
return new cljs.core.Keyword(null,"_id","_id",-789960287).cljs$core$IFn$_invoke$arity$1(offcourse.helpers.interop.jsx__GT_clj.call(null,doc));
});
offcourse.adapters.pouchdb.wrapper.init = (function offcourse$adapters$pouchdb$wrapper$init(name){
return (new PouchDB(name));
});
offcourse.adapters.pouchdb.wrapper.info = (function offcourse$adapters$pouchdb$wrapper$info(pouch){
return offcourse.helpers.interop.handle_js_response.call(null,pouch.info());
});
offcourse.adapters.pouchdb.wrapper.fetch_docs = (function offcourse$adapters$pouchdb$wrapper$fetch_docs(pouch,keys,include_docs){
return offcourse.helpers.interop.handle_js_response.call(null,pouch.allDocs(cljs.core.clj__GT_js.call(null,new cljs.core.PersistentArrayMap(null, 2, [new cljs.core.Keyword(null,"keys","keys",1068423698),keys,new cljs.core.Keyword(null,"include_docs","include_docs",-65447201),include_docs], null))));
});
offcourse.adapters.pouchdb.wrapper.fetch = (function offcourse$adapters$pouchdb$wrapper$fetch(var_args){
var args__26146__auto__ = [];
var len__26139__auto___32737 = arguments.length;
var i__26140__auto___32738 = (0);
while(true){
if((i__26140__auto___32738 < len__26139__auto___32737)){
args__26146__auto__.push((arguments[i__26140__auto___32738]));

var G__32739 = (i__26140__auto___32738 + (1));
i__26140__auto___32738 = G__32739;
continue;
} else {
}
break;
}

var argseq__26147__auto__ = ((((1) < args__26146__auto__.length))?(new cljs.core.IndexedSeq(args__26146__auto__.slice((1)),(0))):null);
return offcourse.adapters.pouchdb.wrapper.fetch.cljs$core$IFn$_invoke$arity$variadic((arguments[(0)]),argseq__26147__auto__);
});

offcourse.adapters.pouchdb.wrapper.fetch.cljs$core$IFn$_invoke$arity$variadic = (function (pouch,opts){
var opts__$1 = cljs.core.apply.call(null,cljs.core.hash_map,opts);
try{if(((!((opts__$1 == null)))?((((opts__$1.cljs$lang$protocol_mask$partition0$ & (256))) || (opts__$1.cljs$core$ILookup$))?true:(((!opts__$1.cljs$lang$protocol_mask$partition0$))?cljs.core.native_satisfies_QMARK_.call(null,cljs.core.ILookup,opts__$1):false)):cljs.core.native_satisfies_QMARK_.call(null,cljs.core.ILookup,opts__$1))){
try{var opts_key__32729 = cljs.core.get.call(null,opts__$1,new cljs.core.Keyword(null,"key","key",-1516042587),new cljs.core.Keyword("clojure.core.match","not-found","clojure.core.match/not-found",1553053780));
if(cljs.core.not_EQ_.call(null,opts_key__32729,new cljs.core.Keyword("clojure.core.match","not-found","clojure.core.match/not-found",1553053780))){
var doc_id = cljs.core.get.call(null,opts__$1,new cljs.core.Keyword(null,"key","key",-1516042587));
return offcourse.helpers.interop.handle_js_response.call(null,pouch.get(doc_id));
} else {
throw cljs.core.match.backtrack;

}
}catch (e32733){if((e32733 instanceof Error)){
var e__31130__auto__ = e32733;
if((e__31130__auto__ === cljs.core.match.backtrack)){
try{var opts_include_docs__32728 = cljs.core.get.call(null,opts__$1,new cljs.core.Keyword(null,"include-docs","include-docs",637176099),new cljs.core.Keyword("clojure.core.match","not-found","clojure.core.match/not-found",1553053780));
if(cljs.core.not_EQ_.call(null,opts_include_docs__32728,new cljs.core.Keyword("clojure.core.match","not-found","clojure.core.match/not-found",1553053780))){
try{var opts_keys__32730 = cljs.core.get.call(null,opts__$1,new cljs.core.Keyword(null,"keys","keys",1068423698),new cljs.core.Keyword("clojure.core.match","not-found","clojure.core.match/not-found",1553053780));
if(cljs.core.not_EQ_.call(null,opts_keys__32730,new cljs.core.Keyword("clojure.core.match","not-found","clojure.core.match/not-found",1553053780))){
var keys = cljs.core.get.call(null,opts__$1,new cljs.core.Keyword(null,"keys","keys",1068423698));
var incd = cljs.core.get.call(null,opts__$1,new cljs.core.Keyword(null,"include-docs","include-docs",637176099));
return offcourse.adapters.pouchdb.wrapper.fetch_docs.call(null,pouch,keys,incd);
} else {
throw cljs.core.match.backtrack;

}
}catch (e32736){if((e32736 instanceof Error)){
var e__31130__auto____$1 = e32736;
if((e__31130__auto____$1 === cljs.core.match.backtrack)){
throw cljs.core.match.backtrack;
} else {
throw e__31130__auto____$1;
}
} else {
throw e32736;

}
}} else {
throw cljs.core.match.backtrack;

}
}catch (e32734){if((e32734 instanceof Error)){
var e__31130__auto____$1 = e32734;
if((e__31130__auto____$1 === cljs.core.match.backtrack)){
try{var opts_keys__32730 = cljs.core.get.call(null,opts__$1,new cljs.core.Keyword(null,"keys","keys",1068423698),new cljs.core.Keyword("clojure.core.match","not-found","clojure.core.match/not-found",1553053780));
if(cljs.core.not_EQ_.call(null,opts_keys__32730,new cljs.core.Keyword("clojure.core.match","not-found","clojure.core.match/not-found",1553053780))){
var keys = cljs.core.get.call(null,opts__$1,new cljs.core.Keyword(null,"keys","keys",1068423698));
return offcourse.adapters.pouchdb.wrapper.fetch_docs.call(null,pouch,keys,true);
} else {
throw cljs.core.match.backtrack;

}
}catch (e32735){if((e32735 instanceof Error)){
var e__31130__auto____$2 = e32735;
if((e__31130__auto____$2 === cljs.core.match.backtrack)){
throw cljs.core.match.backtrack;
} else {
throw e__31130__auto____$2;
}
} else {
throw e32735;

}
}} else {
throw e__31130__auto____$1;
}
} else {
throw e32734;

}
}} else {
throw e__31130__auto__;
}
} else {
throw e32733;

}
}} else {
throw cljs.core.match.backtrack;

}
}catch (e32731){if((e32731 instanceof Error)){
var e__31130__auto__ = e32731;
if((e__31130__auto__ === cljs.core.match.backtrack)){
throw (new Error([cljs.core.str("No matching clause: "),cljs.core.str(opts__$1)].join('')));
} else {
throw e__31130__auto__;
}
} else {
throw e32731;

}
}});

offcourse.adapters.pouchdb.wrapper.fetch.cljs$lang$maxFixedArity = (1);

offcourse.adapters.pouchdb.wrapper.fetch.cljs$lang$applyTo = (function (seq32721){
var G__32722 = cljs.core.first.call(null,seq32721);
var seq32721__$1 = cljs.core.next.call(null,seq32721);
return offcourse.adapters.pouchdb.wrapper.fetch.cljs$core$IFn$_invoke$arity$variadic(G__32722,seq32721__$1);
});
offcourse.adapters.pouchdb.wrapper.fetch_doc = (function offcourse$adapters$pouchdb$wrapper$fetch_doc(pouch,doc_id){
return offcourse.helpers.interop.handle_js_response.call(null,pouch.get(doc_id));
});
offcourse.adapters.pouchdb.wrapper.refresh_doc = (function offcourse$adapters$pouchdb$wrapper$refresh_doc(pouch,doc){
return offcourse.helpers.interop.handle_js_response.call(null,pouch.put(doc));
});
offcourse.adapters.pouchdb.wrapper.has_doc_QMARK_ = (function offcourse$adapters$pouchdb$wrapper$has_doc_QMARK_(pouch,doc){
var c__27442__auto__ = cljs.core.async.chan.call(null,(1));
cljs.core.async.impl.dispatch.run.call(null,((function (c__27442__auto__){
return (function (){
var f__27443__auto__ = (function (){var switch__27421__auto__ = ((function (c__27442__auto__){
return (function (state_32773){
var state_val_32774 = (state_32773[(1)]);
if((state_val_32774 === (1))){
var inst_32763 = offcourse.adapters.pouchdb.wrapper.get_db_doc_id.call(null,doc);
var inst_32764 = offcourse.adapters.pouchdb.wrapper.fetch_doc.call(null,pouch,inst_32763);
var state_32773__$1 = state_32773;
return cljs.core.async.impl.ioc_helpers.take_BANG_.call(null,state_32773__$1,(2),inst_32764);
} else {
if((state_val_32774 === (2))){
var inst_32766 = (state_32773[(2)]);
var inst_32767 = new cljs.core.Keyword(null,"error","error",-978969032).cljs$core$IFn$_invoke$arity$1(inst_32766);
var state_32773__$1 = state_32773;
if(cljs.core.truth_(inst_32767)){
var statearr_32775_32786 = state_32773__$1;
(statearr_32775_32786[(1)] = (3));

} else {
var statearr_32776_32787 = state_32773__$1;
(statearr_32776_32787[(1)] = (4));

}

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_32774 === (3))){
var state_32773__$1 = state_32773;
var statearr_32777_32788 = state_32773__$1;
(statearr_32777_32788[(2)] = false);

(statearr_32777_32788[(1)] = (5));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_32774 === (4))){
var state_32773__$1 = state_32773;
var statearr_32778_32789 = state_32773__$1;
(statearr_32778_32789[(2)] = true);

(statearr_32778_32789[(1)] = (5));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_32774 === (5))){
var inst_32771 = (state_32773[(2)]);
var state_32773__$1 = state_32773;
return cljs.core.async.impl.ioc_helpers.return_chan.call(null,state_32773__$1,inst_32771);
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
var offcourse$adapters$pouchdb$wrapper$has_doc_QMARK__$_state_machine__27422__auto__ = null;
var offcourse$adapters$pouchdb$wrapper$has_doc_QMARK__$_state_machine__27422__auto____0 = (function (){
var statearr_32782 = [null,null,null,null,null,null,null];
(statearr_32782[(0)] = offcourse$adapters$pouchdb$wrapper$has_doc_QMARK__$_state_machine__27422__auto__);

(statearr_32782[(1)] = (1));

return statearr_32782;
});
var offcourse$adapters$pouchdb$wrapper$has_doc_QMARK__$_state_machine__27422__auto____1 = (function (state_32773){
while(true){
var ret_value__27423__auto__ = (function (){try{while(true){
var result__27424__auto__ = switch__27421__auto__.call(null,state_32773);
if(cljs.core.keyword_identical_QMARK_.call(null,result__27424__auto__,new cljs.core.Keyword(null,"recur","recur",-437573268))){
continue;
} else {
return result__27424__auto__;
}
break;
}
}catch (e32783){if((e32783 instanceof Object)){
var ex__27425__auto__ = e32783;
var statearr_32784_32790 = state_32773;
(statearr_32784_32790[(5)] = ex__27425__auto__);


cljs.core.async.impl.ioc_helpers.process_exception.call(null,state_32773);

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
throw e32783;

}
}})();
if(cljs.core.keyword_identical_QMARK_.call(null,ret_value__27423__auto__,new cljs.core.Keyword(null,"recur","recur",-437573268))){
var G__32791 = state_32773;
state_32773 = G__32791;
continue;
} else {
return ret_value__27423__auto__;
}
break;
}
});
offcourse$adapters$pouchdb$wrapper$has_doc_QMARK__$_state_machine__27422__auto__ = function(state_32773){
switch(arguments.length){
case 0:
return offcourse$adapters$pouchdb$wrapper$has_doc_QMARK__$_state_machine__27422__auto____0.call(this);
case 1:
return offcourse$adapters$pouchdb$wrapper$has_doc_QMARK__$_state_machine__27422__auto____1.call(this,state_32773);
}
throw(new Error('Invalid arity: ' + arguments.length));
};
offcourse$adapters$pouchdb$wrapper$has_doc_QMARK__$_state_machine__27422__auto__.cljs$core$IFn$_invoke$arity$0 = offcourse$adapters$pouchdb$wrapper$has_doc_QMARK__$_state_machine__27422__auto____0;
offcourse$adapters$pouchdb$wrapper$has_doc_QMARK__$_state_machine__27422__auto__.cljs$core$IFn$_invoke$arity$1 = offcourse$adapters$pouchdb$wrapper$has_doc_QMARK__$_state_machine__27422__auto____1;
return offcourse$adapters$pouchdb$wrapper$has_doc_QMARK__$_state_machine__27422__auto__;
})()
;})(switch__27421__auto__,c__27442__auto__))
})();
var state__27444__auto__ = (function (){var statearr_32785 = f__27443__auto__.call(null);
(statearr_32785[cljs.core.async.impl.ioc_helpers.USER_START_IDX] = c__27442__auto__);

return statearr_32785;
})();
return cljs.core.async.impl.ioc_helpers.run_state_machine_wrapped.call(null,state__27444__auto__);
});})(c__27442__auto__))
);

return c__27442__auto__;
});
offcourse.adapters.pouchdb.wrapper.missing_docs = (function offcourse$adapters$pouchdb$wrapper$missing_docs(pouch,docs){
var c__27442__auto__ = cljs.core.async.chan.call(null,(1));
cljs.core.async.impl.dispatch.run.call(null,((function (c__27442__auto__){
return (function (){
var f__27443__auto__ = (function (){var switch__27421__auto__ = ((function (c__27442__auto__){
return (function (state_32824){
var state_val_32825 = (state_32824[(1)]);
if((state_val_32825 === (1))){
var inst_32815 = (state_32824[(7)]);
var inst_32813 = cljs.core.PersistentHashSet.EMPTY;
var inst_32814 = cljs.core.map.call(null,offcourse.adapters.pouchdb.wrapper.get_db_doc_id,docs);
var inst_32815__$1 = cljs.core.into.call(null,inst_32813,inst_32814);
var inst_32816 = offcourse.adapters.pouchdb.wrapper.fetch.call(null,pouch,new cljs.core.Keyword(null,"keys","keys",1068423698),inst_32815__$1,new cljs.core.Keyword(null,"include-docs","include-docs",637176099),false);
var state_32824__$1 = (function (){var statearr_32826 = state_32824;
(statearr_32826[(7)] = inst_32815__$1);

return statearr_32826;
})();
return cljs.core.async.impl.ioc_helpers.take_BANG_.call(null,state_32824__$1,(2),inst_32816);
} else {
if((state_val_32825 === (2))){
var inst_32815 = (state_32824[(7)]);
var inst_32818 = (state_32824[(2)]);
var inst_32819 = (function (){var expected_doc_ids = inst_32815;
var docs__$1 = inst_32818;
return ((function (expected_doc_ids,docs__$1,inst_32815,inst_32818,state_val_32825,c__27442__auto__){
return (function (doc){
return cljs.core.get_in.call(null,doc,new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Keyword(null,"value","value",305978217),new cljs.core.Keyword(null,"deleted","deleted",-510100639)], null));
});
;})(expected_doc_ids,docs__$1,inst_32815,inst_32818,state_val_32825,c__27442__auto__))
})();
var inst_32820 = cljs.core.remove.call(null,inst_32819,inst_32818);
var inst_32821 = cljs.core.map.call(null,new cljs.core.Keyword(null,"id","id",-1388402092),inst_32820);
var inst_32822 = clojure.set.difference.call(null,inst_32815,inst_32821);
var state_32824__$1 = state_32824;
return cljs.core.async.impl.ioc_helpers.return_chan.call(null,state_32824__$1,inst_32822);
} else {
return null;
}
}
});})(c__27442__auto__))
;
return ((function (switch__27421__auto__,c__27442__auto__){
return (function() {
var offcourse$adapters$pouchdb$wrapper$missing_docs_$_state_machine__27422__auto__ = null;
var offcourse$adapters$pouchdb$wrapper$missing_docs_$_state_machine__27422__auto____0 = (function (){
var statearr_32830 = [null,null,null,null,null,null,null,null];
(statearr_32830[(0)] = offcourse$adapters$pouchdb$wrapper$missing_docs_$_state_machine__27422__auto__);

(statearr_32830[(1)] = (1));

return statearr_32830;
});
var offcourse$adapters$pouchdb$wrapper$missing_docs_$_state_machine__27422__auto____1 = (function (state_32824){
while(true){
var ret_value__27423__auto__ = (function (){try{while(true){
var result__27424__auto__ = switch__27421__auto__.call(null,state_32824);
if(cljs.core.keyword_identical_QMARK_.call(null,result__27424__auto__,new cljs.core.Keyword(null,"recur","recur",-437573268))){
continue;
} else {
return result__27424__auto__;
}
break;
}
}catch (e32831){if((e32831 instanceof Object)){
var ex__27425__auto__ = e32831;
var statearr_32832_32834 = state_32824;
(statearr_32832_32834[(5)] = ex__27425__auto__);


cljs.core.async.impl.ioc_helpers.process_exception.call(null,state_32824);

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
throw e32831;

}
}})();
if(cljs.core.keyword_identical_QMARK_.call(null,ret_value__27423__auto__,new cljs.core.Keyword(null,"recur","recur",-437573268))){
var G__32835 = state_32824;
state_32824 = G__32835;
continue;
} else {
return ret_value__27423__auto__;
}
break;
}
});
offcourse$adapters$pouchdb$wrapper$missing_docs_$_state_machine__27422__auto__ = function(state_32824){
switch(arguments.length){
case 0:
return offcourse$adapters$pouchdb$wrapper$missing_docs_$_state_machine__27422__auto____0.call(this);
case 1:
return offcourse$adapters$pouchdb$wrapper$missing_docs_$_state_machine__27422__auto____1.call(this,state_32824);
}
throw(new Error('Invalid arity: ' + arguments.length));
};
offcourse$adapters$pouchdb$wrapper$missing_docs_$_state_machine__27422__auto__.cljs$core$IFn$_invoke$arity$0 = offcourse$adapters$pouchdb$wrapper$missing_docs_$_state_machine__27422__auto____0;
offcourse$adapters$pouchdb$wrapper$missing_docs_$_state_machine__27422__auto__.cljs$core$IFn$_invoke$arity$1 = offcourse$adapters$pouchdb$wrapper$missing_docs_$_state_machine__27422__auto____1;
return offcourse$adapters$pouchdb$wrapper$missing_docs_$_state_machine__27422__auto__;
})()
;})(switch__27421__auto__,c__27442__auto__))
})();
var state__27444__auto__ = (function (){var statearr_32833 = f__27443__auto__.call(null);
(statearr_32833[cljs.core.async.impl.ioc_helpers.USER_START_IDX] = c__27442__auto__);

return statearr_32833;
})();
return cljs.core.async.impl.ioc_helpers.run_state_machine_wrapped.call(null,state__27444__auto__);
});})(c__27442__auto__))
);

return c__27442__auto__;
});

//# sourceMappingURL=wrapper.js.map