ctrls.controller('uploadController',['$scope','GetGrades','GetSubjects'
  ,function($scope,GetGrades,GetSubjects){

    // console.log($state.id);
$scope.grades = GetGrades;

var subjects = GetSubjects;

subjects.shift();

$scope.subjects = subjects;

}]);
