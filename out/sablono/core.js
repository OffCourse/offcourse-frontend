// Compiled by ClojureScript 1.7.170 {}
goog.provide('sablono.core');
goog.require('cljs.core');
goog.require('goog.dom');
goog.require('goog.string');
goog.require('sablono.normalize');
goog.require('sablono.util');
goog.require('sablono.interpreter');
goog.require('cljsjs.react');
goog.require('cljsjs.react.dom.server');
goog.require('cljsjs.react.dom');
goog.require('clojure.string');
/**
 * Add an optional attribute argument to a function that returns a element vector.
 */
sablono.core.wrap_attrs = (function sablono$core$wrap_attrs(func){
return (function() { 
var G__28193__delegate = function (args){
if(cljs.core.map_QMARK_.call(null,cljs.core.first.call(null,args))){
var vec__28192 = cljs.core.apply.call(null,func,cljs.core.rest.call(null,args));
var tag = cljs.core.nth.call(null,vec__28192,(0),null);
var body = cljs.core.nthnext.call(null,vec__28192,(1));
if(cljs.core.map_QMARK_.call(null,cljs.core.first.call(null,body))){
return cljs.core.apply.call(null,cljs.core.vector,tag,cljs.core.merge.call(null,cljs.core.first.call(null,body),cljs.core.first.call(null,args)),cljs.core.rest.call(null,body));
} else {
return cljs.core.apply.call(null,cljs.core.vector,tag,cljs.core.first.call(null,args),body);
}
} else {
return cljs.core.apply.call(null,func,args);
}
};
var G__28193 = function (var_args){
var args = null;
if (arguments.length > 0) {
var G__28194__i = 0, G__28194__a = new Array(arguments.length -  0);
while (G__28194__i < G__28194__a.length) {G__28194__a[G__28194__i] = arguments[G__28194__i + 0]; ++G__28194__i;}
  args = new cljs.core.IndexedSeq(G__28194__a,0);
} 
return G__28193__delegate.call(this,args);};
G__28193.cljs$lang$maxFixedArity = 0;
G__28193.cljs$lang$applyTo = (function (arglist__28195){
var args = cljs.core.seq(arglist__28195);
return G__28193__delegate(args);
});
G__28193.cljs$core$IFn$_invoke$arity$variadic = G__28193__delegate;
return G__28193;
})()
;
});
sablono.core.update_arglists = (function sablono$core$update_arglists(arglists){
var iter__25713__auto__ = (function sablono$core$update_arglists_$_iter__28200(s__28201){
return (new cljs.core.LazySeq(null,(function (){
var s__28201__$1 = s__28201;
while(true){
var temp__4425__auto__ = cljs.core.seq.call(null,s__28201__$1);
if(temp__4425__auto__){
var s__28201__$2 = temp__4425__auto__;
if(cljs.core.chunked_seq_QMARK_.call(null,s__28201__$2)){
var c__25711__auto__ = cljs.core.chunk_first.call(null,s__28201__$2);
var size__25712__auto__ = cljs.core.count.call(null,c__25711__auto__);
var b__28203 = cljs.core.chunk_buffer.call(null,size__25712__auto__);
if((function (){var i__28202 = (0);
while(true){
if((i__28202 < size__25712__auto__)){
var args = cljs.core._nth.call(null,c__25711__auto__,i__28202);
cljs.core.chunk_append.call(null,b__28203,cljs.core.vec.call(null,cljs.core.cons.call(null,new cljs.core.Symbol(null,"attr-map?","attr-map?",116307443,null),args)));

var G__28204 = (i__28202 + (1));
i__28202 = G__28204;
continue;
} else {
return true;
}
break;
}
})()){
return cljs.core.chunk_cons.call(null,cljs.core.chunk.call(null,b__28203),sablono$core$update_arglists_$_iter__28200.call(null,cljs.core.chunk_rest.call(null,s__28201__$2)));
} else {
return cljs.core.chunk_cons.call(null,cljs.core.chunk.call(null,b__28203),null);
}
} else {
var args = cljs.core.first.call(null,s__28201__$2);
return cljs.core.cons.call(null,cljs.core.vec.call(null,cljs.core.cons.call(null,new cljs.core.Symbol(null,"attr-map?","attr-map?",116307443,null),args)),sablono$core$update_arglists_$_iter__28200.call(null,cljs.core.rest.call(null,s__28201__$2)));
}
} else {
return null;
}
break;
}
}),null,null));
});
return iter__25713__auto__.call(null,arglists);
});
/**
 * Render `element` as HTML string.
 */
sablono.core.render = (function sablono$core$render(element){
if(cljs.core.truth_(element)){
return ReactDOMServer.renderToString(element);
} else {
return null;
}
});
/**
 * Render `element` as HTML string, without React internal attributes.
 */
sablono.core.render_static = (function sablono$core$render_static(element){
if(cljs.core.truth_(element)){
return ReactDOMServer.renderToStaticMarkup(element);
} else {
return null;
}
});
/**
 * Include a list of external stylesheet files.
 */
sablono.core.include_css = (function sablono$core$include_css(var_args){
var args__26006__auto__ = [];
var len__25999__auto___28210 = arguments.length;
var i__26000__auto___28211 = (0);
while(true){
if((i__26000__auto___28211 < len__25999__auto___28210)){
args__26006__auto__.push((arguments[i__26000__auto___28211]));

var G__28212 = (i__26000__auto___28211 + (1));
i__26000__auto___28211 = G__28212;
continue;
} else {
}
break;
}

var argseq__26007__auto__ = ((((0) < args__26006__auto__.length))?(new cljs.core.IndexedSeq(args__26006__auto__.slice((0)),(0))):null);
return sablono.core.include_css.cljs$core$IFn$_invoke$arity$variadic(argseq__26007__auto__);
});

sablono.core.include_css.cljs$core$IFn$_invoke$arity$variadic = (function (styles){
var iter__25713__auto__ = (function sablono$core$iter__28206(s__28207){
return (new cljs.core.LazySeq(null,(function (){
var s__28207__$1 = s__28207;
while(true){
var temp__4425__auto__ = cljs.core.seq.call(null,s__28207__$1);
if(temp__4425__auto__){
var s__28207__$2 = temp__4425__auto__;
if(cljs.core.chunked_seq_QMARK_.call(null,s__28207__$2)){
var c__25711__auto__ = cljs.core.chunk_first.call(null,s__28207__$2);
var size__25712__auto__ = cljs.core.count.call(null,c__25711__auto__);
var b__28209 = cljs.core.chunk_buffer.call(null,size__25712__auto__);
if((function (){var i__28208 = (0);
while(true){
if((i__28208 < size__25712__auto__)){
var style = cljs.core._nth.call(null,c__25711__auto__,i__28208);
cljs.core.chunk_append.call(null,b__28209,new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Keyword(null,"link","link",-1769163468),new cljs.core.PersistentArrayMap(null, 3, [new cljs.core.Keyword(null,"type","type",1174270348),"text/css",new cljs.core.Keyword(null,"href","href",-793805698),sablono.util.as_str.call(null,style),new cljs.core.Keyword(null,"rel","rel",1378823488),"stylesheet"], null)], null));

var G__28213 = (i__28208 + (1));
i__28208 = G__28213;
continue;
} else {
return true;
}
break;
}
})()){
return cljs.core.chunk_cons.call(null,cljs.core.chunk.call(null,b__28209),sablono$core$iter__28206.call(null,cljs.core.chunk_rest.call(null,s__28207__$2)));
} else {
return cljs.core.chunk_cons.call(null,cljs.core.chunk.call(null,b__28209),null);
}
} else {
var style = cljs.core.first.call(null,s__28207__$2);
return cljs.core.cons.call(null,new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Keyword(null,"link","link",-1769163468),new cljs.core.PersistentArrayMap(null, 3, [new cljs.core.Keyword(null,"type","type",1174270348),"text/css",new cljs.core.Keyword(null,"href","href",-793805698),sablono.util.as_str.call(null,style),new cljs.core.Keyword(null,"rel","rel",1378823488),"stylesheet"], null)], null),sablono$core$iter__28206.call(null,cljs.core.rest.call(null,s__28207__$2)));
}
} else {
return null;
}
break;
}
}),null,null));
});
return iter__25713__auto__.call(null,styles);
});

sablono.core.include_css.cljs$lang$maxFixedArity = (0);

sablono.core.include_css.cljs$lang$applyTo = (function (seq28205){
return sablono.core.include_css.cljs$core$IFn$_invoke$arity$variadic(cljs.core.seq.call(null,seq28205));
});
/**
 * Include the JavaScript library at `src`.
 */
