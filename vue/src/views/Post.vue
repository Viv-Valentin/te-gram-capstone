<template>
    <div id="post">
        <cloudinary-comp msg="Welcome to Your Vue.js App" />
    </div>
</template>

<script>
import cloudinaryComp from '../components/CloudinaryComp.vue'

export default {
    name: 'Post',
    components: {
        cloudinaryComp
    }
}
</script>

<style>
</style>