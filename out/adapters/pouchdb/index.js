// Compiled by ClojureScript 1.7.170 {}
goog.provide('adapters.pouchdb.index');
goog.require('cljs.core');
goog.require('adapters.pouchdb.wrapper');
goog.require('adapters.pouchdb.implementations.validatable');
goog.require('adapters.pouchdb.implementations.bootstrappable');
goog.require('offcourse.protocols.queryable');
goog.require('com.stuartsierra.component');
goog.require('offcourse.protocols.bootstrappable');
goog.require('offcourse.protocols.validatable');

/**
* @constructor
 * @implements {cljs.core.IRecord}
 * @implements {cljs.core.IEquiv}
 * @implements {cljs.core.IHash}
 * @implements {cljs.core.ICollection}
 * @implements {offcourse.protocols.queryable.Queryable}
 * @implements {offcourse.protocols.bootstrappable.Bootstrappable}
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
adapters.pouchdb.index.PouchDB = (function (name,design_doc,bootstrap_doc,connection,__meta,__extmap,__hash){
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
adapters.pouchdb.index.PouchDB.prototype.com$stuartsierra$component$Lifecycle$ = true;

adapters.pouchdb.index.PouchDB.prototype.com$stuartsierra$component$Lifecycle$start$arity$1 = (function (db){
var self__ = this;
var db__$1 = this;
return cljs.core.assoc.call(null,db__$1,new cljs.core.Keyword(null,"connection","connection",-123599300),adapters.pouchdb.wrapper.init.call(null,new cljs.core.Keyword(null,"name","name",1843675177).cljs$core$IFn$_invoke$arity$1(db__$1)));
});

adapters.pouchdb.index.PouchDB.prototype.com$stuartsierra$component$Lifecycle$stop$arity$1 = (function (db){
var self__ = this;
var db__$1 = this;
return cljs.core.dissoc.call(null,db__$1,new cljs.core.Keyword(null,"connection","connection",-123599300));
});

adapters.pouchdb.index.PouchDB.prototype.cljs$core$ILookup$_lookup$arity$2 = (function (this__25695__auto__,k__25696__auto__){
var self__ = this;
var this__25695__auto____$1 = this;
return cljs.core._lookup.call(null,this__25695__auto____$1,k__25696__auto__,null);
});

adapters.pouchdb.index.PouchDB.prototype.cljs$core$ILookup$_lookup$arity$3 = (function (this__25697__auto__,k37954,else__25698__auto__){
var self__ = this;
var this__25697__auto____$1 = this;
var G__37956 = (((k37954 instanceof cljs.core.Keyword))?k37954.fqn:null);
switch (G__37956) {
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
return cljs.core.get.call(null,self__.__extmap,k37954,else__25698__auto__);

}
});

adapters.pouchdb.index.PouchDB.prototype.cljs$core$IPrintWithWriter$_pr_writer$arity$3 = (function (this__25709__auto__,writer__25710__auto__,opts__25711__auto__){
var self__ = this;
var this__25709__auto____$1 = this;
var pr_pair__25712__auto__ = ((function (this__25709__auto____$1){
return (function (keyval__25713__auto__){
return cljs.core.pr_sequential_writer.call(null,writer__25710__auto__,cljs.core.pr_writer,""," ","",opts__25711__auto__,keyval__25713__auto__);
});})(this__25709__auto____$1))
;
return cljs.core.pr_sequential_writer.call(null,writer__25710__auto__,pr_pair__25712__auto__,"#adapters.pouchdb.index.PouchDB{",", ","}",opts__25711__auto__,cljs.core.concat.call(null,new cljs.core.PersistentVector(null, 4, 5, cljs.core.PersistentVector.EMPTY_NODE, [(new cljs.core.PersistentVector(null,2,(5),cljs.core.PersistentVector.EMPTY_NODE,[new cljs.core.Keyword(null,"name","name",1843675177),self__.name],null)),(new cljs.core.PersistentVector(null,2,(5),cljs.core.PersistentVector.EMPTY_NODE,[new cljs.core.Keyword(null,"design-doc","design-doc",-98897062),self__.design_doc],null)),(new cljs.core.PersistentVector(null,2,(5),cljs.core.PersistentVector.EMPTY_NODE,[new cljs.core.Keyword(null,"bootstrap-doc","bootstrap-doc",-908945544),self__.bootstrap_doc],null)),(new cljs.core.PersistentVector(null,2,(5),cljs.core.PersistentVector.EMPTY_NODE,[new cljs.core.Keyword(null,"connection","connection",-123599300),self__.connection],null))], null),self__.__extmap));
});

adapters.pouchdb.index.PouchDB.prototype.cljs$core$IIterable$ = true;

adapters.pouchdb.index.PouchDB.prototype.cljs$core$IIterable$_iterator$arity$1 = (function (G__37953){
var self__ = this;
var G__37953__$1 = this;
return (new cljs.core.RecordIter((0),G__37953__$1,4,new cljs.core.PersistentVector(null, 4, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Keyword(null,"name","name",1843675177),new cljs.core.Keyword(null,"design-doc","design-doc",-98897062),new cljs.core.Keyword(null,"bootstrap-doc","bootstrap-doc",-908945544),new cljs.core.Keyword(null,"connection","connection",-123599300)], null),cljs.core._iterator.call(null,self__.__extmap)));
});

adapters.pouchdb.index.PouchDB.prototype.cljs$core$IMeta$_meta$arity$1 = (function (this__25693__auto__){
var self__ = this;
var this__25693__auto____$1 = this;
return self__.__meta;
});

adapters.pouchdb.index.PouchDB.prototype.cljs$core$ICloneable$_clone$arity$1 = (function (this__25689__auto__){
var self__ = this;
var this__25689__auto____$1 = this;
return (new adapters.pouchdb.index.PouchDB(self__.name,self__.design_doc,self__.bootstrap_doc,self__.connection,self__.__meta,self__.__extmap,self__.__hash));
});

adapters.pouchdb.index.PouchDB.prototype.cljs$core$ICounted$_count$arity$1 = (function (this__25699__auto__){
var self__ = this;
var this__25699__auto____$1 = this;
return (4 + cljs.core.count.call(null,self__.__extmap));
});

adapters.pouchdb.index.PouchDB.prototype.offcourse$protocols$validatable$Validatable$ = true;

adapters.pouchdb.index.PouchDB.prototype.offcourse$protocols$validatable$Validatable$errors_async$arity$1 = (function (db){
var self__ = this;
var db__$1 = this;
return adapters.pouchdb.implementations.validatable.errors_async.call(null,db__$1);
});

adapters.pouchdb.index.PouchDB.prototype.offcourse$protocols$validatable$Validatable$valid_QMARK__async$arity$1 = (function (db){
var self__ = this;
var db__$1 = this;
return adapters.pouchdb.implementations.validatable.valid_QMARK__async.call(null,db__$1);
});

adapters.pouchdb.index.PouchDB.prototype.cljs$core$IHash$_hash$arity$1 = (function (this__25690__auto__){
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

adapters.pouchdb.index.PouchDB.prototype.cljs$core$IEquiv$_equiv$arity$2 = (function (this__25691__auto__,other__25692__auto__){
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

adapters.pouchdb.index.PouchDB.prototype.cljs$core$IMap$_dissoc$arity$2 = (function (this__25704__auto__,k__25705__auto__){
var self__ = this;
var this__25704__auto____$1 = this;
if(cljs.core.contains_QMARK_.call(null,new cljs.core.PersistentHashSet(null, new cljs.core.PersistentArrayMap(null, 4, [new cljs.core.Keyword(null,"name","name",1843675177),null,new cljs.core.Keyword(null,"bootstrap-doc","bootstrap-doc",-908945544),null,new cljs.core.Keyword(null,"design-doc","design-doc",-98897062),null,new cljs.core.Keyword(null,"connection","connection",-123599300),null], null), null),k__25705__auto__)){
return cljs.core.dissoc.call(null,cljs.core.with_meta.call(null,cljs.core.into.call(null,cljs.core.PersistentArrayMap.EMPTY,this__25704__auto____$1),self__.__meta),k__25705__auto__);
} else {
return (new adapters.pouchdb.index.PouchDB(self__.name,self__.design_doc,self__.bootstrap_doc,self__.connection,self__.__meta,cljs.core.not_empty.call(null,cljs.core.dissoc.call(null,self__.__extmap,k__25705__auto__)),null));
}
});

adapters.pouchdb.index.PouchDB.prototype.cljs$core$IAssociative$_assoc$arity$3 = (function (this__25702__auto__,k__25703__auto__,G__37953){
var self__ = this;
var this__25702__auto____$1 = this;
var pred__37957 = cljs.core.keyword_identical_QMARK_;
var expr__37958 = k__25703__auto__;
if(cljs.core.truth_(pred__37957.call(null,new cljs.core.Keyword(null,"name","name",1843675177),expr__37958))){
return (new adapters.pouchdb.index.PouchDB(G__37953,self__.design_doc,self__.bootstrap_doc,self__.connection,self__.__meta,self__.__extmap,null));
} else {
if(cljs.core.truth_(pred__37957.call(null,new cljs.core.Keyword(null,"design-doc","design-doc",-98897062),expr__37958))){
return (new adapters.pouchdb.index.PouchDB(self__.name,G__37953,self__.bootstrap_doc,self__.connection,self__.__meta,self__.__extmap,null));
} else {
if(cljs.core.truth_(pred__37957.call(null,new cljs.core.Keyword(null,"bootstrap-doc","bootstrap-doc",-908945544),expr__37958))){
return (new adapters.pouchdb.index.PouchDB(self__.name,self__.design_doc,G__37953,self__.connection,self__.__meta,self__.__extmap,null));
} else {
if(cljs.core.truth_(pred__37957.call(null,new cljs.core.Keyword(null,"connection","connection",-123599300),expr__37958))){
return (new adapters.pouchdb.index.PouchDB(self__.name,self__.design_doc,self__.bootstrap_doc,G__37953,self__.__meta,self__.__extmap,null));
} else {
return (new adapters.pouchdb.index.PouchDB(self__.name,self__.design_doc,self__.bootstrap_doc,self__.connection,self__.__meta,cljs.core.assoc.call(null,self__.__extmap,k__25703__auto__,G__37953),null));
}
}
}
}
});

adapters.pouchdb.index.PouchDB.prototype.cljs$core$ISeqable$_seq$arity$1 = (function (this__25707__auto__){
var self__ = this;
var this__25707__auto____$1 = this;
return cljs.core.seq.call(null,cljs.core.concat.call(null,new cljs.core.PersistentVector(null, 4, 5, cljs.core.PersistentVector.EMPTY_NODE, [(new cljs.core.PersistentVector(null,2,(5),cljs.core.PersistentVector.EMPTY_NODE,[new cljs.core.Keyword(null,"name","name",1843675177),self__.name],null)),(new cljs.core.PersistentVector(null,2,(5),cljs.core.PersistentVector.EMPTY_NODE,[new cljs.core.Keyword(null,"design-doc","design-doc",-98897062),self__.design_doc],null)),(new cljs.core.PersistentVector(null,2,(5),cljs.core.PersistentVector.EMPTY_NODE,[new cljs.core.Keyword(null,"bootstrap-doc","bootstrap-doc",-908945544),self__.bootstrap_doc],null)),(new cljs.core.PersistentVector(null,2,(5),cljs.core.PersistentVector.EMPTY_NODE,[new cljs.core.Keyword(null,"connection","connection",-123599300),self__.connection],null))], null),self__.__extmap));
});

adapters.pouchdb.index.PouchDB.prototype.offcourse$protocols$queryable$Queryable$ = true;

adapters.pouchdb.index.PouchDB.prototype.offcourse$protocols$queryable$Queryable$fetch$arity$2 = (function (db,query){
var self__ = this;
var db__$1 = this;
cljs.core.println.call(null,query);

return adapters.pouchdb.wrapper.fetch.call(null,db__$1,query);
});

adapters.pouchdb.index.PouchDB.prototype.offcourse$protocols$bootstrappable$Bootstrappable$ = true;

adapters.pouchdb.index.PouchDB.prototype.offcourse$protocols$bootstrappable$Bootstrappable$bootstrap$arity$1 = (function (db){
var self__ = this;
var db__$1 = this;
return adapters.pouchdb.implementations.bootstrappable.bootstrap.call(null,db__$1);
});

adapters.pouchdb.index.PouchDB.prototype.cljs$core$IWithMeta$_with_meta$arity$2 = (function (this__25694__auto__,G__37953){
var self__ = this;
var this__25694__auto____$1 = this;
return (new adapters.pouchdb.index.PouchDB(self__.name,self__.design_doc,self__.bootstrap_doc,self__.connection,G__37953,self__.__extmap,self__.__hash));
});

adapters.pouchdb.index.PouchDB.prototype.cljs$core$ICollection$_conj$arity$2 = (function (this__25700__auto__,entry__25701__auto__){
var self__ = this;
var this__25700__auto____$1 = this;
if(cljs.core.vector_QMARK_.call(null,entry__25701__auto__)){
return cljs.core._assoc.call(null,this__25700__auto____$1,cljs.core._nth.call(null,entry__25701__auto__,(0)),cljs.core._nth.call(null,entry__25701__auto__,(1)));
} else {
return cljs.core.reduce.call(null,cljs.core._conj,this__25700__auto____$1,entry__25701__auto__);
}
});

adapters.pouchdb.index.PouchDB.getBasis = (function (){
return new cljs.core.PersistentVector(null, 4, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Symbol(null,"name","name",-810760592,null),new cljs.core.Symbol(null,"design-doc","design-doc",1541634465,null),new cljs.core.Symbol(null,"bootstrap-doc","bootstrap-doc",731585983,null),new cljs.core.Symbol(null,"connection","connection",1516932227,null)], null);
});

adapters.pouchdb.index.PouchDB.cljs$lang$type = true;

adapters.pouchdb.index.PouchDB.cljs$lang$ctorPrSeq = (function (this__25729__auto__){
return cljs.core._conj.call(null,cljs.core.List.EMPTY,"adapters.pouchdb.index/PouchDB");
});

adapters.pouchdb.index.PouchDB.cljs$lang$ctorPrWriter = (function (this__25729__auto__,writer__25730__auto__){
return cljs.core._write.call(null,writer__25730__auto__,"adapters.pouchdb.index/PouchDB");
});

adapters.pouchdb.index.__GT_PouchDB = (function adapters$pouchdb$index$__GT_PouchDB(name,design_doc,bootstrap_doc,connection){
return (new adapters.pouchdb.index.PouchDB(name,design_doc,bootstrap_doc,connection,null,null,null));
});

adapters.pouchdb.index.map__GT_PouchDB = (function adapters$pouchdb$index$map__GT_PouchDB(G__37955){
return (new adapters.pouchdb.index.PouchDB(new cljs.core.Keyword(null,"name","name",1843675177).cljs$core$IFn$_invoke$arity$1(G__37955),new cljs.core.Keyword(null,"design-doc","design-doc",-98897062).cljs$core$IFn$_invoke$arity$1(G__37955),new cljs.core.Keyword(null,"bootstrap-doc","bootstrap-doc",-908945544).cljs$core$IFn$_invoke$arity$1(G__37955),new cljs.core.Keyword(null,"connection","connection",-123599300).cljs$core$IFn$_invoke$arity$1(G__37955),null,cljs.core.dissoc.call(null,G__37955,new cljs.core.Keyword(null,"name","name",1843675177),new cljs.core.Keyword(null,"design-doc","design-doc",-98897062),new cljs.core.Keyword(null,"bootstrap-doc","bootstrap-doc",-908945544),new cljs.core.Keyword(null,"connection","connection",-123599300)),null));
});

adapters.pouchdb.index.new_db = (function adapters$pouchdb$index$new_db(name,design_doc,bootstrap_doc){
return adapters.pouchdb.index.map__GT_PouchDB.call(null,new cljs.core.PersistentArrayMap(null, 3, [new cljs.core.Keyword(null,"name","name",1843675177),name,new cljs.core.Keyword(null,"design-doc","design-doc",-98897062),design_doc,new cljs.core.Keyword(null,"bootstrap-doc","bootstrap-doc",-908945544),bootstrap_doc], null));
});

//# sourceMappingURL=index.js.map