/*
	$('.table .categoryEditBtn').on('click', function(event) {
			event.preventDefault();
			var href = $(this).attr('href');	
			$.get(href, function(category, status) {
				$('#editCategoryId').val(category.categoryId);
				$('#editCategoryName').val(category.categoryName);
			});
			$('#editModal').modal({
				keyboard: false,
				backdrop: 'static'
			});
		}); 
*/


$(document).ready(function() {
	
	//Category Delete Modal
	$('.table .categoryDeleteBtn').on('click', function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$('#deleteCategoryModal #deleteCategory').attr('href', href);
		$('#deleteCategoryModal').modal({
			keyboard: false,
			backdrop: 'static'
		});
	});


	//Product Delete Modal
	$('.table .productDeleteBtn').on('click', function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$('#deleteProductModal #deleteProduct').attr('href', href);
		$('#deleteProductModal').modal({
		});
	});
	
	//EVENT DELETE MODAL
	$('.table .EventDeleteBtn').on('click', function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$('#deleteEventModal #deleteEvent').attr('href', href);
		$('#deleteEventModal').modal({
			keyboard: false,
			backdrop: 'static'
		});
	});

});

$(document).ready(function() {
	
	
	$('#productImage').change(function() {
		readURL(this);
	});


	$(".custom-file-input").on("change", function() {
		var fileName = $(this).val().split("\\").pop();
		$(this).siblings(".custom-file-label").addClass("selected").html(fileName);
	});
<<<<<<< HEAD
<<<<<<< HEAD
	
$(document).ready(function() {
	$('.table .CouponDeleteBtn').on('click', function(coupon) {
		coupon.preventDefault();
		var href = $(this).attr('href');
		$('#deleteCouponModal #deleteCoupon').attr('href', href);
		$('#deleteCouponModal').modal({
			keyboard: false,
			backdrop: 'static'
		});
	});

	$('#productImage').change(function() {
		readURL(this);
	});


	$(".custom-file-input").on("change", function() {
		var fileName = $(this).val().split("\\").pop();
		$(this).siblings(".custom-file-label").addClass("selected").html(fileName);
});
=======
=======
	
	$('#productPrice').keyup(function() {
		this.value = this.value.replace(/[^0-9\.]/g, '');
	});

>>>>>>> 3f8d27aa36c7e71214aa568582ffa4f6d137e596
});
>>>>>>> cb1314640c5849cb87e41e4718cc25c8a97101bb
