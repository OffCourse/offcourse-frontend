// Compiled by ClojureScript 1.7.170 {}
goog.provide('rum.core');
goog.require('cljs.core');
goog.require('cljsjs.react');
goog.require('cljsjs.react.dom');
goog.require('sablono.core');
var last_id_28562 = cljs.core.volatile_BANG_.call(null,(0));
rum.core.next_id = ((function (last_id_28562){
return (function rum$core$next_id(){
return cljs.core._vreset_BANG_.call(null,last_id_28562,(cljs.core._deref.call(null,last_id_28562) + (1)));
});})(last_id_28562))
;
rum.core.state = (function rum$core$state(comp){
return (comp.state[":rum/state"]);
});
rum.core.id = (function rum$core$id(comp){
return new cljs.core.Keyword("rum","id","rum/id",-1388417078).cljs$core$IFn$_invoke$arity$1(cljs.core.deref.call(null,rum.core.state.call(null,comp)));
});
rum.core.collect = (function rum$core$collect(fn_key,classes){
return cljs.core.remove.call(null,cljs.core.nil_QMARK_,cljs.core.map.call(null,fn_key,classes));
});
rum.core.call_all = (function rum$core$call_all(var_args){
var args__26066__auto__ = [];
var len__26059__auto___28566 = arguments.length;
var i__26060__auto___28567 = (0);
while(true){
if((i__26060__auto___28567 < len__26059__auto___28566)){
args__26066__auto__.push((arguments[i__26060__auto___28567]));

var G__28568 = (i__26060__auto___28567 + (1));
i__26060__auto___28567 = G__28568;
continue;
} else {
}
break;
}

var argseq__26067__auto__ = ((((2) < args__26066__auto__.length))?(new cljs.core.IndexedSeq(args__26066__auto__.slice((2)),(0))):null);
return rum.core.call_all.cljs$core$IFn$_invoke$arity$variadic((arguments[(0)]),(arguments[(1)]),argseq__26067__auto__);
});

rum.core.call_all.cljs$core$IFn$_invoke$arity$variadic = (function (state,fns,args){
return cljs.core.reduce.call(null,(function (state__$1,fn){
return cljs.core.apply.call(null,fn,state__$1,args);
}),state,fns);
});

rum.core.call_all.cljs$lang$maxFixedArity = (2);

