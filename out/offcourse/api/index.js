// Compiled by ClojureScript 1.7.170 {}
goog.provide('offcourse.api.index');
goog.require('cljs.core');
goog.require('cljs.core.async');
goog.require('com.stuartsierra.component');
goog.require('offcourse.adapters.pouchdb');
offcourse.api.index.listen = (function offcourse$api$index$listen(p__28238){
var map__28262 = p__28238;
var map__28262__$1 = ((((!((map__28262 == null)))?((((map__28262.cljs$lang$protocol_mask$partition0$ & (64))) || (map__28262.cljs$core$ISeq$))?true:false):false))?cljs.core.apply.call(null,cljs.core.hash_map,map__28262):map__28262);
var output_channel = cljs.core.get.call(null,map__28262__$1,new cljs.core.Keyword(null,"output-channel","output-channel",338004025));
var input_channel = cljs.core.get.call(null,map__28262__$1,new cljs.core.Keyword(null,"input-channel","input-channel",1891525728));
var c__27362__auto__ = cljs.core.async.chan.call(null,(1));
cljs.core.async.impl.dispatch.run.call(null,((function (c__27362__auto__,map__28262,map__28262__$1,output_channel,input_channel){
return (function (){
var f__27363__auto__ = (function (){var switch__27341__auto__ = ((function (c__27362__auto__,map__28262,map__28262__$1,output_channel,input_channel){
return (function (state_28273){
var state_val_28274 = (state_28273[(1)]);
if((state_val_28274 === (1))){
var state_28273__$1 = state_28273;
var statearr_28275_28285 = state_28273__$1;
(statearr_28275_28285[(2)] = null);

(statearr_28275_28285[(1)] = (2));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_28274 === (2))){
var state_28273__$1 = state_28273;
return cljs.core.async.impl.ioc_helpers.take_BANG_.call(null,state_28273__$1,(4),input_channel);
} else {
if((state_val_28274 === (3))){
var inst_28271 = (state_28273[(2)]);
var state_28273__$1 = state_28273;
return cljs.core.async.impl.ioc_helpers.return_chan.call(null,state_28273__$1,inst_28271);
} else {
if((state_val_28274 === (4))){
var inst_28266 = (state_28273[(2)]);
var state_28273__$1 = state_28273;
return cljs.core.async.impl.ioc_helpers.put_BANG_.call(null,state_28273__$1,(5),output_channel,inst_28266);
} else {
if((state_val_28274 === (5))){
var inst_28268 = (state_28273[(2)]);
var state_28273__$1 = (function (){var statearr_28276 = state_28273;
(statearr_28276[(7)] = inst_28268);

return statearr_28276;
})();
var statearr_28277_28286 = state_28273__$1;
(statearr_28277_28286[(2)] = null);

(statearr_28277_28286[(1)] = (2));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
return null;
}
}
}
}
}
});})(c__27362__auto__,map__28262,map__28262__$1,output_channel,input_channel))
;
return ((function (switch__27341__auto__,c__27362__auto__,map__28262,map__28262__$1,output_channel,input_channel){
return (function() {
var offcourse$api$index$listen_$_state_machine__27342__auto__ = null;
var offcourse$api$index$listen_$_state_machine__27342__auto____0 = (function (){
var statearr_28281 = [null,null,null,null,null,null,null,null];
(statearr_28281[(0)] = offcourse$api$index$listen_$_state_machine__27342__auto__);

(statearr_28281[(1)] = (1));

return statearr_28281;
});
var offcourse$api$index$listen_$_state_machine__27342__auto____1 = (function (state_28273){
while(true){
var ret_value__27343__auto__ = (function (){try{while(true){
var result__27344__auto__ = switch__27341__auto__.call(null,state_28273);
if(cljs.core.keyword_identical_QMARK_.call(null,result__27344__auto__,new cljs.core.Keyword(null,"recur","recur",-437573268))){
continue;
} else {
return result__27344__auto__;
}
break;
}
}catch (e28282){if((e28282 instanceof Object)){
var ex__27345__auto__ = e28282;
var statearr_28283_28287 = state_28273;
(statearr_28283_28287[(5)] = ex__27345__auto__);


cljs.core.async.impl.ioc_helpers.process_exception.call(null,state_28273);

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
throw e28282;

}
}})();
if(cljs.core.keyword_identical_QMARK_.call(null,ret_value__27343__auto__,new cljs.core.Keyword(null,"recur","recur",-437573268))){
var G__28288 = state_28273;
state_28273 = G__28288;
continue;
} else {
return ret_value__27343__auto__;
}
break;
}
});
offcourse$api$index$listen_$_state_machine__27342__auto__ = function(state_28273){
switch(arguments.length){
case 0:
return offcourse$api$index$listen_$_state_machine__27342__auto____0.call(this);
case 1:
return offcourse$api$index$listen_$_state_machine__27342__auto____1.call(this,state_28273);
}
throw(new Error('Invalid arity: ' + arguments.length));
};
offcourse$api$index$listen_$_state_machine__27342__auto__.cljs$core$IFn$_invoke$arity$0 = offcourse$api$index$listen_$_state_machine__27342__auto____0;
offcourse$api$index$listen_$_state_machine__27342__auto__.cljs$core$IFn$_invoke$arity$1 = offcourse$api$index$listen_$_state_machine__27342__auto____1;
return offcourse$api$index$listen_$_state_machine__27342__auto__;
})()
;})(switch__27341__auto__,c__27362__auto__,map__28262,map__28262__$1,output_channel,input_channel))
})();
var state__27364__auto__ = (function (){var statearr_28284 = f__27363__auto__.call(null);
(statearr_28284[cljs.core.async.impl.ioc_helpers.USER_START_IDX] = c__27362__auto__);

return statearr_28284;
})();
return cljs.core.async.impl.ioc_helpers.run_state_machine_wrapped.call(null,state__27364__auto__);
});})(c__27362__auto__,map__28262,map__28262__$1,output_channel,input_channel))
);

