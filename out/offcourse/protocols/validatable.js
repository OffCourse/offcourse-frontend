// Compiled by ClojureScript 1.7.170 {}
goog.provide('offcourse.protocols.validatable');
goog.require('cljs.core');

/**
 * @interface
 */
offcourse.protocols.validatable.Validatable = function(){};

offcourse.protocols.validatable.errors = (function offcourse$protocols$validatable$errors(var_args){
var args29682 = [];
var len__26059__auto___29685 = arguments.length;
var i__26060__auto___29686 = (0);
while(true){
if((i__26060__auto___29686 < len__26059__auto___29685)){
args29682.push((arguments[i__26060__auto___29686]));

var G__29687 = (i__26060__auto___29686 + (1));
i__26060__auto___29686 = G__29687;
continue;
} else {
}
break;
}

var G__29684 = args29682.length;
switch (G__29684) {
case 1:
return offcourse.protocols.validatable.errors.cljs$core$IFn$_invoke$arity$1((arguments[(0)]));

break;
case 3:
return offcourse.protocols.validatable.errors.cljs$core$IFn$_invoke$arity$3((arguments[(0)]),(arguments[(1)]),(arguments[(2)]));

break;
default:
throw (new Error([cljs.core.str("Invalid arity: "),cljs.core.str(args29682.length)].join('')));

}
});

offcourse.protocols.validatable.errors.cljs$core$IFn$_invoke$arity$1 = (function (this$){
if((!((this$ == null))) && (!((this$.offcourse$protocols$validatable$Validatable$errors$arity$1 == null)))){
return this$.offcourse$protocols$validatable$Validatable$errors$arity$1(this$);
} else {
var x__25656__auto__ = (((this$ == null))?null:this$);
var m__25657__auto__ = (offcourse.protocols.validatable.errors[goog.typeOf(x__25656__auto__)]);
if(!((m__25657__auto__ == null))){
return m__25657__auto__.call(null,this$);
} else {
var m__25657__auto____$1 = (offcourse.protocols.validatable.errors["_"]);
if(!((m__25657__auto____$1 == null))){
return m__25657__auto____$1.call(null,this$);
} else {
throw cljs.core.missing_protocol.call(null,"Validatable.errors",this$);
}
}
}
});

offcourse.protocols.validatable.errors.cljs$core$IFn$_invoke$arity$3 = (function (this$,type,data){
if((!((this$ == null))) && (!((this$.offcourse$protocols$validatable$Validatable$errors$arity$3 == null)))){
return this$.offcourse$protocols$validatable$Validatable$errors$arity$3(this$,type,data);
} else {
var x__25656__auto__ = (((this$ == null))?null:this$);
var m__25657__auto__ = (offcourse.protocols.validatable.errors[goog.typeOf(x__25656__auto__)]);
if(!((m__25657__auto__ == null))){
return m__25657__auto__.call(null,this$,type,data);
} else {
var m__25657__auto____$1 = (offcourse.protocols.validatable.errors["_"]);
if(!((m__25657__auto____$1 == null))){
return m__25657__auto____$1.call(null,this$,type,data);
} else {
throw cljs.core.missing_protocol.call(null,"Validatable.errors",this$);
}
}
}
});

offcourse.protocols.validatable.errors.cljs$lang$maxFixedArity = 3;

offcourse.protocols.validatable.errors_async = (function offcourse$protocols$validatable$errors_async(this$){
if((!((this$ == null))) && (!((this$.offcourse$protocols$validatable$Validatable$errors_async$arity$1 == null)))){
return this$.offcourse$protocols$validatable$Validatable$errors_async$arity$1(this$);
} else {
var x__25656__auto__ = (((this$ == null))?null:this$);
var m__25657__auto__ = (offcourse.protocols.validatable.errors_async[goog.typeOf(x__25656__auto__)]);
if(!((m__25657__auto__ == null))){
return m__25657__auto__.call(null,this$);
} else {
var m__25657__auto____$1 = (offcourse.protocols.validatable.errors_async["_"]);
if(!((m__25657__auto____$1 == null))){
return m__25657__auto____$1.call(null,this$);
} else {
throw cljs.core.missing_protocol.call(null,"Validatable.errors-async",this$);
}
}
}
});

offcourse.protocols.validatable.valid_QMARK_ = (function offcourse$protocols$validatable$valid_QMARK_(this$){
if((!((this$ == null))) && (!((this$.offcourse$protocols$validatable$Validatable$valid_QMARK_$arity$1 == null)))){
return this$.offcourse$protocols$validatable$Validatable$valid_QMARK_$arity$1(this$);
} else {
var x__25656__auto__ = (((this$ == null))?null:this$);
var m__25657__auto__ = (offcourse.protocols.validatable.valid_QMARK_[goog.typeOf(x__25656__auto__)]);
if(!((m__25657__auto__ == null))){
return m__25657__auto__.call(null,this$);
} else {
var m__25657__auto____$1 = (offcourse.protocols.validatable.valid_QMARK_["_"]);
if(!((m__25657__auto____$1 == null))){
return m__25657__auto____$1.call(null,this$);
} else {
throw cljs.core.missing_protocol.call(null,"Validatable.valid?",this$);
}
}
}
});

offcourse.protocols.validatable.valid_QMARK__async = (function offcourse$protocols$validatable$valid_QMARK__async(this$){
if((!((this$ == null))) && (!((this$.offcourse$protocols$validatable$Validatable$valid_QMARK__async$arity$1 == null)))){
return this$.offcourse$protocols$validatable$Validatable$valid_QMARK__async$arity$1(this$);
} else {
var x__25656__auto__ = (((this$ == null))?null:this$);
var m__25657__auto__ = (offcourse.protocols.validatable.valid_QMARK__async[goog.typeOf(x__25656__auto__)]);
if(!((m__25657__auto__ == null))){
return m__25657__auto__.call(null,this$);
} else {
var m__25657__auto____$1 = (offcourse.protocols.validatable.valid_QMARK__async["_"]);
if(!((m__25657__auto____$1 == null))){
return m__25657__auto____$1.call(null,this$);
} else {
throw cljs.core.missing_protocol.call(null,"Validatable.valid?-async",this$);
}
}
}
});

offcourse.protocols.validatable.unknown_field = (function offcourse$protocols$validatable$unknown_field(errors){
return cljs.core.first.call(null,cljs.core.keys.call(null,errors));
});

//# sourceMappingURL=validatable.js.map