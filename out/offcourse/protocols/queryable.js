// Compiled by ClojureScript 1.7.170 {}
goog.provide('offcourse.protocols.queryable');
goog.require('cljs.core');

/**
 * @interface
 */
offcourse.protocols.queryable.Queryable = function(){};

offcourse.protocols.queryable.fetch = (function offcourse$protocols$queryable$fetch(this$,query){
if((!((this$ == null))) && (!((this$.offcourse$protocols$queryable$Queryable$fetch$arity$2 == null)))){
return this$.offcourse$protocols$queryable$Queryable$fetch$arity$2(this$,query);
} else {
var x__25736__auto__ = (((this$ == null))?null:this$);
var m__25737__auto__ = (offcourse.protocols.queryable.fetch[goog.typeOf(x__25736__auto__)]);
if(!((m__25737__auto__ == null))){
return m__25737__auto__.call(null,this$,query);
} else {
var m__25737__auto____$1 = (offcourse.protocols.queryable.fetch["_"]);
if(!((m__25737__auto____$1 == null))){
return m__25737__auto____$1.call(null,this$,query);
} else {
throw cljs.core.missing_protocol.call(null,"Queryable.fetch",this$);
}
}
}
});


//# sourceMappingURL=queryable.js.map