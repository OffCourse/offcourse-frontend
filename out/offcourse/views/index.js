// Compiled by ClojureScript 1.7.170 {}
goog.provide('offcourse.views.index');
goog.require('cljs.core');
goog.require('cljs.core.async');
goog.require('com.stuartsierra.component');
goog.require('offcourse.views.debug');
if(typeof offcourse.views.index.counter !== 'undefined'){
} else {
offcourse.views.index.counter = cljs.core.atom.call(null,(0));
}
offcourse.views.index.render = (function offcourse$views$index$render(response){
return offcourse.views.debug.render.call(null,response);
});
offcourse.views.index.listen = (function offcourse$views$index$listen(channel){
var c__27362__auto__ = cljs.core.async.chan.call(null,(1));
cljs.core.async.impl.dispatch.run.call(null,((function (c__27362__auto__){
return (function (){
var f__27363__auto__ = (function (){var switch__27341__auto__ = ((function (c__27362__auto__){
return (function (state_28585){
var state_val_28586 = (state_28585[(1)]);
if((state_val_28586 === (1))){
var state_28585__$1 = state_28585;
var statearr_28587_28597 = state_28585__$1;
(statearr_28587_28597[(2)] = null);

(statearr_28587_28597[(1)] = (2));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_28586 === (2))){
var state_28585__$1 = state_28585;
return cljs.core.async.impl.ioc_helpers.take_BANG_.call(null,state_28585__$1,(4),channel);
} else {
if((state_val_28586 === (3))){
var inst_28583 = (state_28585[(2)]);
var state_28585__$1 = state_28585;
return cljs.core.async.impl.ioc_helpers.return_chan.call(null,state_28585__$1,inst_28583);
} else {
if((state_val_28586 === (4))){
var inst_28576 = (state_28585[(2)]);
var inst_28577 = cljs.core.swap_BANG_.call(null,offcourse.views.index.counter,cljs.core.inc);
var inst_28578 = cljs.core.deref.call(null,offcourse.views.index.counter);
var inst_28579 = cljs.core.println.call(null,"rerender:",inst_28578);
var inst_28580 = offcourse.views.index.render.call(null,inst_28576);
var state_28585__$1 = (function (){var statearr_28588 = state_28585;
(statearr_28588[(7)] = inst_28579);

(statearr_28588[(8)] = inst_28577);

(statearr_28588[(9)] = inst_28580);

return statearr_28588;
})();
var statearr_28589_28598 = state_28585__$1;
(statearr_28589_28598[(2)] = null);

(statearr_28589_28598[(1)] = (2));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
return null;
}
}
}
}
});})(c__27362__auto__))
;
return ((function (switch__27341__auto__,c__27362__auto__){
return (function() {
var offcourse$views$index$listen_$_state_machine__27342__auto__ = null;
var offcourse$views$index$listen_$_state_machine__27342__auto____0 = (function (){
var statearr_28593 = [null,null,null,null,null,null,null,null,null,null];
(statearr_28593[(0)] = offcourse$views$index$listen_$_state_machine__27342__auto__);

(statearr_28593[(1)] = (1));

return statearr_28593;
});
var offcourse$views$index$listen_$_state_machine__27342__auto____1 = (function (state_28585){
while(true){
var ret_value__27343__auto__ = (function (){try{while(true){
var result__27344__auto__ = switch__27341__auto__.call(null,state_28585);
if(cljs.core.keyword_identical_QMARK_.call(null,result__27344__auto__,new cljs.core.Keyword(null,"recur","recur",-437573268))){
continue;
} else {
return result__27344__auto__;
}
break;
}
}catch (e28594){if((e28594 instanceof Object)){
var ex__27345__auto__ = e28594;
var statearr_28595_28599 = state_28585;
(statearr_28595_28599[(5)] = ex__27345__auto__);


cljs.core.async.impl.ioc_helpers.process_exception.call(null,state_28585);

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
throw e28594;

}
}})();
if(cljs.core.keyword_identical_QMARK_.call(null,ret_value__27343__auto__,new cljs.core.Keyword(null,"recur","recur",-437573268))){
var G__28600 = state_28585;
state_28585 = G__28600;
continue;
} else {
return ret_value__27343__auto__;
}
break;
}
});
offcourse$views$index$listen_$_state_machine__27342__auto__ = function(state_28585){
switch(arguments.length){
case 0:
return offcourse$views$index$listen_$_state_machine__27342__auto____0.call(this);
case 1:
return offcourse$views$index$listen_$_state_machine__27342__auto____1.call(this,state_28585);
}
throw(new Error('Invalid arity: ' + arguments.length));
};
offcourse$views$index$listen_$_state_machine__27342__auto__.cljs$core$IFn$_invoke$arity$0 = offcourse$views$index$listen_$_state_machine__27342__auto____0;
offcourse$views$index$listen_$_state_machine__27342__auto__.cljs$core$IFn$_invoke$arity$1 = offcourse$views$index$listen_$_state_machine__27342__auto____1;
return offcourse$views$index$listen_$_state_machine__27342__auto__;
})()
;})(switch__27341__auto__,c__27362__auto__))
})();
var state__27364__auto__ = (function (){var statearr_28596 = f__27363__auto__.call(null);
(statearr_28596[cljs.core.async.impl.ioc_helpers.USER_START_IDX] = c__27362__auto__);

return statearr_28596;
})();
return cljs.core.async.impl.ioc_helpers.run_state_machine_wrapped.call(null,state__27364__auto__);
});})(c__27362__auto__))
);

