ctrls.controller('playerController',['$scope','$stateParams','$location','GetAVideo',
function($scope,$stateParams,$location,GetAVideo) {
  // body...
  console.log($stateParams);
  $scope.player = {
    stateParams : $stateParams.id,
  }

  GetAVideo.get({id:$scope.player.stateParams},function (response) {
    // body...
    console.log(response);
    $scope.video = response;
  });

  // console.log($scope.video );

  $scope.back = function () {
    // body...
    console.log("back");
    $location.path("#");
    $location.replace();
  }


}]);
