// Compiled by ClojureScript 1.7.170 {}
goog.provide('offcourse.api.index');
goog.require('cljs.core');
goog.require('cljs.core.async');
goog.require('com.stuartsierra.component');
goog.require('offcourse.protocols.bootstrappable');
goog.require('offcourse.protocols.queryable');
goog.require('offcourse.api.implementations.bootstrappable');

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
 * @implements {cljs.core.IWithMeta}
 * @implements {cljs.core.IAssociative}
 * @implements {com.stuartsierra.component.Lifecycle}
 * @implements {cljs.core.IMap}
 * @implements {cljs.core.ILookup}
*/
offcourse.api.index.API = (function (service,output_channel,input_channel,__meta,__extmap,__hash){
this.service = service;
this.output_channel = output_channel;
this.input_channel = input_channel;
this.__meta = __meta;
this.__extmap = __extmap;
this.__hash = __hash;
this.cljs$lang$protocol_mask$partition0$ = 2229667594;
this.cljs$lang$protocol_mask$partition1$ = 8192;
})
offcourse.api.index.API.prototype.cljs$core$ILookup$_lookup$arity$2 = (function (this__25695__auto__,k__25696__auto__){
var self__ = this;
var this__25695__auto____$1 = this;
return cljs.core._lookup.call(null,this__25695__auto____$1,k__25696__auto__,null);
});

offcourse.api.index.API.prototype.cljs$core$ILookup$_lookup$arity$3 = (function (this__25697__auto__,k37102,else__25698__auto__){
var self__ = this;
var this__25697__auto____$1 = this;
var G__37104 = (((k37102 instanceof cljs.core.Keyword))?k37102.fqn:null);
switch (G__37104) {
case "service":
return self__.service;

break;
case "output-channel":
return self__.output_channel;

break;
case "input-channel":
return self__.input_channel;

break;
default:
return cljs.core.get.call(null,self__.__extmap,k37102,else__25698__auto__);

}
});

offcourse.api.index.API.prototype.cljs$core$IPrintWithWriter$_pr_writer$arity$3 = (function (this__25709__auto__,writer__25710__auto__,opts__25711__auto__){
var self__ = this;
var this__25709__auto____$1 = this;
var pr_pair__25712__auto__ = ((function (this__25709__auto____$1){
return (function (keyval__25713__auto__){
return cljs.core.pr_sequential_writer.call(null,writer__25710__auto__,cljs.core.pr_writer,""," ","",opts__25711__auto__,keyval__25713__auto__);
});})(this__25709__auto____$1))
;
return cljs.core.pr_sequential_writer.call(null,writer__25710__auto__,pr_pair__25712__auto__,"#offcourse.api.index.API{",", ","}",opts__25711__auto__,cljs.core.concat.call(null,new cljs.core.PersistentVector(null, 3, 5, cljs.core.PersistentVector.EMPTY_NODE, [(new cljs.core.PersistentVector(null,2,(5),cljs.core.PersistentVector.EMPTY_NODE,[new cljs.core.Keyword(null,"service","service",-1963054559),self__.service],null)),(new cljs.core.PersistentVector(null,2,(5),cljs.core.PersistentVector.EMPTY_NODE,[new cljs.core.Keyword(null,"output-channel","output-channel",338004025),self__.output_channel],null)),(new cljs.core.PersistentVector(null,2,(5),cljs.core.PersistentVector.EMPTY_NODE,[new cljs.core.Keyword(null,"input-channel","input-channel",1891525728),self__.input_channel],null))], null),self__.__extmap));
});

offcourse.api.index.API.prototype.cljs$core$IIterable$ = true;

offcourse.api.index.API.prototype.cljs$core$IIterable$_iterator$arity$1 = (function (G__37101){
var self__ = this;
var G__37101__$1 = this;
return (new cljs.core.RecordIter((0),G__37101__$1,3,new cljs.core.PersistentVector(null, 3, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Keyword(null,"service","service",-1963054559),new cljs.core.Keyword(null,"output-channel","output-channel",338004025),new cljs.core.Keyword(null,"input-channel","input-channel",1891525728)], null),cljs.core._iterator.call(null,self__.__extmap)));
});

offcourse.api.index.API.prototype.cljs$core$IMeta$_meta$arity$1 = (function (this__25693__auto__){
var self__ = this;
var this__25693__auto____$1 = this;
return self__.__meta;
});

