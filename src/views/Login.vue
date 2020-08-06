<template>
    <div class="login-container">
        <el-form :model="ruleForm2" :rules="rules2"
                 status-icon
                 ref="ruleForm2"
                 label-position="left"
                 label-width="0px"
                 class="demo-ruleForm login-page">
            <h3 class="title">系统登录</h3>
            <el-form-item prop="userAccount">
                <el-input type="text"
                          v-model="ruleForm2.userAccount"
                          auto-complete="off"
                          placeholder="用户名"
                ></el-input>
            </el-form-item>
            <el-form-item prop="userPwd">
                <el-input type="password"
                          v-model="ruleForm2.userPwd"
                          auto-complete="off"
                          placeholder="密码"
                ></el-input>
            </el-form-item>
            <el-checkbox
                    v-model="checked"
                    class="rememberme"
            >记住密码</el-checkbox>
            <el-form-item style="width:100%;">
                <el-button type="primary" style="width:100%;" @click="handleSubmit" :loading="logining">登录</el-button>
            </el-form-item>
            <el-link href="http://localhost:8080/Map#/SignUp" icon="el-icon-user">新人注册</el-link>

        </el-form>
    </div>
</template>

<script>
    export default {
        data(){
            return {
                logining: false,
                ruleForm2: {
                    userAccount: 'admin',
                    userPwd: '123456',
                },
                rules2: {
                    userAccount: [{required: true, message: 'please enter your account', trigger: 'blur'}],
                    userPwd: [{required: true, message: 'enter your password', trigger: 'blur'}]
                },
                checked: false
            }
        },
        methods: {
            handleSubmit(event){
                this.$refs.ruleForm2.validate((valid) => {
                    if(valid){
                        this.logining = true;
                        axios.post('http://localhost:8082/backend/login/userLogin?userAccount='+this.ruleForm2.userAccount+'&userPwd='+this.ruleForm2.userPwd).then(res=>{
                            console.log(res)
                            if(!res.data.code){
                                this.logining = false;
                                sessionStorage.setItem('user', this.ruleForm2.userAccount);
                                this.$router.push({path: '/Map'});
                            }else{
                                this.logining = false;
                                this.$alert('username or password wrong!', 'info', {
                                    confirmButtonText: 'ok'
                                })
                            }
                        })
                    }else{
                        console.log('error submit!');
                        return false;
                    }
                })
            }
        }
    };
</script>

<style scoped>
    .login-container {
        width: 100%;
        height: 100%;
    }
    .login-page {
        -webkit-border-radius: 5px;
        border-radius: 5px;
        margin: 180px auto;
        width: 350px;
        padding: 35px 35px 15px;
        background: #fff;
        border: 1px solid #eaeaea;
        box-shadow: 0 0 25px #cac6c6;
    }
    label.el-checkbox.rememberme {
        margin: 0px 0px 15px;
        text-align: left;
    }
</style>
