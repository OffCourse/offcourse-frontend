// Compiled by ClojureScript 1.7.170 {}
goog.provide('cljs.core.async');
goog.require('cljs.core');
goog.require('cljs.core.async.impl.channels');
goog.require('cljs.core.async.impl.dispatch');
goog.require('cljs.core.async.impl.ioc_helpers');
goog.require('cljs.core.async.impl.protocols');
goog.require('cljs.core.async.impl.buffers');
goog.require('cljs.core.async.impl.timers');
cljs.core.async.fn_handler = (function cljs$core$async$fn_handler(var_args){
var args29865 = [];
var len__25999__auto___29871 = arguments.length;
var i__26000__auto___29872 = (0);
while(true){
if((i__26000__auto___29872 < len__25999__auto___29871)){
args29865.push((arguments[i__26000__auto___29872]));

var G__29873 = (i__26000__auto___29872 + (1));
i__26000__auto___29872 = G__29873;
continue;
} else {
}
break;
}

var G__29867 = args29865.length;
switch (G__29867) {
case 1:
return cljs.core.async.fn_handler.cljs$core$IFn$_invoke$arity$1((arguments[(0)]));

break;
case 2:
return cljs.core.async.fn_handler.cljs$core$IFn$_invoke$arity$2((arguments[(0)]),(arguments[(1)]));

break;
default:
throw (new Error([cljs.core.str("Invalid arity: "),cljs.core.str(args29865.length)].join('')));

}
});

cljs.core.async.fn_handler.cljs$core$IFn$_invoke$arity$1 = (function (f){
return cljs.core.async.fn_handler.call(null,f,true);
});

cljs.core.async.fn_handler.cljs$core$IFn$_invoke$arity$2 = (function (f,blockable){
if(typeof cljs.core.async.t_cljs$core$async29868 !== 'undefined'){
} else {

/**
* @constructor
 * @implements {cljs.core.async.impl.protocols.Handler}
 * @implements {cljs.core.IMeta}
 * @implements {cljs.core.IWithMeta}
*/
cljs.core.async.t_cljs$core$async29868 = (function (f,blockable,meta29869){
this.f = f;
this.blockable = blockable;
this.meta29869 = meta29869;
this.cljs$lang$protocol_mask$partition0$ = 393216;
this.cljs$lang$protocol_mask$partition1$ = 0;
})
cljs.core.async.t_cljs$core$async29868.prototype.cljs$core$IWithMeta$_with_meta$arity$2 = (function (_29870,meta29869__$1){
var self__ = this;
var _29870__$1 = this;
return (new cljs.core.async.t_cljs$core$async29868(self__.f,self__.blockable,meta29869__$1));
});

cljs.core.async.t_cljs$core$async29868.prototype.cljs$core$IMeta$_meta$arity$1 = (function (_29870){
var self__ = this;
var _29870__$1 = this;
return self__.meta29869;
});

cljs.core.async.t_cljs$core$async29868.prototype.cljs$core$async$impl$protocols$Handler$ = true;

cljs.core.async.t_cljs$core$async29868.prototype.cljs$core$async$impl$protocols$Handler$active_QMARK_$arity$1 = (function (_){
var self__ = this;
var ___$1 = this;
return true;
});

cljs.core.async.t_cljs$core$async29868.prototype.cljs$core$async$impl$protocols$Handler$blockable_QMARK_$arity$1 = (function (_){
var self__ = this;
var ___$1 = this;
return self__.blockable;
});

cljs.core.async.t_cljs$core$async29868.prototype.cljs$core$async$impl$protocols$Handler$commit$arity$1 = (function (_){
var self__ = this;
var ___$1 = this;
return self__.f;
});

cljs.core.async.t_cljs$core$async29868.getBasis = (function (){
return new cljs.core.PersistentVector(null, 3, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Symbol(null,"f","f",43394975,null),new cljs.core.Symbol(null,"blockable","blockable",-28395259,null),new cljs.core.Symbol(null,"meta29869","meta29869",895824467,null)], null);
});

cljs.core.async.t_cljs$core$async29868.cljs$lang$type = true;

cljs.core.async.t_cljs$core$async29868.cljs$lang$ctorStr = "cljs.core.async/t_cljs$core$async29868";

cljs.core.async.t_cljs$core$async29868.cljs$lang$ctorPrWriter = (function (this__25539__auto__,writer__25540__auto__,opt__25541__auto__){
return cljs.core._write.call(null,writer__25540__auto__,"cljs.core.async/t_cljs$core$async29868");
});

cljs.core.async.__GT_t_cljs$core$async29868 = (function cljs$core$async$__GT_t_cljs$core$async29868(f__$1,blockable__$1,meta29869){
return (new cljs.core.async.t_cljs$core$async29868(f__$1,blockable__$1,meta29869));
});

}

return (new cljs.core.async.t_cljs$core$async29868(f,blockable,cljs.core.PersistentArrayMap.EMPTY));
});

cljs.core.async.fn_handler.cljs$lang$maxFixedArity = 2;
/**
 * Returns a fixed buffer of size n. When full, puts will block/park.
 */
cljs.core.async.buffer = (function cljs$core$async$buffer(n){
return cljs.core.async.impl.buffers.fixed_buffer.call(null,n);
});
/**
 * Returns a buffer of size n. When full, puts will complete but
 *   val will be dropped (no transfer).
 */
cljs.core.async.dropping_buffer = (function cljs$core$async$dropping_buffer(n){
return cljs.core.async.impl.buffers.dropping_buffer.call(null,n);
});
/**
 * Returns a buffer of size n. When full, puts will complete, and be
 *   buffered, but oldest elements in buffer will be dropped (not
 *   transferred).
 */
cljs.core.async.sliding_buffer = (function cljs$core$async$sliding_buffer(n){
return cljs.core.async.impl.buffers.sliding_buffer.call(null,n);
});
/**
 * Returns true if a channel created with buff will never block. That is to say,
 * puts into this buffer will never cause the buffer to be full. 
 */
cljs.core.async.unblocking_buffer_QMARK_ = (function cljs$core$async$unblocking_buffer_QMARK_(buff){
if(!((buff == null))){
if((false) || (buff.cljs$core$async$impl$protocols$UnblockingBuffer$)){
return true;
} else {
if((!buff.cljs$lang$protocol_mask$partition$)){
return cljs.core.native_satisfies_QMARK_.call(null,cljs.core.async.impl.protocols.UnblockingBuffer,buff);
} else {
return false;
}
}
} else {
return cljs.core.native_satisfies_QMARK_.call(null,cljs.core.async.impl.protocols.UnblockingBuffer,buff);
}
});
/**
 * Creates a channel with an optional buffer, an optional transducer (like (map f),
 *   (filter p) etc or a composition thereof), and an optional exception handler.
 *   If buf-or-n is a number, will create and use a fixed buffer of that size. If a
 *   transducer is supplied a buffer must be specified. ex-handler must be a
 *   fn of one argument - if an exception occurs during transformation it will be called
 *   with the thrown value as an argument, and any non-nil return value will be placed
 *   in the channel.
 */
cljs.core.async.chan = (function cljs$core$async$chan(var_args){
var args29877 = [];
var len__25999__auto___29880 = arguments.length;
var i__26000__auto___29881 = (0);
while(true){
if((i__26000__auto___29881 < len__25999__auto___29880)){
args29877.push((arguments[i__26000__auto___29881]));

var G__29882 = (i__26000__auto___29881 + (1));
i__26000__auto___29881 = G__29882;
continue;
} else {
}
break;
}

var G__29879 = args29877.length;
switch (G__29879) {
case 0:
return cljs.core.async.chan.cljs$core$IFn$_invoke$arity$0();

break;
case 1:
return cljs.core.async.chan.cljs$core$IFn$_invoke$arity$1((arguments[(0)]));

break;
case 2:
return cljs.core.async.chan.cljs$core$IFn$_invoke$arity$2((arguments[(0)]),(arguments[(1)]));

break;
case 3:
return cljs.core.async.chan.cljs$core$IFn$_invoke$arity$3((arguments[(0)]),(arguments[(1)]),(arguments[(2)]));

break;
default:
throw (new Error([cljs.core.str("Invalid arity: "),cljs.core.str(args29877.length)].join('')));

}
});

cljs.core.async.chan.cljs$core$IFn$_invoke$arity$0 = (function (){
return cljs.core.async.chan.call(null,null);
});

cljs.core.async.chan.cljs$core$IFn$_invoke$arity$1 = (function (buf_or_n){
return cljs.core.async.chan.call(null,buf_or_n,null,null);
});

cljs.core.async.chan.cljs$core$IFn$_invoke$arity$2 = (function (buf_or_n,xform){
return cljs.core.async.chan.call(null,buf_or_n,xform,null);
});

cljs.core.async.chan.cljs$core$IFn$_invoke$arity$3 = (function (buf_or_n,xform,ex_handler){
var buf_or_n__$1 = ((cljs.core._EQ_.call(null,buf_or_n,(0)))?null:buf_or_n);
if(cljs.core.truth_(xform)){
if(cljs.core.truth_(buf_or_n__$1)){
} else {
throw (new Error([cljs.core.str("Assert failed: "),cljs.core.str("buffer must be supplied when transducer is"),cljs.core.str("\n"),cljs.core.str(cljs.core.pr_str.call(null,new cljs.core.Symbol(null,"buf-or-n","buf-or-n",-1646815050,null)))].join('')));
}
} else {
}

return cljs.core.async.impl.channels.chan.call(null,((typeof buf_or_n__$1 === 'number')?cljs.core.async.buffer.call(null,buf_or_n__$1):buf_or_n__$1),xform,ex_handler);
});

cljs.core.async.chan.cljs$lang$maxFixedArity = 3;
/**
 * Creates a promise channel with an optional transducer, and an optional
 *   exception-handler. A promise channel can take exactly one value that consumers
 *   will receive. Once full, puts complete but val is dropped (no transfer).
 *   Consumers will block until either a value is placed in the channel or the
 *   channel is closed. See chan for the semantics of xform and ex-handler.
 */
cljs.core.async.promise_chan = (function cljs$core$async$promise_chan(var_args){
var args29884 = [];
var len__25999__auto___29887 = arguments.length;
var i__26000__auto___29888 = (0);
while(true){
if((i__26000__auto___29888 < len__25999__auto___29887)){
args29884.push((arguments[i__26000__auto___29888]));

var G__29889 = (i__26000__auto___29888 + (1));
i__26000__auto___29888 = G__29889;
continue;
} else {
}
break;
}

var G__29886 = args29884.length;
switch (G__29886) {
case 0:
return cljs.core.async.promise_chan.cljs$core$IFn$_invoke$arity$0();

break;
case 1:
return cljs.core.async.promise_chan.cljs$core$IFn$_invoke$arity$1((arguments[(0)]));

break;
case 2:
return cljs.core.async.promise_chan.cljs$core$IFn$_invoke$arity$2((arguments[(0)]),(arguments[(1)]));

break;
default:
throw (new Error([cljs.core.str("Invalid arity: "),cljs.core.str(args29884.length)].join('')));

}
});

cljs.core.async.promise_chan.cljs$core$IFn$_invoke$arity$0 = (function (){
return cljs.core.async.promise_chan.call(null,null);
});

cljs.core.async.promise_chan.cljs$core$IFn$_invoke$arity$1 = (function (xform){
return cljs.core.async.promise_chan.call(null,xform,null);
});

cljs.core.async.promise_chan.cljs$core$IFn$_invoke$arity$2 = (function (xform,ex_handler){
return cljs.core.async.chan.call(null,cljs.core.async.impl.buffers.promise_buffer.call(null),xform,ex_handler);
});

cljs.core.async.promise_chan.cljs$lang$maxFixedArity = 2;
/**
 * Returns a channel that will close after msecs
 */
cljs.core.async.timeout = (function cljs$core$async$timeout(msecs){
return cljs.core.async.impl.timers.timeout.call(null,msecs);
});
/**
 * takes a val from port. Must be called inside a (go ...) block. Will
 *   return nil if closed. Will park if nothing is available.
 *   Returns true unless port is already closed
 */
cljs.core.async._LT__BANG_ = (function cljs$core$async$_LT__BANG_(port){
throw (new Error("<! used not in (go ...) block"));
});
/**
 * Asynchronously takes a val from port, passing to fn1. Will pass nil
 * if closed. If on-caller? (default true) is true, and value is
 * immediately available, will call fn1 on calling thread.
 * Returns nil.
 */
cljs.core.async.take_BANG_ = (function cljs$core$async$take_BANG_(var_args){
var args29891 = [];
var len__25999__auto___29894 = arguments.length;
var i__26000__auto___29895 = (0);
while(true){
if((i__26000__auto___29895 < len__25999__auto___29894)){
args29891.push((arguments[i__26000__auto___29895]));

var G__29896 = (i__26000__auto___29895 + (1));
i__26000__auto___29895 = G__29896;
continue;
} else {
}
break;
}

var G__29893 = args29891.length;
switch (G__29893) {
case 2:
return cljs.core.async.take_BANG_.cljs$core$IFn$_invoke$arity$2((arguments[(0)]),(arguments[(1)]));

break;
case 3:
return cljs.core.async.take_BANG_.cljs$core$IFn$_invoke$arity$3((arguments[(0)]),(arguments[(1)]),(arguments[(2)]));

break;
default:
throw (new Error([cljs.core.str("Invalid arity: "),cljs.core.str(args29891.length)].join('')));

}
});

cljs.core.async.take_BANG_.cljs$core$IFn$_invoke$arity$2 = (function (port,fn1){
return cljs.core.async.take_BANG_.call(null,port,fn1,true);
});

cljs.core.async.take_BANG_.cljs$core$IFn$_invoke$arity$3 = (function (port,fn1,on_caller_QMARK_){
var ret = cljs.core.async.impl.protocols.take_BANG_.call(null,port,cljs.core.async.fn_handler.call(null,fn1));
if(cljs.core.truth_(ret)){
var val_29898 = cljs.core.deref.call(null,ret);
if(cljs.core.truth_(on_caller_QMARK_)){
fn1.call(null,val_29898);
} else {
cljs.core.async.impl.dispatch.run.call(null,((function (val_29898,ret){
return (function (){
return fn1.call(null,val_29898);
});})(val_29898,ret))
);
}
} else {
}

return null;
});

cljs.core.async.take_BANG_.cljs$lang$maxFixedArity = 3;
cljs.core.async.nop = (function cljs$core$async$nop(_){
return null;
});
cljs.core.async.fhnop = cljs.core.async.fn_handler.call(null,cljs.core.async.nop);
/**
 * puts a val into port. nil values are not allowed. Must be called
 *   inside a (go ...) block. Will park if no buffer space is available.
 *   Returns true unless port is already closed.
 */
cljs.core.async._GT__BANG_ = (function cljs$core$async$_GT__BANG_(port,val){
throw (new Error(">! used not in (go ...) block"));
});
/**
 * Asynchronously puts a val into port, calling fn0 (if supplied) when
 * complete. nil values are not allowed. Will throw if closed. If
 * on-caller? (default true) is true, and the put is immediately
 * accepted, will call fn0 on calling thread.  Returns nil.
 */
cljs.core.async.put_BANG_ = (function cljs$core$async$put_BANG_(var_args){
var args29899 = [];
var len__25999__auto___29902 = arguments.length;
var i__26000__auto___29903 = (0);
while(true){
if((i__26000__auto___29903 < len__25999__auto___29902)){
args29899.push((arguments[i__26000__auto___29903]));

var G__29904 = (i__26000__auto___29903 + (1));
i__26000__auto___29903 = G__29904;
continue;
} else {
}
break;
}

var G__29901 = args29899.length;
switch (G__29901) {
case 2:
return cljs.core.async.put_BANG_.cljs$core$IFn$_invoke$arity$2((arguments[(0)]),(arguments[(1)]));

break;
case 3:
return cljs.core.async.put_BANG_.cljs$core$IFn$_invoke$arity$3((arguments[(0)]),(arguments[(1)]),(arguments[(2)]));

break;
case 4:
return cljs.core.async.put_BANG_.cljs$core$IFn$_invoke$arity$4((arguments[(0)]),(arguments[(1)]),(arguments[(2)]),(arguments[(3)]));

break;
default:
throw (new Error([cljs.core.str("Invalid arity: "),cljs.core.str(args29899.length)].join('')));

}
});

cljs.core.async.put_BANG_.cljs$core$IFn$_invoke$arity$2 = (function (port,val){
var temp__4423__auto__ = cljs.core.async.impl.protocols.put_BANG_.call(null,port,val,cljs.core.async.fhnop);
if(cljs.core.truth_(temp__4423__auto__)){
var ret = temp__4423__auto__;
return cljs.core.deref.call(null,ret);
} else {
return true;
}
});

cljs.core.async.put_BANG_.cljs$core$IFn$_invoke$arity$3 = (function (port,val,fn1){
return cljs.core.async.put_BANG_.call(null,port,val,fn1,true);
});

cljs.core.async.put_BANG_.cljs$core$IFn$_invoke$arity$4 = (function (port,val,fn1,on_caller_QMARK_){
var temp__4423__auto__ = cljs.core.async.impl.protocols.put_BANG_.call(null,port,val,cljs.core.async.fn_handler.call(null,fn1));
if(cljs.core.truth_(temp__4423__auto__)){
var retb = temp__4423__auto__;
var ret = cljs.core.deref.call(null,retb);
if(cljs.core.truth_(on_caller_QMARK_)){
fn1.call(null,ret);
} else {
cljs.core.async.impl.dispatch.run.call(null,((function (ret,retb,temp__4423__auto__){
return (function (){
return fn1.call(null,ret);
});})(ret,retb,temp__4423__auto__))
);
}

return ret;
} else {
return true;
}
});

cljs.core.async.put_BANG_.cljs$lang$maxFixedArity = 4;
cljs.core.async.close_BANG_ = (function cljs$core$async$close_BANG_(port){
return cljs.core.async.impl.protocols.close_BANG_.call(null,port);
});
cljs.core.async.random_array = (function cljs$core$async$random_array(n){
var a = (new Array(n));
var n__25844__auto___29906 = n;
var x_29907 = (0);
while(true){
if((x_29907 < n__25844__auto___29906)){
(a[x_29907] = (0));

var G__29908 = (x_29907 + (1));
x_29907 = G__29908;
continue;
} else {
}
break;
}

var i = (1);
while(true){
if(cljs.core._EQ_.call(null,i,n)){
return a;
} else {
var j = cljs.core.rand_int.call(null,i);
(a[i] = (a[j]));

(a[j] = i);

var G__29909 = (i + (1));
i = G__29909;
continue;
}
break;
}
});
cljs.core.async.alt_flag = (function cljs$core$async$alt_flag(){
var flag = cljs.core.atom.call(null,true);
if(typeof cljs.core.async.t_cljs$core$async29913 !== 'undefined'){
} else {

/**
* @constructor
 * @implements {cljs.core.async.impl.protocols.Handler}
 * @implements {cljs.core.IMeta}
 * @implements {cljs.core.IWithMeta}
*/
cljs.core.async.t_cljs$core$async29913 = (function (alt_flag,flag,meta29914){
this.alt_flag = alt_flag;
this.flag = flag;
this.meta29914 = meta29914;
this.cljs$lang$protocol_mask$partition0$ = 393216;
this.cljs$lang$protocol_mask$partition1$ = 0;
})
cljs.core.async.t_cljs$core$async29913.prototype.cljs$core$IWithMeta$_with_meta$arity$2 = ((function (flag){
return (function (_29915,meta29914__$1){
var self__ = this;
var _29915__$1 = this;
return (new cljs.core.async.t_cljs$core$async29913(self__.alt_flag,self__.flag,meta29914__$1));
});})(flag))
;

cljs.core.async.t_cljs$core$async29913.prototype.cljs$core$IMeta$_meta$arity$1 = ((function (flag){
return (function (_29915){
var self__ = this;
var _29915__$1 = this;
return self__.meta29914;
});})(flag))
;

cljs.core.async.t_cljs$core$async29913.prototype.cljs$core$async$impl$protocols$Handler$ = true;

cljs.core.async.t_cljs$core$async29913.prototype.cljs$core$async$impl$protocols$Handler$active_QMARK_$arity$1 = ((function (flag){
return (function (_){
var self__ = this;
var ___$1 = this;
return cljs.core.deref.call(null,self__.flag);
});})(flag))
;

cljs.core.async.t_cljs$core$async29913.prototype.cljs$core$async$impl$protocols$Handler$blockable_QMARK_$arity$1 = ((function (flag){
return (function (_){
var self__ = this;
var ___$1 = this;
return true;
});})(flag))
;

cljs.core.async.t_cljs$core$async29913.prototype.cljs$core$async$impl$protocols$Handler$commit$arity$1 = ((function (flag){
return (function (_){
var self__ = this;
var ___$1 = this;
cljs.core.reset_BANG_.call(null,self__.flag,null);

return true;
});})(flag))
;

cljs.core.async.t_cljs$core$async29913.getBasis = ((function (flag){
return (function (){
return new cljs.core.PersistentVector(null, 3, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.with_meta(new cljs.core.Symbol(null,"alt-flag","alt-flag",-1794972754,null),new cljs.core.PersistentArrayMap(null, 2, [new cljs.core.Keyword(null,"private","private",-558947994),true,new cljs.core.Keyword(null,"arglists","arglists",1661989754),cljs.core.list(new cljs.core.Symbol(null,"quote","quote",1377916282,null),cljs.core.list(cljs.core.PersistentVector.EMPTY))], null)),new cljs.core.Symbol(null,"flag","flag",-1565787888,null),new cljs.core.Symbol(null,"meta29914","meta29914",545747089,null)], null);
});})(flag))
;

cljs.core.async.t_cljs$core$async29913.cljs$lang$type = true;

cljs.core.async.t_cljs$core$async29913.cljs$lang$ctorStr = "cljs.core.async/t_cljs$core$async29913";

cljs.core.async.t_cljs$core$async29913.cljs$lang$ctorPrWriter = ((function (flag){
return (function (this__25539__auto__,writer__25540__auto__,opt__25541__auto__){
return cljs.core._write.call(null,writer__25540__auto__,"cljs.core.async/t_cljs$core$async29913");
});})(flag))
;

cljs.core.async.__GT_t_cljs$core$async29913 = ((function (flag){
return (function cljs$core$async$alt_flag_$___GT_t_cljs$core$async29913(alt_flag__$1,flag__$1,meta29914){
return (new cljs.core.async.t_cljs$core$async29913(alt_flag__$1,flag__$1,meta29914));
});})(flag))
;

}

return (new cljs.core.async.t_cljs$core$async29913(cljs$core$async$alt_flag,flag,cljs.core.PersistentArrayMap.EMPTY));
});
cljs.core.async.alt_handler = (function cljs$core$async$alt_handler(flag,cb){
if(typeof cljs.core.async.t_cljs$core$async29919 !== 'undefined'){
} else {

/**
* @constructor
 * @implements {cljs.core.async.impl.protocols.Handler}
 * @implements {cljs.core.IMeta}
 * @implements {cljs.core.IWithMeta}
*/
cljs.core.async.t_cljs$core$async29919 = (function (alt_handler,flag,cb,meta29920){
this.alt_handler = alt_handler;
this.flag = flag;
this.cb = cb;
this.meta29920 = meta29920;
this.cljs$lang$protocol_mask$partition0$ = 393216;
this.cljs$lang$protocol_mask$partition1$ = 0;
})
cljs.core.async.t_cljs$core$async29919.prototype.cljs$core$IWithMeta$_with_meta$arity$2 = (function (_29921,meta29920__$1){
var self__ = this;
var _29921__$1 = this;
return (new cljs.core.async.t_cljs$core$async29919(self__.alt_handler,self__.flag,self__.cb,meta29920__$1));
});

cljs.core.async.t_cljs$core$async29919.prototype.cljs$core$IMeta$_meta$arity$1 = (function (_29921){
var self__ = this;
var _29921__$1 = this;
return self__.meta29920;
});

cljs.core.async.t_cljs$core$async29919.prototype.cljs$core$async$impl$protocols$Handler$ = true;

cljs.core.async.t_cljs$core$async29919.prototype.cljs$core$async$impl$protocols$Handler$active_QMARK_$arity$1 = (function (_){
var self__ = this;
var ___$1 = this;
return cljs.core.async.impl.protocols.active_QMARK_.call(null,self__.flag);
});

cljs.core.async.t_cljs$core$async29919.prototype.cljs$core$async$impl$protocols$Handler$blockable_QMARK_$arity$1 = (function (_){
var self__ = this;
var ___$1 = this;
return true;
});

cljs.core.async.t_cljs$core$async29919.prototype.cljs$core$async$impl$protocols$Handler$commit$arity$1 = (function (_){
var self__ = this;
var ___$1 = this;
cljs.core.async.impl.protocols.commit.call(null,self__.flag);

return self__.cb;
});

cljs.core.async.t_cljs$core$async29919.getBasis = (function (){
return new cljs.core.PersistentVector(null, 4, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.with_meta(new cljs.core.Symbol(null,"alt-handler","alt-handler",963786170,null),new cljs.core.PersistentArrayMap(null, 2, [new cljs.core.Keyword(null,"private","private",-558947994),true,new cljs.core.Keyword(null,"arglists","arglists",1661989754),cljs.core.list(new cljs.core.Symbol(null,"quote","quote",1377916282,null),cljs.core.list(new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Symbol(null,"flag","flag",-1565787888,null),new cljs.core.Symbol(null,"cb","cb",-2064487928,null)], null)))], null)),new cljs.core.Symbol(null,"flag","flag",-1565787888,null),new cljs.core.Symbol(null,"cb","cb",-2064487928,null),new cljs.core.Symbol(null,"meta29920","meta29920",-937240065,null)], null);
});

cljs.core.async.t_cljs$core$async29919.cljs$lang$type = true;

cljs.core.async.t_cljs$core$async29919.cljs$lang$ctorStr = "cljs.core.async/t_cljs$core$async29919";

cljs.core.async.t_cljs$core$async29919.cljs$lang$ctorPrWriter = (function (this__25539__auto__,writer__25540__auto__,opt__25541__auto__){
return cljs.core._write.call(null,writer__25540__auto__,"cljs.core.async/t_cljs$core$async29919");
});

cljs.core.async.__GT_t_cljs$core$async29919 = (function cljs$core$async$alt_handler_$___GT_t_cljs$core$async29919(alt_handler__$1,flag__$1,cb__$1,meta29920){
return (new cljs.core.async.t_cljs$core$async29919(alt_handler__$1,flag__$1,cb__$1,meta29920));
});

}

return (new cljs.core.async.t_cljs$core$async29919(cljs$core$async$alt_handler,flag,cb,cljs.core.PersistentArrayMap.EMPTY));
});
/**
 * returns derefable [val port] if immediate, nil if enqueued
 */
cljs.core.async.do_alts = (function cljs$core$async$do_alts(fret,ports,opts){
var flag = cljs.core.async.alt_flag.call(null);
var n = cljs.core.count.call(null,ports);
var idxs = cljs.core.async.random_array.call(null,n);
var priority = new cljs.core.Keyword(null,"priority","priority",1431093715).cljs$core$IFn$_invoke$arity$1(opts);
var ret = (function (){var i = (0);
while(true){
if((i < n)){
var idx = (cljs.core.truth_(priority)?i:(idxs[i]));
var port = cljs.core.nth.call(null,ports,idx);
var wport = ((cljs.core.vector_QMARK_.call(null,port))?port.call(null,(0)):null);
var vbox = (cljs.core.truth_(wport)?(function (){var val = port.call(null,(1));
return cljs.core.async.impl.protocols.put_BANG_.call(null,wport,val,cljs.core.async.alt_handler.call(null,flag,((function (i,val,idx,port,wport,flag,n,idxs,priority){
return (function (p1__29922_SHARP_){
return fret.call(null,new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [p1__29922_SHARP_,wport], null));
});})(i,val,idx,port,wport,flag,n,idxs,priority))
));
})():cljs.core.async.impl.protocols.take_BANG_.call(null,port,cljs.core.async.alt_handler.call(null,flag,((function (i,idx,port,wport,flag,n,idxs,priority){
return (function (p1__29923_SHARP_){
return fret.call(null,new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [p1__29923_SHARP_,port], null));
});})(i,idx,port,wport,flag,n,idxs,priority))
)));
if(cljs.core.truth_(vbox)){
return cljs.core.async.impl.channels.box.call(null,new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.deref.call(null,vbox),(function (){var or__24941__auto__ = wport;
if(cljs.core.truth_(or__24941__auto__)){
return or__24941__auto__;
} else {
return port;
}
})()], null));
} else {
var G__29924 = (i + (1));
i = G__29924;
continue;
}
} else {
return null;
}
break;
}
})();
var or__24941__auto__ = ret;
if(cljs.core.truth_(or__24941__auto__)){
return or__24941__auto__;
} else {
if(cljs.core.contains_QMARK_.call(null,opts,new cljs.core.Keyword(null,"default","default",-1987822328))){
var temp__4425__auto__ = (function (){var and__24929__auto__ = cljs.core.async.impl.protocols.active_QMARK_.call(null,flag);
if(cljs.core.truth_(and__24929__auto__)){
return cljs.core.async.impl.protocols.commit.call(null,flag);
} else {
return and__24929__auto__;
}
})();
if(cljs.core.truth_(temp__4425__auto__)){
var got = temp__4425__auto__;
return cljs.core.async.impl.channels.box.call(null,new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Keyword(null,"default","default",-1987822328).cljs$core$IFn$_invoke$arity$1(opts),new cljs.core.Keyword(null,"default","default",-1987822328)], null));
} else {
return null;
}
} else {
return null;
}
}
});
/**
 * Completes at most one of several channel operations. Must be called
 * inside a (go ...) block. ports is a vector of channel endpoints,
 * which can be either a channel to take from or a vector of
 *   [channel-to-put-to val-to-put], in any combination. Takes will be
 *   made as if by <!, and puts will be made as if by >!. Unless
 *   the :priority option is true, if more than one port operation is
 *   ready a non-deterministic choice will be made. If no operation is
 *   ready and a :default value is supplied, [default-val :default] will
 *   be returned, otherwise alts! will park until the first operation to
 *   become ready completes. Returns [val port] of the completed
 *   operation, where val is the value taken for takes, and a
 *   boolean (true unless already closed, as per put!) for puts.
 * 
 *   opts are passed as :key val ... Supported options:
 * 
 *   :default val - the value to use if none of the operations are immediately ready
 *   :priority true - (default nil) when true, the operations will be tried in order.
 * 
 *   Note: there is no guarantee that the port exps or val exprs will be
 *   used, nor in what order should they be, so they should not be
 *   depended upon for side effects.
 */
cljs.core.async.alts_BANG_ = (function cljs$core$async$alts_BANG_(var_args){
var args__26006__auto__ = [];
var len__25999__auto___29930 = arguments.length;
var i__26000__auto___29931 = (0);
while(true){
if((i__26000__auto___29931 < len__25999__auto___29930)){
args__26006__auto__.push((arguments[i__26000__auto___29931]));

var G__29932 = (i__26000__auto___29931 + (1));
i__26000__auto___29931 = G__29932;
continue;
} else {
}
break;
}

var argseq__26007__auto__ = ((((1) < args__26006__auto__.length))?(new cljs.core.IndexedSeq(args__26006__auto__.slice((1)),(0))):null);
return cljs.core.async.alts_BANG_.cljs$core$IFn$_invoke$arity$variadic((arguments[(0)]),argseq__26007__auto__);
});

cljs.core.async.alts_BANG_.cljs$core$IFn$_invoke$arity$variadic = (function (ports,p__29927){
var map__29928 = p__29927;
var map__29928__$1 = ((((!((map__29928 == null)))?((((map__29928.cljs$lang$protocol_mask$partition0$ & (64))) || (map__29928.cljs$core$ISeq$))?true:false):false))?cljs.core.apply.call(null,cljs.core.hash_map,map__29928):map__29928);
var opts = map__29928__$1;
throw (new Error("alts! used not in (go ...) block"));
});

cljs.core.async.alts_BANG_.cljs$lang$maxFixedArity = (1);

cljs.core.async.alts_BANG_.cljs$lang$applyTo = (function (seq29925){
var G__29926 = cljs.core.first.call(null,seq29925);
var seq29925__$1 = cljs.core.next.call(null,seq29925);
return cljs.core.async.alts_BANG_.cljs$core$IFn$_invoke$arity$variadic(G__29926,seq29925__$1);
});
/**
 * Puts a val into port if it's possible to do so immediately.
 *   nil values are not allowed. Never blocks. Returns true if offer succeeds.
 */
cljs.core.async.offer_BANG_ = (function cljs$core$async$offer_BANG_(port,val){
var ret = cljs.core.async.impl.protocols.put_BANG_.call(null,port,val,cljs.core.async.fn_handler.call(null,cljs.core.async.nop,false));
if(cljs.core.truth_(ret)){
return cljs.core.deref.call(null,ret);
} else {
return null;
}
});
/**
 * Takes a val from port if it's possible to do so immediately.
 *   Never blocks. Returns value if successful, nil otherwise.
 */
cljs.core.async.poll_BANG_ = (function cljs$core$async$poll_BANG_(port){
var ret = cljs.core.async.impl.protocols.take_BANG_.call(null,port,cljs.core.async.fn_handler.call(null,cljs.core.async.nop,false));
if(cljs.core.truth_(ret)){
return cljs.core.deref.call(null,ret);
} else {
return null;
}
});
/**
 * Takes elements from the from channel and supplies them to the to
 * channel. By default, the to channel will be closed when the from
 * channel closes, but can be determined by the close?  parameter. Will
 * stop consuming the from channel if the to channel closes
 */
cljs.core.async.pipe = (function cljs$core$async$pipe(var_args){
var args29933 = [];
var len__25999__auto___29983 = arguments.length;
var i__26000__auto___29984 = (0);
while(true){
if((i__26000__auto___29984 < len__25999__auto___29983)){
args29933.push((arguments[i__26000__auto___29984]));

var G__29985 = (i__26000__auto___29984 + (1));
i__26000__auto___29984 = G__29985;
continue;
} else {
}
break;
}

var G__29935 = args29933.length;
switch (G__29935) {
case 2:
return cljs.core.async.pipe.cljs$core$IFn$_invoke$arity$2((arguments[(0)]),(arguments[(1)]));

break;
case 3:
return cljs.core.async.pipe.cljs$core$IFn$_invoke$arity$3((arguments[(0)]),(arguments[(1)]),(arguments[(2)]));

break;
default:
throw (new Error([cljs.core.str("Invalid arity: "),cljs.core.str(args29933.length)].join('')));

}
});

cljs.core.async.pipe.cljs$core$IFn$_invoke$arity$2 = (function (from,to){
return cljs.core.async.pipe.call(null,from,to,true);
});

cljs.core.async.pipe.cljs$core$IFn$_invoke$arity$3 = (function (from,to,close_QMARK_){
var c__27451__auto___29987 = cljs.core.async.chan.call(null,(1));
cljs.core.async.impl.dispatch.run.call(null,((function (c__27451__auto___29987){
return (function (){
var f__27452__auto__ = (function (){var switch__27386__auto__ = ((function (c__27451__auto___29987){
return (function (state_29959){
var state_val_29960 = (state_29959[(1)]);
if((state_val_29960 === (7))){
var inst_29955 = (state_29959[(2)]);
var state_29959__$1 = state_29959;
var statearr_29961_29988 = state_29959__$1;
(statearr_29961_29988[(2)] = inst_29955);

(statearr_29961_29988[(1)] = (3));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_29960 === (1))){
var state_29959__$1 = state_29959;
var statearr_29962_29989 = state_29959__$1;
(statearr_29962_29989[(2)] = null);

(statearr_29962_29989[(1)] = (2));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_29960 === (4))){
var inst_29938 = (state_29959[(7)]);
var inst_29938__$1 = (state_29959[(2)]);
var inst_29939 = (inst_29938__$1 == null);
var state_29959__$1 = (function (){var statearr_29963 = state_29959;
(statearr_29963[(7)] = inst_29938__$1);

return statearr_29963;
})();
if(cljs.core.truth_(inst_29939)){
var statearr_29964_29990 = state_29959__$1;
(statearr_29964_29990[(1)] = (5));

} else {
var statearr_29965_29991 = state_29959__$1;
(statearr_29965_29991[(1)] = (6));

}

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_29960 === (13))){
var state_29959__$1 = state_29959;
var statearr_29966_29992 = state_29959__$1;
(statearr_29966_29992[(2)] = null);

(statearr_29966_29992[(1)] = (14));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_29960 === (6))){
var inst_29938 = (state_29959[(7)]);
var state_29959__$1 = state_29959;
return cljs.core.async.impl.ioc_helpers.put_BANG_.call(null,state_29959__$1,(11),to,inst_29938);
} else {
if((state_val_29960 === (3))){
var inst_29957 = (state_29959[(2)]);
var state_29959__$1 = state_29959;
return cljs.core.async.impl.ioc_helpers.return_chan.call(null,state_29959__$1,inst_29957);
} else {
if((state_val_29960 === (12))){
var state_29959__$1 = state_29959;
var statearr_29967_29993 = state_29959__$1;
(statearr_29967_29993[(2)] = null);

(statearr_29967_29993[(1)] = (2));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_29960 === (2))){
var state_29959__$1 = state_29959;
return cljs.core.async.impl.ioc_helpers.take_BANG_.call(null,state_29959__$1,(4),from);
} else {
if((state_val_29960 === (11))){
var inst_29948 = (state_29959[(2)]);
var state_29959__$1 = state_29959;
if(cljs.core.truth_(inst_29948)){
var statearr_29968_29994 = state_29959__$1;
(statearr_29968_29994[(1)] = (12));

} else {
var statearr_29969_29995 = state_29959__$1;
(statearr_29969_29995[(1)] = (13));

}

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_29960 === (9))){
var state_29959__$1 = state_29959;
var statearr_29970_29996 = state_29959__$1;
(statearr_29970_29996[(2)] = null);

(statearr_29970_29996[(1)] = (10));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_29960 === (5))){
var state_29959__$1 = state_29959;
if(cljs.core.truth_(close_QMARK_)){
var statearr_29971_29997 = state_29959__$1;
(statearr_29971_29997[(1)] = (8));

} else {
var statearr_29972_29998 = state_29959__$1;
(statearr_29972_29998[(1)] = (9));

}

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_29960 === (14))){
var inst_29953 = (state_29959[(2)]);
var state_29959__$1 = state_29959;
var statearr_29973_29999 = state_29959__$1;
(statearr_29973_29999[(2)] = inst_29953);

(statearr_29973_29999[(1)] = (7));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_29960 === (10))){
var inst_29945 = (state_29959[(2)]);
var state_29959__$1 = state_29959;
var statearr_29974_30000 = state_29959__$1;
(statearr_29974_30000[(2)] = inst_29945);

(statearr_29974_30000[(1)] = (7));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_29960 === (8))){
var inst_29942 = cljs.core.async.close_BANG_.call(null,to);
var state_29959__$1 = state_29959;
var statearr_29975_30001 = state_29959__$1;
(statearr_29975_30001[(2)] = inst_29942);

(statearr_29975_30001[(1)] = (10));


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
});})(c__27451__auto___29987))
;
return ((function (switch__27386__auto__,c__27451__auto___29987){
return (function() {
var cljs$core$async$state_machine__27387__auto__ = null;
var cljs$core$async$state_machine__27387__auto____0 = (function (){
var statearr_29979 = [null,null,null,null,null,null,null,null];
(statearr_29979[(0)] = cljs$core$async$state_machine__27387__auto__);

(statearr_29979[(1)] = (1));

return statearr_29979;
});
var cljs$core$async$state_machine__27387__auto____1 = (function (state_29959){
while(true){
var ret_value__27388__auto__ = (function (){try{while(true){
var result__27389__auto__ = switch__27386__auto__.call(null,state_29959);
if(cljs.core.keyword_identical_QMARK_.call(null,result__27389__auto__,new cljs.core.Keyword(null,"recur","recur",-437573268))){
continue;
} else {
return result__27389__auto__;
}
break;
}
}catch (e29980){if((e29980 instanceof Object)){
var ex__27390__auto__ = e29980;
var statearr_29981_30002 = state_29959;
(statearr_29981_30002[(5)] = ex__27390__auto__);


cljs.core.async.impl.ioc_helpers.process_exception.call(null,state_29959);

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
throw e29980;

}
}})();
if(cljs.core.keyword_identical_QMARK_.call(null,ret_value__27388__auto__,new cljs.core.Keyword(null,"recur","recur",-437573268))){
var G__30003 = state_29959;
state_29959 = G__30003;
continue;
} else {
return ret_value__27388__auto__;
}
break;
}
});
cljs$core$async$state_machine__27387__auto__ = function(state_29959){
switch(arguments.length){
case 0:
return cljs$core$async$state_machine__27387__auto____0.call(this);
case 1:
return cljs$core$async$state_machine__27387__auto____1.call(this,state_29959);
}
throw(new Error('Invalid arity: ' + arguments.length));
};
cljs$core$async$state_machine__27387__auto__.cljs$core$IFn$_invoke$arity$0 = cljs$core$async$state_machine__27387__auto____0;
cljs$core$async$state_machine__27387__auto__.cljs$core$IFn$_invoke$arity$1 = cljs$core$async$state_machine__27387__auto____1;
return cljs$core$async$state_machine__27387__auto__;
})()
;})(switch__27386__auto__,c__27451__auto___29987))
})();
var state__27453__auto__ = (function (){var statearr_29982 = f__27452__auto__.call(null);
(statearr_29982[cljs.core.async.impl.ioc_helpers.USER_START_IDX] = c__27451__auto___29987);

return statearr_29982;
})();
return cljs.core.async.impl.ioc_helpers.run_state_machine_wrapped.call(null,state__27453__auto__);
});})(c__27451__auto___29987))
);


return to;
});

cljs.core.async.pipe.cljs$lang$maxFixedArity = 3;
cljs.core.async.pipeline_STAR_ = (function cljs$core$async$pipeline_STAR_(n,to,xf,from,close_QMARK_,ex_handler,type){
if((n > (0))){
} else {
throw (new Error([cljs.core.str("Assert failed: "),cljs.core.str(cljs.core.pr_str.call(null,cljs.core.list(new cljs.core.Symbol(null,"pos?","pos?",-244377722,null),new cljs.core.Symbol(null,"n","n",-2092305744,null))))].join('')));
}

var jobs = cljs.core.async.chan.call(null,n);
var results = cljs.core.async.chan.call(null,n);
var process = ((function (jobs,results){
return (function (p__30187){
var vec__30188 = p__30187;
var v = cljs.core.nth.call(null,vec__30188,(0),null);
var p = cljs.core.nth.call(null,vec__30188,(1),null);
var job = vec__30188;
if((job == null)){
cljs.core.async.close_BANG_.call(null,results);

return null;
} else {
var res = cljs.core.async.chan.call(null,(1),xf,ex_handler);
var c__27451__auto___30370 = cljs.core.async.chan.call(null,(1));
cljs.core.async.impl.dispatch.run.call(null,((function (c__27451__auto___30370,res,vec__30188,v,p,job,jobs,results){
return (function (){
var f__27452__auto__ = (function (){var switch__27386__auto__ = ((function (c__27451__auto___30370,res,vec__30188,v,p,job,jobs,results){
return (function (state_30193){
var state_val_30194 = (state_30193[(1)]);
if((state_val_30194 === (1))){
var state_30193__$1 = state_30193;
return cljs.core.async.impl.ioc_helpers.put_BANG_.call(null,state_30193__$1,(2),res,v);
} else {
if((state_val_30194 === (2))){
var inst_30190 = (state_30193[(2)]);
var inst_30191 = cljs.core.async.close_BANG_.call(null,res);
var state_30193__$1 = (function (){var statearr_30195 = state_30193;
(statearr_30195[(7)] = inst_30190);

return statearr_30195;
})();
return cljs.core.async.impl.ioc_helpers.return_chan.call(null,state_30193__$1,inst_30191);
} else {
return null;
}
}
});})(c__27451__auto___30370,res,vec__30188,v,p,job,jobs,results))
;
return ((function (switch__27386__auto__,c__27451__auto___30370,res,vec__30188,v,p,job,jobs,results){
return (function() {
var cljs$core$async$pipeline_STAR__$_state_machine__27387__auto__ = null;
var cljs$core$async$pipeline_STAR__$_state_machine__27387__auto____0 = (function (){
var statearr_30199 = [null,null,null,null,null,null,null,null];
(statearr_30199[(0)] = cljs$core$async$pipeline_STAR__$_state_machine__27387__auto__);

(statearr_30199[(1)] = (1));

return statearr_30199;
});
var cljs$core$async$pipeline_STAR__$_state_machine__27387__auto____1 = (function (state_30193){
while(true){
var ret_value__27388__auto__ = (function (){try{while(true){
var result__27389__auto__ = switch__27386__auto__.call(null,state_30193);
if(cljs.core.keyword_identical_QMARK_.call(null,result__27389__auto__,new cljs.core.Keyword(null,"recur","recur",-437573268))){
continue;
} else {
return result__27389__auto__;
}
break;
}
}catch (e30200){if((e30200 instanceof Object)){
var ex__27390__auto__ = e30200;
var statearr_30201_30371 = state_30193;
(statearr_30201_30371[(5)] = ex__27390__auto__);


cljs.core.async.impl.ioc_helpers.process_exception.call(null,state_30193);

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
throw e30200;

}
}})();
if(cljs.core.keyword_identical_QMARK_.call(null,ret_value__27388__auto__,new cljs.core.Keyword(null,"recur","recur",-437573268))){
var G__30372 = state_30193;
state_30193 = G__30372;
continue;
} else {
return ret_value__27388__auto__;
}
break;
}
});
cljs$core$async$pipeline_STAR__$_state_machine__27387__auto__ = function(state_30193){
switch(arguments.length){
case 0:
return cljs$core$async$pipeline_STAR__$_state_machine__27387__auto____0.call(this);
case 1:
return cljs$core$async$pipeline_STAR__$_state_machine__27387__auto____1.call(this,state_30193);
}
throw(new Error('Invalid arity: ' + arguments.length));
};
cljs$core$async$pipeline_STAR__$_state_machine__27387__auto__.cljs$core$IFn$_invoke$arity$0 = cljs$core$async$pipeline_STAR__$_state_machine__27387__auto____0;
cljs$core$async$pipeline_STAR__$_state_machine__27387__auto__.cljs$core$IFn$_invoke$arity$1 = cljs$core$async$pipeline_STAR__$_state_machine__27387__auto____1;
return cljs$core$async$pipeline_STAR__$_state_machine__27387__auto__;
})()
;})(switch__27386__auto__,c__27451__auto___30370,res,vec__30188,v,p,job,jobs,results))
})();
var state__27453__auto__ = (function (){var statearr_30202 = f__27452__auto__.call(null);
(statearr_30202[cljs.core.async.impl.ioc_helpers.USER_START_IDX] = c__27451__auto___30370);

return statearr_30202;
})();
return cljs.core.async.impl.ioc_helpers.run_state_machine_wrapped.call(null,state__27453__auto__);
});})(c__27451__auto___30370,res,vec__30188,v,p,job,jobs,results))
);


cljs.core.async.put_BANG_.call(null,p,res);

return true;
}
});})(jobs,results))
;
var async = ((function (jobs,results,process){
return (function (p__30203){
var vec__30204 = p__30203;
var v = cljs.core.nth.call(null,vec__30204,(0),null);
var p = cljs.core.nth.call(null,vec__30204,(1),null);
var job = vec__30204;
if((job == null)){
cljs.core.async.close_BANG_.call(null,results);

return null;
} else {
var res = cljs.core.async.chan.call(null,(1));
xf.call(null,v,res);

cljs.core.async.put_BANG_.call(null,p,res);

return true;
}
});})(jobs,results,process))
;
var n__25844__auto___30373 = n;
var __30374 = (0);
while(true){
if((__30374 < n__25844__auto___30373)){
var G__30205_30375 = (((type instanceof cljs.core.Keyword))?type.fqn:null);
switch (G__30205_30375) {
case "compute":
var c__27451__auto___30377 = cljs.core.async.chan.call(null,(1));
cljs.core.async.impl.dispatch.run.call(null,((function (__30374,c__27451__auto___30377,G__30205_30375,n__25844__auto___30373,jobs,results,process,async){
return (function (){
var f__27452__auto__ = (function (){var switch__27386__auto__ = ((function (__30374,c__27451__auto___30377,G__30205_30375,n__25844__auto___30373,jobs,results,process,async){
return (function (state_30218){
var state_val_30219 = (state_30218[(1)]);
if((state_val_30219 === (1))){
var state_30218__$1 = state_30218;
var statearr_30220_30378 = state_30218__$1;
(statearr_30220_30378[(2)] = null);

(statearr_30220_30378[(1)] = (2));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_30219 === (2))){
var state_30218__$1 = state_30218;
return cljs.core.async.impl.ioc_helpers.take_BANG_.call(null,state_30218__$1,(4),jobs);
} else {
if((state_val_30219 === (3))){
var inst_30216 = (state_30218[(2)]);
var state_30218__$1 = state_30218;
return cljs.core.async.impl.ioc_helpers.return_chan.call(null,state_30218__$1,inst_30216);
} else {
if((state_val_30219 === (4))){
var inst_30208 = (state_30218[(2)]);
var inst_30209 = process.call(null,inst_30208);
var state_30218__$1 = state_30218;
if(cljs.core.truth_(inst_30209)){
var statearr_30221_30379 = state_30218__$1;
(statearr_30221_30379[(1)] = (5));

} else {
var statearr_30222_30380 = state_30218__$1;
(statearr_30222_30380[(1)] = (6));

}

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_30219 === (5))){
var state_30218__$1 = state_30218;
var statearr_30223_30381 = state_30218__$1;
(statearr_30223_30381[(2)] = null);

(statearr_30223_30381[(1)] = (2));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_30219 === (6))){
var state_30218__$1 = state_30218;
var statearr_30224_30382 = state_30218__$1;
(statearr_30224_30382[(2)] = null);

(statearr_30224_30382[(1)] = (7));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_30219 === (7))){
var inst_30214 = (state_30218[(2)]);
var state_30218__$1 = state_30218;
var statearr_30225_30383 = state_30218__$1;
(statearr_30225_30383[(2)] = inst_30214);

(statearr_30225_30383[(1)] = (3));


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
});})(__30374,c__27451__auto___30377,G__30205_30375,n__25844__auto___30373,jobs,results,process,async))
;
return ((function (__30374,switch__27386__auto__,c__27451__auto___30377,G__30205_30375,n__25844__auto___30373,jobs,results,process,async){
return (function() {
var cljs$core$async$pipeline_STAR__$_state_machine__27387__auto__ = null;
var cljs$core$async$pipeline_STAR__$_state_machine__27387__auto____0 = (function (){
var statearr_30229 = [null,null,null,null,null,null,null];
(statearr_30229[(0)] = cljs$core$async$pipeline_STAR__$_state_machine__27387__auto__);

(statearr_30229[(1)] = (1));

return statearr_30229;
});
var cljs$core$async$pipeline_STAR__$_state_machine__27387__auto____1 = (function (state_30218){
while(true){
var ret_value__27388__auto__ = (function (){try{while(true){
var result__27389__auto__ = switch__27386__auto__.call(null,state_30218);
if(cljs.core.keyword_identical_QMARK_.call(null,result__27389__auto__,new cljs.core.Keyword(null,"recur","recur",-437573268))){
continue;
} else {
return result__27389__auto__;
}
break;
}
}catch (e30230){if((e30230 instanceof Object)){
var ex__27390__auto__ = e30230;
var statearr_30231_30384 = state_30218;
(statearr_30231_30384[(5)] = ex__27390__auto__);


cljs.core.async.impl.ioc_helpers.process_exception.call(null,state_30218);

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
throw e30230;

}
}})();
if(cljs.core.keyword_identical_QMARK_.call(null,ret_value__27388__auto__,new cljs.core.Keyword(null,"recur","recur",-437573268))){
var G__30385 = state_30218;
state_30218 = G__30385;
continue;
} else {
return ret_value__27388__auto__;
}
break;
}
});
cljs$core$async$pipeline_STAR__$_state_machine__27387__auto__ = function(state_30218){
switch(arguments.length){
case 0:
return cljs$core$async$pipeline_STAR__$_state_machine__27387__auto____0.call(this);
case 1:
return cljs$core$async$pipeline_STAR__$_state_machine__27387__auto____1.call(this,state_30218);
}
throw(new Error('Invalid arity: ' + arguments.length));
};
cljs$core$async$pipeline_STAR__$_state_machine__27387__auto__.cljs$core$IFn$_invoke$arity$0 = cljs$core$async$pipeline_STAR__$_state_machine__27387__auto____0;
cljs$core$async$pipeline_STAR__$_state_machine__27387__auto__.cljs$core$IFn$_invoke$arity$1 = cljs$core$async$pipeline_STAR__$_state_machine__27387__auto____1;
return cljs$core$async$pipeline_STAR__$_state_machine__27387__auto__;
})()
;})(__30374,switch__27386__auto__,c__27451__auto___30377,G__30205_30375,n__25844__auto___30373,jobs,results,process,async))
})();
var state__27453__auto__ = (function (){var statearr_30232 = f__27452__auto__.call(null);
(statearr_30232[cljs.core.async.impl.ioc_helpers.USER_START_IDX] = c__27451__auto___30377);

return statearr_30232;
})();
return cljs.core.async.impl.ioc_helpers.run_state_machine_wrapped.call(null,state__27453__auto__);
});})(__30374,c__27451__auto___30377,G__30205_30375,n__25844__auto___30373,jobs,results,process,async))
);


break;
case "async":
var c__27451__auto___30386 = cljs.core.async.chan.call(null,(1));
cljs.core.async.impl.dispatch.run.call(null,((function (__30374,c__27451__auto___30386,G__30205_30375,n__25844__auto___30373,jobs,results,process,async){
return (function (){
var f__27452__auto__ = (function (){var switch__27386__auto__ = ((function (__30374,c__27451__auto___30386,G__30205_30375,n__25844__auto___30373,jobs,results,process,async){
return (function (state_30245){
var state_val_30246 = (state_30245[(1)]);
if((state_val_30246 === (1))){
var state_30245__$1 = state_30245;
var statearr_30247_30387 = state_30245__$1;
(statearr_30247_30387[(2)] = null);

(statearr_30247_30387[(1)] = (2));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_30246 === (2))){
var state_30245__$1 = state_30245;
return cljs.core.async.impl.ioc_helpers.take_BANG_.call(null,state_30245__$1,(4),jobs);
} else {
if((state_val_30246 === (3))){
var inst_30243 = (state_30245[(2)]);
var state_30245__$1 = state_30245;
return cljs.core.async.impl.ioc_helpers.return_chan.call(null,state_30245__$1,inst_30243);
} else {
if((state_val_30246 === (4))){
var inst_30235 = (state_30245[(2)]);
var inst_30236 = async.call(null,inst_30235);
var state_30245__$1 = state_30245;
if(cljs.core.truth_(inst_30236)){
var statearr_30248_30388 = state_30245__$1;
(statearr_30248_30388[(1)] = (5));

} else {
var statearr_30249_30389 = state_30245__$1;
(statearr_30249_30389[(1)] = (6));

}

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_30246 === (5))){
var state_30245__$1 = state_30245;
var statearr_30250_30390 = state_30245__$1;
(statearr_30250_30390[(2)] = null);

(statearr_30250_30390[(1)] = (2));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_30246 === (6))){
var state_30245__$1 = state_30245;
var statearr_30251_30391 = state_30245__$1;
(statearr_30251_30391[(2)] = null);

(statearr_30251_30391[(1)] = (7));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_30246 === (7))){
var inst_30241 = (state_30245[(2)]);
var state_30245__$1 = state_30245;
var statearr_30252_30392 = state_30245__$1;
(statearr_30252_30392[(2)] = inst_30241);

(statearr_30252_30392[(1)] = (3));


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
});})(__30374,c__27451__auto___30386,G__30205_30375,n__25844__auto___30373,jobs,results,process,async))
;
return ((function (__30374,switch__27386__auto__,c__27451__auto___30386,G__30205_30375,n__25844__auto___30373,jobs,results,process,async){
return (function() {
var cljs$core$async$pipeline_STAR__$_state_machine__27387__auto__ = null;
var cljs$core$async$pipeline_STAR__$_state_machine__27387__auto____0 = (function (){
var statearr_30256 = [null,null,null,null,null,null,null];
(statearr_30256[(0)] = cljs$core$async$pipeline_STAR__$_state_machine__27387__auto__);

(statearr_30256[(1)] = (1));

return statearr_30256;
});
var cljs$core$async$pipeline_STAR__$_state_machine__27387__auto____1 = (function (state_30245){
while(true){
var ret_value__27388__auto__ = (function (){try{while(true){
var result__27389__auto__ = switch__27386__auto__.call(null,state_30245);
if(cljs.core.keyword_identical_QMARK_.call(null,result__27389__auto__,new cljs.core.Keyword(null,"recur","recur",-437573268))){
continue;
} else {
return result__27389__auto__;
}
break;
}
}catch (e30257){if((e30257 instanceof Object)){
var ex__27390__auto__ = e30257;
var statearr_30258_30393 = state_30245;
(statearr_30258_30393[(5)] = ex__27390__auto__);


cljs.core.async.impl.ioc_helpers.process_exception.call(null,state_30245);

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
throw e30257;

}
}})();
if(cljs.core.keyword_identical_QMARK_.call(null,ret_value__27388__auto__,new cljs.core.Keyword(null,"recur","recur",-437573268))){
var G__30394 = state_30245;
state_30245 = G__30394;
continue;
} else {
return ret_value__27388__auto__;
}
break;
}
});
cljs$core$async$pipeline_STAR__$_state_machine__27387__auto__ = function(state_30245){
switch(arguments.length){
case 0:
return cljs$core$async$pipeline_STAR__$_state_machine__27387__auto____0.call(this);
case 1:
return cljs$core$async$pipeline_STAR__$_state_machine__27387__auto____1.call(this,state_30245);
}
throw(new Error('Invalid arity: ' + arguments.length));
};
cljs$core$async$pipeline_STAR__$_state_machine__27387__auto__.cljs$core$IFn$_invoke$arity$0 = cljs$core$async$pipeline_STAR__$_state_machine__27387__auto____0;
cljs$core$async$pipeline_STAR__$_state_machine__27387__auto__.cljs$core$IFn$_invoke$arity$1 = cljs$core$async$pipeline_STAR__$_state_machine__27387__auto____1;
return cljs$core$async$pipeline_STAR__$_state_machine__27387__auto__;
})()
;})(__30374,switch__27386__auto__,c__27451__auto___30386,G__30205_30375,n__25844__auto___30373,jobs,results,process,async))
})();
var state__27453__auto__ = (function (){var statearr_30259 = f__27452__auto__.call(null);
(statearr_30259[cljs.core.async.impl.ioc_helpers.USER_START_IDX] = c__27451__auto___30386);

return statearr_30259;
})();
return cljs.core.async.impl.ioc_helpers.run_state_machine_wrapped.call(null,state__27453__auto__);
});})(__30374,c__27451__auto___30386,G__30205_30375,n__25844__auto___30373,jobs,results,process,async))
);


break;
default:
throw (new Error([cljs.core.str("No matching clause: "),cljs.core.str(type)].join('')));

}

var G__30395 = (__30374 + (1));
__30374 = G__30395;
continue;
} else {
}
break;
}

var c__27451__auto___30396 = cljs.core.async.chan.call(null,(1));
cljs.core.async.impl.dispatch.run.call(null,((function (c__27451__auto___30396,jobs,results,process,async){
return (function (){
var f__27452__auto__ = (function (){var switch__27386__auto__ = ((function (c__27451__auto___30396,jobs,results,process,async){
return (function (state_30281){
var state_val_30282 = (state_30281[(1)]);
if((state_val_30282 === (1))){
var state_30281__$1 = state_30281;
var statearr_30283_30397 = state_30281__$1;
(statearr_30283_30397[(2)] = null);

(statearr_30283_30397[(1)] = (2));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_30282 === (2))){
var state_30281__$1 = state_30281;
return cljs.core.async.impl.ioc_helpers.take_BANG_.call(null,state_30281__$1,(4),from);
} else {
if((state_val_30282 === (3))){
var inst_30279 = (state_30281[(2)]);
var state_30281__$1 = state_30281;
return cljs.core.async.impl.ioc_helpers.return_chan.call(null,state_30281__$1,inst_30279);
} else {
if((state_val_30282 === (4))){
var inst_30262 = (state_30281[(7)]);
var inst_30262__$1 = (state_30281[(2)]);
var inst_30263 = (inst_30262__$1 == null);
var state_30281__$1 = (function (){var statearr_30284 = state_30281;
(statearr_30284[(7)] = inst_30262__$1);

return statearr_30284;
})();
if(cljs.core.truth_(inst_30263)){
var statearr_30285_30398 = state_30281__$1;
(statearr_30285_30398[(1)] = (5));

} else {
var statearr_30286_30399 = state_30281__$1;
(statearr_30286_30399[(1)] = (6));

}

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_30282 === (5))){
var inst_30265 = cljs.core.async.close_BANG_.call(null,jobs);
var state_30281__$1 = state_30281;
var statearr_30287_30400 = state_30281__$1;
(statearr_30287_30400[(2)] = inst_30265);

(statearr_30287_30400[(1)] = (7));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_30282 === (6))){
var inst_30262 = (state_30281[(7)]);
var inst_30267 = (state_30281[(8)]);
var inst_30267__$1 = cljs.core.async.chan.call(null,(1));
var inst_30268 = cljs.core.PersistentVector.EMPTY_NODE;
var inst_30269 = [inst_30262,inst_30267__$1];
var inst_30270 = (new cljs.core.PersistentVector(null,2,(5),inst_30268,inst_30269,null));
var state_30281__$1 = (function (){var statearr_30288 = state_30281;
(statearr_30288[(8)] = inst_30267__$1);

return statearr_30288;
})();
return cljs.core.async.impl.ioc_helpers.put_BANG_.call(null,state_30281__$1,(8),jobs,inst_30270);
} else {
if((state_val_30282 === (7))){
var inst_30277 = (state_30281[(2)]);
var state_30281__$1 = state_30281;
var statearr_30289_30401 = state_30281__$1;
(statearr_30289_30401[(2)] = inst_30277);

(statearr_30289_30401[(1)] = (3));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_30282 === (8))){
var inst_30267 = (state_30281[(8)]);
var inst_30272 = (state_30281[(2)]);
var state_30281__$1 = (function (){var statearr_30290 = state_30281;
(statearr_30290[(9)] = inst_30272);

return statearr_30290;
})();
return cljs.core.async.impl.ioc_helpers.put_BANG_.call(null,state_30281__$1,(9),results,inst_30267);
} else {
if((state_val_30282 === (9))){
var inst_30274 = (state_30281[(2)]);
var state_30281__$1 = (function (){var statearr_30291 = state_30281;
(statearr_30291[(10)] = inst_30274);

return statearr_30291;
})();
var statearr_30292_30402 = state_30281__$1;
(statearr_30292_30402[(2)] = null);

(statearr_30292_30402[(1)] = (2));


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
});})(c__27451__auto___30396,jobs,results,process,async))
;
return ((function (switch__27386__auto__,c__27451__auto___30396,jobs,results,process,async){
return (function() {
var cljs$core$async$pipeline_STAR__$_state_machine__27387__auto__ = null;
var cljs$core$async$pipeline_STAR__$_state_machine__27387__auto____0 = (function (){
var statearr_30296 = [null,null,null,null,null,null,null,null,null,null,null];
(statearr_30296[(0)] = cljs$core$async$pipeline_STAR__$_state_machine__27387__auto__);

(statearr_30296[(1)] = (1));

return statearr_30296;
});
var cljs$core$async$pipeline_STAR__$_state_machine__27387__auto____1 = (function (state_30281){
while(true){
var ret_value__27388__auto__ = (function (){try{while(true){
var result__27389__auto__ = switch__27386__auto__.call(null,state_30281);
if(cljs.core.keyword_identical_QMARK_.call(null,result__27389__auto__,new cljs.core.Keyword(null,"recur","recur",-437573268))){
continue;
} else {
return result__27389__auto__;
}
break;
}
}catch (e30297){if((e30297 instanceof Object)){
var ex__27390__auto__ = e30297;
var statearr_30298_30403 = state_30281;
(statearr_30298_30403[(5)] = ex__27390__auto__);


cljs.core.async.impl.ioc_helpers.process_exception.call(null,state_30281);

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
throw e30297;

}
}})();
if(cljs.core.keyword_identical_QMARK_.call(null,ret_value__27388__auto__,new cljs.core.Keyword(null,"recur","recur",-437573268))){
var G__30404 = state_30281;
state_30281 = G__30404;
continue;
} else {
return ret_value__27388__auto__;
}
break;
}
});
cljs$core$async$pipeline_STAR__$_state_machine__27387__auto__ = function(state_30281){
switch(arguments.length){
case 0:
return cljs$core$async$pipeline_STAR__$_state_machine__27387__auto____0.call(this);
case 1:
return cljs$core$async$pipeline_STAR__$_state_machine__27387__auto____1.call(this,state_30281);
}
throw(new Error('Invalid arity: ' + arguments.length));
};
cljs$core$async$pipeline_STAR__$_state_machine__27387__auto__.cljs$core$IFn$_invoke$arity$0 = cljs$core$async$pipeline_STAR__$_state_machine__27387__auto____0;
cljs$core$async$pipeline_STAR__$_state_machine__27387__auto__.cljs$core$IFn$_invoke$arity$1 = cljs$core$async$pipeline_STAR__$_state_machine__27387__auto____1;
return cljs$core$async$pipeline_STAR__$_state_machine__27387__auto__;
})()
;})(switch__27386__auto__,c__27451__auto___30396,jobs,results,process,async))
})();
var state__27453__auto__ = (function (){var statearr_30299 = f__27452__auto__.call(null);
(statearr_30299[cljs.core.async.impl.ioc_helpers.USER_START_IDX] = c__27451__auto___30396);

return statearr_30299;
})();
return cljs.core.async.impl.ioc_helpers.run_state_machine_wrapped.call(null,state__27453__auto__);
});})(c__27451__auto___30396,jobs,results,process,async))
);


var c__27451__auto__ = cljs.core.async.chan.call(null,(1));
cljs.core.async.impl.dispatch.run.call(null,((function (c__27451__auto__,jobs,results,process,async){
return (function (){
var f__27452__auto__ = (function (){var switch__27386__auto__ = ((function (c__27451__auto__,jobs,results,process,async){
return (function (state_30337){
var state_val_30338 = (state_30337[(1)]);
if((state_val_30338 === (7))){
var inst_30333 = (state_30337[(2)]);
var state_30337__$1 = state_30337;
var statearr_30339_30405 = state_30337__$1;
(statearr_30339_30405[(2)] = inst_30333);

(statearr_30339_30405[(1)] = (3));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_30338 === (20))){
var state_30337__$1 = state_30337;
var statearr_30340_30406 = state_30337__$1;
(statearr_30340_30406[(2)] = null);

(statearr_30340_30406[(1)] = (21));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_30338 === (1))){
var state_30337__$1 = state_30337;
var statearr_30341_30407 = state_30337__$1;
(statearr_30341_30407[(2)] = null);

(statearr_30341_30407[(1)] = (2));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_30338 === (4))){
var inst_30302 = (state_30337[(7)]);
var inst_30302__$1 = (state_30337[(2)]);
var inst_30303 = (inst_30302__$1 == null);
var state_30337__$1 = (function (){var statearr_30342 = state_30337;
(statearr_30342[(7)] = inst_30302__$1);

return statearr_30342;
})();
if(cljs.core.truth_(inst_30303)){
var statearr_30343_30408 = state_30337__$1;
(statearr_30343_30408[(1)] = (5));

} else {
var statearr_30344_30409 = state_30337__$1;
(statearr_30344_30409[(1)] = (6));

}

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_30338 === (15))){
var inst_30315 = (state_30337[(8)]);
var state_30337__$1 = state_30337;
return cljs.core.async.impl.ioc_helpers.put_BANG_.call(null,state_30337__$1,(18),to,inst_30315);
} else {
if((state_val_30338 === (21))){
var inst_30328 = (state_30337[(2)]);
var state_30337__$1 = state_30337;
var statearr_30345_30410 = state_30337__$1;
(statearr_30345_30410[(2)] = inst_30328);

(statearr_30345_30410[(1)] = (13));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_30338 === (13))){
var inst_30330 = (state_30337[(2)]);
var state_30337__$1 = (function (){var statearr_30346 = state_30337;
(statearr_30346[(9)] = inst_30330);

return statearr_30346;
})();
var statearr_30347_30411 = state_30337__$1;
(statearr_30347_30411[(2)] = null);

(statearr_30347_30411[(1)] = (2));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_30338 === (6))){
var inst_30302 = (state_30337[(7)]);
var state_30337__$1 = state_30337;
return cljs.core.async.impl.ioc_helpers.take_BANG_.call(null,state_30337__$1,(11),inst_30302);
} else {
if((state_val_30338 === (17))){
var inst_30323 = (state_30337[(2)]);
var state_30337__$1 = state_30337;
if(cljs.core.truth_(inst_30323)){
var statearr_30348_30412 = state_30337__$1;
(statearr_30348_30412[(1)] = (19));

} else {
var statearr_30349_30413 = state_30337__$1;
(statearr_30349_30413[(1)] = (20));

}

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_30338 === (3))){
var inst_30335 = (state_30337[(2)]);
var state_30337__$1 = state_30337;
return cljs.core.async.impl.ioc_helpers.return_chan.call(null,state_30337__$1,inst_30335);
} else {
if((state_val_30338 === (12))){
var inst_30312 = (state_30337[(10)]);
var state_30337__$1 = state_30337;
return cljs.core.async.impl.ioc_helpers.take_BANG_.call(null,state_30337__$1,(14),inst_30312);
} else {
if((state_val_30338 === (2))){
var state_30337__$1 = state_30337;
return cljs.core.async.impl.ioc_helpers.take_BANG_.call(null,state_30337__$1,(4),results);
} else {
if((state_val_30338 === (19))){
var state_30337__$1 = state_30337;
var statearr_30350_30414 = state_30337__$1;
(statearr_30350_30414[(2)] = null);

(statearr_30350_30414[(1)] = (12));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_30338 === (11))){
var inst_30312 = (state_30337[(2)]);
var state_30337__$1 = (function (){var statearr_30351 = state_30337;
(statearr_30351[(10)] = inst_30312);

return statearr_30351;
})();
var statearr_30352_30415 = state_30337__$1;
(statearr_30352_30415[(2)] = null);

(statearr_30352_30415[(1)] = (12));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_30338 === (9))){
var state_30337__$1 = state_30337;
var statearr_30353_30416 = state_30337__$1;
(statearr_30353_30416[(2)] = null);

(statearr_30353_30416[(1)] = (10));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_30338 === (5))){
var state_30337__$1 = state_30337;
if(cljs.core.truth_(close_QMARK_)){
var statearr_30354_30417 = state_30337__$1;
(statearr_30354_30417[(1)] = (8));

} else {
var statearr_30355_30418 = state_30337__$1;
(statearr_30355_30418[(1)] = (9));

}

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_30338 === (14))){
var inst_30317 = (state_30337[(11)]);
var inst_30315 = (state_30337[(8)]);
var inst_30315__$1 = (state_30337[(2)]);
var inst_30316 = (inst_30315__$1 == null);
var inst_30317__$1 = cljs.core.not.call(null,inst_30316);
var state_30337__$1 = (function (){var statearr_30356 = state_30337;
(statearr_30356[(11)] = inst_30317__$1);

(statearr_30356[(8)] = inst_30315__$1);

return statearr_30356;
})();
if(inst_30317__$1){
var statearr_30357_30419 = state_30337__$1;
(statearr_30357_30419[(1)] = (15));

} else {
var statearr_30358_30420 = state_30337__$1;
(statearr_30358_30420[(1)] = (16));

}

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_30338 === (16))){
var inst_30317 = (state_30337[(11)]);
var state_30337__$1 = state_30337;
var statearr_30359_30421 = state_30337__$1;
(statearr_30359_30421[(2)] = inst_30317);

(statearr_30359_30421[(1)] = (17));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_30338 === (10))){
var inst_30309 = (state_30337[(2)]);
var state_30337__$1 = state_30337;
var statearr_30360_30422 = state_30337__$1;
(statearr_30360_30422[(2)] = inst_30309);

(statearr_30360_30422[(1)] = (7));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_30338 === (18))){
var inst_30320 = (state_30337[(2)]);
var state_30337__$1 = state_30337;
var statearr_30361_30423 = state_30337__$1;
(statearr_30361_30423[(2)] = inst_30320);

(statearr_30361_30423[(1)] = (17));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_30338 === (8))){
var inst_30306 = cljs.core.async.close_BANG_.call(null,to);
var state_30337__$1 = state_30337;
var statearr_30362_30424 = state_30337__$1;
(statearr_30362_30424[(2)] = inst_30306);

(statearr_30362_30424[(1)] = (10));


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
}
}
}
}
}
}
});})(c__27451__auto__,jobs,results,process,async))
;
return ((function (switch__27386__auto__,c__27451__auto__,jobs,results,process,async){
return (function() {
var cljs$core$async$pipeline_STAR__$_state_machine__27387__auto__ = null;
var cljs$core$async$pipeline_STAR__$_state_machine__27387__auto____0 = (function (){
var statearr_30366 = [null,null,null,null,null,null,null,null,null,null,null,null];
(statearr_30366[(0)] = cljs$core$async$pipeline_STAR__$_state_machine__27387__auto__);

(statearr_30366[(1)] = (1));

return statearr_30366;
});
var cljs$core$async$pipeline_STAR__$_state_machine__27387__auto____1 = (function (state_30337){
while(true){
var ret_value__27388__auto__ = (function (){try{while(true){
var result__27389__auto__ = switch__27386__auto__.call(null,state_30337);
if(cljs.core.keyword_identical_QMARK_.call(null,result__27389__auto__,new cljs.core.Keyword(null,"recur","recur",-437573268))){
continue;
} else {
return result__27389__auto__;
}
break;
}
}catch (e30367){if((e30367 instanceof Object)){
var ex__27390__auto__ = e30367;
var statearr_30368_30425 = state_30337;
(statearr_30368_30425[(5)] = ex__27390__auto__);


cljs.core.async.impl.ioc_helpers.process_exception.call(null,state_30337);

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
throw e30367;

}
}})();
if(cljs.core.keyword_identical_QMARK_.call(null,ret_value__27388__auto__,new cljs.core.Keyword(null,"recur","recur",-437573268))){
var G__30426 = state_30337;
state_30337 = G__30426;
continue;
} else {
return ret_value__27388__auto__;
}
break;
}
});
cljs$core$async$pipeline_STAR__$_state_machine__27387__auto__ = function(state_30337){
switch(arguments.length){
case 0:
return cljs$core$async$pipeline_STAR__$_state_machine__27387__auto____0.call(this);
case 1:
return cljs$core$async$pipeline_STAR__$_state_machine__27387__auto____1.call(this,state_30337);
}
throw(new Error('Invalid arity: ' + arguments.length));
};
cljs$core$async$pipeline_STAR__$_state_machine__27387__auto__.cljs$core$IFn$_invoke$arity$0 = cljs$core$async$pipeline_STAR__$_state_machine__27387__auto____0;
cljs$core$async$pipeline_STAR__$_state_machine__27387__auto__.cljs$core$IFn$_invoke$arity$1 = cljs$core$async$pipeline_STAR__$_state_machine__27387__auto____1;
return cljs$core$async$pipeline_STAR__$_state_machine__27387__auto__;
})()
;})(switch__27386__auto__,c__27451__auto__,jobs,results,process,async))
})();
var state__27453__auto__ = (function (){var statearr_30369 = f__27452__auto__.call(null);
(statearr_30369[cljs.core.async.impl.ioc_helpers.USER_START_IDX] = c__27451__auto__);

return statearr_30369;
})();
return cljs.core.async.impl.ioc_helpers.run_state_machine_wrapped.call(null,state__27453__auto__);
});})(c__27451__auto__,jobs,results,process,async))
);

return c__27451__auto__;
});
/**
 * Takes elements from the from channel and supplies them to the to
 *   channel, subject to the async function af, with parallelism n. af
 *   must be a function of two arguments, the first an input value and
 *   the second a channel on which to place the result(s). af must close!
 *   the channel before returning.  The presumption is that af will
 *   return immediately, having launched some asynchronous operation
 *   whose completion/callback will manipulate the result channel. Outputs
 *   will be returned in order relative to  the inputs. By default, the to
 *   channel will be closed when the from channel closes, but can be
 *   determined by the close?  parameter. Will stop consuming the from
 *   channel if the to channel closes.
 */
cljs.core.async.pipeline_async = (function cljs$core$async$pipeline_async(var_args){
var args30427 = [];
var len__25999__auto___30430 = arguments.length;
var i__26000__auto___30431 = (0);
while(true){
if((i__26000__auto___30431 < len__25999__auto___30430)){
args30427.push((arguments[i__26000__auto___30431]));

var G__30432 = (i__26000__auto___30431 + (1));
i__26000__auto___30431 = G__30432;
continue;
} else {
}
break;
}

var G__30429 = args30427.length;
switch (G__30429) {
case 4:
return cljs.core.async.pipeline_async.cljs$core$IFn$_invoke$arity$4((arguments[(0)]),(arguments[(1)]),(arguments[(2)]),(arguments[(3)]));

break;
case 5:
return cljs.core.async.pipeline_async.cljs$core$IFn$_invoke$arity$5((arguments[(0)]),(arguments[(1)]),(arguments[(2)]),(arguments[(3)]),(arguments[(4)]));

break;
default:
throw (new Error([cljs.core.str("Invalid arity: "),cljs.core.str(args30427.length)].join('')));

}
});

cljs.core.async.pipeline_async.cljs$core$IFn$_invoke$arity$4 = (function (n,to,af,from){
return cljs.core.async.pipeline_async.call(null,n,to,af,from,true);
});

cljs.core.async.pipeline_async.cljs$core$IFn$_invoke$arity$5 = (function (n,to,af,from,close_QMARK_){
return cljs.core.async.pipeline_STAR_.call(null,n,to,af,from,close_QMARK_,null,new cljs.core.Keyword(null,"async","async",1050769601));
});

cljs.core.async.pipeline_async.cljs$lang$maxFixedArity = 5;
/**
 * Takes elements from the from channel and supplies them to the to
 *   channel, subject to the transducer xf, with parallelism n. Because
 *   it is parallel, the transducer will be applied independently to each
 *   element, not across elements, and may produce zero or more outputs
 *   per input.  Outputs will be returned in order relative to the
 *   inputs. By default, the to channel will be closed when the from
 *   channel closes, but can be determined by the close?  parameter. Will
 *   stop consuming the from channel if the to channel closes.
 * 
 *   Note this is supplied for API compatibility with the Clojure version.
 *   Values of N > 1 will not result in actual concurrency in a
 *   single-threaded runtime.
 */
cljs.core.async.pipeline = (function cljs$core$async$pipeline(var_args){
var args30434 = [];
var len__25999__auto___30437 = arguments.length;
var i__26000__auto___30438 = (0);
while(true){
if((i__26000__auto___30438 < len__25999__auto___30437)){
args30434.push((arguments[i__26000__auto___30438]));

var G__30439 = (i__26000__auto___30438 + (1));
i__26000__auto___30438 = G__30439;
continue;
} else {
}
break;
}

var G__30436 = args30434.length;
switch (G__30436) {
case 4:
return cljs.core.async.pipeline.cljs$core$IFn$_invoke$arity$4((arguments[(0)]),(arguments[(1)]),(arguments[(2)]),(arguments[(3)]));

break;
case 5:
return cljs.core.async.pipeline.cljs$core$IFn$_invoke$arity$5((arguments[(0)]),(arguments[(1)]),(arguments[(2)]),(arguments[(3)]),(arguments[(4)]));

break;
case 6:
return cljs.core.async.pipeline.cljs$core$IFn$_invoke$arity$6((arguments[(0)]),(arguments[(1)]),(arguments[(2)]),(arguments[(3)]),(arguments[(4)]),(arguments[(5)]));

break;
default:
throw (new Error([cljs.core.str("Invalid arity: "),cljs.core.str(args30434.length)].join('')));

}
});

cljs.core.async.pipeline.cljs$core$IFn$_invoke$arity$4 = (function (n,to,xf,from){
return cljs.core.async.pipeline.call(null,n,to,xf,from,true);
});

cljs.core.async.pipeline.cljs$core$IFn$_invoke$arity$5 = (function (n,to,xf,from,close_QMARK_){
return cljs.core.async.pipeline.call(null,n,to,xf,from,close_QMARK_,null);
});

cljs.core.async.pipeline.cljs$core$IFn$_invoke$arity$6 = (function (n,to,xf,from,close_QMARK_,ex_handler){
return cljs.core.async.pipeline_STAR_.call(null,n,to,xf,from,close_QMARK_,ex_handler,new cljs.core.Keyword(null,"compute","compute",1555393130));
});

cljs.core.async.pipeline.cljs$lang$maxFixedArity = 6;
/**
 * Takes a predicate and a source channel and returns a vector of two
 *   channels, the first of which will contain the values for which the
 *   predicate returned true, the second those for which it returned
 *   false.
 * 
 *   The out channels will be unbuffered by default, or two buf-or-ns can
 *   be supplied. The channels will close after the source channel has
 *   closed.
 */
cljs.core.async.split = (function cljs$core$async$split(var_args){
var args30441 = [];
var len__25999__auto___30494 = arguments.length;
var i__26000__auto___30495 = (0);
while(true){
if((i__26000__auto___30495 < len__25999__auto___30494)){
args30441.push((arguments[i__26000__auto___30495]));

var G__30496 = (i__26000__auto___30495 + (1));
i__26000__auto___30495 = G__30496;
continue;
} else {
}
break;
}

var G__30443 = args30441.length;
switch (G__30443) {
case 2:
return cljs.core.async.split.cljs$core$IFn$_invoke$arity$2((arguments[(0)]),(arguments[(1)]));

break;
case 4:
return cljs.core.async.split.cljs$core$IFn$_invoke$arity$4((arguments[(0)]),(arguments[(1)]),(arguments[(2)]),(arguments[(3)]));

break;
default:
throw (new Error([cljs.core.str("Invalid arity: "),cljs.core.str(args30441.length)].join('')));

}
});

cljs.core.async.split.cljs$core$IFn$_invoke$arity$2 = (function (p,ch){
return cljs.core.async.split.call(null,p,ch,null,null);
});

cljs.core.async.split.cljs$core$IFn$_invoke$arity$4 = (function (p,ch,t_buf_or_n,f_buf_or_n){
var tc = cljs.core.async.chan.call(null,t_buf_or_n);
var fc = cljs.core.async.chan.call(null,f_buf_or_n);
var c__27451__auto___30498 = cljs.core.async.chan.call(null,(1));
cljs.core.async.impl.dispatch.run.call(null,((function (c__27451__auto___30498,tc,fc){
return (function (){
var f__27452__auto__ = (function (){var switch__27386__auto__ = ((function (c__27451__auto___30498,tc,fc){
return (function (state_30469){
var state_val_30470 = (state_30469[(1)]);
if((state_val_30470 === (7))){
var inst_30465 = (state_30469[(2)]);
var state_30469__$1 = state_30469;
var statearr_30471_30499 = state_30469__$1;
(statearr_30471_30499[(2)] = inst_30465);

(statearr_30471_30499[(1)] = (3));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_30470 === (1))){
var state_30469__$1 = state_30469;
var statearr_30472_30500 = state_30469__$1;
(statearr_30472_30500[(2)] = null);

(statearr_30472_30500[(1)] = (2));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_30470 === (4))){
var inst_30446 = (state_30469[(7)]);
var inst_30446__$1 = (state_30469[(2)]);
var inst_30447 = (inst_30446__$1 == null);
var state_30469__$1 = (function (){var statearr_30473 = state_30469;
(statearr_30473[(7)] = inst_30446__$1);

return statearr_30473;
})();
if(cljs.core.truth_(inst_30447)){
var statearr_30474_30501 = state_30469__$1;
(statearr_30474_30501[(1)] = (5));

} else {
var statearr_30475_30502 = state_30469__$1;
(statearr_30475_30502[(1)] = (6));

}

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_30470 === (13))){
var state_30469__$1 = state_30469;
var statearr_30476_30503 = state_30469__$1;
(statearr_30476_30503[(2)] = null);

(statearr_30476_30503[(1)] = (14));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_30470 === (6))){
var inst_30446 = (state_30469[(7)]);
var inst_30452 = p.call(null,inst_30446);
var state_30469__$1 = state_30469;
if(cljs.core.truth_(inst_30452)){
var statearr_30477_30504 = state_30469__$1;
(statearr_30477_30504[(1)] = (9));

} else {
var statearr_30478_30505 = state_30469__$1;
(statearr_30478_30505[(1)] = (10));

}

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_30470 === (3))){
var inst_30467 = (state_30469[(2)]);
var state_30469__$1 = state_30469;
return cljs.core.async.impl.ioc_helpers.return_chan.call(null,state_30469__$1,inst_30467);
} else {
if((state_val_30470 === (12))){
var state_30469__$1 = state_30469;
var statearr_30479_30506 = state_30469__$1;
(statearr_30479_30506[(2)] = null);

(statearr_30479_30506[(1)] = (2));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_30470 === (2))){
var state_30469__$1 = state_30469;
return cljs.core.async.impl.ioc_helpers.take_BANG_.call(null,state_30469__$1,(4),ch);
} else {
if((state_val_30470 === (11))){
var inst_30446 = (state_30469[(7)]);
var inst_30456 = (state_30469[(2)]);
var state_30469__$1 = state_30469;
return cljs.core.async.impl.ioc_helpers.put_BANG_.call(null,state_30469__$1,(8),inst_30456,inst_30446);
} else {
if((state_val_30470 === (9))){
var state_30469__$1 = state_30469;
var statearr_30480_30507 = state_30469__$1;
(statearr_30480_30507[(2)] = tc);

(statearr_30480_30507[(1)] = (11));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_30470 === (5))){
var inst_30449 = cljs.core.async.close_BANG_.call(null,tc);
var inst_30450 = cljs.core.async.close_BANG_.call(null,fc);
var state_30469__$1 = (function (){var statearr_30481 = state_30469;
(statearr_30481[(8)] = inst_30449);

return statearr_30481;
})();
var statearr_30482_30508 = state_30469__$1;
(statearr_30482_30508[(2)] = inst_30450);

(statearr_30482_30508[(1)] = (7));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_30470 === (14))){
var inst_30463 = (state_30469[(2)]);
var state_30469__$1 = state_30469;
var statearr_30483_30509 = state_30469__$1;
(statearr_30483_30509[(2)] = inst_30463);

(statearr_30483_30509[(1)] = (7));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_30470 === (10))){
var state_30469__$1 = state_30469;
var statearr_30484_30510 = state_30469__$1;
(statearr_30484_30510[(2)] = fc);

(statearr_30484_30510[(1)] = (11));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_30470 === (8))){
var inst_30458 = (state_30469[(2)]);
var state_30469__$1 = state_30469;
if(cljs.core.truth_(inst_30458)){
var statearr_30485_30511 = state_30469__$1;
(statearr_30485_30511[(1)] = (12));

} else {
var statearr_30486_30512 = state_30469__$1;
(statearr_30486_30512[(1)] = (13));

}

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
});})(c__27451__auto___30498,tc,fc))
;
return ((function (switch__27386__auto__,c__27451__auto___30498,tc,fc){
return (function() {
var cljs$core$async$state_machine__27387__auto__ = null;
var cljs$core$async$state_machine__27387__auto____0 = (function (){
var statearr_30490 = [null,null,null,null,null,null,null,null,null];
(statearr_30490[(0)] = cljs$core$async$state_machine__27387__auto__);

(statearr_30490[(1)] = (1));

return statearr_30490;
});
var cljs$core$async$state_machine__27387__auto____1 = (function (state_30469){
while(true){
var ret_value__27388__auto__ = (function (){try{while(true){
var result__27389__auto__ = switch__27386__auto__.call(null,state_30469);
if(cljs.core.keyword_identical_QMARK_.call(null,result__27389__auto__,new cljs.core.Keyword(null,"recur","recur",-437573268))){
continue;
} else {
return result__27389__auto__;
}
break;
}
}catch (e30491){if((e30491 instanceof Object)){
var ex__27390__auto__ = e30491;
var statearr_30492_30513 = state_30469;
(statearr_30492_30513[(5)] = ex__27390__auto__);


cljs.core.async.impl.ioc_helpers.process_exception.call(null,state_30469);

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
throw e30491;

}
}})();
if(cljs.core.keyword_identical_QMARK_.call(null,ret_value__27388__auto__,new cljs.core.Keyword(null,"recur","recur",-437573268))){
var G__30514 = state_30469;
state_30469 = G__30514;
continue;
} else {
return ret_value__27388__auto__;
}
break;
}
});
cljs$core$async$state_machine__27387__auto__ = function(state_30469){
switch(arguments.length){
case 0:
return cljs$core$async$state_machine__27387__auto____0.call(this);
case 1:
return cljs$core$async$state_machine__27387__auto____1.call(this,state_30469);
}
throw(new Error('Invalid arity: ' + arguments.length));
};
cljs$core$async$state_machine__27387__auto__.cljs$core$IFn$_invoke$arity$0 = cljs$core$async$state_machine__27387__auto____0;
cljs$core$async$state_machine__27387__auto__.cljs$core$IFn$_invoke$arity$1 = cljs$core$async$state_machine__27387__auto____1;
return cljs$core$async$state_machine__27387__auto__;
})()
;})(switch__27386__auto__,c__27451__auto___30498,tc,fc))
})();
var state__27453__auto__ = (function (){var statearr_30493 = f__27452__auto__.call(null);
(statearr_30493[cljs.core.async.impl.ioc_helpers.USER_START_IDX] = c__27451__auto___30498);

return statearr_30493;
})();
return cljs.core.async.impl.ioc_helpers.run_state_machine_wrapped.call(null,state__27453__auto__);
});})(c__27451__auto___30498,tc,fc))
);


return new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [tc,fc], null);
});

cljs.core.async.split.cljs$lang$maxFixedArity = 4;
/**
 * f should be a function of 2 arguments. Returns a channel containing
 *   the single result of applying f to init and the first item from the
 *   channel, then applying f to that result and the 2nd item, etc. If
 *   the channel closes without yielding items, returns init and f is not
 *   called. ch must close before reduce produces a result.
 */
cljs.core.async.reduce = (function cljs$core$async$reduce(f,init,ch){
var c__27451__auto__ = cljs.core.async.chan.call(null,(1));
cljs.core.async.impl.dispatch.run.call(null,((function (c__27451__auto__){
return (function (){
var f__27452__auto__ = (function (){var switch__27386__auto__ = ((function (c__27451__auto__){
return (function (state_30578){
var state_val_30579 = (state_30578[(1)]);
if((state_val_30579 === (7))){
var inst_30574 = (state_30578[(2)]);
var state_30578__$1 = state_30578;
var statearr_30580_30601 = state_30578__$1;
(statearr_30580_30601[(2)] = inst_30574);

(statearr_30580_30601[(1)] = (3));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_30579 === (1))){
var inst_30558 = init;
var state_30578__$1 = (function (){var statearr_30581 = state_30578;
(statearr_30581[(7)] = inst_30558);

return statearr_30581;
})();
var statearr_30582_30602 = state_30578__$1;
(statearr_30582_30602[(2)] = null);

(statearr_30582_30602[(1)] = (2));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_30579 === (4))){
var inst_30561 = (state_30578[(8)]);
var inst_30561__$1 = (state_30578[(2)]);
var inst_30562 = (inst_30561__$1 == null);
var state_30578__$1 = (function (){var statearr_30583 = state_30578;
(statearr_30583[(8)] = inst_30561__$1);

return statearr_30583;
})();
if(cljs.core.truth_(inst_30562)){
var statearr_30584_30603 = state_30578__$1;
(statearr_30584_30603[(1)] = (5));

} else {
var statearr_30585_30604 = state_30578__$1;
(statearr_30585_30604[(1)] = (6));

}

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_30579 === (6))){
var inst_30565 = (state_30578[(9)]);
var inst_30561 = (state_30578[(8)]);
var inst_30558 = (state_30578[(7)]);
var inst_30565__$1 = f.call(null,inst_30558,inst_30561);
var inst_30566 = cljs.core.reduced_QMARK_.call(null,inst_30565__$1);
var state_30578__$1 = (function (){var statearr_30586 = state_30578;
(statearr_30586[(9)] = inst_30565__$1);

return statearr_30586;
})();
if(inst_30566){
var statearr_30587_30605 = state_30578__$1;
(statearr_30587_30605[(1)] = (8));

} else {
var statearr_30588_30606 = state_30578__$1;
(statearr_30588_30606[(1)] = (9));

}

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_30579 === (3))){
var inst_30576 = (state_30578[(2)]);
var state_30578__$1 = state_30578;
return cljs.core.async.impl.ioc_helpers.return_chan.call(null,state_30578__$1,inst_30576);
} else {
if((state_val_30579 === (2))){
var state_30578__$1 = state_30578;
return cljs.core.async.impl.ioc_helpers.take_BANG_.call(null,state_30578__$1,(4),ch);
} else {
if((state_val_30579 === (9))){
var inst_30565 = (state_30578[(9)]);
var inst_30558 = inst_30565;
var state_30578__$1 = (function (){var statearr_30589 = state_30578;
(statearr_30589[(7)] = inst_30558);

return statearr_30589;
})();
var statearr_30590_30607 = state_30578__$1;
(statearr_30590_30607[(2)] = null);

(statearr_30590_30607[(1)] = (2));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_30579 === (5))){
var inst_30558 = (state_30578[(7)]);
var state_30578__$1 = state_30578;
var statearr_30591_30608 = state_30578__$1;
(statearr_30591_30608[(2)] = inst_30558);

(statearr_30591_30608[(1)] = (7));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_30579 === (10))){
var inst_30572 = (state_30578[(2)]);
var state_30578__$1 = state_30578;
var statearr_30592_30609 = state_30578__$1;
(statearr_30592_30609[(2)] = inst_30572);

(statearr_30592_30609[(1)] = (7));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_30579 === (8))){
var inst_30565 = (state_30578[(9)]);
var inst_30568 = cljs.core.deref.call(null,inst_30565);
var state_30578__$1 = state_30578;
var statearr_30593_30610 = state_30578__$1;
(statearr_30593_30610[(2)] = inst_30568);

(statearr_30593_30610[(1)] = (10));


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
});})(c__27451__auto__))
;
return ((function (switch__27386__auto__,c__27451__auto__){
return (function() {
var cljs$core$async$reduce_$_state_machine__27387__auto__ = null;
var cljs$core$async$reduce_$_state_machine__27387__auto____0 = (function (){
var statearr_30597 = [null,null,null,null,null,null,null,null,null,null];
(statearr_30597[(0)] = cljs$core$async$reduce_$_state_machine__27387__auto__);

(statearr_30597[(1)] = (1));

return statearr_30597;
});
var cljs$core$async$reduce_$_state_machine__27387__auto____1 = (function (state_30578){
while(true){
var ret_value__27388__auto__ = (function (){try{while(true){
var result__27389__auto__ = switch__27386__auto__.call(null,state_30578);
if(cljs.core.keyword_identical_QMARK_.call(null,result__27389__auto__,new cljs.core.Keyword(null,"recur","recur",-437573268))){
continue;
} else {
return result__27389__auto__;
}
break;
}
}catch (e30598){if((e30598 instanceof Object)){
var ex__27390__auto__ = e30598;
var statearr_30599_30611 = state_30578;
(statearr_30599_30611[(5)] = ex__27390__auto__);


cljs.core.async.impl.ioc_helpers.process_exception.call(null,state_30578);

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
throw e30598;

}
}})();
if(cljs.core.keyword_identical_QMARK_.call(null,ret_value__27388__auto__,new cljs.core.Keyword(null,"recur","recur",-437573268))){
var G__30612 = state_30578;
state_30578 = G__30612;
continue;
} else {
return ret_value__27388__auto__;
}
break;
}
});
cljs$core$async$reduce_$_state_machine__27387__auto__ = function(state_30578){
switch(arguments.length){
case 0:
return cljs$core$async$reduce_$_state_machine__27387__auto____0.call(this);
case 1:
return cljs$core$async$reduce_$_state_machine__27387__auto____1.call(this,state_30578);
}
throw(new Error('Invalid arity: ' + arguments.length));
};
cljs$core$async$reduce_$_state_machine__27387__auto__.cljs$core$IFn$_invoke$arity$0 = cljs$core$async$reduce_$_state_machine__27387__auto____0;
cljs$core$async$reduce_$_state_machine__27387__auto__.cljs$core$IFn$_invoke$arity$1 = cljs$core$async$reduce_$_state_machine__27387__auto____1;
return cljs$core$async$reduce_$_state_machine__27387__auto__;
})()
;})(switch__27386__auto__,c__27451__auto__))
})();
var state__27453__auto__ = (function (){var statearr_30600 = f__27452__auto__.call(null);
(statearr_30600[cljs.core.async.impl.ioc_helpers.USER_START_IDX] = c__27451__auto__);

return statearr_30600;
})();
return cljs.core.async.impl.ioc_helpers.run_state_machine_wrapped.call(null,state__27453__auto__);
});})(c__27451__auto__))
);

return c__27451__auto__;
});
/**
 * Puts the contents of coll into the supplied channel.
 * 
 *   By default the channel will be closed after the items are copied,
 *   but can be determined by the close? parameter.
 * 
 *   Returns a channel which will close after the items are copied.
 */
cljs.core.async.onto_chan = (function cljs$core$async$onto_chan(var_args){
var args30613 = [];
var len__25999__auto___30665 = arguments.length;
var i__26000__auto___30666 = (0);
while(true){
if((i__26000__auto___30666 < len__25999__auto___30665)){
args30613.push((arguments[i__26000__auto___30666]));

var G__30667 = (i__26000__auto___30666 + (1));
i__26000__auto___30666 = G__30667;
continue;
} else {
}
break;
}

var G__30615 = args30613.length;
switch (G__30615) {
case 2:
return cljs.core.async.onto_chan.cljs$core$IFn$_invoke$arity$2((arguments[(0)]),(arguments[(1)]));

break;
case 3:
return cljs.core.async.onto_chan.cljs$core$IFn$_invoke$arity$3((arguments[(0)]),(arguments[(1)]),(arguments[(2)]));

break;
default:
throw (new Error([cljs.core.str("Invalid arity: "),cljs.core.str(args30613.length)].join('')));

}
});

cljs.core.async.onto_chan.cljs$core$IFn$_invoke$arity$2 = (function (ch,coll){
return cljs.core.async.onto_chan.call(null,ch,coll,true);
});

cljs.core.async.onto_chan.cljs$core$IFn$_invoke$arity$3 = (function (ch,coll,close_QMARK_){
var c__27451__auto__ = cljs.core.async.chan.call(null,(1));
cljs.core.async.impl.dispatch.run.call(null,((function (c__27451__auto__){
return (function (){
var f__27452__auto__ = (function (){var switch__27386__auto__ = ((function (c__27451__auto__){
return (function (state_30640){
var state_val_30641 = (state_30640[(1)]);
if((state_val_30641 === (7))){
var inst_30622 = (state_30640[(2)]);
var state_30640__$1 = state_30640;
var statearr_30642_30669 = state_30640__$1;
(statearr_30642_30669[(2)] = inst_30622);

(statearr_30642_30669[(1)] = (6));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_30641 === (1))){
var inst_30616 = cljs.core.seq.call(null,coll);
var inst_30617 = inst_30616;
var state_30640__$1 = (function (){var statearr_30643 = state_30640;
(statearr_30643[(7)] = inst_30617);

return statearr_30643;
})();
var statearr_30644_30670 = state_30640__$1;
(statearr_30644_30670[(2)] = null);

(statearr_30644_30670[(1)] = (2));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_30641 === (4))){
var inst_30617 = (state_30640[(7)]);
var inst_30620 = cljs.core.first.call(null,inst_30617);
var state_30640__$1 = state_30640;
return cljs.core.async.impl.ioc_helpers.put_BANG_.call(null,state_30640__$1,(7),ch,inst_30620);
} else {
if((state_val_30641 === (13))){
var inst_30634 = (state_30640[(2)]);
var state_30640__$1 = state_30640;
var statearr_30645_30671 = state_30640__$1;
(statearr_30645_30671[(2)] = inst_30634);

(statearr_30645_30671[(1)] = (10));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_30641 === (6))){
var inst_30625 = (state_30640[(2)]);
var state_30640__$1 = state_30640;
if(cljs.core.truth_(inst_30625)){
var statearr_30646_30672 = state_30640__$1;
(statearr_30646_30672[(1)] = (8));

} else {
var statearr_30647_30673 = state_30640__$1;
(statearr_30647_30673[(1)] = (9));

}

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_30641 === (3))){
var inst_30638 = (state_30640[(2)]);
var state_30640__$1 = state_30640;
return cljs.core.async.impl.ioc_helpers.return_chan.call(null,state_30640__$1,inst_30638);
} else {
if((state_val_30641 === (12))){
var state_30640__$1 = state_30640;
var statearr_30648_30674 = state_30640__$1;
(statearr_30648_30674[(2)] = null);

(statearr_30648_30674[(1)] = (13));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_30641 === (2))){
var inst_30617 = (state_30640[(7)]);
var state_30640__$1 = state_30640;
if(cljs.core.truth_(inst_30617)){
var statearr_30649_30675 = state_30640__$1;
(statearr_30649_30675[(1)] = (4));

} else {
var statearr_30650_30676 = state_30640__$1;
(statearr_30650_30676[(1)] = (5));

}

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_30641 === (11))){
var inst_30631 = cljs.core.async.close_BANG_.call(null,ch);
var state_30640__$1 = state_30640;
var statearr_30651_30677 = state_30640__$1;
(statearr_30651_30677[(2)] = inst_30631);

(statearr_30651_30677[(1)] = (13));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_30641 === (9))){
var state_30640__$1 = state_30640;
if(cljs.core.truth_(close_QMARK_)){
var statearr_30652_30678 = state_30640__$1;
(statearr_30652_30678[(1)] = (11));

} else {
var statearr_30653_30679 = state_30640__$1;
(statearr_30653_30679[(1)] = (12));

}

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_30641 === (5))){
var inst_30617 = (state_30640[(7)]);
var state_30640__$1 = state_30640;
var statearr_30654_30680 = state_30640__$1;
(statearr_30654_30680[(2)] = inst_30617);

(statearr_30654_30680[(1)] = (6));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_30641 === (10))){
var inst_30636 = (state_30640[(2)]);
var state_30640__$1 = state_30640;
var statearr_30655_30681 = state_30640__$1;
(statearr_30655_30681[(2)] = inst_30636);

(statearr_30655_30681[(1)] = (3));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_30641 === (8))){
var inst_30617 = (state_30640[(7)]);
var inst_30627 = cljs.core.next.call(null,inst_30617);
var inst_30617__$1 = inst_30627;
var state_30640__$1 = (function (){var statearr_30656 = state_30640;
(statearr_30656[(7)] = inst_30617__$1);

return statearr_30656;
})();
var statearr_30657_30682 = state_30640__$1;
(statearr_30657_30682[(2)] = null);

(statearr_30657_30682[(1)] = (2));


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
});})(c__27451__auto__))
;
return ((function (switch__27386__auto__,c__27451__auto__){
return (function() {
var cljs$core$async$state_machine__27387__auto__ = null;
var cljs$core$async$state_machine__27387__auto____0 = (function (){
var statearr_30661 = [null,null,null,null,null,null,null,null];
(statearr_30661[(0)] = cljs$core$async$state_machine__27387__auto__);

(statearr_30661[(1)] = (1));

return statearr_30661;
});
var cljs$core$async$state_machine__27387__auto____1 = (function (state_30640){
while(true){
var ret_value__27388__auto__ = (function (){try{while(true){
var result__27389__auto__ = switch__27386__auto__.call(null,state_30640);
if(cljs.core.keyword_identical_QMARK_.call(null,result__27389__auto__,new cljs.core.Keyword(null,"recur","recur",-437573268))){
continue;
} else {
return result__27389__auto__;
}
break;
}
}catch (e30662){if((e30662 instanceof Object)){
var ex__27390__auto__ = e30662;
var statearr_30663_30683 = state_30640;
(statearr_30663_30683[(5)] = ex__27390__auto__);


cljs.core.async.impl.ioc_helpers.process_exception.call(null,state_30640);

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
throw e30662;

}
}})();
if(cljs.core.keyword_identical_QMARK_.call(null,ret_value__27388__auto__,new cljs.core.Keyword(null,"recur","recur",-437573268))){
var G__30684 = state_30640;
state_30640 = G__30684;
continue;
} else {
return ret_value__27388__auto__;
}
break;
}
});
cljs$core$async$state_machine__27387__auto__ = function(state_30640){
switch(arguments.length){
case 0:
return cljs$core$async$state_machine__27387__auto____0.call(this);
case 1:
return cljs$core$async$state_machine__27387__auto____1.call(this,state_30640);
}
throw(new Error('Invalid arity: ' + arguments.length));
};
cljs$core$async$state_machine__27387__auto__.cljs$core$IFn$_invoke$arity$0 = cljs$core$async$state_machine__27387__auto____0;
cljs$core$async$state_machine__27387__auto__.cljs$core$IFn$_invoke$arity$1 = cljs$core$async$state_machine__27387__auto____1;
return cljs$core$async$state_machine__27387__auto__;
})()
;})(switch__27386__auto__,c__27451__auto__))
})();
var state__27453__auto__ = (function (){var statearr_30664 = f__27452__auto__.call(null);
(statearr_30664[cljs.core.async.impl.ioc_helpers.USER_START_IDX] = c__27451__auto__);

return statearr_30664;
})();
return cljs.core.async.impl.ioc_helpers.run_state_machine_wrapped.call(null,state__27453__auto__);
});})(c__27451__auto__))
);

return c__27451__auto__;
});

cljs.core.async.onto_chan.cljs$lang$maxFixedArity = 3;
/**
 * Creates and returns a channel which contains the contents of coll,
 *   closing when exhausted.
 */
cljs.core.async.to_chan = (function cljs$core$async$to_chan(coll){
var ch = cljs.core.async.chan.call(null,cljs.core.bounded_count.call(null,(100),coll));
cljs.core.async.onto_chan.call(null,ch,coll);

return ch;
});

/**
 * @interface
 */
cljs.core.async.Mux = function(){};

cljs.core.async.muxch_STAR_ = (function cljs$core$async$muxch_STAR_(_){
if((!((_ == null))) && (!((_.cljs$core$async$Mux$muxch_STAR_$arity$1 == null)))){
return _.cljs$core$async$Mux$muxch_STAR_$arity$1(_);
} else {
var x__25596__auto__ = (((_ == null))?null:_);
var m__25597__auto__ = (cljs.core.async.muxch_STAR_[goog.typeOf(x__25596__auto__)]);
if(!((m__25597__auto__ == null))){
return m__25597__auto__.call(null,_);
} else {
var m__25597__auto____$1 = (cljs.core.async.muxch_STAR_["_"]);
if(!((m__25597__auto____$1 == null))){
return m__25597__auto____$1.call(null,_);
} else {
throw cljs.core.missing_protocol.call(null,"Mux.muxch*",_);
}
}
}
});


/**
 * @interface
 */
cljs.core.async.Mult = function(){};

cljs.core.async.tap_STAR_ = (function cljs$core$async$tap_STAR_(m,ch,close_QMARK_){
if((!((m == null))) && (!((m.cljs$core$async$Mult$tap_STAR_$arity$3 == null)))){
return m.cljs$core$async$Mult$tap_STAR_$arity$3(m,ch,close_QMARK_);
} else {
var x__25596__auto__ = (((m == null))?null:m);
var m__25597__auto__ = (cljs.core.async.tap_STAR_[goog.typeOf(x__25596__auto__)]);
if(!((m__25597__auto__ == null))){
return m__25597__auto__.call(null,m,ch,close_QMARK_);
} else {
var m__25597__auto____$1 = (cljs.core.async.tap_STAR_["_"]);
if(!((m__25597__auto____$1 == null))){
return m__25597__auto____$1.call(null,m,ch,close_QMARK_);
} else {
throw cljs.core.missing_protocol.call(null,"Mult.tap*",m);
}
}
}
});

cljs.core.async.untap_STAR_ = (function cljs$core$async$untap_STAR_(m,ch){
if((!((m == null))) && (!((m.cljs$core$async$Mult$untap_STAR_$arity$2 == null)))){
return m.cljs$core$async$Mult$untap_STAR_$arity$2(m,ch);
} else {
var x__25596__auto__ = (((m == null))?null:m);
var m__25597__auto__ = (cljs.core.async.untap_STAR_[goog.typeOf(x__25596__auto__)]);
if(!((m__25597__auto__ == null))){
return m__25597__auto__.call(null,m,ch);
} else {
var m__25597__auto____$1 = (cljs.core.async.untap_STAR_["_"]);
if(!((m__25597__auto____$1 == null))){
return m__25597__auto____$1.call(null,m,ch);
} else {
throw cljs.core.missing_protocol.call(null,"Mult.untap*",m);
}
}
}
});

cljs.core.async.untap_all_STAR_ = (function cljs$core$async$untap_all_STAR_(m){
if((!((m == null))) && (!((m.cljs$core$async$Mult$untap_all_STAR_$arity$1 == null)))){
return m.cljs$core$async$Mult$untap_all_STAR_$arity$1(m);
} else {
var x__25596__auto__ = (((m == null))?null:m);
var m__25597__auto__ = (cljs.core.async.untap_all_STAR_[goog.typeOf(x__25596__auto__)]);
if(!((m__25597__auto__ == null))){
return m__25597__auto__.call(null,m);
} else {
var m__25597__auto____$1 = (cljs.core.async.untap_all_STAR_["_"]);
if(!((m__25597__auto____$1 == null))){
return m__25597__auto____$1.call(null,m);
} else {
throw cljs.core.missing_protocol.call(null,"Mult.untap-all*",m);
}
}
}
});

/**
 * Creates and returns a mult(iple) of the supplied channel. Channels
 *   containing copies of the channel can be created with 'tap', and
 *   detached with 'untap'.
 * 
 *   Each item is distributed to all taps in parallel and synchronously,
 *   i.e. each tap must accept before the next item is distributed. Use
 *   buffering/windowing to prevent slow taps from holding up the mult.
 * 
 *   Items received when there are no taps get dropped.
 * 
 *   If a tap puts to a closed channel, it will be removed from the mult.
 */
cljs.core.async.mult = (function cljs$core$async$mult(ch){
var cs = cljs.core.atom.call(null,cljs.core.PersistentArrayMap.EMPTY);
var m = (function (){
if(typeof cljs.core.async.t_cljs$core$async30906 !== 'undefined'){
} else {

/**
* @constructor
 * @implements {cljs.core.async.Mult}
 * @implements {cljs.core.IMeta}
 * @implements {cljs.core.async.Mux}
 * @implements {cljs.core.IWithMeta}
*/
cljs.core.async.t_cljs$core$async30906 = (function (mult,ch,cs,meta30907){
this.mult = mult;
this.ch = ch;
this.cs = cs;
this.meta30907 = meta30907;
this.cljs$lang$protocol_mask$partition0$ = 393216;
this.cljs$lang$protocol_mask$partition1$ = 0;
})
cljs.core.async.t_cljs$core$async30906.prototype.cljs$core$IWithMeta$_with_meta$arity$2 = ((function (cs){
return (function (_30908,meta30907__$1){
var self__ = this;
var _30908__$1 = this;
return (new cljs.core.async.t_cljs$core$async30906(self__.mult,self__.ch,self__.cs,meta30907__$1));
});})(cs))
;

cljs.core.async.t_cljs$core$async30906.prototype.cljs$core$IMeta$_meta$arity$1 = ((function (cs){
return (function (_30908){
var self__ = this;
var _30908__$1 = this;
return self__.meta30907;
});})(cs))
;

cljs.core.async.t_cljs$core$async30906.prototype.cljs$core$async$Mux$ = true;

cljs.core.async.t_cljs$core$async30906.prototype.cljs$core$async$Mux$muxch_STAR_$arity$1 = ((function (cs){
return (function (_){
var self__ = this;
var ___$1 = this;
return self__.ch;
});})(cs))
;

cljs.core.async.t_cljs$core$async30906.prototype.cljs$core$async$Mult$ = true;

cljs.core.async.t_cljs$core$async30906.prototype.cljs$core$async$Mult$tap_STAR_$arity$3 = ((function (cs){
return (function (_,ch__$1,close_QMARK_){
var self__ = this;
var ___$1 = this;
cljs.core.swap_BANG_.call(null,self__.cs,cljs.core.assoc,ch__$1,close_QMARK_);

return null;
});})(cs))
;

cljs.core.async.t_cljs$core$async30906.prototype.cljs$core$async$Mult$untap_STAR_$arity$2 = ((function (cs){
return (function (_,ch__$1){
var self__ = this;
var ___$1 = this;
cljs.core.swap_BANG_.call(null,self__.cs,cljs.core.dissoc,ch__$1);

return null;
});})(cs))
;

cljs.core.async.t_cljs$core$async30906.prototype.cljs$core$async$Mult$untap_all_STAR_$arity$1 = ((function (cs){
return (function (_){
var self__ = this;
var ___$1 = this;
cljs.core.reset_BANG_.call(null,self__.cs,cljs.core.PersistentArrayMap.EMPTY);

return null;
});})(cs))
;

cljs.core.async.t_cljs$core$async30906.getBasis = ((function (cs){
return (function (){
return new cljs.core.PersistentVector(null, 4, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.with_meta(new cljs.core.Symbol(null,"mult","mult",-1187640995,null),new cljs.core.PersistentArrayMap(null, 2, [new cljs.core.Keyword(null,"arglists","arglists",1661989754),cljs.core.list(new cljs.core.Symbol(null,"quote","quote",1377916282,null),cljs.core.list(new cljs.core.PersistentVector(null, 1, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Symbol(null,"ch","ch",1085813622,null)], null))),new cljs.core.Keyword(null,"doc","doc",1913296891),"Creates and returns a mult(iple) of the supplied channel. Channels\n  containing copies of the channel can be created with 'tap', and\n  detached with 'untap'.\n\n  Each item is distributed to all taps in parallel and synchronously,\n  i.e. each tap must accept before the next item is distributed. Use\n  buffering/windowing to prevent slow taps from holding up the mult.\n\n  Items received when there are no taps get dropped.\n\n  If a tap puts to a closed channel, it will be removed from the mult."], null)),new cljs.core.Symbol(null,"ch","ch",1085813622,null),new cljs.core.Symbol(null,"cs","cs",-117024463,null),new cljs.core.Symbol(null,"meta30907","meta30907",841899328,null)], null);
});})(cs))
;

cljs.core.async.t_cljs$core$async30906.cljs$lang$type = true;

cljs.core.async.t_cljs$core$async30906.cljs$lang$ctorStr = "cljs.core.async/t_cljs$core$async30906";

cljs.core.async.t_cljs$core$async30906.cljs$lang$ctorPrWriter = ((function (cs){
return (function (this__25539__auto__,writer__25540__auto__,opt__25541__auto__){
return cljs.core._write.call(null,writer__25540__auto__,"cljs.core.async/t_cljs$core$async30906");
});})(cs))
;

cljs.core.async.__GT_t_cljs$core$async30906 = ((function (cs){
return (function cljs$core$async$mult_$___GT_t_cljs$core$async30906(mult__$1,ch__$1,cs__$1,meta30907){
return (new cljs.core.async.t_cljs$core$async30906(mult__$1,ch__$1,cs__$1,meta30907));
});})(cs))
;

}

return (new cljs.core.async.t_cljs$core$async30906(cljs$core$async$mult,ch,cs,cljs.core.PersistentArrayMap.EMPTY));
})()
;
var dchan = cljs.core.async.chan.call(null,(1));
var dctr = cljs.core.atom.call(null,null);
var done = ((function (cs,m,dchan,dctr){
return (function (_){
if((cljs.core.swap_BANG_.call(null,dctr,cljs.core.dec) === (0))){
return cljs.core.async.put_BANG_.call(null,dchan,true);
} else {
return null;
}
});})(cs,m,dchan,dctr))
;
var c__27451__auto___31127 = cljs.core.async.chan.call(null,(1));
cljs.core.async.impl.dispatch.run.call(null,((function (c__27451__auto___31127,cs,m,dchan,dctr,done){
return (function (){
var f__27452__auto__ = (function (){var switch__27386__auto__ = ((function (c__27451__auto___31127,cs,m,dchan,dctr,done){
return (function (state_31039){
var state_val_31040 = (state_31039[(1)]);
if((state_val_31040 === (7))){
var inst_31035 = (state_31039[(2)]);
var state_31039__$1 = state_31039;
var statearr_31041_31128 = state_31039__$1;
(statearr_31041_31128[(2)] = inst_31035);

(statearr_31041_31128[(1)] = (3));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31040 === (20))){
var inst_30940 = (state_31039[(7)]);
var inst_30950 = cljs.core.first.call(null,inst_30940);
var inst_30951 = cljs.core.nth.call(null,inst_30950,(0),null);
var inst_30952 = cljs.core.nth.call(null,inst_30950,(1),null);
var state_31039__$1 = (function (){var statearr_31042 = state_31039;
(statearr_31042[(8)] = inst_30951);

return statearr_31042;
})();
if(cljs.core.truth_(inst_30952)){
var statearr_31043_31129 = state_31039__$1;
(statearr_31043_31129[(1)] = (22));

} else {
var statearr_31044_31130 = state_31039__$1;
(statearr_31044_31130[(1)] = (23));

}

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31040 === (27))){
var inst_30911 = (state_31039[(9)]);
var inst_30980 = (state_31039[(10)]);
var inst_30982 = (state_31039[(11)]);
var inst_30987 = (state_31039[(12)]);
var inst_30987__$1 = cljs.core._nth.call(null,inst_30980,inst_30982);
var inst_30988 = cljs.core.async.put_BANG_.call(null,inst_30987__$1,inst_30911,done);
var state_31039__$1 = (function (){var statearr_31045 = state_31039;
(statearr_31045[(12)] = inst_30987__$1);

return statearr_31045;
})();
if(cljs.core.truth_(inst_30988)){
var statearr_31046_31131 = state_31039__$1;
(statearr_31046_31131[(1)] = (30));

} else {
var statearr_31047_31132 = state_31039__$1;
(statearr_31047_31132[(1)] = (31));

}

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31040 === (1))){
var state_31039__$1 = state_31039;
var statearr_31048_31133 = state_31039__$1;
(statearr_31048_31133[(2)] = null);

(statearr_31048_31133[(1)] = (2));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31040 === (24))){
var inst_30940 = (state_31039[(7)]);
var inst_30957 = (state_31039[(2)]);
var inst_30958 = cljs.core.next.call(null,inst_30940);
var inst_30920 = inst_30958;
var inst_30921 = null;
var inst_30922 = (0);
var inst_30923 = (0);
var state_31039__$1 = (function (){var statearr_31049 = state_31039;
(statearr_31049[(13)] = inst_30920);

(statearr_31049[(14)] = inst_30921);

(statearr_31049[(15)] = inst_30922);

(statearr_31049[(16)] = inst_30957);

(statearr_31049[(17)] = inst_30923);

return statearr_31049;
})();
var statearr_31050_31134 = state_31039__$1;
(statearr_31050_31134[(2)] = null);

(statearr_31050_31134[(1)] = (8));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31040 === (39))){
var state_31039__$1 = state_31039;
var statearr_31054_31135 = state_31039__$1;
(statearr_31054_31135[(2)] = null);

(statearr_31054_31135[(1)] = (41));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31040 === (4))){
var inst_30911 = (state_31039[(9)]);
var inst_30911__$1 = (state_31039[(2)]);
var inst_30912 = (inst_30911__$1 == null);
var state_31039__$1 = (function (){var statearr_31055 = state_31039;
(statearr_31055[(9)] = inst_30911__$1);

return statearr_31055;
})();
if(cljs.core.truth_(inst_30912)){
var statearr_31056_31136 = state_31039__$1;
(statearr_31056_31136[(1)] = (5));

} else {
var statearr_31057_31137 = state_31039__$1;
(statearr_31057_31137[(1)] = (6));

}

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31040 === (15))){
var inst_30920 = (state_31039[(13)]);
var inst_30921 = (state_31039[(14)]);
var inst_30922 = (state_31039[(15)]);
var inst_30923 = (state_31039[(17)]);
var inst_30936 = (state_31039[(2)]);
var inst_30937 = (inst_30923 + (1));
var tmp31051 = inst_30920;
var tmp31052 = inst_30921;
var tmp31053 = inst_30922;
var inst_30920__$1 = tmp31051;
var inst_30921__$1 = tmp31052;
var inst_30922__$1 = tmp31053;
var inst_30923__$1 = inst_30937;
var state_31039__$1 = (function (){var statearr_31058 = state_31039;
(statearr_31058[(13)] = inst_30920__$1);

(statearr_31058[(14)] = inst_30921__$1);

(statearr_31058[(15)] = inst_30922__$1);

(statearr_31058[(18)] = inst_30936);

(statearr_31058[(17)] = inst_30923__$1);

return statearr_31058;
})();
var statearr_31059_31138 = state_31039__$1;
(statearr_31059_31138[(2)] = null);

(statearr_31059_31138[(1)] = (8));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31040 === (21))){
var inst_30961 = (state_31039[(2)]);
var state_31039__$1 = state_31039;
var statearr_31063_31139 = state_31039__$1;
(statearr_31063_31139[(2)] = inst_30961);

(statearr_31063_31139[(1)] = (18));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31040 === (31))){
var inst_30987 = (state_31039[(12)]);
var inst_30991 = done.call(null,null);
var inst_30992 = cljs.core.async.untap_STAR_.call(null,m,inst_30987);
var state_31039__$1 = (function (){var statearr_31064 = state_31039;
(statearr_31064[(19)] = inst_30991);

return statearr_31064;
})();
var statearr_31065_31140 = state_31039__$1;
(statearr_31065_31140[(2)] = inst_30992);

(statearr_31065_31140[(1)] = (32));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31040 === (32))){
var inst_30981 = (state_31039[(20)]);
var inst_30980 = (state_31039[(10)]);
var inst_30982 = (state_31039[(11)]);
var inst_30979 = (state_31039[(21)]);
var inst_30994 = (state_31039[(2)]);
var inst_30995 = (inst_30982 + (1));
var tmp31060 = inst_30981;
var tmp31061 = inst_30980;
var tmp31062 = inst_30979;
var inst_30979__$1 = tmp31062;
var inst_30980__$1 = tmp31061;
var inst_30981__$1 = tmp31060;
var inst_30982__$1 = inst_30995;
var state_31039__$1 = (function (){var statearr_31066 = state_31039;
(statearr_31066[(20)] = inst_30981__$1);

(statearr_31066[(10)] = inst_30980__$1);

(statearr_31066[(22)] = inst_30994);

(statearr_31066[(11)] = inst_30982__$1);

(statearr_31066[(21)] = inst_30979__$1);

return statearr_31066;
})();
var statearr_31067_31141 = state_31039__$1;
(statearr_31067_31141[(2)] = null);

(statearr_31067_31141[(1)] = (25));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31040 === (40))){
var inst_31007 = (state_31039[(23)]);
var inst_31011 = done.call(null,null);
var inst_31012 = cljs.core.async.untap_STAR_.call(null,m,inst_31007);
var state_31039__$1 = (function (){var statearr_31068 = state_31039;
(statearr_31068[(24)] = inst_31011);

return statearr_31068;
})();
var statearr_31069_31142 = state_31039__$1;
(statearr_31069_31142[(2)] = inst_31012);

(statearr_31069_31142[(1)] = (41));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31040 === (33))){
var inst_30998 = (state_31039[(25)]);
var inst_31000 = cljs.core.chunked_seq_QMARK_.call(null,inst_30998);
var state_31039__$1 = state_31039;
if(inst_31000){
var statearr_31070_31143 = state_31039__$1;
(statearr_31070_31143[(1)] = (36));

} else {
var statearr_31071_31144 = state_31039__$1;
(statearr_31071_31144[(1)] = (37));

}

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31040 === (13))){
var inst_30930 = (state_31039[(26)]);
var inst_30933 = cljs.core.async.close_BANG_.call(null,inst_30930);
var state_31039__$1 = state_31039;
var statearr_31072_31145 = state_31039__$1;
(statearr_31072_31145[(2)] = inst_30933);

(statearr_31072_31145[(1)] = (15));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31040 === (22))){
var inst_30951 = (state_31039[(8)]);
var inst_30954 = cljs.core.async.close_BANG_.call(null,inst_30951);
var state_31039__$1 = state_31039;
var statearr_31073_31146 = state_31039__$1;
(statearr_31073_31146[(2)] = inst_30954);

(statearr_31073_31146[(1)] = (24));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31040 === (36))){
var inst_30998 = (state_31039[(25)]);
var inst_31002 = cljs.core.chunk_first.call(null,inst_30998);
var inst_31003 = cljs.core.chunk_rest.call(null,inst_30998);
var inst_31004 = cljs.core.count.call(null,inst_31002);
var inst_30979 = inst_31003;
var inst_30980 = inst_31002;
var inst_30981 = inst_31004;
var inst_30982 = (0);
var state_31039__$1 = (function (){var statearr_31074 = state_31039;
(statearr_31074[(20)] = inst_30981);

(statearr_31074[(10)] = inst_30980);

(statearr_31074[(11)] = inst_30982);

(statearr_31074[(21)] = inst_30979);

return statearr_31074;
})();
var statearr_31075_31147 = state_31039__$1;
(statearr_31075_31147[(2)] = null);

(statearr_31075_31147[(1)] = (25));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31040 === (41))){
var inst_30998 = (state_31039[(25)]);
var inst_31014 = (state_31039[(2)]);
var inst_31015 = cljs.core.next.call(null,inst_30998);
var inst_30979 = inst_31015;
var inst_30980 = null;
var inst_30981 = (0);
var inst_30982 = (0);
var state_31039__$1 = (function (){var statearr_31076 = state_31039;
(statearr_31076[(20)] = inst_30981);

(statearr_31076[(10)] = inst_30980);

(statearr_31076[(27)] = inst_31014);

(statearr_31076[(11)] = inst_30982);

(statearr_31076[(21)] = inst_30979);

return statearr_31076;
})();
var statearr_31077_31148 = state_31039__$1;
(statearr_31077_31148[(2)] = null);

(statearr_31077_31148[(1)] = (25));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31040 === (43))){
var state_31039__$1 = state_31039;
var statearr_31078_31149 = state_31039__$1;
(statearr_31078_31149[(2)] = null);

(statearr_31078_31149[(1)] = (44));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31040 === (29))){
var inst_31023 = (state_31039[(2)]);
var state_31039__$1 = state_31039;
var statearr_31079_31150 = state_31039__$1;
(statearr_31079_31150[(2)] = inst_31023);

(statearr_31079_31150[(1)] = (26));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31040 === (44))){
var inst_31032 = (state_31039[(2)]);
var state_31039__$1 = (function (){var statearr_31080 = state_31039;
(statearr_31080[(28)] = inst_31032);

return statearr_31080;
})();
var statearr_31081_31151 = state_31039__$1;
(statearr_31081_31151[(2)] = null);

(statearr_31081_31151[(1)] = (2));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31040 === (6))){
var inst_30971 = (state_31039[(29)]);
var inst_30970 = cljs.core.deref.call(null,cs);
var inst_30971__$1 = cljs.core.keys.call(null,inst_30970);
var inst_30972 = cljs.core.count.call(null,inst_30971__$1);
var inst_30973 = cljs.core.reset_BANG_.call(null,dctr,inst_30972);
var inst_30978 = cljs.core.seq.call(null,inst_30971__$1);
var inst_30979 = inst_30978;
var inst_30980 = null;
var inst_30981 = (0);
var inst_30982 = (0);
var state_31039__$1 = (function (){var statearr_31082 = state_31039;
(statearr_31082[(20)] = inst_30981);

(statearr_31082[(10)] = inst_30980);

(statearr_31082[(11)] = inst_30982);

(statearr_31082[(21)] = inst_30979);

(statearr_31082[(30)] = inst_30973);

(statearr_31082[(29)] = inst_30971__$1);

return statearr_31082;
})();
var statearr_31083_31152 = state_31039__$1;
(statearr_31083_31152[(2)] = null);

(statearr_31083_31152[(1)] = (25));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31040 === (28))){
var inst_30979 = (state_31039[(21)]);
var inst_30998 = (state_31039[(25)]);
var inst_30998__$1 = cljs.core.seq.call(null,inst_30979);
var state_31039__$1 = (function (){var statearr_31084 = state_31039;
(statearr_31084[(25)] = inst_30998__$1);

return statearr_31084;
})();
if(inst_30998__$1){
var statearr_31085_31153 = state_31039__$1;
(statearr_31085_31153[(1)] = (33));

} else {
var statearr_31086_31154 = state_31039__$1;
(statearr_31086_31154[(1)] = (34));

}

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31040 === (25))){
var inst_30981 = (state_31039[(20)]);
var inst_30982 = (state_31039[(11)]);
var inst_30984 = (inst_30982 < inst_30981);
var inst_30985 = inst_30984;
var state_31039__$1 = state_31039;
if(cljs.core.truth_(inst_30985)){
var statearr_31087_31155 = state_31039__$1;
(statearr_31087_31155[(1)] = (27));

} else {
var statearr_31088_31156 = state_31039__$1;
(statearr_31088_31156[(1)] = (28));

}

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31040 === (34))){
var state_31039__$1 = state_31039;
var statearr_31089_31157 = state_31039__$1;
(statearr_31089_31157[(2)] = null);

(statearr_31089_31157[(1)] = (35));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31040 === (17))){
var state_31039__$1 = state_31039;
var statearr_31090_31158 = state_31039__$1;
(statearr_31090_31158[(2)] = null);

(statearr_31090_31158[(1)] = (18));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31040 === (3))){
var inst_31037 = (state_31039[(2)]);
var state_31039__$1 = state_31039;
return cljs.core.async.impl.ioc_helpers.return_chan.call(null,state_31039__$1,inst_31037);
} else {
if((state_val_31040 === (12))){
var inst_30966 = (state_31039[(2)]);
var state_31039__$1 = state_31039;
var statearr_31091_31159 = state_31039__$1;
(statearr_31091_31159[(2)] = inst_30966);

(statearr_31091_31159[(1)] = (9));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31040 === (2))){
var state_31039__$1 = state_31039;
return cljs.core.async.impl.ioc_helpers.take_BANG_.call(null,state_31039__$1,(4),ch);
} else {
if((state_val_31040 === (23))){
var state_31039__$1 = state_31039;
var statearr_31092_31160 = state_31039__$1;
(statearr_31092_31160[(2)] = null);

(statearr_31092_31160[(1)] = (24));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31040 === (35))){
var inst_31021 = (state_31039[(2)]);
var state_31039__$1 = state_31039;
var statearr_31093_31161 = state_31039__$1;
(statearr_31093_31161[(2)] = inst_31021);

(statearr_31093_31161[(1)] = (29));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31040 === (19))){
var inst_30940 = (state_31039[(7)]);
var inst_30944 = cljs.core.chunk_first.call(null,inst_30940);
var inst_30945 = cljs.core.chunk_rest.call(null,inst_30940);
var inst_30946 = cljs.core.count.call(null,inst_30944);
var inst_30920 = inst_30945;
var inst_30921 = inst_30944;
var inst_30922 = inst_30946;
var inst_30923 = (0);
var state_31039__$1 = (function (){var statearr_31094 = state_31039;
(statearr_31094[(13)] = inst_30920);

(statearr_31094[(14)] = inst_30921);

(statearr_31094[(15)] = inst_30922);

(statearr_31094[(17)] = inst_30923);

return statearr_31094;
})();
var statearr_31095_31162 = state_31039__$1;
(statearr_31095_31162[(2)] = null);

(statearr_31095_31162[(1)] = (8));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31040 === (11))){
var inst_30920 = (state_31039[(13)]);
var inst_30940 = (state_31039[(7)]);
var inst_30940__$1 = cljs.core.seq.call(null,inst_30920);
var state_31039__$1 = (function (){var statearr_31096 = state_31039;
(statearr_31096[(7)] = inst_30940__$1);

return statearr_31096;
})();
if(inst_30940__$1){
var statearr_31097_31163 = state_31039__$1;
(statearr_31097_31163[(1)] = (16));

} else {
var statearr_31098_31164 = state_31039__$1;
(statearr_31098_31164[(1)] = (17));

}

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31040 === (9))){
var inst_30968 = (state_31039[(2)]);
var state_31039__$1 = state_31039;
var statearr_31099_31165 = state_31039__$1;
(statearr_31099_31165[(2)] = inst_30968);

(statearr_31099_31165[(1)] = (7));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31040 === (5))){
var inst_30918 = cljs.core.deref.call(null,cs);
var inst_30919 = cljs.core.seq.call(null,inst_30918);
var inst_30920 = inst_30919;
var inst_30921 = null;
var inst_30922 = (0);
var inst_30923 = (0);
var state_31039__$1 = (function (){var statearr_31100 = state_31039;
(statearr_31100[(13)] = inst_30920);

(statearr_31100[(14)] = inst_30921);

(statearr_31100[(15)] = inst_30922);

(statearr_31100[(17)] = inst_30923);

return statearr_31100;
})();
var statearr_31101_31166 = state_31039__$1;
(statearr_31101_31166[(2)] = null);

(statearr_31101_31166[(1)] = (8));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31040 === (14))){
var state_31039__$1 = state_31039;
var statearr_31102_31167 = state_31039__$1;
(statearr_31102_31167[(2)] = null);

(statearr_31102_31167[(1)] = (15));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31040 === (45))){
var inst_31029 = (state_31039[(2)]);
var state_31039__$1 = state_31039;
var statearr_31103_31168 = state_31039__$1;
(statearr_31103_31168[(2)] = inst_31029);

(statearr_31103_31168[(1)] = (44));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31040 === (26))){
var inst_30971 = (state_31039[(29)]);
var inst_31025 = (state_31039[(2)]);
var inst_31026 = cljs.core.seq.call(null,inst_30971);
var state_31039__$1 = (function (){var statearr_31104 = state_31039;
(statearr_31104[(31)] = inst_31025);

return statearr_31104;
})();
if(inst_31026){
var statearr_31105_31169 = state_31039__$1;
(statearr_31105_31169[(1)] = (42));

} else {
var statearr_31106_31170 = state_31039__$1;
(statearr_31106_31170[(1)] = (43));

}

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31040 === (16))){
var inst_30940 = (state_31039[(7)]);
var inst_30942 = cljs.core.chunked_seq_QMARK_.call(null,inst_30940);
var state_31039__$1 = state_31039;
if(inst_30942){
var statearr_31107_31171 = state_31039__$1;
(statearr_31107_31171[(1)] = (19));

} else {
var statearr_31108_31172 = state_31039__$1;
(statearr_31108_31172[(1)] = (20));

}

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31040 === (38))){
var inst_31018 = (state_31039[(2)]);
var state_31039__$1 = state_31039;
var statearr_31109_31173 = state_31039__$1;
(statearr_31109_31173[(2)] = inst_31018);

(statearr_31109_31173[(1)] = (35));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31040 === (30))){
var state_31039__$1 = state_31039;
var statearr_31110_31174 = state_31039__$1;
(statearr_31110_31174[(2)] = null);

(statearr_31110_31174[(1)] = (32));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31040 === (10))){
var inst_30921 = (state_31039[(14)]);
var inst_30923 = (state_31039[(17)]);
var inst_30929 = cljs.core._nth.call(null,inst_30921,inst_30923);
var inst_30930 = cljs.core.nth.call(null,inst_30929,(0),null);
var inst_30931 = cljs.core.nth.call(null,inst_30929,(1),null);
var state_31039__$1 = (function (){var statearr_31111 = state_31039;
(statearr_31111[(26)] = inst_30930);

return statearr_31111;
})();
if(cljs.core.truth_(inst_30931)){
var statearr_31112_31175 = state_31039__$1;
(statearr_31112_31175[(1)] = (13));

} else {
var statearr_31113_31176 = state_31039__$1;
(statearr_31113_31176[(1)] = (14));

}

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31040 === (18))){
var inst_30964 = (state_31039[(2)]);
var state_31039__$1 = state_31039;
var statearr_31114_31177 = state_31039__$1;
(statearr_31114_31177[(2)] = inst_30964);

(statearr_31114_31177[(1)] = (12));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31040 === (42))){
var state_31039__$1 = state_31039;
return cljs.core.async.impl.ioc_helpers.take_BANG_.call(null,state_31039__$1,(45),dchan);
} else {
if((state_val_31040 === (37))){
var inst_30911 = (state_31039[(9)]);
var inst_31007 = (state_31039[(23)]);
var inst_30998 = (state_31039[(25)]);
var inst_31007__$1 = cljs.core.first.call(null,inst_30998);
var inst_31008 = cljs.core.async.put_BANG_.call(null,inst_31007__$1,inst_30911,done);
var state_31039__$1 = (function (){var statearr_31115 = state_31039;
(statearr_31115[(23)] = inst_31007__$1);

return statearr_31115;
})();
if(cljs.core.truth_(inst_31008)){
var statearr_31116_31178 = state_31039__$1;
(statearr_31116_31178[(1)] = (39));

} else {
var statearr_31117_31179 = state_31039__$1;
(statearr_31117_31179[(1)] = (40));

}

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31040 === (8))){
var inst_30922 = (state_31039[(15)]);
var inst_30923 = (state_31039[(17)]);
var inst_30925 = (inst_30923 < inst_30922);
var inst_30926 = inst_30925;
var state_31039__$1 = state_31039;
if(cljs.core.truth_(inst_30926)){
var statearr_31118_31180 = state_31039__$1;
(statearr_31118_31180[(1)] = (10));

} else {
var statearr_31119_31181 = state_31039__$1;
(statearr_31119_31181[(1)] = (11));

}

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
});})(c__27451__auto___31127,cs,m,dchan,dctr,done))
;
return ((function (switch__27386__auto__,c__27451__auto___31127,cs,m,dchan,dctr,done){
return (function() {
var cljs$core$async$mult_$_state_machine__27387__auto__ = null;
var cljs$core$async$mult_$_state_machine__27387__auto____0 = (function (){
var statearr_31123 = [null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null];
(statearr_31123[(0)] = cljs$core$async$mult_$_state_machine__27387__auto__);

(statearr_31123[(1)] = (1));

return statearr_31123;
});
var cljs$core$async$mult_$_state_machine__27387__auto____1 = (function (state_31039){
while(true){
var ret_value__27388__auto__ = (function (){try{while(true){
var result__27389__auto__ = switch__27386__auto__.call(null,state_31039);
if(cljs.core.keyword_identical_QMARK_.call(null,result__27389__auto__,new cljs.core.Keyword(null,"recur","recur",-437573268))){
continue;
} else {
return result__27389__auto__;
}
break;
}
}catch (e31124){if((e31124 instanceof Object)){
var ex__27390__auto__ = e31124;
var statearr_31125_31182 = state_31039;
(statearr_31125_31182[(5)] = ex__27390__auto__);


cljs.core.async.impl.ioc_helpers.process_exception.call(null,state_31039);

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
throw e31124;

}
}})();
if(cljs.core.keyword_identical_QMARK_.call(null,ret_value__27388__auto__,new cljs.core.Keyword(null,"recur","recur",-437573268))){
var G__31183 = state_31039;
state_31039 = G__31183;
continue;
} else {
return ret_value__27388__auto__;
}
break;
}
});
cljs$core$async$mult_$_state_machine__27387__auto__ = function(state_31039){
switch(arguments.length){
case 0:
return cljs$core$async$mult_$_state_machine__27387__auto____0.call(this);
case 1:
return cljs$core$async$mult_$_state_machine__27387__auto____1.call(this,state_31039);
}
throw(new Error('Invalid arity: ' + arguments.length));
};
cljs$core$async$mult_$_state_machine__27387__auto__.cljs$core$IFn$_invoke$arity$0 = cljs$core$async$mult_$_state_machine__27387__auto____0;
cljs$core$async$mult_$_state_machine__27387__auto__.cljs$core$IFn$_invoke$arity$1 = cljs$core$async$mult_$_state_machine__27387__auto____1;
return cljs$core$async$mult_$_state_machine__27387__auto__;
})()
;})(switch__27386__auto__,c__27451__auto___31127,cs,m,dchan,dctr,done))
})();
var state__27453__auto__ = (function (){var statearr_31126 = f__27452__auto__.call(null);
(statearr_31126[cljs.core.async.impl.ioc_helpers.USER_START_IDX] = c__27451__auto___31127);

return statearr_31126;
})();
return cljs.core.async.impl.ioc_helpers.run_state_machine_wrapped.call(null,state__27453__auto__);
});})(c__27451__auto___31127,cs,m,dchan,dctr,done))
);


return m;
});
/**
 * Copies the mult source onto the supplied channel.
 * 
 *   By default the channel will be closed when the source closes,
 *   but can be determined by the close? parameter.
 */
cljs.core.async.tap = (function cljs$core$async$tap(var_args){
var args31184 = [];
var len__25999__auto___31187 = arguments.length;
var i__26000__auto___31188 = (0);
while(true){
if((i__26000__auto___31188 < len__25999__auto___31187)){
args31184.push((arguments[i__26000__auto___31188]));

var G__31189 = (i__26000__auto___31188 + (1));
i__26000__auto___31188 = G__31189;
continue;
} else {
}
break;
}

var G__31186 = args31184.length;
switch (G__31186) {
case 2:
return cljs.core.async.tap.cljs$core$IFn$_invoke$arity$2((arguments[(0)]),(arguments[(1)]));

break;
case 3:
return cljs.core.async.tap.cljs$core$IFn$_invoke$arity$3((arguments[(0)]),(arguments[(1)]),(arguments[(2)]));

break;
default:
throw (new Error([cljs.core.str("Invalid arity: "),cljs.core.str(args31184.length)].join('')));

}
});

cljs.core.async.tap.cljs$core$IFn$_invoke$arity$2 = (function (mult,ch){
return cljs.core.async.tap.call(null,mult,ch,true);
});

cljs.core.async.tap.cljs$core$IFn$_invoke$arity$3 = (function (mult,ch,close_QMARK_){
cljs.core.async.tap_STAR_.call(null,mult,ch,close_QMARK_);

return ch;
});

cljs.core.async.tap.cljs$lang$maxFixedArity = 3;
/**
 * Disconnects a target channel from a mult
 */
cljs.core.async.untap = (function cljs$core$async$untap(mult,ch){
return cljs.core.async.untap_STAR_.call(null,mult,ch);
});
/**
 * Disconnects all target channels from a mult
 */
cljs.core.async.untap_all = (function cljs$core$async$untap_all(mult){
return cljs.core.async.untap_all_STAR_.call(null,mult);
});

/**
 * @interface
 */
cljs.core.async.Mix = function(){};

cljs.core.async.admix_STAR_ = (function cljs$core$async$admix_STAR_(m,ch){
if((!((m == null))) && (!((m.cljs$core$async$Mix$admix_STAR_$arity$2 == null)))){
return m.cljs$core$async$Mix$admix_STAR_$arity$2(m,ch);
} else {
var x__25596__auto__ = (((m == null))?null:m);
var m__25597__auto__ = (cljs.core.async.admix_STAR_[goog.typeOf(x__25596__auto__)]);
if(!((m__25597__auto__ == null))){
return m__25597__auto__.call(null,m,ch);
} else {
var m__25597__auto____$1 = (cljs.core.async.admix_STAR_["_"]);
if(!((m__25597__auto____$1 == null))){
return m__25597__auto____$1.call(null,m,ch);
} else {
throw cljs.core.missing_protocol.call(null,"Mix.admix*",m);
}
}
}
});

cljs.core.async.unmix_STAR_ = (function cljs$core$async$unmix_STAR_(m,ch){
if((!((m == null))) && (!((m.cljs$core$async$Mix$unmix_STAR_$arity$2 == null)))){
return m.cljs$core$async$Mix$unmix_STAR_$arity$2(m,ch);
} else {
var x__25596__auto__ = (((m == null))?null:m);
var m__25597__auto__ = (cljs.core.async.unmix_STAR_[goog.typeOf(x__25596__auto__)]);
if(!((m__25597__auto__ == null))){
return m__25597__auto__.call(null,m,ch);
} else {
var m__25597__auto____$1 = (cljs.core.async.unmix_STAR_["_"]);
if(!((m__25597__auto____$1 == null))){
return m__25597__auto____$1.call(null,m,ch);
} else {
throw cljs.core.missing_protocol.call(null,"Mix.unmix*",m);
}
}
}
});

cljs.core.async.unmix_all_STAR_ = (function cljs$core$async$unmix_all_STAR_(m){
if((!((m == null))) && (!((m.cljs$core$async$Mix$unmix_all_STAR_$arity$1 == null)))){
return m.cljs$core$async$Mix$unmix_all_STAR_$arity$1(m);
} else {
var x__25596__auto__ = (((m == null))?null:m);
var m__25597__auto__ = (cljs.core.async.unmix_all_STAR_[goog.typeOf(x__25596__auto__)]);
if(!((m__25597__auto__ == null))){
return m__25597__auto__.call(null,m);
} else {
var m__25597__auto____$1 = (cljs.core.async.unmix_all_STAR_["_"]);
if(!((m__25597__auto____$1 == null))){
return m__25597__auto____$1.call(null,m);
} else {
throw cljs.core.missing_protocol.call(null,"Mix.unmix-all*",m);
}
}
}
});

cljs.core.async.toggle_STAR_ = (function cljs$core$async$toggle_STAR_(m,state_map){
if((!((m == null))) && (!((m.cljs$core$async$Mix$toggle_STAR_$arity$2 == null)))){
return m.cljs$core$async$Mix$toggle_STAR_$arity$2(m,state_map);
} else {
var x__25596__auto__ = (((m == null))?null:m);
var m__25597__auto__ = (cljs.core.async.toggle_STAR_[goog.typeOf(x__25596__auto__)]);
if(!((m__25597__auto__ == null))){
return m__25597__auto__.call(null,m,state_map);
} else {
var m__25597__auto____$1 = (cljs.core.async.toggle_STAR_["_"]);
if(!((m__25597__auto____$1 == null))){
return m__25597__auto____$1.call(null,m,state_map);
} else {
throw cljs.core.missing_protocol.call(null,"Mix.toggle*",m);
}
}
}
});

cljs.core.async.solo_mode_STAR_ = (function cljs$core$async$solo_mode_STAR_(m,mode){
if((!((m == null))) && (!((m.cljs$core$async$Mix$solo_mode_STAR_$arity$2 == null)))){
return m.cljs$core$async$Mix$solo_mode_STAR_$arity$2(m,mode);
} else {
var x__25596__auto__ = (((m == null))?null:m);
var m__25597__auto__ = (cljs.core.async.solo_mode_STAR_[goog.typeOf(x__25596__auto__)]);
if(!((m__25597__auto__ == null))){
return m__25597__auto__.call(null,m,mode);
} else {
var m__25597__auto____$1 = (cljs.core.async.solo_mode_STAR_["_"]);
if(!((m__25597__auto____$1 == null))){
return m__25597__auto____$1.call(null,m,mode);
} else {
throw cljs.core.missing_protocol.call(null,"Mix.solo-mode*",m);
}
}
}
});

cljs.core.async.ioc_alts_BANG_ = (function cljs$core$async$ioc_alts_BANG_(var_args){
var args__26006__auto__ = [];
var len__25999__auto___31201 = arguments.length;
var i__26000__auto___31202 = (0);
while(true){
if((i__26000__auto___31202 < len__25999__auto___31201)){
args__26006__auto__.push((arguments[i__26000__auto___31202]));

var G__31203 = (i__26000__auto___31202 + (1));
i__26000__auto___31202 = G__31203;
continue;
} else {
}
break;
}

var argseq__26007__auto__ = ((((3) < args__26006__auto__.length))?(new cljs.core.IndexedSeq(args__26006__auto__.slice((3)),(0))):null);
return cljs.core.async.ioc_alts_BANG_.cljs$core$IFn$_invoke$arity$variadic((arguments[(0)]),(arguments[(1)]),(arguments[(2)]),argseq__26007__auto__);
});

cljs.core.async.ioc_alts_BANG_.cljs$core$IFn$_invoke$arity$variadic = (function (state,cont_block,ports,p__31195){
var map__31196 = p__31195;
var map__31196__$1 = ((((!((map__31196 == null)))?((((map__31196.cljs$lang$protocol_mask$partition0$ & (64))) || (map__31196.cljs$core$ISeq$))?true:false):false))?cljs.core.apply.call(null,cljs.core.hash_map,map__31196):map__31196);
var opts = map__31196__$1;
var statearr_31198_31204 = state;
(statearr_31198_31204[cljs.core.async.impl.ioc_helpers.STATE_IDX] = cont_block);


var temp__4425__auto__ = cljs.core.async.do_alts.call(null,((function (map__31196,map__31196__$1,opts){
return (function (val){
var statearr_31199_31205 = state;
(statearr_31199_31205[cljs.core.async.impl.ioc_helpers.VALUE_IDX] = val);


return cljs.core.async.impl.ioc_helpers.run_state_machine_wrapped.call(null,state);
});})(map__31196,map__31196__$1,opts))
,ports,opts);
if(cljs.core.truth_(temp__4425__auto__)){
var cb = temp__4425__auto__;
var statearr_31200_31206 = state;
(statearr_31200_31206[cljs.core.async.impl.ioc_helpers.VALUE_IDX] = cljs.core.deref.call(null,cb));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
return null;
}
});

cljs.core.async.ioc_alts_BANG_.cljs$lang$maxFixedArity = (3);

cljs.core.async.ioc_alts_BANG_.cljs$lang$applyTo = (function (seq31191){
var G__31192 = cljs.core.first.call(null,seq31191);
var seq31191__$1 = cljs.core.next.call(null,seq31191);
var G__31193 = cljs.core.first.call(null,seq31191__$1);
var seq31191__$2 = cljs.core.next.call(null,seq31191__$1);
var G__31194 = cljs.core.first.call(null,seq31191__$2);
var seq31191__$3 = cljs.core.next.call(null,seq31191__$2);
return cljs.core.async.ioc_alts_BANG_.cljs$core$IFn$_invoke$arity$variadic(G__31192,G__31193,G__31194,seq31191__$3);
});
/**
 * Creates and returns a mix of one or more input channels which will
 *   be put on the supplied out channel. Input sources can be added to
 *   the mix with 'admix', and removed with 'unmix'. A mix supports
 *   soloing, muting and pausing multiple inputs atomically using
 *   'toggle', and can solo using either muting or pausing as determined
 *   by 'solo-mode'.
 * 
 *   Each channel can have zero or more boolean modes set via 'toggle':
 * 
 *   :solo - when true, only this (ond other soloed) channel(s) will appear
 *        in the mix output channel. :mute and :pause states of soloed
 *        channels are ignored. If solo-mode is :mute, non-soloed
 *        channels are muted, if :pause, non-soloed channels are
 *        paused.
 * 
 *   :mute - muted channels will have their contents consumed but not included in the mix
 *   :pause - paused channels will not have their contents consumed (and thus also not included in the mix)
 */
cljs.core.async.mix = (function cljs$core$async$mix(out){
var cs = cljs.core.atom.call(null,cljs.core.PersistentArrayMap.EMPTY);
var solo_modes = new cljs.core.PersistentHashSet(null, new cljs.core.PersistentArrayMap(null, 2, [new cljs.core.Keyword(null,"pause","pause",-2095325672),null,new cljs.core.Keyword(null,"mute","mute",1151223646),null], null), null);
var attrs = cljs.core.conj.call(null,solo_modes,new cljs.core.Keyword(null,"solo","solo",-316350075));
var solo_mode = cljs.core.atom.call(null,new cljs.core.Keyword(null,"mute","mute",1151223646));
var change = cljs.core.async.chan.call(null);
var changed = ((function (cs,solo_modes,attrs,solo_mode,change){
return (function (){
return cljs.core.async.put_BANG_.call(null,change,true);
});})(cs,solo_modes,attrs,solo_mode,change))
;
var pick = ((function (cs,solo_modes,attrs,solo_mode,change,changed){
return (function (attr,chs){
return cljs.core.reduce_kv.call(null,((function (cs,solo_modes,attrs,solo_mode,change,changed){
return (function (ret,c,v){
if(cljs.core.truth_(attr.call(null,v))){
return cljs.core.conj.call(null,ret,c);
} else {
return ret;
}
});})(cs,solo_modes,attrs,solo_mode,change,changed))
,cljs.core.PersistentHashSet.EMPTY,chs);
});})(cs,solo_modes,attrs,solo_mode,change,changed))
;
var calc_state = ((function (cs,solo_modes,attrs,solo_mode,change,changed,pick){
return (function (){
var chs = cljs.core.deref.call(null,cs);
var mode = cljs.core.deref.call(null,solo_mode);
var solos = pick.call(null,new cljs.core.Keyword(null,"solo","solo",-316350075),chs);
var pauses = pick.call(null,new cljs.core.Keyword(null,"pause","pause",-2095325672),chs);
return new cljs.core.PersistentArrayMap(null, 3, [new cljs.core.Keyword(null,"solos","solos",1441458643),solos,new cljs.core.Keyword(null,"mutes","mutes",1068806309),pick.call(null,new cljs.core.Keyword(null,"mute","mute",1151223646),chs),new cljs.core.Keyword(null,"reads","reads",-1215067361),cljs.core.conj.call(null,(((cljs.core._EQ_.call(null,mode,new cljs.core.Keyword(null,"pause","pause",-2095325672))) && (!(cljs.core.empty_QMARK_.call(null,solos))))?cljs.core.vec.call(null,solos):cljs.core.vec.call(null,cljs.core.remove.call(null,pauses,cljs.core.keys.call(null,chs)))),change)], null);
});})(cs,solo_modes,attrs,solo_mode,change,changed,pick))
;
var m = (function (){
if(typeof cljs.core.async.t_cljs$core$async31370 !== 'undefined'){
} else {

/**
* @constructor
 * @implements {cljs.core.IMeta}
 * @implements {cljs.core.async.Mix}
 * @implements {cljs.core.async.Mux}
 * @implements {cljs.core.IWithMeta}
*/
cljs.core.async.t_cljs$core$async31370 = (function (change,mix,solo_mode,pick,cs,calc_state,out,changed,solo_modes,attrs,meta31371){
this.change = change;
this.mix = mix;
this.solo_mode = solo_mode;
this.pick = pick;
this.cs = cs;
this.calc_state = calc_state;
this.out = out;
this.changed = changed;
this.solo_modes = solo_modes;
this.attrs = attrs;
this.meta31371 = meta31371;
this.cljs$lang$protocol_mask$partition0$ = 393216;
this.cljs$lang$protocol_mask$partition1$ = 0;
})
cljs.core.async.t_cljs$core$async31370.prototype.cljs$core$IWithMeta$_with_meta$arity$2 = ((function (cs,solo_modes,attrs,solo_mode,change,changed,pick,calc_state){
return (function (_31372,meta31371__$1){
var self__ = this;
var _31372__$1 = this;
return (new cljs.core.async.t_cljs$core$async31370(self__.change,self__.mix,self__.solo_mode,self__.pick,self__.cs,self__.calc_state,self__.out,self__.changed,self__.solo_modes,self__.attrs,meta31371__$1));
});})(cs,solo_modes,attrs,solo_mode,change,changed,pick,calc_state))
;

cljs.core.async.t_cljs$core$async31370.prototype.cljs$core$IMeta$_meta$arity$1 = ((function (cs,solo_modes,attrs,solo_mode,change,changed,pick,calc_state){
return (function (_31372){
var self__ = this;
var _31372__$1 = this;
return self__.meta31371;
});})(cs,solo_modes,attrs,solo_mode,change,changed,pick,calc_state))
;

cljs.core.async.t_cljs$core$async31370.prototype.cljs$core$async$Mux$ = true;

cljs.core.async.t_cljs$core$async31370.prototype.cljs$core$async$Mux$muxch_STAR_$arity$1 = ((function (cs,solo_modes,attrs,solo_mode,change,changed,pick,calc_state){
return (function (_){
var self__ = this;
var ___$1 = this;
return self__.out;
});})(cs,solo_modes,attrs,solo_mode,change,changed,pick,calc_state))
;

cljs.core.async.t_cljs$core$async31370.prototype.cljs$core$async$Mix$ = true;

cljs.core.async.t_cljs$core$async31370.prototype.cljs$core$async$Mix$admix_STAR_$arity$2 = ((function (cs,solo_modes,attrs,solo_mode,change,changed,pick,calc_state){
return (function (_,ch){
var self__ = this;
var ___$1 = this;
cljs.core.swap_BANG_.call(null,self__.cs,cljs.core.assoc,ch,cljs.core.PersistentArrayMap.EMPTY);

return self__.changed.call(null);
});})(cs,solo_modes,attrs,solo_mode,change,changed,pick,calc_state))
;

cljs.core.async.t_cljs$core$async31370.prototype.cljs$core$async$Mix$unmix_STAR_$arity$2 = ((function (cs,solo_modes,attrs,solo_mode,change,changed,pick,calc_state){
return (function (_,ch){
var self__ = this;
var ___$1 = this;
cljs.core.swap_BANG_.call(null,self__.cs,cljs.core.dissoc,ch);

return self__.changed.call(null);
});})(cs,solo_modes,attrs,solo_mode,change,changed,pick,calc_state))
;

cljs.core.async.t_cljs$core$async31370.prototype.cljs$core$async$Mix$unmix_all_STAR_$arity$1 = ((function (cs,solo_modes,attrs,solo_mode,change,changed,pick,calc_state){
return (function (_){
var self__ = this;
var ___$1 = this;
cljs.core.reset_BANG_.call(null,self__.cs,cljs.core.PersistentArrayMap.EMPTY);

return self__.changed.call(null);
});})(cs,solo_modes,attrs,solo_mode,change,changed,pick,calc_state))
;

cljs.core.async.t_cljs$core$async31370.prototype.cljs$core$async$Mix$toggle_STAR_$arity$2 = ((function (cs,solo_modes,attrs,solo_mode,change,changed,pick,calc_state){
return (function (_,state_map){
var self__ = this;
var ___$1 = this;
cljs.core.swap_BANG_.call(null,self__.cs,cljs.core.partial.call(null,cljs.core.merge_with,cljs.core.merge),state_map);

return self__.changed.call(null);
});})(cs,solo_modes,attrs,solo_mode,change,changed,pick,calc_state))
;

cljs.core.async.t_cljs$core$async31370.prototype.cljs$core$async$Mix$solo_mode_STAR_$arity$2 = ((function (cs,solo_modes,attrs,solo_mode,change,changed,pick,calc_state){
return (function (_,mode){
var self__ = this;
var ___$1 = this;
if(cljs.core.truth_(self__.solo_modes.call(null,mode))){
} else {
throw (new Error([cljs.core.str("Assert failed: "),cljs.core.str([cljs.core.str("mode must be one of: "),cljs.core.str(self__.solo_modes)].join('')),cljs.core.str("\n"),cljs.core.str(cljs.core.pr_str.call(null,cljs.core.list(new cljs.core.Symbol(null,"solo-modes","solo-modes",882180540,null),new cljs.core.Symbol(null,"mode","mode",-2000032078,null))))].join('')));
}

cljs.core.reset_BANG_.call(null,self__.solo_mode,mode);

return self__.changed.call(null);
});})(cs,solo_modes,attrs,solo_mode,change,changed,pick,calc_state))
;

cljs.core.async.t_cljs$core$async31370.getBasis = ((function (cs,solo_modes,attrs,solo_mode,change,changed,pick,calc_state){
return (function (){
return new cljs.core.PersistentVector(null, 11, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Symbol(null,"change","change",477485025,null),cljs.core.with_meta(new cljs.core.Symbol(null,"mix","mix",2121373763,null),new cljs.core.PersistentArrayMap(null, 2, [new cljs.core.Keyword(null,"arglists","arglists",1661989754),cljs.core.list(new cljs.core.Symbol(null,"quote","quote",1377916282,null),cljs.core.list(new cljs.core.PersistentVector(null, 1, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Symbol(null,"out","out",729986010,null)], null))),new cljs.core.Keyword(null,"doc","doc",1913296891),"Creates and returns a mix of one or more input channels which will\n  be put on the supplied out channel. Input sources can be added to\n  the mix with 'admix', and removed with 'unmix'. A mix supports\n  soloing, muting and pausing multiple inputs atomically using\n  'toggle', and can solo using either muting or pausing as determined\n  by 'solo-mode'.\n\n  Each channel can have zero or more boolean modes set via 'toggle':\n\n  :solo - when true, only this (ond other soloed) channel(s) will appear\n          in the mix output channel. :mute and :pause states of soloed\n          channels are ignored. If solo-mode is :mute, non-soloed\n          channels are muted, if :pause, non-soloed channels are\n          paused.\n\n  :mute - muted channels will have their contents consumed but not included in the mix\n  :pause - paused channels will not have their contents consumed (and thus also not included in the mix)\n"], null)),new cljs.core.Symbol(null,"solo-mode","solo-mode",2031788074,null),new cljs.core.Symbol(null,"pick","pick",1300068175,null),new cljs.core.Symbol(null,"cs","cs",-117024463,null),new cljs.core.Symbol(null,"calc-state","calc-state",-349968968,null),new cljs.core.Symbol(null,"out","out",729986010,null),new cljs.core.Symbol(null,"changed","changed",-2083710852,null),new cljs.core.Symbol(null,"solo-modes","solo-modes",882180540,null),new cljs.core.Symbol(null,"attrs","attrs",-450137186,null),new cljs.core.Symbol(null,"meta31371","meta31371",2107928915,null)], null);
});})(cs,solo_modes,attrs,solo_mode,change,changed,pick,calc_state))
;

cljs.core.async.t_cljs$core$async31370.cljs$lang$type = true;

cljs.core.async.t_cljs$core$async31370.cljs$lang$ctorStr = "cljs.core.async/t_cljs$core$async31370";

cljs.core.async.t_cljs$core$async31370.cljs$lang$ctorPrWriter = ((function (cs,solo_modes,attrs,solo_mode,change,changed,pick,calc_state){
return (function (this__25539__auto__,writer__25540__auto__,opt__25541__auto__){
return cljs.core._write.call(null,writer__25540__auto__,"cljs.core.async/t_cljs$core$async31370");
});})(cs,solo_modes,attrs,solo_mode,change,changed,pick,calc_state))
;

cljs.core.async.__GT_t_cljs$core$async31370 = ((function (cs,solo_modes,attrs,solo_mode,change,changed,pick,calc_state){
return (function cljs$core$async$mix_$___GT_t_cljs$core$async31370(change__$1,mix__$1,solo_mode__$1,pick__$1,cs__$1,calc_state__$1,out__$1,changed__$1,solo_modes__$1,attrs__$1,meta31371){
return (new cljs.core.async.t_cljs$core$async31370(change__$1,mix__$1,solo_mode__$1,pick__$1,cs__$1,calc_state__$1,out__$1,changed__$1,solo_modes__$1,attrs__$1,meta31371));
});})(cs,solo_modes,attrs,solo_mode,change,changed,pick,calc_state))
;

}

return (new cljs.core.async.t_cljs$core$async31370(change,cljs$core$async$mix,solo_mode,pick,cs,calc_state,out,changed,solo_modes,attrs,cljs.core.PersistentArrayMap.EMPTY));
})()
;
var c__27451__auto___31533 = cljs.core.async.chan.call(null,(1));
cljs.core.async.impl.dispatch.run.call(null,((function (c__27451__auto___31533,cs,solo_modes,attrs,solo_mode,change,changed,pick,calc_state,m){
return (function (){
var f__27452__auto__ = (function (){var switch__27386__auto__ = ((function (c__27451__auto___31533,cs,solo_modes,attrs,solo_mode,change,changed,pick,calc_state,m){
return (function (state_31470){
var state_val_31471 = (state_31470[(1)]);
if((state_val_31471 === (7))){
var inst_31388 = (state_31470[(2)]);
var state_31470__$1 = state_31470;
var statearr_31472_31534 = state_31470__$1;
(statearr_31472_31534[(2)] = inst_31388);

(statearr_31472_31534[(1)] = (4));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31471 === (20))){
var inst_31400 = (state_31470[(7)]);
var state_31470__$1 = state_31470;
var statearr_31473_31535 = state_31470__$1;
(statearr_31473_31535[(2)] = inst_31400);

(statearr_31473_31535[(1)] = (21));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31471 === (27))){
var state_31470__$1 = state_31470;
var statearr_31474_31536 = state_31470__$1;
(statearr_31474_31536[(2)] = null);

(statearr_31474_31536[(1)] = (28));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31471 === (1))){
var inst_31376 = (state_31470[(8)]);
var inst_31376__$1 = calc_state.call(null);
var inst_31378 = (inst_31376__$1 == null);
var inst_31379 = cljs.core.not.call(null,inst_31378);
var state_31470__$1 = (function (){var statearr_31475 = state_31470;
(statearr_31475[(8)] = inst_31376__$1);

return statearr_31475;
})();
if(inst_31379){
var statearr_31476_31537 = state_31470__$1;
(statearr_31476_31537[(1)] = (2));

} else {
var statearr_31477_31538 = state_31470__$1;
(statearr_31477_31538[(1)] = (3));

}

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31471 === (24))){
var inst_31444 = (state_31470[(9)]);
var inst_31423 = (state_31470[(10)]);
var inst_31430 = (state_31470[(11)]);
var inst_31444__$1 = inst_31423.call(null,inst_31430);
var state_31470__$1 = (function (){var statearr_31478 = state_31470;
(statearr_31478[(9)] = inst_31444__$1);

return statearr_31478;
})();
if(cljs.core.truth_(inst_31444__$1)){
var statearr_31479_31539 = state_31470__$1;
(statearr_31479_31539[(1)] = (29));

} else {
var statearr_31480_31540 = state_31470__$1;
(statearr_31480_31540[(1)] = (30));

}

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31471 === (4))){
var inst_31391 = (state_31470[(2)]);
var state_31470__$1 = state_31470;
if(cljs.core.truth_(inst_31391)){
var statearr_31481_31541 = state_31470__$1;
(statearr_31481_31541[(1)] = (8));

} else {
var statearr_31482_31542 = state_31470__$1;
(statearr_31482_31542[(1)] = (9));

}

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31471 === (15))){
var inst_31417 = (state_31470[(2)]);
var state_31470__$1 = state_31470;
if(cljs.core.truth_(inst_31417)){
var statearr_31483_31543 = state_31470__$1;
(statearr_31483_31543[(1)] = (19));

} else {
var statearr_31484_31544 = state_31470__$1;
(statearr_31484_31544[(1)] = (20));

}

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31471 === (21))){
var inst_31422 = (state_31470[(12)]);
var inst_31422__$1 = (state_31470[(2)]);
var inst_31423 = cljs.core.get.call(null,inst_31422__$1,new cljs.core.Keyword(null,"solos","solos",1441458643));
var inst_31424 = cljs.core.get.call(null,inst_31422__$1,new cljs.core.Keyword(null,"mutes","mutes",1068806309));
var inst_31425 = cljs.core.get.call(null,inst_31422__$1,new cljs.core.Keyword(null,"reads","reads",-1215067361));
var state_31470__$1 = (function (){var statearr_31485 = state_31470;
(statearr_31485[(10)] = inst_31423);

(statearr_31485[(13)] = inst_31424);

(statearr_31485[(12)] = inst_31422__$1);

return statearr_31485;
})();
return cljs.core.async.ioc_alts_BANG_.call(null,state_31470__$1,(22),inst_31425);
} else {
if((state_val_31471 === (31))){
var inst_31452 = (state_31470[(2)]);
var state_31470__$1 = state_31470;
if(cljs.core.truth_(inst_31452)){
var statearr_31486_31545 = state_31470__$1;
(statearr_31486_31545[(1)] = (32));

} else {
var statearr_31487_31546 = state_31470__$1;
(statearr_31487_31546[(1)] = (33));

}

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31471 === (32))){
var inst_31429 = (state_31470[(14)]);
var state_31470__$1 = state_31470;
return cljs.core.async.impl.ioc_helpers.put_BANG_.call(null,state_31470__$1,(35),out,inst_31429);
} else {
if((state_val_31471 === (33))){
var inst_31422 = (state_31470[(12)]);
var inst_31400 = inst_31422;
var state_31470__$1 = (function (){var statearr_31488 = state_31470;
(statearr_31488[(7)] = inst_31400);

return statearr_31488;
})();
var statearr_31489_31547 = state_31470__$1;
(statearr_31489_31547[(2)] = null);

(statearr_31489_31547[(1)] = (11));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31471 === (13))){
var inst_31400 = (state_31470[(7)]);
var inst_31407 = inst_31400.cljs$lang$protocol_mask$partition0$;
var inst_31408 = (inst_31407 & (64));
var inst_31409 = inst_31400.cljs$core$ISeq$;
var inst_31410 = (inst_31408) || (inst_31409);
var state_31470__$1 = state_31470;
if(cljs.core.truth_(inst_31410)){
var statearr_31490_31548 = state_31470__$1;
(statearr_31490_31548[(1)] = (16));

} else {
var statearr_31491_31549 = state_31470__$1;
(statearr_31491_31549[(1)] = (17));

}

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31471 === (22))){
var inst_31429 = (state_31470[(14)]);
var inst_31430 = (state_31470[(11)]);
var inst_31428 = (state_31470[(2)]);
var inst_31429__$1 = cljs.core.nth.call(null,inst_31428,(0),null);
var inst_31430__$1 = cljs.core.nth.call(null,inst_31428,(1),null);
var inst_31431 = (inst_31429__$1 == null);
var inst_31432 = cljs.core._EQ_.call(null,inst_31430__$1,change);
var inst_31433 = (inst_31431) || (inst_31432);
var state_31470__$1 = (function (){var statearr_31492 = state_31470;
(statearr_31492[(14)] = inst_31429__$1);

(statearr_31492[(11)] = inst_31430__$1);

return statearr_31492;
})();
if(cljs.core.truth_(inst_31433)){
var statearr_31493_31550 = state_31470__$1;
(statearr_31493_31550[(1)] = (23));

} else {
var statearr_31494_31551 = state_31470__$1;
(statearr_31494_31551[(1)] = (24));

}

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31471 === (36))){
var inst_31422 = (state_31470[(12)]);
var inst_31400 = inst_31422;
var state_31470__$1 = (function (){var statearr_31495 = state_31470;
(statearr_31495[(7)] = inst_31400);

return statearr_31495;
})();
var statearr_31496_31552 = state_31470__$1;
(statearr_31496_31552[(2)] = null);

(statearr_31496_31552[(1)] = (11));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31471 === (29))){
var inst_31444 = (state_31470[(9)]);
var state_31470__$1 = state_31470;
var statearr_31497_31553 = state_31470__$1;
(statearr_31497_31553[(2)] = inst_31444);

(statearr_31497_31553[(1)] = (31));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31471 === (6))){
var state_31470__$1 = state_31470;
var statearr_31498_31554 = state_31470__$1;
(statearr_31498_31554[(2)] = false);

(statearr_31498_31554[(1)] = (7));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31471 === (28))){
var inst_31440 = (state_31470[(2)]);
var inst_31441 = calc_state.call(null);
var inst_31400 = inst_31441;
var state_31470__$1 = (function (){var statearr_31499 = state_31470;
(statearr_31499[(15)] = inst_31440);

(statearr_31499[(7)] = inst_31400);

return statearr_31499;
})();
var statearr_31500_31555 = state_31470__$1;
(statearr_31500_31555[(2)] = null);

(statearr_31500_31555[(1)] = (11));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31471 === (25))){
var inst_31466 = (state_31470[(2)]);
var state_31470__$1 = state_31470;
var statearr_31501_31556 = state_31470__$1;
(statearr_31501_31556[(2)] = inst_31466);

(statearr_31501_31556[(1)] = (12));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31471 === (34))){
var inst_31464 = (state_31470[(2)]);
var state_31470__$1 = state_31470;
var statearr_31502_31557 = state_31470__$1;
(statearr_31502_31557[(2)] = inst_31464);

(statearr_31502_31557[(1)] = (25));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31471 === (17))){
var state_31470__$1 = state_31470;
var statearr_31503_31558 = state_31470__$1;
(statearr_31503_31558[(2)] = false);

(statearr_31503_31558[(1)] = (18));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31471 === (3))){
var state_31470__$1 = state_31470;
var statearr_31504_31559 = state_31470__$1;
(statearr_31504_31559[(2)] = false);

(statearr_31504_31559[(1)] = (4));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31471 === (12))){
var inst_31468 = (state_31470[(2)]);
var state_31470__$1 = state_31470;
return cljs.core.async.impl.ioc_helpers.return_chan.call(null,state_31470__$1,inst_31468);
} else {
if((state_val_31471 === (2))){
var inst_31376 = (state_31470[(8)]);
var inst_31381 = inst_31376.cljs$lang$protocol_mask$partition0$;
var inst_31382 = (inst_31381 & (64));
var inst_31383 = inst_31376.cljs$core$ISeq$;
var inst_31384 = (inst_31382) || (inst_31383);
var state_31470__$1 = state_31470;
if(cljs.core.truth_(inst_31384)){
var statearr_31505_31560 = state_31470__$1;
(statearr_31505_31560[(1)] = (5));

} else {
var statearr_31506_31561 = state_31470__$1;
(statearr_31506_31561[(1)] = (6));

}

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31471 === (23))){
var inst_31429 = (state_31470[(14)]);
var inst_31435 = (inst_31429 == null);
var state_31470__$1 = state_31470;
if(cljs.core.truth_(inst_31435)){
var statearr_31507_31562 = state_31470__$1;
(statearr_31507_31562[(1)] = (26));

} else {
var statearr_31508_31563 = state_31470__$1;
(statearr_31508_31563[(1)] = (27));

}

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31471 === (35))){
var inst_31455 = (state_31470[(2)]);
var state_31470__$1 = state_31470;
if(cljs.core.truth_(inst_31455)){
var statearr_31509_31564 = state_31470__$1;
(statearr_31509_31564[(1)] = (36));

} else {
var statearr_31510_31565 = state_31470__$1;
(statearr_31510_31565[(1)] = (37));

}

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31471 === (19))){
var inst_31400 = (state_31470[(7)]);
var inst_31419 = cljs.core.apply.call(null,cljs.core.hash_map,inst_31400);
var state_31470__$1 = state_31470;
var statearr_31511_31566 = state_31470__$1;
(statearr_31511_31566[(2)] = inst_31419);

(statearr_31511_31566[(1)] = (21));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31471 === (11))){
var inst_31400 = (state_31470[(7)]);
var inst_31404 = (inst_31400 == null);
var inst_31405 = cljs.core.not.call(null,inst_31404);
var state_31470__$1 = state_31470;
if(inst_31405){
var statearr_31512_31567 = state_31470__$1;
(statearr_31512_31567[(1)] = (13));

} else {
var statearr_31513_31568 = state_31470__$1;
(statearr_31513_31568[(1)] = (14));

}

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31471 === (9))){
var inst_31376 = (state_31470[(8)]);
var state_31470__$1 = state_31470;
var statearr_31514_31569 = state_31470__$1;
(statearr_31514_31569[(2)] = inst_31376);

(statearr_31514_31569[(1)] = (10));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31471 === (5))){
var state_31470__$1 = state_31470;
var statearr_31515_31570 = state_31470__$1;
(statearr_31515_31570[(2)] = true);

(statearr_31515_31570[(1)] = (7));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31471 === (14))){
var state_31470__$1 = state_31470;
var statearr_31516_31571 = state_31470__$1;
(statearr_31516_31571[(2)] = false);

(statearr_31516_31571[(1)] = (15));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31471 === (26))){
var inst_31430 = (state_31470[(11)]);
var inst_31437 = cljs.core.swap_BANG_.call(null,cs,cljs.core.dissoc,inst_31430);
var state_31470__$1 = state_31470;
var statearr_31517_31572 = state_31470__$1;
(statearr_31517_31572[(2)] = inst_31437);

(statearr_31517_31572[(1)] = (28));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31471 === (16))){
var state_31470__$1 = state_31470;
var statearr_31518_31573 = state_31470__$1;
(statearr_31518_31573[(2)] = true);

(statearr_31518_31573[(1)] = (18));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31471 === (38))){
var inst_31460 = (state_31470[(2)]);
var state_31470__$1 = state_31470;
var statearr_31519_31574 = state_31470__$1;
(statearr_31519_31574[(2)] = inst_31460);

(statearr_31519_31574[(1)] = (34));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31471 === (30))){
var inst_31423 = (state_31470[(10)]);
var inst_31424 = (state_31470[(13)]);
var inst_31430 = (state_31470[(11)]);
var inst_31447 = cljs.core.empty_QMARK_.call(null,inst_31423);
var inst_31448 = inst_31424.call(null,inst_31430);
var inst_31449 = cljs.core.not.call(null,inst_31448);
var inst_31450 = (inst_31447) && (inst_31449);
var state_31470__$1 = state_31470;
var statearr_31520_31575 = state_31470__$1;
(statearr_31520_31575[(2)] = inst_31450);

(statearr_31520_31575[(1)] = (31));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31471 === (10))){
var inst_31376 = (state_31470[(8)]);
var inst_31396 = (state_31470[(2)]);
var inst_31397 = cljs.core.get.call(null,inst_31396,new cljs.core.Keyword(null,"solos","solos",1441458643));
var inst_31398 = cljs.core.get.call(null,inst_31396,new cljs.core.Keyword(null,"mutes","mutes",1068806309));
var inst_31399 = cljs.core.get.call(null,inst_31396,new cljs.core.Keyword(null,"reads","reads",-1215067361));
var inst_31400 = inst_31376;
var state_31470__$1 = (function (){var statearr_31521 = state_31470;
(statearr_31521[(16)] = inst_31399);

(statearr_31521[(17)] = inst_31397);

(statearr_31521[(18)] = inst_31398);

(statearr_31521[(7)] = inst_31400);

return statearr_31521;
})();
var statearr_31522_31576 = state_31470__$1;
(statearr_31522_31576[(2)] = null);

(statearr_31522_31576[(1)] = (11));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31471 === (18))){
var inst_31414 = (state_31470[(2)]);
var state_31470__$1 = state_31470;
var statearr_31523_31577 = state_31470__$1;
(statearr_31523_31577[(2)] = inst_31414);

(statearr_31523_31577[(1)] = (15));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31471 === (37))){
var state_31470__$1 = state_31470;
var statearr_31524_31578 = state_31470__$1;
(statearr_31524_31578[(2)] = null);

(statearr_31524_31578[(1)] = (38));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31471 === (8))){
var inst_31376 = (state_31470[(8)]);
var inst_31393 = cljs.core.apply.call(null,cljs.core.hash_map,inst_31376);
var state_31470__$1 = state_31470;
var statearr_31525_31579 = state_31470__$1;
(statearr_31525_31579[(2)] = inst_31393);

(statearr_31525_31579[(1)] = (10));


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
}
}
}
}
}
}
}
}
});})(c__27451__auto___31533,cs,solo_modes,attrs,solo_mode,change,changed,pick,calc_state,m))
;
return ((function (switch__27386__auto__,c__27451__auto___31533,cs,solo_modes,attrs,solo_mode,change,changed,pick,calc_state,m){
return (function() {
var cljs$core$async$mix_$_state_machine__27387__auto__ = null;
var cljs$core$async$mix_$_state_machine__27387__auto____0 = (function (){
var statearr_31529 = [null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null];
(statearr_31529[(0)] = cljs$core$async$mix_$_state_machine__27387__auto__);

(statearr_31529[(1)] = (1));

return statearr_31529;
});
var cljs$core$async$mix_$_state_machine__27387__auto____1 = (function (state_31470){
while(true){
var ret_value__27388__auto__ = (function (){try{while(true){
var result__27389__auto__ = switch__27386__auto__.call(null,state_31470);
if(cljs.core.keyword_identical_QMARK_.call(null,result__27389__auto__,new cljs.core.Keyword(null,"recur","recur",-437573268))){
continue;
} else {
return result__27389__auto__;
}
break;
}
}catch (e31530){if((e31530 instanceof Object)){
var ex__27390__auto__ = e31530;
var statearr_31531_31580 = state_31470;
(statearr_31531_31580[(5)] = ex__27390__auto__);


cljs.core.async.impl.ioc_helpers.process_exception.call(null,state_31470);

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
throw e31530;

}
}})();
if(cljs.core.keyword_identical_QMARK_.call(null,ret_value__27388__auto__,new cljs.core.Keyword(null,"recur","recur",-437573268))){
var G__31581 = state_31470;
state_31470 = G__31581;
continue;
} else {
return ret_value__27388__auto__;
}
break;
}
});
cljs$core$async$mix_$_state_machine__27387__auto__ = function(state_31470){
switch(arguments.length){
case 0:
return cljs$core$async$mix_$_state_machine__27387__auto____0.call(this);
case 1:
return cljs$core$async$mix_$_state_machine__27387__auto____1.call(this,state_31470);
}
throw(new Error('Invalid arity: ' + arguments.length));
};
cljs$core$async$mix_$_state_machine__27387__auto__.cljs$core$IFn$_invoke$arity$0 = cljs$core$async$mix_$_state_machine__27387__auto____0;
cljs$core$async$mix_$_state_machine__27387__auto__.cljs$core$IFn$_invoke$arity$1 = cljs$core$async$mix_$_state_machine__27387__auto____1;
return cljs$core$async$mix_$_state_machine__27387__auto__;
})()
;})(switch__27386__auto__,c__27451__auto___31533,cs,solo_modes,attrs,solo_mode,change,changed,pick,calc_state,m))
})();
var state__27453__auto__ = (function (){var statearr_31532 = f__27452__auto__.call(null);
(statearr_31532[cljs.core.async.impl.ioc_helpers.USER_START_IDX] = c__27451__auto___31533);

return statearr_31532;
})();
return cljs.core.async.impl.ioc_helpers.run_state_machine_wrapped.call(null,state__27453__auto__);
});})(c__27451__auto___31533,cs,solo_modes,attrs,solo_mode,change,changed,pick,calc_state,m))
);


return m;
});
/**
 * Adds ch as an input to the mix
 */
cljs.core.async.admix = (function cljs$core$async$admix(mix,ch){
return cljs.core.async.admix_STAR_.call(null,mix,ch);
});
/**
 * Removes ch as an input to the mix
 */
cljs.core.async.unmix = (function cljs$core$async$unmix(mix,ch){
return cljs.core.async.unmix_STAR_.call(null,mix,ch);
});
/**
 * removes all inputs from the mix
 */
cljs.core.async.unmix_all = (function cljs$core$async$unmix_all(mix){
return cljs.core.async.unmix_all_STAR_.call(null,mix);
});
/**
 * Atomically sets the state(s) of one or more channels in a mix. The
 *   state map is a map of channels -> channel-state-map. A
 *   channel-state-map is a map of attrs -> boolean, where attr is one or
 *   more of :mute, :pause or :solo. Any states supplied are merged with
 *   the current state.
 * 
 *   Note that channels can be added to a mix via toggle, which can be
 *   used to add channels in a particular (e.g. paused) state.
 */
cljs.core.async.toggle = (function cljs$core$async$toggle(mix,state_map){
return cljs.core.async.toggle_STAR_.call(null,mix,state_map);
});
/**
 * Sets the solo mode of the mix. mode must be one of :mute or :pause
 */
cljs.core.async.solo_mode = (function cljs$core$async$solo_mode(mix,mode){
return cljs.core.async.solo_mode_STAR_.call(null,mix,mode);
});

/**
 * @interface
 */
cljs.core.async.Pub = function(){};

cljs.core.async.sub_STAR_ = (function cljs$core$async$sub_STAR_(p,v,ch,close_QMARK_){
if((!((p == null))) && (!((p.cljs$core$async$Pub$sub_STAR_$arity$4 == null)))){
return p.cljs$core$async$Pub$sub_STAR_$arity$4(p,v,ch,close_QMARK_);
} else {
var x__25596__auto__ = (((p == null))?null:p);
var m__25597__auto__ = (cljs.core.async.sub_STAR_[goog.typeOf(x__25596__auto__)]);
if(!((m__25597__auto__ == null))){
return m__25597__auto__.call(null,p,v,ch,close_QMARK_);
} else {
var m__25597__auto____$1 = (cljs.core.async.sub_STAR_["_"]);
if(!((m__25597__auto____$1 == null))){
return m__25597__auto____$1.call(null,p,v,ch,close_QMARK_);
} else {
throw cljs.core.missing_protocol.call(null,"Pub.sub*",p);
}
}
}
});

cljs.core.async.unsub_STAR_ = (function cljs$core$async$unsub_STAR_(p,v,ch){
if((!((p == null))) && (!((p.cljs$core$async$Pub$unsub_STAR_$arity$3 == null)))){
return p.cljs$core$async$Pub$unsub_STAR_$arity$3(p,v,ch);
} else {
var x__25596__auto__ = (((p == null))?null:p);
var m__25597__auto__ = (cljs.core.async.unsub_STAR_[goog.typeOf(x__25596__auto__)]);
if(!((m__25597__auto__ == null))){
return m__25597__auto__.call(null,p,v,ch);
} else {
var m__25597__auto____$1 = (cljs.core.async.unsub_STAR_["_"]);
if(!((m__25597__auto____$1 == null))){
return m__25597__auto____$1.call(null,p,v,ch);
} else {
throw cljs.core.missing_protocol.call(null,"Pub.unsub*",p);
}
}
}
});

cljs.core.async.unsub_all_STAR_ = (function cljs$core$async$unsub_all_STAR_(var_args){
var args31582 = [];
var len__25999__auto___31585 = arguments.length;
var i__26000__auto___31586 = (0);
while(true){
if((i__26000__auto___31586 < len__25999__auto___31585)){
args31582.push((arguments[i__26000__auto___31586]));

var G__31587 = (i__26000__auto___31586 + (1));
i__26000__auto___31586 = G__31587;
continue;
} else {
}
break;
}

var G__31584 = args31582.length;
switch (G__31584) {
case 1:
return cljs.core.async.unsub_all_STAR_.cljs$core$IFn$_invoke$arity$1((arguments[(0)]));

break;
case 2:
return cljs.core.async.unsub_all_STAR_.cljs$core$IFn$_invoke$arity$2((arguments[(0)]),(arguments[(1)]));

break;
default:
throw (new Error([cljs.core.str("Invalid arity: "),cljs.core.str(args31582.length)].join('')));

}
});

cljs.core.async.unsub_all_STAR_.cljs$core$IFn$_invoke$arity$1 = (function (p){
if((!((p == null))) && (!((p.cljs$core$async$Pub$unsub_all_STAR_$arity$1 == null)))){
return p.cljs$core$async$Pub$unsub_all_STAR_$arity$1(p);
} else {
var x__25596__auto__ = (((p == null))?null:p);
var m__25597__auto__ = (cljs.core.async.unsub_all_STAR_[goog.typeOf(x__25596__auto__)]);
if(!((m__25597__auto__ == null))){
return m__25597__auto__.call(null,p);
} else {
var m__25597__auto____$1 = (cljs.core.async.unsub_all_STAR_["_"]);
if(!((m__25597__auto____$1 == null))){
return m__25597__auto____$1.call(null,p);
} else {
throw cljs.core.missing_protocol.call(null,"Pub.unsub-all*",p);
}
}
}
});

cljs.core.async.unsub_all_STAR_.cljs$core$IFn$_invoke$arity$2 = (function (p,v){
if((!((p == null))) && (!((p.cljs$core$async$Pub$unsub_all_STAR_$arity$2 == null)))){
return p.cljs$core$async$Pub$unsub_all_STAR_$arity$2(p,v);
} else {
var x__25596__auto__ = (((p == null))?null:p);
var m__25597__auto__ = (cljs.core.async.unsub_all_STAR_[goog.typeOf(x__25596__auto__)]);
if(!((m__25597__auto__ == null))){
return m__25597__auto__.call(null,p,v);
} else {
var m__25597__auto____$1 = (cljs.core.async.unsub_all_STAR_["_"]);
if(!((m__25597__auto____$1 == null))){
return m__25597__auto____$1.call(null,p,v);
} else {
throw cljs.core.missing_protocol.call(null,"Pub.unsub-all*",p);
}
}
}
});

cljs.core.async.unsub_all_STAR_.cljs$lang$maxFixedArity = 2;

/**
 * Creates and returns a pub(lication) of the supplied channel,
 *   partitioned into topics by the topic-fn. topic-fn will be applied to
 *   each value on the channel and the result will determine the 'topic'
 *   on which that value will be put. Channels can be subscribed to
 *   receive copies of topics using 'sub', and unsubscribed using
 *   'unsub'. Each topic will be handled by an internal mult on a
 *   dedicated channel. By default these internal channels are
 *   unbuffered, but a buf-fn can be supplied which, given a topic,
 *   creates a buffer with desired properties.
 * 
 *   Each item is distributed to all subs in parallel and synchronously,
 *   i.e. each sub must accept before the next item is distributed. Use
 *   buffering/windowing to prevent slow subs from holding up the pub.
 * 
 *   Items received when there are no matching subs get dropped.
 * 
 *   Note that if buf-fns are used then each topic is handled
 *   asynchronously, i.e. if a channel is subscribed to more than one
 *   topic it should not expect them to be interleaved identically with
 *   the source.
 */
cljs.core.async.pub = (function cljs$core$async$pub(var_args){
var args31590 = [];
var len__25999__auto___31715 = arguments.length;
var i__26000__auto___31716 = (0);
while(true){
if((i__26000__auto___31716 < len__25999__auto___31715)){
args31590.push((arguments[i__26000__auto___31716]));

var G__31717 = (i__26000__auto___31716 + (1));
i__26000__auto___31716 = G__31717;
continue;
} else {
}
break;
}

var G__31592 = args31590.length;
switch (G__31592) {
case 2:
return cljs.core.async.pub.cljs$core$IFn$_invoke$arity$2((arguments[(0)]),(arguments[(1)]));

break;
case 3:
return cljs.core.async.pub.cljs$core$IFn$_invoke$arity$3((arguments[(0)]),(arguments[(1)]),(arguments[(2)]));

break;
default:
throw (new Error([cljs.core.str("Invalid arity: "),cljs.core.str(args31590.length)].join('')));

}
});

cljs.core.async.pub.cljs$core$IFn$_invoke$arity$2 = (function (ch,topic_fn){
return cljs.core.async.pub.call(null,ch,topic_fn,cljs.core.constantly.call(null,null));
});

cljs.core.async.pub.cljs$core$IFn$_invoke$arity$3 = (function (ch,topic_fn,buf_fn){
var mults = cljs.core.atom.call(null,cljs.core.PersistentArrayMap.EMPTY);
var ensure_mult = ((function (mults){
return (function (topic){
var or__24941__auto__ = cljs.core.get.call(null,cljs.core.deref.call(null,mults),topic);
if(cljs.core.truth_(or__24941__auto__)){
return or__24941__auto__;
} else {
return cljs.core.get.call(null,cljs.core.swap_BANG_.call(null,mults,((function (or__24941__auto__,mults){
return (function (p1__31589_SHARP_){
if(cljs.core.truth_(p1__31589_SHARP_.call(null,topic))){
return p1__31589_SHARP_;
} else {
return cljs.core.assoc.call(null,p1__31589_SHARP_,topic,cljs.core.async.mult.call(null,cljs.core.async.chan.call(null,buf_fn.call(null,topic))));
}
});})(or__24941__auto__,mults))
),topic);
}
});})(mults))
;
var p = (function (){
if(typeof cljs.core.async.t_cljs$core$async31593 !== 'undefined'){
} else {

/**
* @constructor
 * @implements {cljs.core.async.Pub}
 * @implements {cljs.core.IMeta}
 * @implements {cljs.core.async.Mux}
 * @implements {cljs.core.IWithMeta}
*/
cljs.core.async.t_cljs$core$async31593 = (function (ch,topic_fn,buf_fn,mults,ensure_mult,meta31594){
this.ch = ch;
this.topic_fn = topic_fn;
this.buf_fn = buf_fn;
this.mults = mults;
this.ensure_mult = ensure_mult;
this.meta31594 = meta31594;
this.cljs$lang$protocol_mask$partition0$ = 393216;
this.cljs$lang$protocol_mask$partition1$ = 0;
})
cljs.core.async.t_cljs$core$async31593.prototype.cljs$core$IWithMeta$_with_meta$arity$2 = ((function (mults,ensure_mult){
return (function (_31595,meta31594__$1){
var self__ = this;
var _31595__$1 = this;
return (new cljs.core.async.t_cljs$core$async31593(self__.ch,self__.topic_fn,self__.buf_fn,self__.mults,self__.ensure_mult,meta31594__$1));
});})(mults,ensure_mult))
;

cljs.core.async.t_cljs$core$async31593.prototype.cljs$core$IMeta$_meta$arity$1 = ((function (mults,ensure_mult){
return (function (_31595){
var self__ = this;
var _31595__$1 = this;
return self__.meta31594;
});})(mults,ensure_mult))
;

cljs.core.async.t_cljs$core$async31593.prototype.cljs$core$async$Mux$ = true;

cljs.core.async.t_cljs$core$async31593.prototype.cljs$core$async$Mux$muxch_STAR_$arity$1 = ((function (mults,ensure_mult){
return (function (_){
var self__ = this;
var ___$1 = this;
return self__.ch;
});})(mults,ensure_mult))
;

cljs.core.async.t_cljs$core$async31593.prototype.cljs$core$async$Pub$ = true;

cljs.core.async.t_cljs$core$async31593.prototype.cljs$core$async$Pub$sub_STAR_$arity$4 = ((function (mults,ensure_mult){
return (function (p,topic,ch__$1,close_QMARK_){
var self__ = this;
var p__$1 = this;
var m = self__.ensure_mult.call(null,topic);
return cljs.core.async.tap.call(null,m,ch__$1,close_QMARK_);
});})(mults,ensure_mult))
;

cljs.core.async.t_cljs$core$async31593.prototype.cljs$core$async$Pub$unsub_STAR_$arity$3 = ((function (mults,ensure_mult){
return (function (p,topic,ch__$1){
var self__ = this;
var p__$1 = this;
var temp__4425__auto__ = cljs.core.get.call(null,cljs.core.deref.call(null,self__.mults),topic);
if(cljs.core.truth_(temp__4425__auto__)){
var m = temp__4425__auto__;
return cljs.core.async.untap.call(null,m,ch__$1);
} else {
return null;
}
});})(mults,ensure_mult))
;

cljs.core.async.t_cljs$core$async31593.prototype.cljs$core$async$Pub$unsub_all_STAR_$arity$1 = ((function (mults,ensure_mult){
return (function (_){
var self__ = this;
var ___$1 = this;
return cljs.core.reset_BANG_.call(null,self__.mults,cljs.core.PersistentArrayMap.EMPTY);
});})(mults,ensure_mult))
;

cljs.core.async.t_cljs$core$async31593.prototype.cljs$core$async$Pub$unsub_all_STAR_$arity$2 = ((function (mults,ensure_mult){
return (function (_,topic){
var self__ = this;
var ___$1 = this;
return cljs.core.swap_BANG_.call(null,self__.mults,cljs.core.dissoc,topic);
});})(mults,ensure_mult))
;

cljs.core.async.t_cljs$core$async31593.getBasis = ((function (mults,ensure_mult){
return (function (){
return new cljs.core.PersistentVector(null, 6, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Symbol(null,"ch","ch",1085813622,null),new cljs.core.Symbol(null,"topic-fn","topic-fn",-862449736,null),new cljs.core.Symbol(null,"buf-fn","buf-fn",-1200281591,null),new cljs.core.Symbol(null,"mults","mults",-461114485,null),new cljs.core.Symbol(null,"ensure-mult","ensure-mult",1796584816,null),new cljs.core.Symbol(null,"meta31594","meta31594",89628972,null)], null);
});})(mults,ensure_mult))
;

cljs.core.async.t_cljs$core$async31593.cljs$lang$type = true;

cljs.core.async.t_cljs$core$async31593.cljs$lang$ctorStr = "cljs.core.async/t_cljs$core$async31593";

cljs.core.async.t_cljs$core$async31593.cljs$lang$ctorPrWriter = ((function (mults,ensure_mult){
return (function (this__25539__auto__,writer__25540__auto__,opt__25541__auto__){
return cljs.core._write.call(null,writer__25540__auto__,"cljs.core.async/t_cljs$core$async31593");
});})(mults,ensure_mult))
;

cljs.core.async.__GT_t_cljs$core$async31593 = ((function (mults,ensure_mult){
return (function cljs$core$async$__GT_t_cljs$core$async31593(ch__$1,topic_fn__$1,buf_fn__$1,mults__$1,ensure_mult__$1,meta31594){
return (new cljs.core.async.t_cljs$core$async31593(ch__$1,topic_fn__$1,buf_fn__$1,mults__$1,ensure_mult__$1,meta31594));
});})(mults,ensure_mult))
;

}

return (new cljs.core.async.t_cljs$core$async31593(ch,topic_fn,buf_fn,mults,ensure_mult,cljs.core.PersistentArrayMap.EMPTY));
})()
;
var c__27451__auto___31719 = cljs.core.async.chan.call(null,(1));
cljs.core.async.impl.dispatch.run.call(null,((function (c__27451__auto___31719,mults,ensure_mult,p){
return (function (){
var f__27452__auto__ = (function (){var switch__27386__auto__ = ((function (c__27451__auto___31719,mults,ensure_mult,p){
return (function (state_31667){
var state_val_31668 = (state_31667[(1)]);
if((state_val_31668 === (7))){
var inst_31663 = (state_31667[(2)]);
var state_31667__$1 = state_31667;
var statearr_31669_31720 = state_31667__$1;
(statearr_31669_31720[(2)] = inst_31663);

(statearr_31669_31720[(1)] = (3));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31668 === (20))){
var state_31667__$1 = state_31667;
var statearr_31670_31721 = state_31667__$1;
(statearr_31670_31721[(2)] = null);

(statearr_31670_31721[(1)] = (21));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31668 === (1))){
var state_31667__$1 = state_31667;
var statearr_31671_31722 = state_31667__$1;
(statearr_31671_31722[(2)] = null);

(statearr_31671_31722[(1)] = (2));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31668 === (24))){
var inst_31646 = (state_31667[(7)]);
var inst_31655 = cljs.core.swap_BANG_.call(null,mults,cljs.core.dissoc,inst_31646);
var state_31667__$1 = state_31667;
var statearr_31672_31723 = state_31667__$1;
(statearr_31672_31723[(2)] = inst_31655);

(statearr_31672_31723[(1)] = (25));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31668 === (4))){
var inst_31598 = (state_31667[(8)]);
var inst_31598__$1 = (state_31667[(2)]);
var inst_31599 = (inst_31598__$1 == null);
var state_31667__$1 = (function (){var statearr_31673 = state_31667;
(statearr_31673[(8)] = inst_31598__$1);

return statearr_31673;
})();
if(cljs.core.truth_(inst_31599)){
var statearr_31674_31724 = state_31667__$1;
(statearr_31674_31724[(1)] = (5));

} else {
var statearr_31675_31725 = state_31667__$1;
(statearr_31675_31725[(1)] = (6));

}

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31668 === (15))){
var inst_31640 = (state_31667[(2)]);
var state_31667__$1 = state_31667;
var statearr_31676_31726 = state_31667__$1;
(statearr_31676_31726[(2)] = inst_31640);

(statearr_31676_31726[(1)] = (12));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31668 === (21))){
var inst_31660 = (state_31667[(2)]);
var state_31667__$1 = (function (){var statearr_31677 = state_31667;
(statearr_31677[(9)] = inst_31660);

return statearr_31677;
})();
var statearr_31678_31727 = state_31667__$1;
(statearr_31678_31727[(2)] = null);

(statearr_31678_31727[(1)] = (2));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31668 === (13))){
var inst_31622 = (state_31667[(10)]);
var inst_31624 = cljs.core.chunked_seq_QMARK_.call(null,inst_31622);
var state_31667__$1 = state_31667;
if(inst_31624){
var statearr_31679_31728 = state_31667__$1;
(statearr_31679_31728[(1)] = (16));

} else {
var statearr_31680_31729 = state_31667__$1;
(statearr_31680_31729[(1)] = (17));

}

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31668 === (22))){
var inst_31652 = (state_31667[(2)]);
var state_31667__$1 = state_31667;
if(cljs.core.truth_(inst_31652)){
var statearr_31681_31730 = state_31667__$1;
(statearr_31681_31730[(1)] = (23));

} else {
var statearr_31682_31731 = state_31667__$1;
(statearr_31682_31731[(1)] = (24));

}

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31668 === (6))){
var inst_31598 = (state_31667[(8)]);
var inst_31648 = (state_31667[(11)]);
var inst_31646 = (state_31667[(7)]);
var inst_31646__$1 = topic_fn.call(null,inst_31598);
var inst_31647 = cljs.core.deref.call(null,mults);
var inst_31648__$1 = cljs.core.get.call(null,inst_31647,inst_31646__$1);
var state_31667__$1 = (function (){var statearr_31683 = state_31667;
(statearr_31683[(11)] = inst_31648__$1);

(statearr_31683[(7)] = inst_31646__$1);

return statearr_31683;
})();
if(cljs.core.truth_(inst_31648__$1)){
var statearr_31684_31732 = state_31667__$1;
(statearr_31684_31732[(1)] = (19));

} else {
var statearr_31685_31733 = state_31667__$1;
(statearr_31685_31733[(1)] = (20));

}

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31668 === (25))){
var inst_31657 = (state_31667[(2)]);
var state_31667__$1 = state_31667;
var statearr_31686_31734 = state_31667__$1;
(statearr_31686_31734[(2)] = inst_31657);

(statearr_31686_31734[(1)] = (21));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31668 === (17))){
var inst_31622 = (state_31667[(10)]);
var inst_31631 = cljs.core.first.call(null,inst_31622);
var inst_31632 = cljs.core.async.muxch_STAR_.call(null,inst_31631);
var inst_31633 = cljs.core.async.close_BANG_.call(null,inst_31632);
var inst_31634 = cljs.core.next.call(null,inst_31622);
var inst_31608 = inst_31634;
var inst_31609 = null;
var inst_31610 = (0);
var inst_31611 = (0);
var state_31667__$1 = (function (){var statearr_31687 = state_31667;
(statearr_31687[(12)] = inst_31610);

(statearr_31687[(13)] = inst_31611);

(statearr_31687[(14)] = inst_31633);

(statearr_31687[(15)] = inst_31609);

(statearr_31687[(16)] = inst_31608);

return statearr_31687;
})();
var statearr_31688_31735 = state_31667__$1;
(statearr_31688_31735[(2)] = null);

(statearr_31688_31735[(1)] = (8));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31668 === (3))){
var inst_31665 = (state_31667[(2)]);
var state_31667__$1 = state_31667;
return cljs.core.async.impl.ioc_helpers.return_chan.call(null,state_31667__$1,inst_31665);
} else {
if((state_val_31668 === (12))){
var inst_31642 = (state_31667[(2)]);
var state_31667__$1 = state_31667;
var statearr_31689_31736 = state_31667__$1;
(statearr_31689_31736[(2)] = inst_31642);

(statearr_31689_31736[(1)] = (9));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31668 === (2))){
var state_31667__$1 = state_31667;
return cljs.core.async.impl.ioc_helpers.take_BANG_.call(null,state_31667__$1,(4),ch);
} else {
if((state_val_31668 === (23))){
var state_31667__$1 = state_31667;
var statearr_31690_31737 = state_31667__$1;
(statearr_31690_31737[(2)] = null);

(statearr_31690_31737[(1)] = (25));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31668 === (19))){
var inst_31598 = (state_31667[(8)]);
var inst_31648 = (state_31667[(11)]);
var inst_31650 = cljs.core.async.muxch_STAR_.call(null,inst_31648);
var state_31667__$1 = state_31667;
return cljs.core.async.impl.ioc_helpers.put_BANG_.call(null,state_31667__$1,(22),inst_31650,inst_31598);
} else {
if((state_val_31668 === (11))){
var inst_31622 = (state_31667[(10)]);
var inst_31608 = (state_31667[(16)]);
var inst_31622__$1 = cljs.core.seq.call(null,inst_31608);
var state_31667__$1 = (function (){var statearr_31691 = state_31667;
(statearr_31691[(10)] = inst_31622__$1);

return statearr_31691;
})();
if(inst_31622__$1){
var statearr_31692_31738 = state_31667__$1;
(statearr_31692_31738[(1)] = (13));

} else {
var statearr_31693_31739 = state_31667__$1;
(statearr_31693_31739[(1)] = (14));

}

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31668 === (9))){
var inst_31644 = (state_31667[(2)]);
var state_31667__$1 = state_31667;
var statearr_31694_31740 = state_31667__$1;
(statearr_31694_31740[(2)] = inst_31644);

(statearr_31694_31740[(1)] = (7));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31668 === (5))){
var inst_31605 = cljs.core.deref.call(null,mults);
var inst_31606 = cljs.core.vals.call(null,inst_31605);
var inst_31607 = cljs.core.seq.call(null,inst_31606);
var inst_31608 = inst_31607;
var inst_31609 = null;
var inst_31610 = (0);
var inst_31611 = (0);
var state_31667__$1 = (function (){var statearr_31695 = state_31667;
(statearr_31695[(12)] = inst_31610);

(statearr_31695[(13)] = inst_31611);

(statearr_31695[(15)] = inst_31609);

(statearr_31695[(16)] = inst_31608);

return statearr_31695;
})();
var statearr_31696_31741 = state_31667__$1;
(statearr_31696_31741[(2)] = null);

(statearr_31696_31741[(1)] = (8));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31668 === (14))){
var state_31667__$1 = state_31667;
var statearr_31700_31742 = state_31667__$1;
(statearr_31700_31742[(2)] = null);

(statearr_31700_31742[(1)] = (15));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31668 === (16))){
var inst_31622 = (state_31667[(10)]);
var inst_31626 = cljs.core.chunk_first.call(null,inst_31622);
var inst_31627 = cljs.core.chunk_rest.call(null,inst_31622);
var inst_31628 = cljs.core.count.call(null,inst_31626);
var inst_31608 = inst_31627;
var inst_31609 = inst_31626;
var inst_31610 = inst_31628;
var inst_31611 = (0);
var state_31667__$1 = (function (){var statearr_31701 = state_31667;
(statearr_31701[(12)] = inst_31610);

(statearr_31701[(13)] = inst_31611);

(statearr_31701[(15)] = inst_31609);

(statearr_31701[(16)] = inst_31608);

return statearr_31701;
})();
var statearr_31702_31743 = state_31667__$1;
(statearr_31702_31743[(2)] = null);

(statearr_31702_31743[(1)] = (8));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31668 === (10))){
var inst_31610 = (state_31667[(12)]);
var inst_31611 = (state_31667[(13)]);
var inst_31609 = (state_31667[(15)]);
var inst_31608 = (state_31667[(16)]);
var inst_31616 = cljs.core._nth.call(null,inst_31609,inst_31611);
var inst_31617 = cljs.core.async.muxch_STAR_.call(null,inst_31616);
var inst_31618 = cljs.core.async.close_BANG_.call(null,inst_31617);
var inst_31619 = (inst_31611 + (1));
var tmp31697 = inst_31610;
var tmp31698 = inst_31609;
var tmp31699 = inst_31608;
var inst_31608__$1 = tmp31699;
var inst_31609__$1 = tmp31698;
var inst_31610__$1 = tmp31697;
var inst_31611__$1 = inst_31619;
var state_31667__$1 = (function (){var statearr_31703 = state_31667;
(statearr_31703[(12)] = inst_31610__$1);

(statearr_31703[(17)] = inst_31618);

(statearr_31703[(13)] = inst_31611__$1);

(statearr_31703[(15)] = inst_31609__$1);

(statearr_31703[(16)] = inst_31608__$1);

return statearr_31703;
})();
var statearr_31704_31744 = state_31667__$1;
(statearr_31704_31744[(2)] = null);

(statearr_31704_31744[(1)] = (8));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31668 === (18))){
var inst_31637 = (state_31667[(2)]);
var state_31667__$1 = state_31667;
var statearr_31705_31745 = state_31667__$1;
(statearr_31705_31745[(2)] = inst_31637);

(statearr_31705_31745[(1)] = (15));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31668 === (8))){
var inst_31610 = (state_31667[(12)]);
var inst_31611 = (state_31667[(13)]);
var inst_31613 = (inst_31611 < inst_31610);
var inst_31614 = inst_31613;
var state_31667__$1 = state_31667;
if(cljs.core.truth_(inst_31614)){
var statearr_31706_31746 = state_31667__$1;
(statearr_31706_31746[(1)] = (10));

} else {
var statearr_31707_31747 = state_31667__$1;
(statearr_31707_31747[(1)] = (11));

}

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
});})(c__27451__auto___31719,mults,ensure_mult,p))
;
return ((function (switch__27386__auto__,c__27451__auto___31719,mults,ensure_mult,p){
return (function() {
var cljs$core$async$state_machine__27387__auto__ = null;
var cljs$core$async$state_machine__27387__auto____0 = (function (){
var statearr_31711 = [null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null];
(statearr_31711[(0)] = cljs$core$async$state_machine__27387__auto__);

(statearr_31711[(1)] = (1));

return statearr_31711;
});
var cljs$core$async$state_machine__27387__auto____1 = (function (state_31667){
while(true){
var ret_value__27388__auto__ = (function (){try{while(true){
var result__27389__auto__ = switch__27386__auto__.call(null,state_31667);
if(cljs.core.keyword_identical_QMARK_.call(null,result__27389__auto__,new cljs.core.Keyword(null,"recur","recur",-437573268))){
continue;
} else {
return result__27389__auto__;
}
break;
}
}catch (e31712){if((e31712 instanceof Object)){
var ex__27390__auto__ = e31712;
var statearr_31713_31748 = state_31667;
(statearr_31713_31748[(5)] = ex__27390__auto__);


cljs.core.async.impl.ioc_helpers.process_exception.call(null,state_31667);

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
throw e31712;

}
}})();
if(cljs.core.keyword_identical_QMARK_.call(null,ret_value__27388__auto__,new cljs.core.Keyword(null,"recur","recur",-437573268))){
var G__31749 = state_31667;
state_31667 = G__31749;
continue;
} else {
return ret_value__27388__auto__;
}
break;
}
});
cljs$core$async$state_machine__27387__auto__ = function(state_31667){
switch(arguments.length){
case 0:
return cljs$core$async$state_machine__27387__auto____0.call(this);
case 1:
return cljs$core$async$state_machine__27387__auto____1.call(this,state_31667);
}
throw(new Error('Invalid arity: ' + arguments.length));
};
cljs$core$async$state_machine__27387__auto__.cljs$core$IFn$_invoke$arity$0 = cljs$core$async$state_machine__27387__auto____0;
cljs$core$async$state_machine__27387__auto__.cljs$core$IFn$_invoke$arity$1 = cljs$core$async$state_machine__27387__auto____1;
return cljs$core$async$state_machine__27387__auto__;
})()
;})(switch__27386__auto__,c__27451__auto___31719,mults,ensure_mult,p))
})();
var state__27453__auto__ = (function (){var statearr_31714 = f__27452__auto__.call(null);
(statearr_31714[cljs.core.async.impl.ioc_helpers.USER_START_IDX] = c__27451__auto___31719);

return statearr_31714;
})();
return cljs.core.async.impl.ioc_helpers.run_state_machine_wrapped.call(null,state__27453__auto__);
});})(c__27451__auto___31719,mults,ensure_mult,p))
);


return p;
});

cljs.core.async.pub.cljs$lang$maxFixedArity = 3;
/**
 * Subscribes a channel to a topic of a pub.
 * 
 *   By default the channel will be closed when the source closes,
 *   but can be determined by the close? parameter.
 */
cljs.core.async.sub = (function cljs$core$async$sub(var_args){
var args31750 = [];
var len__25999__auto___31753 = arguments.length;
var i__26000__auto___31754 = (0);
while(true){
if((i__26000__auto___31754 < len__25999__auto___31753)){
args31750.push((arguments[i__26000__auto___31754]));

var G__31755 = (i__26000__auto___31754 + (1));
i__26000__auto___31754 = G__31755;
continue;
} else {
}
break;
}

var G__31752 = args31750.length;
switch (G__31752) {
case 3:
return cljs.core.async.sub.cljs$core$IFn$_invoke$arity$3((arguments[(0)]),(arguments[(1)]),(arguments[(2)]));

break;
case 4:
return cljs.core.async.sub.cljs$core$IFn$_invoke$arity$4((arguments[(0)]),(arguments[(1)]),(arguments[(2)]),(arguments[(3)]));

break;
default:
throw (new Error([cljs.core.str("Invalid arity: "),cljs.core.str(args31750.length)].join('')));

}
});

cljs.core.async.sub.cljs$core$IFn$_invoke$arity$3 = (function (p,topic,ch){
return cljs.core.async.sub.call(null,p,topic,ch,true);
});

cljs.core.async.sub.cljs$core$IFn$_invoke$arity$4 = (function (p,topic,ch,close_QMARK_){
return cljs.core.async.sub_STAR_.call(null,p,topic,ch,close_QMARK_);
});

cljs.core.async.sub.cljs$lang$maxFixedArity = 4;
/**
 * Unsubscribes a channel from a topic of a pub
 */
cljs.core.async.unsub = (function cljs$core$async$unsub(p,topic,ch){
return cljs.core.async.unsub_STAR_.call(null,p,topic,ch);
});
/**
 * Unsubscribes all channels from a pub, or a topic of a pub
 */
cljs.core.async.unsub_all = (function cljs$core$async$unsub_all(var_args){
var args31757 = [];
var len__25999__auto___31760 = arguments.length;
var i__26000__auto___31761 = (0);
while(true){
if((i__26000__auto___31761 < len__25999__auto___31760)){
args31757.push((arguments[i__26000__auto___31761]));

var G__31762 = (i__26000__auto___31761 + (1));
i__26000__auto___31761 = G__31762;
continue;
} else {
}
break;
}

var G__31759 = args31757.length;
switch (G__31759) {
case 1:
return cljs.core.async.unsub_all.cljs$core$IFn$_invoke$arity$1((arguments[(0)]));

break;
case 2:
return cljs.core.async.unsub_all.cljs$core$IFn$_invoke$arity$2((arguments[(0)]),(arguments[(1)]));

break;
default:
throw (new Error([cljs.core.str("Invalid arity: "),cljs.core.str(args31757.length)].join('')));

}
});

cljs.core.async.unsub_all.cljs$core$IFn$_invoke$arity$1 = (function (p){
return cljs.core.async.unsub_all_STAR_.call(null,p);
});

cljs.core.async.unsub_all.cljs$core$IFn$_invoke$arity$2 = (function (p,topic){
return cljs.core.async.unsub_all_STAR_.call(null,p,topic);
});

cljs.core.async.unsub_all.cljs$lang$maxFixedArity = 2;
/**
 * Takes a function and a collection of source channels, and returns a
 *   channel which contains the values produced by applying f to the set
 *   of first items taken from each source channel, followed by applying
 *   f to the set of second items from each channel, until any one of the
 *   channels is closed, at which point the output channel will be
 *   closed. The returned channel will be unbuffered by default, or a
 *   buf-or-n can be supplied
 */
cljs.core.async.map = (function cljs$core$async$map(var_args){
var args31764 = [];
var len__25999__auto___31835 = arguments.length;
var i__26000__auto___31836 = (0);
while(true){
if((i__26000__auto___31836 < len__25999__auto___31835)){
args31764.push((arguments[i__26000__auto___31836]));

var G__31837 = (i__26000__auto___31836 + (1));
i__26000__auto___31836 = G__31837;
continue;
} else {
}
break;
}

var G__31766 = args31764.length;
switch (G__31766) {
case 2:
return cljs.core.async.map.cljs$core$IFn$_invoke$arity$2((arguments[(0)]),(arguments[(1)]));

break;
case 3:
return cljs.core.async.map.cljs$core$IFn$_invoke$arity$3((arguments[(0)]),(arguments[(1)]),(arguments[(2)]));

break;
default:
throw (new Error([cljs.core.str("Invalid arity: "),cljs.core.str(args31764.length)].join('')));

}
});

cljs.core.async.map.cljs$core$IFn$_invoke$arity$2 = (function (f,chs){
return cljs.core.async.map.call(null,f,chs,null);
});

cljs.core.async.map.cljs$core$IFn$_invoke$arity$3 = (function (f,chs,buf_or_n){
var chs__$1 = cljs.core.vec.call(null,chs);
var out = cljs.core.async.chan.call(null,buf_or_n);
var cnt = cljs.core.count.call(null,chs__$1);
var rets = cljs.core.object_array.call(null,cnt);
var dchan = cljs.core.async.chan.call(null,(1));
var dctr = cljs.core.atom.call(null,null);
var done = cljs.core.mapv.call(null,((function (chs__$1,out,cnt,rets,dchan,dctr){
return (function (i){
return ((function (chs__$1,out,cnt,rets,dchan,dctr){
return (function (ret){
(rets[i] = ret);

if((cljs.core.swap_BANG_.call(null,dctr,cljs.core.dec) === (0))){
return cljs.core.async.put_BANG_.call(null,dchan,rets.slice((0)));
} else {
return null;
}
});
;})(chs__$1,out,cnt,rets,dchan,dctr))
});})(chs__$1,out,cnt,rets,dchan,dctr))
,cljs.core.range.call(null,cnt));
var c__27451__auto___31839 = cljs.core.async.chan.call(null,(1));
cljs.core.async.impl.dispatch.run.call(null,((function (c__27451__auto___31839,chs__$1,out,cnt,rets,dchan,dctr,done){
return (function (){
var f__27452__auto__ = (function (){var switch__27386__auto__ = ((function (c__27451__auto___31839,chs__$1,out,cnt,rets,dchan,dctr,done){
return (function (state_31805){
var state_val_31806 = (state_31805[(1)]);
if((state_val_31806 === (7))){
var state_31805__$1 = state_31805;
var statearr_31807_31840 = state_31805__$1;
(statearr_31807_31840[(2)] = null);

(statearr_31807_31840[(1)] = (8));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31806 === (1))){
var state_31805__$1 = state_31805;
var statearr_31808_31841 = state_31805__$1;
(statearr_31808_31841[(2)] = null);

(statearr_31808_31841[(1)] = (2));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31806 === (4))){
var inst_31769 = (state_31805[(7)]);
var inst_31771 = (inst_31769 < cnt);
var state_31805__$1 = state_31805;
if(cljs.core.truth_(inst_31771)){
var statearr_31809_31842 = state_31805__$1;
(statearr_31809_31842[(1)] = (6));

} else {
var statearr_31810_31843 = state_31805__$1;
(statearr_31810_31843[(1)] = (7));

}

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31806 === (15))){
var inst_31801 = (state_31805[(2)]);
var state_31805__$1 = state_31805;
var statearr_31811_31844 = state_31805__$1;
(statearr_31811_31844[(2)] = inst_31801);

(statearr_31811_31844[(1)] = (3));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31806 === (13))){
var inst_31794 = cljs.core.async.close_BANG_.call(null,out);
var state_31805__$1 = state_31805;
var statearr_31812_31845 = state_31805__$1;
(statearr_31812_31845[(2)] = inst_31794);

(statearr_31812_31845[(1)] = (15));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31806 === (6))){
var state_31805__$1 = state_31805;
var statearr_31813_31846 = state_31805__$1;
(statearr_31813_31846[(2)] = null);

(statearr_31813_31846[(1)] = (11));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31806 === (3))){
var inst_31803 = (state_31805[(2)]);
var state_31805__$1 = state_31805;
return cljs.core.async.impl.ioc_helpers.return_chan.call(null,state_31805__$1,inst_31803);
} else {
if((state_val_31806 === (12))){
var inst_31791 = (state_31805[(8)]);
var inst_31791__$1 = (state_31805[(2)]);
var inst_31792 = cljs.core.some.call(null,cljs.core.nil_QMARK_,inst_31791__$1);
var state_31805__$1 = (function (){var statearr_31814 = state_31805;
(statearr_31814[(8)] = inst_31791__$1);

return statearr_31814;
})();
if(cljs.core.truth_(inst_31792)){
var statearr_31815_31847 = state_31805__$1;
(statearr_31815_31847[(1)] = (13));

} else {
var statearr_31816_31848 = state_31805__$1;
(statearr_31816_31848[(1)] = (14));

}

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31806 === (2))){
var inst_31768 = cljs.core.reset_BANG_.call(null,dctr,cnt);
var inst_31769 = (0);
var state_31805__$1 = (function (){var statearr_31817 = state_31805;
(statearr_31817[(9)] = inst_31768);

(statearr_31817[(7)] = inst_31769);

return statearr_31817;
})();
var statearr_31818_31849 = state_31805__$1;
(statearr_31818_31849[(2)] = null);

(statearr_31818_31849[(1)] = (4));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31806 === (11))){
var inst_31769 = (state_31805[(7)]);
var _ = cljs.core.async.impl.ioc_helpers.add_exception_frame.call(null,state_31805,(10),Object,null,(9));
var inst_31778 = chs__$1.call(null,inst_31769);
var inst_31779 = done.call(null,inst_31769);
var inst_31780 = cljs.core.async.take_BANG_.call(null,inst_31778,inst_31779);
var state_31805__$1 = state_31805;
var statearr_31819_31850 = state_31805__$1;
(statearr_31819_31850[(2)] = inst_31780);


cljs.core.async.impl.ioc_helpers.process_exception.call(null,state_31805__$1);

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31806 === (9))){
var inst_31769 = (state_31805[(7)]);
var inst_31782 = (state_31805[(2)]);
var inst_31783 = (inst_31769 + (1));
var inst_31769__$1 = inst_31783;
var state_31805__$1 = (function (){var statearr_31820 = state_31805;
(statearr_31820[(10)] = inst_31782);

(statearr_31820[(7)] = inst_31769__$1);

return statearr_31820;
})();
var statearr_31821_31851 = state_31805__$1;
(statearr_31821_31851[(2)] = null);

(statearr_31821_31851[(1)] = (4));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31806 === (5))){
var inst_31789 = (state_31805[(2)]);
var state_31805__$1 = (function (){var statearr_31822 = state_31805;
(statearr_31822[(11)] = inst_31789);

return statearr_31822;
})();
return cljs.core.async.impl.ioc_helpers.take_BANG_.call(null,state_31805__$1,(12),dchan);
} else {
if((state_val_31806 === (14))){
var inst_31791 = (state_31805[(8)]);
var inst_31796 = cljs.core.apply.call(null,f,inst_31791);
var state_31805__$1 = state_31805;
return cljs.core.async.impl.ioc_helpers.put_BANG_.call(null,state_31805__$1,(16),out,inst_31796);
} else {
if((state_val_31806 === (16))){
var inst_31798 = (state_31805[(2)]);
var state_31805__$1 = (function (){var statearr_31823 = state_31805;
(statearr_31823[(12)] = inst_31798);

return statearr_31823;
})();
var statearr_31824_31852 = state_31805__$1;
(statearr_31824_31852[(2)] = null);

(statearr_31824_31852[(1)] = (2));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31806 === (10))){
var inst_31773 = (state_31805[(2)]);
var inst_31774 = cljs.core.swap_BANG_.call(null,dctr,cljs.core.dec);
var state_31805__$1 = (function (){var statearr_31825 = state_31805;
(statearr_31825[(13)] = inst_31773);

return statearr_31825;
})();
var statearr_31826_31853 = state_31805__$1;
(statearr_31826_31853[(2)] = inst_31774);


cljs.core.async.impl.ioc_helpers.process_exception.call(null,state_31805__$1);

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31806 === (8))){
var inst_31787 = (state_31805[(2)]);
var state_31805__$1 = state_31805;
var statearr_31827_31854 = state_31805__$1;
(statearr_31827_31854[(2)] = inst_31787);

(statearr_31827_31854[(1)] = (5));


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
}
});})(c__27451__auto___31839,chs__$1,out,cnt,rets,dchan,dctr,done))
;
return ((function (switch__27386__auto__,c__27451__auto___31839,chs__$1,out,cnt,rets,dchan,dctr,done){
return (function() {
var cljs$core$async$state_machine__27387__auto__ = null;
var cljs$core$async$state_machine__27387__auto____0 = (function (){
var statearr_31831 = [null,null,null,null,null,null,null,null,null,null,null,null,null,null];
(statearr_31831[(0)] = cljs$core$async$state_machine__27387__auto__);

(statearr_31831[(1)] = (1));

return statearr_31831;
});
var cljs$core$async$state_machine__27387__auto____1 = (function (state_31805){
while(true){
var ret_value__27388__auto__ = (function (){try{while(true){
var result__27389__auto__ = switch__27386__auto__.call(null,state_31805);
if(cljs.core.keyword_identical_QMARK_.call(null,result__27389__auto__,new cljs.core.Keyword(null,"recur","recur",-437573268))){
continue;
} else {
return result__27389__auto__;
}
break;
}
}catch (e31832){if((e31832 instanceof Object)){
var ex__27390__auto__ = e31832;
var statearr_31833_31855 = state_31805;
(statearr_31833_31855[(5)] = ex__27390__auto__);


cljs.core.async.impl.ioc_helpers.process_exception.call(null,state_31805);

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
throw e31832;

}
}})();
if(cljs.core.keyword_identical_QMARK_.call(null,ret_value__27388__auto__,new cljs.core.Keyword(null,"recur","recur",-437573268))){
var G__31856 = state_31805;
state_31805 = G__31856;
continue;
} else {
return ret_value__27388__auto__;
}
break;
}
});
cljs$core$async$state_machine__27387__auto__ = function(state_31805){
switch(arguments.length){
case 0:
return cljs$core$async$state_machine__27387__auto____0.call(this);
case 1:
return cljs$core$async$state_machine__27387__auto____1.call(this,state_31805);
}
throw(new Error('Invalid arity: ' + arguments.length));
};
cljs$core$async$state_machine__27387__auto__.cljs$core$IFn$_invoke$arity$0 = cljs$core$async$state_machine__27387__auto____0;
cljs$core$async$state_machine__27387__auto__.cljs$core$IFn$_invoke$arity$1 = cljs$core$async$state_machine__27387__auto____1;
return cljs$core$async$state_machine__27387__auto__;
})()
;})(switch__27386__auto__,c__27451__auto___31839,chs__$1,out,cnt,rets,dchan,dctr,done))
})();
var state__27453__auto__ = (function (){var statearr_31834 = f__27452__auto__.call(null);
(statearr_31834[cljs.core.async.impl.ioc_helpers.USER_START_IDX] = c__27451__auto___31839);

return statearr_31834;
})();
return cljs.core.async.impl.ioc_helpers.run_state_machine_wrapped.call(null,state__27453__auto__);
});})(c__27451__auto___31839,chs__$1,out,cnt,rets,dchan,dctr,done))
);


return out;
});

cljs.core.async.map.cljs$lang$maxFixedArity = 3;
/**
 * Takes a collection of source channels and returns a channel which
 *   contains all values taken from them. The returned channel will be
 *   unbuffered by default, or a buf-or-n can be supplied. The channel
 *   will close after all the source channels have closed.
 */
cljs.core.async.merge = (function cljs$core$async$merge(var_args){
var args31858 = [];
var len__25999__auto___31914 = arguments.length;
var i__26000__auto___31915 = (0);
while(true){
if((i__26000__auto___31915 < len__25999__auto___31914)){
args31858.push((arguments[i__26000__auto___31915]));

var G__31916 = (i__26000__auto___31915 + (1));
i__26000__auto___31915 = G__31916;
continue;
} else {
}
break;
}

var G__31860 = args31858.length;
switch (G__31860) {
case 1:
return cljs.core.async.merge.cljs$core$IFn$_invoke$arity$1((arguments[(0)]));

break;
case 2:
return cljs.core.async.merge.cljs$core$IFn$_invoke$arity$2((arguments[(0)]),(arguments[(1)]));

break;
default:
throw (new Error([cljs.core.str("Invalid arity: "),cljs.core.str(args31858.length)].join('')));

}
});

cljs.core.async.merge.cljs$core$IFn$_invoke$arity$1 = (function (chs){
return cljs.core.async.merge.call(null,chs,null);
});

cljs.core.async.merge.cljs$core$IFn$_invoke$arity$2 = (function (chs,buf_or_n){
var out = cljs.core.async.chan.call(null,buf_or_n);
var c__27451__auto___31918 = cljs.core.async.chan.call(null,(1));
cljs.core.async.impl.dispatch.run.call(null,((function (c__27451__auto___31918,out){
return (function (){
var f__27452__auto__ = (function (){var switch__27386__auto__ = ((function (c__27451__auto___31918,out){
return (function (state_31890){
var state_val_31891 = (state_31890[(1)]);
if((state_val_31891 === (7))){
var inst_31869 = (state_31890[(7)]);
var inst_31870 = (state_31890[(8)]);
var inst_31869__$1 = (state_31890[(2)]);
var inst_31870__$1 = cljs.core.nth.call(null,inst_31869__$1,(0),null);
var inst_31871 = cljs.core.nth.call(null,inst_31869__$1,(1),null);
var inst_31872 = (inst_31870__$1 == null);
var state_31890__$1 = (function (){var statearr_31892 = state_31890;
(statearr_31892[(7)] = inst_31869__$1);

(statearr_31892[(9)] = inst_31871);

(statearr_31892[(8)] = inst_31870__$1);

return statearr_31892;
})();
if(cljs.core.truth_(inst_31872)){
var statearr_31893_31919 = state_31890__$1;
(statearr_31893_31919[(1)] = (8));

} else {
var statearr_31894_31920 = state_31890__$1;
(statearr_31894_31920[(1)] = (9));

}

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31891 === (1))){
var inst_31861 = cljs.core.vec.call(null,chs);
var inst_31862 = inst_31861;
var state_31890__$1 = (function (){var statearr_31895 = state_31890;
(statearr_31895[(10)] = inst_31862);

return statearr_31895;
})();
var statearr_31896_31921 = state_31890__$1;
(statearr_31896_31921[(2)] = null);

(statearr_31896_31921[(1)] = (2));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31891 === (4))){
var inst_31862 = (state_31890[(10)]);
var state_31890__$1 = state_31890;
return cljs.core.async.ioc_alts_BANG_.call(null,state_31890__$1,(7),inst_31862);
} else {
if((state_val_31891 === (6))){
var inst_31886 = (state_31890[(2)]);
var state_31890__$1 = state_31890;
var statearr_31897_31922 = state_31890__$1;
(statearr_31897_31922[(2)] = inst_31886);

(statearr_31897_31922[(1)] = (3));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31891 === (3))){
var inst_31888 = (state_31890[(2)]);
var state_31890__$1 = state_31890;
return cljs.core.async.impl.ioc_helpers.return_chan.call(null,state_31890__$1,inst_31888);
} else {
if((state_val_31891 === (2))){
var inst_31862 = (state_31890[(10)]);
var inst_31864 = cljs.core.count.call(null,inst_31862);
var inst_31865 = (inst_31864 > (0));
var state_31890__$1 = state_31890;
if(cljs.core.truth_(inst_31865)){
var statearr_31899_31923 = state_31890__$1;
(statearr_31899_31923[(1)] = (4));

} else {
var statearr_31900_31924 = state_31890__$1;
(statearr_31900_31924[(1)] = (5));

}

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31891 === (11))){
var inst_31862 = (state_31890[(10)]);
var inst_31879 = (state_31890[(2)]);
var tmp31898 = inst_31862;
var inst_31862__$1 = tmp31898;
var state_31890__$1 = (function (){var statearr_31901 = state_31890;
(statearr_31901[(10)] = inst_31862__$1);

(statearr_31901[(11)] = inst_31879);

return statearr_31901;
})();
var statearr_31902_31925 = state_31890__$1;
(statearr_31902_31925[(2)] = null);

(statearr_31902_31925[(1)] = (2));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31891 === (9))){
var inst_31870 = (state_31890[(8)]);
var state_31890__$1 = state_31890;
return cljs.core.async.impl.ioc_helpers.put_BANG_.call(null,state_31890__$1,(11),out,inst_31870);
} else {
if((state_val_31891 === (5))){
var inst_31884 = cljs.core.async.close_BANG_.call(null,out);
var state_31890__$1 = state_31890;
var statearr_31903_31926 = state_31890__$1;
(statearr_31903_31926[(2)] = inst_31884);

(statearr_31903_31926[(1)] = (6));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31891 === (10))){
var inst_31882 = (state_31890[(2)]);
var state_31890__$1 = state_31890;
var statearr_31904_31927 = state_31890__$1;
(statearr_31904_31927[(2)] = inst_31882);

(statearr_31904_31927[(1)] = (6));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31891 === (8))){
var inst_31862 = (state_31890[(10)]);
var inst_31869 = (state_31890[(7)]);
var inst_31871 = (state_31890[(9)]);
var inst_31870 = (state_31890[(8)]);
var inst_31874 = (function (){var cs = inst_31862;
var vec__31867 = inst_31869;
var v = inst_31870;
var c = inst_31871;
return ((function (cs,vec__31867,v,c,inst_31862,inst_31869,inst_31871,inst_31870,state_val_31891,c__27451__auto___31918,out){
return (function (p1__31857_SHARP_){
return cljs.core.not_EQ_.call(null,c,p1__31857_SHARP_);
});
;})(cs,vec__31867,v,c,inst_31862,inst_31869,inst_31871,inst_31870,state_val_31891,c__27451__auto___31918,out))
})();
var inst_31875 = cljs.core.filterv.call(null,inst_31874,inst_31862);
var inst_31862__$1 = inst_31875;
var state_31890__$1 = (function (){var statearr_31905 = state_31890;
(statearr_31905[(10)] = inst_31862__$1);

return statearr_31905;
})();
var statearr_31906_31928 = state_31890__$1;
(statearr_31906_31928[(2)] = null);

(statearr_31906_31928[(1)] = (2));


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
});})(c__27451__auto___31918,out))
;
return ((function (switch__27386__auto__,c__27451__auto___31918,out){
return (function() {
var cljs$core$async$state_machine__27387__auto__ = null;
var cljs$core$async$state_machine__27387__auto____0 = (function (){
var statearr_31910 = [null,null,null,null,null,null,null,null,null,null,null,null];
(statearr_31910[(0)] = cljs$core$async$state_machine__27387__auto__);

(statearr_31910[(1)] = (1));

return statearr_31910;
});
var cljs$core$async$state_machine__27387__auto____1 = (function (state_31890){
while(true){
var ret_value__27388__auto__ = (function (){try{while(true){
var result__27389__auto__ = switch__27386__auto__.call(null,state_31890);
if(cljs.core.keyword_identical_QMARK_.call(null,result__27389__auto__,new cljs.core.Keyword(null,"recur","recur",-437573268))){
continue;
} else {
return result__27389__auto__;
}
break;
}
}catch (e31911){if((e31911 instanceof Object)){
var ex__27390__auto__ = e31911;
var statearr_31912_31929 = state_31890;
(statearr_31912_31929[(5)] = ex__27390__auto__);


cljs.core.async.impl.ioc_helpers.process_exception.call(null,state_31890);

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
throw e31911;

}
}})();
if(cljs.core.keyword_identical_QMARK_.call(null,ret_value__27388__auto__,new cljs.core.Keyword(null,"recur","recur",-437573268))){
var G__31930 = state_31890;
state_31890 = G__31930;
continue;
} else {
return ret_value__27388__auto__;
}
break;
}
});
cljs$core$async$state_machine__27387__auto__ = function(state_31890){
switch(arguments.length){
case 0:
return cljs$core$async$state_machine__27387__auto____0.call(this);
case 1:
return cljs$core$async$state_machine__27387__auto____1.call(this,state_31890);
}
throw(new Error('Invalid arity: ' + arguments.length));
};
cljs$core$async$state_machine__27387__auto__.cljs$core$IFn$_invoke$arity$0 = cljs$core$async$state_machine__27387__auto____0;
cljs$core$async$state_machine__27387__auto__.cljs$core$IFn$_invoke$arity$1 = cljs$core$async$state_machine__27387__auto____1;
return cljs$core$async$state_machine__27387__auto__;
})()
;})(switch__27386__auto__,c__27451__auto___31918,out))
})();
var state__27453__auto__ = (function (){var statearr_31913 = f__27452__auto__.call(null);
(statearr_31913[cljs.core.async.impl.ioc_helpers.USER_START_IDX] = c__27451__auto___31918);

return statearr_31913;
})();
return cljs.core.async.impl.ioc_helpers.run_state_machine_wrapped.call(null,state__27453__auto__);
});})(c__27451__auto___31918,out))
);


return out;
});

cljs.core.async.merge.cljs$lang$maxFixedArity = 2;
/**
 * Returns a channel containing the single (collection) result of the
 *   items taken from the channel conjoined to the supplied
 *   collection. ch must close before into produces a result.
 */
cljs.core.async.into = (function cljs$core$async$into(coll,ch){
return cljs.core.async.reduce.call(null,cljs.core.conj,coll,ch);
});
/**
 * Returns a channel that will return, at most, n items from ch. After n items
 * have been returned, or ch has been closed, the return chanel will close.
 * 
 *   The output channel is unbuffered by default, unless buf-or-n is given.
 */
cljs.core.async.take = (function cljs$core$async$take(var_args){
var args31931 = [];
var len__25999__auto___31980 = arguments.length;
var i__26000__auto___31981 = (0);
while(true){
if((i__26000__auto___31981 < len__25999__auto___31980)){
args31931.push((arguments[i__26000__auto___31981]));

var G__31982 = (i__26000__auto___31981 + (1));
i__26000__auto___31981 = G__31982;
continue;
} else {
}
break;
}

var G__31933 = args31931.length;
switch (G__31933) {
case 2:
return cljs.core.async.take.cljs$core$IFn$_invoke$arity$2((arguments[(0)]),(arguments[(1)]));

break;
case 3:
return cljs.core.async.take.cljs$core$IFn$_invoke$arity$3((arguments[(0)]),(arguments[(1)]),(arguments[(2)]));

break;
default:
throw (new Error([cljs.core.str("Invalid arity: "),cljs.core.str(args31931.length)].join('')));

}
});

cljs.core.async.take.cljs$core$IFn$_invoke$arity$2 = (function (n,ch){
return cljs.core.async.take.call(null,n,ch,null);
});

cljs.core.async.take.cljs$core$IFn$_invoke$arity$3 = (function (n,ch,buf_or_n){
var out = cljs.core.async.chan.call(null,buf_or_n);
var c__27451__auto___31984 = cljs.core.async.chan.call(null,(1));
cljs.core.async.impl.dispatch.run.call(null,((function (c__27451__auto___31984,out){
return (function (){
var f__27452__auto__ = (function (){var switch__27386__auto__ = ((function (c__27451__auto___31984,out){
return (function (state_31957){
var state_val_31958 = (state_31957[(1)]);
if((state_val_31958 === (7))){
var inst_31939 = (state_31957[(7)]);
var inst_31939__$1 = (state_31957[(2)]);
var inst_31940 = (inst_31939__$1 == null);
var inst_31941 = cljs.core.not.call(null,inst_31940);
var state_31957__$1 = (function (){var statearr_31959 = state_31957;
(statearr_31959[(7)] = inst_31939__$1);

return statearr_31959;
})();
if(inst_31941){
var statearr_31960_31985 = state_31957__$1;
(statearr_31960_31985[(1)] = (8));

} else {
var statearr_31961_31986 = state_31957__$1;
(statearr_31961_31986[(1)] = (9));

}

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31958 === (1))){
var inst_31934 = (0);
var state_31957__$1 = (function (){var statearr_31962 = state_31957;
(statearr_31962[(8)] = inst_31934);

return statearr_31962;
})();
var statearr_31963_31987 = state_31957__$1;
(statearr_31963_31987[(2)] = null);

(statearr_31963_31987[(1)] = (2));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31958 === (4))){
var state_31957__$1 = state_31957;
return cljs.core.async.impl.ioc_helpers.take_BANG_.call(null,state_31957__$1,(7),ch);
} else {
if((state_val_31958 === (6))){
var inst_31952 = (state_31957[(2)]);
var state_31957__$1 = state_31957;
var statearr_31964_31988 = state_31957__$1;
(statearr_31964_31988[(2)] = inst_31952);

(statearr_31964_31988[(1)] = (3));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31958 === (3))){
var inst_31954 = (state_31957[(2)]);
var inst_31955 = cljs.core.async.close_BANG_.call(null,out);
var state_31957__$1 = (function (){var statearr_31965 = state_31957;
(statearr_31965[(9)] = inst_31954);

return statearr_31965;
})();
return cljs.core.async.impl.ioc_helpers.return_chan.call(null,state_31957__$1,inst_31955);
} else {
if((state_val_31958 === (2))){
var inst_31934 = (state_31957[(8)]);
var inst_31936 = (inst_31934 < n);
var state_31957__$1 = state_31957;
if(cljs.core.truth_(inst_31936)){
var statearr_31966_31989 = state_31957__$1;
(statearr_31966_31989[(1)] = (4));

} else {
var statearr_31967_31990 = state_31957__$1;
(statearr_31967_31990[(1)] = (5));

}

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31958 === (11))){
var inst_31934 = (state_31957[(8)]);
var inst_31944 = (state_31957[(2)]);
var inst_31945 = (inst_31934 + (1));
var inst_31934__$1 = inst_31945;
var state_31957__$1 = (function (){var statearr_31968 = state_31957;
(statearr_31968[(10)] = inst_31944);

(statearr_31968[(8)] = inst_31934__$1);

return statearr_31968;
})();
var statearr_31969_31991 = state_31957__$1;
(statearr_31969_31991[(2)] = null);

(statearr_31969_31991[(1)] = (2));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31958 === (9))){
var state_31957__$1 = state_31957;
var statearr_31970_31992 = state_31957__$1;
(statearr_31970_31992[(2)] = null);

(statearr_31970_31992[(1)] = (10));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31958 === (5))){
var state_31957__$1 = state_31957;
var statearr_31971_31993 = state_31957__$1;
(statearr_31971_31993[(2)] = null);

(statearr_31971_31993[(1)] = (6));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31958 === (10))){
var inst_31949 = (state_31957[(2)]);
var state_31957__$1 = state_31957;
var statearr_31972_31994 = state_31957__$1;
(statearr_31972_31994[(2)] = inst_31949);

(statearr_31972_31994[(1)] = (6));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_31958 === (8))){
var inst_31939 = (state_31957[(7)]);
var state_31957__$1 = state_31957;
return cljs.core.async.impl.ioc_helpers.put_BANG_.call(null,state_31957__$1,(11),out,inst_31939);
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
});})(c__27451__auto___31984,out))
;
return ((function (switch__27386__auto__,c__27451__auto___31984,out){
return (function() {
var cljs$core$async$state_machine__27387__auto__ = null;
var cljs$core$async$state_machine__27387__auto____0 = (function (){
var statearr_31976 = [null,null,null,null,null,null,null,null,null,null,null];
(statearr_31976[(0)] = cljs$core$async$state_machine__27387__auto__);

(statearr_31976[(1)] = (1));

return statearr_31976;
});
var cljs$core$async$state_machine__27387__auto____1 = (function (state_31957){
while(true){
var ret_value__27388__auto__ = (function (){try{while(true){
var result__27389__auto__ = switch__27386__auto__.call(null,state_31957);
if(cljs.core.keyword_identical_QMARK_.call(null,result__27389__auto__,new cljs.core.Keyword(null,"recur","recur",-437573268))){
continue;
} else {
return result__27389__auto__;
}
break;
}
}catch (e31977){if((e31977 instanceof Object)){
var ex__27390__auto__ = e31977;
var statearr_31978_31995 = state_31957;
(statearr_31978_31995[(5)] = ex__27390__auto__);


cljs.core.async.impl.ioc_helpers.process_exception.call(null,state_31957);

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
throw e31977;

}
}})();
if(cljs.core.keyword_identical_QMARK_.call(null,ret_value__27388__auto__,new cljs.core.Keyword(null,"recur","recur",-437573268))){
var G__31996 = state_31957;
state_31957 = G__31996;
continue;
} else {
return ret_value__27388__auto__;
}
break;
}
});
cljs$core$async$state_machine__27387__auto__ = function(state_31957){
switch(arguments.length){
case 0:
return cljs$core$async$state_machine__27387__auto____0.call(this);
case 1:
return cljs$core$async$state_machine__27387__auto____1.call(this,state_31957);
}
throw(new Error('Invalid arity: ' + arguments.length));
};
cljs$core$async$state_machine__27387__auto__.cljs$core$IFn$_invoke$arity$0 = cljs$core$async$state_machine__27387__auto____0;
cljs$core$async$state_machine__27387__auto__.cljs$core$IFn$_invoke$arity$1 = cljs$core$async$state_machine__27387__auto____1;
return cljs$core$async$state_machine__27387__auto__;
})()
;})(switch__27386__auto__,c__27451__auto___31984,out))
})();
var state__27453__auto__ = (function (){var statearr_31979 = f__27452__auto__.call(null);
(statearr_31979[cljs.core.async.impl.ioc_helpers.USER_START_IDX] = c__27451__auto___31984);

return statearr_31979;
})();
return cljs.core.async.impl.ioc_helpers.run_state_machine_wrapped.call(null,state__27453__auto__);
});})(c__27451__auto___31984,out))
);


return out;
});

cljs.core.async.take.cljs$lang$maxFixedArity = 3;
/**
 * Deprecated - this function will be removed. Use transducer instead
 */
cljs.core.async.map_LT_ = (function cljs$core$async$map_LT_(f,ch){
if(typeof cljs.core.async.t_cljs$core$async32004 !== 'undefined'){
} else {

/**
* @constructor
 * @implements {cljs.core.async.impl.protocols.Channel}
 * @implements {cljs.core.async.impl.protocols.WritePort}
 * @implements {cljs.core.async.impl.protocols.ReadPort}
 * @implements {cljs.core.IMeta}
 * @implements {cljs.core.IWithMeta}
*/
cljs.core.async.t_cljs$core$async32004 = (function (map_LT_,f,ch,meta32005){
this.map_LT_ = map_LT_;
this.f = f;
this.ch = ch;
this.meta32005 = meta32005;
this.cljs$lang$protocol_mask$partition0$ = 393216;
this.cljs$lang$protocol_mask$partition1$ = 0;
})
cljs.core.async.t_cljs$core$async32004.prototype.cljs$core$IWithMeta$_with_meta$arity$2 = (function (_32006,meta32005__$1){
var self__ = this;
var _32006__$1 = this;
return (new cljs.core.async.t_cljs$core$async32004(self__.map_LT_,self__.f,self__.ch,meta32005__$1));
});

cljs.core.async.t_cljs$core$async32004.prototype.cljs$core$IMeta$_meta$arity$1 = (function (_32006){
var self__ = this;
var _32006__$1 = this;
return self__.meta32005;
});

cljs.core.async.t_cljs$core$async32004.prototype.cljs$core$async$impl$protocols$Channel$ = true;

cljs.core.async.t_cljs$core$async32004.prototype.cljs$core$async$impl$protocols$Channel$close_BANG_$arity$1 = (function (_){
var self__ = this;
var ___$1 = this;
return cljs.core.async.impl.protocols.close_BANG_.call(null,self__.ch);
});

cljs.core.async.t_cljs$core$async32004.prototype.cljs$core$async$impl$protocols$Channel$closed_QMARK_$arity$1 = (function (_){
var self__ = this;
var ___$1 = this;
return cljs.core.async.impl.protocols.closed_QMARK_.call(null,self__.ch);
});

cljs.core.async.t_cljs$core$async32004.prototype.cljs$core$async$impl$protocols$ReadPort$ = true;

cljs.core.async.t_cljs$core$async32004.prototype.cljs$core$async$impl$protocols$ReadPort$take_BANG_$arity$2 = (function (_,fn1){
var self__ = this;
var ___$1 = this;
var ret = cljs.core.async.impl.protocols.take_BANG_.call(null,self__.ch,(function (){
if(typeof cljs.core.async.t_cljs$core$async32007 !== 'undefined'){
} else {

/**
* @constructor
 * @implements {cljs.core.async.impl.protocols.Handler}
 * @implements {cljs.core.IMeta}
 * @implements {cljs.core.IWithMeta}
*/
cljs.core.async.t_cljs$core$async32007 = (function (map_LT_,f,ch,meta32005,_,fn1,meta32008){
this.map_LT_ = map_LT_;
this.f = f;
this.ch = ch;
this.meta32005 = meta32005;
this._ = _;
this.fn1 = fn1;
this.meta32008 = meta32008;
this.cljs$lang$protocol_mask$partition0$ = 393216;
this.cljs$lang$protocol_mask$partition1$ = 0;
})
cljs.core.async.t_cljs$core$async32007.prototype.cljs$core$IWithMeta$_with_meta$arity$2 = ((function (___$1){
return (function (_32009,meta32008__$1){
var self__ = this;
var _32009__$1 = this;
return (new cljs.core.async.t_cljs$core$async32007(self__.map_LT_,self__.f,self__.ch,self__.meta32005,self__._,self__.fn1,meta32008__$1));
});})(___$1))
;

cljs.core.async.t_cljs$core$async32007.prototype.cljs$core$IMeta$_meta$arity$1 = ((function (___$1){
return (function (_32009){
var self__ = this;
var _32009__$1 = this;
return self__.meta32008;
});})(___$1))
;

cljs.core.async.t_cljs$core$async32007.prototype.cljs$core$async$impl$protocols$Handler$ = true;

cljs.core.async.t_cljs$core$async32007.prototype.cljs$core$async$impl$protocols$Handler$active_QMARK_$arity$1 = ((function (___$1){
return (function (___$1){
var self__ = this;
var ___$2 = this;
return cljs.core.async.impl.protocols.active_QMARK_.call(null,self__.fn1);
});})(___$1))
;

cljs.core.async.t_cljs$core$async32007.prototype.cljs$core$async$impl$protocols$Handler$blockable_QMARK_$arity$1 = ((function (___$1){
return (function (___$1){
var self__ = this;
var ___$2 = this;
return true;
});})(___$1))
;

cljs.core.async.t_cljs$core$async32007.prototype.cljs$core$async$impl$protocols$Handler$commit$arity$1 = ((function (___$1){
return (function (___$1){
var self__ = this;
var ___$2 = this;
var f1 = cljs.core.async.impl.protocols.commit.call(null,self__.fn1);
return ((function (f1,___$2,___$1){
return (function (p1__31997_SHARP_){
return f1.call(null,(((p1__31997_SHARP_ == null))?null:self__.f.call(null,p1__31997_SHARP_)));
});
;})(f1,___$2,___$1))
});})(___$1))
;

cljs.core.async.t_cljs$core$async32007.getBasis = ((function (___$1){
return (function (){
return new cljs.core.PersistentVector(null, 7, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.with_meta(new cljs.core.Symbol(null,"map<","map<",-1235808357,null),new cljs.core.PersistentArrayMap(null, 2, [new cljs.core.Keyword(null,"arglists","arglists",1661989754),cljs.core.list(new cljs.core.Symbol(null,"quote","quote",1377916282,null),cljs.core.list(new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Symbol(null,"f","f",43394975,null),new cljs.core.Symbol(null,"ch","ch",1085813622,null)], null))),new cljs.core.Keyword(null,"doc","doc",1913296891),"Deprecated - this function will be removed. Use transducer instead"], null)),new cljs.core.Symbol(null,"f","f",43394975,null),new cljs.core.Symbol(null,"ch","ch",1085813622,null),new cljs.core.Symbol(null,"meta32005","meta32005",469036161,null),cljs.core.with_meta(new cljs.core.Symbol(null,"_","_",-1201019570,null),new cljs.core.PersistentArrayMap(null, 1, [new cljs.core.Keyword(null,"tag","tag",-1290361223),new cljs.core.Symbol("cljs.core.async","t_cljs$core$async32004","cljs.core.async/t_cljs$core$async32004",1793738204,null)], null)),new cljs.core.Symbol(null,"fn1","fn1",895834444,null),new cljs.core.Symbol(null,"meta32008","meta32008",-31550480,null)], null);
});})(___$1))
;

cljs.core.async.t_cljs$core$async32007.cljs$lang$type = true;

cljs.core.async.t_cljs$core$async32007.cljs$lang$ctorStr = "cljs.core.async/t_cljs$core$async32007";

cljs.core.async.t_cljs$core$async32007.cljs$lang$ctorPrWriter = ((function (___$1){
return (function (this__25539__auto__,writer__25540__auto__,opt__25541__auto__){
return cljs.core._write.call(null,writer__25540__auto__,"cljs.core.async/t_cljs$core$async32007");
});})(___$1))
;

cljs.core.async.__GT_t_cljs$core$async32007 = ((function (___$1){
return (function cljs$core$async$map_LT__$___GT_t_cljs$core$async32007(map_LT___$1,f__$1,ch__$1,meta32005__$1,___$2,fn1__$1,meta32008){
return (new cljs.core.async.t_cljs$core$async32007(map_LT___$1,f__$1,ch__$1,meta32005__$1,___$2,fn1__$1,meta32008));
});})(___$1))
;

}

return (new cljs.core.async.t_cljs$core$async32007(self__.map_LT_,self__.f,self__.ch,self__.meta32005,___$1,fn1,cljs.core.PersistentArrayMap.EMPTY));
})()
);
if(cljs.core.truth_((function (){var and__24929__auto__ = ret;
if(cljs.core.truth_(and__24929__auto__)){
return !((cljs.core.deref.call(null,ret) == null));
} else {
return and__24929__auto__;
}
})())){
return cljs.core.async.impl.channels.box.call(null,self__.f.call(null,cljs.core.deref.call(null,ret)));
} else {
return ret;
}
});

cljs.core.async.t_cljs$core$async32004.prototype.cljs$core$async$impl$protocols$WritePort$ = true;

cljs.core.async.t_cljs$core$async32004.prototype.cljs$core$async$impl$protocols$WritePort$put_BANG_$arity$3 = (function (_,val,fn1){
var self__ = this;
var ___$1 = this;
return cljs.core.async.impl.protocols.put_BANG_.call(null,self__.ch,val,fn1);
});

cljs.core.async.t_cljs$core$async32004.getBasis = (function (){
return new cljs.core.PersistentVector(null, 4, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.with_meta(new cljs.core.Symbol(null,"map<","map<",-1235808357,null),new cljs.core.PersistentArrayMap(null, 2, [new cljs.core.Keyword(null,"arglists","arglists",1661989754),cljs.core.list(new cljs.core.Symbol(null,"quote","quote",1377916282,null),cljs.core.list(new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Symbol(null,"f","f",43394975,null),new cljs.core.Symbol(null,"ch","ch",1085813622,null)], null))),new cljs.core.Keyword(null,"doc","doc",1913296891),"Deprecated - this function will be removed. Use transducer instead"], null)),new cljs.core.Symbol(null,"f","f",43394975,null),new cljs.core.Symbol(null,"ch","ch",1085813622,null),new cljs.core.Symbol(null,"meta32005","meta32005",469036161,null)], null);
});

cljs.core.async.t_cljs$core$async32004.cljs$lang$type = true;

cljs.core.async.t_cljs$core$async32004.cljs$lang$ctorStr = "cljs.core.async/t_cljs$core$async32004";

cljs.core.async.t_cljs$core$async32004.cljs$lang$ctorPrWriter = (function (this__25539__auto__,writer__25540__auto__,opt__25541__auto__){
return cljs.core._write.call(null,writer__25540__auto__,"cljs.core.async/t_cljs$core$async32004");
});

cljs.core.async.__GT_t_cljs$core$async32004 = (function cljs$core$async$map_LT__$___GT_t_cljs$core$async32004(map_LT___$1,f__$1,ch__$1,meta32005){
return (new cljs.core.async.t_cljs$core$async32004(map_LT___$1,f__$1,ch__$1,meta32005));
});

}

return (new cljs.core.async.t_cljs$core$async32004(cljs$core$async$map_LT_,f,ch,cljs.core.PersistentArrayMap.EMPTY));
});
/**
 * Deprecated - this function will be removed. Use transducer instead
 */
cljs.core.async.map_GT_ = (function cljs$core$async$map_GT_(f,ch){
if(typeof cljs.core.async.t_cljs$core$async32013 !== 'undefined'){
} else {

/**
* @constructor
 * @implements {cljs.core.async.impl.protocols.Channel}
 * @implements {cljs.core.async.impl.protocols.WritePort}
 * @implements {cljs.core.async.impl.protocols.ReadPort}
 * @implements {cljs.core.IMeta}
 * @implements {cljs.core.IWithMeta}
*/
cljs.core.async.t_cljs$core$async32013 = (function (map_GT_,f,ch,meta32014){
this.map_GT_ = map_GT_;
this.f = f;
this.ch = ch;
this.meta32014 = meta32014;
this.cljs$lang$protocol_mask$partition0$ = 393216;
this.cljs$lang$protocol_mask$partition1$ = 0;
})
cljs.core.async.t_cljs$core$async32013.prototype.cljs$core$IWithMeta$_with_meta$arity$2 = (function (_32015,meta32014__$1){
var self__ = this;
var _32015__$1 = this;
return (new cljs.core.async.t_cljs$core$async32013(self__.map_GT_,self__.f,self__.ch,meta32014__$1));
});

cljs.core.async.t_cljs$core$async32013.prototype.cljs$core$IMeta$_meta$arity$1 = (function (_32015){
var self__ = this;
var _32015__$1 = this;
return self__.meta32014;
});

cljs.core.async.t_cljs$core$async32013.prototype.cljs$core$async$impl$protocols$Channel$ = true;

cljs.core.async.t_cljs$core$async32013.prototype.cljs$core$async$impl$protocols$Channel$close_BANG_$arity$1 = (function (_){
var self__ = this;
var ___$1 = this;
return cljs.core.async.impl.protocols.close_BANG_.call(null,self__.ch);
});

cljs.core.async.t_cljs$core$async32013.prototype.cljs$core$async$impl$protocols$ReadPort$ = true;

cljs.core.async.t_cljs$core$async32013.prototype.cljs$core$async$impl$protocols$ReadPort$take_BANG_$arity$2 = (function (_,fn1){
var self__ = this;
var ___$1 = this;
return cljs.core.async.impl.protocols.take_BANG_.call(null,self__.ch,fn1);
});

cljs.core.async.t_cljs$core$async32013.prototype.cljs$core$async$impl$protocols$WritePort$ = true;

cljs.core.async.t_cljs$core$async32013.prototype.cljs$core$async$impl$protocols$WritePort$put_BANG_$arity$3 = (function (_,val,fn1){
var self__ = this;
var ___$1 = this;
return cljs.core.async.impl.protocols.put_BANG_.call(null,self__.ch,self__.f.call(null,val),fn1);
});

cljs.core.async.t_cljs$core$async32013.getBasis = (function (){
return new cljs.core.PersistentVector(null, 4, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.with_meta(new cljs.core.Symbol(null,"map>","map>",1676369295,null),new cljs.core.PersistentArrayMap(null, 2, [new cljs.core.Keyword(null,"arglists","arglists",1661989754),cljs.core.list(new cljs.core.Symbol(null,"quote","quote",1377916282,null),cljs.core.list(new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Symbol(null,"f","f",43394975,null),new cljs.core.Symbol(null,"ch","ch",1085813622,null)], null))),new cljs.core.Keyword(null,"doc","doc",1913296891),"Deprecated - this function will be removed. Use transducer instead"], null)),new cljs.core.Symbol(null,"f","f",43394975,null),new cljs.core.Symbol(null,"ch","ch",1085813622,null),new cljs.core.Symbol(null,"meta32014","meta32014",1244719551,null)], null);
});

cljs.core.async.t_cljs$core$async32013.cljs$lang$type = true;

cljs.core.async.t_cljs$core$async32013.cljs$lang$ctorStr = "cljs.core.async/t_cljs$core$async32013";

cljs.core.async.t_cljs$core$async32013.cljs$lang$ctorPrWriter = (function (this__25539__auto__,writer__25540__auto__,opt__25541__auto__){
return cljs.core._write.call(null,writer__25540__auto__,"cljs.core.async/t_cljs$core$async32013");
});

cljs.core.async.__GT_t_cljs$core$async32013 = (function cljs$core$async$map_GT__$___GT_t_cljs$core$async32013(map_GT___$1,f__$1,ch__$1,meta32014){
return (new cljs.core.async.t_cljs$core$async32013(map_GT___$1,f__$1,ch__$1,meta32014));
});

}

return (new cljs.core.async.t_cljs$core$async32013(cljs$core$async$map_GT_,f,ch,cljs.core.PersistentArrayMap.EMPTY));
});
/**
 * Deprecated - this function will be removed. Use transducer instead
 */
cljs.core.async.filter_GT_ = (function cljs$core$async$filter_GT_(p,ch){
if(typeof cljs.core.async.t_cljs$core$async32019 !== 'undefined'){
} else {

/**
* @constructor
 * @implements {cljs.core.async.impl.protocols.Channel}
 * @implements {cljs.core.async.impl.protocols.WritePort}
 * @implements {cljs.core.async.impl.protocols.ReadPort}
 * @implements {cljs.core.IMeta}
 * @implements {cljs.core.IWithMeta}
*/
cljs.core.async.t_cljs$core$async32019 = (function (filter_GT_,p,ch,meta32020){
this.filter_GT_ = filter_GT_;
this.p = p;
this.ch = ch;
this.meta32020 = meta32020;
this.cljs$lang$protocol_mask$partition0$ = 393216;
this.cljs$lang$protocol_mask$partition1$ = 0;
})
cljs.core.async.t_cljs$core$async32019.prototype.cljs$core$IWithMeta$_with_meta$arity$2 = (function (_32021,meta32020__$1){
var self__ = this;
var _32021__$1 = this;
return (new cljs.core.async.t_cljs$core$async32019(self__.filter_GT_,self__.p,self__.ch,meta32020__$1));
});

cljs.core.async.t_cljs$core$async32019.prototype.cljs$core$IMeta$_meta$arity$1 = (function (_32021){
var self__ = this;
var _32021__$1 = this;
return self__.meta32020;
});

cljs.core.async.t_cljs$core$async32019.prototype.cljs$core$async$impl$protocols$Channel$ = true;

cljs.core.async.t_cljs$core$async32019.prototype.cljs$core$async$impl$protocols$Channel$close_BANG_$arity$1 = (function (_){
var self__ = this;
var ___$1 = this;
return cljs.core.async.impl.protocols.close_BANG_.call(null,self__.ch);
});

cljs.core.async.t_cljs$core$async32019.prototype.cljs$core$async$impl$protocols$Channel$closed_QMARK_$arity$1 = (function (_){
var self__ = this;
var ___$1 = this;
return cljs.core.async.impl.protocols.closed_QMARK_.call(null,self__.ch);
});

cljs.core.async.t_cljs$core$async32019.prototype.cljs$core$async$impl$protocols$ReadPort$ = true;

cljs.core.async.t_cljs$core$async32019.prototype.cljs$core$async$impl$protocols$ReadPort$take_BANG_$arity$2 = (function (_,fn1){
var self__ = this;
var ___$1 = this;
return cljs.core.async.impl.protocols.take_BANG_.call(null,self__.ch,fn1);
});

cljs.core.async.t_cljs$core$async32019.prototype.cljs$core$async$impl$protocols$WritePort$ = true;

cljs.core.async.t_cljs$core$async32019.prototype.cljs$core$async$impl$protocols$WritePort$put_BANG_$arity$3 = (function (_,val,fn1){
var self__ = this;
var ___$1 = this;
if(cljs.core.truth_(self__.p.call(null,val))){
return cljs.core.async.impl.protocols.put_BANG_.call(null,self__.ch,val,fn1);
} else {
return cljs.core.async.impl.channels.box.call(null,cljs.core.not.call(null,cljs.core.async.impl.protocols.closed_QMARK_.call(null,self__.ch)));
}
});

cljs.core.async.t_cljs$core$async32019.getBasis = (function (){
return new cljs.core.PersistentVector(null, 4, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.with_meta(new cljs.core.Symbol(null,"filter>","filter>",-37644455,null),new cljs.core.PersistentArrayMap(null, 2, [new cljs.core.Keyword(null,"arglists","arglists",1661989754),cljs.core.list(new cljs.core.Symbol(null,"quote","quote",1377916282,null),cljs.core.list(new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Symbol(null,"p","p",1791580836,null),new cljs.core.Symbol(null,"ch","ch",1085813622,null)], null))),new cljs.core.Keyword(null,"doc","doc",1913296891),"Deprecated - this function will be removed. Use transducer instead"], null)),new cljs.core.Symbol(null,"p","p",1791580836,null),new cljs.core.Symbol(null,"ch","ch",1085813622,null),new cljs.core.Symbol(null,"meta32020","meta32020",-1171060138,null)], null);
});

cljs.core.async.t_cljs$core$async32019.cljs$lang$type = true;

cljs.core.async.t_cljs$core$async32019.cljs$lang$ctorStr = "cljs.core.async/t_cljs$core$async32019";

cljs.core.async.t_cljs$core$async32019.cljs$lang$ctorPrWriter = (function (this__25539__auto__,writer__25540__auto__,opt__25541__auto__){
return cljs.core._write.call(null,writer__25540__auto__,"cljs.core.async/t_cljs$core$async32019");
});

cljs.core.async.__GT_t_cljs$core$async32019 = (function cljs$core$async$filter_GT__$___GT_t_cljs$core$async32019(filter_GT___$1,p__$1,ch__$1,meta32020){
return (new cljs.core.async.t_cljs$core$async32019(filter_GT___$1,p__$1,ch__$1,meta32020));
});

}

return (new cljs.core.async.t_cljs$core$async32019(cljs$core$async$filter_GT_,p,ch,cljs.core.PersistentArrayMap.EMPTY));
});
/**
 * Deprecated - this function will be removed. Use transducer instead
 */
cljs.core.async.remove_GT_ = (function cljs$core$async$remove_GT_(p,ch){
return cljs.core.async.filter_GT_.call(null,cljs.core.complement.call(null,p),ch);
});
/**
 * Deprecated - this function will be removed. Use transducer instead
 */
cljs.core.async.filter_LT_ = (function cljs$core$async$filter_LT_(var_args){
var args32022 = [];
var len__25999__auto___32066 = arguments.length;
var i__26000__auto___32067 = (0);
while(true){
if((i__26000__auto___32067 < len__25999__auto___32066)){
args32022.push((arguments[i__26000__auto___32067]));

var G__32068 = (i__26000__auto___32067 + (1));
i__26000__auto___32067 = G__32068;
continue;
} else {
}
break;
}

var G__32024 = args32022.length;
switch (G__32024) {
case 2:
return cljs.core.async.filter_LT_.cljs$core$IFn$_invoke$arity$2((arguments[(0)]),(arguments[(1)]));

break;
case 3:
return cljs.core.async.filter_LT_.cljs$core$IFn$_invoke$arity$3((arguments[(0)]),(arguments[(1)]),(arguments[(2)]));

break;
default:
throw (new Error([cljs.core.str("Invalid arity: "),cljs.core.str(args32022.length)].join('')));

}
});

cljs.core.async.filter_LT_.cljs$core$IFn$_invoke$arity$2 = (function (p,ch){
return cljs.core.async.filter_LT_.call(null,p,ch,null);
});

cljs.core.async.filter_LT_.cljs$core$IFn$_invoke$arity$3 = (function (p,ch,buf_or_n){
var out = cljs.core.async.chan.call(null,buf_or_n);
var c__27451__auto___32070 = cljs.core.async.chan.call(null,(1));
cljs.core.async.impl.dispatch.run.call(null,((function (c__27451__auto___32070,out){
return (function (){
var f__27452__auto__ = (function (){var switch__27386__auto__ = ((function (c__27451__auto___32070,out){
return (function (state_32045){
var state_val_32046 = (state_32045[(1)]);
if((state_val_32046 === (7))){
var inst_32041 = (state_32045[(2)]);
var state_32045__$1 = state_32045;
var statearr_32047_32071 = state_32045__$1;
(statearr_32047_32071[(2)] = inst_32041);

(statearr_32047_32071[(1)] = (3));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_32046 === (1))){
var state_32045__$1 = state_32045;
var statearr_32048_32072 = state_32045__$1;
(statearr_32048_32072[(2)] = null);

(statearr_32048_32072[(1)] = (2));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_32046 === (4))){
var inst_32027 = (state_32045[(7)]);
var inst_32027__$1 = (state_32045[(2)]);
var inst_32028 = (inst_32027__$1 == null);
var state_32045__$1 = (function (){var statearr_32049 = state_32045;
(statearr_32049[(7)] = inst_32027__$1);

return statearr_32049;
})();
if(cljs.core.truth_(inst_32028)){
var statearr_32050_32073 = state_32045__$1;
(statearr_32050_32073[(1)] = (5));

} else {
var statearr_32051_32074 = state_32045__$1;
(statearr_32051_32074[(1)] = (6));

}

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_32046 === (6))){
var inst_32027 = (state_32045[(7)]);
var inst_32032 = p.call(null,inst_32027);
var state_32045__$1 = state_32045;
if(cljs.core.truth_(inst_32032)){
var statearr_32052_32075 = state_32045__$1;
(statearr_32052_32075[(1)] = (8));

} else {
var statearr_32053_32076 = state_32045__$1;
(statearr_32053_32076[(1)] = (9));

}

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_32046 === (3))){
var inst_32043 = (state_32045[(2)]);
var state_32045__$1 = state_32045;
return cljs.core.async.impl.ioc_helpers.return_chan.call(null,state_32045__$1,inst_32043);
} else {
if((state_val_32046 === (2))){
var state_32045__$1 = state_32045;
return cljs.core.async.impl.ioc_helpers.take_BANG_.call(null,state_32045__$1,(4),ch);
} else {
if((state_val_32046 === (11))){
var inst_32035 = (state_32045[(2)]);
var state_32045__$1 = state_32045;
var statearr_32054_32077 = state_32045__$1;
(statearr_32054_32077[(2)] = inst_32035);

(statearr_32054_32077[(1)] = (10));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_32046 === (9))){
var state_32045__$1 = state_32045;
var statearr_32055_32078 = state_32045__$1;
(statearr_32055_32078[(2)] = null);

(statearr_32055_32078[(1)] = (10));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_32046 === (5))){
var inst_32030 = cljs.core.async.close_BANG_.call(null,out);
var state_32045__$1 = state_32045;
var statearr_32056_32079 = state_32045__$1;
(statearr_32056_32079[(2)] = inst_32030);

(statearr_32056_32079[(1)] = (7));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_32046 === (10))){
var inst_32038 = (state_32045[(2)]);
var state_32045__$1 = (function (){var statearr_32057 = state_32045;
(statearr_32057[(8)] = inst_32038);

return statearr_32057;
})();
var statearr_32058_32080 = state_32045__$1;
(statearr_32058_32080[(2)] = null);

(statearr_32058_32080[(1)] = (2));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_32046 === (8))){
var inst_32027 = (state_32045[(7)]);
var state_32045__$1 = state_32045;
return cljs.core.async.impl.ioc_helpers.put_BANG_.call(null,state_32045__$1,(11),out,inst_32027);
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
});})(c__27451__auto___32070,out))
;
return ((function (switch__27386__auto__,c__27451__auto___32070,out){
return (function() {
var cljs$core$async$state_machine__27387__auto__ = null;
var cljs$core$async$state_machine__27387__auto____0 = (function (){
var statearr_32062 = [null,null,null,null,null,null,null,null,null];
(statearr_32062[(0)] = cljs$core$async$state_machine__27387__auto__);

(statearr_32062[(1)] = (1));

return statearr_32062;
});
var cljs$core$async$state_machine__27387__auto____1 = (function (state_32045){
while(true){
var ret_value__27388__auto__ = (function (){try{while(true){
var result__27389__auto__ = switch__27386__auto__.call(null,state_32045);
if(cljs.core.keyword_identical_QMARK_.call(null,result__27389__auto__,new cljs.core.Keyword(null,"recur","recur",-437573268))){
continue;
} else {
return result__27389__auto__;
}
break;
}
}catch (e32063){if((e32063 instanceof Object)){
var ex__27390__auto__ = e32063;
var statearr_32064_32081 = state_32045;
(statearr_32064_32081[(5)] = ex__27390__auto__);


cljs.core.async.impl.ioc_helpers.process_exception.call(null,state_32045);

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
throw e32063;

}
}})();
if(cljs.core.keyword_identical_QMARK_.call(null,ret_value__27388__auto__,new cljs.core.Keyword(null,"recur","recur",-437573268))){
var G__32082 = state_32045;
state_32045 = G__32082;
continue;
} else {
return ret_value__27388__auto__;
}
break;
}
});
cljs$core$async$state_machine__27387__auto__ = function(state_32045){
switch(arguments.length){
case 0:
return cljs$core$async$state_machine__27387__auto____0.call(this);
case 1:
return cljs$core$async$state_machine__27387__auto____1.call(this,state_32045);
}
throw(new Error('Invalid arity: ' + arguments.length));
};
cljs$core$async$state_machine__27387__auto__.cljs$core$IFn$_invoke$arity$0 = cljs$core$async$state_machine__27387__auto____0;
cljs$core$async$state_machine__27387__auto__.cljs$core$IFn$_invoke$arity$1 = cljs$core$async$state_machine__27387__auto____1;
return cljs$core$async$state_machine__27387__auto__;
})()
;})(switch__27386__auto__,c__27451__auto___32070,out))
})();
var state__27453__auto__ = (function (){var statearr_32065 = f__27452__auto__.call(null);
(statearr_32065[cljs.core.async.impl.ioc_helpers.USER_START_IDX] = c__27451__auto___32070);

return statearr_32065;
})();
return cljs.core.async.impl.ioc_helpers.run_state_machine_wrapped.call(null,state__27453__auto__);
});})(c__27451__auto___32070,out))
);


return out;
});

cljs.core.async.filter_LT_.cljs$lang$maxFixedArity = 3;
/**
 * Deprecated - this function will be removed. Use transducer instead
 */
cljs.core.async.remove_LT_ = (function cljs$core$async$remove_LT_(var_args){
var args32083 = [];
var len__25999__auto___32086 = arguments.length;
var i__26000__auto___32087 = (0);
while(true){
if((i__26000__auto___32087 < len__25999__auto___32086)){
args32083.push((arguments[i__26000__auto___32087]));

var G__32088 = (i__26000__auto___32087 + (1));
i__26000__auto___32087 = G__32088;
continue;
} else {
}
break;
}

var G__32085 = args32083.length;
switch (G__32085) {
case 2:
return cljs.core.async.remove_LT_.cljs$core$IFn$_invoke$arity$2((arguments[(0)]),(arguments[(1)]));

break;
case 3:
return cljs.core.async.remove_LT_.cljs$core$IFn$_invoke$arity$3((arguments[(0)]),(arguments[(1)]),(arguments[(2)]));

break;
default:
throw (new Error([cljs.core.str("Invalid arity: "),cljs.core.str(args32083.length)].join('')));

}
});

cljs.core.async.remove_LT_.cljs$core$IFn$_invoke$arity$2 = (function (p,ch){
return cljs.core.async.remove_LT_.call(null,p,ch,null);
});

cljs.core.async.remove_LT_.cljs$core$IFn$_invoke$arity$3 = (function (p,ch,buf_or_n){
return cljs.core.async.filter_LT_.call(null,cljs.core.complement.call(null,p),ch,buf_or_n);
});

cljs.core.async.remove_LT_.cljs$lang$maxFixedArity = 3;
cljs.core.async.mapcat_STAR_ = (function cljs$core$async$mapcat_STAR_(f,in$,out){
var c__27451__auto__ = cljs.core.async.chan.call(null,(1));
cljs.core.async.impl.dispatch.run.call(null,((function (c__27451__auto__){
return (function (){
var f__27452__auto__ = (function (){var switch__27386__auto__ = ((function (c__27451__auto__){
return (function (state_32255){
var state_val_32256 = (state_32255[(1)]);
if((state_val_32256 === (7))){
var inst_32251 = (state_32255[(2)]);
var state_32255__$1 = state_32255;
var statearr_32257_32298 = state_32255__$1;
(statearr_32257_32298[(2)] = inst_32251);

(statearr_32257_32298[(1)] = (3));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_32256 === (20))){
var inst_32221 = (state_32255[(7)]);
var inst_32232 = (state_32255[(2)]);
var inst_32233 = cljs.core.next.call(null,inst_32221);
var inst_32207 = inst_32233;
var inst_32208 = null;
var inst_32209 = (0);
var inst_32210 = (0);
var state_32255__$1 = (function (){var statearr_32258 = state_32255;
(statearr_32258[(8)] = inst_32208);

(statearr_32258[(9)] = inst_32210);

(statearr_32258[(10)] = inst_32207);

(statearr_32258[(11)] = inst_32209);

(statearr_32258[(12)] = inst_32232);

return statearr_32258;
})();
var statearr_32259_32299 = state_32255__$1;
(statearr_32259_32299[(2)] = null);

(statearr_32259_32299[(1)] = (8));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_32256 === (1))){
var state_32255__$1 = state_32255;
var statearr_32260_32300 = state_32255__$1;
(statearr_32260_32300[(2)] = null);

(statearr_32260_32300[(1)] = (2));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_32256 === (4))){
var inst_32196 = (state_32255[(13)]);
var inst_32196__$1 = (state_32255[(2)]);
var inst_32197 = (inst_32196__$1 == null);
var state_32255__$1 = (function (){var statearr_32261 = state_32255;
(statearr_32261[(13)] = inst_32196__$1);

return statearr_32261;
})();
if(cljs.core.truth_(inst_32197)){
var statearr_32262_32301 = state_32255__$1;
(statearr_32262_32301[(1)] = (5));

} else {
var statearr_32263_32302 = state_32255__$1;
(statearr_32263_32302[(1)] = (6));

}

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_32256 === (15))){
var state_32255__$1 = state_32255;
var statearr_32267_32303 = state_32255__$1;
(statearr_32267_32303[(2)] = null);

(statearr_32267_32303[(1)] = (16));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_32256 === (21))){
var state_32255__$1 = state_32255;
var statearr_32268_32304 = state_32255__$1;
(statearr_32268_32304[(2)] = null);

(statearr_32268_32304[(1)] = (23));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_32256 === (13))){
var inst_32208 = (state_32255[(8)]);
var inst_32210 = (state_32255[(9)]);
var inst_32207 = (state_32255[(10)]);
var inst_32209 = (state_32255[(11)]);
var inst_32217 = (state_32255[(2)]);
var inst_32218 = (inst_32210 + (1));
var tmp32264 = inst_32208;
var tmp32265 = inst_32207;
var tmp32266 = inst_32209;
var inst_32207__$1 = tmp32265;
var inst_32208__$1 = tmp32264;
var inst_32209__$1 = tmp32266;
var inst_32210__$1 = inst_32218;
var state_32255__$1 = (function (){var statearr_32269 = state_32255;
(statearr_32269[(14)] = inst_32217);

(statearr_32269[(8)] = inst_32208__$1);

(statearr_32269[(9)] = inst_32210__$1);

(statearr_32269[(10)] = inst_32207__$1);

(statearr_32269[(11)] = inst_32209__$1);

return statearr_32269;
})();
var statearr_32270_32305 = state_32255__$1;
(statearr_32270_32305[(2)] = null);

(statearr_32270_32305[(1)] = (8));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_32256 === (22))){
var state_32255__$1 = state_32255;
var statearr_32271_32306 = state_32255__$1;
(statearr_32271_32306[(2)] = null);

(statearr_32271_32306[(1)] = (2));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_32256 === (6))){
var inst_32196 = (state_32255[(13)]);
var inst_32205 = f.call(null,inst_32196);
var inst_32206 = cljs.core.seq.call(null,inst_32205);
var inst_32207 = inst_32206;
var inst_32208 = null;
var inst_32209 = (0);
var inst_32210 = (0);
var state_32255__$1 = (function (){var statearr_32272 = state_32255;
(statearr_32272[(8)] = inst_32208);

(statearr_32272[(9)] = inst_32210);

(statearr_32272[(10)] = inst_32207);

(statearr_32272[(11)] = inst_32209);

return statearr_32272;
})();
var statearr_32273_32307 = state_32255__$1;
(statearr_32273_32307[(2)] = null);

(statearr_32273_32307[(1)] = (8));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_32256 === (17))){
var inst_32221 = (state_32255[(7)]);
var inst_32225 = cljs.core.chunk_first.call(null,inst_32221);
var inst_32226 = cljs.core.chunk_rest.call(null,inst_32221);
var inst_32227 = cljs.core.count.call(null,inst_32225);
var inst_32207 = inst_32226;
var inst_32208 = inst_32225;
var inst_32209 = inst_32227;
var inst_32210 = (0);
var state_32255__$1 = (function (){var statearr_32274 = state_32255;
(statearr_32274[(8)] = inst_32208);

(statearr_32274[(9)] = inst_32210);

(statearr_32274[(10)] = inst_32207);

(statearr_32274[(11)] = inst_32209);

return statearr_32274;
})();
var statearr_32275_32308 = state_32255__$1;
(statearr_32275_32308[(2)] = null);

(statearr_32275_32308[(1)] = (8));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_32256 === (3))){
var inst_32253 = (state_32255[(2)]);
var state_32255__$1 = state_32255;
return cljs.core.async.impl.ioc_helpers.return_chan.call(null,state_32255__$1,inst_32253);
} else {
if((state_val_32256 === (12))){
var inst_32241 = (state_32255[(2)]);
var state_32255__$1 = state_32255;
var statearr_32276_32309 = state_32255__$1;
(statearr_32276_32309[(2)] = inst_32241);

(statearr_32276_32309[(1)] = (9));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_32256 === (2))){
var state_32255__$1 = state_32255;
return cljs.core.async.impl.ioc_helpers.take_BANG_.call(null,state_32255__$1,(4),in$);
} else {
if((state_val_32256 === (23))){
var inst_32249 = (state_32255[(2)]);
var state_32255__$1 = state_32255;
var statearr_32277_32310 = state_32255__$1;
(statearr_32277_32310[(2)] = inst_32249);

(statearr_32277_32310[(1)] = (7));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_32256 === (19))){
var inst_32236 = (state_32255[(2)]);
var state_32255__$1 = state_32255;
var statearr_32278_32311 = state_32255__$1;
(statearr_32278_32311[(2)] = inst_32236);

(statearr_32278_32311[(1)] = (16));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_32256 === (11))){
var inst_32221 = (state_32255[(7)]);
var inst_32207 = (state_32255[(10)]);
var inst_32221__$1 = cljs.core.seq.call(null,inst_32207);
var state_32255__$1 = (function (){var statearr_32279 = state_32255;
(statearr_32279[(7)] = inst_32221__$1);

return statearr_32279;
})();
if(inst_32221__$1){
var statearr_32280_32312 = state_32255__$1;
(statearr_32280_32312[(1)] = (14));

} else {
var statearr_32281_32313 = state_32255__$1;
(statearr_32281_32313[(1)] = (15));

}

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_32256 === (9))){
var inst_32243 = (state_32255[(2)]);
var inst_32244 = cljs.core.async.impl.protocols.closed_QMARK_.call(null,out);
var state_32255__$1 = (function (){var statearr_32282 = state_32255;
(statearr_32282[(15)] = inst_32243);

return statearr_32282;
})();
if(cljs.core.truth_(inst_32244)){
var statearr_32283_32314 = state_32255__$1;
(statearr_32283_32314[(1)] = (21));

} else {
var statearr_32284_32315 = state_32255__$1;
(statearr_32284_32315[(1)] = (22));

}

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_32256 === (5))){
var inst_32199 = cljs.core.async.close_BANG_.call(null,out);
var state_32255__$1 = state_32255;
var statearr_32285_32316 = state_32255__$1;
(statearr_32285_32316[(2)] = inst_32199);

(statearr_32285_32316[(1)] = (7));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_32256 === (14))){
var inst_32221 = (state_32255[(7)]);
var inst_32223 = cljs.core.chunked_seq_QMARK_.call(null,inst_32221);
var state_32255__$1 = state_32255;
if(inst_32223){
var statearr_32286_32317 = state_32255__$1;
(statearr_32286_32317[(1)] = (17));

} else {
var statearr_32287_32318 = state_32255__$1;
(statearr_32287_32318[(1)] = (18));

}

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_32256 === (16))){
var inst_32239 = (state_32255[(2)]);
var state_32255__$1 = state_32255;
var statearr_32288_32319 = state_32255__$1;
(statearr_32288_32319[(2)] = inst_32239);

(statearr_32288_32319[(1)] = (12));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_32256 === (10))){
var inst_32208 = (state_32255[(8)]);
var inst_32210 = (state_32255[(9)]);
var inst_32215 = cljs.core._nth.call(null,inst_32208,inst_32210);
var state_32255__$1 = state_32255;
return cljs.core.async.impl.ioc_helpers.put_BANG_.call(null,state_32255__$1,(13),out,inst_32215);
} else {
if((state_val_32256 === (18))){
var inst_32221 = (state_32255[(7)]);
var inst_32230 = cljs.core.first.call(null,inst_32221);
var state_32255__$1 = state_32255;
return cljs.core.async.impl.ioc_helpers.put_BANG_.call(null,state_32255__$1,(20),out,inst_32230);
} else {
if((state_val_32256 === (8))){
var inst_32210 = (state_32255[(9)]);
var inst_32209 = (state_32255[(11)]);
var inst_32212 = (inst_32210 < inst_32209);
var inst_32213 = inst_32212;
var state_32255__$1 = state_32255;
if(cljs.core.truth_(inst_32213)){
var statearr_32289_32320 = state_32255__$1;
(statearr_32289_32320[(1)] = (10));

} else {
var statearr_32290_32321 = state_32255__$1;
(statearr_32290_32321[(1)] = (11));

}

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
}
}
}
}
}
}
}
}
});})(c__27451__auto__))
;
return ((function (switch__27386__auto__,c__27451__auto__){
return (function() {
var cljs$core$async$mapcat_STAR__$_state_machine__27387__auto__ = null;
var cljs$core$async$mapcat_STAR__$_state_machine__27387__auto____0 = (function (){
var statearr_32294 = [null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null];
(statearr_32294[(0)] = cljs$core$async$mapcat_STAR__$_state_machine__27387__auto__);

(statearr_32294[(1)] = (1));

return statearr_32294;
});
var cljs$core$async$mapcat_STAR__$_state_machine__27387__auto____1 = (function (state_32255){
while(true){
var ret_value__27388__auto__ = (function (){try{while(true){
var result__27389__auto__ = switch__27386__auto__.call(null,state_32255);
if(cljs.core.keyword_identical_QMARK_.call(null,result__27389__auto__,new cljs.core.Keyword(null,"recur","recur",-437573268))){
continue;
} else {
return result__27389__auto__;
}
break;
}
}catch (e32295){if((e32295 instanceof Object)){
var ex__27390__auto__ = e32295;
var statearr_32296_32322 = state_32255;
(statearr_32296_32322[(5)] = ex__27390__auto__);


cljs.core.async.impl.ioc_helpers.process_exception.call(null,state_32255);

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
throw e32295;

}
}})();
if(cljs.core.keyword_identical_QMARK_.call(null,ret_value__27388__auto__,new cljs.core.Keyword(null,"recur","recur",-437573268))){
var G__32323 = state_32255;
state_32255 = G__32323;
continue;
} else {
return ret_value__27388__auto__;
}
break;
}
});
cljs$core$async$mapcat_STAR__$_state_machine__27387__auto__ = function(state_32255){
switch(arguments.length){
case 0:
return cljs$core$async$mapcat_STAR__$_state_machine__27387__auto____0.call(this);
case 1:
return cljs$core$async$mapcat_STAR__$_state_machine__27387__auto____1.call(this,state_32255);
}
throw(new Error('Invalid arity: ' + arguments.length));
};
cljs$core$async$mapcat_STAR__$_state_machine__27387__auto__.cljs$core$IFn$_invoke$arity$0 = cljs$core$async$mapcat_STAR__$_state_machine__27387__auto____0;
cljs$core$async$mapcat_STAR__$_state_machine__27387__auto__.cljs$core$IFn$_invoke$arity$1 = cljs$core$async$mapcat_STAR__$_state_machine__27387__auto____1;
return cljs$core$async$mapcat_STAR__$_state_machine__27387__auto__;
})()
;})(switch__27386__auto__,c__27451__auto__))
})();
var state__27453__auto__ = (function (){var statearr_32297 = f__27452__auto__.call(null);
(statearr_32297[cljs.core.async.impl.ioc_helpers.USER_START_IDX] = c__27451__auto__);

return statearr_32297;
})();
return cljs.core.async.impl.ioc_helpers.run_state_machine_wrapped.call(null,state__27453__auto__);
});})(c__27451__auto__))
);

return c__27451__auto__;
});
/**
 * Deprecated - this function will be removed. Use transducer instead
 */
cljs.core.async.mapcat_LT_ = (function cljs$core$async$mapcat_LT_(var_args){
var args32324 = [];
var len__25999__auto___32327 = arguments.length;
var i__26000__auto___32328 = (0);
while(true){
if((i__26000__auto___32328 < len__25999__auto___32327)){
args32324.push((arguments[i__26000__auto___32328]));

var G__32329 = (i__26000__auto___32328 + (1));
i__26000__auto___32328 = G__32329;
continue;
} else {
}
break;
}

var G__32326 = args32324.length;
switch (G__32326) {
case 2:
return cljs.core.async.mapcat_LT_.cljs$core$IFn$_invoke$arity$2((arguments[(0)]),(arguments[(1)]));

break;
case 3:
return cljs.core.async.mapcat_LT_.cljs$core$IFn$_invoke$arity$3((arguments[(0)]),(arguments[(1)]),(arguments[(2)]));

break;
default:
throw (new Error([cljs.core.str("Invalid arity: "),cljs.core.str(args32324.length)].join('')));

}
});

cljs.core.async.mapcat_LT_.cljs$core$IFn$_invoke$arity$2 = (function (f,in$){
return cljs.core.async.mapcat_LT_.call(null,f,in$,null);
});

cljs.core.async.mapcat_LT_.cljs$core$IFn$_invoke$arity$3 = (function (f,in$,buf_or_n){
var out = cljs.core.async.chan.call(null,buf_or_n);
cljs.core.async.mapcat_STAR_.call(null,f,in$,out);

return out;
});

cljs.core.async.mapcat_LT_.cljs$lang$maxFixedArity = 3;
/**
 * Deprecated - this function will be removed. Use transducer instead
 */
cljs.core.async.mapcat_GT_ = (function cljs$core$async$mapcat_GT_(var_args){
var args32331 = [];
var len__25999__auto___32334 = arguments.length;
var i__26000__auto___32335 = (0);
while(true){
if((i__26000__auto___32335 < len__25999__auto___32334)){
args32331.push((arguments[i__26000__auto___32335]));

var G__32336 = (i__26000__auto___32335 + (1));
i__26000__auto___32335 = G__32336;
continue;
} else {
}
break;
}

var G__32333 = args32331.length;
switch (G__32333) {
case 2:
return cljs.core.async.mapcat_GT_.cljs$core$IFn$_invoke$arity$2((arguments[(0)]),(arguments[(1)]));

break;
case 3:
return cljs.core.async.mapcat_GT_.cljs$core$IFn$_invoke$arity$3((arguments[(0)]),(arguments[(1)]),(arguments[(2)]));

break;
default:
throw (new Error([cljs.core.str("Invalid arity: "),cljs.core.str(args32331.length)].join('')));

}
});

cljs.core.async.mapcat_GT_.cljs$core$IFn$_invoke$arity$2 = (function (f,out){
return cljs.core.async.mapcat_GT_.call(null,f,out,null);
});

cljs.core.async.mapcat_GT_.cljs$core$IFn$_invoke$arity$3 = (function (f,out,buf_or_n){
var in$ = cljs.core.async.chan.call(null,buf_or_n);
cljs.core.async.mapcat_STAR_.call(null,f,in$,out);

return in$;
});

cljs.core.async.mapcat_GT_.cljs$lang$maxFixedArity = 3;
/**
 * Deprecated - this function will be removed. Use transducer instead
 */
cljs.core.async.unique = (function cljs$core$async$unique(var_args){
var args32338 = [];
var len__25999__auto___32389 = arguments.length;
var i__26000__auto___32390 = (0);
while(true){
if((i__26000__auto___32390 < len__25999__auto___32389)){
args32338.push((arguments[i__26000__auto___32390]));

var G__32391 = (i__26000__auto___32390 + (1));
i__26000__auto___32390 = G__32391;
continue;
} else {
}
break;
}

var G__32340 = args32338.length;
switch (G__32340) {
case 1:
return cljs.core.async.unique.cljs$core$IFn$_invoke$arity$1((arguments[(0)]));

break;
case 2:
return cljs.core.async.unique.cljs$core$IFn$_invoke$arity$2((arguments[(0)]),(arguments[(1)]));

break;
default:
throw (new Error([cljs.core.str("Invalid arity: "),cljs.core.str(args32338.length)].join('')));

}
});

cljs.core.async.unique.cljs$core$IFn$_invoke$arity$1 = (function (ch){
return cljs.core.async.unique.call(null,ch,null);
});

cljs.core.async.unique.cljs$core$IFn$_invoke$arity$2 = (function (ch,buf_or_n){
var out = cljs.core.async.chan.call(null,buf_or_n);
var c__27451__auto___32393 = cljs.core.async.chan.call(null,(1));
cljs.core.async.impl.dispatch.run.call(null,((function (c__27451__auto___32393,out){
return (function (){
var f__27452__auto__ = (function (){var switch__27386__auto__ = ((function (c__27451__auto___32393,out){
return (function (state_32364){
var state_val_32365 = (state_32364[(1)]);
if((state_val_32365 === (7))){
var inst_32359 = (state_32364[(2)]);
var state_32364__$1 = state_32364;
var statearr_32366_32394 = state_32364__$1;
(statearr_32366_32394[(2)] = inst_32359);

(statearr_32366_32394[(1)] = (3));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_32365 === (1))){
var inst_32341 = null;
var state_32364__$1 = (function (){var statearr_32367 = state_32364;
(statearr_32367[(7)] = inst_32341);

return statearr_32367;
})();
var statearr_32368_32395 = state_32364__$1;
(statearr_32368_32395[(2)] = null);

(statearr_32368_32395[(1)] = (2));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_32365 === (4))){
var inst_32344 = (state_32364[(8)]);
var inst_32344__$1 = (state_32364[(2)]);
var inst_32345 = (inst_32344__$1 == null);
var inst_32346 = cljs.core.not.call(null,inst_32345);
var state_32364__$1 = (function (){var statearr_32369 = state_32364;
(statearr_32369[(8)] = inst_32344__$1);

return statearr_32369;
})();
if(inst_32346){
var statearr_32370_32396 = state_32364__$1;
(statearr_32370_32396[(1)] = (5));

} else {
var statearr_32371_32397 = state_32364__$1;
(statearr_32371_32397[(1)] = (6));

}

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_32365 === (6))){
var state_32364__$1 = state_32364;
var statearr_32372_32398 = state_32364__$1;
(statearr_32372_32398[(2)] = null);

(statearr_32372_32398[(1)] = (7));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_32365 === (3))){
var inst_32361 = (state_32364[(2)]);
var inst_32362 = cljs.core.async.close_BANG_.call(null,out);
var state_32364__$1 = (function (){var statearr_32373 = state_32364;
(statearr_32373[(9)] = inst_32361);

return statearr_32373;
})();
return cljs.core.async.impl.ioc_helpers.return_chan.call(null,state_32364__$1,inst_32362);
} else {
if((state_val_32365 === (2))){
var state_32364__$1 = state_32364;
return cljs.core.async.impl.ioc_helpers.take_BANG_.call(null,state_32364__$1,(4),ch);
} else {
if((state_val_32365 === (11))){
var inst_32344 = (state_32364[(8)]);
var inst_32353 = (state_32364[(2)]);
var inst_32341 = inst_32344;
var state_32364__$1 = (function (){var statearr_32374 = state_32364;
(statearr_32374[(10)] = inst_32353);

(statearr_32374[(7)] = inst_32341);

return statearr_32374;
})();
var statearr_32375_32399 = state_32364__$1;
(statearr_32375_32399[(2)] = null);

(statearr_32375_32399[(1)] = (2));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_32365 === (9))){
var inst_32344 = (state_32364[(8)]);
var state_32364__$1 = state_32364;
return cljs.core.async.impl.ioc_helpers.put_BANG_.call(null,state_32364__$1,(11),out,inst_32344);
} else {
if((state_val_32365 === (5))){
var inst_32344 = (state_32364[(8)]);
var inst_32341 = (state_32364[(7)]);
var inst_32348 = cljs.core._EQ_.call(null,inst_32344,inst_32341);
var state_32364__$1 = state_32364;
if(inst_32348){
var statearr_32377_32400 = state_32364__$1;
(statearr_32377_32400[(1)] = (8));

} else {
var statearr_32378_32401 = state_32364__$1;
(statearr_32378_32401[(1)] = (9));

}

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_32365 === (10))){
var inst_32356 = (state_32364[(2)]);
var state_32364__$1 = state_32364;
var statearr_32379_32402 = state_32364__$1;
(statearr_32379_32402[(2)] = inst_32356);

(statearr_32379_32402[(1)] = (7));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_32365 === (8))){
var inst_32341 = (state_32364[(7)]);
var tmp32376 = inst_32341;
var inst_32341__$1 = tmp32376;
var state_32364__$1 = (function (){var statearr_32380 = state_32364;
(statearr_32380[(7)] = inst_32341__$1);

return statearr_32380;
})();
var statearr_32381_32403 = state_32364__$1;
(statearr_32381_32403[(2)] = null);

(statearr_32381_32403[(1)] = (2));


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
});})(c__27451__auto___32393,out))
;
return ((function (switch__27386__auto__,c__27451__auto___32393,out){
return (function() {
var cljs$core$async$state_machine__27387__auto__ = null;
var cljs$core$async$state_machine__27387__auto____0 = (function (){
var statearr_32385 = [null,null,null,null,null,null,null,null,null,null,null];
(statearr_32385[(0)] = cljs$core$async$state_machine__27387__auto__);

(statearr_32385[(1)] = (1));

return statearr_32385;
});
var cljs$core$async$state_machine__27387__auto____1 = (function (state_32364){
while(true){
var ret_value__27388__auto__ = (function (){try{while(true){
var result__27389__auto__ = switch__27386__auto__.call(null,state_32364);
if(cljs.core.keyword_identical_QMARK_.call(null,result__27389__auto__,new cljs.core.Keyword(null,"recur","recur",-437573268))){
continue;
} else {
return result__27389__auto__;
}
break;
}
}catch (e32386){if((e32386 instanceof Object)){
var ex__27390__auto__ = e32386;
var statearr_32387_32404 = state_32364;
(statearr_32387_32404[(5)] = ex__27390__auto__);


cljs.core.async.impl.ioc_helpers.process_exception.call(null,state_32364);

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
throw e32386;

}
}})();
if(cljs.core.keyword_identical_QMARK_.call(null,ret_value__27388__auto__,new cljs.core.Keyword(null,"recur","recur",-437573268))){
var G__32405 = state_32364;
state_32364 = G__32405;
continue;
} else {
return ret_value__27388__auto__;
}
break;
}
});
cljs$core$async$state_machine__27387__auto__ = function(state_32364){
switch(arguments.length){
case 0:
return cljs$core$async$state_machine__27387__auto____0.call(this);
case 1:
return cljs$core$async$state_machine__27387__auto____1.call(this,state_32364);
}
throw(new Error('Invalid arity: ' + arguments.length));
};
cljs$core$async$state_machine__27387__auto__.cljs$core$IFn$_invoke$arity$0 = cljs$core$async$state_machine__27387__auto____0;
cljs$core$async$state_machine__27387__auto__.cljs$core$IFn$_invoke$arity$1 = cljs$core$async$state_machine__27387__auto____1;
return cljs$core$async$state_machine__27387__auto__;
})()
;})(switch__27386__auto__,c__27451__auto___32393,out))
})();
var state__27453__auto__ = (function (){var statearr_32388 = f__27452__auto__.call(null);
(statearr_32388[cljs.core.async.impl.ioc_helpers.USER_START_IDX] = c__27451__auto___32393);

return statearr_32388;
})();
return cljs.core.async.impl.ioc_helpers.run_state_machine_wrapped.call(null,state__27453__auto__);
});})(c__27451__auto___32393,out))
);


return out;
});

cljs.core.async.unique.cljs$lang$maxFixedArity = 2;
/**
 * Deprecated - this function will be removed. Use transducer instead
 */
cljs.core.async.partition = (function cljs$core$async$partition(var_args){
var args32406 = [];
var len__25999__auto___32476 = arguments.length;
var i__26000__auto___32477 = (0);
while(true){
if((i__26000__auto___32477 < len__25999__auto___32476)){
args32406.push((arguments[i__26000__auto___32477]));

var G__32478 = (i__26000__auto___32477 + (1));
i__26000__auto___32477 = G__32478;
continue;
} else {
}
break;
}

var G__32408 = args32406.length;
switch (G__32408) {
case 2:
return cljs.core.async.partition.cljs$core$IFn$_invoke$arity$2((arguments[(0)]),(arguments[(1)]));

break;
case 3:
return cljs.core.async.partition.cljs$core$IFn$_invoke$arity$3((arguments[(0)]),(arguments[(1)]),(arguments[(2)]));

break;
default:
throw (new Error([cljs.core.str("Invalid arity: "),cljs.core.str(args32406.length)].join('')));

}
});

cljs.core.async.partition.cljs$core$IFn$_invoke$arity$2 = (function (n,ch){
return cljs.core.async.partition.call(null,n,ch,null);
});

cljs.core.async.partition.cljs$core$IFn$_invoke$arity$3 = (function (n,ch,buf_or_n){
var out = cljs.core.async.chan.call(null,buf_or_n);
var c__27451__auto___32480 = cljs.core.async.chan.call(null,(1));
cljs.core.async.impl.dispatch.run.call(null,((function (c__27451__auto___32480,out){
return (function (){
var f__27452__auto__ = (function (){var switch__27386__auto__ = ((function (c__27451__auto___32480,out){
return (function (state_32446){
var state_val_32447 = (state_32446[(1)]);
if((state_val_32447 === (7))){
var inst_32442 = (state_32446[(2)]);
var state_32446__$1 = state_32446;
var statearr_32448_32481 = state_32446__$1;
(statearr_32448_32481[(2)] = inst_32442);

(statearr_32448_32481[(1)] = (3));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_32447 === (1))){
var inst_32409 = (new Array(n));
var inst_32410 = inst_32409;
var inst_32411 = (0);
var state_32446__$1 = (function (){var statearr_32449 = state_32446;
(statearr_32449[(7)] = inst_32411);

(statearr_32449[(8)] = inst_32410);

return statearr_32449;
})();
var statearr_32450_32482 = state_32446__$1;
(statearr_32450_32482[(2)] = null);

(statearr_32450_32482[(1)] = (2));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_32447 === (4))){
var inst_32414 = (state_32446[(9)]);
var inst_32414__$1 = (state_32446[(2)]);
var inst_32415 = (inst_32414__$1 == null);
var inst_32416 = cljs.core.not.call(null,inst_32415);
var state_32446__$1 = (function (){var statearr_32451 = state_32446;
(statearr_32451[(9)] = inst_32414__$1);

return statearr_32451;
})();
if(inst_32416){
var statearr_32452_32483 = state_32446__$1;
(statearr_32452_32483[(1)] = (5));

} else {
var statearr_32453_32484 = state_32446__$1;
(statearr_32453_32484[(1)] = (6));

}

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_32447 === (15))){
var inst_32436 = (state_32446[(2)]);
var state_32446__$1 = state_32446;
var statearr_32454_32485 = state_32446__$1;
(statearr_32454_32485[(2)] = inst_32436);

(statearr_32454_32485[(1)] = (14));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_32447 === (13))){
var state_32446__$1 = state_32446;
var statearr_32455_32486 = state_32446__$1;
(statearr_32455_32486[(2)] = null);

(statearr_32455_32486[(1)] = (14));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_32447 === (6))){
var inst_32411 = (state_32446[(7)]);
var inst_32432 = (inst_32411 > (0));
var state_32446__$1 = state_32446;
if(cljs.core.truth_(inst_32432)){
var statearr_32456_32487 = state_32446__$1;
(statearr_32456_32487[(1)] = (12));

} else {
var statearr_32457_32488 = state_32446__$1;
(statearr_32457_32488[(1)] = (13));

}

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_32447 === (3))){
var inst_32444 = (state_32446[(2)]);
var state_32446__$1 = state_32446;
return cljs.core.async.impl.ioc_helpers.return_chan.call(null,state_32446__$1,inst_32444);
} else {
if((state_val_32447 === (12))){
var inst_32410 = (state_32446[(8)]);
var inst_32434 = cljs.core.vec.call(null,inst_32410);
var state_32446__$1 = state_32446;
return cljs.core.async.impl.ioc_helpers.put_BANG_.call(null,state_32446__$1,(15),out,inst_32434);
} else {
if((state_val_32447 === (2))){
var state_32446__$1 = state_32446;
return cljs.core.async.impl.ioc_helpers.take_BANG_.call(null,state_32446__$1,(4),ch);
} else {
if((state_val_32447 === (11))){
var inst_32426 = (state_32446[(2)]);
var inst_32427 = (new Array(n));
var inst_32410 = inst_32427;
var inst_32411 = (0);
var state_32446__$1 = (function (){var statearr_32458 = state_32446;
(statearr_32458[(7)] = inst_32411);

(statearr_32458[(10)] = inst_32426);

(statearr_32458[(8)] = inst_32410);

return statearr_32458;
})();
var statearr_32459_32489 = state_32446__$1;
(statearr_32459_32489[(2)] = null);

(statearr_32459_32489[(1)] = (2));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_32447 === (9))){
var inst_32410 = (state_32446[(8)]);
var inst_32424 = cljs.core.vec.call(null,inst_32410);
var state_32446__$1 = state_32446;
return cljs.core.async.impl.ioc_helpers.put_BANG_.call(null,state_32446__$1,(11),out,inst_32424);
} else {
if((state_val_32447 === (5))){
var inst_32411 = (state_32446[(7)]);
var inst_32414 = (state_32446[(9)]);
var inst_32410 = (state_32446[(8)]);
var inst_32419 = (state_32446[(11)]);
var inst_32418 = (inst_32410[inst_32411] = inst_32414);
var inst_32419__$1 = (inst_32411 + (1));
var inst_32420 = (inst_32419__$1 < n);
var state_32446__$1 = (function (){var statearr_32460 = state_32446;
(statearr_32460[(12)] = inst_32418);

(statearr_32460[(11)] = inst_32419__$1);

return statearr_32460;
})();
if(cljs.core.truth_(inst_32420)){
var statearr_32461_32490 = state_32446__$1;
(statearr_32461_32490[(1)] = (8));

} else {
var statearr_32462_32491 = state_32446__$1;
(statearr_32462_32491[(1)] = (9));

}

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_32447 === (14))){
var inst_32439 = (state_32446[(2)]);
var inst_32440 = cljs.core.async.close_BANG_.call(null,out);
var state_32446__$1 = (function (){var statearr_32464 = state_32446;
(statearr_32464[(13)] = inst_32439);

return statearr_32464;
})();
var statearr_32465_32492 = state_32446__$1;
(statearr_32465_32492[(2)] = inst_32440);

(statearr_32465_32492[(1)] = (7));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_32447 === (10))){
var inst_32430 = (state_32446[(2)]);
var state_32446__$1 = state_32446;
var statearr_32466_32493 = state_32446__$1;
(statearr_32466_32493[(2)] = inst_32430);

(statearr_32466_32493[(1)] = (7));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_32447 === (8))){
var inst_32410 = (state_32446[(8)]);
var inst_32419 = (state_32446[(11)]);
var tmp32463 = inst_32410;
var inst_32410__$1 = tmp32463;
var inst_32411 = inst_32419;
var state_32446__$1 = (function (){var statearr_32467 = state_32446;
(statearr_32467[(7)] = inst_32411);

(statearr_32467[(8)] = inst_32410__$1);

return statearr_32467;
})();
var statearr_32468_32494 = state_32446__$1;
(statearr_32468_32494[(2)] = null);

(statearr_32468_32494[(1)] = (2));


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
});})(c__27451__auto___32480,out))
;
return ((function (switch__27386__auto__,c__27451__auto___32480,out){
return (function() {
var cljs$core$async$state_machine__27387__auto__ = null;
var cljs$core$async$state_machine__27387__auto____0 = (function (){
var statearr_32472 = [null,null,null,null,null,null,null,null,null,null,null,null,null,null];
(statearr_32472[(0)] = cljs$core$async$state_machine__27387__auto__);

(statearr_32472[(1)] = (1));

return statearr_32472;
});
var cljs$core$async$state_machine__27387__auto____1 = (function (state_32446){
while(true){
var ret_value__27388__auto__ = (function (){try{while(true){
var result__27389__auto__ = switch__27386__auto__.call(null,state_32446);
if(cljs.core.keyword_identical_QMARK_.call(null,result__27389__auto__,new cljs.core.Keyword(null,"recur","recur",-437573268))){
continue;
} else {
return result__27389__auto__;
}
break;
}
}catch (e32473){if((e32473 instanceof Object)){
var ex__27390__auto__ = e32473;
var statearr_32474_32495 = state_32446;
(statearr_32474_32495[(5)] = ex__27390__auto__);


cljs.core.async.impl.ioc_helpers.process_exception.call(null,state_32446);

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
throw e32473;

}
}})();
if(cljs.core.keyword_identical_QMARK_.call(null,ret_value__27388__auto__,new cljs.core.Keyword(null,"recur","recur",-437573268))){
var G__32496 = state_32446;
state_32446 = G__32496;
continue;
} else {
return ret_value__27388__auto__;
}
break;
}
});
cljs$core$async$state_machine__27387__auto__ = function(state_32446){
switch(arguments.length){
case 0:
return cljs$core$async$state_machine__27387__auto____0.call(this);
case 1:
return cljs$core$async$state_machine__27387__auto____1.call(this,state_32446);
}
throw(new Error('Invalid arity: ' + arguments.length));
};
cljs$core$async$state_machine__27387__auto__.cljs$core$IFn$_invoke$arity$0 = cljs$core$async$state_machine__27387__auto____0;
cljs$core$async$state_machine__27387__auto__.cljs$core$IFn$_invoke$arity$1 = cljs$core$async$state_machine__27387__auto____1;
return cljs$core$async$state_machine__27387__auto__;
})()
;})(switch__27386__auto__,c__27451__auto___32480,out))
})();
var state__27453__auto__ = (function (){var statearr_32475 = f__27452__auto__.call(null);
(statearr_32475[cljs.core.async.impl.ioc_helpers.USER_START_IDX] = c__27451__auto___32480);

return statearr_32475;
})();
return cljs.core.async.impl.ioc_helpers.run_state_machine_wrapped.call(null,state__27453__auto__);
});})(c__27451__auto___32480,out))
);


return out;
});

cljs.core.async.partition.cljs$lang$maxFixedArity = 3;
/**
 * Deprecated - this function will be removed. Use transducer instead
 */
cljs.core.async.partition_by = (function cljs$core$async$partition_by(var_args){
var args32497 = [];
var len__25999__auto___32571 = arguments.length;
var i__26000__auto___32572 = (0);
while(true){
if((i__26000__auto___32572 < len__25999__auto___32571)){
args32497.push((arguments[i__26000__auto___32572]));

var G__32573 = (i__26000__auto___32572 + (1));
i__26000__auto___32572 = G__32573;
continue;
} else {
}
break;
}

var G__32499 = args32497.length;
switch (G__32499) {
case 2:
return cljs.core.async.partition_by.cljs$core$IFn$_invoke$arity$2((arguments[(0)]),(arguments[(1)]));

break;
case 3:
return cljs.core.async.partition_by.cljs$core$IFn$_invoke$arity$3((arguments[(0)]),(arguments[(1)]),(arguments[(2)]));

break;
default:
throw (new Error([cljs.core.str("Invalid arity: "),cljs.core.str(args32497.length)].join('')));

}
});

cljs.core.async.partition_by.cljs$core$IFn$_invoke$arity$2 = (function (f,ch){
return cljs.core.async.partition_by.call(null,f,ch,null);
});

cljs.core.async.partition_by.cljs$core$IFn$_invoke$arity$3 = (function (f,ch,buf_or_n){
var out = cljs.core.async.chan.call(null,buf_or_n);
var c__27451__auto___32575 = cljs.core.async.chan.call(null,(1));
cljs.core.async.impl.dispatch.run.call(null,((function (c__27451__auto___32575,out){
return (function (){
var f__27452__auto__ = (function (){var switch__27386__auto__ = ((function (c__27451__auto___32575,out){
return (function (state_32541){
var state_val_32542 = (state_32541[(1)]);
if((state_val_32542 === (7))){
var inst_32537 = (state_32541[(2)]);
var state_32541__$1 = state_32541;
var statearr_32543_32576 = state_32541__$1;
(statearr_32543_32576[(2)] = inst_32537);

(statearr_32543_32576[(1)] = (3));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_32542 === (1))){
var inst_32500 = [];
var inst_32501 = inst_32500;
var inst_32502 = new cljs.core.Keyword("cljs.core.async","nothing","cljs.core.async/nothing",-69252123);
var state_32541__$1 = (function (){var statearr_32544 = state_32541;
(statearr_32544[(7)] = inst_32502);

(statearr_32544[(8)] = inst_32501);

return statearr_32544;
})();
var statearr_32545_32577 = state_32541__$1;
(statearr_32545_32577[(2)] = null);

(statearr_32545_32577[(1)] = (2));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_32542 === (4))){
var inst_32505 = (state_32541[(9)]);
var inst_32505__$1 = (state_32541[(2)]);
var inst_32506 = (inst_32505__$1 == null);
var inst_32507 = cljs.core.not.call(null,inst_32506);
var state_32541__$1 = (function (){var statearr_32546 = state_32541;
(statearr_32546[(9)] = inst_32505__$1);

return statearr_32546;
})();
if(inst_32507){
var statearr_32547_32578 = state_32541__$1;
(statearr_32547_32578[(1)] = (5));

} else {
var statearr_32548_32579 = state_32541__$1;
(statearr_32548_32579[(1)] = (6));

}

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_32542 === (15))){
var inst_32531 = (state_32541[(2)]);
var state_32541__$1 = state_32541;
var statearr_32549_32580 = state_32541__$1;
(statearr_32549_32580[(2)] = inst_32531);

(statearr_32549_32580[(1)] = (14));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_32542 === (13))){
var state_32541__$1 = state_32541;
var statearr_32550_32581 = state_32541__$1;
(statearr_32550_32581[(2)] = null);

(statearr_32550_32581[(1)] = (14));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_32542 === (6))){
var inst_32501 = (state_32541[(8)]);
var inst_32526 = inst_32501.length;
var inst_32527 = (inst_32526 > (0));
var state_32541__$1 = state_32541;
if(cljs.core.truth_(inst_32527)){
var statearr_32551_32582 = state_32541__$1;
(statearr_32551_32582[(1)] = (12));

} else {
var statearr_32552_32583 = state_32541__$1;
(statearr_32552_32583[(1)] = (13));

}

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_32542 === (3))){
var inst_32539 = (state_32541[(2)]);
var state_32541__$1 = state_32541;
return cljs.core.async.impl.ioc_helpers.return_chan.call(null,state_32541__$1,inst_32539);
} else {
if((state_val_32542 === (12))){
var inst_32501 = (state_32541[(8)]);
var inst_32529 = cljs.core.vec.call(null,inst_32501);
var state_32541__$1 = state_32541;
return cljs.core.async.impl.ioc_helpers.put_BANG_.call(null,state_32541__$1,(15),out,inst_32529);
} else {
if((state_val_32542 === (2))){
var state_32541__$1 = state_32541;
return cljs.core.async.impl.ioc_helpers.take_BANG_.call(null,state_32541__$1,(4),ch);
} else {
if((state_val_32542 === (11))){
var inst_32509 = (state_32541[(10)]);
var inst_32505 = (state_32541[(9)]);
var inst_32519 = (state_32541[(2)]);
var inst_32520 = [];
var inst_32521 = inst_32520.push(inst_32505);
var inst_32501 = inst_32520;
var inst_32502 = inst_32509;
var state_32541__$1 = (function (){var statearr_32553 = state_32541;
(statearr_32553[(11)] = inst_32521);

(statearr_32553[(7)] = inst_32502);

(statearr_32553[(12)] = inst_32519);

(statearr_32553[(8)] = inst_32501);

return statearr_32553;
})();
var statearr_32554_32584 = state_32541__$1;
(statearr_32554_32584[(2)] = null);

(statearr_32554_32584[(1)] = (2));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_32542 === (9))){
var inst_32501 = (state_32541[(8)]);
var inst_32517 = cljs.core.vec.call(null,inst_32501);
var state_32541__$1 = state_32541;
return cljs.core.async.impl.ioc_helpers.put_BANG_.call(null,state_32541__$1,(11),out,inst_32517);
} else {
if((state_val_32542 === (5))){
var inst_32502 = (state_32541[(7)]);
var inst_32509 = (state_32541[(10)]);
var inst_32505 = (state_32541[(9)]);
var inst_32509__$1 = f.call(null,inst_32505);
var inst_32510 = cljs.core._EQ_.call(null,inst_32509__$1,inst_32502);
var inst_32511 = cljs.core.keyword_identical_QMARK_.call(null,inst_32502,new cljs.core.Keyword("cljs.core.async","nothing","cljs.core.async/nothing",-69252123));
var inst_32512 = (inst_32510) || (inst_32511);
var state_32541__$1 = (function (){var statearr_32555 = state_32541;
(statearr_32555[(10)] = inst_32509__$1);

return statearr_32555;
})();
if(cljs.core.truth_(inst_32512)){
var statearr_32556_32585 = state_32541__$1;
(statearr_32556_32585[(1)] = (8));

} else {
var statearr_32557_32586 = state_32541__$1;
(statearr_32557_32586[(1)] = (9));

}

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_32542 === (14))){
var inst_32534 = (state_32541[(2)]);
var inst_32535 = cljs.core.async.close_BANG_.call(null,out);
var state_32541__$1 = (function (){var statearr_32559 = state_32541;
(statearr_32559[(13)] = inst_32534);

return statearr_32559;
})();
var statearr_32560_32587 = state_32541__$1;
(statearr_32560_32587[(2)] = inst_32535);

(statearr_32560_32587[(1)] = (7));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_32542 === (10))){
var inst_32524 = (state_32541[(2)]);
var state_32541__$1 = state_32541;
var statearr_32561_32588 = state_32541__$1;
(statearr_32561_32588[(2)] = inst_32524);

(statearr_32561_32588[(1)] = (7));


return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
if((state_val_32542 === (8))){
var inst_32509 = (state_32541[(10)]);
var inst_32501 = (state_32541[(8)]);
var inst_32505 = (state_32541[(9)]);
var inst_32514 = inst_32501.push(inst_32505);
var tmp32558 = inst_32501;
var inst_32501__$1 = tmp32558;
var inst_32502 = inst_32509;
var state_32541__$1 = (function (){var statearr_32562 = state_32541;
(statearr_32562[(14)] = inst_32514);

(statearr_32562[(7)] = inst_32502);

(statearr_32562[(8)] = inst_32501__$1);

return statearr_32562;
})();
var statearr_32563_32589 = state_32541__$1;
(statearr_32563_32589[(2)] = null);

(statearr_32563_32589[(1)] = (2));


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
});})(c__27451__auto___32575,out))
;
return ((function (switch__27386__auto__,c__27451__auto___32575,out){
return (function() {
var cljs$core$async$state_machine__27387__auto__ = null;
var cljs$core$async$state_machine__27387__auto____0 = (function (){
var statearr_32567 = [null,null,null,null,null,null,null,null,null,null,null,null,null,null,null];
(statearr_32567[(0)] = cljs$core$async$state_machine__27387__auto__);

(statearr_32567[(1)] = (1));

return statearr_32567;
});
var cljs$core$async$state_machine__27387__auto____1 = (function (state_32541){
while(true){
var ret_value__27388__auto__ = (function (){try{while(true){
var result__27389__auto__ = switch__27386__auto__.call(null,state_32541);
if(cljs.core.keyword_identical_QMARK_.call(null,result__27389__auto__,new cljs.core.Keyword(null,"recur","recur",-437573268))){
continue;
} else {
return result__27389__auto__;
}
break;
}
}catch (e32568){if((e32568 instanceof Object)){
var ex__27390__auto__ = e32568;
var statearr_32569_32590 = state_32541;
(statearr_32569_32590[(5)] = ex__27390__auto__);


cljs.core.async.impl.ioc_helpers.process_exception.call(null,state_32541);

return new cljs.core.Keyword(null,"recur","recur",-437573268);
} else {
throw e32568;

}
}})();
if(cljs.core.keyword_identical_QMARK_.call(null,ret_value__27388__auto__,new cljs.core.Keyword(null,"recur","recur",-437573268))){
var G__32591 = state_32541;
state_32541 = G__32591;
continue;
} else {
return ret_value__27388__auto__;
}
break;
}
});
cljs$core$async$state_machine__27387__auto__ = function(state_32541){
switch(arguments.length){
case 0:
return cljs$core$async$state_machine__27387__auto____0.call(this);
case 1:
return cljs$core$async$state_machine__27387__auto____1.call(this,state_32541);
}
throw(new Error('Invalid arity: ' + arguments.length));
};
cljs$core$async$state_machine__27387__auto__.cljs$core$IFn$_invoke$arity$0 = cljs$core$async$state_machine__27387__auto____0;
cljs$core$async$state_machine__27387__auto__.cljs$core$IFn$_invoke$arity$1 = cljs$core$async$state_machine__27387__auto____1;
return cljs$core$async$state_machine__27387__auto__;
})()
;})(switch__27386__auto__,c__27451__auto___32575,out))
})();
var state__27453__auto__ = (function (){var statearr_32570 = f__27452__auto__.call(null);
(statearr_32570[cljs.core.async.impl.ioc_helpers.USER_START_IDX] = c__27451__auto___32575);

return statearr_32570;
})();
return cljs.core.async.impl.ioc_helpers.run_state_machine_wrapped.call(null,state__27453__auto__);
});})(c__27451__auto___32575,out))
);


return out;
});

cljs.core.async.partition_by.cljs$lang$maxFixedArity = 3;

//# sourceMappingURL=async.js.map