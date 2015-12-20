// Compiled by ClojureScript 1.7.170 {}
goog.provide('offcourse.adapters.pouchdb.index');
goog.require('cljs.core');
goog.require('cljs.core.async');
goog.require('com.stuartsierra.component');
goog.require('cljsjs.pouchdb');
offcourse.adapters.pouchdb.index.init_db = (function offcourse$adapters$pouchdb$index$init_db(str){
return (new PouchDB(str));
});
offcourse.adapters.pouchdb.index.handle_promise = (function offcourse$adapters$pouchdb$index$handle_promise(var_args){
var args28552 = [];
var len__26648__auto___28555 = arguments.length;
var i__26649__auto___28556 = (0);
while(true){
if((i__26649__auto___28556 < len__26648__auto___28555)){
args28552.push((arguments[i__26649__auto___28556]));

var G__28557 = (i__26649__auto___28556 + (1));
i__26649__auto___28556 = G__28557;
continue;
} else {
}
break;
}

var G__28554 = args28552.length;
switch (G__28554) {
case 1:
return offcourse.adapters.pouchdb.index.handle_promise.cljs$core$IFn$_invoke$arity$1((arguments[(0)]));

break;
case 2:
return offcourse.adapters.pouchdb.index.handle_promise.cljs$core$IFn$_invoke$arity$2((arguments[(0)]),(arguments[(1)]));

break;
default:
throw (new Error([cljs.core.str("Invalid arity: "),cljs.core.str(args28552.length)].join('')));

}
});

offcourse.adapters.pouchdb.index.handle_promise.cljs$core$IFn$_invoke$arity$1 = (function (promise){
return offcourse.adapters.pouchdb.index.handle_promise.call(null,promise,cljs.core.identity);
});

offcourse.adapters.pouchdb.index.handle_promise.cljs$core$IFn$_invoke$arity$2 = (function (promise,cb){
var channel = cljs.core.async.chan.call(null);
promise.then(((function (channel){
return (function (p1__28551_SHARP_){
return cljs.core.async.put_BANG_.call(null,channel,cb.call(null,p1__28551_SHARP_));
});})(channel))
);

return channel;
});

offcourse.adapters.pouchdb.index.handle_promise.cljs$lang$maxFixedArity = 2;

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
offcourse.adapters.pouchdb.index.PouchDB = (function (local_name,local_connection,__meta,__extmap,__hash){
this.local_name = local_name;
this.local_connection = local_connection;
this.__meta = __meta;
this.__extmap = __extmap;
this.__hash = __hash;
this.cljs$lang$protocol_mask$partition0$ = 2229667594;
this.cljs$lang$protocol_mask$partition1$ = 8192;
})
offcourse.adapters.pouchdb.index.PouchDB.prototype.cljs$core$ILookup$_lookup$arity$2 = (function (this__26204__auto__,k__26205__auto__){
var self__ = this;
var this__26204__auto____$1 = this;
return cljs.core._lookup.call(null,this__26204__auto____$1,k__26205__auto__,null);
});

offcourse.adapters.pouchdb.index.PouchDB.prototype.cljs$core$ILookup$_lookup$arity$3 = (function (this__26206__auto__,k28560,else__26207__auto__){
var self__ = this;
var this__26206__auto____$1 = this;
var G__28562 = (((k28560 instanceof cljs.core.Keyword))?k28560.fqn:null);
switch (G__28562) {
case "local-name":
return self__.local_name;

break;
case "local-connection":
return self__.local_connection;

break;
default:
return cljs.core.get.call(null,self__.__extmap,k28560,else__26207__auto__);

}
});

