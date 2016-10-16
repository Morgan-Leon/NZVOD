ctrls.controller('playerController',['$scope','$stateParams','$location',
function($scope,$stateParams,$location) {
  // body...
  console.log($stateParams);
  $scope.player = {
    stateParams : $stateParams.id,
  }

  $scope.back = function () {
    // body...
    console.log("back");
    $location.path("#");
    $location.replace();
  }

}]);
