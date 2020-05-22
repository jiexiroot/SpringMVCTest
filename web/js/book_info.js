/** Created by GOU on 2020-05-17 18:57  */
function delThis(e,id){
    let bookName = $(e).parents('tr').children().eq(2).text();
    layer.confirm("是否删除《"+ bookName +"》这本书？", {icon:2,btn: ['确定','取消'],offset: '180px'},function(index){
        $.ajax({
            url:"/SpringMVCTest/bookDelThis",
            type:"post",
            async:false,
            data:{bookId:id},
            success:function(data){
                if(data.result=='1'){
                    $(e).parents('tr').remove();
                    layer.msg('删除成功');
                }else{
                    layer.msg('删除失败');
                }
            }

        })
        layer.close(index);
    },function(index){
        layer.close(index);
    });
}
$(function(){

    // $("#table").bootstrapTable('destroy').bootstrapTable({
    //     fixedColumns: true,
    //     fixedNumber: 1 //固定列数
    // });
    // $('#table').bootstrapTable();
    // $(window).resize(function () {
    //     $('#table').bootstrapTable('resetView');
    // });

    $("#delChoose").bind("click",function () {
        let checkID = [];//定义一个空数组
        $("input[name='ids']:checked").each(function(i){//把所有被选中的复选框的值存入数组
            checkID[i] =$(this).val();
        });
        layer.confirm("是否删除这些书？", {icon:2,btn: ['确定','取消'],offset: '180px'},function(index){
            $.ajax({
                url:"/SpringMVCTest/bookDelChoose",
                type:"post",
                async:false,
                data:{bookIds:checkID},
                success:function(data){
                    if(data.result=='1'){
                        for(var i=0;i<checkID.length;i++){
                            $(`input[value="${checkID[i]}"]`).parents('tr').remove();
                        }
                        layer.msg('删除成功,删除了'+data.updates+'本书');
                    }else{
                        layer.msg('删除失败');
                    }
                }

            })
            layer.close(index);
        },function(index){
            layer.close(index);
        });
    })
});
