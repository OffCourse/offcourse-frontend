// Compiled by ClojureScript 1.7.170 {}
goog.provide('offcourse.core');
goog.require('cljs.core');
goog.require('sablono.core');
if(typeof offcourse.core.counter !== 'undefined'){
} else {
offcourse.core.counter = cljs.core.atom.call(null,(0));
}
offcourse.core.hello = (function offcourse$core$hello(counter){
return new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Keyword(null,"p","p",151049309),counter], null);
});
offcourse.core.render = (function offcourse$core$render(){
cljs.core.swap_BANG_.call(null,offcourse.core.counter,cljs.core.inc);

return ReactDOM.render(sablono.interpreter.interpret.call(null,offcourse.core.hello.call(null,cljs.core.deref.call(null,offcourse.core.counter))),document.getElementById("container"));
});

//# sourceMappingURL=core.js.map