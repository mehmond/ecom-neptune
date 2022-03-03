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
	$('.table .categoryDeleteBtn').on('click', function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$('#deleteCategoryModal #deleteCategory').attr('href', href);
		$('#deleteCategoryModal').modal({
			keyboard: false,
			backdrop: 'static'
		});
	});
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
});