import Vue from 'vue'
import App from './App.vue'
import router from './router' // 【新增】引入路由

Vue.config.productionTip = false

new Vue({
  router, // 【新增】挂载路由
  render: h => h(App),
}).$mount('#app')