sablono.core.include_js = (function sablono$core$include_js(src){
return goog.dom.appendChild(goog.dom.getDocument().body,goog.dom.createDom("script",{"src": src}));
});
/**
 * Include Facebook's React JavaScript library.
 */
sablono.core.include_react = (function sablono$core$include_react(){
return sablono.core.include_js.call(null,"http://fb.me/react-0.12.2.js");
});
/**
 * Wraps some content in a HTML hyperlink with the supplied URL.
 */
sablono.core.link_to28214 = (function sablono$core$link_to28214(var_args){
var args__26006__auto__ = [];
var len__25999__auto___28217 = arguments.length;
var i__26000__auto___28218 = (0);
while(true){
if((i__26000__auto___28218 < len__25999__auto___28217)){
args__26006__auto__.push((arguments[i__26000__auto___28218]));

var G__28219 = (i__26000__auto___28218 + (1));
i__26000__auto___28218 = G__28219;
continue;
} else {
}
break;
}

var argseq__26007__auto__ = ((((1) < args__26006__auto__.length))?(new cljs.core.IndexedSeq(args__26006__auto__.slice((1)),(0))):null);
return sablono.core.link_to28214.cljs$core$IFn$_invoke$arity$variadic((arguments[(0)]),argseq__26007__auto__);
});

sablono.core.link_to28214.cljs$core$IFn$_invoke$arity$variadic = (function (url,content){
return new cljs.core.PersistentVector(null, 3, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Keyword(null,"a","a",-2123407586),new cljs.core.PersistentArrayMap(null, 1, [new cljs.core.Keyword(null,"href","href",-793805698),sablono.util.as_str.call(null,url)], null),content], null);
});

sablono.core.link_to28214.cljs$lang$maxFixedArity = (1);

sablono.core.link_to28214.cljs$lang$applyTo = (function (seq28215){
var G__28216 = cljs.core.first.call(null,seq28215);
var seq28215__$1 = cljs.core.next.call(null,seq28215);
return sablono.core.link_to28214.cljs$core$IFn$_invoke$arity$variadic(G__28216,seq28215__$1);
});

sablono.core.link_to = sablono.core.wrap_attrs.call(null,sablono.core.link_to28214);
/**
 * Wraps some content in a HTML hyperlink with the supplied e-mail
 *   address. If no content provided use the e-mail address as content.
 */
sablono.core.mail_to28220 = (function sablono$core$mail_to28220(var_args){
var args__26006__auto__ = [];
var len__25999__auto___28225 = arguments.length;
var i__26000__auto___28226 = (0);
while(true){
if((i__26000__auto___28226 < len__25999__auto___28225)){
args__26006__auto__.push((arguments[i__26000__auto___28226]));

var G__28227 = (i__26000__auto___28226 + (1));
i__26000__auto___28226 = G__28227;
continue;
} else {
}
break;
}

var argseq__26007__auto__ = ((((1) < args__26006__auto__.length))?(new cljs.core.IndexedSeq(args__26006__auto__.slice((1)),(0))):null);
return sablono.core.mail_to28220.cljs$core$IFn$_invoke$arity$variadic((arguments[(0)]),argseq__26007__auto__);
});

sablono.core.mail_to28220.cljs$core$IFn$_invoke$arity$variadic = (function (e_mail,p__28223){
var vec__28224 = p__28223;
var content = cljs.core.nth.call(null,vec__28224,(0),null);
return new cljs.core.PersistentVector(null, 3, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Keyword(null,"a","a",-2123407586),new cljs.core.PersistentArrayMap(null, 1, [new cljs.core.Keyword(null,"href","href",-793805698),[cljs.core.str("mailto:"),cljs.core.str(e_mail)].join('')], null),(function (){var or__24941__auto__ = content;
if(cljs.core.truth_(or__24941__auto__)){
return or__24941__auto__;
} else {
return e_mail;
}
})()], null);
});

sablono.core.mail_to28220.cljs$lang$maxFixedArity = (1);

sablono.core.mail_to28220.cljs$lang$applyTo = (function (seq28221){
var G__28222 = cljs.core.first.call(null,seq28221);
var seq28221__$1 = cljs.core.next.call(null,seq28221);
return sablono.core.mail_to28220.cljs$core$IFn$_invoke$arity$variadic(G__28222,seq28221__$1);
});

sablono.core.mail_to = sablono.core.wrap_attrs.call(null,sablono.core.mail_to28220);
/**
 * Wrap a collection in an unordered list.
 */
sablono.core.unordered_list28228 = (function sablono$core$unordered_list28228(coll){
return new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Keyword(null,"ul","ul",-1349521403),(function (){var iter__25713__auto__ = (function sablono$core$unordered_list28228_$_iter__28233(s__28234){
return (new cljs.core.LazySeq(null,(function (){
var s__28234__$1 = s__28234;
while(true){
var temp__4425__auto__ = cljs.core.seq.call(null,s__28234__$1);
if(temp__4425__auto__){
var s__28234__$2 = temp__4425__auto__;
if(cljs.core.chunked_seq_QMARK_.call(null,s__28234__$2)){
var c__25711__auto__ = cljs.core.chunk_first.call(null,s__28234__$2);
var size__25712__auto__ = cljs.core.count.call(null,c__25711__auto__);
var b__28236 = cljs.core.chunk_buffer.call(null,size__25712__auto__);
if((function (){var i__28235 = (0);
while(true){
if((i__28235 < size__25712__auto__)){
var x = cljs.core._nth.call(null,c__25711__auto__,i__28235);
cljs.core.chunk_append.call(null,b__28236,new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Keyword(null,"li","li",723558921),x], null));

var G__28237 = (i__28235 + (1));
i__28235 = G__28237;
continue;
} else {
return true;
}
break;
}
})()){
return cljs.core.chunk_cons.call(null,cljs.core.chunk.call(null,b__28236),sablono$core$unordered_list28228_$_iter__28233.call(null,cljs.core.chunk_rest.call(null,s__28234__$2)));
} else {
return cljs.core.chunk_cons.call(null,cljs.core.chunk.call(null,b__28236),null);
}
} else {
var x = cljs.core.first.call(null,s__28234__$2);
return cljs.core.cons.call(null,new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Keyword(null,"li","li",723558921),x], null),sablono$core$unordered_list28228_$_iter__28233.call(null,cljs.core.rest.call(null,s__28234__$2)));
}
} else {
return null;
}
break;
}
}),null,null));
});
return iter__25713__auto__.call(null,coll);
})()], null);
});

sablono.core.unordered_list = sablono.core.wrap_attrs.call(null,sablono.core.unordered_list28228);
/**
 * Wrap a collection in an ordered list.
 */
sablono.core.ordered_list28238 = (function sablono$core$ordered_list28238(coll){
return new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Keyword(null,"ol","ol",932524051),(function (){var iter__25713__auto__ = (function sablono$core$ordered_list28238_$_iter__28243(s__28244){
return (new cljs.core.LazySeq(null,(function (){
var s__28244__$1 = s__28244;
while(true){
var temp__4425__auto__ = cljs.core.seq.call(null,s__28244__$1);
if(temp__4425__auto__){
var s__28244__$2 = temp__4425__auto__;
if(cljs.core.chunked_seq_QMARK_.call(null,s__28244__$2)){
var c__25711__auto__ = cljs.core.chunk_first.call(null,s__28244__$2);
var size__25712__auto__ = cljs.core.count.call(null,c__25711__auto__);
var b__28246 = cljs.core.chunk_buffer.call(null,size__25712__auto__);
if((function (){var i__28245 = (0);
while(true){
if((i__28245 < size__25712__auto__)){
var x = cljs.core._nth.call(null,c__25711__auto__,i__28245);
cljs.core.chunk_append.call(null,b__28246,new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Keyword(null,"li","li",723558921),x], null));

var G__28247 = (i__28245 + (1));
i__28245 = G__28247;
continue;
} else {
return true;
}
break;
}
})()){
return cljs.core.chunk_cons.call(null,cljs.core.chunk.call(null,b__28246),sablono$core$ordered_list28238_$_iter__28243.call(null,cljs.core.chunk_rest.call(null,s__28244__$2)));
} else {
return cljs.core.chunk_cons.call(null,cljs.core.chunk.call(null,b__28246),null);
}
} else {
var x = cljs.core.first.call(null,s__28244__$2);
return cljs.core.cons.call(null,new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Keyword(null,"li","li",723558921),x], null),sablono$core$ordered_list28238_$_iter__28243.call(null,cljs.core.rest.call(null,s__28244__$2)));
}
} else {
return null;
}
break;
}
}),null,null));
});
return iter__25713__auto__.call(null,coll);
})()], null);
});

