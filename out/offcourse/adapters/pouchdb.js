// Compiled by ClojureScript 1.7.170 {}
goog.provide('offcourse.adapters.pouchdb');
goog.require('cljs.core');
goog.require('cljs.core.async');
goog.require('com.stuartsierra.component');
goog.require('cljsjs.pouchdb');
goog.require('offcourse.helpers.interop');

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
 * @implements {cljs.core.IWithMeta}
 * @implements {cljs.core.IAssociative}
 * @implements {com.stuartsierra.component.Lifecycle}
 * @implements {cljs.core.IMap}
 * @implements {cljs.core.ILookup}
*/
offcourse.adapters.pouchdb.PouchDB = (function (name,design_doc,bootstrap_doc,connection,__meta,__extmap,__hash){
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
offcourse.adapters.pouchdb.PouchDB.prototype.cljs$core$ILookup$_lookup$arity$2 = (function (this__25615__auto__,k__25616__auto__){
var self__ = this;
var this__25615__auto____$1 = this;
return cljs.core._lookup.call(null,this__25615__auto____$1,k__25616__auto__,null);
});

offcourse.adapters.pouchdb.PouchDB.prototype.cljs$core$ILookup$_lookup$arity$3 = (function (this__25617__auto__,k29391,else__25618__auto__){
var self__ = this;
var this__25617__auto____$1 = this;
var G__29393 = (((k29391 instanceof cljs.core.Keyword))?k29391.fqn:null);
switch (G__29393) {
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
return cljs.core.get.call(null,self__.__extmap,k29391,else__25618__auto__);

}
});

offcourse.adapters.pouchdb.PouchDB.prototype.cljs$core$IPrintWithWriter$_pr_writer$arity$3 = (function (this__25629__auto__,writer__25630__auto__,opts__25631__auto__){
var self__ = this;
var this__25629__auto____$1 = this;
var pr_pair__25632__auto__ = ((function (this__25629__auto____$1){
return (function (keyval__25633__auto__){
return cljs.core.pr_sequential_writer.call(null,writer__25630__auto__,cljs.core.pr_writer,""," ","",opts__25631__auto__,keyval__25633__auto__);
});})(this__25629__auto____$1))
;
return cljs.core.pr_sequential_writer.call(null,writer__25630__auto__,pr_pair__25632__auto__,"#offcourse.adapters.pouchdb.PouchDB{",", ","}",opts__25631__auto__,cljs.core.concat.call(null,new cljs.core.PersistentVector(null, 4, 5, cljs.core.PersistentVector.EMPTY_NODE, [(new cljs.core.PersistentVector(null,2,(5),cljs.core.PersistentVector.EMPTY_NODE,[new cljs.core.Keyword(null,"name","name",1843675177),self__.name],null)),(new cljs.core.PersistentVector(null,2,(5),cljs.core.PersistentVector.EMPTY_NODE,[new cljs.core.Keyword(null,"design-doc","design-doc",-98897062),self__.design_doc],null)),(new cljs.core.PersistentVector(null,2,(5),cljs.core.PersistentVector.EMPTY_NODE,[new cljs.core.Keyword(null,"bootstrap-doc","bootstrap-doc",-908945544),self__.bootstrap_doc],null)),(new cljs.core.PersistentVector(null,2,(5),cljs.core.PersistentVector.EMPTY_NODE,[new cljs.core.Keyword(null,"connection","connection",-123599300),self__.connection],null))], null),self__.__extmap));
});

offcourse.adapters.pouchdb.PouchDB.prototype.cljs$core$IIterable$ = true;

offcourse.adapters.pouchdb.PouchDB.prototype.cljs$core$IIterable$_iterator$arity$1 = (function (G__29390){
var self__ = this;
var G__29390__$1 = this;
return (new cljs.core.RecordIter((0),G__29390__$1,4,new cljs.core.PersistentVector(null, 4, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Keyword(null,"name","name",1843675177),new cljs.core.Keyword(null,"design-doc","design-doc",-98897062),new cljs.core.Keyword(null,"bootstrap-doc","bootstrap-doc",-908945544),new cljs.core.Keyword(null,"connection","connection",-123599300)], null),cljs.core._iterator.call(null,self__.__extmap)));
});

offcourse.adapters.pouchdb.PouchDB.prototype.cljs$core$IMeta$_meta$arity$1 = (function (this__25613__auto__){
var self__ = this;
var this__25613__auto____$1 = this;
return self__.__meta;
});

offcourse.adapters.pouchdb.PouchDB.prototype.cljs$core$ICloneable$_clone$arity$1 = (function (this__25609__auto__){
var self__ = this;
var this__25609__auto____$1 = this;
return (new offcourse.adapters.pouchdb.PouchDB(self__.name,self__.design_doc,self__.bootstrap_doc,self__.connection,self__.__meta,self__.__extmap,self__.__hash));
});

offcourse.adapters.pouchdb.PouchDB.prototype.cljs$core$ICounted$_count$arity$1 = (function (this__25619__auto__){
var self__ = this;
var this__25619__auto____$1 = this;
return (4 + cljs.core.count.call(null,self__.__extmap));
});

offcourse.adapters.pouchdb.PouchDB.prototype.cljs$core$IHash$_hash$arity$1 = (function (this__25610__auto__){
var self__ = this;
var this__25610__auto____$1 = this;
var h__25436__auto__ = self__.__hash;
if(!((h__25436__auto__ == null))){
return h__25436__auto__;
} else {
var h__25436__auto____$1 = cljs.core.hash_imap.call(null,this__25610__auto____$1);
self__.__hash = h__25436__auto____$1;

return h__25436__auto____$1;
}
});

offcourse.adapters.pouchdb.PouchDB.prototype.cljs$core$IEquiv$_equiv$arity$2 = (function (this__25611__auto__,other__25612__auto__){
var self__ = this;
var this__25611__auto____$1 = this;
if(cljs.core.truth_((function (){var and__24989__auto__ = other__25612__auto__;
if(cljs.core.truth_(and__24989__auto__)){
var and__24989__auto____$1 = (this__25611__auto____$1.constructor === other__25612__auto__.constructor);
if(and__24989__auto____$1){
return cljs.core.equiv_map.call(null,this__25611__auto____$1,other__25612__auto__);
} else {
return and__24989__auto____$1;
}
} else {
return and__24989__auto__;
}
})())){
return true;
} else {
return false;
}
});

offcourse.adapters.pouchdb.PouchDB.prototype.cljs$core$IMap$_dissoc$arity$2 = (function (this__25624__auto__,k__25625__auto__){
var self__ = this;
var this__25624__auto____$1 = this;
if(cljs.core.contains_QMARK_.call(null,new cljs.core.PersistentHashSet(null, new cljs.core.PersistentArrayMap(null, 4, [new cljs.core.Keyword(null,"name","name",1843675177),null,new cljs.core.Keyword(null,"bootstrap-doc","bootstrap-doc",-908945544),null,new cljs.core.Keyword(null,"design-doc","design-doc",-98897062),null,new cljs.core.Keyword(null,"connection","connection",-123599300),null], null), null),k__25625__auto__)){
return cljs.core.dissoc.call(null,cljs.core.with_meta.call(null,cljs.core.into.call(null,cljs.core.PersistentArrayMap.EMPTY,this__25624__auto____$1),self__.__meta),k__25625__auto__);
} else {
return (new offcourse.adapters.pouchdb.PouchDB(self__.name,self__.design_doc,self__.bootstrap_doc,self__.connection,self__.__meta,cljs.core.not_empty.call(null,cljs.core.dissoc.call(null,self__.__extmap,k__25625__auto__)),null));
}
});

offcourse.adapters.pouchdb.PouchDB.prototype.cljs$core$IAssociative$_assoc$arity$3 = (function (this__25622__auto__,k__25623__auto__,G__29390){
var self__ = this;
var this__25622__auto____$1 = this;
var pred__29394 = cljs.core.keyword_identical_QMARK_;
var expr__29395 = k__25623__auto__;
if(cljs.core.truth_(pred__29394.call(null,new cljs.core.Keyword(null,"name","name",1843675177),expr__29395))){
return (new offcourse.adapters.pouchdb.PouchDB(G__29390,self__.design_doc,self__.bootstrap_doc,self__.connection,self__.__meta,self__.__extmap,null));
} else {
if(cljs.core.truth_(pred__29394.call(null,new cljs.core.Keyword(null,"design-doc","design-doc",-98897062),expr__29395))){
return (new offcourse.adapters.pouchdb.PouchDB(self__.name,G__29390,self__.bootstrap_doc,self__.connection,self__.__meta,self__.__extmap,null));
} else {
if(cljs.core.truth_(pred__29394.call(null,new cljs.core.Keyword(null,"bootstrap-doc","bootstrap-doc",-908945544),expr__29395))){
return (new offcourse.adapters.pouchdb.PouchDB(self__.name,self__.design_doc,G__29390,self__.connection,self__.__meta,self__.__extmap,null));
} else {
if(cljs.core.truth_(pred__29394.call(null,new cljs.core.Keyword(null,"connection","connection",-123599300),expr__29395))){
return (new offcourse.adapters.pouchdb.PouchDB(self__.name,self__.design_doc,self__.bootstrap_doc,G__29390,self__.__meta,self__.__extmap,null));
} else {
return (new offcourse.adapters.pouchdb.PouchDB(self__.name,self__.design_doc,self__.bootstrap_doc,self__.connection,self__.__meta,cljs.core.assoc.call(null,self__.__extmap,k__25623__auto__,G__29390),null));
}
}
}
}
});

offcourse.adapters.pouchdb.PouchDB.prototype.cljs$core$ISeqable$_seq$arity$1 = (function (this__25627__auto__){
var self__ = this;
var this__25627__auto____$1 = this;
return cljs.core.seq.call(null,cljs.core.concat.call(null,new cljs.core.PersistentVector(null, 4, 5, cljs.core.PersistentVector.EMPTY_NODE, [(new cljs.core.PersistentVector(null,2,(5),cljs.core.PersistentVector.EMPTY_NODE,[new cljs.core.Keyword(null,"name","name",1843675177),self__.name],null)),(new cljs.core.PersistentVector(null,2,(5),cljs.core.PersistentVector.EMPTY_NODE,[new cljs.core.Keyword(null,"design-doc","design-doc",-98897062),self__.design_doc],null)),(new cljs.core.PersistentVector(null,2,(5),cljs.core.PersistentVector.EMPTY_NODE,[new cljs.core.Keyword(null,"bootstrap-doc","bootstrap-doc",-908945544),self__.bootstrap_doc],null)),(new cljs.core.PersistentVector(null,2,(5),cljs.core.PersistentVector.EMPTY_NODE,[new cljs.core.Keyword(null,"connection","connection",-123599300),self__.connection],null))], null),self__.__extmap));
});

offcourse.adapters.pouchdb.PouchDB.prototype.cljs$core$IWithMeta$_with_meta$arity$2 = (function (this__25614__auto__,G__29390){
var self__ = this;
var this__25614__auto____$1 = this;
return (new offcourse.adapters.pouchdb.PouchDB(self__.name,self__.design_doc,self__.bootstrap_doc,self__.connection,G__29390,self__.__extmap,self__.__hash));
});

offcourse.adapters.pouchdb.PouchDB.prototype.cljs$core$ICollection$_conj$arity$2 = (function (this__25620__auto__,entry__25621__auto__){
var self__ = this;
var this__25620__auto____$1 = this;
if(cljs.core.vector_QMARK_.call(null,entry__25621__auto__)){
return cljs.core._assoc.call(null,this__25620__auto____$1,cljs.core._nth.call(null,entry__25621__auto__,(0)),cljs.core._nth.call(null,entry__25621__auto__,(1)));
} else {
return cljs.core.reduce.call(null,cljs.core._conj,this__25620__auto____$1,entry__25621__auto__);
}
});

offcourse.adapters.pouchdb.PouchDB.prototype.com$stuartsierra$component$Lifecycle$ = true;

offcourse.adapters.pouchdb.PouchDB.prototype.com$stuartsierra$component$Lifecycle$start$arity$1 = (function (db){
var self__ = this;
var db__$1 = this;
return cljs.core.assoc.call(null,db__$1,new cljs.core.Keyword(null,"connection","connection",-123599300),(new PouchDB(new cljs.core.Keyword(null,"name","name",1843675177).cljs$core$IFn$_invoke$arity$1(db__$1))));
});

offcourse.adapters.pouchdb.PouchDB.prototype.com$stuartsierra$component$Lifecycle$stop$arity$1 = (function (db){
var self__ = this;
var db__$1 = this;
return cljs.core.dissoc.call(null,db__$1,new cljs.core.Keyword(null,"connection","connection",-123599300));
});

offcourse.adapters.pouchdb.PouchDB.getBasis = (function (){
return new cljs.core.PersistentVector(null, 4, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Symbol(null,"name","name",-810760592,null),new cljs.core.Symbol(null,"design-doc","design-doc",1541634465,null),new cljs.core.Symbol(null,"bootstrap-doc","bootstrap-doc",731585983,null),new cljs.core.Symbol(null,"connection","connection",1516932227,null)], null);
});

