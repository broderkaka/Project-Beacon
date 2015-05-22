angular.module('ui.bootstrap.demo', ['ui.bootstrap']);

angular.module('ui.bootstrap.demo').controller('TabsDemoCtrl', function ($scope, $window) {
});

angular.module('ui.bootstrap.demo').controller('SearchTvShow', function ($scope, $window, $http) {
  $scope.search = function()
  {
    $http.get('/rest/v1/searchtvshow?tvshow="' + $scope.query +'"').
            success(function(data) {
                console.log(data);
                $scope.tvShows = data.tvshows;
            });
  }

  $scope.add = function(show)
  {
    $http.post('/rest/v1/addtvshow', show);
  }

});

angular.module('ui.bootstrap.demo').controller('MyTvShow', function ($scope, $timeout, $http) {
    $scope.loadMyShows = function()
    {

        $http.get('/rest/v1/getmytvshows').success(function(data){
                console.log(data);
                $scope.shows = data;
            });
    }



});
