<template>
    <div>
        <el-container>
            <el-header style="margin-bottom: 20px">
                <i class="el-icon-platform-eleme"></i>
                <h1>2020WBFWDC---时空交通大数据分析</h1>
            </el-header>
            <el-container style="height: 700px; border: 1px solid #eee">
                <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
                    <el-menu router="">
                        <el-submenu v-for="(item, index) in $router.options.routes" :index="index+''">
                            <template slot="title"><i class="el-icon-menu"></i>{{item.name}}</template>
                            <el-menu-item v-for="(item2, index2) in item.children" :index="item2.path"
                                          :class="$route.path==item2.path?'is-active':''">
                                {{item2.name}}
                            </el-menu-item>
                        </el-submenu>
                    </el-menu>
                </el-aside>
                <el-main>
                    <router-view></router-view>
                </el-main>
            </el-container>
            <el-footer style="margin-top: 20px">Copyright ©2020 All rights reserved</el-footer>
        </el-container>
    </div>
</template>

<script>
    export default {
        name: "Index"
    }
</script>
<!--在vue组件中，为了使样式私有化（模块化），不对全局造成污染，可以在style标签上添加scoped属性以表示它的只属于当下的模块-->
<style scoped>
    h1 {
        clear: both;
        font-size: 20px;
        float: left;
    }
</style>