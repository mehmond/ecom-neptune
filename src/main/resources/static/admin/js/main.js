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
		$('#deleteModal #deleteCategory').attr('href', href);
		$('#deleteModal').modal({
			keyboard: false,
			backdrop: 'static'
		});
	});
});