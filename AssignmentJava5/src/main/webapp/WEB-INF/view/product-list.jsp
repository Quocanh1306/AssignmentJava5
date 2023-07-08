<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>List Products</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="eCommerce HTML Template Free Download" name="keywords">
    <meta content="eCommerce HTML Template Free Download" name="description">

    <!-- Favicon -->
    <link href="img/favicon.ico" rel="icon">

    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400|Source+Code+Pro:700,900&display=swap"
          rel="stylesheet">

    <!-- CSS Libraries -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
    <link href="lib/slick/slick.css" rel="stylesheet">
    <link href="lib/slick/slick-theme.css" rel="stylesheet">

    <!-- Template Stylesheet -->
    <link href="css/style.css" rel="stylesheet">
</head>

<body>
<!-- Top bar Start -->
<div class="top-bar">
    <div class="container-fluid">
        <div class="row">
            <div class="col-sm-6">
                <i class="fa fa-envelope"></i>
                support@email.com
            </div>
            <div class="col-sm-6">
                <i class="fa fa-phone-alt"></i>
                +012-345-6789
            </div>
        </div>
    </div>
</div>
<!-- Top bar End -->

<!-- Nav Bar Start -->
<div class="nav">
    <div class="container-fluid">
        <nav class="navbar navbar-expand-md bg-dark navbar-dark">
            <a href="#" class="navbar-brand">MENU</a>
            <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse justify-content-between" id="navbarCollapse">
                <div class="navbar-nav mr-auto">
                    <a href="/phone" class="nav-item nav-link">Home</a>
                    <a href="/phone" class="nav-item nav-link active">Products</a>
                    <a href="product-detail.jsp" class="nav-item nav-link">Product Detail</a>
                    <c:if test="${u.getRole() == 1}">
                        <a href="/manager-phone" class="nav-item nav-link">Manager</a>
                    </c:if>
                    <a href="/cart" class="nav-item nav-link">Cart</a>
                    <a href="/account" class="nav-item nav-link">My Account</a>
                    <div class="nav-item dropdown">
                        <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">More Pages</a>
                        <div class="dropdown-menu">
                            <a href="wishlist.jsp" class="dropdown-item">Wishlist</a>
                            <a href="login.jsp" class="dropdown-item">Login & Register</a>
                            <a href="contact.jsp" class="dropdown-item">Contact Us</a>
                        </div>
                    </div>
                </div>
                <div class="navbar-nav ml-auto">
                    <div class="nav-item dropdown">
                        <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">${u.userName}</a>
                        <div class="dropdown-menu">
                            <a href="/login/logout" class="dropdown-item">Logout</a>
                            <a href="#" class="dropdown-item">Register</a>
                        </div>
                    </div>
                </div>
            </div>
        </nav>
    </div>
</div>
<!-- Nav Bar End -->

<!-- Bottom Bar Start -->
<div class="bottom-bar">
    <div class="container-fluid">
        <div class="row align-items-center">
            <div class="col-md-3">
                <div class="logo">
                    <a href="index.jsp">
                        <img src="img/logo.png" alt="Logo">
                    </a>
                </div>
            </div>
            <div class="col-md-6">
                <form action="">
                    <div class="search">
                        <input type="text" placeholder="Search" name="tenDienThoai" value="${param.tenDienThoai}">
                        <button type="submit"><i class="fa fa-search"></i></button>
                    </div>
                </form>
            </div>
            <div class="col-md-3">
                <div class="user">
                    <a href="wishlist.jsp" class="btn wishlist">
                        <i class="fa fa-heart"></i>
                        <span>(0)</span>
                    </a>
                    <a href="cart.jsp" class="btn cart">
                        <i class="fa fa-shopping-cart"></i>
                        <span>(0)</span>
                    </a>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Bottom Bar End -->

<!-- Breadcrumb Start -->
<div class="breadcrumb-wrap">
    <div class="container-fluid">
        <ul class="breadcrumb">
            <li class="breadcrumb-item"><a href="#">Home</a></li>
            <li class="breadcrumb-item"><a href="#">Products</a></li>
            <li class="breadcrumb-item active">Product List</li>
        </ul>
    </div>
</div>
<!-- Breadcrumb End -->