sablono.core.ordered_list = sablono.core.wrap_attrs.call(null,sablono.core.ordered_list28238);
/**
 * Create an image element.
 */
sablono.core.image28248 = (function sablono$core$image28248(var_args){
var args28249 = [];
var len__25999__auto___28252 = arguments.length;
var i__26000__auto___28253 = (0);
while(true){
if((i__26000__auto___28253 < len__25999__auto___28252)){
args28249.push((arguments[i__26000__auto___28253]));

var G__28254 = (i__26000__auto___28253 + (1));
i__26000__auto___28253 = G__28254;
continue;
} else {
}
break;
}

var G__28251 = args28249.length;
switch (G__28251) {
case 1:
return sablono.core.image28248.cljs$core$IFn$_invoke$arity$1((arguments[(0)]));

break;
case 2:
return sablono.core.image28248.cljs$core$IFn$_invoke$arity$2((arguments[(0)]),(arguments[(1)]));

break;
default:
throw (new Error([cljs.core.str("Invalid arity: "),cljs.core.str(args28249.length)].join('')));

}
});

sablono.core.image28248.cljs$core$IFn$_invoke$arity$1 = (function (src){
return new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Keyword(null,"img","img",1442687358),new cljs.core.PersistentArrayMap(null, 1, [new cljs.core.Keyword(null,"src","src",-1651076051),sablono.util.as_str.call(null,src)], null)], null);
});

sablono.core.image28248.cljs$core$IFn$_invoke$arity$2 = (function (src,alt){
return new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Keyword(null,"img","img",1442687358),new cljs.core.PersistentArrayMap(null, 2, [new cljs.core.Keyword(null,"src","src",-1651076051),sablono.util.as_str.call(null,src),new cljs.core.Keyword(null,"alt","alt",-3214426),alt], null)], null);
});

sablono.core.image28248.cljs$lang$maxFixedArity = 2;

sablono.core.image = sablono.core.wrap_attrs.call(null,sablono.core.image28248);
sablono.core._STAR_group_STAR_ = cljs.core.PersistentVector.EMPTY;
/**
 * Create a field name from the supplied argument the current field group.
 */
sablono.core.make_name = (function sablono$core$make_name(name){
return cljs.core.reduce.call(null,(function (p1__28256_SHARP_,p2__28257_SHARP_){
return [cljs.core.str(p1__28256_SHARP_),cljs.core.str("["),cljs.core.str(p2__28257_SHARP_),cljs.core.str("]")].join('');
}),cljs.core.conj.call(null,sablono.core._STAR_group_STAR_,sablono.util.as_str.call(null,name)));
});
/**
 * Create a field id from the supplied argument and current field group.
 */
sablono.core.make_id = (function sablono$core$make_id(name){
return cljs.core.reduce.call(null,(function (p1__28258_SHARP_,p2__28259_SHARP_){
return [cljs.core.str(p1__28258_SHARP_),cljs.core.str("-"),cljs.core.str(p2__28259_SHARP_)].join('');
}),cljs.core.conj.call(null,sablono.core._STAR_group_STAR_,sablono.util.as_str.call(null,name)));
});
/**
 * Creates a new <input> element.
 */
sablono.core.input_field_STAR_ = (function sablono$core$input_field_STAR_(type,name,value){
return new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Keyword(null,"input","input",556931961),new cljs.core.PersistentArrayMap(null, 4, [new cljs.core.Keyword(null,"type","type",1174270348),type,new cljs.core.Keyword(null,"name","name",1843675177),sablono.core.make_name.call(null,name),new cljs.core.Keyword(null,"id","id",-1388402092),sablono.core.make_id.call(null,name),new cljs.core.Keyword(null,"value","value",305978217),value], null)], null);
});
/**
 * Creates a color input field.
 */
sablono.core.color_field28260 = (function sablono$core$color_field28260(var_args){
var args28261 = [];
var len__25999__auto___28328 = arguments.length;
var i__26000__auto___28329 = (0);
while(true){
if((i__26000__auto___28329 < len__25999__auto___28328)){
args28261.push((arguments[i__26000__auto___28329]));

var G__28330 = (i__26000__auto___28329 + (1));
i__26000__auto___28329 = G__28330;
continue;
} else {
}
break;
}

var G__28263 = args28261.length;
switch (G__28263) {
case 1:
return sablono.core.color_field28260.cljs$core$IFn$_invoke$arity$1((arguments[(0)]));

break;
case 2:
return sablono.core.color_field28260.cljs$core$IFn$_invoke$arity$2((arguments[(0)]),(arguments[(1)]));

break;
default:
throw (new Error([cljs.core.str("Invalid arity: "),cljs.core.str(args28261.length)].join('')));

}
});

sablono.core.color_field28260.cljs$core$IFn$_invoke$arity$1 = (function (name__28021__auto__){
return sablono.core.color_field28260.call(null,name__28021__auto__,null);
});

sablono.core.color_field28260.cljs$core$IFn$_invoke$arity$2 = (function (name__28021__auto__,value__28022__auto__){
return sablono.core.input_field_STAR_.call(null,[cljs.core.str(new cljs.core.Symbol(null,"color","color",-1642760596,null))].join(''),name__28021__auto__,value__28022__auto__);
});

sablono.core.color_field28260.cljs$lang$maxFixedArity = 2;

sablono.core.color_field = sablono.core.wrap_attrs.call(null,sablono.core.color_field28260);

/**
 * Creates a date input field.
 */
sablono.core.date_field28264 = (function sablono$core$date_field28264(var_args){
var args28265 = [];
var len__25999__auto___28332 = arguments.length;
var i__26000__auto___28333 = (0);
while(true){
if((i__26000__auto___28333 < len__25999__auto___28332)){
args28265.push((arguments[i__26000__auto___28333]));

var G__28334 = (i__26000__auto___28333 + (1));
i__26000__auto___28333 = G__28334;
continue;
} else {
}
break;
}

var G__28267 = args28265.length;
switch (G__28267) {
case 1:
return sablono.core.date_field28264.cljs$core$IFn$_invoke$arity$1((arguments[(0)]));

break;
case 2:
return sablono.core.date_field28264.cljs$core$IFn$_invoke$arity$2((arguments[(0)]),(arguments[(1)]));

break;
default:
throw (new Error([cljs.core.str("Invalid arity: "),cljs.core.str(args28265.length)].join('')));

}
});

sablono.core.date_field28264.cljs$core$IFn$_invoke$arity$1 = (function (name__28021__auto__){
return sablono.core.date_field28264.call(null,name__28021__auto__,null);
});

sablono.core.date_field28264.cljs$core$IFn$_invoke$arity$2 = (function (name__28021__auto__,value__28022__auto__){
return sablono.core.input_field_STAR_.call(null,[cljs.core.str(new cljs.core.Symbol(null,"date","date",177097065,null))].join(''),name__28021__auto__,value__28022__auto__);
});

sablono.core.date_field28264.cljs$lang$maxFixedArity = 2;

sablono.core.date_field = sablono.core.wrap_attrs.call(null,sablono.core.date_field28264);

/**
 * Creates a datetime input field.
 */
sablono.core.datetime_field28268 = (function sablono$core$datetime_field28268(var_args){
var args28269 = [];
var len__25999__auto___28336 = arguments.length;
var i__26000__auto___28337 = (0);
while(true){
if((i__26000__auto___28337 < len__25999__auto___28336)){
args28269.push((arguments[i__26000__auto___28337]));

var G__28338 = (i__26000__auto___28337 + (1));
i__26000__auto___28337 = G__28338;
continue;
} else {
}
break;
}

var G__28271 = args28269.length;
switch (G__28271) {
case 1:
return sablono.core.datetime_field28268.cljs$core$IFn$_invoke$arity$1((arguments[(0)]));

break;
case 2:
return sablono.core.datetime_field28268.cljs$core$IFn$_invoke$arity$2((arguments[(0)]),(arguments[(1)]));

break;
default:
throw (new Error([cljs.core.str("Invalid arity: "),cljs.core.str(args28269.length)].join('')));

}
});

sablono.core.datetime_field28268.cljs$core$IFn$_invoke$arity$1 = (function (name__28021__auto__){
return sablono.core.datetime_field28268.call(null,name__28021__auto__,null);
});

sablono.core.datetime_field28268.cljs$core$IFn$_invoke$arity$2 = (function (name__28021__auto__,value__28022__auto__){
return sablono.core.input_field_STAR_.call(null,[cljs.core.str(new cljs.core.Symbol(null,"datetime","datetime",2135207229,null))].join(''),name__28021__auto__,value__28022__auto__);
});

