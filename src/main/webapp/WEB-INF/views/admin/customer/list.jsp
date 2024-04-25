<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 25/12/2023
  Time: 2:39 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<%String context = request.getContextPath();%>
<%--<c:url var="customerListURL" value="/admin/customer-list"/>--%>
<%--<c:url var="buildingAPI" value="/api/customer"/>--%>
<html>
<head>
    <title>Danh sách khách hàng</title>
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
                <li class="active">Dashboard</li>
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
                        Quản lý người dùng
                    </small>
                </h1>
            </div><!-- /.page-header -->
            <div class="row">
                <div class="widget-box" style="margin-bottom: 0;">
                    <div class="widget-header">
                        <h4 class="widget-title">TÌM KIẾM</h4>
                        <div class="widget-toolbar">
                            <a href="#" data-action="collapse">
                                <i class="ace-icon fa fa-chevron-up"></i>
                            </a>
                        </div>
                    </div>
                    <div class="widget-body"
                         style="font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;">
                        <div class="widget-main">
                            <form:form modelAttribute="modelSearch" action="/admin/customer-list" id="listForm"
                                       method="GET">
                                <div class="row">

                                    <div class="form-group">
                                        <div class="col-xs-12">
                                            <div class="col-xs-4">
                                                <label class="name">Tên khách hàng</label>
                                                <form:input path="fullName" cssClass="form-control"/>
                                            </div>
                                            <div class="col-xs-4">
                                                <label class="name">Di động</label>
                                                <form:input path="numberPhone" cssClass="form-control"/>
                                            </div>
                                            <div class="col-xs-4">
                                                <label class="name">Email</label>
                                                <form:input path="email" cssClass="form-control"/>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="col-xs-12">
                                            <div class="col-xs-4">
                                                <label class="name">Chọn nhân viên phụ trách</label>
                                                <form:select path="staffId" cssClass="form-control">
                                                    <form:option value=""
                                                                 label="--Chọn Nhân Viên Phụ Trách--"></form:option>
                                                    <form:options items="${staffs}"></form:options>
                                                </form:select>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="col-xs-12">
                                            <div class="col-xs-4">
                                                <button class="btn btn-xs btn-danger" id="btnSearch">
                                                    <i class="ace icon glyphicon glyphicon-search"></i>
                                                    Tìm kiếm
                                                </button>
                                            </div>
                                        </div>
                                    </div>

                                </div>
                            </form:form>
                        </div>
                    </div>
                </div>
                <div class="pull-right">
                    <a href='/admin/customer-edit'/>
                    <button class="btn btn-info btn-white" title="addBuilding">
                        <svg
                                xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                class="bi bi-building-fill-add" viewBox="0 0 16 16">
                            <path d="M12.5 16a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7m.5-5v1h1a.5.5 0 0 1 0 1h-1v1a.5.5 0 0 1-1 0v-1h-1a.5.5 0 0 1 0-1h1v-1a.5.5 0 0 1 1 0"/>
                            <path d="M2 1a1 1 0 0 1 1-1h10a1 1 0 0 1 1 1v7.256A4.493 4.493 0 0 0 12.5 8a4.493 4.493 0 0 0-3.59 1.787A.498.498 0 0 0 9 9.5v-1a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .39-.187A4.476 4.476 0 0 0 8.027 12H6.5a.5.5 0 0 0-.5.5V16H3a1 1 0 0 1-1-1zm2 1.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5m3 0v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5m3.5-.5a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zM4 5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5M7.5 5a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm2.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5M4.5 8a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5z"/>
                        </svg>
                    </button>
                    </a>

                    <button class="btn btn-white btn-warning btn-bold" title="removeBuilding" id="removeBuilding">
                        <svg
                                xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                class="bi bi-building-fill-dash" viewBox="0 0 16 16">
                            <path
                                    d="M12.5 16a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7M11 12h3a.5.5 0 0 1 0 1h-3a.5.5 0 0 1 0-1"/>
                            <path
                                    d="M2 1a1 1 0 0 1 1-1h10a1 1 0 0 1 1 1v7.256A4.493 4.493 0 0 0 12.5 8a4.493 4.493 0 0 0-3.59 1.787A.498.498 0 0 0 9 9.5v-1a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .39-.187A4.476 4.476 0 0 0 8.027 12H6.5a.5.5 0 0 0-.5.5V16H3a1 1 0 0 1-1-1zm2 1.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5m3 0v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5m3.5-.5a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zM4 5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5M7.5 5a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm2.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5M4.5 8a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5z"/>
                        </svg>
                    </button>
                </div>
            </div><!-- /.span -->
            <hr>
            <!-- Bảng kết quả -->
            <div class="col-xs-12" style="padding: 0;">
                <display:table name="model.listResult" cellspacing="0" cellpadding="0"
                               requestURI="/admin/customer-list" partialList="true" sort="external"
                               size="${model.totalItems}" defaultsort="2" defaultorder="ascending"
                               id="tableList" pagesize="${model.maxPageItems}"
                               export="false"
                               class="table table-fcv-ace table-striped table-bordered table-hover dataTable no-footer"
                               style="margin: 3em 0 1.5em;">
                    <display:column title="<fieldset class='form-group'>
												        <input type='checkbox' id='checkAll' class='check-box-element'>
												        </fieldset>" class="center select-cell"
                                    headerClass="center select-cell">
                        <fieldset>
                            <input type="checkbox" name="checkList" value="${tableList.id}"
                                   id="checkbox_${tableList.id}" class="check-box-element"/>
                        </fieldset>
                    </display:column>
                    <display:column property="name" title="Tên khách hàng"/>
                    <display:column property="customerPhone" title="Số điện thoại"/>
                    <display:column property="email" title="Email"/>
                    <display:column property="demand" title="Nhu cầu"/>
                    <display:column property="createdBy" title="Người thêm"/>
                    <display:column property="createdDate" title="Ngày thêm"/>
                    <display:column property="status" title="Tình trạng"/>
                    <display:column title="Thao tác">
                        <div class="hidden-sm hidden-xs btn-group">
                            <button class="btn btn-xs btn-success" title="building-delivery"
                                    onclick="transactionCustomer(${tableList.id})">
                                <i class="ace-icon fa fa-check bigger-120"></i>
                            </button>
                            <a class="btn btn-xs btn-info" title="fix-building"
                               href="<c:url value='/admin/building-edit-${tableList.id}'/>">
                                <i class="ace-icon fa fa-pencil bigger-120"></i>
                            </a>

                            <button class="btn btnRemove btn-xs btn-danger" title="remove-customer"
                                    data="${tableList.id}">
                                <i class="ace-icon fa fa-trash-o bigger-120"></i>
                            </button>
                        </div>
                    </display:column>
                    <input type="hidden" id="customerId1" name="id" value="${tableList.id}"/>
                </display:table>
            </div>
        </div><!-- /.page-content -->
    </div>
