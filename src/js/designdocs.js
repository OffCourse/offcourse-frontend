goog.provide('OffcourseDesignDocs');
OffcourseDesignDocs.debugMessage = 'Dead Code';

var goals = {
    map: function mapGoals (doc){
        emit(doc["goal"], doc["course-id"]);
    }.toString(),
    reduce: "_count"
};

var flags = {
    map: function mapFlags (doc){
        var flags = doc["flags"];
        flags.forEach(function(flag){
            emit(flag, doc["course-id"]);
        })
    }.toString(),
    reduce: "_count"
};

var curators = {
    map: function mapCurators (doc){
        emit(doc["curator"], doc["course-id"]);
    }.toString(),
    reduce: "_count"
};

var tags = {
    map: function mapTags (doc) {
        var checkpoints = doc['checkpoints'];
        var tagsTemp = Object.keys(checkpoints).map(function (key) {return checkpoints[key]['tags']});
        var tags = [].concat.apply([], tagsTemp);
        if(tags.length > 0){
            tags.forEach(function(tag) {emit(tag, doc['course-id'])});
        }
    }.toString(),
    reduce: "_count"
};

var courseIds = {
    map: function mapCurators (doc){
        emit(doc["course-id"], null);
    }.toString(),
    reduce: "_count"
}

var views = {
    goals: goals,
    flags: flags,
    tags: tags,
    courseIds: courseIds,
    curators: curators
};

var doc = {
    _id: "_design/query",
    views: views
};

OffcourseDesignDocs.course = doc;
