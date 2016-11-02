var mainServices = angular.module('mainServices',['ngResource', "nourConfig"]);

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

  /*
  Get All Subjects
  */
  var subjects = [
    {
      id : 0,
      name : '全部',
      color : 'black'
    },
    {
      id : 1,
      name : '语文',
      color : 'purple'
    },
    {
      id : 2,
      name : '数学',
      color : 'green'
    },
    {
      id : 3,
      name : '英语',
      color : 'pink'
    },
    {
      id : 4,
      name : '音乐',
      color : 'yellow'
    },
    {
      id : 5,
      name : '美术',
      color : 'teal'
    },
    {
      id : 6,
      name : '科学',
      color : 'blue'
    },
    {
      id : 7,
      name : '品社',
      color : 'olive'
    },
    {
      id : 8,
      name : '体育',
      color : 'violet'
    },
    {
      id : 9,
      name : '信息',
      color : 'brown'
    },
  ];

  mainServices.factory('GetSubjects',
    function(){
      return subjects;
    });

  /*
  Get All Grades
  */
  var grades = [
    // {
    //   id : 0,
    //   name : '全部'
    // },
    {
      id : 1,
      name : '一年级上'
    },
    {
      id : 2,
      name : '一年级下'
    },
    {
      id : 3,
      name : '二年级上'
    },
    {
      id : 4,
      name : '二年级下'
    },
    {
      id : 5,
      name : '三年级上'
    },
    {
      id : 6,
      name : '三年级下'
    },
    {
      id : 7,
      name : '四年级上'
    },
    {
      id : 8,
      name : '四年级下'
    },
    {
      id : 9,
      name : '五年级上'
    },
    {
      id : 10,
      name : '五年级下'
    },
    {
      id : 11,
      name : '六年级上'
    },
    {
      id : 12,
      name : '六年级下'
    }
  ];
  mainServices.factory('GetGrades',function () {
    // body...
    return grades;
  })
