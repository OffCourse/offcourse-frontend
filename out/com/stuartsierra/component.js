// Compiled by ClojureScript 1.7.170 {}
goog.provide('com.stuartsierra.component');
goog.require('cljs.core');
goog.require('com.stuartsierra.dependency');
goog.require('com.stuartsierra.component.platform');

/**
 * @interface
 */
com.stuartsierra.component.Lifecycle = function(){};

/**
 * Begins operation of this component. Synchronous, does not return
 *   until the component is started. Returns an updated version of this
 *   component.
 */
com.stuartsierra.component.start = (function com$stuartsierra$component$start(component){
if((!((component == null))) && (!((component.com$stuartsierra$component$Lifecycle$start$arity$1 == null)))){
return component.com$stuartsierra$component$Lifecycle$start$arity$1(component);
} else {
var x__25596__auto__ = (((component == null))?null:component);
var m__25597__auto__ = (com.stuartsierra.component.start[goog.typeOf(x__25596__auto__)]);
if(!((m__25597__auto__ == null))){
return m__25597__auto__.call(null,component);
} else {
var m__25597__auto____$1 = (com.stuartsierra.component.start["_"]);
if(!((m__25597__auto____$1 == null))){
return m__25597__auto____$1.call(null,component);
} else {
throw cljs.core.missing_protocol.call(null,"Lifecycle.start",component);
}
}
}
});

/**
 * Ceases operation of this component. Synchronous, does not return
 *   until the component is stopped. Returns an updated version of this
 *   component.
 */
com.stuartsierra.component.stop = (function com$stuartsierra$component$stop(component){
if((!((component == null))) && (!((component.com$stuartsierra$component$Lifecycle$stop$arity$1 == null)))){
return component.com$stuartsierra$component$Lifecycle$stop$arity$1(component);
} else {
var x__25596__auto__ = (((component == null))?null:component);
var m__25597__auto__ = (com.stuartsierra.component.stop[goog.typeOf(x__25596__auto__)]);
if(!((m__25597__auto__ == null))){
return m__25597__auto__.call(null,component);
} else {
var m__25597__auto____$1 = (com.stuartsierra.component.stop["_"]);
if(!((m__25597__auto____$1 == null))){
return m__25597__auto____$1.call(null,component);
} else {
throw cljs.core.missing_protocol.call(null,"Lifecycle.stop",component);
}
}
}
});

(com.stuartsierra.component.Lifecycle["object"] = true);

(com.stuartsierra.component.start["object"] = (function (this$){
return this$;
}));

(com.stuartsierra.component.stop["object"] = (function (this$){
return this$;
}));
/**
 * Returns the map of other components on which this component depends.
 */
com.stuartsierra.component.dependencies = (function com$stuartsierra$component$dependencies(component){
return new cljs.core.Keyword("com.stuartsierra.component","dependencies","com.stuartsierra.component/dependencies",-1213797470).cljs$core$IFn$_invoke$arity$2(cljs.core.meta.call(null,component),cljs.core.PersistentArrayMap.EMPTY);
});
/**
 * Associates metadata with component describing the other components
 *   on which it depends. Component dependencies are specified as a map.
 *   Keys in the map correspond to keys in this component which must be
 *   provided by its containing system. Values in the map are the keys in
 *   the system at which those components may be found. Alternatively, if
 *   the keys are the same in both the component and its enclosing
 *   system, they may be specified as a vector of keys.
 */
