var app = angular.module("myApp", ['ngResource']);

function Ctrl($scope, $resource)
{
  
  var Productos = $resource('/productos/:id',
          {id:'@id'},
          {
            update: { method: 'put',    isArray: false },
            del:    { method: 'delete', isArray: false }
          }                  
      );
  
  $scope.newProd = new Productos();
  $scope.misProductos = [];
  
  
  $scope.agregar = function(){
    
    $scope.newProd.id 
        ?
          $scope.newProd.$update(function(){
            $scope.newProd = new Productos();
          })
        :
          $scope.newProd.$save(function(){
            $scope.misProductos.push($scope.newProd);
            $scope.newProd = new Productos();
          });
    
          
  }
  
  $scope.update = function(p){
    $scope.newProd = p;
  }
  
  Productos.query(function(data){
      $scope.misProductos = data;
      console.log("Productos del server");
      console.log(data);
    }
  );
  
  $scope.borrar = function(p, i)
  {
    p.$del(function(){
      $scope.misProductos.splice(i,1);
    });
  }
  
  
}
app.controller('Ctrl', Ctrl);