rum.core.call_all.cljs$lang$applyTo = (function (seq28563){
var G__28564 = cljs.core.first.call(null,seq28563);
var seq28563__$1 = cljs.core.next.call(null,seq28563);
var G__28565 = cljs.core.first.call(null,seq28563__$1);
var seq28563__$2 = cljs.core.next.call(null,seq28563__$1);
return rum.core.call_all.cljs$core$IFn$_invoke$arity$variadic(G__28564,G__28565,seq28563__$2);
});
rum.core.build_class = (function rum$core$build_class(classes,display_name){
if(cljs.core.sequential_QMARK_.call(null,classes)){
} else {
throw (new Error([cljs.core.str("Assert failed: "),cljs.core.str(cljs.core.pr_str.call(null,cljs.core.list(new cljs.core.Symbol(null,"sequential?","sequential?",1102351463,null),new cljs.core.Symbol(null,"classes","classes",-616631259,null))))].join('')));
}

var init = rum.core.collect.call(null,new cljs.core.Keyword(null,"init","init",-1875481434),classes);
var will_mount = rum.core.collect.call(null,new cljs.core.Keyword(null,"will-mount","will-mount",-434633071),classes);
var did_mount = rum.core.collect.call(null,new cljs.core.Keyword(null,"did-mount","did-mount",918232960),classes);
var transfer_state = rum.core.collect.call(null,new cljs.core.Keyword(null,"transfer-state","transfer-state",-947550242),classes);
var should_update = rum.core.collect.call(null,new cljs.core.Keyword(null,"should-update","should-update",-1292781795),classes);
var will_update = rum.core.collect.call(null,new cljs.core.Keyword(null,"will-update","will-update",328062998),classes);
var render = cljs.core.first.call(null,rum.core.collect.call(null,new cljs.core.Keyword(null,"render","render",-1408033454),classes));
var wrapped_render = cljs.core.reduce.call(null,((function (init,will_mount,did_mount,transfer_state,should_update,will_update,render){
return (function (p1__28570_SHARP_,p2__28569_SHARP_){
return p2__28569_SHARP_.call(null,p1__28570_SHARP_);
});})(init,will_mount,did_mount,transfer_state,should_update,will_update,render))
,render,rum.core.collect.call(null,new cljs.core.Keyword(null,"wrap-render","wrap-render",1782000986),classes));
var did_update = rum.core.collect.call(null,new cljs.core.Keyword(null,"did-update","did-update",-2143702256),classes);
var will_unmount = rum.core.collect.call(null,new cljs.core.Keyword(null,"will-unmount","will-unmount",-808051550),classes);
var props__GT_state = ((function (init,will_mount,did_mount,transfer_state,should_update,will_update,render,wrapped_render,did_update,will_unmount){
return (function (props){
return rum.core.call_all.call(null,(props[":rum/initial-state"]),init,props);
});})(init,will_mount,did_mount,transfer_state,should_update,will_update,render,wrapped_render,did_update,will_unmount))
;
var child_context = rum.core.collect.call(null,new cljs.core.Keyword(null,"child-context","child-context",-1375270295),classes);
var class_properties = cljs.core.reduce.call(null,cljs.core.merge,rum.core.collect.call(null,new cljs.core.Keyword(null,"class-properties","class-properties",1351279702),classes));
return React.createClass(cljs.core.clj__GT_js.call(null,cljs.core.merge.call(null,cljs.core.PersistentHashMap.fromArrays([new cljs.core.Keyword(null,"componentDidUpdate","componentDidUpdate",-1983477981),new cljs.core.Keyword(null,"displayName","displayName",-809144601),new cljs.core.Keyword(null,"componentWillUnmount","componentWillUnmount",1573788814),new cljs.core.Keyword(null,"componentWillReceiveProps","componentWillReceiveProps",559988974),new cljs.core.Keyword(null,"shouldComponentUpdate","shouldComponentUpdate",1795750960),new cljs.core.Keyword(null,"render","render",-1408033454),new cljs.core.Keyword(null,"getChildContext","getChildContext",-1321948108),new cljs.core.Keyword(null,"componentWillUpdate","componentWillUpdate",657390932),new cljs.core.Keyword(null,"getInitialState","getInitialState",1541760916),new cljs.core.Keyword(null,"componentDidMount","componentDidMount",955710936),new cljs.core.Keyword(null,"componentWillMount","componentWillMount",-285327619)],[((cljs.core.empty_QMARK_.call(null,did_update))?null:((function (init,will_mount,did_mount,transfer_state,should_update,will_update,render,wrapped_render,did_update,will_unmount,props__GT_state,child_context,class_properties){
return (function (_,___$1){
var this$ = this;
return cljs.core._vreset_BANG_.call(null,rum.core.state.call(null,this$),rum.core.call_all.call(null,cljs.core._deref.call(null,rum.core.state.call(null,this$)),did_update));
});})(init,will_mount,did_mount,transfer_state,should_update,will_update,render,wrapped_render,did_update,will_unmount,props__GT_state,child_context,class_properties))
),display_name,((cljs.core.empty_QMARK_.call(null,will_unmount))?null:((function (init,will_mount,did_mount,transfer_state,should_update,will_update,render,wrapped_render,did_update,will_unmount,props__GT_state,child_context,class_properties){
return (function (){
var this$ = this;
return cljs.core._vreset_BANG_.call(null,rum.core.state.call(null,this$),rum.core.call_all.call(null,cljs.core._deref.call(null,rum.core.state.call(null,this$)),will_unmount));
});})(init,will_mount,did_mount,transfer_state,should_update,will_update,render,wrapped_render,did_update,will_unmount,props__GT_state,child_context,class_properties))
),((function (init,will_mount,did_mount,transfer_state,should_update,will_update,render,wrapped_render,did_update,will_unmount,props__GT_state,child_context,class_properties){
return (function (next_props){
var this$ = this;
var old_state = cljs.core.deref.call(null,rum.core.state.call(null,this$));
var next_state = cljs.core.merge.call(null,new cljs.core.PersistentArrayMap(null, 2, [new cljs.core.Keyword("rum","react-component","rum/react-component",-1879897248),this$,new cljs.core.Keyword("rum","id","rum/id",-1388417078),new cljs.core.Keyword("rum","id","rum/id",-1388417078).cljs$core$IFn$_invoke$arity$1(old_state)], null),props__GT_state.call(null,next_props));
var next_state__$1 = cljs.core.reduce.call(null,((function (old_state,next_state,this$,init,will_mount,did_mount,transfer_state,should_update,will_update,render,wrapped_render,did_update,will_unmount,props__GT_state,child_context,class_properties){
return (function (p1__28572_SHARP_,p2__28571_SHARP_){
return p2__28571_SHARP_.call(null,old_state,p1__28572_SHARP_);
});})(old_state,next_state,this$,init,will_mount,did_mount,transfer_state,should_update,will_update,render,wrapped_render,did_update,will_unmount,props__GT_state,child_context,class_properties))
,next_state,transfer_state);
return this$.setState({":rum/state": cljs.core.volatile_BANG_.call(null,next_state__$1)});
});})(init,will_mount,did_mount,transfer_state,should_update,will_update,render,wrapped_render,did_update,will_unmount,props__GT_state,child_context,class_properties))
,((cljs.core.empty_QMARK_.call(null,should_update))?null:((function (init,will_mount,did_mount,transfer_state,should_update,will_update,render,wrapped_render,did_update,will_unmount,props__GT_state,child_context,class_properties){
return (function (next_props,next_state){
var this$ = this;
var old_state = cljs.core.deref.call(null,rum.core.state.call(null,this$));
var new_state = cljs.core.deref.call(null,(next_state[":rum/state"]));
var or__25001__auto__ = cljs.core.some.call(null,((function (old_state,new_state,this$,init,will_mount,did_mount,transfer_state,should_update,will_update,render,wrapped_render,did_update,will_unmount,props__GT_state,child_context,class_properties){
return (function (p1__28573_SHARP_){
return p1__28573_SHARP_.call(null,old_state,new_state);
});})(old_state,new_state,this$,init,will_mount,did_mount,transfer_state,should_update,will_update,render,wrapped_render,did_update,will_unmount,props__GT_state,child_context,class_properties))
,should_update);
if(cljs.core.truth_(or__25001__auto__)){
return or__25001__auto__;
} else {
return false;
}
});})(init,will_mount,did_mount,transfer_state,should_update,will_update,render,wrapped_render,did_update,will_unmount,props__GT_state,child_context,class_properties))
),((function (init,will_mount,did_mount,transfer_state,should_update,will_update,render,wrapped_render,did_update,will_unmount,props__GT_state,child_context,class_properties){
return (function (){
var this$ = this;
var state = rum.core.state.call(null,this$);
var vec__28576 = wrapped_render.call(null,cljs.core.deref.call(null,state));
var dom = cljs.core.nth.call(null,vec__28576,(0),null);
var next_state = cljs.core.nth.call(null,vec__28576,(1),null);
cljs.core.vreset_BANG_.call(null,state,next_state);

return dom;
});})(init,will_mount,did_mount,transfer_state,should_update,will_update,render,wrapped_render,did_update,will_unmount,props__GT_state,child_context,class_properties))
,((cljs.core.empty_QMARK_.call(null,child_context))?null:((function (init,will_mount,did_mount,transfer_state,should_update,will_update,render,wrapped_render,did_update,will_unmount,props__GT_state,child_context,class_properties){
return (function (){
var this$ = this;
var state = cljs.core.deref.call(null,rum.core.state.call(null,this$));
return cljs.core.clj__GT_js.call(null,cljs.core.transduce.call(null,cljs.core.map.call(null,((function (state,this$,init,will_mount,did_mount,transfer_state,should_update,will_update,render,wrapped_render,did_update,will_unmount,props__GT_state,child_context,class_properties){
return (function (p1__28574_SHARP_){
return p1__28574_SHARP_.call(null,state);
});})(state,this$,init,will_mount,did_mount,transfer_state,should_update,will_update,render,wrapped_render,did_update,will_unmount,props__GT_state,child_context,class_properties))
),cljs.core.merge,cljs.core.PersistentArrayMap.EMPTY,child_context));
});})(init,will_mount,did_mount,transfer_state,should_update,will_update,render,wrapped_render,did_update,will_unmount,props__GT_state,child_context,class_properties))
),((cljs.core.empty_QMARK_.call(null,will_update))?null:((function (init,will_mount,did_mount,transfer_state,should_update,will_update,render,wrapped_render,did_update,will_unmount,props__GT_state,child_context,class_properties){
return (function (_,next_state){
var this$ = this;
var new_state = (next_state[":rum/state"]);
return cljs.core._vreset_BANG_.call(null,new_state,rum.core.call_all.call(null,cljs.core._deref.call(null,new_state),will_update));
});})(init,will_mount,did_mount,transfer_state,should_update,will_update,render,wrapped_render,did_update,will_unmount,props__GT_state,child_context,class_properties))
),((function (init,will_mount,did_mount,transfer_state,should_update,will_update,render,wrapped_render,did_update,will_unmount,props__GT_state,child_context,class_properties){
return (function (){
var this$ = this;
var props = this$.props;
var state = cljs.core.merge.call(null,new cljs.core.PersistentArrayMap(null, 2, [new cljs.core.Keyword("rum","react-component","rum/react-component",-1879897248),this$,new cljs.core.Keyword("rum","id","rum/id",-1388417078),rum.core.next_id.call(null)], null),props__GT_state.call(null,props));
return {":rum/state": cljs.core.volatile_BANG_.call(null,state)};
});})(init,will_mount,did_mount,transfer_state,should_update,will_update,render,wrapped_render,did_update,will_unmount,props__GT_state,child_context,class_properties))
,((cljs.core.empty_QMARK_.call(null,did_mount))?null:((function (init,will_mount,did_mount,transfer_state,should_update,will_update,render,wrapped_render,did_update,will_unmount,props__GT_state,child_context,class_properties){
return (function (){
var this$ = this;
return cljs.core._vreset_BANG_.call(null,rum.core.state.call(null,this$),rum.core.call_all.call(null,cljs.core._deref.call(null,rum.core.state.call(null,this$)),did_mount));
});})(init,will_mount,did_mount,transfer_state,should_update,will_update,render,wrapped_render,did_update,will_unmount,props__GT_state,child_context,class_properties))
),((cljs.core.empty_QMARK_.call(null,will_mount))?null:((function (init,will_mount,did_mount,transfer_state,should_update,will_update,render,wrapped_render,did_update,will_unmount,props__GT_state,child_context,class_properties){
return (function (){
var this$ = this;
return cljs.core._vreset_BANG_.call(null,rum.core.state.call(null,this$),rum.core.call_all.call(null,cljs.core._deref.call(null,rum.core.state.call(null,this$)),will_mount));
});})(init,will_mount,did_mount,transfer_state,should_update,will_update,render,wrapped_render,did_update,will_unmount,props__GT_state,child_context,class_properties))
)]),class_properties)));
});
rum.core.schedule = (function (){var or__25001__auto__ = (function (){var and__24989__auto__ = typeof window !== 'undefined';
if(and__24989__auto__){
var or__25001__auto__ = window.requestAnimationFrame;
if(cljs.core.truth_(or__25001__auto__)){
return or__25001__auto__;
} else {
var or__25001__auto____$1 = window.webkitRequestAnimationFrame;
if(cljs.core.truth_(or__25001__auto____$1)){
return or__25001__auto____$1;
} else {
var or__25001__auto____$2 = window.mozRequestAnimationFrame;
if(cljs.core.truth_(or__25001__auto____$2)){
return or__25001__auto____$2;
} else {
return window.msRequestAnimationFrame;
}
}
}
} else {
return and__24989__auto__;
}
})();
if(cljs.core.truth_(or__25001__auto__)){
return or__25001__auto__;
} else {
return ((function (or__25001__auto__){
return (function (p1__28577_SHARP_){
return setTimeout(p1__28577_SHARP_,(16));
});
;})(or__25001__auto__))
}
})();
rum.core.compare_by = (function rum$core$compare_by(keyfn){
return (function (x,y){
return cljs.core.compare.call(null,keyfn.call(null,x),keyfn.call(null,y));
});
});
rum.core.empty_queue = cljs.core.sorted_set_by.call(null,rum.core.compare_by.call(null,rum.core.id));
rum.core.render_queue = cljs.core.volatile_BANG_.call(null,rum.core.empty_queue);
rum.core.render = (function rum$core$render(){
var queue = cljs.core.deref.call(null,rum.core.render_queue);
cljs.core.vreset_BANG_.call(null,rum.core.render_queue,rum.core.empty_queue);

var seq__28584 = cljs.core.seq.call(null,queue);
var chunk__28586 = null;
var count__28587 = (0);
var i__28588 = (0);
while(true){
if((i__28588 < count__28587)){
var comp = cljs.core._nth.call(null,chunk__28586,i__28588);
if(cljs.core.truth_(comp.isMounted())){
comp.forceUpdate();

var G__28590 = seq__28584;
var G__28591 = chunk__28586;
var G__28592 = count__28587;
var G__28593 = (i__28588 + (1));
seq__28584 = G__28590;
chunk__28586 = G__28591;
count__28587 = G__28592;
i__28588 = G__28593;
continue;
} else {
var G__28594 = seq__28584;
var G__28595 = chunk__28586;
var G__28596 = count__28587;
var G__28597 = (i__28588 + (1));
seq__28584 = G__28594;
chunk__28586 = G__28595;
count__28587 = G__28596;
i__28588 = G__28597;
continue;
}
} else {
var temp__4425__auto__ = cljs.core.seq.call(null,seq__28584);
if(temp__4425__auto__){
var seq__28584__$1 = temp__4425__auto__;
if(cljs.core.chunked_seq_QMARK_.call(null,seq__28584__$1)){
var c__25804__auto__ = cljs.core.chunk_first.call(null,seq__28584__$1);
var G__28598 = cljs.core.chunk_rest.call(null,seq__28584__$1);
var G__28599 = c__25804__auto__;
var G__28600 = cljs.core.count.call(null,c__25804__auto__);
var G__28601 = (0);
seq__28584 = G__28598;
chunk__28586 = G__28599;
count__28587 = G__28600;
i__28588 = G__28601;
continue;
} else {
var comp = cljs.core.first.call(null,seq__28584__$1);
if(cljs.core.truth_(comp.isMounted())){
comp.forceUpdate();

var G__28602 = cljs.core.next.call(null,seq__28584__$1);
var G__28603 = null;
var G__28604 = (0);
var G__28605 = (0);
seq__28584 = G__28602;
chunk__28586 = G__28603;
count__28587 = G__28604;
i__28588 = G__28605;
continue;
} else {
var G__28606 = cljs.core.next.call(null,seq__28584__$1);
var G__28607 = null;
var G__28608 = (0);
var G__28609 = (0);
seq__28584 = G__28606;
chunk__28586 = G__28607;
count__28587 = G__28608;
i__28588 = G__28609;
continue;
}
}
} else {
return null;
}
}
break;
}
});
rum.core.request_render = (function rum$core$request_render(component){
if(cljs.core.empty_QMARK_.call(null,cljs.core.deref.call(null,rum.core.render_queue))){
rum.core.schedule.call(null,rum.core.render);
} else {
}

return cljs.core._vreset_BANG_.call(null,rum.core.render_queue,cljs.core.conj.call(null,cljs.core._deref.call(null,rum.core.render_queue),component));
});
rum.core.mount = (function rum$core$mount(component,node){
return ReactDOM.render(component,node);
});
rum.core.render__GT_mixin = (function rum$core$render__GT_mixin(render_fn){
return new cljs.core.PersistentArrayMap(null, 1, [new cljs.core.Keyword(null,"render","render",-1408033454),(function (state){
return new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.apply.call(null,render_fn,new cljs.core.Keyword("rum","args","rum/args",1315791754).cljs$core$IFn$_invoke$arity$1(state)),state], null);
})], null);
});
rum.core.render_state__GT_mixin = (function rum$core$render_state__GT_mixin(render_fn){
return new cljs.core.PersistentArrayMap(null, 1, [new cljs.core.Keyword(null,"render","render",-1408033454),(function (state){
return new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.apply.call(null,render_fn,state,new cljs.core.Keyword("rum","args","rum/args",1315791754).cljs$core$IFn$_invoke$arity$1(state)),state], null);
})], null);
});
rum.core.render_comp__GT_mixin = (function rum$core$render_comp__GT_mixin(render_fn){
return new cljs.core.PersistentArrayMap(null, 1, [new cljs.core.Keyword(null,"render","render",-1408033454),(function (state){
return new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.apply.call(null,render_fn,new cljs.core.Keyword("rum","react-component","rum/react-component",-1879897248).cljs$core$IFn$_invoke$arity$1(state),new cljs.core.Keyword("rum","args","rum/args",1315791754).cljs$core$IFn$_invoke$arity$1(state)),state], null);
})], null);
});
rum.core.args__GT_state = (function rum$core$args__GT_state(args){
return new cljs.core.PersistentArrayMap(null, 1, [new cljs.core.Keyword("rum","args","rum/args",1315791754),args], null);
});
rum.core.element = (function rum$core$element(var_args){
var args__26066__auto__ = [];
var len__26059__auto___28615 = arguments.length;
var i__26060__auto___28616 = (0);
while(true){
if((i__26060__auto___28616 < len__26059__auto___28615)){
args__26066__auto__.push((arguments[i__26060__auto___28616]));

var G__28617 = (i__26060__auto___28616 + (1));
i__26060__auto___28616 = G__28617;
continue;
} else {
}
break;
}

var argseq__26067__auto__ = ((((2) < args__26066__auto__.length))?(new cljs.core.IndexedSeq(args__26066__auto__.slice((2)),(0))):null);
return rum.core.element.cljs$core$IFn$_invoke$arity$variadic((arguments[(0)]),(arguments[(1)]),argseq__26067__auto__);
});

