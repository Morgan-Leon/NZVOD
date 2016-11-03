//mainCtrl.js
var ctrls = angular.module('nourControllers', ['nourConfig', 'ngResource',
    'mainServices'
    ]);

ctrls.controller('mainController',['$scope','$stateParams','GetSubjects','GetGrades',
        'GetVideosAll','GetVideosBySubjectAndGrade','GetVideosBySearchName',
        function($scope,$stateParams,GetSubjects,GetGrades,GetVideosAll,
                 GetVideosBySubjectAndGrade,GetVideosBySearchName){

$scope.main = {
  selectedSubjectID : 1,
  selectedGradeID : 0,
  searchTerm : "",
  // thumbNailPlaceHolder : "/images/thumbnails/placeHolder.jpg"
};
$scope.videos = [];

//----Stores
  // GetSubjects.query({},function (data) {
  //   // body...
  //   $scope.subjects = data;
  // });

  $scope.subjects = GetSubjects;

  $scope.grades = GetGrades;

  GetVideosAll.query({},function (data) {
    // body...
    $scope.videos = data;
    console.log(data);
  });


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

    $scope.$watch('main.searchTerm',function (newValue, oldValue) {
      // body...
      $scope.videos = GetVideosBySearchName.query(
        {
          name:newValue,
          subjectId:$scope.main.selectedSubjectID,
          gradeId:$scope.main.selectedGradeID
        })
    })

    getVideos = function () {
      // body...
      GetVideosBySubjectAndGrade.query(
        {subjectId:$scope.main.selectedSubjectID,gradeId:$scope.main.selectedGradeID},
        function (data) {
        // body...
        console.log(data);
        $scope.videos = data;
      })
    };

    videoUpload = function () {
      // body...
      $('.ui.modal').modal('show');
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

ctrls.filter('formatThumbnailsUrl',function () {
  // body...
  return function (input) {
    // body...
    if (input==null || input == "") {
      return "/images/placeHolder.jpg";
    }
    else return input;
  }
});

/**
  除去文件名中的扩展名
  文件名中除扩展名外不要有点
*/
ctrls.filter('formatVideoName',function () {
  // body...
  return function (input) {
    // body...
    var findDot =  input.indexOf('.');
    if (findDot > 0) {
      return input.substring(0,input.indexOf('.'));
    }
    else {
      return input;
    }
  }
});

ctrls.filter('formatGrades',function () {
  // body...
  return function (input) {
     if (input%2 == 0) {
       return "下";
     }
     else {
       return "上";
     }
  }
});

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