offcourse.api.index.API.prototype.cljs$core$ICloneable$_clone$arity$1 = (function (this__25689__auto__){
var self__ = this;
var this__25689__auto____$1 = this;
return (new offcourse.api.index.API(self__.service,self__.output_channel,self__.input_channel,self__.__meta,self__.__extmap,self__.__hash));
});

offcourse.api.index.API.prototype.cljs$core$ICounted$_count$arity$1 = (function (this__25699__auto__){
var self__ = this;
var this__25699__auto____$1 = this;
return (3 + cljs.core.count.call(null,self__.__extmap));
});

offcourse.api.index.API.prototype.cljs$core$IHash$_hash$arity$1 = (function (this__25690__auto__){
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

offcourse.api.index.API.prototype.cljs$core$IEquiv$_equiv$arity$2 = (function (this__25691__auto__,other__25692__auto__){
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

offcourse.api.index.API.prototype.cljs$core$IMap$_dissoc$arity$2 = (function (this__25704__auto__,k__25705__auto__){
var self__ = this;
var this__25704__auto____$1 = this;
if(cljs.core.contains_QMARK_.call(null,new cljs.core.PersistentHashSet(null, new cljs.core.PersistentArrayMap(null, 3, [new cljs.core.Keyword(null,"input-channel","input-channel",1891525728),null,new cljs.core.Keyword(null,"service","service",-1963054559),null,new cljs.core.Keyword(null,"output-channel","output-channel",338004025),null], null), null),k__25705__auto__)){
return cljs.core.dissoc.call(null,cljs.core.with_meta.call(null,cljs.core.into.call(null,cljs.core.PersistentArrayMap.EMPTY,this__25704__auto____$1),self__.__meta),k__25705__auto__);
} else {
return (new offcourse.api.index.API(self__.service,self__.output_channel,self__.input_channel,self__.__meta,cljs.core.not_empty.call(null,cljs.core.dissoc.call(null,self__.__extmap,k__25705__auto__)),null));
}
});

offcourse.api.index.API.prototype.cljs$core$IAssociative$_assoc$arity$3 = (function (this__25702__auto__,k__25703__auto__,G__37101){
var self__ = this;
var this__25702__auto____$1 = this;
var pred__37105 = cljs.core.keyword_identical_QMARK_;
var expr__37106 = k__25703__auto__;
if(cljs.core.truth_(pred__37105.call(null,new cljs.core.Keyword(null,"service","service",-1963054559),expr__37106))){
return (new offcourse.api.index.API(G__37101,self__.output_channel,self__.input_channel,self__.__meta,self__.__extmap,null));
} else {
if(cljs.core.truth_(pred__37105.call(null,new cljs.core.Keyword(null,"output-channel","output-channel",338004025),expr__37106))){
return (new offcourse.api.index.API(self__.service,G__37101,self__.input_channel,self__.__meta,self__.__extmap,null));
} else {
if(cljs.core.truth_(pred__37105.call(null,new cljs.core.Keyword(null,"input-channel","input-channel",1891525728),expr__37106))){
return (new offcourse.api.index.API(self__.service,self__.output_channel,G__37101,self__.__meta,self__.__extmap,null));
} else {
return (new offcourse.api.index.API(self__.service,self__.output_channel,self__.input_channel,self__.__meta,cljs.core.assoc.call(null,self__.__extmap,k__25703__auto__,G__37101),null));
}
}
}
});

offcourse.api.index.API.prototype.cljs$core$ISeqable$_seq$arity$1 = (function (this__25707__auto__){
var self__ = this;
var this__25707__auto____$1 = this;
return cljs.core.seq.call(null,cljs.core.concat.call(null,new cljs.core.PersistentVector(null, 3, 5, cljs.core.PersistentVector.EMPTY_NODE, [(new cljs.core.PersistentVector(null,2,(5),cljs.core.PersistentVector.EMPTY_NODE,[new cljs.core.Keyword(null,"service","service",-1963054559),self__.service],null)),(new cljs.core.PersistentVector(null,2,(5),cljs.core.PersistentVector.EMPTY_NODE,[new cljs.core.Keyword(null,"output-channel","output-channel",338004025),self__.output_channel],null)),(new cljs.core.PersistentVector(null,2,(5),cljs.core.PersistentVector.EMPTY_NODE,[new cljs.core.Keyword(null,"input-channel","input-channel",1891525728),self__.input_channel],null))], null),self__.__extmap));
});

offcourse.api.index.API.prototype.offcourse$protocols$queryable$Queryable$ = true;

offcourse.api.index.API.prototype.offcourse$protocols$queryable$Queryable$fetch$arity$2 = (function (api,query){
var self__ = this;
var api__$1 = this;
return offcourse.protocols.queryable.fetch.call(null,new cljs.core.Keyword(null,"service","service",-1963054559).cljs$core$IFn$_invoke$arity$1(api__$1),query);
});

offcourse.api.index.API.prototype.offcourse$protocols$bootstrappable$Bootstrappable$ = true;

offcourse.api.index.API.prototype.offcourse$protocols$bootstrappable$Bootstrappable$bootstrap$arity$1 = (function (api){
var self__ = this;
var api__$1 = this;
return offcourse.api.implementations.bootstrappable.bootstrap.call(null,api__$1);
});

offcourse.api.index.API.prototype.cljs$core$IWithMeta$_with_meta$arity$2 = (function (this__25694__auto__,G__37101){
var self__ = this;
var this__25694__auto____$1 = this;
return (new offcourse.api.index.API(self__.service,self__.output_channel,self__.input_channel,G__37101,self__.__extmap,self__.__hash));
});

offcourse.api.index.API.prototype.cljs$core$ICollection$_conj$arity$2 = (function (this__25700__auto__,entry__25701__auto__){
var self__ = this;
var this__25700__auto____$1 = this;
if(cljs.core.vector_QMARK_.call(null,entry__25701__auto__)){
return cljs.core._assoc.call(null,this__25700__auto____$1,cljs.core._nth.call(null,entry__25701__auto__,(0)),cljs.core._nth.call(null,entry__25701__auto__,(1)));
} else {
return cljs.core.reduce.call(null,cljs.core._conj,this__25700__auto____$1,entry__25701__auto__);
}
});

offcourse.api.index.API.prototype.com$stuartsierra$component$Lifecycle$ = true;

offcourse.api.index.API.prototype.com$stuartsierra$component$Lifecycle$start$arity$1 = (function (api){
var self__ = this;
var api__$1 = this;
return cljs.core.assoc.call(null,api__$1,new cljs.core.Keyword(null,"listener","listener",882147248),offcourse.protocols.bootstrappable.bootstrap.call(null,api__$1));
});

offcourse.api.index.API.prototype.com$stuartsierra$component$Lifecycle$stop$arity$1 = (function (api){
var self__ = this;
var api__$1 = this;
cljs.core.async.close_BANG_.call(null,self__.input_channel);

return cljs.core.dissoc.call(null,api__$1,new cljs.core.Keyword(null,"listener","listener",882147248));
});

offcourse.api.index.API.getBasis = (function (){
return new cljs.core.PersistentVector(null, 3, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Symbol(null,"service","service",-322523032,null),new cljs.core.Symbol(null,"output-channel","output-channel",1978535552,null),new cljs.core.Symbol(null,"input-channel","input-channel",-762910041,null)], null);
});

offcourse.api.index.API.cljs$lang$type = true;

offcourse.api.index.API.cljs$lang$ctorPrSeq = (function (this__25729__auto__){
return cljs.core._conj.call(null,cljs.core.List.EMPTY,"offcourse.api.index/API");
});

offcourse.api.index.API.cljs$lang$ctorPrWriter = (function (this__25729__auto__,writer__25730__auto__){
return cljs.core._write.call(null,writer__25730__auto__,"offcourse.api.index/API");
});

offcourse.api.index.__GT_API = (function offcourse$api$index$__GT_API(service,output_channel,input_channel){
return (new offcourse.api.index.API(service,output_channel,input_channel,null,null,null));
});

offcourse.api.index.map__GT_API = (function offcourse$api$index$map__GT_API(G__37103){
return (new offcourse.api.index.API(new cljs.core.Keyword(null,"service","service",-1963054559).cljs$core$IFn$_invoke$arity$1(G__37103),new cljs.core.Keyword(null,"output-channel","output-channel",338004025).cljs$core$IFn$_invoke$arity$1(G__37103),new cljs.core.Keyword(null,"input-channel","input-channel",1891525728).cljs$core$IFn$_invoke$arity$1(G__37103),null,cljs.core.dissoc.call(null,G__37103,new cljs.core.Keyword(null,"service","service",-1963054559),new cljs.core.Keyword(null,"output-channel","output-channel",338004025),new cljs.core.Keyword(null,"input-channel","input-channel",1891525728)),null));
});

offcourse.api.index.new_api = (function offcourse$api$index$new_api(){
return offcourse.api.index.map__GT_API.call(null,cljs.core.PersistentArrayMap.EMPTY);
});

//# sourceMappingURL=index.js.map