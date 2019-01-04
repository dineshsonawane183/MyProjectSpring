$(document).ready(function(){
	
	 $.ajax({
		  url: "JsonController?action=all_customer",
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
	tt =  $('#CustomerTable').dataTable({
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
	    

        "aoColumns": [{'bSortable': true},{'bSortable': true},{'bSortable': true},{'bSortable': true},
        	{'bSortable': true},{'bSortable': true, 'sWidth':'20%'}]
        
	});
	var arr=[];
	$.each(data,function(i,j){
		console.log(i);
		console.log(j);
		
	
		var image="<img height='100px' width='200px' src='assets/images/customerImages/img"+j.id+".jpeg'/>";
		var edit="<center><a href='customer?action=edit&&id="+j.id+"' ><button >Edit</button></a>&nbsp; &nbsp;&nbsp;&nbsp;<a href='customer?action=delete&&id="+j.id+"' ><button >Delete</button></a><center>"
		arr.push([j.id,image,j.name,j.address,j.contact,edit]);
	});
	tt.fnAddData(arr);
}