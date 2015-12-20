// Compiled by ClojureScript 1.7.170 {}
goog.provide('cljs.repl');
goog.require('cljs.core');
cljs.repl.print_doc = (function cljs$repl$print_doc(m){
cljs.core.println.call(null,"-------------------------");

cljs.core.println.call(null,[cljs.core.str((function (){var temp__4425__auto__ = new cljs.core.Keyword(null,"ns","ns",441598760).cljs$core$IFn$_invoke$arity$1(m);
if(cljs.core.truth_(temp__4425__auto__)){
var ns = temp__4425__auto__;
return [cljs.core.str(ns),cljs.core.str("/")].join('');
} else {
return null;
}
})()),cljs.core.str(new cljs.core.Keyword(null,"name","name",1843675177).cljs$core$IFn$_invoke$arity$1(m))].join(''));

if(cljs.core.truth_(new cljs.core.Keyword(null,"protocol","protocol",652470118).cljs$core$IFn$_invoke$arity$1(m))){
cljs.core.println.call(null,"Protocol");
} else {
}

if(cljs.core.truth_(new cljs.core.Keyword(null,"forms","forms",2045992350).cljs$core$IFn$_invoke$arity$1(m))){
var seq__26097_26111 = cljs.core.seq.call(null,new cljs.core.Keyword(null,"forms","forms",2045992350).cljs$core$IFn$_invoke$arity$1(m));
var chunk__26098_26112 = null;
var count__26099_26113 = (0);
var i__26100_26114 = (0);
while(true){
if((i__26100_26114 < count__26099_26113)){
var f_26115 = cljs.core._nth.call(null,chunk__26098_26112,i__26100_26114);
cljs.core.println.call(null,"  ",f_26115);

var G__26116 = seq__26097_26111;
var G__26117 = chunk__26098_26112;
var G__26118 = count__26099_26113;
var G__26119 = (i__26100_26114 + (1));
seq__26097_26111 = G__26116;
chunk__26098_26112 = G__26117;
count__26099_26113 = G__26118;
i__26100_26114 = G__26119;
continue;
} else {
var temp__4425__auto___26120 = cljs.core.seq.call(null,seq__26097_26111);
if(temp__4425__auto___26120){
var seq__26097_26121__$1 = temp__4425__auto___26120;
if(cljs.core.chunked_seq_QMARK_.call(null,seq__26097_26121__$1)){
var c__25744__auto___26122 = cljs.core.chunk_first.call(null,seq__26097_26121__$1);
var G__26123 = cljs.core.chunk_rest.call(null,seq__26097_26121__$1);
var G__26124 = c__25744__auto___26122;
var G__26125 = cljs.core.count.call(null,c__25744__auto___26122);
var G__26126 = (0);
seq__26097_26111 = G__26123;
chunk__26098_26112 = G__26124;
count__26099_26113 = G__26125;
i__26100_26114 = G__26126;
continue;
} else {
var f_26127 = cljs.core.first.call(null,seq__26097_26121__$1);
cljs.core.println.call(null,"  ",f_26127);

var G__26128 = cljs.core.next.call(null,seq__26097_26121__$1);
var G__26129 = null;
var G__26130 = (0);
var G__26131 = (0);
seq__26097_26111 = G__26128;
chunk__26098_26112 = G__26129;
count__26099_26113 = G__26130;
i__26100_26114 = G__26131;
continue;
}
} else {
}
}
break;
}
} else {
if(cljs.core.truth_(new cljs.core.Keyword(null,"arglists","arglists",1661989754).cljs$core$IFn$_invoke$arity$1(m))){
var arglists_26132 = new cljs.core.Keyword(null,"arglists","arglists",1661989754).cljs$core$IFn$_invoke$arity$1(m);
if(cljs.core.truth_((function (){var or__24941__auto__ = new cljs.core.Keyword(null,"macro","macro",-867863404).cljs$core$IFn$_invoke$arity$1(m);
if(cljs.core.truth_(or__24941__auto__)){
return or__24941__auto__;
} else {
return new cljs.core.Keyword(null,"repl-special-function","repl-special-function",1262603725).cljs$core$IFn$_invoke$arity$1(m);
}
})())){
cljs.core.prn.call(null,arglists_26132);
} else {
cljs.core.prn.call(null,((cljs.core._EQ_.call(null,new cljs.core.Symbol(null,"quote","quote",1377916282,null),cljs.core.first.call(null,arglists_26132)))?cljs.core.second.call(null,arglists_26132):arglists_26132));
}
} else {
}
}

if(cljs.core.truth_(new cljs.core.Keyword(null,"special-form","special-form",-1326536374).cljs$core$IFn$_invoke$arity$1(m))){
cljs.core.println.call(null,"Special Form");

cljs.core.println.call(null," ",new cljs.core.Keyword(null,"doc","doc",1913296891).cljs$core$IFn$_invoke$arity$1(m));

if(cljs.core.contains_QMARK_.call(null,m,new cljs.core.Keyword(null,"url","url",276297046))){
if(cljs.core.truth_(new cljs.core.Keyword(null,"url","url",276297046).cljs$core$IFn$_invoke$arity$1(m))){
return cljs.core.println.call(null,[cljs.core.str("\n  Please see http://clojure.org/"),cljs.core.str(new cljs.core.Keyword(null,"url","url",276297046).cljs$core$IFn$_invoke$arity$1(m))].join(''));
} else {
return null;
}
} else {
return cljs.core.println.call(null,[cljs.core.str("\n  Please see http://clojure.org/special_forms#"),cljs.core.str(new cljs.core.Keyword(null,"name","name",1843675177).cljs$core$IFn$_invoke$arity$1(m))].join(''));
}
} else {
if(cljs.core.truth_(new cljs.core.Keyword(null,"macro","macro",-867863404).cljs$core$IFn$_invoke$arity$1(m))){
cljs.core.println.call(null,"Macro");
} else {
}

if(cljs.core.truth_(new cljs.core.Keyword(null,"repl-special-function","repl-special-function",1262603725).cljs$core$IFn$_invoke$arity$1(m))){
cljs.core.println.call(null,"REPL Special Function");
} else {
}

cljs.core.println.call(null," ",new cljs.core.Keyword(null,"doc","doc",1913296891).cljs$core$IFn$_invoke$arity$1(m));

if(cljs.core.truth_(new cljs.core.Keyword(null,"protocol","protocol",652470118).cljs$core$IFn$_invoke$arity$1(m))){
var seq__26101 = cljs.core.seq.call(null,new cljs.core.Keyword(null,"methods","methods",453930866).cljs$core$IFn$_invoke$arity$1(m));
var chunk__26102 = null;
var count__26103 = (0);
var i__26104 = (0);
while(true){
if((i__26104 < count__26103)){
var vec__26105 = cljs.core._nth.call(null,chunk__26102,i__26104);
var name = cljs.core.nth.call(null,vec__26105,(0),null);
var map__26106 = cljs.core.nth.call(null,vec__26105,(1),null);
var map__26106__$1 = ((((!((map__26106 == null)))?((((map__26106.cljs$lang$protocol_mask$partition0$ & (64))) || (map__26106.cljs$core$ISeq$))?true:false):false))?cljs.core.apply.call(null,cljs.core.hash_map,map__26106):map__26106);
var doc = cljs.core.get.call(null,map__26106__$1,new cljs.core.Keyword(null,"doc","doc",1913296891));
var arglists = cljs.core.get.call(null,map__26106__$1,new cljs.core.Keyword(null,"arglists","arglists",1661989754));
cljs.core.println.call(null);

cljs.core.println.call(null," ",name);

cljs.core.println.call(null," ",arglists);

if(cljs.core.truth_(doc)){
cljs.core.println.call(null," ",doc);
} else {
}

var G__26133 = seq__26101;
var G__26134 = chunk__26102;
var G__26135 = count__26103;
var G__26136 = (i__26104 + (1));
seq__26101 = G__26133;
chunk__26102 = G__26134;
count__26103 = G__26135;
i__26104 = G__26136;
continue;
} else {
var temp__4425__auto__ = cljs.core.seq.call(null,seq__26101);
if(temp__4425__auto__){
var seq__26101__$1 = temp__4425__auto__;
if(cljs.core.chunked_seq_QMARK_.call(null,seq__26101__$1)){
var c__25744__auto__ = cljs.core.chunk_first.call(null,seq__26101__$1);
var G__26137 = cljs.core.chunk_rest.call(null,seq__26101__$1);
var G__26138 = c__25744__auto__;
var G__26139 = cljs.core.count.call(null,c__25744__auto__);
var G__26140 = (0);
seq__26101 = G__26137;
chunk__26102 = G__26138;
count__26103 = G__26139;
i__26104 = G__26140;
continue;
} else {
var vec__26108 = cljs.core.first.call(null,seq__26101__$1);
var name = cljs.core.nth.call(null,vec__26108,(0),null);
var map__26109 = cljs.core.nth.call(null,vec__26108,(1),null);
var map__26109__$1 = ((((!((map__26109 == null)))?((((map__26109.cljs$lang$protocol_mask$partition0$ & (64))) || (map__26109.cljs$core$ISeq$))?true:false):false))?cljs.core.apply.call(null,cljs.core.hash_map,map__26109):map__26109);
var doc = cljs.core.get.call(null,map__26109__$1,new cljs.core.Keyword(null,"doc","doc",1913296891));
var arglists = cljs.core.get.call(null,map__26109__$1,new cljs.core.Keyword(null,"arglists","arglists",1661989754));
cljs.core.println.call(null);

cljs.core.println.call(null," ",name);

cljs.core.println.call(null," ",arglists);

if(cljs.core.truth_(doc)){
cljs.core.println.call(null," ",doc);
} else {
}

var G__26141 = cljs.core.next.call(null,seq__26101__$1);
var G__26142 = null;
var G__26143 = (0);
var G__26144 = (0);
seq__26101 = G__26141;
chunk__26102 = G__26142;
count__26103 = G__26143;
i__26104 = G__26144;
continue;
}
} else {
return null;
}
}
break;
}
} else {
return null;
}
}
});

//# sourceMappingURL=repl.js.map