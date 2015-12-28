<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <title>Add outlet</title>

    <%@ include file="fragment/headerContent.jspf" %>
</head>

<body>

<div id="wrapper">

    <%@ include file="fragment/menu.jspf" %>

    <div id="page-wrapper">

        <div class="container-fluid">


            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">
                        Add outlet
                    </h1>
                    <ol class="breadcrumb">
                        <li>
                            <i class="fa fa-dashboard"></i> Admin
                        </li>
                        <li class="active">
                            <i class="fa fa-edit"></i> Add outlet
                        </li>
                    </ol>
                </div>
            </div>

            <div class="row">
                <div class="col-lg-6">

                    <form role="form">

                        <div class="form-group">
                            <input class="form-control" placeholder="Outlet name">
                        </div>

                        <div class="form-group">
                            <input class="form-control" placeholder="Outlet location">
                        </div>

                        <div class="form-group">
                            <input class="form-control" placeholder="Serial code" required>
                        </div>

                        <button type="submit" class="btn btn-default">Add outlet</button>
                        <br><br><br><br><br><br><br><br><br><br><br><br>
                    </form>

                </div>

            </div>

        </div>
    </div>
</div>

</body>

</html>
