// Compiled by ClojureScript 1.7.170 {}
goog.provide('offcourse.adapters.pouchdb.index');
goog.require('cljs.core');
goog.require('cljs.core.async');
goog.require('com.stuartsierra.component');
goog.require('offcourse.adapters.pouchdb.wrapper');
goog.require('offcourse.protocols.validatable');

/**
* @constructor
 * @implements {cljs.core.IRecord}
 * @implements {cljs.core.IEquiv}
 * @implements {cljs.core.IHash}
 * @implements {cljs.core.ICollection}
 * @implements {cljs.core.ICounted}
 * @implements {cljs.core.ISeqable}
 * @implements {cljs.core.IMeta}
 * @implements {cljs.core.ICloneable}
 * @implements {cljs.core.IPrintWithWriter}
 * @implements {cljs.core.IIterable}
 * @implements {offcourse.protocols.validatable.Validatable}
 * @implements {cljs.core.IWithMeta}
 * @implements {cljs.core.IAssociative}
 * @implements {com.stuartsierra.component.Lifecycle}
 * @implements {cljs.core.IMap}
 * @implements {cljs.core.ILookup}
*/
offcourse.adapters.pouchdb.index.PouchDB = (function (name,design_doc,bootstrap_doc,connection,__meta,__extmap,__hash){
this.name = name;
this.design_doc = design_doc;
this.bootstrap_doc = bootstrap_doc;
this.connection = connection;
this.__meta = __meta;
this.__extmap = __extmap;
this.__hash = __hash;
this.cljs$lang$protocol_mask$partition0$ = 2229667594;
this.cljs$lang$protocol_mask$partition1$ = 8192;
})
offcourse.adapters.pouchdb.index.PouchDB.prototype.cljs$core$ILookup$_lookup$arity$2 = (function (this__25695__auto__,k__25696__auto__){
var self__ = this;
var this__25695__auto____$1 = this;
return cljs.core._lookup.call(null,this__25695__auto____$1,k__25696__auto__,null);
});

offcourse.adapters.pouchdb.index.PouchDB.prototype.cljs$core$ILookup$_lookup$arity$3 = (function (this__25697__auto__,k32463,else__25698__auto__){
var self__ = this;
var this__25697__auto____$1 = this;
var G__32465 = (((k32463 instanceof cljs.core.Keyword))?k32463.fqn:null);
switch (G__32465) {
case "name":
return self__.name;

break;
case "design-doc":
return self__.design_doc;

break;
case "bootstrap-doc":
return self__.bootstrap_doc;

break;
case "connection":
return self__.connection;

break;
default:
return cljs.core.get.call(null,self__.__extmap,k32463,else__25698__auto__);

}
});

offcourse.adapters.pouchdb.index.PouchDB.prototype.cljs$core$IPrintWithWriter$_pr_writer$arity$3 = (function (this__25709__auto__,writer__25710__auto__,opts__25711__auto__){
var self__ = this;
var this__25709__auto____$1 = this;
var pr_pair__25712__auto__ = ((function (this__25709__auto____$1){
return (function (keyval__25713__auto__){
return cljs.core.pr_sequential_writer.call(null,writer__25710__auto__,cljs.core.pr_writer,""," ","",opts__25711__auto__,keyval__25713__auto__);
});})(this__25709__auto____$1))
;
return cljs.core.pr_sequential_writer.call(null,writer__25710__auto__,pr_pair__25712__auto__,"#offcourse.adapters.pouchdb.index.PouchDB{",", ","}",opts__25711__auto__,cljs.core.concat.call(null,new cljs.core.PersistentVector(null, 4, 5, cljs.core.PersistentVector.EMPTY_NODE, [(new cljs.core.PersistentVector(null,2,(5),cljs.core.PersistentVector.EMPTY_NODE,[new cljs.core.Keyword(null,"name","name",1843675177),self__.name],null)),(new cljs.core.PersistentVector(null,2,(5),cljs.core.PersistentVector.EMPTY_NODE,[new cljs.core.Keyword(null,"design-doc","design-doc",-98897062),self__.design_doc],null)),(new cljs.core.PersistentVector(null,2,(5),cljs.core.PersistentVector.EMPTY_NODE,[new cljs.core.Keyword(null,"bootstrap-doc","bootstrap-doc",-908945544),self__.bootstrap_doc],null)),(new cljs.core.PersistentVector(null,2,(5),cljs.core.PersistentVector.EMPTY_NODE,[new cljs.core.Keyword(null,"connection","connection",-123599300),self__.connection],null))], null),self__.__extmap));
});

offcourse.adapters.pouchdb.index.PouchDB.prototype.cljs$core$IIterable$ = true;

offcourse.adapters.pouchdb.index.PouchDB.prototype.cljs$core$IIterable$_iterator$arity$1 = (function (G__32462){
var self__ = this;
var G__32462__$1 = this;
return (new cljs.core.RecordIter((0),G__32462__$1,4,new cljs.core.PersistentVector(null, 4, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Keyword(null,"name","name",1843675177),new cljs.core.Keyword(null,"design-doc","design-doc",-98897062),new cljs.core.Keyword(null,"bootstrap-doc","bootstrap-doc",-908945544),new cljs.core.Keyword(null,"connection","connection",-123599300)], null),cljs.core._iterator.call(null,self__.__extmap)));
});

offcourse.adapters.pouchdb.index.PouchDB.prototype.cljs$core$IMeta$_meta$arity$1 = (function (this__25693__auto__){
var self__ = this;
var this__25693__auto____$1 = this;
return self__.__meta;
});

offcourse.adapters.pouchdb.index.PouchDB.prototype.cljs$core$ICloneable$_clone$arity$1 = (function (this__25689__auto__){
var self__ = this;
var this__25689__auto____$1 = this;
return (new offcourse.adapters.pouchdb.index.PouchDB(self__.name,self__.design_doc,self__.bootstrap_doc,self__.connection,self__.__meta,self__.__extmap,self__.__hash));
});

offcourse.adapters.pouchdb.index.PouchDB.prototype.cljs$core$ICounted$_count$arity$1 = (function (this__25699__auto__){
var self__ = this;
var this__25699__auto____$1 = this;
return (4 + cljs.core.count.call(null,self__.__extmap));
});

