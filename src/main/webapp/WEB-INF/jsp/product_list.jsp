<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<c:set var="context" scope="session"
	value="${pageContext.request.contextPath}" />
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<title>Home | E-Shopper</title>
<link href="${context}/css/bootstrap.min.css" rel="stylesheet">
<link href="${context}/css/font-awesome.min.css" rel="stylesheet">
<link href="${context}/css/prettyPhoto.css" rel="stylesheet">
<link href="${context}/css/price-range.css" rel="stylesheet">
<link href="${context}/css/animate.css" rel="stylesheet">
<link href="${context}/css/main.css" rel="stylesheet">
<link href="${context}/css/responsive.css" rel="stylesheet">
<!--[if lt IE 9]>
    <script src="${context}/js/html5shiv.js"></script>
    <script src="${context}/js/respond.min.js"></script>
    <![endif]-->
<link rel="shortcut icon" href="${context}/images/ico/favicon.ico">
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="${context}/images/ico/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="${context}/images/ico/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="${context}/images/ico/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed"
	href="${context}/images/ico/apple-touch-icon-57-precomposed.png">
<script src="${context}/js/nav.js"></script>
<script src="${context}/js/jquery.js"></script>
<script src="${context}/js/bootstrap.min.js"></script>
<script src="${context}/js/jquery.scrollUp.min.js"></script>
<script src="${context}/js/price-range.js"></script>
<script src="${context}/js/jquery.prettyPhoto.js"></script>
<script src="${context}/js/main.js"></script>
<script type="text/javascript">
	$(document).ready(function($) {
		$('#dc_mega-menu-orange').dcMegaMenu({
			rowItems : '4',
			speed : 'fast',
			effect : 'fade'
		});
	});
</script>
<!-- <script type="text/javascript">
	$(window).scroll(function() {
	    if ($(this).scrollTop()) {
	        $('#header-middle').fadeIn();
	    } else {
	        $('#header-middle').fadeOut();
	    }
	});
	</script> -->
</head>
<!--/head-->

