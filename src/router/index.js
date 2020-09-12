
// 非懒加载模式

import Vue from 'vue'
import VueRouter from 'vue-router'
import Data from '../views/Data'
import Map from '../views/Map'
import Index from "../views/Index";
import Feedback from "../views/Feedback";
import Login from "../views/Login";
import SignUp from "../views/SignUp";


Vue.use(VueRouter)

const routes = [
    {
        path: '/',
        name: '我的账号',
        component: Login,
        meta:{
            keepalive: false
        },
        // children: [
        //     {
        //         path: '/User',
        //         name: '个人中心',
        //         component: User,
        //     }
        // ]
    },
    {
        path: '/SignUp',
        name: '个人中心',
        component: SignUp,
        meta:{
            keepalive: false
        }
    },
    {
        path: '/Map',
        name: '时空地图',
        component: Index,
        redirect: 'Map',
        children: [
            {
                path: '/Map',
                name: '时空地图',
                component: Map,
            }
        ]
    },
    {
        path: '/data',
        name: '数据展示',
        component: Index,
        redirect: 'Data',
        children: [
            {
                path: '/Data',
                name: '清洗数据',
                component: Data,
            }
        ]
    },
    {
        path: '/Feedback',
        name: '服务中心',
        component: Index,
        redirect: 'Data',
        children: [
            {
                path: '/Feedback',
                name: '意见反馈',
                component: Feedback,
            }
        ]
    },
]

const router = new VueRouter({
  routes
})

export default router
