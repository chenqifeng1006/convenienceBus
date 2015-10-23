<html>
<head>
	<script type="text/javascript" src="./js/libs/jquery.js"></script>
	<script>
		
	</script>
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
			url:'admin/query',
			data:{},
			success:function(data){
				console.log(data)
			}
		})
	})
	
	$('#add').click(function(){
		$.ajax({
			type:'POST',
			url:'admin/add',
			data:{
				cellPhone:'186428384582',
				card:'21021102',
				password:'123456',
				username:'chenqf2',
				role:'commonAdmin'
			},
			success:function(data){
				console.log(data)
			}
		})
	})
	
	$('#edit').click(function(){
		$.ajax({
			type:'POST',
			url:'admin/edit',
			data:{
				id:8,
				cellPhone:'186428384581',
				card:'21021102',
				password:'123456',
				username:'chenqf3',
				role:'commonAdmin'
			},
			success:function(data){
				console.log(data)
			}
		})
	})
	
	$('#delete').click(function(){
		$.ajax({
			type:'POST',
			url:'admin/delete',
			data:{id:6},
			success:function(data){
				console.log(data)
			}
		})
	})
	
})

</script>


</html>