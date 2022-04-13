<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
$(window).on("scroll", function() {
    if ($(this).scrollTop() > 10) {
        $("nav.navbar").addClass("mybg-dark");
        $("nav.navbar").addClass("navbar-shrink");
        $(".navbar-dark .navbar-toggler").css({"background-color" : "#212529"});

    } else {
        $("nav.navbar").removeClass("mybg-dark");
        $("nav.navbar").removeClass("navbar-shrink");
        $(".navbar-brand").css({
            "color": "#fff"
        });
        $(".navbar-dark .navbar-toggler").css({"background-color" : "transparent"});
        
    }
});

$(document).ready(function() {

    $(function() {

        $(document).on('scroll', function() {

            if ($(window).scrollTop() > 100) {
                $('.scroll-top-wrapper').addClass('show');
            } else {
                $('.scroll-top-wrapper').removeClass('show');
            }
        });

        $('.scroll-top-wrapper').on('click', scrollToTop);
    });

    function scrollToTop() {
        verticalOffset = typeof(verticalOffset) != 'undefined' ? verticalOffset : 0;
        element = $('body');
        offset = element.offset();
        offsetTop = offset.top;
        $('html, body').animate({
            scrollTop: offsetTop
        }, 500, 'linear');
    }

});
</script>
<style type="text/css">
body {
    font-family: 'Indie Flower', cursive;
    font-size: 100%;
}


/*---navbar---*/

.navbar {
    background: transparent;
}
.navbar-shrink{
    padding-top: 0;
    padding-bottom: 0;
}
.navbar-brand {
    font-size: 2em;
    font-weight: bolder;
}



.navbar a:not(.navbar-brand) {
    font-weight: bolder;
    font-size: 1.4em;
    color: #ffffff !important;
}
.navbar a:not(.navbar-brand):hover{
	color:red !important;
}

header.masthead {
    position: relative;
    background-color: #343a40;
    height: 100vh;
    background: url(https://images.pexels.com/photos/551997/pexels-photo-551997.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260) no-repeat fixed center center;
    -webkit-background-size: cover;
    -moz-background-size: cover;
    -o-background-size: cover;
    background-size: cover;
    padding-top: 8rem;
    padding-bottom: 8rem;
}

header.masthead .overlay {
    position: absolute;
    background-color: #212529;
    height: 100%;
    width: 100%;
    top: 0;
    left: 0;
    opacity: .3
}

header.masthead h1 {
    font-size: 2rem
}

@media (min-width:768px) {
    header.masthead {
        padding-top: 12rem;
        padding-bottom: 12rem
    }
    header.masthead h1 {
        font-size: 4rem;
        font-weight:bold;
    }
}

.my-padding {
    padding-top: 8rem;
    padding-bottom: 8rem;
}

.form-row>.col,
.form-row>[class*=col-] {
    padding-right: 0;
    padding-left: 0;
}


/*---gallery---*/

#photos {
    padding-top: 5rem;
    padding-bottom: 5rem;
}

#photos img {
    width: 100%;
    height: 15em;
    border-radius: 0.8em;
    transition: transform 2s ease-in-out;
}

#photos img:hover {
    opacity: 0.8;
    transform: scale(1.15);
}

#photos h2 {
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    border-top: 0.15em solid black;
    border-bottom: 0.15em solid black;
    color: red;
    display: none;
}

#photos .col-lg-4:hover h2 {
    display: block;
}

.portfolio-item {
    position: relative;
    margin-bottom: 2rem;
}

img.img-fluid.rounded-circle.mb-3 {
    height: 192px;
    width: 192px;
    object-fit: cover;
}
.featherlight .featherlight-image{
    width:600px;
    height:400px;
}

/*-----parallax-----*/

.mybg {
    position: relative;
    background: linear-gradient(to right, rgba(255, 255, 255, 0.7686274509803922), rgba(255, 255, 255, 0.7686274509803922)), url(https://images.pexels.com/photos/5317/food-salad-restaurant-person.jpg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260) no-repeat center center fixed;
    background-size: cover;
}

.call-to-action {
    position: relative;
    background-color: #1c1c1c;
    padding-top: 7rem;
    padding-bottom: 7rem
}

.call-to-action .overlay {
    position: absolute;
    background-color: #212529;
    height: 100%;
    width: 100%;
    top: 0;
    left: 0;
    opacity: .3
}

footer.footer {
    padding-top: 4rem;
    padding-bottom: 4rem
}

.myhr {
    border-top: 1px solid rgba(255, 255, 255, 0.1) !important;
}

.myform {
    border-radius: 0px !important;
}

.mybtn {
    border-radius: 0px !important;
}

.txt-upper {
    text-transform: uppercase;
}

.mybg-dark {
    background: #000000 !important;
}

.order-now a {
    background: #fff;
    border: 3px solid black;
    padding: 6px 15px;
    font-size: 1.5em;
    font-weight: bold;
    color: #0056b3;
    text-decoration: none;
    opacity: 0.6;
}

.order-now a:hover {
    background: red;
    color:#fff;
    opacity: 1;
}

.myfont-color {
    color: #979797 !important;
}


/*----testimonials----*/

.testimonials {
    padding-top: 7rem;
    padding-bottom: 7rem
}

.testimonials .testimonial-item {
    max-width: 18rem
}

.testimonials .testimonial-item img {
    max-width: 12rem;
    box-shadow: 0 5px 5px 0 #adb5bd
}


/* Footer */

section {
    padding: 60px 0 18px;
}

section .section-title {
    text-align: center;
    color: #007b5e;
    margin-bottom: 50px;
    text-transform: uppercase;
}

#footer {
    background: #232323 !important;
}