offcourse.adapters.pouchdb.index.PouchDB.prototype.offcourse$protocols$validatable$Validatable$ = true;

offcourse.adapters.pouchdb.index.PouchDB.prototype.offcourse$protocols$validatable$Validatable$errors_async$arity$1 = (function (p__32466){
var self__ = this;
var map__32467 = p__32466;
var map__32467__$1 = ((((!((map__32467 == null)))?((((map__32467.cljs$lang$protocol_mask$partition0$ & (64))) || (map__32467.cljs$core$ISeq$))?true:false):false))?cljs.core.apply.call(null,cljs.core.hash_map,map__32467):map__32467);
var connection__$1 = cljs.core.get.call(null,map__32467__$1,new cljs.core.Keyword(null,"connection","connection",-123599300));
var design_doc__$1 = cljs.core.get.call(null,map__32467__$1,new cljs.core.Keyword(null,"design-doc","design-doc",-98897062));
var bootstrap_doc__$1 = cljs.core.get.call(null,map__32467__$1,new cljs.core.Keyword(null,"bootstrap-doc","bootstrap-doc",-908945544));
var map__32469 = this;
var map__32469__$1 = ((((!((map__32469 == null)))?((((map__32469.cljs$lang$protocol_mask$partition0$ & (64))) || (map__32469.cljs$core$ISeq$))?true:false):false))?cljs.core.apply.call(null,cljs.core.hash_map,map__32469):map__32469);
var connection__$2 = cljs.core.get.call(null,map__32469__$1,new cljs.core.Keyword(null,"connection","connection",-123599300));
var design_doc__$2 = cljs.core.get.call(null,map__32469__$1,new cljs.core.Keyword(null,"design-doc","design-doc",-98897062));
var bootstrap_doc__$2 = cljs.core.get.call(null,map__32469__$1,new cljs.core.Keyword(null,"bootstrap-doc","bootstrap-doc",-908945544));
var c__27442__auto__ = cljs.core.async.chan.call(null,(1));
cljs.core.async.impl.dispatch.run.call(null,((function (c__27442__auto__,map__32469,map__32469__$1,connection__$2,design_doc__$2,bootstrap_doc__$2,map__32467,map__32467__$1,connection__$1,design_doc__$1,bootstrap_doc__$1){
return (function (){
var f__27443__auto__ = (function (){var switch__27421__auto__ = ((function (c__27442__auto__,map__32469,map__32469__$1,connection__$2,design_doc__$2,bootstrap_doc__$2,map__32467,map__32467__$1,connection__$1,design_doc__$1,bootstrap_doc__$1){
return (function (state_32489){
var state_val_32490 = (state_32489[(1)]);
if((state_val_32490 === (1))){
var inst_32471 = cljs.core.PersistentVector.EMPTY_NODE;
var inst_32472 = [design_doc__$2,bootstrap_doc__$2];
var inst_32473 = (new cljs.core.PersistentVector(null,2,(5),inst_32471,inst_32472,null));
var inst_32474 = offcourse.adapters.pouchdb.wrapper.missing_docs.call(null,connection__$2,inst_32473);
var state_32489__$1 = state_32489;
return cljs.core.async.impl.ioc_helpers.take_BANG_.call(null,state_32489__$1,(2),inst_32474);
} else {
if((state_val_32490 === (2))){
var inst_32476 = (state_32489[(7)]);
var inst_32476__$1 = (state_32489[(2)]);
var inst_32477 = cljs.core.empty_QMARK_.call(null,inst_32476__$1);
var state_32489__$1 = (function (){var statearr_32491 = state_32489;
(statearr_32491[(7)] = inst_32476__$1);

return statearr_32491;
})();
if(inst_32477){
var statearr_32492_32564 = state_32489__$1;
(statearr_32492_32564[(1)] = (3));

} else {
var statearr_32493_32565 = state_32489__$1;
(statearr_32493_32565[(1)] = (4));

}

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_32490 === (3))){
var inst_32479 = [new cljs.core.Keyword(null,"status","status",-1997798413)];
var inst_32480 = [new cljs.core.Keyword(null,"db-ready","db-ready",25959867)];
var inst_32481 = cljs.core.PersistentHashMap.fromArrays(inst_32479,inst_32480);
var state_32489__$1 = state_32489;
var statearr_32494_32566 = state_32489__$1;
(statearr_32494_32566[(2)] = inst_32481);

(statearr_32494_32566[(1)] = (5));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_32490 === (4))){
var inst_32476 = (state_32489[(7)]);
var inst_32483 = [new cljs.core.Keyword(null,"status","status",-1997798413),new cljs.core.Keyword(null,"error","error",-978969032),new cljs.core.Keyword(null,"missing-data","missing-data",1386207722)];
var inst_32484 = [new cljs.core.Keyword(null,"error","error",-978969032),new cljs.core.Keyword(null,"missing-data","missing-data",1386207722),inst_32476];
var inst_32485 = cljs.core.PersistentHashMap.fromArrays(inst_32483,inst_32484);
var state_32489__$1 = state_32489;
var statearr_32495_32567 = state_32489__$1;
(statearr_32495_32567[(2)] = inst_32485);

(statearr_32495_32567[(1)] = (5));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_32490 === (5))){
var inst_32487 = (state_32489[(2)]);
var state_32489__$1 = state_32489;
return cljs.core.async.impl.ioc_helpers.return_chan.call(null,state_32489__$1,inst_32487);
} else {
return null;
}
}
}
}
}
});})(c__27442__auto__,map__32469,map__32469__$1,connection__$2,design_doc__$2,bootstrap_doc__$2,map__32467,map__32467__$1,connection__$1,design_doc__$1,bootstrap_doc__$1))
;
return ((function (switch__27421__auto__,c__27442__auto__,map__32469,map__32469__$1,connection__$2,design_doc__$2,bootstrap_doc__$2,map__32467,map__32467__$1,connection__$1,design_doc__$1,bootstrap_doc__$1){
return (function() {
var offcourse$adapters$pouchdb$index$state_machine__27422__auto__ = null;
var offcourse$adapters$pouchdb$index$state_machine__27422__auto____0 = (function (){
var statearr_32499 = [null,null,null,null,null,null,null,null];
(statearr_32499[(0)] = offcourse$adapters$pouchdb$index$state_machine__27422__auto__);

(statearr_32499[(1)] = (1));

return statearr_32499;
});
var offcourse$adapters$pouchdb$index$state_machine__27422__auto____1 = (function (state_32489){
while(true){
var ret_value__27423__auto__ = (function (){try{while(true){
var result__27424__auto__ = switch__27421__auto__.call(null,state_32489);
if(cljs.core.keyword_identical_QMARK_.call(null,result__27424__auto__,new cljs.core.Keyword(null,"recur","recur",-437573268))){
continue;
} else {
return result__27424__auto__;
}
break;
}
}catch (e32500){if((e32500 instanceof Object)){
var ex__27425__auto__ = e32500;
var statearr_32501_32568 = state_32489;
(statearr_32501_32568[(5)] = ex__27425__auto__);


cljs.core.async.impl.ioc_helpers.process_exception.call(null,state_32489);

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
throw e32500;

}
}})();
if(cljs.core.keyword_identical_QMARK_.call(null,ret_value__27423__auto__,new cljs.core.Keyword(null,"recur","recur",-437573268))){
var G__32569 = state_32489;
state_32489 = G__32569;
continue;
} else {
return ret_value__27423__auto__;
}
break;
}
});
offcourse$adapters$pouchdb$index$state_machine__27422__auto__ = function(state_32489){
switch(arguments.length){
case 0:
return offcourse$adapters$pouchdb$index$state_machine__27422__auto____0.call(this);
case 1:
return offcourse$adapters$pouchdb$index$state_machine__27422__auto____1.call(this,state_32489);
}
throw(new Error('Invalid arity: ' + arguments.length));
};
offcourse$adapters$pouchdb$index$state_machine__27422__auto__.cljs$core$IFn$_invoke$arity$0 = offcourse$adapters$pouchdb$index$state_machine__27422__auto____0;
offcourse$adapters$pouchdb$index$state_machine__27422__auto__.cljs$core$IFn$_invoke$arity$1 = offcourse$adapters$pouchdb$index$state_machine__27422__auto____1;
return offcourse$adapters$pouchdb$index$state_machine__27422__auto__;
})()
;})(switch__27421__auto__,c__27442__auto__,map__32469,map__32469__$1,connection__$2,design_doc__$2,bootstrap_doc__$2,map__32467,map__32467__$1,connection__$1,design_doc__$1,bootstrap_doc__$1))
})();
var state__27444__auto__ = (function (){var statearr_32502 = f__27443__auto__.call(null);
(statearr_32502[cljs.core.async.impl.ioc_helpers.USER_START_IDX] = c__27442__auto__);

return statearr_32502;
})();
return cljs.core.async.impl.ioc_helpers.run_state_machine_wrapped.call(null,state__27444__auto__);
});})(c__27442__auto__,map__32469,map__32469__$1,connection__$2,design_doc__$2,bootstrap_doc__$2,map__32467,map__32467__$1,connection__$1,design_doc__$1,bootstrap_doc__$1))
);