sablono.core.datetime_field28268.cljs$lang$maxFixedArity = 2;

sablono.core.datetime_field = sablono.core.wrap_attrs.call(null,sablono.core.datetime_field28268);

/**
 * Creates a datetime-local input field.
 */
sablono.core.datetime_local_field28272 = (function sablono$core$datetime_local_field28272(var_args){
var args28273 = [];
var len__25999__auto___28340 = arguments.length;
var i__26000__auto___28341 = (0);
while(true){
if((i__26000__auto___28341 < len__25999__auto___28340)){
args28273.push((arguments[i__26000__auto___28341]));

var G__28342 = (i__26000__auto___28341 + (1));
i__26000__auto___28341 = G__28342;
continue;
} else {
}
break;
}

var G__28275 = args28273.length;
switch (G__28275) {
case 1:
return sablono.core.datetime_local_field28272.cljs$core$IFn$_invoke$arity$1((arguments[(0)]));

break;
case 2:
return sablono.core.datetime_local_field28272.cljs$core$IFn$_invoke$arity$2((arguments[(0)]),(arguments[(1)]));

break;
default:
throw (new Error([cljs.core.str("Invalid arity: "),cljs.core.str(args28273.length)].join('')));

}
});

sablono.core.datetime_local_field28272.cljs$core$IFn$_invoke$arity$1 = (function (name__28021__auto__){
return sablono.core.datetime_local_field28272.call(null,name__28021__auto__,null);
});

sablono.core.datetime_local_field28272.cljs$core$IFn$_invoke$arity$2 = (function (name__28021__auto__,value__28022__auto__){
return sablono.core.input_field_STAR_.call(null,[cljs.core.str(new cljs.core.Symbol(null,"datetime-local","datetime-local",-507312697,null))].join(''),name__28021__auto__,value__28022__auto__);
});

sablono.core.datetime_local_field28272.cljs$lang$maxFixedArity = 2;

sablono.core.datetime_local_field = sablono.core.wrap_attrs.call(null,sablono.core.datetime_local_field28272);

/**
 * Creates a email input field.
 */
sablono.core.email_field28276 = (function sablono$core$email_field28276(var_args){
var args28277 = [];
var len__25999__auto___28344 = arguments.length;
var i__26000__auto___28345 = (0);
while(true){
if((i__26000__auto___28345 < len__25999__auto___28344)){
args28277.push((arguments[i__26000__auto___28345]));

var G__28346 = (i__26000__auto___28345 + (1));
i__26000__auto___28345 = G__28346;
continue;
} else {
}
break;
}

var G__28279 = args28277.length;
switch (G__28279) {
case 1:
return sablono.core.email_field28276.cljs$core$IFn$_invoke$arity$1((arguments[(0)]));

break;
case 2:
return sablono.core.email_field28276.cljs$core$IFn$_invoke$arity$2((arguments[(0)]),(arguments[(1)]));

break;
default:
throw (new Error([cljs.core.str("Invalid arity: "),cljs.core.str(args28277.length)].join('')));

}
});

sablono.core.email_field28276.cljs$core$IFn$_invoke$arity$1 = (function (name__28021__auto__){
return sablono.core.email_field28276.call(null,name__28021__auto__,null);
});

sablono.core.email_field28276.cljs$core$IFn$_invoke$arity$2 = (function (name__28021__auto__,value__28022__auto__){
return sablono.core.input_field_STAR_.call(null,[cljs.core.str(new cljs.core.Symbol(null,"email","email",-1238619063,null))].join(''),name__28021__auto__,value__28022__auto__);
});

sablono.core.email_field28276.cljs$lang$maxFixedArity = 2;

sablono.core.email_field = sablono.core.wrap_attrs.call(null,sablono.core.email_field28276);

/**
 * Creates a file input field.
 */
sablono.core.file_field28280 = (function sablono$core$file_field28280(var_args){
var args28281 = [];
var len__25999__auto___28348 = arguments.length;
var i__26000__auto___28349 = (0);
while(true){
if((i__26000__auto___28349 < len__25999__auto___28348)){
args28281.push((arguments[i__26000__auto___28349]));

var G__28350 = (i__26000__auto___28349 + (1));
i__26000__auto___28349 = G__28350;
continue;
} else {
}
break;
}

var G__28283 = args28281.length;
switch (G__28283) {
case 1:
return sablono.core.file_field28280.cljs$core$IFn$_invoke$arity$1((arguments[(0)]));

break;
case 2:
return sablono.core.file_field28280.cljs$core$IFn$_invoke$arity$2((arguments[(0)]),(arguments[(1)]));

break;
default:
throw (new Error([cljs.core.str("Invalid arity: "),cljs.core.str(args28281.length)].join('')));

}
});

sablono.core.file_field28280.cljs$core$IFn$_invoke$arity$1 = (function (name__28021__auto__){
return sablono.core.file_field28280.call(null,name__28021__auto__,null);
});

sablono.core.file_field28280.cljs$core$IFn$_invoke$arity$2 = (function (name__28021__auto__,value__28022__auto__){
return sablono.core.input_field_STAR_.call(null,[cljs.core.str(new cljs.core.Symbol(null,"file","file",370885649,null))].join(''),name__28021__auto__,value__28022__auto__);
});

sablono.core.file_field28280.cljs$lang$maxFixedArity = 2;

sablono.core.file_field = sablono.core.wrap_attrs.call(null,sablono.core.file_field28280);

/**
 * Creates a hidden input field.
 */
sablono.core.hidden_field28284 = (function sablono$core$hidden_field28284(var_args){
var args28285 = [];
var len__25999__auto___28352 = arguments.length;
var i__26000__auto___28353 = (0);
while(true){
if((i__26000__auto___28353 < len__25999__auto___28352)){
args28285.push((arguments[i__26000__auto___28353]));

var G__28354 = (i__26000__auto___28353 + (1));
i__26000__auto___28353 = G__28354;
continue;
} else {
}
break;
}

var G__28287 = args28285.length;
switch (G__28287) {
case 1:
return sablono.core.hidden_field28284.cljs$core$IFn$_invoke$arity$1((arguments[(0)]));

break;
case 2:
return sablono.core.hidden_field28284.cljs$core$IFn$_invoke$arity$2((arguments[(0)]),(arguments[(1)]));

break;
default:
throw (new Error([cljs.core.str("Invalid arity: "),cljs.core.str(args28285.length)].join('')));

}
});

sablono.core.hidden_field28284.cljs$core$IFn$_invoke$arity$1 = (function (name__28021__auto__){
return sablono.core.hidden_field28284.call(null,name__28021__auto__,null);
});

sablono.core.hidden_field28284.cljs$core$IFn$_invoke$arity$2 = (function (name__28021__auto__,value__28022__auto__){
return sablono.core.input_field_STAR_.call(null,[cljs.core.str(new cljs.core.Symbol(null,"hidden","hidden",1328025435,null))].join(''),name__28021__auto__,value__28022__auto__);
});

sablono.core.hidden_field28284.cljs$lang$maxFixedArity = 2;

sablono.core.hidden_field = sablono.core.wrap_attrs.call(null,sablono.core.hidden_field28284);

/**
 * Creates a month input field.
 */
sablono.core.month_field28288 = (function sablono$core$month_field28288(var_args){
var args28289 = [];
var len__25999__auto___28356 = arguments.length;
var i__26000__auto___28357 = (0);
while(true){
if((i__26000__auto___28357 < len__25999__auto___28356)){
args28289.push((arguments[i__26000__auto___28357]));

var G__28358 = (i__26000__auto___28357 + (1));
i__26000__auto___28357 = G__28358;
continue;
} else {
}
break;
}

var G__28291 = args28289.length;
switch (G__28291) {
case 1:
return sablono.core.month_field28288.cljs$core$IFn$_invoke$arity$1((arguments[(0)]));

break;
case 2:
return sablono.core.month_field28288.cljs$core$IFn$_invoke$arity$2((arguments[(0)]),(arguments[(1)]));

break;
default:
throw (new Error([cljs.core.str("Invalid arity: "),cljs.core.str(args28289.length)].join('')));

}
});

sablono.core.month_field28288.cljs$core$IFn$_invoke$arity$1 = (function (name__28021__auto__){
return sablono.core.month_field28288.call(null,name__28021__auto__,null);
});

