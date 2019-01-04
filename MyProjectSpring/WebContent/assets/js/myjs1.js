$(document).ready(function(){
	
	 $.ajax({
		  url: "JsonController?action=all_product",
		  type: "GET",
		  dataType: "json",
		  contentType: 'application/json',
		  success: function(data){
			  intialize(data);
			  },
		  error: function(data) {
			  console.log(data)
		   },
		});
	
})
var tt=[];
function intialize(data)
{
	console.log(data)
	tt =  $('#ProductTable').dataTable({
		"paging" : true,
        "ordering" : true,
        "info"  : true,
        "searching" : true,
	    "bRetrieve" :true,
	    "bPaginate":false,
	    "bLengthChange": false,
	    "autoWidth": false,
	    "iDisplayLength": 10,
	    "bFilter":true,
	    "bDestroy":true,
	    

        "aoColumns": [{'bSortable': true, 'sWidth':'10%'},{'bSortable': true, 'sWidth':'10%'},{'bSortable': true, 'sWidth':'10%'},
        	{'bSortable': true, 'sWidth':'20%'},{'bSortable': true, 'sWidth':'10%'},{'bSortable': true, 'sWidth':'10%'},
        	{'bSortable': true, 'sWidth':'10%'},{'bSortable': true, 'sWidth':'20%'}]
        
	});
	var arr=[];
	$.each(data,function(i,j){
		console.log(i);
		console.log(j);
		/*document.write(j.id);*/
		var edit="<center><a href='product?action=edit&&id="+j.id+"' ><button>Edit</button></a>&nbsp; &nbsp;&nbsp;&nbsp;<a href='product?action=delete&&id="+j.id+"' ><button >Delete</button></a><center>"
		arr.push([j.id,j.name,j.brand,j.description,j.unitPrice,j.quantity,j.active,edit]);
	});
	tt.fnAddData(arr);
}