<template>
    <div></div>
</template>

<script>
import Axios from "axios";

export default {
  name: "logout",
  created() {
    Axios.post("http://localhost/user/logout", null, { withCredentials: true }).then(
      this.$router.push("/login")
    );
  }
};
</script>
