// Compiled by ClojureScript 1.7.170 {}
goog.provide('com.stuartsierra.component.platform');
goog.require('cljs.core');
com.stuartsierra.component.platform.argument_error = (function com$stuartsierra$component$platform$argument_error(message){
return cljs.core.ex_info.call(null,message,new cljs.core.PersistentArrayMap(null, 1, [new cljs.core.Keyword(null,"reason","reason",-2070751759),new cljs.core.Keyword("com.stuartsierra.component.platform","illegal-argument","com.stuartsierra.component.platform/illegal-argument",-1074189374)], null));
});
/**
 * Returns a string name for the type/class of x.
 */
com.stuartsierra.component.platform.type_name = (function com$stuartsierra$component$platform$type_name(x){
return cljs.core.type__GT_str.call(null,cljs.core.type.call(null,x));
});
/**
 * Returns a new ExceptionInfo with the same details as error and
 *   ex-data as the result of (apply f (ex-data throwable) args).
 */
com.stuartsierra.component.platform.alter_ex_data = (function com$stuartsierra$component$platform$alter_ex_data(var_args){
var args__26006__auto__ = [];
var len__25999__auto___32887 = arguments.length;
var i__26000__auto___32888 = (0);
while(true){
if((i__26000__auto___32888 < len__25999__auto___32887)){
args__26006__auto__.push((arguments[i__26000__auto___32888]));

var G__32889 = (i__26000__auto___32888 + (1));
i__26000__auto___32888 = G__32889;
continue;
} else {
}
break;
}

var argseq__26007__auto__ = ((((2) < args__26006__auto__.length))?(new cljs.core.IndexedSeq(args__26006__auto__.slice((2)),(0))):null);
return com.stuartsierra.component.platform.alter_ex_data.cljs$core$IFn$_invoke$arity$variadic((arguments[(0)]),(arguments[(1)]),argseq__26007__auto__);
});

com.stuartsierra.component.platform.alter_ex_data.cljs$core$IFn$_invoke$arity$variadic = (function (error,f,args){
var ex = cljs.core.ex_info.call(null,cljs.core.ex_message.call(null,error),cljs.core.apply.call(null,f,cljs.core.ex_data.call(null,error),args),cljs.core.ex_cause.call(null,error));
ex.name = error.name;

ex.description = error.description;

ex.number = error.number;

ex.fileName = error.fileName;

ex.lineNumber = error.lineNumber;

ex.columnNumber = error.columnNumber;

ex.stack = error.stack;

return ex;
});

com.stuartsierra.component.platform.alter_ex_data.cljs$lang$maxFixedArity = (2);

com.stuartsierra.component.platform.alter_ex_data.cljs$lang$applyTo = (function (seq32884){
var G__32885 = cljs.core.first.call(null,seq32884);
var seq32884__$1 = cljs.core.next.call(null,seq32884);
var G__32886 = cljs.core.first.call(null,seq32884__$1);
var seq32884__$2 = cljs.core.next.call(null,seq32884__$1);
return com.stuartsierra.component.platform.alter_ex_data.cljs$core$IFn$_invoke$arity$variadic(G__32885,G__32886,seq32884__$2);
});

//# sourceMappingURL=platform.js.map