return c__27362__auto__;
});
offcourse.api.index.bootstrap = (function offcourse$api$index$bootstrap(p__28289){
var map__28356 = p__28289;
var map__28356__$1 = ((((!((map__28356 == null)))?((((map__28356.cljs$lang$protocol_mask$partition0$ & (64))) || (map__28356.cljs$core$ISeq$))?true:false):false))?cljs.core.apply.call(null,cljs.core.hash_map,map__28356):map__28356);
var api = map__28356__$1;
var output_channel = cljs.core.get.call(null,map__28356__$1,new cljs.core.Keyword(null,"output-channel","output-channel",338004025));
var input_channel = cljs.core.get.call(null,map__28356__$1,new cljs.core.Keyword(null,"input-channel","input-channel",1891525728));
var status = cljs.core.get.call(null,map__28356__$1,new cljs.core.Keyword(null,"status","status",-1997798413));
var service = cljs.core.get.call(null,map__28356__$1,new cljs.core.Keyword(null,"service","service",-1963054559));
var c__27362__auto__ = cljs.core.async.chan.call(null,(1));
cljs.core.async.impl.dispatch.run.call(null,((function (c__27362__auto__,map__28356,map__28356__$1,api,output_channel,input_channel,status,service){
return (function (){
var f__27363__auto__ = (function (){var switch__27341__auto__ = ((function (c__27362__auto__,map__28356,map__28356__$1,api,output_channel,input_channel,status,service){
return (function (state_28395){
var state_val_28396 = (state_28395[(1)]);
if((state_val_28396 === (7))){
var state_28395__$1 = state_28395;
var statearr_28397_28422 = state_28395__$1;
(statearr_28397_28422[(2)] = false);

(statearr_28397_28422[(1)] = (8));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_28396 === (1))){
var inst_28359 = offcourse.adapters.pouchdb.bootstrap.call(null,service);
var state_28395__$1 = state_28395;
return cljs.core.async.impl.ioc_helpers.take_BANG_.call(null,state_28395__$1,(2),inst_28359);
} else {
if((state_val_28396 === (4))){
var state_28395__$1 = state_28395;
var statearr_28398_28423 = state_28395__$1;
(statearr_28398_28423[(2)] = false);

(statearr_28398_28423[(1)] = (5));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_28396 === (15))){
var inst_28389 = (state_28395[(2)]);
var state_28395__$1 = state_28395;
var statearr_28399_28424 = state_28395__$1;
(statearr_28399_28424[(2)] = inst_28389);

(statearr_28399_28424[(1)] = (14));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_28396 === (13))){
var inst_28391 = offcourse.api.index.listen.call(null,api);
var state_28395__$1 = state_28395;
var statearr_28400_28425 = state_28395__$1;
(statearr_28400_28425[(2)] = inst_28391);

(statearr_28400_28425[(1)] = (14));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_28396 === (6))){
var state_28395__$1 = state_28395;
var statearr_28401_28426 = state_28395__$1;
(statearr_28401_28426[(2)] = true);

(statearr_28401_28426[(1)] = (8));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_28396 === (3))){
var inst_28361 = (state_28395[(7)]);
var inst_28366 = inst_28361.cljs$lang$protocol_mask$partition0$;
var inst_28367 = (inst_28366 & (64));
var inst_28368 = inst_28361.cljs$core$ISeq$;
var inst_28369 = (inst_28367) || (inst_28368);
var state_28395__$1 = state_28395;
if(cljs.core.truth_(inst_28369)){
var statearr_28402_28427 = state_28395__$1;
(statearr_28402_28427[(1)] = (6));

} else {
var statearr_28403_28428 = state_28395__$1;
(statearr_28403_28428[(1)] = (7));

}

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_28396 === (12))){
var inst_28381 = (state_28395[(8)]);
var inst_28385 = [new cljs.core.Keyword(null,"response","response",-1068424192)];
var inst_28386 = [inst_28381];
var inst_28387 = cljs.core.PersistentHashMap.fromArrays(inst_28385,inst_28386);
var state_28395__$1 = state_28395;
return cljs.core.async.impl.ioc_helpers.put_BANG_.call(null,state_28395__$1,(15),output_channel,inst_28387);
} else {
if((state_val_28396 === (2))){
var inst_28361 = (state_28395[(7)]);
var inst_28361__$1 = (state_28395[(2)]);
var inst_28363 = (inst_28361__$1 == null);
var inst_28364 = cljs.core.not.call(null,inst_28363);
var state_28395__$1 = (function (){var statearr_28404 = state_28395;
(statearr_28404[(7)] = inst_28361__$1);

return statearr_28404;
})();
if(inst_28364){
var statearr_28405_28429 = state_28395__$1;
(statearr_28405_28429[(1)] = (3));

} else {
var statearr_28406_28430 = state_28395__$1;
(statearr_28406_28430[(1)] = (4));

}

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_28396 === (11))){
var inst_28381 = (state_28395[(8)]);
var inst_28381__$1 = (state_28395[(2)]);
var inst_28382 = cljs.core.get.call(null,inst_28381__$1,new cljs.core.Keyword(null,"error","error",-978969032));
var inst_28383 = cljs.core.println.call(null,inst_28381__$1);
var state_28395__$1 = (function (){var statearr_28407 = state_28395;
(statearr_28407[(8)] = inst_28381__$1);

(statearr_28407[(9)] = inst_28383);

return statearr_28407;
})();
if(cljs.core.truth_(inst_28382)){
var statearr_28408_28431 = state_28395__$1;
(statearr_28408_28431[(1)] = (12));

} else {
var statearr_28409_28432 = state_28395__$1;
(statearr_28409_28432[(1)] = (13));

}

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_28396 === (9))){
var inst_28361 = (state_28395[(7)]);
var inst_28378 = cljs.core.apply.call(null,cljs.core.hash_map,inst_28361);
var state_28395__$1 = state_28395;
var statearr_28410_28433 = state_28395__$1;
(statearr_28410_28433[(2)] = inst_28378);

(statearr_28410_28433[(1)] = (11));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_28396 === (5))){
var inst_28376 = (state_28395[(2)]);
var state_28395__$1 = state_28395;
if(cljs.core.truth_(inst_28376)){
var statearr_28411_28434 = state_28395__$1;
(statearr_28411_28434[(1)] = (9));

} else {
var statearr_28412_28435 = state_28395__$1;
(statearr_28412_28435[(1)] = (10));

}

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_28396 === (14))){
var inst_28393 = (state_28395[(2)]);
var state_28395__$1 = state_28395;
return cljs.core.async.impl.ioc_helpers.return_chan.call(null,state_28395__$1,inst_28393);
} else {
if((state_val_28396 === (10))){
var inst_28361 = (state_28395[(7)]);
var state_28395__$1 = state_28395;
var statearr_28413_28436 = state_28395__$1;
(statearr_28413_28436[(2)] = inst_28361);

(statearr_28413_28436[(1)] = (11));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_28396 === (8))){
var inst_28373 = (state_28395[(2)]);
var state_28395__$1 = state_28395;
var statearr_28414_28437 = state_28395__$1;
(statearr_28414_28437[(2)] = inst_28373);

(statearr_28414_28437[(1)] = (5));


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
}
});})(c__27362__auto__,map__28356,map__28356__$1,api,output_channel,input_channel,status,service))
;
return ((function (switch__27341__auto__,c__27362__auto__,map__28356,map__28356__$1,api,output_channel,input_channel,status,service){
return (function() {
var offcourse$api$index$bootstrap_$_state_machine__27342__auto__ = null;
var offcourse$api$index$bootstrap_$_state_machine__27342__auto____0 = (function (){
var statearr_28418 = [null,null,null,null,null,null,null,null,null,null];
(statearr_28418[(0)] = offcourse$api$index$bootstrap_$_state_machine__27342__auto__);

(statearr_28418[(1)] = (1));

return statearr_28418;
});
var offcourse$api$index$bootstrap_$_state_machine__27342__auto____1 = (function (state_28395){
while(true){
var ret_value__27343__auto__ = (function (){try{while(true){
var result__27344__auto__ = switch__27341__auto__.call(null,state_28395);
if(cljs.core.keyword_identical_QMARK_.call(null,result__27344__auto__,new cljs.core.Keyword(null,"recur","recur",-437573268))){
continue;
} else {
return result__27344__auto__;
}
break;
}
}catch (e28419){if((e28419 instanceof Object)){
var ex__27345__auto__ = e28419;
var statearr_28420_28438 = state_28395;
(statearr_28420_28438[(5)] = ex__27345__auto__);


cljs.core.async.impl.ioc_helpers.process_exception.call(null,state_28395);

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
throw e28419;

}
}})();
if(cljs.core.keyword_identical_QMARK_.call(null,ret_value__27343__auto__,new cljs.core.Keyword(null,"recur","recur",-437573268))){
var G__28439 = state_28395;
state_28395 = G__28439;
continue;
} else {
return ret_value__27343__auto__;
}
break;
}
});
offcourse$api$index$bootstrap_$_state_machine__27342__auto__ = function(state_28395){
switch(arguments.length){
case 0:
return offcourse$api$index$bootstrap_$_state_machine__27342__auto____0.call(this);
case 1:
return offcourse$api$index$bootstrap_$_state_machine__27342__auto____1.call(this,state_28395);
}
throw(new Error('Invalid arity: ' + arguments.length));
};
offcourse$api$index$bootstrap_$_state_machine__27342__auto__.cljs$core$IFn$_invoke$arity$0 = offcourse$api$index$bootstrap_$_state_machine__27342__auto____0;
offcourse$api$index$bootstrap_$_state_machine__27342__auto__.cljs$core$IFn$_invoke$arity$1 = offcourse$api$index$bootstrap_$_state_machine__27342__auto____1;
return offcourse$api$index$bootstrap_$_state_machine__27342__auto__;
})()
;})(switch__27341__auto__,c__27362__auto__,map__28356,map__28356__$1,api,output_channel,input_channel,status,service))
})();
var state__27364__auto__ = (function (){var statearr_28421 = f__27363__auto__.call(null);
(statearr_28421[cljs.core.async.impl.ioc_helpers.USER_START_IDX] = c__27362__auto__);

return statearr_28421;
})();
return cljs.core.async.impl.ioc_helpers.run_state_machine_wrapped.call(null,state__27364__auto__);
});})(c__27362__auto__,map__28356,map__28356__$1,api,output_channel,input_channel,status,service))
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
offcourse.api.index.API.prototype.cljs$core$ILookup$_lookup$arity$2 = (function (this__25615__auto__,k__25616__auto__){
var self__ = this;
var this__25615__auto____$1 = this;
return cljs.core._lookup.call(null,this__25615__auto____$1,k__25616__auto__,null);
});