return c__27362__auto__;
});

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
offcourse.views.index.Renderer = (function (listener,input_channel,__meta,__extmap,__hash){
this.listener = listener;
this.input_channel = input_channel;
this.__meta = __meta;
this.__extmap = __extmap;
this.__hash = __hash;
this.cljs$lang$protocol_mask$partition0$ = 2229667594;
this.cljs$lang$protocol_mask$partition1$ = 8192;
})
offcourse.views.index.Renderer.prototype.cljs$core$ILookup$_lookup$arity$2 = (function (this__25615__auto__,k__25616__auto__){
var self__ = this;
var this__25615__auto____$1 = this;
return cljs.core._lookup.call(null,this__25615__auto____$1,k__25616__auto__,null);
});

offcourse.views.index.Renderer.prototype.cljs$core$ILookup$_lookup$arity$3 = (function (this__25617__auto__,k28602,else__25618__auto__){
var self__ = this;
var this__25617__auto____$1 = this;
var G__28604 = (((k28602 instanceof cljs.core.Keyword))?k28602.fqn:null);
switch (G__28604) {
case "listener":
return self__.listener;

break;
case "input-channel":
return self__.input_channel;

break;
default:
return cljs.core.get.call(null,self__.__extmap,k28602,else__25618__auto__);

}
});

offcourse.views.index.Renderer.prototype.cljs$core$IPrintWithWriter$_pr_writer$arity$3 = (function (this__25629__auto__,writer__25630__auto__,opts__25631__auto__){
var self__ = this;
var this__25629__auto____$1 = this;
var pr_pair__25632__auto__ = ((function (this__25629__auto____$1){
return (function (keyval__25633__auto__){
return cljs.core.pr_sequential_writer.call(null,writer__25630__auto__,cljs.core.pr_writer,""," ","",opts__25631__auto__,keyval__25633__auto__);
});})(this__25629__auto____$1))
;
return cljs.core.pr_sequential_writer.call(null,writer__25630__auto__,pr_pair__25632__auto__,"#offcourse.views.index.Renderer{",", ","}",opts__25631__auto__,cljs.core.concat.call(null,new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [(new cljs.core.PersistentVector(null,2,(5),cljs.core.PersistentVector.EMPTY_NODE,[new cljs.core.Keyword(null,"listener","listener",882147248),self__.listener],null)),(new cljs.core.PersistentVector(null,2,(5),cljs.core.PersistentVector.EMPTY_NODE,[new cljs.core.Keyword(null,"input-channel","input-channel",1891525728),self__.input_channel],null))], null),self__.__extmap));
});