<!-- Product List Start -->
<div class="product-view">
<div class="container-fluid">
<div class="row">
<div class="col-lg-8">
<div class="row">
    <div class="col-md-12">
        <div class="product-view-top">
            <div class="row">
                <div class="col-md-4">
                    <div class="product-short">
                        <div class="dropdown">
                            <div class="dropdown-toggle" data-toggle="dropdown">Product short by</div>
                            <div class="dropdown-menu dropdown-menu-right">
                                <a href="/phone" class="dropdown-item">All</a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="product-short">
                        <div class="dropdown">
                            <div class="dropdown-toggle" data-toggle="dropdown">Ram</div>
                            <div class="dropdown-menu dropdown-menu-right">
                                <a href="?ram=${6}&tenDienThoai=${param.tenDienThoai}" class="dropdown-item">6GB</a>
                                <a href="?ram=${8}&tenDienThoai=${param.tenDienThoai}" class="dropdown-item">8GB</a>
                                <a href="?ram=${12}&tenDienThoai=${param.tenDienThoai}" class="dropdown-item">12GB</a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="product-price-range">
                        <div class="dropdown">
                            <div class="dropdown-toggle" data-toggle="dropdown">Product price range</div>
                            <div class="dropdown-menu dropdown-menu-right">
                                <a href="/phone/${0}/${20000}" class="dropdown-item">$0 to $100000</a>
                                <a href="/phone/${20000}/${100000}" class="dropdown-item">$$100000 to $200000</a>
                                <a href="/phone/${100000}/${300000}" class="dropdown-item">$200000 to $300000</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <c:if test="${page.isEmpty()}">
        <h2>Not Found Product</h2>
    </c:if>
    <c:forEach items="${page.getContent()}" var="dt">
        <div class="col-md-4">
            <div class="product-item">
                <div class="product-title">
                    <a href="#">${dt.tenDienThoai} ${dt.dungLuong} ${dt.ram}</a>
                    <div class="ratting">
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                    </div>
                </div>
                <div class="product-image">
                    <a href="/phone/detail/${dt.maDienThoai}">
                        <img src="${dt.anh}" alt="Product Image">
                    </a>
                    <div class="product-action">
                        <a href="/gio-hang/add/${dt.maDienThoai}"><i class="fa fa-cart-plus"></i></a>
                        <a href="#"><i class="fa fa-heart"></i></a>
                        <a href="/home/detail/${dt.maDienThoai}"><i class="fa fa-search"></i></a>
                    </div>
                </div>
                <div class="product-price">
                    <h3><span>$</span>${dt.donGia}</h3>
                    <a class="btn" href="/cart/add/${dt.maDienThoai}"><i class="fa fa-shopping-cart"></i>Buy Now</a>
                </div>
            </div>
        </div>
    </c:forEach>
</div>

<!-- Pagination Start -->
<div class="col-md-12">
<nav aria-label="Page navigation example">
<ul class="pagination justify-content-center">
<c:if test="${page.getNumber() + 1 > 1}">
    <li class="page-item">
    <a class="page-link" href="?page=${page.getNumber()}&tenSanPham=${param.tenSanPham}">Previous</a>
    </li>
</c:if>
    <c:forEach begin="1" end="${page.getTotalPages()}" var="i">
        <li class="page-item"><a class="page-link" href="?page=${i}">${i}</a></li>
    </c:forEach>
<c:if test="${page.getNumber() + 1 lt page.getTotalPages()}">
    <li class="page-item">
    <a class="page-link" href="?page=${page.getNumber() + 2}&tenSanPham=${param.tenSanPham}">Next</a>
    </li>
</c:if>
    </ul>
    </nav>
    </div>
    <!-- Pagination Start -->
    </div>

    <!-- Side Bar Start -->
    <div class="col-lg-4 sidebar">
    <div class="sidebar-widget category">
    <h2 class="title">Category</h2>
    <nav class="navbar bg-light">
    <ul class="navbar-nav">
    <li class="nav-item">
    <a class="nav-link" href="#"><i class="fa fa-mobile-alt"></i>Iphone</a>
    </li>
    <li class="nav-item">
    <a class="nav-link" href="#"><i class="fa fa-mobile-alt"></i>SamSung</a>
    </li>
    <li class="nav-item">
    <a class="nav-link" href="#"><i class="fa fa-mobile-alt"></i>Xiaomi</a>
    </li>
    <li class="nav-item">
    <a class="nav-link" href="#"><i class="fa fa-mobile-alt"></i>Oppo</a>
    </li>
    <li class="nav-item">
    <a class="nav-link" href="#"><i class="fa "></i>Others</a>
    </li>
    </ul>
    </nav>
    </div>

    <div class="sidebar-widget widget-slider">
    <div class="sidebar-slider normal-slider">
    <c:forEach items="${danhSachDienThoai}" var="dt">
        <div class="product-item">
            <div class="product-title">
                <a href="#">${dt.tenDienThoai} ${dt.dungLuong}GB ${dt.ram}G</a>
                <div class="ratting">
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                </div>
            </div>
            <div class="product-image">
                <a href="product-detail.jsp">
                    <img src="${dt.anh}" alt="Product Image">
                </a>
                <div class="product-action">
                    <a href="#"><i class="fa fa-cart-plus"></i></a>
                    <a href="#"><i class="fa fa-heart"></i></a>
                    <a href="#"><i class="fa fa-search"></i></a>
                </div>
            </div>
            <div class="product-price">
                <h3><span>$</span>${dt.donGia}</h3>
                <a class="btn" href=""><i class="fa fa-shopping-cart"></i>Buy Now</a>
            </div>
        </div>
    </c:forEach>


    </div>

