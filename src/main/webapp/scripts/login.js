function login() {
    //测试绑定事件
    var name = $("#account").val().trim();
    var password = $("#password").val().trim();
    var valid = true;


    $("#account_span").html("");
    $("#password_span").html("");

    if (name === "") {
        $("#account_span").html("用户名不能为空");
        valid = false;
    }
    if (password === "") {
        $("#password_span").html("密码不能为空");
        valid = false;
    }


    //验证表单是否为空
    if (valid) {
        //发送请求
        $.ajax({
            url: path + "/user/login.do",
            type: "post",
            data: {"name": name, "password": password},
            dataType: "json",
            success: function (resultJson) {
                //result是服务器返回的JSON结果
                if(resultJson.state===0) {//登录成功
                    var userId=resultJson.data.id;
                    addCookie("userId", userId, 2);
                    window.location.href="edit.html";
                }else if(resultJson.state===1) {//用户名不存在
                    $("#account_span").html(resultJson.msg)
                }else{
                    $("#password_span").html(resultJson.msg);
                }
            },
            error: function () {
                alert("ajax请求失败！")
            }
        });
    }
}

function register() {

        var username = $("#username").val().trim();
        var nickname = $("#nickname").val().trim();
        var password = $("#register_password").val().trim();
        var final_password = $("#final_password").val().trim();

        var ok=true;

        //重置warning
        $("#warning_1").hide();
        $("#warning_2").hide();
        $("#warning_3").hide();

        //检验数据格式
        if(username==="") {
            ok=false;
            $("#warning_1 span").html("用户名不能为空");
            $("#warning_1").show();
        }

        if(password==="") {
            ok=false;
            $("#warning_2 span").html("密码不能为空");
            $("#warning_2").show();
        }else if(password.length<6) {
            ok=false;
            $("#warning_2 span").html("密码不能少于6位");
            $("#warning_2").show();
        }

        //检验确认密码是否一致
        if(final_password==="") {
            ok=false;
            $("#warning_3 span").html("密码不能为空");
            $("#warning_3").show();
        }else if(final_password!=password) {
            ok=false;
            $("#warning_3 span").html("密码不一致");
            $("#warning_3").show();
        }

        /*数据检验之后发送ajax请求*/
        if(ok) {
            $.ajax({
                url: path + "/user/add.do",
                type:"post",
                data:{"username":username,"nickname":nickname,"password":password},
                dataType:"json",
                success:function(result){
                    if(result.state===0) {
                        alert("注册成功");
                        $("#back").click();
                    }else{
                        $("#warning_1 span").html(result.msg);
                        $("#warning_1").show();
                    }
                },
                error:function () {
                    alert("注册失败");
                }

            });
        }

    }
