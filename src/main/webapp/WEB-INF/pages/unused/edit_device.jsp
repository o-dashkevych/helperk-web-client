<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <title>Edit device</title>

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
                        Edit device
                    </h1>
                    <ol class="breadcrumb">
                        <li>
                            <i class="fa fa-dashboard"></i> Admin
                        </li>
                        <li class="active">
                            <i class="fa fa-edit"></i> Edit device
                        </li>
                    </ol>
                </div>
            </div>

            <div class="row">
                <div class="col-lg-6">

                    <form role="form">

                        <div class="form-group">
                            <label for="disabledSelect">Choose device to edit</label>
                            <select id="disabledSelect" class="form-control">
                                <option>Disabled select</option>
                            </select>
                        </div>

                        <div class="form-group">
                            <input class="form-control" placeholder="Device name">
                        </div>
                        <fieldset disabled>
                            <div class="form-group">
                                <input class="form-control" placeholder="Device MAC address">
                            </div>
                        </fieldset>

                        <button type="submit" class="btn btn-default">Edit</button>
                        <br><br><br><br><br><br><br><br><br><br><br><br>
                    </form>

                </div>

            </div>

        </div>
    </div>
</div>

</body>

</html>
