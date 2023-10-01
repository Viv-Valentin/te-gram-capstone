import axios from 'axios';

export default {
    
    getLikes(username) {
        return axios.get("/" + username + "/favorite")
    }

}