	$registerForm = $('#registerForm');
	if (registerForm.length) {

		$registerForm.validate({
			rules : {

				name : {
					required : true

				},
				username : {
					required : true

				},
				password : {
					required : true
				},
				user : {
					required : true
				}
			},
			messages : {
				username : {
					required : 'Please enter your username!',

				},
				name : {
					required : 'Please enter your Full Name!',

				},
				password : {
					required : 'Please enter your password!'
				},
				user : {
					required : 'Please Select User Type!'
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