//mainCtrl.js
var ctrls = angular.module('nourControllers', ['nourConfig', 'ngResource',
    'mainServices']);

ctrls.controller('mainController',['$scope','$stateParams','GetSubjects',
        'GetVideosAll','GetVideosBySubjectAndGrade','GetVideosBySearchName',
        function($scope,$stateParams,GetSubjects,GetVideosAll,
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