sablono.core.month_field28288.cljs$core$IFn$_invoke$arity$2 = (function (name__28021__auto__,value__28022__auto__){
return sablono.core.input_field_STAR_.call(null,[cljs.core.str(new cljs.core.Symbol(null,"month","month",-319717006,null))].join(''),name__28021__auto__,value__28022__auto__);
});

sablono.core.month_field28288.cljs$lang$maxFixedArity = 2;

sablono.core.month_field = sablono.core.wrap_attrs.call(null,sablono.core.month_field28288);

/**
 * Creates a number input field.
 */
sablono.core.number_field28292 = (function sablono$core$number_field28292(var_args){
var args28293 = [];
var len__25999__auto___28360 = arguments.length;
var i__26000__auto___28361 = (0);
while(true){
if((i__26000__auto___28361 < len__25999__auto___28360)){
args28293.push((arguments[i__26000__auto___28361]));

var G__28362 = (i__26000__auto___28361 + (1));
i__26000__auto___28361 = G__28362;
continue;
} else {
}
break;
}

var G__28295 = args28293.length;
switch (G__28295) {
case 1:
return sablono.core.number_field28292.cljs$core$IFn$_invoke$arity$1((arguments[(0)]));

break;
case 2:
return sablono.core.number_field28292.cljs$core$IFn$_invoke$arity$2((arguments[(0)]),(arguments[(1)]));

break;
default:
throw (new Error([cljs.core.str("Invalid arity: "),cljs.core.str(args28293.length)].join('')));

}
});

sablono.core.number_field28292.cljs$core$IFn$_invoke$arity$1 = (function (name__28021__auto__){
return sablono.core.number_field28292.call(null,name__28021__auto__,null);
});

sablono.core.number_field28292.cljs$core$IFn$_invoke$arity$2 = (function (name__28021__auto__,value__28022__auto__){
return sablono.core.input_field_STAR_.call(null,[cljs.core.str(new cljs.core.Symbol(null,"number","number",-1084057331,null))].join(''),name__28021__auto__,value__28022__auto__);
});

sablono.core.number_field28292.cljs$lang$maxFixedArity = 2;

sablono.core.number_field = sablono.core.wrap_attrs.call(null,sablono.core.number_field28292);

/**
 * Creates a password input field.
 */
sablono.core.password_field28296 = (function sablono$core$password_field28296(var_args){
var args28297 = [];
var len__25999__auto___28364 = arguments.length;
var i__26000__auto___28365 = (0);
while(true){
if((i__26000__auto___28365 < len__25999__auto___28364)){
args28297.push((arguments[i__26000__auto___28365]));

var G__28366 = (i__26000__auto___28365 + (1));
i__26000__auto___28365 = G__28366;
continue;
} else {
}
break;
}

var G__28299 = args28297.length;
switch (G__28299) {
case 1:
return sablono.core.password_field28296.cljs$core$IFn$_invoke$arity$1((arguments[(0)]));

break;
case 2:
return sablono.core.password_field28296.cljs$core$IFn$_invoke$arity$2((arguments[(0)]),(arguments[(1)]));

break;
default:
throw (new Error([cljs.core.str("Invalid arity: "),cljs.core.str(args28297.length)].join('')));

}
});

sablono.core.password_field28296.cljs$core$IFn$_invoke$arity$1 = (function (name__28021__auto__){
return sablono.core.password_field28296.call(null,name__28021__auto__,null);
});

sablono.core.password_field28296.cljs$core$IFn$_invoke$arity$2 = (function (name__28021__auto__,value__28022__auto__){
return sablono.core.input_field_STAR_.call(null,[cljs.core.str(new cljs.core.Symbol(null,"password","password",2057553998,null))].join(''),name__28021__auto__,value__28022__auto__);
});

sablono.core.password_field28296.cljs$lang$maxFixedArity = 2;

sablono.core.password_field = sablono.core.wrap_attrs.call(null,sablono.core.password_field28296);

/**
 * Creates a range input field.
 */
sablono.core.range_field28300 = (function sablono$core$range_field28300(var_args){
var args28301 = [];
var len__25999__auto___28368 = arguments.length;
var i__26000__auto___28369 = (0);
while(true){
if((i__26000__auto___28369 < len__25999__auto___28368)){
args28301.push((arguments[i__26000__auto___28369]));

var G__28370 = (i__26000__auto___28369 + (1));
i__26000__auto___28369 = G__28370;
continue;
} else {
}
break;
}

var G__28303 = args28301.length;
switch (G__28303) {
case 1:
return sablono.core.range_field28300.cljs$core$IFn$_invoke$arity$1((arguments[(0)]));

break;
case 2:
return sablono.core.range_field28300.cljs$core$IFn$_invoke$arity$2((arguments[(0)]),(arguments[(1)]));

break;
default:
throw (new Error([cljs.core.str("Invalid arity: "),cljs.core.str(args28301.length)].join('')));

}
});

sablono.core.range_field28300.cljs$core$IFn$_invoke$arity$1 = (function (name__28021__auto__){
return sablono.core.range_field28300.call(null,name__28021__auto__,null);
});

sablono.core.range_field28300.cljs$core$IFn$_invoke$arity$2 = (function (name__28021__auto__,value__28022__auto__){
return sablono.core.input_field_STAR_.call(null,[cljs.core.str(new cljs.core.Symbol(null,"range","range",-1014743483,null))].join(''),name__28021__auto__,value__28022__auto__);
});

sablono.core.range_field28300.cljs$lang$maxFixedArity = 2;

sablono.core.range_field = sablono.core.wrap_attrs.call(null,sablono.core.range_field28300);

/**
 * Creates a search input field.
 */
sablono.core.search_field28304 = (function sablono$core$search_field28304(var_args){
var args28305 = [];
var len__25999__auto___28372 = arguments.length;
var i__26000__auto___28373 = (0);
while(true){
if((i__26000__auto___28373 < len__25999__auto___28372)){
args28305.push((arguments[i__26000__auto___28373]));

var G__28374 = (i__26000__auto___28373 + (1));
i__26000__auto___28373 = G__28374;
continue;
} else {
}
break;
}

var G__28307 = args28305.length;
switch (G__28307) {
case 1:
return sablono.core.search_field28304.cljs$core$IFn$_invoke$arity$1((arguments[(0)]));

break;
case 2:
return sablono.core.search_field28304.cljs$core$IFn$_invoke$arity$2((arguments[(0)]),(arguments[(1)]));

break;
default:
throw (new Error([cljs.core.str("Invalid arity: "),cljs.core.str(args28305.length)].join('')));

}
});

sablono.core.search_field28304.cljs$core$IFn$_invoke$arity$1 = (function (name__28021__auto__){
return sablono.core.search_field28304.call(null,name__28021__auto__,null);
});

sablono.core.search_field28304.cljs$core$IFn$_invoke$arity$2 = (function (name__28021__auto__,value__28022__auto__){
return sablono.core.input_field_STAR_.call(null,[cljs.core.str(new cljs.core.Symbol(null,"search","search",-1089495947,null))].join(''),name__28021__auto__,value__28022__auto__);
});

sablono.core.search_field28304.cljs$lang$maxFixedArity = 2;

sablono.core.search_field = sablono.core.wrap_attrs.call(null,sablono.core.search_field28304);

/**
 * Creates a tel input field.
 */
sablono.core.tel_field28308 = (function sablono$core$tel_field28308(var_args){
var args28309 = [];
var len__25999__auto___28376 = arguments.length;
var i__26000__auto___28377 = (0);
while(true){
if((i__26000__auto___28377 < len__25999__auto___28376)){
args28309.push((arguments[i__26000__auto___28377]));

var G__28378 = (i__26000__auto___28377 + (1));
i__26000__auto___28377 = G__28378;
continue;
} else {
}
break;
}

var G__28311 = args28309.length;
switch (G__28311) {
case 1:
return sablono.core.tel_field28308.cljs$core$IFn$_invoke$arity$1((arguments[(0)]));

break;
case 2:
return sablono.core.tel_field28308.cljs$core$IFn$_invoke$arity$2((arguments[(0)]),(arguments[(1)]));

break;
default:
throw (new Error([cljs.core.str("Invalid arity: "),cljs.core.str(args28309.length)].join('')));

}
});

sablono.core.tel_field28308.cljs$core$IFn$_invoke$arity$1 = (function (name__28021__auto__){
return sablono.core.tel_field28308.call(null,name__28021__auto__,null);
});

sablono.core.tel_field28308.cljs$core$IFn$_invoke$arity$2 = (function (name__28021__auto__,value__28022__auto__){
return sablono.core.input_field_STAR_.call(null,[cljs.core.str(new cljs.core.Symbol(null,"tel","tel",1864669686,null))].join(''),name__28021__auto__,value__28022__auto__);
});

