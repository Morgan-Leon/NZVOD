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
    return $resource(config.HOST + "",
      {},{}
  );
  }])