com.stuartsierra.component.using = (function com$stuartsierra$component$using(component,dependencies){
return cljs.core.vary_meta.call(null,component,cljs.core.update_in,new cljs.core.PersistentVector(null, 1, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Keyword("com.stuartsierra.component","dependencies","com.stuartsierra.component/dependencies",-1213797470)], null),cljs.core.fnil.call(null,cljs.core.merge,cljs.core.PersistentArrayMap.EMPTY),((cljs.core.map_QMARK_.call(null,dependencies))?dependencies:((cljs.core.vector_QMARK_.call(null,dependencies))?cljs.core.into.call(null,cljs.core.PersistentArrayMap.EMPTY,cljs.core.map.call(null,(function (x){
return new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [x,x], null);
}),dependencies)):(function(){throw cljs.core.ex_info.call(null,"Dependencies must be a map or vector",new cljs.core.PersistentArrayMap(null, 3, [new cljs.core.Keyword(null,"reason","reason",-2070751759),new cljs.core.Keyword("com.stuartsierra.component","invalid-dependencies","com.stuartsierra.component/invalid-dependencies",-1050144080),new cljs.core.Keyword(null,"component","component",1555936782),component,new cljs.core.Keyword(null,"dependencies","dependencies",1108064605),dependencies], null))})()
)));
});
com.stuartsierra.component.nil_component = (function com$stuartsierra$component$nil_component(system,key){
return cljs.core.ex_info.call(null,[cljs.core.str("Component "),cljs.core.str(key),cljs.core.str(" was nil in system; maybe it returned nil from start or stop")].join(''),new cljs.core.PersistentArrayMap(null, 3, [new cljs.core.Keyword(null,"reason","reason",-2070751759),new cljs.core.Keyword("com.stuartsierra.component","nil-component","com.stuartsierra.component/nil-component",-1755174116),new cljs.core.Keyword(null,"system-key","system-key",-334147604),key,new cljs.core.Keyword(null,"system","system",-29381724),system], null));
});
com.stuartsierra.component.get_component = (function com$stuartsierra$component$get_component(system,key){
var component = cljs.core.get.call(null,system,key,new cljs.core.Keyword("com.stuartsierra.component","not-found","com.stuartsierra.component/not-found",1697924753));
if((component == null)){
throw com.stuartsierra.component.nil_component.call(null,system,key);
} else {
}

if(cljs.core._EQ_.call(null,new cljs.core.Keyword("com.stuartsierra.component","not-found","com.stuartsierra.component/not-found",1697924753),component)){
throw cljs.core.ex_info.call(null,[cljs.core.str("Missing component "),cljs.core.str(key),cljs.core.str(" from system")].join(''),new cljs.core.PersistentArrayMap(null, 3, [new cljs.core.Keyword(null,"reason","reason",-2070751759),new cljs.core.Keyword("com.stuartsierra.component","missing-component","com.stuartsierra.component/missing-component",-1719526915),new cljs.core.Keyword(null,"system-key","system-key",-334147604),key,new cljs.core.Keyword(null,"system","system",-29381724),system], null));
} else {
}

return component;
});
com.stuartsierra.component.get_dependency = (function com$stuartsierra$component$get_dependency(system,system_key,component,dependency_key){
var dependency = cljs.core.get.call(null,system,system_key,new cljs.core.Keyword("com.stuartsierra.component","not-found","com.stuartsierra.component/not-found",1697924753));
if((dependency == null)){
throw com.stuartsierra.component.nil_component.call(null,system,system_key);
} else {
}

if(cljs.core._EQ_.call(null,new cljs.core.Keyword("com.stuartsierra.component","not-found","com.stuartsierra.component/not-found",1697924753),dependency)){
throw cljs.core.ex_info.call(null,[cljs.core.str("Missing dependency "),cljs.core.str(dependency_key),cljs.core.str(" of "),cljs.core.str(com.stuartsierra.component.platform.type_name.call(null,component)),cljs.core.str(" expected in system at "),cljs.core.str(system_key)].join(''),new cljs.core.PersistentArrayMap(null, 5, [new cljs.core.Keyword(null,"reason","reason",-2070751759),new cljs.core.Keyword("com.stuartsierra.component","missing-dependency","com.stuartsierra.component/missing-dependency",-1159089756),new cljs.core.Keyword(null,"system-key","system-key",-334147604),system_key,new cljs.core.Keyword(null,"dependency-key","dependency-key",684780755),dependency_key,new cljs.core.Keyword(null,"component","component",1555936782),component,new cljs.core.Keyword(null,"system","system",-29381724),system], null));
} else {
}

return dependency;
});
/**
 * Associates dependency metadata with multiple components in the
 *   system. dependency-map is a map of keys in the system to maps or
 *   vectors specifying the dependencies of the component at that key in
 *   the system, as per 'using'.
 */
com.stuartsierra.component.system_using = (function com$stuartsierra$component$system_using(system,dependency_map){
return cljs.core.reduce_kv.call(null,(function (system__$1,key,dependencies){
var component = com.stuartsierra.component.get_component.call(null,system__$1,key);
return cljs.core.assoc.call(null,system__$1,key,com.stuartsierra.component.using.call(null,component,dependencies));
}),system,dependency_map);
});
/**
 * Returns a dependency graph, using the data structures defined in
 *   com.stuartsierra.dependency, for the components found by
 *   (select-keys system component-keys)
 */
