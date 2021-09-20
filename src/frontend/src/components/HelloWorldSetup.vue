<script setup>import { onMounted, ref } from "@vue/runtime-core";

const msg = ref("")

onMounted(() => {
    fetch("/api/message/hello")
        .then((response) =>
            response.text()
        )
        .then((data) => {
            console.log(data)
            msg.value = data
        })
})

</script>

<template>
    <div>MSG:{{ msg }}</div>
</template>