offcourse.adapters.pouchdb.index.PouchDB.prototype.cljs$core$IPrintWithWriter$_pr_writer$arity$3 = (function (this__26218__auto__,writer__26219__auto__,opts__26220__auto__){
var self__ = this;
var this__26218__auto____$1 = this;
var pr_pair__26221__auto__ = ((function (this__26218__auto____$1){
return (function (keyval__26222__auto__){
return cljs.core.pr_sequential_writer.call(null,writer__26219__auto__,cljs.core.pr_writer,""," ","",opts__26220__auto__,keyval__26222__auto__);
});})(this__26218__auto____$1))
;
return cljs.core.pr_sequential_writer.call(null,writer__26219__auto__,pr_pair__26221__auto__,"#offcourse.adapters.pouchdb.index.PouchDB{",", ","}",opts__26220__auto__,cljs.core.concat.call(null,new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [(new cljs.core.PersistentVector(null,2,(5),cljs.core.PersistentVector.EMPTY_NODE,[new cljs.core.Keyword(null,"local-name","local-name",1873837179),self__.local_name],null)),(new cljs.core.PersistentVector(null,2,(5),cljs.core.PersistentVector.EMPTY_NODE,[new cljs.core.Keyword(null,"local-connection","local-connection",-207139104),self__.local_connection],null))], null),self__.__extmap));
});

offcourse.adapters.pouchdb.index.PouchDB.prototype.cljs$core$IIterable$ = true;

offcourse.adapters.pouchdb.index.PouchDB.prototype.cljs$core$IIterable$_iterator$arity$1 = (function (G__28559){
var self__ = this;
var G__28559__$1 = this;
return (new cljs.core.RecordIter((0),G__28559__$1,2,new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Keyword(null,"local-name","local-name",1873837179),new cljs.core.Keyword(null,"local-connection","local-connection",-207139104)], null),cljs.core._iterator.call(null,self__.__extmap)));
});

offcourse.adapters.pouchdb.index.PouchDB.prototype.cljs$core$IMeta$_meta$arity$1 = (function (this__26202__auto__){
var self__ = this;
var this__26202__auto____$1 = this;
return self__.__meta;
});

offcourse.adapters.pouchdb.index.PouchDB.prototype.cljs$core$ICloneable$_clone$arity$1 = (function (this__26198__auto__){
var self__ = this;
var this__26198__auto____$1 = this;
return (new offcourse.adapters.pouchdb.index.PouchDB(self__.local_name,self__.local_connection,self__.__meta,self__.__extmap,self__.__hash));
});

offcourse.adapters.pouchdb.index.PouchDB.prototype.cljs$core$ICounted$_count$arity$1 = (function (this__26208__auto__){
var self__ = this;
var this__26208__auto____$1 = this;
return (2 + cljs.core.count.call(null,self__.__extmap));
});

offcourse.adapters.pouchdb.index.PouchDB.prototype.cljs$core$IHash$_hash$arity$1 = (function (this__26199__auto__){
var self__ = this;
var this__26199__auto____$1 = this;
var h__26025__auto__ = self__.__hash;
if(!((h__26025__auto__ == null))){
return h__26025__auto__;
} else {
var h__26025__auto____$1 = cljs.core.hash_imap.call(null,this__26199__auto____$1);
self__.__hash = h__26025__auto____$1;

return h__26025__auto____$1;
}
});

offcourse.adapters.pouchdb.index.PouchDB.prototype.cljs$core$IEquiv$_equiv$arity$2 = (function (this__26200__auto__,other__26201__auto__){
var self__ = this;
var this__26200__auto____$1 = this;
if(cljs.core.truth_((function (){var and__25578__auto__ = other__26201__auto__;
if(cljs.core.truth_(and__25578__auto__)){
var and__25578__auto____$1 = (this__26200__auto____$1.constructor === other__26201__auto__.constructor);
if(and__25578__auto____$1){
return cljs.core.equiv_map.call(null,this__26200__auto____$1,other__26201__auto__);
} else {
return and__25578__auto____$1;
}
} else {
return and__25578__auto__;
}
})())){
return true;
} else {
return false;
}
});

