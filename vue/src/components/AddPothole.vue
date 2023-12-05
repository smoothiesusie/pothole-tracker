<template>
    <div class="add-pothole">
      <h2>Add a New Pothole</h2>
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
        <button type="submit">Add Pothole</button>
      </form>
    </div>
  </template>
  <script>
  export default {
    name: 'AddPothole',
    data() {
      return {
        pothole: {
          latitude: null,
          longitude: null,
          severity: 1,
          status: 'reported'
        }
      };
    },
    methods: {
      submitPothole() {
        console.log('Adding pothole:', this.pothole);
        this.resetForm();
      },
      resetForm() {
        this.pothole = { latitude: null, longitude: null, severity: 1, status: 'reported' };
      }
    }
  };
  </script>

  <style scoped>

  .add-pothole {
    display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
  min-height: 100vh;
  background-image: url('https://images.unsplash.com/photo-1539651044670-315229da9d2f?q=80&w=2070&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D');
  background-size: cover;
  background-position: center;
  background-repeat: no-repeat;
  font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
  color: white;
  border: 1px solid black;
  color: rgb(208, 243, 8);
  font-size: 2rem;
  
  }
 
  
  </style>