import axios from 'axios';

export default {
    
    getLikes(username) {
        return axios.get("/" + username + "/favorite");
    },
    addFavorite(username, postId){
        return axios.post("/" + username + "/" + postId, {});
    },
    deleteFavorite(username, postId){
        return axios.delete("/" + username + "/" + postId, {});
    },
   
}