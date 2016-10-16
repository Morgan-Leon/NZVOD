var mainServices = angular.module('mainServices',['ngResource', "nourConfig"]);

/*
Get All Subjects
*/
mainServices.factory('GetSubjects',['$resource','config',
  function($resource,config){
    return $resource(config.HOST + "subjects",
    {},{}
    );
  }])
/*
Get All Videos
*/
mainServices.factory('GetVideosAll',['$resource','config',
  function($resource,config){
    return $resource(config.HOST + "videos",
    {},{}
    );
  }])


/*
Gat Videos By Subject & Grade
*/
mainServices.factory('GetVideosBySubjectAndGrade',['$resource','config',
  function($resource,config){
    return $resource(config.HOST + "/subject/:subjectId/grade/:gradeId/videos",
      {subjectId:'@_subjectId',gradeId:'@_gradeId'},{}
  );
  }])


  /*
  Gat Videos By Subject & Grade
  */
  mainServices.factory('GetVideosBySearchName',['$resource','config',
    function($resource,config){
      return $resource(config.HOST + "/videos/conditions?name=:name&subjectId=:subjectId&gradeId=:gradeId",
        {name:'@_nameId',subjectId:'@_subjectId',gradeId:'@_gradeId'},
        {}
    );
  }])
