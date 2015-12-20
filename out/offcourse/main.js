// Compiled by ClojureScript 1.7.170 {}
goog.provide('offcourse.main');
goog.require('cljs.core');
goog.require('com.stuartsierra.component');
goog.require('offcourse.adapters.pouchdb.index');
goog.require('offcourse.core');
if(typeof offcourse.main.db !== 'undefined'){
} else {
offcourse.main.db = offcourse.adapters.pouchdb.index.new_pouch.call(null,"Offcourse-Sample");
}
offcourse.main.init = (function offcourse$main$init(){
cljs.core.enable_console_print_BANG_.call(null);

cljs.core.println.call(null,"1...2...3... lift off!");

return com.stuartsierra.component.start.call(null,offcourse.main.db);
});
offcourse.main.reload = (function offcourse$main$reload(){
cljs.core.enable_console_print_BANG_.call(null);

cljs.core.println.call(null,"Entering hyperspace");

return offcourse.core.render.call(null);
});
offcourse.main.stop = (function offcourse$main$stop(){
return com.stuartsierra.component.stop.call(null,offcourse.main.db);
});

//# sourceMappingURL=main.js.map