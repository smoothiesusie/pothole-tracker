<template>
  <div id="capstone-app">
    <div id="nav">
      <div class="nav-welcome">
        <p>Saving the world one Pothole at a time!</p>
      </div>
      <div class="divider"></div>
      <div class="nav-links">
        <router-link v-bind:to="{ name: 'home' }">Home</router-link>
        <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
        <div class="user-info">Welcome to Pothole Patrol, {{ $store.state.user.username }}</div>

      </div>
    </div>
    <!-- <div>{{ $store.state.user }}</div> -->
    <router-view />
    
  </div>
  <footer class="footer"><span>&copy; Pothole Patrol 2023</span></footer>
</template>


<style>
#nav {
  display: flex;
  justify-content: space-between; 
  align-items: center; 
  padding-bottom: 20px;
  font-family: fantasy;
  background-color: black;
  color: whitesmoke;
  padding-bottom: 5px;
  border-bottom: 2px solid white;
  /* background-image: url('https://images.unsplash.com/photo-1539651044670-315229da9d2f?q=80&w=2070&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D'); */
  height: 50px;
  padding-right: 5px;
}

.nav-links a {
  color: rgb(253, 228, 6);
  padding-right: 5px;
}

.nav-links a:hover{
  color: aqua;
}

.nav-welcome p {
  margin: 0; 
  text-shadow: 2px 2px 3px rgb(214, 214, 195); 
  color: rgb(253, 228, 6);
  font-size: larger;
  padding-left: 10px;

  
}

.nav-links {
  display: flex;
  gap: 10px; 
  padding-right: 5px;
}

.user-info {
  color: white;
  
  border: 1px solid white;
 
  margin-right: auto;
  display:flex;
  justify-content: center;
  align-items: center;
}

.footer {
  display: flex;
  justify-content: space-between; 
  align-items: center; 
  /* padding-bottom: 20px; */
  font-family: fantasy;
  background-color: black;
  color: whitesmoke;
  
  border-bottom: 2px solid white;
  /* background-image: url('https://images.unsplash.com/photo-1539651044670-315229da9d2f?q=80&w=2070&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D'); */
  height: 50px;
  padding-top: 5px;
  border-top: 2px solid white;
  display: flex;
  justify-content: center;
}

</style>

