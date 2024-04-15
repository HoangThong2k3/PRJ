<header class="header">
    <div class="container">
        <div class="row">
            <div class="col-lg-3">
                <div class="header__logo">
                    <a href="./"><img src="resources/images/logo.jpg" alt="Snack Shop logo"></a>
                </div>
            </div>
            <div class="col-lg-6">
                <nav class="header__menu">
                    <ul>
                        <li class="active"><a href="./home.jsp">Home</a></li>
                        <li><a href="./shop-grid.html">Shop</a></li>
                        <li><a href="#">Pages</a>
                            <ul class="header__menu__dropdown">
                                <li><a href="./shopping-cart.jsp">Shoping Cart</a></li>
                                <li><a href="./checkout.jsp">Check Out</a></li>
                            </ul>
                        </li>
                        <li><a href="./contact.jsp">Contact</a></li>
                    </ul>
                </nav>
            </div>
            <div class="col-lg-3">
                <div class="header__cart">
                    <div class="logo">
                        <img src="resources/images/${sessionScope.USER_INFO.getAvatar()}"  alt=""/>
                    </div>
                    <div>
                        <ul>
                            <li><a href="#"><i class="fa fa-shopping-bag fa-4"></i> <span>3</span></a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <div class="humberger__open">
            <i class="fa fa-bars"></i>
        </div>
    </div>
</header>