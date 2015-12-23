// Compiled by ClojureScript 1.7.170 {}
goog.provide('offcourse.plumbing');
goog.require('cljs.core');
goog.require('cljs.core.async');
offcourse.plumbing.channels = (function offcourse$plumbing$channels(){
var api_input = cljs.core.async.chan.call(null);
var api_output = cljs.core.async.chan.call(null);
var renderer_input = cljs.core.async.chan.call(null);
cljs.core.async.pipe.call(null,api_output,renderer_input);

return new cljs.core.PersistentArrayMap(null, 3, [new cljs.core.Keyword(null,"api-input","api-input",-728790096),api_input,new cljs.core.Keyword(null,"api-output","api-output",2109409900),api_output,new cljs.core.Keyword(null,"renderer-input","renderer-input",473428225),renderer_input], null);
});

//# sourceMappingURL=plumbing.js.map