// Compiled by ClojureScript 1.7.170 {}
goog.provide('offcourse.helpers.interop');
goog.require('cljs.core');
goog.require('cljs.core.async');
offcourse.helpers.interop.jsx__GT_clj = (function offcourse$helpers$interop$jsx__GT_clj(x){
return cljs.core.into.call(null,cljs.core.PersistentArrayMap.EMPTY,(function (){var iter__25853__auto__ = (function offcourse$helpers$interop$jsx__GT_clj_$_iter__32072(s__32073){
return (new cljs.core.LazySeq(null,(function (){
var s__32073__$1 = s__32073;
while(true){
var temp__4425__auto__ = cljs.core.seq.call(null,s__32073__$1);
if(temp__4425__auto__){
var s__32073__$2 = temp__4425__auto__;
if(cljs.core.chunked_seq_QMARK_.call(null,s__32073__$2)){
var c__25851__auto__ = cljs.core.chunk_first.call(null,s__32073__$2);
var size__25852__auto__ = cljs.core.count.call(null,c__25851__auto__);
var b__32075 = cljs.core.chunk_buffer.call(null,size__25852__auto__);
if((function (){var i__32074 = (0);
while(true){
if((i__32074 < size__25852__auto__)){
var k = cljs.core._nth.call(null,c__25851__auto__,i__32074);
cljs.core.chunk_append.call(null,b__32075,new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.keyword.call(null,k),(x[k])], null));

var G__32076 = (i__32074 + (1));
i__32074 = G__32076;
continue;
} else {
return true;
}
break;
}
})()){
return cljs.core.chunk_cons.call(null,cljs.core.chunk.call(null,b__32075),offcourse$helpers$interop$jsx__GT_clj_$_iter__32072.call(null,cljs.core.chunk_rest.call(null,s__32073__$2)));
} else {
return cljs.core.chunk_cons.call(null,cljs.core.chunk.call(null,b__32075),null);
}
} else {
var k = cljs.core.first.call(null,s__32073__$2);
return cljs.core.cons.call(null,new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.keyword.call(null,k),(x[k])], null),offcourse$helpers$interop$jsx__GT_clj_$_iter__32072.call(null,cljs.core.rest.call(null,s__32073__$2)));
}
} else {
return null;
}
break;
}
}),null,null));
});
return iter__25853__auto__.call(null,Object.keys(x));
})());
});
offcourse.helpers.interop.handle_js = (function offcourse$helpers$interop$handle_js(json){
return cljs.core.js__GT_clj.call(null,json,new cljs.core.Keyword(null,"keywordize-keys","keywordize-keys",1310784252),true);
});
offcourse.helpers.interop.handle_error = (function offcourse$helpers$interop$handle_error(message){
var error = offcourse.helpers.interop.jsx__GT_clj.call(null,message);
return new cljs.core.PersistentArrayMap(null, 1, [new cljs.core.Keyword(null,"error","error",-978969032),[cljs.core.str(message)].join('')], null);
});
offcourse.helpers.interop.handle_promise = (function offcourse$helpers$interop$handle_promise(var_args){
var args32079 = [];
var len__26139__auto___32082 = arguments.length;
var i__26140__auto___32083 = (0);
while(true){
if((i__26140__auto___32083 < len__26139__auto___32082)){
args32079.push((arguments[i__26140__auto___32083]));

var G__32084 = (i__26140__auto___32083 + (1));
i__26140__auto___32083 = G__32084;
continue;
} else {
}
break;
}

var G__32081 = args32079.length;
switch (G__32081) {
case 1:
return offcourse.helpers.interop.handle_promise.cljs$core$IFn$_invoke$arity$1((arguments[(0)]));

break;
case 2:
return offcourse.helpers.interop.handle_promise.cljs$core$IFn$_invoke$arity$2((arguments[(0)]),(arguments[(1)]));

break;
default:
throw (new Error([cljs.core.str("Invalid arity: "),cljs.core.str(args32079.length)].join('')));

}
});

offcourse.helpers.interop.handle_promise.cljs$core$IFn$_invoke$arity$1 = (function (promise){
return offcourse.helpers.interop.handle_promise.call(null,promise,cljs.core.identity);
});

offcourse.helpers.interop.handle_promise.cljs$core$IFn$_invoke$arity$2 = (function (promise,cb){
var channel = cljs.core.async.chan.call(null);
promise.then(((function (channel){
return (function (p1__32077_SHARP_){
return cljs.core.async.put_BANG_.call(null,channel,cb.call(null,p1__32077_SHARP_));
});})(channel))
).catch(((function (channel){
return (function (p1__32078_SHARP_){
return cljs.core.async.put_BANG_.call(null,channel,offcourse.helpers.interop.handle_error.call(null,p1__32078_SHARP_));
});})(channel))
);

return channel;
});

offcourse.helpers.interop.handle_promise.cljs$lang$maxFixedArity = 2;
offcourse.helpers.interop.handle_js_response = (function offcourse$helpers$interop$handle_js_response(var_args){
var args32086 = [];
var len__26139__auto___32089 = arguments.length;
var i__26140__auto___32090 = (0);
while(true){
if((i__26140__auto___32090 < len__26139__auto___32089)){
args32086.push((arguments[i__26140__auto___32090]));

var G__32091 = (i__26140__auto___32090 + (1));
i__26140__auto___32090 = G__32091;
continue;
} else {
}
break;
}

var G__32088 = args32086.length;
switch (G__32088) {
case 1:
return offcourse.helpers.interop.handle_js_response.cljs$core$IFn$_invoke$arity$1((arguments[(0)]));

break;
case 2:
return offcourse.helpers.interop.handle_js_response.cljs$core$IFn$_invoke$arity$2((arguments[(0)]),(arguments[(1)]));

break;
default:
throw (new Error([cljs.core.str("Invalid arity: "),cljs.core.str(args32086.length)].join('')));

}
});

offcourse.helpers.interop.handle_js_response.cljs$core$IFn$_invoke$arity$1 = (function (promise){
return offcourse.helpers.interop.handle_promise.call(null,promise,offcourse.helpers.interop.handle_js);
});

offcourse.helpers.interop.handle_js_response.cljs$core$IFn$_invoke$arity$2 = (function (promise,cb){
return offcourse.helpers.interop.handle_promise.call(null,promise,cljs.core.comp.call(null,cb,offcourse.helpers.interop.handle_js));
});

offcourse.helpers.interop.handle_js_response.cljs$lang$maxFixedArity = 2;

//# sourceMappingURL=interop.js.map