offcourse.adapters.pouchdb.PouchDB.cljs$lang$type = true;

offcourse.adapters.pouchdb.PouchDB.cljs$lang$ctorPrSeq = (function (this__25649__auto__){
return cljs.core._conj.call(null,cljs.core.List.EMPTY,"offcourse.adapters.pouchdb/PouchDB");
});

offcourse.adapters.pouchdb.PouchDB.cljs$lang$ctorPrWriter = (function (this__25649__auto__,writer__25650__auto__){
return cljs.core._write.call(null,writer__25650__auto__,"offcourse.adapters.pouchdb/PouchDB");
});

offcourse.adapters.pouchdb.__GT_PouchDB = (function offcourse$adapters$pouchdb$__GT_PouchDB(name,design_doc,bootstrap_doc,connection){
return (new offcourse.adapters.pouchdb.PouchDB(name,design_doc,bootstrap_doc,connection,null,null,null));
});

offcourse.adapters.pouchdb.map__GT_PouchDB = (function offcourse$adapters$pouchdb$map__GT_PouchDB(G__29392){
return (new offcourse.adapters.pouchdb.PouchDB(new cljs.core.Keyword(null,"name","name",1843675177).cljs$core$IFn$_invoke$arity$1(G__29392),new cljs.core.Keyword(null,"design-doc","design-doc",-98897062).cljs$core$IFn$_invoke$arity$1(G__29392),new cljs.core.Keyword(null,"bootstrap-doc","bootstrap-doc",-908945544).cljs$core$IFn$_invoke$arity$1(G__29392),new cljs.core.Keyword(null,"connection","connection",-123599300).cljs$core$IFn$_invoke$arity$1(G__29392),null,cljs.core.dissoc.call(null,G__29392,new cljs.core.Keyword(null,"name","name",1843675177),new cljs.core.Keyword(null,"design-doc","design-doc",-98897062),new cljs.core.Keyword(null,"bootstrap-doc","bootstrap-doc",-908945544),new cljs.core.Keyword(null,"connection","connection",-123599300)),null));
});

