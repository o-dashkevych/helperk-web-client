<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <title>View devices</title>

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
                        Devices list
                    </h1>
                    <ol class="breadcrumb">
                        <li>
                            <i class="fa fa-dashboard"></i> Admin
                        </li>
                        <li class="active">
                            <i class="fa fa-table"></i> Devices
                        </li>
                    </ol>
                </div>
            </div>

            <div class="row">
                <div class="col-lg-12">
                    <h2>My devices</h2>
                    <div class="table-responsive">
                        <table class="table table-hover table-striped">
                            <thead>
                            <tr>
                                <th>Name</th>
                                <th>MAC address</th>
                                <th>Edit</th>
                                <th>Remove</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <td>/index.html</td>
                                <td>1265</td>
                                <td>
                                    <button type="submit" class="btn btn-default">Edit</button>
                                </td>
                                <td>
                                    <button type="submit" class="btn btn-default">Remove</button>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</div>


</body>

</html>
