/** Created by GOU on 2020-05-13 15:09  */
$(function(){
    $.ajax({
        url:"/SpringMVCTest/selectfromC",
        type:"post",
        async:false,
        success:function(data){
            if(data.result=='1'){
                $('#cInfo').append(`<iframe frameborder="0" name="bookInfo_min" src="/SpringMVCTest/resources/book_info.jsp" width="100%" height="550px"/>`)
                $('#cList').append("<p class='text-info lead'>点击标签进入该种类的详细信息</p>")
                $('#cList').append("<ul id='bookName'></ul>")
               for(let i=0;i<data.slc.length;i++){
                   $('#bookName').append(`<li id='bookid_${data.slc[i].id}'>
                <a href="/SpringMVCTest/cid/${data.slc[i].id}/name/${data.slc[i].name}" target="bookInfo_min">${data.slc[i].name}</a></li>`)
               }
            }else{
                $('#cList').append("<h2>error:0</h2><h3><small>没有找到图书的种类id</small></h3>")
            }

        }
    });
})