<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0043)http://www.shopdev.co.uk/blog/menuDemo.html -->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>Demo</title>

    <style>
    body {
        background-color:grey;
        margin:0;
    }

        /* Firefox Dotted Outline Fix */
    a:active {
        outline: none;
    }

        /* Firefox Dotted Outline Fix */
    a:focus {
        -moz-outline-style: none;
    }

        /* Menu Body */
    ul#menu {
        width:80%;
        height:102px;
        background:url("${resource(dir: 'images', file: 'bg.png')}") repeat-x;
        list-style:none;
        margin:0;
        padding:0;
        padding-top:20px;
        padding-left:20%;
    }

        /* Float LI Elements - horizontal display */
    ul#menu li {
        float:left;
    }
    .content{
        min-width: 1000px;
        max-height: 100px;
    }
     #menu li img.menu-icon
     {
         cursor: pointer;
     }
     #upload-icon img:hover
     {
        background-image: url("../images/uploadfile1.png");
        margin-bottom:40px;
     }
    </style>
    <link rel="stylesheet" href="../css/customCss.css" type="text/css" />

    <script type="text/javascript" src="${resource(dir: 'js', file: 'jquery-1.7.1.js')}"></script>

    <script type="text/javascript">

        function cal()
        {
            alert("hi");
        }

        $(document).ready(function () {
         // alert("hi")
        });
//
         $("#upload-icon").click(function(){

             alert("hi") ;
           //  $("#upload-icon").attr("src","../images/uploadfile2.png")

         });

    </script>
</head>

<body>
<div>
<div  class="content" style="background-color: #1c94c4;width: 100%;position: relative;">
<ul id="menu">
    <li><h5 style="margin-left:-250px;margin-top:14px;margin-right:20px;font-size: 35px;font-weight: bold;color:#1F1F1F;font-family: agency FB" >997 Transactions</h5></li>
    <li><g:link action="info"><img class="menu-icon" src="../images/home1.png" alt=""/></g:link></li>
    <li id="upload-icon"><g:link action="uploadFile"> <img class="menu-icon"  id="upload" src="../images/uploadfile1.png" alt=""/></g:link></li>
    <li ><g:link action="deleteUsingName"><img class="menu-icon"  id="delete-icon" src="../images/deletefile1.png" alt=""/></g:link></li>
    <li ><g:link action="editUsingName"><img class="menu-icon"  id="edit-icon" src="../images/editfile1.png" alt=""/></g:link> </li>
    <li ><g:link action="display"><img class="menu-icon"  id="view-icon" src="../images/viewfiles1.png" alt=""/></g:link></li>
    <li ><g:link controller="logout"><img class="menu-icon"  id="logout-icon" src="../images/logout1.png" alt=""/></g:link> </li>
</ul>
</div>
</div>
</body>
<g:layoutBody/>
</html>