<template>
  <div>
    <h1>Congratulations!</h1>
    <h2>From Server: {{aboutme}}</h2>
  </div>
</template>

<script>
import Axios from "axios";

export default {
  data() {
    return {
      aboutme: ""
    };
  },

  created() {
    Axios.get("http://localhost/user/about", { withCredentials: true })
      .then(response => (this.aboutme = response.data))
      .catch(console.log); // TODO: redirect to login page
  }
};
</script>