offcourse.api.index.API.prototype.cljs$core$ILookup$_lookup$arity$3 = (function (this__25617__auto__,k28441,else__25618__auto__){
var self__ = this;
var this__25617__auto____$1 = this;
var G__28443 = (((k28441 instanceof cljs.core.Keyword))?k28441.fqn:null);
switch (G__28443) {
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
return cljs.core.get.call(null,self__.__extmap,k28441,else__25618__auto__);

}
});

offcourse.api.index.API.prototype.cljs$core$IPrintWithWriter$_pr_writer$arity$3 = (function (this__25629__auto__,writer__25630__auto__,opts__25631__auto__){
var self__ = this;
var this__25629__auto____$1 = this;
var pr_pair__25632__auto__ = ((function (this__25629__auto____$1){
return (function (keyval__25633__auto__){
return cljs.core.pr_sequential_writer.call(null,writer__25630__auto__,cljs.core.pr_writer,""," ","",opts__25631__auto__,keyval__25633__auto__);
});})(this__25629__auto____$1))
;
return cljs.core.pr_sequential_writer.call(null,writer__25630__auto__,pr_pair__25632__auto__,"#offcourse.api.index.API{",", ","}",opts__25631__auto__,cljs.core.concat.call(null,new cljs.core.PersistentVector(null, 3, 5, cljs.core.PersistentVector.EMPTY_NODE, [(new cljs.core.PersistentVector(null,2,(5),cljs.core.PersistentVector.EMPTY_NODE,[new cljs.core.Keyword(null,"service","service",-1963054559),self__.service],null)),(new cljs.core.PersistentVector(null,2,(5),cljs.core.PersistentVector.EMPTY_NODE,[new cljs.core.Keyword(null,"output-channel","output-channel",338004025),self__.output_channel],null)),(new cljs.core.PersistentVector(null,2,(5),cljs.core.PersistentVector.EMPTY_NODE,[new cljs.core.Keyword(null,"input-channel","input-channel",1891525728),self__.input_channel],null))], null),self__.__extmap));
});