rum.core.element.cljs$core$IFn$_invoke$arity$variadic = (function (class$,state,p__28613){
var vec__28614 = p__28613;
var props = cljs.core.nth.call(null,vec__28614,(0),null);
var props__$1 = (function (){var or__25001__auto__ = props;
if(cljs.core.truth_(or__25001__auto__)){
return or__25001__auto__;
} else {
return {};
}
})();
(props__$1[":rum/initial-state"] = state);

return React.createElement(class$,props__$1);
});

rum.core.element.cljs$lang$maxFixedArity = (2);

rum.core.element.cljs$lang$applyTo = (function (seq28610){
var G__28611 = cljs.core.first.call(null,seq28610);
var seq28610__$1 = cljs.core.next.call(null,seq28610);
var G__28612 = cljs.core.first.call(null,seq28610__$1);
var seq28610__$2 = cljs.core.next.call(null,seq28610__$1);
return rum.core.element.cljs$core$IFn$_invoke$arity$variadic(G__28611,G__28612,seq28610__$2);
});
rum.core.ctor__GT_class = (function rum$core$ctor__GT_class(ctor){
return new cljs.core.Keyword("rum","class","rum/class",-2030775258).cljs$core$IFn$_invoke$arity$1(cljs.core.meta.call(null,ctor));
});
rum.core.with_key = (function rum$core$with_key(element,key){
return React.cloneElement(element,{"key": key},null);
});
rum.core.with_ref = (function rum$core$with_ref(element,ref){
return React.cloneElement(element,{"ref": ref},null);
});
rum.core.static$ = new cljs.core.PersistentArrayMap(null, 1, [new cljs.core.Keyword(null,"should-update","should-update",-1292781795),(function (old_state,new_state){
return cljs.core.not_EQ_.call(null,new cljs.core.Keyword("rum","args","rum/args",1315791754).cljs$core$IFn$_invoke$arity$1(old_state),new cljs.core.Keyword("rum","args","rum/args",1315791754).cljs$core$IFn$_invoke$arity$1(new_state));
})], null);
/**
 * Adds an atom to component’s state that can be used as local state.
 * Atom is stored under key `:rum/local`.
 * Component will be automatically re-rendered if atom’s value changes
 */
