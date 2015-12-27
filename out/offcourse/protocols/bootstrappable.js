// Compiled by ClojureScript 1.7.170 {}
goog.provide('offcourse.protocols.bootstrappable');
goog.require('cljs.core');

/**
 * @interface
 */
offcourse.protocols.bootstrappable.Bootstrappable = function(){};

offcourse.protocols.bootstrappable.bootstrap = (function offcourse$protocols$bootstrappable$bootstrap(this$){
if((!((this$ == null))) && (!((this$.offcourse$protocols$bootstrappable$Bootstrappable$bootstrap$arity$1 == null)))){
return this$.offcourse$protocols$bootstrappable$Bootstrappable$bootstrap$arity$1(this$);
} else {
var x__25736__auto__ = (((this$ == null))?null:this$);
var m__25737__auto__ = (offcourse.protocols.bootstrappable.bootstrap[goog.typeOf(x__25736__auto__)]);
if(!((m__25737__auto__ == null))){
return m__25737__auto__.call(null,this$);
} else {
var m__25737__auto____$1 = (offcourse.protocols.bootstrappable.bootstrap["_"]);
if(!((m__25737__auto____$1 == null))){
return m__25737__auto____$1.call(null,this$);
} else {
throw cljs.core.missing_protocol.call(null,"Bootstrappable.bootstrap",this$);
}
}
}
});


//# sourceMappingURL=bootstrappable.js.map