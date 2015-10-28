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
<button id="regist">regist</button>
<button id="login">login</button>
<button id="withdrawals">withdrawals</button>
<button id="reset">reset</button>
<button id="recharge">recharge</button>
</body>

<script>
$(function(){
	$('#query').click(function(){
		$.ajax({
			url:'member/query',
			data:{},
			success:function(data){
				console.log(data)
			}
		})
	})
	
	$('#add').click(function(){
		$.ajax({
			type:'POST',
			url:'member/add',
			data:{
				cellPhone:'186428384582',
				card:'21021102',
				password:'123456',
				username:'陈其丰222',
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
			url:'member/edit',
			data:{
				id:2,
				cellPhone:'xxxxxxx',
				card:'xxxxxxx',
				password:'xxxxxxx',
				username:'丛日红',
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
			url:'member/delete',
			data:{id:3},
			success:function(data){
				console.log(data)
			}
		})
	})
	
	$('#regist').click(function(){
		$.ajax({
			type:'POST',
			url:'member/regist',
			data:{
				cellPhone:'186428384582',
				card:'21021102',
				password:'123456',
				username:'regist',
				amount:'12.2'
			},
			success:function(data){
				console.log(data)
			}
		})
	})
	
	$('#reset').click(function(){
		$.ajax({
			type:'POST',
			url:'member/reset',
			data:{
				id:3
			},
			success:function(data){
				console.log(data)
			}
		})
	})
	
	$('#recharge').click(function(){
		$.ajax({
			type:'POST',
			url:'member/recharge',
			data:{
				id:3,
				amount:15
			},
			success:function(data){
				console.log(data)
			}
		})
	})
	
	$('#withdrawals').click(function(){
		$.ajax({
			type:'POST',
			url:'member/withdrawals',
			data:{
				id:3,
				amount:50
			},
			success:function(data){
				console.log(data)
			}
		})
	})
	
	$('#login').click(function(){
		$.ajax({
			type:'POST',
			url:'member/login',
			data:{
				username:'18642838458',
				password:'123456'
			},
			success:function(data){
				console.log(data)
			}
		})
	})
	
	
})

</script>


</html>