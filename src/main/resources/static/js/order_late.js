new Vue({
    el:"#app",
    data:{
        user:{
            id:"",            //用户id
            username:"",      //账号
            telephone:"",     //手机号
            name:"",          //用户名
            regTime:"",       //注册时间
            gexing:"",        //个性签名
            hobby:"",         //爱好
            address:"",       //地址
        },
        totalMoney:"",      //所有订单产品的总价
        orderList:[]        //获取订单详情里面的所有信息内容
    },
    methods:{
        //进入个人修改页面
        updateInfo:function () {
            window.location.href = "self_info.html";
        },
        //获取总价格的方法
        getTotalMoney:function(){
            //在当前方法中定义一个变量，表明是vue对象
            var _this = this;
            axios.get('/project_service/pay/getTotalMoney')
                .then(function (response) {
                    //把后台返回的总价格给这里的页面进行渲染
                    _this.totalMoney = response.data;
                })
                .catch(function (error) {
                    console.log(error);
                })
        },
        //获取订单信息内容进行展示
        getOrder:function () {
            //在当前方法中定义一个变量，表明是vue对象
            var _this = this;
            axios.get('/project_service/pay/getLatePay')
                .then(function (response) {
                    //把后台返回的集合给这里的页面进行渲染
                    _this.orderList = response.data;
                })
                .catch(function (error) {
                    console.log(error);
                })
        },
        //获取登录的用户的信息内容
        getUser:function () {
            //在当前方法中定义一个变量，表明是vue对象
            var _this = this;
            axios.get('/project_service/order/getLoginUser')
                .then(function (response) {
                    //判断用户是否已经登录
                    if (response.data == null) {
                        alert("用户暂未登录！请登录后再进行此操作！");
                        window.location.href = "login.html";
                    } else {
                        //把返回的user对象赋值给这里的user进行显示
                        _this.user = response.data;
                    }
                })
                .catch(function (error) {
                    console.log(error);
                })
        },
        //付款功能
        payMoney:function () {
            //在当前方法中定义一个变量，表明是vue对象
            var _this = this;

            var current_totalMoney = document.getElementById("totalPrice").innerText;

            //当购物车里面有内容的时候才可以进行支付
            if (current_totalMoney != 0 && current_totalMoney != null) {
                var current_msoid = document.getElementById("msoid").innerText;
                var current_userid = document.getElementById("userid").innerText;
                //进行支付操作
                axios.get('/project_service/order/payMoney',{
                    params:{
                        //根据用户id和订单号进行支付
                        totalMoney : current_totalMoney,        //总价格
                        msoid : current_msoid,                  //订单号
                        userid : current_userid                 //用户id
                    }
                })
                    .then(function () {
                        alert("支付成功！详情可以到个人中心查看订单详情！");
                        window.location.href = "dingdanzhongxin.html";
                    })
                    .catch(function (error) {
                        console.log(error);
                    })
                window.open("http://127.0.0.1:8080/project_service/alipay/pay?traceNo="+"邬先生东北菜，"+this.note+"&traceNo="+current_msoid+"&totalAmount="+current_totalMoney,'_self')
            }

            //alert(current_totalMoney + " - "  + current_msoid + " - " + current_userid);  //测试
        }
    },
    created:function () {
        //获取账号信息内容
        this.getUser();
        //当我们的订单页面刷新的时候就直接获取order里面的内容
        this.getOrder();
        //获取总价格
        this.getTotalMoney();
    }
});