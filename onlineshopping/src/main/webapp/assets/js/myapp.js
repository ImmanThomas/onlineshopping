$(function() {

	// solving the active menu problem
	switch (menu) {

	case 'About Us':
		$('#about').addClass('active');
		break;
	case 'Contact Us':
		$('#contact').addClass('active');
		break;
	case 'All Products':
		$('#listProducts').addClass('active');
		break;
	case 'Home':
		$("#home").addClass("active");
		break;

	default:

		$('#listProducts').addClass('active');
		$('#a_' + menu).addClass('active');
		break;
	}

	// code for jquery dataTable

	var $dataTable = $("#listProductsTable");

	if ($dataTable.length) {

		var jsonURL = '';

		if (window.categoryID == '') {
			jsonURL = "/json/data/all/products";
		} else {
			jsonURL = '/json/data/category/' + window.categoryID + '/products';
		}

		$dataTable
				.DataTable({

					pageLength : 5,
					lengthMenu : [ [ "3", "5", "10", "-1" ],
							[ "3 records", "5 records", "10 records", "ALL" ] ],
					ajax : {
						url : window.contextRoot + jsonURL,
						dataSrc : ''
					},
					columns : [

							{
								data : 'code',
								mRender : function(data, type, row) {
									return '<img class="dataTablesImage" src="'
											+ window.contextRoot
											+ '/resources/images/' + data
											+ '.jpg"></img>';
								}
							},
							{
								data : 'name'
							},
							{
								data : 'brand'
							},
							{
								data : 'unitPrice',
								mRender : function(data, type, row) {

									return "&#8377; " + data

								}
							},
							{
								data : 'quantity'
							},
							{

								data : 'id',
								bSortable : false,
								mRender : function(data, type, row) {

									var str = '';
									str += '<a href="'
											+ window.contextRoot
											+ '/show/'
											+ data
											+ '/product" class="btn btn-primary"><i class="fa fa-eye"></i></a>&nbsp;';
									str += '<a href="'
											+ window.contextRoot
											+ '/cart/add/'
											+ data
											+ '/product" class="btn btn-primary"><i class="fa fa-shopping-cart"></i></a>';
									return str;
								}
							} ]
				});

	}

});