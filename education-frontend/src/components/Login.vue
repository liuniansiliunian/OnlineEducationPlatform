<template>
  <div class="login-container">
    <h2>用户登录</h2>
    <div class="form-group">
      <input v-model="username" placeholder="请输入用户名" />
    </div>
    <div class="form-group">
      <input type="password" v-model="password" placeholder="请输入密码" />
    </div>
    <button @click="handleLogin">登录</button>
    <p v-if="message" style="color: red; margin-top: 10px;">{{ message }}</p>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  name: 'UserLogin',
  data() {
    return {
      username: '',
      password: '',
      message: ''
    }
  },
  methods: {
    handleLogin() {
      // 发送登录请求
      axios.post('http://localhost:8080/OnlineEducationPlatform_war_exploded/login', {
        username: this.username,
        password: this.password
      })
          .then(res => {
            // 根据后端返回的 code 判断
            if (res.data.code === 200) {
              // 登录成功，跳转到列表页
              this.$router.push('/users');
            } else {
              // 登录失败，显示错误消息
              this.message = res.data.message;
            }
          })
          .catch(err => {
            console.error(err);
            this.message = '请求失败，请检查后端';
          });
    }
  }
}
</script>

<style scoped>
.login-container { width: 300px; margin: 100px auto; padding: 20px; border: 1px solid #ddd; border-radius: 8px; text-align: center; }
.form-group { margin-bottom: 15px; }
input { padding: 8px; width: 90%; }
button { padding: 8px 20px; background-color: #42b983; color: white; border: none; cursor: pointer; }
</style>