rum.core.local = (function rum$core$local(var_args){
var args__26066__auto__ = [];
var len__26059__auto___28622 = arguments.length;
var i__26060__auto___28623 = (0);
while(true){
if((i__26060__auto___28623 < len__26059__auto___28622)){
args__26066__auto__.push((arguments[i__26060__auto___28623]));

var G__28624 = (i__26060__auto___28623 + (1));
i__26060__auto___28623 = G__28624;
continue;
} else {
}
break;
}

var argseq__26067__auto__ = ((((1) < args__26066__auto__.length))?(new cljs.core.IndexedSeq(args__26066__auto__.slice((1)),(0))):null);
return rum.core.local.cljs$core$IFn$_invoke$arity$variadic((arguments[(0)]),argseq__26067__auto__);
});

rum.core.local.cljs$core$IFn$_invoke$arity$variadic = (function (initial,p__28620){
var vec__28621 = p__28620;
var key = cljs.core.nth.call(null,vec__28621,(0),null);
var key__$1 = (function (){var or__25001__auto__ = key;
if(cljs.core.truth_(or__25001__auto__)){
return or__25001__auto__;
} else {
return new cljs.core.Keyword("rum","local","rum/local",-1497916586);
}
})();
return new cljs.core.PersistentArrayMap(null, 2, [new cljs.core.Keyword(null,"transfer-state","transfer-state",-947550242),((function (key__$1,vec__28621,key){
return (function (old,new$){
return cljs.core.assoc.call(null,new$,key__$1,old.call(null,key__$1));
});})(key__$1,vec__28621,key))
,new cljs.core.Keyword(null,"will-mount","will-mount",-434633071),((function (key__$1,vec__28621,key){
return (function (state){
var local_state = cljs.core.atom.call(null,initial);
var component = new cljs.core.Keyword("rum","react-component","rum/react-component",-1879897248).cljs$core$IFn$_invoke$arity$1(state);
cljs.core.add_watch.call(null,local_state,key__$1,((function (local_state,component,key__$1,vec__28621,key){
return (function (_,___$1,___$2,___$3){
return rum.core.request_render.call(null,component);
});})(local_state,component,key__$1,vec__28621,key))
);

return cljs.core.assoc.call(null,state,key__$1,local_state);
});})(key__$1,vec__28621,key))
], null);
});

rum.core.local.cljs$lang$maxFixedArity = (1);