return c__27442__auto__;
});

offcourse.adapters.pouchdb.index.PouchDB.prototype.offcourse$protocols$validatable$Validatable$valid_QMARK__async$arity$1 = (function (db){
var self__ = this;
var db__$1 = this;
var c__27442__auto__ = cljs.core.async.chan.call(null,(1));
cljs.core.async.impl.dispatch.run.call(null,((function (c__27442__auto__,db__$1){
return (function (){
var f__27443__auto__ = (function (){var switch__27421__auto__ = ((function (c__27442__auto__,db__$1){
return (function (state_32534){
var state_val_32535 = (state_32534[(1)]);
if((state_val_32535 === (7))){
var state_32534__$1 = state_32534;
var statearr_32536_32570 = state_32534__$1;
(statearr_32536_32570[(2)] = false);

(statearr_32536_32570[(1)] = (8));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_32535 === (1))){
var inst_32504 = offcourse.protocols.validatable.errors_async.call(null,db__$1);
var state_32534__$1 = state_32534;
return cljs.core.async.impl.ioc_helpers.take_BANG_.call(null,state_32534__$1,(2),inst_32504);
} else {
if((state_val_32535 === (4))){
var state_32534__$1 = state_32534;
var statearr_32537_32571 = state_32534__$1;
(statearr_32537_32571[(2)] = false);

(statearr_32537_32571[(1)] = (5));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_32535 === (13))){
var state_32534__$1 = state_32534;
var statearr_32538_32572 = state_32534__$1;
(statearr_32538_32572[(2)] = true);

(statearr_32538_32572[(1)] = (14));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_32535 === (6))){
var state_32534__$1 = state_32534;
var statearr_32539_32573 = state_32534__$1;
(statearr_32539_32573[(2)] = true);

(statearr_32539_32573[(1)] = (8));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_32535 === (3))){
var inst_32506 = (state_32534[(7)]);
var inst_32511 = inst_32506.cljs$lang$protocol_mask$partition0$;
var inst_32512 = (inst_32511 & (64));
var inst_32513 = inst_32506.cljs$core$ISeq$;
var inst_32514 = (inst_32512) || (inst_32513);
var state_32534__$1 = state_32534;
if(cljs.core.truth_(inst_32514)){
var statearr_32540_32574 = state_32534__$1;
(statearr_32540_32574[(1)] = (6));

} else {
var statearr_32541_32575 = state_32534__$1;
(statearr_32541_32575[(1)] = (7));

}

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_32535 === (12))){
var state_32534__$1 = state_32534;
var statearr_32542_32576 = state_32534__$1;
(statearr_32542_32576[(2)] = false);

(statearr_32542_32576[(1)] = (14));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_32535 === (2))){
var inst_32506 = (state_32534[(7)]);
var inst_32506__$1 = (state_32534[(2)]);
var inst_32508 = (inst_32506__$1 == null);
var inst_32509 = cljs.core.not.call(null,inst_32508);
var state_32534__$1 = (function (){var statearr_32543 = state_32534;
(statearr_32543[(7)] = inst_32506__$1);

return statearr_32543;
})();
if(inst_32509){
var statearr_32544_32577 = state_32534__$1;
(statearr_32544_32577[(1)] = (3));

} else {
var statearr_32545_32578 = state_32534__$1;
(statearr_32545_32578[(1)] = (4));

}

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_32535 === (11))){
var inst_32526 = (state_32534[(2)]);
var inst_32527 = cljs.core.get.call(null,inst_32526,new cljs.core.Keyword(null,"status","status",-1997798413));
var inst_32528 = cljs.core._EQ_.call(null,inst_32527,new cljs.core.Keyword(null,"error","error",-978969032));
var state_32534__$1 = state_32534;
if(inst_32528){
var statearr_32546_32579 = state_32534__$1;
(statearr_32546_32579[(1)] = (12));

} else {
var statearr_32547_32580 = state_32534__$1;
(statearr_32547_32580[(1)] = (13));

}

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_32535 === (9))){
var inst_32506 = (state_32534[(7)]);
var inst_32523 = cljs.core.apply.call(null,cljs.core.hash_map,inst_32506);
var state_32534__$1 = state_32534;
var statearr_32548_32581 = state_32534__$1;
(statearr_32548_32581[(2)] = inst_32523);

(statearr_32548_32581[(1)] = (11));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_32535 === (5))){
var inst_32521 = (state_32534[(2)]);
var state_32534__$1 = state_32534;
if(cljs.core.truth_(inst_32521)){
var statearr_32549_32582 = state_32534__$1;
(statearr_32549_32582[(1)] = (9));

} else {
var statearr_32550_32583 = state_32534__$1;
(statearr_32550_32583[(1)] = (10));

}

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_32535 === (14))){
var inst_32532 = (state_32534[(2)]);
var state_32534__$1 = state_32534;
return cljs.core.async.impl.ioc_helpers.return_chan.call(null,state_32534__$1,inst_32532);
} else {
if((state_val_32535 === (10))){
var inst_32506 = (state_32534[(7)]);
var state_32534__$1 = state_32534;
var statearr_32551_32584 = state_32534__$1;
(statearr_32551_32584[(2)] = inst_32506);

(statearr_32551_32584[(1)] = (11));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_32535 === (8))){
var inst_32518 = (state_32534[(2)]);
var state_32534__$1 = state_32534;
var statearr_32552_32585 = state_32534__$1;
(statearr_32552_32585[(2)] = inst_32518);

(statearr_32552_32585[(1)] = (5));


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
});})(c__27442__auto__,db__$1))
;
return ((function (switch__27421__auto__,c__27442__auto__,db__$1){
return (function() {
var offcourse$adapters$pouchdb$index$state_machine__27422__auto__ = null;
var offcourse$adapters$pouchdb$index$state_machine__27422__auto____0 = (function (){
var statearr_32556 = [null,null,null,null,null,null,null,null];
(statearr_32556[(0)] = offcourse$adapters$pouchdb$index$state_machine__27422__auto__);

(statearr_32556[(1)] = (1));

return statearr_32556;
});
var offcourse$adapters$pouchdb$index$state_machine__27422__auto____1 = (function (state_32534){
while(true){
var ret_value__27423__auto__ = (function (){try{while(true){
var result__27424__auto__ = switch__27421__auto__.call(null,state_32534);
if(cljs.core.keyword_identical_QMARK_.call(null,result__27424__auto__,new cljs.core.Keyword(null,"recur","recur",-437573268))){
continue;
} else {
return result__27424__auto__;
}
break;
}
}catch (e32557){if((e32557 instanceof Object)){
var ex__27425__auto__ = e32557;
var statearr_32558_32586 = state_32534;
(statearr_32558_32586[(5)] = ex__27425__auto__);


cljs.core.async.impl.ioc_helpers.process_exception.call(null,state_32534);

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
throw e32557;

}
}})();
if(cljs.core.keyword_identical_QMARK_.call(null,ret_value__27423__auto__,new cljs.core.Keyword(null,"recur","recur",-437573268))){
var G__32587 = state_32534;
state_32534 = G__32587;
continue;
} else {
return ret_value__27423__auto__;
}
break;
}
});
offcourse$adapters$pouchdb$index$state_machine__27422__auto__ = function(state_32534){
switch(arguments.length){
case 0:
return offcourse$adapters$pouchdb$index$state_machine__27422__auto____0.call(this);
case 1:
return offcourse$adapters$pouchdb$index$state_machine__27422__auto____1.call(this,state_32534);
}
throw(new Error('Invalid arity: ' + arguments.length));
};
offcourse$adapters$pouchdb$index$state_machine__27422__auto__.cljs$core$IFn$_invoke$arity$0 = offcourse$adapters$pouchdb$index$state_machine__27422__auto____0;
offcourse$adapters$pouchdb$index$state_machine__27422__auto__.cljs$core$IFn$_invoke$arity$1 = offcourse$adapters$pouchdb$index$state_machine__27422__auto____1;
return offcourse$adapters$pouchdb$index$state_machine__27422__auto__;
})()
;})(switch__27421__auto__,c__27442__auto__,db__$1))
})();
var state__27444__auto__ = (function (){var statearr_32559 = f__27443__auto__.call(null);
(statearr_32559[cljs.core.async.impl.ioc_helpers.USER_START_IDX] = c__27442__auto__);

return statearr_32559;
})();
return cljs.core.async.impl.ioc_helpers.run_state_machine_wrapped.call(null,state__27444__auto__);
});})(c__27442__auto__,db__$1))
);