</div><!-- /.main-content -->
<div class="modal fade" id="transactionTypeModal" role="dialog">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Nhập giao dịch</h4>
            </div>
            <div class="modal-body">
                <div class="form-group has-success">
                    <label for="inputSuccess" class="col-xs-12 col-sm-3 control-label no-padding-right">Chi tiết giao
                        dịch</label>
                    <div class="col-xs-12 col-sm-9">
                        <span class="block input-icon input-icon-right">
                            <input type="text" id="inputSuccess" class="width-100">
                        </span>
                    </div>
                </div>
                <input type="hidden" id="customerId2" value="">
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal" id="btnAssignmentBuilding">Thêm
                    giao dịch
                </button>
                <button type="button" class="btn btn-default" data-dismiss="modal">Đóng</button>
            </div>
        </div>
    </div>
</div>
<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
    <i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
</a>
<script>
    function transactionCustomer(customerId) {
        transactionModalOpen();
    }

    function transactionModalOpen() {
        $('#transactionTypeModal').modal();
    }

    $('.btnRemove').click(function (e) {
        e.preventDefault();
        var customerId = $(this).attr('data');
        console.log(customerId)
        var message = window.confirm("Bạn có chắc muốn xóa khách hàng này không?")
        if (message) {
            remove(customerId);
        }
    });
    $('#removeBuilding').click(function (e) {
        e.preventDefault();
        var selectedCustomerId = $('input[name="checkList"]:checked').map(function () {
            return $(this).val();
        }).get();
        var customerIdString = selectedCustomerId.join('-');
        console.log(customerIdString);
        var warning = window.confirm("Bạn có chắc muốn xóa các khách hàng này không?");
        if(!warning){
            return;
        }
        remove(customerIdString);
    });


    function remove(customerId) {
        console.log("delete")
        $.ajax({
            method: "DELETE",
            url: "<%=context%>/api/customer/delete-customer/" + customerId,
            // data: {id: customerId},
            success: function (response) {
                console.log(response);
                window.location.reload();
                // $('#listForm').submit();

            },
            error: function (error) {
                console.error(error);
            }
        });
    }

</script>
</body>
</html>