com.stuartsierra.component.dependency_graph = (function com$stuartsierra$component$dependency_graph(system,component_keys){
return cljs.core.reduce_kv.call(null,(function (graph,key,component){
return cljs.core.reduce.call(null,(function (p1__32736_SHARP_,p2__32737_SHARP_){
return com.stuartsierra.dependency.depend.call(null,p1__32736_SHARP_,key,p2__32737_SHARP_);
}),graph,cljs.core.vals.call(null,com.stuartsierra.component.dependencies.call(null,component)));
}),com.stuartsierra.dependency.graph.call(null),cljs.core.select_keys.call(null,system,component_keys));
});
com.stuartsierra.component.assoc_dependency = (function com$stuartsierra$component$assoc_dependency(system,component,dependency_key,system_key){
var dependency = com.stuartsierra.component.get_dependency.call(null,system,system_key,component,dependency_key);
return cljs.core.assoc.call(null,component,dependency_key,dependency);
});
com.stuartsierra.component.assoc_dependencies = (function com$stuartsierra$component$assoc_dependencies(component,system){
return cljs.core.reduce_kv.call(null,(function (p1__32738_SHARP_,p2__32739_SHARP_,p3__32740_SHARP_){
return com.stuartsierra.component.assoc_dependency.call(null,system,p1__32738_SHARP_,p2__32739_SHARP_,p3__32740_SHARP_);
}),component,com.stuartsierra.component.dependencies.call(null,component));
});
com.stuartsierra.component.try_action = (function com$stuartsierra$component$try_action(component,system,key,f,args){
try{return cljs.core.apply.call(null,f,component,args);
}catch (e32742){var t = e32742;
throw cljs.core.ex_info.call(null,[cljs.core.str("Error in component "),cljs.core.str(key),cljs.core.str(" in system "),cljs.core.str(com.stuartsierra.component.platform.type_name.call(null,system)),cljs.core.str(" calling "),cljs.core.str(f)].join(''),new cljs.core.PersistentArrayMap(null, 5, [new cljs.core.Keyword(null,"reason","reason",-2070751759),new cljs.core.Keyword("com.stuartsierra.component","component-function-threw-exception","com.stuartsierra.component/component-function-threw-exception",1285478818),new cljs.core.Keyword(null,"function","function",-2127255473),f,new cljs.core.Keyword(null,"system-key","system-key",-334147604),key,new cljs.core.Keyword(null,"component","component",1555936782),component,new cljs.core.Keyword(null,"system","system",-29381724),system], null),t);
}});
/**
 * Invokes (apply f component args) on each of the components at
 *   component-keys in the system, in dependency order. Before invoking
 *   f, assoc's updated dependencies of the component.
 */
com.stuartsierra.component.update_system = (function com$stuartsierra$component$update_system(var_args){
var args__26006__auto__ = [];
var len__25999__auto___32747 = arguments.length;
var i__26000__auto___32748 = (0);
while(true){
if((i__26000__auto___32748 < len__25999__auto___32747)){
args__26006__auto__.push((arguments[i__26000__auto___32748]));

var G__32749 = (i__26000__auto___32748 + (1));
i__26000__auto___32748 = G__32749;
continue;
} else {
}
break;
}

var argseq__26007__auto__ = ((((3) < args__26006__auto__.length))?(new cljs.core.IndexedSeq(args__26006__auto__.slice((3)),(0))):null);
return com.stuartsierra.component.update_system.cljs$core$IFn$_invoke$arity$variadic((arguments[(0)]),(arguments[(1)]),(arguments[(2)]),argseq__26007__auto__);
});

com.stuartsierra.component.update_system.cljs$core$IFn$_invoke$arity$variadic = (function (system,component_keys,f,args){
var graph = com.stuartsierra.component.dependency_graph.call(null,system,component_keys);
return cljs.core.reduce.call(null,((function (graph){
return (function (system__$1,key){
return cljs.core.assoc.call(null,system__$1,key,com.stuartsierra.component.try_action.call(null,com.stuartsierra.component.assoc_dependencies.call(null,com.stuartsierra.component.get_component.call(null,system__$1,key),system__$1),system__$1,key,f,args));
});})(graph))
,system,cljs.core.sort.call(null,com.stuartsierra.dependency.topo_comparator.call(null,graph),component_keys));
});

com.stuartsierra.component.update_system.cljs$lang$maxFixedArity = (3);

com.stuartsierra.component.update_system.cljs$lang$applyTo = (function (seq32743){
var G__32744 = cljs.core.first.call(null,seq32743);
var seq32743__$1 = cljs.core.next.call(null,seq32743);
var G__32745 = cljs.core.first.call(null,seq32743__$1);
var seq32743__$2 = cljs.core.next.call(null,seq32743__$1);
var G__32746 = cljs.core.first.call(null,seq32743__$2);
var seq32743__$3 = cljs.core.next.call(null,seq32743__$2);
return com.stuartsierra.component.update_system.cljs$core$IFn$_invoke$arity$variadic(G__32744,G__32745,G__32746,seq32743__$3);
});
/**
 * Like update-system but operates in reverse dependency order.
 */
