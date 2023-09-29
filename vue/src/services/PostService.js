import axios from 'axios';

export default {
    
    getFeed() {
        return axios.get("/")
    },
    
    addPost(post) {
        return axios.post("/post", post);
    },

    getPosts(posts){
        return axios.get('/:username', posts)
        // potential issue here
    }





}