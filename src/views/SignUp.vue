<template>
    <div>
        <el-container class="frame"  style="box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04)">
            <el-header>新用户注册信息表</el-header>
            <el-form :model="ruleForm" status-icon :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
<!--                <el-form-item label="ID" prop="NumID">-->
<!--                    <el-input v-model.number="ruleForm.id"></el-input>-->
                <el-form-item label="用户名" prop="userAccount">
                    <el-input v-model.number="ruleForm.userAccount"></el-input>
                </el-form-item>
<!--                <el-form-item label="邮箱" prop="Email">-->
<!--                    <el-input v-model.number="ruleForm.email"></el-input>-->
<!--                </el-form-item>-->
                <el-form-item label="密码" prop="pass">
                    <el-input type="password" v-model="ruleForm.pass" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="确认密码" prop="checkPass">
                    <el-input type="password" v-model="ruleForm.checkPass" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="submitForm('ruleForm')">提交</el-button>
                    <el-button @click="resetForm('ruleForm')">重置</el-button>
                </el-form-item>
            </el-form>
        </el-container>
    </div>
</template>

<script>
    import router from "../router";

    export default {
        name: "User",
        data() {
            // const NumID = (rule, value, callback) => {
            //     if (!value) {
            //         return callback(new Error('ID不能为空'));
            //     }
            //     setTimeout(() => {
            //         if (!Number.isInteger(value)) {
            //             callback(new Error('请输入数字值'));
            //         } else {
            //             if (value < 1000000) {
            //                 callback(new Error('必须在六位数之内，包括六位数'));
            //             } else {
            //                 callback();
            //             }
            //         }
            //     }, 1000);
            // };
            const userAccount = (rule, value, callback) => {
                const reg = /^([a-zA-Z]|[0-9])/;
                if (!value) {
                    return callback(new Error('用户名不能为空'));
                }else if (reg.test(value)){
                    callback();
                } else {
                    callback(new Error('用户名格式不正确，只能用数字或字母'));
                }
            };
            // const Email = (rule, value, callback) => {
            //     const reg = /^([a-zA-Z]|[0-9])(\w|\-)+@[a-zA-Z0-9]+\.([a-zA-Z]{2,4})$/;
            //     if (!value) {
            //         return callback(new Error('邮箱不能为空'));
            //     }else if (reg.test(email)) {
            //             callback(new Error('邮箱格式正确'));
            //     } else {
            //             callback(new Error('邮箱格不正确'));
            //     }
            // };
            const validatePass = (rule, value, callback) => {
                // const reg = /^([a-zA-Z]|[0-9])/;
                if (value === '') {
                    callback(new Error('请输入密码'));
                } else {
                    if (this.ruleForm.checkPass !== '') {
                        this.$refs.ruleForm.validateField('checkPass');
                    }
                    callback();
                }
            };
            const validatePass2 = (rule, value, callback) => {
                if (value === '') {
                    callback(new Error('请再次输入密码'));
                } else if (value !== this.ruleForm.pass) {
                    callback(new Error('两次输入密码不一致!'));
                } else {
                    callback();
                }
            };
            return {
                ruleForm: {
                    pass: '',
                    checkPass: '',
                    userAccount: '',
                    // NumID: '',
                    // email: ''
                },
                rules: {
                    // id: [
                    //     { validator: NumID, trigger: 'blur' }
                    // ],
                    userAccount: [
                        { validator: userAccount, trigger: 'blur' }
                    ],
                    // email: [
                    //     { validator: Email, trigger: 'blur' }
                    // ],

                    pass: [
                        { validator: validatePass, trigger: 'blur' }
                    ],
                    checkPass: [
                        { validator: validatePass2, trigger: 'blur' }
                    ]
                }
            };
        },
        methods: {
            submitForm(formName) {
                // 申请表传入后端，高级用户由管理员设定，普通用户自己申请
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        alert('submit!');
                        //let {userAccount, pass} = this.ruleForm
                        //const data = {
                        //    userAccount: userAccount,
                        //    userPwd: pass
                        //}
                        // axios.post('http://localhost:8080/api/signUpinfo', data).then(res=>{
                        axios.post('http://localhost:8082/backend/user/saveUser?userAccount='+this.ruleForm.userAccount+'&userPwd='+this.ruleForm.pass).then(res=>{
                            console.log(res.data.code)
                            if (!res.data.code) {
                            // 登录成功，页面跳转
                                this.$router.push({path: '/'});
                            }
                            // console.log(res)
                        })
                    } else {
                        console.log('error submit!!');
                        return false;
                    }
                });
            },
            resetForm(formName) {
                this.$refs[formName].resetFields();
            }
        }
    }
</script>

<style scoped>
    .frame{
        margin: 200px auto;
        width: 500px;
        height: auto;
        padding: 20px;
    }
</style>