return c__27442__auto__;
});

offcourse.adapters.pouchdb.index.PouchDB.prototype.cljs$core$IHash$_hash$arity$1 = (function (this__25690__auto__){
var self__ = this;
var this__25690__auto____$1 = this;
var h__25516__auto__ = self__.__hash;
if(!((h__25516__auto__ == null))){
return h__25516__auto__;
} else {
var h__25516__auto____$1 = cljs.core.hash_imap.call(null,this__25690__auto____$1);
self__.__hash = h__25516__auto____$1;

return h__25516__auto____$1;
}
});

offcourse.adapters.pouchdb.index.PouchDB.prototype.cljs$core$IEquiv$_equiv$arity$2 = (function (this__25691__auto__,other__25692__auto__){
var self__ = this;
var this__25691__auto____$1 = this;
if(cljs.core.truth_((function (){var and__25069__auto__ = other__25692__auto__;
if(cljs.core.truth_(and__25069__auto__)){
var and__25069__auto____$1 = (this__25691__auto____$1.constructor === other__25692__auto__.constructor);
if(and__25069__auto____$1){
return cljs.core.equiv_map.call(null,this__25691__auto____$1,other__25692__auto__);
} else {
return and__25069__auto____$1;
}
} else {
return and__25069__auto__;
}
})())){
return true;
} else {
return false;
}
});