offcourse.adapters.pouchdb.index.PouchDB.prototype.cljs$core$IMap$_dissoc$arity$2 = (function (this__26213__auto__,k__26214__auto__){
var self__ = this;
var this__26213__auto____$1 = this;
if(cljs.core.contains_QMARK_.call(null,new cljs.core.PersistentHashSet(null, new cljs.core.PersistentArrayMap(null, 2, [new cljs.core.Keyword(null,"local-connection","local-connection",-207139104),null,new cljs.core.Keyword(null,"local-name","local-name",1873837179),null], null), null),k__26214__auto__)){
return cljs.core.dissoc.call(null,cljs.core.with_meta.call(null,cljs.core.into.call(null,cljs.core.PersistentArrayMap.EMPTY,this__26213__auto____$1),self__.__meta),k__26214__auto__);
} else {
return (new offcourse.adapters.pouchdb.index.PouchDB(self__.local_name,self__.local_connection,self__.__meta,cljs.core.not_empty.call(null,cljs.core.dissoc.call(null,self__.__extmap,k__26214__auto__)),null));
}
});

offcourse.adapters.pouchdb.index.PouchDB.prototype.cljs$core$IAssociative$_assoc$arity$3 = (function (this__26211__auto__,k__26212__auto__,G__28559){
var self__ = this;
var this__26211__auto____$1 = this;
var pred__28563 = cljs.core.keyword_identical_QMARK_;
var expr__28564 = k__26212__auto__;
if(cljs.core.truth_(pred__28563.call(null,new cljs.core.Keyword(null,"local-name","local-name",1873837179),expr__28564))){
return (new offcourse.adapters.pouchdb.index.PouchDB(G__28559,self__.local_connection,self__.__meta,self__.__extmap,null));
} else {
if(cljs.core.truth_(pred__28563.call(null,new cljs.core.Keyword(null,"local-connection","local-connection",-207139104),expr__28564))){
return (new offcourse.adapters.pouchdb.index.PouchDB(self__.local_name,G__28559,self__.__meta,self__.__extmap,null));
} else {
return (new offcourse.adapters.pouchdb.index.PouchDB(self__.local_name,self__.local_connection,self__.__meta,cljs.core.assoc.call(null,self__.__extmap,k__26212__auto__,G__28559),null));
}
}
});

offcourse.adapters.pouchdb.index.PouchDB.prototype.cljs$core$ISeqable$_seq$arity$1 = (function (this__26216__auto__){
var self__ = this;
var this__26216__auto____$1 = this;
return cljs.core.seq.call(null,cljs.core.concat.call(null,new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [(new cljs.core.PersistentVector(null,2,(5),cljs.core.PersistentVector.EMPTY_NODE,[new cljs.core.Keyword(null,"local-name","local-name",1873837179),self__.local_name],null)),(new cljs.core.PersistentVector(null,2,(5),cljs.core.PersistentVector.EMPTY_NODE,[new cljs.core.Keyword(null,"local-connection","local-connection",-207139104),self__.local_connection],null))], null),self__.__extmap));
});

offcourse.adapters.pouchdb.index.PouchDB.prototype.cljs$core$IWithMeta$_with_meta$arity$2 = (function (this__26203__auto__,G__28559){
var self__ = this;
var this__26203__auto____$1 = this;
return (new offcourse.adapters.pouchdb.index.PouchDB(self__.local_name,self__.local_connection,G__28559,self__.__extmap,self__.__hash));
});

offcourse.adapters.pouchdb.index.PouchDB.prototype.cljs$core$ICollection$_conj$arity$2 = (function (this__26209__auto__,entry__26210__auto__){
var self__ = this;
var this__26209__auto____$1 = this;
if(cljs.core.vector_QMARK_.call(null,entry__26210__auto__)){
return cljs.core._assoc.call(null,this__26209__auto____$1,cljs.core._nth.call(null,entry__26210__auto__,(0)),cljs.core._nth.call(null,entry__26210__auto__,(1)));
} else {
return cljs.core.reduce.call(null,cljs.core._conj,this__26209__auto____$1,entry__26210__auto__);
}
});

