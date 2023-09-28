<template>
    <div id="post">
        <add-post />
    </div>
</template>

<script>
import AddPost from '../components/AddPost.vue';

export default {
    name: 'Post',
    data() {
        return {
            posts: []
        }
    },
    components: {
        AddPost
    }
}
</script>

<style></style>