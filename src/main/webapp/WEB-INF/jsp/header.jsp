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
						<div class="shop-menu pull-left">
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
								<li><a href="#"><span>Hi Nitin!</span>
								</a>
									<ul>
									<%-- <li><a href="#">${cookie.userId}</a></li> --%>
										<li><a href="#">Recommendations</a></li>
										<li><a href="#">Reviews and Ratings</a></li>
										<li><a href="#">Bluefishes</a></li>
										<li><a href="#">Tigerfishes</a></li>
										<li><a href="#">Tigerfishes</a></li>
										<li><a href="#">Tigerfishes</a></li>
									</ul>
								</li>
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
							<a href="index.html"><img src="${context}/images/home/logo.png" alt="" />
							</a>
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
					<!-- <div class="col-sm-9"> -->
					<!-- <div class="navbar-header">
							<button type="button" class="navbar-toggle"
								data-toggle="collapse" data-target=".navbar-collapse">
								<span class="sr-only">Toggle navigation</span> <span
									class="icon-bar"></span> <span class="icon-bar"></span> <span
									class="icon-bar"></span>
							</button>
						</div> -->
					<jsp:include page="menu.jsp"></jsp:include>
					<!-- </div> -->
					<!-- <div class="col-sm-3">
						<div class="search_box pull-right">
							<input type="text" placeholder="Search" />
						</div>
					</div> -->
				</div>
			</div>
		</div>
		<!--/header-bottom-->
	</header>
	<!--/header-->