offcourse.adapters.pouchdb.new_db = (function offcourse$adapters$pouchdb$new_db(name,design_doc,bootstrap_doc){
return offcourse.adapters.pouchdb.map__GT_PouchDB.call(null,new cljs.core.PersistentArrayMap(null, 3, [new cljs.core.Keyword(null,"name","name",1843675177),name,new cljs.core.Keyword(null,"design-doc","design-doc",-98897062),design_doc,new cljs.core.Keyword(null,"bootstrap-doc","bootstrap-doc",-908945544),bootstrap_doc], null));
});
offcourse.adapters.pouchdb.info = (function offcourse$adapters$pouchdb$info(pouch){
return offcourse.helpers.interop.handle_json_response.call(null,pouch.info());
});
offcourse.adapters.pouchdb.fetch = (function offcourse$adapters$pouchdb$fetch(pouch,doc_id){
return offcourse.helpers.interop.handle_json_response.call(null,pouch.get(doc_id));
});
offcourse.adapters.pouchdb.refresh = (function offcourse$adapters$pouchdb$refresh(pouch,doc){
return offcourse.helpers.interop.handle_json_response.call(null,pouch.put(doc));
});
offcourse.adapters.pouchdb.bootstrap = (function offcourse$adapters$pouchdb$bootstrap(p__29398){
var map__29427 = p__29398;
var map__29427__$1 = ((((!((map__29427 == null)))?((((map__29427.cljs$lang$protocol_mask$partition0$ & (64))) || (map__29427.cljs$core$ISeq$))?true:false):false))?cljs.core.apply.call(null,cljs.core.hash_map,map__29427):map__29427);
var connection = cljs.core.get.call(null,map__29427__$1,new cljs.core.Keyword(null,"connection","connection",-123599300));
var design_doc = cljs.core.get.call(null,map__29427__$1,new cljs.core.Keyword(null,"design-doc","design-doc",-98897062));
var bootstrap_doc = cljs.core.get.call(null,map__29427__$1,new cljs.core.Keyword(null,"bootstrap-doc","bootstrap-doc",-908945544));
var channel = cljs.core.async.chan.call(null);
var design_doc_id = new cljs.core.Keyword(null,"_id","_id",-789960287).cljs$core$IFn$_invoke$arity$1(offcourse.helpers.interop.jsx__GT_clj.call(null,design_doc));
var c__27362__auto___29455 = cljs.core.async.chan.call(null,(1));
cljs.core.async.impl.dispatch.run.call(null,((function (c__27362__auto___29455,channel,design_doc_id,map__29427,map__29427__$1,connection,design_doc,bootstrap_doc){
return (function (){
var f__27363__auto__ = (function (){var switch__27341__auto__ = ((function (c__27362__auto___29455,channel,design_doc_id,map__29427,map__29427__$1,connection,design_doc,bootstrap_doc){
return (function (state_29442){
var state_val_29443 = (state_29442[(1)]);
if((state_val_29443 === (1))){
var inst_29429 = offcourse.adapters.pouchdb.fetch.call(null,connection,"123abc");
var state_29442__$1 = state_29442;
return cljs.core.async.impl.ioc_helpers.take_BANG_.call(null,state_29442__$1,(2),inst_29429);
} else {
if((state_val_29443 === (2))){
var inst_29431 = (state_29442[(2)]);
var inst_29432 = new cljs.core.Keyword(null,"error","error",-978969032).cljs$core$IFn$_invoke$arity$1(inst_29431);
var state_29442__$1 = state_29442;
if(cljs.core.truth_(inst_29432)){
var statearr_29444_29456 = state_29442__$1;
(statearr_29444_29456[(1)] = (3));

} else {
var statearr_29445_29457 = state_29442__$1;
(statearr_29445_29457[(1)] = (4));

}

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_29443 === (3))){
var inst_29434 = offcourse.adapters.pouchdb.refresh.call(null,connection,bootstrap_doc);
var inst_29435 = cljs.core.async.pipe.call(null,inst_29434,channel);
var state_29442__$1 = state_29442;
var statearr_29446_29458 = state_29442__$1;
(statearr_29446_29458[(2)] = inst_29435);

(statearr_29446_29458[(1)] = (5));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_29443 === (4))){
var state_29442__$1 = state_29442;
return cljs.core.async.impl.ioc_helpers.put_BANG_.call(null,state_29442__$1,(6),channel,bootstrap_doc);
} else {
if((state_val_29443 === (5))){
var inst_29440 = (state_29442[(2)]);
var state_29442__$1 = state_29442;
return cljs.core.async.impl.ioc_helpers.return_chan.call(null,state_29442__$1,inst_29440);
} else {
if((state_val_29443 === (6))){
var inst_29438 = (state_29442[(2)]);
var state_29442__$1 = state_29442;
var statearr_29447_29459 = state_29442__$1;
(statearr_29447_29459[(2)] = inst_29438);

(statearr_29447_29459[(1)] = (5));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
return null;
}
}
}
}
}
}
});})(c__27362__auto___29455,channel,design_doc_id,map__29427,map__29427__$1,connection,design_doc,bootstrap_doc))
;
return ((function (switch__27341__auto__,c__27362__auto___29455,channel,design_doc_id,map__29427,map__29427__$1,connection,design_doc,bootstrap_doc){
return (function() {
var offcourse$adapters$pouchdb$bootstrap_$_state_machine__27342__auto__ = null;
var offcourse$adapters$pouchdb$bootstrap_$_state_machine__27342__auto____0 = (function (){
var statearr_29451 = [null,null,null,null,null,null,null];
(statearr_29451[(0)] = offcourse$adapters$pouchdb$bootstrap_$_state_machine__27342__auto__);

(statearr_29451[(1)] = (1));

return statearr_29451;
});
var offcourse$adapters$pouchdb$bootstrap_$_state_machine__27342__auto____1 = (function (state_29442){
while(true){
var ret_value__27343__auto__ = (function (){try{while(true){
var result__27344__auto__ = switch__27341__auto__.call(null,state_29442);
if(cljs.core.keyword_identical_QMARK_.call(null,result__27344__auto__,new cljs.core.Keyword(null,"recur","recur",-437573268))){
continue;
} else {
return result__27344__auto__;
}
break;
}
}catch (e29452){if((e29452 instanceof Object)){
var ex__27345__auto__ = e29452;
var statearr_29453_29460 = state_29442;
(statearr_29453_29460[(5)] = ex__27345__auto__);


cljs.core.async.impl.ioc_helpers.process_exception.call(null,state_29442);

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
throw e29452;

}
}})();
if(cljs.core.keyword_identical_QMARK_.call(null,ret_value__27343__auto__,new cljs.core.Keyword(null,"recur","recur",-437573268))){
var G__29461 = state_29442;
state_29442 = G__29461;
continue;
} else {
return ret_value__27343__auto__;
}
break;
}
});
offcourse$adapters$pouchdb$bootstrap_$_state_machine__27342__auto__ = function(state_29442){
switch(arguments.length){
case 0:
return offcourse$adapters$pouchdb$bootstrap_$_state_machine__27342__auto____0.call(this);
case 1:
return offcourse$adapters$pouchdb$bootstrap_$_state_machine__27342__auto____1.call(this,state_29442);
}
throw(new Error('Invalid arity: ' + arguments.length));
};
offcourse$adapters$pouchdb$bootstrap_$_state_machine__27342__auto__.cljs$core$IFn$_invoke$arity$0 = offcourse$adapters$pouchdb$bootstrap_$_state_machine__27342__auto____0;
offcourse$adapters$pouchdb$bootstrap_$_state_machine__27342__auto__.cljs$core$IFn$_invoke$arity$1 = offcourse$adapters$pouchdb$bootstrap_$_state_machine__27342__auto____1;
return offcourse$adapters$pouchdb$bootstrap_$_state_machine__27342__auto__;
})()
;})(switch__27341__auto__,c__27362__auto___29455,channel,design_doc_id,map__29427,map__29427__$1,connection,design_doc,bootstrap_doc))
})();
var state__27364__auto__ = (function (){var statearr_29454 = f__27363__auto__.call(null);
(statearr_29454[cljs.core.async.impl.ioc_helpers.USER_START_IDX] = c__27362__auto___29455);

return statearr_29454;
})();
return cljs.core.async.impl.ioc_helpers.run_state_machine_wrapped.call(null,state__27364__auto__);
});})(c__27362__auto___29455,channel,design_doc_id,map__29427,map__29427__$1,connection,design_doc,bootstrap_doc))
);


return channel;
});

//# sourceMappingURL=pouchdb.js.map