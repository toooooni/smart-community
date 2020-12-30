<template>


        <div class="back clearfixed" :style="back">
         <el-select v-model="value" placeholder="请选择用户身份">
        <el-option
        v-for="item in options"
        :key="item.value"
        :label="item.label"
        :value="item.value">
        </el-option>
  </el-select>
            <div class="main clearfixed">
                <div id="signup">
                    {{title_second}}
                </div>
                 <div class="title"> {{title_one}}</div>
                 i
                 <input type="text" id="name" placeholder = "请输入用户名">
                 <input type="password" id="password" placeholder = "请输入密码">
                <div id="buttom">
                    {{title_one}}
                </div>
            </div>
        </div>


</template>

<script>
export default {
     name:'login',
    data() {
        return{
            back:{
                backgroundImage:"url("+require("../../assets/bg3.jpg") + ")",
                backgroundRepeat:"no-repeat",
                width: "100%",
                height: "100%",
                backgroundSize: "cover",
            },
            title_one:'登录',
            title_second:'注册',
            options: [{
          value: '',
          label: '黄金糕'
        }, {
          value: '选项2',
          label: '双皮奶'
        }, {
          value: '选项3',
          label: '蚵仔煎'
        }, {
          value: '选项4',
          label: '龙须面'
        }, {
          value: '选项5',
          label: '北京烤鸭'
        }],
        }
    },
}
</script>

<style>
#app,html,body {
        width: 100%;
        height: 100%;    
    }
    *{
        margin: 0;
        padding: 0;
    }


    .clearfixed::after{
        display: block;
        content: "";
        clear: both;
    }
    .main,input{
        position: absolute;
        left: 50%;
        transform: translate(-50%,-50%);
        display: block;
        border-radius: 5px;
        opacity: 1;
    }
    input:hover{
        border: 5px white solid;
 
        
    }
    .main{
        top: 40%;
    }
    #password{
        top: 60%;
    }
    
    .main{
        float: left;
        width: 35%;
        height: 55%;
        /* border: 1px solid rgb(105, 36, 36); */
        border-radius: 10px;
        background: #314864;
        opacity: 0.8;
        box-shadow: 15px 15px 15px #222f36;
    }

    .title{
       
        height: 40px;
        width: 80px;
        font-weight:bolder;
        margin-top:20px;
        margin-left: 100px;
        font-size: 20px;
        color:white;
        border-bottom:3px white solid; 
        text-align: center;
        line-height: 40px;
    }
 
    #buttom{
        line-height: 40px;
        position: absolute;
        width: 64%;
        border-radius: 5px;
        background-color:#fcf5f5;
        border:1px white solid;
        font-size: 15px;
        color: rgb(97, 31, 31);
        text-align: center;
        left: 18%;
        top: 70%;
    }
    #buttom:hover{
        border: 2px white solid;
        cursor:pointer;
    }
  
    #signup{
        position: absolute;
        width: 80px;
        font-size: 18px;
        color: white;
        margin-left: 280px;
        margin-top:25px;
        height: 40px;
        line-height: 30px;
        text-align: center;
    }
    #signup:hover{
        font-weight: bolder;
        border-bottom:3px white solid;
        cursor:pointer;
    }
    input{
        display: block;
        width: 65%;
        height: 30px;
    }
    #name{
        top: 48%;
    }
</style>