<script>
export default {
  data() {
    return {
      msg: ''
    }
  },
  mounted() {
    fetch("/api/message/hello")
      .then((response) => response.text())
      .then((data) => {
        this.msg = data
        console.log(data)
      })

  }
}

</script>

<template>
  <div>{{ msg }}</div>
</template>

<style scoped>
a {
  color: #42b983;
}
</style>
