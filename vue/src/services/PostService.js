import axios from 'axios';

export default {
    
    getFeed() {
        return axios.get("/");
    },
    
    addPost(post) {
        return axios.post("/post", post);
    },

    getPosts(username){
        return axios.get("/" + username);
    },

    getPost(username, postId) {
        return axios.get("/" + username + "/" + postId);
    }

}