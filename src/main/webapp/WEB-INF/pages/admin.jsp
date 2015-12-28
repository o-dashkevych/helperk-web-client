<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>Admin Page</title>

    <%@ include file="fragment/headerContent.jspf" %>

</head>
<div id="wrapper">

    <%@ include file="fragment/menu.jspf" %>
    <div id="page-wrapper">

        <div class="container-fluid">

            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">
                        Admin page
                        <small>Statistics Overview</small>
                    </h1>
                </div>
            </div>

            <div class="row">
                <div class="col-lg-6 col-md-6">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-3">
                                    <i class="fa fa-support fa-5x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div class="huge">26</div>
                                    <div>Your devices!</div>
                                </div>
                            </div>
                        </div>
                        <a href="#">
                            <div class="panel-footer">
                                <span class="pull-left">View Details</span>
                                <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                <div class="clearfix"></div>
                            </div>
                        </a>
                    </div>
                </div>
                <div class="col-lg-6 col-md-6">
                    <div class="panel panel-green">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-3">
                                    <i class="fa fa-tasks fa-5x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div class="huge">12</div>
                                    <div>Your outlets!</div>
                                </div>
                            </div>
                        </div>
                        <a href="#">
                            <div class="panel-footer">
                                <span class="pull-left">View Details</span>
                                <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                <div class="clearfix"></div>
                            </div>
                        </a>
                    </div>
                </div>
            </div>

            <div class="col-lg-12">
                <h2>Bordered with Striped Rows</h2>
                <div class="table-responsive">
                    <table class="table table-bordered table-hover table-striped">
                        <thead>
                        <tr>
                            <th>Page</th>
                            <th>Visits</th>
                            <th>% New Visits</th>
                            <th>Revenue</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>/index.html</td>
                            <td>1265</td>
                            <td>32.3%</td>
                            <td>$321.33</td>
                        </tr>
                        <tr>
                            <td>/about.html</td>
                            <td>261</td>
                            <td>33.3%</td>
                            <td>$234.12</td>
                        </tr>
                        <tr>
                            <td>/sales.html</td>
                            <td>665</td>
                            <td>21.3%</td>
                            <td>$16.34</td>
                        </tr>
                        <tr>
                            <td>/blog.html</td>
                            <td>9516</td>
                            <td>89.3%</td>
                            <td>$1644.43</td>
                        </tr>
                        <tr>
                            <td>/404.html</td>
                            <td>23</td>
                            <td>34.3%</td>
                            <td>$23.52</td>
                        </tr>
                        <tr>
                            <td>/services.html</td>
                            <td>421</td>
                            <td>60.3%</td>
                            <td>$724.32</td>
                        </tr>
                        <tr>
                            <td>/blog/post.html</td>
                            <td>1233</td>
                            <td>93.2%</td>
                            <td>$126.34</td>
                        </tr>
                        </tbody>
                    </table>
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