offcourse.adapters.pouchdb.index.PouchDB.prototype.cljs$core$IMap$_dissoc$arity$2 = (function (this__25704__auto__,k__25705__auto__){
var self__ = this;
var this__25704__auto____$1 = this;
if(cljs.core.contains_QMARK_.call(null,new cljs.core.PersistentHashSet(null, new cljs.core.PersistentArrayMap(null, 4, [new cljs.core.Keyword(null,"name","name",1843675177),null,new cljs.core.Keyword(null,"bootstrap-doc","bootstrap-doc",-908945544),null,new cljs.core.Keyword(null,"design-doc","design-doc",-98897062),null,new cljs.core.Keyword(null,"connection","connection",-123599300),null], null), null),k__25705__auto__)){
return cljs.core.dissoc.call(null,cljs.core.with_meta.call(null,cljs.core.into.call(null,cljs.core.PersistentArrayMap.EMPTY,this__25704__auto____$1),self__.__meta),k__25705__auto__);
} else {
return (new offcourse.adapters.pouchdb.index.PouchDB(self__.name,self__.design_doc,self__.bootstrap_doc,self__.connection,self__.__meta,cljs.core.not_empty.call(null,cljs.core.dissoc.call(null,self__.__extmap,k__25705__auto__)),null));
}
});

offcourse.adapters.pouchdb.index.PouchDB.prototype.cljs$core$IAssociative$_assoc$arity$3 = (function (this__25702__auto__,k__25703__auto__,G__32462){
var self__ = this;
var this__25702__auto____$1 = this;
var pred__32560 = cljs.core.keyword_identical_QMARK_;
var expr__32561 = k__25703__auto__;
if(cljs.core.truth_(pred__32560.call(null,new cljs.core.Keyword(null,"name","name",1843675177),expr__32561))){
return (new offcourse.adapters.pouchdb.index.PouchDB(G__32462,self__.design_doc,self__.bootstrap_doc,self__.connection,self__.__meta,self__.__extmap,null));
} else {
if(cljs.core.truth_(pred__32560.call(null,new cljs.core.Keyword(null,"design-doc","design-doc",-98897062),expr__32561))){
return (new offcourse.adapters.pouchdb.index.PouchDB(self__.name,G__32462,self__.bootstrap_doc,self__.connection,self__.__meta,self__.__extmap,null));
} else {
if(cljs.core.truth_(pred__32560.call(null,new cljs.core.Keyword(null,"bootstrap-doc","bootstrap-doc",-908945544),expr__32561))){
return (new offcourse.adapters.pouchdb.index.PouchDB(self__.name,self__.design_doc,G__32462,self__.connection,self__.__meta,self__.__extmap,null));
} else {
if(cljs.core.truth_(pred__32560.call(null,new cljs.core.Keyword(null,"connection","connection",-123599300),expr__32561))){
return (new offcourse.adapters.pouchdb.index.PouchDB(self__.name,self__.design_doc,self__.bootstrap_doc,G__32462,self__.__meta,self__.__extmap,null));
} else {
return (new offcourse.adapters.pouchdb.index.PouchDB(self__.name,self__.design_doc,self__.bootstrap_doc,self__.connection,self__.__meta,cljs.core.assoc.call(null,self__.__extmap,k__25703__auto__,G__32462),null));
}
}
}
}
});

offcourse.adapters.pouchdb.index.PouchDB.prototype.cljs$core$ISeqable$_seq$arity$1 = (function (this__25707__auto__){
var self__ = this;
var this__25707__auto____$1 = this;
return cljs.core.seq.call(null,cljs.core.concat.call(null,new cljs.core.PersistentVector(null, 4, 5, cljs.core.PersistentVector.EMPTY_NODE, [(new cljs.core.PersistentVector(null,2,(5),cljs.core.PersistentVector.EMPTY_NODE,[new cljs.core.Keyword(null,"name","name",1843675177),self__.name],null)),(new cljs.core.PersistentVector(null,2,(5),cljs.core.PersistentVector.EMPTY_NODE,[new cljs.core.Keyword(null,"design-doc","design-doc",-98897062),self__.design_doc],null)),(new cljs.core.PersistentVector(null,2,(5),cljs.core.PersistentVector.EMPTY_NODE,[new cljs.core.Keyword(null,"bootstrap-doc","bootstrap-doc",-908945544),self__.bootstrap_doc],null)),(new cljs.core.PersistentVector(null,2,(5),cljs.core.PersistentVector.EMPTY_NODE,[new cljs.core.Keyword(null,"connection","connection",-123599300),self__.connection],null))], null),self__.__extmap));
});

offcourse.adapters.pouchdb.index.PouchDB.prototype.cljs$core$IWithMeta$_with_meta$arity$2 = (function (this__25694__auto__,G__32462){
var self__ = this;
var this__25694__auto____$1 = this;
return (new offcourse.adapters.pouchdb.index.PouchDB(self__.name,self__.design_doc,self__.bootstrap_doc,self__.connection,G__32462,self__.__extmap,self__.__hash));
});

offcourse.adapters.pouchdb.index.PouchDB.prototype.cljs$core$ICollection$_conj$arity$2 = (function (this__25700__auto__,entry__25701__auto__){
var self__ = this;
var this__25700__auto____$1 = this;
if(cljs.core.vector_QMARK_.call(null,entry__25701__auto__)){
return cljs.core._assoc.call(null,this__25700__auto____$1,cljs.core._nth.call(null,entry__25701__auto__,(0)),cljs.core._nth.call(null,entry__25701__auto__,(1)));
} else {
return cljs.core.reduce.call(null,cljs.core._conj,this__25700__auto____$1,entry__25701__auto__);
}
});

offcourse.adapters.pouchdb.index.PouchDB.prototype.com$stuartsierra$component$Lifecycle$ = true;

