<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head>
<title>Campeonato Entre Amigos</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="description"
	content="Expand, contract, animate forms with jQuery wihtout leaving the page" />
<meta name="keywords"
	content="expand, form, css3, jquery, animate, width, height, adapt, unobtrusive javascript" />
<link rel="shortcut icon" href="../favicon.ico" type="image/x-icon" />
<link rel="stylesheet" type="text/css" href="resources/css/style.css" />
<script src="js/cufon-yui.js" type="text/javascript"></script>
<script src="js/ChunkFive_400.font.js" type="text/javascript"></script>
<script type="text/javascript">
	Cufon.replace('h1', {
		textShadow : '1px 1px #fff'
	});
	Cufon.replace('h2', {
		textShadow : '1px 1px #fff'
	});
	Cufon.replace('h3', {
		textShadow : '1px 1px #000'
	});
	Cufon.replace('.back');
</script>
</head>
<body>
	<div class="wrapper"></div>
		
		<div class="content"></div>
			<div id="form_wrapper" class="form_wrapper">
				
				<form action="efetuaLogin" class="login active" method="post">
					<h3>Login</h3>
					<div>
						<label>Username:</label> <input type="text" name="login" /> <span
							class="error">This is an error</span>
					</div>
					<div>
						<label>Password: <a href="forgot_password.html"
							rel="forgot_password" class="forgot linkform">Forgot your
								password?</a></label> <input type="password" name="senha" /> <span
							class="error">This is an error</span>
					</div>
					<div class="bottom">
						<div class="remember">
							<input type="checkbox" /><span>Keep me logged in</span>
						</div>
						<input type="submit" value="Login"></input> <a
							href="register.html" rel="register" class="linkform">You
							don't have an account yet? Register here</a>
						<div class="clear"></div>
					</div>
				</form>
				
			</div>
			<div class="clear"></div>



			
</body>
</html>