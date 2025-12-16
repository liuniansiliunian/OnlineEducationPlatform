import Vue from 'vue'
import VueRouter from 'vue-router'
// 引入我们将要写的两个组件
import Login from '../components/Login.vue'
import UserList from '../components/UserList.vue'

Vue.use(VueRouter)

const routes = [
    {
        path: '/',
        name: 'Login',
        component: Login
    },
    {
        path: '/users',
        name: 'UserList',
        component: UserList
    }
]

const router = new VueRouter({
    mode: 'history', // 去掉 URL 里的 # 号
    routes
})

export default router