#footer h5 {
    padding-left: 10px;
    border-left: 3px solid #eeeeee;
    padding-bottom: 6px;
    margin-bottom: 20px;
    color: #ffffff;
}

#footer a {
    color: #ffffff;
    text-decoration: none !important;
    background-color: transparent;
    -webkit-text-decoration-skip: objects;
}

#footer ul.social li {
    padding: 3px 0;
}

#footer ul.social li a i {
    margin-right: 5px;
    font-size: 25px;
    -webkit-transition: .5s all ease;
    -moz-transition: .5s all ease;
    transition: .5s all ease;
}

#footer ul.social li:hover a i {
    font-size: 30px;
    margin-top: -10px;
}

#footer ul.social li a,
#footer ul.quick-links li a {
    color: #979797;
}

#footer ul.quick-links li a:hover {
    color: #fff;
}

#footer ul.social li a:hover {
    color: #eeeeee;
}

#footer ul.quick-links li {
    padding: 3px 0;
    -webkit-transition: .5s all ease;
    -moz-transition: .5s all ease;
    transition: .5s all ease;
}

#footer ul.quick-links li:hover {
    padding: 3px 0;
    margin-left: 5px;
    font-weight: 700;
}

#footer ul.quick-links li a i {
    margin-right: 5px;
}

#footer ul.quick-links li:hover a i {
    font-weight: 700;
}

@media (max-width:767px) {
    #footer h5 {
        padding-left: 0;
        border-left: transparent;
        padding-bottom: 0px;
        margin-bottom: 10px;
    }
}

 
/*-----scroll-top-----*/

.scroll-top-wrapper {
    position: fixed;
    opacity: 0;
    visibility: hidden;
    overflow: hidden;
    text-align: center;
    z-index: 99999999;
    background-color: #777777;
    color: #eeeeee;
    width: 50px;
    height: 48px;
    line-height: 48px;
    right: 30px;
    bottom: 30px;
    padding-top: 2px;
    border-top-left-radius: 10px;
    border-top-right-radius: 10px;
    border-bottom-right-radius: 10px;
    border-bottom-left-radius: 10px;
    -webkit-transition: all 0.5s ease-in-out;
    -moz-transition: all 0.5s ease-in-out;
    -ms-transition: all 0.5s ease-in-out;
    -o-transition: all 0.5s ease-in-out;
    transition: all 0.5s ease-in-out;
}

.scroll-top-wrapper:hover {
    background-color: #888888;
}

.scroll-top-wrapper.show {
    visibility: visible;
    cursor: pointer;
    opacity: 1.0;
}

.scroll-top-wrapper i.fa {
    line-height: inherit;
}
</style>
</head>
 <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
 <link href="https://fonts.googleapis.com/css?family=Indie+Flower" rel="stylesheet">
<link href="//cdn.rawgit.com/noelboss/featherlight/1.7.13/release/featherlight.min.css" type="text/css" rel="stylesheet" />
<script src="//cdn.rawgit.com/noelboss/featherlight/1.7.13/release/featherlight.min.js" type="text/javascript" charset="utf-8"></script>
<body>
      <!-- Masthead -->
    <header class="masthead text-white text-center">
        <div class="overlay"></div>
        <div class="container">
            <div class="row">
                <div class="col-xl-9 mx-auto mt-5">
                    <h1 class="mb-5">Welcome To Canteen Management System</h1>
                </div>
                <div class="col-xl-12 mx-auto order-now my-padding">
                    <a href="account/login">Order Now!</a>
                </div>
            </div>
        </div>
    </header>

    <!--Gallery-->
        <!--gallery end-->

     <!-- Footer -->
    <section id="footer">
        <div class="container">
            <div class="row text-xs-center text-sm-left text-md-left mb-5">
                <div class="col-xs-12 col-sm-4 col-md-3">
                    <h5 class="txt-upper">About Restro</h5>
                    <p class="myfont-color text-justify">Welcome to Canteen Management System</p>
                   
                </div>
                <div class="col-xs-12 col-sm-4 col-md-3 myfont-color">
                    <h5 class="txt-upper">HOURS</h5>
                    <p> LUNCH:
                        <br> Mon-Fri: 11:30 AM - 2:30 PM
                        <br>
                        <br> DINNER:

                        <br> Mon-Thu: 4:45 PM - 10:30 PM
                        <br> Fri: 4:45 PM - 11 PM
                        <br> Sat: 4:30 PM - 11 PM
                        <br> Sun: 5:00 PM - 10:30 PM
                        <p>

                </div>
                <div class="col-xs-12 col-sm-4 col-md-3">
                    <h5 class="txt-upper">Featured Menus</h5>
                    <ul class="list-unstyled quick-links">
                        <li><a href="javascript:void();">Pizza</a></li>
                        <li><a href="javascript:void();">Appetizers</a></li>
                        <li><a href="javascript:void();">Soup</a></li>
                        <li><a href="javascript:void();">Shushi rolls</a></li>
                        <li><a href="javascript:void();">Spaghetti</a></li>
                        <li><a href="javascript:void();">Pasta</a></li>
                    </ul>
                </div>
            </div>
            <hr class="myhr">
            <div class="row">
                <div class="col-xs-12 col-sm-12 col-md-12 mt-2 mt-sm-2  text-white">

                    <p class="h6">Copyright © All Rights Reserved.<a class="text-green ml-2" href="#" target="_blank">Restro</a></p>
                </div>
                <hr>
            </div>
        </div>
    </section>
    <!--Footer -->

    <div class="scroll-top-wrapper ">
        <span class="scroll-top-inner">
    <i class="fa fa-2x fa-arrow-circle-up"></i>
  </span>
    </div>

	<h4>
		<a href="account/login">Go to login</a>
	</h4>
</body>
</html>