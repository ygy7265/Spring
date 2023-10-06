	$(function(){
				
				//User1
				$("#user1BtnList").click(function(){
					$.ajax({
						type: 'GET',
						url: '/Ch10/user1',					
						dataType: 'json',
						success: function(data){
							console.log(data);
						}
						
					});
				});
				$("#user1BtnSelect").click(function(){
					$.ajax({
						type: 'GET',
						url: '/Ch10/user1/A101',					
						dataType: 'json',
						success: function(data){
							console.log(data);
						}
						
					});
				});
				$("#user1BtnRegister").click(function(){
					
					const jsonData = {
						id : 's101',
						name : 'hong',
						hp : '112',
						age : 32
						
					}
					$.ajax({
						type: 'POST',
						url: '/Ch10/user1',					
						dataType: 'json',
						data : jsonData,
						success: function(data){
							console.log(data);
						}
						
					});
				});
				$("#user1BtnUpdate").click(function(){
					const jsonData = {
						id : 's101',
						name : 'hong',
						hp : '115',
						age : 25
						
					}
					$.ajax({
						type: 'PUT',
						url: '/Ch10/user1',					
						dataType: 'json',
						data : jsonData,
						success: function(data){
							console.log(data);
						}
						
					});
				});
				$("#user1BtnDelete").click(function(){
					$.ajax({
						type: 'DELETE',
						url: '/Ch10/user1/s101',					
						dataType: 'json',
						success: function(data){
							console.log(data);
						}
						
					});
				});
			});
			