offcourse.adapters.pouchdb.index.PouchDB.prototype.com$stuartsierra$component$Lifecycle$start$arity$1 = (function (db){
var self__ = this;
var db__$1 = this;
return cljs.core.assoc.call(null,db__$1,new cljs.core.Keyword(null,"connection","connection",-123599300),offcourse.adapters.pouchdb.wrapper.init.call(null,new cljs.core.Keyword(null,"name","name",1843675177).cljs$core$IFn$_invoke$arity$1(db__$1)));
});

offcourse.adapters.pouchdb.index.PouchDB.prototype.com$stuartsierra$component$Lifecycle$stop$arity$1 = (function (db){
var self__ = this;
var db__$1 = this;
return cljs.core.dissoc.call(null,db__$1,new cljs.core.Keyword(null,"connection","connection",-123599300));
});

offcourse.adapters.pouchdb.index.PouchDB.getBasis = (function (){
return new cljs.core.PersistentVector(null, 4, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Symbol(null,"name","name",-810760592,null),new cljs.core.Symbol(null,"design-doc","design-doc",1541634465,null),new cljs.core.Symbol(null,"bootstrap-doc","bootstrap-doc",731585983,null),new cljs.core.Symbol(null,"connection","connection",1516932227,null)], null);
});

offcourse.adapters.pouchdb.index.PouchDB.cljs$lang$type = true;

offcourse.adapters.pouchdb.index.PouchDB.cljs$lang$ctorPrSeq = (function (this__25729__auto__){
return cljs.core._conj.call(null,cljs.core.List.EMPTY,"offcourse.adapters.pouchdb.index/PouchDB");
});

offcourse.adapters.pouchdb.index.PouchDB.cljs$lang$ctorPrWriter = (function (this__25729__auto__,writer__25730__auto__){
return cljs.core._write.call(null,writer__25730__auto__,"offcourse.adapters.pouchdb.index/PouchDB");
});

offcourse.adapters.pouchdb.index.__GT_PouchDB = (function offcourse$adapters$pouchdb$index$__GT_PouchDB(name,design_doc,bootstrap_doc,connection){
return (new offcourse.adapters.pouchdb.index.PouchDB(name,design_doc,bootstrap_doc,connection,null,null,null));
});

offcourse.adapters.pouchdb.index.map__GT_PouchDB = (function offcourse$adapters$pouchdb$index$map__GT_PouchDB(G__32464){
return (new offcourse.adapters.pouchdb.index.PouchDB(new cljs.core.Keyword(null,"name","name",1843675177).cljs$core$IFn$_invoke$arity$1(G__32464),new cljs.core.Keyword(null,"design-doc","design-doc",-98897062).cljs$core$IFn$_invoke$arity$1(G__32464),new cljs.core.Keyword(null,"bootstrap-doc","bootstrap-doc",-908945544).cljs$core$IFn$_invoke$arity$1(G__32464),new cljs.core.Keyword(null,"connection","connection",-123599300).cljs$core$IFn$_invoke$arity$1(G__32464),null,cljs.core.dissoc.call(null,G__32464,new cljs.core.Keyword(null,"name","name",1843675177),new cljs.core.Keyword(null,"design-doc","design-doc",-98897062),new cljs.core.Keyword(null,"bootstrap-doc","bootstrap-doc",-908945544),new cljs.core.Keyword(null,"connection","connection",-123599300)),null));
});

