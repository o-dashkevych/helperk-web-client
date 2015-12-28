<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>My Charts</title>
    <%@ include file="fragment/headerContent.jspf" %>

</head>

<body>

<div id="wrapper">

    <%@ include file="fragment/menu.jspf" %>

    <div id="page-wrapper">

        <div class="container-fluid">

            <!-- Page Heading -->
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">
                        Charts
                    </h1>
                    <ol class="breadcrumb">
                        <li>
                            <i class="fa fa-dashboard"></i> Admin
                        </li>
                        <li class="active">
                            <i class="fa fa-bar-chart-o"></i>Charts
                        </li>
                    </ol>
                </div>
            </div>

            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <h3 class="panel-title"><i class="fa fa-long-arrow-right"></i> Total outlets using</h3>
                        </div>
                        <div class="panel-body">
                            <div class="flot-chart">
                                <div class="flot-chart-content" id="flot-bar-chart"></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-green">
                        <div class="panel-heading">
                            <h3 class="panel-title"><i class="fa fa-bar-chart-o"></i> Basic outlet using statistic</h3>
                        </div>
                        <div class="panel-body">
                            <div id="morris-area-chart"></div>
                        </div>
                    </div>
                </div>
            </div>

        </div>

    </div>

</div>

<script src="/resources/js/plugins/morris/raphael.min.js"></script>
<script src="/resources/js/plugins/morris/morris.min.js"></script>
<script src="/resources/js/plugins/morris/morris-data.js"></script>

</body>

</html>