sablono.core.tel_field28308.cljs$lang$maxFixedArity = 2;

sablono.core.tel_field = sablono.core.wrap_attrs.call(null,sablono.core.tel_field28308);

/**
 * Creates a text input field.
 */
sablono.core.text_field28312 = (function sablono$core$text_field28312(var_args){
var args28313 = [];
var len__25999__auto___28380 = arguments.length;
var i__26000__auto___28381 = (0);
while(true){
if((i__26000__auto___28381 < len__25999__auto___28380)){
args28313.push((arguments[i__26000__auto___28381]));

var G__28382 = (i__26000__auto___28381 + (1));
i__26000__auto___28381 = G__28382;
continue;
} else {
}
break;
}

var G__28315 = args28313.length;
switch (G__28315) {
case 1:
return sablono.core.text_field28312.cljs$core$IFn$_invoke$arity$1((arguments[(0)]));

break;
case 2:
return sablono.core.text_field28312.cljs$core$IFn$_invoke$arity$2((arguments[(0)]),(arguments[(1)]));

break;
default:
throw (new Error([cljs.core.str("Invalid arity: "),cljs.core.str(args28313.length)].join('')));

}
});

sablono.core.text_field28312.cljs$core$IFn$_invoke$arity$1 = (function (name__28021__auto__){
return sablono.core.text_field28312.call(null,name__28021__auto__,null);
});

sablono.core.text_field28312.cljs$core$IFn$_invoke$arity$2 = (function (name__28021__auto__,value__28022__auto__){
return sablono.core.input_field_STAR_.call(null,[cljs.core.str(new cljs.core.Symbol(null,"text","text",-150030170,null))].join(''),name__28021__auto__,value__28022__auto__);
});

sablono.core.text_field28312.cljs$lang$maxFixedArity = 2;

sablono.core.text_field = sablono.core.wrap_attrs.call(null,sablono.core.text_field28312);

/**
 * Creates a time input field.
 */
sablono.core.time_field28316 = (function sablono$core$time_field28316(var_args){
var args28317 = [];
var len__25999__auto___28384 = arguments.length;
var i__26000__auto___28385 = (0);
while(true){
if((i__26000__auto___28385 < len__25999__auto___28384)){
args28317.push((arguments[i__26000__auto___28385]));

var G__28386 = (i__26000__auto___28385 + (1));
i__26000__auto___28385 = G__28386;
continue;
} else {
}
break;
}

var G__28319 = args28317.length;
switch (G__28319) {
case 1:
return sablono.core.time_field28316.cljs$core$IFn$_invoke$arity$1((arguments[(0)]));

break;
case 2:
return sablono.core.time_field28316.cljs$core$IFn$_invoke$arity$2((arguments[(0)]),(arguments[(1)]));

break;
default:
throw (new Error([cljs.core.str("Invalid arity: "),cljs.core.str(args28317.length)].join('')));

}
});

sablono.core.time_field28316.cljs$core$IFn$_invoke$arity$1 = (function (name__28021__auto__){
return sablono.core.time_field28316.call(null,name__28021__auto__,null);
});

sablono.core.time_field28316.cljs$core$IFn$_invoke$arity$2 = (function (name__28021__auto__,value__28022__auto__){
return sablono.core.input_field_STAR_.call(null,[cljs.core.str(new cljs.core.Symbol(null,"time","time",-1268547887,null))].join(''),name__28021__auto__,value__28022__auto__);
});

sablono.core.time_field28316.cljs$lang$maxFixedArity = 2;

sablono.core.time_field = sablono.core.wrap_attrs.call(null,sablono.core.time_field28316);

/**
 * Creates a url input field.
 */
sablono.core.url_field28320 = (function sablono$core$url_field28320(var_args){
var args28321 = [];
var len__25999__auto___28388 = arguments.length;
var i__26000__auto___28389 = (0);
while(true){
if((i__26000__auto___28389 < len__25999__auto___28388)){
args28321.push((arguments[i__26000__auto___28389]));

var G__28390 = (i__26000__auto___28389 + (1));
i__26000__auto___28389 = G__28390;
continue;
} else {
}
break;
}

var G__28323 = args28321.length;
switch (G__28323) {
case 1:
return sablono.core.url_field28320.cljs$core$IFn$_invoke$arity$1((arguments[(0)]));

break;
case 2:
return sablono.core.url_field28320.cljs$core$IFn$_invoke$arity$2((arguments[(0)]),(arguments[(1)]));

break;
default:
throw (new Error([cljs.core.str("Invalid arity: "),cljs.core.str(args28321.length)].join('')));

}
});

sablono.core.url_field28320.cljs$core$IFn$_invoke$arity$1 = (function (name__28021__auto__){
return sablono.core.url_field28320.call(null,name__28021__auto__,null);
});

sablono.core.url_field28320.cljs$core$IFn$_invoke$arity$2 = (function (name__28021__auto__,value__28022__auto__){
return sablono.core.input_field_STAR_.call(null,[cljs.core.str(new cljs.core.Symbol(null,"url","url",1916828573,null))].join(''),name__28021__auto__,value__28022__auto__);
});

sablono.core.url_field28320.cljs$lang$maxFixedArity = 2;

sablono.core.url_field = sablono.core.wrap_attrs.call(null,sablono.core.url_field28320);

/**
 * Creates a week input field.
 */
sablono.core.week_field28324 = (function sablono$core$week_field28324(var_args){
var args28325 = [];
var len__25999__auto___28392 = arguments.length;
var i__26000__auto___28393 = (0);
while(true){
if((i__26000__auto___28393 < len__25999__auto___28392)){
args28325.push((arguments[i__26000__auto___28393]));

var G__28394 = (i__26000__auto___28393 + (1));
i__26000__auto___28393 = G__28394;
continue;
} else {
}
break;
}

var G__28327 = args28325.length;
switch (G__28327) {
case 1:
return sablono.core.week_field28324.cljs$core$IFn$_invoke$arity$1((arguments[(0)]));

break;
case 2:
return sablono.core.week_field28324.cljs$core$IFn$_invoke$arity$2((arguments[(0)]),(arguments[(1)]));

break;
default:
throw (new Error([cljs.core.str("Invalid arity: "),cljs.core.str(args28325.length)].join('')));

}
});

sablono.core.week_field28324.cljs$core$IFn$_invoke$arity$1 = (function (name__28021__auto__){
return sablono.core.week_field28324.call(null,name__28021__auto__,null);
});

sablono.core.week_field28324.cljs$core$IFn$_invoke$arity$2 = (function (name__28021__auto__,value__28022__auto__){
return sablono.core.input_field_STAR_.call(null,[cljs.core.str(new cljs.core.Symbol(null,"week","week",314058249,null))].join(''),name__28021__auto__,value__28022__auto__);
});

sablono.core.week_field28324.cljs$lang$maxFixedArity = 2;

sablono.core.week_field = sablono.core.wrap_attrs.call(null,sablono.core.week_field28324);
sablono.core.file_upload = sablono.core.file_field;
/**
 * Creates a check box.
 */
sablono.core.check_box28396 = (function sablono$core$check_box28396(var_args){
var args28397 = [];
var len__25999__auto___28400 = arguments.length;
var i__26000__auto___28401 = (0);
while(true){
if((i__26000__auto___28401 < len__25999__auto___28400)){
args28397.push((arguments[i__26000__auto___28401]));

var G__28402 = (i__26000__auto___28401 + (1));
i__26000__auto___28401 = G__28402;
continue;
} else {
}
break;
}

var G__28399 = args28397.length;
switch (G__28399) {
case 1:
return sablono.core.check_box28396.cljs$core$IFn$_invoke$arity$1((arguments[(0)]));

break;
case 2:
return sablono.core.check_box28396.cljs$core$IFn$_invoke$arity$2((arguments[(0)]),(arguments[(1)]));

break;
case 3:
return sablono.core.check_box28396.cljs$core$IFn$_invoke$arity$3((arguments[(0)]),(arguments[(1)]),(arguments[(2)]));

break;
default:
throw (new Error([cljs.core.str("Invalid arity: "),cljs.core.str(args28397.length)].join('')));

}
});

sablono.core.check_box28396.cljs$core$IFn$_invoke$arity$1 = (function (name){
return sablono.core.check_box28396.call(null,name,null);
});

sablono.core.check_box28396.cljs$core$IFn$_invoke$arity$2 = (function (name,checked_QMARK_){
return sablono.core.check_box28396.call(null,name,checked_QMARK_,"true");
});

