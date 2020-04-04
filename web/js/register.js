$(function () {
    $('#sub_register').bind('click', function () {
        let $user = $('#user').val();
        let $pass = $('#pass1').val();
        let $pass2 = $('#pass2').val();
        let $num = $('#num').val();
        let $nickname = $('#nickname').val();
        let $address = $('#address').val();
        let $mail = $('#mail').val();
        let regex = /^(13[0-9]|14[0-9]|15[0-9]|166|17[0-9]|18[0-9]|19[8|9])\d{8}$/;
        if ($user != "" || $pass != "" || $pass2 != "" || $num != "" ) {
            if ($pass != $pass2) {
                layer.alert("两次密码不一致");
            } else if (!(regex.test($num))) {
                layer.alert("手机号码不合法");
            }else{
                $.ajax({
                    url:"../registerAjax",
                    type:"post",
                    async:false,
                    data:{chooseID:'1','username':$user,'password':$pass,'telphone':$num,'address':$address,'nickname':$nickname,'mail':$mail},
                    success:function(data){
                        var json = $.parseJSON(data);
                        if(json.result=='1'){
                            layer.alert('注册成功');
                            window.location.href="login.jsp"
                        }else{
                            layer.alert('注册失败！用户名已经存在');
                            $('#user').val("");
                        }
                    }

                })
            }
        }else{
            layer.alert("有空值请检查");
        }
    });
})