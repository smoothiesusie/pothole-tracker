<template>
    <div class="view-potholes">
      <h2>View Potholes</h2>
      <div v-if="potholes.length === 0">
        No potholes reported yet.
      </div>
      <ul v-else>
        <li v-for="pothole in potholes" :key="pothole.id">
          <div>Latitude: {{ pothole.latitude }}</div>
          <div>Longitude: {{ pothole.longitude }}</div>
          <div>Severity: {{ pothole.severity }}</div>
          <div>Status: {{ pothole.status }}</div>
          <!-- Add more fields as required -->
        </li>
      </ul>
    </div>
  </template>
  
  <script>
  export default {
    name: 'ViewPotholes',
    data() {
      return {
        potholes: [] 
      };
    },
    created() {
      this.fetchPotholes();
    },
    methods: {
      fetchPotholes() {
      
        console.log('Fetching potholes...');
        // Example static data
        this.potholes = [
          { latitude: 38.3460, longitude: -0.4908, severity: 3, status: 'reported' },
         
        ];
      }
    }
  };
  </script>
  
  <style scoped>
  .view-potholes {
    
  }
  </style>
  