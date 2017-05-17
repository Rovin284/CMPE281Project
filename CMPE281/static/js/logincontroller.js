var loginapp = angular.module('loginapp', []);


loginapp.controller('LoginController', ['$scope', '$http', '$window', function($scope, $http, $window) {
    console.log("Hello from LoginController");
	
	//destroy session
	$http.get('/sessiondestroy').success(function(response){
		console.log("session destroyed");
	});
	
	//insert user details
	$scope.addUser = function() {
	console.log($scope.user);
	$scope.user.type="Normal User";
	
	$http.post('/userlist', $scope.user).success(function(response) {
		console.log(response);
		$window.alert("Registration Successful..!!");
		$scope.user="";
	  });
	};
	
	//authenticate user
	$scope.checkUser = function(name,password) {
		print("Test-------------");
		console.log($scope.login);
var express = require('express');
var mysql = require('mysql');
var app = express();
console.log("Hello!");
var connection = mysql.createConnection({
  host     : 'root1.c7n0qa8vxvem.us-west-2.rds.amazonaws.com',
    user     : 'root',
    password : 'root1234',
    database : 'project281',
});

connection.connect(function(error){
  if(error){
    console.log("Error");
  }else{
    console.log("Connected");
  }
});

app.get('/',function(req, resp){
  connection.query("select * from user where name = "+name+";", function (error,rows, fields) {
    if(error){
      console.log("Error in the query");
    }else{
      console.log("Successful query");
      console.log(rows);
      resp.send(rows);
    }
  });
});


		if(){
			$window.location.href = "userindex.html";
		}
		$scope.login.status="Wrong username or Password. Try Again!!";
		
		if(response.toString() == "successful"){
			$scope.login.status="";
			
			//test
			$http.get('/usertype/'+name).success(function(res) {
				console.log(res);
				if(res == "Admin User"){
					$window.location.href = "adminindex.html";
				}else{
					$window.location.href = "userindex.html";
				}
			});
		}
		
	});
	//$window.location.href = "userindex.html";
	};
}]);