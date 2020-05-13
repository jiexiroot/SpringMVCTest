$(function(){
    $('#sumbit').bind('click',function(){
        var $user = $('#username');
        var $pass = $('#password');
        if($user.val()=="" || $pass.val()==""){
            layer.alert("有空值，请检查！")
        }else{
            $.ajax({
                url:"/SpringMVCTest/loginAjax",
                type:"post",
                async:false,
                data:{'username':$user.val(),'password':$pass.val()},
                success:function(data){
                    if(data.result=='0'){
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
        }
    });
    $('#username').focus(function(){
        $('#username').parent().removeClass('has-error');
    });
    $('#password').focus(function(){
        $('#password').parent().removeClass('has-error');
    });
});