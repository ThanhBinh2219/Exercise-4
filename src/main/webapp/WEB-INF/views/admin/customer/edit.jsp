<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 15/12/2023
  Time: 8:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<html>
<head>
    <title>Chỉnh sửa khách hàng</title>
</head>
<body>
<div class="main-content">
    <div class="main-content-inner">
        <div class="breadcrumbs" id="breadcrumbs">
            <script type="text/javascript">
                try {
                    ace.settings.check('breadcrumbs', 'fixed')
                } catch (e) {
                }
            </script>

            <ul class="breadcrumb">
                <li>
                    <i class="ace-icon fa fa-home home-icon"></i>
                    <a href="#">Home</a>
                </li>
                <li class="active">Chỉnh sửa khách hàng</li>
            </ul>
            <div class="nav-search" id="nav-search">
                <form class="form-search">
							<span class="input-icon">
								<input type="text" placeholder="Search ..." class="nav-search-input"
                                       id="nav-search-input" autocomplete="off"/>
								<i class="ace-icon fa fa-search nav-search-icon"></i>
							</span>
                </form>
            </div><!-- /.nav-search -->
        </div>

        <div class="page-content">
            <div class="page-header">
                <h1>
                    Dashboard
                    <small>
                        <i class="ace-icon fa fa-angle-double-right"></i>
                        overview &amp; stats
                    </small>
                </h1>
            </div><!-- /.page-header -->
            <div class="row" style="font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;">
                <form:form modelAttribute="customerEdit" action="/api/customer-edit" id="listForm" method="GET">
                    <div class="col-xs-12">
                        <form action="" class=rm-horizontal" id="form-edit">
                            <div class="form-group row">
                                <label class="col-sm-3" for="name">Tên khách hàng</label>
                                <div class="col-sm-9">
                                    <form:input path="name" cssClass="form-control"/>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-3" for="customerPhone">Số điện thoại</label>
                                <div class="col-sm-9">
                                    <form:input path="customerPhone" cssClass="form-control"/>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-3" for="email">Email</label>
                                <div class="col-sm-9">
                                    <form:input path="email" cssClass="form-control"/>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-3">Nhu cầu</label>
                                <div class="col-sm-9">
                                    <form:input path="demand" cssClass="form-control"/>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-3">Trạng Thái</label>
                                <div class="col-sm-9">
                                    <form:input path="status" cssClass="form-control"/>
                                </div>
                            </div>

                            <div class="form-group pull-right">
                                <c:if test="${not empty customerEdit.id}">
                                    <button type="button" class="btn btn-primary" id="btnAddOrUpdateCustomer"
                                            name="btnUpdateCustomer">
                                        <i class="ace-icon glyphicon glyphicon-ok"></i>
                                        Cập nhật khách hàng
                                    </button>
                                    <button type="button" class="btn btn-primary " id="btnCancel">
                                        <i class="ace-icon glyphicon glyphicon-remove"></i>
                                        Hủy
                                    </button>
                                </c:if>
                                <c:if test="${empty customerEdit.id}">
                                    <button type="button" class="btn btn-primary" id="btnAddOrUpdateCustomer"
                                            name="btnUpdateBuilding">
                                        <i class="ace-icon glyphicon glyphicon-ok"></i>
                                        Thêm khách hàng
                                    </button>
                                    <button type="button" class="btn btn-primary" id="btnCancel">
                                        <i class="ace-icon glyphicon glyphicon-remove"></i>
                                        Hủy
                                    </button>
                                </c:if>
                            </div>
                            <form:hidden path="id" id="customerId"/>
                        </form>
                    </div>
                </form:form>
            </div><!-- /.span -->
        </div><!-- /.page-content -->
    </div>
</div><!-- /.main-content -->
<script>
    let url = "/spring_boot_war_exploded/api/customer";
    $("#btnAddOrUpdateCustomer").click(function (e) {
        e.preventDefault();
        let data = {}
        var formData = $("#listForm").serializeArray();
        $.each(formData, function (index, item) {
           data[item.name] = item.value;
        });
        console.log(data)
        $.ajax({
            url: url,
            type: "POST",
            data: JSON.stringify(data),
            dataType: "json",
            contentType: "application/json",
            success: function (response) {
                console.log(response)
                window.location.href = "<c:url value='/admin/customer-list'/>";
            },
            error: function (response) {
                var redirectUrl = (null === customerId) ? "" : "/admin/customer-edit-" + customerId;
                console.log("loi");
            }
        });
    });



    function cancelBtn() {
        var cancelBtns = document.querySelectorAll('#btnCancel');
        cancelBtns.forEach(function (btn) {
            console.log(btn)
            btn.addEventListener('click', function () {
                window.location.href = "<c:url value="/admin/customer-list"/>";
            });
        });
    }
    cancelBtn()
</script>
</body>
</html>