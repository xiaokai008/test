/**
 * Created by bdqn on 2016/5/3.
 */
//登录的方法
function login(){
    var loginName=$("#loginName").val();
    var password=$("#password").val();
    $.ajax({
        url:contextPath+"/login.action",
        method:"post",
        data:{loginName:loginName,password:password},
        success:function(jsonStr){
            // var result=eval("("+jsonStr+")");
            if(jsonStr.status==1){
                window.location.href=contextPath+"/index.action";
            }else{
                showMessage(result.message)
            }
        }
    })
}