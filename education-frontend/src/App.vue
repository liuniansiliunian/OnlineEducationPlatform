<template>
  <div id="app">
    <h1>学生信息查询系统 (Vue版)</h1>

    <div class="card" v-if="user">
      <p><strong>ID:</strong> {{ user.id }}</p>
      <p><strong>用户名:</strong> {{ user.username }}</p>
      <p><strong>邮箱:</strong> {{ user.email }}</p>
    </div>

    <button @click="fetchUser" :disabled="loading">
      {{ loading ? '查询中...' : '查询 1 号学生' }}
    </button>

    <p v-if="error" style="color: red;">{{ error }}</p>
  </div>
</template>

<script>
// 引入刚才安装的 axios
import axios from 'axios'

export default {
  name: 'App',
  data() {
    return {
      user: null,      // 用来存放后端返回的学生数据
      loading: false,  // 加载状态
      error: null      // 错误信息
    }
  },
  methods: {
    fetchUser() {
      this.loading = true;
      this.error = null;
      this.user = null;

      // 发送 GET 请求给后端
      // 注意：这里的端口是 8080 (Tomcat)，路径必须和浏览器里测试的一样
      axios.get('http://localhost:8080/OnlineEducationPlatform_war_exploded/user/1')
          .then(response => {
            // 请求成功，把数据存下来
            console.log('收到后端数据:', response.data);
            this.user = response.data;
            this.loading = false;
          })
          .catch(err => {
            // 请求失败，处理错误
            console.error('请求失败:', err);
            this.error = '请求失败！请检查：1.后端Tomcat是否启动？ 2.跨域配置WebConfig是否生效？';
            this.loading = false;
          });
    }
  }
}
</script>

<style>
/* 简单的样式美化 */
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
.card {
  border: 1px solid #ddd;
  box-shadow: 0 2px 12px 0 rgba(0,0,0,0.1);
  padding: 20px;
  margin: 20px auto;
  width: 300px;
  border-radius: 8px;
  background-color: #fdfdfd;
}
button {
  padding: 10px 25px;
  background-color: #42b983;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  font-size: 16px;
  margin-top: 10px;
}
button:disabled {
  background-color: #a0cfff;
  cursor: not-allowed;
}
button:hover:not(:disabled) {
  background-color: #3aa876;
}
</style>