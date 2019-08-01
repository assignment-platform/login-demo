<template>
  <div>{{aboutme}}</div>
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
    Axios.get("http://localhost/user/about")
      .then(response => (this.aboutme = response.data))
      .catch(console.log); // TODO: redirect to login page
  }
};
</script>

