'use strict';

/**
 * @ngdoc function
 * @name dashyAngular.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of dashyAngular
 */
angular.module('dashyAngular').controller('Analyse_Java_Class', function ($scope,  $http) {
  
   $scope.overall_result="";
   $scope.pass_value = "";
   $scope.avg_result = "";
   $scope.results = [];
  
  $scope.showContent = function($fileContent){
    $scope.content = $fileContent;
	
	var jc = $scope.content;
	
	var myEscapedJSONString = jc.replace(/\\n/g, "\\n")
                                      .replace(/\\'/g, "\\'")
                                      .replace(/\\"/g, '\\"')
                                      .replace(/\\&/g, "\\&")
                                      .replace(/\\r/g, "\\r")
                                      .replace(/\\t/g, "\\t")
                                      .replace(/\\b/g, "\\b")
                                      .replace(/\\f/g, "\\f");
	
	var javaCodeJSON = {
						"java_code":  myEscapedJSONString
						}

	var myJSONString = JSON.stringify(javaCodeJSON);
	
	//console.log(JSON.parse(myEscapedJSONString) );
	console.log(javaCodeJSON);
	
	$http({
			  method: 'POST',
			  data : myJSONString,
			  url: 'http://localhost:8084/CodeMage/analyse'
			}).then(function successCallback(response) {
				$scope.overall_result = response.data.overall_result;
				$scope.pass_value = response.data.pass_value;
				$scope.avg_result = response.data.avg_result;
				$scope.results = response.data.table;
				
				console.log(response.overall_result);
			}, function errorCallback(response) {
				swal(
				  'error!',
				  'something wrong! massa',
				  'error'
				)
			});
	
  };
  
  
  
  
})
.directive('onReadFile', function ($parse) {
	return {
		restrict: 'A',
		scope: false,
		link: function(scope, element, attrs) {
            var fn = $parse(attrs.onReadFile);
            
			element.on('change', function(onChangeEvent) {
				var reader = new FileReader();
                
				reader.onload = function(onLoadEvent) {
					scope.$apply(function() {
						fn(scope, {$fileContent:onLoadEvent.target.result});
					});
				};

				reader.readAsText((onChangeEvent.srcElement || onChangeEvent.target).files[0]);
			});
		}
	};
});