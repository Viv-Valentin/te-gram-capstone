<template>
    <div id="post">  
        <h1>Post Upload</h1>
        <h2>Get started by clicking on the Upload Photo button! From here you can choose a photo, write your caption, and make a post!</h2>          
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
    },
}

</script>

<style>

#post{
    margin: 4em auto;
}

</style>