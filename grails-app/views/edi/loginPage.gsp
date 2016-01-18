<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">



<head>
  	<title>Login Page</title>
	<meta http-equiv="content-type" content="text/html; charset=utf-8" />

	<!-- The main style sheet -->
  	<link rel="stylesheet" href="css/style.css" type="text/css" media="screen" />

	<!-- START MooSlide -->
	<!-- The CSS -->
  	<link rel="stylesheet" href="css/mooslide.css" type="text/css" media="screen" />
    <!-- Mootools - the core -->
	<script type="text/javascript" src="js/mootools12.js"></script>
    <!-- MooSlide (show/hide login form) -->
	<script type="text/javascript" src="js/mooSlide2-moo12.js"></script>
	<script language="javascript" type="text/ecmascript">
	window.addEvent('domready',function(){
		var myLogin = new mooSlide2({ slideSpeed: 1000, fadeSpeed: 500,  toggler:'login', content:'loginPanel', height:250, close: false, effects:Fx.Transitions.Bounce.easeOut , from:'top'});
		//optional: AutoStart the slider on page load:
		//MyLogin.run();
	    $('close').addEvent('click', function(e){
			e = new Event(e);
			myLogin.clearit();
			e.stop();
		});
	});
	</script>
</head>

<body>

    <!-- Login Panel using MooSlide -->
	<div id="loginPanel" class="mooSlide">
			<g:form class="left" controller="edi" action="info" method="post">
				<h1 class="padlock">Member Login</h1>
				<label for="log"><b>Username: </b></label>
				<input type="text" name="log" id="log" value="" size="23" />
				<label for="pwd"><b>Password:</b></label>
				<input type="password" name="pwd" id="pwd" size="23" />
            	<label><input class="rememberme" name="rememberme" id="rememberme" type="checkbox" checked="checked" value="forever" /> &nbsp;Remember me</label>
				<input type="submit" name="submit" value="" class="button_login" />
			</g:form>
			<div class="sep"></div>

			<form class="right" action="#" method="post">
				<h1>Not a Member? Sign Up!</h1>
				<label for="signup"><b>Username: </b></label>
				<input type="text" name="signup" id="signup" value="" size="23" />
				<label for="email"><b>Email:</b></label>
				<input type="text" name="email" id="email" size="23" />
				<input type="submit" name="submit" value="" class="button_register" />
			</form>
			<div class="clearfix"></div>

			<div class="loginClose"><a href="#" id="close">&nbsp;</a></div>
	</div> <!-- / Login panel -->

    <div id="container">
		<div id="content">
            <div id="logg">
            <p><a href="#"id="login"><b>Login</b></a></p>
              </div>
            <center>
                <div>
                    <img style="margin-left:20px; margin-top: 250px" src="images/stethescope.png" alt="" />
                    <span class="transactions">997 Transactions</span>
                </div></center>
		</div><!-- / content -->
        <div class="clearfix"></div>
	</div><!-- / container -->

</body>
</html>