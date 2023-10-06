	$(function(){
				
				//User2
				$("#user2BtnList").click(function(){
					$.ajax({
						type: 'GET',
						url: '/Ch10/user2',					
						dataType: 'json',
						success: function(data){
							console.log(data);
						}
						
					});
				});
				$("#user2BtnSelect").click(function(){
					$.ajax({
						type: 'GET',
						url: '/Ch10/user2/A101',					
						dataType: 'json',
						success: function(data){
							console.log(data);
						}
						
					});
				});
				$("#user2BtnRegister").click(function(){
					
					const jsonData = {
						id : 's101',
						name : 'hong',
						hp : '112',
						age : 32
						
					}
					$.ajax({
						type: 'POST',
						url: '/Ch10/user2',					
						dataType: 'json',
						data : jsonData,
						success: function(data){
							console.log(data);
						}
						
					});
				});
				$("#user2BtnUpdate").click(function(){
					const jsonData = {
						id : 's101',
						name : 'hong',
						hp : '115',
						age : 25
						
					}
					$.ajax({
						type: 'PUT',
						url: '/Ch10/user2',					
						dataType: 'json',
						data : jsonData,
						success: function(data){
							console.log(data);
						}
						
					});
				});
				$("#user2BtnDelete").click(function(){
					$.ajax({
						type: 'DELETE',
						url: '/Ch10/user2/s101',					
						dataType: 'json',
						success: function(data){
							console.log(data);
						}
						
					});
				});
			});
			