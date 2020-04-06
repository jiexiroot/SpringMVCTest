$(function(){
    $('#sumbit').bind('click',function(){
        var $user = $('#username');
        var $pass = $('#password');
        $.ajax({
            url:"/SpringMVCTest/loginAjax",
            type:"post",
            async:false,
            data:{'username':$user.val(),'password':$pass.val()},
            success:function(data){
                var json = $.parseJSON(data);
                if(json.result=='0'){
                    layer.msg('密码或账户名错误');
                    $user.parent().addClass('has-error');
                    $pass.parent().addClass('has-error');
                    $pass.val("");
                }else{
                    layer.msg('登录成功');
                    window.location.href="/SpringMVCTest/resources/index.jsp"
                }

            }
        });

    });
    $('#username').focus(function(){
        $('#username').parent().removeClass('has-error');
    });
    $('#password').focus(function(){
        $('#password').parent().removeClass('has-error');
    });
});