offcourse.api.index.API.prototype.cljs$core$IIterable$ = true;

offcourse.api.index.API.prototype.cljs$core$IIterable$_iterator$arity$1 = (function (G__28440){
var self__ = this;
var G__28440__$1 = this;
return (new cljs.core.RecordIter((0),G__28440__$1,3,new cljs.core.PersistentVector(null, 3, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Keyword(null,"service","service",-1963054559),new cljs.core.Keyword(null,"output-channel","output-channel",338004025),new cljs.core.Keyword(null,"input-channel","input-channel",1891525728)], null),cljs.core._iterator.call(null,self__.__extmap)));
});

offcourse.api.index.API.prototype.cljs$core$IMeta$_meta$arity$1 = (function (this__25613__auto__){
var self__ = this;
var this__25613__auto____$1 = this;
return self__.__meta;
});

offcourse.api.index.API.prototype.cljs$core$ICloneable$_clone$arity$1 = (function (this__25609__auto__){
var self__ = this;
var this__25609__auto____$1 = this;
return (new offcourse.api.index.API(self__.service,self__.output_channel,self__.input_channel,self__.__meta,self__.__extmap,self__.__hash));
});

offcourse.api.index.API.prototype.cljs$core$ICounted$_count$arity$1 = (function (this__25619__auto__){
var self__ = this;
var this__25619__auto____$1 = this;
return (3 + cljs.core.count.call(null,self__.__extmap));
});