<%--    <div class="sidebar-widget brands">--%>
<%--    <h2 class="title">Our Brands</h2>--%>
<%--    <ul>--%>
<%--    <li><a href="#">Nulla </a><span>(45)</span></li>--%>
<%--    <li><a href="#">Curabitur </a><span>(34)</span></li>--%>
<%--    <li><a href="#">Nunc </a><span>(67)</span></li>--%>
<%--    <li><a href="#">Ullamcorper</a><span>(74)</span></li>--%>
<%--    <li><a href="#">Fusce </a><span>(89)</span></li>--%>
<%--    <li><a href="#">Sagittis</a><span>(28)</span></li>--%>
<%--    </ul>--%>
<%--    </div>--%>

    <div class="sidebar-widget tag">
    <h2 class="title">Tags Cloud</h2>
    <a href="#">Lorem ipsum</a>
    <a href="#">Vivamus</a>
    <a href="#">Phasellus</a>
    <a href="#">pulvinar</a>
    <a href="#">Curabitur</a>
    <a href="#">Fusce</a>
    <a href="#">Sem quis</a>
    <a href="#">Mollis metus</a>
    <a href="#">Sit amet</a>
    <a href="#">Vel posuere</a>
    <a href="#">orci luctus</a>
    <a href="#">Nam lorem</a>
    </div>
    </div>
    <!-- Side Bar End -->
    </div>
    </div>
    </div>
    <!-- Product List End -->

    <!-- Brand Start -->
    <div class="brand">
    <div class="container-fluid">
    <div class="brand-slider">
    <div class="brand-item"><img src="data:image/png;base64,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" width="100px" alt=""></div>
    <div class="brand-item"><img src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAASwAAACoCAMAAABt9SM9AAAAdVBMVEX///8AAAC/v7/09PSioqLS0tIwMDD6+vrl5eV7e3vx8fF4eHjLy8tQUFBGRkarq6vY2NiOjo7e3t6EhIS3t7cXFxcMDAyampo+Pj5hYWHb29uwsLDs7OwgICCgoKBXV1dsbGwsLCyJiYm8vLxlZWU3NzckJCSrYnspAAAE5klEQVR4nO2d13KrQAyGg4MDbsENN1xTzvs/4okhTgyIErMrrTT67pmR/lkWrcry9KQoiqIoiqIoimKTPbUBTJj724Pn7ajNYMB04WX0qS1xnuTi3RhT2+I4vneHilVHz8sxpbbHYYaTvFZeSG2Ruyy9ItQWucuopFVMbZKzvJa08rbUNrnKS1krb01tlKNAWunHEKb4GdT9vZoFqNWA2iwneQe10pMhxBDW6oXaLicBgoYrS2q7XKQcuKesqO1yElgrr0dtl4usYa1eqe1ykoqFpfl3gCOslU9tl5PEoFYTarOcpA8vLGqz3GQAaqUZUhBQKz3ngISQVhphwUSqVXvKeXetFVZSTvrNqU1yl1VBqteA2iKHKWilcXsdOalOQ2pz3OZeKq3lNPAj1ZsG7Y0cPO8wWUT6CUwJ5j1/NjiPZlH/ue0zu2gwyYqum8nAH7d+jjXD5SCfgBkljVt4fw2UL0aJdMEisGizWdekQPtAQH8LwCI8y7GZV7vtvfjgOpnOqh/J1pfMnS08Nfh9ei88sV9fGh5JH5P3yQxqVtUv59/kQuiDPTQQ0tofKmqm0EI5ToNgvGitVIqopMTHn1x/gAW1h8YIi2kEC2yonTTE2L5UX8QiDtwJilZfCIhRoYS6HVbsc4QV/XtW+KR2tiMVtWVLnKnd7URFr6M1WJ8V/xZadmZG7W8X3lClilmfqaeoWp2p3e3GAVMr1ttVZfueHZgfpQNMrbhXzODRG9UKAnNhse9HakqeG4T/uCaeVidqVzuDeIBmn2yoGuqyAP85sWc0rQTkk/1mLw0hoON7i6WVgIWF9y1kH2JhJkipPTUA2pYlobhqvQJ9g3myIQVLKwlvIZpYEr6Fcyyx3qg9NUCv2U0z8D/qIJbsJezvaLks1sWvb1q1RJpAQpsRmljUjprgrGK1By3nQO2oCdDE4p9RRhRLwkU+aOdoCffoo23wEoJStNAhofbUAPDFOxaQkPtDO+5IuIgTrxBG7akB0FI0EnZ4vGbSEbWr3cEr3kt4D/HEKo4KM+SCJpaAkgVaCC+hMQQvdhBwgzDO8GoG+9YQ1Gkwamc7gzmJcqZ2titoeYcr3MMHvMnoK8wvWNmjisV98B5XrJh35QIt/ydBLcxIK4VzoQd12jCF87kHrRz2A+PhMLQraH555dtUgy+W5x2pnX6Upiv+rBAzrSTiVS3y8Dz8EInFM2WDOX5/B7XbjwH+5MQ6XCv6GwqxuDYwU2zxfG9nIxCL7/09qFf3ZFC73AF0rThPPiHesZLBOWWKnajh3VSDvLQ4ZwCxlxbvhYXa9cB7x0pB1IrzpzADMYyndtUA5b8VWoJp3i8HVnGa76nwnor/2JuGa7qhAMp11Px39wyMLGBM7aQxEBqQJEwefmO9LMa4Gl3C9qmHf8vyPZavauNbtwexGj8ImA3LYzGQ51r9qsHaD8MEjO+UsBZtse6QrMJS56SQY04RK7GpuM39hoWMPN+iaiPGG2skRe4lDP/jSbRWLQoY23XS6+92/V4yazxRSrhMspa6nPw2KRT+Qr/ujwWcO99bsr9UKAX3Nz5HFbnDE/vCVyuAc2J8rHF9B00v8mwdfYBh/qu4mjX+kamXH5z6FL9b3RMsv3fvw0fScrRynow+r+fLf9uI+TDmIwRhyLuRQ1EURVEURTHCf8eYSCcC+BLCAAAAAElFTkSuQmCC" width="100px" alt=""></div>
    <div class="brand-item"><img src="data:image/png;base64,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" width="100px" alt=""></div>
    <div class="brand-item"><img src="data:image/png;base64,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" width="100px" alt=""></div>
    <div class="brand-item"><img src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAN8AAADiCAMAAAD5w+JtAAAA0lBMVEX////PCiwjJScAAADLAADPACnNABnOACXNAB3OACPOACDOACYYGh0AAAXNABUfISNvcHHBwcLOz8/Hx8dZWlvj4+PMAAzpqq82ODkWGBshIyX29vYACAzMAApJSkt8fX7mnaT119r56Or88/TyzNDij5aUlZbr7Ozdb3rYVmTRHTftuL3SJz733+LiiZLTNEjfeoTXTFzvwcbbZXHqrrT77u/lmaDTMEXjjZXVQlPz0NTZW2nedH+qqqt4eXmztLQuLzFeX2CIiYpOT1CQkJGenp/ea1dVAAAVe0lEQVR4nO1de1vaShMnkoSbhlZPg6A5RcFWQRTFG+pp7enp9/9Kb5K9ZPaWnQ2Kvs/D768Ws8nO7txnNqnV3gzH13enl6eWi468xcn06O0m8TY4vn64SpKo2Qr8cfmVk06jHcX+/fxmtp6prY7r54YfNTtejmBSem0vope1oyRa3IzWNMXqOHpOonbgFYinZZe34KWtyL8qvfrdMV76bU9EcF5yPds+jkbUGq5rss44vvI7noKkRAIngXJ5ELU/6B6e+A2VunRLzowjxrFuQBAvb9c4bSRuL2VeY/CPTWPOWvoRLf/DbeFjrN28DM0Tw5hb3zTE8+drnb0VU1+VJM5vgWHQMDSO8aKntc7fgql5J1Ikj/pR5+Y18bzQLLZrx3UpeV5bz2yz8lHhh9lBy0S9oKkddtcsHxZ9FBlslfFZBj2DlrJnhg+iRc9kl0VB80Ez7Niy616ZZVkjbhLrPLU+Wq9Ee1I0lmunRsFI64PIG6FxSJ4Mxh0i7q2fIAnPVu5MEd2oA+3smQ1cP0EiEFKUoqWG8Y+YffeaF+9AE8QpZvvS8FUZaLMOFP77hrwlLqQ4TUUTXhn9VQHh3XuQxXFnV4I5VAFELkzQeQ+yODQBqhaKi3aEEr8UsSVB9aaweWbFNsgWEGH9DCuzTpRFOCJkPXGKsH5kZVTVtD5gbDRBLLmgWMZOV+YdE6M4HZ8hHAoDR1jGTlXT+3nZWOvgKRYeZ91zvKOJd5ilpGDQ6iVdmcUbU2FO1k1NKTMNfGHkHOX25OiUBBGvET8tPOOfHHbBSwQ1sdQkgg0oSYDfvUKA+Bw1jYkQpA+ZQ1QT9pixoM+4vmO/01w1E/yQilhs8gFd6BOyoLiog9JnSi/epovUCVbzv3v5RExFPBf6BDUxdhBc4/6dZzzeKCvfWDEm6xxE+lVyoS+4BwNdBNdUQVyQh7dXyGEcMzFpXOrpc5iml4CBF3j1adKfPTa38LkyfROu5UKtl+uyDUIOBu/XmepPwLP3qyZpnsAqa3OR1w5iJHigeO8zZUDt/gTgDn61/oSh4J3oTI2D/yIaCAf1qS8/CTnXoFWFPCm262gUlYP/mc7zrto4Xe5NXHqvXaUWI/OQTo5d9g8EqujgPYMcWWXj5fVJ3EVwrugOjQg6uFlQT7j4rbrccEcRX10CuRTKEmlv4uAmQz8SH/anUItPT+pTW65WUKfhOvfyVU4bUeSiLxz8AtU89HTcnWiktARD7cQVK+jiR4IUDDr54mnUpz6nFYQu5JnSB4oj6jkYsoRbmCsHsY3kRxpsp1OYbyqaKI4oLj1PUChCF/PuS1M7NfG2QyxoZrvWlXiliwBG12yUg3mQvU9zqb9ta8UssDDLRzwUrnSx1CE3Ug6DmmLsWVZtRG9gqdaQ0pH3eFHiU3XRSonoWy5LNJPeUdWg1KpJ4ZhDCNhmGsDBfZHKK3el4oCspVlyr6KRQFcgQApU31anRdvlYchami2qE40EXhe2WJ7KIawSO0sszzJnogTcW2YstuucoBmUq8IbtHsWNOCjVJdYgqkRTICd49pPTpfzyTLJxbufgtEe2yeGqaUhNIbg7F2iNSirdOG3XFDWbaskoAJdTMyTAE2FT8LEdAQ6uyTk3BaIUYm9loaqXEE3Bl/qYq4W2r0OQdha3oKpGWAALvUKG4vQ02X2qcQ90g+oIdukdH02MpDCD5yhR2wxgcXHZ7jWEMGjNLVqi7CcJsl3AyccsPXN2uhIwQIkbFYD5P0QTXxkiJU+7MOjIR+inNIwIKbSf4lbD5AuGGFZJLH62OiIFXAolj66H0iXByRMr7ASG1tTvWht3ylqEsh8Cgtw1fSXDsBNukE7rEWMuTJ9gEORUSBLNeBWo/CW0dz5uvQBDsVpfPZwHDsXxgHNnRj6rM3iBQodinNC2cNR3Fb4klOHYrYm2S3BFj0Id+NWHtXtyBQGajE4c+AsO5uRVb/gDCmbBMtojzFr7EJfUc52qRUi8vQuKXfgh2KiCFYJwtDHIwfL2RgJiYYiEU41WS9hNuoawUXU+z1AzLjFs/JNB3mBNsuEIwdpzhK+B3Qcwkmj9GECDu6aGdO5WmACXBdxTu/I5ASxgXj6GozvH524E9VriI5eCHi2yb6BePr49rlk8j1chtCp5gXai+wbiKaPb9+DkzLwOldaiiQ4CWA6a5YDsm4gmj62fU7lN09fqlfhZCG8QpVf2xYGSx9Xni7l7wyxniAJDinpHFwp22wglj62YNpCbQmwJUAnjyFFRN00W4ISSR9zXZwcswzYszyubO/F9MbLci80vEHRxzxPl9ppfnvdKUot5k5GtTCCuqYLAJx/xmy0o+kznfLVwskp8gojWM7ZOP+acZmj6XM6revm1BZ5uXLORtEX0n6J8lKfirbTcXJrqUaeOk0mlHI2i2/L7Ajr83A4AELGNfSEmHDpqEMpV5WmSjD5CaaLXXW46ymekUOeIgMrXpa19LL8UskljNHttTARZcKnp/w4dnRt6eQD8zCWHClZOp9usatfra9M347zpZpr7eLMjUC28lOzVWbJEXMKmTnW+vYwI3z9G1ge/Ox2F822/u/HAbIOQsDSoWYvjdFndsSpFDkqF3+om/4wCvNyRPa0UFs4G02chJwWPc1GnlUfjW4z62DBlDIBeTrZm3pRkEsEWasg8nRXXbo4MqycZZydtX4U21ZIg8DXpHTH90S4wiHvEQ/iS80plTOnTtujcu6y1f/sHK6iE6kZzxl/j1frGTRrdPwrVZXOHdaSBUomG2Gp3zINha+mpDwzURKet6fFe7yCy9oD4KaWf6pc3it5s5IM9q46g4K01N+ZhbH3SXBEakLiQnjDXCA9rO0rMeJRE61lmJNkcF9ZeK1PEDAP4QLvGqqT7UWSxlB6aZuRrEpHS7QQMudYX/FhAYy+XEilE99x2VE0y3WuNAWoxeJUlcrjLtA8SkVMG0fw4r+2g4gtDTo9GZ5LsnR0majTrE00E0kuJaV0HSGfymyELrHH8zS6EgDrjUPbBvkNcMdPupcfejXt4I7/JBbq0TzK/HiNG8qzk7r+OsZrSNvQiiUem/v6HdDTl6lSySu9w/Eoq3lqVAzvj9RkkFlKEFnLjJbi5IaxyRHR8SdBU2q1nk1Qio1thFpHLPpbVfqY6Ud1b3QkhzP1xYzXljWjRIHos80xW8iO4ah6sKQ/mYX/qLghOhfcEK1a4Sg9a5H6bIKiefQQ/ijLkikJFH4SZSYzIdesinpX0RGDnduFVq1wWLrjUkUjaGHEFvImTOWAHeMqZWt9Gvgi+mikzbswqBWO2oklFmmJTsKjXQpZ44qcwOTVD9kBZ2GR3bRLm9cLrQuCaIaWPJqLcoZIEdOarpSALnpTRP7kR6OsCevoElqt8bmVnVOThDhDG0QTaG1m9xYtwOscofD84k1K4qqzGr6trtMSDkofnyG0XXuOywUEYujUs3A90/aiNSt6U4QEBe/BKE8JBv4TsHkHJnsuIqt44Lo3G/4zuP3oqXTx+EkZwc/29efj2GKUe2ZhAFnIbM9FZBkRbDmznQwh83tlcstIETRGUb6CPjTv0itrgWoISu56gg1osnYY/GkSMbA4KeEQ3n0EDXbRewOWlDexlmR0g2QJ9MrsCh3NEI8Qn4FIHwTEsEzCebq88JfB4YSHZtmFMsIWcKNGc/1bxLUgFsmlIUQUw2uj48dL6IVSDIreoqKHnTcnGIv3ov3tIQWPgEgEprWqgCiGd8r79NmtmbI8YUugO/9e9LsbzhEG/hlgzTFa8HKwgAXXL8wRTUAicWTw/3gLC3fTwNkELvJ8FQxrLDwKZfEgWIzodNzey60hWNSjS22hgk+d6f12wWcsgCiOEmqNlBihWV1NZZqcOUK3dZGFYtrRLFCxgTQhBt5gR9+bU5zX022fGGFP246bAJvRHMs1GZoh7BW6S1Qx9KXj4KC5iPpMxRXq9nUEwTPwSCngWZaG82gpNhyp/lKxgYRDYet3vl1Nzp3K9gXxPWikHp1aXXoNEvA8lxZujo5/ChgolX5pEsXxmpxDYWt0tqPgNKm8fWEHJg56sWMjTA7x3dkOLfgAoq14lJio2MCcHng8PasgFdwpbZ+oVh7P3YUng3ga3umNOgCCAqdFt+IRfMcyDoVHn1KXAhzDFmxf27+AjvzC0SbwiUklW+wBLRmBv4Cpul4I1FzRRJ1xKHxV90UbSD90XaQKz9DkPtigvtBs4diTBaYkFPfvEo1zmYpYC76/aRiCs29FuTNVmjDMdHRXAIJYPSdw7lRthxCZdFRUqMA7+WY+LGXd+EUvHE/TdPwlPH1SmTU9/QsFR65NZwUkJr19ZsYCCPm1MHcgHTTuS02CMKnKrOmZGg5mZXlSC9riLY8XhEJEvz4xjkEspHhqRxW1Zo7Y0Oc6q84QWWJSSAXPnnIK7S2nWXSmdDecrjKT2Lios7iCn8AQ+OL7SWZnaSRqbRk+9lPqArEv/Caqzpq6oi54mlfJzlO0peMVR1d+y3YgaN6MOmLB+Hjp7mtC8oalz8PXojUQEyWEQkvXadCSyuEPDvkHFWrNWga+Fq1DQ+50s51nPhD/+1ialrMiPLe/o2jcqmrpc0STFb6muZJeSTcPd0DAJUWlIqj8bbRpuIpeCSQNXoKZ9kOFaDRb1lO+Goxc0ysSdW2Xd0g+qh+adHmY6M+gcJOsoLpbcTB0fN5sHmGbQjRoh25beHvlelgFEBf5T1UYpnZ9GiWhYx82g1juscFWkDI+pRXG8dMKn5U9Gi4mfhJFYRODEMLHvc2KkBeFDogI4sSfLIaYV0pZMBvfDO9OSnHHMMzRy4D/MMyoh8dNjul0ej3+v/ni8QYbbPAaGN0ez44ex9fTac9J+jN18Xg0O759/y+Ij0bHs9nROKXhpje8e7iYny6erpb3k0bsZ0iSOM60t486q00x9VN1H8dJQm7Rntwvr54Wp/OLh7th7yalffw4e0XiR8U2ZJbhYj4/fTpbXp57ISWB0hCmZrHdbrVajU4gNXz6bl93HYoObxB0Gult2+3Mpua2jhMfBec58c+A+KOU+JGTO+EXJFAaGp1OydEpCQ3f7XXUaZx4jg38AkJ8GxKfZMQ7fMnD9eC5hKjKB8BXC6zdTgA6n6CG6BhOq9nwGKwSWIdOn7k6qZ6GkToYXbBC+I54M58Ah/cii8/x0afQNbhuVo06Xb/hUZFDw+qbR1Cx6CCXw+xAvW9TQmelzSOotIXya9UxmDuL4AqSB+G+hUHrwH5bBUu3hVRSn5Uxbjgq0oqfeHQ6nhovX/Fj33On/J01Z23AyMO/Gjl2dVjK4VIfq/x9p9oIeYK6Sj7QhiE25WQpqJQCd4I6mrxCkkd9dnkPNCdvtU+oL61ur9gE85pA9BcELm9F0eK03A6KDa+vDVs7a6u5QjGH4qZEELRHrl8VpecA4qvXWNvbK0PjQSe5f/uPX98uTBS2VxS9AlP13G7Kmcl9RbvjiNlCV+tpCd19q6I3ETs8g6Z/tb4Plx/PfbEFtxP6p68sGOOs2NJudIJOqx0mnYtX9FYQGA3P/bCVZXmCVjPyL4dvodSOevOz5f3ybO6W+3slzHqnSy/wLp8epqt+9HaDDTbYYIMNNthggw022GCDDTbYYIMN0Ng93Mqw80X+w1/d7Pfup+KX3y/7KV6+yld+Jreo66rE+/mf+sKf/tnK7rO/9Y907cFOdu3hrvTzXje/fPCT/I8M1kKZUUZffZChrtK3nf3eB/T9vd1N0f+h0LdDbqGhb4/c/fCPQEc9u093+2/p4p+H+bX/ST//6OeX09vvkcE6bCszyujbIaRq6Mt+34b05Tvad9m/3/mQrUFXc+ut+nfpifnFg4F0j8MBnMgema8G4CFw/96Svi91+uydz/Dnn2TAocigB/RiaSq7deEOH4q+H3367K7Ai5SS7l/CxZTqrb7IoP/2+Vw/Gn1sR7I/Clrj07ZmBOXarcGWcJN+zp5c6hl9GvED8rce+r6x7RPvk8l//uPhT+1iCHOh7FnfE+nr/q3BuukjmoFOWlAmZNLbv8BPjD3TJ3wDPxP2HByy/1P66rUyrIc+OmOiQkWpooIJhzD2lBh0QNjz3w9I3z7xEMiwrR34pz2ygYeFWgWyCidDNXAhvh+HPiI5gz5lRtEaiEatBtlTYFAiwkA1fhz6yA3SuX7N59h9gX+UtH6t9ouzp3DpS1di7g9DH+OsA/6vPfBXyWoz9hx0xdmwocXsPgx9ZNfy8eRW3d/wz13CoMysEfbc/vqJbTrBH2Xrq9L3Xb6GeIOV6TsAimFP2YVa7T+RQQl77uyRe3GCiIrqA/ec0tf/BiFHIip9W/1DCYRTKtP3h0yUxCxUimDkQTlvZ09YDf6PL/AiuDDMf+kD7EA7aqDPgMr0EbeKeij/aK54gXcj7JktwC/IoHSRoPOq8z9F52gt9P3Mb8vdDrIPgmPyBzomhKqMmQUGJU8ULMsHoY8KDiNI9rJSfAcCesBMJV+KnCXZJVA3fAz6duviT3SmgkNNb5d5XpQ9cycMaFDC1qLe/Rj0/ZKNC/mhuw+GkdkPtmuQPRkB+ZUk+hcWhdNXhxADSS19dRlG/anmXxT6vit6b1f2I6EFoexJExPcIB/U5fsW9NW/C7DSp7Hviv37rfxC8LO4GwUVt5cvuxx0uaAm/4v5XpQ9qRNGHIPU5lGbLyr/N/RfPqk8luOb7EuyWGCwU4DyO3wOmX8aDVH2pH8iW50+hsxAZM+3pE/xiSkU2foDYgEJUHo5gxKJe2G/E9NZZ8ZdfNgb0kettJgLq/FgvJDLLojbZahaaCA7YZS79+UQ6q3pozpC1Nec7MIKfy5TyTDVS6cxkGZAn0N+3tkTn/aG9NWYqhUk4uBQnh8N2PUQUr0gZodivQX2Xwj735i+rzQfJmj5/W1pfmz5d2TQDQHs/aMIaqETBvJuirV9S/p4Orr+L5Oin306xR2+qUTNDl5290Tskm2B3jJwRqAT9qXY17pSbXlD+ookQr/++98//3z7dMhSgF2e82KumByTcbUKp8wziKJQ7zMOJy6phr7tryp+FBqgIn3fi4XtpgFjv2CvYtImK8LtAbwl43hpOf6wn4u8oETf1nZfwQ7n5ar01X4CjQBRLxJAdcPEakXWs2DFXc7xghPG11Fhz5L6A3hmZfpqf7QE1gstwEJZJd9R43IFU73UVEpOGFPBUiliDfTVPte35ftu14FN29JaZQpaDgS8S9MwkhPGVkkIiNdDX+37p3of2KdBqmrA2M9qnAAXh9ZVCmH7oosRdAHI2uhLH/5tnxM42P9PGPk3zclryavVXoiJAGyXq0r1KXlsobryrvT9DxFEMFK5z48iAAAAAElFTkSuQmCC" width="100px" alt=""></div>
    </div>
    </div>
    </div>
    <!-- Brand End -->

    <!-- Footer Start -->
    <div class="footer">
    <div class="container-fluid">
    <div class="row">
    <div class="col-lg-3 col-md-6">
    <div class="footer-widget">
    <h2>Get in Touch</h2>
    <div class="contact-info">
    <p><i class="fa fa-map-marker"></i>123 E Store, Los Angeles, USA</p>
    <p><i class="fa fa-envelope"></i>email@example.com</p>
    <p><i class="fa fa-phone"></i>+123-456-7890</p>
    </div>
    </div>
    </div>

    <div class="col-lg-3 col-md-6">
    <div class="footer-widget">
    <h2>Follow Us</h2>
    <div class="contact-info">
    <div class="social">
    <a href=""><i class="fab fa-twitter"></i></a>
    <a href=""><i class="fab fa-facebook-f"></i></a>
    <a href=""><i class="fab fa-linkedin-in"></i></a>
    <a href=""><i class="fab fa-instagram"></i></a>
    <a href=""><i class="fab fa-youtube"></i></a>
    </div>
    </div>
    </div>
    </div>

    <div class="col-lg-3 col-md-6">
    <div class="footer-widget">
    <h2>Company Info</h2>
    <ul>
    <li><a href="#">About Us</a></li>
    <li><a href="#">Privacy Policy</a></li>
    <li><a href="#">Terms & Condition</a></li>
    </ul>
    </div>
    </div>

    <div class="col-lg-3 col-md-6">
    <div class="footer-widget">
    <h2>Purchase Info</h2>
    <ul>
    <li><a href="#">Pyament Policy</a></li>
    <li><a href="#">Shipping Policy</a></li>
    <li><a href="#">Return Policy</a></li>
    </ul>
    </div>
    </div>
    </div>

    <div class="row payment align-items-center">
    <div class="col-md-6">
    <div class="payment-method">
    <h2>We Accept:</h2>
    <img src="img/payment-method.png" alt="Payment Method" />
    </div>
    </div>
    <div class="col-md-6">
    <div class="payment-security">
    <h2>Secured By:</h2>
    <img src="img/godaddy.svg" alt="Payment Security" />
    <img src="img/norton.svg" alt="Payment Security" />
    <img src="img/ssl.svg" alt="Payment Security" />
    </div>
    </div>
    </div>
    </div>
    </div>
    <!-- Footer End -->

    <!-- Footer Bottom Start -->
    <div class="footer-bottom">
    <div class="container">
    <div class="row">
    <div class="col-md-6 copyright">
    <p>Copyright &copy; <a href="https://htmlcodex.com">HTML Codex</a>. All Rights Reserved</p>
    </div>

    <div class="col-md-6 template-by">
    <p>Template By <a href="https://htmlcodex.com">HTML Codex</a></p>
    </div>
    </div>
    </div>
    </div>
    <!-- Footer Bottom End -->

    <!-- Back to Top -->
    <a href="#" class="back-to-top"><i class="fa fa-chevron-up"></i></a>


    <!-- JavaScript Libraries -->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
    <script src="lib/easing/easing.min.js"></script>
    <script src="lib/slick/slick.min.js"></script>

    <!-- Template Javascript -->
    <script src="../js/main.js"></script>
    </body>
    </html>
