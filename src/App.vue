<template>
  <div id="app">
      <!-- 外层容器。当子元素中包含 或 时，全部子元素会垂直上下排列，否则会水平左右排列。-->
      <el-container style="border: 1px solid #eee" v-if="$route.meta.keepalive">
        <!-- 主要区域容器-->
          <el-main>
            <router-view></router-view>
          </el-main>
      </el-container>
      <router-view v-if="!$route.meta.keepalive"></router-view>
  </div>
</template>

<style>

</style>

<script>

</script>