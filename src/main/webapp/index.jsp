<!doctype html>
<html lang="en">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <title>RC CLIENT APP</title>
</head>

<body>
    <h1>WELCOME TO RC CLIENT APP DEMO!</h1>
    <form id="my-form" >
        <div class="form-group">
            <label for="exampleInputEmail1">Email address</label>
            <input type="email" class="form-control" aria-describedby="emailHelp" id="email" placeholder="Enter email">
            <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
        </div>
        <div class="row">
            <div class="col">
                <input type="text" class="form-control" placeholder="Name" id="name">
            </div>
        </div><br>
        <button class="btn btn-primary">SUBMIT</button>
    </form>
	<div id="showresults">
	</div>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.js" integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60=" crossorigin="anonymous"></script>
 	 <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <script type="text/JavaScript">
    const url = "http://ec2-13-57-7-24.us-west-1.compute.amazonaws.com:8080/RCClient/rest/post";
    $(document).ready(function(e){
    	
    	  $("button").click(function(event){
    		// var email = document.getElementById("email").value;
    		// var name = document.getElementById("name").value;
    		 var data = JSON.stringify({
    		        "email": $('#email').val(),
    		        "name": $('#name').val()});
    		 var req = $.ajax({
    			  url:url,
    			  type:"POST",
    			  data:data,
    			  contentType:"application/json",
    			  dataType:"json",
    			  success: function(data){
    	      		//$("#response").html(JSON.stringify(data));
    	      		var obj = JSON.parse(JSON.stringify(data));
    	      		
    	      		var str = "Hello "+obj.name +"! Your New ID is "+ obj.id;
    	      		alert(str);
    	    }});
    		 req.done(function(data){
    			 var obj = JSON.parse(JSON.stringify(data));
 	      		
 	      		var str = "Hello "+obj.name +"! Your New ID is "+ obj.id;
 	      		$("#showresults").append(str);
    		 });
       	  event.preventDefault();
    	  });
    });
    </script>
</body>

</html>