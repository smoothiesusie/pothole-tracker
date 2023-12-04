import axios from "axios";

export default {

    getPotholeList(pothole) {
        return axios.get('/potholes', pothole)
    }
}