<body>
	<header id="header">
		<!--header-->
		<div class="header_top">
			<!--header_top-->
			<div class="container">
				<div class="row">
					<div class="col-sm-6">
						<div class="contactinfo">
							<ul class="nav nav-pills">
								<li><a href="#"><i class="fa fa-phone"></i> +91
										8800598226</a>
								</li>
								<li><a href="#"><i class="fa fa-envelope"></i>
										info@domain.com</a>
								</li>
							</ul>
						</div>
					</div>
					<div class="col-sm-6">
						<div class="shop-menu pull-right">
							<ul class="nav navbar-nav">
								<li><a href="#"><i class="fa fa-user"></i> Account</a>
								</li>
								<li><a href="#"><i class="fa fa-star"></i> Wishlist</a>
								</li>
								<li><a href="checkout.html"><i class="fa fa-crosshairs"></i>
										Checkout</a>
								</li>
								<li><a href="cart.html"><i class="fa fa-shopping-cart"></i>
										Cart</a>
								</li>
								<li><a href="${context}/login"><i class="fa fa-lock"></i>
										Login</a>
								</li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!--/header_top-->

		<div class="header-middle">
			<!--header-middle-->
			<div class="container">
				<div class="row">
					<div class="col-sm-4">
						<div class="logo pull-left">
							<a href="index.html"><img
								src="${context}/images/home/logo.png" alt="" /> </a>
						</div>

					</div>
					<div class="search_box pull-right">
						<input type="text" placeholder="Search" />
					</div>
				</div>
			</div>
		</div>
		<!--/header-middle-->

		<div class="header-bottom">
			<!--header-bottom-->
			<div class="container">
				<div class="row">
					<jsp:include page="menu.jsp"></jsp:include>
				</div>
			</div>
		</div>
		<!--/header-bottom-->
	</header>
	<!--/header-->

	<section>
		<div class="container">
			<div class="row">
				<div class="col-sm-3">
					<div class="left-sidebar">
						<h2>Category</h2>
						<div class="panel-group category-products" id="accordian">
							<!--category-productsr-->
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title">
										<a data-toggle="collapse" data-parent="#accordian"
											href="#sportswear"> <span class="badge pull-right"><i
												class="fa fa-plus"></i> </span> Sportswear </a>
									</h4>
								</div>
								<div id="sportswear" class="panel-collapse collapse">
									<div class="panel-body">
										<ul>
											<li><a href="#">Nike </a>
											</li>
											<li><a href="#">Under Armour </a>
											</li>
											<li><a href="#">Adidas </a>
											</li>
											<li><a href="#">Puma</a>
											</li>
											<li><a href="#">ASICS </a>
											</li>
										</ul>
									</div>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title">
										<a data-toggle="collapse" data-parent="#accordian"
											href="#mens"> <span class="badge pull-right"><i
												class="fa fa-plus"></i> </span> Mens </a>
									</h4>
								</div>
								<div id="mens" class="panel-collapse collapse">
									<div class="panel-body">
										<ul>
											<li><a href="#">Fendi</a>
											</li>
											<li><a href="#">Guess</a>
											</li>
											<li><a href="#">Valentino</a>
											</li>
											<li><a href="#">Dior</a>
											</li>
											<li><a href="#">Versace</a>
											</li>
											<li><a href="#">Armani</a>
											</li>
											<li><a href="#">Prada</a>
											</li>
											<li><a href="#">Dolce and Gabbana</a>
											</li>
											<li><a href="#">Chanel</a>
											</li>
											<li><a href="#">Gucci</a>
											</li>
										</ul>
									</div>
								</div>
							</div>

							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title">
										<a data-toggle="collapse" data-parent="#accordian"
											href="#womens"> <span class="badge pull-right"><i
												class="fa fa-plus"></i> </span> Womens </a>
									</h4>
								</div>
								<div id="womens" class="panel-collapse collapse">
									<div class="panel-body">
										<ul>
											<li><a href="#">Fendi</a>
											</li>
											<li><a href="#">Guess</a>
											</li>
											<li><a href="#">Valentino</a>
											</li>
											<li><a href="#">Dior</a>
											</li>
											<li><a href="#">Versace</a>
											</li>
										</ul>
									</div>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title">
										<a href="#">Kids</a>
									</h4>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title">
										<a href="#">Fashion</a>
									</h4>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title">
										<a href="#">Households</a>
									</h4>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title">
										<a href="#">Interiors</a>
									</h4>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title">
										<a href="#">Clothing</a>
									</h4>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title">
										<a href="#">Bags</a>
									</h4>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title">
										<a href="#">Shoes</a>
									</h4>
								</div>
							</div>
						</div>
						<!--/category-products-->

						<div class="brands_products">
							<!--brands_products-->
							<h2>Brands</h2>
							<div class="brands-name">
								<ul class="nav nav-pills nav-stacked">
									<li><a href="#"> <span class="pull-right">(50)</span>Acne</a>
									</li>
									<li><a href="#"> <span class="pull-right">(56)</span>Grüne
											Erde</a>
									</li>
									<li><a href="#"> <span class="pull-right">(27)</span>Albiro</a>
									</li>
									<li><a href="#"> <span class="pull-right">(32)</span>Ronhill</a>
									</li>
									<li><a href="#"> <span class="pull-right">(5)</span>Oddmolly</a>
									</li>
									<li><a href="#"> <span class="pull-right">(9)</span>Boudestijn</a>
									</li>
									<li><a href="#"> <span class="pull-right">(4)</span>Rösch
											creative culture</a>
									</li>
								</ul>
							</div>
						</div>
						<!--/brands_products-->

						<div class="price-range">
							<!--price-range-->
							<h2>Price Range</h2>
							<div class="well text-center">
								<input type="text" class="span2" value="" data-slider-min="0"
									data-slider-max="600" data-slider-step="5"
									data-slider-value="[250,450]" id="sl2"><br /> <b
									class="pull-left">$ 0</b> <b class="pull-right">$ 600</b>
							</div>
						</div>
						<!--/price-range-->

						<div class="shipping text-center">
							<!--shipping-->
							<img src="${context}/images/home/shipping.jpg" alt="" />
						</div>
						<!--/shipping-->

					</div>
				</div>

				<div class="col-sm-9 padding-right">
					<div class="features_items">
						<!--features_items-->
						<h2 class="title text-center">Features Items</h2>
						<c:forEach items="${productBeansList }" var="product">
							<div class="col-sm-4">
								<div class="product-image-wrapper">
									<div class="single-products">
										<div class="productinfo text-center">
											<a
												href="${context}/product/getProductByProductId/<c:out value="${product.productId}" />"><img
												src="${context}/images/home/product1.jpg" alt="" />
											</a>
											<h2>${product.price }</h2>
											<p>${product.modelName}</p>
											<a href="#" class="btn btn-default add-to-cart"><i
												class="fa fa-shopping-cart"></i>Add to cart</a>
										</div>
									</div>
									<div class="choose">
										<ul class="nav nav-pills nav-justified">
											<li><a href="#"><i class="fa fa-plus-square"></i>Add
													to wishlist</a>
											</li>
											<li><a href="#"><i class="fa fa-plus-square"></i>Add
													to compare</a>
											</li>
										</ul>
									</div>
								</div>
							</div>
						</c:forEach>


					</div>
					<!--features_items-->

				</div>
			</div>
		</div>
	</section>

	<jsp:include page="footer.jsp" />


</body>
</html>