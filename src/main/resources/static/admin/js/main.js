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
	
	$('#productPrice').keyup(function() {
		this.value = this.value.replace(/[^0-9\.]/g, '');
	});

});
