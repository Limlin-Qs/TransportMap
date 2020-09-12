<template>
    <div>
        <div class="boxLayout">
            <h5>问题</h5>
            <el-input
                    type="text"
                    placeholder="请输入内容"
                    v-model="text"
                    maxlength="10"
                    show-word-limit
            >
            </el-input>
            <h5>详情</h5>
            <el-input
                    type="textarea"
                    placeholder="请输入内容"
                    v-model="textarea"
                    maxlength="30"
                    show-word-limit
            >
            </el-input>
            <div style="margin-top: 20px"></div>
            <el-button type="primary" style="float: right">提交</el-button>
        </div>
    </div>
</template>

<script>
    export default {
        name: "Feedback",
        text: '',
        textarea: '',
    }
</script>

<style scoped>
    .boxLayout {
        display: flow;
        flex-direction: row;
        margin: 0 auto;
        width: 60%;
    }
</style>