com.stuartsierra.component.update_system_reverse = (function com$stuartsierra$component$update_system_reverse(var_args){
var args__26006__auto__ = [];
var len__25999__auto___32754 = arguments.length;
var i__26000__auto___32755 = (0);
while(true){
if((i__26000__auto___32755 < len__25999__auto___32754)){
args__26006__auto__.push((arguments[i__26000__auto___32755]));

var G__32756 = (i__26000__auto___32755 + (1));
i__26000__auto___32755 = G__32756;
continue;
} else {
}
break;
}

var argseq__26007__auto__ = ((((3) < args__26006__auto__.length))?(new cljs.core.IndexedSeq(args__26006__auto__.slice((3)),(0))):null);
return com.stuartsierra.component.update_system_reverse.cljs$core$IFn$_invoke$arity$variadic((arguments[(0)]),(arguments[(1)]),(arguments[(2)]),argseq__26007__auto__);
});

com.stuartsierra.component.update_system_reverse.cljs$core$IFn$_invoke$arity$variadic = (function (system,component_keys,f,args){
var graph = com.stuartsierra.component.dependency_graph.call(null,system,component_keys);
return cljs.core.reduce.call(null,((function (graph){
return (function (system__$1,key){
return cljs.core.assoc.call(null,system__$1,key,com.stuartsierra.component.try_action.call(null,com.stuartsierra.component.assoc_dependencies.call(null,com.stuartsierra.component.get_component.call(null,system__$1,key),system__$1),system__$1,key,f,args));
});})(graph))
,system,cljs.core.reverse.call(null,cljs.core.sort.call(null,com.stuartsierra.dependency.topo_comparator.call(null,graph),component_keys)));
});

com.stuartsierra.component.update_system_reverse.cljs$lang$maxFixedArity = (3);

com.stuartsierra.component.update_system_reverse.cljs$lang$applyTo = (function (seq32750){
var G__32751 = cljs.core.first.call(null,seq32750);
var seq32750__$1 = cljs.core.next.call(null,seq32750);
var G__32752 = cljs.core.first.call(null,seq32750__$1);
var seq32750__$2 = cljs.core.next.call(null,seq32750__$1);
var G__32753 = cljs.core.first.call(null,seq32750__$2);
var seq32750__$3 = cljs.core.next.call(null,seq32750__$2);
return com.stuartsierra.component.update_system_reverse.cljs$core$IFn$_invoke$arity$variadic(G__32751,G__32752,G__32753,seq32750__$3);
});
/**
 * Recursively starts components in the system, in dependency order,
 *   assoc'ing in their dependencies along the way. component-keys is a
 *   collection of keys (order doesn't matter) in the system specifying
 *   the components to start, defaults to all keys in the system.
 */
com.stuartsierra.component.start_system = (function com$stuartsierra$component$start_system(var_args){
var args32757 = [];
var len__25999__auto___32760 = arguments.length;
var i__26000__auto___32761 = (0);
while(true){
if((i__26000__auto___32761 < len__25999__auto___32760)){
args32757.push((arguments[i__26000__auto___32761]));

var G__32762 = (i__26000__auto___32761 + (1));
i__26000__auto___32761 = G__32762;
continue;
} else {
}
break;
}

var G__32759 = args32757.length;
switch (G__32759) {
case 1:
return com.stuartsierra.component.start_system.cljs$core$IFn$_invoke$arity$1((arguments[(0)]));

break;
case 2:
return com.stuartsierra.component.start_system.cljs$core$IFn$_invoke$arity$2((arguments[(0)]),(arguments[(1)]));

break;
default:
throw (new Error([cljs.core.str("Invalid arity: "),cljs.core.str(args32757.length)].join('')));

}
});

com.stuartsierra.component.start_system.cljs$core$IFn$_invoke$arity$1 = (function (system){
return com.stuartsierra.component.start_system.call(null,system,cljs.core.keys.call(null,system));
});