offcourse.adapters.pouchdb.index.PouchDB.prototype.com$stuartsierra$component$Lifecycle$ = true;

offcourse.adapters.pouchdb.index.PouchDB.prototype.com$stuartsierra$component$Lifecycle$start$arity$1 = (function (this$){
var self__ = this;
var this$__$1 = this;
var db = offcourse.adapters.pouchdb.index.init_db.call(null,self__.local_name);
cljs.core.println.call(null,"initialized",self__.local_name);

return cljs.core.assoc.call(null,this$__$1,new cljs.core.Keyword(null,"local-connection","local-connection",-207139104),db);
});

offcourse.adapters.pouchdb.index.PouchDB.prototype.com$stuartsierra$component$Lifecycle$stop$arity$1 = (function (this$){
var self__ = this;
var this$__$1 = this;
cljs.core.dissoc.call(null,this$__$1,new cljs.core.Keyword(null,"local-connection","local-connection",-207139104));

return cljs.core.println.call(null,"stopped",new cljs.core.Keyword(null,"local-name","local-name",1873837179).cljs$core$IFn$_invoke$arity$1(this$__$1));
});

offcourse.adapters.pouchdb.index.PouchDB.getBasis = (function (){
return new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Symbol(null,"local-name","local-name",-780598590,null),new cljs.core.Symbol(null,"local-connection","local-connection",1433392423,null)], null);
});

offcourse.adapters.pouchdb.index.PouchDB.cljs$lang$type = true;

offcourse.adapters.pouchdb.index.PouchDB.cljs$lang$ctorPrSeq = (function (this__26238__auto__){
return cljs.core._conj.call(null,cljs.core.List.EMPTY,"offcourse.adapters.pouchdb.index/PouchDB");
});

offcourse.adapters.pouchdb.index.PouchDB.cljs$lang$ctorPrWriter = (function (this__26238__auto__,writer__26239__auto__){
return cljs.core._write.call(null,writer__26239__auto__,"offcourse.adapters.pouchdb.index/PouchDB");
});

offcourse.adapters.pouchdb.index.__GT_PouchDB = (function offcourse$adapters$pouchdb$index$__GT_PouchDB(local_name,local_connection){
return (new offcourse.adapters.pouchdb.index.PouchDB(local_name,local_connection,null,null,null));
});

offcourse.adapters.pouchdb.index.map__GT_PouchDB = (function offcourse$adapters$pouchdb$index$map__GT_PouchDB(G__28561){
return (new offcourse.adapters.pouchdb.index.PouchDB(new cljs.core.Keyword(null,"local-name","local-name",1873837179).cljs$core$IFn$_invoke$arity$1(G__28561),new cljs.core.Keyword(null,"local-connection","local-connection",-207139104).cljs$core$IFn$_invoke$arity$1(G__28561),null,cljs.core.dissoc.call(null,G__28561,new cljs.core.Keyword(null,"local-name","local-name",1873837179),new cljs.core.Keyword(null,"local-connection","local-connection",-207139104)),null));
});

offcourse.adapters.pouchdb.index.new_pouch = (function offcourse$adapters$pouchdb$index$new_pouch(local_name){
return offcourse.adapters.pouchdb.index.map__GT_PouchDB.call(null,new cljs.core.PersistentArrayMap(null, 1, [new cljs.core.Keyword(null,"local-name","local-name",1873837179),local_name], null));
});
offcourse.adapters.pouchdb.index.info = (function offcourse$adapters$pouchdb$index$info(pouch,cb){
return offcourse.adapters.pouchdb.index.handle_promise.call(null,new cljs.core.Keyword(null,"local-connection","local-connection",-207139104).cljs$core$IFn$_invoke$arity$1(pouch).info(),cb);
});

//# sourceMappingURL=index.js.map