rum.core.local.cljs$lang$applyTo = (function (seq28618){
var G__28619 = cljs.core.first.call(null,seq28618);
var seq28618__$1 = cljs.core.next.call(null,seq28618);
return rum.core.local.cljs$core$IFn$_invoke$arity$variadic(G__28619,seq28618__$1);
});
rum.core._STAR_reactions_STAR_;
rum.core.reactive_key = (function rum$core$reactive_key(state){
return [cljs.core.str(":rum/reactive-"),cljs.core.str(new cljs.core.Keyword("rum","id","rum/id",-1388417078).cljs$core$IFn$_invoke$arity$1(state))].join('');
});
rum.core.reactive = new cljs.core.PersistentArrayMap(null, 3, [new cljs.core.Keyword(null,"transfer-state","transfer-state",-947550242),(function (old,new$){
return cljs.core.assoc.call(null,new$,new cljs.core.Keyword("rum","refs","rum/refs",-1559872630),new cljs.core.Keyword("rum","refs","rum/refs",-1559872630).cljs$core$IFn$_invoke$arity$1(old));
}),new cljs.core.Keyword(null,"wrap-render","wrap-render",1782000986),(function (render_fn){
return (function (state){
var _STAR_reactions_STAR_28625 = rum.core._STAR_reactions_STAR_;
rum.core._STAR_reactions_STAR_ = cljs.core.volatile_BANG_.call(null,cljs.core.PersistentHashSet.EMPTY);

try{var comp = new cljs.core.Keyword("rum","react-component","rum/react-component",-1879897248).cljs$core$IFn$_invoke$arity$1(state);
var old_reactions = new cljs.core.Keyword("rum","refs","rum/refs",-1559872630).cljs$core$IFn$_invoke$arity$2(state,cljs.core.PersistentHashSet.EMPTY);
var vec__28626 = render_fn.call(null,state);
var dom = cljs.core.nth.call(null,vec__28626,(0),null);
var next_state = cljs.core.nth.call(null,vec__28626,(1),null);
var new_reactions = cljs.core.deref.call(null,rum.core._STAR_reactions_STAR_);
var key = rum.core.reactive_key.call(null,state);
var seq__28627_28639 = cljs.core.seq.call(null,old_reactions);
var chunk__28628_28640 = null;
var count__28629_28641 = (0);
var i__28630_28642 = (0);
while(true){
if((i__28630_28642 < count__28629_28641)){
var ref_28643 = cljs.core._nth.call(null,chunk__28628_28640,i__28630_28642);
if(cljs.core.contains_QMARK_.call(null,new_reactions,ref_28643)){
} else {
cljs.core.remove_watch.call(null,ref_28643,key);
}

var G__28644 = seq__28627_28639;
var G__28645 = chunk__28628_28640;
var G__28646 = count__28629_28641;
var G__28647 = (i__28630_28642 + (1));
seq__28627_28639 = G__28644;
chunk__28628_28640 = G__28645;
count__28629_28641 = G__28646;
i__28630_28642 = G__28647;
continue;
} else {
var temp__4425__auto___28648 = cljs.core.seq.call(null,seq__28627_28639);
if(temp__4425__auto___28648){
var seq__28627_28649__$1 = temp__4425__auto___28648;
if(cljs.core.chunked_seq_QMARK_.call(null,seq__28627_28649__$1)){
var c__25804__auto___28650 = cljs.core.chunk_first.call(null,seq__28627_28649__$1);
var G__28651 = cljs.core.chunk_rest.call(null,seq__28627_28649__$1);
var G__28652 = c__25804__auto___28650;
var G__28653 = cljs.core.count.call(null,c__25804__auto___28650);
var G__28654 = (0);
seq__28627_28639 = G__28651;
chunk__28628_28640 = G__28652;
count__28629_28641 = G__28653;
i__28630_28642 = G__28654;
continue;
} else {
var ref_28655 = cljs.core.first.call(null,seq__28627_28649__$1);
if(cljs.core.contains_QMARK_.call(null,new_reactions,ref_28655)){
} else {
cljs.core.remove_watch.call(null,ref_28655,key);
}

var G__28656 = cljs.core.next.call(null,seq__28627_28649__$1);
var G__28657 = null;
var G__28658 = (0);
var G__28659 = (0);
seq__28627_28639 = G__28656;
chunk__28628_28640 = G__28657;
count__28629_28641 = G__28658;
i__28630_28642 = G__28659;
continue;
}
} else {
}
}
break;
}

var seq__28631_28660 = cljs.core.seq.call(null,new_reactions);
var chunk__28632_28661 = null;
var count__28633_28662 = (0);
var i__28634_28663 = (0);
while(true){
if((i__28634_28663 < count__28633_28662)){
var ref_28664 = cljs.core._nth.call(null,chunk__28632_28661,i__28634_28663);
if(cljs.core.contains_QMARK_.call(null,old_reactions,ref_28664)){
} else {
cljs.core.add_watch.call(null,ref_28664,key,((function (seq__28631_28660,chunk__28632_28661,count__28633_28662,i__28634_28663,ref_28664,comp,old_reactions,vec__28626,dom,next_state,new_reactions,key,_STAR_reactions_STAR_28625){
return (function (_,___$1,___$2,___$3){
return rum.core.request_render.call(null,comp);
});})(seq__28631_28660,chunk__28632_28661,count__28633_28662,i__28634_28663,ref_28664,comp,old_reactions,vec__28626,dom,next_state,new_reactions,key,_STAR_reactions_STAR_28625))
);
}

var G__28665 = seq__28631_28660;
var G__28666 = chunk__28632_28661;
var G__28667 = count__28633_28662;
var G__28668 = (i__28634_28663 + (1));
seq__28631_28660 = G__28665;
chunk__28632_28661 = G__28666;
count__28633_28662 = G__28667;
i__28634_28663 = G__28668;
continue;
} else {
var temp__4425__auto___28669 = cljs.core.seq.call(null,seq__28631_28660);
if(temp__4425__auto___28669){
var seq__28631_28670__$1 = temp__4425__auto___28669;
if(cljs.core.chunked_seq_QMARK_.call(null,seq__28631_28670__$1)){
var c__25804__auto___28671 = cljs.core.chunk_first.call(null,seq__28631_28670__$1);
var G__28672 = cljs.core.chunk_rest.call(null,seq__28631_28670__$1);
var G__28673 = c__25804__auto___28671;
var G__28674 = cljs.core.count.call(null,c__25804__auto___28671);
var G__28675 = (0);
seq__28631_28660 = G__28672;
chunk__28632_28661 = G__28673;
count__28633_28662 = G__28674;
i__28634_28663 = G__28675;
continue;
} else {
var ref_28676 = cljs.core.first.call(null,seq__28631_28670__$1);
if(cljs.core.contains_QMARK_.call(null,old_reactions,ref_28676)){
} else {
cljs.core.add_watch.call(null,ref_28676,key,((function (seq__28631_28660,chunk__28632_28661,count__28633_28662,i__28634_28663,ref_28676,seq__28631_28670__$1,temp__4425__auto___28669,comp,old_reactions,vec__28626,dom,next_state,new_reactions,key,_STAR_reactions_STAR_28625){
return (function (_,___$1,___$2,___$3){
return rum.core.request_render.call(null,comp);
});})(seq__28631_28660,chunk__28632_28661,count__28633_28662,i__28634_28663,ref_28676,seq__28631_28670__$1,temp__4425__auto___28669,comp,old_reactions,vec__28626,dom,next_state,new_reactions,key,_STAR_reactions_STAR_28625))
);
}

var G__28677 = cljs.core.next.call(null,seq__28631_28670__$1);
var G__28678 = null;
var G__28679 = (0);
var G__28680 = (0);
seq__28631_28660 = G__28677;
chunk__28632_28661 = G__28678;
count__28633_28662 = G__28679;
i__28634_28663 = G__28680;
continue;
}
} else {
}
}
break;
}

return new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [dom,cljs.core.assoc.call(null,next_state,new cljs.core.Keyword("rum","refs","rum/refs",-1559872630),new_reactions)], null);
}finally {rum.core._STAR_reactions_STAR_ = _STAR_reactions_STAR_28625;
}});
}),new cljs.core.Keyword(null,"will-unmount","will-unmount",-808051550),(function (state){
var key_28681 = rum.core.reactive_key.call(null,state);
var seq__28635_28682 = cljs.core.seq.call(null,new cljs.core.Keyword("rum","refs","rum/refs",-1559872630).cljs$core$IFn$_invoke$arity$1(state));
var chunk__28636_28683 = null;
var count__28637_28684 = (0);
var i__28638_28685 = (0);
while(true){
if((i__28638_28685 < count__28637_28684)){
var ref_28686 = cljs.core._nth.call(null,chunk__28636_28683,i__28638_28685);
cljs.core.remove_watch.call(null,ref_28686,key_28681);

var G__28687 = seq__28635_28682;
var G__28688 = chunk__28636_28683;
var G__28689 = count__28637_28684;
var G__28690 = (i__28638_28685 + (1));
seq__28635_28682 = G__28687;
chunk__28636_28683 = G__28688;
count__28637_28684 = G__28689;
i__28638_28685 = G__28690;
continue;
} else {
var temp__4425__auto___28691 = cljs.core.seq.call(null,seq__28635_28682);
if(temp__4425__auto___28691){
var seq__28635_28692__$1 = temp__4425__auto___28691;
if(cljs.core.chunked_seq_QMARK_.call(null,seq__28635_28692__$1)){
var c__25804__auto___28693 = cljs.core.chunk_first.call(null,seq__28635_28692__$1);
var G__28694 = cljs.core.chunk_rest.call(null,seq__28635_28692__$1);
var G__28695 = c__25804__auto___28693;
var G__28696 = cljs.core.count.call(null,c__25804__auto___28693);
var G__28697 = (0);
seq__28635_28682 = G__28694;
chunk__28636_28683 = G__28695;
count__28637_28684 = G__28696;
i__28638_28685 = G__28697;
continue;
} else {
var ref_28698 = cljs.core.first.call(null,seq__28635_28692__$1);
cljs.core.remove_watch.call(null,ref_28698,key_28681);

var G__28699 = cljs.core.next.call(null,seq__28635_28692__$1);
var G__28700 = null;
var G__28701 = (0);
var G__28702 = (0);
seq__28635_28682 = G__28699;
chunk__28636_28683 = G__28700;
count__28637_28684 = G__28701;
i__28638_28685 = G__28702;
continue;
}
} else {
}
}
break;
}

return cljs.core.dissoc.call(null,state,new cljs.core.Keyword("rum","refs","rum/refs",-1559872630));
})], null);
rum.core.react = (function rum$core$react(ref){
cljs.core._vreset_BANG_.call(null,rum.core._STAR_reactions_STAR_,cljs.core.conj.call(null,cljs.core._deref.call(null,rum.core._STAR_reactions_STAR_),ref));

return cljs.core.deref.call(null,ref);
});