com.stuartsierra.component.start_system.cljs$core$IFn$_invoke$arity$2 = (function (system,component_keys){
return com.stuartsierra.component.update_system.call(null,system,component_keys,new cljs.core.Var(function(){return com.stuartsierra.component.start;},new cljs.core.Symbol("com.stuartsierra.component","start","com.stuartsierra.component/start",-1511960847,null),cljs.core.PersistentHashMap.fromArrays([new cljs.core.Keyword(null,"protocol","protocol",652470118),new cljs.core.Keyword(null,"ns","ns",441598760),new cljs.core.Keyword(null,"name","name",1843675177),new cljs.core.Keyword(null,"file","file",-1269645878),new cljs.core.Keyword(null,"end-column","end-column",1425389514),new cljs.core.Keyword(null,"column","column",2078222095),new cljs.core.Keyword(null,"line","line",212345235),new cljs.core.Keyword(null,"end-line","end-line",1837326455),new cljs.core.Keyword(null,"arglists","arglists",1661989754),new cljs.core.Keyword(null,"doc","doc",1913296891),new cljs.core.Keyword(null,"test","test",577538877)],[new cljs.core.Symbol("com.stuartsierra.component","Lifecycle","com.stuartsierra.component/Lifecycle",-1776107234,null),new cljs.core.Symbol(null,"com.stuartsierra.component","com.stuartsierra.component",881800690,null),new cljs.core.Symbol(null,"start","start",1285322546,null),"out/com/stuartsierra/component.cljc",9,1,5,6,cljs.core.list(new cljs.core.PersistentVector(null, 1, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Symbol(null,"component","component",-1098498987,null)], null)),"Begins operation of this component. Synchronous, does not return\n  until the component is started. Returns an updated version of this\n  component.",(cljs.core.truth_(com.stuartsierra.component.start)?com.stuartsierra.component.start.cljs$lang$test:null)])));
});

com.stuartsierra.component.start_system.cljs$lang$maxFixedArity = 2;
/**
 * Recursively stops components in the system, in reverse dependency
 *   order. component-keys is a collection of keys (order doesn't matter)
 *   in the system specifying the components to stop, defaults to all
 *   keys in the system.
 */
com.stuartsierra.component.stop_system = (function com$stuartsierra$component$stop_system(var_args){
var args32764 = [];
var len__25999__auto___32767 = arguments.length;
var i__26000__auto___32768 = (0);
while(true){
if((i__26000__auto___32768 < len__25999__auto___32767)){
args32764.push((arguments[i__26000__auto___32768]));

var G__32769 = (i__26000__auto___32768 + (1));
i__26000__auto___32768 = G__32769;
continue;
} else {
}
break;
}

var G__32766 = args32764.length;
switch (G__32766) {
case 1:
return com.stuartsierra.component.stop_system.cljs$core$IFn$_invoke$arity$1((arguments[(0)]));

break;
case 2:
return com.stuartsierra.component.stop_system.cljs$core$IFn$_invoke$arity$2((arguments[(0)]),(arguments[(1)]));

break;
default:
throw (new Error([cljs.core.str("Invalid arity: "),cljs.core.str(args32764.length)].join('')));

}
});

com.stuartsierra.component.stop_system.cljs$core$IFn$_invoke$arity$1 = (function (system){
return com.stuartsierra.component.stop_system.call(null,system,cljs.core.keys.call(null,system));
});

com.stuartsierra.component.stop_system.cljs$core$IFn$_invoke$arity$2 = (function (system,component_keys){
return com.stuartsierra.component.update_system_reverse.call(null,system,component_keys,new cljs.core.Var(function(){return com.stuartsierra.component.stop;},new cljs.core.Symbol("com.stuartsierra.component","stop","com.stuartsierra.component/stop",1533540630,null),cljs.core.PersistentHashMap.fromArrays([new cljs.core.Keyword(null,"protocol","protocol",652470118),new cljs.core.Keyword(null,"ns","ns",441598760),new cljs.core.Keyword(null,"name","name",1843675177),new cljs.core.Keyword(null,"file","file",-1269645878),new cljs.core.Keyword(null,"end-column","end-column",1425389514),new cljs.core.Keyword(null,"column","column",2078222095),new cljs.core.Keyword(null,"line","line",212345235),new cljs.core.Keyword(null,"end-line","end-line",1837326455),new cljs.core.Keyword(null,"arglists","arglists",1661989754),new cljs.core.Keyword(null,"doc","doc",1913296891),new cljs.core.Keyword(null,"test","test",577538877)],[new cljs.core.Symbol("com.stuartsierra.component","Lifecycle","com.stuartsierra.component/Lifecycle",-1776107234,null),new cljs.core.Symbol(null,"com.stuartsierra.component","com.stuartsierra.component",881800690,null),new cljs.core.Symbol(null,"stop","stop",-500379815,null),"out/com/stuartsierra/component.cljc",8,1,5,10,cljs.core.list(new cljs.core.PersistentVector(null, 1, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Symbol(null,"component","component",-1098498987,null)], null)),"Ceases operation of this component. Synchronous, does not return\n  until the component is stopped. Returns an updated version of this\n  component.",(cljs.core.truth_(com.stuartsierra.component.stop)?com.stuartsierra.component.stop.cljs$lang$test:null)])));
});

