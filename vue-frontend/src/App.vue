<template>
  <div id="app">
    <el-row>
      <el-col :span="6">
        <el-form ref="form" :model="form" label-width="40px">
          <el-form-item label="ID">
            <el-input v-model="form.id"></el-input>
          </el-form-item>
          <el-form-item label="密码">
            <el-input v-model="form.password"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="onSubmit">登录</el-button>
          </el-form-item>
        </el-form>
      </el-col>
    </el-row>
  </div>
</template>

<style>
.el-row {
  display: flex;
  justify-content: center;
  margin-top: 50px;
}

.el-form {
  border: 1px solid #ccc;
  border-radius: 6px;
  padding: 20px;
  background-color: cornsilk;
}
</style>

<script>

export default {
  data() {
    return {
      form: {
        id: "",
        password: ""
      }
    };
  }
};
</script>
