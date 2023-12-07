<template>
    <div class="full-background">
    <h2 class="title">View Potholes</h2>
    <div class="view-potholes">
      <div v-if="isLoading" class="loading">
                Loading potholes...
            </div>
      <div v-if="potholes.length === 0">
        No potholes reported yet.
      </div>
      <ul v-else>
        <div v-for="pothole in potholes" :key="pothole.id">
          <div class="detail-container">
          <div>Latitude: {{ pothole.latitude }}</div>
          <div>Longitude: {{ pothole.longitude }}</div>
          <div>Severity: {{ pothole.severity }}</div>
          <div>Status: {{ pothole.status }}</div>
          <div>Date Reported: {{ pothole.reportedAt }}</div>
          <div>Reported By: {{ pothole.username  }}</div>
          <button class="update">Update Status</button>
        </div>
        
         
      </div>
      </ul>

    </div>

    <Maps />

  </div>
  </template>
  
  <script>
import PotholeService from '../services/PotholeService';
import Maps from './Maps.vue'
import UserServices from '../services/UserServices'



  export default {

   components: {
    Maps
    
   },

    name: 'ViewPotholes',
    data() {
      return {
        potholes: [],
        users: [],
        isLoading: true,
      };
    },
    
    created() {
      this.fetchPotholes();
      

    },
    methods: {
      fetchPotholes() {
        console.log('Fetching potholes...');
        
        PotholeService.getPotholeList().then(response=>{
          this.potholes =  response.data
          this.isLoading = false;


        })
        
      },
    }
  };
  </script>
  
  <style scoped>
  /* .view-potholes { 
    display: flex;
    justify-content: center;
    align-items: center;
    
    
    
  }

  .detail-container {
    display: flex;
    border: 1px solid black;
    align-items: center;
    flex-direction: column;
    width: 250px;
    height: 250px;
    justify-content: space-between;
    box-shadow: grey
  }

  .title {
    display: flex;
    justify-content: center;
    font-family: fantasy;
    font-size: 3rem;
  } */

.full-background {
  background-image: url('https://images.unsplash.com/photo-1539651044670-315229da9d2f?q=80&w=2070&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D');
  height: 100vh;
  background-position: cover;
  background-repeat: no-repeat;
}

.update {
  border: 1px solid black;
  height: 30px;
  border-radius: 5px 5px 5px 5px;
  background-color: rgb(109, 201, 201);
  font-family: fantasy;
  font-size: large;
  cursor: pointer;
  transition: background-color 0.3s ease-in-out, transform 0.3s ease-in-out;
}

.update:hover {
  background-color: rgb(109, 201, 201);
  transform: scaleY(1.2);
  border: 2px solid white;
}
  .view-potholes ul { 
    font-family: fantasy;
  display: flex;
  flex-direction: row; 
  overflow-x: auto; 
  white-space: nowrap; 
  padding: 10px;
}

.view-potholes {
  
  backdrop-filter: blur(2px); 
  -webkit-backdrop-filter: blur(2px);
}

.detail-container {
  display: flex;
  border: 1px solid black;
  align-items: center;
  flex-direction: column;
  width: 250px;
  height: 250px;
  margin: 10px; 
  justify-content: space-around; 
  box-shadow: 2px 2px 5px grey; 
  background: rgba(255, 255, 255, 0.5);
  backdrop-filter: blur(5px);
  -webkit-backdrop-filter: blur(5px); 
  border-radius: 10px; 
  color: black; 
  transition: transform 0.3s ease, box-shadow 0.3s ease; 

}

.detail-container:hover {
  transform: scale(1.05); 
  box-shadow: 5px 5px 10px grey; 
}

.title {
  margin-top: -0px;
  display: flex;
  justify-content: center;
  font-family: fantasy;
  font-size: 4rem;
  margin-bottom: 20px; 
  color: rgb(208, 243, 8);
  text-decoration: underline;
 
}

.loading {
  display: flex;
  justify-content: center;
  font-size: 6rem;
  font-family: monospace;
  color: rgb(160, 216, 216);
}
  </style>
  