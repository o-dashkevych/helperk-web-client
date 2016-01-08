<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add advert</title>
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
                    <h1 class="page-header">Add advert</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-9">

                    <div class="row">
                        <div class="col-lg-6">
                            <form role="form" action="/advert/add/submit">
                                <div class="form-group">
                                    <label>Title</label>
                                    <input class="form-control" placeholder="Enter text" name="title">
                                </div>
                                <div class="form-group">
                                    <label>Description</label>
                                    <textarea class="form-control" rows="3" name="description"></textarea>
                                </div>

                                <div class="form-group">
                                    <label>Category</label>
                                    <select class="form-control" name="type">
                                        <c:forEach var="advertType" items="${advertTypes}">
                                            <option>${advertType.name}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="form-group input-group">
                                    <span class="input-group-addon">$</span>
                                    <input type="text" name="price" class="form-control">
                                </div>
                                <button type="submit" class="btn btn-default">Submit</button>
                            </form>
                            <br>
                            ${error}
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