/**
* @constructor
 * @implements {rum.core.Object}
 * @implements {cljs.core.IWatchable}
 * @implements {cljs.core.IAtom}
 * @implements {cljs.core.IEquiv}
 * @implements {cljs.core.IHash}
 * @implements {cljs.core.IReset}
 * @implements {cljs.core.ISwap}
 * @implements {cljs.core.IDeref}
 * @implements {cljs.core.IPrintWithWriter}
*/
rum.core.LensCursor = (function (parent,getter,setter){
this.parent = parent;
this.getter = getter;
this.setter = setter;
this.cljs$lang$protocol_mask$partition1$ = 114690;
this.cljs$lang$protocol_mask$partition0$ = 2153807872;
})
rum.core.LensCursor.prototype.equiv = (function (other){
var self__ = this;
var this$ = this;
return cljs.core._equiv.call(null,this$,other);
});

rum.core.LensCursor.prototype.cljs$core$IEquiv$_equiv$arity$2 = (function (this$,other){
var self__ = this;
var this$__$1 = this;
return (this$__$1 === other);
});

rum.core.LensCursor.prototype.cljs$core$IDeref$_deref$arity$1 = (function (_){
var self__ = this;
var ___$1 = this;
return self__.getter.call(null,cljs.core._deref.call(null,self__.parent));
});

rum.core.LensCursor.prototype.cljs$core$IWatchable$_add_watch$arity$3 = (function (this$,key,f){
var self__ = this;
var this$__$1 = this;
cljs.core.add_watch.call(null,self__.parent,cljs.core._conj.call(null,cljs.core._conj.call(null,cljs.core.List.EMPTY,key),this$__$1),((function (this$__$1){
return (function (_,___$1,oldp,newp){
var old = self__.getter.call(null,oldp);
var new$ = self__.getter.call(null,newp);
if(cljs.core.not_EQ_.call(null,old,new$)){
return f.call(null,key,this$__$1,old,new$);
} else {
return null;
}
});})(this$__$1))
);

return this$__$1;
});

rum.core.LensCursor.prototype.cljs$core$IWatchable$_remove_watch$arity$2 = (function (this$,key){
var self__ = this;
var this$__$1 = this;
cljs.core.remove_watch.call(null,self__.parent,cljs.core._conj.call(null,cljs.core._conj.call(null,cljs.core.List.EMPTY,key),this$__$1));

return this$__$1;
});

rum.core.LensCursor.prototype.cljs$core$IHash$_hash$arity$1 = (function (this$){
var self__ = this;
var this$__$1 = this;
return goog.getUid(this$__$1);
});

rum.core.LensCursor.prototype.cljs$core$IReset$_reset_BANG_$arity$2 = (function (_,new_value){
var self__ = this;
var ___$1 = this;
cljs.core.swap_BANG_.call(null,self__.parent,self__.setter,new_value);

return new_value;
});

rum.core.LensCursor.prototype.cljs$core$ISwap$_swap_BANG_$arity$2 = (function (this$,f){
var self__ = this;
var this$__$1 = this;
return cljs.core._reset_BANG_.call(null,this$__$1,f.call(null,cljs.core._deref.call(null,this$__$1)));
});

rum.core.LensCursor.prototype.cljs$core$ISwap$_swap_BANG_$arity$3 = (function (this$,f,a){
var self__ = this;
var this$__$1 = this;
return cljs.core._reset_BANG_.call(null,this$__$1,f.call(null,cljs.core._deref.call(null,this$__$1),a));
});

rum.core.LensCursor.prototype.cljs$core$ISwap$_swap_BANG_$arity$4 = (function (this$,f,a,b){
var self__ = this;
var this$__$1 = this;
return cljs.core._reset_BANG_.call(null,this$__$1,f.call(null,cljs.core._deref.call(null,this$__$1),a,b));
});

rum.core.LensCursor.prototype.cljs$core$ISwap$_swap_BANG_$arity$5 = (function (this$,f,a,b,xs){
var self__ = this;
var this$__$1 = this;
return cljs.core._reset_BANG_.call(null,this$__$1,cljs.core.apply.call(null,f,cljs.core._deref.call(null,this$__$1),a,b,xs));
});