sablono.core.check_box28396.cljs$core$IFn$_invoke$arity$3 = (function (name,checked_QMARK_,value){
return new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Keyword(null,"input","input",556931961),new cljs.core.PersistentArrayMap(null, 5, [new cljs.core.Keyword(null,"type","type",1174270348),"checkbox",new cljs.core.Keyword(null,"name","name",1843675177),sablono.core.make_name.call(null,name),new cljs.core.Keyword(null,"id","id",-1388402092),sablono.core.make_id.call(null,name),new cljs.core.Keyword(null,"value","value",305978217),value,new cljs.core.Keyword(null,"checked","checked",-50955819),checked_QMARK_], null)], null);
});

sablono.core.check_box28396.cljs$lang$maxFixedArity = 3;

sablono.core.check_box = sablono.core.wrap_attrs.call(null,sablono.core.check_box28396);
/**
 * Creates a radio button.
 */
sablono.core.radio_button28404 = (function sablono$core$radio_button28404(var_args){
var args28405 = [];
var len__25999__auto___28408 = arguments.length;
var i__26000__auto___28409 = (0);
while(true){
if((i__26000__auto___28409 < len__25999__auto___28408)){
args28405.push((arguments[i__26000__auto___28409]));

var G__28410 = (i__26000__auto___28409 + (1));
i__26000__auto___28409 = G__28410;
continue;
} else {
}
break;
}

var G__28407 = args28405.length;
switch (G__28407) {
case 1:
return sablono.core.radio_button28404.cljs$core$IFn$_invoke$arity$1((arguments[(0)]));

break;
case 2:
return sablono.core.radio_button28404.cljs$core$IFn$_invoke$arity$2((arguments[(0)]),(arguments[(1)]));

break;
case 3:
return sablono.core.radio_button28404.cljs$core$IFn$_invoke$arity$3((arguments[(0)]),(arguments[(1)]),(arguments[(2)]));

break;
default:
throw (new Error([cljs.core.str("Invalid arity: "),cljs.core.str(args28405.length)].join('')));

}
});

sablono.core.radio_button28404.cljs$core$IFn$_invoke$arity$1 = (function (group){
return sablono.core.radio_button28404.call(null,group,null);
});

sablono.core.radio_button28404.cljs$core$IFn$_invoke$arity$2 = (function (group,checked_QMARK_){
return sablono.core.radio_button28404.call(null,group,checked_QMARK_,"true");
});

sablono.core.radio_button28404.cljs$core$IFn$_invoke$arity$3 = (function (group,checked_QMARK_,value){
return new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Keyword(null,"input","input",556931961),new cljs.core.PersistentArrayMap(null, 5, [new cljs.core.Keyword(null,"type","type",1174270348),"radio",new cljs.core.Keyword(null,"name","name",1843675177),sablono.core.make_name.call(null,group),new cljs.core.Keyword(null,"id","id",-1388402092),sablono.core.make_id.call(null,[cljs.core.str(sablono.util.as_str.call(null,group)),cljs.core.str("-"),cljs.core.str(sablono.util.as_str.call(null,value))].join('')),new cljs.core.Keyword(null,"value","value",305978217),value,new cljs.core.Keyword(null,"checked","checked",-50955819),checked_QMARK_], null)], null);
});

sablono.core.radio_button28404.cljs$lang$maxFixedArity = 3;

sablono.core.radio_button = sablono.core.wrap_attrs.call(null,sablono.core.radio_button28404);
sablono.core.hash_key = (function sablono$core$hash_key(x){
return goog.string.hashCode(cljs.core.pr_str.call(null,x));
});
/**
 * Creates a seq of option tags from a collection.
 */
sablono.core.select_options28412 = (function sablono$core$select_options28412(coll){
var iter__25713__auto__ = (function sablono$core$select_options28412_$_iter__28421(s__28422){
return (new cljs.core.LazySeq(null,(function (){
var s__28422__$1 = s__28422;
while(true){
var temp__4425__auto__ = cljs.core.seq.call(null,s__28422__$1);
if(temp__4425__auto__){
var s__28422__$2 = temp__4425__auto__;
if(cljs.core.chunked_seq_QMARK_.call(null,s__28422__$2)){
var c__25711__auto__ = cljs.core.chunk_first.call(null,s__28422__$2);
var size__25712__auto__ = cljs.core.count.call(null,c__25711__auto__);
var b__28424 = cljs.core.chunk_buffer.call(null,size__25712__auto__);
if((function (){var i__28423 = (0);
while(true){
if((i__28423 < size__25712__auto__)){
var x = cljs.core._nth.call(null,c__25711__auto__,i__28423);
cljs.core.chunk_append.call(null,b__28424,((cljs.core.sequential_QMARK_.call(null,x))?(function (){var vec__28427 = x;
var text = cljs.core.nth.call(null,vec__28427,(0),null);
var val = cljs.core.nth.call(null,vec__28427,(1),null);
var disabled_QMARK_ = cljs.core.nth.call(null,vec__28427,(2),null);
var disabled_QMARK___$1 = cljs.core.boolean$.call(null,disabled_QMARK_);
if(cljs.core.sequential_QMARK_.call(null,val)){
return new cljs.core.PersistentVector(null, 3, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Keyword(null,"optgroup","optgroup",1738282218),new cljs.core.PersistentArrayMap(null, 2, [new cljs.core.Keyword(null,"key","key",-1516042587),sablono.core.hash_key.call(null,text),new cljs.core.Keyword(null,"label","label",1718410804),text], null),sablono$core$select_options28412.call(null,val)], null);
} else {
return new cljs.core.PersistentVector(null, 3, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Keyword(null,"option","option",65132272),new cljs.core.PersistentArrayMap(null, 3, [new cljs.core.Keyword(null,"disabled","disabled",-1529784218),disabled_QMARK___$1,new cljs.core.Keyword(null,"key","key",-1516042587),sablono.core.hash_key.call(null,val),new cljs.core.Keyword(null,"value","value",305978217),val], null),text], null);
}
})():new cljs.core.PersistentVector(null, 3, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Keyword(null,"option","option",65132272),new cljs.core.PersistentArrayMap(null, 2, [new cljs.core.Keyword(null,"key","key",-1516042587),sablono.core.hash_key.call(null,x),new cljs.core.Keyword(null,"value","value",305978217),x], null),x], null)));

var G__28429 = (i__28423 + (1));
i__28423 = G__28429;
continue;
} else {
return true;
}
break;
}
})()){
return cljs.core.chunk_cons.call(null,cljs.core.chunk.call(null,b__28424),sablono$core$select_options28412_$_iter__28421.call(null,cljs.core.chunk_rest.call(null,s__28422__$2)));
} else {
return cljs.core.chunk_cons.call(null,cljs.core.chunk.call(null,b__28424),null);
}
} else {
var x = cljs.core.first.call(null,s__28422__$2);
return cljs.core.cons.call(null,((cljs.core.sequential_QMARK_.call(null,x))?(function (){var vec__28428 = x;
var text = cljs.core.nth.call(null,vec__28428,(0),null);
var val = cljs.core.nth.call(null,vec__28428,(1),null);
var disabled_QMARK_ = cljs.core.nth.call(null,vec__28428,(2),null);
var disabled_QMARK___$1 = cljs.core.boolean$.call(null,disabled_QMARK_);
if(cljs.core.sequential_QMARK_.call(null,val)){
return new cljs.core.PersistentVector(null, 3, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Keyword(null,"optgroup","optgroup",1738282218),new cljs.core.PersistentArrayMap(null, 2, [new cljs.core.Keyword(null,"key","key",-1516042587),sablono.core.hash_key.call(null,text),new cljs.core.Keyword(null,"label","label",1718410804),text], null),sablono$core$select_options28412.call(null,val)], null);
} else {
return new cljs.core.PersistentVector(null, 3, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Keyword(null,"option","option",65132272),new cljs.core.PersistentArrayMap(null, 3, [new cljs.core.Keyword(null,"disabled","disabled",-1529784218),disabled_QMARK___$1,new cljs.core.Keyword(null,"key","key",-1516042587),sablono.core.hash_key.call(null,val),new cljs.core.Keyword(null,"value","value",305978217),val], null),text], null);
}
})():new cljs.core.PersistentVector(null, 3, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Keyword(null,"option","option",65132272),new cljs.core.PersistentArrayMap(null, 2, [new cljs.core.Keyword(null,"key","key",-1516042587),sablono.core.hash_key.call(null,x),new cljs.core.Keyword(null,"value","value",305978217),x], null),x], null)),sablono$core$select_options28412_$_iter__28421.call(null,cljs.core.rest.call(null,s__28422__$2)));
}
} else {
return null;
}
break;
}
}),null,null));
});
return iter__25713__auto__.call(null,coll);
});

