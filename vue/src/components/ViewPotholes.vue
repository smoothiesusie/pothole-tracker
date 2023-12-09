<template>
  <div class="full-background">
    <div class="top-text">
      <p class="reported-holes">Reported Potholes : {{ potholes.length }}</p>
      <h2 class="title">View Potholes</h2>
      <p class="reported-holes">Fixed Potholes: {{ fixedPotholes }}</p>
    </div>
    <div class="view-potholes">
      <div v-if="isLoading" class="loading">Loading potholes...</div>
      <div v-if="potholes.length === 0">No potholes reported yet.</div>
      <ul v-else>
        <div
          v-for="pothole in potholes"
          :key="pothole.id"
          :class="{ highlighted: pothole.highlighted }"
        >
          <div class="detail-container">
            <div>Latitude: {{ pothole.latitude }}</div>
            <div>Longitude: {{ pothole.longitude }}</div>

            <label for="severity" v-if="pothole.isClicked">Severity: </label>
            <select
              name="severity"
              v-model="pothole.severity"
              v-if="pothole.isClicked"
            >
              <option value="1">1</option>
              <option value="2">2</option>
              <option value="3">3</option>
              <option value="4">4</option>
              <option value="5">5</option>
            </select>
            <div v-else>Severity: {{ pothole.severity }}</div>

            <label for="status" v-if="pothole.isClicked">Status: </label>
            <select
              name="status"
              v-model="pothole.status"
              v-if="pothole.isClicked"
            >
              <option value="In Review">In Review</option>
              <option value="In Progress">In Progress</option>
              <option value="Fixed">Fixed</option>
            </select>
            <!-- <div v-else>Status: {{ pothole.status }}</div> -->
            <label for="inspected"
              >Inspected Date:
              {{ pothole.inspectedDate || "Not Inspected Yet" }}</label
            >
            <input
              name="inspected"
              type="date"
              v-model="pothole.inspectedDate"
              v-if="pothole.isClicked"
            />
            <div v-else>Status: {{ pothole.status }}</div>
            <div>Date Reported: {{ pothole.reportedAt }}</div>
            <div>Reported By: {{ pothole.username }}</div>
            <button
              class="update"
              v-if="isUserAdmin && !pothole.isClicked"
              v-on:click="updateClicked(pothole)"
            >
              Update Status
            </button>
            <button
              class="update"
              v-if="isUserAdmin && pothole.isClicked"
              v-on:click="updateStatus(pothole)"
            >
              Submit
            </button>

            <button
              class="update"
              v-if="pothole.isClicked"
              v-on:click="deletePothole(pothole)"
            >
              Delete
            </button>
          </div>
        </div>
      </ul>
    </div>

    <Maps @marker-clicked="handleMarkerClick" />
  </div>
</template>

<script>
import PotholeService from "../services/PotholeService";
import Maps from "./Maps.vue";
// import UserServices from '../services/UserServices'

export default {
  components: {
    Maps,
  },

  name: "ViewPotholes",
  data() {
    return {
      potholes: [],
      users: [],
      isLoading: true,
      markers: [],
      isClicked: false,
      // fixedPotholes: 0
    };
  },

  created() {
    this.fetchPotholes();

    this.$store.state.potholes.forEach((pothole) => {
      console.log("here");
      let marker = {
        center: { lat: pothole.latitude, lng: pothole.longitude },
      };
      this.$store.state.markers.push(marker);
    });
    this.isLoading = false;
  },
  methods: {
    fetchPotholes() {
      console.log("Fetching potholes...");

      PotholeService.getPotholeList().then((response) => {
        this.potholes = response.data;
        this.$store.state.potholes = response.data;
        this.isLoading = false;
      });
    },

    deletePothole(pothole) {
      PotholeService.deletePothole(pothole.potholeid).then((response) => {
        this.fetchPotholes();
        // this.$router.go()
        this.$store.commit("INCREMENT_FIXED_POTHOLES");
      });
    },

    updateStatus(pothole) {
      PotholeService.updateUsersReport(pothole).then((response) => {
        pothole = response.data;
        pothole.isClicked = false;
        console.log(pothole);
        this.$router.go();
      });
    },
    updateClicked(pothole) {
      if (!this.oneClicked) {
        pothole.isClicked = true;
      }
    },
    handleMarkerClick(markerId) {
      const potholeIndex = this.potholes.findIndex(
        (p) => p.potholeid === markerId
      );
      if (potholeIndex > -1) {
        const selectedPothole = this.potholes[potholeIndex];
        selectedPothole.highlighted = true;
        this.potholes.unshift(this.potholes.splice(potholeIndex, 1)[0]);
      }
    },
  },
  computed: {
    isUserAdmin() {
      const currentUser = this.$store.state.user;
      return (
        currentUser &&
        currentUser.authorities.some((auth) => auth.name === "ROLE_ADMIN")
      );
    },
    oneClicked() {
      let clicked = false;
      this.potholes.forEach((pothole) => {
        if (pothole.isClicked) {
          clicked = true;
        }
      });
      return clicked;
    },
    fixedPotholes() {
      return this.$store.state.fixedPotholes;
    },
  },
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
  background-image: url("https://images.unsplash.com/photo-1539651044670-315229da9d2f?q=80&w=2070&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D");
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
  transition: transform 0.3s ease, box-shadow 0.3s ease;
}

/* .view-potholes {
  padding: 5px;
  border: 5px;

} */

.detail-container {
  display: flex;
  border: 1px solid black;
  align-items: center;
  flex-direction: column;
  width: 250px;
  height: 250px;
  /* margin: 10px; */
  justify-content: space-around;
  box-shadow: 2px 2px 5px grey;
  background: rgba(255, 255, 255, 0.5);
  backdrop-filter: blur(5px);
  -webkit-backdrop-filter: blur(5px);
  border-radius: 10px;
  color: black;
  transition: transform 0.3s ease, box-shadow 0.3s ease;
  /* padding: 10px; */
}

.detail-container:hover {
  transform: scale(1.05);
  /* box-shadow: 5px 5px 10px grey; */
  background-color: rgba(255, 255, 255, 0.808);
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

.top-text {
  color: rgb(208, 243, 8);
  display: flex;
  justify-content: space-between;
  font-size: 2rem;
  font-family: monospace;
  border-bottom: 2px solid white;
  padding: 5px;
}

.highlighted {
  background-color: rgb(13, 173, 173);
  border-radius: 15px 15px 15px 15px;
  padding: 5px;
  border: 2px solid rgb(255, 255, 255);
  border-left: 5px;
  padding-right: 5px;
  padding-left: 5px;
}

.pothole-list-move {
  transition: transform 1s ease;
}
</style>
