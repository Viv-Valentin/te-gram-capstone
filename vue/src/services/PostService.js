import axios from 'axios';


export default {

    submitComment(comment) {
        return axios.post(`/comments`, comment);
    },
    deleteComment(commentId) {
        return axios.delete(`/comments/${commentId}`);
    },
    listPosts() {
        return axios.get('/posts')
    },
    getPost(postId) {
        return axios.get(`/posts/${postId}`)
    },
    addPost(post) {
        return axios.post('/posts', post)
    },
    addLiked(postId) {
        return axios.post(`/liked/${postId}`)
    },
    removeLiked(postId) {
        return axios.delete(`/liked/${postId}`)
    },
}