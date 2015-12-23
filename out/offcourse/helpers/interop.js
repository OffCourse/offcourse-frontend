// Compiled by ClojureScript 1.7.170 {}
goog.provide('offcourse.helpers.interop');
goog.require('cljs.core');
goog.require('cljs.core.async');
offcourse.helpers.interop.jsx__GT_clj = (function offcourse$helpers$interop$jsx__GT_clj(x){
return cljs.core.into.call(null,cljs.core.PersistentArrayMap.EMPTY,(function (){var iter__25773__auto__ = (function offcourse$helpers$interop$jsx__GT_clj_$_iter__28982(s__28983){
return (new cljs.core.LazySeq(null,(function (){
var s__28983__$1 = s__28983;
while(true){
var temp__4425__auto__ = cljs.core.seq.call(null,s__28983__$1);
if(temp__4425__auto__){
var s__28983__$2 = temp__4425__auto__;
if(cljs.core.chunked_seq_QMARK_.call(null,s__28983__$2)){
var c__25771__auto__ = cljs.core.chunk_first.call(null,s__28983__$2);
var size__25772__auto__ = cljs.core.count.call(null,c__25771__auto__);
var b__28985 = cljs.core.chunk_buffer.call(null,size__25772__auto__);
if((function (){var i__28984 = (0);
while(true){
if((i__28984 < size__25772__auto__)){
var k = cljs.core._nth.call(null,c__25771__auto__,i__28984);
cljs.core.chunk_append.call(null,b__28985,new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.keyword.call(null,k),(x[k])], null));

var G__28986 = (i__28984 + (1));
i__28984 = G__28986;
continue;
} else {
return true;
}
break;
}
})()){
return cljs.core.chunk_cons.call(null,cljs.core.chunk.call(null,b__28985),offcourse$helpers$interop$jsx__GT_clj_$_iter__28982.call(null,cljs.core.chunk_rest.call(null,s__28983__$2)));
} else {
return cljs.core.chunk_cons.call(null,cljs.core.chunk.call(null,b__28985),null);
}
} else {
var k = cljs.core.first.call(null,s__28983__$2);
return cljs.core.cons.call(null,new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.keyword.call(null,k),(x[k])], null),offcourse$helpers$interop$jsx__GT_clj_$_iter__28982.call(null,cljs.core.rest.call(null,s__28983__$2)));
}
} else {
return null;
}
break;
}
}),null,null));
});
return iter__25773__auto__.call(null,Object.keys(x));
})());
});
offcourse.helpers.interop.handle_error = (function offcourse$helpers$interop$handle_error(message){
var error = offcourse.helpers.interop.jsx__GT_clj.call(null,message);
return new cljs.core.PersistentArrayMap(null, 1, [new cljs.core.Keyword(null,"error","error",-978969032),[cljs.core.str(message)].join('')], null);
});
offcourse.helpers.interop.handle_promise = (function offcourse$helpers$interop$handle_promise(var_args){
var args28989 = [];
var len__26059__auto___28992 = arguments.length;
var i__26060__auto___28993 = (0);
while(true){
if((i__26060__auto___28993 < len__26059__auto___28992)){
args28989.push((arguments[i__26060__auto___28993]));

var G__28994 = (i__26060__auto___28993 + (1));
i__26060__auto___28993 = G__28994;
continue;
} else {
}
break;
}

var G__28991 = args28989.length;
switch (G__28991) {
case 1:
return offcourse.helpers.interop.handle_promise.cljs$core$IFn$_invoke$arity$1((arguments[(0)]));

break;
case 2:
return offcourse.helpers.interop.handle_promise.cljs$core$IFn$_invoke$arity$2((arguments[(0)]),(arguments[(1)]));

break;
default:
throw (new Error([cljs.core.str("Invalid arity: "),cljs.core.str(args28989.length)].join('')));

}
});

offcourse.helpers.interop.handle_promise.cljs$core$IFn$_invoke$arity$1 = (function (promise){
return offcourse.helpers.interop.handle_promise.call(null,promise,cljs.core.identity);
});

offcourse.helpers.interop.handle_promise.cljs$core$IFn$_invoke$arity$2 = (function (promise,cb){
var channel = cljs.core.async.chan.call(null);
promise.then(((function (channel){
return (function (p1__28987_SHARP_){
return cljs.core.async.put_BANG_.call(null,channel,cb.call(null,p1__28987_SHARP_));
});})(channel))
).catch(((function (channel){
return (function (p1__28988_SHARP_){
return cljs.core.async.put_BANG_.call(null,channel,offcourse.helpers.interop.handle_error.call(null,p1__28988_SHARP_));
});})(channel))
);

return channel;
});

offcourse.helpers.interop.handle_promise.cljs$lang$maxFixedArity = 2;
offcourse.helpers.interop.handle_json_response = (function offcourse$helpers$interop$handle_json_response(var_args){
var args28996 = [];
var len__26059__auto___28999 = arguments.length;
var i__26060__auto___29000 = (0);
while(true){
if((i__26060__auto___29000 < len__26059__auto___28999)){
args28996.push((arguments[i__26060__auto___29000]));

var G__29001 = (i__26060__auto___29000 + (1));
i__26060__auto___29000 = G__29001;
continue;
} else {
}
break;
}

var G__28998 = args28996.length;
switch (G__28998) {
case 1:
return offcourse.helpers.interop.handle_json_response.cljs$core$IFn$_invoke$arity$1((arguments[(0)]));

break;
case 2:
return offcourse.helpers.interop.handle_json_response.cljs$core$IFn$_invoke$arity$2((arguments[(0)]),(arguments[(1)]));

break;
default:
throw (new Error([cljs.core.str("Invalid arity: "),cljs.core.str(args28996.length)].join('')));

}
});

offcourse.helpers.interop.handle_json_response.cljs$core$IFn$_invoke$arity$1 = (function (promise){
return offcourse.helpers.interop.handle_promise.call(null,promise,cljs.core.js__GT_clj);
});

offcourse.helpers.interop.handle_json_response.cljs$core$IFn$_invoke$arity$2 = (function (promise,cb){
return offcourse.helpers.interop.handle_promise.call(null,promise,cljs.core.comp.call(null,cb,cljs.core.js__GT_clj));
});

offcourse.helpers.interop.handle_json_response.cljs$lang$maxFixedArity = 2;

//# sourceMappingURL=interop.js.map