goog.provide('OffcourseDesignDocs');
OffcourseDesignDocs.debugMessage = 'Dead Code';

var goals = {
    map: function mapGoals (doc){
        emit(doc["goal"], null);
    }.toString(),
    reduce: "_count"
};

var flags = {
    map: function mapFlags (doc){
        var flags = doc["flags"];
        flags.forEach(function(flag){
            emit(flag, null);
        })
    }.toString(),
    reduce: "_count"
};

var curators = {
    map: function mapCurators (doc){
        emit(doc["curator"], null);
    }.toString(),
    reduce: "_count"
};

var tags = {
    map: function mapTags (doc) {
        var checkpoints = doc['checkpoints'];
        var tagsTemp = Object.keys(checkpoints).map(function (key) {return checkpoints[key]['tags']});
        var tags = [].concat.apply([], tagsTemp);
        if(tags.length > 0){
            tags.forEach(function(tag) {emit(tag, doc['_id'])});
        }
    }.toString(),
    reduce: "_count"
};

var views = {
    goals: goals,
    flags: flags,
    tags: tags,
    curators: curators
};

var doc = {
    _id: "_design/query",
    views: views
};

OffcourseDesignDocs.course = doc;
