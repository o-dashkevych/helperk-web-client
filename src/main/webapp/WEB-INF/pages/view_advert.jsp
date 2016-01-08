<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${advert.titleName}</title>
    <%@ include file="fragment/header.jspf" %>
</head>
<body>
<!-- Navigation -->
<%@ include file="fragment/header_user.jspf" %>
<div class="container">
    <div id="row">

        <div id="col-lg-9">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">${advert.titleName}</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-9">

                    <div class="row">
                        <div class="col-lg-6">
                            <dl>
                                <h3>${advert.titleName}</h3>
                                <dt>Description</dt>
                                <dd>${advert.description}</dd>
                                <dt>Category</dt>
                                <dd>${advert.type.name}</dd>
                            </dl>
                            <dl class="dl-horizontal">
                                <dt>Price</dt>
                                <dd>${advert.price}</dd>
                                <dt>Creator</dt>
                                <dd>${advert.creator.email}</dd>
                            </dl>
                            <form action="/advert/view/execute">
                                <input type="hidden" name="id" value="${advert.id}">
                                <input type="submit" class="btn btn-primary btn-lg" value="Execute">
                            </form>
                            <br>
                            ${message}
                        </div>
                    </div>
                    <!-- /.row (nested) -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
        </div>
        <!-- /#page-wrapper -->

    </div>
</div>

<!-- /#wrapper -->

<div class="container">

    <hr>

    <!-- Footer -->
    <footer>
        <div class="row">
            <div class="col-lg-12">
                <p>Copyright &copy; Helperk 2015</p>
            </div>
        </div>
    </footer>

</div>


<!-- jQuery -->
<script src="${pageContext.request.contextPath}/resources/bower_components/jquery/dist/jquery.min.js"></script>

<script src="${pageContext.request.contextPath}/resources/bower_components/jquery/dist/jquery.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="${pageContext.request.contextPath}/resources/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

<script src="${pageContext.request.contextPath}/resources/bower_components/bootstrap/dist/js/bootstrap.js"></script>

<!-- Metis Menu Plugin JavaScript -->
<script src="${pageContext.request.contextPath}/resources/bower_components/metisMenu/dist/metisMenu.min.js"></script>

<!-- Custom Theme JavaScript -->
<script src="${pageContext.request.contextPath}/resources/dist/js/sb-admin-2.js"></script>

<script type="text/javascript"
        src="${pageContext.request.contextPath}/resources/datepicker/js/bootstrap-datepicker.js"></script>

</body>
</html>
