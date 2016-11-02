'use strict';

angular.module('route')
  .directive('uiDropdown', function () {
    return {
      restrict: 'EA',
      scope: {
        action: '=action'
      },
      link: function (scope, element) {
        element.
          dropdown({
            action: scope.action || 'activate'
          })
        ;
      }
    };
  });