com.stuartsierra.component.stop_system.cljs$lang$maxFixedArity = 2;

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
com.stuartsierra.component.SystemMap = (function (__meta,__extmap,__hash){
this.__meta = __meta;
this.__extmap = __extmap;
this.__hash = __hash;
this.cljs$lang$protocol_mask$partition0$ = 2229667594;
this.cljs$lang$protocol_mask$partition1$ = 8192;
})
com.stuartsierra.component.SystemMap.prototype.com$stuartsierra$component$Lifecycle$ = true;

com.stuartsierra.component.SystemMap.prototype.com$stuartsierra$component$Lifecycle$start$arity$1 = (function (system){
var self__ = this;
var system__$1 = this;
return com.stuartsierra.component.start_system.call(null,system__$1);
});

com.stuartsierra.component.SystemMap.prototype.com$stuartsierra$component$Lifecycle$stop$arity$1 = (function (system){
var self__ = this;
var system__$1 = this;
return com.stuartsierra.component.stop_system.call(null,system__$1);
});

com.stuartsierra.component.SystemMap.prototype.cljs$core$ILookup$_lookup$arity$2 = (function (this__25555__auto__,k__25556__auto__){
var self__ = this;
var this__25555__auto____$1 = this;
return cljs.core._lookup.call(null,this__25555__auto____$1,k__25556__auto__,null);
});

com.stuartsierra.component.SystemMap.prototype.cljs$core$ILookup$_lookup$arity$3 = (function (this__25557__auto__,k32772,else__25558__auto__){
var self__ = this;
var this__25557__auto____$1 = this;
var G__32774 = k32772;
switch (G__32774) {
default:
return cljs.core.get.call(null,self__.__extmap,k32772,else__25558__auto__);

}
});

com.stuartsierra.component.SystemMap.prototype.cljs$core$IPrintWithWriter$_pr_writer$arity$3 = (function (this__25569__auto__,writer__25570__auto__,opts__25571__auto__){
var self__ = this;
var this__25569__auto____$1 = this;
var pr_pair__25572__auto__ = ((function (this__25569__auto____$1){
return (function (keyval__25573__auto__){
return cljs.core.pr_sequential_writer.call(null,writer__25570__auto__,cljs.core.pr_writer,""," ","",opts__25571__auto__,keyval__25573__auto__);
});})(this__25569__auto____$1))
;
return cljs.core.pr_sequential_writer.call(null,writer__25570__auto__,pr_pair__25572__auto__,"#com.stuartsierra.component.SystemMap{",", ","}",opts__25571__auto__,cljs.core.concat.call(null,cljs.core.PersistentVector.EMPTY,self__.__extmap));
});

com.stuartsierra.component.SystemMap.prototype.cljs$core$IIterable$ = true;

com.stuartsierra.component.SystemMap.prototype.cljs$core$IIterable$_iterator$arity$1 = (function (G__32771){
var self__ = this;
var G__32771__$1 = this;
return (new cljs.core.RecordIter((0),G__32771__$1,0,cljs.core.PersistentVector.EMPTY,cljs.core._iterator.call(null,self__.__extmap)));
});

com.stuartsierra.component.SystemMap.prototype.cljs$core$IMeta$_meta$arity$1 = (function (this__25553__auto__){
var self__ = this;
var this__25553__auto____$1 = this;
return self__.__meta;
});

com.stuartsierra.component.SystemMap.prototype.cljs$core$ICloneable$_clone$arity$1 = (function (this__25549__auto__){
var self__ = this;
var this__25549__auto____$1 = this;
return (new com.stuartsierra.component.SystemMap(self__.__meta,self__.__extmap,self__.__hash));
});

com.stuartsierra.component.SystemMap.prototype.cljs$core$ICounted$_count$arity$1 = (function (this__25559__auto__){
var self__ = this;
var this__25559__auto____$1 = this;
return (0 + cljs.core.count.call(null,self__.__extmap));
});

