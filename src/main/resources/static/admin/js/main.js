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
	$('#productPrice').keyup(function() {
		this.value = this.value.replace(/[^0-9\.]/g, '');
	});

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

$(document).ready(function() {
	$('.table .EventDeleteBtn').on('click', function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$('#deleteEventModal #deleteEvent').attr('href', href);
		$('#deleteEventModal').modal({
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