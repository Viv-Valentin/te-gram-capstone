import axios from 'axios';

export default {
    
    getFeed() {
        return axios.get("/")
    },
    
    addPost(post) {
        return axios.post("/post", post);
    },

    getPosts(){
        return axios.get("/:username")
        // potential issue here
    }

    // add in another get post to actually get and display that info





}