com.stuartsierra.component.SystemMap.prototype.cljs$core$IHash$_hash$arity$1 = (function (this__25550__auto__){
var self__ = this;
var this__25550__auto____$1 = this;
var h__25376__auto__ = self__.__hash;
if(!((h__25376__auto__ == null))){
return h__25376__auto__;
} else {
var h__25376__auto____$1 = cljs.core.hash_imap.call(null,this__25550__auto____$1);
self__.__hash = h__25376__auto____$1;

return h__25376__auto____$1;
}
});

com.stuartsierra.component.SystemMap.prototype.cljs$core$IEquiv$_equiv$arity$2 = (function (this__25551__auto__,other__25552__auto__){
var self__ = this;
var this__25551__auto____$1 = this;
if(cljs.core.truth_((function (){var and__24929__auto__ = other__25552__auto__;
if(cljs.core.truth_(and__24929__auto__)){
var and__24929__auto____$1 = (this__25551__auto____$1.constructor === other__25552__auto__.constructor);
if(and__24929__auto____$1){
return cljs.core.equiv_map.call(null,this__25551__auto____$1,other__25552__auto__);
} else {
return and__24929__auto____$1;
}
} else {
return and__24929__auto__;
}
})())){
return true;
} else {
return false;
}
});

com.stuartsierra.component.SystemMap.prototype.cljs$core$IMap$_dissoc$arity$2 = (function (this__25564__auto__,k__25565__auto__){
var self__ = this;
var this__25564__auto____$1 = this;
if(cljs.core.contains_QMARK_.call(null,cljs.core.PersistentHashSet.EMPTY,k__25565__auto__)){
return cljs.core.dissoc.call(null,cljs.core.with_meta.call(null,cljs.core.into.call(null,cljs.core.PersistentArrayMap.EMPTY,this__25564__auto____$1),self__.__meta),k__25565__auto__);
} else {
return (new com.stuartsierra.component.SystemMap(self__.__meta,cljs.core.not_empty.call(null,cljs.core.dissoc.call(null,self__.__extmap,k__25565__auto__)),null));
}
});

com.stuartsierra.component.SystemMap.prototype.cljs$core$IAssociative$_assoc$arity$3 = (function (this__25562__auto__,k__25563__auto__,G__32771){
var self__ = this;
var this__25562__auto____$1 = this;
var pred__32775 = cljs.core.keyword_identical_QMARK_;
var expr__32776 = k__25563__auto__;
return (new com.stuartsierra.component.SystemMap(self__.__meta,cljs.core.assoc.call(null,self__.__extmap,k__25563__auto__,G__32771),null));
});

com.stuartsierra.component.SystemMap.prototype.cljs$core$ISeqable$_seq$arity$1 = (function (this__25567__auto__){
var self__ = this;
var this__25567__auto____$1 = this;
return cljs.core.seq.call(null,cljs.core.concat.call(null,cljs.core.PersistentVector.EMPTY,self__.__extmap));
});

com.stuartsierra.component.SystemMap.prototype.cljs$core$IWithMeta$_with_meta$arity$2 = (function (this__25554__auto__,G__32771){
var self__ = this;
var this__25554__auto____$1 = this;
return (new com.stuartsierra.component.SystemMap(G__32771,self__.__extmap,self__.__hash));
});

com.stuartsierra.component.SystemMap.prototype.cljs$core$ICollection$_conj$arity$2 = (function (this__25560__auto__,entry__25561__auto__){
var self__ = this;
var this__25560__auto____$1 = this;
if(cljs.core.vector_QMARK_.call(null,entry__25561__auto__)){
return cljs.core._assoc.call(null,this__25560__auto____$1,cljs.core._nth.call(null,entry__25561__auto__,(0)),cljs.core._nth.call(null,entry__25561__auto__,(1)));
} else {
return cljs.core.reduce.call(null,cljs.core._conj,this__25560__auto____$1,entry__25561__auto__);
}
});

com.stuartsierra.component.SystemMap.getBasis = (function (){
return cljs.core.PersistentVector.EMPTY;
});

com.stuartsierra.component.SystemMap.cljs$lang$type = true;

com.stuartsierra.component.SystemMap.cljs$lang$ctorPrSeq = (function (this__25589__auto__){
return cljs.core._conj.call(null,cljs.core.List.EMPTY,"com.stuartsierra.component/SystemMap");
});

com.stuartsierra.component.SystemMap.cljs$lang$ctorPrWriter = (function (this__25589__auto__,writer__25590__auto__){
return cljs.core._write.call(null,writer__25590__auto__,"com.stuartsierra.component/SystemMap");
});

com.stuartsierra.component.__GT_SystemMap = (function com$stuartsierra$component$__GT_SystemMap(){
return (new com.stuartsierra.component.SystemMap(null,null,null));
});

