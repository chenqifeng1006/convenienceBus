<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<script type="text/javascript" src="./js/libs/jquery.js"></script>
</head>
<body>

<button id="query">query</button>
<button id="add">add</button>
<button id="edit">edit</button>
<button id="delete">delete</button>

</body>

<script>
$(function(){
	$('#query').click(function(){
		$.ajax({
			url:'driver/query',
			data:{},
			success:function(data){
				console.log(data)
			}
		})
	})
	
	$('#add').click(function(){
		$.ajax({
			type:'POST',
			url:'driver/add',
			data:{
				cellPhone:'186428384582',
				card:'21021102',
				password:'123456',
				username:'陈其丰222',
				vehicleLicense:'n9y83',
				amount:'12.2'
			},
			success:function(data){
				console.log(data)
			}
		})
	})
	
	$('#edit').click(function(){
		$.ajax({
			type:'POST',
			url:'driver/edit',
			data:{
				id:3,
				cellPhone:'186428384582',
				card:'21021102',
				password:'123456',
				username:'丛日红',
				vehicleLicense:'n9y83',
				amount:'12.88'
			},
			success:function(data){
				console.log(data)
			}
		})
	})
	
	$('#delete').click(function(){
		$.ajax({
			type:'POST',
			url:'driver/delete',
			data:{id:6},
			success:function(data){
				console.log(data)
			}
		})
	})
	
})

</script>


</html>