offcourse.api.index.API.prototype.cljs$core$IHash$_hash$arity$1 = (function (this__25610__auto__){
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

offcourse.api.index.API.prototype.cljs$core$IEquiv$_equiv$arity$2 = (function (this__25611__auto__,other__25612__auto__){
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

offcourse.api.index.API.prototype.cljs$core$IMap$_dissoc$arity$2 = (function (this__25624__auto__,k__25625__auto__){
var self__ = this;
var this__25624__auto____$1 = this;
if(cljs.core.contains_QMARK_.call(null,new cljs.core.PersistentHashSet(null, new cljs.core.PersistentArrayMap(null, 3, [new cljs.core.Keyword(null,"input-channel","input-channel",1891525728),null,new cljs.core.Keyword(null,"service","service",-1963054559),null,new cljs.core.Keyword(null,"output-channel","output-channel",338004025),null], null), null),k__25625__auto__)){
return cljs.core.dissoc.call(null,cljs.core.with_meta.call(null,cljs.core.into.call(null,cljs.core.PersistentArrayMap.EMPTY,this__25624__auto____$1),self__.__meta),k__25625__auto__);
} else {
return (new offcourse.api.index.API(self__.service,self__.output_channel,self__.input_channel,self__.__meta,cljs.core.not_empty.call(null,cljs.core.dissoc.call(null,self__.__extmap,k__25625__auto__)),null));
}
});

offcourse.api.index.API.prototype.cljs$core$IAssociative$_assoc$arity$3 = (function (this__25622__auto__,k__25623__auto__,G__28440){
var self__ = this;
var this__25622__auto____$1 = this;
var pred__28444 = cljs.core.keyword_identical_QMARK_;
var expr__28445 = k__25623__auto__;
if(cljs.core.truth_(pred__28444.call(null,new cljs.core.Keyword(null,"service","service",-1963054559),expr__28445))){
return (new offcourse.api.index.API(G__28440,self__.output_channel,self__.input_channel,self__.__meta,self__.__extmap,null));
} else {
if(cljs.core.truth_(pred__28444.call(null,new cljs.core.Keyword(null,"output-channel","output-channel",338004025),expr__28445))){
return (new offcourse.api.index.API(self__.service,G__28440,self__.input_channel,self__.__meta,self__.__extmap,null));
} else {
if(cljs.core.truth_(pred__28444.call(null,new cljs.core.Keyword(null,"input-channel","input-channel",1891525728),expr__28445))){
return (new offcourse.api.index.API(self__.service,self__.output_channel,G__28440,self__.__meta,self__.__extmap,null));
} else {
return (new offcourse.api.index.API(self__.service,self__.output_channel,self__.input_channel,self__.__meta,cljs.core.assoc.call(null,self__.__extmap,k__25623__auto__,G__28440),null));
}
}
}
});

offcourse.api.index.API.prototype.cljs$core$ISeqable$_seq$arity$1 = (function (this__25627__auto__){
var self__ = this;
var this__25627__auto____$1 = this;
return cljs.core.seq.call(null,cljs.core.concat.call(null,new cljs.core.PersistentVector(null, 3, 5, cljs.core.PersistentVector.EMPTY_NODE, [(new cljs.core.PersistentVector(null,2,(5),cljs.core.PersistentVector.EMPTY_NODE,[new cljs.core.Keyword(null,"service","service",-1963054559),self__.service],null)),(new cljs.core.PersistentVector(null,2,(5),cljs.core.PersistentVector.EMPTY_NODE,[new cljs.core.Keyword(null,"output-channel","output-channel",338004025),self__.output_channel],null)),(new cljs.core.PersistentVector(null,2,(5),cljs.core.PersistentVector.EMPTY_NODE,[new cljs.core.Keyword(null,"input-channel","input-channel",1891525728),self__.input_channel],null))], null),self__.__extmap));
});

offcourse.api.index.API.prototype.cljs$core$IWithMeta$_with_meta$arity$2 = (function (this__25614__auto__,G__28440){
var self__ = this;
var this__25614__auto____$1 = this;
return (new offcourse.api.index.API(self__.service,self__.output_channel,self__.input_channel,G__28440,self__.__extmap,self__.__hash));
});

offcourse.api.index.API.prototype.cljs$core$ICollection$_conj$arity$2 = (function (this__25620__auto__,entry__25621__auto__){
var self__ = this;
var this__25620__auto____$1 = this;
if(cljs.core.vector_QMARK_.call(null,entry__25621__auto__)){
return cljs.core._assoc.call(null,this__25620__auto____$1,cljs.core._nth.call(null,entry__25621__auto__,(0)),cljs.core._nth.call(null,entry__25621__auto__,(1)));
} else {
return cljs.core.reduce.call(null,cljs.core._conj,this__25620__auto____$1,entry__25621__auto__);
}
});

offcourse.api.index.API.prototype.com$stuartsierra$component$Lifecycle$ = true;

offcourse.api.index.API.prototype.com$stuartsierra$component$Lifecycle$start$arity$1 = (function (api){
var self__ = this;
var api__$1 = this;
return cljs.core.assoc.call(null,api__$1,new cljs.core.Keyword(null,"listener","listener",882147248),offcourse.api.index.bootstrap.call(null,api__$1));
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

offcourse.api.index.API.cljs$lang$ctorPrSeq = (function (this__25649__auto__){
return cljs.core._conj.call(null,cljs.core.List.EMPTY,"offcourse.api.index/API");
});

offcourse.api.index.API.cljs$lang$ctorPrWriter = (function (this__25649__auto__,writer__25650__auto__){
return cljs.core._write.call(null,writer__25650__auto__,"offcourse.api.index/API");
});

offcourse.api.index.__GT_API = (function offcourse$api$index$__GT_API(service,output_channel,input_channel){
return (new offcourse.api.index.API(service,output_channel,input_channel,null,null,null));
});

offcourse.api.index.map__GT_API = (function offcourse$api$index$map__GT_API(G__28442){
return (new offcourse.api.index.API(new cljs.core.Keyword(null,"service","service",-1963054559).cljs$core$IFn$_invoke$arity$1(G__28442),new cljs.core.Keyword(null,"output-channel","output-channel",338004025).cljs$core$IFn$_invoke$arity$1(G__28442),new cljs.core.Keyword(null,"input-channel","input-channel",1891525728).cljs$core$IFn$_invoke$arity$1(G__28442),null,cljs.core.dissoc.call(null,G__28442,new cljs.core.Keyword(null,"service","service",-1963054559),new cljs.core.Keyword(null,"output-channel","output-channel",338004025),new cljs.core.Keyword(null,"input-channel","input-channel",1891525728)),null));
});

offcourse.api.index.new_api = (function offcourse$api$index$new_api(){
return offcourse.api.index.map__GT_API.call(null,cljs.core.PersistentArrayMap.EMPTY);
});

//# sourceMappingURL=index.js.map