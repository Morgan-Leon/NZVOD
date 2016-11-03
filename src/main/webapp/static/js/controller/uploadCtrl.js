ctrls.controller('uploadController',['$scope','GetGrades','GetSubjects','AddVideo'
  ,function($scope,GetGrades,GetSubjects,AddVideo){

$scope.video = {
  name : '',
  gradeId : -1,
  subjectId : -1,
  author : '',
  description : '',
  url : '../videos/',

};

// console.log($state.id);
$scope.grades = GetGrades;

var subjects = GetSubjects;

subjects.shift();

$scope.subjects = subjects;


$scope.selectGrade = function (grade) {
  // body...
  $scope.video.gradeId = grade.id;
}

$scope.selectSubject = function (subject) {
  // body...
  $scope.video.subjectId = subject.id;
}


/**
上传视频
*/
$scope.uploadVideo = function () {
  // body...
  console.log($scope.video);
  
  AddVideo.save($scope.video,function (response) {
    // body...
    console.log(response);
  })

}


}]);
