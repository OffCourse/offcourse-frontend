// Compiled by ClojureScript 1.7.170 {}
goog.provide('offcourse.helpers.interop');
goog.require('cljs.core');
goog.require('cljs.core.async');
offcourse.helpers.interop.jsx__GT_clj = (function offcourse$helpers$interop$jsx__GT_clj(x){
return cljs.core.into.call(null,cljs.core.PersistentArrayMap.EMPTY,(function (){var iter__25853__auto__ = (function offcourse$helpers$interop$jsx__GT_clj_$_iter__27949(s__27950){
return (new cljs.core.LazySeq(null,(function (){
var s__27950__$1 = s__27950;
while(true){
var temp__4425__auto__ = cljs.core.seq.call(null,s__27950__$1);
if(temp__4425__auto__){
var s__27950__$2 = temp__4425__auto__;
if(cljs.core.chunked_seq_QMARK_.call(null,s__27950__$2)){
var c__25851__auto__ = cljs.core.chunk_first.call(null,s__27950__$2);
var size__25852__auto__ = cljs.core.count.call(null,c__25851__auto__);
var b__27952 = cljs.core.chunk_buffer.call(null,size__25852__auto__);
if((function (){var i__27951 = (0);
while(true){
if((i__27951 < size__25852__auto__)){
var k = cljs.core._nth.call(null,c__25851__auto__,i__27951);
cljs.core.chunk_append.call(null,b__27952,new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.keyword.call(null,k),(x[k])], null));

var G__27953 = (i__27951 + (1));
i__27951 = G__27953;
continue;
} else {
return true;
}
break;
}
})()){
return cljs.core.chunk_cons.call(null,cljs.core.chunk.call(null,b__27952),offcourse$helpers$interop$jsx__GT_clj_$_iter__27949.call(null,cljs.core.chunk_rest.call(null,s__27950__$2)));
} else {
return cljs.core.chunk_cons.call(null,cljs.core.chunk.call(null,b__27952),null);
}
} else {
var k = cljs.core.first.call(null,s__27950__$2);
return cljs.core.cons.call(null,new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.keyword.call(null,k),(x[k])], null),offcourse$helpers$interop$jsx__GT_clj_$_iter__27949.call(null,cljs.core.rest.call(null,s__27950__$2)));
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
var args27956 = [];
var len__26139__auto___27959 = arguments.length;
var i__26140__auto___27960 = (0);
while(true){
if((i__26140__auto___27960 < len__26139__auto___27959)){
args27956.push((arguments[i__26140__auto___27960]));

var G__27961 = (i__26140__auto___27960 + (1));
i__26140__auto___27960 = G__27961;
continue;
} else {
}
break;
}

var G__27958 = args27956.length;
switch (G__27958) {
case 1:
return offcourse.helpers.interop.handle_promise.cljs$core$IFn$_invoke$arity$1((arguments[(0)]));

break;
case 2:
return offcourse.helpers.interop.handle_promise.cljs$core$IFn$_invoke$arity$2((arguments[(0)]),(arguments[(1)]));

break;
default:
throw (new Error([cljs.core.str("Invalid arity: "),cljs.core.str(args27956.length)].join('')));

}
});

offcourse.helpers.interop.handle_promise.cljs$core$IFn$_invoke$arity$1 = (function (promise){
return offcourse.helpers.interop.handle_promise.call(null,promise,cljs.core.identity);
});

offcourse.helpers.interop.handle_promise.cljs$core$IFn$_invoke$arity$2 = (function (promise,cb){
var channel = cljs.core.async.chan.call(null);
promise.then(((function (channel){
return (function (p1__27954_SHARP_){
return cljs.core.async.put_BANG_.call(null,channel,cb.call(null,p1__27954_SHARP_));
});})(channel))
).catch(((function (channel){
return (function (p1__27955_SHARP_){
return cljs.core.async.put_BANG_.call(null,channel,offcourse.helpers.interop.handle_error.call(null,p1__27955_SHARP_));
});})(channel))
);

return channel;
});

offcourse.helpers.interop.handle_promise.cljs$lang$maxFixedArity = 2;
offcourse.helpers.interop.handle_js_response = (function offcourse$helpers$interop$handle_js_response(var_args){
var args27963 = [];
var len__26139__auto___27966 = arguments.length;
var i__26140__auto___27967 = (0);
while(true){
if((i__26140__auto___27967 < len__26139__auto___27966)){
args27963.push((arguments[i__26140__auto___27967]));

var G__27968 = (i__26140__auto___27967 + (1));
i__26140__auto___27967 = G__27968;
continue;
} else {
}
break;
}

var G__27965 = args27963.length;
switch (G__27965) {
case 1:
return offcourse.helpers.interop.handle_js_response.cljs$core$IFn$_invoke$arity$1((arguments[(0)]));

break;
case 2:
return offcourse.helpers.interop.handle_js_response.cljs$core$IFn$_invoke$arity$2((arguments[(0)]),(arguments[(1)]));

break;
default:
throw (new Error([cljs.core.str("Invalid arity: "),cljs.core.str(args27963.length)].join('')));

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