offcourse.adapters.pouchdb.index.new_db = (function offcourse$adapters$pouchdb$index$new_db(name,design_doc,bootstrap_doc){
return offcourse.adapters.pouchdb.index.map__GT_PouchDB.call(null,new cljs.core.PersistentArrayMap(null, 3, [new cljs.core.Keyword(null,"name","name",1843675177),name,new cljs.core.Keyword(null,"design-doc","design-doc",-98897062),design_doc,new cljs.core.Keyword(null,"bootstrap-doc","bootstrap-doc",-908945544),bootstrap_doc], null));
});
offcourse.adapters.pouchdb.index.bootstrap_data = (function offcourse$adapters$pouchdb$index$bootstrap_data(p__32588){
var map__32633 = p__32588;
var map__32633__$1 = ((((!((map__32633 == null)))?((((map__32633.cljs$lang$protocol_mask$partition0$ & (64))) || (map__32633.cljs$core$ISeq$))?true:false):false))?cljs.core.apply.call(null,cljs.core.hash_map,map__32633):map__32633);
var bootstrap_doc = cljs.core.get.call(null,map__32633__$1,new cljs.core.Keyword(null,"bootstrap-doc","bootstrap-doc",-908945544));
var design_doc = cljs.core.get.call(null,map__32633__$1,new cljs.core.Keyword(null,"design-doc","design-doc",-98897062));
var connection = cljs.core.get.call(null,map__32633__$1,new cljs.core.Keyword(null,"connection","connection",-123599300));
var c__27442__auto__ = cljs.core.async.chan.call(null,(1));
cljs.core.async.impl.dispatch.run.call(null,((function (c__27442__auto__,map__32633,map__32633__$1,bootstrap_doc,design_doc,connection){
return (function (){
var f__27443__auto__ = (function (){var switch__27421__auto__ = ((function (c__27442__auto__,map__32633,map__32633__$1,bootstrap_doc,design_doc,connection){
return (function (state_32660){
var state_val_32661 = (state_32660[(1)]);
if((state_val_32661 === (1))){
var inst_32635 = [new cljs.core.Keyword(null,"bootstrap-doc","bootstrap-doc",-908945544),new cljs.core.Keyword(null,"design-doc","design-doc",-98897062)];
var inst_32636 = offcourse.adapters.pouchdb.wrapper.refresh_doc.call(null,connection,bootstrap_doc);
var state_32660__$1 = (function (){var statearr_32662 = state_32660;
(statearr_32662[(7)] = inst_32635);

return statearr_32662;
})();
return cljs.core.async.impl.ioc_helpers.take_BANG_.call(null,state_32660__$1,(2),inst_32636);
} else {
if((state_val_32661 === (2))){
var inst_32638 = (state_32660[(2)]);
var inst_32639 = offcourse.adapters.pouchdb.wrapper.refresh_doc.call(null,connection,design_doc);
var state_32660__$1 = (function (){var statearr_32663 = state_32660;
(statearr_32663[(8)] = inst_32638);

return statearr_32663;
})();
return cljs.core.async.impl.ioc_helpers.take_BANG_.call(null,state_32660__$1,(3),inst_32639);
} else {
if((state_val_32661 === (3))){
var inst_32647 = (state_32660[(9)]);
var inst_32635 = (state_32660[(7)]);
var inst_32638 = (state_32660[(8)]);
var inst_32641 = (state_32660[(2)]);
var inst_32642 = [inst_32638,inst_32641];
var inst_32643 = cljs.core.PersistentHashMap.fromArrays(inst_32635,inst_32642);
var inst_32645 = (function (){var bootstrap_data__$1 = inst_32643;
return ((function (bootstrap_data__$1,inst_32647,inst_32635,inst_32638,inst_32641,inst_32642,inst_32643,state_val_32661,c__27442__auto__,map__32633,map__32633__$1,bootstrap_doc,design_doc,connection){
return (function (acc,p__32644){
var vec__32664 = p__32644;
var k = cljs.core.nth.call(null,vec__32664,(0),null);
var v = cljs.core.nth.call(null,vec__32664,(1),null);
if(cljs.core.truth_(v)){
return null;
} else {
return cljs.core.conj.call(null,acc,k);
}
});
;})(bootstrap_data__$1,inst_32647,inst_32635,inst_32638,inst_32641,inst_32642,inst_32643,state_val_32661,c__27442__auto__,map__32633,map__32633__$1,bootstrap_doc,design_doc,connection))
})();
var inst_32646 = cljs.core.PersistentVector.EMPTY;
var inst_32647__$1 = cljs.core.reduce.call(null,inst_32645,inst_32646,inst_32643);
var inst_32648 = cljs.core.empty_QMARK_.call(null,inst_32647__$1);
var state_32660__$1 = (function (){var statearr_32665 = state_32660;
(statearr_32665[(9)] = inst_32647__$1);

return statearr_32665;
})();
if(inst_32648){
var statearr_32666_32677 = state_32660__$1;
(statearr_32666_32677[(1)] = (4));

} else {
var statearr_32667_32678 = state_32660__$1;
(statearr_32667_32678[(1)] = (5));

}

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_32661 === (4))){
var inst_32650 = [new cljs.core.Keyword(null,"status","status",-1997798413)];
var inst_32651 = [new cljs.core.Keyword(null,"db-bootstrapped","db-bootstrapped",-1309822246)];
var inst_32652 = cljs.core.PersistentHashMap.fromArrays(inst_32650,inst_32651);
var state_32660__$1 = state_32660;
var statearr_32668_32679 = state_32660__$1;
(statearr_32668_32679[(2)] = inst_32652);

(statearr_32668_32679[(1)] = (6));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_32661 === (5))){
var inst_32647 = (state_32660[(9)]);
var inst_32654 = [new cljs.core.Keyword(null,"status","status",-1997798413),new cljs.core.Keyword(null,"error","error",-978969032),new cljs.core.Keyword(null,"missing-data","missing-data",1386207722)];
var inst_32655 = [new cljs.core.Keyword(null,"error","error",-978969032),new cljs.core.Keyword(null,"missing-data","missing-data",1386207722),inst_32647];
var inst_32656 = cljs.core.PersistentHashMap.fromArrays(inst_32654,inst_32655);
var state_32660__$1 = state_32660;
var statearr_32669_32680 = state_32660__$1;
(statearr_32669_32680[(2)] = inst_32656);

(statearr_32669_32680[(1)] = (6));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_32661 === (6))){
var inst_32658 = (state_32660[(2)]);
var state_32660__$1 = state_32660;
return cljs.core.async.impl.ioc_helpers.return_chan.call(null,state_32660__$1,inst_32658);
} else {
return null;
}
}
}
}
}
}
});})(c__27442__auto__,map__32633,map__32633__$1,bootstrap_doc,design_doc,connection))
;
return ((function (switch__27421__auto__,c__27442__auto__,map__32633,map__32633__$1,bootstrap_doc,design_doc,connection){
return (function() {
var offcourse$adapters$pouchdb$index$bootstrap_data_$_state_machine__27422__auto__ = null;
var offcourse$adapters$pouchdb$index$bootstrap_data_$_state_machine__27422__auto____0 = (function (){
var statearr_32673 = [null,null,null,null,null,null,null,null,null,null];
(statearr_32673[(0)] = offcourse$adapters$pouchdb$index$bootstrap_data_$_state_machine__27422__auto__);

(statearr_32673[(1)] = (1));

return statearr_32673;
});
var offcourse$adapters$pouchdb$index$bootstrap_data_$_state_machine__27422__auto____1 = (function (state_32660){
while(true){
var ret_value__27423__auto__ = (function (){try{while(true){
var result__27424__auto__ = switch__27421__auto__.call(null,state_32660);
if(cljs.core.keyword_identical_QMARK_.call(null,result__27424__auto__,new cljs.core.Keyword(null,"recur","recur",-437573268))){
continue;
} else {
return result__27424__auto__;
}
break;
}
}catch (e32674){if((e32674 instanceof Object)){
var ex__27425__auto__ = e32674;
var statearr_32675_32681 = state_32660;
(statearr_32675_32681[(5)] = ex__27425__auto__);


cljs.core.async.impl.ioc_helpers.process_exception.call(null,state_32660);

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
throw e32674;

}
}})();
if(cljs.core.keyword_identical_QMARK_.call(null,ret_value__27423__auto__,new cljs.core.Keyword(null,"recur","recur",-437573268))){
var G__32682 = state_32660;
state_32660 = G__32682;
continue;
} else {
return ret_value__27423__auto__;
}
break;
}
});
offcourse$adapters$pouchdb$index$bootstrap_data_$_state_machine__27422__auto__ = function(state_32660){
switch(arguments.length){
case 0:
return offcourse$adapters$pouchdb$index$bootstrap_data_$_state_machine__27422__auto____0.call(this);
case 1:
return offcourse$adapters$pouchdb$index$bootstrap_data_$_state_machine__27422__auto____1.call(this,state_32660);
}
throw(new Error('Invalid arity: ' + arguments.length));
};
offcourse$adapters$pouchdb$index$bootstrap_data_$_state_machine__27422__auto__.cljs$core$IFn$_invoke$arity$0 = offcourse$adapters$pouchdb$index$bootstrap_data_$_state_machine__27422__auto____0;
offcourse$adapters$pouchdb$index$bootstrap_data_$_state_machine__27422__auto__.cljs$core$IFn$_invoke$arity$1 = offcourse$adapters$pouchdb$index$bootstrap_data_$_state_machine__27422__auto____1;
return offcourse$adapters$pouchdb$index$bootstrap_data_$_state_machine__27422__auto__;
})()
;})(switch__27421__auto__,c__27442__auto__,map__32633,map__32633__$1,bootstrap_doc,design_doc,connection))
})();
var state__27444__auto__ = (function (){var statearr_32676 = f__27443__auto__.call(null);
(statearr_32676[cljs.core.async.impl.ioc_helpers.USER_START_IDX] = c__27442__auto__);

return statearr_32676;
})();
return cljs.core.async.impl.ioc_helpers.run_state_machine_wrapped.call(null,state__27444__auto__);
});})(c__27442__auto__,map__32633,map__32633__$1,bootstrap_doc,design_doc,connection))
);

