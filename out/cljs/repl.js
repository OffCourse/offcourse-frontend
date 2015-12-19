// Compiled by ClojureScript 1.7.122 {}
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
var seq__25916_25930 = cljs.core.seq.call(null,new cljs.core.Keyword(null,"forms","forms",2045992350).cljs$core$IFn$_invoke$arity$1(m));
var chunk__25917_25931 = null;
var count__25918_25932 = (0);
var i__25919_25933 = (0);
while(true){
if((i__25919_25933 < count__25918_25932)){
var f_25934 = cljs.core._nth.call(null,chunk__25917_25931,i__25919_25933);
cljs.core.println.call(null,"  ",f_25934);

var G__25935 = seq__25916_25930;
var G__25936 = chunk__25917_25931;
var G__25937 = count__25918_25932;
var G__25938 = (i__25919_25933 + (1));
seq__25916_25930 = G__25935;
chunk__25917_25931 = G__25936;
count__25918_25932 = G__25937;
i__25919_25933 = G__25938;
continue;
} else {
var temp__4425__auto___25939 = cljs.core.seq.call(null,seq__25916_25930);
if(temp__4425__auto___25939){
var seq__25916_25940__$1 = temp__4425__auto___25939;
if(cljs.core.chunked_seq_QMARK_.call(null,seq__25916_25940__$1)){
var c__25563__auto___25941 = cljs.core.chunk_first.call(null,seq__25916_25940__$1);
var G__25942 = cljs.core.chunk_rest.call(null,seq__25916_25940__$1);
var G__25943 = c__25563__auto___25941;
var G__25944 = cljs.core.count.call(null,c__25563__auto___25941);
var G__25945 = (0);
seq__25916_25930 = G__25942;
chunk__25917_25931 = G__25943;
count__25918_25932 = G__25944;
i__25919_25933 = G__25945;
continue;
} else {
var f_25946 = cljs.core.first.call(null,seq__25916_25940__$1);
cljs.core.println.call(null,"  ",f_25946);

var G__25947 = cljs.core.next.call(null,seq__25916_25940__$1);
var G__25948 = null;
var G__25949 = (0);
var G__25950 = (0);
seq__25916_25930 = G__25947;
chunk__25917_25931 = G__25948;
count__25918_25932 = G__25949;
i__25919_25933 = G__25950;
continue;
}
} else {
}
}
break;
}
} else {
if(cljs.core.truth_(new cljs.core.Keyword(null,"arglists","arglists",1661989754).cljs$core$IFn$_invoke$arity$1(m))){
var arglists_25951 = new cljs.core.Keyword(null,"arglists","arglists",1661989754).cljs$core$IFn$_invoke$arity$1(m);
if(cljs.core.truth_((function (){var or__24760__auto__ = new cljs.core.Keyword(null,"macro","macro",-867863404).cljs$core$IFn$_invoke$arity$1(m);
if(cljs.core.truth_(or__24760__auto__)){
return or__24760__auto__;
} else {
return new cljs.core.Keyword(null,"repl-special-function","repl-special-function",1262603725).cljs$core$IFn$_invoke$arity$1(m);
}
})())){
cljs.core.prn.call(null,arglists_25951);
} else {
cljs.core.prn.call(null,((cljs.core._EQ_.call(null,new cljs.core.Symbol(null,"quote","quote",1377916282,null),cljs.core.first.call(null,arglists_25951)))?cljs.core.second.call(null,arglists_25951):arglists_25951));
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
var seq__25920 = cljs.core.seq.call(null,new cljs.core.Keyword(null,"methods","methods",453930866).cljs$core$IFn$_invoke$arity$1(m));
var chunk__25921 = null;
var count__25922 = (0);
var i__25923 = (0);
while(true){
if((i__25923 < count__25922)){
var vec__25924 = cljs.core._nth.call(null,chunk__25921,i__25923);
var name = cljs.core.nth.call(null,vec__25924,(0),null);
var map__25925 = cljs.core.nth.call(null,vec__25924,(1),null);
var map__25925__$1 = ((((!((map__25925 == null)))?((((map__25925.cljs$lang$protocol_mask$partition0$ & (64))) || (map__25925.cljs$core$ISeq$))?true:false):false))?cljs.core.apply.call(null,cljs.core.hash_map,map__25925):map__25925);
var doc = cljs.core.get.call(null,map__25925__$1,new cljs.core.Keyword(null,"doc","doc",1913296891));
var arglists = cljs.core.get.call(null,map__25925__$1,new cljs.core.Keyword(null,"arglists","arglists",1661989754));
cljs.core.println.call(null);

cljs.core.println.call(null," ",name);

cljs.core.println.call(null," ",arglists);

if(cljs.core.truth_(doc)){
cljs.core.println.call(null," ",doc);
} else {
}

var G__25952 = seq__25920;
var G__25953 = chunk__25921;
var G__25954 = count__25922;
var G__25955 = (i__25923 + (1));
seq__25920 = G__25952;
chunk__25921 = G__25953;
count__25922 = G__25954;
i__25923 = G__25955;
continue;
} else {
var temp__4425__auto__ = cljs.core.seq.call(null,seq__25920);
if(temp__4425__auto__){
var seq__25920__$1 = temp__4425__auto__;
if(cljs.core.chunked_seq_QMARK_.call(null,seq__25920__$1)){
var c__25563__auto__ = cljs.core.chunk_first.call(null,seq__25920__$1);
var G__25956 = cljs.core.chunk_rest.call(null,seq__25920__$1);
var G__25957 = c__25563__auto__;
var G__25958 = cljs.core.count.call(null,c__25563__auto__);
var G__25959 = (0);
seq__25920 = G__25956;
chunk__25921 = G__25957;
count__25922 = G__25958;
i__25923 = G__25959;
continue;
} else {
var vec__25927 = cljs.core.first.call(null,seq__25920__$1);
var name = cljs.core.nth.call(null,vec__25927,(0),null);
var map__25928 = cljs.core.nth.call(null,vec__25927,(1),null);
var map__25928__$1 = ((((!((map__25928 == null)))?((((map__25928.cljs$lang$protocol_mask$partition0$ & (64))) || (map__25928.cljs$core$ISeq$))?true:false):false))?cljs.core.apply.call(null,cljs.core.hash_map,map__25928):map__25928);
var doc = cljs.core.get.call(null,map__25928__$1,new cljs.core.Keyword(null,"doc","doc",1913296891));
var arglists = cljs.core.get.call(null,map__25928__$1,new cljs.core.Keyword(null,"arglists","arglists",1661989754));
cljs.core.println.call(null);

cljs.core.println.call(null," ",name);

cljs.core.println.call(null," ",arglists);

if(cljs.core.truth_(doc)){
cljs.core.println.call(null," ",doc);
} else {
}

var G__25960 = cljs.core.next.call(null,seq__25920__$1);
var G__25961 = null;
var G__25962 = (0);
var G__25963 = (0);
seq__25920 = G__25960;
chunk__25921 = G__25961;
count__25922 = G__25962;
i__25923 = G__25963;
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