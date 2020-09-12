import Vue from 'vue'
import './plugins/axios'
import App from './App.vue'
import router from './router'
import store from './store'
//这个是一个vue状态管理器、vue过滤、vue工具的集合
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import echarts from 'echarts'
// import VueAMap from 'vue-amap';
// import { AMapManager } from 'vue-amap';

import BaiduMap from 'vue-baidu-map'


Vue.use(BaiduMap, {
  ak: '5ieMMexWmzB9jivTq6oCRX9j'
})

Vue.use(ElementUI);

Vue.prototype.$echarts = echarts

Vue.config.productionTip = false
//阻止启动生产消息，常用作指令,开发环境下，Vue 会提供很多警告来帮你对付常见的错误与陷阱。而在生产环境下，
// 这些警告语句却没有用，反而会增加应用的体积。此外，有些警告检查还有一些小的运行时开销，这在生产环境模式
// 下是可以避免的。(摘于官网说明) 大概意思应该就是，消息提示的环境配置，设置为开发环境或者生产环境

new Vue({
  router,
  //创建和挂载根实例。
  //记得要通过 router 配置参数注入路由，从而让整个应用都有路由功能
  store,
  render: h => h(App)
}).$mount('#app')