return c__27442__auto__;
});
offcourse.adapters.pouchdb.index.bootstrap = (function offcourse$adapters$pouchdb$index$bootstrap(db){
var c__27442__auto__ = cljs.core.async.chan.call(null,(1));
cljs.core.async.impl.dispatch.run.call(null,((function (c__27442__auto__){
return (function (){
var f__27443__auto__ = (function (){var switch__27421__auto__ = ((function (c__27442__auto__){
return (function (state_32708){
var state_val_32709 = (state_32708[(1)]);
if((state_val_32709 === (1))){
var inst_32700 = new cljs.core.Keyword(null,"connection","connection",-123599300).cljs$core$IFn$_invoke$arity$1(db);
var inst_32701 = cljs.core.PersistentVector.EMPTY_NODE;
var inst_32702 = ["_design/query"];
var inst_32703 = (new cljs.core.PersistentVector(null,1,(5),inst_32701,inst_32702,null));
var inst_32704 = offcourse.adapters.pouchdb.wrapper.fetch.call(null,inst_32700,new cljs.core.Keyword(null,"keys","keys",1068423698),inst_32703,new cljs.core.Keyword(null,"include-docs","include-docs",637176099),false);
var state_32708__$1 = state_32708;
return cljs.core.async.impl.ioc_helpers.take_BANG_.call(null,state_32708__$1,(2),inst_32704);
} else {
if((state_val_32709 === (2))){
var inst_32706 = (state_32708[(2)]);
var state_32708__$1 = state_32708;
return cljs.core.async.impl.ioc_helpers.return_chan.call(null,state_32708__$1,inst_32706);
} else {
return null;
}
}
});})(c__27442__auto__))
;
return ((function (switch__27421__auto__,c__27442__auto__){
return (function() {
var offcourse$adapters$pouchdb$index$bootstrap_$_state_machine__27422__auto__ = null;
var offcourse$adapters$pouchdb$index$bootstrap_$_state_machine__27422__auto____0 = (function (){
var statearr_32713 = [null,null,null,null,null,null,null];
(statearr_32713[(0)] = offcourse$adapters$pouchdb$index$bootstrap_$_state_machine__27422__auto__);

(statearr_32713[(1)] = (1));

return statearr_32713;
});
var offcourse$adapters$pouchdb$index$bootstrap_$_state_machine__27422__auto____1 = (function (state_32708){
while(true){
var ret_value__27423__auto__ = (function (){try{while(true){
var result__27424__auto__ = switch__27421__auto__.call(null,state_32708);
if(cljs.core.keyword_identical_QMARK_.call(null,result__27424__auto__,new cljs.core.Keyword(null,"recur","recur",-437573268))){
continue;
} else {
return result__27424__auto__;
}
break;
}
}catch (e32714){if((e32714 instanceof Object)){
var ex__27425__auto__ = e32714;
var statearr_32715_32717 = state_32708;
(statearr_32715_32717[(5)] = ex__27425__auto__);


cljs.core.async.impl.ioc_helpers.process_exception.call(null,state_32708);

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
throw e32714;

}
}})();
if(cljs.core.keyword_identical_QMARK_.call(null,ret_value__27423__auto__,new cljs.core.Keyword(null,"recur","recur",-437573268))){
var G__32718 = state_32708;
state_32708 = G__32718;
continue;
} else {
return ret_value__27423__auto__;
}
break;
}
});
offcourse$adapters$pouchdb$index$bootstrap_$_state_machine__27422__auto__ = function(state_32708){
switch(arguments.length){
case 0:
return offcourse$adapters$pouchdb$index$bootstrap_$_state_machine__27422__auto____0.call(this);
case 1:
return offcourse$adapters$pouchdb$index$bootstrap_$_state_machine__27422__auto____1.call(this,state_32708);
}
throw(new Error('Invalid arity: ' + arguments.length));
};
offcourse$adapters$pouchdb$index$bootstrap_$_state_machine__27422__auto__.cljs$core$IFn$_invoke$arity$0 = offcourse$adapters$pouchdb$index$bootstrap_$_state_machine__27422__auto____0;
offcourse$adapters$pouchdb$index$bootstrap_$_state_machine__27422__auto__.cljs$core$IFn$_invoke$arity$1 = offcourse$adapters$pouchdb$index$bootstrap_$_state_machine__27422__auto____1;
return offcourse$adapters$pouchdb$index$bootstrap_$_state_machine__27422__auto__;
})()
;})(switch__27421__auto__,c__27442__auto__))
})();
var state__27444__auto__ = (function (){var statearr_32716 = f__27443__auto__.call(null);
(statearr_32716[cljs.core.async.impl.ioc_helpers.USER_START_IDX] = c__27442__auto__);

return statearr_32716;
})();
return cljs.core.async.impl.ioc_helpers.run_state_machine_wrapped.call(null,state__27444__auto__);
});})(c__27442__auto__))
);

return c__27442__auto__;
});

//# sourceMappingURL=index.js.map