com.stuartsierra.component.map__GT_SystemMap = (function com$stuartsierra$component$map__GT_SystemMap(G__32773){
return (new com.stuartsierra.component.SystemMap(null,cljs.core.dissoc.call(null,G__32773),null));
});

com.stuartsierra.component.SystemMap.prototype.cljs$core$IPrintWithWriter$ = true;

com.stuartsierra.component.SystemMap.prototype.cljs$core$IPrintWithWriter$_pr_writer$arity$3 = (function (this$,writer,opts){
var this$__$1 = this;
return cljs.core._write.call(null,writer,"#<SystemMap>");
});
/**
 * Returns a system constructed of key/value pairs. The system has
 *   default implementations of the Lifecycle 'start' and 'stop' methods
 *   which recursively start/stop all components in the system.
 * 
 *   System maps print as #<SystemMap> to avoid overwhelming the printer
 *   with large objects. As a consequence, printed system maps cannot be
 *   'read'. To disable this behavior and print system maps like normal
 *   records, call
 *   (remove-method clojure.core/print-method com.stuartsierra.component.SystemMap)
 */
com.stuartsierra.component.system_map = (function com$stuartsierra$component$system_map(var_args){
var args__26006__auto__ = [];
var len__25999__auto___32780 = arguments.length;
var i__26000__auto___32781 = (0);
while(true){
if((i__26000__auto___32781 < len__25999__auto___32780)){
args__26006__auto__.push((arguments[i__26000__auto___32781]));

var G__32782 = (i__26000__auto___32781 + (1));
i__26000__auto___32781 = G__32782;
continue;
} else {
}
break;
}

var argseq__26007__auto__ = ((((0) < args__26006__auto__.length))?(new cljs.core.IndexedSeq(args__26006__auto__.slice((0)),(0))):null);
return com.stuartsierra.component.system_map.cljs$core$IFn$_invoke$arity$variadic(argseq__26007__auto__);
});

com.stuartsierra.component.system_map.cljs$core$IFn$_invoke$arity$variadic = (function (keyvals){
if(cljs.core.even_QMARK_.call(null,cljs.core.count.call(null,keyvals))){
} else {
throw com.stuartsierra.component.platform.argument_error.call(null,"system-map requires an even number of arguments");
}

return com.stuartsierra.component.map__GT_SystemMap.call(null,cljs.core.apply.call(null,cljs.core.array_map,keyvals));
});

com.stuartsierra.component.system_map.cljs$lang$maxFixedArity = (0);

com.stuartsierra.component.system_map.cljs$lang$applyTo = (function (seq32779){
return com.stuartsierra.component.system_map.cljs$core$IFn$_invoke$arity$variadic(cljs.core.seq.call(null,seq32779));
});
/**
 * True if the error has ex-data indicating it was thrown by something
 *   in the com.stuartsierra.component namespace.
 */
com.stuartsierra.component.ex_component_QMARK_ = (function com$stuartsierra$component$ex_component_QMARK_(error){
var map__32785 = cljs.core.ex_data.call(null,error);
var map__32785__$1 = ((((!((map__32785 == null)))?((((map__32785.cljs$lang$protocol_mask$partition0$ & (64))) || (map__32785.cljs$core$ISeq$))?true:false):false))?cljs.core.apply.call(null,cljs.core.hash_map,map__32785):map__32785);
var reason = cljs.core.get.call(null,map__32785__$1,new cljs.core.Keyword(null,"reason","reason",-2070751759));
return ((reason instanceof cljs.core.Keyword)) && (cljs.core._EQ_.call(null,"com.stuartsierra.component",cljs.core.namespace.call(null,reason)));
});
/**
 * If the error has ex-data provided by the com.stuartsierra.component
 *   namespace, returns a new exception instance with the :component
 *   and :system removed from its ex-data. Preserves the other details of
 *   the original error. If the error was not created by this namespace,
 *   returns it unchanged. Use this when you want to catch and rethrow
 *   exceptions without including the full component or system.
 */
com.stuartsierra.component.ex_without_components = (function com$stuartsierra$component$ex_without_components(error){
if(cljs.core.truth_(com.stuartsierra.component.ex_component_QMARK_.call(null,error))){
return com.stuartsierra.component.platform.alter_ex_data.call(null,error,cljs.core.dissoc,new cljs.core.Keyword(null,"component","component",1555936782),new cljs.core.Keyword(null,"system","system",-29381724));
} else {
return error;
}
});

//# sourceMappingURL=component.js.map