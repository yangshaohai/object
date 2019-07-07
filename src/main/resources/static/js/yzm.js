function draw(show_num,id) {
    var canvas_width=$('#'+id).width();
    var canvas_height=$('#'+id).height();
    // console.log($("#graphics").width()+id)
    var canvas = document.getElementById(id);//获取到canvas的对象，演员
    var context = canvas.getContext("2d");//获取到canvas画图的环境，演员表演的舞台
    canvas.width = 100;
    canvas.height = 43;
    var sCode = "A,B,C,E,F,G,H,J,K,L,M,N,P,Q,R,S,T,W,X,Y,Z,1,2,3,4,5,6,7,8,9,0";
    var aCode = sCode.split(",");
    var aLength = aCode.length;//获取到数组的长度

    for (var i = 0; i <= 3; i++) {
        var j = Math.floor(Math.random() * aLength);//获取到随机的索引值
        var deg = Math.random() * 30 * Math.PI / 180;//产生0~30之间的随机弧度
        var txt = aCode[j];//得到随机的一个内容
        show_num[i] = txt.toLowerCase();
        var x = 10 + i * 20;//文字在canvas上的x坐标
        var y = 20 + Math.random() * 8;//文字在canvas上的y坐标
        context.font = "bold 23px 微软雅黑";

        context.translate(x, y);
        context.rotate(deg);

        context.fillStyle = randomColor();
        context.fillText(txt, 0, 0);

        context.rotate(-deg);
        context.translate(-x, -y);
    }
    $("#"+id+"1").val(show_num.join(""));
    for (var i = 0; i <= 5; i++) { //验证码上显示线条
        context.strokeStyle = randomColor();
        context.beginPath();
        context.moveTo(Math.random() * canvas_width, Math.random() * canvas_height);
        context.lineTo(Math.random() * canvas_width, Math.random() * canvas_height);
        context.stroke();
    }
    for (var i = 0; i <= 30; i++) { //验证码上显示小点
        context.strokeStyle = randomColor();
        context.beginPath();
        var x = Math.random() * canvas_width;
        var y = Math.random() * canvas_height;
        context.moveTo(x, y);
        context.lineTo(x + 1, y + 1);
        context.stroke();
    }
}

function randomColor() {//得到随机的颜色值
    var r = Math.floor(Math.random() * 256);
    var g = Math.floor(Math.random() * 256);
    var b = Math.floor(Math.random() * 256);
    return "rgb(" + r + "," + g + "," + b + ")";
}

var InterValObj; //timer变量，控制时间
var count = 60; //间隔函数，1秒执行
var curCount;//当前剩余秒数
//向邮箱发送验证码
$('#send-email-code').click(function(){
    //校验邮箱
    var email = $("#email").val();
    if(!email.match(/^[a-z0-9]+([._]*[a-z0-9]+)*@[a-z0-9]+([_.][a-z0-9]+)+$/gi)){
        layer.msg('邮箱格式不正确！请重新输入', {
            time: 20000, //20s后自动关闭
            btn: ['确定']
        });
        return false;
    }

    // 设置button效果，开始计时
    curCount = count;
    document.getElementById("send-email-code").setAttribute("disabled","true" );//设置按钮为禁用状态
    document.getElementById("send-email-code").value=curCount + "秒后重获";//更改按钮文字
    InterValObj = window.setInterval(SetRemainTime, 1000); // 启动计时器timer处理函数，1秒执行一次

    //请求发送验证码
 $.ajax({
 	type:"get",
 	url:"/email",
 	async:true,
 	data:{"email":email},
 	success:function(obj){
 	    // console.log(obj);
 		if(obj.status==200){//验证码发送成功
            layer.msg('验证码已发到您的邮箱,请查收', {
                time: 20000, //20s后自动关闭
                btn: ['确定']
            });
            $("#emailTip").val(obj.code);
 			// $('#emailTip').html("<font color='#339933'>√ 邮箱验证码已发到您的手机,请查收</font>");
 		}else{
            layer.msg('验证码发送失败，请重新发送', {
                time: 20000, //20s后自动关闭
                btn: ['确定']
            });
 			// $("#emailTip").html("<font color='red'>× 短信验证码发送失败，请重新发送</font>");
 		}
 	},
 	dataType:"json"
 });
});

//timer处理函数
function SetRemainTime() {
    if (curCount == 0) {//超时重新获取验证码
        window.clearInterval(InterValObj);// 停止计时器
        document.getElementById("send-email-code").removeAttribute("disabled");//移除禁用状态改为可用
        document.getElementById("send-email-code").value="重获验证码";
    }else {
        curCount--;
        document.getElementById("send-email-code").value=curCount + "秒后重获";
    }
}