rum.core.LensCursor.prototype.cljs$core$IPrintWithWriter$_pr_writer$arity$3 = (function (this$,writer,opts){
var self__ = this;
var this$__$1 = this;
cljs.core._write.call(null,writer,"#<Cursor: ");

cljs.core.pr_writer.call(null,cljs.core._deref.call(null,this$__$1),writer,opts);

return cljs.core._write.call(null,writer,">");
});

rum.core.LensCursor.getBasis = (function (){
return new cljs.core.PersistentVector(null, 3, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Symbol(null,"parent","parent",761652748,null),new cljs.core.Symbol(null,"getter","getter",1725376382,null),new cljs.core.Symbol(null,"setter","setter",-706080843,null)], null);
});

rum.core.LensCursor.cljs$lang$type = true;

rum.core.LensCursor.cljs$lang$ctorStr = "rum.core/LensCursor";

rum.core.LensCursor.cljs$lang$ctorPrWriter = (function (this__25599__auto__,writer__25600__auto__,opt__25601__auto__){
return cljs.core._write.call(null,writer__25600__auto__,"rum.core/LensCursor");
});

rum.core.__GT_LensCursor = (function rum$core$__GT_LensCursor(parent,getter,setter){
return (new rum.core.LensCursor(parent,getter,setter));
});

