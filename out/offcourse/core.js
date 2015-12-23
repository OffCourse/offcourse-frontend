// Compiled by ClojureScript 1.7.170 {}
goog.provide('offcourse.core');
goog.require('cljs.core');
goog.require('offcourse.api.index');
goog.require('offcourse.views.index');
goog.require('offcourse.plumbing');
goog.require('offcourse.fake_data.index');
goog.require('offcourse.adapters.pouchdb');
goog.require('com.stuartsierra.component');
offcourse.core.stringify = (function offcourse$core$stringify(js_object){
return JSON.stringify(js_object);
});
offcourse.core.app = (function offcourse$core$app(design_doc){
var channels = offcourse.plumbing.channels.call(null);
var bootstrap_doc = offcourse.core.stringify.call(null,cljs.core.clj__GT_js.call(null,offcourse.fake_data.index.generate_course.call(null,"123abbc")));
cljs.core.println.call(null,bootstrap_doc);

return com.stuartsierra.component.system_map.call(null,new cljs.core.Keyword(null,"api-input","api-input",-728790096),new cljs.core.Keyword(null,"api-input","api-input",-728790096).cljs$core$IFn$_invoke$arity$1(channels),new cljs.core.Keyword(null,"api-output","api-output",2109409900),new cljs.core.Keyword(null,"api-output","api-output",2109409900).cljs$core$IFn$_invoke$arity$1(channels),new cljs.core.Keyword(null,"renderer-input","renderer-input",473428225),new cljs.core.Keyword(null,"renderer-input","renderer-input",473428225).cljs$core$IFn$_invoke$arity$1(channels),new cljs.core.Keyword(null,"db","db",993250759),offcourse.adapters.pouchdb.new_db.call(null,"Offcourse-Sample",design_doc,bootstrap_doc),new cljs.core.Keyword(null,"api","api",-899839580),com.stuartsierra.component.using.call(null,offcourse.api.index.new_api.call(null),new cljs.core.PersistentArrayMap(null, 3, [new cljs.core.Keyword(null,"input-channel","input-channel",1891525728),new cljs.core.Keyword(null,"api-input","api-input",-728790096),new cljs.core.Keyword(null,"output-channel","output-channel",338004025),new cljs.core.Keyword(null,"api-output","api-output",2109409900),new cljs.core.Keyword(null,"service","service",-1963054559),new cljs.core.Keyword(null,"db","db",993250759)], null)),new cljs.core.Keyword(null,"renderer","renderer",336841071),com.stuartsierra.component.using.call(null,offcourse.views.index.new_renderer.call(null),new cljs.core.PersistentArrayMap(null, 1, [new cljs.core.Keyword(null,"input-channel","input-channel",1891525728),new cljs.core.Keyword(null,"renderer-input","renderer-input",473428225)], null)));
});

//# sourceMappingURL=core.js.map