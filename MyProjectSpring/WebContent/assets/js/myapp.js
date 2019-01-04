$(function() {
	// for handling CSRF token
	var token = $('meta[name="_csrf"]').attr('content');
	var header = $('meta[name="_csrf_header"]').attr('content');

	if ((token != undefined && header != undefined)
			&& (token.length > 0 && header.length > 0)) {
		// set the token header for the ajax request
		$(document).ajaxSend(function(e, xhr, options) {
			xhr.setRequestHeader(header, token);
		});
	}

	// code for jquery dataTable
	var $table = $('#ProductTable');

	// execute the below code only where we have this table
	if ($table.length) {
		console.log('Inside the table!');

		var jsonUrl = window.contextRoot+'/json/data/getAllProducts';

		$table.DataTable({

			lengthMenu : [ [ 3, 5, 10, -1 ],
					[ '3 Records', '5 Records', '10 Records', 'ALL' ] ],
			pageLength : 5,
			ajax : {
				url : jsonUrl,
				dataSrc : ''
			},
			columns : [
				{
					data : 'id'
				},
					{
						data : 'code',
						bSortable : false,
						mRender : function(data, type, row) {

							return '<img src="' + window.contextRoot
									+ '/resources/images/' + data
									+ '.jpg" class="dataTableImg"/>';

						}
					},

					 {
						data : 'name'
					},

					{
						data : 'brand'
					}, {
						data : 'description'
					},

					{
						data : 'unitPrice',
							
							mRender : function(data, type, row) {
								return '&#8377; ' + data
							}
					}, {
						data : 'quantity',
						
						mRender : function(data, type, row) {

							if (data < 1) {
								return '<span style="color:red">Out of Stock!</span>';
							}

							return data;

						}
					},{
						data : 'id',
						bSortable : false,
						mRender : function(data, type, row) {

							var str = '';
							
							
							str+="<a href='"+window.contextRoot+"/view/"+data+"/product'class='btn btn-primary' /><span class='glyphicon glyphicon-eye-open' ></span> </a> &nbsp;";
							if(userRole !== 'ADMIN') {
								if (row.quantity < 1) {
									str += '<a href="javascript:void(0)" class="btn btn-success disabled"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
								} else {

									str += '<a href="'
											+ window.contextRoot
											+ '/cart/add/'
											+ data
											+ '/product" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
								}
							}
							else {
								str += '<a href="'
									+ window.contextRoot
									+ '/manage/'
									+ data
									+ '/product" class="btn btn-warning"><span class="glyphicon glyphicon-pencil"></span></a>';
							}
							
							return str;

						}
					} ]
		});
	}

	/* validating the loginform */

	// validating the product form element
	// fetch the form element
	$loginForm = $('#loginForm');

	if ($loginForm.length) {

		$loginForm.validate({
			rules : {
				username : {
					required : true,
				},
				password : {
					required : true
				}
			},
			messages : {
				username : {
					required : 'Please enter your username!',

				},
				password : {
					required : 'Please enter your password!'
				}
			},
			errorElement : "em",
			errorPlacement : function(error, element) {
				// Add the 'help-block' class to the error element
				error.addClass("help-block");

				// add the error label after the input element
				error.insertAfter(element);
			}
		}

		);

	}

	/*------*/
	$alert = $('.alert');
	if ($alert.length) {
		setTimeout(function() {
			$alert.fadeOut('slow');
		}, 3000);
	}

	/* for fading out the alert message after 3 seconds */

	/*------*/
	/* handle refresh cart */
	$('button[name="refreshCart"]')
			.click(
					function() {
						var cartLineId = $(this).attr('value');
						var countField = $('#count_' + cartLineId);
						var originalCount = countField.attr('value');
						// do the checking only the count has changed
						if (countField.val() !== originalCount) {
							// check if the quantity is within the specified
							// range
							if (countField.val() < 1 || countField.val() > 3) {
								// set the field back to the original field
								countField.val(originalCount);
								bootbox
										.alert({
											size : 'medium',
											title : 'Error',
											message : 'Product Count should be minimum 1 and maximum 3!'
										});
							} else {
								// use the window.location.href property to send
								// the request to the server
								var updateUrl = window.contextRoot + '/cart/'
										+ cartLineId + '/update?count='
										+ countField.val();
								window.location.href = updateUrl;
							}
						}
					});

});