offcourse.views.index.Renderer.prototype.cljs$core$IIterable$ = true;

offcourse.views.index.Renderer.prototype.cljs$core$IIterable$_iterator$arity$1 = (function (G__28601){
var self__ = this;
var G__28601__$1 = this;
return (new cljs.core.RecordIter((0),G__28601__$1,2,new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Keyword(null,"listener","listener",882147248),new cljs.core.Keyword(null,"input-channel","input-channel",1891525728)], null),cljs.core._iterator.call(null,self__.__extmap)));
});

offcourse.views.index.Renderer.prototype.cljs$core$IMeta$_meta$arity$1 = (function (this__25613__auto__){
var self__ = this;
var this__25613__auto____$1 = this;
return self__.__meta;
});

offcourse.views.index.Renderer.prototype.cljs$core$ICloneable$_clone$arity$1 = (function (this__25609__auto__){
var self__ = this;
var this__25609__auto____$1 = this;
return (new offcourse.views.index.Renderer(self__.listener,self__.input_channel,self__.__meta,self__.__extmap,self__.__hash));
});

offcourse.views.index.Renderer.prototype.cljs$core$ICounted$_count$arity$1 = (function (this__25619__auto__){
var self__ = this;
var this__25619__auto____$1 = this;
return (2 + cljs.core.count.call(null,self__.__extmap));
});