rum.core.cursor = (function rum$core$cursor(ref,path){
var getter = (function (p1__28703_SHARP_){
return cljs.core.get_in.call(null,p1__28703_SHARP_,path);
});
var setter = ((function (getter){
return (function (p1__28704_SHARP_,p2__28705_SHARP_){
return cljs.core.assoc_in.call(null,p1__28704_SHARP_,path,p2__28705_SHARP_);
});})(getter))
;
if((ref instanceof rum.core.LensCursor)){
return (new rum.core.LensCursor(ref.parent,cljs.core.comp.call(null,getter,ref.getter),((function (getter,setter){
return (function (where,what){
var focus = ref.getter.call(null,where);
var focus__$1 = setter.call(null,focus,what);
var focus__$2 = ref.setter.call(null,where,focus__$1);
return focus__$2;
});})(getter,setter))
));
} else {
return (new rum.core.LensCursor(ref,getter,setter));
}
});
rum.core.deref_args = (function rum$core$deref_args(xs){
return cljs.core.mapv.call(null,(function (p1__28706_SHARP_){
if(((!((p1__28706_SHARP_ == null)))?((((p1__28706_SHARP_.cljs$lang$protocol_mask$partition0$ & (32768))) || (p1__28706_SHARP_.cljs$core$IDeref$))?true:(((!p1__28706_SHARP_.cljs$lang$protocol_mask$partition0$))?cljs.core.native_satisfies_QMARK_.call(null,cljs.core.IDeref,p1__28706_SHARP_):false)):cljs.core.native_satisfies_QMARK_.call(null,cljs.core.IDeref,p1__28706_SHARP_))){
return cljs.core.deref.call(null,p1__28706_SHARP_);
} else {
return p1__28706_SHARP_;
}
}),xs);
});
rum.core.cursored = new cljs.core.PersistentArrayMap(null, 3, [new cljs.core.Keyword(null,"transfer-state","transfer-state",-947550242),(function (old,new$){
return cljs.core.assoc.call(null,new$,new cljs.core.Keyword("rum","om-args","rum/om-args",-1682450907),new cljs.core.Keyword("rum","om-args","rum/om-args",-1682450907).cljs$core$IFn$_invoke$arity$1(old));
}),new cljs.core.Keyword(null,"should-update","should-update",-1292781795),(function (old_state,new_state){
return cljs.core.not_EQ_.call(null,new cljs.core.Keyword("rum","om-args","rum/om-args",-1682450907).cljs$core$IFn$_invoke$arity$1(old_state),rum.core.deref_args.call(null,new cljs.core.Keyword("rum","args","rum/args",1315791754).cljs$core$IFn$_invoke$arity$1(new_state)));
}),new cljs.core.Keyword(null,"wrap-render","wrap-render",1782000986),(function (render_fn){
return (function (state){
var vec__28709 = render_fn.call(null,state);
var dom = cljs.core.nth.call(null,vec__28709,(0),null);
var next_state = cljs.core.nth.call(null,vec__28709,(1),null);
return new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [dom,cljs.core.assoc.call(null,next_state,new cljs.core.Keyword("rum","om-args","rum/om-args",-1682450907),rum.core.deref_args.call(null,new cljs.core.Keyword("rum","args","rum/args",1315791754).cljs$core$IFn$_invoke$arity$1(state)))], null);
});
})], null);
rum.core.cursored_key = (function rum$core$cursored_key(state){
return [cljs.core.str(":rum/cursored-"),cljs.core.str(new cljs.core.Keyword("rum","id","rum/id",-1388417078).cljs$core$IFn$_invoke$arity$1(state))].join('');
});
rum.core.cursored_watch = new cljs.core.PersistentArrayMap(null, 2, [new cljs.core.Keyword(null,"did-mount","did-mount",918232960),(function (state){
var seq__28710_28726 = cljs.core.seq.call(null,new cljs.core.Keyword("rum","args","rum/args",1315791754).cljs$core$IFn$_invoke$arity$1(state));
var chunk__28712_28727 = null;
var count__28713_28728 = (0);
var i__28714_28729 = (0);
while(true){
if((i__28714_28729 < count__28713_28728)){
var arg_28730 = cljs.core._nth.call(null,chunk__28712_28727,i__28714_28729);
if(((!((arg_28730 == null)))?((((arg_28730.cljs$lang$protocol_mask$partition1$ & (2))) || (arg_28730.cljs$core$IWatchable$))?true:(((!arg_28730.cljs$lang$protocol_mask$partition1$))?cljs.core.native_satisfies_QMARK_.call(null,cljs.core.IWatchable,arg_28730):false)):cljs.core.native_satisfies_QMARK_.call(null,cljs.core.IWatchable,arg_28730))){
cljs.core.add_watch.call(null,arg_28730,rum.core.cursored_key.call(null,state),((function (seq__28710_28726,chunk__28712_28727,count__28713_28728,i__28714_28729,arg_28730){
return (function (_,___$1,___$2,___$3){
return rum.core.request_render.call(null,new cljs.core.Keyword("rum","react-component","rum/react-component",-1879897248).cljs$core$IFn$_invoke$arity$1(state));
});})(seq__28710_28726,chunk__28712_28727,count__28713_28728,i__28714_28729,arg_28730))
);

var G__28731 = seq__28710_28726;
var G__28732 = chunk__28712_28727;
var G__28733 = count__28713_28728;
var G__28734 = (i__28714_28729 + (1));
seq__28710_28726 = G__28731;
chunk__28712_28727 = G__28732;
count__28713_28728 = G__28733;
i__28714_28729 = G__28734;
continue;
} else {
var G__28735 = seq__28710_28726;
var G__28736 = chunk__28712_28727;
var G__28737 = count__28713_28728;
var G__28738 = (i__28714_28729 + (1));
seq__28710_28726 = G__28735;
chunk__28712_28727 = G__28736;
count__28713_28728 = G__28737;
i__28714_28729 = G__28738;
continue;
}
} else {
var temp__4425__auto___28739 = cljs.core.seq.call(null,seq__28710_28726);
if(temp__4425__auto___28739){
var seq__28710_28740__$1 = temp__4425__auto___28739;
if(cljs.core.chunked_seq_QMARK_.call(null,seq__28710_28740__$1)){
var c__25804__auto___28741 = cljs.core.chunk_first.call(null,seq__28710_28740__$1);
var G__28742 = cljs.core.chunk_rest.call(null,seq__28710_28740__$1);
var G__28743 = c__25804__auto___28741;
var G__28744 = cljs.core.count.call(null,c__25804__auto___28741);
var G__28745 = (0);
seq__28710_28726 = G__28742;
chunk__28712_28727 = G__28743;
count__28713_28728 = G__28744;
i__28714_28729 = G__28745;
continue;
} else {
var arg_28746 = cljs.core.first.call(null,seq__28710_28740__$1);
if(((!((arg_28746 == null)))?((((arg_28746.cljs$lang$protocol_mask$partition1$ & (2))) || (arg_28746.cljs$core$IWatchable$))?true:(((!arg_28746.cljs$lang$protocol_mask$partition1$))?cljs.core.native_satisfies_QMARK_.call(null,cljs.core.IWatchable,arg_28746):false)):cljs.core.native_satisfies_QMARK_.call(null,cljs.core.IWatchable,arg_28746))){
cljs.core.add_watch.call(null,arg_28746,rum.core.cursored_key.call(null,state),((function (seq__28710_28726,chunk__28712_28727,count__28713_28728,i__28714_28729,arg_28746,seq__28710_28740__$1,temp__4425__auto___28739){
return (function (_,___$1,___$2,___$3){
return rum.core.request_render.call(null,new cljs.core.Keyword("rum","react-component","rum/react-component",-1879897248).cljs$core$IFn$_invoke$arity$1(state));
});})(seq__28710_28726,chunk__28712_28727,count__28713_28728,i__28714_28729,arg_28746,seq__28710_28740__$1,temp__4425__auto___28739))
);

var G__28747 = cljs.core.next.call(null,seq__28710_28740__$1);
var G__28748 = null;
var G__28749 = (0);
var G__28750 = (0);
seq__28710_28726 = G__28747;
chunk__28712_28727 = G__28748;
count__28713_28728 = G__28749;
i__28714_28729 = G__28750;
continue;
} else {
var G__28751 = cljs.core.next.call(null,seq__28710_28740__$1);
var G__28752 = null;
var G__28753 = (0);
var G__28754 = (0);
seq__28710_28726 = G__28751;
chunk__28712_28727 = G__28752;
count__28713_28728 = G__28753;
i__28714_28729 = G__28754;
continue;
}
}
} else {
}
}
break;
}

return state;
}),new cljs.core.Keyword(null,"will-unmount","will-unmount",-808051550),(function (state){
var seq__28718_28755 = cljs.core.seq.call(null,new cljs.core.Keyword("rum","args","rum/args",1315791754).cljs$core$IFn$_invoke$arity$1(state));
var chunk__28720_28756 = null;
var count__28721_28757 = (0);
var i__28722_28758 = (0);
while(true){
if((i__28722_28758 < count__28721_28757)){
var arg_28759 = cljs.core._nth.call(null,chunk__28720_28756,i__28722_28758);
if(((!((arg_28759 == null)))?((((arg_28759.cljs$lang$protocol_mask$partition1$ & (2))) || (arg_28759.cljs$core$IWatchable$))?true:(((!arg_28759.cljs$lang$protocol_mask$partition1$))?cljs.core.native_satisfies_QMARK_.call(null,cljs.core.IWatchable,arg_28759):false)):cljs.core.native_satisfies_QMARK_.call(null,cljs.core.IWatchable,arg_28759))){
cljs.core.remove_watch.call(null,arg_28759,rum.core.cursored_key.call(null,state));

var G__28760 = seq__28718_28755;
var G__28761 = chunk__28720_28756;
var G__28762 = count__28721_28757;
var G__28763 = (i__28722_28758 + (1));
seq__28718_28755 = G__28760;
chunk__28720_28756 = G__28761;
count__28721_28757 = G__28762;
i__28722_28758 = G__28763;
continue;
} else {
var G__28764 = seq__28718_28755;
var G__28765 = chunk__28720_28756;
var G__28766 = count__28721_28757;
var G__28767 = (i__28722_28758 + (1));
seq__28718_28755 = G__28764;
chunk__28720_28756 = G__28765;
count__28721_28757 = G__28766;
i__28722_28758 = G__28767;
continue;
}
} else {
var temp__4425__auto___28768 = cljs.core.seq.call(null,seq__28718_28755);
if(temp__4425__auto___28768){
var seq__28718_28769__$1 = temp__4425__auto___28768;
if(cljs.core.chunked_seq_QMARK_.call(null,seq__28718_28769__$1)){
var c__25804__auto___28770 = cljs.core.chunk_first.call(null,seq__28718_28769__$1);
var G__28771 = cljs.core.chunk_rest.call(null,seq__28718_28769__$1);
var G__28772 = c__25804__auto___28770;
var G__28773 = cljs.core.count.call(null,c__25804__auto___28770);
var G__28774 = (0);
seq__28718_28755 = G__28771;
chunk__28720_28756 = G__28772;
count__28721_28757 = G__28773;
i__28722_28758 = G__28774;
continue;
} else {
var arg_28775 = cljs.core.first.call(null,seq__28718_28769__$1);
if(((!((arg_28775 == null)))?((((arg_28775.cljs$lang$protocol_mask$partition1$ & (2))) || (arg_28775.cljs$core$IWatchable$))?true:(((!arg_28775.cljs$lang$protocol_mask$partition1$))?cljs.core.native_satisfies_QMARK_.call(null,cljs.core.IWatchable,arg_28775):false)):cljs.core.native_satisfies_QMARK_.call(null,cljs.core.IWatchable,arg_28775))){
cljs.core.remove_watch.call(null,arg_28775,rum.core.cursored_key.call(null,state));

var G__28776 = cljs.core.next.call(null,seq__28718_28769__$1);
var G__28777 = null;
var G__28778 = (0);
var G__28779 = (0);
seq__28718_28755 = G__28776;
chunk__28720_28756 = G__28777;
count__28721_28757 = G__28778;
i__28722_28758 = G__28779;
continue;
} else {
var G__28780 = cljs.core.next.call(null,seq__28718_28769__$1);
var G__28781 = null;
var G__28782 = (0);
var G__28783 = (0);
seq__28718_28755 = G__28780;
chunk__28720_28756 = G__28781;
count__28721_28757 = G__28782;
i__28722_28758 = G__28783;
continue;
}
}
} else {
}
}
break;
}

return state;
})], null);

//# sourceMappingURL=core.js.map