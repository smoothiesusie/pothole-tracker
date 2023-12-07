<template>
  <div class="full-page-wrapper">
    <!-- <h1 class="title">Pothole Patrol</h1> -->
    <div class="add-pothole">
      <h2>Add a New Pothole</h2>
      <button class="generate-location" @click="getUserLocation">Auto-generate location</button>
      <form @submit.prevent="submitPothole">
        <div>
          <label for="latitude">Latitude:</label>
          <input id="latitude" v-model="pothole.latitude" type="number" required>
        </div>
        <div>
          <label for="longitude">Longitude:</label>
          <input id="longitude" v-model="pothole.longitude" type="number" required>
        </div>
        <div>
          <label for="severity">Severity:</label>
          <input id="severity" v-model="pothole.severity" type="number" min="1" max="5" required>
        </div>
        <div>
          <label for="status">Status:</label>
          <select id="status" v-model="pothole.status">
            <option value="reported">Reported</option>
            <option value="in_progress">In Progress</option>
            <option value="fixed">Fixed</option>
          </select>
        </div>
        
      </form>
      <button type="submit" class="pothole-button" @click="submitPothole">Add Pothole</button>
      
      
    </div>
    
    
  </div>
  <div class="map-container"><Maps/></div>
  </template>
  <script>

  import PotholeService from '../services/PotholeService';
  import Maps from './Maps.vue';
  export default {

    components : {
      Maps
    },
    name: 'AddPothole',
    data() {
      return {
        pothole: {
          userid: null,
          latitude: null,
          longitude: null,
          severity: 1,
          status: 'reported'
        }
      };
    },
    methods: {
      submitPothole() {
  
  if (this.pothole.latitude === 0 || this.pothole.longitude === 0) {
    console.log("Please input valid coordinates (non-zero).");
    return;
  }

  console.log('Adding pothole:', this.pothole);

  PotholeService.addNewPothole(this.pothole).then(response => {
    this.pothole = response.data;
    this.$emit('potholeAdded', {
      latitude: this.pothole.latitude,
      longitude: this.pothole.longitude
    });
  });
  
},


      getUserLocation() {
      if ('geolocation' in navigator) {
        navigator.geolocation.getCurrentPosition(
          (position) => {
              this.pothole.latitude = position.coords.latitude,
              this.pothole.longitude = position.coords.longitude
            },
          
          (error) => {
            console.error("Error getting location: ", error);
          },
          {
            enableHighAccuracy: true // Optional, for more accurate results
          }
        );
      } else {
        console.log("Geolocation is not supported by this browser.");
      }
    },


  }
};
  </script>

  <!-- <style scoped>

  /* .add-pothole {
    margin-top: 200px;
    display: flex;
  flex-direction: column;
  justify-content: space-between;
  align-items: center;
  gap: 10px;
  padding: 30px;
  background: rgba(34, 2, 2, 0.247);
  backdrop-filter: blur(3px);
  -webkit-backdrop-filter: blur(5px);
  border-radius: 10px;
  border: 1px solid rgba(0, 0, 0, 0.705);
  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.781);
  width: 400px;
  height: 400px;
  margin: auto;
  text-align: center;
  font-family: monospace;
}

  
  
  
 
  .full-page-wrapper {
    background-image: url('https://images.unsplash.com/photo-1539651044670-315229da9d2f?q=80&w=2070&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D');
    background-position: cover;
    background-repeat: no-repeat;
    height: 100vh;

  } */ -->


  <style scoped>

  .map-container {
    display: flex;
    flex-direction: row;
    justify-content: center;
    align-items: center;
    margin-top: -285px;
    
  }
  .add-pothole {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  gap: 20px; 
  padding: 20px;
  background: rgba(34, 2, 2, 0.158);
  backdrop-filter: blur(3px);
  -webkit-backdrop-filter: blur(5px);
  border-radius: 10px;
  border: 1px solid rgba(253, 243, 243, 0.705);
  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.781);
  width: 1470px;
  height: 300px; 
  margin: auto; 
  text-align: center;
  font-family: monospace;
  padding-bottom: 50px;
  padding-top: -30px;
  margin-top: -0.5px;
  border-top: -1px;
  padding: -5px;
  position: relative;
  top: 7px;
}
input {
  padding: 10px; 
  margin-bottom: 10px; 
  width: 100%; 
  box-sizing: border-box; 
}

.full-page-wrapper {
  background-image: url('https://images.unsplash.com/photo-1539651044670-315229da9d2f?q=80&w=2070&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D');
  background-size: cover;
  background-repeat: no-repeat;
  height: 100vh;
  position: relative; 
}

.title {
  margin-top: -0.5px;
  color: yellow;
  font-family: fantasy;
  display: flex;
  justify-content: center;
  font-size: 5rem;
  padding-top: 50px;
  text-decoration: underline;
}

.pothole-button {
  height: 23px;
  border: 1px solid black;
  font-family: fantasy;
  width: 100px;
  height: 30px;
  border-radius: 5px 5px 5px 5px;
  background-color: rgb(109, 201, 201);
  transition: background-color 0.3s ease-in-out, transform 0.3s ease-in-out;

}

.pothole-button:hover {
  transform: scaleY(1.2);
  border: 2px solid white;
}
</style>

  
