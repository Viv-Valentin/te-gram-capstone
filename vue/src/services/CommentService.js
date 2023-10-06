import axios from 'axios';

export default {
    
    getComments(username, postId) {
        return axios.get("/" + username + "/" + postId + "/comment");
    },
    addComment(username){
        return axios.post("/" + username + "/comment", {});
    },
    deleteComment(username){
        return axios.delete("/" + username + "/comment", {});
    },
   
}