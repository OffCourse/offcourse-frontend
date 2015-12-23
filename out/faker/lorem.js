// Compiled by ClojureScript 1.7.170 {}
goog.provide('faker.lorem');
goog.require('cljs.core');
goog.require('clojure.string');
goog.require('faker.lorem_data');
/**
 * Lazy sequence of random latin words
 */
faker.lorem.words = (function faker$lorem$words(){
return cljs.core.repeatedly.call(null,(function (){
return cljs.core.rand_nth.call(null,faker.lorem_data.latin_words);
}));
});
/**
 * Lazy sequence of random latin sentences.
 * 
 *   (sentences 5) will generate a sequence of random sentences between
 *   5 and 5 + 5 words.
 *   (sentences) will generate random sentences between 4 and 4 + 5 words.
 */
faker.lorem.sentences = (function faker$lorem$sentences(var_args){
var args28807 = [];
var len__26059__auto___28810 = arguments.length;
var i__26060__auto___28811 = (0);
while(true){
if((i__26060__auto___28811 < len__26059__auto___28810)){
args28807.push((arguments[i__26060__auto___28811]));

var G__28812 = (i__26060__auto___28811 + (1));
i__26060__auto___28811 = G__28812;
continue;
} else {
}
break;
}

var G__28809 = args28807.length;
switch (G__28809) {
case 0:
return faker.lorem.sentences.cljs$core$IFn$_invoke$arity$0();

break;
case 1:
return faker.lorem.sentences.cljs$core$IFn$_invoke$arity$1((arguments[(0)]));

break;
default:
throw (new Error([cljs.core.str("Invalid arity: "),cljs.core.str(args28807.length)].join('')));

}
});

faker.lorem.sentences.cljs$core$IFn$_invoke$arity$0 = (function (){
return faker.lorem.sentences.call(null,(4));
});

faker.lorem.sentences.cljs$core$IFn$_invoke$arity$1 = (function (word_count){
return cljs.core.map.call(null,(function (n){
return [cljs.core.str(clojure.string.capitalize.call(null,clojure.string.join.call(null," ",cljs.core.take.call(null,n,faker.lorem.words.call(null))))),cljs.core.str(".")].join('');
}),cljs.core.repeatedly.call(null,(function (){
return (word_count + cljs.core.rand_int.call(null,(6)));
})));
});

faker.lorem.sentences.cljs$lang$maxFixedArity = 1;
/**
 * Lazy sequence of random latin paragraphs.
 * 
 *   (paragraphs 5) will generate a sequence of random paragraphs between
 *   5 and 5 + 2 sentences.
 *   (paragraphs) will generate random paragraphs between 3 and 3 + 2 sentences
 */
faker.lorem.paragraphs = (function faker$lorem$paragraphs(var_args){
var args28814 = [];
var len__26059__auto___28817 = arguments.length;
var i__26060__auto___28818 = (0);
while(true){
if((i__26060__auto___28818 < len__26059__auto___28817)){
args28814.push((arguments[i__26060__auto___28818]));

var G__28819 = (i__26060__auto___28818 + (1));
i__26060__auto___28818 = G__28819;
continue;
} else {
}
break;
}

var G__28816 = args28814.length;
switch (G__28816) {
case 0:
return faker.lorem.paragraphs.cljs$core$IFn$_invoke$arity$0();

break;
case 1:
return faker.lorem.paragraphs.cljs$core$IFn$_invoke$arity$1((arguments[(0)]));

break;
default:
throw (new Error([cljs.core.str("Invalid arity: "),cljs.core.str(args28814.length)].join('')));

}
});

faker.lorem.paragraphs.cljs$core$IFn$_invoke$arity$0 = (function (){
return faker.lorem.paragraphs.call(null,(3));
});

faker.lorem.paragraphs.cljs$core$IFn$_invoke$arity$1 = (function (sentence_count){
return cljs.core.map.call(null,(function (n){
return clojure.string.join.call(null," ",cljs.core.take.call(null,n,faker.lorem.sentences.call(null)));
}),cljs.core.repeatedly.call(null,(function (){
return (sentence_count + cljs.core.rand_int.call(null,(3)));
})));
});

faker.lorem.paragraphs.cljs$lang$maxFixedArity = 1;

//# sourceMappingURL=lorem.js.map