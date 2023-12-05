<template>
  <div class="home">
    <div class="buttons">
      <button class="click" @click="goToAddPothole" >Add a New Pothole!</button>
      <button class="click" >Delete an existing Pothole!</button>
      <button class="click" @click="goToAllPotholeView">See all Potholes!</button>
    </div>
    <div class="container">
      <h1 class="home-title">Pothole Patrol</h1>
      <p>At the heart of our mission with the Pothole Tracker application is a simple yet profound vision: to make our streets safer and our communities more connected. By empowering individuals to report potholes swiftly and efficiently, we're not just fixing roads — we're fostering a sense of community responsibility and collaboration.

Each reported pothole symbolizes a step towards smoother, safer journeys for everyone. It's more than just an app; it's a tool for change, demonstrating how technology can bring us together to improve our shared spaces. Together, we're not just repairing the roads — we're building the foundation for a more responsive and caring world, one application at a time.</p>
    </div>
  </div>
</template>

<script>
 
export default {

  methods: {
    goToAddPothole() {
      this.$router.push('/potholes')
    },

    goToAllPotholeView(){
      this.$router.push('/potholeList')
    }
  }

};
</script>

<style>
.home {
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

.container {
  border-radius: 1px solid white;
  height: 850px;
  display: flex;
  align-items: center;
  justify-content: space-evenly;
  flex-direction: column;
  background: rgba(34, 2, 2, 0.247);
  backdrop-filter: blur(3px);
  -webkit-backdrop-filter: blur(5px);
  border-radius: 10px;
  border: 1px solid rgba(0, 0, 0, 0.705);
  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.781);
  width: 1100px;
}

.buttons {
  display: flex;
  flex-direction: row;
  align-items: center;
  justify-content: space-evenly;
  height: 40px;
  width: 1000px;
  padding-bottom: 50px;
  text-align: center;
  border-top: 20px;
  margin-bottom: -30px;
  
  
}

.click {
  display: flex;
  justify-content: center;
  padding-right: 10px;
  align-items: center;
  width: 300px;
  height: 45px;
  border-radius: 15px 15px 15px 15px;
  box-shadow: 2px 2px 2px black ;
  text-align: center;
  font-family:monospace;
  font-size: large;
  background-color:rgb(13, 173, 173);
  color: whitesmoke;
  transition: background-color 0.3s ease-in-out, transform 0.3s ease-in-out;
}

.click:hover {
  background-color:rgb(17, 109, 109);
  transform: scaleY(1.2);
}

.home-title {
  padding-top: 100px;
  font-size: 4em; 
  color: #dae906; 
  text-align: center; 
  text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.5); 
  font-family: fantasy; 
  margin-bottom: 20px; 
  margin-top: -100px;
  text-decoration: underline;
}

</style>