sablono.core.select_options = sablono.core.wrap_attrs.call(null,sablono.core.select_options28412);
/**
 * Creates a drop-down box using the <select> tag.
 */
sablono.core.drop_down28430 = (function sablono$core$drop_down28430(var_args){
var args28431 = [];
var len__25999__auto___28434 = arguments.length;
var i__26000__auto___28435 = (0);
while(true){
if((i__26000__auto___28435 < len__25999__auto___28434)){
args28431.push((arguments[i__26000__auto___28435]));

var G__28436 = (i__26000__auto___28435 + (1));
i__26000__auto___28435 = G__28436;
continue;
} else {
}
break;
}

var G__28433 = args28431.length;
switch (G__28433) {
case 2:
return sablono.core.drop_down28430.cljs$core$IFn$_invoke$arity$2((arguments[(0)]),(arguments[(1)]));

break;
case 3:
return sablono.core.drop_down28430.cljs$core$IFn$_invoke$arity$3((arguments[(0)]),(arguments[(1)]),(arguments[(2)]));

break;
default:
throw (new Error([cljs.core.str("Invalid arity: "),cljs.core.str(args28431.length)].join('')));

}
});

sablono.core.drop_down28430.cljs$core$IFn$_invoke$arity$2 = (function (name,options){
return sablono.core.drop_down28430.call(null,name,options,null);
});

sablono.core.drop_down28430.cljs$core$IFn$_invoke$arity$3 = (function (name,options,selected){
return new cljs.core.PersistentVector(null, 3, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Keyword(null,"select","select",1147833503),new cljs.core.PersistentArrayMap(null, 2, [new cljs.core.Keyword(null,"name","name",1843675177),sablono.core.make_name.call(null,name),new cljs.core.Keyword(null,"id","id",-1388402092),sablono.core.make_id.call(null,name)], null),sablono.core.select_options.call(null,options,selected)], null);
});

sablono.core.drop_down28430.cljs$lang$maxFixedArity = 3;

sablono.core.drop_down = sablono.core.wrap_attrs.call(null,sablono.core.drop_down28430);
/**
 * Creates a text area element.
 */
sablono.core.text_area28438 = (function sablono$core$text_area28438(var_args){
var args28439 = [];
var len__25999__auto___28442 = arguments.length;
var i__26000__auto___28443 = (0);
while(true){
if((i__26000__auto___28443 < len__25999__auto___28442)){
args28439.push((arguments[i__26000__auto___28443]));

var G__28444 = (i__26000__auto___28443 + (1));
i__26000__auto___28443 = G__28444;
continue;
} else {
}
break;
}

var G__28441 = args28439.length;
switch (G__28441) {
case 1:
return sablono.core.text_area28438.cljs$core$IFn$_invoke$arity$1((arguments[(0)]));

break;
case 2:
return sablono.core.text_area28438.cljs$core$IFn$_invoke$arity$2((arguments[(0)]),(arguments[(1)]));

break;
default:
throw (new Error([cljs.core.str("Invalid arity: "),cljs.core.str(args28439.length)].join('')));

}
});

sablono.core.text_area28438.cljs$core$IFn$_invoke$arity$1 = (function (name){
return sablono.core.text_area28438.call(null,name,null);
});

sablono.core.text_area28438.cljs$core$IFn$_invoke$arity$2 = (function (name,value){
return new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Keyword(null,"textarea","textarea",-650375824),new cljs.core.PersistentArrayMap(null, 3, [new cljs.core.Keyword(null,"name","name",1843675177),sablono.core.make_name.call(null,name),new cljs.core.Keyword(null,"id","id",-1388402092),sablono.core.make_id.call(null,name),new cljs.core.Keyword(null,"value","value",305978217),value], null)], null);
});

sablono.core.text_area28438.cljs$lang$maxFixedArity = 2;

sablono.core.text_area = sablono.core.wrap_attrs.call(null,sablono.core.text_area28438);
/**
 * Creates a label for an input field with the supplied name.
 */
sablono.core.label28446 = (function sablono$core$label28446(name,text){
return new cljs.core.PersistentVector(null, 3, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Keyword(null,"label","label",1718410804),new cljs.core.PersistentArrayMap(null, 1, [new cljs.core.Keyword(null,"htmlFor","htmlFor",-1050291720),sablono.core.make_id.call(null,name)], null),text], null);
});

sablono.core.label = sablono.core.wrap_attrs.call(null,sablono.core.label28446);
/**
 * Creates a submit button.
 */
sablono.core.submit_button28447 = (function sablono$core$submit_button28447(text){
return new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Keyword(null,"input","input",556931961),new cljs.core.PersistentArrayMap(null, 2, [new cljs.core.Keyword(null,"type","type",1174270348),"submit",new cljs.core.Keyword(null,"value","value",305978217),text], null)], null);
});

sablono.core.submit_button = sablono.core.wrap_attrs.call(null,sablono.core.submit_button28447);
/**
 * Creates a form reset button.
 */
sablono.core.reset_button28448 = (function sablono$core$reset_button28448(text){
return new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Keyword(null,"input","input",556931961),new cljs.core.PersistentArrayMap(null, 2, [new cljs.core.Keyword(null,"type","type",1174270348),"reset",new cljs.core.Keyword(null,"value","value",305978217),text], null)], null);
});

sablono.core.reset_button = sablono.core.wrap_attrs.call(null,sablono.core.reset_button28448);
/**
 * Create a form that points to a particular method and route.
 *   e.g. (form-to [:put "/post"]
 *       ...)
 */
sablono.core.form_to28449 = (function sablono$core$form_to28449(var_args){
var args__26006__auto__ = [];
var len__25999__auto___28454 = arguments.length;
var i__26000__auto___28455 = (0);
while(true){
if((i__26000__auto___28455 < len__25999__auto___28454)){
args__26006__auto__.push((arguments[i__26000__auto___28455]));

var G__28456 = (i__26000__auto___28455 + (1));
i__26000__auto___28455 = G__28456;
continue;
} else {
}
break;
}

var argseq__26007__auto__ = ((((1) < args__26006__auto__.length))?(new cljs.core.IndexedSeq(args__26006__auto__.slice((1)),(0))):null);
return sablono.core.form_to28449.cljs$core$IFn$_invoke$arity$variadic((arguments[(0)]),argseq__26007__auto__);
});

sablono.core.form_to28449.cljs$core$IFn$_invoke$arity$variadic = (function (p__28452,body){
var vec__28453 = p__28452;
var method = cljs.core.nth.call(null,vec__28453,(0),null);
var action = cljs.core.nth.call(null,vec__28453,(1),null);
var method_str = clojure.string.upper_case.call(null,cljs.core.name.call(null,method));
var action_uri = sablono.util.to_uri.call(null,action);
return cljs.core.vec.call(null,cljs.core.concat.call(null,((cljs.core.contains_QMARK_.call(null,new cljs.core.PersistentHashSet(null, new cljs.core.PersistentArrayMap(null, 2, [new cljs.core.Keyword(null,"get","get",1683182755),null,new cljs.core.Keyword(null,"post","post",269697687),null], null), null),method))?new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Keyword(null,"form","form",-1624062471),new cljs.core.PersistentArrayMap(null, 2, [new cljs.core.Keyword(null,"method","method",55703592),method_str,new cljs.core.Keyword(null,"action","action",-811238024),action_uri], null)], null):new cljs.core.PersistentVector(null, 3, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Keyword(null,"form","form",-1624062471),new cljs.core.PersistentArrayMap(null, 2, [new cljs.core.Keyword(null,"method","method",55703592),"POST",new cljs.core.Keyword(null,"action","action",-811238024),action_uri], null),sablono.core.hidden_field.call(null,new cljs.core.PersistentArrayMap(null, 1, [new cljs.core.Keyword(null,"key","key",-1516042587),(3735928559)], null),"_method",method_str)], null)),body));
});

sablono.core.form_to28449.cljs$lang$maxFixedArity = (1);

sablono.core.form_to28449.cljs$lang$applyTo = (function (seq28450){
var G__28451 = cljs.core.first.call(null,seq28450);
var seq28450__$1 = cljs.core.next.call(null,seq28450);
return sablono.core.form_to28449.cljs$core$IFn$_invoke$arity$variadic(G__28451,seq28450__$1);
});

sablono.core.form_to = sablono.core.wrap_attrs.call(null,sablono.core.form_to28449);

//# sourceMappingURL=core.js.map