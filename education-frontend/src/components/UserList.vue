<template>
  <div class="list-container">
    <h2>学生列表</h2>
    <table border="1" cellspacing="0" cellpadding="10" style="margin: 0 auto;">
      <thead>
      <tr>
        <th>ID</th>
        <th>用户名</th>
        <th>邮箱</th>
      </tr>
      </thead>
      <tbody>
      <tr v-for="user in users" :key="user.id">
        <td>{{ user.id }}</td>
        <td>{{ user.username }}</td>
        <td>{{ user.email }}</td>
      </tr>
      </tbody>
    </table>
    <br>
    <button @click="$router.push('/')">退出登录</button>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  name: 'UserList',
  data() {
    return {
      users: []
    }
  },
  created() {
    // 页面加载时自动获取数据
    this.fetchUsers();
  },
  methods: {
    fetchUsers() {
      axios.get('http://localhost:8080/OnlineEducationPlatform_war_exploded/users')
          .then(res => {
            this.users = res.data;
          })
          .catch(err => {
            alert('获取列表失败');
            console.error(err);
          });
    }
  }
}
</script>

<style scoped>
.list-container { text-align: center; margin-top: 50px; }
</style>