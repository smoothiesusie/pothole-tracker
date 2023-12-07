import axios from "axios";

export default {

    getPotholeList(pothole) {
        return axios.get('/UsersPotholes', pothole)
    },

    addNewPothole(pothole) {
        return axios.post('/addPothole', pothole)
    }
}