offcourse.views.index.Renderer.prototype.cljs$core$IHash$_hash$arity$1 = (function (this__25610__auto__){
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

offcourse.views.index.Renderer.prototype.cljs$core$IEquiv$_equiv$arity$2 = (function (this__25611__auto__,other__25612__auto__){
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

offcourse.views.index.Renderer.prototype.cljs$core$IMap$_dissoc$arity$2 = (function (this__25624__auto__,k__25625__auto__){
var self__ = this;
var this__25624__auto____$1 = this;
if(cljs.core.contains_QMARK_.call(null,new cljs.core.PersistentHashSet(null, new cljs.core.PersistentArrayMap(null, 2, [new cljs.core.Keyword(null,"input-channel","input-channel",1891525728),null,new cljs.core.Keyword(null,"listener","listener",882147248),null], null), null),k__25625__auto__)){
return cljs.core.dissoc.call(null,cljs.core.with_meta.call(null,cljs.core.into.call(null,cljs.core.PersistentArrayMap.EMPTY,this__25624__auto____$1),self__.__meta),k__25625__auto__);
} else {
return (new offcourse.views.index.Renderer(self__.listener,self__.input_channel,self__.__meta,cljs.core.not_empty.call(null,cljs.core.dissoc.call(null,self__.__extmap,k__25625__auto__)),null));
}
});

offcourse.views.index.Renderer.prototype.cljs$core$IAssociative$_assoc$arity$3 = (function (this__25622__auto__,k__25623__auto__,G__28601){
var self__ = this;
var this__25622__auto____$1 = this;
var pred__28605 = cljs.core.keyword_identical_QMARK_;
var expr__28606 = k__25623__auto__;
if(cljs.core.truth_(pred__28605.call(null,new cljs.core.Keyword(null,"listener","listener",882147248),expr__28606))){
return (new offcourse.views.index.Renderer(G__28601,self__.input_channel,self__.__meta,self__.__extmap,null));
} else {
if(cljs.core.truth_(pred__28605.call(null,new cljs.core.Keyword(null,"input-channel","input-channel",1891525728),expr__28606))){
return (new offcourse.views.index.Renderer(self__.listener,G__28601,self__.__meta,self__.__extmap,null));
} else {
return (new offcourse.views.index.Renderer(self__.listener,self__.input_channel,self__.__meta,cljs.core.assoc.call(null,self__.__extmap,k__25623__auto__,G__28601),null));
}
}
});

offcourse.views.index.Renderer.prototype.cljs$core$ISeqable$_seq$arity$1 = (function (this__25627__auto__){
var self__ = this;
var this__25627__auto____$1 = this;
return cljs.core.seq.call(null,cljs.core.concat.call(null,new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [(new cljs.core.PersistentVector(null,2,(5),cljs.core.PersistentVector.EMPTY_NODE,[new cljs.core.Keyword(null,"listener","listener",882147248),self__.listener],null)),(new cljs.core.PersistentVector(null,2,(5),cljs.core.PersistentVector.EMPTY_NODE,[new cljs.core.Keyword(null,"input-channel","input-channel",1891525728),self__.input_channel],null))], null),self__.__extmap));
});

offcourse.views.index.Renderer.prototype.cljs$core$IWithMeta$_with_meta$arity$2 = (function (this__25614__auto__,G__28601){
var self__ = this;
var this__25614__auto____$1 = this;
return (new offcourse.views.index.Renderer(self__.listener,self__.input_channel,G__28601,self__.__extmap,self__.__hash));
});

offcourse.views.index.Renderer.prototype.cljs$core$ICollection$_conj$arity$2 = (function (this__25620__auto__,entry__25621__auto__){
var self__ = this;
var this__25620__auto____$1 = this;
if(cljs.core.vector_QMARK_.call(null,entry__25621__auto__)){
return cljs.core._assoc.call(null,this__25620__auto____$1,cljs.core._nth.call(null,entry__25621__auto__,(0)),cljs.core._nth.call(null,entry__25621__auto__,(1)));
} else {
return cljs.core.reduce.call(null,cljs.core._conj,this__25620__auto____$1,entry__25621__auto__);
}
});

offcourse.views.index.Renderer.prototype.com$stuartsierra$component$Lifecycle$ = true;

offcourse.views.index.Renderer.prototype.com$stuartsierra$component$Lifecycle$start$arity$1 = (function (api){
var self__ = this;
var api__$1 = this;
return cljs.core.assoc.call(null,api__$1,new cljs.core.Keyword(null,"listener","listener",882147248),offcourse.views.index.listen.call(null,self__.input_channel));
});

offcourse.views.index.Renderer.prototype.com$stuartsierra$component$Lifecycle$stop$arity$1 = (function (api){
var self__ = this;
var api__$1 = this;
cljs.core.async.close_BANG_.call(null,self__.input_channel);

return cljs.core.dissoc.call(null,api__$1,new cljs.core.Keyword(null,"listener","listener",882147248));
});

offcourse.views.index.Renderer.getBasis = (function (){
return new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Symbol(null,"listener","listener",-1772288521,null),new cljs.core.Symbol(null,"input-channel","input-channel",-762910041,null)], null);
});

offcourse.views.index.Renderer.cljs$lang$type = true;

offcourse.views.index.Renderer.cljs$lang$ctorPrSeq = (function (this__25649__auto__){
return cljs.core._conj.call(null,cljs.core.List.EMPTY,"offcourse.views.index/Renderer");
});

offcourse.views.index.Renderer.cljs$lang$ctorPrWriter = (function (this__25649__auto__,writer__25650__auto__){
return cljs.core._write.call(null,writer__25650__auto__,"offcourse.views.index/Renderer");
});

offcourse.views.index.__GT_Renderer = (function offcourse$views$index$__GT_Renderer(listener,input_channel){
return (new offcourse.views.index.Renderer(listener,input_channel,null,null,null));
});

offcourse.views.index.map__GT_Renderer = (function offcourse$views$index$map__GT_Renderer(G__28603){
return (new offcourse.views.index.Renderer(new cljs.core.Keyword(null,"listener","listener",882147248).cljs$core$IFn$_invoke$arity$1(G__28603),new cljs.core.Keyword(null,"input-channel","input-channel",1891525728).cljs$core$IFn$_invoke$arity$1(G__28603),null,cljs.core.dissoc.call(null,G__28603,new cljs.core.Keyword(null,"listener","listener",882147248),new cljs.core.Keyword(null,"input-channel","input-channel",1891525728)),null));
});

offcourse.views.index.new_renderer = (function offcourse$views$index$new_renderer(){
return offcourse.views.index.map__GT_Renderer.call(null,cljs.core.PersistentArrayMap.EMPTY);
});

//# sourceMappingURL=index.js.map