//mainCtrl.js
var ctrls = angular.module('nourControllers', ['nourConfig', 'ngResource',
    'mainServices']);

ctrls.controller('mainController',['$scope','$stateParams','GetSubjects','GetVideosAll','GetVideosBySubjectAndGrade',
        function($scope,$stateParams,GetSubjects,GetVideosAll,GetVideosBySubjectAndGrade){

$scope.main = {
  selectedSubjectID : 1,
  selectedGradeID : 0,
};
$scope.videos = [];

//----Stores
  // GetSubjects.query({},function (data) {
  //   // body...
  //   $scope.subjects = data;
  // });

  $scope.subjects = [
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

  $scope.grades = [
    {
      id : 0,
      name : '全部'
    },
    {
      id : 1,
      name : '一年级'
    },
    {
      id : 2,
      name : '二年级'
    },
    {
      id : 3,
      name : '三年级'
    },
    {
      id : 4,
      name : '四年级'
    },
    {
      id : 5,
      name : '五年级'
    },
    {
      id : 6,
      name : '六年级'
    }
  ];

  GetVideosAll.query({},function (data) {
    // body...
    $scope.videos = data;
    console.log(data);
  });

  getVideos = function () {
    // body...
    GetVideosBySubjectAndGrade.query(
      {subjectId:$scope.main.selectedSubjectID,gradeId:$scope.main.selectedGradeID},
      function (data) {
      // body...
      console.log(data);
      $scope.videos = data;
    })
  }


//=============================================================================


//----Functions
    $scope.selectSubject = function (item){
      // body...
      console.log(item);
      $scope.main.selectedSubjectID = item.id;
      getVideos();
    };

    $scope.selectGrade = function (item){
      // body...
      console.log(item);
      $scope.main.selectedGradeID = item.id;
      getVideos();
    };


    $scope.isAble = function(iterm){
      if (iterm.status === "已结束") {
        return true;
      }
      else {
        return false;
      }
    };

    $scope.getHref = function(item){
      if ($scope.isAble(item)) {
        return "";
      }
      else {
        return "#/update/"+item.id;
      }
    };

//=============================================================================

  // fix menu when passed
  $('.masthead')
    .visibility({
      once: false,
      onBottomPassed: function() {
        $('.fixed.menu').transition('fade in');
      },
      onBottomPassedReverse: function() {
        $('.fixed.menu').transition('fade out');
      }
    })
  ;

  // create sidebar and attach to menu open
  $('.ui.sidebar')
    .sidebar('attach events', '.toc.item');

}]);

ctrls.filter('formatRegion', function () {
    return function (input) {
        // if (input.length > 6)
        //     return input.substring(0, 6) + '...';
        // else
        //     return input;
        switch (input) {
          case 1: return "海淀区";
          case 2: return "朝阳区";
          case 3: return "西城区";
          case 4: return "东城区";
          case 5: return "丰田区";
          case 6: return "大兴区";
          case 7: return "石景山";

          default: return "";
        }

    }
});

ctrls.filter('formatCarType', function () {
    return function (input) {
        // if (input.length > 6)
        //     return input.substring(0, 6) + '...';
        // else
        //     return input;
        switch (input) {
          case 1: return "金杯";
          case 2: return "皮卡";
          case 3: return "厢式货车";
          case 4: return "1041货车";

          default: return "";
        }

    }
});
